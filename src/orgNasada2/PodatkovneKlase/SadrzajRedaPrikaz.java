package orgNasada2.PodatkovneKlase;

import java.time.LocalDate;

public class SadrzajRedaPrikaz {

	private int brojReda;
	private int brojMjesta;
	private String nazivPosaðenog;
	LocalDate datumSadnje;
	private int idSadrzajReda;
	
	public SadrzajRedaPrikaz(int brojReda, int brojMjesta, String nazivPosaðenog, LocalDate datumSadnje, int idSadrzajReda)
	{
		this.brojReda = brojReda;
		this.brojMjesta = brojMjesta;
		this.nazivPosaðenog = nazivPosaðenog;
		this.datumSadnje = datumSadnje;
		this.idSadrzajReda = idSadrzajReda;
	}
	
	public int getBrojReda() {
		return brojReda;
	}
	public void setBrojReda(int brojReda) {
		this.brojReda = brojReda;
	}
	public int getBrojMjesta() {
		return brojMjesta;
	}
	public void setBrojMjesta(int brojMjesta) {
		this.brojMjesta = brojMjesta;
	}
	public String getNazivPosaðenog() {
		return nazivPosaðenog;
	}
	public void setNazivPosaðenog(String nazivPosaðenog) {
		this.nazivPosaðenog = nazivPosaðenog;
	}
	public LocalDate getDatumSadnje() {
		return datumSadnje;
	}
	public void setDatumSadnje(LocalDate datumSadnje) {
		this.datumSadnje = datumSadnje;
	}
	public int getIdSadrzajReda() {
		return idSadrzajReda;
	}
	public void setIdSadrzajReda(int idSadrzajReda) {
		this.idSadrzajReda = idSadrzajReda;
	}
}
