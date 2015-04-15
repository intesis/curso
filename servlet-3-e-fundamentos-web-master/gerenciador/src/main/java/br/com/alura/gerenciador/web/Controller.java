package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tarefa = req.getParameter("tarefa");

		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Você esqueceu de passar a tarefa");
		}

		tarefa = "br.com.alura.gerenciador.web." + tarefa;

		try {
			Class<?> tipo = Class.forName(tarefa);
			Tarefa t = (Tarefa) tipo.newInstance();
			String lugar = t.executa(req, resp);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher(lugar);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}

	}

}
