// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package gov.georgia.dhr.dfcs.sacwis.ws.document;

public interface DocumentServicesSoap extends java.rmi.Remote {
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document getBlankDocument(java.lang.String documentMetaData, java.lang.String preFillData) throws 
         java.rmi.RemoteException;
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document appendDocuments(gov.georgia.dhr.dfcs.sacwis.ws.document.Document mainDocument, java.lang.String documentList) throws 
         java.rmi.RemoteException;
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document getDocument(java.lang.String documentMetaData, java.lang.String preFillData) throws 
         java.rmi.RemoteException;
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document reconstructDocument(java.lang.String documentMetaData, java.lang.String documentData) throws 
         java.rmi.RemoteException;
    public gov.georgia.dhr.dfcs.sacwis.ws.document.Document previewDocument(java.lang.String documentMetaData, java.lang.String documentData) throws 
         java.rmi.RemoteException;
}