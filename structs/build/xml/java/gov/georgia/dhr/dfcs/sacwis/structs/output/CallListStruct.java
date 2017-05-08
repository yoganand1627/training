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
 * Class CallListStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallListStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szScrNmIncmgCaller
     */
    private java.lang.String _szScrNmIncmgCaller;

    /**
     * Field _szScrNmInReName
     */
    private java.lang.String _szScrNmInReName;

    /**
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;

    /**
     * Field _szCdIncomingDisposition
     */
    private java.lang.String _szCdIncomingDisposition;

    /**
     * Field _dtDtIncomingCall
     */
    private org.exolab.castor.types.Date _dtDtIncomingCall;

    /**
     * Field _tmTmIncmgCall
     */
    private java.lang.String _tmTmIncmgCall;

    /**
     * Field _szCdAddrCounty
     */
    private java.lang.String _szCdAddrCounty;

    /**
     * Field _szAddrCity
     */
    private java.lang.String _szAddrCity;

    /**
     * Field _cdIncmgStatus
     */
    private java.lang.String _cdIncmgStatus;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdStageCurrPriority
     */
    private java.lang.String _szCdStageCurrPriority;

    /**
     * Field _szScrPersonName
     */
    private java.lang.String _szScrPersonName;

    /**
     * Field _ulIdIncomingWorker
     */
    private int _ulIdIncomingWorker;

    /**
     * keeps track of state for field: _ulIdIncomingWorker
     */
    private boolean _has_ulIdIncomingWorker;

    /**
     * Field _bIndIncmgIntInvClsReclss
     */
    private java.lang.String _bIndIncmgIntInvClsReclss;

    /**
     * Field _bIndIncmgSensitive
     */
    private java.lang.String _bIndIncmgSensitive;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallListStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdIncomingWorker()
    {
        this._has_ulIdIncomingWorker= false;
    } //-- void deleteUlIdIncomingWorker() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndIncmgIntInvClsReclss'.
     * 
     * @return the value of field 'BIndIncmgIntInvClsReclss'.
     */
    public java.lang.String getBIndIncmgIntInvClsReclss()
    {
        return this._bIndIncmgIntInvClsReclss;
    } //-- java.lang.String getBIndIncmgIntInvClsReclss() 

    /**
     * Returns the value of field 'bIndIncmgSensitive'.
     * 
     * @return the value of field 'BIndIncmgSensitive'.
     */
    public java.lang.String getBIndIncmgSensitive()
    {
        return this._bIndIncmgSensitive;
    } //-- java.lang.String getBIndIncmgSensitive() 

    /**
     * Returns the value of field 'cdIncmgStatus'.
     * 
     * @return the value of field 'CdIncmgStatus'.
     */
    public java.lang.String getCdIncmgStatus()
    {
        return this._cdIncmgStatus;
    } //-- java.lang.String getCdIncmgStatus() 

    /**
     * Returns the value of field 'dtDtIncomingCall'.
     * 
     * @return the value of field 'DtDtIncomingCall'.
     */
    public org.exolab.castor.types.Date getDtDtIncomingCall()
    {
        return this._dtDtIncomingCall;
    } //-- org.exolab.castor.types.Date getDtDtIncomingCall() 

    /**
     * Returns the value of field 'szAddrCity'.
     * 
     * @return the value of field 'SzAddrCity'.
     */
    public java.lang.String getSzAddrCity()
    {
        return this._szAddrCity;
    } //-- java.lang.String getSzAddrCity() 

    /**
     * Returns the value of field 'szCdAddrCounty'.
     * 
     * @return the value of field 'SzCdAddrCounty'.
     */
    public java.lang.String getSzCdAddrCounty()
    {
        return this._szCdAddrCounty;
    } //-- java.lang.String getSzCdAddrCounty() 

    /**
     * Returns the value of field 'szCdIncomingDisposition'.
     * 
     * @return the value of field 'SzCdIncomingDisposition'.
     */
    public java.lang.String getSzCdIncomingDisposition()
    {
        return this._szCdIncomingDisposition;
    } //-- java.lang.String getSzCdIncomingDisposition() 

    /**
     * Returns the value of field 'szCdStageClassification'.
     * 
     * @return the value of field 'SzCdStageClassification'.
     */
    public java.lang.String getSzCdStageClassification()
    {
        return this._szCdStageClassification;
    } //-- java.lang.String getSzCdStageClassification() 

    /**
     * Returns the value of field 'szCdStageCurrPriority'.
     * 
     * @return the value of field 'SzCdStageCurrPriority'.
     */
    public java.lang.String getSzCdStageCurrPriority()
    {
        return this._szCdStageCurrPriority;
    } //-- java.lang.String getSzCdStageCurrPriority() 

    /**
     * Returns the value of field 'szScrNmInReName'.
     * 
     * @return the value of field 'SzScrNmInReName'.
     */
    public java.lang.String getSzScrNmInReName()
    {
        return this._szScrNmInReName;
    } //-- java.lang.String getSzScrNmInReName() 

    /**
     * Returns the value of field 'szScrNmIncmgCaller'.
     * 
     * @return the value of field 'SzScrNmIncmgCaller'.
     */
    public java.lang.String getSzScrNmIncmgCaller()
    {
        return this._szScrNmIncmgCaller;
    } //-- java.lang.String getSzScrNmIncmgCaller() 

    /**
     * Returns the value of field 'szScrPersonName'.
     * 
     * @return the value of field 'SzScrPersonName'.
     */
    public java.lang.String getSzScrPersonName()
    {
        return this._szScrPersonName;
    } //-- java.lang.String getSzScrPersonName() 

    /**
     * Returns the value of field 'tmTmIncmgCall'.
     * 
     * @return the value of field 'TmTmIncmgCall'.
     */
    public java.lang.String getTmTmIncmgCall()
    {
        return this._tmTmIncmgCall;
    } //-- java.lang.String getTmTmIncmgCall() 

    /**
     * Returns the value of field 'ulIdIncomingWorker'.
     * 
     * @return the value of field 'UlIdIncomingWorker'.
     */
    public int getUlIdIncomingWorker()
    {
        return this._ulIdIncomingWorker;
    } //-- int getUlIdIncomingWorker() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Method hasUlIdIncomingWorker
     * 
     * 
     * 
     * @return true if at least one UlIdIncomingWorker has been adde
     */
    public boolean hasUlIdIncomingWorker()
    {
        return this._has_ulIdIncomingWorker;
    } //-- boolean hasUlIdIncomingWorker() 

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
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

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
     * Sets the value of field 'bIndIncmgIntInvClsReclss'.
     * 
     * @param bIndIncmgIntInvClsReclss the value of field
     * 'bIndIncmgIntInvClsReclss'.
     */
    public void setBIndIncmgIntInvClsReclss(java.lang.String bIndIncmgIntInvClsReclss)
    {
        this._bIndIncmgIntInvClsReclss = bIndIncmgIntInvClsReclss;
    } //-- void setBIndIncmgIntInvClsReclss(java.lang.String) 

    /**
     * Sets the value of field 'bIndIncmgSensitive'.
     * 
     * @param bIndIncmgSensitive the value of field
     * 'bIndIncmgSensitive'.
     */
    public void setBIndIncmgSensitive(java.lang.String bIndIncmgSensitive)
    {
        this._bIndIncmgSensitive = bIndIncmgSensitive;
    } //-- void setBIndIncmgSensitive(java.lang.String) 

    /**
     * Sets the value of field 'cdIncmgStatus'.
     * 
     * @param cdIncmgStatus the value of field 'cdIncmgStatus'.
     */
    public void setCdIncmgStatus(java.lang.String cdIncmgStatus)
    {
        this._cdIncmgStatus = cdIncmgStatus;
    } //-- void setCdIncmgStatus(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncomingCall'.
     * 
     * @param dtDtIncomingCall the value of field 'dtDtIncomingCall'
     */
    public void setDtDtIncomingCall(org.exolab.castor.types.Date dtDtIncomingCall)
    {
        this._dtDtIncomingCall = dtDtIncomingCall;
    } //-- void setDtDtIncomingCall(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szAddrCity'.
     * 
     * @param szAddrCity the value of field 'szAddrCity'.
     */
    public void setSzAddrCity(java.lang.String szAddrCity)
    {
        this._szAddrCity = szAddrCity;
    } //-- void setSzAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdAddrCounty'.
     * 
     * @param szCdAddrCounty the value of field 'szCdAddrCounty'.
     */
    public void setSzCdAddrCounty(java.lang.String szCdAddrCounty)
    {
        this._szCdAddrCounty = szCdAddrCounty;
    } //-- void setSzCdAddrCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingDisposition'.
     * 
     * @param szCdIncomingDisposition the value of field
     * 'szCdIncomingDisposition'.
     */
    public void setSzCdIncomingDisposition(java.lang.String szCdIncomingDisposition)
    {
        this._szCdIncomingDisposition = szCdIncomingDisposition;
    } //-- void setSzCdIncomingDisposition(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageClassification'.
     * 
     * @param szCdStageClassification the value of field
     * 'szCdStageClassification'.
     */
    public void setSzCdStageClassification(java.lang.String szCdStageClassification)
    {
        this._szCdStageClassification = szCdStageClassification;
    } //-- void setSzCdStageClassification(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCurrPriority'.
     * 
     * @param szCdStageCurrPriority the value of field
     * 'szCdStageCurrPriority'.
     */
    public void setSzCdStageCurrPriority(java.lang.String szCdStageCurrPriority)
    {
        this._szCdStageCurrPriority = szCdStageCurrPriority;
    } //-- void setSzCdStageCurrPriority(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmInReName'.
     * 
     * @param szScrNmInReName the value of field 'szScrNmInReName'.
     */
    public void setSzScrNmInReName(java.lang.String szScrNmInReName)
    {
        this._szScrNmInReName = szScrNmInReName;
    } //-- void setSzScrNmInReName(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmIncmgCaller'.
     * 
     * @param szScrNmIncmgCaller the value of field
     * 'szScrNmIncmgCaller'.
     */
    public void setSzScrNmIncmgCaller(java.lang.String szScrNmIncmgCaller)
    {
        this._szScrNmIncmgCaller = szScrNmIncmgCaller;
    } //-- void setSzScrNmIncmgCaller(java.lang.String) 

    /**
     * Sets the value of field 'szScrPersonName'.
     * 
     * @param szScrPersonName the value of field 'szScrPersonName'.
     */
    public void setSzScrPersonName(java.lang.String szScrPersonName)
    {
        this._szScrPersonName = szScrPersonName;
    } //-- void setSzScrPersonName(java.lang.String) 

    /**
     * Sets the value of field 'tmTmIncmgCall'.
     * 
     * @param tmTmIncmgCall the value of field 'tmTmIncmgCall'.
     */
    public void setTmTmIncmgCall(java.lang.String tmTmIncmgCall)
    {
        this._tmTmIncmgCall = tmTmIncmgCall;
    } //-- void setTmTmIncmgCall(java.lang.String) 

    /**
     * Sets the value of field 'ulIdIncomingWorker'.
     * 
     * @param ulIdIncomingWorker the value of field
     * 'ulIdIncomingWorker'.
     */
    public void setUlIdIncomingWorker(int ulIdIncomingWorker)
    {
        this._ulIdIncomingWorker = ulIdIncomingWorker;
        this._has_ulIdIncomingWorker = true;
    } //-- void setUlIdIncomingWorker(int) 

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
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct unmarshal(java.io.Reader) 

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
