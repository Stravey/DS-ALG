package com.myframe.Parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@SuppressWarnings("all")
public class ParserGUI extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;

    public ParserGUI() {
        setTitle("语法分析器");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 主容器使用BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // 左右输入输出面板（使用等分网格布局）
        JPanel ioPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        ioPanel.setBorder(BorderFactory.createTitledBorder("输入输出区域"));

        // 输入区域
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputArea = createStyledTextArea();
        inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createTitledBorder("输入表达式"));

        // 输出区域
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputArea = createStyledTextArea();
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        outputPanel.setBorder(BorderFactory.createTitledBorder("分析结果"));

        ioPanel.add(inputPanel);
        ioPanel.add(outputPanel);

        // 底部按钮面板（居中布局）
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // 功能按钮
        JButton uploadBtn = createButton("上传文件", new Color(0, 150, 136));
        JButton parseBtn = createButton("分析语法", new Color(255, 87, 34));

        controlPanel.add(Box.createHorizontalGlue());
        controlPanel.add(uploadBtn);
        controlPanel.add(Box.createHorizontalStrut(30));
        controlPanel.add(parseBtn);
        controlPanel.add(Box.createHorizontalGlue());

        // 组装主界面
        mainPanel.add(ioPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        add(mainPanel);

        // 事件绑定
        uploadBtn.addActionListener(this::handleFileUpload);
        parseBtn.addActionListener(this::handleParse);
    }

    private JTextArea createStyledTextArea() {
        JTextArea area = new JTextArea();
        area.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        return area;
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createEmptyBorder(8, 25, 8, 25)
        ));
        return button;
    }

    private void handleFileUpload(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                inputArea.setText(content.toString().trim());
            } catch (Exception ex) {
                outputArea.setText("文件读取错误: " + ex.getMessage());
            }
        }
    }

    private void handleParse(ActionEvent e) {
        String input = inputArea.getText().trim();
        try {
            // 调用语法分析逻辑（需自行实现）
            boolean isValid = new LL1Parser().parse(new Tokenizer().tokenize(input));
            outputArea.setText(isValid ? "合法表达式" : "非法表达式");
            outputArea.setBackground(isValid ? new Color(220, 255, 220) : new Color(255, 220, 220));
        } catch (Exception ex) {
            outputArea.setText("分析错误: " + ex.getMessage());
            outputArea.setBackground(new Color(255, 220, 220));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new ParserGUI().setVisible(true);
        });
    }
}