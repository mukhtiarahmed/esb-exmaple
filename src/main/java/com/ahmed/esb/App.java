package com.ahmed.esb;

import com.ahmed.esb.route.CsvToXmlRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;

/**
 *  CSV File Processor
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        BasicConfigurator.configure();
        CamelContext camelContext = new DefaultCamelContext();
        CsvToXmlRoute route = new CsvToXmlRoute("file://src/main/resources?noop=true&fileName=cities.csv",
                "file://output", "file://error");
        camelContext.addRoutes(route);
        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();
    }
}
