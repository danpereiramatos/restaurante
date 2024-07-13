package br.com.nomeempresa.restaurante.adapters.inbound.response.payment.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointOfInteraction {

    @JsonProperty("transaction_data")
    private TransactionData transactionData;

}
