package com.romario.superprod.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romario.superprod.config.UniradApiProperty;
import com.romario.superprod.repository.UsuarioRepository;
import com.romario.superprod.service.util.Tenantuser;

@RestController
@RequestMapping("/tokens")
public class TokenResource {
	
	@Autowired
	private UniradApiProperty protecApiProperty;
	@Autowired
	private Tenantuser tenantUsuario;
	@Autowired
	private UsuarioRepository usurepo;
	

	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse resp) {
		usurepo.voltartenant(tenantUsuario.buscarEmailUsuToken());
		Cookie cookie = new Cookie("refreshToken", null);

		cookie.setHttpOnly(true);
		cookie.setSecure(protecApiProperty.getSeguranca().isEnableHttps());
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
	}

}
