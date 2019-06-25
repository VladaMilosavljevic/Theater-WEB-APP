package service.impl;

import dao.DaoInsertPredstava;
import dao.impl.DaoInsertPredstavaImpl;
import domen.Predstave;
import service.ServiceInsertPredstava;

public class ServiceInsertPredstavaImpl implements ServiceInsertPredstava {

	@Override
	public void insertPredstava(Predstave p) {
	DaoInsertPredstava di=new DaoInsertPredstavaImpl();
	di.insertPredstava(p);

	}

}
