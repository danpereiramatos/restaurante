package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.PaymentEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class ConversorPagamentoDominioEntidade {

    private final ConversorProdutoDominioEntidade conversorProdutoDominioEntidade;

    public ConversorPagamentoDominioEntidade(ConversorProdutoDominioEntidade conversorProdutoDominioEntidade) {
        this.conversorProdutoDominioEntidade = conversorProdutoDominioEntidade;
    }

    public PaymentEntity converterParaDominio(Payment payment){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(payment.getId());
        paymentEntity.setAmount(payment.getTransactionAmount());
        paymentEntity.setPayer(payment.getPayer().getEmail());
        paymentEntity.setStatus(StatusPayment.WAITING_PAYMENT.name());
        paymentEntity.setProduct(new ProdutoEntity());
        paymentEntity.setDate(payment.getDate().toLocalDate());


        return paymentEntity;
    }

}
