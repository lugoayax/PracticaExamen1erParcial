package edu.cecyt9.ipn.practicadepracticas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView user;
    TextView pass;
    Toast error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user =(TextView) findViewById(R.id.txtUsr);
        pass=(TextView) findViewById(R.id.txtPss);
        error= Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT);
    }

    public void entrar(View view){
        if(user.getText().toString().equals("usuario") && pass.getText().toString().equals("contra")){
            Intent menu = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(menu);
        }
        else{
            error.show();
        }
    }
}
