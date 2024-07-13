package br.com.nomeempresa.restaurante.adapters.inbound.controllers;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.payment.PaymentRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;
import br.com.nomeempresa.restaurante.ports.in.IPaymentServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final IPaymentServicePort iPaymentServicePort;

    private final ConversorRequestDominio converter;

    @PostMapping("generate-payment")
    public Payment generatePayment(@RequestBody @Valid PaymentRequest request) {
        return iPaymentServicePort.generatedPayment(converter.converterPaymentParaDominio(request));
    }

    @GetMapping("findById/{id}")
    public Payment getPayment(@PathVariable(name = "id",required = false) Long id) {
        return iPaymentServicePort.getPayment(id);
    }

    @GetMapping("list-payments")
    public List<Payment> getListPayments() {
        return iPaymentServicePort.getListPayments();
    }

    @GetMapping("status/{id}")
    public StatusPayment getStatusPayment(@PathVariable(name = "id",required = false) Long id) {
        return iPaymentServicePort.getStatusPayment(id);
    }

}
