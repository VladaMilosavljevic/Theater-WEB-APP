package controlerpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import domen.Predstave;
import service.ServiceInsertPredstava;
import service.ServicePredstavaDelete;
import service.ServiceUpdatePredstave;
import service.impl.ServiceInsertPredstavaImpl;
import service.impl.ServicePredstaveDeleteImpl;
import service.impl.ServiceUpdatePredstaveImpl;

/**
 * Servlet implementation class ServletPredstave
 */
@WebServlet({"/ServletPredstave","/akcija/*"})
public class ServletPredstave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPredstave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String putanja=request.getPathInfo();
	if(putanja.equals("/updatePredstave")) {
		String id=request.getParameter("id");
		String naziv=request.getParameter("naziv");
		request.setAttribute("id", id);
        request.setAttribute("naziv", naziv);
        request.getRequestDispatcher("/updatePredstave.jsp").forward(request, response);
	
	}else if (putanja.equals("/deletePredstave")) {
		String id=request.getParameter("id");
	   ServicePredstavaDelete sd=new ServicePredstaveDeleteImpl();
		sd.deletePredstave(Integer.parseInt(id));
		response.sendRedirect("/PozoristeProjekat/predstave.jsp");
			
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String putanja=request.getPathInfo();
		if(putanja.equals("/updatePredstave")) {
			String id=request.getParameter("id");
			String naziv=request.getParameter("naziv");
			String cena=request.getParameter("cena");
			Predstave p= new Predstave();
			p.setId_predstave(Integer.parseInt(id));
			p.setNaziv(naziv);
			p.setCena(Integer.parseInt(cena));
			ServiceUpdatePredstave sp=new ServiceUpdatePredstaveImpl();
			sp.updatePredstave(p);
			response.sendRedirect("/PozoristeProjekat/predstave.jsp");
			
		}else {
			
		
		String naziv=request.getParameter("txt_naziv");
		String cena=request.getParameter("txt_cena");
		Predstave p= new Predstave();
		p.setNaziv(naziv);
		p.setCena(Integer.parseInt(cena));
		ServiceInsertPredstava sp=new ServiceInsertPredstavaImpl();
		sp.insertPredstava(p);
		response.sendRedirect("/PozoristeProjekat/predstave.jsp");
	}
}
}