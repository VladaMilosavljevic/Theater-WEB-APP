package controlerpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domen.Konstante;
import domen.User;
import service.RegistracijaService;
import service.ServiceVratiKorisnika;
import service.impl.RegistracijaServiceImpl;
import service.impl.ServiceVratiKorisnikaImpl;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vrednost = request.getParameter("submit");
		if(vrednost.equals("Prijavi se")) {
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			User us=new User();
			us.setUsername(user);
			us.setPassword(pass);
			ServiceVratiKorisnika sk= new ServiceVratiKorisnikaImpl();
			User podatakIzBaze=sk.vratiUsera(us);
			if(podatakIzBaze != null && podatakIzBaze.getStatus() == 1) {  // login kao user
				HttpSession sesija=request.getSession();
				sesija.setAttribute("ulogovanKorisnik", podatakIzBaze);
				request.setAttribute("msg1", "Uspesno ste se prijavili kao " + user );
				request.getRequestDispatcher("prijava.jsp").forward(request, response);
			}else if(podatakIzBaze != null && podatakIzBaze.getStatus() == 0) {   //logovanje kao admin za update predstava i cena
				HttpSession sesija=request.getSession();
				sesija.setAttribute("ulogovanKorisnik", podatakIzBaze);
				request.setAttribute("msg1", "Uspesno ste se prijavili kao admin " + user );
				request.getRequestDispatcher("predstave.jsp").forward(request, response);
			}else {
			
				response.sendRedirect("prijava.jsp");
				
				
			}
			
		}else {
			String user=request.getParameter("user1");
			String password1=request.getParameter("pass1");
			String password2=request.getParameter("pass2");
			String ime=request.getParameter("ime");
			String mail=request.getParameter("mail");
			if(password1.equals(password2)) {
				User u =new User();
				u.setIme(ime);
				u.setMail(mail);
				u.setUsername(user);
				u.setPassword(password1);
				u.setStatus(Konstante.USER.getId());
				RegistracijaService rs=new RegistracijaServiceImpl();
				rs.insertUser(u);
				request.setAttribute("msg", "uspesno ste se registrovali");
			    request.getRequestDispatcher("prijava.jsp").forward(request, response);
			    }else {
			response.sendRedirect("index.jsp");
	}

}
}
}