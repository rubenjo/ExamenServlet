package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Videojuegos;
import es.salesianos.repository.VideojuegoRepository;

public class ListadoVideojuegoServlet extends HttpServlet{

	VideojuegoRepository gameRepository=new VideojuegoRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videojuegos> listAllGames=gameRepository.listAllGames();
		req.getSession().setAttribute("consoles", listAllGames);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ListadoVideojuegos.jsp");
		dispatcher.forward(req, resp);
	}
}
