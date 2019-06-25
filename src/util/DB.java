package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static DB instanca;
	private static final int MAX_CON=5;
	private static final Connection [] bafer = new  Connection[MAX_CON];
	private int first= 0;
	private int last=0;
	private int free=MAX_CON;
	private DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for(int i=0;i< MAX_CON;i++) {
				try {
					bafer[i]=DriverManager.getConnection("jdbc:mysql://localhost:3306/pozoriste","root","");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			
			
			
			e.printStackTrace();
		}
		
		
		
	}
	public static DB getInstanca () {
		if(instanca == null) {
			 instanca=new DB();
		}
		return instanca;
	}

	public synchronized Connection getConnection () {
		if(free== 0) {
			
			return null;
		}
		free--;
		Connection con= bafer[first];
		first=(first+1)% MAX_CON; //0+1/5
		return con;
		



	}
	 public  synchronized void putConnection(Connection con) {
		 if(con == null) {
			 return;
		 }
		 free++;
		 bafer[last]=con;
		 last=(last+1)%MAX_CON;
		 
		 
		 
		 
		 
	 }
	}


