package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// 主窗口类，继承自 JFrame
public class LexicalAnalyzerGUI extends JFrame {
    // 输入文本区域
    private JTextArea inputTextArea;
    // 输出文本区域
    private JTextArea outputTextArea;
    // 分析按钮
    private JButton analyzeButton;

    public LexicalAnalyzerGUI() {
        // 设置窗口标题
        setTitle("词法分析器");
        // 设置窗口大小
        setSize(800, 500);
        // 设置关闭窗口时的操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口布局
        setLayout(new BorderLayout());

        // 创建输入面板
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        JLabel inputLabel = new JLabel("输入表达式:");
        inputTextArea = new JTextArea(10, 30);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        // 创建分析按钮
        analyzeButton = new JButton("分析");
        analyzeButton.addActionListener(new AnalyzeButtonListener());

        // 创建输出面板
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        JLabel outputLabel = new JLabel("分析结果:");
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);

        // 将组件添加到主窗口
        add(inputPanel, BorderLayout.NORTH);
        add(analyzeButton, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        // 显示窗口
        setVisible(true);
    }

    // 分析按钮的监听器类
    private class AnalyzeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 获取输入文本
            String input = inputTextArea.getText();
            // 进行词法分析
            List<Token> tokens = lexicalAnalysis(input);
            // 构建输出结果
            StringBuilder output = new StringBuilder();
            for (Token token : tokens) {
                output.append(token.toString()).append("\n");
            }
            // 将结果显示在输出文本区域
            outputTextArea.setText(output.toString());
        }
    }

    // 词法分析方法
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
            // 处理数字
            if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < input.length() && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')) {
                    numBuilder.append(input.charAt(i));
                    i++;
                }
                tokens.add(new Token(TokenType.NUMBER, numBuilder.toString()));
            }
            // 处理运算符
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
                i++;
            }
            // 处理左括号
            else if (c == '(') {
                tokens.add(new Token(TokenType.LEFT_PAREN, String.valueOf(c)));
                i++;
            }
            // 处理右括号
            else if (c == ')') {
                tokens.add(new Token(TokenType.RIGHT_PAREN, String.valueOf(c)));
                i++;
            }
            // 处理未知字符
            else {
                tokens.add(new Token(TokenType.UNKNOWN, String.valueOf(c)));
                i++;
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        // 在事件调度线程中创建并显示 GUI
        SwingUtilities.invokeLater(() -> new LexicalAnalyzerGUI());
    }
}

// 词法单元类
class Token {
    TokenType type;
    String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{type=" + type + ", value='" + value + "'}";
    }
}

// 词法单元类型枚举
enum TokenType {
    NUMBER,
    OPERATOR,
    LEFT_PAREN,
    RIGHT_PAREN,
    UNKNOWN
}