
package com.lotus.staykeep;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-03-26T15:52:23.047-04:00
 * Generated source version: 3.3.0
 *
 */
public final class Confirmer_ConfirmerImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://staykeep.lotus.com/", "confirmerImplService");

    private Confirmer_ConfirmerImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ConfirmerImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ConfirmerImplService ss = new ConfirmerImplService(wsdlURL, SERVICE_NAME);
        Confirmer port = ss.getConfirmerImplPort();

        {
        System.out.println("Invoking confirm...");
        java.lang.String _confirm__return = port.confirm();
        System.out.println("confirm.result=" + _confirm__return);


        }

        System.exit(0);
    }

}
