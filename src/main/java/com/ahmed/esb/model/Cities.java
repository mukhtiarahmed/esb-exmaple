package com.ahmed.esb.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "cities")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cities {

    @XmlElement(name = "city")
    private List<City> city;

    @XmlTransient
    private String country;

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
