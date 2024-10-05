package com.ResilientSoftware.backendApiMicroService.repository;

import com.ResilientSoftware.backendApiMicroService.entities.mongo.negocioX.ReporteTicketsNegocioX;
import org.apache.catalina.LifecycleState;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface ReporteTicketsRepository extends MongoRepository<ReporteTicketsNegocioX, ObjectId> {

    List<ReporteTicketsNegocioX> findByCreatedAtBetweenOrderByCreatedAtDesc(Date fechaInicio, Date fechaFin);

    List<ReporteTicketsNegocioX> findByTicketsContainingAndCreatedAtBetweenOrderByCreatedAtDesc(List<String> tipoTicket,
                                                                                               Date fechaInicio,
                                                                                               Date fechaFin);
}
