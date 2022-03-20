import java.util.HashMap;
import java.util.Calendar;

public class Estabelecimento {
    String cnpj;
    Calendar abertura;
    Calendar fechamento;
    Endereco endereco;
    HashMap<String,Integer> menu;
    String nome;

    public Estabelecimento(
        String nome,
        String cnpj,
        Calendar abertura,
        Calendar fechamento,
        Endereco endereco,
        HashMap<String,Integer> menu
    ) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.endereco = endereco;
        this.menu = menu;
    }
}
