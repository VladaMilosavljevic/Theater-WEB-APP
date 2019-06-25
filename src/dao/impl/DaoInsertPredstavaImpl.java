package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DaoInsertPredstava;
import domen.Predstave;
import util.DB;

public class DaoInsertPredstavaImpl implements DaoInsertPredstava {

	@Override
	public void insertPredstava(Predstave p) {
		Connection con=DB.getInstanca().getConnection();
		PreparedStatement ps;
		String insertPredstava="insert into predstava (naziv,cena) values (?,?)";
		try {
			ps=con.prepareStatement(insertPredstava);
			ps.setString(1, p.getNaziv());
			ps.setDouble(2, p.getCena());
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
