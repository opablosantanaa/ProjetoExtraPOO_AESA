package br.com.programa.exe.entidades;
import java.util.Date;

public class Base {
    private String nome;
    private int id;
    private String cep;
    private Status status = Status.ACTIVE;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep.length() == 8) {
            this.cep = cep;
        } else{
            this.cep = "00000-000";
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
