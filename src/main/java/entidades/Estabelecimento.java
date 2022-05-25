package entidades;

import java.util.HashMap;
import java.util.ArrayList;

public class Estabelecimento {
    String nome;
    String cnpj;
    boolean aberto;
    ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    HashMap<String, Integer> menu;

    public Estabelecimento(
            String nome,
            String cnpj,
            boolean aberto,
            HashMap<String, Integer> menu) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.aberto = aberto;
        this.menu = menu;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean getAberto() {
        return this.aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Endereco getEndereco(int index) {
        return this.enderecos.get(index);
    }

    public void setEndereco(int index, Endereco endereco) {
        this.enderecos.set(index, endereco);
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void deleteEndereco(int index) {
        this.enderecos.remove(index);
    }

    public HashMap<String, Integer> getMenu() {
        return this.menu;
    }

    public void setMenu(HashMap<String, Integer> menu) {
        this.menu = menu;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
