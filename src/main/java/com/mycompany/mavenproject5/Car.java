/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject5;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

/**
 *
 * @author Vies
 */
@Entity
@Table(name = "CAR")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByManufacturer", query = "SELECT c FROM Car c WHERE c.manufacturer = :manufacturer"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByRegistrationNo", query = "SELECT c FROM Car c WHERE c.registrationNo = :registrationNo"),
    @NamedQuery(name = "Car.findByOptLockVersion", query = "SELECT c FROM Car c WHERE c.optLockVersion = :optLockVersion")})
public class Car implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Size(max = 20)
    @Column(name = "MODEL")
    private String model;
    @Column(name = "REGISTRATION_NO")
    private Integer registrationNo;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @JoinTable(name = "CAR_CARETAKER", joinColumns = {
        @JoinColumn(name = "CAR_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CARETAKER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Caretaker> caretakerList;
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Driver driverId;
    //psk
    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(Integer registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Caretaker> getCaretakerList() {
        return caretakerList;
    }

    public void setCaretakerList(List<Caretaker> caretakerList) {
        this.caretakerList = caretakerList;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationNo != null ? registrationNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.registrationNo == null && other.registrationNo != null) || (this.registrationNo != null && !this.registrationNo.equals(other.registrationNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject5.Car[ id=" + id + " ]";
    }
    
}
