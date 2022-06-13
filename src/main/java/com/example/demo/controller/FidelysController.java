package com.example.demo.controller;


import com.example.demo.entities.ChangePasswordModel;
import com.example.demo.entities.Fidelys;
import com.example.demo.entities.Vols;
import com.example.demo.entities.billet;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.FidelysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.NoSuchProviderException;
import java.util.List;

@RestController
public class FidelysController {
    Fidelys fidelys;
    List<Fidelys> Fid;
    @Autowired
    private FidelysService fidelysService;
   /* @Autowired
    private FidelysRepository fidelysRepository;
    @PostMapping("/register")
    public Fidelys Register(@RequestBody Fidelys fidelys){
        return  fidelysRepository.save(fidelys);
    }

    @PostMapping("/login")
    public Fidelys Login(@RequestBody Fidelys fidelys){
        Fidelys oldFidelys =FidelysRepository.findByEmailAndPassword(fidelys.getEmail(), fidelys.getPassword());
        return oldFidelys;
    }*/



@Autowired
EmailSenderService emailSenderService;
    @RequestMapping("/welcome")
    public String welcomepage() {
        return "Welcome to back";
    }

    Fidelys fidelys1= new Fidelys();


    @PostMapping("/register")
    public long Register(@RequestBody Fidelys fidelys) throws NoSuchProviderException {
        System.out.println(fidelysService.sign(fidelys));
        System.out.println(fidelys.getEmail() + "   " + fidelys.getPassword() + "    " + fidelys.getFirstname());


        return fidelysService.sign(fidelys);
    }

    @PostMapping("/login1")
    public long Login(@RequestBody Fidelys fidelys) {
        System.out.println(fidelys.getEmail());

        System.out.println(fidelysService.loginFidelys(fidelys));


        return fidelysService.loginFidelys(fidelys);

    }



    @PostMapping("/getfidelys")
    public List<Fidelys> getfidelys(@RequestBody Fidelys fidelys) {


         Fid=fidelysService.getfidelys(fidelys.getId());
        System.out.println(Fid.get(0).getEmail() );


        return Fid;

    }
    @PostMapping("/setpassword")
    public Fidelys modifierPassword(@RequestBody ChangePasswordModel changePasswordModel) throws Exception {

        return fidelysService.updatepassword(changePasswordModel.getId(), changePasswordModel.getPassword(), changePasswordModel.getOldpassword());

    }

    @PostMapping("/setprenom")
    public Fidelys modifierprenom(@RequestBody Fidelys fidelys) {

        return fidelysService.updateprenom(fidelys);

    }



    @PostMapping("/setnom")
    public Fidelys modifiernom(@RequestBody Fidelys fidelys) {

        return fidelysService.updatenom(fidelys);

    }
    @PostMapping("/setdate")
    public Fidelys modifierdate(@RequestBody Fidelys fidelys) {

        return fidelysService.updatedate(fidelys);

    }
    @PostMapping("/setnat")
    public Fidelys modifiernat(@RequestBody Fidelys fidelys) {

        return fidelysService.updatenat(fidelys);

    }
    @PostMapping("/setsoc")
    public Fidelys modifiersoc(@RequestBody Fidelys fidelys) {

        return fidelysService.updatesoc(fidelys);

    }
    @PostMapping("/setsexe")
    public Fidelys modifiersexe(@RequestBody Fidelys fidelys) {

        return fidelysService.updatesexe(fidelys);

    }
    @PostMapping("/setfn")
    public Fidelys modifierfn(@RequestBody Fidelys fidelys) {

        return fidelysService.updatefon(fidelys);

    }
    @PostMapping("/settel")
    public Fidelys modifiertel(@RequestBody Fidelys fidelys) {

        return fidelysService.updatetel(fidelys);

    }
    @PostMapping("/setmail")
    public Fidelys modifiermail(@RequestBody Fidelys fidelys) {

        return fidelysService.updateemail(fidelys);

    }
    @PostMapping("/setcin")
    public Fidelys modifiercin(@RequestBody Fidelys fidelys) {

        return fidelysService.updatecin(fidelys);

    }

    @RequestMapping ("/getall")
    public ResponseEntity<List<Fidelys>> getallF(){
        List<Fidelys> fidelysList = fidelysService.getAll();
        return new ResponseEntity<>(fidelysList, HttpStatus.OK);
    }

    @PostMapping ("/deletefidelys")
    public Fidelys delete(@RequestBody int id) {

        return fidelysService.deleteFidelys(id);

    }
    @PostMapping("/updatefidelys")
    public Fidelys update(@RequestBody Fidelys fidelys) {

        return fidelysService.UpdateFidelys(fidelys);

    }
    @PostMapping("/findfidelys")
    public Fidelys find(@RequestBody int id) {

        return fidelysService.find(id);

    }
    @PostMapping("/testersolde")
    public long tester(@RequestBody Fidelys fidelys) throws Exception {

        return fidelysService.Testersolde(fidelys);

    }
    @PostMapping("/convertirsolde")
    public String convertir(@RequestBody Fidelys fidelys) throws Exception {

        return fidelysService.convertir(fidelys);

    }

    @PostMapping("/achatbillet")
    public String achatbillet (@RequestBody Fidelys fidelys) throws Exception {

        return fidelysService.payment(fidelys);


    }

    @PostMapping("/achatmiles")
    public String achatmiles (@RequestBody Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getSolde());
        return fidelysService.achatMiles(fidelys);
    }
    @PostMapping("/achatmilesq")
    public String achatmilesq (@RequestBody Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getSoldequa());
        return fidelysService.achatMilesQ(fidelys);
    }

    @PostMapping("/upstatus")
    public String upstatus (@RequestBody Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getSoldequa());
        return fidelysService.upstatus(fidelys);
    }

}


