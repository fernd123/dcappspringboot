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
 * A Training.
 */
@Entity
@Table(name = "training")
public class Training implements Serializable {

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
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "route")
    private String route;

    @ManyToOne
    @JsonIgnoreProperties("trainings")
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

    public Training createAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getName() {
        return name;
    }

    public Training name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Training route(String route) {
        this.route = route;
        return this;
    }

    public void setRoute(String route) {
        this.route = route;
    }
    
    public String getRoute(String route) {
		return this.route;
	}

    public Customer getCustomer() {
        return customer;
    }

    public Training customer(Customer customer) {
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
        if (!(o instanceof Training)) {
            return false;
        }
        return id != null && id.equals(((Training) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Training{" +
            "id=" + getId() +
            ", createAt='" + getCreateAt() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
