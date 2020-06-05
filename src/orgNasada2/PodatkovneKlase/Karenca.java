package orgNasada2.PodatkovneKlase;

import java.time.LocalDate;

public class Karenca {
	
	private int idKarenca;
	private int sredstvoID;
	private LocalDate datumTretiranja;
	private LocalDate datumIstekaRad;
	private LocalDate datumIstekaKon;
	
	public Karenca(int idKarenca, int sredstvoID, LocalDate datTretiranja, LocalDate datumIstekaRad, LocalDate datumIstekaKon)
	{
		this.idKarenca=idKarenca;
		this.sredstvoID=sredstvoID;
		this.datumTretiranja=datTretiranja;
		this.datumIstekaRad=datumIstekaRad;
		this.datumIstekaKon=datumIstekaKon;
	}
	
	public Karenca(int sredstvoID, LocalDate datTretiranja, LocalDate datumIstekaRad, LocalDate datumIstekaKon)
	{
		this.sredstvoID=sredstvoID;
		this.datumTretiranja=datTretiranja;
		this.datumIstekaRad=datumIstekaRad;
		this.datumIstekaKon=datumIstekaKon;
	}
	
	public int getIdKarenca() {
		return idKarenca;
	}
	public void setIdKarenca(int idKarenca) {
		this.idKarenca = idKarenca;
	}
	public int getSredstvoID() {
		return sredstvoID;
	}
	public void setSredstvoID(int sredstvoID) {
		this.sredstvoID = sredstvoID;
	}
	public LocalDate getDatumTretiranja() {
		return datumTretiranja;
	}
	public void setDatumTretiranja(LocalDate datumTretiranja) {
		this.datumTretiranja = datumTretiranja;
	}
	public LocalDate getDatumIstekaRad() {
		return datumIstekaRad;
	}
	public void setDatumIstekaRad(LocalDate datumIstekaRad) {
		this.datumIstekaRad = datumIstekaRad;
	}
	public LocalDate getDatumIstekaKon() {
		return datumIstekaKon;
	}
	public void setDatumIstekaKon(LocalDate datumIstekaKon) {
		this.datumIstekaKon = datumIstekaKon;
	}
	
	
	//TEST CONST
	
	public Karenca (Karenca temp)
	{
		this.sredstvoID=temp.getSredstvoID();
		this.datumTretiranja=temp.getDatumTretiranja();
		this.datumIstekaRad=temp.getDatumIstekaRad();
		this.datumIstekaKon=temp.getDatumIstekaKon();
	}

}
