

import java.util.ArrayList;

/**
 * Created by Adam on 16.05.2017.
 */
public class Klient {
    private String pesel;
    private ArrayList<Konto> listaKont= new ArrayList<Konto>();

    public Klient(){

    }
    
    public Klient(String pesel) {
		this.pesel = pesel;
	}

	public void dodajKonto(Konto k)
    {
        listaKont.add(k);
    }
    public void usunKonto(Konto k)
    {
        listaKont.remove(k);
    }
    public ArrayList<Konto> getKonta(){
        return listaKont;
    }
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
}
