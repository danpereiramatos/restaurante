package br.com.nomeempresa.restaurante.domain.core.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointOfInteraction {

    @JsonProperty("transaction_data")
    private TransactionData transactionData;

}
