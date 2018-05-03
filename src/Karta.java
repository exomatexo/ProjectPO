

/**
 * Created by Adam on 16.05.2017.
 */
public class Karta {
    private String nrKarty;
    private double saldo;
    private String wlasciciel;
    private String rodzaj;

    public Karta(String nrKarty, double saldo, String wlasciciel, String rodzaj) {
        this.nrKarty = nrKarty;
        this.saldo = saldo;
        this.setWlasciciel(wlasciciel);
        this.rodzaj = rodzaj;
    }

    public Karta() {
        saldo=0;
    }

    public double getSaldo()
    {
        return saldo;
    }
    public String getNrKarty()
    {
        return nrKarty;
    }
    public String getRodzaj()
    {
        return rodzaj;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

	public String getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(String wlasciciel) {
		this.wlasciciel = wlasciciel;
	}
}
