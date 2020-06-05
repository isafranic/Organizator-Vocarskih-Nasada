package orgNasada2.radSBazom;

import java.util.Vector;

public class DBConst {
	
	/*
	 * DB Connections
	 */
	public static final String databaseDriverJDBC = "com.mysql.cj.jdbc.Driver";
	public static final String databaseURL = "jdbc:mysql://localhost:3306/organizatorNasadaDB?serverTimezone=UTC";  
	public static final String databaseCredUser = "user"; 
	public static final String databaseCredPass = "pass";
	/*
	 * Constant za Naredbe
	 */
	public static final String purposeSelect = "SELECT ";
	public static final String purposeUpdate = "UPDATE ";
	public static final String purposeInsert = "INSERT INTO ";
	public static final Vector<String> emptyVector = new Vector<String>();
	public static final String isActive = ".isActive = true ";
	public static final String emptyString = "";
	public static final String equalsString = " = ";
	/*
	 * Imena tablica u bazi podataka
	 */
	public static final String dBKarenca = "karenca";
	public static final String dBNasad = "nasad";
	public static final String dBNavodnjavanje = "navodnjavanje";
	public static final String dBPodloge = "podloge";
	public static final String dBPosaðeno = "posaðeno";
	public static final String dBRedovi = "redovi";
	public static final String dBSadrzajReda = "sadrzajReda";
	public static final String dBSorte = "sorte";
	public static final String dBSredstva = "sredstva";
	public static final String dBUsers = "users";	
	/*
	 * Users column names
	 */
	public static final String dBColUserID = dBUsers + ".idUser";
	public static final String dBColUserIme = dBUsers + ".ime";
	public static final String dBColUserKorIme = dBUsers + ".korisnickoIme";
	public static final String dBColUserPass = dBUsers + ".sifra";
	/*
	 * Karenca column names
	 */
	public static final String dBColKarIDKarenca = dBKarenca + ".idKarenca";
	public static final String dBColKarSredstvoID = dBKarenca + ".sredstvoID";
	public static final String dBColKarDatTret = dBKarenca + ".datumTretiranja";
	public static final String dBColKarDatIstRad = dBKarenca + ".datumIstekaRadno";
	public static final String dBColKarDatIstKon = dBKarenca + ".datumIstekaKonzumno";
	/*
	 * Karenca CN visual
	 */
	public static final String vKarencaID = "'Karenca ID'";
	public static final String vKarTret = "'Datum Tretiranja'";
	public static final String vKarRad = "'Radna KR'";
	public static final String vKarKon = "'Konzumna KR'";
	/*
	 * Nasad column names
	 */
	public static final String dBColNasIDNasad = dBNasad + ".idNasad";
	public static final String dBColNasArkodID = dBNasad + ".arkodID";
	public static final String dBColNasUserID = dBNasad + ".userID";
	public static final String dBColNasNaziv = dBNasad + ".naziv";
	public static final String dBColNasPovrsina = dBNasad + ".povrsina";
	public static final String dBColNasLokacija = dBNasad + ".lokacija";
	public static final String dBColNasNavID = dBNasad + ".navodnjavanjeID";
	public static final String dBColNasKarID = dBNasad + ".karencaID";
	public static final String dBColNasBrojRedova = dBNasad + ".brojRedova";
	/*
	 * Nasad CN visual
	 */
	public static final String vNasadID = "'Nasad ID'";
	public static final String vNasad = "'Nasad'";
	public static final String vNasadArkod = "'ARKOD'";
	public static final String vNasadPovrsina = "'Povrsina'";
	public static final String vNasadLokacija = "'Lokacija'";
	public static final String vNasadBrRed = "'Redova'";
	/*
	 * Navodnjvanje column names
	 */
	public static final String dBColNavIDNav = dBNavodnjavanje + ".idNavodnjavanje";
	public static final String dBColNavNaziv = dBNavodnjavanje + ".nazivNavodnjavanja";
	/*
	 * Navodnjavanje CN visual
	 */
	public static final String vNavodnjavanjeID = "'Navodnjavanje ID'";
	public static final String vNavodnjavanje = "'Navodnjavanje'";
	/*
	 * Podloge column names
	 */
	public static final String dBColPodIDPod = dBPodloge + ".idPodloge";
	public static final String dBColPodNaziv = dBPodloge + ".nazivPodloge";
	public static final String dBColPodBujnost = dBPodloge + ".bujnostPodloge";
	/*
	 * Podloge CN visual
	 */
	public static final String vPodlogeID = "'Podloge ID'";
	public static final String vPodloga = "'Podloga'";
	public static final String vPodBujnost = "'Bujnost'";
	/*
	 * Posaðeno column names
	 */
	public static final String dBColPosIDPos = dBPosaðeno + ".idPosaðeno";
	public static final String dBColPosSorteID = dBPosaðeno + ".sorteID";
	public static final String dBColPosPodlogeID = dBPosaðeno + ".podlogeID";
	public static final String dBColPosNaziv = dBPosaðeno + ".nazivPosaðeno";
	/*
	 * Posaðeno CN visual
	 */
	public static final String vPosaðenoID = "'Posaðeno ID'";
	public static final String vPosaðeno = "'Vocka'";
	public static final String vDatumSadnje = "'Sadnja'";
	/*
	 * Redovi column names
	 */
	public static final String dBColRedIDReda = dBRedovi + ".idReda";
	public static final String dBColRedNasadID = dBRedovi + ".nasadID";
	public static final String dBColRedBrojReda = dBRedovi + ".brojReda";
	public static final String dBColRedBrojSadMjesta = dBRedovi + ".brojSadnihMjesta";
	/*
	 * Redovi CN visual
	 */
	public static final String vRedoviBrMjesta = "'Mjesto'";
	public static final String vRedoviBrReda = "'Red'";
	/*
	 * Sadrzaj Reda column names
	 */
	public static final String DBColSadRedID = dBSadrzajReda + ".idSadrzajReda";
	public static final String dBColSadRedRedID = dBSadrzajReda + ".redID";
	public static final String dBColSadRedPosID = dBSadrzajReda + ".posaðenoID";
	public static final String dBColSadRedBrojMjesta = dBSadrzajReda + ".brojMjesta";
	public static final String dBColSadRedDatumSadnje = dBSadrzajReda + ".datumSadnje";
	/*
	 * Sadrzaj Redova CN visual
	 */
	public static final String vSadRedovaBrMjesta = "'Mjesto'";
	/*
	 * Sorte column names
	 */
	public static final String dBColSorID = dBSorte + ".idSorte";
	public static final String dBColSorIme = dBSorte + ".imeSorte";
	public static final String dBColSorVrsta = dBSorte + ".vrstaSorte";
	/*
	 * Sorte CN visual
	 */
	public static final String vSorteID = "'Sorte ID'";
	public static final String vSorta = "'Sorta'";
	public static final String vSorteVrsta = "'Vrsta'";
	/*
	 * Sredstva column names
	 */
	public static final String dBColSredID = dBSredstva + ".idSredstva";
	public static final String dBColSredNaziv = dBSredstva + ".nazivSredstva";
	public static final String dBColSredTipTret = dBSredstva + ".tipTretiranja";
	public static final String dBColSredAktTvar = dBSredstva + ".aktivnaTvar";
	public static final String dBColSredSvrha = dBSredstva + ".svrhaSredstva";
	public static final String dBColSredKarRad = dBSredstva + ".karencaRadno";
	public static final String dBColSredKarKon = dBSredstva + ".karencaKonzumno";
	/*
	 * Sredstva CN visual
	 */
	public static final String vSredstvoID = "'Sredstvo ID'";
	public static final String vSredstvo = "'Sredstvo'";
	public static final String vSredTT = "'Tip Tretiranja'";
	public static final String vSredAktTvar = "'Aktivna Tvar'";
	public static final String vSredSvrha = "'Svrha'";
	public static final String vSredKarRad = "'Radna Kar (d)'";
	public static final String vSredKarKon = "'Konzumna Kar (d)'";
	/*
	 * Table Model Visual
	 */
	public static final String vID = "'ID'";
	public static final String vNaziv = "'Naziv'";
	public static final String vUserID = "'User ID'";
	/*
	 * Nasad prikaz
	 */
	public static final String[] nasadPrikazWhat = {dBColNasIDNasad, dBColNasArkodID, dBColNasUserID, dBColNasNaziv
			,dBColNasLokacija, dBColNasPovrsina, dBColNasBrojRedova, dBColNavNaziv, dBColSredNaziv
			,dBColKarDatIstRad, dBColKarDatIstKon};
	public static final String[] nasadPrikazAs = {vNasadID, vNasadArkod, vUserID, vNaziv, vNasadLokacija, vNasadPovrsina, vNasadBrRed, vNavodnjavanje, vSredstvo, vKarRad, vKarKon};
	public static final String[] nasadPrikazJoin = {dBUsers, dBNavodnjavanje, dBKarenca, dBSredstva};
	public static final String[] nasadPrikazJoinOn = {dBColNasUserID, dBColNasNavID, dBColNasKarID, dBColKarSredstvoID};
	public static final String[] nasadPrikazJoinFrom = {dBColUserID, dBColNavIDNav, dBColKarIDKarenca, dBColSredID};
	/*
	 * Nasad data fetch
	 */
	public static final String[] nasadDataFetchWhat = {"*"};
	public static final String[] nasadDataFetchWhere = {dBColNasUserID + equalsString, dBColNasNaziv + equalsString};
	/*
	 * Nasad prikaz imena
	 */
	public static final String[] nasadPrikazImenaWhat = {dBColNasNaziv};
	public static final String[] nasadPrikazImenaJoin = {dBUsers};
	public static final String[] nasadPrikazImenaJoinOn = {dBColNasUserID};
	public static final String[] nasadPrikazImenaJoinFrom = {dBColUserID};
	/*
	 * Nasad dohvati ID
	 */
	public static final String[] nasadGetIdByNameWhat = {dBColNasIDNasad};
	public static final String[] nasadGetIdByNameWhere = {dBColNasUserID +equalsString, dBColNasNaziv + equalsString};
	/*
	 * Nasad broj Redova
	 */
	public static final String[] nasadBrojRedovaWhat = {dBColNasBrojRedova};
	public static final String[] nasadBrojRedovaWhere = {dBColNasIDNasad + equalsString};
	/*
	 * Sljedeci red u nasadu
	 */
	public static final String[] nasadNextRedWhat = {dBColNasBrojRedova, "COUNT(" + dBColRedNasadID + " )"};
	public static final String[] nasadNextRedAs = {"'Max'", "'Cur'"};
	public static final String[] nasadNextRedWhere = {dBColNasIDNasad +equalsString, dBColRedNasadID + equalsString};
	public static final String[] nasadNextRedJoin = {dBNasad};
	public static final String[] nasadNextRedJoinOn = {dBColRedNasadID};
	public static final String[] nasadNextRedJoinFrom = {dBColNasIDNasad};
	/*
	 * Redovi broj Reda
	 */
	public static final String[] redoviBrojRedaWhat = {dBColRedBrojReda};
	public static final String[] redoviBrojRedaWhere = {dBColRedNasadID+ equalsString};	
	/*
	 * Redovi broj Mjesta
	 */
	public static final String[] redoviBrojMjestaWhat = {dBColRedBrojSadMjesta};
	public static final String[] redoviBrojMjestaWhere = {dBColRedIDReda + equalsString};
	/*
	 * Redovi get all
	 */
	public static final String[] redoviInfoAllWhat = {dBColRedIDReda, dBColRedNasadID, dBColRedBrojReda, dBColRedBrojSadMjesta};
	/*
	 * Redovi broj redova u nasadu
	 * Select count(nasadID) as brojRedova from redovi where nasadID = 1;
	 */
	public static final String brojRedovaNasadaUDBWhat = "count(" + dBColRedNasadID + " )";
	public static final String brojRedovaNasadaUDBAs = "Broj Redova";
	public static final String brojRedovaNasadaUDBWhere = dBColRedNasadID + equalsString;
	/*
	 * Redovi idReda
	 */
	public static final String[] redoviIDRedaWhat = {dBColRedIDReda};
	public static final String[] redoviIDRedaWhere = {dBColRedNasadID + equalsString, dBColRedBrojReda + equalsString};
	/*
	 *  Sadrzaj Reda Prikaz
	 */
	public static final String[] sadrzajRedaWhat = {dBColRedBrojReda ,dBColSadRedBrojMjesta ,dBColPosNaziv ,dBColSadRedDatumSadnje};
	public static final String[] sadrzajRedaAs = {vRedoviBrReda, vSadRedovaBrMjesta, vPosaðeno, vDatumSadnje};
	public static final String[] sadrzajRedaJoin = {dBRedovi, dBPosaðeno};
	public static final String[] sadrzajRedaJoinOn = {dBColSadRedRedID, dBColSadRedPosID};
	public static final String[] sadrzajRedaJoinFrom = {dBColRedIDReda, dBColPosIDPos};
	public static final String[] sadrzajRedaOrdering = {dBColRedBrojReda, dBColSadRedBrojMjesta};
	/*
	 * Posaðeno prikaz 
	 */
	public static final String[] posaðenoPrikazWhat = {dBColPosIDPos, dBColPosNaziv, dBColSorIme, dBColSorVrsta, dBColPodNaziv, dBColPodBujnost};
	public static final String[] posaðenoPrikazAs = {vPosaðenoID, vNaziv, vSorta, vSorteVrsta, vPodloga, vPodBujnost};
	public static final String[] posaðenoPrikazJoin = {dBSadrzajReda,dBSorte, dBPodloge};
	public static final String[] posaðenoPrikazJoinOn = {dBColPosIDPos,dBColPosSorteID,dBColPosPodlogeID};
	public static final String[] posaðenoPrikazJoinFrom = {dBColSadRedPosID,dBColSorID,dBColPodIDPod};
	public static final String[] posaðenoPrikazOrdering = {dBColPosNaziv + " LIMIT 1"};
	// prikaz informacija o posaðenom
	public static final String posaðenoPrikazByIdWhere = dBColPosIDPos + equalsString;
	
