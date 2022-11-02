package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "plane", collectionRelation = "planes")
public class PlaneDTO extends RepresentationModel<PlaneDTO> {
  private final Integer id;
  private final String modelName;
  private final String companyName;
  private final Integer speed;
  private final Integer flightTime;
}
