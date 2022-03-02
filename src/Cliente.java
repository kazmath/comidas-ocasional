public class Cliente {
    String nome;
    String numero;
    String email;
    String cpf;
    Endereco endereco;

    public Cliente(
        String nome,
        String numero,
        String email,
        String cpf
    ) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.cpf = cpf;
    }
}
