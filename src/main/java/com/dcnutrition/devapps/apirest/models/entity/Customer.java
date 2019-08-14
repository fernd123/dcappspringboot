package com.dcnutrition.devapps.apirest.models.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="create_at")
	@Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "height")
    private String height;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "observations")
    private String observations;

    @Column(name = "city")
    private String city;

    @PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

    @OneToOne
    @JoinColumn(unique = true)
    private UserCustom user;
	
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Measure> measures = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CustomerDate> customerDates = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Training> trainings = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Diet> diets = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Customer createAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getName() {
        return name;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public Customer lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public Customer sex(String sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public Customer height(String height) {
        this.height = height;
        return this;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Customer birthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public Customer phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservations() {
        return observations;
    }

    public Customer observations(String observations) {
        this.observations = observations;
        return this;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getCity() {
        return city;
    }

    public Customer city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /*
    public User getUser() {
        return user;
    }

    public Customer user(User user) {
        this.user = user;
        return this;
    }
    

    public void setUser(User user) {
        this.user = user;
    }
	*/
    public Set<Measure> getMeasures() {
        return measures;
    }

    public Customer measures(Set<Measure> measures) {
        this.measures = measures;
        return this;
    }

    public Customer addMeasure(Measure measure) {
        this.measures.add(measure);
        measure.setCustomer(this);
        return this;
    }

    public Customer removeMeasure(Measure measure) {
        this.measures.remove(measure);
        measure.setCustomer(null);
        return this;
    }

    public void setMeasures(Set<Measure> measures) {
        this.measures = measures;
    }

    public Set<CustomerDate> getCustomerDates() {
        return customerDates;
    }

    public Customer customerDates(Set<CustomerDate> customerDates) {
        this.customerDates = customerDates;
        return this;
    }

    public Customer addCustomerDate(CustomerDate customerDate) {
        this.customerDates.add(customerDate);
        customerDate.setCustomer(this);
        return this;
    }

    public Customer removeCustomerDate(CustomerDate customerDate) {
        this.customerDates.remove(customerDate);
        customerDate.setCustomer(null);
        return this;
    }

    public void setCustomerDates(Set<CustomerDate> customerDates) {
        this.customerDates = customerDates;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public Customer trainings(Set<Training> trainings) {
        this.trainings = trainings;
        return this;
    }

    public Customer addTraining(Training training) {
        this.trainings.add(training);
        training.setCustomer(this);
        return this;
    }

    public Customer removeTraining(Training training) {
        this.trainings.remove(training);
        training.setCustomer(null);
        return this;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    public Set<Diet> getDiets() {
        return diets;
    }

    public Customer diets(Set<Diet> diets) {
        this.diets = diets;
        return this;
    }

    public Customer addDiet(Diet diet) {
        this.diets.add(diet);
        diet.setCustomer(this);
        return this;
    }

    public Customer removeDiet(Diet diet) {
        this.diets.remove(diet);
        diet.setCustomer(null);
        return this;
    }

    public void setDiets(Set<Diet> diets) {
        this.diets = diets;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", createAt='" + getCreateAt() + "'" +
            ", name='" + getName() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", sex='" + getSex() + "'" +
            ", height='" + getHeight() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", observations='" + getObservations() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }

}
