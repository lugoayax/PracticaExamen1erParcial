package edu.cecyt9.ipn.practicadepracticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ahorcado extends AppCompatActivity implements View.OnClickListener {

    TextView palabra, caracter;
    Button intentar, reintentar;
    ImageView imagen;
    int turno=0;
    int error=0;
    String opciones[]={"Pro_r_m_r", "Progr_m_r", "Program_r", "Programar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);
        intentar=findViewById(R.id.btnIntentar);
        reintentar=findViewById(R.id.btnReintentar);
        palabra=findViewById(R.id.txtPalabra);
        caracter=findViewById(R.id.txtCaracter);
        imagen=findViewById(R.id.imgAhorcado);
        intentar.setOnClickListener(this);
        reintentar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==intentar.getId()){
            if(!caracter.getText().toString().equals("") && caracter.getText().toString().length()==1) {
                switch (turno){
                    case 0:
                        if(caracter.getText().toString().equals("r")){
                            palabra.setText(opciones[0]);
                            Toast.makeText(this, "Correcto :D", Toast.LENGTH_SHORT).show();
                            turno++;
                        }
                        else{
                            error++;
                            errores();
                        }
                        break;
                    case 1:
                        if(caracter.getText().toString().equals("g")){
                            palabra.setText(opciones[1]);
                            Toast.makeText(this, "Correcto :D", Toast.LENGTH_SHORT).show();
                            turno++;
                        }
                        else{
                            error++;
                            errores();
                        }
                        break;
                    case 2:
                        if(caracter.getText().toString().equals("a")){
                            palabra.setText(opciones[2]);
                            Toast.makeText(this, "Correcto :D", Toast.LENGTH_SHORT).show();
                            turno++;
                        }
                        else{
                            error++;
                            errores();
                        }
                        break;
                    case 3:
                        if(caracter.getText().toString().equals("a")){
                            palabra.setText(opciones[3]);
                            Toast.makeText(this, "Has Ganado :)", Toast.LENGTH_SHORT).show();
                            intentar.setEnabled(false);
                            caracter.setEnabled(false);
                        }
                        else{
                            error++;
                            errores();
                        }
                        break;
                }
            }
            else{
                Toast.makeText(this, "Debes escribir unicamente un caracter y no puedes dejarlo vacio", Toast.LENGTH_SHORT).show();
            }
        }
        if(view.getId()==reintentar.getId()){
            turno=0;
            error=0;
            imagen.setImageResource(R.drawable.ahorcado1);
            palabra.setText("P_o_r_m_r");
            intentar.setEnabled(true);
            caracter.setEnabled(true);
        }
    }

    public void errores(){
        switch (error){
            case 1:
                imagen.setImageResource(R.drawable.ahorcado2);
                break;
            case 2:
                imagen.setImageResource(R.drawable.ahorcado3);
                break;
            case 3:
                imagen.setImageResource(R.drawable.ahorcado4);
                break;
            case 4:
                imagen.setImageResource(R.drawable.ahorcado5);
                Toast.makeText(this, "Has Perdido x(", Toast.LENGTH_SHORT).show();
                intentar.setEnabled(false);
                caracter.setEnabled(false);
                break;
        }
    }
}
