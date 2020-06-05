package orgNasada2.PodatkovneKlase;

public class PrviStartDBPodatci {
	
	private String[] breskve = {"Springtime", "Springcrest", "Spring Lady", "Royal Glory", "Flavorcrest",
			"Redhaven", "Redtop", "Maria Marta", "GloHaven", "Elegant Lady",
				"Suncrest", "Fayette", "OHenry"};

	private String[] jabuke = {"Corail", "Gala Annaglo", "Gala Galaxy", "Royal Gala", "Jonagold",
			"Eveline", "Gala Baigent", "Gala Schnitzer Schniga", "Golden Delicious", "Jonagold Decosta",
				"Jonagold Early Queen", "Jonagold Navajo", "Jonagold Wilmuta", "King Jonagold", "Nicopgreen", 
					"Kanzi", "Pink Lady", "Regia", "Top Red", "Jonagored"};

	private String[] navodnjavanje = {"Bez ureðenog navodnjavanja", "Kap na kap", "Prskalice"};
	
	public int getBreskveBroj()
	{
		return breskve.length;
	}
	
	public String getBreskve(int i) {
		return breskve[i];
	}
	
	public int getjabukeBroj()
	{
		return jabuke.length;
	}
	
	public String getJabuke(int i) {
		return jabuke[i];
	}
	
	public int getNavodnjavanjeBroj()
	{
		return navodnjavanje.length;
	}
	
	public String getNavodnjavanje(int i) {
		return navodnjavanje[i];
	}

}
