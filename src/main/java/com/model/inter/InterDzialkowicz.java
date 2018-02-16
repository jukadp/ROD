package com.model.inter;

import com.model.Dzialkowicz;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public interface InterDzialkowicz {

 List<Dzialkowicz> getAll(); 
  Dzialkowicz getById(Long id);
 void add(Dzialkowicz dzialkowicz); 
 void delete(Long id); 
 void update(Dzialkowicz dzialkowicz);
}
