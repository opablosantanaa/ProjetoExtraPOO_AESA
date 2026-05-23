package br.com.programa.exe.entidades;

public class Pessoa extends Base{
    private String telefone;

    public String getTelefone() {

        if (telefone.length() == 11) {
            return "(" + telefone.substring(0,2) + ") " + telefone.substring(2,11);
        } else if (telefone.trim().length() == 13) {
            return telefone;
        }else {
                telefone = null;
                return "Telefone inválido!";
            }
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa(String nome, String telefone, String cep){
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCep(cep);
    }

    public Pessoa(){
    }
}
