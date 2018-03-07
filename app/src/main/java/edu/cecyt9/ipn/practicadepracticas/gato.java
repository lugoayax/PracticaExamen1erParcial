package edu.cecyt9.ipn.practicadepracticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class gato extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9, reinicio;
    int acabo=0;
    int turno=0;
    String xo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b8=findViewById(R.id.btn8);
        b9=findViewById(R.id.btn9);
        reinicio=findViewById(R.id.btnReiniciar);
        reinicio.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(acabo==0){



            switch (v.getId()){
                case (R.id.btn1):
                    vacio(b1);
                    break;
                case (R.id.btn2):
                    vacio(b2);
                    break;
                case (R.id.btn3):
                    vacio(b3);
                    break;
                case (R.id.btn4):
                    vacio(b4);
                    break;
                case (R.id.btn5):
                    vacio(b5);
                    break;
                case (R.id.btn6):
                    vacio(b6);
                    break;
                case (R.id.btn7):
                    vacio(b7);
                    break;
                case (R.id.btn8):
                    vacio(b8);
                    break;
                case (R.id.btn9):
                    vacio(b9);
                    break;
                default:
                    break;
            }

            evalua();

        }
        if(v.getId()==reinicio.getId()){
            b1.setText("");b2.setText("");b3.setText("");b4.setText("");b5.setText("");
            b6.setText("");b7.setText("");b8.setText("");b9.setText("");
            acabo=0;
        }
    }
    public void vacio(Button b){

        if(b.getText().toString().equals("")){
            if(turno==0){
                xo="X";
                turno=1;
            }
            else{
                xo="O";
                turno=0;
            }
            b.setText(xo);
        }
    }

    public void evalua(){
        if((b1.getText().toString().equals(b2.getText().toString())&& b1.getText().toString().equals(b3.getText().toString()) && !b1.getText().toString().equals(""))
                || (b1.getText().toString().equals(b4.getText().toString())&& b1.getText().toString().equals(b7.getText().toString()) && !b1.getText().toString().equals(""))
                || (b1.getText().toString().equals(b5.getText().toString())&& b1.getText().toString().equals(b9.getText().toString()) && !b1.getText().toString().equals(""))
                || (b2.getText().toString().equals(b5.getText().toString())&& b2.getText().toString().equals(b8.getText().toString()) && !b2.getText().toString().equals(""))
                || (b3.getText().toString().equals(b6.getText().toString())&& b3.getText().toString().equals(b9.getText().toString()) && !b3.getText().toString().equals(""))
                || (b3.getText().toString().equals(b5.getText().toString())&& b3.getText().toString().equals(b7.getText().toString()) && !b3.getText().toString().equals(""))
                || (b4.getText().toString().equals(b5.getText().toString())&& b4.getText().toString().equals(b6.getText().toString()) && !b4.getText().toString().equals(""))
                || (b7.getText().toString().equals(b8.getText().toString())&& b7.getText().toString().equals(b9.getText().toString()) && !b7.getText().toString().equals(""))){
            acabo=1;
            Toast.makeText(this, "Gano"+xo, Toast.LENGTH_SHORT).show();
        }
    }
}
