package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorPagamentoDominioEntidade;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.PaymentRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;
import br.com.nomeempresa.restaurante.ports.out.ISavePaymentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class SavePaymentAdapter implements ISavePaymentPort {

    private final PaymentRepository paymentRepository;

    private final ConversorPagamentoDominioEntidade pagamentoDominioEntidade;

    private static final List<Payment> payments = new ArrayList<>();


    @Override
    public Payment savedPayment(Payment payment) {
        paymentRepository.save(pagamentoDominioEntidade.converterParaDominio(payment));

        return payment;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return recoverDataPayment(payment.getId());
    }

    @Override
    public Payment getPayment(Long id) {
        return recoverDataPayment(id);
    }

    @Override
    public StatusPayment getStatusPayment(Long id) {
        return null;
    }

    @Override
    public List<Payment> getListPayments() {
        return payments;
    }

    private Payment recoverDataPayment(Long id) {

        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Payment not found with id: " + id));

    }
}
