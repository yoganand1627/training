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
 * Class CINV07SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV07SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtIncomingCall
     */
    private org.exolab.castor.types.Date _dtDtIncomingCall;

    /**
     * Field _CINV07SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00 _CINV07SOG00;

    /**
     * Field _CINV07SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01_ARRAY _CINV07SOG01_ARRAY;

    /**
     * Field _CINV07SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02_ARRAY _CINV07SOG02_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV07SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO()


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
     * Returns the value of field 'CINV07SOG00'.
     * 
     * @return the value of field 'CINV07SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00 getCINV07SOG00()
    {
        return this._CINV07SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00 getCINV07SOG00() 

    /**
     * Returns the value of field 'CINV07SOG01_ARRAY'.
     * 
     * @return the value of field 'CINV07SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01_ARRAY getCINV07SOG01_ARRAY()
    {
        return this._CINV07SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01_ARRAY getCINV07SOG01_ARRAY() 

    /**
     * Returns the value of field 'CINV07SOG02_ARRAY'.
     * 
     * @return the value of field 'CINV07SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02_ARRAY getCINV07SOG02_ARRAY()
    {
        return this._CINV07SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02_ARRAY getCINV07SOG02_ARRAY() 

    /**
     * Returns the value of field 'dtDtIncomingCall'.
     * 
     * @return the value of field 'DtDtIncomingCall'.
     */
    public org.exolab.castor.types.Date getDtDtIncomingCall()
    {
        return this._dtDtIncomingCall;
    } //-- org.exolab.castor.types.Date getDtDtIncomingCall() 

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
     * Sets the value of field 'CINV07SOG00'.
     * 
     * @param CINV07SOG00 the value of field 'CINV07SOG00'.
     */
    public void setCINV07SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00 CINV07SOG00)
    {
        this._CINV07SOG00 = CINV07SOG00;
    } //-- void setCINV07SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00) 

    /**
     * Sets the value of field 'CINV07SOG01_ARRAY'.
     * 
     * @param CINV07SOG01_ARRAY the value of field
     * 'CINV07SOG01_ARRAY'.
     */
    public void setCINV07SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01_ARRAY CINV07SOG01_ARRAY)
    {
        this._CINV07SOG01_ARRAY = CINV07SOG01_ARRAY;
    } //-- void setCINV07SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01_ARRAY) 

    /**
     * Sets the value of field 'CINV07SOG02_ARRAY'.
     * 
     * @param CINV07SOG02_ARRAY the value of field
     * 'CINV07SOG02_ARRAY'.
     */
    public void setCINV07SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02_ARRAY CINV07SOG02_ARRAY)
    {
        this._CINV07SOG02_ARRAY = CINV07SOG02_ARRAY;
    } //-- void setCINV07SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02_ARRAY) 

    /**
     * Sets the value of field 'dtDtIncomingCall'.
     * 
     * @param dtDtIncomingCall the value of field 'dtDtIncomingCall'
     */
    public void setDtDtIncomingCall(org.exolab.castor.types.Date dtDtIncomingCall)
    {
        this._dtDtIncomingCall = dtDtIncomingCall;
    } //-- void setDtDtIncomingCall(org.exolab.castor.types.Date) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO unmarshal(java.io.Reader) 

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
