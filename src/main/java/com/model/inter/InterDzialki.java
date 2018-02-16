package com.model.inter;

import com.model.Dzialki;
import java.util.List;

public interface InterDzialki {

 List<Dzialki> getAll(); 
  Dzialki getById(Long id);
     Dzialki getByIdDzialkowicz(Long nr_czlonkowski);
 void add(Dzialki dzialki); 
 void delete(Long id); 
 void update(Dzialki dzialki);
}
