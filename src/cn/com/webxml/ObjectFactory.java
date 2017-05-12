
package cn.com.webxml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.com.webxml package. 
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

    private final static QName _String_QNAME = new QName("http://WebXml.com.cn/", "string");
    private final static QName _ArrayOfString_QNAME = new QName("http://WebXml.com.cn/", "ArrayOfString");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.com.webxml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetVersionTimeResponse }
     * 
     */
    public GetVersionTimeResponse createGetVersionTimeResponse() {
        return new GetVersionTimeResponse();
    }

    /**
     * Create an instance of {@link GetVersionTime }
     * 
     */
    public GetVersionTime createGetVersionTime() {
        return new GetVersionTime();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link GetGeoIPContextResponse }
     * 
     */
    public GetGeoIPContextResponse createGetGeoIPContextResponse() {
        return new GetGeoIPContextResponse();
    }

    /**
     * Create an instance of {@link GetCountryCityByIpResponse }
     * 
     */
    public GetCountryCityByIpResponse createGetCountryCityByIpResponse() {
        return new GetCountryCityByIpResponse();
    }

    /**
     * Create an instance of {@link GetCountryCityByIp }
     * 
     */
    public GetCountryCityByIp createGetCountryCityByIp() {
        return new GetCountryCityByIp();
    }

    /**
     * Create an instance of {@link GetGeoIPContext }
     * 
     */
    public GetGeoIPContext createGetGeoIPContext() {
        return new GetGeoIPContext();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebXml.com.cn/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebXml.com.cn/", name = "ArrayOfString")
    public JAXBElement<ArrayOfString> createArrayOfString(ArrayOfString value) {
        return new JAXBElement<ArrayOfString>(_ArrayOfString_QNAME, ArrayOfString.class, null, value);
    }

}
