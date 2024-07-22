package br.com.nomeempresa.restaurante.application.exception;

public class NoInputPresent extends RuntimeException {
    public static final String MESSAGE = "Parametro de entrada é obrigatório";
    public NoInputPresent() {
        super(MESSAGE);
    }
}
