


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Exomat on 04.05.2017.
 */
public class Transakcja implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date data;
    private Double kwota;
    private String nrKarty, waluta;
    private Boolean czyudana;
    private String nazwaBank;
    private String pesel;
    private String kontoodbiorcy;
    public Transakcja(Date data, Double kwota, String nrKarty, String waluta, String kontoodbiorcy) {
        this.data = data;
        this.kwota = kwota;
        this.nrKarty = nrKarty;
        this.waluta = waluta;
        this.setKontoodbiorcy(kontoodbiorcy);
    }

    public Transakcja(Double kwota, String nrKarty, String waluta, String kontoodbiorcy) {
        this.kwota = kwota;
        this.nrKarty = nrKarty;
        this.waluta = waluta;
        this.setKontoodbiorcy(kontoodbiorcy);
    }

    public Transakcja() {
    }

    public void setCzyudana(Boolean czyudana) {
        this.czyudana = czyudana;
    }

    public Date getData() {
        return data;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Double getKwota() {
        return kwota;
    }

    public String getNrKarty() {
        return nrKarty;
    }

    public String getWaluta() {
        return waluta;
    }

    public Boolean getCzyudana() {
        return czyudana;
    }

    public String getNazwaBank(){return nazwaBank;}

    public String getPesel(){return pesel;}

    public void setNazwaBank(String nazwaBank) {
        this.nazwaBank = nazwaBank;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

	public String getKontoodbiorcy() {
		return kontoodbiorcy;
	}

	public void setKontoodbiorcy(String kontoodbiorcy) {
		this.kontoodbiorcy = kontoodbiorcy;
	}
}
