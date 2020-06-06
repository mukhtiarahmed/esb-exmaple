package com.ahmed.esb.aggregate;

import com.ahmed.esb.model.CsvCity;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;

public class CountryWiseCityAggregate implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        CsvCity newBody =  newExchange.getIn().getBody(CsvCity.class);
        ArrayList<CsvCity> list;
        if (oldExchange == null) {
            list = new ArrayList<>();
            list.add(newBody);
            newExchange.getIn().setBody(list);
            return newExchange;
        } else {
            list = oldExchange.getIn().getBody(ArrayList.class);
            list.add(newBody);
            return oldExchange;
        }


    }

}
