package orgNasada2.PodatkovneKlase;

public class Posa�eno {
	
	private int idPosa�eno;
	private String nazivPosa�eno;
	private int sortaID;
	private int podlogaID;
	
	public Posa�eno(int id, String naziv, int idSorta, int idPodloga)
	{
		this.idPosa�eno = id;
		this.nazivPosa�eno = naziv;
		this.sortaID = idSorta;
		this.podlogaID = idPodloga;
	}
	public Posa�eno(String naziv, int idSorta, int idPodloga)
	{
		this.nazivPosa�eno = naziv;
		this.sortaID = idSorta;
		this.podlogaID = idPodloga;
	}
	
	public int getIdPosa�eno() {
		return idPosa�eno;
	}
	public void setIdPosa�eno(int idPosa�eno) {
		this.idPosa�eno = idPosa�eno;
	}
	public String getNazivPosa�eno() {
		return nazivPosa�eno;
	}
	public void setNazivPosa�eno(String nazivPosa�eno) {
		this.nazivPosa�eno = nazivPosa�eno;
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
