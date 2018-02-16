package com.model.inter;

import com.model.Zobowiazania;
import java.util.List;

public interface InterZobowiazania {

 List<Zobowiazania> getAll(); 
  Zobowiazania getById(Long id);
 void add(Zobowiazania zobowiazania); 
 void delete(Long id); 
 void update(Zobowiazania zobowiazania);
}
