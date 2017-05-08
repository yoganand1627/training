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
 * Class ROWCCMN33SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN33SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dtDtEventOccurred
     */
    private org.exolab.castor.types.Date _dtDtEventOccurred;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _szCdEventType
     */
    private java.lang.String _szCdEventType;

    /**
     * Field _szScrPersonNameEvent
     */
    private java.lang.String _szScrPersonNameEvent;

    /**
     * Field _szTxtEventDescr
     */
    private java.lang.String _szTxtEventDescr;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szScrCaseWorker
     */
    private java.lang.String _szScrCaseWorker;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _szCdTaskTopWindow
     */
    private java.lang.String _szCdTaskTopWindow;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _bIndTaskDelete
     */
    private java.lang.String _bIndTaskDelete;

    /**
     * Field _bIndTaskEventNavig
     */
    private java.lang.String _bIndTaskEventNavig;

    /**
     * Field _bIndTaskMultInstance
     */
    private java.lang.String _bIndTaskMultInstance;

    /**
     * Field _cIndTaskNewUsing
     */
    private java.lang.String _cIndTaskNewUsing;

    /**
     * Field _szCdTaskEventStatus
     */
    private java.lang.String _szCdTaskEventStatus;

    /**
     * Field _cIndCurrent
     */
    private java.lang.String _cIndCurrent;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN33SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndTaskDelete'.
     * 
     * @return the value of field 'BIndTaskDelete'.
     */
    public java.lang.String getBIndTaskDelete()
    {
        return this._bIndTaskDelete;
    } //-- java.lang.String getBIndTaskDelete() 

    /**
     * Returns the value of field 'bIndTaskEventNavig'.
     * 
     * @return the value of field 'BIndTaskEventNavig'.
     */
    public java.lang.String getBIndTaskEventNavig()
    {
        return this._bIndTaskEventNavig;
    } //-- java.lang.String getBIndTaskEventNavig() 

    /**
     * Returns the value of field 'bIndTaskMultInstance'.
     * 
     * @return the value of field 'BIndTaskMultInstance'.
     */
    public java.lang.String getBIndTaskMultInstance()
    {
        return this._bIndTaskMultInstance;
    } //-- java.lang.String getBIndTaskMultInstance() 

    /**
     * Returns the value of field 'cIndCurrent'.
     * 
     * @return the value of field 'CIndCurrent'.
     */
    public java.lang.String getCIndCurrent()
    {
        return this._cIndCurrent;
    } //-- java.lang.String getCIndCurrent() 

    /**
     * Returns the value of field 'cIndTaskNewUsing'.
     * 
     * @return the value of field 'CIndTaskNewUsing'.
     */
    public java.lang.String getCIndTaskNewUsing()
    {
        return this._cIndTaskNewUsing;
    } //-- java.lang.String getCIndTaskNewUsing() 

    /**
     * Returns the value of field 'dtDtEventOccurred'.
     * 
     * @return the value of field 'DtDtEventOccurred'.
     */
    public org.exolab.castor.types.Date getDtDtEventOccurred()
    {
        return this._dtDtEventOccurred;
    } //-- org.exolab.castor.types.Date getDtDtEventOccurred() 

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
     * Returns the value of field 'szCdEventType'.
     * 
     * @return the value of field 'SzCdEventType'.
     */
    public java.lang.String getSzCdEventType()
    {
        return this._szCdEventType;
    } //-- java.lang.String getSzCdEventType() 

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
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szCdTaskEventStatus'.
     * 
     * @return the value of field 'SzCdTaskEventStatus'.
     */
    public java.lang.String getSzCdTaskEventStatus()
    {
        return this._szCdTaskEventStatus;
    } //-- java.lang.String getSzCdTaskEventStatus() 

    /**
     * Returns the value of field 'szCdTaskTopWindow'.
     * 
     * @return the value of field 'SzCdTaskTopWindow'.
     */
    public java.lang.String getSzCdTaskTopWindow()
    {
        return this._szCdTaskTopWindow;
    } //-- java.lang.String getSzCdTaskTopWindow() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

    /**
     * Returns the value of field 'szScrCaseWorker'.
     * 
     * @return the value of field 'SzScrCaseWorker'.
     */
    public java.lang.String getSzScrCaseWorker()
    {
        return this._szScrCaseWorker;
    } //-- java.lang.String getSzScrCaseWorker() 

    /**
     * Returns the value of field 'szScrPersonNameEvent'.
     * 
     * @return the value of field 'SzScrPersonNameEvent'.
     */
    public java.lang.String getSzScrPersonNameEvent()
    {
        return this._szScrPersonNameEvent;
    } //-- java.lang.String getSzScrPersonNameEvent() 

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
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

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
     * Sets the value of field 'bIndTaskDelete'.
     * 
     * @param bIndTaskDelete the value of field 'bIndTaskDelete'.
     */
    public void setBIndTaskDelete(java.lang.String bIndTaskDelete)
    {
        this._bIndTaskDelete = bIndTaskDelete;
    } //-- void setBIndTaskDelete(java.lang.String) 

    /**
     * Sets the value of field 'bIndTaskEventNavig'.
     * 
     * @param bIndTaskEventNavig the value of field
     * 'bIndTaskEventNavig'.
     */
    public void setBIndTaskEventNavig(java.lang.String bIndTaskEventNavig)
    {
        this._bIndTaskEventNavig = bIndTaskEventNavig;
    } //-- void setBIndTaskEventNavig(java.lang.String) 

    /**
     * Sets the value of field 'bIndTaskMultInstance'.
     * 
     * @param bIndTaskMultInstance the value of field
     * 'bIndTaskMultInstance'.
     */
    public void setBIndTaskMultInstance(java.lang.String bIndTaskMultInstance)
    {
        this._bIndTaskMultInstance = bIndTaskMultInstance;
    } //-- void setBIndTaskMultInstance(java.lang.String) 

    /**
     * Sets the value of field 'cIndCurrent'.
     * 
     * @param cIndCurrent the value of field 'cIndCurrent'.
     */
    public void setCIndCurrent(java.lang.String cIndCurrent)
    {
        this._cIndCurrent = cIndCurrent;
    } //-- void setCIndCurrent(java.lang.String) 

    /**
     * Sets the value of field 'cIndTaskNewUsing'.
     * 
     * @param cIndTaskNewUsing the value of field 'cIndTaskNewUsing'
     */
    public void setCIndTaskNewUsing(java.lang.String cIndTaskNewUsing)
    {
        this._cIndTaskNewUsing = cIndTaskNewUsing;
    } //-- void setCIndTaskNewUsing(java.lang.String) 

    /**
     * Sets the value of field 'dtDtEventOccurred'.
     * 
     * @param dtDtEventOccurred the value of field
     * 'dtDtEventOccurred'.
     */
    public void setDtDtEventOccurred(org.exolab.castor.types.Date dtDtEventOccurred)
    {
        this._dtDtEventOccurred = dtDtEventOccurred;
    } //-- void setDtDtEventOccurred(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdEventType'.
     * 
     * @param szCdEventType the value of field 'szCdEventType'.
     */
    public void setSzCdEventType(java.lang.String szCdEventType)
    {
        this._szCdEventType = szCdEventType;
    } //-- void setSzCdEventType(java.lang.String) 

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
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szCdTaskEventStatus'.
     * 
     * @param szCdTaskEventStatus the value of field
     * 'szCdTaskEventStatus'.
     */
    public void setSzCdTaskEventStatus(java.lang.String szCdTaskEventStatus)
    {
        this._szCdTaskEventStatus = szCdTaskEventStatus;
    } //-- void setSzCdTaskEventStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdTaskTopWindow'.
     * 
     * @param szCdTaskTopWindow the value of field
     * 'szCdTaskTopWindow'.
     */
    public void setSzCdTaskTopWindow(java.lang.String szCdTaskTopWindow)
    {
        this._szCdTaskTopWindow = szCdTaskTopWindow;
    } //-- void setSzCdTaskTopWindow(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

    /**
     * Sets the value of field 'szScrCaseWorker'.
     * 
     * @param szScrCaseWorker the value of field 'szScrCaseWorker'.
     */
    public void setSzScrCaseWorker(java.lang.String szScrCaseWorker)
    {
        this._szScrCaseWorker = szScrCaseWorker;
    } //-- void setSzScrCaseWorker(java.lang.String) 

    /**
     * Sets the value of field 'szScrPersonNameEvent'.
     * 
     * @param szScrPersonNameEvent the value of field
     * 'szScrPersonNameEvent'.
     */
    public void setSzScrPersonNameEvent(java.lang.String szScrPersonNameEvent)
    {
        this._szScrPersonNameEvent = szScrPersonNameEvent;
    } //-- void setSzScrPersonNameEvent(java.lang.String) 

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
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO unmarshal(java.io.Reader) 

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
