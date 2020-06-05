package orgNasada2.PodatkovneKlase;

public class PosaðenoInfo {
	
	private int idPosaðeno;
	private String nazivPosaðeno;
	private String sorta;
	private String podloga;
	
	public PosaðenoInfo(int id, String naziv, String sorta, String podloga)
	{
		this.idPosaðeno = id;
		this.nazivPosaðeno = naziv;
		this.sorta = sorta;
		this.podloga = podloga;
	}
	public PosaðenoInfo(PosaðenoInfo temp)
	{
		this.idPosaðeno = temp.getIdPosaðeno();
		this.nazivPosaðeno = temp.getNazivPosaðeno();
		this.sorta = temp.getSorta();
		this.podloga = temp.getPodloga();
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
	public String getSorta() {
		return sorta;
	}
	public void setSorta(String sorta) {
		this.sorta = sorta;
	}
	public String getPodloga() {
		return podloga;
	}
	public void setPodloga(String podloga) {
		this.podloga = podloga;
	}

	
}
