package com.example.roomtestapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomtestapp.R;
import com.example.roomtestapp.controller.NotaLab;
import com.example.roomtestapp.entities.Nota;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edNota;
    private Button btSalvar;
    private Button btApagar;

    private NotaLab notaLab;
    private Nota nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNota = findViewById(R.id.ed_nota);

        notaLab = NotaLab.get(this);
        List<Nota> notas = notaLab.getNotas();
        if (notas.size() > 0) {
            nota = notas.get(0);
            edNota.setText(nota.getMensagem());
        }

        btSalvar = findViewById(R.id.bt_salvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btApagar = findViewById(R.id.bt_apagar);
        btApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apagar();
            }
        });
    }

    private void apagar() {
        if (nota != null) {
            notaLab.deleteNota(nota);
            nota = null;
            edNota.setText("");
            Toast.makeText(this, getString(R.string.nota_apagada),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.nota_nao_existe),
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void salvar() {
        String textoNota = edNota.getText().toString();

        if (!textoNota.equals("")) {
            if (nota == null) {
                nota = new Nota();
                nota.setMensagem(textoNota);
                notaLab.addNota(nota);
                Toast.makeText(this, getString(R.string.nota_criada),
                        Toast.LENGTH_SHORT).show();
            } else {
                nota.setMensagem(textoNota);
                notaLab.updateNota(nota);
                Toast.makeText(this, getString(R.string.nota_atualizada),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.crie_nota_primeiro),
                    Toast.LENGTH_SHORT).show();
        }

    }
}