
package com.model.inter;

import com.model.Naleznosc;
import java.util.List;

public interface InterNaleznosc {

 List<Naleznosc> getAll(); 
  Naleznosc getById(Long id);
 void add(Naleznosc zobowiazania); 
 void delete(Long id); 
 void update(Naleznosc zobowiazania);
}
