package orgNasada2.gui.controller;

import org.apache.log4j.Logger;

import orgNasada2.PodatkovneKlase.Korisnik;
import orgNasada2.gui.GuiVisual;
import orgNasada2.radSBazom.DBInsert;
import orgNasada2.radSBazom.Utilities;


public class GuiController 
{	
	public static int insertFormNasadID = 1;
	
	private static final Logger logger = Logger.getLogger(GuiVisual.class);
		
	@SuppressWarnings("unused")
	public static boolean loginUser(String username, char[] password)
	{
		StringBuilder sqlQuery = new StringBuilder();
		StringBuilder pass = new StringBuilder();
		for(char c: password) pass.append(c);
		sqlQuery.append("SELECT * FROM users WHERE korisnickoIme = '" + username +"' AND sifra = '" + pass + "' LIMIT 1");
		logger.info(sqlQuery);
		Korisnik user = new Korisnik(Utilities.query2Korisnik(sqlQuery));
			if(user != null)
			{
				GuiVisual.setUser(user);
				return true;
			}
			return false;
	}

	public static boolean registerUser(String username, String ime, String password, String passwordConfirm)
	{	
		if(DBInsert.unesiKorisnika(username, password.toString(), ime)==1)	return true;
		return false;
	}

	public static void tretirajVocnjakSaSredstvom(String sredstvo, String nasad) {
		// TODO Auto-generated method stub
		
	}
	
}
