
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Exomat on 04.05.2017.
 */
public class Sprzedawca implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Nazwa;
    private  String nrKonta;
    Calendar calendar = Calendar.getInstance();

    public Sprzedawca(String nazwa, String nrKonta) {
        Nazwa = nazwa;
        this.nrKonta = nrKonta;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }

    public Transakcja transakcja(Double kwota, String nrKarty, String waluta, String nrKonta){
        Date data = calendar.getTime();
        return new Transakcja(data, kwota, nrKarty, waluta, nrKonta);
    }


}
