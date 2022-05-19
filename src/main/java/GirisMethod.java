import javax.print.Doc;
import java.sql.SQLException;
import java.util.Scanner;

public class GirisMethod {

    DoctorTransactions doctorTransactions = new DoctorTransactions();

    public void anaMenu() throws SQLException, ClassNotFoundException {
        System.out.println("JAVANAR HOSPITALE HOSGELDINIZ\n" +
                "LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ\n" +
                "1-)DOKTOR EKLE\n2-)DOKTORLARI LISTELE\n3-)DOKTOR BILGILERINI GUNCELLE\n4-)DOKTOR SIL\n5-)HASTA EKLE");

        int input = secenekKadarGirisAl(5);

        switch (input) {
            case 1: doctorTransactions.add();
                break;
            case 2 : doctorTransactions.read();
                break;
            case 3 : doctorTransactions.update();
                break;
            case 4 : doctorTransactions.delete();
                break;
            case 5 : Hasta.hastaEkle();
                break;
            default:
                System.out.println("kaybol");
        }

    }


    public int secenekKadarGirisAl(int i) {
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scan.next());  //integer giris yapilana kadar while
                if(input>0&&input<=i) {
                    break;
                }
                else throw new Exception();

            }catch (Exception e ){
                System.out.println("Hatali giris yaptiniz lutfen tekrar giris yapiniz");
            }
        }
        return input;
    }

}
