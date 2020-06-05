package orgNasada2.radSBazom;

import java.util.Vector;

import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import orgNasada2.PodatkovneKlase.Korisnik;
import orgNasada2.PodatkovneKlase.Nasad;
import orgNasada2.PodatkovneKlase.Navodnjavanje;
import orgNasada2.PodatkovneKlase.Podloga;
import orgNasada2.PodatkovneKlase.PosaðenoInfo;
import orgNasada2.PodatkovneKlase.RedInfo;
import orgNasada2.PodatkovneKlase.Sorta;
import orgNasada2.PodatkovneKlase.Sredstvo;

public class DBSelect {
	
	private static final Logger logger = Logger.getLogger(DBSelect.class);

	public void initialize(){}
	
	/* Select  
	 * What - 1 - mandatory (M)
	 * As - 2 - non Mandatory (NM)
	 * From
	 * Join
	 * Where - 3 - M
	 * Where isActive - 4 M
	 * Order By - 5 - NM
	 */
	
	
	public static Nasad getNasadKorisnikaPod(int userID, String nazivNasada)
	{
		if(!nazivNasada.equals(" "))
		{
		 		Vector<String> what = new Vector<String>();
		 		for(String s : DBConst.nasadDataFetchWhat) what.add(s);
		 		
		 		Vector<String> where = new Vector<String>();
		 		where.add(DBConst.nasadDataFetchWhere[0] + userID);
		 		where.add(DBConst.nasadDataFetchWhere[1] + "'" + nazivNasada + "' ");

				return Utilities.query2Nasad(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNasad, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector));
		}
		return null;
	}
	
	public static TableModel getNasadKorisnika(String user, String nazivNasada)
	{
		if(!nazivNasada.equals(" "))
		{
		 		Vector<String> what = new Vector<String>();
		 		for(String s : DBConst.nasadPrikazWhat) what.add(s);
		 		
		 		Vector<String> as = new Vector<String>();
		 		for(String s : DBConst.nasadPrikazAs) as.add(s);
				
				Vector<String> join = new Vector<String>();
				for(String s : DBConst.nasadPrikazJoin) join.add(s);
				
				Vector<String> joinOn = new Vector<String>();
				for(String s : DBConst.nasadPrikazJoinOn) joinOn.add(s);
				
				Vector<String> joinFrom = new Vector<String>();
				for(String s : DBConst.nasadPrikazJoinFrom) joinFrom.add(s);
				
				Vector<String> where = new Vector<String>();
				where.add(DBConst.dBColUserKorIme + " = '" + user + "'");
				where.add(DBConst.dBColNasNaziv+ " = '" + nazivNasada + "'");
				
		 		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBNasad, join, joinOn, joinFrom, where, DBConst.emptyVector));
			}
		return null;
	}
	
	
	
	public static int getIdNasada(Korisnik user, String imeNasada)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.nasadGetIdByNameWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		where.add(DBConst.nasadGetIdByNameWhere[0] + user.getId());
 		where.add(DBConst.nasadGetIdByNameWhere[1] + "'" + imeNasada +"'");

		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNasad, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector)).firstElement();
	}
	
	public static Vector<Integer> getAllIDSorte()
	{
		Vector<String> what = new Vector<String>();
 		what.add("idSorte");
 		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSorte, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector));
	}
	public static Vector<Integer> getAllIDPodloge()
	{
		Vector<String> what = new Vector<String>();
 		what.add("idPodloge");
 		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPodloge, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector));
	}
	public static Vector<Integer> getAllIDNavodnjavanje()
	{
		Vector<String> what = new Vector<String>();
 		what.add("idNavodnjavanje");
 		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNavodnjavanje, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector));
	}
	
	public static Vector<Integer> getAllIDSadnice()
	{
		Vector<String> what = new Vector<String>();
 		what.add("idPosaðeno");
 		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPosaðeno, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector));
	}

	public static TableModel getSveNasadeKorisnika(String user)
	{
 		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.nasadPrikazWhat) what.add(s);
		
		Vector<String> join = new Vector<String>();
		for(String s : DBConst.nasadPrikazJoin) join.add(s);
		
		Vector<String> joinOn = new Vector<String>();
		for(String s : DBConst.nasadPrikazJoinOn) joinOn.add(s);
		
		Vector<String> joinFrom = new Vector<String>();
		for(String s : DBConst.nasadPrikazJoinFrom) joinFrom.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add("Users.korisnickoIme = '" + user + "'");
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNasad, join, joinOn, joinFrom, where, DBConst.emptyVector));
		
 }
	
	public static Vector<String> getImenaNasadaKorisnika(String user)
	{
 		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.nasadPrikazImenaWhat) what.add(s);
		
		Vector<String> join = new Vector<String>();
		for(String s : DBConst.nasadPrikazImenaJoin) join.add(s);
		
		Vector<String> joinOn = new Vector<String>();
		for(String s : DBConst.nasadPrikazImenaJoinOn) joinOn.add(s);
		
		Vector<String> joinFrom = new Vector<String>();
		for(String s : DBConst.nasadPrikazImenaJoinFrom) joinFrom.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add("Users.korisnickoIme = '" + user + "'");
		
		return Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNasad, join, joinOn, joinFrom, where, DBConst.emptyVector));
		
 }

	public static Vector<String> getImenaSadnica()
	{
 		Vector<String> what = new Vector<String>();
 		what.add(DBConst.vockeNaziviWhat);
				
		return Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPosaðeno, 
				DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector));
	}
	
	public static TableModel getPosaðenoByName(String imePosaðenog)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.posaðenoPrikazWhat) what.add(s);
		
 		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.posaðenoPrikazAs) as.add(s);
 		
		Vector<String> join = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazJoin) join.add(s);
		
		Vector<String> joinOn = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazJoinOn) joinOn.add(s);
		
		Vector<String> joinFrom = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazJoinFrom) joinFrom.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add("posaðeno.nazivPosaðeno = '" + imePosaðenog + "' ");
		
		Vector<String> ordering = new Vector<String>();
		for(String s: DBConst.posaðenoPrikazOrdering) ordering.add(s);
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBPosaðeno, join, joinOn, joinFrom, where, ordering));
		
	}
	
	public static boolean checkPostojanjedBSadrzajReda(int redID, int brojMjesta)
	{
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(DBSelect.getNotExistsSadrzajRedaQuery(redID, brojMjesta));
		return Utilities.query2hasResult(sqlQuery);
	}
	
	public static String getNotExistsSadrzajRedaQuery(int redID, int brojMjesta)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sadrzajRedaCheckPosaðenoWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		where.add(DBConst.sadrzajRedaCheckPosaðenoWhere[0] + String.valueOf(redID));
 		where.add(DBConst.sadrzajRedaCheckPosaðenoWhere[1] + String.valueOf(brojMjesta));
 		
		return Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSadrzajReda, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector).toString();
	}
	
	public static int getBrojSadnihMjestaURedu(int redID)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.redoviBrojMjestaWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		for(String s : DBConst.redoviBrojMjestaWhere) where.add(s + "'" + redID + "'");
 		
 		Vector<Integer> vecInt = new Vector<Integer>();
 		vecInt.addAll(Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBRedovi, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector)));
 		return vecInt.firstElement();
	}
	
	public static Sredstvo getSredstvo(int idSredstvo)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sredstvaPrikazWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		where.add(" idSredstva = " + idSredstvo + " ");	
 		
 		return Utilities.query2Sredstvo(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSredstva, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector));
 		
	}
	
	public static Vector<RedInfo> getRedoviInfo(int nasadID)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.redoviInfoAllWhat) what.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add(" nasadID = " + nasadID);
		
		return Utilities.query2VecRedInfo(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBRedovi, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector));
		
	}

	public static TableModel getSadrzajReda(int idNasad, String imeVocke, String brojReda)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sadrzajRedaWhat) what.add(s);
 		
 		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.sadrzajRedaAs) as.add(s);
		
		Vector<String> join = new Vector<String>();
		for(String s : DBConst.sadrzajRedaJoin) join.add(s);
		
		Vector<String> joinOn = new Vector<String>();
		for(String s : DBConst.sadrzajRedaJoinOn) joinOn.add(s);
		
		Vector<String> joinFrom = new Vector<String>();
		for(String s : DBConst.sadrzajRedaJoinFrom) joinFrom.add(s);
		
		Vector<String> ordering = new Vector<String>();
		for(String s : DBConst.sadrzajRedaOrdering) ordering.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add("redovi.nasadID = " + idNasad + " ");
		if(!imeVocke.equals("")) where.add("posaðeno.nazivPosaðeno = '" + imeVocke + "' ");
		if(!brojReda.equals("")) where.add("redovi.brojReda = " + brojReda + " ");
		
		logger.info("Sadrzaj Reda Query, Nasad ID: " + idNasad + " ");
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBSadrzajReda, join, joinOn, joinFrom, where, ordering));
	
	}
	
	public static TableModel getPosaðeno()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.posaðenoPrikazCondWhat) what.add(s);
 		
		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.posaðenoPrikazCondAs) as.add(s);
		
		Vector<String> join = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazCondJoin) join.add(s);
		
		Vector<String> joinOn = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazCondJoinOn) joinOn.add(s);
		
		Vector<String> joinFrom = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazCondJoinFrom) joinFrom.add(s);
		
		Vector<String> where = new Vector<String>();
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBPosaðeno, join, joinOn, joinFrom, where,  DBConst.emptyVector));
		}
	
	public static PosaðenoInfo getPosaðenoByID(int id)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.posaðenoPrikazCondWhat) what.add(s);
		
		Vector<String> join = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazCondJoin) join.add(s);
		
		Vector<String> joinOn = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazCondJoinOn) joinOn.add(s);
		
		Vector<String> joinFrom = new Vector<String>();
		for(String s : DBConst.posaðenoPrikazCondJoinFrom) joinFrom.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.posaðenoPrikazByIdWhere + id);
		
		return Utilities.query2PosaðenoInfo(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPosaðeno, join, joinOn, joinFrom, where,  DBConst.emptyVector));
		}
	
	public static TableModel getNavodnjavanje()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.navodnjavanjePrikazWhat) what.add(s);
 		
		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.navodnjavanjePrikazAs) as.add(s);
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBNavodnjavanje, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static int getNavodnjavanjeID(String name)
	{
		Vector<String> what = new Vector<String>();
		for(String s: DBConst.navodnjavanjePrikazByNameWhat) what.add(s);
		
		Vector<String> where = new Vector<String>();
		for(String s: DBConst.navodnjavanjePrikazByNameWhere) where.add(s + "'" + name + "' ");
		
		Vector<Integer> vecInt = new Vector<Integer>();
		vecInt.addAll(Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNavodnjavanje, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector)));
		return vecInt.firstElement();
	}
	
	public static String getNavodnjavanjeNaziv(int idNavodnjavanje)
	{
		Vector<String> what = new Vector<String>();
		what.add(DBConst.nazivNavodnjavanja);
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.nazivNavodnjavanjaByIDWhere + "'" + idNavodnjavanje + "' ");
		
		Vector<String> vecStr = new Vector<String>();
		vecStr.addAll(Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNavodnjavanje, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector)));
		return vecStr.firstElement();
	}
	
	public static Navodnjavanje getNavodnjavanje(int idNavodnjavanje)
	{
		Vector<String> what = new Vector<String>();
		for(String s : DBConst.navodnjavanjePrikazWhat) what.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.nazivNavodnjavanjaByIDWhere + "'" + idNavodnjavanje + "' ");		

		return Utilities.query2Navodnjavanje(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNavodnjavanje, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector));
	}
	
	public static int getPosaðenoID(String name)
	{
		Vector<String> what = new Vector<String>();
		for(String s: DBConst.posaðenoIDByNameWhat) what.add(s);
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.posaðenoIDByNameWhere[0] + "'" + name + "' ");
		
		Vector<Integer> vecInt = new Vector<Integer>();
		vecInt.addAll(Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPosaðeno, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector)));
		return vecInt.firstElement();
	}
	
	

	public static Vector<String> getNavodnjavanjeVec()
	{
		Vector<String> what = new Vector<String>();
 		what.add(DBConst.nazivNavodnjavanja);
 		
		return Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBNavodnjavanje, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static TableModel getPodloge()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.podlogePrikazWhat) what.add(s);
 		
		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.podlogePrikazAs) as.add(s);
 		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBPodloge, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static Podloga getPodlogeById(int id)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.podlogePrikazWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		where.add(DBConst.podlogePrikazWhere + "'" + id + "'");
 		
		return Utilities.query2Podloga(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPodloge, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector));
	}
	
	public static Vector<String> getPodlogeVS()
	{
		Vector<String> what = new Vector<String>();
 		what.add("nazivPodloge");
 		
		return Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPodloge, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static int getPodlogeID(String naziv)
	{
		Vector<String> what = new Vector<String>();
 		what.add("idPodloge");
 		
 		Vector<String> where = new Vector<String>();
 		where.add("nazivPodloge = '" + naziv + "' " );
 		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBPodloge, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector)).firstElement();
	}

	public static TableModel getSorte()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sortePrikazWhat) what.add(s);
 		
		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.sortePrikazAs) as.add(s);
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBSorte, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static Sorta getSorteById(int id)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sortePrikazWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		where.add("idSorte = '" + id + "' " );
		
		return Utilities.query2Sorta(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSorte, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static Vector<String> getSorteVS()
	{
		Vector<String> what = new Vector<String>();
 		what.add("imeSorte");
		
		return Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSorte, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static int getSorteID(String naziv)
	{
		Vector<String> what = new Vector<String>();
 		what.add("idSorte");
 		
 		Vector<String> where = new Vector<String>();
 		where.add("imeSorte = '" + naziv + "' " );
 		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSorte, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where,  DBConst.emptyVector)).firstElement();
	}
	
	public static TableModel getSredstva()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sredstvaPrikazWhat) what.add(s);
 		
 		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.sredstvaPrikazAs) as.add(s);
		
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBSredstva, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector,  DBConst.emptyVector));
	}
	
	public static TableModel getAktivneKarence()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.karenceAktivneWhat) what.add(s);
 		
		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.karenceAktivneAs) as.add(s);
 		
 		Vector<String> join = new Vector<String>();
 		for(String s : DBConst.karenceAktivneJoin) join.add(s);
 		
 		Vector<String> joinOn = new Vector<String>();
 		for(String s : DBConst.karenceAktivneJoinOn) joinOn.add(s);
 		
 		Vector<String> joinFrom = new Vector<String>();
 		for(String s : DBConst.karenceAktivneJoinFrom) joinFrom.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		for(String s : DBConst.karenceAktivneWhere) where.add(s);
				
		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBKarenca, join, joinOn, joinFrom, where, DBConst.emptyVector));
	}
	
	public static TableModel getSveKarence()
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.karenceWhat) what.add(s);
 		
 		Vector<String> as = new Vector<String>();
 		for(String s : DBConst.karenceAs) as.add(s);
 		
 		Vector<String> join = new Vector<String>();
 		for(String s : DBConst.karenceJoin) join.add(s);
 		
 		Vector<String> joinOn = new Vector<String>();
 		for(String s : DBConst.karenceJoinOn) joinOn.add(s);
 		
 		Vector<String> joinFrom = new Vector<String>();
 		for(String s : DBConst.karenceJoinFrom) joinFrom.add(s);
 		
 		return Utilities.query2TabMod(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, as, DBConst.dBKarenca, join, joinOn, joinFrom, DBConst.emptyVector, DBConst.emptyVector));
		
	}
	
	public static Vector<String> getSvaSredstvaNames()
	{		
		Vector<String> what = new Vector<String>();
		what.add(DBConst.sredstvaPrikazNamesWhat);
 		
 		return Utilities.query2VecStr(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBSredstva, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector));
 }

	public static Vector<Integer> getTrajanjeKarenca(int sredstvoID)
	{
		Vector<String> what = new Vector<String>();
 		for(String s : DBConst.sredstvaPrikazTrajanjeKarenceWhat) what.add(s);
 		
 		Vector<String> where = new Vector<String>();
 		where.add(DBConst.sredstvaPrikazTrajanjeKarenceWhere + sredstvoID);
 				
		Vector<Integer> vecInt = new Vector<Integer>();
		vecInt.addAll(Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBKarenca, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector)));
		return vecInt;
	}

	public static int getBrojRedovaUNasadu(int idNasad) {
		Vector<String> what = new Vector<String>();
		what.add(DBConst.brojRedovaNasadaUDBWhat);
		
		Vector<String> as = new Vector<String>();
		as.add(DBConst.brojRedovaNasadaUDBAs);
		
		Vector<String> where = new Vector<String>();
		where.add(DBConst.brojRedovaNasadaUDBWhere + idNasad);
		
		return Utilities.query2VecInt(Utilities.fetchStrBuilderSelect(DBConst.purposeSelect, what, DBConst.emptyVector, DBConst.dBRedovi, DBConst.emptyVector, DBConst.emptyVector, DBConst.emptyVector, where, DBConst.emptyVector)).firstElement();
	}
}