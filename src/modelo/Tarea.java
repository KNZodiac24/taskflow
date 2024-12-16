package modelo;

import java.sql.Date;
import java.sql.Timestamp;

public class Tarea {
    private String nombre;
    private String descripcion;
    private Date fechaCulminacion;
    private Timestamp fechaYHoraCreacion;
    private String nomUsr;
    private boolean estaCompletada;

    public Tarea(String nombre, String descripcion, Date fechaCulminacion, String nomUsr){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCulminacion = fechaCulminacion;
        this.nomUsr = nomUsr;
    }  

    public Tarea(String nombre, String descripcion, Date fechaCulminacion, Timestamp fechaYHoraCreacion, String nomUsr, boolean estaCompletada){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCulminacion = fechaCulminacion;
        this.fechaYHoraCreacion = fechaYHoraCreacion;
        this.nomUsr = nomUsr;
        this.estaCompletada = estaCompletada;
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

    public void setFechaYHoraCreacion(Timestamp fechaYHoraCreacion){
        this.fechaYHoraCreacion = fechaYHoraCreacion;
    }

    public Timestamp getFechaYHoraCreacion(){
        return fechaYHoraCreacion;
    }

    public void setEstaCompletada(boolean estaCompletada){
        this.estaCompletada = estaCompletada;
    }

    public boolean estaCompletada(){
        return this.estaCompletada;
    }

    public String darFechaDeCulminacion(){
        String fechaTemp = this.fechaCulminacion.toString();
        String[] fechaPorPartes = fechaTemp.split("-");
        return fechaPorPartes[2]+"/"+fechaPorPartes[1]+"/"+fechaPorPartes[0];
    }
}
