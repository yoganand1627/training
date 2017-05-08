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
 * Class ROWCFAD07SOG04.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD07SOG04 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szNbrRshsVid
     */
    private java.lang.String _szNbrRshsVid;

    /**
     * Field _szCdRshsCategory
     */
    private java.lang.String _szCdRshsCategory;

    /**
     * Field _szCdRshsClosureRsn
     */
    private java.lang.String _szCdRshsClosureRsn;

    /**
     * Field _szCdRshsEthnicity
     */
    private java.lang.String _szCdRshsEthnicity;

    /**
     * Field _szCdRshsFaHomeStatus
     */
    private java.lang.String _szCdRshsFaHomeStatus;

    /**
     * Field _szCdRshsLanguage
     */
    private java.lang.String _szCdRshsLanguage;

    /**
     * Field _szCdRshsMaritalStatus
     */
    private java.lang.String _szCdRshsMaritalStatus;

    /**
     * Field _szCdRshsRegion
     */
    private java.lang.String _szCdRshsRegion;

    /**
     * Field _szCdRshsReligion
     */
    private java.lang.String _szCdRshsReligion;

    /**
     * Field _szCdRshsRespite
     */
    private java.lang.String _szCdRshsRespite;

    /**
     * Field _szCdRshsSourceInquiry
     */
    private java.lang.String _szCdRshsSourceInquiry;

    /**
     * Field _dtDtRshsMarriage
     */
    private org.exolab.castor.types.Date _dtDtRshsMarriage;

    /**
     * Field _cIndRshsCareProv
     */
    private java.lang.String _cIndRshsCareProv;

    /**
     * Field _dNbrRshsAnnualIncome
     */
    private int _dNbrRshsAnnualIncome;

    /**
     * keeps track of state for field: _dNbrRshsAnnualIncome
     */
    private boolean _has_dNbrRshsAnnualIncome;

    /**
     * Field _szNmLegal
     */
    private java.lang.String _szNmLegal;

    /**
     * Field _szNmRshsResource
     */
    private java.lang.String _szNmRshsResource;

    /**
     * Field _szCdRshsState
     */
    private java.lang.String _szCdRshsState;

    /**
     * Field _szCdRshsCnty
     */
    private java.lang.String _szCdRshsCnty;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szTxtNdfcsCertEntity
     */
    private java.lang.String _szTxtNdfcsCertEntity;

    /**
     * Field _szCdAdExchangeStatus
     */
    private java.lang.String _szCdAdExchangeStatus;

    /**
     * Field _szCdSchoolDistrict
     */
    private java.lang.String _szCdSchoolDistrict;

    /**
     * Field _szCdElementary
     */
    private java.lang.String _szCdElementary;

    /**
     * Field _szCdMiddle
     */
    private java.lang.String _szCdMiddle;

    /**
     * Field _szCdHigh
     */
    private java.lang.String _szCdHigh;

    /**
     * Field _cIndWaiver
     */
    private java.lang.String _cIndWaiver;

    /**
     * Field _cIndCurrHomeStudyExists
     */
    private java.lang.String _cIndCurrHomeStudyExists;

    /**
     * Field _cIndRshsNonDFCSHome
     */
    private java.lang.String _cIndRshsNonDFCSHome;

    /**
     * Field _cIndPrevFamilyStudyReq
     */
    private java.lang.String _cIndPrevFamilyStudyReq;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD07SOG04() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDNbrRshsAnnualIncome()
    {
        this._has_dNbrRshsAnnualIncome= false;
    } //-- void deleteDNbrRshsAnnualIncome() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     * Returns the value of field 'cIndCurrHomeStudyExists'.
     * 
     * @return the value of field 'CIndCurrHomeStudyExists'.
     */
    public java.lang.String getCIndCurrHomeStudyExists()
    {
        return this._cIndCurrHomeStudyExists;
    } //-- java.lang.String getCIndCurrHomeStudyExists() 

    /**
     * Returns the value of field 'cIndPrevFamilyStudyReq'.
     * 
     * @return the value of field 'CIndPrevFamilyStudyReq'.
     */
    public java.lang.String getCIndPrevFamilyStudyReq()
    {
        return this._cIndPrevFamilyStudyReq;
    } //-- java.lang.String getCIndPrevFamilyStudyReq() 

    /**
     * Returns the value of field 'cIndRshsCareProv'.
     * 
     * @return the value of field 'CIndRshsCareProv'.
     */
    public java.lang.String getCIndRshsCareProv()
    {
        return this._cIndRshsCareProv;
    } //-- java.lang.String getCIndRshsCareProv() 

    /**
     * Returns the value of field 'cIndRshsNonDFCSHome'.
     * 
     * @return the value of field 'CIndRshsNonDFCSHome'.
     */
    public java.lang.String getCIndRshsNonDFCSHome()
    {
        return this._cIndRshsNonDFCSHome;
    } //-- java.lang.String getCIndRshsNonDFCSHome() 

    /**
     * Returns the value of field 'cIndWaiver'.
     * 
     * @return the value of field 'CIndWaiver'.
     */
    public java.lang.String getCIndWaiver()
    {
        return this._cIndWaiver;
    } //-- java.lang.String getCIndWaiver() 

    /**
     * Returns the value of field 'dNbrRshsAnnualIncome'.
     * 
     * @return the value of field 'DNbrRshsAnnualIncome'.
     */
    public int getDNbrRshsAnnualIncome()
    {
        return this._dNbrRshsAnnualIncome;
    } //-- int getDNbrRshsAnnualIncome() 

    /**
     * Returns the value of field 'dtDtRshsMarriage'.
     * 
     * @return the value of field 'DtDtRshsMarriage'.
     */
    public org.exolab.castor.types.Date getDtDtRshsMarriage()
    {
        return this._dtDtRshsMarriage;
    } //-- org.exolab.castor.types.Date getDtDtRshsMarriage() 

    /**
     * Returns the value of field 'szCdAdExchangeStatus'.
     * 
     * @return the value of field 'SzCdAdExchangeStatus'.
     */
    public java.lang.String getSzCdAdExchangeStatus()
    {
        return this._szCdAdExchangeStatus;
    } //-- java.lang.String getSzCdAdExchangeStatus() 

    /**
     * Returns the value of field 'szCdElementary'.
     * 
     * @return the value of field 'SzCdElementary'.
     */
    public java.lang.String getSzCdElementary()
    {
        return this._szCdElementary;
    } //-- java.lang.String getSzCdElementary() 

    /**
     * Returns the value of field 'szCdHigh'.
     * 
     * @return the value of field 'SzCdHigh'.
     */
    public java.lang.String getSzCdHigh()
    {
        return this._szCdHigh;
    } //-- java.lang.String getSzCdHigh() 

    /**
     * Returns the value of field 'szCdMiddle'.
     * 
     * @return the value of field 'SzCdMiddle'.
     */
    public java.lang.String getSzCdMiddle()
    {
        return this._szCdMiddle;
    } //-- java.lang.String getSzCdMiddle() 

    /**
     * Returns the value of field 'szCdRshsCategory'.
     * 
     * @return the value of field 'SzCdRshsCategory'.
     */
    public java.lang.String getSzCdRshsCategory()
    {
        return this._szCdRshsCategory;
    } //-- java.lang.String getSzCdRshsCategory() 

    /**
     * Returns the value of field 'szCdRshsClosureRsn'.
     * 
     * @return the value of field 'SzCdRshsClosureRsn'.
     */
    public java.lang.String getSzCdRshsClosureRsn()
    {
        return this._szCdRshsClosureRsn;
    } //-- java.lang.String getSzCdRshsClosureRsn() 

    /**
     * Returns the value of field 'szCdRshsCnty'.
     * 
     * @return the value of field 'SzCdRshsCnty'.
     */
    public java.lang.String getSzCdRshsCnty()
    {
        return this._szCdRshsCnty;
    } //-- java.lang.String getSzCdRshsCnty() 

    /**
     * Returns the value of field 'szCdRshsEthnicity'.
     * 
     * @return the value of field 'SzCdRshsEthnicity'.
     */
    public java.lang.String getSzCdRshsEthnicity()
    {
        return this._szCdRshsEthnicity;
    } //-- java.lang.String getSzCdRshsEthnicity() 

    /**
     * Returns the value of field 'szCdRshsFaHomeStatus'.
     * 
     * @return the value of field 'SzCdRshsFaHomeStatus'.
     */
    public java.lang.String getSzCdRshsFaHomeStatus()
    {
        return this._szCdRshsFaHomeStatus;
    } //-- java.lang.String getSzCdRshsFaHomeStatus() 

    /**
     * Returns the value of field 'szCdRshsLanguage'.
     * 
     * @return the value of field 'SzCdRshsLanguage'.
     */
    public java.lang.String getSzCdRshsLanguage()
    {
        return this._szCdRshsLanguage;
    } //-- java.lang.String getSzCdRshsLanguage() 

    /**
     * Returns the value of field 'szCdRshsMaritalStatus'.
     * 
     * @return the value of field 'SzCdRshsMaritalStatus'.
     */
    public java.lang.String getSzCdRshsMaritalStatus()
    {
        return this._szCdRshsMaritalStatus;
    } //-- java.lang.String getSzCdRshsMaritalStatus() 

    /**
     * Returns the value of field 'szCdRshsRegion'.
     * 
     * @return the value of field 'SzCdRshsRegion'.
     */
    public java.lang.String getSzCdRshsRegion()
    {
        return this._szCdRshsRegion;
    } //-- java.lang.String getSzCdRshsRegion() 

    /**
     * Returns the value of field 'szCdRshsReligion'.
     * 
     * @return the value of field 'SzCdRshsReligion'.
     */
    public java.lang.String getSzCdRshsReligion()
    {
        return this._szCdRshsReligion;
    } //-- java.lang.String getSzCdRshsReligion() 

    /**
     * Returns the value of field 'szCdRshsRespite'.
     * 
     * @return the value of field 'SzCdRshsRespite'.
     */
    public java.lang.String getSzCdRshsRespite()
    {
        return this._szCdRshsRespite;
    } //-- java.lang.String getSzCdRshsRespite() 

    /**
     * Returns the value of field 'szCdRshsSourceInquiry'.
     * 
     * @return the value of field 'SzCdRshsSourceInquiry'.
     */
    public java.lang.String getSzCdRshsSourceInquiry()
    {
        return this._szCdRshsSourceInquiry;
    } //-- java.lang.String getSzCdRshsSourceInquiry() 

    /**
     * Returns the value of field 'szCdRshsState'.
     * 
     * @return the value of field 'SzCdRshsState'.
     */
    public java.lang.String getSzCdRshsState()
    {
        return this._szCdRshsState;
    } //-- java.lang.String getSzCdRshsState() 

    /**
     * Returns the value of field 'szCdSchoolDistrict'.
     * 
     * @return the value of field 'SzCdSchoolDistrict'.
     */
    public java.lang.String getSzCdSchoolDistrict()
    {
        return this._szCdSchoolDistrict;
    } //-- java.lang.String getSzCdSchoolDistrict() 

    /**
     * Returns the value of field 'szNbrRshsVid'.
     * 
     * @return the value of field 'SzNbrRshsVid'.
     */
    public java.lang.String getSzNbrRshsVid()
    {
        return this._szNbrRshsVid;
    } //-- java.lang.String getSzNbrRshsVid() 

    /**
     * Returns the value of field 'szNmLegal'.
     * 
     * @return the value of field 'SzNmLegal'.
     */
    public java.lang.String getSzNmLegal()
    {
        return this._szNmLegal;
    } //-- java.lang.String getSzNmLegal() 

    /**
     * Returns the value of field 'szNmRshsResource'.
     * 
     * @return the value of field 'SzNmRshsResource'.
     */
    public java.lang.String getSzNmRshsResource()
    {
        return this._szNmRshsResource;
    } //-- java.lang.String getSzNmRshsResource() 

    /**
     * Returns the value of field 'szTxtNdfcsCertEntity'.
     * 
     * @return the value of field 'SzTxtNdfcsCertEntity'.
     */
    public java.lang.String getSzTxtNdfcsCertEntity()
    {
        return this._szTxtNdfcsCertEntity;
    } //-- java.lang.String getSzTxtNdfcsCertEntity() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Method hasDNbrRshsAnnualIncome
     * 
     * 
     * 
     * @return true if at least one DNbrRshsAnnualIncome has been
     * added
     */
    public boolean hasDNbrRshsAnnualIncome()
    {
        return this._has_dNbrRshsAnnualIncome;
    } //-- boolean hasDNbrRshsAnnualIncome() 

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
     * Sets the value of field 'cIndCurrHomeStudyExists'.
     * 
     * @param cIndCurrHomeStudyExists the value of field
     * 'cIndCurrHomeStudyExists'.
     */
    public void setCIndCurrHomeStudyExists(java.lang.String cIndCurrHomeStudyExists)
    {
        this._cIndCurrHomeStudyExists = cIndCurrHomeStudyExists;
    } //-- void setCIndCurrHomeStudyExists(java.lang.String) 

    /**
     * Sets the value of field 'cIndPrevFamilyStudyReq'.
     * 
     * @param cIndPrevFamilyStudyReq the value of field
     * 'cIndPrevFamilyStudyReq'.
     */
    public void setCIndPrevFamilyStudyReq(java.lang.String cIndPrevFamilyStudyReq)
    {
        this._cIndPrevFamilyStudyReq = cIndPrevFamilyStudyReq;
    } //-- void setCIndPrevFamilyStudyReq(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsCareProv'.
     * 
     * @param cIndRshsCareProv the value of field 'cIndRshsCareProv'
     */
    public void setCIndRshsCareProv(java.lang.String cIndRshsCareProv)
    {
        this._cIndRshsCareProv = cIndRshsCareProv;
    } //-- void setCIndRshsCareProv(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsNonDFCSHome'.
     * 
     * @param cIndRshsNonDFCSHome the value of field
     * 'cIndRshsNonDFCSHome'.
     */
    public void setCIndRshsNonDFCSHome(java.lang.String cIndRshsNonDFCSHome)
    {
        this._cIndRshsNonDFCSHome = cIndRshsNonDFCSHome;
    } //-- void setCIndRshsNonDFCSHome(java.lang.String) 

    /**
     * Sets the value of field 'cIndWaiver'.
     * 
     * @param cIndWaiver the value of field 'cIndWaiver'.
     */
    public void setCIndWaiver(java.lang.String cIndWaiver)
    {
        this._cIndWaiver = cIndWaiver;
    } //-- void setCIndWaiver(java.lang.String) 

    /**
     * Sets the value of field 'dNbrRshsAnnualIncome'.
     * 
     * @param dNbrRshsAnnualIncome the value of field
     * 'dNbrRshsAnnualIncome'.
     */
    public void setDNbrRshsAnnualIncome(int dNbrRshsAnnualIncome)
    {
        this._dNbrRshsAnnualIncome = dNbrRshsAnnualIncome;
        this._has_dNbrRshsAnnualIncome = true;
    } //-- void setDNbrRshsAnnualIncome(int) 

    /**
     * Sets the value of field 'dtDtRshsMarriage'.
     * 
     * @param dtDtRshsMarriage the value of field 'dtDtRshsMarriage'
     */
    public void setDtDtRshsMarriage(org.exolab.castor.types.Date dtDtRshsMarriage)
    {
        this._dtDtRshsMarriage = dtDtRshsMarriage;
    } //-- void setDtDtRshsMarriage(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdAdExchangeStatus'.
     * 
     * @param szCdAdExchangeStatus the value of field
     * 'szCdAdExchangeStatus'.
     */
    public void setSzCdAdExchangeStatus(java.lang.String szCdAdExchangeStatus)
    {
        this._szCdAdExchangeStatus = szCdAdExchangeStatus;
    } //-- void setSzCdAdExchangeStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdElementary'.
     * 
     * @param szCdElementary the value of field 'szCdElementary'.
     */
    public void setSzCdElementary(java.lang.String szCdElementary)
    {
        this._szCdElementary = szCdElementary;
    } //-- void setSzCdElementary(java.lang.String) 

    /**
     * Sets the value of field 'szCdHigh'.
     * 
     * @param szCdHigh the value of field 'szCdHigh'.
     */
    public void setSzCdHigh(java.lang.String szCdHigh)
    {
        this._szCdHigh = szCdHigh;
    } //-- void setSzCdHigh(java.lang.String) 

    /**
     * Sets the value of field 'szCdMiddle'.
     * 
     * @param szCdMiddle the value of field 'szCdMiddle'.
     */
    public void setSzCdMiddle(java.lang.String szCdMiddle)
    {
        this._szCdMiddle = szCdMiddle;
    } //-- void setSzCdMiddle(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsCategory'.
     * 
     * @param szCdRshsCategory the value of field 'szCdRshsCategory'
     */
    public void setSzCdRshsCategory(java.lang.String szCdRshsCategory)
    {
        this._szCdRshsCategory = szCdRshsCategory;
    } //-- void setSzCdRshsCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsClosureRsn'.
     * 
     * @param szCdRshsClosureRsn the value of field
     * 'szCdRshsClosureRsn'.
     */
    public void setSzCdRshsClosureRsn(java.lang.String szCdRshsClosureRsn)
    {
        this._szCdRshsClosureRsn = szCdRshsClosureRsn;
    } //-- void setSzCdRshsClosureRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsCnty'.
     * 
     * @param szCdRshsCnty the value of field 'szCdRshsCnty'.
     */
    public void setSzCdRshsCnty(java.lang.String szCdRshsCnty)
    {
        this._szCdRshsCnty = szCdRshsCnty;
    } //-- void setSzCdRshsCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsEthnicity'.
     * 
     * @param szCdRshsEthnicity the value of field
     * 'szCdRshsEthnicity'.
     */
    public void setSzCdRshsEthnicity(java.lang.String szCdRshsEthnicity)
    {
        this._szCdRshsEthnicity = szCdRshsEthnicity;
    } //-- void setSzCdRshsEthnicity(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsFaHomeStatus'.
     * 
     * @param szCdRshsFaHomeStatus the value of field
     * 'szCdRshsFaHomeStatus'.
     */
    public void setSzCdRshsFaHomeStatus(java.lang.String szCdRshsFaHomeStatus)
    {
        this._szCdRshsFaHomeStatus = szCdRshsFaHomeStatus;
    } //-- void setSzCdRshsFaHomeStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsLanguage'.
     * 
     * @param szCdRshsLanguage the value of field 'szCdRshsLanguage'
     */
    public void setSzCdRshsLanguage(java.lang.String szCdRshsLanguage)
    {
        this._szCdRshsLanguage = szCdRshsLanguage;
    } //-- void setSzCdRshsLanguage(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsMaritalStatus'.
     * 
     * @param szCdRshsMaritalStatus the value of field
     * 'szCdRshsMaritalStatus'.
     */
    public void setSzCdRshsMaritalStatus(java.lang.String szCdRshsMaritalStatus)
    {
        this._szCdRshsMaritalStatus = szCdRshsMaritalStatus;
    } //-- void setSzCdRshsMaritalStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsRegion'.
     * 
     * @param szCdRshsRegion the value of field 'szCdRshsRegion'.
     */
    public void setSzCdRshsRegion(java.lang.String szCdRshsRegion)
    {
        this._szCdRshsRegion = szCdRshsRegion;
    } //-- void setSzCdRshsRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsReligion'.
     * 
     * @param szCdRshsReligion the value of field 'szCdRshsReligion'
     */
    public void setSzCdRshsReligion(java.lang.String szCdRshsReligion)
    {
        this._szCdRshsReligion = szCdRshsReligion;
    } //-- void setSzCdRshsReligion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsRespite'.
     * 
     * @param szCdRshsRespite the value of field 'szCdRshsRespite'.
     */
    public void setSzCdRshsRespite(java.lang.String szCdRshsRespite)
    {
        this._szCdRshsRespite = szCdRshsRespite;
    } //-- void setSzCdRshsRespite(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsSourceInquiry'.
     * 
     * @param szCdRshsSourceInquiry the value of field
     * 'szCdRshsSourceInquiry'.
     */
    public void setSzCdRshsSourceInquiry(java.lang.String szCdRshsSourceInquiry)
    {
        this._szCdRshsSourceInquiry = szCdRshsSourceInquiry;
    } //-- void setSzCdRshsSourceInquiry(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsState'.
     * 
     * @param szCdRshsState the value of field 'szCdRshsState'.
     */
    public void setSzCdRshsState(java.lang.String szCdRshsState)
    {
        this._szCdRshsState = szCdRshsState;
    } //-- void setSzCdRshsState(java.lang.String) 

    /**
     * Sets the value of field 'szCdSchoolDistrict'.
     * 
     * @param szCdSchoolDistrict the value of field
     * 'szCdSchoolDistrict'.
     */
    public void setSzCdSchoolDistrict(java.lang.String szCdSchoolDistrict)
    {
        this._szCdSchoolDistrict = szCdSchoolDistrict;
    } //-- void setSzCdSchoolDistrict(java.lang.String) 

    /**
     * Sets the value of field 'szNbrRshsVid'.
     * 
     * @param szNbrRshsVid the value of field 'szNbrRshsVid'.
     */
    public void setSzNbrRshsVid(java.lang.String szNbrRshsVid)
    {
        this._szNbrRshsVid = szNbrRshsVid;
    } //-- void setSzNbrRshsVid(java.lang.String) 

    /**
     * Sets the value of field 'szNmLegal'.
     * 
     * @param szNmLegal the value of field 'szNmLegal'.
     */
    public void setSzNmLegal(java.lang.String szNmLegal)
    {
        this._szNmLegal = szNmLegal;
    } //-- void setSzNmLegal(java.lang.String) 

    /**
     * Sets the value of field 'szNmRshsResource'.
     * 
     * @param szNmRshsResource the value of field 'szNmRshsResource'
     */
    public void setSzNmRshsResource(java.lang.String szNmRshsResource)
    {
        this._szNmRshsResource = szNmRshsResource;
    } //-- void setSzNmRshsResource(java.lang.String) 

    /**
     * Sets the value of field 'szTxtNdfcsCertEntity'.
     * 
     * @param szTxtNdfcsCertEntity the value of field
     * 'szTxtNdfcsCertEntity'.
     */
    public void setSzTxtNdfcsCertEntity(java.lang.String szTxtNdfcsCertEntity)
    {
        this._szTxtNdfcsCertEntity = szTxtNdfcsCertEntity;
    } //-- void setSzTxtNdfcsCertEntity(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04 unmarshal(java.io.Reader) 

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
