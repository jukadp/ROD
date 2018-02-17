package com.model.inter;

import com.model.NumerRachunku;
import java.util.List;

public interface InterNumerRachunku {

 List<NumerRachunku> getAll(); 
  NumerRachunku getById(int id);
 void add(NumerRachunku iban); 
 void delete(Long id); 
 void update(NumerRachunku iban);
}
