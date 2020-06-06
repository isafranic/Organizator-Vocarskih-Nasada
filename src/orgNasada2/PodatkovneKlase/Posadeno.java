package orgNasada2.PodatkovneKlase;

public class Posadeno {
	
	private int idPosadeno;
	private String nazivPosadeno;
	private int sortaID;
	private int podlogaID;
	
	public Posadeno(int id, String naziv, int idSorta, int idPodloga)
	{
		this.idPosadeno = id;
		this.nazivPosadeno = naziv;
		this.sortaID = idSorta;
		this.podlogaID = idPodloga;
	}
	public Posadeno(String naziv, int idSorta, int idPodloga)
	{
		this.nazivPosadeno = naziv;
		this.sortaID = idSorta;
		this.podlogaID = idPodloga;
	}
	
	public int getIdPosadeno() {
		return idPosadeno;
	}
	public void setIdPosadeno(int idPosadeno) {
		this.idPosadeno = idPosadeno;
	}
	public String getNazivPosadeno() {
		return nazivPosadeno;
	}
	public void setNazivPosadeno(String nazivPosadeno) {
		this.nazivPosadeno = nazivPosadeno;
	}
	public int getSortaID() {
		return sortaID;
	}
	public void setSortaID(int sortaID) {
		this.sortaID = sortaID;
	}
	public int getPodlogaID() {
		return podlogaID;
	}
	public void setPodlogaID(int podlogaID) {
		this.podlogaID = podlogaID;
	}

	
}
