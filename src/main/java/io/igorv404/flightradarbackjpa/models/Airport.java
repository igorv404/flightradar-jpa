package io.igorv404.flightradarbackjpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @ManyToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id")
  private City cityId;
}
