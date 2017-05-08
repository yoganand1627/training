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
 * Class ROWCSUB38SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB38SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdLegalActEvent
     */
    private int _ulIdLegalActEvent;

    /**
     * keeps track of state for field: _ulIdLegalActEvent
     */
    private boolean _has_ulIdLegalActEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdLegalActAction
     */
    private java.lang.String _szCdLegalActAction;

    /**
     * Field _szCdLegalActActnSubtype
     */
    private java.lang.String _szCdLegalActActnSubtype;

    /**
     * Field _szCdLegalActOutcome
     */
    private java.lang.String _szCdLegalActOutcome;

    /**
     * Field _dtDtLegalActDateFiled
     */
    private org.exolab.castor.types.Date _dtDtLegalActDateFiled;

    /**
     * Field _dtDtLegalActOutcomeDt
     */
    private org.exolab.castor.types.Date _dtDtLegalActOutcomeDt;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _cIndLegalActDocsNCase
     */
    private java.lang.String _cIndLegalActDocsNCase;

    /**
     * Field _szTxtLegalActComment
     */
    private java.lang.String _szTxtLegalActComment;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _dtCrtActDate
     */
    private org.exolab.castor.types.Date _dtCrtActDate;

    /**
     * Field _szCdHrTypCrtOrd
     */
    private java.lang.String _szCdHrTypCrtOrd;

    /**
     * Field _ulNbrCrtFile
     */
    private int _ulNbrCrtFile;

    /**
     * keeps track of state for field: _ulNbrCrtFile
     */
    private boolean _has_ulNbrCrtFile;

    /**
     * Field _szCdCrtCaseNbr
     */
    private java.lang.String _szCdCrtCaseNbr;

    /**
     * Field _szCdCrtType
     */
    private java.lang.String _szCdCrtType;

    /**
     * Field _dtNxtHearDate
     */
    private org.exolab.castor.types.Date _dtNxtHearDate;

    /**
     * Field _dtContinDate
     */
    private org.exolab.castor.types.Date _dtContinDate;

    /**
     * Field _dtCrtOrdDate
     */
    private org.exolab.castor.types.Date _dtCrtOrdDate;

    /**
     * Field _dtPubDate
     */
    private org.exolab.castor.types.Date _dtPubDate;

    /**
     * Field _indComplete
     */
    private java.lang.String _indComplete;

    /**
     * Field _indUpPrevAct
     */
    private java.lang.String _indUpPrevAct;

    /**
     * Field _szCdState
     */
    private java.lang.String _szCdState;

    /**
     * Field _tsDtShelterCareAuth
     */
    private java.util.Date _tsDtShelterCareAuth;

    /**
     * Field _nmCrtOrdPrepBy
     */
    private java.lang.String _nmCrtOrdPrepBy;

    /**
     * Field _indCrtOrdSigned
     */
    private java.lang.String _indCrtOrdSigned;

    /**
     * Field _indAmendment
     */
    private java.lang.String _indAmendment;

    /**
     * Field _bIndNoRepAppointed
     */
    private java.lang.String _bIndNoRepAppointed;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB38SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdLegalActEvent()
    {
        this._has_ulIdLegalActEvent= false;
    } //-- void deleteUlIdLegalActEvent() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlNbrCrtFile()
    {
        this._has_ulNbrCrtFile= false;
    } //-- void deleteUlNbrCrtFile() 

    /**
     * Returns the value of field 'bIndNoRepAppointed'.
     * 
     * @return the value of field 'BIndNoRepAppointed'.
     */
    public java.lang.String getBIndNoRepAppointed()
    {
        return this._bIndNoRepAppointed;
    } //-- java.lang.String getBIndNoRepAppointed() 

    /**
     * Returns the value of field 'cIndLegalActDocsNCase'.
     * 
     * @return the value of field 'CIndLegalActDocsNCase'.
     */
    public java.lang.String getCIndLegalActDocsNCase()
    {
        return this._cIndLegalActDocsNCase;
    } //-- java.lang.String getCIndLegalActDocsNCase() 

    /**
     * Returns the value of field 'dtContinDate'.
     * 
     * @return the value of field 'DtContinDate'.
     */
    public org.exolab.castor.types.Date getDtContinDate()
    {
        return this._dtContinDate;
    } //-- org.exolab.castor.types.Date getDtContinDate() 

    /**
     * Returns the value of field 'dtCrtActDate'.
     * 
     * @return the value of field 'DtCrtActDate'.
     */
    public org.exolab.castor.types.Date getDtCrtActDate()
    {
        return this._dtCrtActDate;
    } //-- org.exolab.castor.types.Date getDtCrtActDate() 

    /**
     * Returns the value of field 'dtCrtOrdDate'.
     * 
     * @return the value of field 'DtCrtOrdDate'.
     */
    public org.exolab.castor.types.Date getDtCrtOrdDate()
    {
        return this._dtCrtOrdDate;
    } //-- org.exolab.castor.types.Date getDtCrtOrdDate() 

    /**
     * Returns the value of field 'dtDtLegalActDateFiled'.
     * 
     * @return the value of field 'DtDtLegalActDateFiled'.
     */
    public org.exolab.castor.types.Date getDtDtLegalActDateFiled()
    {
        return this._dtDtLegalActDateFiled;
    } //-- org.exolab.castor.types.Date getDtDtLegalActDateFiled() 

    /**
     * Returns the value of field 'dtDtLegalActOutcomeDt'.
     * 
     * @return the value of field 'DtDtLegalActOutcomeDt'.
     */
    public org.exolab.castor.types.Date getDtDtLegalActOutcomeDt()
    {
        return this._dtDtLegalActOutcomeDt;
    } //-- org.exolab.castor.types.Date getDtDtLegalActOutcomeDt() 

    /**
     * Returns the value of field 'dtNxtHearDate'.
     * 
     * @return the value of field 'DtNxtHearDate'.
     */
    public org.exolab.castor.types.Date getDtNxtHearDate()
    {
        return this._dtNxtHearDate;
    } //-- org.exolab.castor.types.Date getDtNxtHearDate() 

    /**
     * Returns the value of field 'dtPubDate'.
     * 
     * @return the value of field 'DtPubDate'.
     */
    public org.exolab.castor.types.Date getDtPubDate()
    {
        return this._dtPubDate;
    } //-- org.exolab.castor.types.Date getDtPubDate() 

    /**
     * Returns the value of field 'indAmendment'.
     * 
     * @return the value of field 'IndAmendment'.
     */
    public java.lang.String getIndAmendment()
    {
        return this._indAmendment;
    } //-- java.lang.String getIndAmendment() 

    /**
     * Returns the value of field 'indComplete'.
     * 
     * @return the value of field 'IndComplete'.
     */
    public java.lang.String getIndComplete()
    {
        return this._indComplete;
    } //-- java.lang.String getIndComplete() 

    /**
     * Returns the value of field 'indCrtOrdSigned'.
     * 
     * @return the value of field 'IndCrtOrdSigned'.
     */
    public java.lang.String getIndCrtOrdSigned()
    {
        return this._indCrtOrdSigned;
    } //-- java.lang.String getIndCrtOrdSigned() 

    /**
     * Returns the value of field 'indUpPrevAct'.
     * 
     * @return the value of field 'IndUpPrevAct'.
     */
    public java.lang.String getIndUpPrevAct()
    {
        return this._indUpPrevAct;
    } //-- java.lang.String getIndUpPrevAct() 

    /**
     * Returns the value of field 'nmCrtOrdPrepBy'.
     * 
     * @return the value of field 'NmCrtOrdPrepBy'.
     */
    public java.lang.String getNmCrtOrdPrepBy()
    {
        return this._nmCrtOrdPrepBy;
    } //-- java.lang.String getNmCrtOrdPrepBy() 

    /**
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdCrtCaseNbr'.
     * 
     * @return the value of field 'SzCdCrtCaseNbr'.
     */
    public java.lang.String getSzCdCrtCaseNbr()
    {
        return this._szCdCrtCaseNbr;
    } //-- java.lang.String getSzCdCrtCaseNbr() 

    /**
     * Returns the value of field 'szCdCrtType'.
     * 
     * @return the value of field 'SzCdCrtType'.
     */
    public java.lang.String getSzCdCrtType()
    {
        return this._szCdCrtType;
    } //-- java.lang.String getSzCdCrtType() 

    /**
     * Returns the value of field 'szCdHrTypCrtOrd'.
     * 
     * @return the value of field 'SzCdHrTypCrtOrd'.
     */
    public java.lang.String getSzCdHrTypCrtOrd()
    {
        return this._szCdHrTypCrtOrd;
    } //-- java.lang.String getSzCdHrTypCrtOrd() 

    /**
     * Returns the value of field 'szCdLegalActAction'.
     * 
     * @return the value of field 'SzCdLegalActAction'.
     */
    public java.lang.String getSzCdLegalActAction()
    {
        return this._szCdLegalActAction;
    } //-- java.lang.String getSzCdLegalActAction() 

    /**
     * Returns the value of field 'szCdLegalActActnSubtype'.
     * 
     * @return the value of field 'SzCdLegalActActnSubtype'.
     */
    public java.lang.String getSzCdLegalActActnSubtype()
    {
        return this._szCdLegalActActnSubtype;
    } //-- java.lang.String getSzCdLegalActActnSubtype() 

    /**
     * Returns the value of field 'szCdLegalActOutcome'.
     * 
     * @return the value of field 'SzCdLegalActOutcome'.
     */
    public java.lang.String getSzCdLegalActOutcome()
    {
        return this._szCdLegalActOutcome;
    } //-- java.lang.String getSzCdLegalActOutcome() 

    /**
     * Returns the value of field 'szCdState'.
     * 
     * @return the value of field 'SzCdState'.
     */
    public java.lang.String getSzCdState()
    {
        return this._szCdState;
    } //-- java.lang.String getSzCdState() 

    /**
     * Returns the value of field 'szTxtLegalActComment'.
     * 
     * @return the value of field 'SzTxtLegalActComment'.
     */
    public java.lang.String getSzTxtLegalActComment()
    {
        return this._szTxtLegalActComment;
    } //-- java.lang.String getSzTxtLegalActComment() 

    /**
     * Returns the value of field 'tsDtShelterCareAuth'.
     * 
     * @return the value of field 'TsDtShelterCareAuth'.
     */
    public java.util.Date getTsDtShelterCareAuth()
    {
        return this._tsDtShelterCareAuth;
    } //-- java.util.Date getTsDtShelterCareAuth() 

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
     * Returns the value of field 'ulIdLegalActEvent'.
     * 
     * @return the value of field 'UlIdLegalActEvent'.
     */
    public int getUlIdLegalActEvent()
    {
        return this._ulIdLegalActEvent;
    } //-- int getUlIdLegalActEvent() 

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
     * Returns the value of field 'ulNbrCrtFile'.
     * 
     * @return the value of field 'UlNbrCrtFile'.
     */
    public int getUlNbrCrtFile()
    {
        return this._ulNbrCrtFile;
    } //-- int getUlNbrCrtFile() 

    /**
     * Method hasUlIdLegalActEvent
     * 
     * 
     * 
     * @return true if at least one UlIdLegalActEvent has been added
     */
    public boolean hasUlIdLegalActEvent()
    {
        return this._has_ulIdLegalActEvent;
    } //-- boolean hasUlIdLegalActEvent() 

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
     * Method hasUlNbrCrtFile
     * 
     * 
     * 
     * @return true if at least one UlNbrCrtFile has been added
     */
    public boolean hasUlNbrCrtFile()
    {
        return this._has_ulNbrCrtFile;
    } //-- boolean hasUlNbrCrtFile() 

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
     * Sets the value of field 'bIndNoRepAppointed'.
     * 
     * @param bIndNoRepAppointed the value of field
     * 'bIndNoRepAppointed'.
     */
    public void setBIndNoRepAppointed(java.lang.String bIndNoRepAppointed)
    {
        this._bIndNoRepAppointed = bIndNoRepAppointed;
    } //-- void setBIndNoRepAppointed(java.lang.String) 

    /**
     * Sets the value of field 'cIndLegalActDocsNCase'.
     * 
     * @param cIndLegalActDocsNCase the value of field
     * 'cIndLegalActDocsNCase'.
     */
    public void setCIndLegalActDocsNCase(java.lang.String cIndLegalActDocsNCase)
    {
        this._cIndLegalActDocsNCase = cIndLegalActDocsNCase;
    } //-- void setCIndLegalActDocsNCase(java.lang.String) 

    /**
     * Sets the value of field 'dtContinDate'.
     * 
     * @param dtContinDate the value of field 'dtContinDate'.
     */
    public void setDtContinDate(org.exolab.castor.types.Date dtContinDate)
    {
        this._dtContinDate = dtContinDate;
    } //-- void setDtContinDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtCrtActDate'.
     * 
     * @param dtCrtActDate the value of field 'dtCrtActDate'.
     */
    public void setDtCrtActDate(org.exolab.castor.types.Date dtCrtActDate)
    {
        this._dtCrtActDate = dtCrtActDate;
    } //-- void setDtCrtActDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtCrtOrdDate'.
     * 
     * @param dtCrtOrdDate the value of field 'dtCrtOrdDate'.
     */
    public void setDtCrtOrdDate(org.exolab.castor.types.Date dtCrtOrdDate)
    {
        this._dtCrtOrdDate = dtCrtOrdDate;
    } //-- void setDtCrtOrdDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegalActDateFiled'.
     * 
     * @param dtDtLegalActDateFiled the value of field
     * 'dtDtLegalActDateFiled'.
     */
    public void setDtDtLegalActDateFiled(org.exolab.castor.types.Date dtDtLegalActDateFiled)
    {
        this._dtDtLegalActDateFiled = dtDtLegalActDateFiled;
    } //-- void setDtDtLegalActDateFiled(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegalActOutcomeDt'.
     * 
     * @param dtDtLegalActOutcomeDt the value of field
     * 'dtDtLegalActOutcomeDt'.
     */
    public void setDtDtLegalActOutcomeDt(org.exolab.castor.types.Date dtDtLegalActOutcomeDt)
    {
        this._dtDtLegalActOutcomeDt = dtDtLegalActOutcomeDt;
    } //-- void setDtDtLegalActOutcomeDt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtNxtHearDate'.
     * 
     * @param dtNxtHearDate the value of field 'dtNxtHearDate'.
     */
    public void setDtNxtHearDate(org.exolab.castor.types.Date dtNxtHearDate)
    {
        this._dtNxtHearDate = dtNxtHearDate;
    } //-- void setDtNxtHearDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtPubDate'.
     * 
     * @param dtPubDate the value of field 'dtPubDate'.
     */
    public void setDtPubDate(org.exolab.castor.types.Date dtPubDate)
    {
        this._dtPubDate = dtPubDate;
    } //-- void setDtPubDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indAmendment'.
     * 
     * @param indAmendment the value of field 'indAmendment'.
     */
    public void setIndAmendment(java.lang.String indAmendment)
    {
        this._indAmendment = indAmendment;
    } //-- void setIndAmendment(java.lang.String) 

    /**
     * Sets the value of field 'indComplete'.
     * 
     * @param indComplete the value of field 'indComplete'.
     */
    public void setIndComplete(java.lang.String indComplete)
    {
        this._indComplete = indComplete;
    } //-- void setIndComplete(java.lang.String) 

    /**
     * Sets the value of field 'indCrtOrdSigned'.
     * 
     * @param indCrtOrdSigned the value of field 'indCrtOrdSigned'.
     */
    public void setIndCrtOrdSigned(java.lang.String indCrtOrdSigned)
    {
        this._indCrtOrdSigned = indCrtOrdSigned;
    } //-- void setIndCrtOrdSigned(java.lang.String) 

    /**
     * Sets the value of field 'indUpPrevAct'.
     * 
     * @param indUpPrevAct the value of field 'indUpPrevAct'.
     */
    public void setIndUpPrevAct(java.lang.String indUpPrevAct)
    {
        this._indUpPrevAct = indUpPrevAct;
    } //-- void setIndUpPrevAct(java.lang.String) 

    /**
     * Sets the value of field 'nmCrtOrdPrepBy'.
     * 
     * @param nmCrtOrdPrepBy the value of field 'nmCrtOrdPrepBy'.
     */
    public void setNmCrtOrdPrepBy(java.lang.String nmCrtOrdPrepBy)
    {
        this._nmCrtOrdPrepBy = nmCrtOrdPrepBy;
    } //-- void setNmCrtOrdPrepBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdCrtCaseNbr'.
     * 
     * @param szCdCrtCaseNbr the value of field 'szCdCrtCaseNbr'.
     */
    public void setSzCdCrtCaseNbr(java.lang.String szCdCrtCaseNbr)
    {
        this._szCdCrtCaseNbr = szCdCrtCaseNbr;
    } //-- void setSzCdCrtCaseNbr(java.lang.String) 

    /**
     * Sets the value of field 'szCdCrtType'.
     * 
     * @param szCdCrtType the value of field 'szCdCrtType'.
     */
    public void setSzCdCrtType(java.lang.String szCdCrtType)
    {
        this._szCdCrtType = szCdCrtType;
    } //-- void setSzCdCrtType(java.lang.String) 

    /**
     * Sets the value of field 'szCdHrTypCrtOrd'.
     * 
     * @param szCdHrTypCrtOrd the value of field 'szCdHrTypCrtOrd'.
     */
    public void setSzCdHrTypCrtOrd(java.lang.String szCdHrTypCrtOrd)
    {
        this._szCdHrTypCrtOrd = szCdHrTypCrtOrd;
    } //-- void setSzCdHrTypCrtOrd(java.lang.String) 

    /**
     * Sets the value of field 'szCdLegalActAction'.
     * 
     * @param szCdLegalActAction the value of field
     * 'szCdLegalActAction'.
     */
    public void setSzCdLegalActAction(java.lang.String szCdLegalActAction)
    {
        this._szCdLegalActAction = szCdLegalActAction;
    } //-- void setSzCdLegalActAction(java.lang.String) 

    /**
     * Sets the value of field 'szCdLegalActActnSubtype'.
     * 
     * @param szCdLegalActActnSubtype the value of field
     * 'szCdLegalActActnSubtype'.
     */
    public void setSzCdLegalActActnSubtype(java.lang.String szCdLegalActActnSubtype)
    {
        this._szCdLegalActActnSubtype = szCdLegalActActnSubtype;
    } //-- void setSzCdLegalActActnSubtype(java.lang.String) 

    /**
     * Sets the value of field 'szCdLegalActOutcome'.
     * 
     * @param szCdLegalActOutcome the value of field
     * 'szCdLegalActOutcome'.
     */
    public void setSzCdLegalActOutcome(java.lang.String szCdLegalActOutcome)
    {
        this._szCdLegalActOutcome = szCdLegalActOutcome;
    } //-- void setSzCdLegalActOutcome(java.lang.String) 

    /**
     * Sets the value of field 'szCdState'.
     * 
     * @param szCdState the value of field 'szCdState'.
     */
    public void setSzCdState(java.lang.String szCdState)
    {
        this._szCdState = szCdState;
    } //-- void setSzCdState(java.lang.String) 

    /**
     * Sets the value of field 'szTxtLegalActComment'.
     * 
     * @param szTxtLegalActComment the value of field
     * 'szTxtLegalActComment'.
     */
    public void setSzTxtLegalActComment(java.lang.String szTxtLegalActComment)
    {
        this._szTxtLegalActComment = szTxtLegalActComment;
    } //-- void setSzTxtLegalActComment(java.lang.String) 

    /**
     * Sets the value of field 'tsDtShelterCareAuth'.
     * 
     * @param tsDtShelterCareAuth the value of field
     * 'tsDtShelterCareAuth'.
     */
    public void setTsDtShelterCareAuth(java.util.Date tsDtShelterCareAuth)
    {
        this._tsDtShelterCareAuth = tsDtShelterCareAuth;
    } //-- void setTsDtShelterCareAuth(java.util.Date) 

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
     * Sets the value of field 'ulIdLegalActEvent'.
     * 
     * @param ulIdLegalActEvent the value of field
     * 'ulIdLegalActEvent'.
     */
    public void setUlIdLegalActEvent(int ulIdLegalActEvent)
    {
        this._ulIdLegalActEvent = ulIdLegalActEvent;
        this._has_ulIdLegalActEvent = true;
    } //-- void setUlIdLegalActEvent(int) 

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
     * Sets the value of field 'ulNbrCrtFile'.
     * 
     * @param ulNbrCrtFile the value of field 'ulNbrCrtFile'.
     */
    public void setUlNbrCrtFile(int ulNbrCrtFile)
    {
        this._ulNbrCrtFile = ulNbrCrtFile;
        this._has_ulNbrCrtFile = true;
    } //-- void setUlNbrCrtFile(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01 unmarshal(java.io.Reader) 

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
