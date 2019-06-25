package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoPredstave;
import domen.Predstave;
import util.DB;

public class DaoImplPredstave implements DaoPredstave {

	@Override
	public List<Predstave> vratiPredstave() {
		Connection con=DB.getInstanca().getConnection();
		PreparedStatement ps;
		ResultSet rs;
		String sql="select * from predstava ";
		List<Predstave>list=new ArrayList<Predstave>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Predstave p = new Predstave();
				p.setId_predstave(rs.getInt("id_predstava"));
				p.setNaziv(rs.getString("naziv"));
				p.setCena(rs.getInt("cena"));
				
				
				list.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}
		
		return list;
	}

}
