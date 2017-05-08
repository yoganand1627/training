/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class PreFillMetaData.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreFillMetaData implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _serviceName
     */
    private java.lang.String _serviceName;

    /**
     * Field _inputClass
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass _inputClass;

    /**
     * Field _outputClass
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.OutputClass _outputClass;

    /**
     * Field _errorMessages
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages _errorMessages;


      //----------------/
     //- Constructors -/
    //----------------/

    public PreFillMetaData() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'errorMessages'.
     * 
     * @return the value of field 'ErrorMessages'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages getErrorMessages()
    {
        return this._errorMessages;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages getErrorMessages() 

    /**
     * Returns the value of field 'inputClass'.
     * 
     * @return the value of field 'InputClass'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass getInputClass()
    {
        return this._inputClass;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass getInputClass() 

    /**
     * Returns the value of field 'outputClass'.
     * 
     * @return the value of field 'OutputClass'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.OutputClass getOutputClass()
    {
        return this._outputClass;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.OutputClass getOutputClass() 

    /**
     * Returns the value of field 'serviceName'.
     * 
     * @return the value of field 'ServiceName'.
     */
    public java.lang.String getServiceName()
    {
        return this._serviceName;
    } //-- java.lang.String getServiceName() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'errorMessages'.
     * 
     * @param errorMessages the value of field 'errorMessages'.
     */
    public void setErrorMessages(gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages errorMessages)
    {
        this._errorMessages = errorMessages;
    } //-- void setErrorMessages(gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages) 

    /**
     * Sets the value of field 'inputClass'.
     * 
     * @param inputClass the value of field 'inputClass'.
     */
    public void setInputClass(gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass inputClass)
    {
        this._inputClass = inputClass;
    } //-- void setInputClass(gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass) 

    /**
     * Sets the value of field 'outputClass'.
     * 
     * @param outputClass the value of field 'outputClass'.
     */
    public void setOutputClass(gov.georgia.dhr.dfcs.sacwis.structs.document.OutputClass outputClass)
    {
        this._outputClass = outputClass;
    } //-- void setOutputClass(gov.georgia.dhr.dfcs.sacwis.structs.document.OutputClass) 

    /**
     * Sets the value of field 'serviceName'.
     * 
     * @param serviceName the value of field 'serviceName'.
     */
    public void setServiceName(java.lang.String serviceName)
    {
        this._serviceName = serviceName;
    } //-- void setServiceName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData unmarshal(java.io.Reader) 

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
