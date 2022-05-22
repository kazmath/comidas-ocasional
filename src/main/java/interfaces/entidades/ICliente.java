package interfaces.entidades;

import entidades.Cadastro;
import entidades.Cliente;
import entidades.Endereco;

public interface ICliente {
    public void addCliente(Cliente cliente);

    public Cliente getCliente(int index);

    public void setCliente(int index, Cliente cliente);

    public void deleteCliente(int index);

    public Cadastro getCadastro();

    public void setCadastro(Cadastro cadastro);

    public void addEndereco(Endereco endereco);

    public Endereco getEndereco(int index);

    public void setEndereco(int index, Endereco endereco);

    public void deleteEndereco(int index);
}