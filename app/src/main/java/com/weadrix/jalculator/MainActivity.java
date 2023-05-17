package com.weadrix.jalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numberZero,numberOne,numberTwo,numberThree,numberFour,numberFive,numberSix,numberSeven,
    numberEight,numberNine,point,sum,subtraction,multiplication,division,equal,btn_clear;

    private TextView txtExpression,txtResult;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitComponent();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        point.setOnClickListener(this);
        sum.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expression = findViewById(R.id.txt_expression);
                String string = expression.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpression = string.substring(var0,var1);
                    expression.setText(txtExpression);
                }
                txtResult.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double)longResult){
                        txtResult.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResult.setText((CharSequence) String.valueOf(result));
                    }
                }catch (Exception e){

                }
            }
        });
    }

    private void InitComponent(){
        numberZero = findViewById(R.id.btn_number_zero);
        numberOne = findViewById(R.id.btn_number_one);
        numberTwo = findViewById(R.id.btn_number_two);
        numberThree = findViewById(R.id.btn_number_three);
        numberFour = findViewById(R.id.btn_number_four);
        numberFive = findViewById(R.id.btn_number_five);
        numberSix = findViewById(R.id.btn_number_six);
        numberSeven = findViewById(R.id.btn_number_seven);
        numberEight = findViewById(R.id.btn_number_eight);
        numberNine = findViewById(R.id.btn_number_nine);
        point = findViewById(R.id.btn_point);
        sum = findViewById(R.id.btn_sum);
        subtraction = findViewById(R.id.btn_subtraction);
        multiplication = findViewById(R.id.btn_multiplication);
        division = findViewById(R.id.btn_division);
        equal = findViewById(R.id.btn_equal);
        btn_clear = findViewById(R.id.btn_clear);
        txtExpression = findViewById(R.id.txt_expression);
        txtResult = findViewById(R.id.txt_result);
        backspace = findViewById(R.id.btn_backspace);
    }

    public void AddExpression(String string, boolean clear_data){

        if (txtResult.getText().equals(""))
        {
            txtExpression.setText(" ");
        }
        if (clear_data){
            txtResult.setText(" ");
            txtExpression.append(string);
        }else {
            txtExpression.append(txtResult.getText());
            txtExpression.append(string);
            txtResult.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        System.out.println("o viewID é: " + view.getId());

        if (viewId == R.id.btn_number_zero) {
            AddExpression("0", true);
        } else if (viewId == R.id.btn_number_one) {
            AddExpression("1", true);
        } else if (viewId == R.id.btn_number_two) {
            AddExpression("2", true);
        } else if (viewId == R.id.btn_number_three) {
            AddExpression("3", true);
        } else if (viewId == R.id.btn_number_four) {
            AddExpression("4", true);
        } else if (viewId == R.id.btn_number_five) {
            AddExpression("5", true);
        } else if (viewId == R.id.btn_number_six) {
            AddExpression("6", true);
        } else if (viewId == R.id.btn_number_seven) {
            AddExpression("7", true);
        } else if (viewId == R.id.btn_number_eight) {
            AddExpression("8", true);
        } else if (viewId == R.id.btn_number_nine) {
            AddExpression("9", true);
        } else if (viewId == R.id.btn_point) {
            AddExpression(".", true);
        } else if (viewId == R.id.btn_sum) {
            AddExpression("+", false);
        } else if (viewId == R.id.btn_subtraction) {
            AddExpression("-", false);
        } else if (viewId == R.id.btn_multiplication) {
            AddExpression("*", false);
        }else if (viewId == R.id.btn_division) {
            AddExpression("/", false);
        }
    }
}