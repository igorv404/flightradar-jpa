package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Time;
import java.util.Date;

@Builder
@Getter
@Relation(itemRelation = "flight", collectionRelation = "flights")
public class FlightDTO extends RepresentationModel<FlightDTO> {
  private final Integer id;
  private final Integer pilotId;
  private final Integer planeId;
  private final Integer startTerminal;
  private final Integer endTerminal;
  private final Date data;
  private final Time time;
  private final Integer price;
}
