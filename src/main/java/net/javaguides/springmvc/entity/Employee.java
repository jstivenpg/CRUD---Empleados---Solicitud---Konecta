package net.javaguides.springmvc.entity;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha_ingreso")
    private Date admissionDate;

    @Column(name = "nombre")
    private String name;

    @Column(name = "salario")
    private int salary;
    
    @OneToMany()
    private List<Request> requests;

    public Employee() {

    }
   
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getAdmissionDate() {
		return admissionDate;
	}



	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	   public String toString() {
	       return "Employee [id=" + id + ", fecha_ingreso=" + admissionDate + ", nombre=" + name + ", salario=" + salary + "]";
    }
	
	public void addRequests(Request theRequest) {
		if(requests == null) requests = new ArrayList<>();
		
		requests.add(theRequest);
		theRequest.setEmpleado(this);
	}
}