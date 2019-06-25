package service.impl;

import dao.DaoPredstaveDelete;
import dao.impl.DaoPredstaveDeleteImpl;
import service.ServicePredstavaDelete;

public class ServicePredstaveDeleteImpl implements ServicePredstavaDelete {

	@Override
	public void deletePredstave(int id) {
	DaoPredstaveDelete dp=new DaoPredstaveDeleteImpl();
	dp.deletePredstave(id);
		
	}

}
