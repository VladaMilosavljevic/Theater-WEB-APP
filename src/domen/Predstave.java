package domen;

public class Predstave {
	private int id_predstave;
	public int getId_predstave() {
		return id_predstave;
	}
	public void setId_predstave(int id_predstave) {
		this.id_predstave = id_predstave;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	
	
	private String naziv;
	private int cena;
	public int getCena() {
		return cena;
	}
	public int setCena(int cena) {
		return this.cena = cena;
	}



}
