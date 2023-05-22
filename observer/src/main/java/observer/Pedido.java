package observer;

import java.util.Date;
import java.util.Observable;

public class Pedido extends Observable {

    private int numeroPedido;
    private String descricao;
    private Date dataAtualizacaoStatus;
    private String statusPedido;

    public Pedido(int numeroPedido, String descricao) {
        this.numeroPedido = numeroPedido;
        this.descricao = descricao;
    }

    public Date getDataEntrega() {
        return this.dataAtualizacaoStatus;
    }

    public String getStatusPedido() {
        return this.statusPedido;
    }

    public void definirDataEntrega(Date data) {
        this.dataAtualizacaoStatus = data;
        setChanged();
        notifyObservers();
    }

    public void definirStatusPedido(String status) {
        this.statusPedido = status;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", descricao='" + descricao + '\'' +
                ", dataAtualizacaoStatus=" + dataAtualizacaoStatus +
                ", statusPedido='" + statusPedido + '\'' +
                '}';
    }
}