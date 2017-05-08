// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package gov.georgia.dhr.dfcs.sacwis.ws.document;

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

public class DocumentServicesSoap_Stub
    extends com.sun.xml.rpc.client.StubBase
    implements gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap {
    
    
    
    /*
     *  public constructor
     */
    public DocumentServicesSoap_Stub(HandlerChain handlerChain) {
        super(handlerChain);
        _setProperty(ENDPOINT_ADDRESS_PROPERTY, "http://localhost/sacwis/documentservices.asmx");
    }
    
    
    /*
     *  implementation of getDocument
     */
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document getDocument(java.lang.String documentMetaData, java.lang.String preFillData)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(getDocument_OPCODE);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocument _myGetDocument = new gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocument();
            _myGetDocument.setDocumentMetaData(documentMetaData);
            _myGetDocument.setPreFillData(preFillData);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_getDocument_getDocument_QNAME);
            _bodyBlock.setValue(_myGetDocument);
            _bodyBlock.setSerializer(ns1_myGetDocument_LiteralSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "http://localhost/sacwis/getDocument");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocumentResponse _result = null;
            java.lang.Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocumentResponse)((SOAPDeserializationState) _responseObj).getInstance();
            } else {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocumentResponse)_responseObj;
            }
            
            return _result.getGetDocumentResult();
            
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
     *  implementation of previewDocument
     */
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document previewDocument(java.lang.String documentMetaData, java.lang.String documentData)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(previewDocument_OPCODE);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocument _myPreviewDocument = new gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocument();
            _myPreviewDocument.setDocumentMetaData(documentMetaData);
            _myPreviewDocument.setDocumentData(documentData);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_previewDocument_previewDocument_QNAME);
            _bodyBlock.setValue(_myPreviewDocument);
            _bodyBlock.setSerializer(ns1_myPreviewDocument_LiteralSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "http://localhost/sacwis/previewDocument");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocumentResponse _result = null;
            java.lang.Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocumentResponse)((SOAPDeserializationState) _responseObj).getInstance();
            } else {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocumentResponse)_responseObj;
            }
            
            return _result.getPreviewDocumentResult();
            
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
     *  implementation of appendDocuments
     */
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document appendDocuments(gov.georgia.dhr.dfcs.sacwis.ws.document.Document mainDocument, java.lang.String documentList)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(appendDocuments_OPCODE);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocuments _myAppendDocuments = new gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocuments();
            _myAppendDocuments.setMainDocument(mainDocument);
            _myAppendDocuments.setDocumentList(documentList);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_appendDocuments_appendDocuments_QNAME);
            _bodyBlock.setValue(_myAppendDocuments);
            _bodyBlock.setSerializer(ns1_myAppendDocuments_LiteralSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "http://localhost/sacwis/appendDocuments");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocumentsResponse _result = null;
            java.lang.Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocumentsResponse)((SOAPDeserializationState) _responseObj).getInstance();
            } else {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocumentsResponse)_responseObj;
            }
            
            return _result.getAppendDocumentsResult();
            
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
     *  implementation of getBlankDocument
     */
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document getBlankDocument(java.lang.String documentMetaData, java.lang.String preFillData)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(getBlankDocument_OPCODE);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocument _myGetBlankDocument = new gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocument();
            _myGetBlankDocument.setDocumentMetaData(documentMetaData);
            _myGetBlankDocument.setPreFillData(preFillData);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_getBlankDocument_getBlankDocument_QNAME);
            _bodyBlock.setValue(_myGetBlankDocument);
            _bodyBlock.setSerializer(ns1_myGetBlankDocument_LiteralSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "http://localhost/sacwis/getBlankDocument");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocumentResponse _result = null;
            java.lang.Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocumentResponse)((SOAPDeserializationState) _responseObj).getInstance();
            } else {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocumentResponse)_responseObj;
            }
            
            return _result.getGetBlankDocumentResult();
            
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
     *  implementation of reconstructDocument
     */
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document reconstructDocument(java.lang.String documentMetaData, java.lang.String documentData)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(reconstructDocument_OPCODE);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocument _myReconstructDocument = new gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocument();
            _myReconstructDocument.setDocumentMetaData(documentMetaData);
            _myReconstructDocument.setDocumentData(documentData);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_reconstructDocument_reconstructDocument_QNAME);
            _bodyBlock.setValue(_myReconstructDocument);
            _bodyBlock.setSerializer(ns1_myReconstructDocument_LiteralSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "http://localhost/sacwis/reconstructDocument");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse _result = null;
            java.lang.Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse)((SOAPDeserializationState) _responseObj).getInstance();
            } else {
                _result = (gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse)_responseObj;
            }
            
            return _result.getReconstructDocumentResult();
            
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
            case getDocument_OPCODE:
                _deserialize_getDocument(bodyReader, deserializationContext, state);
                break;
            case previewDocument_OPCODE:
                _deserialize_previewDocument(bodyReader, deserializationContext, state);
                break;
            case appendDocuments_OPCODE:
                _deserialize_appendDocuments(bodyReader, deserializationContext, state);
                break;
            case getBlankDocument_OPCODE:
                _deserialize_getBlankDocument(bodyReader, deserializationContext, state);
                break;
            case reconstructDocument_OPCODE:
                _deserialize_reconstructDocument(bodyReader, deserializationContext, state);
                break;
            default:
                throw new SenderException("sender.response.unrecognizedOperation", java.lang.Integer.toString(opcode));
        }
    }
    
    
    
    /*
     * This method deserializes the body of the getDocument operation.
     */
    private void _deserialize_getDocument(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myGetDocumentResponseObj =
            ns1_myGetDocumentResponse_LiteralSerializer.deserialize(ns1_getDocument_getDocumentResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_getDocument_getDocumentResponse_QNAME);
        bodyBlock.setValue(myGetDocumentResponseObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    /*
     * This method deserializes the body of the previewDocument operation.
     */
    private void _deserialize_previewDocument(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myPreviewDocumentResponseObj =
            ns1_myPreviewDocumentResponse_LiteralSerializer.deserialize(ns1_previewDocument_previewDocumentResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_previewDocument_previewDocumentResponse_QNAME);
        bodyBlock.setValue(myPreviewDocumentResponseObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    /*
     * This method deserializes the body of the appendDocuments operation.
     */
    private void _deserialize_appendDocuments(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myAppendDocumentsResponseObj =
            ns1_myAppendDocumentsResponse_LiteralSerializer.deserialize(ns1_appendDocuments_appendDocumentsResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_appendDocuments_appendDocumentsResponse_QNAME);
        bodyBlock.setValue(myAppendDocumentsResponseObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    /*
     * This method deserializes the body of the getBlankDocument operation.
     */
    private void _deserialize_getBlankDocument(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myGetBlankDocumentResponseObj =
            ns1_myGetBlankDocumentResponse_LiteralSerializer.deserialize(ns1_getBlankDocument_getBlankDocumentResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_getBlankDocument_getBlankDocumentResponse_QNAME);
        bodyBlock.setValue(myGetBlankDocumentResponseObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    /*
     * This method deserializes the body of the reconstructDocument operation.
     */
    private void _deserialize_reconstructDocument(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myReconstructDocumentResponseObj =
            ns1_myReconstructDocumentResponse_LiteralSerializer.deserialize(ns1_reconstructDocument_reconstructDocumentResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_reconstructDocument_reconstructDocumentResponse_QNAME);
        bodyBlock.setValue(myReconstructDocumentResponseObj);
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
        ns1_myGetBlankDocument_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocument.class, ns1_getBlankDocument_TYPE_QNAME);
        ns1_myPreviewDocument_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocument.class, ns1_previewDocument_TYPE_QNAME);
        ns1_myAppendDocuments_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocuments.class, ns1_appendDocuments_TYPE_QNAME);
        ns1_myGetBlankDocumentResponse_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.GetBlankDocumentResponse.class, ns1_getBlankDocumentResponse_TYPE_QNAME);
        ns1_myPreviewDocumentResponse_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.PreviewDocumentResponse.class, ns1_previewDocumentResponse_TYPE_QNAME);
        ns1_myGetDocumentResponse_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocumentResponse.class, ns1_getDocumentResponse_TYPE_QNAME);
        ns1_myAppendDocumentsResponse_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.AppendDocumentsResponse.class, ns1_appendDocumentsResponse_TYPE_QNAME);
        ns1_myReconstructDocument_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocument.class, ns1_reconstructDocument_TYPE_QNAME);
        ns1_myGetDocument_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.GetDocument.class, ns1_getDocument_TYPE_QNAME);
        ns1_myReconstructDocumentResponse_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", gov.georgia.dhr.dfcs.sacwis.ws.document.ReconstructDocumentResponse.class, ns1_reconstructDocumentResponse_TYPE_QNAME);
    }
    
    private static final javax.xml.namespace.QName _portName = new QName("http://localhost/sacwis/", "DocumentServicesSoap");
    private static final int getDocument_OPCODE = 0;
    private static final int previewDocument_OPCODE = 1;
    private static final int appendDocuments_OPCODE = 2;
    private static final int getBlankDocument_OPCODE = 3;
    private static final int reconstructDocument_OPCODE = 4;
    private static final javax.xml.namespace.QName ns1_getDocument_getDocument_QNAME = new QName("http://localhost/sacwis/", "getDocument");
    private static final javax.xml.namespace.QName ns1_getDocument_TYPE_QNAME = new QName("http://localhost/sacwis/", "getDocument");
    private CombinedSerializer ns1_myGetDocument_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_getDocument_getDocumentResponse_QNAME = new QName("http://localhost/sacwis/", "getDocumentResponse");
    private static final javax.xml.namespace.QName ns1_getDocumentResponse_TYPE_QNAME = new QName("http://localhost/sacwis/", "getDocumentResponse");
    private CombinedSerializer ns1_myGetDocumentResponse_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_previewDocument_previewDocument_QNAME = new QName("http://localhost/sacwis/", "previewDocument");
    private static final javax.xml.namespace.QName ns1_previewDocument_TYPE_QNAME = new QName("http://localhost/sacwis/", "previewDocument");
    private CombinedSerializer ns1_myPreviewDocument_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_previewDocument_previewDocumentResponse_QNAME = new QName("http://localhost/sacwis/", "previewDocumentResponse");
    private static final javax.xml.namespace.QName ns1_previewDocumentResponse_TYPE_QNAME = new QName("http://localhost/sacwis/", "previewDocumentResponse");
    private CombinedSerializer ns1_myPreviewDocumentResponse_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_appendDocuments_appendDocuments_QNAME = new QName("http://localhost/sacwis/", "appendDocuments");
    private static final javax.xml.namespace.QName ns1_appendDocuments_TYPE_QNAME = new QName("http://localhost/sacwis/", "appendDocuments");
    private CombinedSerializer ns1_myAppendDocuments_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_appendDocuments_appendDocumentsResponse_QNAME = new QName("http://localhost/sacwis/", "appendDocumentsResponse");
    private static final javax.xml.namespace.QName ns1_appendDocumentsResponse_TYPE_QNAME = new QName("http://localhost/sacwis/", "appendDocumentsResponse");
    private CombinedSerializer ns1_myAppendDocumentsResponse_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_getBlankDocument_getBlankDocument_QNAME = new QName("http://localhost/sacwis/", "getBlankDocument");
    private static final javax.xml.namespace.QName ns1_getBlankDocument_TYPE_QNAME = new QName("http://localhost/sacwis/", "getBlankDocument");
    private CombinedSerializer ns1_myGetBlankDocument_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_getBlankDocument_getBlankDocumentResponse_QNAME = new QName("http://localhost/sacwis/", "getBlankDocumentResponse");
    private static final javax.xml.namespace.QName ns1_getBlankDocumentResponse_TYPE_QNAME = new QName("http://localhost/sacwis/", "getBlankDocumentResponse");
    private CombinedSerializer ns1_myGetBlankDocumentResponse_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_reconstructDocument_reconstructDocument_QNAME = new QName("http://localhost/sacwis/", "reconstructDocument");
    private static final javax.xml.namespace.QName ns1_reconstructDocument_TYPE_QNAME = new QName("http://localhost/sacwis/", "reconstructDocument");
    private CombinedSerializer ns1_myReconstructDocument_LiteralSerializer;
    private static final javax.xml.namespace.QName ns1_reconstructDocument_reconstructDocumentResponse_QNAME = new QName("http://localhost/sacwis/", "reconstructDocumentResponse");
    private static final javax.xml.namespace.QName ns1_reconstructDocumentResponse_TYPE_QNAME = new QName("http://localhost/sacwis/", "reconstructDocumentResponse");
    private CombinedSerializer ns1_myReconstructDocumentResponse_LiteralSerializer;
    private static final java.lang.String[] myNamespace_declarations =
                                        new java.lang.String[] {
                                            "ns0", "http://localhost/sacwis/"
                                        };
    
    private static final QName[] understoodHeaderNames = new QName[] {  };
}
