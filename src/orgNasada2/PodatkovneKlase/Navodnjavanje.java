package orgNasada2.PodatkovneKlase;

public class Navodnjavanje {

	private int idNavodnjavanje;
	private String nazivNavodnjavanja;
	
	public Navodnjavanje(int id, String naziv)
	{
		this.idNavodnjavanje = id;
		this.nazivNavodnjavanja = naziv;
	}
	
	public Navodnjavanje(String naziv)
	{
		this.nazivNavodnjavanja = naziv;
	}
	
	public Navodnjavanje(Navodnjavanje navodnjavanje) {
		this.idNavodnjavanje = navodnjavanje.getIdNavodnjavanje();
		this.nazivNavodnjavanja = navodnjavanje.getNazivNavodnjavanja();
	}

	public int getIdNavodnjavanje() {
		return idNavodnjavanje;
	}
	public void setIdNavodnjavanje(int idNavodnjavanje) {
		this.idNavodnjavanje = idNavodnjavanje;
	}
	
	public String getNazivNavodnjavanja() {
		return nazivNavodnjavanja;
	}
	public void setNazivNavodnjavanja(String nazivNavodnjavanja) {
		this.nazivNavodnjavanja = nazivNavodnjavanja;
	}
	
	
}
