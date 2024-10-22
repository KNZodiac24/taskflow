package modelo;

import java.sql.Date;

public class Tarea {
    private String nombre;
    private String descripcion;
    private Date fechaYHoraCreacion;
    private Date fechaCulminacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaYHoraCreacion() {
		return fechaYHoraCreacion;
	}

	public void setFechaYHoraCreacion(Date fechaYHoraCreacion) {
		this.fechaYHoraCreacion = fechaYHoraCreacion;
	}

	public Date getFechaCulminacion() {
		return fechaCulminacion;
	}

	public void setFechaCulminacion(Date fechaCulminacion) {
		this.fechaCulminacion = fechaCulminacion;
	}

    

}
