package io.github.rushi98.rcal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity
{
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                TextView display = (TextView) findViewById(R.id.display);
                Button seven = (Button) findViewById(R.id.seven);
                Button eight = (Button) findViewById(R.id.eight);
                Button nine = (Button) findViewById(R.id.nine);
                Button four = (Button) findViewById(R.id.four);
                Button five = (Button) findViewById(R.id.five);
                Button six = (Button) findViewById(R.id.six);
                Button one = (Button) findViewById(R.id.one);
                Button two = (Button) findViewById(R.id.two);
                Button three = (Button) findViewById(R.id.three);
                Button zero = (Button) findViewById(R.id.zero);
                Button dot = (Button) findViewById(R.id.dot);
                Button equals = (Button) findViewById(R.id.equals);
                ImageButton backspace = (ImageButton) findViewById(R.id.backspace);
                ImageButton ac = (ImageButton) findViewById(R.id.ac);
                Button multiply = (Button) findViewById(R.id.multiply);
                Button divide = (Button) findViewById(R.id.divide);
                Button plus = (Button) findViewById(R.id.plus);
                Button minus = (Button) findViewById(R.id.minus);
                Button left_bracket = (Button) findViewById(R.id.left_bracket);
                Button right_bracket = (Button) findViewById(R.id.right_bracket);
                final Calculator calculator = new Calculator(display);
                View.OnClickListener sevenListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("7");
                        }
                };
                seven.setOnClickListener(sevenListener);
                View.OnClickListener eightListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("8");
                        }
                };
                eight.setOnClickListener(eightListener);
                View.OnClickListener nineListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("9");
                        }
                };
                nine.setOnClickListener(nineListener);
                View.OnClickListener fourListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("4");
                        }
                };
                four.setOnClickListener(fourListener);
                View.OnClickListener fiveListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("5");
                        }
                };
                five.setOnClickListener(fiveListener);
                View.OnClickListener sixListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("6");
                        }
                };
                six.setOnClickListener(sixListener);
                View.OnClickListener oneListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("1");
                        }
                };
                one.setOnClickListener(oneListener);
                View.OnClickListener twoListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("2");
                        }
                };
                two.setOnClickListener(twoListener);
                View.OnClickListener threeListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("3");
                        }
                };
                three.setOnClickListener(threeListener);
                View.OnClickListener zeroListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("0");
                        }
                };
                zero.setOnClickListener(zeroListner);
                View.OnClickListener dotListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit(".");
                        }
                };
                dot.setOnClickListener(dotListener);
                View.OnClickListener equalListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.equals();
                        }
                };
                equals.setOnClickListener(equalListener);
                View.OnClickListener acListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.ac();
                        }
                };
                ac.setOnClickListener(acListener);
                View.OnClickListener backSpaceListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.backSpace();
                        }
                };
                backspace.setOnClickListener(backSpaceListener);
                View.OnClickListener multiplyListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputOperator("*");
                        }
                };
                multiply.setOnClickListener(multiplyListener);
                View.OnClickListener divideListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputOperator("/");
                        }
                };
                divide.setOnClickListener(divideListener);
                View.OnClickListener plusListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputOperator("+");
                        }
                };
                plus.setOnClickListener(plusListener);
                View.OnClickListener minusListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputOperator("-");
                        }
                };
                minus.setOnClickListener(minusListener);
                View.OnClickListener leftBracketListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit("(");
                        }
                };
                left_bracket.setOnClickListener(leftBracketListener);
                View.OnClickListener rightBracketListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                calculator.inputDigit(")");
                        }
                };
                right_bracket.setOnClickListener(rightBracketListener);
        }
}
