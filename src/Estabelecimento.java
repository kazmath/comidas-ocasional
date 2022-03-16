import java.util.HashMap;
import java.util.Calendar; //TODO: Aprender como a biblioteca calendar.

public class Estabelecimento {
    String cnpj;
    int[][] horarios;
    Endereco endereco;
    HashMap<String,Integer> menu;
    String nome;

    public Estabelecimento(
        String nome,
        String cnpj,
        int[][] horarios,
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
