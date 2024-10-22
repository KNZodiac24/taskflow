package modelo;

public class Usuario {
    private String nombreUsuario;
    private String nombrePreferido;
    private String contrasenia;

    public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombrePreferido() {
		return nombrePreferido;
	}
	public void setNombrePreferido(String nombrePreferido) {
		this.nombrePreferido = nombrePreferido;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
