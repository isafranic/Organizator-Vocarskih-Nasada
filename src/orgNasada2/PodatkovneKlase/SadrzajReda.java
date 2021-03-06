package orgNasada2.PodatkovneKlase;

import java.time.LocalDate;

public class SadrzajReda {
	
	private int idSadržajReda;
	private int redID;
	private int posađenoID;
	private int brojSadnogMjesta;
	private LocalDate datumSadnje;
	
	public SadrzajReda(int id, int redID, int posađenoID, int brojSadnogMjesta, LocalDate datum)
	{
		this.idSadržajReda=id;
		this.posađenoID = posađenoID;
		this.brojSadnogMjesta=brojSadnogMjesta;
		this.datumSadnje=datum;
	}
	
	public SadrzajReda(int redID, int posađenoID, int brojSadnogMjesta, LocalDate datum)
	{
		this.posađenoID = posađenoID;
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
	public int getPosađenoID() {
		return posađenoID;
	}
	public void setPosađenoID(int posađenoID) {
		this.posađenoID = posađenoID;
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
