package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.TerminalDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.TerminalDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Terminal;
import io.igorv404.flightradarbackjpa.services.TerminalService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terminals")
public class TerminalController {
  private final TerminalService terminalService;
  private final TerminalDTOAssembler terminalDTOAssembler;

  public TerminalController(TerminalService terminalService, TerminalDTOAssembler terminalDTOAssembler) {
    this.terminalService = terminalService;
    this.terminalDTOAssembler = terminalDTOAssembler;
  }

  @GetMapping
  public CollectionModel<TerminalDTO> getAll() {
    List<Terminal> terminals = this.terminalService.getAll();
    return this.terminalDTOAssembler.toCollectionModel(terminals);
  }

  @GetMapping("/{id}")
  public TerminalDTO getById(@PathVariable Integer id) {
    Terminal terminal = this.terminalService.getById(id);
    return this.terminalDTOAssembler.toModel(terminal);
  }

  @PostMapping("/airport/{id}")
  public TerminalDTO create(@RequestBody Terminal entity, @PathVariable Integer id) {
    Terminal terminal = this.terminalService.create(entity, id);
    return this.terminalDTOAssembler.toModel(terminal);
  }

  @PutMapping("/{id}")
  public TerminalDTO update(@PathVariable Integer id, @RequestBody Terminal entity) {
    Terminal terminal = this.terminalService.update(id, entity);
    return this.terminalDTOAssembler.toModel(terminal);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.terminalService.delete(id);
  }
}
