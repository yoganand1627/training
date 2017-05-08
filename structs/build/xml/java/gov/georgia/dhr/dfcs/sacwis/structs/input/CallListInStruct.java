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
 * Class CallListInStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallListInStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _nmIncomingCallerFirst
     */
    private java.lang.String _nmIncomingCallerFirst;

    /**
     * Field _nmIncomingCallerMiddle
     */
    private java.lang.String _nmIncomingCallerMiddle;

    /**
     * Field _nmIncomingCallerLast
     */
    private java.lang.String _nmIncomingCallerLast;

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;

    /**
     * Field _szCdInfoAndRefrl
     */
    private java.lang.String _szCdInfoAndRefrl;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szAddrIncomingCallerCity
     */
    private java.lang.String _szAddrIncomingCallerCity;

    /**
     * Field _szCdIncomingCallerCounty
     */
    private java.lang.String _szCdIncomingCallerCounty;

    /**
     * Field _szCdIncomingDisposition
     */
    private java.lang.String _szCdIncomingDisposition;

    /**
     * Field _szCdStageRegion
     */
    private java.lang.String _szCdStageRegion;

    /**
     * Field _cdIncmgStatus
     */
    private java.lang.String _cdIncmgStatus;

    /**
     * Field _szScrDtRangeFrom
     */
    private org.exolab.castor.types.Date _szScrDtRangeFrom;

    /**
     * Field _szScrDtRangeTo
     */
    private org.exolab.castor.types.Date _szScrDtRangeTo;

    /**
     * Field _szScrTimeFrom
     */
    private java.lang.String _szScrTimeFrom;

    /**
     * Field _szScrTmTimeTo
     */
    private java.lang.String _szScrTmTimeTo;

    /**
     * Field _szCdStageCurrPriority
     */
    private java.lang.String _szCdStageCurrPriority;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szCdStageNonIncType
     */
    private java.lang.String _szCdStageNonIncType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallListInStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'nmIncomingCallerFirst'.
     * 
     * @return the value of field 'NmIncomingCallerFirst'.
     */
    public java.lang.String getNmIncomingCallerFirst()
    {
        return this._nmIncomingCallerFirst;
    } //-- java.lang.String getNmIncomingCallerFirst() 

    /**
     * Returns the value of field 'nmIncomingCallerLast'.
     * 
     * @return the value of field 'NmIncomingCallerLast'.
     */
    public java.lang.String getNmIncomingCallerLast()
    {
        return this._nmIncomingCallerLast;
    } //-- java.lang.String getNmIncomingCallerLast() 

    /**
     * Returns the value of field 'nmIncomingCallerMiddle'.
     * 
     * @return the value of field 'NmIncomingCallerMiddle'.
     */
    public java.lang.String getNmIncomingCallerMiddle()
    {
        return this._nmIncomingCallerMiddle;
    } //-- java.lang.String getNmIncomingCallerMiddle() 

    /**
     * Returns the value of field 'szAddrIncomingCallerCity'.
     * 
     * @return the value of field 'SzAddrIncomingCallerCity'.
     */
    public java.lang.String getSzAddrIncomingCallerCity()
    {
        return this._szAddrIncomingCallerCity;
    } //-- java.lang.String getSzAddrIncomingCallerCity() 

    /**
     * Returns the value of field 'szCdIncomingCallerCounty'.
     * 
     * @return the value of field 'SzCdIncomingCallerCounty'.
     */
    public java.lang.String getSzCdIncomingCallerCounty()
    {
        return this._szCdIncomingCallerCounty;
    } //-- java.lang.String getSzCdIncomingCallerCounty() 

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
     * Returns the value of field 'szCdInfoAndRefrl'.
     * 
     * @return the value of field 'SzCdInfoAndRefrl'.
     */
    public java.lang.String getSzCdInfoAndRefrl()
    {
        return this._szCdInfoAndRefrl;
    } //-- java.lang.String getSzCdInfoAndRefrl() 

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
     * Returns the value of field 'szCdStageNonIncType'.
     * 
     * @return the value of field 'SzCdStageNonIncType'.
     */
    public java.lang.String getSzCdStageNonIncType()
    {
        return this._szCdStageNonIncType;
    } //-- java.lang.String getSzCdStageNonIncType() 

    /**
     * Returns the value of field 'szCdStagePersType'.
     * 
     * @return the value of field 'SzCdStagePersType'.
     */
    public java.lang.String getSzCdStagePersType()
    {
        return this._szCdStagePersType;
    } //-- java.lang.String getSzCdStagePersType() 

    /**
     * Returns the value of field 'szCdStageRegion'.
     * 
     * @return the value of field 'SzCdStageRegion'.
     */
    public java.lang.String getSzCdStageRegion()
    {
        return this._szCdStageRegion;
    } //-- java.lang.String getSzCdStageRegion() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

    /**
     * Returns the value of field 'szScrDtRangeFrom'.
     * 
     * @return the value of field 'SzScrDtRangeFrom'.
     */
    public org.exolab.castor.types.Date getSzScrDtRangeFrom()
    {
        return this._szScrDtRangeFrom;
    } //-- org.exolab.castor.types.Date getSzScrDtRangeFrom() 

    /**
     * Returns the value of field 'szScrDtRangeTo'.
     * 
     * @return the value of field 'SzScrDtRangeTo'.
     */
    public org.exolab.castor.types.Date getSzScrDtRangeTo()
    {
        return this._szScrDtRangeTo;
    } //-- org.exolab.castor.types.Date getSzScrDtRangeTo() 

    /**
     * Returns the value of field 'szScrTimeFrom'.
     * 
     * @return the value of field 'SzScrTimeFrom'.
     */
    public java.lang.String getSzScrTimeFrom()
    {
        return this._szScrTimeFrom;
    } //-- java.lang.String getSzScrTimeFrom() 

    /**
     * Returns the value of field 'szScrTmTimeTo'.
     * 
     * @return the value of field 'SzScrTmTimeTo'.
     */
    public java.lang.String getSzScrTmTimeTo()
    {
        return this._szScrTmTimeTo;
    } //-- java.lang.String getSzScrTmTimeTo() 

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
     * Sets the value of field 'cdIncmgStatus'.
     * 
     * @param cdIncmgStatus the value of field 'cdIncmgStatus'.
     */
    public void setCdIncmgStatus(java.lang.String cdIncmgStatus)
    {
        this._cdIncmgStatus = cdIncmgStatus;
    } //-- void setCdIncmgStatus(java.lang.String) 

    /**
     * Sets the value of field 'nmIncomingCallerFirst'.
     * 
     * @param nmIncomingCallerFirst the value of field
     * 'nmIncomingCallerFirst'.
     */
    public void setNmIncomingCallerFirst(java.lang.String nmIncomingCallerFirst)
    {
        this._nmIncomingCallerFirst = nmIncomingCallerFirst;
    } //-- void setNmIncomingCallerFirst(java.lang.String) 

    /**
     * Sets the value of field 'nmIncomingCallerLast'.
     * 
     * @param nmIncomingCallerLast the value of field
     * 'nmIncomingCallerLast'.
     */
    public void setNmIncomingCallerLast(java.lang.String nmIncomingCallerLast)
    {
        this._nmIncomingCallerLast = nmIncomingCallerLast;
    } //-- void setNmIncomingCallerLast(java.lang.String) 

    /**
     * Sets the value of field 'nmIncomingCallerMiddle'.
     * 
     * @param nmIncomingCallerMiddle the value of field
     * 'nmIncomingCallerMiddle'.
     */
    public void setNmIncomingCallerMiddle(java.lang.String nmIncomingCallerMiddle)
    {
        this._nmIncomingCallerMiddle = nmIncomingCallerMiddle;
    } //-- void setNmIncomingCallerMiddle(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncomingCallerCity'.
     * 
     * @param szAddrIncomingCallerCity the value of field
     * 'szAddrIncomingCallerCity'.
     */
    public void setSzAddrIncomingCallerCity(java.lang.String szAddrIncomingCallerCity)
    {
        this._szAddrIncomingCallerCity = szAddrIncomingCallerCity;
    } //-- void setSzAddrIncomingCallerCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingCallerCounty'.
     * 
     * @param szCdIncomingCallerCounty the value of field
     * 'szCdIncomingCallerCounty'.
     */
    public void setSzCdIncomingCallerCounty(java.lang.String szCdIncomingCallerCounty)
    {
        this._szCdIncomingCallerCounty = szCdIncomingCallerCounty;
    } //-- void setSzCdIncomingCallerCounty(java.lang.String) 

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
     * Sets the value of field 'szCdInfoAndRefrl'.
     * 
     * @param szCdInfoAndRefrl the value of field 'szCdInfoAndRefrl'
     */
    public void setSzCdInfoAndRefrl(java.lang.String szCdInfoAndRefrl)
    {
        this._szCdInfoAndRefrl = szCdInfoAndRefrl;
    } //-- void setSzCdInfoAndRefrl(java.lang.String) 

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
     * Sets the value of field 'szCdStageNonIncType'.
     * 
     * @param szCdStageNonIncType the value of field
     * 'szCdStageNonIncType'.
     */
    public void setSzCdStageNonIncType(java.lang.String szCdStageNonIncType)
    {
        this._szCdStageNonIncType = szCdStageNonIncType;
    } //-- void setSzCdStageNonIncType(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersType'.
     * 
     * @param szCdStagePersType the value of field
     * 'szCdStagePersType'.
     */
    public void setSzCdStagePersType(java.lang.String szCdStagePersType)
    {
        this._szCdStagePersType = szCdStagePersType;
    } //-- void setSzCdStagePersType(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRegion'.
     * 
     * @param szCdStageRegion the value of field 'szCdStageRegion'.
     */
    public void setSzCdStageRegion(java.lang.String szCdStageRegion)
    {
        this._szCdStageRegion = szCdStageRegion;
    } //-- void setSzCdStageRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

    /**
     * Sets the value of field 'szScrDtRangeFrom'.
     * 
     * @param szScrDtRangeFrom the value of field 'szScrDtRangeFrom'
     */
    public void setSzScrDtRangeFrom(org.exolab.castor.types.Date szScrDtRangeFrom)
    {
        this._szScrDtRangeFrom = szScrDtRangeFrom;
    } //-- void setSzScrDtRangeFrom(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szScrDtRangeTo'.
     * 
     * @param szScrDtRangeTo the value of field 'szScrDtRangeTo'.
     */
    public void setSzScrDtRangeTo(org.exolab.castor.types.Date szScrDtRangeTo)
    {
        this._szScrDtRangeTo = szScrDtRangeTo;
    } //-- void setSzScrDtRangeTo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szScrTimeFrom'.
     * 
     * @param szScrTimeFrom the value of field 'szScrTimeFrom'.
     */
    public void setSzScrTimeFrom(java.lang.String szScrTimeFrom)
    {
        this._szScrTimeFrom = szScrTimeFrom;
    } //-- void setSzScrTimeFrom(java.lang.String) 

    /**
     * Sets the value of field 'szScrTmTimeTo'.
     * 
     * @param szScrTmTimeTo the value of field 'szScrTmTimeTo'.
     */
    public void setSzScrTmTimeTo(java.lang.String szScrTmTimeTo)
    {
        this._szScrTmTimeTo = szScrTmTimeTo;
    } //-- void setSzScrTmTimeTo(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct unmarshal(java.io.Reader) 

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