	/*
	 * Posaðeno prikaz condensed
	 */
	public static final String[] posaðenoPrikazCondWhat = {dBColPosIDPos, dBColPosNaziv, dBColSorIme,dBColPodNaziv};
	public static final String[] posaðenoPrikazCondAs = {vPosaðenoID, vNaziv, vSorta, vPodloga};
	public static final String[] posaðenoPrikazCondJoin = {dBSorte,dBPodloge};
	public static final String[] posaðenoPrikazCondJoinOn = {dBColPosSorteID,dBColPosPodlogeID};
	public static final String[] posaðenoPrikazCondJoinFrom = {dBColSorID,dBColPodIDPod};
	/*
	 * get Posaðeno ID By Name
	 */
	public static final String[] posaðenoIDByNameWhat = {dBColPosIDPos};
	public static final String[] posaðenoIDByNameWhere = {dBColPosNaziv + equalsString};
	/*
	 * Navodnjavanje prikaz sva
	 */
	public static final String[] navodnjavanjePrikazWhat = {dBColNavIDNav,dBColNavNaziv};
	public static final String[] navodnjavanjePrikazAs = {vNavodnjavanjeID, vNaziv};
	/*
	 * Navodnjavanje prikaz names
	 */
	public static final String nazivNavodnjavanja = dBColNavNaziv;
	public static final String nazivNavodnjavanjaByIDWhere = dBColNavIDNav + equalsString;
	/*
	 * Navodnjavanje prikaz id po imenu 
	 */
	public static final String[] navodnjavanjePrikazByNameWhat = {dBColNavIDNav};
	public static final String[] navodnjavanjePrikazByNameWhere = {dBColNavNaziv + equalsString};
	/*
	 * Sredstva prikaz sva
	 */
	public static final String[] sredstvaPrikazWhat = {dBColSredID, dBColSredNaziv, dBColSredTipTret ,dBColSredAktTvar ,dBColSredSvrha ,dBColSredKarRad ,dBColSredKarKon };	
	public static final String[] sredstvaPrikazAs = {vSredstvoID, vNaziv, vSredTT, vSredAktTvar, vSredSvrha, vSredKarRad, vSredKarKon};
	/*
	 * Sredstva prikaz trajanjeKarence
	 */
	public static final String[] sredstvaPrikazTrajanjeKarenceWhat = {dBColSredKarRad, dBColSredKarKon};
	public static final String sredstvaPrikazTrajanjeKarenceWhere = dBColSredID + equalsString;
	/*
	 * Sredstva prikaz imena
	 */
	public static final String sredstvaPrikazNamesWhat = dBColSredNaziv;
	/*
	 * Karenca prikaz sve
	 */
	public static final String[] karenceWhat = {dBColKarIDKarenca, dBColNasNaziv, dBColSredNaziv, dBColKarDatTret, dBColKarDatIstRad, dBColKarDatIstKon};
	public static final String[] karenceAs = {vKarencaID, vNasad, vSredstvo, vKarTret, vKarRad, vKarKon};
	public static final String[] karenceJoin = {dBNasad, dBSredstva};
	public static final String[] karenceJoinOn = {dBColKarIDKarenca, dBColKarSredstvoID};
	public static final String[] karenceJoinFrom = {dBColNasKarID, dBColSredID};
	/*
	 * Karenca prikaz aktivne
	 */
	public static final String[] karenceAktivneWhat = {dBColKarIDKarenca, dBColNasNaziv, dBColSredNaziv, dBColKarDatTret,  dBColKarDatIstRad, dBColKarDatIstKon};
	public static final String[] karenceAktivneAs = {vKarencaID, vNasad, vSredstvo, vKarTret, vKarRad, vKarKon};
	public static final String[] karenceAktivneJoin = {dBNasad, dBSredstva};
	public static final String[] karenceAktivneJoinOn = {dBColKarIDKarenca, dBColKarSredstvoID};
	public static final String[] karenceAktivneJoinFrom = {dBColNasKarID, dBColSredID};
	public static final String[] karenceAktivneWhere = {dBColKarDatIstRad + " > GETDATE() "};
	/*
	 * Sorte prikaz
	 */
	public static final String[] sortePrikazWhat = {dBColSorID , dBColSorIme , dBColSorVrsta };
	public static final String[] sortePrikazAs = {vSorteID, vNaziv, vSorteVrsta};
	/*
	 * Sadnice nazivi
	 */
	public static final String vockeNaziviWhat = dBColPosNaziv ;
	/*
	 * Podloge prikaz
	 */
	public static final String[] podlogePrikazWhat = {dBColPodIDPod ,dBColPodNaziv ,dBColPodBujnost };
	public static final String[] podlogePrikazAs = {vPodlogeID, vNaziv, vPodBujnost};
	public static final String podlogePrikazWhere = dBColPodIDPod  + equalsString;
	/*
	 * Unesi Nasad
	 */
	public static final String[] unesiNasadWhat = {dBColNasUserID ,dBColNasArkodID , dBColNasNaziv ,dBColNasPovrsina ,dBColNasLokacija ,dBColNasNavID ,dBColNasKarID ,dBColNasBrojRedova };
	/*
	 * Unesi Red
	 */
	public static final String[] unesiRedWhat = {dBColRedNasadID, dBColRedBrojSadMjesta, dBColRedBrojReda};
	/*
	 * Unesi Sadrzaj Reda
	 */
	public static final String[] unesiSadrzajRedaWhat = {dBColSadRedRedID, dBColSadRedPosID ,dBColSadRedBrojMjesta ,dBColSadRedDatumSadnje };
	public static final String[] unesiSadrzajRedaWhereNotExists = {" NOT EXISTS ( "};
	/*
	 * Sadrzaj Reda check exists
	 */
	public static final String[] sadrzajRedaCheckPosaðenoWhat = {dBColSadRedPosID };
	public static final String[] sadrzajRedaCheckPosaðenoWhere = {dBColSadRedRedID  + equalsString, dBColSadRedBrojMjesta + equalsString};
	/*
	 * Unesi Sredstvo
	 */
	public static final String[] unesiSredstvo = {dBColSredNaziv ,dBColSredTipTret ,dBColSredAktTvar ,dBColSredSvrha ,dBColSredKarRad ,dBColSredKarKon };
	/*
	 * Unesi Karencu
	 */
	public static final String[] unesiKarencu = {dBColKarSredstvoID ,dBColKarDatTret ,dBColKarDatIstRad ,dBColKarDatIstKon };
	/*
	 * Unesi Posaðeno
	 */
	public static final String[] unesiPosaðeno = {dBColPosSorteID ,dBColPosPodlogeID ,dBColPosNaziv };
	/*
	 * Unesi Sorte
	 */
	public static final String[] unesiSorte = {dBColSorIme ,dBColSorVrsta };
	/*
	 * Unesi podloge
	 */
	public static final String[] unesiPodloge = {dBColPodNaziv ,dBColPodBujnost };
	/*
	 * Unesi korisnika
	 */
	public static final String[] unesiKorisnika = {"korisnickoIme", "ime", "sifra"};
	/*
	 * Update
	 */
	/*
	 * Update Karenca
	 */
	public static final String[] updateKarencaWhat = {dBColKarSredstvoID ,dBColKarDatTret ,dBColKarDatIstRad ,dBColKarDatIstKon };
	public static final String[] updateKarencaWhere = {dBColKarIDKarenca  + equalsString};
	/*
	 * Update Sredstva
	 */
	public static final String[] updateSredstvaWhat = {dBColSredNaziv ,dBColSredTipTret ,dBColSredAktTvar ,dBColSredSvrha ,dBColSredKarRad ,dBColSredKarKon };
	public static final String[] updateSredstvaWhere = {dBColSredID  + equalsString};
	/*
	 * Update Navodnjavanje
	 */
	public static final String[] updateNavodnjavanjeWhat = {dBColNavNaziv};
	public static final String[] updateNavodjavanjeWhere = {dBColNavIDNav + equalsString};
	/*
	 * Update Podloga
	 */
	public static final String[] updatePodlogaWhat = {dBColPodNaziv ,dBColPodBujnost };
	public static final String[] updatePodlogaWhere = {dBColPodIDPod + equalsString};
	/*
	 * Update Sorta
	 */
	public static final String[] updateSortaWhat = {dBColSorIme ,dBColSorVrsta };
	public static final String[] updateSortaWhere = {dBColSorID  + equalsString};
	/*
	 * Update Posaðeno
	 */
	public static final String[] updatePosaðenoWhat = {dBColPosNaziv ,dBColPosSorteID ,dBColPosPodlogeID };
	public static final String[] updatePosaðenoWhere = {dBColPosIDPos + equalsString};
	/*
	 * Update Red
	 */
	public static final String[] updateRedWhat = {dBColRedNasadID, dBColRedBrojReda, dBColRedBrojSadMjesta};
	public static final String[] updateRedWhere = {dBColRedNasadID + equalsString, dBColRedBrojReda + equalsString};
	/*
	 * Update Sadrzaj Reda
	 */
	public static final String[] updateSadrzajRedaWhat = {dBColSadRedPosID , dBColSadRedDatumSadnje };
	public static final String[] updateSadrzajRedaWhere = {dBColSadRedRedID + equalsString, dBColSadRedBrojMjesta + equalsString};
	/*
	 * Update Cijeli Red
	 */
	public static final String[] updateCijeliSadrzajRedaWhat = {dBColSadRedPosID , dBColSadRedDatumSadnje };
	public static final String[] updateCijeliSadrzajRedaWhere = {dBColSadRedRedID  + equalsString};
	/*
	 * Update Nasad
	 */
	public static final String[] updateNasadWhat = {dBColNasNaziv, dBColNasArkodID ,dBColNasPovrsina ,dBColNasLokacija ,dBColNasNavID ,
			dBColNasKarID ,dBColNasBrojRedova };
	public static final String[] updateNasadWhere = {dBColNasIDNasad + equalsString, dBColNasUserID + equalsString};
	/*
	 * Increment broj redova u nasadu
	 */
	public static final String[] updateNasadIncBrojRedovaWhat = {"brojRedova = brojRedova+1"};
	public static final String[] updateNasadIncBrojRedovaWhere = {dBColNasIDNasad + equalsString, dBColNasUserID + equalsString};
	
}
	
	
	
	


