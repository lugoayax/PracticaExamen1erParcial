package edu.cecyt9.ipn.practicadepracticas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button web, image, conect, gato, ahorcado, memorama, calculadora, reserva, inten;
    Intent redirect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        web=(Button) findViewById(R.id.btnWeb);
        conect=(Button) findViewById(R.id.btnConecta);
        image = (Button) findViewById(R.id.btnImageView);
        gato=findViewById(R.id.btnGato);
        ahorcado=findViewById(R.id.btnAhorcado);
        memorama=findViewById(R.id.btnMemorama);
        calculadora=findViewById(R.id.btnCalculadora);
        reserva=findViewById(R.id.btnReserva);
        inten=findViewById(R.id.btnIntents);
        inten.setOnClickListener(this);
        memorama.setOnClickListener(this);
        reserva.setOnClickListener(this);
        calculadora.setOnClickListener(this);
        conect.setOnClickListener(this);
        ahorcado.setOnClickListener(this);
        gato.setOnClickListener(this);
        web.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==web.getId()){
            redirect= new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(redirect);
        }
        if(view.getId()==image.getId()){
            redirect= new Intent(Main2Activity.this, Main4Activity.class);
            startActivity(redirect);
        }
        if(view.getId()==conect.getId()){
            redirect= new Intent(Main2Activity.this, conecta4.class);
            startActivity(redirect);
        }
        if(view.getId()==gato.getId()){
            redirect= new Intent(Main2Activity.this, gato.class);
            startActivity(redirect);
        }
        if(view.getId()==ahorcado.getId()){
            redirect= new Intent(Main2Activity.this, ahorcado.class);
            startActivity(redirect);
        }
        if(view.getId()==memorama.getId()){
            redirect= new Intent(Main2Activity.this, memorama.class);
            startActivity(redirect);
        }
        if(view.getId()==calculadora.getId()){
            redirect= new Intent(Main2Activity.this, calculadora.class);
            startActivity(redirect);
        }
        if(view.getId()==reserva.getId()){
            redirect= new Intent(Main2Activity.this, reserva.class);
            startActivity(redirect);
        }
        if(view.getId()==inten.getId()){
            redirect= new Intent(Main2Activity.this, intents.class);
            startActivity(redirect);
        }
    }
}
