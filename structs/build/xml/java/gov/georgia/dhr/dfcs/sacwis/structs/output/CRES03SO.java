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
 * Class CRES03SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES03SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _bIndORSAssociateToShines
     */
    private java.lang.String _bIndORSAssociateToShines;

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
     * Field _lNbrRsrcFacilAcclaim
     */
    private int _lNbrRsrcFacilAcclaim;

    /**
     * keeps track of state for field: _lNbrRsrcFacilAcclaim
     */
    private boolean _has_lNbrRsrcFacilAcclaim;

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
     * Field _szTxtRsrcComments
     */
    private java.lang.String _szTxtRsrcComments;

    /**
     * Field _szTxtSchDistName
     */
    private java.lang.String _szTxtSchDistName;

    /**
     * Field _cIndRsrcTransport
     */
    private java.lang.String _cIndRsrcTransport;

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
     * Field _szCdMhmrCompCode
     */
    private java.lang.String _szCdMhmrCompCode;

    /**
     * Field _szCdRsrcPayment
     */
    private java.lang.String _szCdRsrcPayment;

    /**
     * Field _lNbrSchCampusNbr
     */
    private int _lNbrSchCampusNbr;

    /**
     * keeps track of state for field: _lNbrSchCampusNbr
     */
    private boolean _has_lNbrSchCampusNbr;

    /**
     * Field _dtScrDtRsrcLastUpdate
     */
    private org.exolab.castor.types.Date _dtScrDtRsrcLastUpdate;

    /**
     * Field _cScrIndRsrcPrime
     */
    private java.lang.String _cScrIndRsrcPrime;

    /**
     * Field _CScrIndRsrcSub
     */
    private java.lang.String _CScrIndRsrcSub;

    /**
     * Field _cScrIndRsrcContracted
     */
    private java.lang.String _cScrIndRsrcContracted;

    /**
     * Field _szCdIncFacilOperBy
     */
    private java.lang.String _szCdIncFacilOperBy;

    /**
     * Field _ROWCRES03SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY _ROWCRES03SOG00_ARRAY;

    /**
     * Field _ROWCRES03SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY _ROWCRES03SOG01_ARRAY;

    /**
     * Field _ROWCRES03SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY _ROWCRES03SOG02_ARRAY;

    /**
     * Field _szNmLegal
     */
    private java.lang.String _szNmLegal;

    /**
     * Field _szCdEdhistType
     */
    private java.lang.String _szCdEdhistType;

    /**
     * Field _szEdHistComments
     */
    private java.lang.String _szEdHistComments;

    /**
     * Field _szIndEdhistLicense
     */
    private java.lang.String _szIndEdhistLicense;

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
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _szNmAgencyName
     */
    private java.lang.String _szNmAgencyName;

    /**
     * Field _ulIdHomeStage
     */
    private int _ulIdHomeStage;

    /**
     * keeps track of state for field: _ulIdHomeStage
     */
    private boolean _has_ulIdHomeStage;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES03SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO()


      //-----------/
     //- Methods -/
    //-----------/

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
    public void deleteUlIdHomeStage()
    {
        this._has_ulIdHomeStage= false;
    } //-- void deleteUlIdHomeStage() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'bIndORSAssociateToShines'.
     * 
     * @return the value of field 'BIndORSAssociateToShines'.
     */
    public java.lang.String getBIndORSAssociateToShines()
    {
        return this._bIndORSAssociateToShines;
    } //-- java.lang.String getBIndORSAssociateToShines() 

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
     * Returns the value of field 'cScrIndRsrcContracted'.
     * 
     * @return the value of field 'CScrIndRsrcContracted'.
     */
    public java.lang.String getCScrIndRsrcContracted()
    {
        return this._cScrIndRsrcContracted;
    } //-- java.lang.String getCScrIndRsrcContracted() 

    /**
     * Returns the value of field 'cScrIndRsrcPrime'.
     * 
     * @return the value of field 'CScrIndRsrcPrime'.
     */
    public java.lang.String getCScrIndRsrcPrime()
    {
        return this._cScrIndRsrcPrime;
    } //-- java.lang.String getCScrIndRsrcPrime() 

    /**
     * Returns the value of field 'CScrIndRsrcSub'.
     * 
     * @return the value of field 'CScrIndRsrcSub'.
     */
    public java.lang.String getCScrIndRsrcSub()
    {
        return this._CScrIndRsrcSub;
    } //-- java.lang.String getCScrIndRsrcSub() 

    /**
     * Returns the value of field 'dtScrDtRsrcLastUpdate'.
     * 
     * @return the value of field 'DtScrDtRsrcLastUpdate'.
     */
    public org.exolab.castor.types.Date getDtScrDtRsrcLastUpdate()
    {
        return this._dtScrDtRsrcLastUpdate;
    } //-- org.exolab.castor.types.Date getDtScrDtRsrcLastUpdate() 

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
     * Returns the value of field 'ROWCRES03SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCRES03SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY getROWCRES03SOG00_ARRAY()
    {
        return this._ROWCRES03SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY getROWCRES03SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCRES03SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCRES03SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY getROWCRES03SOG01_ARRAY()
    {
        return this._ROWCRES03SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY getROWCRES03SOG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCRES03SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCRES03SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY getROWCRES03SOG02_ARRAY()
    {
        return this._ROWCRES03SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY getROWCRES03SOG02_ARRAY() 

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
     * Returns the value of field 'szCdEdhistType'.
     * 
     * @return the value of field 'SzCdEdhistType'.
     */
    public java.lang.String getSzCdEdhistType()
    {
        return this._szCdEdhistType;
    } //-- java.lang.String getSzCdEdhistType() 

    /**
     * Returns the value of field 'szCdIncFacilOperBy'.
     * 
     * @return the value of field 'SzCdIncFacilOperBy'.
     */
    public java.lang.String getSzCdIncFacilOperBy()
    {
        return this._szCdIncFacilOperBy;
    } //-- java.lang.String getSzCdIncFacilOperBy() 

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
     * Returns the value of field 'szCdRsrcCategory'.
     * 
     * @return the value of field 'SzCdRsrcCategory'.
     */
    public java.lang.String getSzCdRsrcCategory()
    {
        return this._szCdRsrcCategory;
    } //-- java.lang.String getSzCdRsrcCategory() 

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
     * Returns the value of field 'szCdRsrcPayment'.
     * 
     * @return the value of field 'SzCdRsrcPayment'.
     */
    public java.lang.String getSzCdRsrcPayment()
    {
        return this._szCdRsrcPayment;
    } //-- java.lang.String getSzCdRsrcPayment() 

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
     * Returns the value of field 'szEdHistComments'.
     * 
     * @return the value of field 'SzEdHistComments'.
     */
    public java.lang.String getSzEdHistComments()
    {
        return this._szEdHistComments;
    } //-- java.lang.String getSzEdHistComments() 

    /**
     * Returns the value of field 'szIndEdhistLicense'.
     * 
     * @return the value of field 'SzIndEdhistLicense'.
     */
    public java.lang.String getSzIndEdhistLicense()
    {
        return this._szIndEdhistLicense;
    } //-- java.lang.String getSzIndEdhistLicense() 

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
     * Returns the value of field 'szNmAgencyName'.
     * 
     * @return the value of field 'SzNmAgencyName'.
     */
    public java.lang.String getSzNmAgencyName()
    {
        return this._szNmAgencyName;
    } //-- java.lang.String getSzNmAgencyName() 

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
     * Returns the value of field 'szTxtSchDistName'.
     * 
     * @return the value of field 'SzTxtSchDistName'.
     */
    public java.lang.String getSzTxtSchDistName()
    {
        return this._szTxtSchDistName;
    } //-- java.lang.String getSzTxtSchDistName() 

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
     * Returns the value of field 'ulIdHomeStage'.
     * 
     * @return the value of field 'UlIdHomeStage'.
     */
    public int getUlIdHomeStage()
    {
        return this._ulIdHomeStage;
    } //-- int getUlIdHomeStage() 

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
     * Method hasUlIdHomeStage
     * 
     * 
     * 
     * @return true if at least one UlIdHomeStage has been added
     */
    public boolean hasUlIdHomeStage()
    {
        return this._has_ulIdHomeStage;
    } //-- boolean hasUlIdHomeStage() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'bIndORSAssociateToShines'.
     * 
     * @param bIndORSAssociateToShines the value of field
     * 'bIndORSAssociateToShines'.
     */
    public void setBIndORSAssociateToShines(java.lang.String bIndORSAssociateToShines)
    {
        this._bIndORSAssociateToShines = bIndORSAssociateToShines;
    } //-- void setBIndORSAssociateToShines(java.lang.String) 

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
     * Sets the value of field 'cScrIndRsrcContracted'.
     * 
     * @param cScrIndRsrcContracted the value of field
     * 'cScrIndRsrcContracted'.
     */
    public void setCScrIndRsrcContracted(java.lang.String cScrIndRsrcContracted)
    {
        this._cScrIndRsrcContracted = cScrIndRsrcContracted;
    } //-- void setCScrIndRsrcContracted(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndRsrcPrime'.
     * 
     * @param cScrIndRsrcPrime the value of field 'cScrIndRsrcPrime'
     */
    public void setCScrIndRsrcPrime(java.lang.String cScrIndRsrcPrime)
    {
        this._cScrIndRsrcPrime = cScrIndRsrcPrime;
    } //-- void setCScrIndRsrcPrime(java.lang.String) 

    /**
     * Sets the value of field 'CScrIndRsrcSub'.
     * 
     * @param CScrIndRsrcSub the value of field 'CScrIndRsrcSub'.
     */
    public void setCScrIndRsrcSub(java.lang.String CScrIndRsrcSub)
    {
        this._CScrIndRsrcSub = CScrIndRsrcSub;
    } //-- void setCScrIndRsrcSub(java.lang.String) 

    /**
     * Sets the value of field 'dtScrDtRsrcLastUpdate'.
     * 
     * @param dtScrDtRsrcLastUpdate the value of field
     * 'dtScrDtRsrcLastUpdate'.
     */
    public void setDtScrDtRsrcLastUpdate(org.exolab.castor.types.Date dtScrDtRsrcLastUpdate)
    {
        this._dtScrDtRsrcLastUpdate = dtScrDtRsrcLastUpdate;
    } //-- void setDtScrDtRsrcLastUpdate(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCRES03SOG00_ARRAY'.
     * 
     * @param ROWCRES03SOG00_ARRAY the value of field
     * 'ROWCRES03SOG00_ARRAY'.
     */
    public void setROWCRES03SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY ROWCRES03SOG00_ARRAY)
    {
        this._ROWCRES03SOG00_ARRAY = ROWCRES03SOG00_ARRAY;
    } //-- void setROWCRES03SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCRES03SOG01_ARRAY'.
     * 
     * @param ROWCRES03SOG01_ARRAY the value of field
     * 'ROWCRES03SOG01_ARRAY'.
     */
    public void setROWCRES03SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY ROWCRES03SOG01_ARRAY)
    {
        this._ROWCRES03SOG01_ARRAY = ROWCRES03SOG01_ARRAY;
    } //-- void setROWCRES03SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCRES03SOG02_ARRAY'.
     * 
     * @param ROWCRES03SOG02_ARRAY the value of field
     * 'ROWCRES03SOG02_ARRAY'.
     */
    public void setROWCRES03SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY ROWCRES03SOG02_ARRAY)
    {
        this._ROWCRES03SOG02_ARRAY = ROWCRES03SOG02_ARRAY;
    } //-- void setROWCRES03SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY) 

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
     * Sets the value of field 'szCdEdhistType'.
     * 
     * @param szCdEdhistType the value of field 'szCdEdhistType'.
     */
    public void setSzCdEdhistType(java.lang.String szCdEdhistType)
    {
        this._szCdEdhistType = szCdEdhistType;
    } //-- void setSzCdEdhistType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncFacilOperBy'.
     * 
     * @param szCdIncFacilOperBy the value of field
     * 'szCdIncFacilOperBy'.
     */
    public void setSzCdIncFacilOperBy(java.lang.String szCdIncFacilOperBy)
    {
        this._szCdIncFacilOperBy = szCdIncFacilOperBy;
    } //-- void setSzCdIncFacilOperBy(java.lang.String) 

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
     * Sets the value of field 'szCdRsrcCategory'.
     * 
     * @param szCdRsrcCategory the value of field 'szCdRsrcCategory'
     */
    public void setSzCdRsrcCategory(java.lang.String szCdRsrcCategory)
    {
        this._szCdRsrcCategory = szCdRsrcCategory;
    } //-- void setSzCdRsrcCategory(java.lang.String) 

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
     * Sets the value of field 'szCdRsrcPayment'.
     * 
     * @param szCdRsrcPayment the value of field 'szCdRsrcPayment'.
     */
    public void setSzCdRsrcPayment(java.lang.String szCdRsrcPayment)
    {
        this._szCdRsrcPayment = szCdRsrcPayment;
    } //-- void setSzCdRsrcPayment(java.lang.String) 

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
     * Sets the value of field 'szEdHistComments'.
     * 
     * @param szEdHistComments the value of field 'szEdHistComments'
     */
    public void setSzEdHistComments(java.lang.String szEdHistComments)
    {
        this._szEdHistComments = szEdHistComments;
    } //-- void setSzEdHistComments(java.lang.String) 

    /**
     * Sets the value of field 'szIndEdhistLicense'.
     * 
     * @param szIndEdhistLicense the value of field
     * 'szIndEdhistLicense'.
     */
    public void setSzIndEdhistLicense(java.lang.String szIndEdhistLicense)
    {
        this._szIndEdhistLicense = szIndEdhistLicense;
    } //-- void setSzIndEdhistLicense(java.lang.String) 

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
     * Sets the value of field 'szNmAgencyName'.
     * 
     * @param szNmAgencyName the value of field 'szNmAgencyName'.
     */
    public void setSzNmAgencyName(java.lang.String szNmAgencyName)
    {
        this._szNmAgencyName = szNmAgencyName;
    } //-- void setSzNmAgencyName(java.lang.String) 

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
     * Sets the value of field 'szTxtSchDistName'.
     * 
     * @param szTxtSchDistName the value of field 'szTxtSchDistName'
     */
    public void setSzTxtSchDistName(java.lang.String szTxtSchDistName)
    {
        this._szTxtSchDistName = szTxtSchDistName;
    } //-- void setSzTxtSchDistName(java.lang.String) 

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
     * Sets the value of field 'ulIdHomeStage'.
     * 
     * @param ulIdHomeStage the value of field 'ulIdHomeStage'.
     */
    public void setUlIdHomeStage(int ulIdHomeStage)
    {
        this._ulIdHomeStage = ulIdHomeStage;
        this._has_ulIdHomeStage = true;
    } //-- void setUlIdHomeStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO unmarshal(java.io.Reader) 

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
