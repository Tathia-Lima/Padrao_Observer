package observer;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;
    private Date dataAtualizacaoStatus;
    private String statusPedido;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public Date getDataEntrega() {
        return this.dataAtualizacaoStatus;
    }

    public String getStatusPedido() {
        return this.statusPedido;
    }

    public void fazerPedido(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        if (pedido instanceof Pedido) {
            Pedido p = (Pedido) pedido;
            this.ultimaNotificacao = "Cliente: " + this.nome + ", Pedido: " + p.toString();
            this.dataAtualizacaoStatus = p.getDataEntrega();
            this.statusPedido = p.getStatusPedido();
            // System.out.println(this.ultimaNotificacao);
        }
    }
}