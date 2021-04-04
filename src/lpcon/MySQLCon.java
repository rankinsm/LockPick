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
	
	public static String[] accountProfiles(int ID) {
		String[] names = new String[8];
		int n = 0;
		for(int i = 0; i < 8; i++) {
			names[i] = null;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select profileName FROM tableprofile WHERE accountID = '"+ID+"'");
			while(rs.next()) {
				names[n] = rs.getString(1);
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
			ResultSet rs = stmt.executeQuery("select profilePIN FROM tableprofile WHERE accountID = '"+accountID+"' AND profileID = '"+profileID+"'");  
			if(rs.next()) {
				testPIN = rs.getString(1);
				if(testPIN.equals(pin)) {
					return true;
				
				}
			}
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		
		return false;
	}
	
	public static int profileIDCheck(int accountID, String nameCheck) {

		int pID = -1;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");  
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select profileID FROM tableprofile WHERE accountID = '"+accountID+"' AND profileName = '"+nameCheck+"'");  
			if(rs.next()) {
				pID = rs.getInt(1);
			}
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return pID;
	}
}  