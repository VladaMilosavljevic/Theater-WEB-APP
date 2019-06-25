package domen;

import java.util.Date;

public class Rezervacija {
	private int id_rezervacija;
	private String datumPredstave;
	private int brojKarata;
	private int id_predstava;
	private int iznos;
	private  int id_user;
	public int getIznos() {
		return iznos;
	}
	public void setIznos(int iznos) {
		this.iznos = iznos;
	}
	public int getId_rezervacija() {
		return id_rezervacija;
	}
	public void setId_rezervacija(int id_rezervacija) {
		this.id_rezervacija = id_rezervacija;
	}
	public String getDatumPredstave() {
		return datumPredstave;
	}
	public void setDatumPredstave(String datumPredstave) {
		this.datumPredstave = datumPredstave;
	}
	public int getBrojKarata() {
		return brojKarata;
	}
	public void setBrojKarata(int brojKarata) {
		this.brojKarata = brojKarata;
	}
	public int getId_predstava() {
		return id_predstava;
	}
	public void setId_predstava(int id_predstava) {
		this.id_predstava = id_predstava;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


}
