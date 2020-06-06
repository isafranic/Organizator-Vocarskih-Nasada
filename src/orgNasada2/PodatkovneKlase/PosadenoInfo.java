package orgNasada2.PodatkovneKlase;

public class PosadenoInfo {
	
	private int idPosadeno;
	private String nazivPosadeno;
	private String sorta;
	private String podloga;
	
	public PosadenoInfo(int id, String naziv, String sorta, String podloga)
	{
		this.idPosadeno = id;
		this.nazivPosadeno = naziv;
		this.sorta = sorta;
		this.podloga = podloga;
	}
	public PosadenoInfo(PosadenoInfo temp)
	{
		this.idPosadeno = temp.getIdPosadeno();
		this.nazivPosadeno = temp.getNazivPosadeno();
		this.sorta = temp.getSorta();
		this.podloga = temp.getPodloga();
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
