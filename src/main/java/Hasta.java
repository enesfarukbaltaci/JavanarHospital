import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hasta {

    public static void hastaEkle()throws SQLException, ClassNotFoundException {

        String ad;
        String soyad;
        String dogumT;
        String brans;
        int maas;

        Scanner scan = new Scanner(System.in);
        Statement st = Connector.connectDB().createStatement();

        System.out.println("Doktor Ismi Giriniz");
        ad=scan.nextLine();
        System.out.println("Doktor Soyad Giriniz");
        soyad=scan.nextLine();
        System.out.println("Doktor Dogum Tarihi Giriniz");
        dogumT=scan.nextLine();
        System.out.println("Doktor Brans Giriniz");
        brans=scan.nextLine();
        System.out.println("Doktor maas Giriniz");
        maas=scan.nextInt();

        st.executeUpdate("insert into Doktorlar values (0,'"+ ad + '\'' + ",'" + soyad + '\'' + ",'" + dogumT + '\'' + ",'" + brans + '\'' + "," + maas+" )");













    }

}
