public class Cliente {
    Cadastro cadastro;
    Endereco endereco;

    public Cliente(
            Cadastro cadastro,
            Endereco endereco) {
        this.cadastro = cadastro;
        this.endereco = endereco;
    }

    public Cadastro getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
