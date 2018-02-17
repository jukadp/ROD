package com.model.inter;

import com.model.Wyciagi;
import java.util.List;

public interface InterWyciagi {

 List<Wyciagi> getAll(); 
  Wyciagi getById(Long id);
 void add(Wyciagi wyciagiJs); 
 void delete(Long id); 
 void update(Wyciagi wyciagiJs);
}
