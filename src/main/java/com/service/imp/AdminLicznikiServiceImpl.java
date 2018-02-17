package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.OdczytLicznika;
import com.repo.AdminLicznikiRepo;
import com.service.AdminLicznikiService;


@Service("AdminLicznikiService")
public class AdminLicznikiServiceImpl implements AdminLicznikiService {

	@Autowired
	private AdminLicznikiRepo adminLicznikiRepo;

        
         @Autowired
    public void setContactRepository(AdminLicznikiRepo adminLicznikiRepo) {
        this.adminLicznikiRepo = adminLicznikiRepo;
    }
        
        
	@Override
	public  Iterable<OdczytLicznika> getAllAdmin_zarz_liczniki() {
		return adminLicznikiRepo.findAll();
	}

	@Override
	public OdczytLicznika getAdmin_zarz_licznikiById(long id) {
		return adminLicznikiRepo.findOne(id);
	}
    
    @Override
    public OdczytLicznika saveAdmin_zarz_liczniki(OdczytLicznika liczniki) {
        return this.adminLicznikiRepo.save(liczniki);
    }
    
    @Override
    public void deleteAdmin_zarz_liczniki(long id) {
        this.adminLicznikiRepo.delete(id);
    }

  
}
