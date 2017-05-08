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
 * Class CCMN13SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN13SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _stageStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct _stageStruct;

    /**
     * Field _taskStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct _taskStruct;

    /**
     * Field _assignedStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct _assignedStruct;

    /**
     * Field _createdStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct _createdStruct;

    /**
     * Field _todoInfoStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct _todoInfoStruct;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _tmTmWCDDtSystemTime
     */
    private java.lang.String _tmTmWCDDtSystemTime;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN13SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'assignedStruct'.
     * 
     * @return the value of field 'AssignedStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct getAssignedStruct()
    {
        return this._assignedStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct getAssignedStruct() 

    /**
     * Returns the value of field 'createdStruct'.
     * 
     * @return the value of field 'CreatedStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct getCreatedStruct()
    {
        return this._createdStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct getCreatedStruct() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'stageStruct'.
     * 
     * @return the value of field 'StageStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct getStageStruct()
    {
        return this._stageStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct getStageStruct() 

    /**
     * Returns the value of field 'taskStruct'.
     * 
     * @return the value of field 'TaskStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct getTaskStruct()
    {
        return this._taskStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct getTaskStruct() 

    /**
     * Returns the value of field 'tmTmWCDDtSystemTime'.
     * 
     * @return the value of field 'TmTmWCDDtSystemTime'.
     */
    public java.lang.String getTmTmWCDDtSystemTime()
    {
        return this._tmTmWCDDtSystemTime;
    } //-- java.lang.String getTmTmWCDDtSystemTime() 

    /**
     * Returns the value of field 'todoInfoStruct'.
     * 
     * @return the value of field 'TodoInfoStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct getTodoInfoStruct()
    {
        return this._todoInfoStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct getTodoInfoStruct() 

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
     * Sets the value of field 'assignedStruct'.
     * 
     * @param assignedStruct the value of field 'assignedStruct'.
     */
    public void setAssignedStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct assignedStruct)
    {
        this._assignedStruct = assignedStruct;
    } //-- void setAssignedStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct) 

    /**
     * Sets the value of field 'createdStruct'.
     * 
     * @param createdStruct the value of field 'createdStruct'.
     */
    public void setCreatedStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct createdStruct)
    {
        this._createdStruct = createdStruct;
    } //-- void setCreatedStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'stageStruct'.
     * 
     * @param stageStruct the value of field 'stageStruct'.
     */
    public void setStageStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct stageStruct)
    {
        this._stageStruct = stageStruct;
    } //-- void setStageStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct) 

    /**
     * Sets the value of field 'taskStruct'.
     * 
     * @param taskStruct the value of field 'taskStruct'.
     */
    public void setTaskStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct taskStruct)
    {
        this._taskStruct = taskStruct;
    } //-- void setTaskStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct) 

    /**
     * Sets the value of field 'tmTmWCDDtSystemTime'.
     * 
     * @param tmTmWCDDtSystemTime the value of field
     * 'tmTmWCDDtSystemTime'.
     */
    public void setTmTmWCDDtSystemTime(java.lang.String tmTmWCDDtSystemTime)
    {
        this._tmTmWCDDtSystemTime = tmTmWCDDtSystemTime;
    } //-- void setTmTmWCDDtSystemTime(java.lang.String) 

    /**
     * Sets the value of field 'todoInfoStruct'.
     * 
     * @param todoInfoStruct the value of field 'todoInfoStruct'.
     */
    public void setTodoInfoStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct todoInfoStruct)
    {
        this._todoInfoStruct = todoInfoStruct;
    } //-- void setTodoInfoStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO unmarshal(java.io.Reader) 

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
