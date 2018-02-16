package com.model.inter;

import com.model.WyciagiJs;
import java.util.List;

public interface InterWyciagiJS {

 List<WyciagiJs> getAll(); 
  WyciagiJs getById(Long id);
 void add(WyciagiJs wyciagiJs); 
 void delete(Long id); 
 void update(WyciagiJs wyciagiJs);
}
