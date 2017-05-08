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
 * Class ROWCCMN45SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN45SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _szCdTaskListWindow
     */
    private java.lang.String _szCdTaskListWindow;

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
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _szTxtTaskDecode
     */
    private java.lang.String _szTxtTaskDecode;

    /**
     * Field _cIndTaskShowInList
     */
    private java.lang.String _cIndTaskShowInList;

    /**
     * Field _cIndTaskNuAcrossCase
     */
    private java.lang.String _cIndTaskNuAcrossCase;

    /**
     * Field _szCdTaskPrior
     */
    private java.lang.String _szCdTaskPrior;

    /**
     * Field _bIndTaskEventCreate
     */
    private java.lang.String _bIndTaskEventCreate;

    /**
     * Field _cIndTaskListEnable
     */
    private java.lang.String _cIndTaskListEnable;

    /**
     * Field _cIndTaskNewEnable
     */
    private java.lang.String _cIndTaskNewEnable;

    /**
     * Field _cIndTaskDetailEnable
     */
    private java.lang.String _cIndTaskDetailEnable;

    /**
     * Field _bIndTaskMultInstance
     */
    private java.lang.String _bIndTaskMultInstance;

    /**
     * Field _cIndTaskRtrvPriorStage
     */
    private java.lang.String _cIndTaskRtrvPriorStage;

    /**
     * Field _bIndTaskTodoEnable
     */
    private java.lang.String _bIndTaskTodoEnable;

    /**
     * Field _szCdEventType
     */
    private java.lang.String _szCdEventType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN45SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00()


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
     * Returns the value of field 'bIndTaskEventCreate'.
     * 
     * @return the value of field 'BIndTaskEventCreate'.
     */
    public java.lang.String getBIndTaskEventCreate()
    {
        return this._bIndTaskEventCreate;
    } //-- java.lang.String getBIndTaskEventCreate() 

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
     * Returns the value of field 'bIndTaskTodoEnable'.
     * 
     * @return the value of field 'BIndTaskTodoEnable'.
     */
    public java.lang.String getBIndTaskTodoEnable()
    {
        return this._bIndTaskTodoEnable;
    } //-- java.lang.String getBIndTaskTodoEnable() 

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
     * Returns the value of field 'cIndTaskListEnable'.
     * 
     * @return the value of field 'CIndTaskListEnable'.
     */
    public java.lang.String getCIndTaskListEnable()
    {
        return this._cIndTaskListEnable;
    } //-- java.lang.String getCIndTaskListEnable() 

    /**
     * Returns the value of field 'cIndTaskNewEnable'.
     * 
     * @return the value of field 'CIndTaskNewEnable'.
     */
    public java.lang.String getCIndTaskNewEnable()
    {
        return this._cIndTaskNewEnable;
    } //-- java.lang.String getCIndTaskNewEnable() 

    /**
     * Returns the value of field 'cIndTaskNuAcrossCase'.
     * 
     * @return the value of field 'CIndTaskNuAcrossCase'.
     */
    public java.lang.String getCIndTaskNuAcrossCase()
    {
        return this._cIndTaskNuAcrossCase;
    } //-- java.lang.String getCIndTaskNuAcrossCase() 

    /**
     * Returns the value of field 'cIndTaskRtrvPriorStage'.
     * 
     * @return the value of field 'CIndTaskRtrvPriorStage'.
     */
    public java.lang.String getCIndTaskRtrvPriorStage()
    {
        return this._cIndTaskRtrvPriorStage;
    } //-- java.lang.String getCIndTaskRtrvPriorStage() 

    /**
     * Returns the value of field 'cIndTaskShowInList'.
     * 
     * @return the value of field 'CIndTaskShowInList'.
     */
    public java.lang.String getCIndTaskShowInList()
    {
        return this._cIndTaskShowInList;
    } //-- java.lang.String getCIndTaskShowInList() 

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
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szCdTaskListWindow'.
     * 
     * @return the value of field 'SzCdTaskListWindow'.
     */
    public java.lang.String getSzCdTaskListWindow()
    {
        return this._szCdTaskListWindow;
    } //-- java.lang.String getSzCdTaskListWindow() 

    /**
     * Returns the value of field 'szCdTaskPrior'.
     * 
     * @return the value of field 'SzCdTaskPrior'.
     */
    public java.lang.String getSzCdTaskPrior()
    {
        return this._szCdTaskPrior;
    } //-- java.lang.String getSzCdTaskPrior() 

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
     * Returns the value of field 'szTxtTaskDecode'.
     * 
     * @return the value of field 'SzTxtTaskDecode'.
     */
    public java.lang.String getSzTxtTaskDecode()
    {
        return this._szTxtTaskDecode;
    } //-- java.lang.String getSzTxtTaskDecode() 

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
     * Sets the value of field 'bIndTaskEventCreate'.
     * 
     * @param bIndTaskEventCreate the value of field
     * 'bIndTaskEventCreate'.
     */
    public void setBIndTaskEventCreate(java.lang.String bIndTaskEventCreate)
    {
        this._bIndTaskEventCreate = bIndTaskEventCreate;
    } //-- void setBIndTaskEventCreate(java.lang.String) 

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
     * Sets the value of field 'bIndTaskTodoEnable'.
     * 
     * @param bIndTaskTodoEnable the value of field
     * 'bIndTaskTodoEnable'.
     */
    public void setBIndTaskTodoEnable(java.lang.String bIndTaskTodoEnable)
    {
        this._bIndTaskTodoEnable = bIndTaskTodoEnable;
    } //-- void setBIndTaskTodoEnable(java.lang.String) 

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
     * Sets the value of field 'cIndTaskListEnable'.
     * 
     * @param cIndTaskListEnable the value of field
     * 'cIndTaskListEnable'.
     */
    public void setCIndTaskListEnable(java.lang.String cIndTaskListEnable)
    {
        this._cIndTaskListEnable = cIndTaskListEnable;
    } //-- void setCIndTaskListEnable(java.lang.String) 

    /**
     * Sets the value of field 'cIndTaskNewEnable'.
     * 
     * @param cIndTaskNewEnable the value of field
     * 'cIndTaskNewEnable'.
     */
    public void setCIndTaskNewEnable(java.lang.String cIndTaskNewEnable)
    {
        this._cIndTaskNewEnable = cIndTaskNewEnable;
    } //-- void setCIndTaskNewEnable(java.lang.String) 

    /**
     * Sets the value of field 'cIndTaskNuAcrossCase'.
     * 
     * @param cIndTaskNuAcrossCase the value of field
     * 'cIndTaskNuAcrossCase'.
     */
    public void setCIndTaskNuAcrossCase(java.lang.String cIndTaskNuAcrossCase)
    {
        this._cIndTaskNuAcrossCase = cIndTaskNuAcrossCase;
    } //-- void setCIndTaskNuAcrossCase(java.lang.String) 

    /**
     * Sets the value of field 'cIndTaskRtrvPriorStage'.
     * 
     * @param cIndTaskRtrvPriorStage the value of field
     * 'cIndTaskRtrvPriorStage'.
     */
    public void setCIndTaskRtrvPriorStage(java.lang.String cIndTaskRtrvPriorStage)
    {
        this._cIndTaskRtrvPriorStage = cIndTaskRtrvPriorStage;
    } //-- void setCIndTaskRtrvPriorStage(java.lang.String) 

    /**
     * Sets the value of field 'cIndTaskShowInList'.
     * 
     * @param cIndTaskShowInList the value of field
     * 'cIndTaskShowInList'.
     */
    public void setCIndTaskShowInList(java.lang.String cIndTaskShowInList)
    {
        this._cIndTaskShowInList = cIndTaskShowInList;
    } //-- void setCIndTaskShowInList(java.lang.String) 

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
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szCdTaskListWindow'.
     * 
     * @param szCdTaskListWindow the value of field
     * 'szCdTaskListWindow'.
     */
    public void setSzCdTaskListWindow(java.lang.String szCdTaskListWindow)
    {
        this._szCdTaskListWindow = szCdTaskListWindow;
    } //-- void setSzCdTaskListWindow(java.lang.String) 

    /**
     * Sets the value of field 'szCdTaskPrior'.
     * 
     * @param szCdTaskPrior the value of field 'szCdTaskPrior'.
     */
    public void setSzCdTaskPrior(java.lang.String szCdTaskPrior)
    {
        this._szCdTaskPrior = szCdTaskPrior;
    } //-- void setSzCdTaskPrior(java.lang.String) 

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
     * Sets the value of field 'szTxtTaskDecode'.
     * 
     * @param szTxtTaskDecode the value of field 'szTxtTaskDecode'.
     */
    public void setSzTxtTaskDecode(java.lang.String szTxtTaskDecode)
    {
        this._szTxtTaskDecode = szTxtTaskDecode;
    } //-- void setSzTxtTaskDecode(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00 unmarshal(java.io.Reader) 

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
