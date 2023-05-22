package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ClienteTest {

    @Test
    void deveNotificarCliente() {
        Pedido pedido1 = new Pedido(1, "Camiseta");
        Cliente cliente1 = new Cliente("João");
        cliente1.fazerPedido(pedido1);

        // Aguardando Pagamento
        pedido1.definirStatusPedido("Aguardando Pagamento");
        pedido1.definirDataEntrega(new Date());
        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Aguardando Pagamento'}", cliente1.getUltimaNotificacao());

        // Pagamento Realizado
        pedido1.definirStatusPedido("Pagamento Realizado");
        pedido1.definirDataEntrega(new Date());
        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Pagamento Realizado'}", cliente1.getUltimaNotificacao());

        // Nota Fiscal Emitida
        pedido1.definirStatusPedido("Nota Fiscal Emitida");
        pedido1.definirDataEntrega(new Date());
        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Nota Fiscal Emitida'}", cliente1.getUltimaNotificacao());

        // Pedido Enviado Para Transportadora
        pedido1.definirStatusPedido("Pedido Enviado Para Transportadora");
        pedido1.definirDataEntrega(new Date());
        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Pedido Enviado Para Transportadora'}", cliente1.getUltimaNotificacao());

        // Produto em Trânsito
        pedido1.definirStatusPedido("Produto em Trânsito");
        pedido1.definirDataEntrega(new Date());
        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Produto em Trânsito'}", cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido pedido1 = new Pedido(1, "Camiseta");
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente ("Cliente 2");
        cliente1.fazerPedido(pedido1);
        cliente2.fazerPedido(pedido1);

        pedido1.definirStatusPedido("Aguardando Pagamento");
        pedido1.definirDataEntrega(new Date());
        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Aguardando Pagamento'}", cliente1.getUltimaNotificacao());

        Assertions.assertEquals("Cliente: João, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Aguardando Pagamento'}", cliente1.getUltimaNotificacao());
        Assertions.assertEquals("Cliente: Cliente 2, Pedido: Pedido{numeroPedido=1, descricao='Camiseta', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Aguardando Pagamento'}", cliente2.getUltimaNotificacao());

    }
    @Test
    void naoDeveNotificarCliente(){
        Pedido pedido1 = new Pedido(1, "Pedido Criado");
        Cliente cliente1 = new Cliente("Cliente 1");
        pedido1.definirStatusPedido("Nota Fiscal Emitida");
        assertEquals(null, cliente1.getUltimaNotificacao());
    }
    @Test
    void deveNotificarClientePedido1() {
        Pedido pedido1 = new Pedido(1, "Pedido Criado 1");
        Pedido pedido2 = new Pedido(2, "Pedido Criado 2");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.fazerPedido(pedido1);
        cliente2.fazerPedido(pedido2);

        pedido1.definirStatusPedido("Em Trânsito");
        pedido1.definirDataEntrega(new Date());

        Assertions.assertEquals("Cliente: Cliente 1, Pedido: Pedido{numeroPedido=1, descricao='Pedido Criado 1', dataAtualizacaoStatus=" + new Date() + ", statusPedido='Em Trânsito'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }

}