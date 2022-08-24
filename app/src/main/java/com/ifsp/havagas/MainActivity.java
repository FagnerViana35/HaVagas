package com.ifsp.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.ifsp.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding amb;

    private String nome;
    private  String email;
    private Boolean addEmails;
    private String tel;
    private String opcaoTelefone;
    private String vagasInteresse;
    private String anoFormatura;
    private String anoConcl;
    private String escola;
    private String tituloDeMonografia;
    private String cel;
    private String sexo;
    private String data;
    private String formacao;
    private String orientador;
    private FormularioCadastro formularioCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        amb.ckTelCel.setOnClickListener(view -> {
            if (amb.ckTelCel.isChecked()){
                amb.llTelCelEt.setVisibility(View.VISIBLE);
            }else{
                amb.llTelCelEt.setVisibility(View.GONE);
                amb.telCelEt.setText("");
            }
        });

        amb.formacaoEt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                formacao = (i == 0) ? "Ensino Fundamental" : (i == 1) ? "Ensino Médio" : (i == 2) ? "Curso Técnico" : (i == 3) ? "Tecnologo" :
                        (i == 4) ? "Licenciatura" : (i == 5) ? "Graduação" : (i == 6) ? "Especialização" : (i == 7) ? "MBA" : (i == 8) ? "Mestrado" :
                                (i == 9) ? "Doutorado" : "Pós Doutorado";

                if (i == 0 || i == 1) {
                    amb.llgradEspec.setVisibility(View.GONE);
                    amb.llMestDrdo.setVisibility(View.GONE);
                    amb.llFundMedio.setVisibility(View.VISIBLE);
                } else if (i == 2 || i == 3) {
                    amb.llFundMedio.setVisibility(View.GONE);
                    amb.llMestDrdo.setVisibility(View.GONE);
                    amb.llgradEspec.setVisibility(View.VISIBLE);
                } else {
                    amb.llgradEspec.setVisibility(View.GONE);
                    amb.llFundMedio.setVisibility(View.GONE);
                    amb.llMestDrdo.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        amb.btLimpar.setOnClickListener(view -> {
            amb.nomeEt.setText("");
            amb.emailEt.setText("");
            amb.ckEmail.setChecked(false);
            amb.telefoneEt.setText("");
            amb.rTelComercial.setChecked(true);
            amb.rTelResidencial.setChecked(true);
            amb.telCelEt.setText("");
            amb.sxMasc.setChecked(true);
            amb.dataNascEt.setText("");
            amb.anoFormFundMedio.setText("");
            amb.anoConclGradEspEt.setText("");
            amb.anoConclMestrDout.setText("");
            amb.instMestrDoutEt.setText("");
            amb.instGradEspecEt.setText("");
            amb.monografiaEt.setText("");
            amb.orientadorEt.setText("");
            amb.ckTelCel.setChecked(false);
            amb.vagasInteresseEt.setText("");
            amb.telCelEt.setVisibility(View.GONE);
        });

        amb.btSalvar.setOnClickListener(view -> {

            nome = amb.nomeEt.getText().toString();
            email = amb.emailEt.getText().toString();
            addEmails = amb.ckEmail.isChecked()? true : false;
            tel = amb.telefoneEt.getText().toString();
            opcaoTelefone = amb.rTelComercial.isChecked()? "Comercial" : "Residencial";
            cel = amb.telCelEt.getText().toString();
            sexo = amb.sxMasc.isChecked()? "Masculino" : "Feminino";
            data = amb.dataNascEt.getText().toString();
            vagasInteresse = amb.vagasInteresseEt.getText().toString();

            if(formacao.equals("Fundamental") || formacao.equals("Medio")){
                anoFormatura = amb.anoFormFundMedio.getText().toString();

                formularioCadastro = new FormularioCadastro(nome, email, addEmails, tel, opcaoTelefone, cel, sexo, data, formacao, vagasInteresse,
                        anoConcl, escola);
                Toast.makeText(MainActivity.this, formularioCadastro.toStringFundamentalMedio(), Toast.LENGTH_SHORT).show();

            }else if(formacao.equals("Graduacao") || formacao.equals("Especializacao")){
                anoConcl = amb.anoConclGradEspEt.getText().toString();
                escola = amb.anoConclGradEspEt.getText().toString();

                formularioCadastro = new FormularioCadastro(nome, email, addEmails, tel, opcaoTelefone, cel, sexo, data, formacao, vagasInteresse, anoConcl, escola);
                Toast.makeText(this, formularioCadastro.toStringGraducaoEspecializacao(), Toast.LENGTH_SHORT).show();
            }else{
                tituloDeMonografia = amb.monografiaEt.getText().toString();
                orientador = amb.orientadorEt.getText().toString();

                formularioCadastro = new FormularioCadastro(nome, email, addEmails, tel, opcaoTelefone, cel, sexo, data, formacao, vagasInteresse, anoConcl, escola, tituloDeMonografia, orientador);
                Toast.makeText(this, formularioCadastro.toString(), Toast.LENGTH_SHORT).show();
            }
            amb.ckTelCel.setOnClickListener(view1 -> {
                if(amb.ckTelCel.isChecked()){
                    amb.llTelCelEt.setVisibility(View.VISIBLE);
                }else{
                    amb.llTelCelEt.setVisibility(View.GONE);
                }
            });
        });

    }
}