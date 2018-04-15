package br.com.allize.allize.models;

public class Comanda {

    private String nome;
    private String hora;
    private String numComanda;
    private String servico;
    private String telefone;
    private String data;
    private String email;

    public Comanda(){};

    public Comanda(String nome, String hora, String numComanda, String servico, String telefone,
                   String data, String email) {
        this.nome = nome;
        this.hora = hora;
        this.numComanda = numComanda;
        this.servico = servico;
        this.telefone = telefone;
        this.data = data;
        this.email= email;
    }


    public String getNumComanda() {
        return numComanda;
    }

    public void setNumComanda(String numComanda) {
        this.numComanda = numComanda;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
