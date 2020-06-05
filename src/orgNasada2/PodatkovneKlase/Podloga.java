package orgNasada2.PodatkovneKlase;

public class Podloga {
	
	private int idPodloge;
	private String nazivPodloge;
	private String bujnostPodloge;	
	
	public Podloga(int idPodloge, String nazivPodloge, String bujnostPodloge) {
		this.setIdPodloge(idPodloge);
		this.nazivPodloge = nazivPodloge;
		this.bujnostPodloge = bujnostPodloge;
	}
	
	public Podloga(String nazivPodloge, String bujnostPodloge) {
		this.nazivPodloge = nazivPodloge;
		this.bujnostPodloge = bujnostPodloge;
	}
	
	public String getNazivPodloge() {
		return nazivPodloge;
	}
	public void setNazivPodloge(String nazivPodloge) {
		this.nazivPodloge = nazivPodloge;
	}
	
	public String getBujnostPodloge() {
		return bujnostPodloge;
	}
	public void setBujnostPodloge(String bujnostPodloge) {
		this.bujnostPodloge = bujnostPodloge;
	}

	public int getIdPodloge() {
		return idPodloge;
	}
	public void setIdPodloge(int idPodloge) {
		this.idPodloge = idPodloge;
	}
	
	//TEST CONST

	public Podloga(Podloga temp) {
		this.nazivPodloge = temp.getNazivPodloge();
		this.bujnostPodloge = temp.getBujnostPodloge();
	}
}
