package edu.cecyt9.ipn.practicadepracticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    WebView vista;
    TextView url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        vista=(WebView) findViewById(R.id.webView);
        url=(TextView) findViewById(R.id.txtUrl);
    }

    public void buscar(View v){
        if(url.getText().toString().isEmpty()){
            Toast.makeText(this, "Escriba una URL", Toast.LENGTH_SHORT).show();
        }
        else{
            vista.loadUrl(url.getText().toString());
        }
    }
}
