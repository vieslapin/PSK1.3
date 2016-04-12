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
import javax.persistence.ManyToMany;
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
@Table(name = "CARETAKER")
@NamedQueries({
    @NamedQuery(name = "Caretaker.findAll", query = "SELECT c FROM Caretaker c"),
    @NamedQuery(name = "Caretaker.findById", query = "SELECT c FROM Caretaker c WHERE c.id = :id"),
    @NamedQuery(name = "Caretaker.findByFirstName", query = "SELECT c FROM Caretaker c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Caretaker.findByLastName", query = "SELECT c FROM Caretaker c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Caretaker.findByIdNumber", query = "SELECT c FROM Caretaker c WHERE c.idNumber = :idNumber"),
    @NamedQuery(name = "Caretaker.findByOptLockVersion", query = "SELECT c FROM Caretaker c WHERE c.optLockVersion = :optLockVersion")})
public class Caretaker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ID_NUMBER")
    private Integer idNumber;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @ManyToMany(mappedBy = "caretakerList")
    private List<Car> carList;

    public Caretaker() {
    }

    public Caretaker(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumber != null ? idNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caretaker)) {
            return false;
        }
        Caretaker other = (Caretaker) object;
        if ((this.idNumber == null && other.idNumber != null) || (this.idNumber != null && !this.idNumber.equals(other.idNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject5.Caretaker[ id=" + id + " ]";
    }
    
}
