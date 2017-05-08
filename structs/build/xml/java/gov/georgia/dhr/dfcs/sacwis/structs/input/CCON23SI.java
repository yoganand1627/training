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
 * Class CCON23SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON23SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtStageStart
     */
    private org.exolab.castor.types.Date _dtDtStageStart;

    /**
     * Field _isApprovalMode
     */
    private boolean _isApprovalMode;

    /**
     * keeps track of state for field: _isApprovalMode
     */
    private boolean _has_isApprovalMode;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdCntrctManager
     */
    private int _ulIdCntrctManager;

    /**
     * keeps track of state for field: _ulIdCntrctManager
     */
    private boolean _has_ulIdCntrctManager;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _cIndCntrctBudgLimit
     */
    private java.lang.String _cIndCntrctBudgLimit;

    /**
     * Field _ulNbrCnperPeriod
     */
    private int _ulNbrCnperPeriod;

    /**
     * keeps track of state for field: _ulNbrCnperPeriod
     */
    private boolean _has_ulNbrCnperPeriod;

    /**
     * Field _ulNbrCnverVersion
     */
    private int _ulNbrCnverVersion;

    /**
     * keeps track of state for field: _ulNbrCnverVersion
     */
    private boolean _has_ulNbrCnverVersion;

    /**
     * Field _szSysCdTodoCf
     */
    private java.lang.String _szSysCdTodoCf;

    /**
     * Field _ROWCCON23SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY _ROWCCON23SIG00_ARRAY;

    /**
     * Field _hdnSzCdSvcAuthDtlAuthType
     */
    private java.lang.String _hdnSzCdSvcAuthDtlAuthType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON23SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIsApprovalMode()
    {
        this._has_isApprovalMode= false;
    } //-- void deleteIsApprovalMode() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdCntrctManager()
    {
        this._has_ulIdCntrctManager= false;
    } //-- void deleteUlIdCntrctManager() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlNbrCnperPeriod()
    {
        this._has_ulNbrCnperPeriod= false;
    } //-- void deleteUlNbrCnperPeriod() 

    /**
     */
    public void deleteUlNbrCnverVersion()
    {
        this._has_ulNbrCnverVersion= false;
    } //-- void deleteUlNbrCnverVersion() 

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
     * Returns the value of field 'cIndCntrctBudgLimit'.
     * 
     * @return the value of field 'CIndCntrctBudgLimit'.
     */
    public java.lang.String getCIndCntrctBudgLimit()
    {
        return this._cIndCntrctBudgLimit;
    } //-- java.lang.String getCIndCntrctBudgLimit() 

    /**
     * Returns the value of field 'dtDtStageStart'.
     * 
     * @return the value of field 'DtDtStageStart'.
     */
    public org.exolab.castor.types.Date getDtDtStageStart()
    {
        return this._dtDtStageStart;
    } //-- org.exolab.castor.types.Date getDtDtStageStart() 

    /**
     * Returns the value of field 'hdnSzCdSvcAuthDtlAuthType'.
     * 
     * @return the value of field 'HdnSzCdSvcAuthDtlAuthType'.
     */
    public java.lang.String getHdnSzCdSvcAuthDtlAuthType()
    {
        return this._hdnSzCdSvcAuthDtlAuthType;
    } //-- java.lang.String getHdnSzCdSvcAuthDtlAuthType() 

    /**
     * Returns the value of field 'isApprovalMode'.
     * 
     * @return the value of field 'IsApprovalMode'.
     */
    public boolean getIsApprovalMode()
    {
        return this._isApprovalMode;
    } //-- boolean getIsApprovalMode() 

    /**
     * Returns the value of field 'ROWCCON23SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCON23SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY getROWCCON23SIG00_ARRAY()
    {
        return this._ROWCCON23SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY getROWCCON23SIG00_ARRAY() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szSysCdTodoCf'.
     * 
     * @return the value of field 'SzSysCdTodoCf'.
     */
    public java.lang.String getSzSysCdTodoCf()
    {
        return this._szSysCdTodoCf;
    } //-- java.lang.String getSzSysCdTodoCf() 

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
     * Returns the value of field 'ulIdCntrctManager'.
     * 
     * @return the value of field 'UlIdCntrctManager'.
     */
    public int getUlIdCntrctManager()
    {
        return this._ulIdCntrctManager;
    } //-- int getUlIdCntrctManager() 

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
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Returns the value of field 'ulNbrCnperPeriod'.
     * 
     * @return the value of field 'UlNbrCnperPeriod'.
     */
    public int getUlNbrCnperPeriod()
    {
        return this._ulNbrCnperPeriod;
    } //-- int getUlNbrCnperPeriod() 

    /**
     * Returns the value of field 'ulNbrCnverVersion'.
     * 
     * @return the value of field 'UlNbrCnverVersion'.
     */
    public int getUlNbrCnverVersion()
    {
        return this._ulNbrCnverVersion;
    } //-- int getUlNbrCnverVersion() 

    /**
     * Method hasIsApprovalMode
     * 
     * 
     * 
     * @return true if at least one IsApprovalMode has been added
     */
    public boolean hasIsApprovalMode()
    {
        return this._has_isApprovalMode;
    } //-- boolean hasIsApprovalMode() 

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
     * Method hasUlIdCntrctManager
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctManager has been added
     */
    public boolean hasUlIdCntrctManager()
    {
        return this._has_ulIdCntrctManager;
    } //-- boolean hasUlIdCntrctManager() 

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
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

    /**
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

    /**
     * Method hasUlNbrCnperPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCnperPeriod has been added
     */
    public boolean hasUlNbrCnperPeriod()
    {
        return this._has_ulNbrCnperPeriod;
    } //-- boolean hasUlNbrCnperPeriod() 

    /**
     * Method hasUlNbrCnverVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverVersion has been added
     */
    public boolean hasUlNbrCnverVersion()
    {
        return this._has_ulNbrCnverVersion;
    } //-- boolean hasUlNbrCnverVersion() 

    /**
     * Returns the value of field 'isApprovalMode'.
     * 
     * @return the value of field 'IsApprovalMode'.
     */
    public boolean isIsApprovalMode()
    {
        return this._isApprovalMode;
    } //-- boolean isIsApprovalMode() 

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
     * Sets the value of field 'cIndCntrctBudgLimit'.
     * 
     * @param cIndCntrctBudgLimit the value of field
     * 'cIndCntrctBudgLimit'.
     */
    public void setCIndCntrctBudgLimit(java.lang.String cIndCntrctBudgLimit)
    {
        this._cIndCntrctBudgLimit = cIndCntrctBudgLimit;
    } //-- void setCIndCntrctBudgLimit(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStageStart'.
     * 
     * @param dtDtStageStart the value of field 'dtDtStageStart'.
     */
    public void setDtDtStageStart(org.exolab.castor.types.Date dtDtStageStart)
    {
        this._dtDtStageStart = dtDtStageStart;
    } //-- void setDtDtStageStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'hdnSzCdSvcAuthDtlAuthType'.
     * 
     * @param hdnSzCdSvcAuthDtlAuthType the value of field
     * 'hdnSzCdSvcAuthDtlAuthType'.
     */
    public void setHdnSzCdSvcAuthDtlAuthType(java.lang.String hdnSzCdSvcAuthDtlAuthType)
    {
        this._hdnSzCdSvcAuthDtlAuthType = hdnSzCdSvcAuthDtlAuthType;
    } //-- void setHdnSzCdSvcAuthDtlAuthType(java.lang.String) 

    /**
     * Sets the value of field 'isApprovalMode'.
     * 
     * @param isApprovalMode the value of field 'isApprovalMode'.
     */
    public void setIsApprovalMode(boolean isApprovalMode)
    {
        this._isApprovalMode = isApprovalMode;
        this._has_isApprovalMode = true;
    } //-- void setIsApprovalMode(boolean) 

    /**
     * Sets the value of field 'ROWCCON23SIG00_ARRAY'.
     * 
     * @param ROWCCON23SIG00_ARRAY the value of field
     * 'ROWCCON23SIG00_ARRAY'.
     */
    public void setROWCCON23SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY ROWCCON23SIG00_ARRAY)
    {
        this._ROWCCON23SIG00_ARRAY = ROWCCON23SIG00_ARRAY;
    } //-- void setROWCCON23SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szSysCdTodoCf'.
     * 
     * @param szSysCdTodoCf the value of field 'szSysCdTodoCf'.
     */
    public void setSzSysCdTodoCf(java.lang.String szSysCdTodoCf)
    {
        this._szSysCdTodoCf = szSysCdTodoCf;
    } //-- void setSzSysCdTodoCf(java.lang.String) 

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
     * Sets the value of field 'ulIdCntrctManager'.
     * 
     * @param ulIdCntrctManager the value of field
     * 'ulIdCntrctManager'.
     */
    public void setUlIdCntrctManager(int ulIdCntrctManager)
    {
        this._ulIdCntrctManager = ulIdCntrctManager;
        this._has_ulIdCntrctManager = true;
    } //-- void setUlIdCntrctManager(int) 

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
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

    /**
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

    /**
     * Sets the value of field 'ulNbrCnperPeriod'.
     * 
     * @param ulNbrCnperPeriod the value of field 'ulNbrCnperPeriod'
     */
    public void setUlNbrCnperPeriod(int ulNbrCnperPeriod)
    {
        this._ulNbrCnperPeriod = ulNbrCnperPeriod;
        this._has_ulNbrCnperPeriod = true;
    } //-- void setUlNbrCnperPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCnverVersion'.
     * 
     * @param ulNbrCnverVersion the value of field
     * 'ulNbrCnverVersion'.
     */
    public void setUlNbrCnverVersion(int ulNbrCnverVersion)
    {
        this._ulNbrCnverVersion = ulNbrCnverVersion;
        this._has_ulNbrCnverVersion = true;
    } //-- void setUlNbrCnverVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI unmarshal(java.io.Reader) 

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
