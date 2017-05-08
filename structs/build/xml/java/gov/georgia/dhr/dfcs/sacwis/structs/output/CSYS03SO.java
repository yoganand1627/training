/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.output;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CSYS03SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSYS03SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _dtDtContact
     */
    private org.exolab.castor.types.Date _dtDtContact;

    /**
     * Field _ROWCSYS03SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY _ROWCSYS03SOG01_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSYS03SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'dtDtContact'.
     * 
     * @return the value of field 'DtDtContact'.
     */
    public org.exolab.castor.types.Date getDtDtContact()
    {
        return this._dtDtContact;
    } //-- org.exolab.castor.types.Date getDtDtContact() 

    /**
     * Returns the value of field 'ROWCSYS03SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCSYS03SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY getROWCSYS03SOG01_ARRAY()
    {
        return this._ROWCSYS03SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY getROWCSYS03SOG01_ARRAY() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'dtDtContact'.
     * 
     * @param dtDtContact the value of field 'dtDtContact'.
     */
    public void setDtDtContact(org.exolab.castor.types.Date dtDtContact)
    {
        this._dtDtContact = dtDtContact;
    } //-- void setDtDtContact(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCSYS03SOG01_ARRAY'.
     * 
     * @param ROWCSYS03SOG01_ARRAY the value of field
     * 'ROWCSYS03SOG01_ARRAY'.
     */
    public void setROWCSYS03SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY ROWCSYS03SOG01_ARRAY)
    {
        this._ROWCSYS03SOG01_ARRAY = ROWCSYS03SOG01_ARRAY;
    } //-- void setROWCSYS03SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO unmarshal(java.io.Reader) 

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
