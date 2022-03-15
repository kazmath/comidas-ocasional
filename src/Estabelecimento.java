import java.util.HashMap;

public class Estabelecimento {
    String cnpj;
    float[] horarios;
    Endereco endereco;
    HashMap<String,Integer> menu;
    String nome;

    public Estabelecimento(
        String nome
        String cnpj,
        float[] horarios,
        Endereco endereco,
        HashMap<String,Integer> menu
    ) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.horarios = horarios;
        this.endereco = endereco;
        this.menu = menu;
    }
}
