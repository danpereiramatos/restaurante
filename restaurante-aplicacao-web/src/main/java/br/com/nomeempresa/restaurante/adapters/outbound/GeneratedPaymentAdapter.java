package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.response.payment.PaymentResponse;
import br.com.nomeempresa.restaurante.adapters.outbound.enums.StatusGeneratedPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;
import br.com.nomeempresa.restaurante.exception.GeneratedPaymentException;
import br.com.nomeempresa.restaurante.ports.out.IGeneratedPaymentPort;
import br.com.nomeempresa.restaurante.adapters.inbound.client.MercadoPagoClient;
import feign.FeignException;

public class GeneratedPaymentAdapter implements IGeneratedPaymentPort {

    private final MercadoPagoClient client;

    public GeneratedPaymentAdapter(MercadoPagoClient client) {
        this.client = client;
    }

    @Override
    public StatusPayment generatedPayment(Payment payment) {

        try {
            PaymentResponse reponse = client.createPayment(payment);
            if (!reponse.getStatus().equals(StatusGeneratedPayment.pending)) {
                throw new GeneratedPaymentException(payment.getId() + " - "+ StatusPayment.FAILED_GENERATED_PAYMENT);
            }
            return StatusPayment.WAITING_PAYMENT;
        } catch (FeignException exception) {
            return StatusPayment.FAILED_GENERATED_PAYMENT;
        }
    }

}
