package com.example.demo.service;




import com.example.demo.dao.VolsRepository;
import com.example.demo.entities.Achatbillet;
import com.example.demo.entities.Vols;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class VolService {
    @Autowired
    VolsRepository volRepository;

    String pattern = "dd/MM/yyyy";
    String dateInString =new SimpleDateFormat(pattern).format(new Date());

    public List<Vols> VolDuJour(String d){

        try{
            List<Vols> vols= volRepository.findByDateDuvol(dateInString);
            return vols;
        }catch(Exception e){throw e;}
    }
    public List<Vols> allvol(){
        return volRepository.findAll();
    }
    public Vols addvol(Vols vol){
        return volRepository.save(vol);
    }
    public Vols updatevol(Vols vol){
        return volRepository.save(vol);
    }
   public String deletevol(String id){
      Vols  vol= findvol(id);
         volRepository.delete(vol);
         return "vol deleted";

    }
   public Vols findvol(String id){
       return volRepository.findByNumeroDuVol(id);
   }

   public List<Vols> findvol1 (String id) {
        List<Vols> flights = new ArrayList<>();
        flights.add(volRepository.findByNumeroDuVol(id));
       return flights;
   }


    public List<Vols> volaller(Achatbillet achatbillet){

        try{
           // System.out.println(volRepository.findByDateDuvol(achatbillet.getVoldepart()));
            System.out.println(achatbillet.getVoldepart());
            List<Vols> vols1= volRepository.findByDateDuvol(achatbillet.getVoldepart());
            System.out.println(vols1);
            List<Vols> vol= new ArrayList<>();
            for (Vols v :vols1){
                System.out.println(v.getEscaleDepart());
                boolean depart= achatbillet.getDepart().equals(v.getEscaleDepart());
                boolean dest= achatbillet.getDestination().equals(v.getEscaleArrive());
                System.out.println(achatbillet.getDepart());

                System.out.println(depart);
                if(depart==true&dest==true){
                    vol.add(v);
                }
            }
            System.out.println(vol);
            return vol;
        }catch(Exception e){throw e;}
    }
    public List<Vols> volretour(Achatbillet achatbillet){

        try{
            List<Vols> vols= volRepository.findByDateDuvol(achatbillet.getVolretour());
            List<Vols> vol= new ArrayList<>();
            for (Vols v :vols){
                boolean depart=  achatbillet.getDestination().equals(v.getEscaleDepart());
                boolean dest= achatbillet.getDepart().equals(v.getEscaleArrive());
                System.out.println(achatbillet.getDepart());

                System.out.println(depart);
                if(depart==true&dest==true){

                    vol.add(v);
                }
            }
            System.out.println("vol"+vol);
            return vol;
        }catch(Exception e){throw e;}
    }
}
