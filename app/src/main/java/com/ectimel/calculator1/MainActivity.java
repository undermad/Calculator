package com.ectimel.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAc, btnPlus,
            btnMinus, btnMulti, btnDivide, btnEqual, btnDel, btnDot;
    private TextView textViewResult, textViewHistory;
    private String numberAsString = null;
    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;
    boolean dot = false;
    boolean equalController = false;

    private String history, currentResult;

    DecimalFormat myFormatter = new DecimalFormat("######.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btn0 = findViewById(R.id.btnZero);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);

        btnAc = findViewById(R.id.btnAc);
        btnDel = findViewById(R.id.btnDel);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });

        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberAsString.length() != 0) {
                    numberAsString = numberAsString.substring(0, numberAsString.length() - 1);
                    if (numberAsString.isEmpty())
                        textViewResult.setText("0");
                    else
                        textViewResult.setText(numberAsString);

                }

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "+");


                if (operator) {
                    if (status == "multiplication")
                        multiply();
                    else if (status == "division")
                        divide();
                    else if (status == "subtraction")
                        minus();
                    else
                        plus();
                }

                status = "sum";
                operator = false;
                numberAsString = null;

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "-");
                if (operator) {
                    if (status == "multiplication")
                        multiply();
                    else if (status == "division")
                        divide();
                    else if (status == "sum")
                        plus();
                    else
                        minus();
                }

                status = "subtraction";
                operator = false;
                numberAsString = null;

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator) {
                    if (status == "subtraction")
                        minus();
                    else if (status == "division")
                        divide();
                    else if (status == "sum")
                        plus();
                    else if (status == "multiplication")
                        multiply();
                    else
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                }

                status = null;
                operator = false;
                textViewHistory.setText("");
                lastNumber = 0;
                equalController = true;

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "*");
                if (operator) {
                    if (status == "subtraction")
                        minus();
                    else if (status == "division")
                        divide();
                    else if (status == "sum")
                        plus();
                    else
                        multiply();
                }

                status = "multiplication";
                operator = false;
                numberAsString = null;

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "/");
                if (operator) {
                    if (status == "multiplication")
                        multiply();
                    else if (status == "subtraction")
                        minus();
                    else if (status == "sum")
                        plus();
                    else
                        divide();
                }

                status = "division";
                operator = false;
                numberAsString = null;
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!dot) {
                    if (numberAsString == null) {
                        numberAsString = "0.";
                    } else {
                        numberAsString += ".";
                    }
                }
                textViewResult.setText(numberAsString);
                dot = true;
            }
        });


    }

    public void resetAll() {
        numberAsString = null;
        status = null;
        textViewResult.setText("0");
        textViewHistory.setText("");
        firstNumber = 0;
        lastNumber = 0;
        dot = false;
    }

    public void divide() {
        if (firstNumber == 0) {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber /= lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
        dot = false;
    }

    public void multiply() {
        if (firstNumber == 0) {
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber *= lastNumber;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber *= lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = false;

    }

    public void plus() {
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber += lastNumber;
        textViewResult.setText(myFormatter.format(firstNumber));
        dot = false;
    }

    public void minus() {

        if (firstNumber == 0)
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber -= lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = false;
    }


    public void numberClick(String view) {
        if (numberAsString == null) {
            numberAsString = view;
        } else if (equalController) {
            firstNumber = 0;
            lastNumber = 0;
            numberAsString = view;
        } else {
            numberAsString += view;
        }
        textViewResult.setText(numberAsString);
        operator = true;
        equalController = false;
    }
}
