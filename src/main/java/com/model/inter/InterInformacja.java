package com.model.inter;

import com.model.Informacja;
import java.util.List;

public interface InterInformacja {

 List<Informacja> getAll(); 
  Informacja getById(Long id);
 void add(Informacja informacja); 
 void delete(Long id); 
 void update(Informacja informacja);
}
