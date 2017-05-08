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
 * Class CINV23SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV23SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtCaseOpened
     */
    private org.exolab.castor.types.Date _dtDtCaseOpened;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _ROWCINV23SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY _ROWCINV23SOG00_ARRAY;

    /**
     * Field _ROWCINV23SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY _ROWCINV23SOG01_ARRAY;

    /**
     * Field _szCdDocClass
     */
    private java.lang.String _szCdDocClass;

    /**
     * Field _szCdExtDocType
     */
    private java.lang.String _szCdExtDocType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV23SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO()


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
     * Returns the value of field 'dtDtCaseOpened'.
     * 
     * @return the value of field 'DtDtCaseOpened'.
     */
    public org.exolab.castor.types.Date getDtDtCaseOpened()
    {
        return this._dtDtCaseOpened;
    } //-- org.exolab.castor.types.Date getDtDtCaseOpened() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCINV23SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV23SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY getROWCINV23SOG00_ARRAY()
    {
        return this._ROWCINV23SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY getROWCINV23SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV23SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCINV23SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY getROWCINV23SOG01_ARRAY()
    {
        return this._ROWCINV23SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY getROWCINV23SOG01_ARRAY() 

    /**
     * Returns the value of field 'szCdDocClass'.
     * 
     * @return the value of field 'SzCdDocClass'.
     */
    public java.lang.String getSzCdDocClass()
    {
        return this._szCdDocClass;
    } //-- java.lang.String getSzCdDocClass() 

    /**
     * Returns the value of field 'szCdExtDocType'.
     * 
     * @return the value of field 'SzCdExtDocType'.
     */
    public java.lang.String getSzCdExtDocType()
    {
        return this._szCdExtDocType;
    } //-- java.lang.String getSzCdExtDocType() 

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
     * Sets the value of field 'dtDtCaseOpened'.
     * 
     * @param dtDtCaseOpened the value of field 'dtDtCaseOpened'.
     */
    public void setDtDtCaseOpened(org.exolab.castor.types.Date dtDtCaseOpened)
    {
        this._dtDtCaseOpened = dtDtCaseOpened;
    } //-- void setDtDtCaseOpened(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCINV23SOG00_ARRAY'.
     * 
     * @param ROWCINV23SOG00_ARRAY the value of field
     * 'ROWCINV23SOG00_ARRAY'.
     */
    public void setROWCINV23SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY ROWCINV23SOG00_ARRAY)
    {
        this._ROWCINV23SOG00_ARRAY = ROWCINV23SOG00_ARRAY;
    } //-- void setROWCINV23SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV23SOG01_ARRAY'.
     * 
     * @param ROWCINV23SOG01_ARRAY the value of field
     * 'ROWCINV23SOG01_ARRAY'.
     */
    public void setROWCINV23SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY ROWCINV23SOG01_ARRAY)
    {
        this._ROWCINV23SOG01_ARRAY = ROWCINV23SOG01_ARRAY;
    } //-- void setROWCINV23SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY) 

    /**
     * Sets the value of field 'szCdDocClass'.
     * 
     * @param szCdDocClass the value of field 'szCdDocClass'.
     */
    public void setSzCdDocClass(java.lang.String szCdDocClass)
    {
        this._szCdDocClass = szCdDocClass;
    } //-- void setSzCdDocClass(java.lang.String) 

    /**
     * Sets the value of field 'szCdExtDocType'.
     * 
     * @param szCdExtDocType the value of field 'szCdExtDocType'.
     */
    public void setSzCdExtDocType(java.lang.String szCdExtDocType)
    {
        this._szCdExtDocType = szCdExtDocType;
    } //-- void setSzCdExtDocType(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO unmarshal(java.io.Reader) 

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
