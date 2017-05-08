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
 * Class CINV14SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV14SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV10DOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 _ROWCINV10DOG00;

    /**
     * Field _ROWCINV10DOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 _ROWCINV10DOG01;

    /**
     * Field _ROWCCMN45DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO _ROWCCMN45DO;

    /**
     * Field _ROWCINV14DOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 _ROWCINV14DOG00;

    /**
     * Field _ROWCINV14SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00 _ROWCINV14SOG00;

    /**
     * Field _ROWCINV86DOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00 _ROWCINV86DOG00;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szScrTxtNarrStatus
     */
    private java.lang.String _szScrTxtNarrStatus;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _bIndPrnUk
     */
    private java.lang.String _bIndPrnUk;

    /**
     * Field _bIndPhabSxabAllegExist
     */
    private java.lang.String _bIndPhabSxabAllegExist;

    /**
     * Field _bIndSubstantiatedAlleg
     */
    private java.lang.String _bIndSubstantiatedAlleg;

    /**
     * Field _bIndBLOBExistsInDatabase
     */
    private java.lang.String _bIndBLOBExistsInDatabase;

    /**
     * Field _cIndCaseMergePending
     */
    private java.lang.String _cIndCaseMergePending;

    /**
     * Field _ulIdPersonSupervisor
     */
    private int _ulIdPersonSupervisor;

    /**
     * keeps track of state for field: _ulIdPersonSupervisor
     */
    private boolean _has_ulIdPersonSupervisor;

    /**
     * Field _bIndActiveEvent
     */
    private java.lang.String _bIndActiveEvent;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV14SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPersonSupervisor()
    {
        this._has_ulIdPersonSupervisor= false;
    } //-- void deleteUlIdPersonSupervisor() 

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
     * Returns the value of field 'bIndActiveEvent'.
     * 
     * @return the value of field 'BIndActiveEvent'.
     */
    public java.lang.String getBIndActiveEvent()
    {
        return this._bIndActiveEvent;
    } //-- java.lang.String getBIndActiveEvent() 

    /**
     * Returns the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase'.
     */
    public java.lang.String getBIndBLOBExistsInDatabase()
    {
        return this._bIndBLOBExistsInDatabase;
    } //-- java.lang.String getBIndBLOBExistsInDatabase() 

    /**
     * Returns the value of field 'bIndPhabSxabAllegExist'.
     * 
     * @return the value of field 'BIndPhabSxabAllegExist'.
     */
    public java.lang.String getBIndPhabSxabAllegExist()
    {
        return this._bIndPhabSxabAllegExist;
    } //-- java.lang.String getBIndPhabSxabAllegExist() 

    /**
     * Returns the value of field 'bIndPrnUk'.
     * 
     * @return the value of field 'BIndPrnUk'.
     */
    public java.lang.String getBIndPrnUk()
    {
        return this._bIndPrnUk;
    } //-- java.lang.String getBIndPrnUk() 

    /**
     * Returns the value of field 'bIndSubstantiatedAlleg'.
     * 
     * @return the value of field 'BIndSubstantiatedAlleg'.
     */
    public java.lang.String getBIndSubstantiatedAlleg()
    {
        return this._bIndSubstantiatedAlleg;
    } //-- java.lang.String getBIndSubstantiatedAlleg() 

    /**
     * Returns the value of field 'cIndCaseMergePending'.
     * 
     * @return the value of field 'CIndCaseMergePending'.
     */
    public java.lang.String getCIndCaseMergePending()
    {
        return this._cIndCaseMergePending;
    } //-- java.lang.String getCIndCaseMergePending() 

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
     * Returns the value of field 'ROWCCMN45DO'.
     * 
     * @return the value of field 'ROWCCMN45DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO()
    {
        return this._ROWCCMN45DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO() 

    /**
     * Returns the value of field 'ROWCINV10DOG00'.
     * 
     * @return the value of field 'ROWCINV10DOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 getROWCINV10DOG00()
    {
        return this._ROWCINV10DOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 getROWCINV10DOG00() 

    /**
     * Returns the value of field 'ROWCINV10DOG01'.
     * 
     * @return the value of field 'ROWCINV10DOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 getROWCINV10DOG01()
    {
        return this._ROWCINV10DOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 getROWCINV10DOG01() 

    /**
     * Returns the value of field 'ROWCINV14DOG00'.
     * 
     * @return the value of field 'ROWCINV14DOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 getROWCINV14DOG00()
    {
        return this._ROWCINV14DOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 getROWCINV14DOG00() 

    /**
     * Returns the value of field 'ROWCINV14SOG00'.
     * 
     * @return the value of field 'ROWCINV14SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00 getROWCINV14SOG00()
    {
        return this._ROWCINV14SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00 getROWCINV14SOG00() 

    /**
     * Returns the value of field 'ROWCINV86DOG00'.
     * 
     * @return the value of field 'ROWCINV86DOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00 getROWCINV86DOG00()
    {
        return this._ROWCINV86DOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00 getROWCINV86DOG00() 

    /**
     * Returns the value of field 'szScrTxtNarrStatus'.
     * 
     * @return the value of field 'SzScrTxtNarrStatus'.
     */
    public java.lang.String getSzScrTxtNarrStatus()
    {
        return this._szScrTxtNarrStatus;
    } //-- java.lang.String getSzScrTxtNarrStatus() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdPersonSupervisor'.
     * 
     * @return the value of field 'UlIdPersonSupervisor'.
     */
    public int getUlIdPersonSupervisor()
    {
        return this._ulIdPersonSupervisor;
    } //-- int getUlIdPersonSupervisor() 

    /**
     * Method hasUlIdPersonSupervisor
     * 
     * 
     * 
     * @return true if at least one UlIdPersonSupervisor has been
     * added
     */
    public boolean hasUlIdPersonSupervisor()
    {
        return this._has_ulIdPersonSupervisor;
    } //-- boolean hasUlIdPersonSupervisor() 

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
     * Sets the value of field 'bIndActiveEvent'.
     * 
     * @param bIndActiveEvent the value of field 'bIndActiveEvent'.
     */
    public void setBIndActiveEvent(java.lang.String bIndActiveEvent)
    {
        this._bIndActiveEvent = bIndActiveEvent;
    } //-- void setBIndActiveEvent(java.lang.String) 

    /**
     * Sets the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @param bIndBLOBExistsInDatabase the value of field
     * 'bIndBLOBExistsInDatabase'.
     */
    public void setBIndBLOBExistsInDatabase(java.lang.String bIndBLOBExistsInDatabase)
    {
        this._bIndBLOBExistsInDatabase = bIndBLOBExistsInDatabase;
    } //-- void setBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * Sets the value of field 'bIndPhabSxabAllegExist'.
     * 
     * @param bIndPhabSxabAllegExist the value of field
     * 'bIndPhabSxabAllegExist'.
     */
    public void setBIndPhabSxabAllegExist(java.lang.String bIndPhabSxabAllegExist)
    {
        this._bIndPhabSxabAllegExist = bIndPhabSxabAllegExist;
    } //-- void setBIndPhabSxabAllegExist(java.lang.String) 

    /**
     * Sets the value of field 'bIndPrnUk'.
     * 
     * @param bIndPrnUk the value of field 'bIndPrnUk'.
     */
    public void setBIndPrnUk(java.lang.String bIndPrnUk)
    {
        this._bIndPrnUk = bIndPrnUk;
    } //-- void setBIndPrnUk(java.lang.String) 

    /**
     * Sets the value of field 'bIndSubstantiatedAlleg'.
     * 
     * @param bIndSubstantiatedAlleg the value of field
     * 'bIndSubstantiatedAlleg'.
     */
    public void setBIndSubstantiatedAlleg(java.lang.String bIndSubstantiatedAlleg)
    {
        this._bIndSubstantiatedAlleg = bIndSubstantiatedAlleg;
    } //-- void setBIndSubstantiatedAlleg(java.lang.String) 

    /**
     * Sets the value of field 'cIndCaseMergePending'.
     * 
     * @param cIndCaseMergePending the value of field
     * 'cIndCaseMergePending'.
     */
    public void setCIndCaseMergePending(java.lang.String cIndCaseMergePending)
    {
        this._cIndCaseMergePending = cIndCaseMergePending;
    } //-- void setCIndCaseMergePending(java.lang.String) 

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
     * Sets the value of field 'ROWCCMN45DO'.
     * 
     * @param ROWCCMN45DO the value of field 'ROWCCMN45DO'.
     */
    public void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO ROWCCMN45DO)
    {
        this._ROWCCMN45DO = ROWCCMN45DO;
    } //-- void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO) 

    /**
     * Sets the value of field 'ROWCINV10DOG00'.
     * 
     * @param ROWCINV10DOG00 the value of field 'ROWCINV10DOG00'.
     */
    public void setROWCINV10DOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 ROWCINV10DOG00)
    {
        this._ROWCINV10DOG00 = ROWCINV10DOG00;
    } //-- void setROWCINV10DOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00) 

    /**
     * Sets the value of field 'ROWCINV10DOG01'.
     * 
     * @param ROWCINV10DOG01 the value of field 'ROWCINV10DOG01'.
     */
    public void setROWCINV10DOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 ROWCINV10DOG01)
    {
        this._ROWCINV10DOG01 = ROWCINV10DOG01;
    } //-- void setROWCINV10DOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01) 

    /**
     * Sets the value of field 'ROWCINV14DOG00'.
     * 
     * @param ROWCINV14DOG00 the value of field 'ROWCINV14DOG00'.
     */
    public void setROWCINV14DOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 ROWCINV14DOG00)
    {
        this._ROWCINV14DOG00 = ROWCINV14DOG00;
    } //-- void setROWCINV14DOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00) 

    /**
     * Sets the value of field 'ROWCINV14SOG00'.
     * 
     * @param ROWCINV14SOG00 the value of field 'ROWCINV14SOG00'.
     */
    public void setROWCINV14SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00 ROWCINV14SOG00)
    {
        this._ROWCINV14SOG00 = ROWCINV14SOG00;
    } //-- void setROWCINV14SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00) 

    /**
     * Sets the value of field 'ROWCINV86DOG00'.
     * 
     * @param ROWCINV86DOG00 the value of field 'ROWCINV86DOG00'.
     */
    public void setROWCINV86DOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00 ROWCINV86DOG00)
    {
        this._ROWCINV86DOG00 = ROWCINV86DOG00;
    } //-- void setROWCINV86DOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00) 

    /**
     * Sets the value of field 'szScrTxtNarrStatus'.
     * 
     * @param szScrTxtNarrStatus the value of field
     * 'szScrTxtNarrStatus'.
     */
    public void setSzScrTxtNarrStatus(java.lang.String szScrTxtNarrStatus)
    {
        this._szScrTxtNarrStatus = szScrTxtNarrStatus;
    } //-- void setSzScrTxtNarrStatus(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdPersonSupervisor'.
     * 
     * @param ulIdPersonSupervisor the value of field
     * 'ulIdPersonSupervisor'.
     */
    public void setUlIdPersonSupervisor(int ulIdPersonSupervisor)
    {
        this._ulIdPersonSupervisor = ulIdPersonSupervisor;
        this._has_ulIdPersonSupervisor = true;
    } //-- void setUlIdPersonSupervisor(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO unmarshal(java.io.Reader) 

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
