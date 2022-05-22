import org.hibernate.Transaction;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Hasta {

    // POJO Class

    // 1- variables

    // idCounter i db den en sonki id olarak cekelim


    @Id
    private int hasta_id;
    @Column
    private String hasta_isim;
    @Column
    private String hasta_soyisim;
    @Column
    private char hasta_cinsiyet;
    @Column
    private String hasta_kanGrubu;
    @Column
    private Date hasta_dogumTarihi;
    @Column
    private String hasta_adres;
    @Column
    private String hasta_email;
    @Column
    private String hasta_telefon;
    @Column
    private int hasta_statu;

    // 2- constructors


    public Hasta(int hasta_id, String hasta_isim, String hasta_soyisim, char hasta_cinsiyet, String hasta_kanGrubu, Date hasta_dogumTarihi, String hasta_adres, String hasta_email, String hasta_telefon, int hasta_statu) {
        this.hasta_id = hasta_id;
        this.hasta_isim = hasta_isim;
        this.hasta_soyisim = hasta_soyisim;
        this.hasta_cinsiyet = hasta_cinsiyet;
        this.hasta_kanGrubu = hasta_kanGrubu;
        this.hasta_dogumTarihi = hasta_dogumTarihi;
        this.hasta_adres = hasta_adres;
        this.hasta_email = hasta_email;
        this.hasta_telefon = hasta_telefon;
        this.hasta_statu = hasta_statu;
    }


    public Hasta() {

    }


    // 3- getter setter


    public  int getHasta_id() {
        return hasta_id;
    }

    public  void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getHasta_isim() {
        return hasta_isim;
    }

    public void setHasta_isim(String hasta_isim) {
        this.hasta_isim = hasta_isim;
    }

    public String getHasta_soyisim() {
        return hasta_soyisim;
    }

    public void setHasta_soyisim(String hasta_soyisim) {
        this.hasta_soyisim = hasta_soyisim;
    }

    public char getHasta_cinsiyet() {
        return hasta_cinsiyet;
    }

    public void setHasta_cinsiyet(char hasta_cinsiyet) {
        this.hasta_cinsiyet = hasta_cinsiyet;
    }

    public String getHasta_kanGrubu() {
        return hasta_kanGrubu;
    }

    public void setHasta_kanGrubu(String hasta_kanGrubu) {
        this.hasta_kanGrubu = hasta_kanGrubu;
    }

    public Date getHasta_dogumTarihi() {
        return hasta_dogumTarihi;
    }

    public void setHasta_dogumTarihi(Date hasta_dogumTarihi) {
        this.hasta_dogumTarihi = hasta_dogumTarihi;
    }

    public String getHasta_adres() {
        return hasta_adres;
    }

    public void setHasta_adres(String hasta_adres) {
        this.hasta_adres = hasta_adres;
    }

    public String getHasta_email() {
        return hasta_email;
    }

    public void setHasta_email(String hasta_email) {
        this.hasta_email = hasta_email;
    }

    public String getHasta_telefon() {
        return hasta_telefon;
    }

    public void setHasta_telefon(String hasta_telefon) {
        this.hasta_telefon = hasta_telefon;
    }

    public int getHasta_statu() {
        return hasta_statu;
    }

    public void setHasta_statu(int hasta_statu) {
        this.hasta_statu = hasta_statu;
    }



    // 4- toString()


    @Override
    public String toString() {
        return "Hasta Bilgileri : " +
                "hasta_id='" + hasta_id + "\n" +
                ", hasya_isim='" + hasta_isim + "\n" +
                ", hasya_soyisim='" + hasta_soyisim + "\n" +
                ", hasta_cinsiyet=" + hasta_cinsiyet +"\n"+
                ", hasta_kanGrubu='" + hasta_kanGrubu +"\n"+
                ", hasta_dogumTarihi=" + hasta_dogumTarihi +"\n"+
                ", hasta_adres='" + hasta_adres +"\n"+
                ", hasta_email='" + hasta_email +"\n"+
                ", hasta_telefon='" + hasta_telefon +"\n"+
                ", hasta_statu=" + hasta_statu +"";
    }
}
