package lpcon;

import java.sql.*;  


public class MySQLCon{ 
	public static boolean isConnected = false;
	
	public static void connect(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");  
			Statement stmt = con.createStatement(); 
			isConnected = true;
//ResultSet rs=stmt.executeQuery("select * from tableaccount");  
//while(rs.next())  
//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}
		catch(Exception e){ 
			isConnected = false;
			System.out.println(e);
		}
	}  
	
	public static void sqlInsert(String accountInfo){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");  
			Statement stmt = con.createStatement(); 
  
			stmt.executeUpdate(accountInfo);
			System.out.println("Insert Successful");
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}
	} 
	
	public static boolean verifyAccount(String email, String pass) {
		String testEmail = null;
		String testPass = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");  
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select accountEmail, accountPassword FROM tableaccount WHERE accountEmail = '"+email+"'");  
			if (rs.next()) {
				testEmail = rs.getString(1);
				if(testEmail.equals(email)) {
					testPass = rs.getString(2);
					if(testPass.equals(pass)) {
						return true;
					}
				}
			}
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		
		return false;
	}
	
	public static int accountID(String email) {
		int num = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select accountID FROM tableaccount WHERE accountEmail = '"+email+"'");
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}  
		return num; 
	}
/*	
	public static String[][] accountProfiles(int ID) {
		String[] names = new String[8];
		String[] PINS = new String[8];
		String[][] profiles = new String[8][2];
		int n = 0;
		for(int i = 0; i < 8; i++) {
			names[i] = null;
			PINS[i] = null;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select profileName, profilePIN FROM tableprofile WHERE accountID = '"+ID+"'");
			while(rs.next()) {
				names[n] = rs.getString(1);
				PINS[n] = rs.getString(2);
				n++;
			}
			for(int i = 0; i < 8; i++) {
				profiles[i][0] = names[i];
				profiles[i][1] = PINS[i];
				System.out.println(profiles[i][0]);
				System.out.println(profiles[i][1]);

			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}  
		
		return profiles;
	}
*/	
	
	public static String[] accountProfiles(int ID) {
		String[] names = new String[8];
		int n = 0;
		for(int i = 0; i < 8; i++) {
			names[i] = "-1";
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select profileName FROM tableprofile WHERE accountID = '"+ID+"'");
			while(rs.next()) {
				names[n] = rs.getString(1);
//				System.out.println(names[n]);
				n++;
			}

		} 
		catch (Exception e) {
			System.out.println(e);
		}  
		
		return names;
	}
	
	public static boolean verifyProfile(int accountID, int profileID, String pin) {
		int pID;
		String testPIN = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");  
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select profileID, profilePIN FROM tableprofile WHERE accountID = '"+accountID+"'");  
			while(!rs.next()) {
				pID = rs.getInt(1);
				if(pID == profileID) {
					testPIN = rs.getString(2);
					if(testPIN.equals(pin)) {
						return true;
					}
				}
			}
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		
		return false;
	}
}  