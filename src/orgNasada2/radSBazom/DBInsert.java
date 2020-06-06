package orgNasada2.radSBazom;

import java.time.LocalDate;
import java.util.Vector;

public class DBInsert {
		
	public static int unesiNasad(int userID, String arkodID, String naziv, String povrsina, String lokacija, int navodnjavanjeID, int karencaID, String brojRedova)
	{		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(userID));
		values.add(arkodID);
		values.add(naziv);
		values.add(povrsina);
		values.add(lokacija);
		values.add(String.valueOf(navodnjavanjeID));
		values.add(String.valueOf(karencaID));
		values.add(brojRedova);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiNasadWhat) what.add(s);
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBNasad, what, values, DBConst.emptyVector));
	}
	
	public static int unesiRed(int idNasada, int brojReda, int brojSadnihMjesta)
	{
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(idNasada));
		values.add(String.valueOf(brojSadnihMjesta));
		values.add(String.valueOf(brojReda));
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiRedWhat) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBRedovi, what, values, DBConst.emptyVector));
		
	}
	
	public static int unesiPraznoMjesto(int redID, int brojMjesta)
	{
		return unesiSadrzajReda(redID, 1, brojMjesta, LocalDate.now());
	}
	
	public static int unesiSadrzajReda(int redID, int PosadenoID, int brojMjesta, LocalDate datumSadnje)
	{
		Vector<String> what = new Vector<String>();
		for(String s: DBConst.unesiSadrzajRedaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(redID));
		values.add(String.valueOf(PosadenoID));
		values.add(String.valueOf(brojMjesta));
		values.add(datumSadnje.toString());
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBSadrzajReda, what, values, DBConst.emptyVector));
	}
	
	public static int unesiNavodnjavanje(String ime)
	{
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("INSERT INTO Navodnjavanje (nazivNavodnjavanja) VALUES (");
		sqlQuery.append(ime);
		sqlQuery.append(")");

		return Utilities.executeUpdate(sqlQuery);
	}

	public static int unesiSredstvo(String nazivSredstva, String tipTretiranja, String aktivnaTvar, String svrhaSredstva, String karencaRadno, String karencaKonzumno)
	{	
		Vector<String> values = new Vector<String>();
		values.add(nazivSredstva);
		values.add(tipTretiranja);
		values.add(aktivnaTvar);
		values.add(svrhaSredstva);
		values.add(karencaRadno);
		values.add(karencaKonzumno);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiSredstvo) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBSredstva, what, values, DBConst.emptyVector));
		
	}
	
	public static int unesiKorisnika(String username, String password, String ime)
	{
		Vector<String> values = new Vector<String>();
		values.add(ime);
		values.add(username);
		values.add(password);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiKorisnika) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBUsers, what, values, DBConst.emptyVector));
		
	}
	
	public static int unesiKarencu(int sredstvoID, int trajanjeRad, int trajanjeKon, LocalDate datumTretiranja)
	{
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(sredstvoID));
		values.add(datumTretiranja.toString());
		LocalDate istekRadne = datumTretiranja.plusDays(trajanjeRad);
		values.add(String.valueOf(istekRadne));
		LocalDate istekKon = datumTretiranja.plusDays(trajanjeKon);
		values.add(String.valueOf(istekKon));	
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiKarencu) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBUsers, what, values, DBConst.emptyVector));
	}
	
	public static int unesiPosadeno(int sorteID, int podlogeID, String nazivPosadeno)
	{
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(sorteID));
		values.add(String.valueOf(podlogeID));
		values.add(nazivPosadeno);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiPosadeno) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBPosadeno, what, values, DBConst.emptyVector));
	}
	
	public static int unesiSorte(String imeSorte, String vrstaSorte)
	{
		Vector<String> values = new Vector<String>();
		values.add(imeSorte);
		values.add(vrstaSorte);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiSorte) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBSorte, what, values, DBConst.emptyVector));
	}
	
	public static int unesiPodloge(String nazivPodloge, String bujnostPodloge)
	{
		Vector<String> values = new Vector<String>();
		values.add(nazivPodloge);
		values.add(bujnostPodloge);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiPodloge) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBPodloge, what, values, DBConst.emptyVector));
		
	}
	
	public static int registerUser(String username, String name, String pass)
	{
		Vector<String> values = new Vector<String>();
		values.add(username);
		values.add(name);
		values.add(pass);
		
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.unesiKorisnika) what.add(s);
		
		return Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeInsert, DBConst.dBUsers, what, values, DBConst.emptyVector));
		
	}
}