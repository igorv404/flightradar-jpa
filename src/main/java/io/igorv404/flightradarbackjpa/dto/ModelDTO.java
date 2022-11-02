package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "model", collectionRelation = "models")
public class ModelDTO extends RepresentationModel<ModelDTO> {
  private final String name;
  private final Float length;
  private final Float wingspan;
  private final Integer countOfSeats;
}
