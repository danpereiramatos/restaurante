package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;

import java.util.List;

public interface IPaymentServicePort {

    Payment generatedPayment(Payment payment);
    Payment updatePayment(Payment payment);
    Payment getPayment(Long id);
    StatusPayment getStatusPayment(Long id);
    List<Payment> getListPayments();

}
