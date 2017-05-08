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
 * Class CFAD40SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD40SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cIndSpclAsstApprvl
     */
    private java.lang.String _cIndSpclAsstApprvl;

    /**
     * Field _cIndSauConf
     */
    private java.lang.String _cIndSauConf;

    /**
     * Field _sAmtSpclAsstReq
     */
    private double _sAmtSpclAsstReq;

    /**
     * keeps track of state for field: _sAmtSpclAsstReq
     */
    private boolean _has_sAmtSpclAsstReq;

    /**
     * Field _szCdSpclAsstType
     */
    private java.lang.String _szCdSpclAsstType;

    /**
     * Field _szTxtSpclAsstSpecify
     */
    private java.lang.String _szTxtSpclAsstSpecify;

    /**
     * Field _szTxtSpclAsstCmnts
     */
    private java.lang.String _szTxtSpclAsstCmnts;

    /**
     * Field _dtDtRenwlEffBegin
     */
    private org.exolab.castor.types.Date _dtDtRenwlEffBegin;

    /**
     * Field _dtDtRenwlEffEnd
     */
    private org.exolab.castor.types.Date _dtDtRenwlEffEnd;

    /**
     * Field _dtDtAdptSubAgreeRetn
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAgreeRetn;

    /**
     * Field _ulIdAdptSub
     */
    private int _ulIdAdptSub;

    /**
     * keeps track of state for field: _ulIdAdptSub
     */
    private boolean _has_ulIdAdptSub;

    /**
     * Field _dtDtAdptSubLastInvc
     */
    private org.exolab.castor.types.Date _dtDtAdptSubLastInvc;

    /**
     * Field _dtDtAdptSubAgreeSent
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAgreeSent;

    /**
     * Field _dtDtAdptSubAppReturned
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAppReturned;

    /**
     * Field _dtDtAdptSubAppSent
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAppSent;

    /**
     * Field _dtDtAdptSubApprvd
     */
    private org.exolab.castor.types.Date _dtDtAdptSubApprvd;

    /**
     * Field _dtDtAdptSubEffective
     */
    private org.exolab.castor.types.Date _dtDtAdptSubEffective;

    /**
     * Field _dtDtAdptSubEnd
     */
    private org.exolab.castor.types.Date _dtDtAdptSubEnd;

    /**
     * Field _dtDtAdptSubTerm
     */
    private org.exolab.castor.types.Date _dtDtAdptSubTerm;

    /**
     * Field _sAmtAdptSub
     */
    private double _sAmtAdptSub;

    /**
     * keeps track of state for field: _sAmtAdptSub
     */
    private boolean _has_sAmtAdptSub;

    /**
     * Field _szTxtAdptSubRsn
     */
    private java.lang.String _szTxtAdptSubRsn;

    /**
     * Field _szCdAdptSubCloseRsn
     */
    private java.lang.String _szCdAdptSubCloseRsn;

    /**
     * Field _cIndAdptSubThirdParty
     */
    private java.lang.String _cIndAdptSubThirdParty;

    /**
     * Field _cIndSchoolVerified
     */
    private java.lang.String _cIndSchoolVerified;

    /**
     * Field _cIndAdptSubProcess
     */
    private java.lang.String _cIndAdptSubProcess;

    /**
     * Field _szCdAdptSubDeterm
     */
    private java.lang.String _szCdAdptSubDeterm;

    /**
     * Field _szCdPlaymentMthd
     */
    private java.lang.String _szCdPlaymentMthd;

    /**
     * Field _ulIdAdptSubPayee
     */
    private int _ulIdAdptSubPayee;

    /**
     * keeps track of state for field: _ulIdAdptSubPayee
     */
    private boolean _has_ulIdAdptSubPayee;

    /**
     * Field _ulIdSpecialNeedsEvent
     */
    private int _ulIdSpecialNeedsEvent;

    /**
     * keeps track of state for field: _ulIdSpecialNeedsEvent
     */
    private boolean _has_ulIdSpecialNeedsEvent;

    /**
     * Field _szCdAllNonIncidentSSA
     */
    private java.lang.String _szCdAllNonIncidentSSA;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD40SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSAmtAdptSub()
    {
        this._has_sAmtAdptSub= false;
    } //-- void deleteSAmtAdptSub() 

    /**
     */
    public void deleteSAmtSpclAsstReq()
    {
        this._has_sAmtSpclAsstReq= false;
    } //-- void deleteSAmtSpclAsstReq() 

    /**
     */
    public void deleteUlIdAdptSub()
    {
        this._has_ulIdAdptSub= false;
    } //-- void deleteUlIdAdptSub() 

    /**
     */
    public void deleteUlIdAdptSubPayee()
    {
        this._has_ulIdAdptSubPayee= false;
    } //-- void deleteUlIdAdptSubPayee() 

    /**
     */
    public void deleteUlIdSpecialNeedsEvent()
    {
        this._has_ulIdSpecialNeedsEvent= false;
    } //-- void deleteUlIdSpecialNeedsEvent() 

    /**
     * Returns the value of field 'cIndAdptSubProcess'.
     * 
     * @return the value of field 'CIndAdptSubProcess'.
     */
    public java.lang.String getCIndAdptSubProcess()
    {
        return this._cIndAdptSubProcess;
    } //-- java.lang.String getCIndAdptSubProcess() 

    /**
     * Returns the value of field 'cIndAdptSubThirdParty'.
     * 
     * @return the value of field 'CIndAdptSubThirdParty'.
     */
    public java.lang.String getCIndAdptSubThirdParty()
    {
        return this._cIndAdptSubThirdParty;
    } //-- java.lang.String getCIndAdptSubThirdParty() 

    /**
     * Returns the value of field 'cIndSauConf'.
     * 
     * @return the value of field 'CIndSauConf'.
     */
    public java.lang.String getCIndSauConf()
    {
        return this._cIndSauConf;
    } //-- java.lang.String getCIndSauConf() 

    /**
     * Returns the value of field 'cIndSchoolVerified'.
     * 
     * @return the value of field 'CIndSchoolVerified'.
     */
    public java.lang.String getCIndSchoolVerified()
    {
        return this._cIndSchoolVerified;
    } //-- java.lang.String getCIndSchoolVerified() 

    /**
     * Returns the value of field 'cIndSpclAsstApprvl'.
     * 
     * @return the value of field 'CIndSpclAsstApprvl'.
     */
    public java.lang.String getCIndSpclAsstApprvl()
    {
        return this._cIndSpclAsstApprvl;
    } //-- java.lang.String getCIndSpclAsstApprvl() 

    /**
     * Returns the value of field 'dtDtAdptSubAgreeRetn'.
     * 
     * @return the value of field 'DtDtAdptSubAgreeRetn'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAgreeRetn()
    {
        return this._dtDtAdptSubAgreeRetn;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAgreeRetn() 

    /**
     * Returns the value of field 'dtDtAdptSubAgreeSent'.
     * 
     * @return the value of field 'DtDtAdptSubAgreeSent'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAgreeSent()
    {
        return this._dtDtAdptSubAgreeSent;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAgreeSent() 

    /**
     * Returns the value of field 'dtDtAdptSubAppReturned'.
     * 
     * @return the value of field 'DtDtAdptSubAppReturned'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAppReturned()
    {
        return this._dtDtAdptSubAppReturned;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAppReturned() 

    /**
     * Returns the value of field 'dtDtAdptSubAppSent'.
     * 
     * @return the value of field 'DtDtAdptSubAppSent'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAppSent()
    {
        return this._dtDtAdptSubAppSent;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAppSent() 

    /**
     * Returns the value of field 'dtDtAdptSubApprvd'.
     * 
     * @return the value of field 'DtDtAdptSubApprvd'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubApprvd()
    {
        return this._dtDtAdptSubApprvd;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubApprvd() 

    /**
     * Returns the value of field 'dtDtAdptSubEffective'.
     * 
     * @return the value of field 'DtDtAdptSubEffective'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubEffective()
    {
        return this._dtDtAdptSubEffective;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubEffective() 

    /**
     * Returns the value of field 'dtDtAdptSubEnd'.
     * 
     * @return the value of field 'DtDtAdptSubEnd'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubEnd()
    {
        return this._dtDtAdptSubEnd;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubEnd() 

    /**
     * Returns the value of field 'dtDtAdptSubLastInvc'.
     * 
     * @return the value of field 'DtDtAdptSubLastInvc'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubLastInvc()
    {
        return this._dtDtAdptSubLastInvc;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubLastInvc() 

    /**
     * Returns the value of field 'dtDtAdptSubTerm'.
     * 
     * @return the value of field 'DtDtAdptSubTerm'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubTerm()
    {
        return this._dtDtAdptSubTerm;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubTerm() 

    /**
     * Returns the value of field 'dtDtRenwlEffBegin'.
     * 
     * @return the value of field 'DtDtRenwlEffBegin'.
     */
    public org.exolab.castor.types.Date getDtDtRenwlEffBegin()
    {
        return this._dtDtRenwlEffBegin;
    } //-- org.exolab.castor.types.Date getDtDtRenwlEffBegin() 

    /**
     * Returns the value of field 'dtDtRenwlEffEnd'.
     * 
     * @return the value of field 'DtDtRenwlEffEnd'.
     */
    public org.exolab.castor.types.Date getDtDtRenwlEffEnd()
    {
        return this._dtDtRenwlEffEnd;
    } //-- org.exolab.castor.types.Date getDtDtRenwlEffEnd() 

    /**
     * Returns the value of field 'sAmtAdptSub'.
     * 
     * @return the value of field 'SAmtAdptSub'.
     */
    public double getSAmtAdptSub()
    {
        return this._sAmtAdptSub;
    } //-- double getSAmtAdptSub() 

    /**
     * Returns the value of field 'sAmtSpclAsstReq'.
     * 
     * @return the value of field 'SAmtSpclAsstReq'.
     */
    public double getSAmtSpclAsstReq()
    {
        return this._sAmtSpclAsstReq;
    } //-- double getSAmtSpclAsstReq() 

    /**
     * Returns the value of field 'szCdAdptSubCloseRsn'.
     * 
     * @return the value of field 'SzCdAdptSubCloseRsn'.
     */
    public java.lang.String getSzCdAdptSubCloseRsn()
    {
        return this._szCdAdptSubCloseRsn;
    } //-- java.lang.String getSzCdAdptSubCloseRsn() 

    /**
     * Returns the value of field 'szCdAdptSubDeterm'.
     * 
     * @return the value of field 'SzCdAdptSubDeterm'.
     */
    public java.lang.String getSzCdAdptSubDeterm()
    {
        return this._szCdAdptSubDeterm;
    } //-- java.lang.String getSzCdAdptSubDeterm() 

    /**
     * Returns the value of field 'szCdAllNonIncidentSSA'.
     * 
     * @return the value of field 'SzCdAllNonIncidentSSA'.
     */
    public java.lang.String getSzCdAllNonIncidentSSA()
    {
        return this._szCdAllNonIncidentSSA;
    } //-- java.lang.String getSzCdAllNonIncidentSSA() 

    /**
     * Returns the value of field 'szCdPlaymentMthd'.
     * 
     * @return the value of field 'SzCdPlaymentMthd'.
     */
    public java.lang.String getSzCdPlaymentMthd()
    {
        return this._szCdPlaymentMthd;
    } //-- java.lang.String getSzCdPlaymentMthd() 

    /**
     * Returns the value of field 'szCdSpclAsstType'.
     * 
     * @return the value of field 'SzCdSpclAsstType'.
     */
    public java.lang.String getSzCdSpclAsstType()
    {
        return this._szCdSpclAsstType;
    } //-- java.lang.String getSzCdSpclAsstType() 

    /**
     * Returns the value of field 'szTxtAdptSubRsn'.
     * 
     * @return the value of field 'SzTxtAdptSubRsn'.
     */
    public java.lang.String getSzTxtAdptSubRsn()
    {
        return this._szTxtAdptSubRsn;
    } //-- java.lang.String getSzTxtAdptSubRsn() 

    /**
     * Returns the value of field 'szTxtSpclAsstCmnts'.
     * 
     * @return the value of field 'SzTxtSpclAsstCmnts'.
     */
    public java.lang.String getSzTxtSpclAsstCmnts()
    {
        return this._szTxtSpclAsstCmnts;
    } //-- java.lang.String getSzTxtSpclAsstCmnts() 

    /**
     * Returns the value of field 'szTxtSpclAsstSpecify'.
     * 
     * @return the value of field 'SzTxtSpclAsstSpecify'.
     */
    public java.lang.String getSzTxtSpclAsstSpecify()
    {
        return this._szTxtSpclAsstSpecify;
    } //-- java.lang.String getSzTxtSpclAsstSpecify() 

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
     * Returns the value of field 'ulIdAdptSub'.
     * 
     * @return the value of field 'UlIdAdptSub'.
     */
    public int getUlIdAdptSub()
    {
        return this._ulIdAdptSub;
    } //-- int getUlIdAdptSub() 

    /**
     * Returns the value of field 'ulIdAdptSubPayee'.
     * 
     * @return the value of field 'UlIdAdptSubPayee'.
     */
    public int getUlIdAdptSubPayee()
    {
        return this._ulIdAdptSubPayee;
    } //-- int getUlIdAdptSubPayee() 

    /**
     * Returns the value of field 'ulIdSpecialNeedsEvent'.
     * 
     * @return the value of field 'UlIdSpecialNeedsEvent'.
     */
    public int getUlIdSpecialNeedsEvent()
    {
        return this._ulIdSpecialNeedsEvent;
    } //-- int getUlIdSpecialNeedsEvent() 

    /**
     * Method hasSAmtAdptSub
     * 
     * 
     * 
     * @return true if at least one SAmtAdptSub has been added
     */
    public boolean hasSAmtAdptSub()
    {
        return this._has_sAmtAdptSub;
    } //-- boolean hasSAmtAdptSub() 

    /**
     * Method hasSAmtSpclAsstReq
     * 
     * 
     * 
     * @return true if at least one SAmtSpclAsstReq has been added
     */
    public boolean hasSAmtSpclAsstReq()
    {
        return this._has_sAmtSpclAsstReq;
    } //-- boolean hasSAmtSpclAsstReq() 

    /**
     * Method hasUlIdAdptSub
     * 
     * 
     * 
     * @return true if at least one UlIdAdptSub has been added
     */
    public boolean hasUlIdAdptSub()
    {
        return this._has_ulIdAdptSub;
    } //-- boolean hasUlIdAdptSub() 

    /**
     * Method hasUlIdAdptSubPayee
     * 
     * 
     * 
     * @return true if at least one UlIdAdptSubPayee has been added
     */
    public boolean hasUlIdAdptSubPayee()
    {
        return this._has_ulIdAdptSubPayee;
    } //-- boolean hasUlIdAdptSubPayee() 

    /**
     * Method hasUlIdSpecialNeedsEvent
     * 
     * 
     * 
     * @return true if at least one UlIdSpecialNeedsEvent has been
     * added
     */
    public boolean hasUlIdSpecialNeedsEvent()
    {
        return this._has_ulIdSpecialNeedsEvent;
    } //-- boolean hasUlIdSpecialNeedsEvent() 

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
     * Sets the value of field 'cIndAdptSubProcess'.
     * 
     * @param cIndAdptSubProcess the value of field
     * 'cIndAdptSubProcess'.
     */
    public void setCIndAdptSubProcess(java.lang.String cIndAdptSubProcess)
    {
        this._cIndAdptSubProcess = cIndAdptSubProcess;
    } //-- void setCIndAdptSubProcess(java.lang.String) 

    /**
     * Sets the value of field 'cIndAdptSubThirdParty'.
     * 
     * @param cIndAdptSubThirdParty the value of field
     * 'cIndAdptSubThirdParty'.
     */
    public void setCIndAdptSubThirdParty(java.lang.String cIndAdptSubThirdParty)
    {
        this._cIndAdptSubThirdParty = cIndAdptSubThirdParty;
    } //-- void setCIndAdptSubThirdParty(java.lang.String) 

    /**
     * Sets the value of field 'cIndSauConf'.
     * 
     * @param cIndSauConf the value of field 'cIndSauConf'.
     */
    public void setCIndSauConf(java.lang.String cIndSauConf)
    {
        this._cIndSauConf = cIndSauConf;
    } //-- void setCIndSauConf(java.lang.String) 

    /**
     * Sets the value of field 'cIndSchoolVerified'.
     * 
     * @param cIndSchoolVerified the value of field
     * 'cIndSchoolVerified'.
     */
    public void setCIndSchoolVerified(java.lang.String cIndSchoolVerified)
    {
        this._cIndSchoolVerified = cIndSchoolVerified;
    } //-- void setCIndSchoolVerified(java.lang.String) 

    /**
     * Sets the value of field 'cIndSpclAsstApprvl'.
     * 
     * @param cIndSpclAsstApprvl the value of field
     * 'cIndSpclAsstApprvl'.
     */
    public void setCIndSpclAsstApprvl(java.lang.String cIndSpclAsstApprvl)
    {
        this._cIndSpclAsstApprvl = cIndSpclAsstApprvl;
    } //-- void setCIndSpclAsstApprvl(java.lang.String) 

    /**
     * Sets the value of field 'dtDtAdptSubAgreeRetn'.
     * 
     * @param dtDtAdptSubAgreeRetn the value of field
     * 'dtDtAdptSubAgreeRetn'.
     */
    public void setDtDtAdptSubAgreeRetn(org.exolab.castor.types.Date dtDtAdptSubAgreeRetn)
    {
        this._dtDtAdptSubAgreeRetn = dtDtAdptSubAgreeRetn;
    } //-- void setDtDtAdptSubAgreeRetn(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubAgreeSent'.
     * 
     * @param dtDtAdptSubAgreeSent the value of field
     * 'dtDtAdptSubAgreeSent'.
     */
    public void setDtDtAdptSubAgreeSent(org.exolab.castor.types.Date dtDtAdptSubAgreeSent)
    {
        this._dtDtAdptSubAgreeSent = dtDtAdptSubAgreeSent;
    } //-- void setDtDtAdptSubAgreeSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubAppReturned'.
     * 
     * @param dtDtAdptSubAppReturned the value of field
     * 'dtDtAdptSubAppReturned'.
     */
    public void setDtDtAdptSubAppReturned(org.exolab.castor.types.Date dtDtAdptSubAppReturned)
    {
        this._dtDtAdptSubAppReturned = dtDtAdptSubAppReturned;
    } //-- void setDtDtAdptSubAppReturned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubAppSent'.
     * 
     * @param dtDtAdptSubAppSent the value of field
     * 'dtDtAdptSubAppSent'.
     */
    public void setDtDtAdptSubAppSent(org.exolab.castor.types.Date dtDtAdptSubAppSent)
    {
        this._dtDtAdptSubAppSent = dtDtAdptSubAppSent;
    } //-- void setDtDtAdptSubAppSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubApprvd'.
     * 
     * @param dtDtAdptSubApprvd the value of field
     * 'dtDtAdptSubApprvd'.
     */
    public void setDtDtAdptSubApprvd(org.exolab.castor.types.Date dtDtAdptSubApprvd)
    {
        this._dtDtAdptSubApprvd = dtDtAdptSubApprvd;
    } //-- void setDtDtAdptSubApprvd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubEffective'.
     * 
     * @param dtDtAdptSubEffective the value of field
     * 'dtDtAdptSubEffective'.
     */
    public void setDtDtAdptSubEffective(org.exolab.castor.types.Date dtDtAdptSubEffective)
    {
        this._dtDtAdptSubEffective = dtDtAdptSubEffective;
    } //-- void setDtDtAdptSubEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubEnd'.
     * 
     * @param dtDtAdptSubEnd the value of field 'dtDtAdptSubEnd'.
     */
    public void setDtDtAdptSubEnd(org.exolab.castor.types.Date dtDtAdptSubEnd)
    {
        this._dtDtAdptSubEnd = dtDtAdptSubEnd;
    } //-- void setDtDtAdptSubEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubLastInvc'.
     * 
     * @param dtDtAdptSubLastInvc the value of field
     * 'dtDtAdptSubLastInvc'.
     */
    public void setDtDtAdptSubLastInvc(org.exolab.castor.types.Date dtDtAdptSubLastInvc)
    {
        this._dtDtAdptSubLastInvc = dtDtAdptSubLastInvc;
    } //-- void setDtDtAdptSubLastInvc(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubTerm'.
     * 
     * @param dtDtAdptSubTerm the value of field 'dtDtAdptSubTerm'.
     */
    public void setDtDtAdptSubTerm(org.exolab.castor.types.Date dtDtAdptSubTerm)
    {
        this._dtDtAdptSubTerm = dtDtAdptSubTerm;
    } //-- void setDtDtAdptSubTerm(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRenwlEffBegin'.
     * 
     * @param dtDtRenwlEffBegin the value of field
     * 'dtDtRenwlEffBegin'.
     */
    public void setDtDtRenwlEffBegin(org.exolab.castor.types.Date dtDtRenwlEffBegin)
    {
        this._dtDtRenwlEffBegin = dtDtRenwlEffBegin;
    } //-- void setDtDtRenwlEffBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRenwlEffEnd'.
     * 
     * @param dtDtRenwlEffEnd the value of field 'dtDtRenwlEffEnd'.
     */
    public void setDtDtRenwlEffEnd(org.exolab.castor.types.Date dtDtRenwlEffEnd)
    {
        this._dtDtRenwlEffEnd = dtDtRenwlEffEnd;
    } //-- void setDtDtRenwlEffEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'sAmtAdptSub'.
     * 
     * @param sAmtAdptSub the value of field 'sAmtAdptSub'.
     */
    public void setSAmtAdptSub(double sAmtAdptSub)
    {
        this._sAmtAdptSub = sAmtAdptSub;
        this._has_sAmtAdptSub = true;
    } //-- void setSAmtAdptSub(double) 

    /**
     * Sets the value of field 'sAmtSpclAsstReq'.
     * 
     * @param sAmtSpclAsstReq the value of field 'sAmtSpclAsstReq'.
     */
    public void setSAmtSpclAsstReq(double sAmtSpclAsstReq)
    {
        this._sAmtSpclAsstReq = sAmtSpclAsstReq;
        this._has_sAmtSpclAsstReq = true;
    } //-- void setSAmtSpclAsstReq(double) 

    /**
     * Sets the value of field 'szCdAdptSubCloseRsn'.
     * 
     * @param szCdAdptSubCloseRsn the value of field
     * 'szCdAdptSubCloseRsn'.
     */
    public void setSzCdAdptSubCloseRsn(java.lang.String szCdAdptSubCloseRsn)
    {
        this._szCdAdptSubCloseRsn = szCdAdptSubCloseRsn;
    } //-- void setSzCdAdptSubCloseRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdptSubDeterm'.
     * 
     * @param szCdAdptSubDeterm the value of field
     * 'szCdAdptSubDeterm'.
     */
    public void setSzCdAdptSubDeterm(java.lang.String szCdAdptSubDeterm)
    {
        this._szCdAdptSubDeterm = szCdAdptSubDeterm;
    } //-- void setSzCdAdptSubDeterm(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllNonIncidentSSA'.
     * 
     * @param szCdAllNonIncidentSSA the value of field
     * 'szCdAllNonIncidentSSA'.
     */
    public void setSzCdAllNonIncidentSSA(java.lang.String szCdAllNonIncidentSSA)
    {
        this._szCdAllNonIncidentSSA = szCdAllNonIncidentSSA;
    } //-- void setSzCdAllNonIncidentSSA(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlaymentMthd'.
     * 
     * @param szCdPlaymentMthd the value of field 'szCdPlaymentMthd'
     */
    public void setSzCdPlaymentMthd(java.lang.String szCdPlaymentMthd)
    {
        this._szCdPlaymentMthd = szCdPlaymentMthd;
    } //-- void setSzCdPlaymentMthd(java.lang.String) 

    /**
     * Sets the value of field 'szCdSpclAsstType'.
     * 
     * @param szCdSpclAsstType the value of field 'szCdSpclAsstType'
     */
    public void setSzCdSpclAsstType(java.lang.String szCdSpclAsstType)
    {
        this._szCdSpclAsstType = szCdSpclAsstType;
    } //-- void setSzCdSpclAsstType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtAdptSubRsn'.
     * 
     * @param szTxtAdptSubRsn the value of field 'szTxtAdptSubRsn'.
     */
    public void setSzTxtAdptSubRsn(java.lang.String szTxtAdptSubRsn)
    {
        this._szTxtAdptSubRsn = szTxtAdptSubRsn;
    } //-- void setSzTxtAdptSubRsn(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSpclAsstCmnts'.
     * 
     * @param szTxtSpclAsstCmnts the value of field
     * 'szTxtSpclAsstCmnts'.
     */
    public void setSzTxtSpclAsstCmnts(java.lang.String szTxtSpclAsstCmnts)
    {
        this._szTxtSpclAsstCmnts = szTxtSpclAsstCmnts;
    } //-- void setSzTxtSpclAsstCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSpclAsstSpecify'.
     * 
     * @param szTxtSpclAsstSpecify the value of field
     * 'szTxtSpclAsstSpecify'.
     */
    public void setSzTxtSpclAsstSpecify(java.lang.String szTxtSpclAsstSpecify)
    {
        this._szTxtSpclAsstSpecify = szTxtSpclAsstSpecify;
    } //-- void setSzTxtSpclAsstSpecify(java.lang.String) 

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
     * Sets the value of field 'ulIdAdptSub'.
     * 
     * @param ulIdAdptSub the value of field 'ulIdAdptSub'.
     */
    public void setUlIdAdptSub(int ulIdAdptSub)
    {
        this._ulIdAdptSub = ulIdAdptSub;
        this._has_ulIdAdptSub = true;
    } //-- void setUlIdAdptSub(int) 

    /**
     * Sets the value of field 'ulIdAdptSubPayee'.
     * 
     * @param ulIdAdptSubPayee the value of field 'ulIdAdptSubPayee'
     */
    public void setUlIdAdptSubPayee(int ulIdAdptSubPayee)
    {
        this._ulIdAdptSubPayee = ulIdAdptSubPayee;
        this._has_ulIdAdptSubPayee = true;
    } //-- void setUlIdAdptSubPayee(int) 

    /**
     * Sets the value of field 'ulIdSpecialNeedsEvent'.
     * 
     * @param ulIdSpecialNeedsEvent the value of field
     * 'ulIdSpecialNeedsEvent'.
     */
    public void setUlIdSpecialNeedsEvent(int ulIdSpecialNeedsEvent)
    {
        this._ulIdSpecialNeedsEvent = ulIdSpecialNeedsEvent;
        this._has_ulIdSpecialNeedsEvent = true;
    } //-- void setUlIdSpecialNeedsEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00 unmarshal(java.io.Reader) 

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
