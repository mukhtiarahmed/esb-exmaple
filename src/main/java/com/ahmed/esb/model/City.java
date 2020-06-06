package com.ahmed.esb.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute
    private String name;

    @XmlElement
    private String population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
