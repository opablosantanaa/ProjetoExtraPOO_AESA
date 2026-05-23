package br.com.programa.exe.entidades;

public class Servico extends Base {
    private String descricao;
    private double preco;
    private String dataservico;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDataservico() {
        if (dataservico == null){
            return "Data não informada";
        } if (dataservico.length() == 10 && dataservico.contains("/")) {
            return dataservico;
        }
        if (dataservico.length() == 7 || dataservico.length() == 8) {
            return dataservico.substring(0, 2) + "/" + dataservico.substring(2, 4) + "/" + dataservico.substring(4, dataservico.length());
        } return "Data inválida";
    }

    public void setDataservico(String dataservico) {
        this.dataservico = dataservico;
    }

    public Servico(String descricao, double preco, String dataservico) {
        this.descricao = descricao;
        this.preco = preco;
        this.dataservico = dataservico;
    }

    public Servico(){
    }
}
