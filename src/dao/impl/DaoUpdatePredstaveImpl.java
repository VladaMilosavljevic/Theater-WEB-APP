package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DaoUpdatePredstave;
import domen.Predstave;
import util.DB;

public class DaoUpdatePredstaveImpl implements DaoUpdatePredstave {

	@Override
	public void updatePredstave(Predstave p) {
		Connection con=DB.getInstanca().getConnection();
		String sqlUpdate="update predstava set naziv=? ,  cena=?  where id_predstava=?";
		try {
			PreparedStatement ps=con.prepareStatement(sqlUpdate);
			ps.setString(1, p.getNaziv());
			ps.setDouble(2, p.getCena());
			ps.setInt(3, p.getId_predstave());
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
