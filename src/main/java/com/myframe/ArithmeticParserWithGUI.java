package com.myframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArithmeticParserWithGUI {
    private static final Map<String, Map<String, String>> parsingTable = new HashMap<>();
    private static final String START_SYMBOL = "E";

    static {
        // 初始化预测分析表
        Map<String, String> eRow = new HashMap<>();
        eRow.put("id", "T E'");
        eRow.put("(", "T E'");
        parsingTable.put("E", eRow);

        Map<String, String> ePrimeRow = new HashMap<>();
        ePrimeRow.put("+", "+ T E'");
        ePrimeRow.put(")", "ε");
        ePrimeRow.put("$", "ε");
        parsingTable.put("E'", ePrimeRow);

        Map<String, String> tRow = new HashMap<>();
        tRow.put("id", "F T'");
        tRow.put("(", "F T'");
        parsingTable.put("T", tRow);

        Map<String, String> tPrimeRow = new HashMap<>();
        tPrimeRow.put("*", "* F T'");
        tPrimeRow.put("+", "ε");
        tPrimeRow.put(")", "ε");
        tPrimeRow.put("$", "ε");
        parsingTable.put("T'", tPrimeRow);

        Map<String, String> fRow = new HashMap<>();
        fRow.put("id", "id");
        fRow.put("(", "( E )");
        parsingTable.put("F", fRow);
    }

    private JTextField inputField;
    private JLabel resultLabel;

    public ArithmeticParserWithGUI() {
        setTitle("算术表达式语法分析器");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("输入算术表达式:");
        inputField = new JTextField(20);
        JButton analyzeButton = new JButton("分析");
        resultLabel = new JLabel("");

        add(inputLabel);
        add(inputField);
        add(analyzeButton);
        add(resultLabel);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                boolean result = parse(input);
                resultLabel.setText("表达式 " + input + " 是否合法: " + result);
            }
        });
    }

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
                Map<String, String> row = parsingTable.get(top);
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

    private static boolean isTerminal(String symbol) {
        return !symbol.equals("E") && !symbol.equals("E'") && !symbol.equals("T") && !symbol.equals("T'") && !symbol.equals("F");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ArithmeticParserWithGUI parser = new ArithmeticParserWithGUI();
                parser.setVisible(true);
            }
        });
    }

}
