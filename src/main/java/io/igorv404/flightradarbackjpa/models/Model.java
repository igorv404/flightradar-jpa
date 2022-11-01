package io.igorv404.flightradarbackjpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
  @Id
  private String name;

  @Column
  private Float length;

  @Column
  private Float wingspan;

  @Column
  private Integer countOfSeats;
}
