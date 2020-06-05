package orgNasada2.PodatkovneKlase;

public class Sredstvo {

	private int idSredstva;
	private String naziv;
	private String tipTretiranja;
	private String aktivnaTvar;
	private String svrhaSredstva;
	private int trajanjeRadneKarenceDani;
	private int trajanjeKonzumneKarenceDani;
	
	public Sredstvo(int idSredstva, String naziv, String tipTretiranja, String aktivnaTvar, String svrha, int trajanjeRadKarence, int trajanjeKonKarence)
	{
		this.setIdSredstva(idSredstva);
		this.naziv = naziv;
		this.tipTretiranja = tipTretiranja;
		this.setAktivnaTvar(aktivnaTvar);
		this.setSvrhaSredstva(svrha);
		this.setTrajanjeRadneKarenceDani(trajanjeRadKarence);
		this.setTrajanjeKonzumneKarenceDani(trajanjeKonKarence);
	}
	
	public Sredstvo(String naziv, String tipTretiranja,String aktivnaTvar, String svrha, int trajanjeRadKarence, int trajanjeKonKarence)
	{
		this.naziv = naziv;
		this.tipTretiranja = tipTretiranja;
		this.setAktivnaTvar(aktivnaTvar);
		this.svrhaSredstva = svrha;
		this.setTrajanjeRadneKarenceDani(trajanjeRadKarence);
		this.setTrajanjeKonzumneKarenceDani(trajanjeKonKarence);
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getTipTretiranja() {
		return tipTretiranja;
	}
	public void setTipTretiranja(String tipTretiranja) {
		this.tipTretiranja = tipTretiranja;
	}


	public int getIdSredstva() {
		return idSredstva;
	}
	public void setIdSredstva(int idSredstva) {
		this.idSredstva = idSredstva;
	}

	public String getSvrhaSredstva() {
		return svrhaSredstva;
	}
	public void setSvrhaSredstva(String svrhaSredstva) {
		this.svrhaSredstva = svrhaSredstva;
	}
	
	//test konstruktor
	public Sredstvo(Sredstvo sred)
	{
		this.idSredstva = sred.getIdSredstva();
		this.naziv = sred.getNaziv();
		this.tipTretiranja = sred.getTipTretiranja();
		this.aktivnaTvar = sred.getAktivnaTvar();
		this.svrhaSredstva = sred.getSvrhaSredstva();
		this.trajanjeRadneKarenceDani = sred.getTrajanjeRadneKarenceDani();		
		this.trajanjeKonzumneKarenceDani = sred.getTrajanjeKonzumneKarenceDani();	
	}

	public int getTrajanjeRadneKarenceDani() {
		return trajanjeRadneKarenceDani;
	}

	public void setTrajanjeRadneKarenceDani(int trajanjeRadneKarenceDani) {
		this.trajanjeRadneKarenceDani = trajanjeRadneKarenceDani;
	}

	public int getTrajanjeKonzumneKarenceDani() {
		return trajanjeKonzumneKarenceDani;
	}

	public void setTrajanjeKonzumneKarenceDani(int trajanjeKonzumneKarenceDani) {
		this.trajanjeKonzumneKarenceDani = trajanjeKonzumneKarenceDani;
	}

	public String getAktivnaTvar() {
		return aktivnaTvar;
	}

	public void setAktivnaTvar(String aktivnaTvar) {
		this.aktivnaTvar = aktivnaTvar;
	}
	
}
