package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie buscaUsuarioLogado() {

		if (cookies == null)
			return null;

		for (Cookie c : cookies) {

			if (c.getName().equals("usuario.logado")) {
				return c;
			}

		}
		
		return null;
	}

}
