package com.model.inter;

import com.model.Dostep;
import java.util.List;

public interface InterDostep {

 List<Dostep> getAll(); 
  Dostep getById(Long id);
   Dostep getByLogin(String login);
 void add(Dostep dostep); 
 void delete(Long id); 
 void update(Dostep dostep);
}
