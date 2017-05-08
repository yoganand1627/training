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
 * Class ROWCSUB28SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB28SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPptEvent
     */
    private int _ulIdPptEvent;

    /**
     * keeps track of state for field: _ulIdPptEvent
     */
    private boolean _has_ulIdPptEvent;

    /**
     * Field _ulIdPptPart
     */
    private int _ulIdPptPart;

    /**
     * keeps track of state for field: _ulIdPptPart
     */
    private boolean _has_ulIdPptPart;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdPptPartType
     */
    private java.lang.String _szCdPptPartType;

    /**
     * Field _szNmPptPartFull
     */
    private java.lang.String _szNmPptPartFull;

    /**
     * Field _szSdsPptPartRelationship
     */
    private java.lang.String _szSdsPptPartRelationship;

    /**
     * Field _szCdPptNotifType
     */
    private java.lang.String _szCdPptNotifType;

    /**
     * Field _dtDtPptPartDateNotif
     */
    private org.exolab.castor.types.Date _dtDtPptPartDateNotif;

    /**
     * Field _dtDtPptPart
     */
    private org.exolab.castor.types.Date _dtDtPptPart;

    /**
     * Field _cScrIndSendAlert
     */
    private java.lang.String _cScrIndSendAlert;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _txtAgency
     */
    private java.lang.String _txtAgency;

    /**
     * Field _txtTitle
     */
    private java.lang.String _txtTitle;

    /**
     * Field _indAccptdChnges
     */
    private java.lang.String _indAccptdChnges;

    /**
     * Field _indSignedWvrAh
     */
    private java.lang.String _indSignedWvrAh;

    /**
     * Field _indReqAh
     */
    private java.lang.String _indReqAh;

    /**
     * Field _indTranPlanComp
     */
    private java.lang.String _indTranPlanComp;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB28SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPptEvent()
    {
        this._has_ulIdPptEvent= false;
    } //-- void deleteUlIdPptEvent() 

    /**
     */
    public void deleteUlIdPptPart()
    {
        this._has_ulIdPptPart= false;
    } //-- void deleteUlIdPptPart() 

    /**
     * Returns the value of field 'cScrIndSendAlert'.
     * 
     * @return the value of field 'CScrIndSendAlert'.
     */
    public java.lang.String getCScrIndSendAlert()
    {
        return this._cScrIndSendAlert;
    } //-- java.lang.String getCScrIndSendAlert() 

    /**
     * Returns the value of field 'dtDtPptPart'.
     * 
     * @return the value of field 'DtDtPptPart'.
     */
    public org.exolab.castor.types.Date getDtDtPptPart()
    {
        return this._dtDtPptPart;
    } //-- org.exolab.castor.types.Date getDtDtPptPart() 

    /**
     * Returns the value of field 'dtDtPptPartDateNotif'.
     * 
     * @return the value of field 'DtDtPptPartDateNotif'.
     */
    public org.exolab.castor.types.Date getDtDtPptPartDateNotif()
    {
        return this._dtDtPptPartDateNotif;
    } //-- org.exolab.castor.types.Date getDtDtPptPartDateNotif() 

    /**
     * Returns the value of field 'indAccptdChnges'.
     * 
     * @return the value of field 'IndAccptdChnges'.
     */
    public java.lang.String getIndAccptdChnges()
    {
        return this._indAccptdChnges;
    } //-- java.lang.String getIndAccptdChnges() 

    /**
     * Returns the value of field 'indReqAh'.
     * 
     * @return the value of field 'IndReqAh'.
     */
    public java.lang.String getIndReqAh()
    {
        return this._indReqAh;
    } //-- java.lang.String getIndReqAh() 

    /**
     * Returns the value of field 'indSignedWvrAh'.
     * 
     * @return the value of field 'IndSignedWvrAh'.
     */
    public java.lang.String getIndSignedWvrAh()
    {
        return this._indSignedWvrAh;
    } //-- java.lang.String getIndSignedWvrAh() 

    /**
     * Returns the value of field 'indTranPlanComp'.
     * 
     * @return the value of field 'IndTranPlanComp'.
     */
    public java.lang.String getIndTranPlanComp()
    {
        return this._indTranPlanComp;
    } //-- java.lang.String getIndTranPlanComp() 

    /**
     * Returns the value of field 'szCdPptNotifType'.
     * 
     * @return the value of field 'SzCdPptNotifType'.
     */
    public java.lang.String getSzCdPptNotifType()
    {
        return this._szCdPptNotifType;
    } //-- java.lang.String getSzCdPptNotifType() 

    /**
     * Returns the value of field 'szCdPptPartType'.
     * 
     * @return the value of field 'SzCdPptPartType'.
     */
    public java.lang.String getSzCdPptPartType()
    {
        return this._szCdPptPartType;
    } //-- java.lang.String getSzCdPptPartType() 

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
     * Returns the value of field 'szNmPptPartFull'.
     * 
     * @return the value of field 'SzNmPptPartFull'.
     */
    public java.lang.String getSzNmPptPartFull()
    {
        return this._szNmPptPartFull;
    } //-- java.lang.String getSzNmPptPartFull() 

    /**
     * Returns the value of field 'szSdsPptPartRelationship'.
     * 
     * @return the value of field 'SzSdsPptPartRelationship'.
     */
    public java.lang.String getSzSdsPptPartRelationship()
    {
        return this._szSdsPptPartRelationship;
    } //-- java.lang.String getSzSdsPptPartRelationship() 

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
     * Returns the value of field 'txtAgency'.
     * 
     * @return the value of field 'TxtAgency'.
     */
    public java.lang.String getTxtAgency()
    {
        return this._txtAgency;
    } //-- java.lang.String getTxtAgency() 

    /**
     * Returns the value of field 'txtTitle'.
     * 
     * @return the value of field 'TxtTitle'.
     */
    public java.lang.String getTxtTitle()
    {
        return this._txtTitle;
    } //-- java.lang.String getTxtTitle() 

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
     * Returns the value of field 'ulIdPptEvent'.
     * 
     * @return the value of field 'UlIdPptEvent'.
     */
    public int getUlIdPptEvent()
    {
        return this._ulIdPptEvent;
    } //-- int getUlIdPptEvent() 

    /**
     * Returns the value of field 'ulIdPptPart'.
     * 
     * @return the value of field 'UlIdPptPart'.
     */
    public int getUlIdPptPart()
    {
        return this._ulIdPptPart;
    } //-- int getUlIdPptPart() 

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
     * Method hasUlIdPptPart
     * 
     * 
     * 
     * @return true if at least one UlIdPptPart has been added
     */
    public boolean hasUlIdPptPart()
    {
        return this._has_ulIdPptPart;
    } //-- boolean hasUlIdPptPart() 

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
     * Sets the value of field 'cScrIndSendAlert'.
     * 
     * @param cScrIndSendAlert the value of field 'cScrIndSendAlert'
     */
    public void setCScrIndSendAlert(java.lang.String cScrIndSendAlert)
    {
        this._cScrIndSendAlert = cScrIndSendAlert;
    } //-- void setCScrIndSendAlert(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPptPart'.
     * 
     * @param dtDtPptPart the value of field 'dtDtPptPart'.
     */
    public void setDtDtPptPart(org.exolab.castor.types.Date dtDtPptPart)
    {
        this._dtDtPptPart = dtDtPptPart;
    } //-- void setDtDtPptPart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPptPartDateNotif'.
     * 
     * @param dtDtPptPartDateNotif the value of field
     * 'dtDtPptPartDateNotif'.
     */
    public void setDtDtPptPartDateNotif(org.exolab.castor.types.Date dtDtPptPartDateNotif)
    {
        this._dtDtPptPartDateNotif = dtDtPptPartDateNotif;
    } //-- void setDtDtPptPartDateNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indAccptdChnges'.
     * 
     * @param indAccptdChnges the value of field 'indAccptdChnges'.
     */
    public void setIndAccptdChnges(java.lang.String indAccptdChnges)
    {
        this._indAccptdChnges = indAccptdChnges;
    } //-- void setIndAccptdChnges(java.lang.String) 

    /**
     * Sets the value of field 'indReqAh'.
     * 
     * @param indReqAh the value of field 'indReqAh'.
     */
    public void setIndReqAh(java.lang.String indReqAh)
    {
        this._indReqAh = indReqAh;
    } //-- void setIndReqAh(java.lang.String) 

    /**
     * Sets the value of field 'indSignedWvrAh'.
     * 
     * @param indSignedWvrAh the value of field 'indSignedWvrAh'.
     */
    public void setIndSignedWvrAh(java.lang.String indSignedWvrAh)
    {
        this._indSignedWvrAh = indSignedWvrAh;
    } //-- void setIndSignedWvrAh(java.lang.String) 

    /**
     * Sets the value of field 'indTranPlanComp'.
     * 
     * @param indTranPlanComp the value of field 'indTranPlanComp'.
     */
    public void setIndTranPlanComp(java.lang.String indTranPlanComp)
    {
        this._indTranPlanComp = indTranPlanComp;
    } //-- void setIndTranPlanComp(java.lang.String) 

    /**
     * Sets the value of field 'szCdPptNotifType'.
     * 
     * @param szCdPptNotifType the value of field 'szCdPptNotifType'
     */
    public void setSzCdPptNotifType(java.lang.String szCdPptNotifType)
    {
        this._szCdPptNotifType = szCdPptNotifType;
    } //-- void setSzCdPptNotifType(java.lang.String) 

    /**
     * Sets the value of field 'szCdPptPartType'.
     * 
     * @param szCdPptPartType the value of field 'szCdPptPartType'.
     */
    public void setSzCdPptPartType(java.lang.String szCdPptPartType)
    {
        this._szCdPptPartType = szCdPptPartType;
    } //-- void setSzCdPptPartType(java.lang.String) 

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
     * Sets the value of field 'szNmPptPartFull'.
     * 
     * @param szNmPptPartFull the value of field 'szNmPptPartFull'.
     */
    public void setSzNmPptPartFull(java.lang.String szNmPptPartFull)
    {
        this._szNmPptPartFull = szNmPptPartFull;
    } //-- void setSzNmPptPartFull(java.lang.String) 

    /**
     * Sets the value of field 'szSdsPptPartRelationship'.
     * 
     * @param szSdsPptPartRelationship the value of field
     * 'szSdsPptPartRelationship'.
     */
    public void setSzSdsPptPartRelationship(java.lang.String szSdsPptPartRelationship)
    {
        this._szSdsPptPartRelationship = szSdsPptPartRelationship;
    } //-- void setSzSdsPptPartRelationship(java.lang.String) 

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
     * Sets the value of field 'txtAgency'.
     * 
     * @param txtAgency the value of field 'txtAgency'.
     */
    public void setTxtAgency(java.lang.String txtAgency)
    {
        this._txtAgency = txtAgency;
    } //-- void setTxtAgency(java.lang.String) 

    /**
     * Sets the value of field 'txtTitle'.
     * 
     * @param txtTitle the value of field 'txtTitle'.
     */
    public void setTxtTitle(java.lang.String txtTitle)
    {
        this._txtTitle = txtTitle;
    } //-- void setTxtTitle(java.lang.String) 

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
     * Sets the value of field 'ulIdPptPart'.
     * 
     * @param ulIdPptPart the value of field 'ulIdPptPart'.
     */
    public void setUlIdPptPart(int ulIdPptPart)
    {
        this._ulIdPptPart = ulIdPptPart;
        this._has_ulIdPptPart = true;
    } //-- void setUlIdPptPart(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00 unmarshal(java.io.Reader) 

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
