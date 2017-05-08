
package gov.georgia.dhr.dfcs.sacwis.ws.crsscreening;

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

public class SHINES_CRS_Svcs_processCRSScreeningServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public SHINES_CRS_Svcs_processCRSScreeningServiceClient() {
        create0();
        Endpoint SHINES_CRS_Svcs_processCRSScreeningPort0EP = service0 .addEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPort0"), new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningBinding"), "http://167.192.98.180:5018/soap/default");
        endpoints.put(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPort0"), SHINES_CRS_Svcs_processCRSScreeningPort0EP);
        Endpoint SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpoint"), new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalBinding"), "xfire.local://SHINES_CRS_Svcs_processCRSScreeningService");
        endpoints.put(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpoint"), SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpointEP);
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
        service0 = asf.create((gov.georgia.dhr.dfcs.sacwis.ws.crsscreening.SHINES_CRS_Svcs_processCRSScreeningPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
    }

    public SHINES_CRS_Svcs_processCRSScreeningPortType getSHINES_CRS_Svcs_processCRSScreeningPort0() {
        return ((SHINES_CRS_Svcs_processCRSScreeningPortType)(this).getEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPort0")));
    }

    public SHINES_CRS_Svcs_processCRSScreeningPortType getSHINES_CRS_Svcs_processCRSScreeningPort0(String url) {
        SHINES_CRS_Svcs_processCRSScreeningPortType var = getSHINES_CRS_Svcs_processCRSScreeningPort0();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public SHINES_CRS_Svcs_processCRSScreeningPortType getSHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpoint() {
        return ((SHINES_CRS_Svcs_processCRSScreeningPortType)(this).getEndpoint(new QName("http://167.192.98.180/", "SHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpoint")));
    }

    public SHINES_CRS_Svcs_processCRSScreeningPortType getSHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpoint(String url) {
        SHINES_CRS_Svcs_processCRSScreeningPortType var = getSHINES_CRS_Svcs_processCRSScreeningPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

}
