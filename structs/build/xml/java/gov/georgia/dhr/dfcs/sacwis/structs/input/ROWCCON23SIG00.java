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
 * Class ROWCCON23SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON23SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdSvcAuthDtlAuthType
     */
    private java.lang.String _szCdSvcAuthDtlAuthType;

    /**
     * Field _szCdSvcAuthDtlPeriod
     */
    private java.lang.String _szCdSvcAuthDtlPeriod;

    /**
     * Field _szCdSvcAuthDtlSvc
     */
    private java.lang.String _szCdSvcAuthDtlSvc;

    /**
     * Field _szCdSvcAuthDtlUnitType
     */
    private java.lang.String _szCdSvcAuthDtlUnitType;

    /**
     * Field _dtDtSvcAuthDtl
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtl;

    /**
     * Field _dtDtSvcAuthDtlBegin
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtlBegin;

    /**
     * Field _dtDtSvcAuthDtlEnd
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtlEnd;

    /**
     * Field _dtDtSvcAuthDtlTerm
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtlTerm;

    /**
     * Field _dtSvcAuthDtlShow
     */
    private org.exolab.castor.types.Date _dtSvcAuthDtlShow;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdSvcAuth
     */
    private int _ulIdSvcAuth;

    /**
     * keeps track of state for field: _ulIdSvcAuth
     */
    private boolean _has_ulIdSvcAuth;

    /**
     * Field _ulIdSvcAuthDtl
     */
    private int _ulIdSvcAuthDtl;

    /**
     * keeps track of state for field: _ulIdSvcAuthDtl
     */
    private boolean _has_ulIdSvcAuthDtl;

    /**
     * Field _lAmtSvcAuthDtlAmtReq
     */
    private double _lAmtSvcAuthDtlAmtReq;

    /**
     * keeps track of state for field: _lAmtSvcAuthDtlAmtReq
     */
    private boolean _has_lAmtSvcAuthDtlAmtReq;

    /**
     * Field _uNbrSvcAuthDtlFreq
     */
    private int _uNbrSvcAuthDtlFreq;

    /**
     * keeps track of state for field: _uNbrSvcAuthDtlFreq
     */
    private boolean _has_uNbrSvcAuthDtlFreq;

    /**
     * Field _ulNbrSvcAuthDtlLineItm
     */
    private int _ulNbrSvcAuthDtlLineItm;

    /**
     * keeps track of state for field: _ulNbrSvcAuthDtlLineItm
     */
    private boolean _has_ulNbrSvcAuthDtlLineItm;

    /**
     * Field _lNbrSvcAuthDtlSugUnit
     */
    private int _lNbrSvcAuthDtlSugUnit;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlSugUnit
     */
    private boolean _has_lNbrSvcAuthDtlSugUnit;

    /**
     * Field _lNbrSvcAuthDtlUnitRate
     */
    private double _lNbrSvcAuthDtlUnitRate;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlUnitRate
     */
    private boolean _has_lNbrSvcAuthDtlUnitRate;

    /**
     * Field _lNbrSvcAuthDtlUnitReq
     */
    private double _lNbrSvcAuthDtlUnitReq;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlUnitReq
     */
    private boolean _has_lNbrSvcAuthDtlUnitReq;

    /**
     * Field _lNbrSvcAuthDtlUnitUsed
     */
    private double _lNbrSvcAuthDtlUnitUsed;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlUnitUsed
     */
    private boolean _has_lNbrSvcAuthDtlUnitUsed;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _indServAcpt
     */
    private java.lang.String _indServAcpt;

    /**
     * Field _indCasePlanSvc
     */
    private java.lang.String _indCasePlanSvc;

    /**
     * Field _szCdSvcQlty
     */
    private java.lang.String _szCdSvcQlty;

    /**
     * Field _szTxtRefQltyCmnts
     */
    private java.lang.String _szTxtRefQltyCmnts;

    /**
     * Field _ulIdAdopAssistAppl
     */
    private int _ulIdAdopAssistAppl;

    /**
     * keeps track of state for field: _ulIdAdopAssistAppl
     */
    private boolean _has_ulIdAdopAssistAppl;

    /**
     * Field _szTxtCommentsAdditional
     */
    private java.lang.String _szTxtCommentsAdditional;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON23SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLAmtSvcAuthDtlAmtReq()
    {
        this._has_lAmtSvcAuthDtlAmtReq= false;
    } //-- void deleteLAmtSvcAuthDtlAmtReq() 

    /**
     */
    public void deleteLNbrSvcAuthDtlSugUnit()
    {
        this._has_lNbrSvcAuthDtlSugUnit= false;
    } //-- void deleteLNbrSvcAuthDtlSugUnit() 

    /**
     */
    public void deleteLNbrSvcAuthDtlUnitRate()
    {
        this._has_lNbrSvcAuthDtlUnitRate= false;
    } //-- void deleteLNbrSvcAuthDtlUnitRate() 

    /**
     */
    public void deleteLNbrSvcAuthDtlUnitReq()
    {
        this._has_lNbrSvcAuthDtlUnitReq= false;
    } //-- void deleteLNbrSvcAuthDtlUnitReq() 

    /**
     */
    public void deleteLNbrSvcAuthDtlUnitUsed()
    {
        this._has_lNbrSvcAuthDtlUnitUsed= false;
    } //-- void deleteLNbrSvcAuthDtlUnitUsed() 

    /**
     */
    public void deleteUNbrSvcAuthDtlFreq()
    {
        this._has_uNbrSvcAuthDtlFreq= false;
    } //-- void deleteUNbrSvcAuthDtlFreq() 

    /**
     */
    public void deleteUlIdAdopAssistAppl()
    {
        this._has_ulIdAdopAssistAppl= false;
    } //-- void deleteUlIdAdopAssistAppl() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdSvcAuth()
    {
        this._has_ulIdSvcAuth= false;
    } //-- void deleteUlIdSvcAuth() 

    /**
     */
    public void deleteUlIdSvcAuthDtl()
    {
        this._has_ulIdSvcAuthDtl= false;
    } //-- void deleteUlIdSvcAuthDtl() 

    /**
     */
    public void deleteUlNbrSvcAuthDtlLineItm()
    {
        this._has_ulNbrSvcAuthDtlLineItm= false;
    } //-- void deleteUlNbrSvcAuthDtlLineItm() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtl'.
     * 
     * @return the value of field 'DtDtSvcAuthDtl'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtl()
    {
        return this._dtDtSvcAuthDtl;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtl() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtlBegin'.
     * 
     * @return the value of field 'DtDtSvcAuthDtlBegin'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtlBegin()
    {
        return this._dtDtSvcAuthDtlBegin;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtlBegin() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtlEnd'.
     * 
     * @return the value of field 'DtDtSvcAuthDtlEnd'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtlEnd()
    {
        return this._dtDtSvcAuthDtlEnd;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtlEnd() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtlTerm'.
     * 
     * @return the value of field 'DtDtSvcAuthDtlTerm'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtlTerm()
    {
        return this._dtDtSvcAuthDtlTerm;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtlTerm() 

    /**
     * Returns the value of field 'dtSvcAuthDtlShow'.
     * 
     * @return the value of field 'DtSvcAuthDtlShow'.
     */
    public org.exolab.castor.types.Date getDtSvcAuthDtlShow()
    {
        return this._dtSvcAuthDtlShow;
    } //-- org.exolab.castor.types.Date getDtSvcAuthDtlShow() 

    /**
     * Returns the value of field 'indCasePlanSvc'.
     * 
     * @return the value of field 'IndCasePlanSvc'.
     */
    public java.lang.String getIndCasePlanSvc()
    {
        return this._indCasePlanSvc;
    } //-- java.lang.String getIndCasePlanSvc() 

    /**
     * Returns the value of field 'indServAcpt'.
     * 
     * @return the value of field 'IndServAcpt'.
     */
    public java.lang.String getIndServAcpt()
    {
        return this._indServAcpt;
    } //-- java.lang.String getIndServAcpt() 

    /**
     * Returns the value of field 'lAmtSvcAuthDtlAmtReq'.
     * 
     * @return the value of field 'LAmtSvcAuthDtlAmtReq'.
     */
    public double getLAmtSvcAuthDtlAmtReq()
    {
        return this._lAmtSvcAuthDtlAmtReq;
    } //-- double getLAmtSvcAuthDtlAmtReq() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlSugUnit'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlSugUnit'.
     */
    public int getLNbrSvcAuthDtlSugUnit()
    {
        return this._lNbrSvcAuthDtlSugUnit;
    } //-- int getLNbrSvcAuthDtlSugUnit() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlUnitRate'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlUnitRate'.
     */
    public double getLNbrSvcAuthDtlUnitRate()
    {
        return this._lNbrSvcAuthDtlUnitRate;
    } //-- double getLNbrSvcAuthDtlUnitRate() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlUnitReq'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlUnitReq'.
     */
    public double getLNbrSvcAuthDtlUnitReq()
    {
        return this._lNbrSvcAuthDtlUnitReq;
    } //-- double getLNbrSvcAuthDtlUnitReq() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlUnitUsed'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlUnitUsed'.
     */
    public double getLNbrSvcAuthDtlUnitUsed()
    {
        return this._lNbrSvcAuthDtlUnitUsed;
    } //-- double getLNbrSvcAuthDtlUnitUsed() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlAuthType'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlAuthType'.
     */
    public java.lang.String getSzCdSvcAuthDtlAuthType()
    {
        return this._szCdSvcAuthDtlAuthType;
    } //-- java.lang.String getSzCdSvcAuthDtlAuthType() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlPeriod'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlPeriod'.
     */
    public java.lang.String getSzCdSvcAuthDtlPeriod()
    {
        return this._szCdSvcAuthDtlPeriod;
    } //-- java.lang.String getSzCdSvcAuthDtlPeriod() 

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
     * Returns the value of field 'szCdSvcAuthDtlUnitType'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlUnitType'.
     */
    public java.lang.String getSzCdSvcAuthDtlUnitType()
    {
        return this._szCdSvcAuthDtlUnitType;
    } //-- java.lang.String getSzCdSvcAuthDtlUnitType() 

    /**
     * Returns the value of field 'szCdSvcQlty'.
     * 
     * @return the value of field 'SzCdSvcQlty'.
     */
    public java.lang.String getSzCdSvcQlty()
    {
        return this._szCdSvcQlty;
    } //-- java.lang.String getSzCdSvcQlty() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szTxtCommentsAdditional'.
     * 
     * @return the value of field 'SzTxtCommentsAdditional'.
     */
    public java.lang.String getSzTxtCommentsAdditional()
    {
        return this._szTxtCommentsAdditional;
    } //-- java.lang.String getSzTxtCommentsAdditional() 

    /**
     * Returns the value of field 'szTxtRefQltyCmnts'.
     * 
     * @return the value of field 'SzTxtRefQltyCmnts'.
     */
    public java.lang.String getSzTxtRefQltyCmnts()
    {
        return this._szTxtRefQltyCmnts;
    } //-- java.lang.String getSzTxtRefQltyCmnts() 

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
     * Returns the value of field 'uNbrSvcAuthDtlFreq'.
     * 
     * @return the value of field 'UNbrSvcAuthDtlFreq'.
     */
    public int getUNbrSvcAuthDtlFreq()
    {
        return this._uNbrSvcAuthDtlFreq;
    } //-- int getUNbrSvcAuthDtlFreq() 

    /**
     * Returns the value of field 'ulIdAdopAssistAppl'.
     * 
     * @return the value of field 'UlIdAdopAssistAppl'.
     */
    public int getUlIdAdopAssistAppl()
    {
        return this._ulIdAdopAssistAppl;
    } //-- int getUlIdAdopAssistAppl() 

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
     * Returns the value of field 'ulIdSvcAuth'.
     * 
     * @return the value of field 'UlIdSvcAuth'.
     */
    public int getUlIdSvcAuth()
    {
        return this._ulIdSvcAuth;
    } //-- int getUlIdSvcAuth() 

    /**
     * Returns the value of field 'ulIdSvcAuthDtl'.
     * 
     * @return the value of field 'UlIdSvcAuthDtl'.
     */
    public int getUlIdSvcAuthDtl()
    {
        return this._ulIdSvcAuthDtl;
    } //-- int getUlIdSvcAuthDtl() 

    /**
     * Returns the value of field 'ulNbrSvcAuthDtlLineItm'.
     * 
     * @return the value of field 'UlNbrSvcAuthDtlLineItm'.
     */
    public int getUlNbrSvcAuthDtlLineItm()
    {
        return this._ulNbrSvcAuthDtlLineItm;
    } //-- int getUlNbrSvcAuthDtlLineItm() 

    /**
     * Method hasLAmtSvcAuthDtlAmtReq
     * 
     * 
     * 
     * @return true if at least one LAmtSvcAuthDtlAmtReq has been
     * added
     */
    public boolean hasLAmtSvcAuthDtlAmtReq()
    {
        return this._has_lAmtSvcAuthDtlAmtReq;
    } //-- boolean hasLAmtSvcAuthDtlAmtReq() 

    /**
     * Method hasLNbrSvcAuthDtlSugUnit
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlSugUnit has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlSugUnit()
    {
        return this._has_lNbrSvcAuthDtlSugUnit;
    } //-- boolean hasLNbrSvcAuthDtlSugUnit() 

    /**
     * Method hasLNbrSvcAuthDtlUnitRate
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlUnitRate has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlUnitRate()
    {
        return this._has_lNbrSvcAuthDtlUnitRate;
    } //-- boolean hasLNbrSvcAuthDtlUnitRate() 

    /**
     * Method hasLNbrSvcAuthDtlUnitReq
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlUnitReq has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlUnitReq()
    {
        return this._has_lNbrSvcAuthDtlUnitReq;
    } //-- boolean hasLNbrSvcAuthDtlUnitReq() 

    /**
     * Method hasLNbrSvcAuthDtlUnitUsed
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlUnitUsed has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlUnitUsed()
    {
        return this._has_lNbrSvcAuthDtlUnitUsed;
    } //-- boolean hasLNbrSvcAuthDtlUnitUsed() 

    /**
     * Method hasUNbrSvcAuthDtlFreq
     * 
     * 
     * 
     * @return true if at least one UNbrSvcAuthDtlFreq has been adde
     */
    public boolean hasUNbrSvcAuthDtlFreq()
    {
        return this._has_uNbrSvcAuthDtlFreq;
    } //-- boolean hasUNbrSvcAuthDtlFreq() 

    /**
     * Method hasUlIdAdopAssistAppl
     * 
     * 
     * 
     * @return true if at least one UlIdAdopAssistAppl has been adde
     */
    public boolean hasUlIdAdopAssistAppl()
    {
        return this._has_ulIdAdopAssistAppl;
    } //-- boolean hasUlIdAdopAssistAppl() 

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
     * Method hasUlIdSvcAuth
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuth has been added
     */
    public boolean hasUlIdSvcAuth()
    {
        return this._has_ulIdSvcAuth;
    } //-- boolean hasUlIdSvcAuth() 

    /**
     * Method hasUlIdSvcAuthDtl
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuthDtl has been added
     */
    public boolean hasUlIdSvcAuthDtl()
    {
        return this._has_ulIdSvcAuthDtl;
    } //-- boolean hasUlIdSvcAuthDtl() 

    /**
     * Method hasUlNbrSvcAuthDtlLineItm
     * 
     * 
     * 
     * @return true if at least one UlNbrSvcAuthDtlLineItm has been
     * added
     */
    public boolean hasUlNbrSvcAuthDtlLineItm()
    {
        return this._has_ulNbrSvcAuthDtlLineItm;
    } //-- boolean hasUlNbrSvcAuthDtlLineItm() 

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
     * Sets the value of field 'dtDtSvcAuthDtl'.
     * 
     * @param dtDtSvcAuthDtl the value of field 'dtDtSvcAuthDtl'.
     */
    public void setDtDtSvcAuthDtl(org.exolab.castor.types.Date dtDtSvcAuthDtl)
    {
        this._dtDtSvcAuthDtl = dtDtSvcAuthDtl;
    } //-- void setDtDtSvcAuthDtl(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthDtlBegin'.
     * 
     * @param dtDtSvcAuthDtlBegin the value of field
     * 'dtDtSvcAuthDtlBegin'.
     */
    public void setDtDtSvcAuthDtlBegin(org.exolab.castor.types.Date dtDtSvcAuthDtlBegin)
    {
        this._dtDtSvcAuthDtlBegin = dtDtSvcAuthDtlBegin;
    } //-- void setDtDtSvcAuthDtlBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthDtlEnd'.
     * 
     * @param dtDtSvcAuthDtlEnd the value of field
     * 'dtDtSvcAuthDtlEnd'.
     */
    public void setDtDtSvcAuthDtlEnd(org.exolab.castor.types.Date dtDtSvcAuthDtlEnd)
    {
        this._dtDtSvcAuthDtlEnd = dtDtSvcAuthDtlEnd;
    } //-- void setDtDtSvcAuthDtlEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthDtlTerm'.
     * 
     * @param dtDtSvcAuthDtlTerm the value of field
     * 'dtDtSvcAuthDtlTerm'.
     */
    public void setDtDtSvcAuthDtlTerm(org.exolab.castor.types.Date dtDtSvcAuthDtlTerm)
    {
        this._dtDtSvcAuthDtlTerm = dtDtSvcAuthDtlTerm;
    } //-- void setDtDtSvcAuthDtlTerm(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtSvcAuthDtlShow'.
     * 
     * @param dtSvcAuthDtlShow the value of field 'dtSvcAuthDtlShow'
     */
    public void setDtSvcAuthDtlShow(org.exolab.castor.types.Date dtSvcAuthDtlShow)
    {
        this._dtSvcAuthDtlShow = dtSvcAuthDtlShow;
    } //-- void setDtSvcAuthDtlShow(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indCasePlanSvc'.
     * 
     * @param indCasePlanSvc the value of field 'indCasePlanSvc'.
     */
    public void setIndCasePlanSvc(java.lang.String indCasePlanSvc)
    {
        this._indCasePlanSvc = indCasePlanSvc;
    } //-- void setIndCasePlanSvc(java.lang.String) 

    /**
     * Sets the value of field 'indServAcpt'.
     * 
     * @param indServAcpt the value of field 'indServAcpt'.
     */
    public void setIndServAcpt(java.lang.String indServAcpt)
    {
        this._indServAcpt = indServAcpt;
    } //-- void setIndServAcpt(java.lang.String) 

    /**
     * Sets the value of field 'lAmtSvcAuthDtlAmtReq'.
     * 
     * @param lAmtSvcAuthDtlAmtReq the value of field
     * 'lAmtSvcAuthDtlAmtReq'.
     */
    public void setLAmtSvcAuthDtlAmtReq(double lAmtSvcAuthDtlAmtReq)
    {
        this._lAmtSvcAuthDtlAmtReq = lAmtSvcAuthDtlAmtReq;
        this._has_lAmtSvcAuthDtlAmtReq = true;
    } //-- void setLAmtSvcAuthDtlAmtReq(double) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlSugUnit'.
     * 
     * @param lNbrSvcAuthDtlSugUnit the value of field
     * 'lNbrSvcAuthDtlSugUnit'.
     */
    public void setLNbrSvcAuthDtlSugUnit(int lNbrSvcAuthDtlSugUnit)
    {
        this._lNbrSvcAuthDtlSugUnit = lNbrSvcAuthDtlSugUnit;
        this._has_lNbrSvcAuthDtlSugUnit = true;
    } //-- void setLNbrSvcAuthDtlSugUnit(int) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlUnitRate'.
     * 
     * @param lNbrSvcAuthDtlUnitRate the value of field
     * 'lNbrSvcAuthDtlUnitRate'.
     */
    public void setLNbrSvcAuthDtlUnitRate(double lNbrSvcAuthDtlUnitRate)
    {
        this._lNbrSvcAuthDtlUnitRate = lNbrSvcAuthDtlUnitRate;
        this._has_lNbrSvcAuthDtlUnitRate = true;
    } //-- void setLNbrSvcAuthDtlUnitRate(double) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlUnitReq'.
     * 
     * @param lNbrSvcAuthDtlUnitReq the value of field
     * 'lNbrSvcAuthDtlUnitReq'.
     */
    public void setLNbrSvcAuthDtlUnitReq(double lNbrSvcAuthDtlUnitReq)
    {
        this._lNbrSvcAuthDtlUnitReq = lNbrSvcAuthDtlUnitReq;
        this._has_lNbrSvcAuthDtlUnitReq = true;
    } //-- void setLNbrSvcAuthDtlUnitReq(double) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlUnitUsed'.
     * 
     * @param lNbrSvcAuthDtlUnitUsed the value of field
     * 'lNbrSvcAuthDtlUnitUsed'.
     */
    public void setLNbrSvcAuthDtlUnitUsed(double lNbrSvcAuthDtlUnitUsed)
    {
        this._lNbrSvcAuthDtlUnitUsed = lNbrSvcAuthDtlUnitUsed;
        this._has_lNbrSvcAuthDtlUnitUsed = true;
    } //-- void setLNbrSvcAuthDtlUnitUsed(double) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlAuthType'.
     * 
     * @param szCdSvcAuthDtlAuthType the value of field
     * 'szCdSvcAuthDtlAuthType'.
     */
    public void setSzCdSvcAuthDtlAuthType(java.lang.String szCdSvcAuthDtlAuthType)
    {
        this._szCdSvcAuthDtlAuthType = szCdSvcAuthDtlAuthType;
    } //-- void setSzCdSvcAuthDtlAuthType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlPeriod'.
     * 
     * @param szCdSvcAuthDtlPeriod the value of field
     * 'szCdSvcAuthDtlPeriod'.
     */
    public void setSzCdSvcAuthDtlPeriod(java.lang.String szCdSvcAuthDtlPeriod)
    {
        this._szCdSvcAuthDtlPeriod = szCdSvcAuthDtlPeriod;
    } //-- void setSzCdSvcAuthDtlPeriod(java.lang.String) 

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
     * Sets the value of field 'szCdSvcAuthDtlUnitType'.
     * 
     * @param szCdSvcAuthDtlUnitType the value of field
     * 'szCdSvcAuthDtlUnitType'.
     */
    public void setSzCdSvcAuthDtlUnitType(java.lang.String szCdSvcAuthDtlUnitType)
    {
        this._szCdSvcAuthDtlUnitType = szCdSvcAuthDtlUnitType;
    } //-- void setSzCdSvcAuthDtlUnitType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcQlty'.
     * 
     * @param szCdSvcQlty the value of field 'szCdSvcQlty'.
     */
    public void setSzCdSvcQlty(java.lang.String szCdSvcQlty)
    {
        this._szCdSvcQlty = szCdSvcQlty;
    } //-- void setSzCdSvcQlty(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCommentsAdditional'.
     * 
     * @param szTxtCommentsAdditional the value of field
     * 'szTxtCommentsAdditional'.
     */
    public void setSzTxtCommentsAdditional(java.lang.String szTxtCommentsAdditional)
    {
        this._szTxtCommentsAdditional = szTxtCommentsAdditional;
    } //-- void setSzTxtCommentsAdditional(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRefQltyCmnts'.
     * 
     * @param szTxtRefQltyCmnts the value of field
     * 'szTxtRefQltyCmnts'.
     */
    public void setSzTxtRefQltyCmnts(java.lang.String szTxtRefQltyCmnts)
    {
        this._szTxtRefQltyCmnts = szTxtRefQltyCmnts;
    } //-- void setSzTxtRefQltyCmnts(java.lang.String) 

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
     * Sets the value of field 'uNbrSvcAuthDtlFreq'.
     * 
     * @param uNbrSvcAuthDtlFreq the value of field
     * 'uNbrSvcAuthDtlFreq'.
     */
    public void setUNbrSvcAuthDtlFreq(int uNbrSvcAuthDtlFreq)
    {
        this._uNbrSvcAuthDtlFreq = uNbrSvcAuthDtlFreq;
        this._has_uNbrSvcAuthDtlFreq = true;
    } //-- void setUNbrSvcAuthDtlFreq(int) 

    /**
     * Sets the value of field 'ulIdAdopAssistAppl'.
     * 
     * @param ulIdAdopAssistAppl the value of field
     * 'ulIdAdopAssistAppl'.
     */
    public void setUlIdAdopAssistAppl(int ulIdAdopAssistAppl)
    {
        this._ulIdAdopAssistAppl = ulIdAdopAssistAppl;
        this._has_ulIdAdopAssistAppl = true;
    } //-- void setUlIdAdopAssistAppl(int) 

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
     * Sets the value of field 'ulIdSvcAuth'.
     * 
     * @param ulIdSvcAuth the value of field 'ulIdSvcAuth'.
     */
    public void setUlIdSvcAuth(int ulIdSvcAuth)
    {
        this._ulIdSvcAuth = ulIdSvcAuth;
        this._has_ulIdSvcAuth = true;
    } //-- void setUlIdSvcAuth(int) 

    /**
     * Sets the value of field 'ulIdSvcAuthDtl'.
     * 
     * @param ulIdSvcAuthDtl the value of field 'ulIdSvcAuthDtl'.
     */
    public void setUlIdSvcAuthDtl(int ulIdSvcAuthDtl)
    {
        this._ulIdSvcAuthDtl = ulIdSvcAuthDtl;
        this._has_ulIdSvcAuthDtl = true;
    } //-- void setUlIdSvcAuthDtl(int) 

    /**
     * Sets the value of field 'ulNbrSvcAuthDtlLineItm'.
     * 
     * @param ulNbrSvcAuthDtlLineItm the value of field
     * 'ulNbrSvcAuthDtlLineItm'.
     */
    public void setUlNbrSvcAuthDtlLineItm(int ulNbrSvcAuthDtlLineItm)
    {
        this._ulNbrSvcAuthDtlLineItm = ulNbrSvcAuthDtlLineItm;
        this._has_ulNbrSvcAuthDtlLineItm = true;
    } //-- void setUlNbrSvcAuthDtlLineItm(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00 unmarshal(java.io.Reader) 

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
