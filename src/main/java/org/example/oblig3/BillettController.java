package org.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    private BillettRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(@RequestBody Billett billett) {
        rep.lagreBillett(billett);
    }

    @GetMapping("/hentAlle")
    public List<Billett> hentAlle() {
        return rep.hentAlleBilletter();
    }


    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettBilletter();
    }

    @GetMapping("/hentEn")
    public Billett Kinobilett (int id){
        return rep.hentEn(id);
    }
    @PostMapping("/endreEn")
    public void endreEn(Billett billett){
        rep.endreEn(billett);
    }

    @GetMapping("/slettEn")
    public void slettEn(int id){
        rep.slettEn(id);
    }

}

