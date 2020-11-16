package com.example.demoeurekaclient.design.Interpreter;

import java.util.StringTokenizer;

/**
 * @author zhanglirui
 * @date 2020/11/16 2:18 下午
 */
public class TerminalExpression extends Expression {

    private String literal = null;

    public TerminalExpression(String str) {
        literal = str;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
