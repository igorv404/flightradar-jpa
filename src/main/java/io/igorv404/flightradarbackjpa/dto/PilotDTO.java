package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "pilot", collectionRelation = "pilots")
public class PilotDTO extends RepresentationModel<PilotDTO> {
  private final Integer id;
  private final String name;
  private final String surname;
  private final Integer age;
  private final Integer flightExperience;
}
