package com.fabs.model.users;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "address", schema = "local_suggestions_users")
public class Address {
    private Integer id;
    private User user;
    private String addressType;
    private String houseNumber;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String zipOrPostCode;
    private String city;
    private String countyOrProvince;
    private String country;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "addressType")
    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Basic
    @Column(name = "houseNumber")
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Basic
    @Column(name = "addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "addressLine3")
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    @Basic
    @Column(name = "addressLine4")
    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    @Basic
    @Column(name = "zipOrPostCode")
    public String getZipOrPostCode() {
        return zipOrPostCode;
    }

    public void setZipOrPostCode(String zipOrPostCode) {
        this.zipOrPostCode = zipOrPostCode;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "countyOrProvince")
    public String getCountyOrProvince() {
        return countyOrProvince;
    }

    public void setCountyOrProvince(String countyOrProvince) {
        this.countyOrProvince = countyOrProvince;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "updateTimestamp")
    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Basic
    @Column(name = "isDeleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (user != null ? !user.equals(address.user) : address.user != null) return false;
        if (addressType != null ? !addressType.equals(address.addressType) : address.addressType != null) return false;
        if (houseNumber != null ? !houseNumber.equals(address.houseNumber) : address.houseNumber != null) return false;
        if (addressLine1 != null ? !addressLine1.equals(address.addressLine1) : address.addressLine1 != null)
            return false;
        if (addressLine2 != null ? !addressLine2.equals(address.addressLine2) : address.addressLine2 != null)
            return false;
        if (addressLine3 != null ? !addressLine3.equals(address.addressLine3) : address.addressLine3 != null)
            return false;
        if (addressLine4 != null ? !addressLine4.equals(address.addressLine4) : address.addressLine4 != null)
            return false;
        if (zipOrPostCode != null ? !zipOrPostCode.equals(address.zipOrPostCode) : address.zipOrPostCode != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null)
            return false;
        if (countyOrProvince != null ? !countyOrProvince.equals(address.countyOrProvince) : address.countyOrProvince != null)
            return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (version != null ? !version.equals(address.version) : address.version != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(address.updateTimestamp) : address.updateTimestamp != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(address.isDeleted) : address.isDeleted != null) return false;
        if (id != null ? !id.equals(address.id) : address.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (addressType != null ? addressType.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (addressLine3 != null ? addressLine3.hashCode() : 0);
        result = 31 * result + (addressLine4 != null ? addressLine4.hashCode() : 0);
        result = 31 * result + (zipOrPostCode != null ? zipOrPostCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (countyOrProvince != null ? countyOrProvince.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user=" + user +
                ", addressType='" + addressType + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", addressLine4='" + addressLine4 + '\'' +
                ", zipOrPostCode='" + zipOrPostCode + '\'' +
                ", city='" + city + '\'' +
                ", countyOrProvince='" + countyOrProvince + '\'' +
                ", country='" + country + '\'' +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
