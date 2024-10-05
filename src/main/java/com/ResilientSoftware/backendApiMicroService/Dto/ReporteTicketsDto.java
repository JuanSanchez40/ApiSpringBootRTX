package com.ResilientSoftware.backendApiMicroService.Dto;

import lombok.Data;

@Data
public class ReporteTicketsDto {
    private String celular;
    private String numTrabajador;
    private String nombre;
    private String numUsuario;
    private String sucursal;
    private String nombreAbreviado;
    private String nombreTecnico;
    private String emailTecnico;
    private String tickets;
    private String createdAt;
    private String puntosAtención;
}