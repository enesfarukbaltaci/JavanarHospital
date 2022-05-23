import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class Connector_hb {


    public static void hastaTablosuVeriGir(Hasta hasta1) throws SQLException, ClassNotFoundException {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hasta.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(hasta1);
        tx.commit();

        session.close();
        sf.close();

        System.out.println("Veri girisi tamamlandi");

    }


    public static int hastaTablosundanIdAl() throws SQLException, ClassNotFoundException {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hasta.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        String HQL_QUERY = "select max(hst.hasta_id) from Hasta hst";
        Query query = null;
        int gonderilecekSayi=0;
        while(true) {
            try {
                query = session.createQuery(HQL_QUERY);
                List results = query.list();
                gonderilecekSayi = (int) results.get(0);
                break;
            } catch (Exception e) {
                // System.out.println("Query Exception Uretti");
                session.close();
                sf.close();
                gonderilecekSayi = 1000;
                break;
            }

        } return gonderilecekSayi;

    };

}




