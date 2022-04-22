package interfaces.entidades;

import java.util.HashMap;

import entidades.Endereco;

public interface IEstabelecimento {
    public String getCnpj();

    public void setCnpj(String cnpj);

    public int getAbertura();

    public void setAbertura(int abertura);

    public int getFechamento();

    public void setFechamento(int fechamento);

    public Endereco getEndereco(int index);

    public void setEndereco(int index, Endereco endereco);

    public void addEndereco(Endereco endereco);

    public String getNome();

    public void setNome(String nome);

    public HashMap<String, Integer> getMenu();

    public void setMenu(HashMap<String, Integer> menu);
    
}
