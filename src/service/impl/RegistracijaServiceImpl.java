package service.impl;

import dao.RegistracijaDao;
import dao.impl.RegistracijaDaoImpl;
import domen.User;
import service.RegistracijaService;

public class RegistracijaServiceImpl implements RegistracijaService {

	@Override
	public void insertUser(User user) {
		RegistracijaDao rd=new RegistracijaDaoImpl();
		rd.insertUser(user);

	}

}
