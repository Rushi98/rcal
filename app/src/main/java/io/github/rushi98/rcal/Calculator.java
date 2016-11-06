package io.github.rushi98.rcal;

import android.widget.TextView;

/**
 * Created by rushi on 5/11/16.
 * Thanks Boann (http://stackoverflow.com/users/964243/boann) for code to evaluate algebra in string format
 * on (http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form)
 */

public class Calculator {
        private TextView display;
        private String queryString;
        boolean followsAnswer = false;
        Calculator(TextView display)
        {
                this.display = display;
                this.queryString = "0";
        }
        public void inputDigit(String in)
        {
                if(this.followsAnswer) this.queryString = "0";
                if(this.queryString.equals("0") && !in.equals(".")) this.queryString = "";
                this.queryString += in;
                this.followsAnswer = false;
                this.display.setText(this.queryString);
        }
        public void backSpace()
        {
                if(this.followsAnswer) this.queryString = "0";
                this.followsAnswer = false;
                int length = this.queryString.length();
                this.queryString = this.queryString.substring(0,length - 1);
                if(this.queryString.length() == 0) this.queryString = "0";
                this.display.setText(this.queryString);
        }
        public void ac()
        {
                this.queryString = "0";
                this.followsAnswer = false;
                this.display.setText(this.queryString);
        }
        public void inputOperator(String op)
        {
                this.queryString += op;
                this.followsAnswer = false;
                this.display.setText(queryString);
        }
        public void equals()
        {
                try
                {
                        this.queryString = String.valueOf(this.eval(this.queryString));
                        this.display.setText(queryString);
                        this.followsAnswer = true;
                }
                catch(Exception e)
                {
                        this.showError();
                }
        }
        private void showError()
        {
                this.display.setText("ERROR!");
                this.queryString = "0";
                this.followsAnswer = false;
        }


        private static double eval(final String str) {
                return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                                while (ch == ' ') nextChar();
                                if (ch == charToEat) {
                                        nextChar();
                                        return true;
                                }
                                return false;
                        }

                        double parse() {
                                nextChar();
                                double x = parseExpression();
                                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                                return x;
                        }

                        // Grammar:
                        // expression = term | expression `+` term | expression `-` term
                        // term = factor | term `*` factor | term `/` factor
                        // factor = `+` factor | `-` factor | `(` expression `)`
                        //        | number | functionName factor | factor `^` factor

                        double parseExpression() {
                                double x = parseTerm();
                                for (;;) {
                                        if      (eat('+')) x += parseTerm(); // addition
                                        else if (eat('-')) x -= parseTerm(); // subtraction
                                        else return x;
                                }
                        }

                        double parseTerm() {
                                double x = parseFactor();
                                for (;;) {
                                        if      (eat('*')) x *= parseFactor(); // multiplication
                                        else if (eat('/')) x /= parseFactor(); // division
                                        else return x;
                                }
                        }

                        double parseFactor() {
                                if (eat('+')) return parseFactor(); // unary plus
                                if (eat('-')) return -parseFactor(); // unary minus

                                double x;
                                int startPos = this.pos;
                                if (eat('(')) { // parentheses
                                        x = parseExpression();
                                        eat(')');
                                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                                        x = Double.parseDouble(str.substring(startPos, this.pos));
                                } else if (ch >= 'a' && ch <= 'z') { // functions
                                        while (ch >= 'a' && ch <= 'z') nextChar();
                                        String func = str.substring(startPos, this.pos);
                                        x = parseFactor();
                                        if (func.equals("sqrt")) x = Math.sqrt(x);
                                        else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                                        else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                                        else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                                        else throw new RuntimeException("Unknown function: " + func);
                                } else {
                                        throw new RuntimeException("Unexpected: " + (char)ch);
                                }

                                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                                return x;
                        }
                }.parse();
        }
}
