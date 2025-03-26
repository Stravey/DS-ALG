package com.myframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 词法单元类，用于表示词法分析得到的一个词法单元
class Token {
    int type;
    String value;

    public Token(int type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{type=" + type + ", value='" + value + "'}";
    }
}
@SuppressWarnings("all")
// 主窗口类，继承自 JFrame
public class LexicalAnalyzerGUI extends JFrame {
    // 输入文本区域，用于用户输入待分析的代码
    private JTextArea inputTextArea;
    // 输出文本区域，用于显示词法分析的结果
    private JTextArea outputTextArea;
    // 分析按钮，点击后触发词法分析操作
    private JButton analyzeButton;
    // 清空按钮，点击后清空输入和输出文本区域的内容
    private JButton clearButton;
    // 上传文件按钮，点击后可选择文件并将文件内容进行词法分析
    private JButton uploadButton;
    // 关键字映射，存储关键字及其对应的种别码
    private static final Map<String, Integer> KEYWORDS = new HashMap<>();
    // 运算符和界符映射，存储运算符和界符及其对应的种别码
    private static final Map<String, Integer> OPERATORS = new HashMap<>();

    static {
        // 初始化关键字映射，将关键字与对应的种别码关联
        KEYWORDS.put("void", 101);
        KEYWORDS.put("main", 102);
        KEYWORDS.put("int", 103);
        KEYWORDS.put("char", 104);
        KEYWORDS.put("if", 105);
        KEYWORDS.put("else", 106);
        KEYWORDS.put("for", 107);
        KEYWORDS.put("while", 108);
        // 初始化运算符和界符映射，将运算符和界符与对应的种别码关联
        OPERATORS.put("+", 201);
        OPERATORS.put("-", 202);
        OPERATORS.put("*", 203);
        OPERATORS.put("/", 204);
        OPERATORS.put("=", 205);
        OPERATORS.put(">", 206);
        OPERATORS.put(">=", 207);
        OPERATORS.put("<", 208);
        OPERATORS.put("<=", 209);
        OPERATORS.put("==", 210);
        OPERATORS.put("<>", 211);
        OPERATORS.put("++", 212);
        OPERATORS.put("--", 213);
        OPERATORS.put("(", 301);
        OPERATORS.put(")", 302);
        OPERATORS.put("{", 303);
        OPERATORS.put("}", 304);
        OPERATORS.put(";", 305);
    }

    public LexicalAnalyzerGUI() {
        // 设置窗口标题为“词法分析器”
        setTitle("词法分析器");
        // 设置窗口大小为 800x600 像素
        setSize(900, 600);
        // 设置关闭窗口时的操作，即退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口布局为 BorderLayout
        setLayout(new BorderLayout());

        // 创建输入面板，用于放置输入文本区域
        JPanel inputPanel = new JPanel(new BorderLayout());
        // 创建输入标签，提示用户输入代码
        JLabel inputLabel = new JLabel("输入代码:");
        // 创建输入文本区域，初始大小为 30x30
        inputTextArea = new JTextArea(30, 30);
        // 为输入文本区域添加滚动条
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        // 将输入标签添加到输入面板的北部
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        // 将带有滚动条的输入文本区域添加到输入面板的中部
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        // 创建输出面板，用于放置输出文本区域
        JPanel outputPanel = new JPanel(new BorderLayout());
        // 创建输出标签，提示用户查看分析结果
        JLabel outputLabel = new JLabel("分析结果:");
        // 创建输出文本区域，初始大小为 30x30，设置为不可编辑
        outputTextArea = new JTextArea(30, 30);
        outputTextArea.setEditable(false);
        // 为输出文本区域添加滚动条
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        // 将输出标签添加到输出面板的北部
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        // 将带有滚动条的输出文本区域添加到输出面板的中部
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);

        // 创建按钮面板，用于放置分析、清空和上传文件按钮
        JPanel buttonPanel = new JPanel();
        // 创建分析按钮
        analyzeButton = new JButton("分析");
        // 为分析按钮添加监听器
        analyzeButton.addActionListener(new AnalyzeButtonListener());
        // 创建清空按钮
        clearButton = new JButton("清空");
        // 为清空按钮添加监听器
        clearButton.addActionListener(new ClearButtonListener());
        // 创建上传文件按钮
        uploadButton = new JButton("上传文件");
        // 为上传文件按钮添加监听器
        uploadButton.addActionListener(new UploadButtonListener());
        // 将分析、清空和上传文件按钮添加到按钮面板
        buttonPanel.add(analyzeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(uploadButton);

        // 创建中间面板，用于放置按钮面板
        JPanel middlePanel = new JPanel(new BorderLayout());
        // 将按钮面板添加到中间面板的南部
        middlePanel.add(buttonPanel, BorderLayout.SOUTH);

        // 将输入面板添加到主窗口的西部
        add(inputPanel, BorderLayout.WEST);
        // 将中间面板添加到主窗口的中部
        add(middlePanel, BorderLayout.CENTER);
        // 将输出面板添加到主窗口的东部
        add(outputPanel, BorderLayout.EAST);

        // 显示窗口
        setVisible(true);
    }

