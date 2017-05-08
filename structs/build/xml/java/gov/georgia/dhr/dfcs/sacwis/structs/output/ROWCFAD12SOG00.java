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
 * Class ROWCFAD12SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD12SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRshsCategory
     */
    private java.lang.String _szCdRshsCategory;

    /**
     * Field _szCdRshsEthnicity
     */
    private java.lang.String _szCdRshsEthnicity;

    /**
     * Field _szCdRshsFaHomeStatus
     */
    private java.lang.String _szCdRshsFaHomeStatus;

    /**
     * Field _szCdRshsInvolClosure
     */
    private java.lang.String _szCdRshsInvolClosure;

    /**
     * Field _szCdRshsLanguage
     */
    private java.lang.String _szCdRshsLanguage;

    /**
     * Field _szCdRshsMaritalStatus
     */
    private java.lang.String _szCdRshsMaritalStatus;

    /**
     * Field _szCdRshsRecmndReopen
     */
    private java.lang.String _szCdRshsRecmndReopen;

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
     * Field _szCdRshsClosureRsn
     */
    private java.lang.String _szCdRshsClosureRsn;

    /**
     * Field _dtDtRshsEffective
     */
    private org.exolab.castor.types.Date _dtDtRshsEffective;

    /**
     * Field _dtDtRshsEnd
     */
    private org.exolab.castor.types.Date _dtDtRshsEnd;

    /**
     * Field _dtDtRshsMarriage
     */
    private org.exolab.castor.types.Date _dtDtRshsMarriage;

    /**
     * Field _ulIdResourceHistory
     */
    private double _ulIdResourceHistory;

    /**
     * keeps track of state for field: _ulIdResourceHistory
     */
    private boolean _has_ulIdResourceHistory;

    /**
     * Field _cCdRshsFaHomeType1
     */
    private java.lang.String _cCdRshsFaHomeType1;

    /**
     * Field _cIndRshsCareProv
     */
    private java.lang.String _cIndRshsCareProv;

    /**
     * Field _cCdRshsFaHomeType5
     */
    private java.lang.String _cCdRshsFaHomeType5;

    /**
     * Field _cCdRshsFaHomeType2
     */
    private java.lang.String _cCdRshsFaHomeType2;

    /**
     * Field _cIndCurrHomeStudyExists
     */
    private java.lang.String _cIndCurrHomeStudyExists;

    /**
     * Field _cCdRshsFaHomeType4
     */
    private java.lang.String _cCdRshsFaHomeType4;

    /**
     * Field _cIndRshsNonDFCSHome
     */
    private java.lang.String _cIndRshsNonDFCSHome;

    /**
     * Field _szTxtNdfcsCertEntity
     */
    private java.lang.String _szTxtNdfcsCertEntity;

    /**
     * Field _cCdRshsFaHomeType6
     */
    private java.lang.String _cCdRshsFaHomeType6;

    /**
     * Field _cCdRshsFaHomeType7
     */
    private java.lang.String _cCdRshsFaHomeType7;

    /**
     * Field _cCdRshsFaHomeType3
     */
    private java.lang.String _cCdRshsFaHomeType3;

    /**
     * Field _uNbrRshsAFeAgeMax
     */
    private int _uNbrRshsAFeAgeMax;

    /**
     * keeps track of state for field: _uNbrRshsAFeAgeMax
     */
    private boolean _has_uNbrRshsAFeAgeMax;

    /**
     * Field _uNbrRshsAFeAgeMin
     */
    private int _uNbrRshsAFeAgeMin;

    /**
     * keeps track of state for field: _uNbrRshsAFeAgeMin
     */
    private boolean _has_uNbrRshsAFeAgeMin;

    /**
     * Field _uNbrRshsAMaAgeMax
     */
    private int _uNbrRshsAMaAgeMax;

    /**
     * keeps track of state for field: _uNbrRshsAMaAgeMax
     */
    private boolean _has_uNbrRshsAMaAgeMax;

    /**
     * Field _uNbrRshsAMaAgeMin
     */
    private int _uNbrRshsAMaAgeMin;

    /**
     * keeps track of state for field: _uNbrRshsAMaAgeMin
     */
    private boolean _has_uNbrRshsAMaAgeMin;

    /**
     * Field _dNbrRshsAnnualIncome
     */
    private int _dNbrRshsAnnualIncome;

    /**
     * keeps track of state for field: _dNbrRshsAnnualIncome
     */
    private boolean _has_dNbrRshsAnnualIncome;

    /**
     * Field _uNbrRshsFacilCapacity
     */
    private int _uNbrRshsFacilCapacity;

    /**
     * keeps track of state for field: _uNbrRshsFacilCapacity
     */
    private boolean _has_uNbrRshsFacilCapacity;

    /**
     * Field _dtDtRshsLicBegin
     */
    private org.exolab.castor.types.Date _dtDtRshsLicBegin;

    /**
     * Field _dtDtRshsLicEnd
     */
    private org.exolab.castor.types.Date _dtDtRshsLicEnd;

    /**
     * Field _cCdRshsExchnageStat
     */
    private java.lang.String _cCdRshsExchnageStat;

    /**
     * Field _bIndHomeIveReimbursable
     */
    private java.lang.String _bIndHomeIveReimbursable;

    /**
     * Field _dtDtReimbursableEffective
     */
    private org.exolab.castor.types.Date _dtDtReimbursableEffective;

    /**
     * Field _dtDtReimbursableEnd
     */
    private org.exolab.castor.types.Date _dtDtReimbursableEnd;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD12SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00()


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
    public void deleteUNbrRshsAFeAgeMax()
    {
        this._has_uNbrRshsAFeAgeMax= false;
    } //-- void deleteUNbrRshsAFeAgeMax() 

    /**
     */
    public void deleteUNbrRshsAFeAgeMin()
    {
        this._has_uNbrRshsAFeAgeMin= false;
    } //-- void deleteUNbrRshsAFeAgeMin() 

    /**
     */
    public void deleteUNbrRshsAMaAgeMax()
    {
        this._has_uNbrRshsAMaAgeMax= false;
    } //-- void deleteUNbrRshsAMaAgeMax() 

    /**
     */
    public void deleteUNbrRshsAMaAgeMin()
    {
        this._has_uNbrRshsAMaAgeMin= false;
    } //-- void deleteUNbrRshsAMaAgeMin() 

    /**
     */
    public void deleteUNbrRshsFacilCapacity()
    {
        this._has_uNbrRshsFacilCapacity= false;
    } //-- void deleteUNbrRshsFacilCapacity() 

    /**
     */
    public void deleteUlIdResourceHistory()
    {
        this._has_ulIdResourceHistory= false;
    } //-- void deleteUlIdResourceHistory() 

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
     * Returns the value of field 'cCdRshsExchnageStat'.
     * 
     * @return the value of field 'CCdRshsExchnageStat'.
     */
    public java.lang.String getCCdRshsExchnageStat()
    {
        return this._cCdRshsExchnageStat;
    } //-- java.lang.String getCCdRshsExchnageStat() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType1'.
     * 
     * @return the value of field 'CCdRshsFaHomeType1'.
     */
    public java.lang.String getCCdRshsFaHomeType1()
    {
        return this._cCdRshsFaHomeType1;
    } //-- java.lang.String getCCdRshsFaHomeType1() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType2'.
     * 
     * @return the value of field 'CCdRshsFaHomeType2'.
     */
    public java.lang.String getCCdRshsFaHomeType2()
    {
        return this._cCdRshsFaHomeType2;
    } //-- java.lang.String getCCdRshsFaHomeType2() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType3'.
     * 
     * @return the value of field 'CCdRshsFaHomeType3'.
     */
    public java.lang.String getCCdRshsFaHomeType3()
    {
        return this._cCdRshsFaHomeType3;
    } //-- java.lang.String getCCdRshsFaHomeType3() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType4'.
     * 
     * @return the value of field 'CCdRshsFaHomeType4'.
     */
    public java.lang.String getCCdRshsFaHomeType4()
    {
        return this._cCdRshsFaHomeType4;
    } //-- java.lang.String getCCdRshsFaHomeType4() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType5'.
     * 
     * @return the value of field 'CCdRshsFaHomeType5'.
     */
    public java.lang.String getCCdRshsFaHomeType5()
    {
        return this._cCdRshsFaHomeType5;
    } //-- java.lang.String getCCdRshsFaHomeType5() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType6'.
     * 
     * @return the value of field 'CCdRshsFaHomeType6'.
     */
    public java.lang.String getCCdRshsFaHomeType6()
    {
        return this._cCdRshsFaHomeType6;
    } //-- java.lang.String getCCdRshsFaHomeType6() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType7'.
     * 
     * @return the value of field 'CCdRshsFaHomeType7'.
     */
    public java.lang.String getCCdRshsFaHomeType7()
    {
        return this._cCdRshsFaHomeType7;
    } //-- java.lang.String getCCdRshsFaHomeType7() 

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
     * Returns the value of field 'dNbrRshsAnnualIncome'.
     * 
     * @return the value of field 'DNbrRshsAnnualIncome'.
     */
    public int getDNbrRshsAnnualIncome()
    {
        return this._dNbrRshsAnnualIncome;
    } //-- int getDNbrRshsAnnualIncome() 

    /**
     * Returns the value of field 'dtDtReimbursableEffective'.
     * 
     * @return the value of field 'DtDtReimbursableEffective'.
     */
    public org.exolab.castor.types.Date getDtDtReimbursableEffective()
    {
        return this._dtDtReimbursableEffective;
    } //-- org.exolab.castor.types.Date getDtDtReimbursableEffective() 

    /**
     * Returns the value of field 'dtDtReimbursableEnd'.
     * 
     * @return the value of field 'DtDtReimbursableEnd'.
     */
    public org.exolab.castor.types.Date getDtDtReimbursableEnd()
    {
        return this._dtDtReimbursableEnd;
    } //-- org.exolab.castor.types.Date getDtDtReimbursableEnd() 

    /**
     * Returns the value of field 'dtDtRshsEffective'.
     * 
     * @return the value of field 'DtDtRshsEffective'.
     */
    public org.exolab.castor.types.Date getDtDtRshsEffective()
    {
        return this._dtDtRshsEffective;
    } //-- org.exolab.castor.types.Date getDtDtRshsEffective() 

    /**
     * Returns the value of field 'dtDtRshsEnd'.
     * 
     * @return the value of field 'DtDtRshsEnd'.
     */
    public org.exolab.castor.types.Date getDtDtRshsEnd()
    {
        return this._dtDtRshsEnd;
    } //-- org.exolab.castor.types.Date getDtDtRshsEnd() 

    /**
     * Returns the value of field 'dtDtRshsLicBegin'.
     * 
     * @return the value of field 'DtDtRshsLicBegin'.
     */
    public org.exolab.castor.types.Date getDtDtRshsLicBegin()
    {
        return this._dtDtRshsLicBegin;
    } //-- org.exolab.castor.types.Date getDtDtRshsLicBegin() 

    /**
     * Returns the value of field 'dtDtRshsLicEnd'.
     * 
     * @return the value of field 'DtDtRshsLicEnd'.
     */
    public org.exolab.castor.types.Date getDtDtRshsLicEnd()
    {
        return this._dtDtRshsLicEnd;
    } //-- org.exolab.castor.types.Date getDtDtRshsLicEnd() 

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
     * Returns the value of field 'szCdRshsInvolClosure'.
     * 
     * @return the value of field 'SzCdRshsInvolClosure'.
     */
    public java.lang.String getSzCdRshsInvolClosure()
    {
        return this._szCdRshsInvolClosure;
    } //-- java.lang.String getSzCdRshsInvolClosure() 

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
     * Returns the value of field 'szCdRshsRecmndReopen'.
     * 
     * @return the value of field 'SzCdRshsRecmndReopen'.
     */
    public java.lang.String getSzCdRshsRecmndReopen()
    {
        return this._szCdRshsRecmndReopen;
    } //-- java.lang.String getSzCdRshsRecmndReopen() 

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
     * Returns the value of field 'szTxtNdfcsCertEntity'.
     * 
     * @return the value of field 'SzTxtNdfcsCertEntity'.
     */
    public java.lang.String getSzTxtNdfcsCertEntity()
    {
        return this._szTxtNdfcsCertEntity;
    } //-- java.lang.String getSzTxtNdfcsCertEntity() 

    /**
     * Returns the value of field 'uNbrRshsAFeAgeMax'.
     * 
     * @return the value of field 'UNbrRshsAFeAgeMax'.
     */
    public int getUNbrRshsAFeAgeMax()
    {
        return this._uNbrRshsAFeAgeMax;
    } //-- int getUNbrRshsAFeAgeMax() 

    /**
     * Returns the value of field 'uNbrRshsAFeAgeMin'.
     * 
     * @return the value of field 'UNbrRshsAFeAgeMin'.
     */
    public int getUNbrRshsAFeAgeMin()
    {
        return this._uNbrRshsAFeAgeMin;
    } //-- int getUNbrRshsAFeAgeMin() 

    /**
     * Returns the value of field 'uNbrRshsAMaAgeMax'.
     * 
     * @return the value of field 'UNbrRshsAMaAgeMax'.
     */
    public int getUNbrRshsAMaAgeMax()
    {
        return this._uNbrRshsAMaAgeMax;
    } //-- int getUNbrRshsAMaAgeMax() 

    /**
     * Returns the value of field 'uNbrRshsAMaAgeMin'.
     * 
     * @return the value of field 'UNbrRshsAMaAgeMin'.
     */
    public int getUNbrRshsAMaAgeMin()
    {
        return this._uNbrRshsAMaAgeMin;
    } //-- int getUNbrRshsAMaAgeMin() 

    /**
     * Returns the value of field 'uNbrRshsFacilCapacity'.
     * 
     * @return the value of field 'UNbrRshsFacilCapacity'.
     */
    public int getUNbrRshsFacilCapacity()
    {
        return this._uNbrRshsFacilCapacity;
    } //-- int getUNbrRshsFacilCapacity() 

    /**
     * Returns the value of field 'ulIdResourceHistory'.
     * 
     * @return the value of field 'UlIdResourceHistory'.
     */
    public double getUlIdResourceHistory()
    {
        return this._ulIdResourceHistory;
    } //-- double getUlIdResourceHistory() 

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
     * Method hasUNbrRshsAFeAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRshsAFeAgeMax has been added
     */
    public boolean hasUNbrRshsAFeAgeMax()
    {
        return this._has_uNbrRshsAFeAgeMax;
    } //-- boolean hasUNbrRshsAFeAgeMax() 

    /**
     * Method hasUNbrRshsAFeAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRshsAFeAgeMin has been added
     */
    public boolean hasUNbrRshsAFeAgeMin()
    {
        return this._has_uNbrRshsAFeAgeMin;
    } //-- boolean hasUNbrRshsAFeAgeMin() 

    /**
     * Method hasUNbrRshsAMaAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRshsAMaAgeMax has been added
     */
    public boolean hasUNbrRshsAMaAgeMax()
    {
        return this._has_uNbrRshsAMaAgeMax;
    } //-- boolean hasUNbrRshsAMaAgeMax() 

    /**
     * Method hasUNbrRshsAMaAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRshsAMaAgeMin has been added
     */
    public boolean hasUNbrRshsAMaAgeMin()
    {
        return this._has_uNbrRshsAMaAgeMin;
    } //-- boolean hasUNbrRshsAMaAgeMin() 

    /**
     * Method hasUNbrRshsFacilCapacity
     * 
     * 
     * 
     * @return true if at least one UNbrRshsFacilCapacity has been
     * added
     */
    public boolean hasUNbrRshsFacilCapacity()
    {
        return this._has_uNbrRshsFacilCapacity;
    } //-- boolean hasUNbrRshsFacilCapacity() 

    /**
     * Method hasUlIdResourceHistory
     * 
     * 
     * 
     * @return true if at least one UlIdResourceHistory has been
     * added
     */
    public boolean hasUlIdResourceHistory()
    {
        return this._has_ulIdResourceHistory;
    } //-- boolean hasUlIdResourceHistory() 

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
     * Sets the value of field 'cCdRshsExchnageStat'.
     * 
     * @param cCdRshsExchnageStat the value of field
     * 'cCdRshsExchnageStat'.
     */
    public void setCCdRshsExchnageStat(java.lang.String cCdRshsExchnageStat)
    {
        this._cCdRshsExchnageStat = cCdRshsExchnageStat;
    } //-- void setCCdRshsExchnageStat(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType1'.
     * 
     * @param cCdRshsFaHomeType1 the value of field
     * 'cCdRshsFaHomeType1'.
     */
    public void setCCdRshsFaHomeType1(java.lang.String cCdRshsFaHomeType1)
    {
        this._cCdRshsFaHomeType1 = cCdRshsFaHomeType1;
    } //-- void setCCdRshsFaHomeType1(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType2'.
     * 
     * @param cCdRshsFaHomeType2 the value of field
     * 'cCdRshsFaHomeType2'.
     */
    public void setCCdRshsFaHomeType2(java.lang.String cCdRshsFaHomeType2)
    {
        this._cCdRshsFaHomeType2 = cCdRshsFaHomeType2;
    } //-- void setCCdRshsFaHomeType2(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType3'.
     * 
     * @param cCdRshsFaHomeType3 the value of field
     * 'cCdRshsFaHomeType3'.
     */
    public void setCCdRshsFaHomeType3(java.lang.String cCdRshsFaHomeType3)
    {
        this._cCdRshsFaHomeType3 = cCdRshsFaHomeType3;
    } //-- void setCCdRshsFaHomeType3(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType4'.
     * 
     * @param cCdRshsFaHomeType4 the value of field
     * 'cCdRshsFaHomeType4'.
     */
    public void setCCdRshsFaHomeType4(java.lang.String cCdRshsFaHomeType4)
    {
        this._cCdRshsFaHomeType4 = cCdRshsFaHomeType4;
    } //-- void setCCdRshsFaHomeType4(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType5'.
     * 
     * @param cCdRshsFaHomeType5 the value of field
     * 'cCdRshsFaHomeType5'.
     */
    public void setCCdRshsFaHomeType5(java.lang.String cCdRshsFaHomeType5)
    {
        this._cCdRshsFaHomeType5 = cCdRshsFaHomeType5;
    } //-- void setCCdRshsFaHomeType5(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType6'.
     * 
     * @param cCdRshsFaHomeType6 the value of field
     * 'cCdRshsFaHomeType6'.
     */
    public void setCCdRshsFaHomeType6(java.lang.String cCdRshsFaHomeType6)
    {
        this._cCdRshsFaHomeType6 = cCdRshsFaHomeType6;
    } //-- void setCCdRshsFaHomeType6(java.lang.String) 

    /**
     * Sets the value of field 'cCdRshsFaHomeType7'.
     * 
     * @param cCdRshsFaHomeType7 the value of field
     * 'cCdRshsFaHomeType7'.
     */
    public void setCCdRshsFaHomeType7(java.lang.String cCdRshsFaHomeType7)
    {
        this._cCdRshsFaHomeType7 = cCdRshsFaHomeType7;
    } //-- void setCCdRshsFaHomeType7(java.lang.String) 

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
     * Sets the value of field 'dtDtReimbursableEffective'.
     * 
     * @param dtDtReimbursableEffective the value of field
     * 'dtDtReimbursableEffective'.
     */
    public void setDtDtReimbursableEffective(org.exolab.castor.types.Date dtDtReimbursableEffective)
    {
        this._dtDtReimbursableEffective = dtDtReimbursableEffective;
    } //-- void setDtDtReimbursableEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtReimbursableEnd'.
     * 
     * @param dtDtReimbursableEnd the value of field
     * 'dtDtReimbursableEnd'.
     */
    public void setDtDtReimbursableEnd(org.exolab.castor.types.Date dtDtReimbursableEnd)
    {
        this._dtDtReimbursableEnd = dtDtReimbursableEnd;
    } //-- void setDtDtReimbursableEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsEffective'.
     * 
     * @param dtDtRshsEffective the value of field
     * 'dtDtRshsEffective'.
     */
    public void setDtDtRshsEffective(org.exolab.castor.types.Date dtDtRshsEffective)
    {
        this._dtDtRshsEffective = dtDtRshsEffective;
    } //-- void setDtDtRshsEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsEnd'.
     * 
     * @param dtDtRshsEnd the value of field 'dtDtRshsEnd'.
     */
    public void setDtDtRshsEnd(org.exolab.castor.types.Date dtDtRshsEnd)
    {
        this._dtDtRshsEnd = dtDtRshsEnd;
    } //-- void setDtDtRshsEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsLicBegin'.
     * 
     * @param dtDtRshsLicBegin the value of field 'dtDtRshsLicBegin'
     */
    public void setDtDtRshsLicBegin(org.exolab.castor.types.Date dtDtRshsLicBegin)
    {
        this._dtDtRshsLicBegin = dtDtRshsLicBegin;
    } //-- void setDtDtRshsLicBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsLicEnd'.
     * 
     * @param dtDtRshsLicEnd the value of field 'dtDtRshsLicEnd'.
     */
    public void setDtDtRshsLicEnd(org.exolab.castor.types.Date dtDtRshsLicEnd)
    {
        this._dtDtRshsLicEnd = dtDtRshsLicEnd;
    } //-- void setDtDtRshsLicEnd(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdRshsInvolClosure'.
     * 
     * @param szCdRshsInvolClosure the value of field
     * 'szCdRshsInvolClosure'.
     */
    public void setSzCdRshsInvolClosure(java.lang.String szCdRshsInvolClosure)
    {
        this._szCdRshsInvolClosure = szCdRshsInvolClosure;
    } //-- void setSzCdRshsInvolClosure(java.lang.String) 

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
     * Sets the value of field 'szCdRshsRecmndReopen'.
     * 
     * @param szCdRshsRecmndReopen the value of field
     * 'szCdRshsRecmndReopen'.
     */
    public void setSzCdRshsRecmndReopen(java.lang.String szCdRshsRecmndReopen)
    {
        this._szCdRshsRecmndReopen = szCdRshsRecmndReopen;
    } //-- void setSzCdRshsRecmndReopen(java.lang.String) 

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
     * Sets the value of field 'uNbrRshsAFeAgeMax'.
     * 
     * @param uNbrRshsAFeAgeMax the value of field
     * 'uNbrRshsAFeAgeMax'.
     */
    public void setUNbrRshsAFeAgeMax(int uNbrRshsAFeAgeMax)
    {
        this._uNbrRshsAFeAgeMax = uNbrRshsAFeAgeMax;
        this._has_uNbrRshsAFeAgeMax = true;
    } //-- void setUNbrRshsAFeAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRshsAFeAgeMin'.
     * 
     * @param uNbrRshsAFeAgeMin the value of field
     * 'uNbrRshsAFeAgeMin'.
     */
    public void setUNbrRshsAFeAgeMin(int uNbrRshsAFeAgeMin)
    {
        this._uNbrRshsAFeAgeMin = uNbrRshsAFeAgeMin;
        this._has_uNbrRshsAFeAgeMin = true;
    } //-- void setUNbrRshsAFeAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRshsAMaAgeMax'.
     * 
     * @param uNbrRshsAMaAgeMax the value of field
     * 'uNbrRshsAMaAgeMax'.
     */
    public void setUNbrRshsAMaAgeMax(int uNbrRshsAMaAgeMax)
    {
        this._uNbrRshsAMaAgeMax = uNbrRshsAMaAgeMax;
        this._has_uNbrRshsAMaAgeMax = true;
    } //-- void setUNbrRshsAMaAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRshsAMaAgeMin'.
     * 
     * @param uNbrRshsAMaAgeMin the value of field
     * 'uNbrRshsAMaAgeMin'.
     */
    public void setUNbrRshsAMaAgeMin(int uNbrRshsAMaAgeMin)
    {
        this._uNbrRshsAMaAgeMin = uNbrRshsAMaAgeMin;
        this._has_uNbrRshsAMaAgeMin = true;
    } //-- void setUNbrRshsAMaAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRshsFacilCapacity'.
     * 
     * @param uNbrRshsFacilCapacity the value of field
     * 'uNbrRshsFacilCapacity'.
     */
    public void setUNbrRshsFacilCapacity(int uNbrRshsFacilCapacity)
    {
        this._uNbrRshsFacilCapacity = uNbrRshsFacilCapacity;
        this._has_uNbrRshsFacilCapacity = true;
    } //-- void setUNbrRshsFacilCapacity(int) 

    /**
     * Sets the value of field 'ulIdResourceHistory'.
     * 
     * @param ulIdResourceHistory the value of field
     * 'ulIdResourceHistory'.
     */
    public void setUlIdResourceHistory(double ulIdResourceHistory)
    {
        this._ulIdResourceHistory = ulIdResourceHistory;
        this._has_ulIdResourceHistory = true;
    } //-- void setUlIdResourceHistory(double) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00 unmarshal(java.io.Reader) 

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
