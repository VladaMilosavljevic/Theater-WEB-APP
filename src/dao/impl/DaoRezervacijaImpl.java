package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dao.DaoRezervacija;
import domen.Rezervacija;
import domen.User;
import util.DB;

public class DaoRezervacijaImpl implements DaoRezervacija {

	@Override
	public void insertRezervacija(Rezervacija r,User u) {
		
		Connection con=DB.getInstanca().getConnection();
		PreparedStatement ps;
		String sqlRezervacija=" insert into rezervacija (datum,brojKarata,iznos,id_predstava,id_user) values (?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sqlRezervacija);
			ps.setString(1, r.getDatumPredstave());
			ps.setInt(2, r.getBrojKarata());
			ps.setInt(3, r.getIznos());
			ps.setInt(4, r.getId_predstava());
			ps.setInt(5, u.getId());
		
			
			
		//	lista.add(r);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				DB.getInstanca().putConnection(con);
	}

}
}
