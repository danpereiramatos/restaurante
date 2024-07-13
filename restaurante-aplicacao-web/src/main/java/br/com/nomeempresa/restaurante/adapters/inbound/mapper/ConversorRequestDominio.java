package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.request.payment.PaymentRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.produto.ProdutoRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.customer.CustomerRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.*;
import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConversorRequestDominio {

    public Customer convertCustomerToDomain (CustomerRequest customerRequest){
        var customer = new Customer();
        customer.setId(customerRequest.id());
        customer.setName(customerRequest.nome());
        if(customerRequest.cpf() != null){
            customer.setCpf(new CPF(customerRequest.cpf()));
        }
        customer.setEmail(customerRequest.email());
        return customer;
    }

    public Produto converterProdutoParaDominio(ProdutoRequest produtoRequest){
        var produto = new Produto();
        BeanUtils.copyProperties(produtoRequest, produto);
        return produto;
    }

    public Payment converterPaymentParaDominio(PaymentRequest paymentRequest) {
        if (paymentRequest == null) {
            return null;
        }

        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentRequest, payment);

        Payer payer = new Payer();
        BeanUtils.copyProperties(paymentRequest.getPayer(), payer);
        payment.setPayer(payer);

        Identification identification = new Identification();
        BeanUtils.copyProperties(paymentRequest.getPayer().getIdentification(), identification);
        payer.setIdentification(identification);

        AdditionalInfo additionalInfo = new AdditionalInfo();
        BeanUtils.copyProperties(paymentRequest.getAdditionalInfo(), additionalInfo);

        if (paymentRequest.getAdditionalInfo().getItems() != null) {
            List<Item> items = new ArrayList<>();
            for (br.com.nomeempresa.restaurante.adapters.inbound.request.payment.Item itemRequest : paymentRequest.getAdditionalInfo().getItems()) {
                Item item = new Item();
                BeanUtils.copyProperties(itemRequest, item);
                items.add(item);
            }
            additionalInfo.setItems(items);
        }

        payment.setAdditionalInfo(additionalInfo);

        return payment;
    }

}