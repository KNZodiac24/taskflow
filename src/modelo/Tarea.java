package modelo;

import java.sql.Date;

public class Tarea {
    private String nombre;
    private String descripcion;
    private Date fechaCulminacion;
    private Date fechaYHoraCreacion;
    private String nomUsr;

    public Tarea(String nombre, String descripcion, Date fechaCulminacion, String nomUsr){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCulminacion = fechaCulminacion;
        this.nomUsr = nomUsr;
    }  

    public Tarea(String nombre, String descripcion, Date fechaCulminacion, Date fechaYHoraCreacion, String nomUsr){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCulminacion = fechaCulminacion;
        this.fechaYHoraCreacion = fechaYHoraCreacion;
        this.nomUsr = nomUsr;
    }

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

	public Date getFechaCulminacion() {
		return fechaCulminacion;
	}

	public void setFechaCulminacion(Date fechaCulminacion) {
		this.fechaCulminacion = fechaCulminacion;
	}

    public String getNomUsr(){
        return nomUsr;
    }

    public void setNomUsr(String nomUsr){
        this.nomUsr = nomUsr;
    }

    public void setFechaYHoraCreacion(Date fechaYHoraCreacion){
        this.fechaYHoraCreacion = fechaYHoraCreacion;
    }

    public String darFechaDeCulminacion(){
        String fechaTemp = this.fechaCulminacion.toString();
        String[] fechaPorPartes = fechaTemp.split("-");
        return fechaPorPartes[2]+"/"+fechaPorPartes[1]+"/"+fechaPorPartes[0];
    }
}
