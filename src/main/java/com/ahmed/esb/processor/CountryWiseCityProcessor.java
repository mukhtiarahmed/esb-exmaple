package com.ahmed.esb.processor;

import com.ahmed.esb.model.Cities;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountryWiseCityProcessor implements Processor {

    private static Logger log = LoggerFactory.getLogger(CountryWiseCityProcessor.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        Cities cities  = exchange.getIn().getBody(Cities.class);
        log.info("country : {}", cities.getCountry());
        exchange.getIn().setHeader(Exchange.FILE_NAME, cities.getCountry() + ".xml");
    }
}
