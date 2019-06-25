package service.impl;

import java.util.ArrayList;

import dao.DaoRezervacija;
import dao.impl.DaoRezervacijaImpl;
import domen.Rezervacija;
import domen.User;
import service.ServiceRezervacija;

public class ServiceRezervacijaImpl implements ServiceRezervacija {

	@Override
	public void insertRezervacija(Rezervacija r,User u) {
	DaoRezervacija dr=new DaoRezervacijaImpl();
	dr.insertRezervacija(r,u);

	}

}
