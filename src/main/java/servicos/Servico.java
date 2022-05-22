package servicos;

import entidades.Cliente;
import entidades.Estabelecimento;

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
            boolean retirada) {
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.pagamento = pagamento;
        this.retirada = retirada;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isRetirada() {
        return this.retirada;
    }

    public boolean getRetirada() {
        return this.retirada;
    }

    public void setRetirada(boolean retirada) {
        this.retirada = retirada;
    }
}
