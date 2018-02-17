package com.model.inter;

import com.model.KontoUzytkownika;
import java.util.List;

public interface InterKontoUzytkownika {

 List<KontoUzytkownika> getAll(); 
  KontoUzytkownika getById(Long id);
   KontoUzytkownika getByLogin(String login);
 void add(KontoUzytkownika dostep); 
 void delete(Long id); 
 void update(KontoUzytkownika dostep);
}
