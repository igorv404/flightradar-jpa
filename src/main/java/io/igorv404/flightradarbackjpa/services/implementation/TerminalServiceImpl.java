package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Airport;
import io.igorv404.flightradarbackjpa.models.Terminal;
import io.igorv404.flightradarbackjpa.repositories.AirportRepository;
import io.igorv404.flightradarbackjpa.repositories.TerminalRepository;
import io.igorv404.flightradarbackjpa.services.TerminalService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TerminalServiceImpl implements TerminalService {
  private final TerminalRepository terminalRepository;
  private final AirportRepository airportRepository;

  public TerminalServiceImpl(TerminalRepository terminalRepository, AirportRepository airportRepository) {
    this.terminalRepository = terminalRepository;
    this.airportRepository = airportRepository;
  }
  @Override
  public List<Terminal> getAll() {
    return this.terminalRepository.findAll();
  }

  @Override
  public Terminal getById(Integer id) {
    return this.terminalRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Terminal update(Integer id, Terminal entity) {
    Terminal updatedEntity = this.terminalRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setNumber(entity.getNumber());
    updatedEntity.setAirportId(entity.getAirportId());
    return this.terminalRepository.save(entity);
  }

  @Override
  public String delete(Integer id) {
    this.terminalRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }

  @Override
  public Terminal create(Terminal entity, Integer airportId) {
    Airport airport = this.airportRepository.findById(airportId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    entity.setAirportId(airport);
    return this.terminalRepository.save(entity);
  }
}
