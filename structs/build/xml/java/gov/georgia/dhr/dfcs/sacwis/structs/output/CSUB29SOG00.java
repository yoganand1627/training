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
 * Class CSUB29SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB29SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szAddrPptCity
     */
    private java.lang.String _szAddrPptCity;

    /**
     * Field _szAddrPptCnty
     */
    private java.lang.String _szAddrPptCnty;

    /**
     * Field _szAddrPptStLn1
     */
    private java.lang.String _szAddrPptStLn1;

    /**
     * Field _szAddrPptStLn2
     */
    private java.lang.String _szAddrPptStLn2;

    /**
     * Field _szAddrPptState
     */
    private java.lang.String _szAddrPptState;

    /**
     * Field _szAddrPptZip
     */
    private java.lang.String _szAddrPptZip;

    /**
     * Field _dtDtPptDate
     */
    private org.exolab.castor.types.Date _dtDtPptDate;

    /**
     * Field _tmScrTmPptTime
     */
    private java.lang.String _tmScrTmPptTime;

    /**
     * Field _dtDtPptDocComp
     */
    private org.exolab.castor.types.Date _dtDtPptDocComp;

    /**
     * Field _ulIdPptEvent
     */
    private int _ulIdPptEvent;

    /**
     * keeps track of state for field: _ulIdPptEvent
     */
    private boolean _has_ulIdPptEvent;

    /**
     * Field _szNbrPptPhone
     */
    private java.lang.String _szNbrPptPhone;

    /**
     * Field _lNbrPptPhoneExt
     */
    private java.lang.String _lNbrPptPhoneExt;

    /**
     * Field _tmTmPptTime
     */
    private java.lang.String _tmTmPptTime;

    /**
     * Field _szTxtPptAddrCmnt
     */
    private java.lang.String _szTxtPptAddrCmnt;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szMeetingType
     */
    private java.lang.String _szMeetingType;

    /**
     * Field _dtDateHearingReq
     */
    private org.exolab.castor.types.Date _dtDateHearingReq;

    /**
     * Field _dtOutcomeDiscussed
     */
    private org.exolab.castor.types.Date _dtOutcomeDiscussed;

    /**
     * Field _bIndAssistNeeded
     */
    private java.lang.String _bIndAssistNeeded;

    /**
     * Field _dtUtilBeginDate
     */
    private org.exolab.castor.types.Date _dtUtilBeginDate;

    /**
     * Field _dtUtilEndDate
     */
    private org.exolab.castor.types.Date _dtUtilEndDate;

    /**
     * Field _dtDatePrepIntvw
     */
    private org.exolab.castor.types.Date _dtDatePrepIntvw;

    /**
     * Field _dtPermRepComp
     */
    private org.exolab.castor.types.Date _dtPermRepComp;

    /**
     * Field _bIndPermanency
     */
    private java.lang.String _bIndPermanency;

    /**
     * Field _bIndPrevReqMet
     */
    private java.lang.String _bIndPrevReqMet;

    /**
     * Field _bIndSafety
     */
    private java.lang.String _bIndSafety;

    /**
     * Field _bIndWellbeing
     */
    private java.lang.String _bIndWellbeing;

    /**
     * Field _bIndTranPlanComp
     */
    private java.lang.String _bIndTranPlanComp;

    /**
     * Field _ulIdContactStdsEvent
     */
    private int _ulIdContactStdsEvent;

    /**
     * keeps track of state for field: _ulIdContactStdsEvent
     */
    private boolean _has_ulIdContactStdsEvent;

    /**
     * Field _szApprovalStatus
     */
    private java.lang.String _szApprovalStatus;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB29SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdContactStdsEvent()
    {
        this._has_ulIdContactStdsEvent= false;
    } //-- void deleteUlIdContactStdsEvent() 

    /**
     */
    public void deleteUlIdPptEvent()
    {
        this._has_ulIdPptEvent= false;
    } //-- void deleteUlIdPptEvent() 

    /**
     * Returns the value of field 'bIndAssistNeeded'.
     * 
     * @return the value of field 'BIndAssistNeeded'.
     */
    public java.lang.String getBIndAssistNeeded()
    {
        return this._bIndAssistNeeded;
    } //-- java.lang.String getBIndAssistNeeded() 

    /**
     * Returns the value of field 'bIndPermanency'.
     * 
     * @return the value of field 'BIndPermanency'.
     */
    public java.lang.String getBIndPermanency()
    {
        return this._bIndPermanency;
    } //-- java.lang.String getBIndPermanency() 

    /**
     * Returns the value of field 'bIndPrevReqMet'.
     * 
     * @return the value of field 'BIndPrevReqMet'.
     */
    public java.lang.String getBIndPrevReqMet()
    {
        return this._bIndPrevReqMet;
    } //-- java.lang.String getBIndPrevReqMet() 

    /**
     * Returns the value of field 'bIndSafety'.
     * 
     * @return the value of field 'BIndSafety'.
     */
    public java.lang.String getBIndSafety()
    {
        return this._bIndSafety;
    } //-- java.lang.String getBIndSafety() 

    /**
     * Returns the value of field 'bIndTranPlanComp'.
     * 
     * @return the value of field 'BIndTranPlanComp'.
     */
    public java.lang.String getBIndTranPlanComp()
    {
        return this._bIndTranPlanComp;
    } //-- java.lang.String getBIndTranPlanComp() 

    /**
     * Returns the value of field 'bIndWellbeing'.
     * 
     * @return the value of field 'BIndWellbeing'.
     */
    public java.lang.String getBIndWellbeing()
    {
        return this._bIndWellbeing;
    } //-- java.lang.String getBIndWellbeing() 

    /**
     * Returns the value of field 'dtDateHearingReq'.
     * 
     * @return the value of field 'DtDateHearingReq'.
     */
    public org.exolab.castor.types.Date getDtDateHearingReq()
    {
        return this._dtDateHearingReq;
    } //-- org.exolab.castor.types.Date getDtDateHearingReq() 

    /**
     * Returns the value of field 'dtDatePrepIntvw'.
     * 
     * @return the value of field 'DtDatePrepIntvw'.
     */
    public org.exolab.castor.types.Date getDtDatePrepIntvw()
    {
        return this._dtDatePrepIntvw;
    } //-- org.exolab.castor.types.Date getDtDatePrepIntvw() 

    /**
     * Returns the value of field 'dtDtPptDate'.
     * 
     * @return the value of field 'DtDtPptDate'.
     */
    public org.exolab.castor.types.Date getDtDtPptDate()
    {
        return this._dtDtPptDate;
    } //-- org.exolab.castor.types.Date getDtDtPptDate() 

    /**
     * Returns the value of field 'dtDtPptDocComp'.
     * 
     * @return the value of field 'DtDtPptDocComp'.
     */
    public org.exolab.castor.types.Date getDtDtPptDocComp()
    {
        return this._dtDtPptDocComp;
    } //-- org.exolab.castor.types.Date getDtDtPptDocComp() 

    /**
     * Returns the value of field 'dtOutcomeDiscussed'.
     * 
     * @return the value of field 'DtOutcomeDiscussed'.
     */
    public org.exolab.castor.types.Date getDtOutcomeDiscussed()
    {
        return this._dtOutcomeDiscussed;
    } //-- org.exolab.castor.types.Date getDtOutcomeDiscussed() 

    /**
     * Returns the value of field 'dtPermRepComp'.
     * 
     * @return the value of field 'DtPermRepComp'.
     */
    public org.exolab.castor.types.Date getDtPermRepComp()
    {
        return this._dtPermRepComp;
    } //-- org.exolab.castor.types.Date getDtPermRepComp() 

    /**
     * Returns the value of field 'dtUtilBeginDate'.
     * 
     * @return the value of field 'DtUtilBeginDate'.
     */
    public org.exolab.castor.types.Date getDtUtilBeginDate()
    {
        return this._dtUtilBeginDate;
    } //-- org.exolab.castor.types.Date getDtUtilBeginDate() 

    /**
     * Returns the value of field 'dtUtilEndDate'.
     * 
     * @return the value of field 'DtUtilEndDate'.
     */
    public org.exolab.castor.types.Date getDtUtilEndDate()
    {
        return this._dtUtilEndDate;
    } //-- org.exolab.castor.types.Date getDtUtilEndDate() 

    /**
     * Returns the value of field 'lNbrPptPhoneExt'.
     * 
     * @return the value of field 'LNbrPptPhoneExt'.
     */
    public java.lang.String getLNbrPptPhoneExt()
    {
        return this._lNbrPptPhoneExt;
    } //-- java.lang.String getLNbrPptPhoneExt() 

    /**
     * Returns the value of field 'szAddrPptCity'.
     * 
     * @return the value of field 'SzAddrPptCity'.
     */
    public java.lang.String getSzAddrPptCity()
    {
        return this._szAddrPptCity;
    } //-- java.lang.String getSzAddrPptCity() 

    /**
     * Returns the value of field 'szAddrPptCnty'.
     * 
     * @return the value of field 'SzAddrPptCnty'.
     */
    public java.lang.String getSzAddrPptCnty()
    {
        return this._szAddrPptCnty;
    } //-- java.lang.String getSzAddrPptCnty() 

    /**
     * Returns the value of field 'szAddrPptStLn1'.
     * 
     * @return the value of field 'SzAddrPptStLn1'.
     */
    public java.lang.String getSzAddrPptStLn1()
    {
        return this._szAddrPptStLn1;
    } //-- java.lang.String getSzAddrPptStLn1() 

    /**
     * Returns the value of field 'szAddrPptStLn2'.
     * 
     * @return the value of field 'SzAddrPptStLn2'.
     */
    public java.lang.String getSzAddrPptStLn2()
    {
        return this._szAddrPptStLn2;
    } //-- java.lang.String getSzAddrPptStLn2() 

    /**
     * Returns the value of field 'szAddrPptState'.
     * 
     * @return the value of field 'SzAddrPptState'.
     */
    public java.lang.String getSzAddrPptState()
    {
        return this._szAddrPptState;
    } //-- java.lang.String getSzAddrPptState() 

    /**
     * Returns the value of field 'szAddrPptZip'.
     * 
     * @return the value of field 'SzAddrPptZip'.
     */
    public java.lang.String getSzAddrPptZip()
    {
        return this._szAddrPptZip;
    } //-- java.lang.String getSzAddrPptZip() 

    /**
     * Returns the value of field 'szApprovalStatus'.
     * 
     * @return the value of field 'SzApprovalStatus'.
     */
    public java.lang.String getSzApprovalStatus()
    {
        return this._szApprovalStatus;
    } //-- java.lang.String getSzApprovalStatus() 

    /**
     * Returns the value of field 'szMeetingType'.
     * 
     * @return the value of field 'SzMeetingType'.
     */
    public java.lang.String getSzMeetingType()
    {
        return this._szMeetingType;
    } //-- java.lang.String getSzMeetingType() 

    /**
     * Returns the value of field 'szNbrPptPhone'.
     * 
     * @return the value of field 'SzNbrPptPhone'.
     */
    public java.lang.String getSzNbrPptPhone()
    {
        return this._szNbrPptPhone;
    } //-- java.lang.String getSzNbrPptPhone() 

    /**
     * Returns the value of field 'szTxtPptAddrCmnt'.
     * 
     * @return the value of field 'SzTxtPptAddrCmnt'.
     */
    public java.lang.String getSzTxtPptAddrCmnt()
    {
        return this._szTxtPptAddrCmnt;
    } //-- java.lang.String getSzTxtPptAddrCmnt() 

    /**
     * Returns the value of field 'tmScrTmPptTime'.
     * 
     * @return the value of field 'TmScrTmPptTime'.
     */
    public java.lang.String getTmScrTmPptTime()
    {
        return this._tmScrTmPptTime;
    } //-- java.lang.String getTmScrTmPptTime() 

    /**
     * Returns the value of field 'tmTmPptTime'.
     * 
     * @return the value of field 'TmTmPptTime'.
     */
    public java.lang.String getTmTmPptTime()
    {
        return this._tmTmPptTime;
    } //-- java.lang.String getTmTmPptTime() 

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
     * Returns the value of field 'ulIdContactStdsEvent'.
     * 
     * @return the value of field 'UlIdContactStdsEvent'.
     */
    public int getUlIdContactStdsEvent()
    {
        return this._ulIdContactStdsEvent;
    } //-- int getUlIdContactStdsEvent() 

    /**
     * Returns the value of field 'ulIdPptEvent'.
     * 
     * @return the value of field 'UlIdPptEvent'.
     */
    public int getUlIdPptEvent()
    {
        return this._ulIdPptEvent;
    } //-- int getUlIdPptEvent() 

    /**
     * Method hasUlIdContactStdsEvent
     * 
     * 
     * 
     * @return true if at least one UlIdContactStdsEvent has been
     * added
     */
    public boolean hasUlIdContactStdsEvent()
    {
        return this._has_ulIdContactStdsEvent;
    } //-- boolean hasUlIdContactStdsEvent() 

    /**
     * Method hasUlIdPptEvent
     * 
     * 
     * 
     * @return true if at least one UlIdPptEvent has been added
     */
    public boolean hasUlIdPptEvent()
    {
        return this._has_ulIdPptEvent;
    } //-- boolean hasUlIdPptEvent() 

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
     * Sets the value of field 'bIndAssistNeeded'.
     * 
     * @param bIndAssistNeeded the value of field 'bIndAssistNeeded'
     */
    public void setBIndAssistNeeded(java.lang.String bIndAssistNeeded)
    {
        this._bIndAssistNeeded = bIndAssistNeeded;
    } //-- void setBIndAssistNeeded(java.lang.String) 

    /**
     * Sets the value of field 'bIndPermanency'.
     * 
     * @param bIndPermanency the value of field 'bIndPermanency'.
     */
    public void setBIndPermanency(java.lang.String bIndPermanency)
    {
        this._bIndPermanency = bIndPermanency;
    } //-- void setBIndPermanency(java.lang.String) 

    /**
     * Sets the value of field 'bIndPrevReqMet'.
     * 
     * @param bIndPrevReqMet the value of field 'bIndPrevReqMet'.
     */
    public void setBIndPrevReqMet(java.lang.String bIndPrevReqMet)
    {
        this._bIndPrevReqMet = bIndPrevReqMet;
    } //-- void setBIndPrevReqMet(java.lang.String) 

    /**
     * Sets the value of field 'bIndSafety'.
     * 
     * @param bIndSafety the value of field 'bIndSafety'.
     */
    public void setBIndSafety(java.lang.String bIndSafety)
    {
        this._bIndSafety = bIndSafety;
    } //-- void setBIndSafety(java.lang.String) 

    /**
     * Sets the value of field 'bIndTranPlanComp'.
     * 
     * @param bIndTranPlanComp the value of field 'bIndTranPlanComp'
     */
    public void setBIndTranPlanComp(java.lang.String bIndTranPlanComp)
    {
        this._bIndTranPlanComp = bIndTranPlanComp;
    } //-- void setBIndTranPlanComp(java.lang.String) 

    /**
     * Sets the value of field 'bIndWellbeing'.
     * 
     * @param bIndWellbeing the value of field 'bIndWellbeing'.
     */
    public void setBIndWellbeing(java.lang.String bIndWellbeing)
    {
        this._bIndWellbeing = bIndWellbeing;
    } //-- void setBIndWellbeing(java.lang.String) 

    /**
     * Sets the value of field 'dtDateHearingReq'.
     * 
     * @param dtDateHearingReq the value of field 'dtDateHearingReq'
     */
    public void setDtDateHearingReq(org.exolab.castor.types.Date dtDateHearingReq)
    {
        this._dtDateHearingReq = dtDateHearingReq;
    } //-- void setDtDateHearingReq(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDatePrepIntvw'.
     * 
     * @param dtDatePrepIntvw the value of field 'dtDatePrepIntvw'.
     */
    public void setDtDatePrepIntvw(org.exolab.castor.types.Date dtDatePrepIntvw)
    {
        this._dtDatePrepIntvw = dtDatePrepIntvw;
    } //-- void setDtDatePrepIntvw(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPptDate'.
     * 
     * @param dtDtPptDate the value of field 'dtDtPptDate'.
     */
    public void setDtDtPptDate(org.exolab.castor.types.Date dtDtPptDate)
    {
        this._dtDtPptDate = dtDtPptDate;
    } //-- void setDtDtPptDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPptDocComp'.
     * 
     * @param dtDtPptDocComp the value of field 'dtDtPptDocComp'.
     */
    public void setDtDtPptDocComp(org.exolab.castor.types.Date dtDtPptDocComp)
    {
        this._dtDtPptDocComp = dtDtPptDocComp;
    } //-- void setDtDtPptDocComp(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtOutcomeDiscussed'.
     * 
     * @param dtOutcomeDiscussed the value of field
     * 'dtOutcomeDiscussed'.
     */
    public void setDtOutcomeDiscussed(org.exolab.castor.types.Date dtOutcomeDiscussed)
    {
        this._dtOutcomeDiscussed = dtOutcomeDiscussed;
    } //-- void setDtOutcomeDiscussed(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtPermRepComp'.
     * 
     * @param dtPermRepComp the value of field 'dtPermRepComp'.
     */
    public void setDtPermRepComp(org.exolab.castor.types.Date dtPermRepComp)
    {
        this._dtPermRepComp = dtPermRepComp;
    } //-- void setDtPermRepComp(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtUtilBeginDate'.
     * 
     * @param dtUtilBeginDate the value of field 'dtUtilBeginDate'.
     */
    public void setDtUtilBeginDate(org.exolab.castor.types.Date dtUtilBeginDate)
    {
        this._dtUtilBeginDate = dtUtilBeginDate;
    } //-- void setDtUtilBeginDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtUtilEndDate'.
     * 
     * @param dtUtilEndDate the value of field 'dtUtilEndDate'.
     */
    public void setDtUtilEndDate(org.exolab.castor.types.Date dtUtilEndDate)
    {
        this._dtUtilEndDate = dtUtilEndDate;
    } //-- void setDtUtilEndDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrPptPhoneExt'.
     * 
     * @param lNbrPptPhoneExt the value of field 'lNbrPptPhoneExt'.
     */
    public void setLNbrPptPhoneExt(java.lang.String lNbrPptPhoneExt)
    {
        this._lNbrPptPhoneExt = lNbrPptPhoneExt;
    } //-- void setLNbrPptPhoneExt(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPptCity'.
     * 
     * @param szAddrPptCity the value of field 'szAddrPptCity'.
     */
    public void setSzAddrPptCity(java.lang.String szAddrPptCity)
    {
        this._szAddrPptCity = szAddrPptCity;
    } //-- void setSzAddrPptCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPptCnty'.
     * 
     * @param szAddrPptCnty the value of field 'szAddrPptCnty'.
     */
    public void setSzAddrPptCnty(java.lang.String szAddrPptCnty)
    {
        this._szAddrPptCnty = szAddrPptCnty;
    } //-- void setSzAddrPptCnty(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPptStLn1'.
     * 
     * @param szAddrPptStLn1 the value of field 'szAddrPptStLn1'.
     */
    public void setSzAddrPptStLn1(java.lang.String szAddrPptStLn1)
    {
        this._szAddrPptStLn1 = szAddrPptStLn1;
    } //-- void setSzAddrPptStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPptStLn2'.
     * 
     * @param szAddrPptStLn2 the value of field 'szAddrPptStLn2'.
     */
    public void setSzAddrPptStLn2(java.lang.String szAddrPptStLn2)
    {
        this._szAddrPptStLn2 = szAddrPptStLn2;
    } //-- void setSzAddrPptStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPptState'.
     * 
     * @param szAddrPptState the value of field 'szAddrPptState'.
     */
    public void setSzAddrPptState(java.lang.String szAddrPptState)
    {
        this._szAddrPptState = szAddrPptState;
    } //-- void setSzAddrPptState(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPptZip'.
     * 
     * @param szAddrPptZip the value of field 'szAddrPptZip'.
     */
    public void setSzAddrPptZip(java.lang.String szAddrPptZip)
    {
        this._szAddrPptZip = szAddrPptZip;
    } //-- void setSzAddrPptZip(java.lang.String) 

    /**
     * Sets the value of field 'szApprovalStatus'.
     * 
     * @param szApprovalStatus the value of field 'szApprovalStatus'
     */
    public void setSzApprovalStatus(java.lang.String szApprovalStatus)
    {
        this._szApprovalStatus = szApprovalStatus;
    } //-- void setSzApprovalStatus(java.lang.String) 

    /**
     * Sets the value of field 'szMeetingType'.
     * 
     * @param szMeetingType the value of field 'szMeetingType'.
     */
    public void setSzMeetingType(java.lang.String szMeetingType)
    {
        this._szMeetingType = szMeetingType;
    } //-- void setSzMeetingType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPptPhone'.
     * 
     * @param szNbrPptPhone the value of field 'szNbrPptPhone'.
     */
    public void setSzNbrPptPhone(java.lang.String szNbrPptPhone)
    {
        this._szNbrPptPhone = szNbrPptPhone;
    } //-- void setSzNbrPptPhone(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPptAddrCmnt'.
     * 
     * @param szTxtPptAddrCmnt the value of field 'szTxtPptAddrCmnt'
     */
    public void setSzTxtPptAddrCmnt(java.lang.String szTxtPptAddrCmnt)
    {
        this._szTxtPptAddrCmnt = szTxtPptAddrCmnt;
    } //-- void setSzTxtPptAddrCmnt(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmPptTime'.
     * 
     * @param tmScrTmPptTime the value of field 'tmScrTmPptTime'.
     */
    public void setTmScrTmPptTime(java.lang.String tmScrTmPptTime)
    {
        this._tmScrTmPptTime = tmScrTmPptTime;
    } //-- void setTmScrTmPptTime(java.lang.String) 

    /**
     * Sets the value of field 'tmTmPptTime'.
     * 
     * @param tmTmPptTime the value of field 'tmTmPptTime'.
     */
    public void setTmTmPptTime(java.lang.String tmTmPptTime)
    {
        this._tmTmPptTime = tmTmPptTime;
    } //-- void setTmTmPptTime(java.lang.String) 

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
     * Sets the value of field 'ulIdContactStdsEvent'.
     * 
     * @param ulIdContactStdsEvent the value of field
     * 'ulIdContactStdsEvent'.
     */
    public void setUlIdContactStdsEvent(int ulIdContactStdsEvent)
    {
        this._ulIdContactStdsEvent = ulIdContactStdsEvent;
        this._has_ulIdContactStdsEvent = true;
    } //-- void setUlIdContactStdsEvent(int) 

    /**
     * Sets the value of field 'ulIdPptEvent'.
     * 
     * @param ulIdPptEvent the value of field 'ulIdPptEvent'.
     */
    public void setUlIdPptEvent(int ulIdPptEvent)
    {
        this._ulIdPptEvent = ulIdPptEvent;
        this._has_ulIdPptEvent = true;
    } //-- void setUlIdPptEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00 unmarshal(java.io.Reader) 

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
