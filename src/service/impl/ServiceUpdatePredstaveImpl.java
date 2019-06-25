package service.impl;

import dao.DaoUpdatePredstave;
import dao.impl.DaoUpdatePredstaveImpl;
import domen.Predstave;
import service.ServiceUpdatePredstave;

public class ServiceUpdatePredstaveImpl implements ServiceUpdatePredstave {

	@Override
	public void updatePredstave(Predstave p) {
		DaoUpdatePredstave dp= new DaoUpdatePredstaveImpl();
		dp.updatePredstave(p);

	}

}
