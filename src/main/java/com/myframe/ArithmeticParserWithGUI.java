/*
package com.myframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static java.awt.AWTEventMulticaster.add;

public class ArithmeticParserWithGUI {
    // 预测分析表，用于存储语法规则
    private static final Map<String, Map<String, String>> PARSING_TABLE = new HashMap<>();
    // 起始符号
    private static final String START_SYMBOL = "E";
    // 输入文本框
    private JTextField inputField;
    // 结果显示标签
    private JLabel resultLabel;

    static {
        // 初始化预测分析表
        initializeParsingTable();
    }

    // 初始化预测分析表的方法
    private static void initializeParsingTable() {
        Map<String, String> eRow = new HashMap<>();
        eRow.put("id", "T E'");
        eRow.put("(", "T E'");
        PARSING_TABLE.put("E", eRow);

        Map<String, String> ePrimeRow = new HashMap<>();
        ePrimeRow.put("+", "+ T E'");
        ePrimeRow.put(")", "ε");
        ePrimeRow.put("$", "ε");
        PARSING_TABLE.put("E'", ePrimeRow);

        Map<String, String> tRow = new HashMap<>();
        tRow.put("id", "F T'");
        tRow.put("(", "F T'");
        PARSING_TABLE.put("T", tRow);

        Map<String, String> tPrimeRow = new HashMap<>();
        tPrimeRow.put("*", "* F T'");
        tPrimeRow.put("+", "ε");
        tPrimeRow.put(")", "ε");
        tPrimeRow.put("$", "ε");
        PARSING_TABLE.put("T'", tPrimeRow);

        Map<String, String> fRow = new HashMap<>();
        fRow.put("id", "id");
        fRow.put("(", "( E )");
        PARSING_TABLE.put("F", fRow);
    }

    // 构造函数，初始化 GUI 界面
    public ArithmeticParserWithGUI() {
        setTitle("算术表达式语法分析器");
        setSize(400, 300); // 增加窗口高度
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // 使用 BorderLayout
        setLocationRelativeTo(null);

        // 输入面板
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel inputLabel = new JLabel("输入算术表达式:");
        inputField = new JTextField(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        // 按钮面板
        JPanel buttonPanel = new JPanel();
        JButton analyzeButton = new JButton("分析");
        buttonPanel.add(analyzeButton);

        // 结果面板
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultLabel.setFont(new Font("Serif", Font.BOLD, 16));

        // 添加组件
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(ArithmeticParserWithGUI.this,
                            "请输入有效的算术表达式", "输入错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                boolean result = parse(input);
                if (result) {
                    resultLabel.setText("表达式 " + input + " 合法");
                    resultLabel.setForeground(Color.GREEN);
                } else {
                    resultLabel.setText("表达式 " + input + " 不合法");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });
    }

    // 语法分析方法
    public static boolean parse(String input) {
        input = input + "$";
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push(START_SYMBOL);

        int index = 0;
        while (!stack.isEmpty()) {
            String top = stack.pop();
            String currentToken = getToken(input, index);

            if (isTerminal(top)) {
                if (top.equals(currentToken)) {
                    index++;
                } else {
                    return false;
                }
            } else {
                Map<String, String> row = PARSING_TABLE.get(top);
                if (row.containsKey(currentToken)) {
                    String production = row.get(currentToken);
                    if (!production.equals("ε")) {
                        String[] symbols = production.split(" ");
                        for (int i = symbols.length - 1; i >= 0; i--) {
                            stack.push(symbols[i]);
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return index == input.length();
    }

    // 获取当前输入字符对应的 token
    private static String getToken(String input, int index) {
        if (index < input.length()) {
            char c = input.charAt(index);
            if (Character.isDigit(c)) {
                return "id";
            } else {
                return String.valueOf(c);
            }
        }
        return null;
    }

    // 判断符号是否为终结符
    private static boolean isTerminal(String symbol) {
        return !symbol.equals("E") && !symbol.equals("E'") && !symbol.equals("T") && !symbol.equals("T'") && !symbol.equals("F");
    }

    // 主方法，启动程序
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArithmeticParserWithGUI parser = new ArithmeticParserWithGUI();
            parser.setVisible(true);
        });
    }

}
*/
