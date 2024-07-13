package br.com.nomeempresa.restaurante.adapters.inbound.response.payment;

import br.com.nomeempresa.restaurante.adapters.inbound.response.payment.transaction.PointOfInteraction;
import br.com.nomeempresa.restaurante.adapters.outbound.enums.StatusGeneratedPayment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {

    private StatusGeneratedPayment status;

    @JsonProperty("point_of_interaction")
    private PointOfInteraction pointOfInteraction;

    @JsonProperty("status_detail")
    private String statusDetail;

}
