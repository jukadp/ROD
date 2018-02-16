/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.inter;

import com.model.AktualizacjaDanych;
import java.util.List;

public interface InterAktualizacjaDanych {

 List<AktualizacjaDanych> getAll(); 
  AktualizacjaDanych getById(Long id);
 void add(AktualizacjaDanych aktualizacjaDanych); 
 void delete(Long id); 
 void update(AktualizacjaDanych aktualizacjaDanych);
}
