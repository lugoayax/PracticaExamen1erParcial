package edu.cecyt9.ipn.practicadepracticas;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class memorama extends AppCompatActivity implements View.OnClickListener{
    ImageButton botones[][] = new ImageButton[6][2];
    int contador=0, guarda1=10, guarda2=10, ganas=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorama);
        botones[0][0] = findViewById(R.id.amlo);
        botones[0][1] = findViewById(R.id.amlo2);
        botones[1][0] = findViewById(R.id.piolin);
        botones[1][1] = findViewById(R.id.piolin2);
        botones[2][0] = findViewById(R.id.ocnitrix);
        botones[2][1] = findViewById(R.id.ocnitrix2);
        botones[3][0] = findViewById(R.id.pollo);
        botones[3][1] = findViewById(R.id.pollo2);
        botones[4][0] = findViewById(R.id.patricio);
        botones[4][1] = findViewById(R.id.patricio2);
        botones[5][0] = findViewById(R.id.emo);
        botones[5][1] = findViewById(R.id.emo2);

        for(int i = 0; i<6; i++){
            for(int j = 0; j<2; j++){
                botones[i][j].setImageResource(R.drawable.bienvenidos);
                botones[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i<6; i++){
            for(int j = 0; j<2; j++){
                if(botones[i][j].getId() == v.getId() && pasa(i, j)){

                    if(i==0){
                        botones[i][j].setImageResource(R.drawable.amlo);
                    }
                    if(i==1){
                        botones[i][j].setImageResource(R.drawable.piolin);
                    }
                    if(i==2){
                        botones[i][j].setImageResource(R.drawable.ocnitrix);
                    }
                    if(i==3){
                        botones[i][j].setImageResource(R.drawable.pollo);
                    }
                    if(i==4){
                        botones[i][j].setImageResource(R.drawable.patricio);
                    }
                    if(i==5){
                        botones[i][j].setImageResource(R.drawable.emo);
                    }
                    if(contador<1){
                        contador++;
                        guarda1 = i;
                        guarda2 = j;
                    }else{
                        contador = 0;
                        if(i == guarda1){
                            botones[i][j].setEnabled(false);
                            botones[guarda1][guarda2].setEnabled(false);
                            ganas++;
                            if(ganas>4){
                                Toast.makeText(this, "Ganaste", Toast.LENGTH_LONG);
                            }
                        }else{
                            botones[i][j].setImageResource(R.drawable.bienvenidos);
                            botones[guarda1][guarda2].setImageResource(R.drawable.bienvenidos);
                        }
                        guarda1 = 10;
                        guarda2 = 10;

                    }
                }
            }
        }
    }

    private boolean pasa(int uno, int dos){
        boolean ret=false;
        if(uno != guarda1){
            ret = true;
        }else{
            if(dos != guarda2){
                ret=true;
            }else{
                ret = false;
            }
        }

        return  ret;
    }
}
