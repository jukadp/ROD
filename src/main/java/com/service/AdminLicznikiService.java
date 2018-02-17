package com.service;

import java.util.List;

import com.model.OdczytLicznika;

public interface AdminLicznikiService {
	
	  Iterable<OdczytLicznika> getAllAdmin_zarz_liczniki();
	 OdczytLicznika getAdmin_zarz_licznikiById(long id);
          OdczytLicznika saveAdmin_zarz_liczniki(OdczytLicznika odczytLicznika);
          void deleteAdmin_zarz_liczniki(long id);
	
}
