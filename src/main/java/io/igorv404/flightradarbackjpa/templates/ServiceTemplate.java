package io.igorv404.flightradarbackjpa.templates;

import java.util.List;

public interface ServiceTemplate<T, ID>{
  List<T> getAll();

  T getById(ID id);

  T update(ID id, T entity);

  String delete(ID id);
}
