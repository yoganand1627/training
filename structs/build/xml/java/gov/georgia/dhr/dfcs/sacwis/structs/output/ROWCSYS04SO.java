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
 * Class ROWCSYS04SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSYS04SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bIndCrossCountyLines
     */
    private java.lang.String _bIndCrossCountyLines;

    /**
     * Field _bIndContactAttempted
     */
    private java.lang.String _bIndContactAttempted;

    /**
     * Field _cIndRsrcSvcShowRow
     */
    private java.lang.String _cIndRsrcSvcShowRow;

    /**
     * Field _contactCbxRecord_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array _contactCbxRecord_Array;

    /**
     * Field _dtDTContactOccurred
     */
    private java.util.Date _dtDTContactOccurred;

    /**
     * Field _dtDtContactApprv
     */
    private org.exolab.castor.types.Date _dtDtContactApprv;

    /**
     * Field _szCdContactedBy
     */
    private java.lang.String _szCdContactedBy;

    /**
     * Field _szCdContactLocation
     */
    private java.lang.String _szCdContactLocation;

    /**
     * Field _szCdContactMethod
     */
    private java.lang.String _szCdContactMethod;

    /**
     * Field _szCdContactNarr
     */
    private java.lang.String _szCdContactNarr;

    /**
     * Field _szCdContactPurpose
     */
    private java.lang.String _szCdContactPurpose;

    /**
     * Field _szCdContactType
     */
    private java.lang.String _szCdContactType;

    /**
     * Field _szCdContactOthers
     */
    private java.lang.String _szCdContactOthers;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdTCMEligible
     */
    private java.lang.String _szCdTCMEligible;

    /**
     * Field _szCdTCMMedSvcs
     */
    private java.lang.String _szCdTCMMedSvcs;

    /**
     * Field _szNmAgencyName
     */
    private java.lang.String _szNmAgencyName;

    /**
     * Field _szNmContactedBy
     */
    private java.lang.String _szNmContactedBy;

    /**
     * Field _szNmPersonFull_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY _szNmPersonFull_ARRAY;

    /**
     * Field _szScrNmContact1
     */
    private java.lang.String _szScrNmContact1;

    /**
     * Field _szScrNmContact2
     */
    private java.lang.String _szScrNmContact2;

    /**
     * Field _szScrNmContact3
     */
    private java.lang.String _szScrNmContact3;

    /**
     * Field _szScrNmContact4
     */
    private java.lang.String _szScrNmContact4;

    /**
     * Field _szScrNmContact5
     */
    private java.lang.String _szScrNmContact5;

    /**
     * Field _ulIdTCMClient
     */
    private int _ulIdTCMClient;

    /**
     * keeps track of state for field: _ulIdTCMClient
     */
    private boolean _has_ulIdTCMClient;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _szDiscussedPersons
     */
    private java.lang.String _szDiscussedPersons;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSYS04SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdTCMClient()
    {
        this._has_ulIdTCMClient= false;
    } //-- void deleteUlIdTCMClient() 

    /**
     * Returns the value of field 'bIndContactAttempted'.
     * 
     * @return the value of field 'BIndContactAttempted'.
     */
    public java.lang.String getBIndContactAttempted()
    {
        return this._bIndContactAttempted;
    } //-- java.lang.String getBIndContactAttempted() 

    /**
     * Returns the value of field 'bIndCrossCountyLines'.
     * 
     * @return the value of field 'BIndCrossCountyLines'.
     */
    public java.lang.String getBIndCrossCountyLines()
    {
        return this._bIndCrossCountyLines;
    } //-- java.lang.String getBIndCrossCountyLines() 

    /**
     * Returns the value of field 'cIndRsrcSvcShowRow'.
     * 
     * @return the value of field 'CIndRsrcSvcShowRow'.
     */
    public java.lang.String getCIndRsrcSvcShowRow()
    {
        return this._cIndRsrcSvcShowRow;
    } //-- java.lang.String getCIndRsrcSvcShowRow() 

    /**
     * Returns the value of field 'contactCbxRecord_Array'.
     * 
     * @return the value of field 'ContactCbxRecord_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array getContactCbxRecord_Array()
    {
        return this._contactCbxRecord_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array getContactCbxRecord_Array() 

    /**
     * Returns the value of field 'dtDTContactOccurred'.
     * 
     * @return the value of field 'DtDTContactOccurred'.
     */
    public java.util.Date getDtDTContactOccurred()
    {
        return this._dtDTContactOccurred;
    } //-- java.util.Date getDtDTContactOccurred() 

    /**
     * Returns the value of field 'dtDtContactApprv'.
     * 
     * @return the value of field 'DtDtContactApprv'.
     */
    public org.exolab.castor.types.Date getDtDtContactApprv()
    {
        return this._dtDtContactApprv;
    } //-- org.exolab.castor.types.Date getDtDtContactApprv() 

    /**
     * Returns the value of field 'szCdContactLocation'.
     * 
     * @return the value of field 'SzCdContactLocation'.
     */
    public java.lang.String getSzCdContactLocation()
    {
        return this._szCdContactLocation;
    } //-- java.lang.String getSzCdContactLocation() 

    /**
     * Returns the value of field 'szCdContactMethod'.
     * 
     * @return the value of field 'SzCdContactMethod'.
     */
    public java.lang.String getSzCdContactMethod()
    {
        return this._szCdContactMethod;
    } //-- java.lang.String getSzCdContactMethod() 

    /**
     * Returns the value of field 'szCdContactNarr'.
     * 
     * @return the value of field 'SzCdContactNarr'.
     */
    public java.lang.String getSzCdContactNarr()
    {
        return this._szCdContactNarr;
    } //-- java.lang.String getSzCdContactNarr() 

    /**
     * Returns the value of field 'szCdContactOthers'.
     * 
     * @return the value of field 'SzCdContactOthers'.
     */
    public java.lang.String getSzCdContactOthers()
    {
        return this._szCdContactOthers;
    } //-- java.lang.String getSzCdContactOthers() 

    /**
     * Returns the value of field 'szCdContactPurpose'.
     * 
     * @return the value of field 'SzCdContactPurpose'.
     */
    public java.lang.String getSzCdContactPurpose()
    {
        return this._szCdContactPurpose;
    } //-- java.lang.String getSzCdContactPurpose() 

    /**
     * Returns the value of field 'szCdContactType'.
     * 
     * @return the value of field 'SzCdContactType'.
     */
    public java.lang.String getSzCdContactType()
    {
        return this._szCdContactType;
    } //-- java.lang.String getSzCdContactType() 

    /**
     * Returns the value of field 'szCdContactedBy'.
     * 
     * @return the value of field 'SzCdContactedBy'.
     */
    public java.lang.String getSzCdContactedBy()
    {
        return this._szCdContactedBy;
    } //-- java.lang.String getSzCdContactedBy() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szCdTCMEligible'.
     * 
     * @return the value of field 'SzCdTCMEligible'.
     */
    public java.lang.String getSzCdTCMEligible()
    {
        return this._szCdTCMEligible;
    } //-- java.lang.String getSzCdTCMEligible() 

    /**
     * Returns the value of field 'szCdTCMMedSvcs'.
     * 
     * @return the value of field 'SzCdTCMMedSvcs'.
     */
    public java.lang.String getSzCdTCMMedSvcs()
    {
        return this._szCdTCMMedSvcs;
    } //-- java.lang.String getSzCdTCMMedSvcs() 

    /**
     * Returns the value of field 'szDiscussedPersons'.
     * 
     * @return the value of field 'SzDiscussedPersons'.
     */
    public java.lang.String getSzDiscussedPersons()
    {
        return this._szDiscussedPersons;
    } //-- java.lang.String getSzDiscussedPersons() 

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
     * Returns the value of field 'szNmContactedBy'.
     * 
     * @return the value of field 'SzNmContactedBy'.
     */
    public java.lang.String getSzNmContactedBy()
    {
        return this._szNmContactedBy;
    } //-- java.lang.String getSzNmContactedBy() 

    /**
     * Returns the value of field 'szNmPersonFull_ARRAY'.
     * 
     * @return the value of field 'SzNmPersonFull_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY getSzNmPersonFull_ARRAY()
    {
        return this._szNmPersonFull_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY getSzNmPersonFull_ARRAY() 

    /**
     * Returns the value of field 'szScrNmContact1'.
     * 
     * @return the value of field 'SzScrNmContact1'.
     */
    public java.lang.String getSzScrNmContact1()
    {
        return this._szScrNmContact1;
    } //-- java.lang.String getSzScrNmContact1() 

    /**
     * Returns the value of field 'szScrNmContact2'.
     * 
     * @return the value of field 'SzScrNmContact2'.
     */
    public java.lang.String getSzScrNmContact2()
    {
        return this._szScrNmContact2;
    } //-- java.lang.String getSzScrNmContact2() 

    /**
     * Returns the value of field 'szScrNmContact3'.
     * 
     * @return the value of field 'SzScrNmContact3'.
     */
    public java.lang.String getSzScrNmContact3()
    {
        return this._szScrNmContact3;
    } //-- java.lang.String getSzScrNmContact3() 

    /**
     * Returns the value of field 'szScrNmContact4'.
     * 
     * @return the value of field 'SzScrNmContact4'.
     */
    public java.lang.String getSzScrNmContact4()
    {
        return this._szScrNmContact4;
    } //-- java.lang.String getSzScrNmContact4() 

    /**
     * Returns the value of field 'szScrNmContact5'.
     * 
     * @return the value of field 'SzScrNmContact5'.
     */
    public java.lang.String getSzScrNmContact5()
    {
        return this._szScrNmContact5;
    } //-- java.lang.String getSzScrNmContact5() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

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
     * Returns the value of field 'ulIdTCMClient'.
     * 
     * @return the value of field 'UlIdTCMClient'.
     */
    public int getUlIdTCMClient()
    {
        return this._ulIdTCMClient;
    } //-- int getUlIdTCMClient() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Method hasUlIdTCMClient
     * 
     * 
     * 
     * @return true if at least one UlIdTCMClient has been added
     */
    public boolean hasUlIdTCMClient()
    {
        return this._has_ulIdTCMClient;
    } //-- boolean hasUlIdTCMClient() 

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
     * Sets the value of field 'bIndContactAttempted'.
     * 
     * @param bIndContactAttempted the value of field
     * 'bIndContactAttempted'.
     */
    public void setBIndContactAttempted(java.lang.String bIndContactAttempted)
    {
        this._bIndContactAttempted = bIndContactAttempted;
    } //-- void setBIndContactAttempted(java.lang.String) 

    /**
     * Sets the value of field 'bIndCrossCountyLines'.
     * 
     * @param bIndCrossCountyLines the value of field
     * 'bIndCrossCountyLines'.
     */
    public void setBIndCrossCountyLines(java.lang.String bIndCrossCountyLines)
    {
        this._bIndCrossCountyLines = bIndCrossCountyLines;
    } //-- void setBIndCrossCountyLines(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcSvcShowRow'.
     * 
     * @param cIndRsrcSvcShowRow the value of field
     * 'cIndRsrcSvcShowRow'.
     */
    public void setCIndRsrcSvcShowRow(java.lang.String cIndRsrcSvcShowRow)
    {
        this._cIndRsrcSvcShowRow = cIndRsrcSvcShowRow;
    } //-- void setCIndRsrcSvcShowRow(java.lang.String) 

    /**
     * Sets the value of field 'contactCbxRecord_Array'.
     * 
     * @param contactCbxRecord_Array the value of field
     * 'contactCbxRecord_Array'.
     */
    public void setContactCbxRecord_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array contactCbxRecord_Array)
    {
        this._contactCbxRecord_Array = contactCbxRecord_Array;
    } //-- void setContactCbxRecord_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array) 

    /**
     * Sets the value of field 'dtDTContactOccurred'.
     * 
     * @param dtDTContactOccurred the value of field
     * 'dtDTContactOccurred'.
     */
    public void setDtDTContactOccurred(java.util.Date dtDTContactOccurred)
    {
        this._dtDTContactOccurred = dtDTContactOccurred;
    } //-- void setDtDTContactOccurred(java.util.Date) 

    /**
     * Sets the value of field 'dtDtContactApprv'.
     * 
     * @param dtDtContactApprv the value of field 'dtDtContactApprv'
     */
    public void setDtDtContactApprv(org.exolab.castor.types.Date dtDtContactApprv)
    {
        this._dtDtContactApprv = dtDtContactApprv;
    } //-- void setDtDtContactApprv(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdContactLocation'.
     * 
     * @param szCdContactLocation the value of field
     * 'szCdContactLocation'.
     */
    public void setSzCdContactLocation(java.lang.String szCdContactLocation)
    {
        this._szCdContactLocation = szCdContactLocation;
    } //-- void setSzCdContactLocation(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactMethod'.
     * 
     * @param szCdContactMethod the value of field
     * 'szCdContactMethod'.
     */
    public void setSzCdContactMethod(java.lang.String szCdContactMethod)
    {
        this._szCdContactMethod = szCdContactMethod;
    } //-- void setSzCdContactMethod(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactNarr'.
     * 
     * @param szCdContactNarr the value of field 'szCdContactNarr'.
     */
    public void setSzCdContactNarr(java.lang.String szCdContactNarr)
    {
        this._szCdContactNarr = szCdContactNarr;
    } //-- void setSzCdContactNarr(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactOthers'.
     * 
     * @param szCdContactOthers the value of field
     * 'szCdContactOthers'.
     */
    public void setSzCdContactOthers(java.lang.String szCdContactOthers)
    {
        this._szCdContactOthers = szCdContactOthers;
    } //-- void setSzCdContactOthers(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactPurpose'.
     * 
     * @param szCdContactPurpose the value of field
     * 'szCdContactPurpose'.
     */
    public void setSzCdContactPurpose(java.lang.String szCdContactPurpose)
    {
        this._szCdContactPurpose = szCdContactPurpose;
    } //-- void setSzCdContactPurpose(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactType'.
     * 
     * @param szCdContactType the value of field 'szCdContactType'.
     */
    public void setSzCdContactType(java.lang.String szCdContactType)
    {
        this._szCdContactType = szCdContactType;
    } //-- void setSzCdContactType(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactedBy'.
     * 
     * @param szCdContactedBy the value of field 'szCdContactedBy'.
     */
    public void setSzCdContactedBy(java.lang.String szCdContactedBy)
    {
        this._szCdContactedBy = szCdContactedBy;
    } //-- void setSzCdContactedBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdTCMEligible'.
     * 
     * @param szCdTCMEligible the value of field 'szCdTCMEligible'.
     */
    public void setSzCdTCMEligible(java.lang.String szCdTCMEligible)
    {
        this._szCdTCMEligible = szCdTCMEligible;
    } //-- void setSzCdTCMEligible(java.lang.String) 

    /**
     * Sets the value of field 'szCdTCMMedSvcs'.
     * 
     * @param szCdTCMMedSvcs the value of field 'szCdTCMMedSvcs'.
     */
    public void setSzCdTCMMedSvcs(java.lang.String szCdTCMMedSvcs)
    {
        this._szCdTCMMedSvcs = szCdTCMMedSvcs;
    } //-- void setSzCdTCMMedSvcs(java.lang.String) 

    /**
     * Sets the value of field 'szDiscussedPersons'.
     * 
     * @param szDiscussedPersons the value of field
     * 'szDiscussedPersons'.
     */
    public void setSzDiscussedPersons(java.lang.String szDiscussedPersons)
    {
        this._szDiscussedPersons = szDiscussedPersons;
    } //-- void setSzDiscussedPersons(java.lang.String) 

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
     * Sets the value of field 'szNmContactedBy'.
     * 
     * @param szNmContactedBy the value of field 'szNmContactedBy'.
     */
    public void setSzNmContactedBy(java.lang.String szNmContactedBy)
    {
        this._szNmContactedBy = szNmContactedBy;
    } //-- void setSzNmContactedBy(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull_ARRAY'.
     * 
     * @param szNmPersonFull_ARRAY the value of field
     * 'szNmPersonFull_ARRAY'.
     */
    public void setSzNmPersonFull_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY szNmPersonFull_ARRAY)
    {
        this._szNmPersonFull_ARRAY = szNmPersonFull_ARRAY;
    } //-- void setSzNmPersonFull_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY) 

    /**
     * Sets the value of field 'szScrNmContact1'.
     * 
     * @param szScrNmContact1 the value of field 'szScrNmContact1'.
     */
    public void setSzScrNmContact1(java.lang.String szScrNmContact1)
    {
        this._szScrNmContact1 = szScrNmContact1;
    } //-- void setSzScrNmContact1(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmContact2'.
     * 
     * @param szScrNmContact2 the value of field 'szScrNmContact2'.
     */
    public void setSzScrNmContact2(java.lang.String szScrNmContact2)
    {
        this._szScrNmContact2 = szScrNmContact2;
    } //-- void setSzScrNmContact2(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmContact3'.
     * 
     * @param szScrNmContact3 the value of field 'szScrNmContact3'.
     */
    public void setSzScrNmContact3(java.lang.String szScrNmContact3)
    {
        this._szScrNmContact3 = szScrNmContact3;
    } //-- void setSzScrNmContact3(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmContact4'.
     * 
     * @param szScrNmContact4 the value of field 'szScrNmContact4'.
     */
    public void setSzScrNmContact4(java.lang.String szScrNmContact4)
    {
        this._szScrNmContact4 = szScrNmContact4;
    } //-- void setSzScrNmContact4(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmContact5'.
     * 
     * @param szScrNmContact5 the value of field 'szScrNmContact5'.
     */
    public void setSzScrNmContact5(java.lang.String szScrNmContact5)
    {
        this._szScrNmContact5 = szScrNmContact5;
    } //-- void setSzScrNmContact5(java.lang.String) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

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
     * Sets the value of field 'ulIdTCMClient'.
     * 
     * @param ulIdTCMClient the value of field 'ulIdTCMClient'.
     */
    public void setUlIdTCMClient(int ulIdTCMClient)
    {
        this._ulIdTCMClient = ulIdTCMClient;
        this._has_ulIdTCMClient = true;
    } //-- void setUlIdTCMClient(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO unmarshal(java.io.Reader) 

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
