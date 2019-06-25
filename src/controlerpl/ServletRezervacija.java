package controlerpl;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import dao.DaoPredstave;
import dao.impl.DaoImplPredstave;
import domen.Predstave;
import domen.Rezervacija;
import domen.User;
import service.ServiceRezervacija;
import service.impl.ServiceRezervacijaImpl;

/**
 * Servlet implementation class ServletRezervacija
 */
@WebServlet("/ServletRezervacija")
public class ServletRezervacija extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRezervacija() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//	String datum = request.getParameter("datum");
		//System.out.println(datum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sesija = request.getSession();
	//	DaoPredstave dp= new DaoImplPredstave();
	//	List<Predstave>list=dp.vratiPredstave();
		
		//for(Predstave p: list) {
		
		 String idPredstave=request.getParameter("predstave");
		 
	
		
	//	 int cena= p.getCena();
	    String datum = request.getParameter("datum");
		String brojKarata=request.getParameter("kolicina");
	 
		Rezervacija r=new Rezervacija();
		r.setId_predstava(Integer.parseInt(idPredstave.substring(0,2)));
        r.setBrojKarata(Integer.parseInt(brojKarata));
        r.setDatumPredstave(datum);
       
        
       r.setIznos(Integer.parseInt(idPredstave.substring(2,5))*Integer.parseInt(brojKarata));
    
		
        sesija.setAttribute("lista", r);
		
		
        User u = (User) sesija.getAttribute("ulogovanKorisnik");
    	if(u != null) {
    		Rezervacija r1= (Rezervacija) sesija.getAttribute("lista");
        ServiceRezervacija sr=new ServiceRezervacijaImpl();
        sr.insertRezervacija(r1,u);
        request.setAttribute("msg", "Uspesno izvrsena rezervacija,ukupan iznos za placanje je " + r1.getIznos());
	    request.getRequestDispatcher("rezervacija.jsp").forward(request, response);
    	}else {
			response.sendRedirect("prijava.jsp");
        
    /*    ArrayList<Rezervacija>lista=(ArrayList<Rezervacija>) sesija.getAttribute("lista");
        if(lista== null) {
        	lista= new ArrayList<Rezervacija>();*/
    	}
		}
		/*
		 * lista.add(r); sesija.setAttribute("lista", lista); ServiceRezervacija sr=new
		 * ServiceRezervacijaImpl(); sr.insertRezervacija(lista);
		 * response.sendRedirect("rezervacija.jsp");
		 */		
        

}




