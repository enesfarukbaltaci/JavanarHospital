
public class Doctor {

    private int id;
    private String ad;
    private String soyad;
    private String dogumT;
    private String brans;
    private int maas;

    public Doctor() {
    }


    public Doctor(int id, String ad, String soyad, String dogumT, String brans, int maas) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumT = dogumT;
        this.brans = brans;
        this.maas = maas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getDogumT() {
        return dogumT;
    }

    public void setDogumT(String dogumT) {
        this.dogumT = dogumT;
    }

    public String getBrans() {
        return brans;
    }

    public void setBrans(String brans) {
        this.brans = brans;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return
                id +
                        ",'" + ad + '\'' +
                        ",'" + soyad + '\'' +
                        ",'" + dogumT + '\'' +
                        ",'" + brans + '\'' +
                        "," + maas
                ;
    }
}
