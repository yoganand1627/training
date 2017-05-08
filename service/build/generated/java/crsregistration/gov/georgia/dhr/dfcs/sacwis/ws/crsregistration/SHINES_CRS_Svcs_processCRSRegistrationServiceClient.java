
package gov.georgia.dhr.dfcs.sacwis.ws.crsregistration;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class SHINES_CRS_Svcs_processCRSRegistrationServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public SHINES_CRS_Svcs_processCRSRegistrationServiceClient() {
        create0();
        Endpoint SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpoint"), new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalBinding"), "xfire.local://SHINES_CRS_Svcs_processCRSRegistrationService");
        endpoints.put(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpoint"), SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpointEP);
        Endpoint SHINES_CRS_Svcs_processCRSRegistrationPort0EP = service0 .addEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPort0"), new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationBinding"), "http://167.192.98.180:5018/soap/default");
        endpoints.put(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPort0"), SHINES_CRS_Svcs_processCRSRegistrationPort0EP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((gov.georgia.dhr.dfcs.sacwis.ws.crsregistration.SHINES_CRS_Svcs_processCRSRegistrationPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public SHINES_CRS_Svcs_processCRSRegistrationPortType getSHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpoint() {
        return ((SHINES_CRS_Svcs_processCRSRegistrationPortType)(this).getEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpoint")));
    }

    public SHINES_CRS_Svcs_processCRSRegistrationPortType getSHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpoint(String url) {
        SHINES_CRS_Svcs_processCRSRegistrationPortType var = getSHINES_CRS_Svcs_processCRSRegistrationPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public SHINES_CRS_Svcs_processCRSRegistrationPortType getSHINES_CRS_Svcs_processCRSRegistrationPort0() {
        return ((SHINES_CRS_Svcs_processCRSRegistrationPortType)(this).getEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSRegistrationPort0")));
    }

    public SHINES_CRS_Svcs_processCRSRegistrationPortType getSHINES_CRS_Svcs_processCRSRegistrationPort0(String url) {
        SHINES_CRS_Svcs_processCRSRegistrationPortType var = getSHINES_CRS_Svcs_processCRSRegistrationPort0();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

}
