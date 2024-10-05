package com.ResilientSoftware.backendApiMicroService.controllers;

import com.ResilientSoftware.backendApiMicroService.Dto.ReporteTicketsDto;

import com.ResilientSoftware.backendApiMicroService.Dto.TiposTicketsDto;
import com.ResilientSoftware.backendApiMicroService.application.ReporteXnegocioApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("empresa-x-reportes")
public class ReportesdeXnegocioController {

    @Autowired
    private ReporteXnegocioApplication reporteXnegocioApplication;

    /**  Los tickets son los tipos de casos que existen por algun problema de soporte que se debe dar
     * a algun modulo u aplicación que este funcionando de manera incorrecta.


     * Endpoint para obetener el reporte de "tickets" de los colaboradores de una empresa, por rango de fecha
     * @param fechaInicio parametro para filtrar por fecha de creación
     * @return Lista de clientes captados durante cierto periodo de tiempo elegido
     */

    @PostMapping(value = {"obtener-reporte-tickets", "obtener-reporte-tickets/"})
    public List<ReporteTicketsDto>obtenerReporteTicketsPorFecha(@RequestParam String fechaInicio,
                                                           @RequestParam String fechaFin,
                                                           @RequestBody(required = false) List<String> tipoTicket ){
        return reporteXnegocioApplication.obtenerReporteTicketsPorFecha(fechaInicio,fechaFin,tipoTicket);
    }


    /**
     * Endpoint para obtener los tipos de tickets
     * @return Lista de tipos de tickets */

    @GetMapping("tipos-tickets")
    public List<TiposTicketsDto> getAllTiposDeTickets() {
        return reporteXnegocioApplication.getAllTiposTickets();
    }
}
