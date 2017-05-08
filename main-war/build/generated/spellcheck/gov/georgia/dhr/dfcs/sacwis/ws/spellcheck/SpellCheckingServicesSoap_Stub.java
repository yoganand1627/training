// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package gov.georgia.dhr.dfcs.sacwis.ws.spellcheck;

import com.sun.xml.rpc.server.http.MessageContextProperties;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.soap.streaming.*;
import com.sun.xml.rpc.soap.message.*;
import com.sun.xml.rpc.soap.SOAPVersion;
import com.sun.xml.rpc.soap.SOAPEncodingConstants;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.lang.reflect.*;
import java.lang.Class;
import com.sun.xml.rpc.client.SenderException;
import com.sun.xml.rpc.client.*;
import com.sun.xml.rpc.client.http.*;
import javax.xml.rpc.handler.*;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.soap.SOAPFaultException;

public class SpellCheckingServicesSoap_Stub
    extends com.sun.xml.rpc.client.StubBase
    implements gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.SpellCheckingServicesSoap {
    
    
    
    /*
     *  public constructor
     */
    public SpellCheckingServicesSoap_Stub(HandlerChain handlerChain) {
        super(handlerChain);
        _setProperty(ENDPOINT_ADDRESS_PROPERTY, "http://localhost/sacwis/spellcheckservices.asmx");
    }
    
    
    /*
     *  implementation of getCorrectionsUI
     */
    public java.lang.String getCorrectionsUI(gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.ArrayOfString fields, gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.ArrayOfString values)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(getCorrectionsUI_OPCODE);
            
            gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUI _myGetCorrectionsUI = new gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUI();
            _myGetCorrectionsUI.setFields(fields);
            _myGetCorrectionsUI.setValues(values);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_getCorrectionsUI_getCorrectionsUI_QNAME);
            _bodyBlock.setValue(_myGetCorrectionsUI);
            _bodyBlock.setSerializer(ns1_myGetCorrectionsUI_LiteralSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "http://localhost/sacwis/getCorrectionsUI");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUIResponse _result = null;
            java.lang.Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUIResponse)((SOAPDeserializationState) _responseObj).getInstance();
            } else {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUIResponse)_responseObj;
            }
            
            return _result.getGetCorrectionsUIResult();
            
        } catch (RemoteException e) {
            // let this one through unchanged
            throw e;
        } catch (JAXRPCException e) {
            throw new RemoteException(e.getMessage(), e);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException)e;
            } else {
                throw new RemoteException(e.getMessage(), e);
            }
        }
    }
    
    
    /*
     *  this method deserializes the request/response structure in the body
     */
    protected void _readFirstBodyElement(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState  state) throws Exception {
        int opcode = state.getRequest().getOperationCode();
        switch (opcode) {
            case getCorrectionsUI_OPCODE:
                _deserialize_getCorrectionsUI(bodyReader, deserializationContext, state);
                break;
            default:
                throw new SenderException("sender.response.unrecognizedOperation", java.lang.Integer.toString(opcode));
        }
    }
    
    
    
    /*
     * This method deserializes the body of the getCorrectionsUI operation.
     */
    private void _deserialize_getCorrectionsUI(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myGetCorrectionsUIResponseObj =
            ns1_myGetCorrectionsUIResponse_LiteralSerializer.deserialize(ns1_getCorrectionsUI_getCorrectionsUIResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_getCorrectionsUI_getCorrectionsUIResponse_QNAME);
        bodyBlock.setValue(myGetCorrectionsUIResponseObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    
    
    protected java.lang.String _getDefaultEnvelopeEncodingStyle() {
        return null;
    }
    
    public java.lang.String _getImplicitEnvelopeEncodingStyle() {
        return "";
    }
    
    public java.lang.String _getEncodingStyle() {
        return SOAPNamespaceConstants.ENCODING;
    }
    
    public void _setEncodingStyle(java.lang.String encodingStyle) {
        throw new UnsupportedOperationException("cannot set encoding style");
    }
    
    
    
    
    
    /*
     * This method returns an array containing (prefix, nsURI) pairs.
     */
    protected java.lang.String[] _getNamespaceDeclarations() {
        return myNamespace_declarations;
    }
    
    /*
     * This method returns an array containing the names of the headers we understand.
     */
    public javax.xml.namespace.QName[] _getUnderstoodHeaders() {
        return understoodHeaderNames;
    }
    
    public void _initialize(InternalTypeMappingRegistry registry) throws Exception {
        super._initialize(registry);
        ns1_myGetCorrectionsUI_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUI.class, ns1_getCorrectionsUI_TYPE_QNAME);
        ns1_myGetCorrectionsUIResponse_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.GetCorrectionsUIResponse.class, ns1_getCorrectionsUIResponse_TYPE_QNAME);
    }
    
    private static final javax.xml.namespace.QName _portName = new QName("http://localhost/sacwis/", "SpellCheckingServicesSoap");
    private static final int getCorrectionsUI_OPCODE = 0;
    private static final javax.xml.namespace.QName ns1_getCorrectionsUI_getCorrectionsUI_QNAME = new QName("http://localhost/sacwis/", "getCorrectionsUI");
    private static final javax.xml.namespace.QName ns1_getCorrectionsUI_TYPE_QNAME = new QName("http://localhost/sacwis/", "getCorrectionsUI");
    private CombinedSerializer ns1_myGetCorrectionsUI_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_getCorrectionsUI_getCorrectionsUIResponse_QNAME = new QName("http://localhost/sacwis/", "getCorrectionsUIResponse");
    private static final javax.xml.namespace.QName ns1_getCorrectionsUIResponse_TYPE_QNAME = new QName("http://localhost/sacwis/", "getCorrectionsUIResponse");
    private CombinedSerializer ns1_myGetCorrectionsUIResponse_LiteralSerializer;
    private static final java.lang.String[] myNamespace_declarations =
                                        new java.lang.String[] {
                                            "ns0", "http://localhost/sacwis/"
                                        };
    
    private static final QName[] understoodHeaderNames = new QName[] {  };
}
