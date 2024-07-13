package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;
import br.com.nomeempresa.restaurante.ports.in.IPaymentServicePort;
import br.com.nomeempresa.restaurante.ports.out.IGeneratedPaymentPort;
import br.com.nomeempresa.restaurante.ports.out.ISavePaymentPort;

import java.util.List;

public class PaymentService implements IPaymentServicePort {


    private final ISavePaymentPort iSavePaymentPort;

    private final IGeneratedPaymentPort iGeneratedPaymentPort;

    public PaymentService(ISavePaymentPort iSavePaymentPort, IGeneratedPaymentPort iGeneratedPaymentPort) {
        this.iSavePaymentPort = iSavePaymentPort;
        this.iGeneratedPaymentPort = iGeneratedPaymentPort;
    }

    @Override
    public Payment generatedPayment(Payment request) {
        StatusPayment status = this.iGeneratedPaymentPort.generatedPayment(request);

        return request;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return iSavePaymentPort.updatePayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return iSavePaymentPort.getPayment(id);
    }

    @Override
    public StatusPayment getStatusPayment(Long id) {
        return iSavePaymentPort.getStatusPayment(id);
    }

    @Override
    public List<Payment> getListPayments() {
        return iSavePaymentPort.getListPayments();
    }
}
