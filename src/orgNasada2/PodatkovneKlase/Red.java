package orgNasada2.PodatkovneKlase;

public class Red {
	
	private int idReda;
	private int nasadID;
	private int brojReda;
	private int brojSadnihMjesta;
	
	public Red(int id, int nasadID, int brojReda, int brojSM)
	{
		this.idReda = id;
		this.nasadID = nasadID;
		this.brojReda = brojReda;
		this.brojSadnihMjesta = brojSM;
	}
	
	public Red(int nasadID, int brojReda, int brojSM)
	{
		this.nasadID = nasadID;
		this.brojReda = brojReda;
		this.brojSadnihMjesta = brojSM;
	}
	
	public int getIdReda() {
		return idReda;
	}
	public void setIdReda(int idReda) {
		this.idReda = idReda;
	}
	
	public int getNasadID() {
		return nasadID;
	}
	public void setNasadID(int nasadID) {
		this.nasadID = nasadID;
	}
	
	public int getBrojReda() {
		return brojReda;
	}
	public void setBrojReda(int brojReda) {
		this.brojReda = brojReda;
	}
	
	public int getBrojSadnihMjesta() {
		return brojSadnihMjesta;
	}
	public void setBrojSadnihMjesta(int brojSadnihMjesta) {
		this.brojSadnihMjesta = brojSadnihMjesta;
	}
	
}
