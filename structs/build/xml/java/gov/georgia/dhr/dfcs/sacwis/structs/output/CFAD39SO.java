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
 * Class CFAD39SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD39SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _CFAD39SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00 _CFAD39SOG00;

    /**
     * Field _CFAD39SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01 _CFAD39SOG01;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _szCdEmpSkill
     */
    private java.lang.String _szCdEmpSkill;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _cSysIndContractCurrent
     */
    private java.lang.String _cSysIndContractCurrent;

    /**
     * Field _cSysIndServiceAuthCurrent
     */
    private java.lang.String _cSysIndServiceAuthCurrent;

    /**
     * Field _szCdLegalStatStatus
     */
    private java.lang.String _szCdLegalStatStatus;

    /**
     * Field _ulIdPlcmtEvent
     */
    private int _ulIdPlcmtEvent;

    /**
     * keeps track of state for field: _ulIdPlcmtEvent
     */
    private boolean _has_ulIdPlcmtEvent;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _dtDtCnperStart
     */
    private org.exolab.castor.types.Date _dtDtCnperStart;

    /**
     * Field _dtDtCnperTerm
     */
    private org.exolab.castor.types.Date _dtDtCnperTerm;

    /**
     * Field _bIndBLOBExistsInDatabase
     */
    private java.lang.String _bIndBLOBExistsInDatabase;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _bIndStageOpen
     */
    private java.lang.String _bIndStageOpen;

    /**
     * Field _bIndHasIntakeStage
     */
    private java.lang.String _bIndHasIntakeStage;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD39SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPlcmtEvent()
    {
        this._has_ulIdPlcmtEvent= false;
    } //-- void deleteUlIdPlcmtEvent() 

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
     * Returns the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase'.
     */
    public java.lang.String getBIndBLOBExistsInDatabase()
    {
        return this._bIndBLOBExistsInDatabase;
    } //-- java.lang.String getBIndBLOBExistsInDatabase() 

    /**
     * Returns the value of field 'bIndHasIntakeStage'.
     * 
     * @return the value of field 'BIndHasIntakeStage'.
     */
    public java.lang.String getBIndHasIntakeStage()
    {
        return this._bIndHasIntakeStage;
    } //-- java.lang.String getBIndHasIntakeStage() 

    /**
     * Returns the value of field 'bIndStageOpen'.
     * 
     * @return the value of field 'BIndStageOpen'.
     */
    public java.lang.String getBIndStageOpen()
    {
        return this._bIndStageOpen;
    } //-- java.lang.String getBIndStageOpen() 

    /**
     * Returns the value of field 'CFAD39SOG00'.
     * 
     * @return the value of field 'CFAD39SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00 getCFAD39SOG00()
    {
        return this._CFAD39SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00 getCFAD39SOG00() 

    /**
     * Returns the value of field 'CFAD39SOG01'.
     * 
     * @return the value of field 'CFAD39SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01 getCFAD39SOG01()
    {
        return this._CFAD39SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01 getCFAD39SOG01() 

    /**
     * Returns the value of field 'cSysIndContractCurrent'.
     * 
     * @return the value of field 'CSysIndContractCurrent'.
     */
    public java.lang.String getCSysIndContractCurrent()
    {
        return this._cSysIndContractCurrent;
    } //-- java.lang.String getCSysIndContractCurrent() 

    /**
     * Returns the value of field 'cSysIndServiceAuthCurrent'.
     * 
     * @return the value of field 'CSysIndServiceAuthCurrent'.
     */
    public java.lang.String getCSysIndServiceAuthCurrent()
    {
        return this._cSysIndServiceAuthCurrent;
    } //-- java.lang.String getCSysIndServiceAuthCurrent() 

    /**
     * Returns the value of field 'dtDtCnperStart'.
     * 
     * @return the value of field 'DtDtCnperStart'.
     */
    public org.exolab.castor.types.Date getDtDtCnperStart()
    {
        return this._dtDtCnperStart;
    } //-- org.exolab.castor.types.Date getDtDtCnperStart() 

    /**
     * Returns the value of field 'dtDtCnperTerm'.
     * 
     * @return the value of field 'DtDtCnperTerm'.
     */
    public org.exolab.castor.types.Date getDtDtCnperTerm()
    {
        return this._dtDtCnperTerm;
    } //-- org.exolab.castor.types.Date getDtDtCnperTerm() 

    /**
     * Returns the value of field 'dtDtPersonBirth'.
     * 
     * @return the value of field 'DtDtPersonBirth'.
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth()
    {
        return this._dtDtPersonBirth;
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth() 

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
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'szCdEmpSkill'.
     * 
     * @return the value of field 'SzCdEmpSkill'.
     */
    public java.lang.String getSzCdEmpSkill()
    {
        return this._szCdEmpSkill;
    } //-- java.lang.String getSzCdEmpSkill() 

    /**
     * Returns the value of field 'szCdLegalStatStatus'.
     * 
     * @return the value of field 'SzCdLegalStatStatus'.
     */
    public java.lang.String getSzCdLegalStatStatus()
    {
        return this._szCdLegalStatStatus;
    } //-- java.lang.String getSzCdLegalStatStatus() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdPlcmtEvent'.
     * 
     * @return the value of field 'UlIdPlcmtEvent'.
     */
    public int getUlIdPlcmtEvent()
    {
        return this._ulIdPlcmtEvent;
    } //-- int getUlIdPlcmtEvent() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Method hasUlIdPlcmtEvent
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtEvent has been added
     */
    public boolean hasUlIdPlcmtEvent()
    {
        return this._has_ulIdPlcmtEvent;
    } //-- boolean hasUlIdPlcmtEvent() 

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
     * Sets the value of field 'bIndHasIntakeStage'.
     * 
     * @param bIndHasIntakeStage the value of field
     * 'bIndHasIntakeStage'.
     */
    public void setBIndHasIntakeStage(java.lang.String bIndHasIntakeStage)
    {
        this._bIndHasIntakeStage = bIndHasIntakeStage;
    } //-- void setBIndHasIntakeStage(java.lang.String) 

    /**
     * Sets the value of field 'bIndStageOpen'.
     * 
     * @param bIndStageOpen the value of field 'bIndStageOpen'.
     */
    public void setBIndStageOpen(java.lang.String bIndStageOpen)
    {
        this._bIndStageOpen = bIndStageOpen;
    } //-- void setBIndStageOpen(java.lang.String) 

    /**
     * Sets the value of field 'CFAD39SOG00'.
     * 
     * @param CFAD39SOG00 the value of field 'CFAD39SOG00'.
     */
    public void setCFAD39SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00 CFAD39SOG00)
    {
        this._CFAD39SOG00 = CFAD39SOG00;
    } //-- void setCFAD39SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00) 

    /**
     * Sets the value of field 'CFAD39SOG01'.
     * 
     * @param CFAD39SOG01 the value of field 'CFAD39SOG01'.
     */
    public void setCFAD39SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01 CFAD39SOG01)
    {
        this._CFAD39SOG01 = CFAD39SOG01;
    } //-- void setCFAD39SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01) 

    /**
     * Sets the value of field 'cSysIndContractCurrent'.
     * 
     * @param cSysIndContractCurrent the value of field
     * 'cSysIndContractCurrent'.
     */
    public void setCSysIndContractCurrent(java.lang.String cSysIndContractCurrent)
    {
        this._cSysIndContractCurrent = cSysIndContractCurrent;
    } //-- void setCSysIndContractCurrent(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndServiceAuthCurrent'.
     * 
     * @param cSysIndServiceAuthCurrent the value of field
     * 'cSysIndServiceAuthCurrent'.
     */
    public void setCSysIndServiceAuthCurrent(java.lang.String cSysIndServiceAuthCurrent)
    {
        this._cSysIndServiceAuthCurrent = cSysIndServiceAuthCurrent;
    } //-- void setCSysIndServiceAuthCurrent(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCnperStart'.
     * 
     * @param dtDtCnperStart the value of field 'dtDtCnperStart'.
     */
    public void setDtDtCnperStart(org.exolab.castor.types.Date dtDtCnperStart)
    {
        this._dtDtCnperStart = dtDtCnperStart;
    } //-- void setDtDtCnperStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCnperTerm'.
     * 
     * @param dtDtCnperTerm the value of field 'dtDtCnperTerm'.
     */
    public void setDtDtCnperTerm(org.exolab.castor.types.Date dtDtCnperTerm)
    {
        this._dtDtCnperTerm = dtDtCnperTerm;
    } //-- void setDtDtCnperTerm(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersonBirth'.
     * 
     * @param dtDtPersonBirth the value of field 'dtDtPersonBirth'.
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date dtDtPersonBirth)
    {
        this._dtDtPersonBirth = dtDtPersonBirth;
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'szCdEmpSkill'.
     * 
     * @param szCdEmpSkill the value of field 'szCdEmpSkill'.
     */
    public void setSzCdEmpSkill(java.lang.String szCdEmpSkill)
    {
        this._szCdEmpSkill = szCdEmpSkill;
    } //-- void setSzCdEmpSkill(java.lang.String) 

    /**
     * Sets the value of field 'szCdLegalStatStatus'.
     * 
     * @param szCdLegalStatStatus the value of field
     * 'szCdLegalStatStatus'.
     */
    public void setSzCdLegalStatStatus(java.lang.String szCdLegalStatStatus)
    {
        this._szCdLegalStatStatus = szCdLegalStatStatus;
    } //-- void setSzCdLegalStatStatus(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of field 'ulIdPlcmtEvent'.
     * 
     * @param ulIdPlcmtEvent the value of field 'ulIdPlcmtEvent'.
     */
    public void setUlIdPlcmtEvent(int ulIdPlcmtEvent)
    {
        this._ulIdPlcmtEvent = ulIdPlcmtEvent;
        this._has_ulIdPlcmtEvent = true;
    } //-- void setUlIdPlcmtEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO unmarshal(java.io.Reader) 

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
