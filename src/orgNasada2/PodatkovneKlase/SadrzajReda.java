package orgNasada2.PodatkovneKlase;

import java.time.LocalDate;

public class SadrzajReda {
	
	private int idSadr�ajReda;
	private int redID;
	private int posa�enoID;
	private int brojSadnogMjesta;
	private LocalDate datumSadnje;
	
	public SadrzajReda(int id, int redID, int posa�enoID, int brojSadnogMjesta, LocalDate datum)
	{
		this.idSadr�ajReda=id;
		this.posa�enoID = posa�enoID;
		this.brojSadnogMjesta=brojSadnogMjesta;
		this.datumSadnje=datum;
	}
	
	public SadrzajReda(int redID, int posa�enoID, int brojSadnogMjesta, LocalDate datum)
	{
		this.posa�enoID = posa�enoID;
		this.brojSadnogMjesta=brojSadnogMjesta;
		this.datumSadnje=datum;
	}
	
	public int getIdSadr�ajReda() {
		return idSadr�ajReda;
	}
	public void setIdSadr�ajReda(int idSadr�ajReda) {
		this.idSadr�ajReda = idSadr�ajReda;
	}
	public int getRedID() {
		return redID;
	}
	public void setRedID(int redID) {
		this.redID = redID;
	}
	public int getPosa�enoID() {
		return posa�enoID;
	}
	public void setPosa�enoID(int posa�enoID) {
		this.posa�enoID = posa�enoID;
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
