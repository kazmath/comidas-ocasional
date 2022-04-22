package interfaces.entidades;

public interface ICadastro {
    public void getEmail();
    
    public void setEmail();
    
    public void getLogin();

    public void setLogin(String login);

    public void getSenha();

    public void setSenha(String senha);

    public void changeSenha(String senha);
}
