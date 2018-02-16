package com.model.inter;

import com.model.Iban;
import java.util.List;

public interface InterIban {

 List<Iban> getAll(); 
  Iban getById(int id);
 void add(Iban iban); 
 void delete(Long id); 
 void update(Iban iban);
}
