package com.ahmed.esb;

import com.ahmed.esb.model.CsvCity;
import com.ahmed.esb.route.CsvToXmlRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvToXmlInvalidDataTest extends CamelTestSupport {

    @Test
    public void testCsv() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:error");
        mock.expectedMessageCount(1);
        assertMockEndpointsSatisfied();
        CsvCity city = mock.getReceivedExchanges().get(0).getIn().getBody(CsvCity.class);
        log.info("error :  {} " , city);

    }


    @Override
    protected RouteBuilder createRouteBuilder()  {
        CsvToXmlRoute route = new CsvToXmlRoute("file://src/test/resources?noop=true&fileName=test_invalid.csv",
                "mock:output", "mock:error");

        return route;
    }


}
