import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;

public class Estabelecimento implements IEndereco {
    String cnpj;
    Calendar abertura;
    Calendar fechamento;
    ArrayList<Endereco> enderecos;
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
