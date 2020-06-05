package orgNasada2.PodatkovneKlase;

public class Posaðeno {
	
	private int idPosaðeno;
	private String nazivPosaðeno;
	private int sortaID;
	private int podlogaID;
	
	public Posaðeno(int id, String naziv, int idSorta, int idPodloga)
	{
		this.idPosaðeno = id;
		this.nazivPosaðeno = naziv;
		this.sortaID = idSorta;
		this.podlogaID = idPodloga;
	}
	public Posaðeno(String naziv, int idSorta, int idPodloga)
	{
		this.nazivPosaðeno = naziv;
		this.sortaID = idSorta;
		this.podlogaID = idPodloga;
	}
	
	public int getIdPosaðeno() {
		return idPosaðeno;
	}
	public void setIdPosaðeno(int idPosaðeno) {
		this.idPosaðeno = idPosaðeno;
	}
	public String getNazivPosaðeno() {
		return nazivPosaðeno;
	}
	public void setNazivPosaðeno(String nazivPosaðeno) {
		this.nazivPosaðeno = nazivPosaðeno;
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
