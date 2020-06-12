package usuarios;

import alerta.Alerta;
import notificador.NotificadorDeUsuarios;

import java.util.ArrayList;
import java.util.List;

public class RepoDeUsuarios {

	private static RepoDeUsuarios repoDeUsuarios = new RepoDeUsuarios();

	private List<Usuario> usuarios = new ArrayList<>();
	private NotificadorDeUsuarios notificadorDeUsuarios;

	private RepoDeUsuarios() {
	}

	public static RepoDeUsuarios getInstance() {
		return repoDeUsuarios;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void notificarAlertaAUsuarios(Alerta alerta) {
		usuarios.forEach(usuario -> notificadorDeUsuarios.notificarUsuario(alerta, usuario));
	}

}
