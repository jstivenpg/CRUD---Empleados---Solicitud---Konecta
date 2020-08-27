package net.javaguides.springmvc.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "solicitud")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "resumen")
    private String summary;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="id_empleado")
    private Employee empleado;

    public Request() {

    }
   

	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getSummary() {
		return summary;
	}




	public void setSummary(String summary) {
		this.summary = summary;
	}



	public Employee getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}


	@Override
	public String toString() {
		return "Request [id=" + id + ", code=" + code + ", description=" + description + ", summary=" + summary + "]";
	}




	
}