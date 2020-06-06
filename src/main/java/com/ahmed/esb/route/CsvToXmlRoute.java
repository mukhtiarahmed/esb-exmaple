package com.ahmed.esb.route;

import com.ahmed.esb.aggregate.CountryWiseCityAggregate;
import com.ahmed.esb.model.CsvCity;
import com.ahmed.esb.processor.CountryWiseCityProcessor;
import com.ahmed.esb.splitter.CountryWiseCitySplitter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

/**
 *
 */
public class CsvToXmlRoute  extends RouteBuilder {

    private String inUri;

    private String outUri;

    private String errorUri;

    public CsvToXmlRoute(String inUri, String outUri, String errorUri) {
        this.inUri = inUri;
        this.outUri = outUri;
        this.errorUri = errorUri;
    }

    @Override
    public void configure()  {
        errorHandler(deadLetterChannel(errorUri));
        from(inUri)
                .unmarshal(new BindyCsvDataFormat(CsvCity.class))
                .setHeader("citySize", simple("${body.size()}"))
                .split(body()).streaming()
                .to("bean-validator://csvCity")
                .aggregate(constant(true), new CountryWiseCityAggregate())
                .completionSize(header("citySize"))
                .split().method(CountryWiseCitySplitter.class, "splitBody")
                .process(new CountryWiseCityProcessor())
                .to(outUri);


    }
}
