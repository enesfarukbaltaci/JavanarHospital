import java.sql.*;
import java.util.Scanner;


public class DoctorTransactions extends Connector implements Transactions {


    static Scanner scan = new Scanner(System.in);


    @Override
    public void add() throws ClassNotFoundException, SQLException {
        Statement st = Connector.connectDB().createStatement();
        Doctor doctor = new Doctor();
        System.out.print("Doktor ismini giriniz : ");
        doctor.setAd(scan.nextLine());
        // st.executeUpdate("insert into"+" Doktorlar("+ "ad)"  +" values ("+doctor.getAd()+")");
        System.out.print("Doktor soyismini giriniz : ");
        doctor.setSoyad(scan.nextLine());
        // st.executeUpdate("insert into"+" Doktorlar("+ "soyad)"  +" values ("+doctor.getSoyad()+")");
        System.out.print("Doktor dogum tarihini giriniz : ");
        doctor.setDogumT(scan.nextLine());
        //  st.executeUpdate("insert into"+" Doktorlar("+ "dT)"  +" values ("+doctor.getDogumT()+")");
        System.out.print("Doktor bransini giriniz : ");
        doctor.setBrans(scan.nextLine());
        // st.executeUpdate("insert into"+" Doktorlar("+ "brans)"  +" values ("+doctor.getBrans()+")");
        System.out.print("Doktor maasini giriniz : ");
        doctor.setMaas(scan.nextInt());
        //  st.executeUpdate("insert into"+" Doktorlar("+ "maas)"  +" values ("+doctor.getMaas()+")");
        st.executeUpdate("insert into Doktorlar values (" + doctor + ")");
        //  System.out.println(doctor);

        //    insert into Doktorlar values (doctor);

    }

    // CRUD -- Create Read Update Delete
    @Override
    public void read() throws ClassNotFoundException, SQLException {
        Statement st = Connector.connectDB().createStatement();
        ResultSet veri = st.executeQuery("select * from Doktorlar");
        System.out.printf("%-6s %-15.15s %-8s %-8s %-15s %-8s\n", "id", "Doktor Isim", "Doktor Soyisim", "Dogum Tarihi", "Brans", "Maas");
        System.out.println("====== ============== ========  ======= ============== ======== ");
        while (veri.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s %-15s %-8d\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4), veri.getString(5), veri.getInt(6));
        }

    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        read();
        // TODO Kullanicidan hangi veriyi guncellemek istediginin numarasini al index ata switch/case calis
        System.out.print("Lutfen degisiklik yapmak istediginiz doktorun ID'sini giriniz : ");
        int doktorID = scan.nextInt();
        System.out.print("1-Doktor Ismi\n2-Doktor Soyisim\n3-Dogum Tarihi\n4-Brans\n5-Maas" +
                "\nLutfen menuden degisiklik yapmak istediginiz bilgiyi seciniz : ");
        int degisiklikIndex = scan.nextInt();
        scan.nextLine();
        switch (degisiklikIndex) {
            case 1:
                String ad = "ad";
                doktorIsimDegistir(ad, doktorID);
                break;
            case 2:
                String soyad = "soyad";
                doktorIsimDegistir(soyad, doktorID);
                break;
            case 3:
                String dT = "dT";
                doktorIsimDegistir(dT, doktorID);
                break;
            case 4:
                String brans = "brans";
                doktorIsimDegistir(brans, doktorID);
                break;
            case 5:
                doktorMaasDegistir(doktorID);
                break;

            default:
                System.out.println("Salak salak gonusma be");
        }
    }

    private void doktorMaasDegistir(int doktorID) throws SQLException, ClassNotFoundException {
        Statement st = Connector.connectDB().createStatement();
        ResultSet doktorVeri = st.executeQuery("select * from Doktorlar where id=" + doktorID);
        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
        System.out.print("Doktorun guncel maasini giriniz : ");
        int yeniMaas = scan.nextInt();
        st.executeUpdate("update Doktorlar set maas='" + yeniMaas + "' where id=" + doktorID);
        read();
    }

//    private void doktorBransDegistir(int doktorID) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
//        Statement st = con.createStatement();
//        ResultSet doktorVeri = st.executeQuery("select * from Doktorlar where id=" + doktorID);
//        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
//        System.out.println("Doktorun yeni bransini giriniz : ");
//        String yeniBrans = scan.nextLine();
//        st.executeUpdate("update Doktorlar set brans='" + yeniBrans + "' where id=" + doktorID);
//        read();
//    }

//    private void doktorDTarihiDegistir(int doktorID) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
//        Statement st = con.createStatement();
//        ResultSet doktorVeri = st.executeQuery("select * from Doktorlar where id=" + doktorID);
//        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
//        System.out.println("Yeni doktor dogum tarihini giriniz : ");
//        String yeniDTarihi = scan.nextLine();
//        st.executeUpdate("update Doktorlar set dT='" + yeniDTarihi + "' where id=" + doktorID);
//        read();
//    }

//    private void doktorSoyisimDegistir(int doktorID) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
//        Statement st = con.createStatement();
//        ResultSet doktorVeri = st.executeQuery("select * from Doktorlar where id=" + doktorID);
//        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
//        System.out.println("Yeni doktor soyismini giriniz : ");
//        String yeniSoyIsim = scan.nextLine();
//        st.executeUpdate("update Doktorlar set soyad='" + yeniSoyIsim + "' where id=" + doktorID);
//        read();
//    }

    private void doktorIsimDegistir(String column, int doktorID) throws ClassNotFoundException, SQLException {
        Statement st = Connector.connectDB().createStatement();
        // ResultSet doktorVeri = st.executeQuery("select * from Doktorlar where id="+doktorID);
        // System.out.println("Isim bilgisini degistirmek istediginiz doktor : " + doktorVeri.getString(1));
        System.out.print("Yeni doktor " + column + " giriniz : ");
        String yeniIsim = scan.nextLine();
        st.executeUpdate("update Doktorlar set " + column + "='" + yeniIsim + "' where id=" + doktorID);
        read();
    }

    @Override
    public void delete() throws ClassNotFoundException, SQLException {
        Statement st = Connector.connectDB().createStatement();
        read();
        System.out.print("Silmek istediginiz doktorun ID sini giriniz : ");
        int input = scan.nextInt();
        st.executeUpdate("delete from Doktorlar where id=" + input);

    }
}
