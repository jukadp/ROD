package com.model.inter;

import com.model.Wlasciciel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public interface InterWlasciciel {

 List<Wlasciciel> getAll(); 
  Wlasciciel getById(Long id);
 void add(Wlasciciel dzialkowicz); 
 void delete(Long id); 
 void update(Wlasciciel dzialkowicz);
}
