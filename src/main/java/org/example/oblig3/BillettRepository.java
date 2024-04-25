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
        String sql = "INSERT INTO Billett(filmer, antall, fornavn, etternavn, nummer, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql,innBillett.getFilmer(), innBillett.getAntall(),innBillett.getFornavn(),innBillett.getEtternavn(),
                innBillett.getNummer(),innBillett.getEpost());

    }
    public List<Billett> hentAlleBilletter(){
        String sql = "SELECT * FROM Billett ORDER BY etternavn";
        List<Billett> alleKunder = db.query(sql,new BeanPropertyRowMapper(Billett.class));
        return alleKunder;
    }

    public void slettBilletter(){
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }
    public Billett hentEn(int id) {

        String sql = "SELECT * FROM Billett WHERE id=?";
        Billett billett = db.queryForObject(sql, BeanPropertyRowMapper.newInstance(Billett.class), id);
        return billett;
    }

    public void endreEn(Billett billett){
        String sql = "UPDATE Billett SET filmer=?, antall=?, fornavn=?,etternavn=?, nummer=?, epost=? where id=?";
        db.update(sql, billett.getFilmer(), billett.getAntall(), billett.getFornavn(), billett.getEtternavn(),
                billett.getNummer(), billett.getEpost(), billett.getId());
    }

    public void slettEn(int id) {
        String sql = "DELETE FROM Billett WHERE id=?";
        db.update(sql,id);
    }
}
