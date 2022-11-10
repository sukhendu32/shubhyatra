package com.masai.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Travels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelsId;
	
	private String travelsName;
	
	private String agentName;
	
	private String address;
	
	private String contact;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tDetails",fetch = FetchType.EAGER)
	private Set<Flight> fight = new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(address, agentName, contact, travelsId, travelsName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travels other = (Travels) obj;
		return Objects.equals(address, other.address) && Objects.equals(agentName, other.agentName)
				&& Objects.equals(contact, other.contact) && Objects.equals(travelsId, other.travelsId)
				&& Objects.equals(travelsName, other.travelsName);
	}
	
	
	

}
