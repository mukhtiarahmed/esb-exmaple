package com.ahmed.esb.model;


import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@CsvRecord(separator = ",")
public class CsvCity {

    @NotNull
    @Size(min = 3, max = 100, message ="country is mandatory")
    @DataField(pos = 1)
    private String country;


    @NotNull
    @Size(min = 3, max = 100,  message ="city is mandatory")
    @DataField(pos = 2)
    private String city;

    @DataField(pos = 3)
    private String population;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
