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
 * Class ROWCSUB19SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB19SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdEligActual
     */
    private java.lang.String _szCdEligActual;

    /**
     * Field _szCdEligCsupQuest1_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY _szCdEligCsupQuest1_ARRAY;

    /**
     * Field _szCdEligMedEligGroup
     */
    private java.lang.String _szCdEligMedEligGroup;

    /**
     * Field _szCdEligSelected
     */
    private java.lang.String _szCdEligSelected;

    /**
     * Field _szCdFceEligReason
     */
    private java.lang.String _szCdFceEligReason;

    /**
     * Field _dtDtEligCsupReferral
     */
    private org.exolab.castor.types.Date _dtDtEligCsupReferral;

    /**
     * Field _dtDtEligEnd
     */
    private org.exolab.castor.types.Date _dtDtEligEnd;

    /**
     * Field _dtDtEligReview
     */
    private org.exolab.castor.types.Date _dtDtEligReview;

    /**
     * Field _dtDtEligStart
     */
    private org.exolab.castor.types.Date _dtDtEligStart;

    /**
     * Field _ulIdEligibilityEvent
     */
    private int _ulIdEligibilityEvent;

    /**
     * keeps track of state for field: _ulIdEligibilityEvent
     */
    private boolean _has_ulIdEligibilityEvent;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdPersonUpdate
     */
    private int _ulIdPersonUpdate;

    /**
     * keeps track of state for field: _ulIdPersonUpdate
     */
    private boolean _has_ulIdPersonUpdate;

    /**
     * Field _cIndEligCsupSend
     */
    private java.lang.String _cIndEligCsupSend;

    /**
     * Field _cIndReviewCreated
     */
    private java.lang.String _cIndReviewCreated;

    /**
     * Field _szTxtChildSuppRefComment
     */
    private java.lang.String _szTxtChildSuppRefComment;

    /**
     * Field _szTxtEligComment
     */
    private java.lang.String _szTxtEligComment;

    /**
     * Field _cIndEligWriteHistory
     */
    private java.lang.String _cIndEligWriteHistory;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB19SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEligibilityEvent()
    {
        this._has_ulIdEligibilityEvent= false;
    } //-- void deleteUlIdEligibilityEvent() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPersonUpdate()
    {
        this._has_ulIdPersonUpdate= false;
    } //-- void deleteUlIdPersonUpdate() 

    /**
     * Returns the value of field 'cIndEligCsupSend'.
     * 
     * @return the value of field 'CIndEligCsupSend'.
     */
    public java.lang.String getCIndEligCsupSend()
    {
        return this._cIndEligCsupSend;
    } //-- java.lang.String getCIndEligCsupSend() 

    /**
     * Returns the value of field 'cIndEligWriteHistory'.
     * 
     * @return the value of field 'CIndEligWriteHistory'.
     */
    public java.lang.String getCIndEligWriteHistory()
    {
        return this._cIndEligWriteHistory;
    } //-- java.lang.String getCIndEligWriteHistory() 

    /**
     * Returns the value of field 'cIndReviewCreated'.
     * 
     * @return the value of field 'CIndReviewCreated'.
     */
    public java.lang.String getCIndReviewCreated()
    {
        return this._cIndReviewCreated;
    } //-- java.lang.String getCIndReviewCreated() 

    /**
     * Returns the value of field 'dtDtEligCsupReferral'.
     * 
     * @return the value of field 'DtDtEligCsupReferral'.
     */
    public org.exolab.castor.types.Date getDtDtEligCsupReferral()
    {
        return this._dtDtEligCsupReferral;
    } //-- org.exolab.castor.types.Date getDtDtEligCsupReferral() 

    /**
     * Returns the value of field 'dtDtEligEnd'.
     * 
     * @return the value of field 'DtDtEligEnd'.
     */
    public org.exolab.castor.types.Date getDtDtEligEnd()
    {
        return this._dtDtEligEnd;
    } //-- org.exolab.castor.types.Date getDtDtEligEnd() 

    /**
     * Returns the value of field 'dtDtEligReview'.
     * 
     * @return the value of field 'DtDtEligReview'.
     */
    public org.exolab.castor.types.Date getDtDtEligReview()
    {
        return this._dtDtEligReview;
    } //-- org.exolab.castor.types.Date getDtDtEligReview() 

    /**
     * Returns the value of field 'dtDtEligStart'.
     * 
     * @return the value of field 'DtDtEligStart'.
     */
    public org.exolab.castor.types.Date getDtDtEligStart()
    {
        return this._dtDtEligStart;
    } //-- org.exolab.castor.types.Date getDtDtEligStart() 

    /**
     * Returns the value of field 'szCdEligActual'.
     * 
     * @return the value of field 'SzCdEligActual'.
     */
    public java.lang.String getSzCdEligActual()
    {
        return this._szCdEligActual;
    } //-- java.lang.String getSzCdEligActual() 

    /**
     * Returns the value of field 'szCdEligCsupQuest1_ARRAY'.
     * 
     * @return the value of field 'SzCdEligCsupQuest1_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY getSzCdEligCsupQuest1_ARRAY()
    {
        return this._szCdEligCsupQuest1_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY getSzCdEligCsupQuest1_ARRAY() 

    /**
     * Returns the value of field 'szCdEligMedEligGroup'.
     * 
     * @return the value of field 'SzCdEligMedEligGroup'.
     */
    public java.lang.String getSzCdEligMedEligGroup()
    {
        return this._szCdEligMedEligGroup;
    } //-- java.lang.String getSzCdEligMedEligGroup() 

    /**
     * Returns the value of field 'szCdEligSelected'.
     * 
     * @return the value of field 'SzCdEligSelected'.
     */
    public java.lang.String getSzCdEligSelected()
    {
        return this._szCdEligSelected;
    } //-- java.lang.String getSzCdEligSelected() 

    /**
     * Returns the value of field 'szCdFceEligReason'.
     * 
     * @return the value of field 'SzCdFceEligReason'.
     */
    public java.lang.String getSzCdFceEligReason()
    {
        return this._szCdFceEligReason;
    } //-- java.lang.String getSzCdFceEligReason() 

    /**
     * Returns the value of field 'szTxtChildSuppRefComment'.
     * 
     * @return the value of field 'SzTxtChildSuppRefComment'.
     */
    public java.lang.String getSzTxtChildSuppRefComment()
    {
        return this._szTxtChildSuppRefComment;
    } //-- java.lang.String getSzTxtChildSuppRefComment() 

    /**
     * Returns the value of field 'szTxtEligComment'.
     * 
     * @return the value of field 'SzTxtEligComment'.
     */
    public java.lang.String getSzTxtEligComment()
    {
        return this._szTxtEligComment;
    } //-- java.lang.String getSzTxtEligComment() 

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
     * Returns the value of field 'ulIdEligibilityEvent'.
     * 
     * @return the value of field 'UlIdEligibilityEvent'.
     */
    public int getUlIdEligibilityEvent()
    {
        return this._ulIdEligibilityEvent;
    } //-- int getUlIdEligibilityEvent() 

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
     * Returns the value of field 'ulIdPersonUpdate'.
     * 
     * @return the value of field 'UlIdPersonUpdate'.
     */
    public int getUlIdPersonUpdate()
    {
        return this._ulIdPersonUpdate;
    } //-- int getUlIdPersonUpdate() 

    /**
     * Method hasUlIdEligibilityEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEligibilityEvent has been
     * added
     */
    public boolean hasUlIdEligibilityEvent()
    {
        return this._has_ulIdEligibilityEvent;
    } //-- boolean hasUlIdEligibilityEvent() 

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
     * Method hasUlIdPersonUpdate
     * 
     * 
     * 
     * @return true if at least one UlIdPersonUpdate has been added
     */
    public boolean hasUlIdPersonUpdate()
    {
        return this._has_ulIdPersonUpdate;
    } //-- boolean hasUlIdPersonUpdate() 

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
     * Sets the value of field 'cIndEligCsupSend'.
     * 
     * @param cIndEligCsupSend the value of field 'cIndEligCsupSend'
     */
    public void setCIndEligCsupSend(java.lang.String cIndEligCsupSend)
    {
        this._cIndEligCsupSend = cIndEligCsupSend;
    } //-- void setCIndEligCsupSend(java.lang.String) 

    /**
     * Sets the value of field 'cIndEligWriteHistory'.
     * 
     * @param cIndEligWriteHistory the value of field
     * 'cIndEligWriteHistory'.
     */
    public void setCIndEligWriteHistory(java.lang.String cIndEligWriteHistory)
    {
        this._cIndEligWriteHistory = cIndEligWriteHistory;
    } //-- void setCIndEligWriteHistory(java.lang.String) 

    /**
     * Sets the value of field 'cIndReviewCreated'.
     * 
     * @param cIndReviewCreated the value of field
     * 'cIndReviewCreated'.
     */
    public void setCIndReviewCreated(java.lang.String cIndReviewCreated)
    {
        this._cIndReviewCreated = cIndReviewCreated;
    } //-- void setCIndReviewCreated(java.lang.String) 

    /**
     * Sets the value of field 'dtDtEligCsupReferral'.
     * 
     * @param dtDtEligCsupReferral the value of field
     * 'dtDtEligCsupReferral'.
     */
    public void setDtDtEligCsupReferral(org.exolab.castor.types.Date dtDtEligCsupReferral)
    {
        this._dtDtEligCsupReferral = dtDtEligCsupReferral;
    } //-- void setDtDtEligCsupReferral(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEligEnd'.
     * 
     * @param dtDtEligEnd the value of field 'dtDtEligEnd'.
     */
    public void setDtDtEligEnd(org.exolab.castor.types.Date dtDtEligEnd)
    {
        this._dtDtEligEnd = dtDtEligEnd;
    } //-- void setDtDtEligEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEligReview'.
     * 
     * @param dtDtEligReview the value of field 'dtDtEligReview'.
     */
    public void setDtDtEligReview(org.exolab.castor.types.Date dtDtEligReview)
    {
        this._dtDtEligReview = dtDtEligReview;
    } //-- void setDtDtEligReview(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEligStart'.
     * 
     * @param dtDtEligStart the value of field 'dtDtEligStart'.
     */
    public void setDtDtEligStart(org.exolab.castor.types.Date dtDtEligStart)
    {
        this._dtDtEligStart = dtDtEligStart;
    } //-- void setDtDtEligStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdEligActual'.
     * 
     * @param szCdEligActual the value of field 'szCdEligActual'.
     */
    public void setSzCdEligActual(java.lang.String szCdEligActual)
    {
        this._szCdEligActual = szCdEligActual;
    } //-- void setSzCdEligActual(java.lang.String) 

    /**
     * Sets the value of field 'szCdEligCsupQuest1_ARRAY'.
     * 
     * @param szCdEligCsupQuest1_ARRAY the value of field
     * 'szCdEligCsupQuest1_ARRAY'.
     */
    public void setSzCdEligCsupQuest1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY szCdEligCsupQuest1_ARRAY)
    {
        this._szCdEligCsupQuest1_ARRAY = szCdEligCsupQuest1_ARRAY;
    } //-- void setSzCdEligCsupQuest1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY) 

    /**
     * Sets the value of field 'szCdEligMedEligGroup'.
     * 
     * @param szCdEligMedEligGroup the value of field
     * 'szCdEligMedEligGroup'.
     */
    public void setSzCdEligMedEligGroup(java.lang.String szCdEligMedEligGroup)
    {
        this._szCdEligMedEligGroup = szCdEligMedEligGroup;
    } //-- void setSzCdEligMedEligGroup(java.lang.String) 

    /**
     * Sets the value of field 'szCdEligSelected'.
     * 
     * @param szCdEligSelected the value of field 'szCdEligSelected'
     */
    public void setSzCdEligSelected(java.lang.String szCdEligSelected)
    {
        this._szCdEligSelected = szCdEligSelected;
    } //-- void setSzCdEligSelected(java.lang.String) 

    /**
     * Sets the value of field 'szCdFceEligReason'.
     * 
     * @param szCdFceEligReason the value of field
     * 'szCdFceEligReason'.
     */
    public void setSzCdFceEligReason(java.lang.String szCdFceEligReason)
    {
        this._szCdFceEligReason = szCdFceEligReason;
    } //-- void setSzCdFceEligReason(java.lang.String) 

    /**
     * Sets the value of field 'szTxtChildSuppRefComment'.
     * 
     * @param szTxtChildSuppRefComment the value of field
     * 'szTxtChildSuppRefComment'.
     */
    public void setSzTxtChildSuppRefComment(java.lang.String szTxtChildSuppRefComment)
    {
        this._szTxtChildSuppRefComment = szTxtChildSuppRefComment;
    } //-- void setSzTxtChildSuppRefComment(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEligComment'.
     * 
     * @param szTxtEligComment the value of field 'szTxtEligComment'
     */
    public void setSzTxtEligComment(java.lang.String szTxtEligComment)
    {
        this._szTxtEligComment = szTxtEligComment;
    } //-- void setSzTxtEligComment(java.lang.String) 

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
     * Sets the value of field 'ulIdEligibilityEvent'.
     * 
     * @param ulIdEligibilityEvent the value of field
     * 'ulIdEligibilityEvent'.
     */
    public void setUlIdEligibilityEvent(int ulIdEligibilityEvent)
    {
        this._ulIdEligibilityEvent = ulIdEligibilityEvent;
        this._has_ulIdEligibilityEvent = true;
    } //-- void setUlIdEligibilityEvent(int) 

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
     * Sets the value of field 'ulIdPersonUpdate'.
     * 
     * @param ulIdPersonUpdate the value of field 'ulIdPersonUpdate'
     */
    public void setUlIdPersonUpdate(int ulIdPersonUpdate)
    {
        this._ulIdPersonUpdate = ulIdPersonUpdate;
        this._has_ulIdPersonUpdate = true;
    } //-- void setUlIdPersonUpdate(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00 unmarshal(java.io.Reader) 

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
