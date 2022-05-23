package clienteweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/cliente.html", "/view/cadastroCliente.html", "/view/cadastroEstabelecimento.html", "/view/loginCliente.html", "/view/loginEstabelecimento.html"})
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamou o metodo Get");

        //super.doGet(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        System.out.println("Chamou o metodo Post");

        //super.doPost(req, resp);
    }
}