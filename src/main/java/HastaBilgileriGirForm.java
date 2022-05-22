import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;


public class HastaBilgileriGirForm extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton button1;
    private JLabel statuHata;
    private JButton KAPATButton;


    // hasta1 objesini olusturalim
    Hasta hasta1 = new Hasta();



    public HastaBilgileriGirForm() {

        // hangi panel, boyutlari ne, ve title

        add(panel1);
        setSize(450, 550);
        setTitle("Hasta Bilgisi Giris Paneli");

        // paneli kapatinca ilgili class kapanmis olacak
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // buton a basinca yapilacak action
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // form daki verileri obje nin degerlerinine atayalim

                hasta1.setHasta_isim(textField1.getText());
                hasta1.setHasta_soyisim(textField2.getText());
                hasta1.setHasta_cinsiyet(textField3.getText().toUpperCase().charAt(0));
                hasta1.setHasta_kanGrubu(textField4.getText());
                Date dogum_tarih = null;
                try {
                    dogum_tarih = new SimpleDateFormat("dd-MM-yyyy").parse(textField5.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                hasta1.setHasta_dogumTarihi(dogum_tarih);
                hasta1.setHasta_adres(textField6.getText());
                hasta1.setHasta_email(textField7.getText());
                hasta1.setHasta_telefon(textField8.getText());
                hasta1.setHasta_statu(Integer.parseInt(textField9.getText()));


                // hasta tablosundan max id yi almak

                int gelen_id = 0;
                try {
                    gelen_id = Connector_hb.hastaTablosundanIdAl();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Gelen id = "+gelen_id);
                hasta1.setHasta_id(gelen_id+1);





                System.out.println(hasta1);



                // bir de formdaki verileri mysql veritabanina atalim

                try {
                    Connector_hb.hastaTablosuVeriGir(hasta1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                // veri girisi tamamlaninca paneli kapatalim
                setVisible(false); // icerisindekileri gorunmez yap
                dispose(); // paneli yok et yani kapat


                // veri girisi yaptiktan sonra terminalde ana menu acilsin
                GirisMethod anamenu = new GirisMethod();
                try {
                    anamenu.anaMenu();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                // Connector_hb.hastaTablosu().close();


            }
        });


        // textField9 a sadece raka girilebilmesi icin:
        textField9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    // rakam disinda bir harfe basinca yazmamasi icin
                    textField9.setEditable(false);
                    statuHata.setText("Sadece rakam giriniz");
                } else {
                    textField9.setEditable(true);
                }
            }
        });

        // kapat butonuna basinca yapilacak aksiyonlar
        KAPATButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // icerisindekileri gorunmez yap
                dispose(); // paneli yok et yani kapat
            }
        });
    }


}
