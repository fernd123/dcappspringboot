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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Measure.
 */
@Entity
@Table(name = "measure")
public class Measure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="create_at")
	@Temporal(TemporalType.DATE)
    private Date createAt;
    
    @PrePersist
   	public void prePersist() {
   		this.createAt = new Date();
   	}

    @Column(name = "weight")
    private Double weight;
    
    @Column(name = "waist")
    private Double waist;

    @Column(name = "biceps")
    private Double biceps;

    @Column(name = "leg")
    private Double leg;

    @Column(name = "chest")
    private Double chest;

    @Column(name = "gluteus")
    private Double gluteus;

    @Column(name = "max_frecuency")
    private Double maxFrecuency;

    @Column(name = "min_frecuency")
    private Double minFrecuency;

    @ManyToOne
    @JsonIgnoreProperties("measures")
    @JsonBackReference
    private Customer customer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Measure createAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Double getWeight() {
        return weight;
    }

    public Measure weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Double getWaist() {
        return waist;
    }

    public Measure waist(Double waist) {
        this.waist = waist;
        return this;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getBiceps() {
        return biceps;
    }

    public Measure biceps(Double biceps) {
        this.biceps = biceps;
        return this;
    }

    public void setBiceps(Double biceps) {
        this.biceps = biceps;
    }

    public Double getLeg() {
        return leg;
    }

    public Measure leg(Double leg) {
        this.leg = leg;
        return this;
    }

    public void setLeg(Double leg) {
        this.leg = leg;
    }

    public Double getChest() {
        return chest;
    }

    public Measure chest(Double chest) {
        this.chest = chest;
        return this;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getGluteus() {
        return gluteus;
    }

    public Measure gluteus(Double gluteus) {
        this.gluteus = gluteus;
        return this;
    }

    public void setGluteus(Double gluteus) {
        this.gluteus = gluteus;
    }

    public Double getMaxFrecuency() {
        return maxFrecuency;
    }

    public Measure maxFrecueny(Double maxFrecuency) {
        this.maxFrecuency = maxFrecuency;
        return this;
    }

    public void setMaxFrecueny(Double maxFrecuency) {
        this.maxFrecuency = maxFrecuency;
    }

    public Double getMinFrecuency() {
        return minFrecuency;
    }

    public Measure minFrecueny(Double minFrecuency) {
        this.minFrecuency = minFrecuency;
        return this;
    }

    public void setMinFrecuency(Double minFrecuency) {
        this.minFrecuency = minFrecuency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Measure customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Measure)) {
            return false;
        }
        return id != null && id.equals(((Measure) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Measure{" +
            "id=" + getId() +
            ", createAt='" + getCreateAt() + "'" +
            ", weight=" + getWeight() +
            ", biceps=" + getBiceps() +
            ", leg=" + getLeg() +
            ", chest=" + getChest() +
            ", gluteus=" + getGluteus() +
            ", maxFrecueny=" + getMaxFrecuency() +
            ", minFrecueny=" + getMinFrecuency() +
            "}";
    }
}
