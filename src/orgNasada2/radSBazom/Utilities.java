package orgNasada2.radSBazom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import orgNasada2.PodatkovneKlase.*;

public class Utilities {
	
	private static PreparedStatement pstmt = null;
	private static final Logger logger = Logger.getLogger(DBSelect.class);
		
	public static Vector<RedInfo> query2VecRedInfo(StringBuilder sqlQuery)
	{
		Vector<RedInfo> rI = new Vector<RedInfo>();
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    while(rs.next())
		    {
		    	rI.add(new RedInfo(rs.getInt("idReda"), rs.getInt("nasadID"), rs.getInt("brojReda"), rs.getInt("brojSadnihMjesta")));
			 }
		    rs.close();
		    conn.close();
		    return rI;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static Korisnik query2Korisnik(StringBuilder sqlQuery)
	{
		Korisnik user = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    if(rs.next())
		    {
		    	user = new Korisnik(rs.getInt("idUser"), rs.getString("ime"), rs.getString("korisnickoIme"), rs.getString("sifra")); 
		    }
		    rs.close();
		    conn.close();
		    return user;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static Nasad query2Nasad(StringBuilder sqlQuery)
	{
		Nasad nasad = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    if(rs.next())
		    {
		    	nasad = new Nasad(rs.getInt(DBConst.dBColNasIDNasad), rs.getString(DBConst.dBColNasArkodID),
		    			rs.getInt(DBConst.dBColNasUserID), rs.getString(DBConst.dBColNasNaziv),
		    			rs.getInt(DBConst.dBColNasPovrsina),rs.getString(DBConst.dBColNasLokacija),
		    			rs.getInt(DBConst.dBColNasNavID),rs.getInt(DBConst.dBColNasKarID),
		    			rs.getInt(DBConst.dBColNasBrojRedova));		    
		    }
		    rs.close();
		    conn.close();
		    return nasad;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static PosaðenoInfo query2PosaðenoInfo(StringBuilder sqlQuery)
	{
		PosaðenoInfo posInfo = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    if(rs.next())
		    {
		    	posInfo = new PosaðenoInfo(rs.getInt("posaðeno.idPosaðeno"), rs.getString("posaðeno.nazivPosaðeno"),
		    			rs.getString("sorte.imeSorte"), rs.getString("podloge.nazivPodloge"));		    
		    }
		    rs.close();
		    conn.close();
		    return posInfo;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static Sredstvo query2Sredstvo(StringBuilder sqlQuery) {
		
		Sredstvo sredstvo = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
			if(rs.next())
			{
				sredstvo = new Sredstvo(rs.getInt("idSredstva"), rs.getString("nazivSredstva"), rs.getString("tipTretiranja"),
						rs.getString("aktivnaTvar"), rs.getString("svrhaSredstva"), rs.getInt("karencaRadno"), rs.getInt("karencaKonzumno"));    
			}
			rs.close();
			conn.close();
			return sredstvo;
			} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
		
	}
	
	public static Podloga query2Podloga(StringBuilder sqlQuery)
	{
		Podloga podloga = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    if(rs.next())
		    {
		    	podloga = new Podloga(rs.getInt("idPodloge"), rs.getString("nazivPodloge"), rs.getString("bujnostPodloge"));	    
		    }
		    rs.close();
		    conn.close();
		    return podloga;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static Navodnjavanje query2Navodnjavanje(StringBuilder sqlQuery)
	{
		Navodnjavanje nav = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    if(rs.next())
		    {
		    	nav = new Navodnjavanje(rs.getInt("idNavodnjavanje"), rs.getString("nazivNavodnjavanja"));	    
		    }
		    rs.close();
		    conn.close();
		    return nav;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static Sorta query2Sorta(StringBuilder sqlQuery)
	{
		Sorta sorta = null;
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();						
		    if(rs.next())
		    {
		    	sorta = new Sorta(rs.getInt("idSorte"), rs.getString("imeSorte"), rs.getString("vrstaSorte"));	    
		    }
		    rs.close();
		    conn.close();
		    return sorta;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	
	
	public static Vector<Integer> query2VecInt(StringBuilder sqlQuery)
	{
		Vector<Integer> values = new Vector<Integer>();
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
			
		    while(rs.next())
		    {
		    	values.add(rs.getInt(1));
		    }
		    conn.close();
	    	rs.close();
	    	if(values.size()==0) values.add(0);
		    return values;
		} catch (Exception e) {
		    e.printStackTrace();
		    values.add(0);
		    return values;
		}
	}

	public static Vector<String> query2VecStr(StringBuilder sqlQuery)
	{
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
			
			Vector<String> values = new Vector<String>();
			int i=1;
		    while(rs.next())
		    {
		    	values.add(rs.getString(i));
		    }
		    conn.close();
		    rs.close();
		    return values;
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}

	@SuppressWarnings("serial")
	public static TableModel query2TabMod(StringBuilder sqlQuery) {
		
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
						
		    ResultSetMetaData rSMD = rs.getMetaData();
		    int brojStupaca = rSMD.getColumnCount();
		    Vector<String> imenaStupaca = new Vector<String>();

		    for (int column = 0; column < brojStupaca; column++) {
			imenaStupaca.addElement(rSMD.getColumnLabel(column + 1));
		    }
		    
		    Vector<Vector<Object>> redovi = new Vector<Vector<Object>>();
		    while (rs.next()) 
		    { 
		    	Vector<Object> noviRed = new Vector<Object>();
		    	for (int i = 1; i <= brojStupaca; i++) 
		    	{
		    		noviRed.addElement(rs.getObject(i));
		    	}
		    	redovi.addElement(noviRed);
		    }
		    rs.close();
		    conn.close();
		    return new DefaultTableModel(redovi, imenaStupaca){
				@Override
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
			};
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	    }

	public static TableModel query2TabModMetaData(StringBuilder sqlQuery) {
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
			
		    ResultSetMetaData rSMD = rs.getMetaData();
		    int brojStupaca = rSMD.getColumnCount();
		    Vector<String> imenaStupaca = new Vector<String>();

		    for (int column = 0; column < brojStupaca; column++) {
			imenaStupaca.addElement(rSMD.getColumnLabel(column + 1));
		    }
		    
		    Vector<Vector<Object>> redovi = new Vector<Vector<Object>>();
		    rs.close();
		    conn.close();
		    return new DefaultTableModel(redovi, imenaStupaca);
		    
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	    }

	public static int query2getRedID(StringBuilder sqlQuery)
	{
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				{
				int max = rs.getInt(1);
				int cur = rs.getInt(2);
				if(cur<max) {
					return cur+1;
				}
			}
		    conn.close();
	    	rs.close();
		    return -1;
		} catch (Exception e) {
		    e.printStackTrace();
		    return -1;
		}
	}
	
	public static boolean query2hasResult(StringBuilder sqlQuery)
	{
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
			logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) return true;
			else return false;
		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
	}
	
	public static StringBuilder fetchStrBuilderUpdIns(String purpose, String table, Vector<String> what, Vector<String> values, Vector<String> where)
	{
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append(purpose);
		
		sqlQuery.append(table);
		
		if(purpose.equals(DBConst.purposeUpdate))
			{
			sqlQuery.append(" SET ");
			for(int i=0; i<what.size(); i++)
				{
					if(i!=0) sqlQuery.append(", ");
					if(!values.isEmpty()) sqlQuery.append(" " + what.elementAt(i) + "='" + values.elementAt(i) + "' ");
					if(values.isEmpty()) sqlQuery.append(" " + what.elementAt(i) + " ");
				}
			}
		else if(purpose.equals("INSERT INTO "))
		{
			sqlQuery.append("( ");
			for(int i=0; i<what.size(); i++)
			{
				if(i!=0) sqlQuery.append(", ");
				sqlQuery.append(what.elementAt(i));
			}
			sqlQuery.append(") VALUES (");
			for(int i=0; i<values.size(); i++) {
				sqlQuery.append("'" + values.get(i) + "'");
				if(i<values.size()-1) sqlQuery.append(", ");
				else sqlQuery.append(" ) ");
			}
		}		
		if(!where.isEmpty())for(int i=0; i<where.size(); i++)
		{
			if(i==0) sqlQuery.append("WHERE ");
			if(i!=0) sqlQuery.append(" AND ");
			sqlQuery.append(where.elementAt(i));
		}
		
		sqlQuery.append(";");
		return sqlQuery;
	}
	
	public static StringBuilder fetchStrBuilderSelect(String purpose, Vector<String> what, Vector<String> as, String from, Vector<String> join,
			Vector<String> joinOn, Vector<String> joinFrom, Vector<String> where, Vector<String> ordering)
	{
		/* Purpose  
		 * What - 1 - mandatory (M)
		 * As - 2 - non Mandatory (NM)
		 * From
		 * Join
		 * Where - 3 - NM
		 * Order By - 4 - NM
		 */
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append(purpose);
		
		if(!as.isEmpty())
		{
			if(!what.isEmpty()) Utilities.appendToQueryWithAs(sqlQuery, what, as);
		}
		else
		{
			if(!what.isEmpty()) Utilities.appendToQuery(1, sqlQuery, what);
		}
		
		if(purpose.equals(DBConst.purposeSelect)) {
			sqlQuery.append("FROM " + from + " ");
		}
		
		if(!join.isEmpty())
		{
			Utilities.appendToQueryJoin(sqlQuery, join, joinOn, joinFrom);
			join.add(from);
		}
		
		if(!where.isEmpty())
		{
			Utilities.appendToQuery(2, sqlQuery, where);
			if(join.isEmpty())
				{
					Vector<String> temp = new Vector<String>();
					temp.add(from);
					Utilities.appendToQuery(3, sqlQuery, temp);
				}
			else Utilities.appendToQuery(3, sqlQuery, join);
		}
		else
		{
			if(join.isEmpty())
			{
				Vector<String> temp = new Vector<String>();
				temp.add(from);
				Utilities.appendToQuery(5, sqlQuery, temp);
			}
		else Utilities.appendToQuery(5, sqlQuery, join);
		}
		if(!ordering.isEmpty()) Utilities.appendToQuery(4, sqlQuery, ordering);

		sqlQuery.append(";");
		
		return sqlQuery;
	}
	
	public static StringBuilder appendToQuery(int mode, StringBuilder sqlQuery, Vector<String> data)
	{		
		switch(mode) {
		case 1:
			{
			appendToQueryFunction(sqlQuery, data, ", ");
			break;
		}
		case 2:{
			sqlQuery.append("WHERE ");
			appendToQueryFunction(sqlQuery, data, " AND ");
			break;
		}
		case 3:{
			sqlQuery.append(" AND ");
			Vector<String> temp = new Vector<String>();
			data.forEach((value) -> temp.add(value + DBConst.isActive ));
			appendToQueryFunction(sqlQuery, temp, " AND ");
			break;
		}
		case 4:{
			sqlQuery.append("ORDER BY ");
			appendToQueryFunction(sqlQuery, data, ", ");
			break;
		}
		case 5:{
			sqlQuery.append(" WHERE ");
			Vector<String> temp = new Vector<String>();
			data.forEach((value) -> temp.add(value + DBConst.isActive ));
			appendToQueryFunction(sqlQuery, temp, " AND ");
			break;
		}
		}
		
		return sqlQuery;
	}
	
	public static StringBuilder appendToQueryFunction(StringBuilder sqlQuery, Vector<String> data, String modifier)
	{
		int limit = data.size();
		for(int i=0; i<limit; i++)
		{
			sqlQuery.append(data.get(i));
			if(i<limit-1)
			{sqlQuery.append(modifier);}
			else sqlQuery.append(" ");
		}
		return sqlQuery;
	}
	
	public static StringBuilder appendToQueryWithAs(StringBuilder sqlQuery, Vector<String> dataWhat, Vector<String> dataAs)
	{
		int limit = dataWhat.size();
		for(int i=0; i<limit; i++)
		{
			sqlQuery.append(dataWhat.get(i));
			sqlQuery.append(" AS ");
			sqlQuery.append(dataAs.get(i));
			if(i<limit-1)
			{sqlQuery.append(",");}
			else sqlQuery.append(" ");
		}
		return sqlQuery;
	}
	
	public static StringBuilder appendToQueryJoin(StringBuilder sqlQuery, Vector<String> join, Vector<String> joinOn, Vector<String> joinFrom)
	{
		for(int i=0; i<join.size(); i++)
		{
			String temp = "JOIN " + join.get(i) + " ON " + joinOn.get(i) + " = " + joinFrom.get(i) + " ";
			sqlQuery.append(temp);
		}
		return sqlQuery;
	}

	
	public static int executeUpdate(StringBuilder sqlQuery)
	{
		try(Connection conn = DriverManager.getConnection(DBConst.databaseURL, DBConst.databaseCredUser, DBConst.databaseCredPass))
		{
		logger.info(sqlQuery);
			pstmt = conn.prepareStatement(sqlQuery.toString());
			return pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	public static void popuniNasadDefault(Nasad nasad, JFrame window)
	{
		Vector<RedInfo> redovi = new Vector<RedInfo>();
		redovi.addAll(DBSelect.getRedoviInfo(nasad.getIdNasad()));
		if(redovi.size()<nasad.getBrojRedova())
		{
			for(int i=redovi.size()+1; i <= nasad.getBrojRedova(); i++) DBInsert.unesiRed(nasad.getIdNasad(), i, 
					Integer.valueOf(JOptionPane.showInputDialog(window, "Unesi broj mjesta u redu broj "+ i +": ")).intValue());
		}
		redovi.clear();
		redovi.addAll(DBSelect.getRedoviInfo(nasad.getIdNasad()));
		if(!redovi.isEmpty())for(RedInfo rI : redovi)
		{
			logger.info("Red: " + rI.getBrojReda());
			for(int i=1; i<rI.getBrojSadnihMjesta()+1; i++)
			{
				logger.info("Unos sadnica. Mjesto: " + i);
				DBInsert.unesiPraznoMjesto(rI.getIdReda(), i); 
			}
		}
	}

	







}

