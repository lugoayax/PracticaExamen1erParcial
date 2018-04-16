package edu.cecyt9.ipn.practicadepracticas;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }
    public void onClickButtonUno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickButtonDos(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickButtonTres(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickButtonCuatro(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickButtonCinco(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickButtonSeis(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickButtonSiete(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickButtonOcho(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickButtonNueve(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickButtonCero(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "0");
    }

    public void onClickButtonPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + ".");
    }

    public void onClickSuma(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "+");
    }
    public void onClickResta(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "-");
    }
    public void onClickMultiplicacion(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "*");
    }
    public void onClickDivision(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "/");
    }

    public void onClickSeno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "sin(");
    }

    public void onClickCoseno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "cos(");
    }

    public void onClickTangente(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "tan(");
    }

    public void onClickCuadrado(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "^");
    }
    public void onClickParA(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "(");
    }
    public void onClickParC(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + ")");
    }

    public void onClickIgual(View miView)
    {
        try{
            TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
            tv.setText(eval(tv.getText().toString())+ "");
        }catch (Exception e){
            Toast.makeText(this, "Expresion no valida", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickLimpia(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText("");
    }

    public double eval(final String str) {
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
