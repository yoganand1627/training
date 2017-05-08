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
 * Class CINV36SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV36SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV36SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY _ROWCINV36SOG01_ARRAY;

    /**
     * Field _ROWCINV36SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY _ROWCINV36SOG02_ARRAY;

    /**
     * Field _CINV36SOG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04 _CINV36SOG04;

    /**
     * Field _CINV36SOG05
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG05 _CINV36SOG05;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _lSysNbrRow_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY _lSysNbrRow_ARRAY;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _cdCpsOverallDisptn
     */
    private java.lang.String _cdCpsOverallDisptn;

    /**
     * Field _bSysIndNoDataFound
     */
    private java.lang.String _bSysIndNoDataFound;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV36SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

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
     * Returns the value of field 'bSysIndNoDataFound'.
     * 
     * @return the value of field 'BSysIndNoDataFound'.
     */
    public java.lang.String getBSysIndNoDataFound()
    {
        return this._bSysIndNoDataFound;
    } //-- java.lang.String getBSysIndNoDataFound() 

    /**
     * Returns the value of field 'CINV36SOG04'.
     * 
     * @return the value of field 'CINV36SOG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04 getCINV36SOG04()
    {
        return this._CINV36SOG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04 getCINV36SOG04() 

    /**
     * Returns the value of field 'CINV36SOG05'.
     * 
     * @return the value of field 'CINV36SOG05'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG05 getCINV36SOG05()
    {
        return this._CINV36SOG05;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG05 getCINV36SOG05() 

    /**
     * Returns the value of field 'cdCpsOverallDisptn'.
     * 
     * @return the value of field 'CdCpsOverallDisptn'.
     */
    public java.lang.String getCdCpsOverallDisptn()
    {
        return this._cdCpsOverallDisptn;
    } //-- java.lang.String getCdCpsOverallDisptn() 

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
     * Returns the value of field 'lSysNbrRow_ARRAY'.
     * 
     * @return the value of field 'LSysNbrRow_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY getLSysNbrRow_ARRAY()
    {
        return this._lSysNbrRow_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY getLSysNbrRow_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCINV36SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCINV36SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY getROWCINV36SOG01_ARRAY()
    {
        return this._ROWCINV36SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY getROWCINV36SOG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV36SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCINV36SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY getROWCINV36SOG02_ARRAY()
    {
        return this._ROWCINV36SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY getROWCINV36SOG02_ARRAY() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'bSysIndNoDataFound'.
     * 
     * @param bSysIndNoDataFound the value of field
     * 'bSysIndNoDataFound'.
     */
    public void setBSysIndNoDataFound(java.lang.String bSysIndNoDataFound)
    {
        this._bSysIndNoDataFound = bSysIndNoDataFound;
    } //-- void setBSysIndNoDataFound(java.lang.String) 

    /**
     * Sets the value of field 'CINV36SOG04'.
     * 
     * @param CINV36SOG04 the value of field 'CINV36SOG04'.
     */
    public void setCINV36SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04 CINV36SOG04)
    {
        this._CINV36SOG04 = CINV36SOG04;
    } //-- void setCINV36SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04) 

    /**
     * Sets the value of field 'CINV36SOG05'.
     * 
     * @param CINV36SOG05 the value of field 'CINV36SOG05'.
     */
    public void setCINV36SOG05(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG05 CINV36SOG05)
    {
        this._CINV36SOG05 = CINV36SOG05;
    } //-- void setCINV36SOG05(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG05) 

    /**
     * Sets the value of field 'cdCpsOverallDisptn'.
     * 
     * @param cdCpsOverallDisptn the value of field
     * 'cdCpsOverallDisptn'.
     */
    public void setCdCpsOverallDisptn(java.lang.String cdCpsOverallDisptn)
    {
        this._cdCpsOverallDisptn = cdCpsOverallDisptn;
    } //-- void setCdCpsOverallDisptn(java.lang.String) 

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
     * Sets the value of field 'lSysNbrRow_ARRAY'.
     * 
     * @param lSysNbrRow_ARRAY the value of field 'lSysNbrRow_ARRAY'
     */
    public void setLSysNbrRow_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY lSysNbrRow_ARRAY)
    {
        this._lSysNbrRow_ARRAY = lSysNbrRow_ARRAY;
    } //-- void setLSysNbrRow_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCINV36SOG01_ARRAY'.
     * 
     * @param ROWCINV36SOG01_ARRAY the value of field
     * 'ROWCINV36SOG01_ARRAY'.
     */
    public void setROWCINV36SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY ROWCINV36SOG01_ARRAY)
    {
        this._ROWCINV36SOG01_ARRAY = ROWCINV36SOG01_ARRAY;
    } //-- void setROWCINV36SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV36SOG02_ARRAY'.
     * 
     * @param ROWCINV36SOG02_ARRAY the value of field
     * 'ROWCINV36SOG02_ARRAY'.
     */
    public void setROWCINV36SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY ROWCINV36SOG02_ARRAY)
    {
        this._ROWCINV36SOG02_ARRAY = ROWCINV36SOG02_ARRAY;
    } //-- void setROWCINV36SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO unmarshal(java.io.Reader) 

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
