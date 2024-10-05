package com.ResilientSoftware.backendApiMicroService.repository;

import com.ResilientSoftware.backendApiMicroService.entities.mongo.negocioX.TiposTicket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiposTicketsRepository extends MongoRepository<TiposTicket, ObjectId> {
    @Aggregation(pipeline =  {
            "{ '$project': { 'nombreTicket': 1, 'insensitive': {$toLower: '$nombreTicket'}, 'tipoTicket': '$tipoTicket', 'estatus': '$estatus'}}",
            "{ '$sort': { 'insensitive': 1 } }",
    })
    List<TiposTicket> findAllByOrderByNombreTicketAsc();
}
