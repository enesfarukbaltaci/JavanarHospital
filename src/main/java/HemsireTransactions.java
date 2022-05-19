import java.sql.*;
import java.util.Scanner;

public class HemsireTransactions implements Transactions {

    static Scanner scan = new Scanner(System.in);

    @Override
    public void add() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        Hemsire hemsire = new Hemsire();
        System.out.print("Hemsire ismini giriniz : ");
        hemsire.setAd(scan.nextLine());

        System.out.print("Hemsire soyismini giriniz : ");
        hemsire.setSoyad(scan.nextLine());

        System.out.print("Hemsire dogum tarihini giriniz : ");
        hemsire.setDogumT(scan.nextLine());

        System.out.print("Hemsire maasini giriniz : ");
        hemsire.setMaas(scan.nextInt());

        st.executeUpdate("insert into hemsire values (" + hemsire+")");


    }

    @Override
    public void read() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();
        ResultSet veri =  st.executeQuery("select * from hemsire");
        System.out.printf("%-6s %-15.15s %-8s %-8s , %-8s\n","id", "Hemsire Isim","Hemsire Soyisim","Dogum Tarihi","Maas");
        System.out.println("====== ============== ========  ======= ============== ======== ");

        while(veri.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s %-8d\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4),veri.getInt(5));
        }

    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        read();
        // TODO Kullanicidan hangi veriyi guncellemek istediginin numarasini al index ata switch/case calis
        System.out.print("Lutfen degisiklik yapmak istediginiz Hemsire ID'sini giriniz : ");
        int hemsireID = scan.nextInt();
        System.out.println("1-Hemsire Ismi\n2-Hemsire Soyisim\n3-Hemsire Tarihi\n4-Maas" +
                "\nLutfen menuden degisiklik yapmak istediginiz bilgiyi seciniz : ");
        int degisiklikIndex = scan.nextInt();
        scan.nextLine();
        switch (degisiklikIndex){
            case 1 :
                String ad="ad";
                hemsireIsimDegistir(ad, hemsireID);
                break;
            case 2 :
                String soyad="soyad";
                hemsireIsimDegistir(soyad,hemsireID);
                break;
            case 3 :
                String dT="dT";
                hemsireIsimDegistir(dT, hemsireID);
                break;
            case 4 :
                hemsireMaasDegistir(hemsireID);
                break;
            default:
                System.out.println("Salak salak gonusma be");
        }
    }

    private void hemsireMaasDegistir(int hemsireID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();
        ResultSet hemsireVeri = st.executeQuery("select * from hemsire where id="+hemsireID);
        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
        System.out.println("Hemsirenin guncel maasini giriniz : ");
        int yeniMaas = scan.nextInt();
        st.executeUpdate("update hemsire set maas='"+yeniMaas +"' where id="+hemsireID);
        read();
    }


    private void hemsireIsimDegistir(String column, int hemsireID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();
        // ResultSet doktorVeri = st.executeQuery("select * from Doktorlar where id="+doktorID);
        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
        System.out.println("Yeni hemsire" +column+ "giriniz : ");
        String yenideger = scan.nextLine();
        st.executeUpdate("update hemsire set "+column+"='"+yenideger +"' where id="+hemsireID);
        read();
    }

    @Override
    public void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();
        read();
        System.out.print("Silmek istediginiz hemsirenin ID sini giriniz : ");
        int input = scan.nextInt();
        st.executeUpdate("delete from hemsire where id="+input);
    }
}
