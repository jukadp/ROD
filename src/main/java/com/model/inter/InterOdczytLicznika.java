package com.model.inter;

import com.model.OdczytLicznika;
import java.util.List;

public interface InterOdczytLicznika {

 List<OdczytLicznika> getAll(); 
  OdczytLicznika getById(Long id);
 void add(OdczytLicznika odczytLicznika); 
 void delete(Long id); 
 void update(OdczytLicznika odczytLicznika);
}
