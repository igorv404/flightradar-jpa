package io.igorv404.flightradarbackjpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {
  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @Column
  private String surname;

  @Column
  private Integer age;

  @Column
  private Integer flightExperience;
}
