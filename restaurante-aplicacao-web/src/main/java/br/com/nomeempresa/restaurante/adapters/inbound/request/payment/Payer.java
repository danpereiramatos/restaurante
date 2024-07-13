package br.com.nomeempresa.restaurante.adapters.inbound.request.payment;

public class Payer {

    private String email;
    private Identification identification;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

}
