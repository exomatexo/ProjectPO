

import java.util.ArrayList;

/**
 * Created by Adam on 16.05.2017.
 */
public class Konto {
    private String nr;
    private double saldo;
    private String waluta;
    private ArrayList<Karta> listaKart= new ArrayList<Karta>();

    public Konto(String nr, String waluta) {
        this.nr = nr;
        this.setWaluta(waluta);
        saldo=0;
    }

    public Konto(){
        saldo=0;
    }

    public void dodajKarte(Karta karta){
        listaKart.add(karta);
        setSaldo();
    }
    public void usunKarte (Karta karta){
        listaKart.remove(karta);
        setSaldo();
    }
    public ArrayList<Karta> getKarty()
    {
        return listaKart;
    }
    public void wplac(double kwota, Karta k)
    {
        k.setSaldo(k.getSaldo()+kwota);
        setSaldo();
    }
    public void wyplac(double kwota, Karta k, String waluta)
    {
        if(waluta.equals("EUR")){
            kwota*=4.2;
        }
        if(waluta.equals("USD")){
            kwota=kwota*3.7;
        }
        if(waluta.equals("GBP")){
            kwota=kwota*4.8;
        }
        if(waluta.equals("CZK")){
            kwota=kwota*0.16;
        }
        if(k.getRodzaj().equals("Kredytowa")) {
            k.setSaldo(k.getSaldo() - kwota);
        }

        if(k.getRodzaj().equals("Debetowa")){
            if(k.getSaldo()>=kwota)
                k.setSaldo(k.getSaldo()-kwota);
        }

        if(k.getRodzaj().equals("Bankomatowa")){
            if(kwota<200){
                if (k.getSaldo()>=kwota){
                    k.setSaldo(k.getSaldo()-kwota);
                }
        }
    }
    setSaldo();
    }
    public String getNr(){
        return nr;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(){
        int a=0;
        for (Karta k: listaKart) {
            a+=k.getSaldo();
        }
        saldo=a;
    }

	public String getWaluta() {
		return waluta;
	}

	public void setWaluta(String waluta) {
		this.waluta = waluta;
	}
}
