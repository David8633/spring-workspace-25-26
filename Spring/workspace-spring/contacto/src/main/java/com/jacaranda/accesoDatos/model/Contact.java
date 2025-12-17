package com.jacaranda.accesoDatos.model;


import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "Contactos")
public class Contact  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Integer id;

    @Column(name = "tipo_contacto")
    private String contactType;

    @Column(name = "valor")
    private String value;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Person person;
    
    public Integer getId() {
        return id;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
   
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(id, other.id);
	}

    
  
}