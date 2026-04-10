package com.hotel.reservation.facade;

import com.hotel.reservation.dto.ReservaDTO;
import com.hotel.reservation.dto.ReservaResponseDTO;
import com.hotel.reservation.enums.EstadoHabitacion;
import com.hotel.reservation.enums.EstadoReserva;
import com.hotel.reservation.exception.BadRequestException;
import com.hotel.reservation.model.Habitacion;
import com.hotel.reservation.model.Reserva;
import com.hotel.reservation.model.ServicioAdicional;
import com.hotel.reservation.repository.ReservaRepository;
import com.hotel.reservation.service.AccesoService;
import com.hotel.reservation.service.FacturacionService;
import com.hotel.reservation.service.HabitacionService;
import com.hotel.reservation.service.ServicioAdicionalService;
import com.hotel.reservation.service.TarifaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelFacade {

    private final HabitacionService habitacionService;
    private final TarifaService tarifaService;
    private final ServicioAdicionalService servicioAdicionalService;
    private final FacturacionService facturacionService;
    private final AccesoService accesoService;
    private final ReservaRepository reservaRepository;

    public HotelFacade(HabitacionService habitacionService, TarifaService tarifaService,
                       ServicioAdicionalService servicioAdicionalService, FacturacionService facturacionService,
                       AccesoService accesoService, ReservaRepository reservaRepository) {
        this.habitacionService = habitacionService;
        this.tarifaService = tarifaService;
        this.servicioAdicionalService = servicioAdicionalService;
        this.facturacionService = facturacionService;
        this.accesoService = accesoService;
        this.reservaRepository = reservaRepository;
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionService.obtenerTodas();
    }

    public ReservaResponseDTO crearReserva(ReservaDTO reservaDTO) {
        Habitacion habitacion = habitacionService.obtenerPorId(reservaDTO.getHabitacionId());
        if (habitacion.getEstado() != EstadoHabitacion.DISPONIBLE) {
            throw new BadRequestException("La habitacion no esta disponible para reserva.");
        }

        List<ServicioAdicional> servicios = servicioAdicionalService.crearServicios(reservaDTO.getServicios());

        Reserva reserva = new Reserva();
        reserva.setHabitacionId(reservaDTO.getHabitacionId());
        reserva.setHuespedId(reservaDTO.getHuespedId());
        reserva.setFechaEntrada(reservaDTO.getFechaEntrada());
        reserva.setFechaSalida(reservaDTO.getFechaSalida());
        reserva.setEstado(EstadoReserva.CREADA);
        reserva.setServicios(servicios);

        // TODO: Validar disponibilidad por rango de fechas y politicas de cancelacion.
        Reserva reservaGuardada = reservaRepository.save(reserva);

        habitacionService.actualizarEstado(habitacion.getId(), EstadoHabitacion.RESERVADA);

        double tarifaBase = tarifaService.calcularTarifaBase(reservaDTO);
        double costoServicios = servicioAdicionalService.calcularCostoTotal(servicios);
        double subtotal = tarifaBase + costoServicios;

        facturacionService.generarFactura(reservaGuardada, subtotal);
        accesoService.generarLlaveDigital(reservaGuardada);

        return new ReservaResponseDTO(
                reservaGuardada.getId(),
                reservaGuardada.getEstado(),
                subtotal,
                "Reserva creada exitosamente"
        );
    }
}