    // 分析按钮的监听器类，实现 ActionListener 接口
    private class AnalyzeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 获取输入文本区域的内容
            String input = inputTextArea.getText();
            // 调用词法分析方法对输入内容进行分析
            List<Token> tokens = lexicalAnalysis(input);
            // 构建输出结果的字符串
            StringBuilder output = new StringBuilder();
            for (Token token : tokens) {
                output.append(token.toString()).append("\n");
            }
            // 将分析结果显示在输出文本区域
            outputTextArea.setText(output.toString());
        }
    }

    // 清空按钮的监听器类，实现 ActionListener 接口
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 清空输入文本区域的内容
            inputTextArea.setText("");
            // 清空输出文本区域的内容
            outputTextArea.setText("");
        }
    }

    // 上传文件按钮的监听器类，实现 ActionListener 接口
    public class UploadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 创建文件选择器
            JFileChooser fileChooser = new JFileChooser();
            // 显示文件选择对话框
            int result = fileChooser.showOpenDialog(LexicalAnalyzerGUI.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                // 获取用户选择的文件
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    // 读取文件内容
                    String fileContent = readFile(selectedFile);
                    // 将文件内容显示在输入文本区域
                    inputTextArea.setText(fileContent);
                    // 对文件内容进行词法分析
                    List<Token> tokens = lexicalAnalysis(fileContent);
                    // 构建输出结果的字符串
                    StringBuilder output = new StringBuilder();
                    for (Token token : tokens) {
                        output.append(token.toString()).append("\n");
                    }
                    // 将分析结果显示在输出文本区域
                    outputTextArea.setText(output.toString());
                } catch (IOException ex) {
                    // 若读取文件出错，显示错误消息对话框
                    JOptionPane.showMessageDialog(LexicalAnalyzerGUI.this, "读取文件时出错: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // 读取文件内容的方法，使用 BufferedReader 逐行读取文件
    private String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // 词法分析方法，对输入的字符串进行词法分析
    private List<Token> lexicalAnalysis(String input) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            // 忽略空白字符
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            // 处理标识符和关键字
            if (Character.isLetter(c)) {
                StringBuilder identifier = new StringBuilder();
                while (i < input.length() && (Character.isLetterOrDigit(input.charAt(i)) || input.charAt(i) == '_')) {
                    identifier.append(input.charAt(i));
                    i++;
                }
                String idStr = identifier.toString();
                if (KEYWORDS.containsKey(idStr)) {
                    // 若为关键字，添加关键字对应的 Token
                    tokens.add(new Token(KEYWORDS.get(idStr), idStr));
                } else {
                    // 若为标识符，添加标识符对应的 Token
                    tokens.add(new Token(400, idStr));
                }
            }
            // 处理常数
            else if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    number.append(input.charAt(i));
                    i++;
                }
                // 检查后续字符是否为非数字且非合法分隔符（如运算符、界符或空白符）
                if (i < input.length()) {
                    char nextChar = input.charAt(i);
                    if (!isSeparator(nextChar)) {
                        // 非法字符附加到常数中，记录错误
                        tokens.add(new Token(-1, "[错误]非法常数: " + number + input.charAt(i)));
                        i++; // 跳过非法字符
                        continue;
                    }
                }
                tokens.add(new Token(500, number.toString()));
            }
            // 处理运算符和界符
            else {
                StringBuilder op = new StringBuilder();
                op.append(c);
                if (i + 1 < input.length()) {
                    String twoCharOp = op.toString() + input.charAt(i + 1);
                    if (OPERATORS.containsKey(twoCharOp)) {
                        // 若为双字符运算符，添加对应的 Token
                        tokens.add(new Token(OPERATORS.get(twoCharOp), twoCharOp));
                        i += 2;
                        continue;
                    }
                }
                if (OPERATORS.containsKey(op.toString())) {
                    // 若为单字符运算符或界符，添加对应的 Token
                    tokens.add(new Token(OPERATORS.get(op.toString()), op.toString()));
                } else {
                    // 遇到无法识别的字符，添加错误 Token
                    tokens.add(new Token(-1, "错误: 无法识别的字符 '" + c + "'"));
                }
                i++;
            }
        }
        return tokens;
    }

    // 判断字符是否为合法分隔符（运算符、界符或空白符）
    private boolean isSeparator(char c) {
        return Character.isWhitespace(c) || OPERATORS.containsKey(String.valueOf(c));
    }

    public static void main(String[] args) {
        // 在事件调度线程中创建并显示 GUI
        SwingUtilities.invokeLater(() -> new LexicalAnalyzerGUI());
    }
}
