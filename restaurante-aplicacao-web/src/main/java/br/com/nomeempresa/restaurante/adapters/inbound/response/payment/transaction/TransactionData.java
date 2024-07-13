package br.com.nomeempresa.restaurante.adapters.inbound.response.payment.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionData {

    @JsonProperty("qr_code")
    private String qrCode;

}
