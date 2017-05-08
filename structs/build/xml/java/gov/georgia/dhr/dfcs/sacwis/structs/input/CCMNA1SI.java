/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.input;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CCMNA1SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMNA1SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _ROWCLSS76DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSS76DO _ROWCLSS76DO;

    /**
     * Field _ulIdPerson_ARRAY_CCMNA1SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMNA1SI _ulIdPerson_ARRAY_CCMNA1SI;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMNA1SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'ROWCLSS76DO'.
     * 
     * @return the value of field 'ROWCLSS76DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSS76DO getROWCLSS76DO()
    {
        return this._ROWCLSS76DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSS76DO getROWCLSS76DO() 

    /**
     * Returns the value of field 'ulIdPerson_ARRAY_CCMNA1SI'.
     * 
     * @return the value of field 'UlIdPerson_ARRAY_CCMNA1SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMNA1SI getUlIdPerson_ARRAY_CCMNA1SI()
    {
        return this._ulIdPerson_ARRAY_CCMNA1SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMNA1SI getUlIdPerson_ARRAY_CCMNA1SI() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'ROWCLSS76DO'.
     * 
     * @param ROWCLSS76DO the value of field 'ROWCLSS76DO'.
     */
    public void setROWCLSS76DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSS76DO ROWCLSS76DO)
    {
        this._ROWCLSS76DO = ROWCLSS76DO;
    } //-- void setROWCLSS76DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSS76DO) 

    /**
     * Sets the value of field 'ulIdPerson_ARRAY_CCMNA1SI'.
     * 
     * @param ulIdPerson_ARRAY_CCMNA1SI the value of field
     * 'ulIdPerson_ARRAY_CCMNA1SI'.
     */
    public void setUlIdPerson_ARRAY_CCMNA1SI(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMNA1SI ulIdPerson_ARRAY_CCMNA1SI)
    {
        this._ulIdPerson_ARRAY_CCMNA1SI = ulIdPerson_ARRAY_CCMNA1SI;
    } //-- void setUlIdPerson_ARRAY_CCMNA1SI(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMNA1SI) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI unmarshal(java.io.Reader) 

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
