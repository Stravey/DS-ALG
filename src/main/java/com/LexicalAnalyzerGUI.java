package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// 主窗口类，继承自 JFrame
public class LexicalAnalyzerGUI extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton analyzeButton;

    public LexicalAnalyzerGUI() {
        // 设置窗口标题
        setTitle("简单词法分析器");
        // 设置窗口大小
        setSize(800, 600);
        // 设置关闭窗口时的操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口布局
        setLayout(new BorderLayout());

        // 创建输入文本区域
        inputTextArea = new JTextArea(15, 30);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        add(inputScrollPane, BorderLayout.NORTH);

        // 创建分析按钮
        analyzeButton = new JButton("分析");
        analyzeButton.addActionListener(new AnalyzeButtonListener());
        add(analyzeButton, BorderLayout.CENTER);

        // 创建输出文本区域
        outputTextArea = new JTextArea(15, 30);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        add(outputScrollPane, BorderLayout.SOUTH);

        // 显示窗口
        setVisible(true);
    }

    // 分析按钮的监听器类
    private class AnalyzeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputTextArea.getText();
            List<Token> tokens = lexicalAnalysis(input);
            StringBuilder output = new StringBuilder();
            for (Token token : tokens) {
                output.append(token.toString()).append("\n");
            }
            outputTextArea.setText(output.toString());
        }
    }

    // 词法分析方法
    private List<Token> lexicalAnalysis(String input) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    numBuilder.append(input.charAt(i));
                    i++;
                }
                tokens.add(new Token(TokenType.NUMBER, numBuilder.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
                i++;
            } else if (Character.isWhitespace(c)) {
                i++;
            } else {
                tokens.add(new Token(TokenType.UNKNOWN, String.valueOf(c)));
                i++;
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
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
    UNKNOWN
}