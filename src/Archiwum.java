

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by Exomat on 04.05.2017.
 */
public class Archiwum implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Transakcja> lista_trans = new ArrayList<>();

    public ArrayList<Transakcja> getLista_trans() {
        return lista_trans;
    }

    public void add_trans(Transakcja ADDT) {
        lista_trans.add(ADDT);
    }

    public Transakcja przeszukaj(Transakcja T) {
        Transakcja S = new Transakcja();
        return S;
    }

    public ArrayList<Transakcja> szukajWaluta(String Waluta) {
        ArrayList<Transakcja> lista = new ArrayList<Transakcja>();
        for (Transakcja T : lista_trans) {
            if (Waluta.equals(T.getWaluta()))
                lista.add(T);
        }
        return lista;
    }

    public ArrayList<Transakcja> szukajKwota(double kwota) {
        ArrayList<Transakcja> lista = new ArrayList<Transakcja>();
        for (Transakcja T : lista_trans) {
            if (kwota == T.getKwota())
                lista.add(T);
        }
        return lista;
    }

    public ArrayList<Transakcja> szukajNrKarty(String karta) {
        ArrayList<Transakcja> lista = new ArrayList<Transakcja>();
        for (Transakcja T : lista_trans) {
            if (karta.equals(T.getNrKarty()))
                lista.add(T);
        }
        return lista;
    }

  

    public ArrayList<Transakcja> szukajBanku(String nazwaBanku) {
        ArrayList<Transakcja> lista = new ArrayList<Transakcja>();
        for (Transakcja T : lista_trans) {
            if (nazwaBanku.equals(T.getNazwaBank()))
                lista.add(T);
        }
        return lista;
    }

    public ArrayList<Transakcja> szukajKlienta(String pesel) {
        ArrayList<Transakcja> lista = new ArrayList<Transakcja>();
        for (Transakcja T : lista_trans) {
            if (pesel.equals(T.getPesel()))
                lista.add(T);
        }
        return lista;
    }
}
