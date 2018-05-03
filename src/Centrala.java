/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;


/**
 * Created by Exomat on 04.05.2017.
 */
public class Centrala implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  ArrayList<Bank> banki= new ArrayList<>();
    private  ArrayList<Sprzedawca> sprzedawcy= new ArrayList<>();
    private  Archiwum archiwum= new Archiwum();
    String a = "stanbanki.ser" ;
    String b = "stansprzed.ser" ;
    String c = "archiwum.ser" ;
    public Archiwum getarchiwum(){
    	return archiwum;
    }
    public void dodajdoarch(Transakcja t){
    	archiwum.add_trans(t);
    }
    public void  usunbank(Bank a){
        banki.remove(a);
    }
    public void  usunsprz(Sprzedawca a){
        sprzedawcy.remove(a);
    }

    public ArrayList<Bank> getBanki() {
        return banki;
    }

    public ArrayList<Sprzedawca> getSprzedawcy() {
        return sprzedawcy;
    }

    public void setBanki(Bank bank) {
        banki.add(bank);
    }
    public void setSprzedawcy(Sprzedawca sprzedawca) {
        sprzedawcy.add(sprzedawca);
    }
    public Bank getbank(int i){
        return banki.get(i);
    }
    public void zapis () throws IOException {

        try {
            ObjectOutputStream zp = new ObjectOutputStream(new FileOutputStream(a));
            zp.writeObject(banki);
            zp.close();

            ObjectOutputStream z = new ObjectOutputStream(new FileOutputStream(b));
            z.writeObject(sprzedawcy);
            z.close();

            ObjectOutputStream za = new ObjectOutputStream(new FileOutputStream(c));
            za.writeObject(archiwum);
            za.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public boolean odczyt () throws FileNotFoundException {


        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(a));
            banki = (ArrayList<Bank>)in.readObject();
            in.close();
            ObjectInputStream iss = new ObjectInputStream(new FileInputStream(b));
            sprzedawcy = (ArrayList<Sprzedawca>) iss.readObject();
            iss.close();
            ObjectInputStream isss = new ObjectInputStream(new FileInputStream(c));
            archiwum = (Archiwum) isss.readObject();
            isss.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
        	return false;
        }


    }
    public String getKlient(String nrKarta){
        for (Bank bank:banki) {
            for (Klient klient:bank.getKlienci()) {
                for (Konto konto:klient.getKonta()) {
                    for (Karta karta:konto.getKarty()) {
                        if((karta.getNrKarty()).equals(nrKarta))
                            return klient.getPesel();
                    }
                }
            }
        }
        return nrKarta;
    }

    public String getBank(String nrKarta){
        for (Bank bank:banki) {
            for (Klient klient:bank.getKlienci()) {
                for (Konto konto:klient.getKonta()) {
                    for (Karta karta:konto.getKarty()) {
                        if((karta.getNrKarty()).equals(nrKarta))
                            return bank.getNazwa();
                    }
                }
            }
        }
        return nrKarta;
    }
}