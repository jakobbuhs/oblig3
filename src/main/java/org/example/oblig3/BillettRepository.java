package org.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billett innBillett){
        String sql = "INSERT INTO Billett(fornavn, etternavn, filmer, antall, nummer, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql,innBillett.getFornavn(),innBillett.getEtternavn(),innBillett.getFilmer(),innBillett.getAntall(),
                innBillett.getNummer(),innBillett.getEpost());

    }
    public List<Billett> hentAlleBilletter(){
        String sql = "SELECT * FROM Billett";
        List<Billett> alleKunder = db.query(sql,new BeanPropertyRowMapper(Billett.class));
        return alleKunder;
    }

    public void slettAlleBilletter(){
        String sql = "DELETE FROM Billeter";
        db.update(sql);
    }
}
