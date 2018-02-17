package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.OdczytLicznika;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.AdminLicznikiService;

@RestController
public class AdminLicznikiRest {
	
	@Autowired
	private AdminLicznikiService adminLicznikiService;
	
	@RequestMapping(path="/admin_liczniki/get", method=RequestMethod.GET)
	public Iterable<OdczytLicznika> getAllDzialkowicz(){
        
            
		return adminLicznikiService.getAllAdmin_zarz_liczniki();
	}
    @RequestMapping(value = "/admin_liczniki/get/{id}", method = RequestMethod.GET)
	public OdczytLicznika getDzialkowiczById(@PathVariable("id") long id){
		return adminLicznikiService.getAdmin_zarz_licznikiById(id);
	}


         
        @RequestMapping(value = "/admin_liczniki/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public OdczytLicznika save(@RequestBody OdczytLicznika liczniki){
 
  
 
     return  adminLicznikiService.saveAdmin_zarz_liczniki(liczniki);
 
}
 @RequestMapping(value = "/admin_liczniki/update",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public OdczytLicznika update(@RequestBody OdczytLicznika liczniki){

     return  adminLicznikiService.saveAdmin_zarz_liczniki(liczniki);
    

}
        @RequestMapping(value ="/admin_liczniki/delete", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void  delete(@RequestParam("id")  String id){
        this.adminLicznikiService.deleteAdmin_zarz_liczniki(Long.parseLong(id));
    }
}


