package com.lotus.staykeep;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-03-26T15:52:23.147-04:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "confirmerImplService",
                  wsdlLocation = "http://localhost:8081/staykeep/confirmerservice?wsdl",
                  targetNamespace = "http://staykeep.lotus.com/")
public class ConfirmerImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://staykeep.lotus.com/", "confirmerImplService");
    public final static QName ConfirmerImplPort = new QName("http://staykeep.lotus.com/", "ConfirmerImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/staykeep/confirmerservice?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ConfirmerImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8081/staykeep/confirmerservice?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ConfirmerImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ConfirmerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConfirmerImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ConfirmerImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ConfirmerImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ConfirmerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns Confirmer
     */
    @WebEndpoint(name = "ConfirmerImplPort")
    public Confirmer getConfirmerImplPort() {
        return super.getPort(ConfirmerImplPort, Confirmer.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Confirmer
     */
    @WebEndpoint(name = "ConfirmerImplPort")
    public Confirmer getConfirmerImplPort(WebServiceFeature... features) {
        return super.getPort(ConfirmerImplPort, Confirmer.class, features);
    }

}
