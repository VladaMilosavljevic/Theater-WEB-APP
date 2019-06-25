package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoVratiKorisnika;
import domen.User;
import util.DB;

public class DaoImplVratiKorisnika implements DaoVratiKorisnika {

	@Override
	public User vratiUsera(User user) {
		Connection con = DB.getInstanca().getConnection();
		PreparedStatement ps;
		ResultSet rs;
		User us = null;
		String sql= "select * from user where username=? and password =?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.execute();
			rs=ps.executeQuery();
			if(rs.next()) {
				us=new User();
				us.setId(rs.getInt("id_user"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setStatus(rs.getInt("status"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}
		
		return us;
	}

}
