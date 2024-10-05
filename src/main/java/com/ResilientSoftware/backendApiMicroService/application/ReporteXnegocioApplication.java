package com.ResilientSoftware.backendApiMicroService.application;

import com.ResilientSoftware.backendApiMicroService.Dto.ReporteTicketsDto;
import com.ResilientSoftware.backendApiMicroService.Dto.TiposTicketsDto;
import com.ResilientSoftware.backendApiMicroService.entities.mongo.negocioX.ReporteTicketsNegocioX;
import com.ResilientSoftware.backendApiMicroService.entities.mongo.negocioX.TiposTicket;
import com.ResilientSoftware.backendApiMicroService.repository.ReporteTicketsRepository;
import com.ResilientSoftware.backendApiMicroService.repository.TiposTicketsRepository;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Utils.Constants;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
public class ReporteXnegocioApplication {

    @Autowired
    private ReporteTicketsRepository reporteTicketsRepository;

    @Autowired
    private TiposTicketsRepository tiposTicketsRepository;

    /**
     * Metodo para obtener el reporte de tipos de tickets por rango de fechas
     * @param fechaInicio parámetro para filtrar por fecha de creacióm
     * @param fechaFin parámetro para filtrar por fecha de actualización
     * @return Lista de reporte de tickets
     */

    public List<ReporteTicketsDto>obtenerReporteTicketsPorFecha(
            String fechaInicio,
            String fechaFin,
            List<String> tipoTicket) {

        List<ReporteTicketsDto> reporteTicketsDtoList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormat.forPattern(Constants.FORMATO_YYYY_MM_DD);
        LocalDateTime inicio = formatter.parseLocalDateTime(fechaInicio);
        LocalDateTime fin = formatter.parseLocalDateTime(fechaFin);

        Date fechaInicioValue = inicio.withTime(0,0,0,0).toDate();
        Date fechaFinValue = fin.withTime(23,59,59,999).toDate();

        List<ReporteTicketsNegocioX> listaTickets;

        if(!tipoTicket.isEmpty()){
            listaTickets = this.reporteTicketsRepository.findByTicketsContainingAndCreatedAtBetweenOrderByCreatedAtDesc(tipoTicket, fechaInicioValue, fechaFinValue);
        } else {
            listaTickets = this.reporteTicketsRepository.findByCreatedAtBetweenOrderByCreatedAtDesc(fechaInicioValue, fechaFinValue);
        }

        if (listaTickets.isEmpty()) {
           return reporteTicketsDtoList;
        }

        for (int index = 0; index < listaTickets.size(); index++){

            String fechadeCreacion = "";

            ReporteTicketsNegocioX listaReporteTickets = listaTickets.get(index);

            fechadeCreacion = new LocalDateTime(listaReporteTickets.getCreatedAt()).toString("dd/MM/yyyy HH:mm:ss");

            String listaSeparadaComas = listaReporteTickets.getTickets().toString();

            listaSeparadaComas = listaSeparadaComas.replace("[","")
                    .replace("]","").replace(" "," ");

            ReporteTicketsDto reporteTicketsDto = new ReporteTicketsDto();

            reporteTicketsDto.setCelular(listaReporteTickets.getCelular());
            reporteTicketsDto.setNumTrabajador(listaReporteTickets.getNumTrabajador());
            reporteTicketsDto.setNombre(listaReporteTickets.getNombre());
            reporteTicketsDto.setNumUsuario(listaReporteTickets.getNumUsuario());
            reporteTicketsDto.setSucursal(listaReporteTickets.getSucursal());
            reporteTicketsDto.setNombreAbreviado(listaReporteTickets.getNombreAbreviado());
            reporteTicketsDto.setNombreTecnico(listaReporteTickets.getNombreTecnico());
            reporteTicketsDto.setEmailTecnico(listaReporteTickets.getEmailTecnico());
            reporteTicketsDto.setTickets(listaSeparadaComas);
            reporteTicketsDto.setCreatedAt(fechadeCreacion);
            reporteTicketsDto.setPuntosAtención(listaReporteTickets.getPuntosAtención());

            reporteTicketsDtoList.add(reporteTicketsDto);
        }
        return reporteTicketsDtoList;
    }

    /**
     * Método para obtener los tipos de tickets
     * return lista de tipos de tickets
     */

    public List<TiposTicketsDto> getAllTiposTickets() {

        List<TiposTicketsDto> tiposTicketsDtoList = new ArrayList<>();

        List<TiposTicket> listaTipoTickets = this.tiposTicketsRepository.findAllByOrderByNombreTicketAsc();

        if (listaTipoTickets.isEmpty()) {
            return tiposTicketsDtoList;
        }

        for (int index = 0; index < listaTipoTickets.size(); index++){

            TiposTicket listadoTiposTicket = listaTipoTickets.get(index);

            TiposTicketsDto tiposTicketsDto = new TiposTicketsDto();

            tiposTicketsDto.setNombreTicket(listadoTiposTicket.getNombreTicket());
            tiposTicketsDto.setTipoTicket(listadoTiposTicket.getTipoTicket());
            tiposTicketsDto.setEstatus(listadoTiposTicket.getEstatus());

            tiposTicketsDtoList.add(tiposTicketsDto);
        }
        return tiposTicketsDtoList;
    }
}
