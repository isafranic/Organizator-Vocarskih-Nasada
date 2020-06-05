package orgNasada2.PodatkovneKlase;

import java.time.LocalDate;

public class SadrzajReda {
	
	private int idSadržajReda;
	private int redID;
	private int posaðenoID;
	private int brojSadnogMjesta;
	private LocalDate datumSadnje;
	
	public SadrzajReda(int id, int redID, int posaðenoID, int brojSadnogMjesta, LocalDate datum)
	{
		this.idSadržajReda=id;
		this.posaðenoID = posaðenoID;
		this.brojSadnogMjesta=brojSadnogMjesta;
		this.datumSadnje=datum;
	}
	
	public SadrzajReda(int redID, int posaðenoID, int brojSadnogMjesta, LocalDate datum)
	{
		this.posaðenoID = posaðenoID;
		this.brojSadnogMjesta=brojSadnogMjesta;
		this.datumSadnje=datum;
	}
	
	public int getIdSadržajReda() {
		return idSadržajReda;
	}
	public void setIdSadržajReda(int idSadržajReda) {
		this.idSadržajReda = idSadržajReda;
	}
	public int getRedID() {
		return redID;
	}
	public void setRedID(int redID) {
		this.redID = redID;
	}
	public int getPosaðenoID() {
		return posaðenoID;
	}
	public void setPosaðenoID(int posaðenoID) {
		this.posaðenoID = posaðenoID;
	}
	public int getBrojSadnogMjesta() {
		return brojSadnogMjesta;
	}
	public void setBrojSadnogMjesta(int brojSadnogMjesta) {
		this.brojSadnogMjesta = brojSadnogMjesta;
	}
	public LocalDate getDatumSadnje() {
		return datumSadnje;
	}
	public void setDatumSadnje(LocalDate datumSadnje) {
		this.datumSadnje = datumSadnje;
	}
	
}
