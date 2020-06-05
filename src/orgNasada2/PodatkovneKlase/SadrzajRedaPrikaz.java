package orgNasada2.PodatkovneKlase;

import java.time.LocalDate;

public class SadrzajRedaPrikaz {

	private int brojReda;
	private int brojMjesta;
	private String nazivPosa�enog;
	LocalDate datumSadnje;
	private int idSadrzajReda;
	
	public SadrzajRedaPrikaz(int brojReda, int brojMjesta, String nazivPosa�enog, LocalDate datumSadnje, int idSadrzajReda)
	{
		this.brojReda = brojReda;
		this.brojMjesta = brojMjesta;
		this.nazivPosa�enog = nazivPosa�enog;
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
	public String getNazivPosa�enog() {
		return nazivPosa�enog;
	}
	public void setNazivPosa�enog(String nazivPosa�enog) {
		this.nazivPosa�enog = nazivPosa�enog;
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
