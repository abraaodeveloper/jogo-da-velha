package com.example.abraao.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt11 ;
    Button bt12 ;
    Button bt13 ;
    Button bt21 ;
    Button bt22 ;
    Button bt23 ;
    Button bt31 ;
    Button bt32 ;
    Button bt33 ;

    Button reiniciarJogo;

    TextView pontosX ;
    TextView pontosO ;

    TextView statusVez;

    private int ptX = 0;
    private int ptO = 0;

    private String vez = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt11 = (Button) findViewById(R.id.bt11);
        bt12 = (Button) findViewById(R.id.bt12);
        bt13 = (Button) findViewById(R.id.bt13);
        bt21 = (Button) findViewById(R.id.bt21);
        bt22 = (Button) findViewById(R.id.bt22);
        bt23 = (Button) findViewById(R.id.bt23);
        bt31 = (Button) findViewById(R.id.bt31);
        bt32 = (Button) findViewById(R.id.bt32);
        bt33 = (Button) findViewById(R.id.bt33);

        reiniciarJogo = (Button) findViewById(R.id.reiniciarjogo);

        pontosX = (TextView) findViewById(R.id.pontosX);
        pontosO = (TextView) findViewById(R.id.pontosO);

        statusVez = (TextView) findViewById(R.id.statusJogada);

        pontosO.setText("0");
        pontosX.setText("0");

        //final Button bt11 = (Button) findViewById(R.id.bt11);
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt11);

            }
        });
        //final Button bt12 = (Button) findViewById(R.id.bt12);
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt12);
            }
        });
        //final Button bt13 = (Button) findViewById(R.id.bt13);
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt13);
            }
        });
        //final Button bt21 = (Button) findViewById(R.id.bt21);
        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt21);
            }
        });
       // final Button bt22 = (Button) findViewById(R.id.bt22);
        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt22);
            }
        });
        //final Button bt23 = (Button) findViewById(R.id.bt23);
        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt23);
            }
        });
       // final Button bt31 = (Button) findViewById(R.id.bt31);
        bt31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt31);
            }
        });
        //final Button bt32 = (Button) findViewById(R.id.bt32);
        bt32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt32);
            }
        });
        //final Button bt33 = (Button) findViewById(R.id.bt33);
        bt33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pintar(bt33);
            }
        });

        reiniciarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt11.setText(" ");
                bt12.setText(" ");
                bt13.setText(" ");
                bt21.setText(" ");
                bt22.setText(" ");
                bt23.setText(" ");
                bt31.setText(" ");
                bt32.setText(" ");
                bt33.setText(" ");
                ptX = 0;
                pontosX.setText(Integer.toString(ptX));
                ptO = 0;
                pontosO.setText(Integer.toString(ptO));
            }
        });
    }
    public void pintar(Button bt){
        if(bt.getText().equals(" ") || bt.getText().equals("")) {
            bt.setText(vez);
            if (vez.equals("X"))
                checar("X");
            if (vez.equals("O"))
                checar("O");
            if(vez.equals("X")) {
                vez = "O";
                statusVez.setText("A vez é do jogador O");
            }else{
                vez = "X";
                statusVez.setText("A vez é do jogador X");
            }
        }

    }
    public void checar(String v){
        if(bt11.getText().equals(v) && bt12.getText().equals(v) && bt13.getText().equals(v) || bt21.getText().equals(v) && bt22.getText().equals(v)
                && bt23.getText().equals(v) || bt31.getText().equals(v) && bt32.getText().equals(v) && bt33.getText().equals(v) ){
            finalizarRodada();
        }
        if(bt11.getText().equals(v) && bt21.getText().equals(v) && bt31.getText().equals(v) || bt12.getText().equals(v) && bt22.getText().equals(v)
                && bt32.getText().equals(v) || bt13.getText().equals(v) && bt23.getText().equals(v) && bt33.getText().equals(v)) {
            finalizarRodada();
        }
        if(bt11.getText().equals(v) && bt22.getText().equals(v) && bt33.getText().equals(v)
                || bt13.getText().equals(v) && bt12.getText().equals(v) && bt31.getText().equals(v)) {
            finalizarRodada();
        }

    }
    public void finalizarRodada(){
        bt11.setText(" ");
        bt12.setText(" ");
        bt13.setText(" ");
        bt21.setText(" ");
        bt22.setText(" ");
        bt23.setText(" ");
        bt31.setText(" ");
        bt32.setText(" ");
        bt33.setText(" ");

        if(vez.equals("X")) {
            Toast.makeText(this, "O jogador X é o vencedor", Toast.LENGTH_LONG).show();
            ptX += 1;
            pontosX.setText(Integer.toString(ptX));
        }
        if(vez.equals("O")) {
            Toast.makeText(this, "O jogador X é o vencedor", Toast.LENGTH_LONG).show();
            ptO += 1;
            pontosO.setText(Integer.toString(ptO));
        }
    }
}
