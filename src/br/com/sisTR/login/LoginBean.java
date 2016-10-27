package br.com.sisTR.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sisTR.util.FacesUtil;
import br.com.sisTR.util.SessionUtil;

@RequestScoped
@ManagedBean
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4280356252615670501L;

	private String usuario;
	private String senha;

	public String login() {
		if (usuario.equals("admin") && senha.equals("admin")) {

			Object object = new Object();
			SessionUtil.setParam("USUARIOLogado", object);

			return "/content/index.xhtml?faces-redirect=true";
		}else{
			FacesUtil.addErrorMessage("Usuário ou senha inválidos");
		}
		return null;
	}

	public String loggout() {
		SessionUtil.remove("USUARIOLogado");
		return "/content/login.xhtml?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
