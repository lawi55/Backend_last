package com.example.demo.service;


import com.example.demo.dao.FidelysRepository;
import com.example.demo.dao.MouvementRepository;
import com.example.demo.entities.AppUserRole;
import com.example.demo.entities.Fidelys;
import com.example.demo.entities.Mouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class FidelysService {
    @Autowired
    private FidelysRepository fidelysRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
    @Autowired
    EmailSenderService emailSenderService;

    public int loginFidelys(Fidelys fidelys) {


        Optional<Fidelys> fidelys2
                = fidelysRepository.findByEmail(fidelys.getEmail());
        System.out.println(fidelys.getEmail() + "   " + fidelys.getPassword());

        boolean match = encoder.matches(fidelys.getPassword(), fidelys2.get().getPassword());
        System.out.println(match);
        if (match == true) {
            String test = fidelys2.get().getFirstname();
            System.out.println(test);

            return fidelys2.get().getId();

        } else {
            System.out.println("le");
            return 00;
        }


    }


    // @EventListener(ApplicationReadyEvent.class)
    public int sign(Fidelys fidelys) throws NoSuchProviderException {

        String res = "reponse";

        boolean test = fidelysRepository.existsByEmailAndPassword(fidelys.getEmail(), fidelys.getPassword());
        if (test) {
            res = "this fidelys already existsssssssss";

        } else {
            System.out.println(fidelys.getEmail());
            String message = "Bonjour\n" +
                    "Merci d’avoir adhérer à notre programme de fidélité Fidelys\n" +
                    "Votre identifiant est :" + fidelys.getId();
            //  emailSenderService.sendSimpleEmail(fidelys.getEmail(),message);
            if (fidelys.getFonction() == null) {
                fidelys.setFonction("---");
            }
            if (fidelys.getSociete() == null) {
                fidelys.setSociete("---");
            }
            fidelys.setAppUserRole(AppUserRole.user);
            fidelys.setStatus("Classique");

            fidelys.setCard("assets/images/classic.png");
            String passwordencoder = encoder.encode(fidelys.getPassword());
            fidelys.setPassword(passwordencoder);
            fidelys.setSolde(3000);
            fidelys.setBanner("assets/images/bannerclassic.png");
            fidelys.setSoldequa(0);
            fidelysRepository.save(fidelys);


            res = "check your mail";


        }
        System.out.println(fidelys.getAdresse());


        return fidelys.getId();

    }

    public List<Fidelys> getfidelys(int id) {
        List list = fidelysRepository.findById(id);
        System.out.println(id);
        return list;

    }

    public Fidelys updatepassword(int id, String password, String oldpassword) throws Exception {
        List<Fidelys> list = fidelysRepository.findById(id);
        System.out.println(list.get(0).getEmail() + "weeeeee");
        boolean test = encoder.matches(oldpassword, list.get(0).getPassword());
        System.out.println(test);
        System.out.println(id);
        if (test == true) {
            String password1 = encoder.encode(password);
            list.get(0).setPassword(password1);
            fidelysRepository.save(list.get(0));
            return (list.get(0));
        } else {
            throw new Exception("password incorrect");
        }


    }

    public Fidelys updateprenom(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setSecondname(fidelys.getSecondname());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatenom(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setFirstname(fidelys.getFirstname());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updateemail(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setEmail(fidelys.getEmail());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatesexe(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setSexe(fidelys.getSexe());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatetel(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setTel(fidelys.getTel());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatecin(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setCin(fidelys.getCin());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatedate(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setBirthdaydate(fidelys.getBirthdaydate());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatenat(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setNationalite(fidelys.getNationalite());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatefon(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setFonction(fidelys.getFonction());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public Fidelys updatesoc(Fidelys fidelys) {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        list.get(0).setSociete(fidelys.getSociete());
        fidelysRepository.save(list.get(0));
        return (list.get(0));


    }

    public List<Fidelys> getAll() {
        return fidelysRepository.findAll();
    }

    public Fidelys UpdateFidelys(Fidelys fidelys) {
        List<Fidelys> fid = fidelysRepository.findById(fidelys.getId());

        fid.get(0).setStatus(fidelys.getStatus());
        fidelysRepository.save(fid.get(0));
        return fid.get(0);

    }

    public Fidelys deleteFidelys(int id) {
        return fidelysRepository.deleteFidelysById(id);

    }

    public Fidelys find(int id) {
        Fidelys fidelys;
        List<Fidelys> fid = fidelysRepository.findById(id);
        fidelys = fid.get(0);
        return fidelys;
    }

    public long Testersolde(Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getId());
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        if (list.get(0).getSolde() < fidelys.getSolde()) {
            throw new Exception("Votre solde est insuffisant");

        } else {
            System.out.println(fidelys.getSolde() * 1 / 2);
            return fidelys.getSolde() * 1 / 2;
        }

    }

    @Autowired
    MouvementRepository mouvementRepository;
    String pattern = "dd/MM/yyyy";
    String dateInString = new SimpleDateFormat(pattern).format(new Date());

    public String convertir(Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getId());
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail());
        long mq = Testersolde(fidelys);
        list.get(0).setSolde(list.get(0).getSolde() - fidelys.getSolde());
        list.get(0).setSoldequa((list.get(0).getSoldequa() + mq));
        Mouvement m = new Mouvement("Convertir Miles", 0, (int) fidelys.getSolde(), fidelys.getId(), dateInString, (int) mq);
        fidelysRepository.save(list.get(0));
        mouvementRepository.save(m);
        System.out.println("conversion effectuée");
        return "conversion effectuée";
    }

    public String payment(Fidelys fidelys) throws Exception {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        list.get(0).setSolde(list.get(0).getSolde() - fidelys.getSolde());
        Mouvement m = new Mouvement("Achat Billet Prime", 0, (int) fidelys.getSolde(), fidelys.getId(), dateInString, 0);
        fidelysRepository.save(list.get(0));
        mouvementRepository.save(m);
        return "achat effectuée";
    }

    public String achatMiles(Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getSolde());
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        list.get(0).setSolde(list.get(0).getSolde() + fidelys.getSolde());
        Mouvement m = new Mouvement("Achat Miles Prime", (int) fidelys.getSolde(), 0, fidelys.getId(), dateInString, 0);
        fidelysRepository.save(list.get(0));
        mouvementRepository.save(m);
        return "achat effectuée";
    }

    public String achatMilesQ(Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getSolde());
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        list.get(0).setSoldequa(list.get(0).getSoldequa() + fidelys.getSolde());
        Mouvement m = new Mouvement("Achat Miles Status", 0, 0, fidelys.getId(), dateInString, (int) fidelys.getSolde());
        fidelysRepository.save(list.get(0));
        mouvementRepository.save(m);
        return "achat effectuée";
    }

    public String upstatus (Fidelys fidelys) throws Exception {
        System.out.println(fidelys.getId());
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        list.get(0).getFirstname();
        if (list.get(0).getSoldequa() >= 20000) {
        list.get(0).setBanner("assets/images/bannersilver.png");
        list.get(0).setStatus("Silver");
        list.get(0).setCard("assets/images/silver.png");
            fidelysRepository.save(list.get(0));
        }
        if (list.get(0).getSoldequa() >= 40000) {
        list.get(0).setBanner("assets/images/bannergold.png");
        list.get(0).setStatus("Gold");
        list.get(0).setCard("assets/images/gold.png");
            fidelysRepository.save(list.get(0));
        }
        fidelysRepository.save(list.get(0));
        return"Congrats";

    }}



