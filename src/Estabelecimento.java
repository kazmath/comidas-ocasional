import java.util.HashMap;
import java.util.Calendar;

public class Estabelecimento {
    String cnpj;
    Calendar abertura;
    Calendar fechamento;
    Endereco endereco;
    HashMap<String, Integer> menu;
    String nome;

    public Estabelecimento(
            String nome,
            String cnpj,
            Calendar abertura,
            Calendar fechamento,
            Endereco endereco,
            HashMap<String, Integer> menu) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.endereco = endereco;
        this.menu = menu;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Calendar getAbertura() {
        return this.abertura;
    }

    public void setAbertura(Calendar abertura) {
        this.abertura = abertura;
    }

    public Calendar getFechamento() {
        return this.fechamento;
    }

    public void setFechamento(Calendar fechamento) {
        this.fechamento = fechamento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
