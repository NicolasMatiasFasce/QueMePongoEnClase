package notificador;

import alerta.Alerta;
import usuarios.Usuario;

public class NotificadorDeUsuarios {

	public void notificarUsuario(Alerta alerta, Usuario usuario) {
		usuario.notificar(alerta);
	}

}
