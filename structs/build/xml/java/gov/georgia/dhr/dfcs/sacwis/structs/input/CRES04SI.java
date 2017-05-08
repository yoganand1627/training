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
 * Class CRES04SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES04SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _szNmRsrcContact
     */
    private java.lang.String _szNmRsrcContact;

    /**
     * Field _szNmRsrcLastUpdate
     */
    private java.lang.String _szNmRsrcLastUpdate;

    /**
     * Field _szCdRsrcCampusType
     */
    private java.lang.String _szCdRsrcCampusType;

    /**
     * Field _szCdRsrcFacilType
     */
    private java.lang.String _szCdRsrcFacilType;

    /**
     * Field _szCdRsrcHub
     */
    private java.lang.String _szCdRsrcHub;

    /**
     * Field _szCdRsrcMaintainer
     */
    private java.lang.String _szCdRsrcMaintainer;

    /**
     * Field _szCdRsrcOwnership
     */
    private java.lang.String _szCdRsrcOwnership;

    /**
     * Field _szCdRsrcStatus
     */
    private java.lang.String _szCdRsrcStatus;

    /**
     * Field _szCdRsrcType
     */
    private java.lang.String _szCdRsrcType;

    /**
     * Field _lNbrSchCampusNbr
     */
    private int _lNbrSchCampusNbr;

    /**
     * keeps track of state for field: _lNbrSchCampusNbr
     */
    private boolean _has_lNbrSchCampusNbr;

    /**
     * Field _indRsrcChanged
     */
    private boolean _indRsrcChanged;

    /**
     * keeps track of state for field: _indRsrcChanged
     */
    private boolean _has_indRsrcChanged;

    /**
     * Field _bIndReview
     */
    private java.lang.String _bIndReview;

    /**
     * Field _indAddrChanged
     */
    private boolean _indAddrChanged;

    /**
     * keeps track of state for field: _indAddrChanged
     */
    private boolean _has_indAddrChanged;

    /**
     * Field _indPhoneChanged
     */
    private boolean _indPhoneChanged;

    /**
     * keeps track of state for field: _indPhoneChanged
     */
    private boolean _has_indPhoneChanged;

    /**
     * Field _lNbrRsrcFacilAcclaim
     */
    private int _lNbrRsrcFacilAcclaim;

    /**
     * keeps track of state for field: _lNbrRsrcFacilAcclaim
     */
    private boolean _has_lNbrRsrcFacilAcclaim;

    /**
     * Field _szCdMhmrCompCode
     */
    private java.lang.String _szCdMhmrCompCode;

    /**
     * Field _cIndRsrcTransport
     */
    private java.lang.String _cIndRsrcTransport;

    /**
     * Field _szTxtRsrcComments
     */
    private java.lang.String _szTxtRsrcComments;

    /**
     * Field _ulPageSizeNbr_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY _ulPageSizeNbr_ARRAY;

    /**
     * Field _ROWCRES04SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY _ROWCRES04SIG00_ARRAY;

    /**
     * Field _ROWCRES04SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY _ROWCRES04SIG01_ARRAY;

    /**
     * Field _szNmLegal
     */
    private java.lang.String _szNmLegal;

    /**
     * Field _szNmRsrcContactTitle
     */
    private java.lang.String _szNmRsrcContactTitle;

    /**
     * Field _szNbrRsrcNtnlProvider
     */
    private java.lang.String _szNbrRsrcNtnlProvider;

    /**
     * Field _szAddrRsrcEmail
     */
    private java.lang.String _szAddrRsrcEmail;

    /**
     * Field _szAddrRsrcWebsite
     */
    private java.lang.String _szAddrRsrcWebsite;

    /**
     * Field _szCdSchoolType
     */
    private java.lang.String _szCdSchoolType;

    /**
     * Field _szCdPaymentDelivery
     */
    private java.lang.String _szCdPaymentDelivery;

    /**
     * Field _szCdSchoolDistrict
     */
    private java.lang.String _szCdSchoolDistrict;

    /**
     * Field _ulSysIdPriorPerson
     */
    private int _ulSysIdPriorPerson;

    /**
     * keeps track of state for field: _ulSysIdPriorPerson
     */
    private boolean _has_ulSysIdPriorPerson;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES04SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIndAddrChanged()
    {
        this._has_indAddrChanged= false;
    } //-- void deleteIndAddrChanged() 

    /**
     */
    public void deleteIndPhoneChanged()
    {
        this._has_indPhoneChanged= false;
    } //-- void deleteIndPhoneChanged() 

    /**
     */
    public void deleteIndRsrcChanged()
    {
        this._has_indRsrcChanged= false;
    } //-- void deleteIndRsrcChanged() 

    /**
     */
    public void deleteLNbrRsrcFacilAcclaim()
    {
        this._has_lNbrRsrcFacilAcclaim= false;
    } //-- void deleteLNbrRsrcFacilAcclaim() 

    /**
     */
    public void deleteLNbrSchCampusNbr()
    {
        this._has_lNbrSchCampusNbr= false;
    } //-- void deleteLNbrSchCampusNbr() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlSysIdPriorPerson()
    {
        this._has_ulSysIdPriorPerson= false;
    } //-- void deleteUlSysIdPriorPerson() 

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
     * Returns the value of field 'bIndReview'.
     * 
     * @return the value of field 'BIndReview'.
     */
    public java.lang.String getBIndReview()
    {
        return this._bIndReview;
    } //-- java.lang.String getBIndReview() 

    /**
     * Returns the value of field 'cIndRsrcTransport'.
     * 
     * @return the value of field 'CIndRsrcTransport'.
     */
    public java.lang.String getCIndRsrcTransport()
    {
        return this._cIndRsrcTransport;
    } //-- java.lang.String getCIndRsrcTransport() 

    /**
     * Returns the value of field 'indAddrChanged'.
     * 
     * @return the value of field 'IndAddrChanged'.
     */
    public boolean getIndAddrChanged()
    {
        return this._indAddrChanged;
    } //-- boolean getIndAddrChanged() 

    /**
     * Returns the value of field 'indPhoneChanged'.
     * 
     * @return the value of field 'IndPhoneChanged'.
     */
    public boolean getIndPhoneChanged()
    {
        return this._indPhoneChanged;
    } //-- boolean getIndPhoneChanged() 

    /**
     * Returns the value of field 'indRsrcChanged'.
     * 
     * @return the value of field 'IndRsrcChanged'.
     */
    public boolean getIndRsrcChanged()
    {
        return this._indRsrcChanged;
    } //-- boolean getIndRsrcChanged() 

    /**
     * Returns the value of field 'lNbrRsrcFacilAcclaim'.
     * 
     * @return the value of field 'LNbrRsrcFacilAcclaim'.
     */
    public int getLNbrRsrcFacilAcclaim()
    {
        return this._lNbrRsrcFacilAcclaim;
    } //-- int getLNbrRsrcFacilAcclaim() 

    /**
     * Returns the value of field 'lNbrSchCampusNbr'.
     * 
     * @return the value of field 'LNbrSchCampusNbr'.
     */
    public int getLNbrSchCampusNbr()
    {
        return this._lNbrSchCampusNbr;
    } //-- int getLNbrSchCampusNbr() 

    /**
     * Returns the value of field 'ROWCRES04SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCRES04SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY getROWCRES04SIG00_ARRAY()
    {
        return this._ROWCRES04SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY getROWCRES04SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCRES04SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCRES04SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY getROWCRES04SIG01_ARRAY()
    {
        return this._ROWCRES04SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY getROWCRES04SIG01_ARRAY() 

    /**
     * Returns the value of field 'szAddrRsrcEmail'.
     * 
     * @return the value of field 'SzAddrRsrcEmail'.
     */
    public java.lang.String getSzAddrRsrcEmail()
    {
        return this._szAddrRsrcEmail;
    } //-- java.lang.String getSzAddrRsrcEmail() 

    /**
     * Returns the value of field 'szAddrRsrcWebsite'.
     * 
     * @return the value of field 'SzAddrRsrcWebsite'.
     */
    public java.lang.String getSzAddrRsrcWebsite()
    {
        return this._szAddrRsrcWebsite;
    } //-- java.lang.String getSzAddrRsrcWebsite() 

    /**
     * Returns the value of field 'szCdMhmrCompCode'.
     * 
     * @return the value of field 'SzCdMhmrCompCode'.
     */
    public java.lang.String getSzCdMhmrCompCode()
    {
        return this._szCdMhmrCompCode;
    } //-- java.lang.String getSzCdMhmrCompCode() 

    /**
     * Returns the value of field 'szCdPaymentDelivery'.
     * 
     * @return the value of field 'SzCdPaymentDelivery'.
     */
    public java.lang.String getSzCdPaymentDelivery()
    {
        return this._szCdPaymentDelivery;
    } //-- java.lang.String getSzCdPaymentDelivery() 

    /**
     * Returns the value of field 'szCdRsrcCampusType'.
     * 
     * @return the value of field 'SzCdRsrcCampusType'.
     */
    public java.lang.String getSzCdRsrcCampusType()
    {
        return this._szCdRsrcCampusType;
    } //-- java.lang.String getSzCdRsrcCampusType() 

    /**
     * Returns the value of field 'szCdRsrcFacilType'.
     * 
     * @return the value of field 'SzCdRsrcFacilType'.
     */
    public java.lang.String getSzCdRsrcFacilType()
    {
        return this._szCdRsrcFacilType;
    } //-- java.lang.String getSzCdRsrcFacilType() 

    /**
     * Returns the value of field 'szCdRsrcHub'.
     * 
     * @return the value of field 'SzCdRsrcHub'.
     */
    public java.lang.String getSzCdRsrcHub()
    {
        return this._szCdRsrcHub;
    } //-- java.lang.String getSzCdRsrcHub() 

    /**
     * Returns the value of field 'szCdRsrcMaintainer'.
     * 
     * @return the value of field 'SzCdRsrcMaintainer'.
     */
    public java.lang.String getSzCdRsrcMaintainer()
    {
        return this._szCdRsrcMaintainer;
    } //-- java.lang.String getSzCdRsrcMaintainer() 

    /**
     * Returns the value of field 'szCdRsrcOwnership'.
     * 
     * @return the value of field 'SzCdRsrcOwnership'.
     */
    public java.lang.String getSzCdRsrcOwnership()
    {
        return this._szCdRsrcOwnership;
    } //-- java.lang.String getSzCdRsrcOwnership() 

    /**
     * Returns the value of field 'szCdRsrcStatus'.
     * 
     * @return the value of field 'SzCdRsrcStatus'.
     */
    public java.lang.String getSzCdRsrcStatus()
    {
        return this._szCdRsrcStatus;
    } //-- java.lang.String getSzCdRsrcStatus() 

    /**
     * Returns the value of field 'szCdRsrcType'.
     * 
     * @return the value of field 'SzCdRsrcType'.
     */
    public java.lang.String getSzCdRsrcType()
    {
        return this._szCdRsrcType;
    } //-- java.lang.String getSzCdRsrcType() 

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
     * Returns the value of field 'szCdSchoolType'.
     * 
     * @return the value of field 'SzCdSchoolType'.
     */
    public java.lang.String getSzCdSchoolType()
    {
        return this._szCdSchoolType;
    } //-- java.lang.String getSzCdSchoolType() 

    /**
     * Returns the value of field 'szNbrRsrcNtnlProvider'.
     * 
     * @return the value of field 'SzNbrRsrcNtnlProvider'.
     */
    public java.lang.String getSzNbrRsrcNtnlProvider()
    {
        return this._szNbrRsrcNtnlProvider;
    } //-- java.lang.String getSzNbrRsrcNtnlProvider() 

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
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

    /**
     * Returns the value of field 'szNmRsrcContact'.
     * 
     * @return the value of field 'SzNmRsrcContact'.
     */
    public java.lang.String getSzNmRsrcContact()
    {
        return this._szNmRsrcContact;
    } //-- java.lang.String getSzNmRsrcContact() 

    /**
     * Returns the value of field 'szNmRsrcContactTitle'.
     * 
     * @return the value of field 'SzNmRsrcContactTitle'.
     */
    public java.lang.String getSzNmRsrcContactTitle()
    {
        return this._szNmRsrcContactTitle;
    } //-- java.lang.String getSzNmRsrcContactTitle() 

    /**
     * Returns the value of field 'szNmRsrcLastUpdate'.
     * 
     * @return the value of field 'SzNmRsrcLastUpdate'.
     */
    public java.lang.String getSzNmRsrcLastUpdate()
    {
        return this._szNmRsrcLastUpdate;
    } //-- java.lang.String getSzNmRsrcLastUpdate() 

    /**
     * Returns the value of field 'szTxtRsrcComments'.
     * 
     * @return the value of field 'SzTxtRsrcComments'.
     */
    public java.lang.String getSzTxtRsrcComments()
    {
        return this._szTxtRsrcComments;
    } //-- java.lang.String getSzTxtRsrcComments() 

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
     * Returns the value of field 'ulPageSizeNbr_ARRAY'.
     * 
     * @return the value of field 'UlPageSizeNbr_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY getUlPageSizeNbr_ARRAY()
    {
        return this._ulPageSizeNbr_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY getUlPageSizeNbr_ARRAY() 

    /**
     * Returns the value of field 'ulSysIdPriorPerson'.
     * 
     * @return the value of field 'UlSysIdPriorPerson'.
     */
    public int getUlSysIdPriorPerson()
    {
        return this._ulSysIdPriorPerson;
    } //-- int getUlSysIdPriorPerson() 

    /**
     * Method hasIndAddrChanged
     * 
     * 
     * 
     * @return true if at least one IndAddrChanged has been added
     */
    public boolean hasIndAddrChanged()
    {
        return this._has_indAddrChanged;
    } //-- boolean hasIndAddrChanged() 

    /**
     * Method hasIndPhoneChanged
     * 
     * 
     * 
     * @return true if at least one IndPhoneChanged has been added
     */
    public boolean hasIndPhoneChanged()
    {
        return this._has_indPhoneChanged;
    } //-- boolean hasIndPhoneChanged() 

    /**
     * Method hasIndRsrcChanged
     * 
     * 
     * 
     * @return true if at least one IndRsrcChanged has been added
     */
    public boolean hasIndRsrcChanged()
    {
        return this._has_indRsrcChanged;
    } //-- boolean hasIndRsrcChanged() 

    /**
     * Method hasLNbrRsrcFacilAcclaim
     * 
     * 
     * 
     * @return true if at least one LNbrRsrcFacilAcclaim has been
     * added
     */
    public boolean hasLNbrRsrcFacilAcclaim()
    {
        return this._has_lNbrRsrcFacilAcclaim;
    } //-- boolean hasLNbrRsrcFacilAcclaim() 

    /**
     * Method hasLNbrSchCampusNbr
     * 
     * 
     * 
     * @return true if at least one LNbrSchCampusNbr has been added
     */
    public boolean hasLNbrSchCampusNbr()
    {
        return this._has_lNbrSchCampusNbr;
    } //-- boolean hasLNbrSchCampusNbr() 

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
     * Method hasUlSysIdPriorPerson
     * 
     * 
     * 
     * @return true if at least one UlSysIdPriorPerson has been adde
     */
    public boolean hasUlSysIdPriorPerson()
    {
        return this._has_ulSysIdPriorPerson;
    } //-- boolean hasUlSysIdPriorPerson() 

    /**
     * Returns the value of field 'indAddrChanged'.
     * 
     * @return the value of field 'IndAddrChanged'.
     */
    public boolean isIndAddrChanged()
    {
        return this._indAddrChanged;
    } //-- boolean isIndAddrChanged() 

    /**
     * Returns the value of field 'indPhoneChanged'.
     * 
     * @return the value of field 'IndPhoneChanged'.
     */
    public boolean isIndPhoneChanged()
    {
        return this._indPhoneChanged;
    } //-- boolean isIndPhoneChanged() 

    /**
     * Returns the value of field 'indRsrcChanged'.
     * 
     * @return the value of field 'IndRsrcChanged'.
     */
    public boolean isIndRsrcChanged()
    {
        return this._indRsrcChanged;
    } //-- boolean isIndRsrcChanged() 

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
     * Sets the value of field 'bIndReview'.
     * 
     * @param bIndReview the value of field 'bIndReview'.
     */
    public void setBIndReview(java.lang.String bIndReview)
    {
        this._bIndReview = bIndReview;
    } //-- void setBIndReview(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcTransport'.
     * 
     * @param cIndRsrcTransport the value of field
     * 'cIndRsrcTransport'.
     */
    public void setCIndRsrcTransport(java.lang.String cIndRsrcTransport)
    {
        this._cIndRsrcTransport = cIndRsrcTransport;
    } //-- void setCIndRsrcTransport(java.lang.String) 

    /**
     * Sets the value of field 'indAddrChanged'.
     * 
     * @param indAddrChanged the value of field 'indAddrChanged'.
     */
    public void setIndAddrChanged(boolean indAddrChanged)
    {
        this._indAddrChanged = indAddrChanged;
        this._has_indAddrChanged = true;
    } //-- void setIndAddrChanged(boolean) 

    /**
     * Sets the value of field 'indPhoneChanged'.
     * 
     * @param indPhoneChanged the value of field 'indPhoneChanged'.
     */
    public void setIndPhoneChanged(boolean indPhoneChanged)
    {
        this._indPhoneChanged = indPhoneChanged;
        this._has_indPhoneChanged = true;
    } //-- void setIndPhoneChanged(boolean) 

    /**
     * Sets the value of field 'indRsrcChanged'.
     * 
     * @param indRsrcChanged the value of field 'indRsrcChanged'.
     */
    public void setIndRsrcChanged(boolean indRsrcChanged)
    {
        this._indRsrcChanged = indRsrcChanged;
        this._has_indRsrcChanged = true;
    } //-- void setIndRsrcChanged(boolean) 

    /**
     * Sets the value of field 'lNbrRsrcFacilAcclaim'.
     * 
     * @param lNbrRsrcFacilAcclaim the value of field
     * 'lNbrRsrcFacilAcclaim'.
     */
    public void setLNbrRsrcFacilAcclaim(int lNbrRsrcFacilAcclaim)
    {
        this._lNbrRsrcFacilAcclaim = lNbrRsrcFacilAcclaim;
        this._has_lNbrRsrcFacilAcclaim = true;
    } //-- void setLNbrRsrcFacilAcclaim(int) 

    /**
     * Sets the value of field 'lNbrSchCampusNbr'.
     * 
     * @param lNbrSchCampusNbr the value of field 'lNbrSchCampusNbr'
     */
    public void setLNbrSchCampusNbr(int lNbrSchCampusNbr)
    {
        this._lNbrSchCampusNbr = lNbrSchCampusNbr;
        this._has_lNbrSchCampusNbr = true;
    } //-- void setLNbrSchCampusNbr(int) 

    /**
     * Sets the value of field 'ROWCRES04SIG00_ARRAY'.
     * 
     * @param ROWCRES04SIG00_ARRAY the value of field
     * 'ROWCRES04SIG00_ARRAY'.
     */
    public void setROWCRES04SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY ROWCRES04SIG00_ARRAY)
    {
        this._ROWCRES04SIG00_ARRAY = ROWCRES04SIG00_ARRAY;
    } //-- void setROWCRES04SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCRES04SIG01_ARRAY'.
     * 
     * @param ROWCRES04SIG01_ARRAY the value of field
     * 'ROWCRES04SIG01_ARRAY'.
     */
    public void setROWCRES04SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY ROWCRES04SIG01_ARRAY)
    {
        this._ROWCRES04SIG01_ARRAY = ROWCRES04SIG01_ARRAY;
    } //-- void setROWCRES04SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY) 

    /**
     * Sets the value of field 'szAddrRsrcEmail'.
     * 
     * @param szAddrRsrcEmail the value of field 'szAddrRsrcEmail'.
     */
    public void setSzAddrRsrcEmail(java.lang.String szAddrRsrcEmail)
    {
        this._szAddrRsrcEmail = szAddrRsrcEmail;
    } //-- void setSzAddrRsrcEmail(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcWebsite'.
     * 
     * @param szAddrRsrcWebsite the value of field
     * 'szAddrRsrcWebsite'.
     */
    public void setSzAddrRsrcWebsite(java.lang.String szAddrRsrcWebsite)
    {
        this._szAddrRsrcWebsite = szAddrRsrcWebsite;
    } //-- void setSzAddrRsrcWebsite(java.lang.String) 

    /**
     * Sets the value of field 'szCdMhmrCompCode'.
     * 
     * @param szCdMhmrCompCode the value of field 'szCdMhmrCompCode'
     */
    public void setSzCdMhmrCompCode(java.lang.String szCdMhmrCompCode)
    {
        this._szCdMhmrCompCode = szCdMhmrCompCode;
    } //-- void setSzCdMhmrCompCode(java.lang.String) 

    /**
     * Sets the value of field 'szCdPaymentDelivery'.
     * 
     * @param szCdPaymentDelivery the value of field
     * 'szCdPaymentDelivery'.
     */
    public void setSzCdPaymentDelivery(java.lang.String szCdPaymentDelivery)
    {
        this._szCdPaymentDelivery = szCdPaymentDelivery;
    } //-- void setSzCdPaymentDelivery(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcCampusType'.
     * 
     * @param szCdRsrcCampusType the value of field
     * 'szCdRsrcCampusType'.
     */
    public void setSzCdRsrcCampusType(java.lang.String szCdRsrcCampusType)
    {
        this._szCdRsrcCampusType = szCdRsrcCampusType;
    } //-- void setSzCdRsrcCampusType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFacilType'.
     * 
     * @param szCdRsrcFacilType the value of field
     * 'szCdRsrcFacilType'.
     */
    public void setSzCdRsrcFacilType(java.lang.String szCdRsrcFacilType)
    {
        this._szCdRsrcFacilType = szCdRsrcFacilType;
    } //-- void setSzCdRsrcFacilType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcHub'.
     * 
     * @param szCdRsrcHub the value of field 'szCdRsrcHub'.
     */
    public void setSzCdRsrcHub(java.lang.String szCdRsrcHub)
    {
        this._szCdRsrcHub = szCdRsrcHub;
    } //-- void setSzCdRsrcHub(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcMaintainer'.
     * 
     * @param szCdRsrcMaintainer the value of field
     * 'szCdRsrcMaintainer'.
     */
    public void setSzCdRsrcMaintainer(java.lang.String szCdRsrcMaintainer)
    {
        this._szCdRsrcMaintainer = szCdRsrcMaintainer;
    } //-- void setSzCdRsrcMaintainer(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcOwnership'.
     * 
     * @param szCdRsrcOwnership the value of field
     * 'szCdRsrcOwnership'.
     */
    public void setSzCdRsrcOwnership(java.lang.String szCdRsrcOwnership)
    {
        this._szCdRsrcOwnership = szCdRsrcOwnership;
    } //-- void setSzCdRsrcOwnership(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcStatus'.
     * 
     * @param szCdRsrcStatus the value of field 'szCdRsrcStatus'.
     */
    public void setSzCdRsrcStatus(java.lang.String szCdRsrcStatus)
    {
        this._szCdRsrcStatus = szCdRsrcStatus;
    } //-- void setSzCdRsrcStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcType'.
     * 
     * @param szCdRsrcType the value of field 'szCdRsrcType'.
     */
    public void setSzCdRsrcType(java.lang.String szCdRsrcType)
    {
        this._szCdRsrcType = szCdRsrcType;
    } //-- void setSzCdRsrcType(java.lang.String) 

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
     * Sets the value of field 'szCdSchoolType'.
     * 
     * @param szCdSchoolType the value of field 'szCdSchoolType'.
     */
    public void setSzCdSchoolType(java.lang.String szCdSchoolType)
    {
        this._szCdSchoolType = szCdSchoolType;
    } //-- void setSzCdSchoolType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrRsrcNtnlProvider'.
     * 
     * @param szNbrRsrcNtnlProvider the value of field
     * 'szNbrRsrcNtnlProvider'.
     */
    public void setSzNbrRsrcNtnlProvider(java.lang.String szNbrRsrcNtnlProvider)
    {
        this._szNbrRsrcNtnlProvider = szNbrRsrcNtnlProvider;
    } //-- void setSzNbrRsrcNtnlProvider(java.lang.String) 

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
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

    /**
     * Sets the value of field 'szNmRsrcContact'.
     * 
     * @param szNmRsrcContact the value of field 'szNmRsrcContact'.
     */
    public void setSzNmRsrcContact(java.lang.String szNmRsrcContact)
    {
        this._szNmRsrcContact = szNmRsrcContact;
    } //-- void setSzNmRsrcContact(java.lang.String) 

    /**
     * Sets the value of field 'szNmRsrcContactTitle'.
     * 
     * @param szNmRsrcContactTitle the value of field
     * 'szNmRsrcContactTitle'.
     */
    public void setSzNmRsrcContactTitle(java.lang.String szNmRsrcContactTitle)
    {
        this._szNmRsrcContactTitle = szNmRsrcContactTitle;
    } //-- void setSzNmRsrcContactTitle(java.lang.String) 

    /**
     * Sets the value of field 'szNmRsrcLastUpdate'.
     * 
     * @param szNmRsrcLastUpdate the value of field
     * 'szNmRsrcLastUpdate'.
     */
    public void setSzNmRsrcLastUpdate(java.lang.String szNmRsrcLastUpdate)
    {
        this._szNmRsrcLastUpdate = szNmRsrcLastUpdate;
    } //-- void setSzNmRsrcLastUpdate(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRsrcComments'.
     * 
     * @param szTxtRsrcComments the value of field
     * 'szTxtRsrcComments'.
     */
    public void setSzTxtRsrcComments(java.lang.String szTxtRsrcComments)
    {
        this._szTxtRsrcComments = szTxtRsrcComments;
    } //-- void setSzTxtRsrcComments(java.lang.String) 

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
     * Sets the value of field 'ulPageSizeNbr_ARRAY'.
     * 
     * @param ulPageSizeNbr_ARRAY the value of field
     * 'ulPageSizeNbr_ARRAY'.
     */
    public void setUlPageSizeNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY)
    {
        this._ulPageSizeNbr_ARRAY = ulPageSizeNbr_ARRAY;
    } //-- void setUlPageSizeNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY) 

    /**
     * Sets the value of field 'ulSysIdPriorPerson'.
     * 
     * @param ulSysIdPriorPerson the value of field
     * 'ulSysIdPriorPerson'.
     */
    public void setUlSysIdPriorPerson(int ulSysIdPriorPerson)
    {
        this._ulSysIdPriorPerson = ulSysIdPriorPerson;
        this._has_ulSysIdPriorPerson = true;
    } //-- void setUlSysIdPriorPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI unmarshal(java.io.Reader) 

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
