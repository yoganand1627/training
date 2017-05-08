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
 * Class ROWCCMN37DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN37DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bIndCaseSensitive
     */
    private java.lang.String _bIndCaseSensitive;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szCdStageCnty
     */
    private java.lang.String _szCdStageCnty;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageType
     */
    private java.lang.String _szCdStageType;

    /**
     * Field _dtDtStagePersLink
     */
    private org.exolab.castor.types.Date _dtDtStagePersLink;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szCdStageRegion
     */
    private java.lang.String _szCdStageRegion;

    /**
     * Field _szCdMobileStatus
     */
    private java.lang.String _szCdMobileStatus;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _bIndStagePersEmpNew
     */
    private java.lang.String _bIndStagePersEmpNew;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szNmCase
     */
    private java.lang.String _szNmCase;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _cIndWkldSuperintNotif
     */
    private java.lang.String _cIndWkldSuperintNotif;

    /**
     * Field _dtDtStageStart
     */
    private org.exolab.castor.types.Date _dtDtStageStart;

    /**
     * Field _szCdRecidivism
     */
    private java.lang.String _szCdRecidivism;

    /**
     * Field _szCdRiskLvl
     */
    private java.lang.String _szCdRiskLvl;

    /**
     * Field _szCdStageCurrPriority
     */
    private java.lang.String _szCdStageCurrPriority;

    /**
     * Field _nbrErrors
     */
    private int _nbrErrors;

    /**
     * keeps track of state for field: _nbrErrors
     */
    private boolean _has_nbrErrors;

    /**
     * Field _nbrWarnings
     */
    private int _nbrWarnings;

    /**
     * keeps track of state for field: _nbrWarnings
     */
    private boolean _has_nbrWarnings;

    /**
     * Field _szCdRsrcFaHomeStatus
     */
    private java.lang.String _szCdRsrcFaHomeStatus;

    /**
     * Field _bIndHomeIveReimbursable
     */
    private java.lang.String _bIndHomeIveReimbursable;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN37DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNbrErrors()
    {
        this._has_nbrErrors= false;
    } //-- void deleteNbrErrors() 

    /**
     */
    public void deleteNbrWarnings()
    {
        this._has_nbrWarnings= false;
    } //-- void deleteNbrWarnings() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'bIndHomeIveReimbursable'.
     * 
     * @return the value of field 'BIndHomeIveReimbursable'.
     */
    public java.lang.String getBIndHomeIveReimbursable()
    {
        return this._bIndHomeIveReimbursable;
    } //-- java.lang.String getBIndHomeIveReimbursable() 

    /**
     * Returns the value of field 'bIndStagePersEmpNew'.
     * 
     * @return the value of field 'BIndStagePersEmpNew'.
     */
    public java.lang.String getBIndStagePersEmpNew()
    {
        return this._bIndStagePersEmpNew;
    } //-- java.lang.String getBIndStagePersEmpNew() 

    /**
     * Returns the value of field 'cIndWkldSuperintNotif'.
     * 
     * @return the value of field 'CIndWkldSuperintNotif'.
     */
    public java.lang.String getCIndWkldSuperintNotif()
    {
        return this._cIndWkldSuperintNotif;
    } //-- java.lang.String getCIndWkldSuperintNotif() 

    /**
     * Returns the value of field 'dtDtStagePersLink'.
     * 
     * @return the value of field 'DtDtStagePersLink'.
     */
    public org.exolab.castor.types.Date getDtDtStagePersLink()
    {
        return this._dtDtStagePersLink;
    } //-- org.exolab.castor.types.Date getDtDtStagePersLink() 

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
     * Returns the value of field 'nbrErrors'.
     * 
     * @return the value of field 'NbrErrors'.
     */
    public int getNbrErrors()
    {
        return this._nbrErrors;
    } //-- int getNbrErrors() 

    /**
     * Returns the value of field 'nbrWarnings'.
     * 
     * @return the value of field 'NbrWarnings'.
     */
    public int getNbrWarnings()
    {
        return this._nbrWarnings;
    } //-- int getNbrWarnings() 

    /**
     * Returns the value of field 'szCdMobileStatus'.
     * 
     * @return the value of field 'SzCdMobileStatus'.
     */
    public java.lang.String getSzCdMobileStatus()
    {
        return this._szCdMobileStatus;
    } //-- java.lang.String getSzCdMobileStatus() 

    /**
     * Returns the value of field 'szCdRecidivism'.
     * 
     * @return the value of field 'SzCdRecidivism'.
     */
    public java.lang.String getSzCdRecidivism()
    {
        return this._szCdRecidivism;
    } //-- java.lang.String getSzCdRecidivism() 

    /**
     * Returns the value of field 'szCdRiskLvl'.
     * 
     * @return the value of field 'SzCdRiskLvl'.
     */
    public java.lang.String getSzCdRiskLvl()
    {
        return this._szCdRiskLvl;
    } //-- java.lang.String getSzCdRiskLvl() 

    /**
     * Returns the value of field 'szCdRsrcFaHomeStatus'.
     * 
     * @return the value of field 'SzCdRsrcFaHomeStatus'.
     */
    public java.lang.String getSzCdRsrcFaHomeStatus()
    {
        return this._szCdRsrcFaHomeStatus;
    } //-- java.lang.String getSzCdRsrcFaHomeStatus() 

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
     * Returns the value of field 'szCdStageCnty'.
     * 
     * @return the value of field 'SzCdStageCnty'.
     */
    public java.lang.String getSzCdStageCnty()
    {
        return this._szCdStageCnty;
    } //-- java.lang.String getSzCdStageCnty() 

    /**
     * Returns the value of field 'szCdStageCurrPriority'.
     * 
     * @return the value of field 'SzCdStageCurrPriority'.
     */
    public java.lang.String getSzCdStageCurrPriority()
    {
        return this._szCdStageCurrPriority;
    } //-- java.lang.String getSzCdStageCurrPriority() 

    /**
     * Returns the value of field 'szCdStagePersRole'.
     * 
     * @return the value of field 'SzCdStagePersRole'.
     */
    public java.lang.String getSzCdStagePersRole()
    {
        return this._szCdStagePersRole;
    } //-- java.lang.String getSzCdStagePersRole() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

    /**
     * Returns the value of field 'szCdStageReasonClosed'.
     * 
     * @return the value of field 'SzCdStageReasonClosed'.
     */
    public java.lang.String getSzCdStageReasonClosed()
    {
        return this._szCdStageReasonClosed;
    } //-- java.lang.String getSzCdStageReasonClosed() 

    /**
     * Returns the value of field 'szCdStageRegion'.
     * 
     * @return the value of field 'SzCdStageRegion'.
     */
    public java.lang.String getSzCdStageRegion()
    {
        return this._szCdStageRegion;
    } //-- java.lang.String getSzCdStageRegion() 

    /**
     * Returns the value of field 'szCdStageType'.
     * 
     * @return the value of field 'SzCdStageType'.
     */
    public java.lang.String getSzCdStageType()
    {
        return this._szCdStageType;
    } //-- java.lang.String getSzCdStageType() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

    /**
     * Returns the value of field 'szNmCase'.
     * 
     * @return the value of field 'SzNmCase'.
     */
    public java.lang.String getSzNmCase()
    {
        return this._szNmCase;
    } //-- java.lang.String getSzNmCase() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

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
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

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
     * Method hasNbrErrors
     * 
     * 
     * 
     * @return true if at least one NbrErrors has been added
     */
    public boolean hasNbrErrors()
    {
        return this._has_nbrErrors;
    } //-- boolean hasNbrErrors() 

    /**
     * Method hasNbrWarnings
     * 
     * 
     * 
     * @return true if at least one NbrWarnings has been added
     */
    public boolean hasNbrWarnings()
    {
        return this._has_nbrWarnings;
    } //-- boolean hasNbrWarnings() 

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
     * Sets the value of field 'bIndHomeIveReimbursable'.
     * 
     * @param bIndHomeIveReimbursable the value of field
     * 'bIndHomeIveReimbursable'.
     */
    public void setBIndHomeIveReimbursable(java.lang.String bIndHomeIveReimbursable)
    {
        this._bIndHomeIveReimbursable = bIndHomeIveReimbursable;
    } //-- void setBIndHomeIveReimbursable(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersEmpNew'.
     * 
     * @param bIndStagePersEmpNew the value of field
     * 'bIndStagePersEmpNew'.
     */
    public void setBIndStagePersEmpNew(java.lang.String bIndStagePersEmpNew)
    {
        this._bIndStagePersEmpNew = bIndStagePersEmpNew;
    } //-- void setBIndStagePersEmpNew(java.lang.String) 

    /**
     * Sets the value of field 'cIndWkldSuperintNotif'.
     * 
     * @param cIndWkldSuperintNotif the value of field
     * 'cIndWkldSuperintNotif'.
     */
    public void setCIndWkldSuperintNotif(java.lang.String cIndWkldSuperintNotif)
    {
        this._cIndWkldSuperintNotif = cIndWkldSuperintNotif;
    } //-- void setCIndWkldSuperintNotif(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStagePersLink'.
     * 
     * @param dtDtStagePersLink the value of field
     * 'dtDtStagePersLink'.
     */
    public void setDtDtStagePersLink(org.exolab.castor.types.Date dtDtStagePersLink)
    {
        this._dtDtStagePersLink = dtDtStagePersLink;
    } //-- void setDtDtStagePersLink(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'nbrErrors'.
     * 
     * @param nbrErrors the value of field 'nbrErrors'.
     */
    public void setNbrErrors(int nbrErrors)
    {
        this._nbrErrors = nbrErrors;
        this._has_nbrErrors = true;
    } //-- void setNbrErrors(int) 

    /**
     * Sets the value of field 'nbrWarnings'.
     * 
     * @param nbrWarnings the value of field 'nbrWarnings'.
     */
    public void setNbrWarnings(int nbrWarnings)
    {
        this._nbrWarnings = nbrWarnings;
        this._has_nbrWarnings = true;
    } //-- void setNbrWarnings(int) 

    /**
     * Sets the value of field 'szCdMobileStatus'.
     * 
     * @param szCdMobileStatus the value of field 'szCdMobileStatus'
     */
    public void setSzCdMobileStatus(java.lang.String szCdMobileStatus)
    {
        this._szCdMobileStatus = szCdMobileStatus;
    } //-- void setSzCdMobileStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRecidivism'.
     * 
     * @param szCdRecidivism the value of field 'szCdRecidivism'.
     */
    public void setSzCdRecidivism(java.lang.String szCdRecidivism)
    {
        this._szCdRecidivism = szCdRecidivism;
    } //-- void setSzCdRecidivism(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskLvl'.
     * 
     * @param szCdRiskLvl the value of field 'szCdRiskLvl'.
     */
    public void setSzCdRiskLvl(java.lang.String szCdRiskLvl)
    {
        this._szCdRiskLvl = szCdRiskLvl;
    } //-- void setSzCdRiskLvl(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFaHomeStatus'.
     * 
     * @param szCdRsrcFaHomeStatus the value of field
     * 'szCdRsrcFaHomeStatus'.
     */
    public void setSzCdRsrcFaHomeStatus(java.lang.String szCdRsrcFaHomeStatus)
    {
        this._szCdRsrcFaHomeStatus = szCdRsrcFaHomeStatus;
    } //-- void setSzCdRsrcFaHomeStatus(java.lang.String) 

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
     * Sets the value of field 'szCdStageCnty'.
     * 
     * @param szCdStageCnty the value of field 'szCdStageCnty'.
     */
    public void setSzCdStageCnty(java.lang.String szCdStageCnty)
    {
        this._szCdStageCnty = szCdStageCnty;
    } //-- void setSzCdStageCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCurrPriority'.
     * 
     * @param szCdStageCurrPriority the value of field
     * 'szCdStageCurrPriority'.
     */
    public void setSzCdStageCurrPriority(java.lang.String szCdStageCurrPriority)
    {
        this._szCdStageCurrPriority = szCdStageCurrPriority;
    } //-- void setSzCdStageCurrPriority(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole'.
     * 
     * @param szCdStagePersRole the value of field
     * 'szCdStagePersRole'.
     */
    public void setSzCdStagePersRole(java.lang.String szCdStagePersRole)
    {
        this._szCdStagePersRole = szCdStagePersRole;
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageReasonClosed'.
     * 
     * @param szCdStageReasonClosed the value of field
     * 'szCdStageReasonClosed'.
     */
    public void setSzCdStageReasonClosed(java.lang.String szCdStageReasonClosed)
    {
        this._szCdStageReasonClosed = szCdStageReasonClosed;
    } //-- void setSzCdStageReasonClosed(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRegion'.
     * 
     * @param szCdStageRegion the value of field 'szCdStageRegion'.
     */
    public void setSzCdStageRegion(java.lang.String szCdStageRegion)
    {
        this._szCdStageRegion = szCdStageRegion;
    } //-- void setSzCdStageRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageType'.
     * 
     * @param szCdStageType the value of field 'szCdStageType'.
     */
    public void setSzCdStageType(java.lang.String szCdStageType)
    {
        this._szCdStageType = szCdStageType;
    } //-- void setSzCdStageType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

    /**
     * Sets the value of field 'szNmCase'.
     * 
     * @param szNmCase the value of field 'szNmCase'.
     */
    public void setSzNmCase(java.lang.String szNmCase)
    {
        this._szNmCase = szNmCase;
    } //-- void setSzNmCase(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO unmarshal(java.io.Reader) 

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
