package com.utp;

import static com.utp.parser.XlsParser.readFromExcelAndSaveToDatabase;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {
   
    @RequestMapping(value={"/","/home"})
        public String home(){
            return "home";
        }
   
  
    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }
   
     @RequestMapping(value="/admin_uzytkownicy")
    public String admin_uzytkownicy(){
        return "admin_uzytkownicy";
    }
         @RequestMapping(value="/admin_dzialki")
    public String admin_dzialki(){
        return "admin_dzialki";
    }
         @RequestMapping(value="/admin_liczniki")
    public String admin_liczniki(){
        return "admin_liczniki";
    }
         @RequestMapping(value="/admin_dokumenty")
    public String admin_dokumenty(){
        return "admin_dokumenty";
    }
         
         @PostMapping("/migration")
         public String handleFileUpload(@RequestParam("file") MultipartFile file,
                 RedirectAttributes redirectAttributes) throws IOException, Exception {
             readFromExcelAndSaveToDatabase((FileInputStream) file.getInputStream());
                   return "admin_dokumenty";  
         }
         
         @RequestMapping(value="/admin_wyciagi")
    public String admin_wyciagi(){
        return "admin_wyciagi";
    }
         @RequestMapping(value="/admin_raport")
    public String admin_raport(){
        return "admin_raport";
    }
        
    
     @RequestMapping(value="/user")
    public String user(){
        return "user";
    }

      @RequestMapping(value="/user_Rozrachunki")
    public String user_Rozrachunki(){
        return "user_Rozrachunki";
    }
       @RequestMapping(value="/user_Zobowiazania")
    public String user_Zobowiazania(){
        return "user_Zobowiazania";
    }
     
       @RequestMapping(value="/user_bank")
    public String user_bank(){
        return "user_bank";
    }
       @RequestMapping(value="/user_licznik")
    public String user_licznik(){
        return "user_licznik";
    }
    
          @RequestMapping(value="/user_ustawienia")
    public String user_ustawienia(){
        return "user_ustawienia";
    }
  
    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }
   

   
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}