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
 * Class CCMN50SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN50SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _ulIdPriorStage
     */
    private int _ulIdPriorStage;

    /**
     * keeps track of state for field: _ulIdPriorStage
     */
    private boolean _has_ulIdPriorStage;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _cSysIndTaskDetailList
     */
    private java.lang.String _cSysIndTaskDetailList;

    /**
     * Field _cSysIndTaskNew
     */
    private java.lang.String _cSysIndTaskNew;

    /**
     * Field _cIndTaskDetailEnable
     */
    private java.lang.String _cIndTaskDetailEnable;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN50SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO()


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
    public void deleteUlIdPriorStage()
    {
        this._has_ulIdPriorStage= false;
    } //-- void deleteUlIdPriorStage() 

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
     * Returns the value of field 'cIndTaskDetailEnable'.
     * 
     * @return the value of field 'CIndTaskDetailEnable'.
     */
    public java.lang.String getCIndTaskDetailEnable()
    {
        return this._cIndTaskDetailEnable;
    } //-- java.lang.String getCIndTaskDetailEnable() 

    /**
     * Returns the value of field 'cSysIndTaskDetailList'.
     * 
     * @return the value of field 'CSysIndTaskDetailList'.
     */
    public java.lang.String getCSysIndTaskDetailList()
    {
        return this._cSysIndTaskDetailList;
    } //-- java.lang.String getCSysIndTaskDetailList() 

    /**
     * Returns the value of field 'cSysIndTaskNew'.
     * 
     * @return the value of field 'CSysIndTaskNew'.
     */
    public java.lang.String getCSysIndTaskNew()
    {
        return this._cSysIndTaskNew;
    } //-- java.lang.String getCSysIndTaskNew() 

    /**
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

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
     * Returns the value of field 'ulIdPriorStage'.
     * 
     * @return the value of field 'UlIdPriorStage'.
     */
    public int getUlIdPriorStage()
    {
        return this._ulIdPriorStage;
    } //-- int getUlIdPriorStage() 

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
     * Method hasUlIdPriorStage
     * 
     * 
     * 
     * @return true if at least one UlIdPriorStage has been added
     */
    public boolean hasUlIdPriorStage()
    {
        return this._has_ulIdPriorStage;
    } //-- boolean hasUlIdPriorStage() 

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
     * Sets the value of field 'cIndTaskDetailEnable'.
     * 
     * @param cIndTaskDetailEnable the value of field
     * 'cIndTaskDetailEnable'.
     */
    public void setCIndTaskDetailEnable(java.lang.String cIndTaskDetailEnable)
    {
        this._cIndTaskDetailEnable = cIndTaskDetailEnable;
    } //-- void setCIndTaskDetailEnable(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndTaskDetailList'.
     * 
     * @param cSysIndTaskDetailList the value of field
     * 'cSysIndTaskDetailList'.
     */
    public void setCSysIndTaskDetailList(java.lang.String cSysIndTaskDetailList)
    {
        this._cSysIndTaskDetailList = cSysIndTaskDetailList;
    } //-- void setCSysIndTaskDetailList(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndTaskNew'.
     * 
     * @param cSysIndTaskNew the value of field 'cSysIndTaskNew'.
     */
    public void setCSysIndTaskNew(java.lang.String cSysIndTaskNew)
    {
        this._cSysIndTaskNew = cSysIndTaskNew;
    } //-- void setCSysIndTaskNew(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

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
     * Sets the value of field 'ulIdPriorStage'.
     * 
     * @param ulIdPriorStage the value of field 'ulIdPriorStage'.
     */
    public void setUlIdPriorStage(int ulIdPriorStage)
    {
        this._ulIdPriorStage = ulIdPriorStage;
        this._has_ulIdPriorStage = true;
    } //-- void setUlIdPriorStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO unmarshal(java.io.Reader) 

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
