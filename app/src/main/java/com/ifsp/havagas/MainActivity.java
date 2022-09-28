package com.ifsp.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.ifsp.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding amb;

    private final String  CYCLE_RECOVERY= "CYCLE_RECOVERY";

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

    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private static final String TELEFONE = "33071465";
    private static final String DATA= "28/06/2022";
    private static final String VAGAS_INTERESSE = "Desenvolvedor";
    private static final String ANO_FORMATURA_ENSINO_MEDIO = "20/06/2005";
    private static final String TITULO_MONOGRAFIA= "sim";
    private static final String ORIENTADOR = "Tem orientador";
    private static final String CELULAR= "994152898";
    private static final String CKEMAIL = "true";
    private static final String TEL_RESIDENCIAL = "34165898";
    private static final String TEL_COMERCIAL= "33071468";
    private static final String SEXO_MASC= "sexo Masculino";
    private static final String SEXO_FEM= "Sexo Feminino";
    private static final String ANO_CONCLUSAO_GRAD= "Ano de Conclusão da Gaduação";
    private static final String ANO_CONCLUSAO_MEST_DOUT= "Ano de Conclusão do Mestrado";
    private static final String INST_MESTR_DOUT= "Instituição de Doutorado";
    private static final String INST_GRAD_ESPEC= "Instituição de Especialização";
    private static final String CK_EMAIL= "email";

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

    @SuppressLint("LongLogTag")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(NOME, amb.nomeEt.getText().toString());
        outState.putString(EMAIL, amb.emailEt.getText().toString());
        outState.putString(TELEFONE, amb.telefoneEt.getText().toString());
        outState.putString(CELULAR, amb.telCelEt.getText().toString());
        outState.putBoolean(TEL_RESIDENCIAL, amb.rTelResidencial.isChecked());
        outState.putBoolean(TEL_COMERCIAL, amb.rTelComercial.isChecked());
        outState.putString(DATA, amb.dataNascEt.getText().toString());

        outState.putString(VAGAS_INTERESSE, amb.vagasInteresseEt.getText().toString());

        outState.putString(TITULO_MONOGRAFIA, amb.monografiaEt.getText().toString());
        outState.putString(ORIENTADOR, amb.orientadorEt.getText().toString());

        outState.putBoolean(CKEMAIL, amb.ckEmail.isChecked());

        outState.putBoolean(SEXO_MASC, amb.sxMasc.isChecked());
        outState.putBoolean(SEXO_FEM, amb.sxFem.isChecked());

        outState.putString(ANO_FORMATURA_ENSINO_MEDIO, amb.anoFormFundMedio.getText().toString());
        outState.putString(ANO_CONCLUSAO_GRAD, amb.anoConclGradEspEt.getText().toString());
        outState.putString(ANO_CONCLUSAO_MEST_DOUT, amb.anoConclMestrDout.getText().toString());

        outState.putString(INST_MESTR_DOUT, amb.instMestrDoutEt.getText().toString());
        outState.putString(INST_GRAD_ESPEC, amb.instGradEspecEt.getText().toString());


        Log.v("Recuperação no onSaveInstanceState", "Dados salvos no Bundle outState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        amb.nomeEt.setText(savedInstanceState.getString(NOME));
        amb.emailEt.setText(savedInstanceState.getString(EMAIL));
        amb.telefoneEt.setText(savedInstanceState.getString(TELEFONE));
        amb.rTelResidencial.setChecked(savedInstanceState.getBoolean((TEL_RESIDENCIAL)));
        amb.rTelComercial.setChecked(savedInstanceState.getBoolean((TEL_COMERCIAL)));

        amb.ckTelCel.setText(savedInstanceState.getString(CELULAR));

        amb.sxMasc.setChecked(savedInstanceState.getBoolean(SEXO_MASC));
        amb.sxFem.setChecked(savedInstanceState.getBoolean(SEXO_FEM));

        amb.dataNascEt.setText(savedInstanceState.getString(DATA));

        amb.vagasInteresseEt.setText(savedInstanceState.getString(VAGAS_INTERESSE));

        amb.anoConclMestrDout.setText(savedInstanceState.getString(ANO_CONCLUSAO_MEST_DOUT));
        amb.anoFormFundMedio.setText(savedInstanceState.getString(ANO_FORMATURA_ENSINO_MEDIO));
        amb.anoConclGradEspEt.setText(savedInstanceState.getString(ANO_CONCLUSAO_GRAD));

        amb.instMestrDoutEt.setText(savedInstanceState.getString(INST_MESTR_DOUT));
        amb.instGradEspecEt.setText(savedInstanceState.getString(INST_GRAD_ESPEC));

        amb.monografiaEt.setText(savedInstanceState.getString(TITULO_MONOGRAFIA));
        amb.orientadorEt.setText(savedInstanceState.getString(ORIENTADOR));
        amb.ckEmail.setChecked(savedInstanceState.getBoolean(CK_EMAIL));


        Log.v(CYCLE_RECOVERY, "onRestoreInstanceState: restaurando dados do ciclo PDM");
    }

    //etapas do ciclo para visualização no console
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(CYCLE_RECOVERY, "onStart: iniciando cliclo visivel");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CYCLE_RECOVERY, "onResume: iniciando cliclo foreground");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(CYCLE_RECOVERY, "onPause: finalizando ciclo foreground");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CYCLE_RECOVERY, "onStop: finalizando ciclo visivel");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v(CYCLE_RECOVERY, "onRestar: iniciando chamada para ciclo visivel");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(CYCLE_RECOVERY, "onDestroy: finalizando ciclo/aplicacao");
    }


}