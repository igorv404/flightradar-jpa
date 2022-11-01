package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Flight;
import io.igorv404.flightradarbackjpa.models.Pilot;
import io.igorv404.flightradarbackjpa.models.Plane;
import io.igorv404.flightradarbackjpa.models.Terminal;
import io.igorv404.flightradarbackjpa.repositories.FlightRepository;
import io.igorv404.flightradarbackjpa.repositories.PilotRepository;
import io.igorv404.flightradarbackjpa.repositories.PlaneRepository;
import io.igorv404.flightradarbackjpa.repositories.TerminalRepository;
import io.igorv404.flightradarbackjpa.services.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
  private final FlightRepository flightRepository;
  private final PlaneRepository planeRepository;
  private final PilotRepository pilotRepository;
  private final TerminalRepository terminalRepository;

  public FlightServiceImpl(FlightRepository flightRepository, PlaneRepository planeRepository, PilotRepository pilotRepository, TerminalRepository terminalRepository) {
    this.flightRepository = flightRepository;
    this.planeRepository = planeRepository;
    this.pilotRepository = pilotRepository;
    this.terminalRepository = terminalRepository;
  }

  @Override
  public Flight create(Flight entity, Integer pilotId, Integer planeId, Integer startTerminalId, Integer endTerminalId) {
    Pilot pilot = this.pilotRepository.findById(pilotId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Plane plane = this.planeRepository.findById(planeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Terminal startTerminal = this.terminalRepository.findById(startTerminalId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Terminal endTerminal = this.terminalRepository.findById(endTerminalId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    entity.setPilotId(pilot);
    entity.setPlaneId(plane);
    entity.setStartTerminal(startTerminal);
    entity.setEndTerminal(endTerminal);
    return this.flightRepository.save(entity);
  }

  @Override
  public List<Flight> getAll() {
    return this.flightRepository.findAll();
  }

  @Override
  public Flight getById(Integer id) {
    return this.flightRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Flight update(Integer id, Flight entity) {
    Flight updatedEntity = this.flightRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setPilotId(entity.getPilotId());
    updatedEntity.setPlaneId(entity.getPlaneId());
    updatedEntity.setStartTerminal(entity.getStartTerminal());
    updatedEntity.setEndTerminal(entity.getEndTerminal());
    updatedEntity.setData(entity.getData());
    updatedEntity.setTime(entity.getTime());
    updatedEntity.setPrice(entity.getPrice());
    return this.flightRepository.save(updatedEntity);
  }

  @Override
  public String delete(Integer id) {
    this.flightRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
