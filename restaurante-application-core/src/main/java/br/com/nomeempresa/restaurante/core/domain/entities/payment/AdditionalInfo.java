package br.com.nomeempresa.restaurante.core.domain.entities.payment;

import java.util.List;

public class AdditionalInfo {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
