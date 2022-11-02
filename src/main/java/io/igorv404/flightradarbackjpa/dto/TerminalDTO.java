package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "terminal", collectionRelation = "terminals")
public class TerminalDTO extends RepresentationModel<TerminalDTO> {
  private final Integer id;
  private final Integer number;
  private final Integer airportId;
}
