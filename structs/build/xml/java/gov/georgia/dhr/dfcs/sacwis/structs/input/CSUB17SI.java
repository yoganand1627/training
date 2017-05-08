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
 * Class CSUB17SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB17SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bSysIndPrfrmValidation
     */
    private java.lang.String _bSysIndPrfrmValidation;

    /**
     * Field _tsLastUpdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY _tsLastUpdate_ARRAY;

    /**
     * Field _szCdPlocChild
     */
    private java.lang.String _szCdPlocChild;

    /**
     * Field _szCdPlocType
     */
    private java.lang.String _szCdPlocType;

    /**
     * Field _dtDtPlocEnd
     */
    private org.exolab.castor.types.Date _dtDtPlocEnd;

    /**
     * Field _dtDtPlocStart
     */
    private org.exolab.castor.types.Date _dtDtPlocStart;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdPlocEvent
     */
    private int _ulIdPlocEvent;

    /**
     * keeps track of state for field: _ulIdPlocEvent
     */
    private boolean _has_ulIdPlocEvent;

    /**
     * Field _cIndPlocCsupSend
     */
    private java.lang.String _cIndPlocCsupSend;

    /**
     * Field _szCdEventStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY _szCdEventStatus_ARRAY;

    /**
     * Field _ulIdEventPerson
     */
    private int _ulIdEventPerson;

    /**
     * keeps track of state for field: _ulIdEventPerson
     */
    private boolean _has_ulIdEventPerson;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szTxtEventDescr
     */
    private java.lang.String _szTxtEventDescr;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _indDateModified
     */
    private java.lang.String _indDateModified;

    /**
     * Field _ulIdPersUpdt
     */
    private int _ulIdPersUpdt;

    /**
     * keeps track of state for field: _ulIdPersUpdt
     */
    private boolean _has_ulIdPersUpdt;

    /**
     * Field _szCdRevType
     */
    private java.lang.String _szCdRevType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB17SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEventPerson()
    {
        this._has_ulIdEventPerson= false;
    } //-- void deleteUlIdEventPerson() 

    /**
     */
    public void deleteUlIdPersUpdt()
    {
        this._has_ulIdPersUpdt= false;
    } //-- void deleteUlIdPersUpdt() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPlocEvent()
    {
        this._has_ulIdPlocEvent= false;
    } //-- void deleteUlIdPlocEvent() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'bSysIndPrfrmValidation'.
     * 
     * @return the value of field 'BSysIndPrfrmValidation'.
     */
    public java.lang.String getBSysIndPrfrmValidation()
    {
        return this._bSysIndPrfrmValidation;
    } //-- java.lang.String getBSysIndPrfrmValidation() 

    /**
     * Returns the value of field 'cIndPlocCsupSend'.
     * 
     * @return the value of field 'CIndPlocCsupSend'.
     */
    public java.lang.String getCIndPlocCsupSend()
    {
        return this._cIndPlocCsupSend;
    } //-- java.lang.String getCIndPlocCsupSend() 

    /**
     * Returns the value of field 'dtDtPlocEnd'.
     * 
     * @return the value of field 'DtDtPlocEnd'.
     */
    public org.exolab.castor.types.Date getDtDtPlocEnd()
    {
        return this._dtDtPlocEnd;
    } //-- org.exolab.castor.types.Date getDtDtPlocEnd() 

    /**
     * Returns the value of field 'dtDtPlocStart'.
     * 
     * @return the value of field 'DtDtPlocStart'.
     */
    public org.exolab.castor.types.Date getDtDtPlocStart()
    {
        return this._dtDtPlocStart;
    } //-- org.exolab.castor.types.Date getDtDtPlocStart() 

    /**
     * Returns the value of field 'indDateModified'.
     * 
     * @return the value of field 'IndDateModified'.
     */
    public java.lang.String getIndDateModified()
    {
        return this._indDateModified;
    } //-- java.lang.String getIndDateModified() 

    /**
     * Returns the value of field 'szCdEventStatus_ARRAY'.
     * 
     * @return the value of field 'SzCdEventStatus_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY getSzCdEventStatus_ARRAY()
    {
        return this._szCdEventStatus_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY getSzCdEventStatus_ARRAY() 

    /**
     * Returns the value of field 'szCdPlocChild'.
     * 
     * @return the value of field 'SzCdPlocChild'.
     */
    public java.lang.String getSzCdPlocChild()
    {
        return this._szCdPlocChild;
    } //-- java.lang.String getSzCdPlocChild() 

    /**
     * Returns the value of field 'szCdPlocType'.
     * 
     * @return the value of field 'SzCdPlocType'.
     */
    public java.lang.String getSzCdPlocType()
    {
        return this._szCdPlocType;
    } //-- java.lang.String getSzCdPlocType() 

    /**
     * Returns the value of field 'szCdRevType'.
     * 
     * @return the value of field 'SzCdRevType'.
     */
    public java.lang.String getSzCdRevType()
    {
        return this._szCdRevType;
    } //-- java.lang.String getSzCdRevType() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szTxtEventDescr'.
     * 
     * @return the value of field 'SzTxtEventDescr'.
     */
    public java.lang.String getSzTxtEventDescr()
    {
        return this._szTxtEventDescr;
    } //-- java.lang.String getSzTxtEventDescr() 

    /**
     * Returns the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY()
    {
        return this._tsLastUpdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY() 

    /**
     * Returns the value of field 'ulIdEventPerson'.
     * 
     * @return the value of field 'UlIdEventPerson'.
     */
    public int getUlIdEventPerson()
    {
        return this._ulIdEventPerson;
    } //-- int getUlIdEventPerson() 

    /**
     * Returns the value of field 'ulIdPersUpdt'.
     * 
     * @return the value of field 'UlIdPersUpdt'.
     */
    public int getUlIdPersUpdt()
    {
        return this._ulIdPersUpdt;
    } //-- int getUlIdPersUpdt() 

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
     * Returns the value of field 'ulIdPlocEvent'.
     * 
     * @return the value of field 'UlIdPlocEvent'.
     */
    public int getUlIdPlocEvent()
    {
        return this._ulIdPlocEvent;
    } //-- int getUlIdPlocEvent() 

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
     * Method hasUlIdEventPerson
     * 
     * 
     * 
     * @return true if at least one UlIdEventPerson has been added
     */
    public boolean hasUlIdEventPerson()
    {
        return this._has_ulIdEventPerson;
    } //-- boolean hasUlIdEventPerson() 

    /**
     * Method hasUlIdPersUpdt
     * 
     * 
     * 
     * @return true if at least one UlIdPersUpdt has been added
     */
    public boolean hasUlIdPersUpdt()
    {
        return this._has_ulIdPersUpdt;
    } //-- boolean hasUlIdPersUpdt() 

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
     * Method hasUlIdPlocEvent
     * 
     * 
     * 
     * @return true if at least one UlIdPlocEvent has been added
     */
    public boolean hasUlIdPlocEvent()
    {
        return this._has_ulIdPlocEvent;
    } //-- boolean hasUlIdPlocEvent() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bSysIndPrfrmValidation'.
     * 
     * @param bSysIndPrfrmValidation the value of field
     * 'bSysIndPrfrmValidation'.
     */
    public void setBSysIndPrfrmValidation(java.lang.String bSysIndPrfrmValidation)
    {
        this._bSysIndPrfrmValidation = bSysIndPrfrmValidation;
    } //-- void setBSysIndPrfrmValidation(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlocCsupSend'.
     * 
     * @param cIndPlocCsupSend the value of field 'cIndPlocCsupSend'
     */
    public void setCIndPlocCsupSend(java.lang.String cIndPlocCsupSend)
    {
        this._cIndPlocCsupSend = cIndPlocCsupSend;
    } //-- void setCIndPlocCsupSend(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPlocEnd'.
     * 
     * @param dtDtPlocEnd the value of field 'dtDtPlocEnd'.
     */
    public void setDtDtPlocEnd(org.exolab.castor.types.Date dtDtPlocEnd)
    {
        this._dtDtPlocEnd = dtDtPlocEnd;
    } //-- void setDtDtPlocEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlocStart'.
     * 
     * @param dtDtPlocStart the value of field 'dtDtPlocStart'.
     */
    public void setDtDtPlocStart(org.exolab.castor.types.Date dtDtPlocStart)
    {
        this._dtDtPlocStart = dtDtPlocStart;
    } //-- void setDtDtPlocStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indDateModified'.
     * 
     * @param indDateModified the value of field 'indDateModified'.
     */
    public void setIndDateModified(java.lang.String indDateModified)
    {
        this._indDateModified = indDateModified;
    } //-- void setIndDateModified(java.lang.String) 

    /**
     * Sets the value of field 'szCdEventStatus_ARRAY'.
     * 
     * @param szCdEventStatus_ARRAY the value of field
     * 'szCdEventStatus_ARRAY'.
     */
    public void setSzCdEventStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY szCdEventStatus_ARRAY)
    {
        this._szCdEventStatus_ARRAY = szCdEventStatus_ARRAY;
    } //-- void setSzCdEventStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY) 

    /**
     * Sets the value of field 'szCdPlocChild'.
     * 
     * @param szCdPlocChild the value of field 'szCdPlocChild'.
     */
    public void setSzCdPlocChild(java.lang.String szCdPlocChild)
    {
        this._szCdPlocChild = szCdPlocChild;
    } //-- void setSzCdPlocChild(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlocType'.
     * 
     * @param szCdPlocType the value of field 'szCdPlocType'.
     */
    public void setSzCdPlocType(java.lang.String szCdPlocType)
    {
        this._szCdPlocType = szCdPlocType;
    } //-- void setSzCdPlocType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRevType'.
     * 
     * @param szCdRevType the value of field 'szCdRevType'.
     */
    public void setSzCdRevType(java.lang.String szCdRevType)
    {
        this._szCdRevType = szCdRevType;
    } //-- void setSzCdRevType(java.lang.String) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEventDescr'.
     * 
     * @param szTxtEventDescr the value of field 'szTxtEventDescr'.
     */
    public void setSzTxtEventDescr(java.lang.String szTxtEventDescr)
    {
        this._szTxtEventDescr = szTxtEventDescr;
    } //-- void setSzTxtEventDescr(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @param tsLastUpdate_ARRAY the value of field
     * 'tsLastUpdate_ARRAY'.
     */
    public void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY tsLastUpdate_ARRAY)
    {
        this._tsLastUpdate_ARRAY = tsLastUpdate_ARRAY;
    } //-- void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY) 

    /**
     * Sets the value of field 'ulIdEventPerson'.
     * 
     * @param ulIdEventPerson the value of field 'ulIdEventPerson'.
     */
    public void setUlIdEventPerson(int ulIdEventPerson)
    {
        this._ulIdEventPerson = ulIdEventPerson;
        this._has_ulIdEventPerson = true;
    } //-- void setUlIdEventPerson(int) 

    /**
     * Sets the value of field 'ulIdPersUpdt'.
     * 
     * @param ulIdPersUpdt the value of field 'ulIdPersUpdt'.
     */
    public void setUlIdPersUpdt(int ulIdPersUpdt)
    {
        this._ulIdPersUpdt = ulIdPersUpdt;
        this._has_ulIdPersUpdt = true;
    } //-- void setUlIdPersUpdt(int) 

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
     * Sets the value of field 'ulIdPlocEvent'.
     * 
     * @param ulIdPlocEvent the value of field 'ulIdPlocEvent'.
     */
    public void setUlIdPlocEvent(int ulIdPlocEvent)
    {
        this._ulIdPlocEvent = ulIdPlocEvent;
        this._has_ulIdPlocEvent = true;
    } //-- void setUlIdPlocEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI unmarshal(java.io.Reader) 

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
