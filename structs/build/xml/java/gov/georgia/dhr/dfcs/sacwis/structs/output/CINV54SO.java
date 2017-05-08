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
 * Class CINV54SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV54SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV54SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00 _ROWCINV54SOG00;

    /**
     * Field _ROWCINV54SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY _ROWCINV54SOG01_ARRAY;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV54SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO()


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
     * Returns the value of field 'ROWCINV54SOG00'.
     * 
     * @return the value of field 'ROWCINV54SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00 getROWCINV54SOG00()
    {
        return this._ROWCINV54SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00 getROWCINV54SOG00() 

    /**
     * Returns the value of field 'ROWCINV54SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCINV54SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY getROWCINV54SOG01_ARRAY()
    {
        return this._ROWCINV54SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY getROWCINV54SOG01_ARRAY() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

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
     * Sets the value of field 'ROWCINV54SOG00'.
     * 
     * @param ROWCINV54SOG00 the value of field 'ROWCINV54SOG00'.
     */
    public void setROWCINV54SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00 ROWCINV54SOG00)
    {
        this._ROWCINV54SOG00 = ROWCINV54SOG00;
    } //-- void setROWCINV54SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00) 

    /**
     * Sets the value of field 'ROWCINV54SOG01_ARRAY'.
     * 
     * @param ROWCINV54SOG01_ARRAY the value of field
     * 'ROWCINV54SOG01_ARRAY'.
     */
    public void setROWCINV54SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY ROWCINV54SOG01_ARRAY)
    {
        this._ROWCINV54SOG01_ARRAY = ROWCINV54SOG01_ARRAY;
    } //-- void setROWCINV54SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO unmarshal(java.io.Reader) 

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
