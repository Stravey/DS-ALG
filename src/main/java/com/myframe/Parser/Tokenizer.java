package com.myframe.Parser;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        int pos = 0;
        while (pos < input.length()) {
            char c = input.charAt(pos);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
                    num.append(input.charAt(pos));
                    pos++;
                }
                tokens.add(new Token(TokenType.NUM, num.toString()));
            } else if (c == '+') {
                tokens.add(new Token(TokenType.PLUS, "+"));
                pos++;
            } else if (c == '*') {
                tokens.add(new Token(TokenType.MULTIPLY, "*"));
                pos++;
            } else if (Character.isWhitespace(c)) {
                pos++;
            } else {
                throw new IllegalArgumentException("非法字符: " + c);
            }
        }
        tokens.add(new Token(TokenType.EOF, "$")); // 添加结束符
        return tokens;
    }
}