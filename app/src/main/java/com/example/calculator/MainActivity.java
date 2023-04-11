package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

    Button btnHapus, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9, btnTambah, btnMinus, btnKali, btnKurung, btnPercent;
    Button btnBagi, btnDot, btnHasil;
    TextView perhitungan, hasil;
    String process;
    Boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnHapus = findViewById(R.id.btnHapus);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurung = findViewById(R.id.btnKurung);
        btnMinus = findViewById(R.id.btnMinus);
        btnKali = findViewById(R.id.btnKali);
        btnPercent = findViewById(R.id.btnPercent);
        btnBagi = findViewById(R.id.btnBagi);
        btnDot = findViewById(R.id.btnDot);
        btnHasil = findViewById(R.id.btnHasil);

        perhitungan = findViewById(R.id.perhitungan);
        hasil = findViewById(R.id.hasil);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perhitungan.setText("");
                hasil.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "0");
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "-");
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "×");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "÷");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + ".");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = perhitungan.getText().toString();
                perhitungan.setText(process + "%");
            }
        });

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                public void onClick(View v) {
                    process = perhitungan.getText().toString();
                    process = process.replaceAll("×", "*");
                    process = process.replaceAll("%",  "/100");
                    process = process.replaceAll("÷","/");

                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    String finalResult = "";

                    try {
                        Scriptable scriptable = rhino.initStandardObjects();
                        finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                        if (finalResult.contains(".")) { // check if result contains decimal point
                            double doubleResult = Double.parseDouble(finalResult);
                            finalResult = String.format("%.2f", doubleResult); // format the result with 2 decimal places
                        } else {
                            int intResult = Integer.parseInt(finalResult);
                            finalResult = String.valueOf(intResult); // convert the result to string
                        }
                    } catch (Exception e) {
                        finalResult="0";
                    }
                    hasil.setText(finalResult);
                });

        btnKurung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    process = perhitungan.getText().toString();
                    perhitungan.setText(process + ")");
                    checkBracket = false;
                }
                else{
                    process = perhitungan.getText().toString();
                    perhitungan.setText(process + "(");
                    checkBracket = true;
                }
            }
        });
    }
}
