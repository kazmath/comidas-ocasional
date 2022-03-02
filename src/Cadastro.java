public class Cadastro {
    String nome;
    String cpf;
    String email;
    String senha;

    public Cadastro(
        String nome,
        String cpf,
        String email,
        String senha
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void changeSenha(String senha) {
        this.senha = senha;
    }
    
    
}