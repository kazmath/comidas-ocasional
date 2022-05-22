package interfaces.entidades;

import entidades.Endereco;

public interface IEndereco {
    public void addEndereco(Endereco endereco);

    public Endereco getEndereco(int index);

    public void setEndereco(int index, Endereco endereco);

    public void deleteEndereco(int index);

    public String getRua();

    public void setRua(String newRua);

    public String getNumCasa();

    public void setNumCasa(String newNumCasa);

    public String getBairro();

    public void setBairro(String newBairro);

    public String getCidade();

    public void setCidade(String newCidade);
}