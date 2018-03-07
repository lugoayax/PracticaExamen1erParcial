package edu.cecyt9.ipn.practicadepracticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {

    Button cambiar;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        cambiar= (Button) findViewById(R.id.btnCambiar);
        imagen = (ImageView) findViewById(R.id.viewImagen);
    }

    public void cambiar(View v){
            imagen.setImageResource(R.drawable.lion);

    }
}
