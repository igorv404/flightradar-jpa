package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "company", collectionRelation = "companies")
public class CompanyDTO extends RepresentationModel<CompanyDTO> {
  private final String name;
  private final String countryName;
  private final Integer countOfPlane;
}
