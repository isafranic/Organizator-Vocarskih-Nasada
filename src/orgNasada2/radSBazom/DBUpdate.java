package orgNasada2.radSBazom;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Vector;

public class DBUpdate {
	
	/*
	 * update Karenca
	 */
	public static void updateKarenca(int idKarenca, int sredstvoID)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateKarencaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(sredstvoID));
		values.add(LocalDate.now().toString());
		Vector<Integer> karencaDays = new Vector<Integer>();
		karencaDays.addAll(DBSelect.getTrajanjeKarenca(sredstvoID));
		values.add( LocalDate.now().plusDays( karencaDays.elementAt(0) ).toString());
		values.add( LocalDate.now().plusDays( karencaDays.elementAt(1) ).toString());
		
		Vector<String> where = new Vector<String>();
		for(String s : DBConst.updateKarencaWhere) where.add(s + sredstvoID);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBKarenca, what, values, where));
		
	}
	/*
	 * Update Sredstvo
	 */
	public static void updateSredstvo(int idSredstva, String naziv, String tipTretiranja, String aktivnaTvar, String svrhaSredstva, String karencaRadno, String karencaKonzumno)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateSredstvaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(naziv);
		values.add(tipTretiranja);
		values.add(aktivnaTvar);
		values.add(svrhaSredstva);
		values.add(karencaRadno);
		values.add(karencaKonzumno);
		
		Vector<String> where = new Vector<String>();
		for(String s : DBConst.updateSredstvaWhere) where.add(s + idSredstva);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBSredstva, what, values, where));
		
	}
	/*
	 * Update Navodnjavanje
	 */
	public static void updateNavodnjavanje(int idNavodnjavanje, String nazivNavodnjavanje)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateNavodnjavanjeWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(nazivNavodnjavanje));
		
		Vector<String> where = new Vector<String>();
		for(String s : DBConst.updateNavodjavanjeWhere) where.add(s + idNavodnjavanje);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBNavodnjavanje, what, values, where));
		
	}
	/*
	 * Update Podloga
	 */
	public static void updatePodloga(int idPodloge, String nazivPodloge, String bujnostPodloge)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updatePodlogaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(nazivPodloge);
		values.add(bujnostPodloge);
		
		Vector<String> where = new Vector<String>();
		for(String s : DBConst.updatePodlogaWhere) where.add(s + idPodloge);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBPodloge, what, values, where));
		
	}
	/*
	 * Update Sorta
	 */
	public static void updateSorta(int idSorta, String imeSorte, String vrstaSorte)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateSortaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(imeSorte);
		values.add(vrstaSorte);
		
		Vector<String> where = new Vector<String>();
		for(String s : DBConst.updateSortaWhere) where.add(s + idSorta);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBSorte, what, values, where));
		
	}
	/*
	 * Update Posadeno
	 */
	public static void updatePosadeno(int idPosadeno, String nazivPosadeno, int sortaID, int podlogaID)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updatePosadenoWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(nazivPosadeno);
		values.add(String.valueOf(sortaID));
		values.add(String.valueOf(podlogaID));
		
		Vector<String> where = new Vector<String>();
		for(String s : DBConst.updatePosadenoWhere) where.add(s + idPosadeno);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBPosadeno, what, values, where));
		
	}
	/*
	 * Update Red
	 */
	public static void updateRed(int nasadID, int brojReda, int brojSadnihMjesta)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateRedWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(brojReda));
		values.add(String.valueOf(brojSadnihMjesta));
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.updateRedWhere[0] + nasadID);
		where.add(DBConst.updateRedWhere[1] + brojReda);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBRedovi, what, values, where));
		
	}
	/*
	 * Update Sadrzaj Reda
	 */
	public static void updateSadrzajReda(int redID, int brojSadnogMjesta, int PosadenoID, LocalDate datumSadnje)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateSadrzajRedaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(PosadenoID));
		values.add(String.valueOf(Date.valueOf(datumSadnje).toString()));
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.updateSadrzajRedaWhere[0] + redID);
		where.add(DBConst.updateSadrzajRedaWhere[1] + brojSadnogMjesta);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBSadrzajReda, what, values, where));
	}
	
	public static void updateCijeliSadrzajReda(int redID, int PosadenoID, LocalDate datumSadnje)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateCijeliSadrzajRedaWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(String.valueOf(PosadenoID));
		values.add(String.valueOf(Date.valueOf(datumSadnje).toString()));
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.updateCijeliSadrzajRedaWhere[0] + redID);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBSadrzajReda, what, values, where));
	}
	/*
	 * Update Nasad
	 */
	public static boolean updateNasad(int idNasad, String arkodID, int userID, String naziv, int povrsina, String lokacija, int navodnjavanjeID, int karencaID, int brojRedova)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateNasadWhat) what.add(s);
		
		Vector<String> values = new Vector<String>();
		values.add(naziv);
		values.add(arkodID);
		values.add(String.valueOf(povrsina));
		values.add(lokacija);
		values.add(String.valueOf(navodnjavanjeID));
		values.add(String.valueOf(karencaID));
		values.add(String.valueOf(brojRedova));
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.updateNasadWhere[0] + idNasad);
		where.add(DBConst.updateNasadWhere[1] + userID);
		
		if(Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBNasad, what, values, where))!=0) return true;
		else return false;
		
	}
	/*
	 * Increment broj redova u nasadu
	 */
	public static void updateNasadIncBrojRedova(int idNasad, int userID)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.updateNasadIncBrojRedovaWhat) what.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.updateNasadIncBrojRedovaWhere[0] + idNasad);
		where.add(DBConst.updateNasadIncBrojRedovaWhere[1] + userID);
		
		Utilities.executeUpdate(Utilities.fetchStrBuilderUpdIns(DBConst.purposeUpdate, DBConst.dBNasad, what, DBConst.emptyVector, where));
		
	}
	
}

