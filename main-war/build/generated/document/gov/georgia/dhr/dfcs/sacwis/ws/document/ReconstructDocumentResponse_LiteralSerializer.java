// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package gov.georgia.dhr.dfcs.sacwis.ws.document;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.xsd.XSDConstants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.encoding.literal.DetailFragmentDeserializer;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.ArrayList;

public class ReconstructDocumentResponse_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final javax.xml.namespace.QName ns1_reconstructDocumentResult_QNAME = new QName("http://localhost/sacwis/", "reconstructDocumentResult");
    private static final javax.xml.namespace.QName ns1_document_TYPE_QNAME = new QName("http://localhost/sacwis/", "document");
    private CombinedSerializer ns1_myDocument_LiteralSerializer;
    
    public ReconstructDocumentResponse_LiteralSerializer(javax.xml.namespace.QName type, java.lang.String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public ReconstructDocumentResponse_LiteralSerializer(javax.xml.namespace.QName type, java.lang.String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns1_myDocument_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.Document.class, ns1_document_TYPE_QNAME);
    }
    
    public java.lang.Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws java.lang.Exception {
        gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse instance = new gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse();
        java.lang.Object member=null;
        javax.xml.namespace.QName elementName;
        java.util.List values;
        java.lang.Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_reconstructDocumentResult_QNAME)) {
                member = ns1_myDocument_LiteralSerializer.deserialize(ns1_reconstructDocumentResult_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setReconstructDocumentResult((gov.georgia.dhr.dfcs.sacwis.ws.document.Document)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_reconstructDocumentResult_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (java.lang.Object)instance;
    }
    
    public void doSerializeAttributes(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse instance = (gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse)obj;
        
    }
    public void doSerialize(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse instance = (gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse)obj;
        
        if (instance.getReconstructDocumentResult() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns1_myDocument_LiteralSerializer.serialize(instance.getReconstructDocumentResult(), ns1_reconstructDocumentResult_QNAME, null, writer, context);
    }
}
