public class Servico {
    enum Pagamento {
        DINHEIRO,
        PIX,
        CARTAO
    }
    Cliente cliente;
    Estabelecimento estabelecimento;
    Pagamento pagamento;
    boolean retirada;

    public Servico(
        Cliente cliente,
        Estabelecimento estabelecimento,
        Pagamento pagamento,
        boolean retirada
    ) {
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.pagamento = pagamento;
        this.retirada = retirada;
    }
}
