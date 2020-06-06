package com.ahmed.esb;

import com.ahmed.esb.model.Cities;
import com.ahmed.esb.route.CsvToXmlRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvCountryBeanTest extends CamelTestSupport {
    @Test
    public void testCsv() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedMessageCount(2);
        assertMockEndpointsSatisfied();
        Cities cities = mock.getReceivedExchanges().get(0).getIn().getBody(Cities.class);
        assertEquals(3, cities.getCity().size());
        cities = mock.getReceivedExchanges().get(1).getIn().getBody(Cities.class);
        assertEquals(3, cities.getCity().size());

    }


    @Override
    protected RouteBuilder createRouteBuilder()  {
        CsvToXmlRoute route = new CsvToXmlRoute("file://src/test/resources?noop=true&fileName=test.csv",
                "mock:output", "mock:error");

        return route;
    }
}
