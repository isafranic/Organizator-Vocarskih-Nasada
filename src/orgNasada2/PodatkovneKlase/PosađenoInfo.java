package orgNasada2.PodatkovneKlase;

public class Posa�enoInfo {
	
	private int idPosa�eno;
	private String nazivPosa�eno;
	private String sorta;
	private String podloga;
	
	public Posa�enoInfo(int id, String naziv, String sorta, String podloga)
	{
		this.idPosa�eno = id;
		this.nazivPosa�eno = naziv;
		this.sorta = sorta;
		this.podloga = podloga;
	}
	public Posa�enoInfo(Posa�enoInfo temp)
	{
		this.idPosa�eno = temp.getIdPosa�eno();
		this.nazivPosa�eno = temp.getNazivPosa�eno();
		this.sorta = temp.getSorta();
		this.podloga = temp.getPodloga();
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
