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
 * Class CCMN33SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN33SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN33SI_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY _ROWCCMN33SI_ARRAY;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdEventPerson
     */
    private int _ulIdEventPerson;

    /**
     * keeps track of state for field: _ulIdEventPerson
     */
    private boolean _has_ulIdEventPerson;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _dtScrDtStartDt
     */
    private org.exolab.castor.types.Date _dtScrDtStartDt;

    /**
     * Field _dtScrDtEventEnd
     */
    private org.exolab.castor.types.Date _dtScrDtEventEnd;

    /**
     * Field _bIndCaseSensitive
     */
    private java.lang.String _bIndCaseSensitive;

    /**
     * Field _bIndUserSensitive
     */
    private java.lang.String _bIndUserSensitive;

    /**
     * Field _bIndUserSealed
     */
    private java.lang.String _bIndUserSealed;

    /**
     * Field _bIndAdoptionAssitPB
     */
    private java.lang.String _bIndAdoptionAssitPB;

    /**
     * Field _bIndSrvAuthAdoptionAssitPB
     */
    private java.lang.String _bIndSrvAuthAdoptionAssitPB;

    /**
     * Field _szCdSvcAuthCategory
     */
    private java.lang.String _szCdSvcAuthCategory;

    /**
     * Field _szCdSvcAuthDtlSvc
     */
    private java.lang.String _szCdSvcAuthDtlSvc;

    /**
     * Field _ulIdStageForCNS
     */
    private int _ulIdStageForCNS;

    /**
     * keeps track of state for field: _ulIdStageForCNS
     */
    private boolean _has_ulIdStageForCNS;

    /**
     * Field _cIndCurrent
     */
    private java.lang.String _cIndCurrent;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN33SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI()


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
    public void deleteUlIdEventPerson()
    {
        this._has_ulIdEventPerson= false;
    } //-- void deleteUlIdEventPerson() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdStageForCNS()
    {
        this._has_ulIdStageForCNS= false;
    } //-- void deleteUlIdStageForCNS() 

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
     * Returns the value of field 'bIndAdoptionAssitPB'.
     * 
     * @return the value of field 'BIndAdoptionAssitPB'.
     */
    public java.lang.String getBIndAdoptionAssitPB()
    {
        return this._bIndAdoptionAssitPB;
    } //-- java.lang.String getBIndAdoptionAssitPB() 

    /**
     * Returns the value of field 'bIndCaseSensitive'.
     * 
     * @return the value of field 'BIndCaseSensitive'.
     */
    public java.lang.String getBIndCaseSensitive()
    {
        return this._bIndCaseSensitive;
    } //-- java.lang.String getBIndCaseSensitive() 

    /**
     * Returns the value of field 'bIndSrvAuthAdoptionAssitPB'.
     * 
     * @return the value of field 'BIndSrvAuthAdoptionAssitPB'.
     */
    public java.lang.String getBIndSrvAuthAdoptionAssitPB()
    {
        return this._bIndSrvAuthAdoptionAssitPB;
    } //-- java.lang.String getBIndSrvAuthAdoptionAssitPB() 

    /**
     * Returns the value of field 'bIndUserSealed'.
     * 
     * @return the value of field 'BIndUserSealed'.
     */
    public java.lang.String getBIndUserSealed()
    {
        return this._bIndUserSealed;
    } //-- java.lang.String getBIndUserSealed() 

    /**
     * Returns the value of field 'bIndUserSensitive'.
     * 
     * @return the value of field 'BIndUserSensitive'.
     */
    public java.lang.String getBIndUserSensitive()
    {
        return this._bIndUserSensitive;
    } //-- java.lang.String getBIndUserSensitive() 

    /**
     * Returns the value of field 'cIndCurrent'.
     * 
     * @return the value of field 'CIndCurrent'.
     */
    public java.lang.String getCIndCurrent()
    {
        return this._cIndCurrent;
    } //-- java.lang.String getCIndCurrent() 

    /**
     * Returns the value of field 'dtScrDtEventEnd'.
     * 
     * @return the value of field 'DtScrDtEventEnd'.
     */
    public org.exolab.castor.types.Date getDtScrDtEventEnd()
    {
        return this._dtScrDtEventEnd;
    } //-- org.exolab.castor.types.Date getDtScrDtEventEnd() 

    /**
     * Returns the value of field 'dtScrDtStartDt'.
     * 
     * @return the value of field 'DtScrDtStartDt'.
     */
    public org.exolab.castor.types.Date getDtScrDtStartDt()
    {
        return this._dtScrDtStartDt;
    } //-- org.exolab.castor.types.Date getDtScrDtStartDt() 

    /**
     * Returns the value of field 'ROWCCMN33SI_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN33SI_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY getROWCCMN33SI_ARRAY()
    {
        return this._ROWCCMN33SI_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY getROWCCMN33SI_ARRAY() 

    /**
     * Returns the value of field 'szCdSvcAuthCategory'.
     * 
     * @return the value of field 'SzCdSvcAuthCategory'.
     */
    public java.lang.String getSzCdSvcAuthCategory()
    {
        return this._szCdSvcAuthCategory;
    } //-- java.lang.String getSzCdSvcAuthCategory() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlSvc'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlSvc'.
     */
    public java.lang.String getSzCdSvcAuthDtlSvc()
    {
        return this._szCdSvcAuthDtlSvc;
    } //-- java.lang.String getSzCdSvcAuthDtlSvc() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

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
     * Returns the value of field 'ulIdEventPerson'.
     * 
     * @return the value of field 'UlIdEventPerson'.
     */
    public int getUlIdEventPerson()
    {
        return this._ulIdEventPerson;
    } //-- int getUlIdEventPerson() 

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
     * Returns the value of field 'ulIdSituation'.
     * 
     * @return the value of field 'UlIdSituation'.
     */
    public int getUlIdSituation()
    {
        return this._ulIdSituation;
    } //-- int getUlIdSituation() 

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
     * Returns the value of field 'ulIdStageForCNS'.
     * 
     * @return the value of field 'UlIdStageForCNS'.
     */
    public int getUlIdStageForCNS()
    {
        return this._ulIdStageForCNS;
    } //-- int getUlIdStageForCNS() 

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
     * Method hasUlIdEventPerson
     * 
     * 
     * 
     * @return true if at least one UlIdEventPerson has been added
     */
    public boolean hasUlIdEventPerson()
    {
        return this._has_ulIdEventPerson;
    } //-- boolean hasUlIdEventPerson() 

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
     * Method hasUlIdSituation
     * 
     * 
     * 
     * @return true if at least one UlIdSituation has been added
     */
    public boolean hasUlIdSituation()
    {
        return this._has_ulIdSituation;
    } //-- boolean hasUlIdSituation() 

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
     * Method hasUlIdStageForCNS
     * 
     * 
     * 
     * @return true if at least one UlIdStageForCNS has been added
     */
    public boolean hasUlIdStageForCNS()
    {
        return this._has_ulIdStageForCNS;
    } //-- boolean hasUlIdStageForCNS() 

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
     * Sets the value of field 'bIndAdoptionAssitPB'.
     * 
     * @param bIndAdoptionAssitPB the value of field
     * 'bIndAdoptionAssitPB'.
     */
    public void setBIndAdoptionAssitPB(java.lang.String bIndAdoptionAssitPB)
    {
        this._bIndAdoptionAssitPB = bIndAdoptionAssitPB;
    } //-- void setBIndAdoptionAssitPB(java.lang.String) 

    /**
     * Sets the value of field 'bIndCaseSensitive'.
     * 
     * @param bIndCaseSensitive the value of field
     * 'bIndCaseSensitive'.
     */
    public void setBIndCaseSensitive(java.lang.String bIndCaseSensitive)
    {
        this._bIndCaseSensitive = bIndCaseSensitive;
    } //-- void setBIndCaseSensitive(java.lang.String) 

    /**
     * Sets the value of field 'bIndSrvAuthAdoptionAssitPB'.
     * 
     * @param bIndSrvAuthAdoptionAssitPB the value of field
     * 'bIndSrvAuthAdoptionAssitPB'.
     */
    public void setBIndSrvAuthAdoptionAssitPB(java.lang.String bIndSrvAuthAdoptionAssitPB)
    {
        this._bIndSrvAuthAdoptionAssitPB = bIndSrvAuthAdoptionAssitPB;
    } //-- void setBIndSrvAuthAdoptionAssitPB(java.lang.String) 

    /**
     * Sets the value of field 'bIndUserSealed'.
     * 
     * @param bIndUserSealed the value of field 'bIndUserSealed'.
     */
    public void setBIndUserSealed(java.lang.String bIndUserSealed)
    {
        this._bIndUserSealed = bIndUserSealed;
    } //-- void setBIndUserSealed(java.lang.String) 

    /**
     * Sets the value of field 'bIndUserSensitive'.
     * 
     * @param bIndUserSensitive the value of field
     * 'bIndUserSensitive'.
     */
    public void setBIndUserSensitive(java.lang.String bIndUserSensitive)
    {
        this._bIndUserSensitive = bIndUserSensitive;
    } //-- void setBIndUserSensitive(java.lang.String) 

    /**
     * Sets the value of field 'cIndCurrent'.
     * 
     * @param cIndCurrent the value of field 'cIndCurrent'.
     */
    public void setCIndCurrent(java.lang.String cIndCurrent)
    {
        this._cIndCurrent = cIndCurrent;
    } //-- void setCIndCurrent(java.lang.String) 

    /**
     * Sets the value of field 'dtScrDtEventEnd'.
     * 
     * @param dtScrDtEventEnd the value of field 'dtScrDtEventEnd'.
     */
    public void setDtScrDtEventEnd(org.exolab.castor.types.Date dtScrDtEventEnd)
    {
        this._dtScrDtEventEnd = dtScrDtEventEnd;
    } //-- void setDtScrDtEventEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtScrDtStartDt'.
     * 
     * @param dtScrDtStartDt the value of field 'dtScrDtStartDt'.
     */
    public void setDtScrDtStartDt(org.exolab.castor.types.Date dtScrDtStartDt)
    {
        this._dtScrDtStartDt = dtScrDtStartDt;
    } //-- void setDtScrDtStartDt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN33SI_ARRAY'.
     * 
     * @param ROWCCMN33SI_ARRAY the value of field
     * 'ROWCCMN33SI_ARRAY'.
     */
    public void setROWCCMN33SI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY ROWCCMN33SI_ARRAY)
    {
        this._ROWCCMN33SI_ARRAY = ROWCCMN33SI_ARRAY;
    } //-- void setROWCCMN33SI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY) 

    /**
     * Sets the value of field 'szCdSvcAuthCategory'.
     * 
     * @param szCdSvcAuthCategory the value of field
     * 'szCdSvcAuthCategory'.
     */
    public void setSzCdSvcAuthCategory(java.lang.String szCdSvcAuthCategory)
    {
        this._szCdSvcAuthCategory = szCdSvcAuthCategory;
    } //-- void setSzCdSvcAuthCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlSvc'.
     * 
     * @param szCdSvcAuthDtlSvc the value of field
     * 'szCdSvcAuthDtlSvc'.
     */
    public void setSzCdSvcAuthDtlSvc(java.lang.String szCdSvcAuthDtlSvc)
    {
        this._szCdSvcAuthDtlSvc = szCdSvcAuthDtlSvc;
    } //-- void setSzCdSvcAuthDtlSvc(java.lang.String) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

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
     * Sets the value of field 'ulIdEventPerson'.
     * 
     * @param ulIdEventPerson the value of field 'ulIdEventPerson'.
     */
    public void setUlIdEventPerson(int ulIdEventPerson)
    {
        this._ulIdEventPerson = ulIdEventPerson;
        this._has_ulIdEventPerson = true;
    } //-- void setUlIdEventPerson(int) 

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
     * Sets the value of field 'ulIdSituation'.
     * 
     * @param ulIdSituation the value of field 'ulIdSituation'.
     */
    public void setUlIdSituation(int ulIdSituation)
    {
        this._ulIdSituation = ulIdSituation;
        this._has_ulIdSituation = true;
    } //-- void setUlIdSituation(int) 

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
     * Sets the value of field 'ulIdStageForCNS'.
     * 
     * @param ulIdStageForCNS the value of field 'ulIdStageForCNS'.
     */
    public void setUlIdStageForCNS(int ulIdStageForCNS)
    {
        this._ulIdStageForCNS = ulIdStageForCNS;
        this._has_ulIdStageForCNS = true;
    } //-- void setUlIdStageForCNS(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI unmarshal(java.io.Reader) 

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
