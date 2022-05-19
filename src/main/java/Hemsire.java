
public class Hemsire{

    private int id;
    private String ad;
    private String soyad;
    private String dogumT;
    private int maas;



    Hemsire(){}


    Hemsire(int id,String ad,String soyad,String dogumT,int maas){
this.ad = ad;
this. soyad = soyad;
this. dogumT = dogumT;
this. maas = maas;
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
                        "," + maas
                ;
    }
}
