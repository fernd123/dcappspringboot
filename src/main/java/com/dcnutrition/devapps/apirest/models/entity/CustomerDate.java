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
 * A CustomerDate.
 */
@Entity
@Table(name = "customer_date")
public class CustomerDate implements Serializable {

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
   		this.date = this.start;
   	}
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "color")
    private String color;

    @Column(name = "observations")
    private String observations;

    @ManyToOne
    @JsonIgnoreProperties("customerDates")
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

    public CustomerDate createAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getDate() {
        return date;
    }

    public CustomerDate date(Date date) {
        this.date = date;
        return this;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStart() {
        return start;
    }

    public CustomerDate start(Date start) {
        this.start = start;
        return this;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public CustomerDate end(Date end) {
        this.end = end;
        return this;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public CustomerDate color(String color) {
        this.color = color;
        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservations() {
        return observations;
    }

    public CustomerDate observations(String observations) {
        this.observations = observations;
        return this;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerDate customer(Customer customer) {
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
        if (!(o instanceof CustomerDate)) {
            return false;
        }
        return id != null && id.equals(((CustomerDate) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CustomerDate{" +
            "id=" + getId() +
            ", createAt='" + getCreateAt() + "'" +
            ", start='" + getStart() + "'" +
            ", end='" + getEnd() + "'" +
            ", color='" + getColor() + "'" +
            ", observations='" + getObservations() + "'" +
            "}";
    }
}
