package com.ResilientSoftware.backendApiMicroService.entities.mongo.negocioX;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Data
@Document(value = "reportesTickets")
public class ReporteTicketsNegocioX {
    @Id
    @Column(name = "_id")
    private String id;
    private String celular;
    private String numTrabajador;
    private String nombre;
    private String numUsuario;
    private String sucursal;
    private String nombreAbreviado;
    private String nombreTecnico;
    private String emailTecnico;
    private ArrayList<String> tickets;
    private String puntosAtención;
    private Date createdAt;
    private Date updateAt;
}