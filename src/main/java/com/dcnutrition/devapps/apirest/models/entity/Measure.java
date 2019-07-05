package com.dcnutrition.devapps.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="measure")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Measure implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private Double weight; //peso
	private Double waist; //cintura
	private Double biceps;//biceps
	private Double leg;   //pierna
	private Double chest; //pecho
	private Double gluteus; //glúteo
	private Double maxFrecueny; // Para ciclistas
	private Double minFrecuency;// Para ciclistas

	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@ManyToOne
	@JsonIgnoreProperties("measures")
	private Customer customer;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getWaist() {
		return waist;
	} 

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getBiceps() {
		return biceps;
	}

	public void setBiceps(Double biceps) {
		this.biceps = biceps;
	}

	public Double getLeg() {
		return leg;
	}

	public void setLeg(Double leg) {
		this.leg = leg;
	}

	public Double getChest() {
		return chest;
	}

	public void setChest(Double chest) {
		this.chest = chest;
	}

	public Double getGluteus() {
		return gluteus;
	}

	public void setGluteus(Double gluteus) {
		this.gluteus = gluteus;
	}

	public Double getMaxFrecueny() {
		return maxFrecueny;
	}

	public void setMaxFrecueny(Double maxFrecueny) {
		this.maxFrecueny = maxFrecueny;
	}

	public Double getMinFrecuency() {
		return minFrecuency;
	}

	public void setMinFrecuency(Double minFrecuency) {
		this.minFrecuency = minFrecuency;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return this.customer;
	}
	private static final long serialVersionUID = 1L;

}
