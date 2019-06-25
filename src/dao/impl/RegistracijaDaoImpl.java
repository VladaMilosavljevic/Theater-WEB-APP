package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.RegistracijaDao;
import domen.User;
import util.DB;

public class RegistracijaDaoImpl implements RegistracijaDao {

	@Override
	public void insertUser(User user) {
		Connection con=DB.getInstanca().getConnection();
		String sql="insert into user (username,password,ime,email,status) values (?,?,?,?,?)";
		PreparedStatement ps;
	
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3,user.getIme());
			ps.setString(4, user.getMail());
			ps.setInt(5, user.getStatus());
		  
			
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().getInstanca().putConnection(con);
		}
		
	}

}
