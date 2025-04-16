package com.myframe.Parser;

import java.util.*;

public class LL1Parser {
    private Map<Symbol, Map<Symbol, List<Symbol>>> parsingTable;

    public LL1Parser() {
        initializeParsingTable();
    }

    private void initializeParsingTable() {
        parsingTable = new HashMap<>();

        // E -> T E'
        parsingTable.computeIfAbsent(Symbol.E, k -> new HashMap<>())
            .put(Symbol.NUM, Arrays.asList(Symbol.T, Symbol.E_PRIME));

        // E' -> + T E' | ε
        parsingTable.computeIfAbsent(Symbol.E_PRIME, k -> new HashMap<>())
            .put(Symbol.PLUS, Arrays.asList(Symbol.PLUS, Symbol.T, Symbol.E_PRIME));
        parsingTable.get(Symbol.E_PRIME).put(Symbol.EOF, Collections.emptyList());
        parsingTable.get(Symbol.E_PRIME).put(Symbol.PLUS, Arrays.asList(Symbol.PLUS, Symbol.T, Symbol.E_PRIME));

        // T -> F T'
        parsingTable.computeIfAbsent(Symbol.T, k -> new HashMap<>())
            .put(Symbol.NUM, Arrays.asList(Symbol.F, Symbol.T_PRIME));

        // T' -> * F T' | ε
        parsingTable.computeIfAbsent(Symbol.T_PRIME, k -> new HashMap<>())
            .put(Symbol.MULTIPLY, Arrays.asList(Symbol.MULTIPLY, Symbol.F, Symbol.T_PRIME));
        parsingTable.get(Symbol.T_PRIME).put(Symbol.PLUS, Collections.emptyList());
        parsingTable.get(Symbol.T_PRIME).put(Symbol.EOF, Collections.emptyList());

        // F -> num
        parsingTable.computeIfAbsent(Symbol.F, k -> new HashMap<>())
            .put(Symbol.NUM, Arrays.asList(Symbol.NUM));
    }

    public boolean parse(List<Token> tokens) {
        Stack<Symbol> stack = new Stack<>();
        stack.push(Symbol.EOF);
        stack.push(Symbol.E);

        int currentTokenIndex = 0;
        Symbol currentTerminal = getSymbolForToken(tokens.get(currentTokenIndex));

        while (!stack.isEmpty()) {
            Symbol top = stack.pop();
            if (isTerminal(top)) {
                if (top == currentTerminal) {
                    if (currentTerminal != Symbol.EOF) {
                        currentTokenIndex++;
                        if (currentTokenIndex < tokens.size()) {
                            currentTerminal = getSymbolForToken(tokens.get(currentTokenIndex));
                        } else {
                            currentTerminal = Symbol.EOF;
                        }
                    }
                } else {
                    return false; // 终结符不匹配
                }
            } else {
                Map<Symbol, List<Symbol>> row = parsingTable.get(top);
                if (row == null) return false;
                List<Symbol> production = row.get(currentTerminal);
                if (production == null) return false; // 分析表无对应项
                // 逆序压栈
                for (int i = production.size() - 1; i >= 0; i--) {
                    stack.push(production.get(i));
                }
            }
        }
        return currentTerminal == Symbol.EOF;
    }

    private boolean isTerminal(Symbol symbol) {
        return symbol == Symbol.PLUS || symbol == Symbol.MULTIPLY || symbol == Symbol.NUM || symbol == Symbol.EOF;
    }

    private Symbol getSymbolForToken(Token token) {
        switch (token.getType()) {
            case PLUS: return Symbol.PLUS;
            case MULTIPLY: return Symbol.MULTIPLY;
            case NUM: return Symbol.NUM;
            case EOF: return Symbol.EOF;
            default: throw new IllegalArgumentException("无效Token类型");
        }
    }
}