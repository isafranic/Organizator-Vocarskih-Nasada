package orgNasada2.PodatkovneKlase;

public class Nasad {
	
	private int idNasad;
	private String arkodID;
	private int userID;
	private String naziv;
	private int povrsina;
	private String lokacija;
	private int navodnjavanjeID;
	private int karencaID;
	private int brojRedova;
		
	public Nasad(int idNasad, String arkodID, int userID, String naziv, int povrsina, String lokacija, int navodnjavanje, int karenca, int brojRedova)
	{
		this.idNasad = idNasad;
		this.setArkodID(arkodID);
		this.userID = userID;
		this.naziv = naziv;
		this.povrsina = povrsina;
		this.lokacija = lokacija;
		this.navodnjavanjeID = navodnjavanje;
		this.karencaID = karenca;
		this.brojRedova = brojRedova;
	}
	
	public int getIdNasad() {
		return idNasad;
	}
	public void setIdNasad(int idNasad) {
		this.idNasad = idNasad;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public int getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}
	
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
	
	public int getNavodnjavanjeID() {
		return navodnjavanjeID;
	}
	public void setNavodnjavanjeID(int navodnjavanjeID) {
		this.navodnjavanjeID = navodnjavanjeID;
	}
	
	public int getKarencaID() {
		return karencaID;
	}
	public void setKarencaID(int karencaID) {
		this.karencaID = karencaID;
	}
	
	public int getBrojRedova() {
		return brojRedova;
	}
	public void setBrojRedova(int brojRedova) {
		this.brojRedova = brojRedova;
	}
	
	// TEST CONST
	public Nasad(String arkodID, int userID, String naziv, int povrsina, String lokacija, int navodnjavanje, int karenca, int brojRedova)
	{
		this.arkodID = arkodID;
		this.userID = userID;
		this.naziv = naziv;
		this.povrsina = povrsina;
		this.lokacija = lokacija;
		this.navodnjavanjeID = navodnjavanje;
		this.karencaID = karenca;
		this.brojRedova = brojRedova;
	}
	
	public Nasad(Nasad temp)
	{
		this.idNasad = temp.getIdNasad();
		this.arkodID = temp.getArkodID();
		this.userID = temp.getUserID();
		this.naziv = temp.getNaziv();
		this.povrsina = temp.getPovrsina();
		this.lokacija = temp.getLokacija();
		this.navodnjavanjeID = temp.getNavodnjavanjeID();
		this.karencaID = temp.getKarencaID();
		this.brojRedova = temp.getBrojRedova();
	}

	public String getArkodID() {
		return arkodID;
	}

	public void setArkodID(String arkodID) {
		this.arkodID = arkodID;
	}

}
