public class Cliente {
    String nome;
    String numero;
    String cpf;
    Endereco endereco;

    public Cliente(
        String nome,
        String numero,
        String cpf,
        Endereco endereco
    ) {
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.endereco = endereco;
    }
}
