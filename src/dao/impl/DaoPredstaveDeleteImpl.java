package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DaoPredstaveDelete;
import util.DB;

public class DaoPredstaveDeleteImpl implements DaoPredstaveDelete {

	@Override
	public void deletePredstave(int id) {
		Connection con=DB.getInstanca().getConnection();
		String sqlDelete="delete from predstava where id_predstava =?";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sqlDelete);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    DB.getInstanca().putConnection(con);
	}

}
