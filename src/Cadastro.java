public class Cadastro {
    String login;
    String cpf;
    String email;
    String senha;

    public Cadastro ( String login, String cpf, String email, String senha ) {
        this.login = login;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void changeSenha(String senha) {
        this.senha = senha;
    }
    
    
}