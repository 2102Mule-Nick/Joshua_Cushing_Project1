
package com.lotus.staykeep;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lotus.staykeep package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Confirm_QNAME = new QName("http://staykeep.lotus.com/", "confirm");
    private final static QName _ConfirmResponse_QNAME = new QName("http://staykeep.lotus.com/", "confirmResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lotus.staykeep
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Confirm }
     * 
     */
    public Confirm createConfirm() {
        return new Confirm();
    }

    /**
     * Create an instance of {@link ConfirmResponse }
     * 
     */
    public ConfirmResponse createConfirmResponse() {
        return new ConfirmResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Confirm }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Confirm }{@code >}
     */
    @XmlElementDecl(namespace = "http://staykeep.lotus.com/", name = "confirm")
    public JAXBElement<Confirm> createConfirm(Confirm value) {
        return new JAXBElement<Confirm>(_Confirm_QNAME, Confirm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfirmResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://staykeep.lotus.com/", name = "confirmResponse")
    public JAXBElement<ConfirmResponse> createConfirmResponse(ConfirmResponse value) {
        return new JAXBElement<ConfirmResponse>(_ConfirmResponse_QNAME, ConfirmResponse.class, null, value);
    }

}
