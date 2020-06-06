package com.ahmed.esb.splitter;

import com.ahmed.esb.model.Cities;
import com.ahmed.esb.model.City;
import com.ahmed.esb.model.CsvCity;

import java.util.*;

public class CountryWiseCitySplitter {


    public Collection<Cities> splitBody(List<CsvCity> cityList) {
        Map<String, Cities> countriesMap = new HashMap<>();
        for(CsvCity csvCity : cityList) {
            Cities cities;
            if(countriesMap.containsKey(csvCity.getCountry())) {
                cities = countriesMap.get(csvCity.getCountry());
            } else {
                cities = new Cities();
                cities.setCity(new ArrayList<>());
                cities.setCountry(csvCity.getCountry());
                countriesMap.put(csvCity.getCountry(), cities);
            }
            City city = new City();
            city.setName(csvCity.getCity());
            city.setPopulation(csvCity.getPopulation());
            cities.getCity().add(city);
        }

        return countriesMap.values();
    }
}
