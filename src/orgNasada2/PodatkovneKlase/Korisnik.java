package orgNasada2.PodatkovneKlase;

public class Korisnik {
	private int idUser;
	private String ime;
	private String korisnickoIme;
	private String lozinka;
	
	public Korisnik(String ime, String usn, String pss)
	{
		this.ime = ime;
		this.korisnickoIme = usn;
		this.lozinka = pss;
	}
	
	public Korisnik(Korisnik user)
	{
		this.idUser = user.getId();
		this.ime = user.getIme();
		this.korisnickoIme = user.getKorisnickoIme();
		this.lozinka = user.getLozinka();
	}
	
	public Korisnik(int id, String ime, String usn, String pss)
	{
		this.idUser = id;
		this.ime = ime;
		this.korisnickoIme = usn;
		this.lozinka = pss;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public int getId() {
		return idUser;
	}
	public void setId(int id) {
		this.idUser = id;
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
}
