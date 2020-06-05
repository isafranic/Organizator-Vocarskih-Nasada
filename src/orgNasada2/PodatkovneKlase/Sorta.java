package orgNasada2.PodatkovneKlase;

public class Sorta {
	
	private int idSorta;
	private String imeSorte;
	private String vrstaSorte;
	
	public Sorta(int id, String ime, String vrsta)
	{
		this.idSorta=id;
		this.imeSorte=ime;
		this.vrstaSorte=vrsta;
	}
	
	public Sorta(Sorta sorta)
	{
		this.idSorta=sorta.getIdSorta();
		this.imeSorte=sorta.getImeSorte();
		this.vrstaSorte=sorta.getVrstaSorte();
	}
	
	public Sorta(String ime, String vrsta)
	{
		this.imeSorte=ime;
		this.vrstaSorte=vrsta;
	}
	public int getIdSorta() {
		return idSorta;
	}
	public void setIdSorta(int idSorta) {
		this.idSorta = idSorta;
	}
	
	public String getImeSorte() {
		return imeSorte;
	}
	public void setImeSorte(String imeSorte) {
		this.imeSorte = imeSorte;
	}
	
	public String getVrstaSorte() {
		return vrstaSorte;
	}
	public void setVrstaSorte(String vrstaSorte) {
		this.vrstaSorte = vrstaSorte;
	}
	
}
