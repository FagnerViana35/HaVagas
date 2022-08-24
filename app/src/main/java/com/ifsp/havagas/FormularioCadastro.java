package com.ifsp.havagas;

public class FormularioCadastro {

    private String opcaoTelefone;
    private String numeroCelular;
    private String nomeCompleto;
    private String email;
    private Boolean receberEmails = false;
    private String numeroTelefone;
    private String sexoPessoa;
    private String data;
    private String anoFormatura;
    private String anoConclusao;
    private String instituicao;
    private String tituloMonografia;
    private String orientador;
    private String formacao;
    private String vagasInteresse;

    public FormularioCadastro() {
    }

    public FormularioCadastro(String nome, String email, Boolean receberEmails, String numeroTelefone, String opcaoTelefone, String numeroCelular, String sexoPessoa, String data, String formacao, String vagasInteresse,
                              String anoForatura) {
        this.nomeCompleto = nome;
        this.email = email;
        this.receberEmails = receberEmails;
        this.numeroTelefone = numeroTelefone;
        this.opcaoTelefone = opcaoTelefone;
        this.numeroCelular = numeroCelular;
        this.sexoPessoa = sexoPessoa;
        this.data = data;
        this.formacao = formacao;
        this.vagasInteresse = vagasInteresse;
        this.anoFormatura = anoForatura;
    }

    public FormularioCadastro(String nome, String email, Boolean receberEmails, String numeroTelefone, String opcaoTelefone, String numeroCelular, String sexoPessoa, String data, String formacao, String vagasInteresse,
                              String anoConcl, String instituicao, String tituloMonografia, String orientador) {
        this.nomeCompleto = nome;
        this.email = email;
        this.receberEmails = receberEmails;
        this.numeroTelefone = numeroTelefone;
        this.opcaoTelefone = opcaoTelefone;
        this.numeroCelular = numeroCelular;
        this.sexoPessoa = sexoPessoa;
        this.data = data;
        this.instituicao = instituicao;
        this.tituloMonografia = tituloMonografia;
        this.orientador = orientador;
        this.formacao = formacao;
        this.vagasInteresse = vagasInteresse;
        this.anoConclusao = anoConcl;

    }

    public FormularioCadastro(String nome, String email, Boolean receberEmails, String telefone, String opcaoTelefone, String numeroCelular, String sexoPessoa, String data, String formacao, String vagasInteresse,
                              String anoConcl, String instituicao) {
        this.nomeCompleto = nome;
        this.email = email;
        this.receberEmails = receberEmails;
        this.numeroTelefone = telefone;
        this.opcaoTelefone = opcaoTelefone;
        this.numeroCelular = numeroCelular;
        this.sexoPessoa = sexoPessoa;
        this.data = data;
        this.formacao = formacao;
        this.vagasInteresse = vagasInteresse;
        this.anoConclusao = anoConcl;
        this.instituicao = instituicao;
    }


    public String getOpcaoTelefone() {
        return opcaoTelefone;
    }

    public void setOpcaoTelefone(String opcaoTelefone) {
        this.opcaoTelefone = opcaoTelefone;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getReceberEmails() {
        return receberEmails;
    }

    public void setReceberEmails(Boolean receberEmails) {
        this.receberEmails = receberEmails;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getSexoPessoa() {
        return sexoPessoa;
    }

    public void setSexoPessoa(String sexoPessoa) {
        this.sexoPessoa = sexoPessoa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAnoFormatura() {
        return anoFormatura;
    }

    public void setAnoFormatura(String anoFormatura) {
        this.anoFormatura = anoFormatura;
    }

    public String getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(String anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getVagasInteresse() {
        return vagasInteresse;
    }

    public void setVagasInteresse(String vagasInteresse) {
        this.vagasInteresse = vagasInteresse;
    }

    @Override
    public String toString() {
        return "FormularioCadastro{" +
                "opcaoTelefone='" + opcaoTelefone + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", receberEmails=" + receberEmails +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                ", sexoPessoa='" + sexoPessoa + '\'' +
                ", data='" + data + '\'' +
                ", anoFormatura='" + anoFormatura + '\'' +
                ", anoConclusao='" + anoConclusao + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", tituloMonografia='" + tituloMonografia + '\'' +
                ", orientador='" + orientador + '\'' +
                ", formacao='" + formacao + '\'' +
                ", vagasInteresse='" + vagasInteresse + '\'' +
                '}';
    }
}
