

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adam on 16.05.2017.
 */
public class Bank implements Serializable  {
   
	private static final long serialVersionUID = 1L;
	private String nazwa;
    private ArrayList<Klient> listaKlientow= new ArrayList<Klient>();

    public Bank(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa(){return nazwa;}

    public void dodajKlienta(Klient klient){
        listaKlientow.add(klient);
    }
    public void usunKlienta (Klient klient){
        listaKlientow.remove(klient);
    }
    public ArrayList<Klient> getKlienci()
    {
        return listaKlientow;
    }
    public Boolean autoryzacja(Transakcja T) {
 
        for (Klient i : listaKlientow) {
            for (Konto a: i.getKonta()){
                for (Karta b: a.getKarty()){
                    if (b.getNrKarty().equals(T.getNrKarty())){
                        if(b.getRodzaj().equals("Kredytowa")) {
                            a.wyplac(T.getKwota(), b, T.getWaluta());
                            T.setCzyudana(true);
                            return true;
                        }
                        if(b.getRodzaj().equals("Debetowa")) {
                            if (b.getSaldo()>= T.getKwota())
                            {
                                a.wyplac(T.getKwota(), b, T.getWaluta());
                                T.setCzyudana(true);
                                return true;
                            }
                            else {
                                T.setCzyudana(false);
                                return false;
                            }
                        }
                        if(b.getRodzaj().equals("Bankomatowa")){
                         if(T.getKwota()<200){
                             if (b.getSaldo()>= T.getKwota()){
                                 a.wyplac(T.getKwota(), b, T.getWaluta());
                                 T.setCzyudana(true);
                                 return true;
                             }
                             else {
                                 T.setCzyudana(false);
                                 return false;}
                         }
                         else {
                             T.setCzyudana(false);
                             return false;
                         }
                        }
                    }
                }
            }
        }
        T.setCzyudana(false);
        return false;
    }

}
