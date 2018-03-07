package edu.cecyt9.ipn.practicadepracticas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class conecta4 extends AppCompatActivity implements View.OnClickListener{

    Button botones[][]=new Button[7][6];
    ImageButton btnRei;
    String sBtns[][] = {{"btn00", "btn01", "btn02", "btn03","btn04", "btn05"}, {"btn10", "btn11", "btn12", "btn13", "btn14", "btn15"},
            {"btn20", "btn21", "btn22", "btn23", "btn24", "btn25"}, {"btn30", "btn31", "btn32", "btn33", "btn34", "btn35"}, {"btn40", "btn41",
            "btn42", "btn43", "btn44", "btn45"}, {"btn50", "btn51", "btn52", "btn53", "btn54", "btn55"}, {"btn60", "btn61", "btn62", "btn63", "btn64", "btn65"}};
    int turno;
    TextView txtP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conecta4);
        txtP = (TextView) findViewById(R.id.txtPrueba);
        btnRei = (ImageButton) findViewById(R.id.btnReiC);
        turno=0;
        botones[0][0] = (Button) findViewById(R.id.btn00);
        botones[0][1] = (Button) findViewById(R.id.btn01);
        botones[0][2] = (Button) findViewById(R.id.btn02);
        botones[0][3] = (Button) findViewById(R.id.btn03);
        botones[0][4] = (Button) findViewById(R.id.btn04);
        botones[0][5] = (Button) findViewById(R.id.btn05);
        botones[1][0] = (Button) findViewById(R.id.btn10);
        botones[1][1] = (Button) findViewById(R.id.btn11);
        botones[1][2] = (Button) findViewById(R.id.btn12);
        botones[1][3] = (Button) findViewById(R.id.btn13);
        botones[1][4] = (Button) findViewById(R.id.btn14);
        botones[1][5] = (Button) findViewById(R.id.btn15);
        botones[2][0] = (Button) findViewById(R.id.btn20);
        botones[2][1] = (Button) findViewById(R.id.btn21);
        botones[2][2] = (Button) findViewById(R.id.btn22);
        botones[2][3] = (Button) findViewById(R.id.btn23);
        botones[2][4] = (Button) findViewById(R.id.btn24);
        botones[2][5] = (Button) findViewById(R.id.btn25);
        botones[3][0] = (Button) findViewById(R.id.btn30);
        botones[3][1] = (Button) findViewById(R.id.btn31);
        botones[3][2] = (Button) findViewById(R.id.btn32);
        botones[3][3] = (Button) findViewById(R.id.btn33);
        botones[3][4] = (Button) findViewById(R.id.btn34);
        botones[3][5] = (Button) findViewById(R.id.btn35);
        botones[4][0] = (Button) findViewById(R.id.btn40);
        botones[4][1] = (Button) findViewById(R.id.btn41);
        botones[4][2] = (Button) findViewById(R.id.btn42);
        botones[4][3] = (Button) findViewById(R.id.btn43);
        botones[4][4] = (Button) findViewById(R.id.btn44);
        botones[4][5] = (Button) findViewById(R.id.btn45);
        botones[5][0] = (Button) findViewById(R.id.btn50);
        botones[5][1] = (Button) findViewById(R.id.btn51);
        botones[5][2] = (Button) findViewById(R.id.btn52);
        botones[5][3] = (Button) findViewById(R.id.btn53);
        botones[5][4] = (Button) findViewById(R.id.btn54);
        botones[5][5] = (Button) findViewById(R.id.btn55);
        botones[6][0] = (Button) findViewById(R.id.btn60);
        botones[6][1] = (Button) findViewById(R.id.btn61);
        botones[6][2] = (Button) findViewById(R.id.btn62);
        botones[6][3] = (Button) findViewById(R.id.btn63);
        botones[6][4] = (Button) findViewById(R.id.btn64);
        botones[6][5] = (Button) findViewById(R.id.btn65);
        botones[0][0].setOnClickListener(this);
        botones[0][1].setOnClickListener(this);
        botones[0][2].setOnClickListener(this);
        botones[0][3].setOnClickListener(this);
        botones[0][4].setOnClickListener(this);
        botones[0][5].setOnClickListener(this);
        btnRei.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //int color;
        if(btnRei.getId() == v.getId()){
            for(int i = 1; i<7; i++){
                for(int j = 0; j<6; j++){
                    botones[i][j].setText("");
                    botones[i][j].setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.darker_gray));
                    turno=0;
                    txtP.setTextColor(Color.parseColor("#999999"));
                    txtP.setText("Turno X");
                    habilita(true);
                }
            }
        }
        String queHay="";
        for(int j = 0; j<6; j++){
            if(botones[0][j].getId() == v.getId()){
                int cont=0;
                for(int i = 6; i>0; i--){
                    //color = ((ColorDrawable) botones[i][j].getBackground()).getColor();
                    queHay = botones[i][j].getText().toString();
                    //if(color != R.color.rojo || color != R.color.azul){
                    if (queHay != "X" && queHay!="O" && cont<1){
                        if(turno%2==0){
                            botones[i][j].setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_dark));
                            botones[i][j].setTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_dark));
                            botones[i][j].setText("X");
                            txtP.setText("Turno O");
                            evalua();
                            turno++;
                            cont++;

                        } else{
                            botones[i][j].setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_blue_dark));
                            botones[i][j].setTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_blue_dark));
                            botones[i][j].setText("O");
                            txtP.setText("Turno X");
                            cont++;
                            evalua();
                            turno++;

                        }
                    }
                }
            }
        }
    }

    public void evalua(){
        if(turno>=36){
            txtP.setText("Empate :(");
            txtP.setTextColor(Color.parseColor("#FF0000"));
            habilita(false);
        }


        //Horizontales---------------
        for(int i = 6; i>1; i--){
            for(int j = 0; j<3; j++){
                String s1, s2, s3, s4;
                s1 = botones[i][j].getText().toString() + "";
                s2 = botones[i][j+1].getText().toString() + "";
                s3 = botones[i][j+2].getText().toString() + "";
                s4 = botones[i][j+3].getText().toString() + "";
                if(s1.equals(s2) && s1.equals(s3) && s1.equals(s4) && !s1.equals("") ){
                    txtP.setTextColor(Color.parseColor("#FF0000"));
                    if(turno%2==0){
                        txtP.setText("X gana");
                        habilita(false);
                    }else{
                        txtP.setText("O gana");
                        habilita(false);
                    }
                }
            }
        }
        //Verticales-------------
        for(int i = 1; i<4; i++){
            for(int j = 0; j<6; j++){
                String s1, s2, s3, s4;
                s1 = botones[i][j].getText().toString() + "";
                s2 = botones[i+1][j].getText().toString() + "";
                s3 = botones[i+2][j].getText().toString() + "";
                s4 = botones[i+3][j].getText().toString() + "";
                if(s1.equals(s2) && s1.equals(s3) && s1.equals(s4) &&  !s1.equals("")){
                    txtP.setTextColor(Color.parseColor("#FF0000"));
                    if(turno%2==0){
                        txtP.setText("X gana");
                        Toast.makeText(this, "Gana X", Toast.LENGTH_SHORT).show();
                        habilita(false);
                    }else{
                        txtP.setText("O gana");
                        Toast.makeText(this, "Gana O", Toast.LENGTH_SHORT).show();
                        habilita(false);
                    }
                }
            }
        }

        //Diagonales-Derecha----------------
        for(int i = 1; i<4; i++){
            for(int j = 0; j<3; j++){
                String s1, s2, s3, s4;
                s1 = botones[i][j].getText().toString() + "";
                s2 = botones[i+1][j+1].getText().toString() + "";
                s3 = botones[i+2][j+2].getText().toString() + "";
                s4 = botones[i+3][j+3].getText().toString() + "";
                if(s1.equals(s2) && s1.equals(s3) && s1.equals(s4) &&  !s1.equals("")){
                    txtP.setTextColor(Color.parseColor("#FF0000"));
                    if(turno%2==0){
                        txtP.setText("X gana");
                        habilita(false);
                    }else{
                        txtP.setText("O gana");
                        habilita(false);
                    }
                }
            }
        }

        //Diagonales-Izquierda---------------------------
        for(int i = 1; i<4; i++){
            for(int j = 5; j>3; j--){
                String s1, s2, s3, s4;
                s1 = botones[i][j].getText().toString() + "";
                s2 = botones[i+1][j-1].getText().toString() + "";
                s3 = botones[i+2][j-2].getText().toString() + "";
                s4 = botones[i+3][j-3].getText().toString() + "";
                if(s1.equals(s2) && s1.equals(s3) && s1.equals(s4) &&  !s1.equals("")){
                    txtP.setTextColor(Color.parseColor("#FF0000"));
                    if(turno%2==0){
                        txtP.setText("X gana");
                        habilita(false);
                    }else{
                        txtP.setText("O gana");
                        habilita(false);
                    }
                }
            }
        }

    }

    private void habilita(boolean b){
        if(b)
            for(int j = 0; j<6; j++)
                botones[0][j].setEnabled(true);
        else
            for(int j = 0; j<6; j++)
                botones[0][j].setEnabled(false);
    }
}