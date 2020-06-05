package orgNasada2.PodatkovneKlase;

public class RedInfo {
	
	private int idReda;
	private int nasadID;
	private int brojReda;
	private int brojSadnihMjesta;
	
	public RedInfo(int idReda, int nasadID, int brojReda, int brojSadnihMjesta)
	{
		this.idReda = idReda;
		this.nasadID = nasadID;
		this.brojReda = brojReda;
		this.brojSadnihMjesta = brojSadnihMjesta;
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
