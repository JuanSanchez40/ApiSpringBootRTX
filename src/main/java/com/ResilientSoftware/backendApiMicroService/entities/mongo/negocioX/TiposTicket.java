package com.ResilientSoftware.backendApiMicroService.entities.mongo.negocioX;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "tipoTickets")
public class TiposTicket {
    @Id
    @Column(name = "_id")
    private String id;

    private String nombreTicket;

    private String tipoTicket;

    private String estatus;
}
