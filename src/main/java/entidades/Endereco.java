package entidades;

public class Endereco {
    private String Rua;
    private String numCasa;
    private String Bairro;
    private String Cidade;

    public Endereco(
            String Rua,
            String numCasa,
            String Bairro,
            String Cidade) {
        this.Rua = Rua;
        this.numCasa = numCasa;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String newRua) {
        this.Rua = newRua;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String newNumCasa) {
        this.numCasa = newNumCasa;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String newBairro) {
        this.Bairro = newBairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String newCidade) {
        this.Cidade = newCidade;
    }

}
