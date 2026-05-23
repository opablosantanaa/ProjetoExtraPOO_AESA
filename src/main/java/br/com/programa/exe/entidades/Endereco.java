package br.com.programa.exe.entidades;

import com.google.gson.annotations.SerializedName;

public class Endereco extends Base{
    @SerializedName("logradouro")
    private String rua;
    private String bairro;
    @SerializedName("localidade")
    private String cidade;
    @SerializedName("uf")
    private String estado;
    private String numeroEnd;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(String numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public Endereco(String cep){
        setCep(cep);
    }
}
