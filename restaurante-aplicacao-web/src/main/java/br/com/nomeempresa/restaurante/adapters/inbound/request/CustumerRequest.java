package br.com.nomeempresa.restaurante.adapters.inbound.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record CustumerRequest(
        Long idUsuario,
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotBlank @Email String email){

}