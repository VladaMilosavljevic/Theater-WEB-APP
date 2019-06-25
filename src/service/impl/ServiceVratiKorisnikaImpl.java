package service.impl;

import dao.DaoVratiKorisnika;
import dao.impl.DaoImplVratiKorisnika;
import domen.User;
import service.ServiceVratiKorisnika;

public class ServiceVratiKorisnikaImpl implements ServiceVratiKorisnika {

	@Override
	public User vratiUsera(User user) {
		DaoVratiKorisnika dk=new DaoImplVratiKorisnika();
		return dk.vratiUsera(user);
	}

}