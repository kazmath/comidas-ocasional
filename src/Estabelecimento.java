import java.util.HashMap;

public class Estabelecimento {
    String cnpj;
    float[] horarios;
    Endereco endereco;
    HashMap<String,Integer> menu;

    public Estabelecimento(
        String cnpj,
        float[] horarios,
        Endereco endereco,
        HashMap<String,Integer> menu
    ) {
        this.cnpj = cnpj;
        this.horarios = horarios;
        this.endereco = endereco;
        this.menu = menu;
    }
}
