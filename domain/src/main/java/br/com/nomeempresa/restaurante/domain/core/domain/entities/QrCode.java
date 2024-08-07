package br.com.nomeempresa.restaurante.domain.core.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QrCode {

    @JsonProperty("status")
    private String status;

    @JsonProperty("point_of_interaction")
    private PointOfInteraction pointOfInteraction;


    public String getQrCode() {
        return this.getPointOfInteraction().getTransactionData().getQrCode();
    }

}
