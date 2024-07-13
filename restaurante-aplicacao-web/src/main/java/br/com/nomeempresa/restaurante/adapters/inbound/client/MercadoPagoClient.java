package br.com.nomeempresa.restaurante.adapters.inbound.client;

import br.com.nomeempresa.restaurante.adapters.inbound.client.interceptor.MercadoPagoInterceptor;
import br.com.nomeempresa.restaurante.adapters.inbound.response.payment.PaymentResponse;
import br.com.nomeempresa.restaurante.core.domain.entities.payment.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mercadoPagoClient", url = "https://api.mercadopago.com/v1/payments", configuration = {MercadoPagoInterceptor.class})
public interface MercadoPagoClient {

    @PostMapping
    PaymentResponse createPayment(@RequestBody Payment paymentRequest);

}
