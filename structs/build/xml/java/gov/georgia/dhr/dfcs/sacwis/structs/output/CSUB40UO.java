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
 * Class CSUB40UO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB40UO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdTodoTask
     */
    private java.lang.String _szCdTodoTask;

    /**
     * Field _szCdTodoType
     */
    private java.lang.String _szCdTodoType;

    /**
     * Field _dtDtTaskDue
     */
    private org.exolab.castor.types.Date _dtDtTaskDue;

    /**
     * Field _dtDtTodoCompleted
     */
    private org.exolab.castor.types.Date _dtDtTodoCompleted;

    /**
     * Field _dtDtTodoCreated
     */
    private org.exolab.castor.types.Date _dtDtTodoCreated;

    /**
     * Field _dtDtTodoDue
     */
    private org.exolab.castor.types.Date _dtDtTodoDue;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _ulIdTodoPersAssigned
     */
    private int _ulIdTodoPersAssigned;

    /**
     * keeps track of state for field: _ulIdTodoPersAssigned
     */
    private boolean _has_ulIdTodoPersAssigned;

    /**
     * Field _ulIdTodoPersCreator
     */
    private int _ulIdTodoPersCreator;

    /**
     * keeps track of state for field: _ulIdTodoPersCreator
     */
    private boolean _has_ulIdTodoPersCreator;

    /**
     * Field _ulIdTodoPersWorker
     */
    private int _ulIdTodoPersWorker;

    /**
     * keeps track of state for field: _ulIdTodoPersWorker
     */
    private boolean _has_ulIdTodoPersWorker;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szTxtTodoDesc
     */
    private java.lang.String _szTxtTodoDesc;

    /**
     * Field _txtTodoLongDesc
     */
    private java.lang.String _txtTodoLongDesc;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB40UO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdIdTodo()
    {
        this._has_ldIdTodo= false;
    } //-- void deleteLdIdTodo() 

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
     */
    public void deleteUlIdTodoPersAssigned()
    {
        this._has_ulIdTodoPersAssigned= false;
    } //-- void deleteUlIdTodoPersAssigned() 

    /**
     */
    public void deleteUlIdTodoPersCreator()
    {
        this._has_ulIdTodoPersCreator= false;
    } //-- void deleteUlIdTodoPersCreator() 

    /**
     */
    public void deleteUlIdTodoPersWorker()
    {
        this._has_ulIdTodoPersWorker= false;
    } //-- void deleteUlIdTodoPersWorker() 

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
     * Returns the value of field 'dtDtTaskDue'.
     * 
     * @return the value of field 'DtDtTaskDue'.
     */
    public org.exolab.castor.types.Date getDtDtTaskDue()
    {
        return this._dtDtTaskDue;
    } //-- org.exolab.castor.types.Date getDtDtTaskDue() 

    /**
     * Returns the value of field 'dtDtTodoCompleted'.
     * 
     * @return the value of field 'DtDtTodoCompleted'.
     */
    public org.exolab.castor.types.Date getDtDtTodoCompleted()
    {
        return this._dtDtTodoCompleted;
    } //-- org.exolab.castor.types.Date getDtDtTodoCompleted() 

    /**
     * Returns the value of field 'dtDtTodoCreated'.
     * 
     * @return the value of field 'DtDtTodoCreated'.
     */
    public org.exolab.castor.types.Date getDtDtTodoCreated()
    {
        return this._dtDtTodoCreated;
    } //-- org.exolab.castor.types.Date getDtDtTodoCreated() 

    /**
     * Returns the value of field 'dtDtTodoDue'.
     * 
     * @return the value of field 'DtDtTodoDue'.
     */
    public org.exolab.castor.types.Date getDtDtTodoDue()
    {
        return this._dtDtTodoDue;
    } //-- org.exolab.castor.types.Date getDtDtTodoDue() 

    /**
     * Returns the value of field 'ldIdTodo'.
     * 
     * @return the value of field 'LdIdTodo'.
     */
    public int getLdIdTodo()
    {
        return this._ldIdTodo;
    } //-- int getLdIdTodo() 

    /**
     * Returns the value of field 'szCdTodoTask'.
     * 
     * @return the value of field 'SzCdTodoTask'.
     */
    public java.lang.String getSzCdTodoTask()
    {
        return this._szCdTodoTask;
    } //-- java.lang.String getSzCdTodoTask() 

    /**
     * Returns the value of field 'szCdTodoType'.
     * 
     * @return the value of field 'SzCdTodoType'.
     */
    public java.lang.String getSzCdTodoType()
    {
        return this._szCdTodoType;
    } //-- java.lang.String getSzCdTodoType() 

    /**
     * Returns the value of field 'szTxtTodoDesc'.
     * 
     * @return the value of field 'SzTxtTodoDesc'.
     */
    public java.lang.String getSzTxtTodoDesc()
    {
        return this._szTxtTodoDesc;
    } //-- java.lang.String getSzTxtTodoDesc() 

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
     * Returns the value of field 'txtTodoLongDesc'.
     * 
     * @return the value of field 'TxtTodoLongDesc'.
     */
    public java.lang.String getTxtTodoLongDesc()
    {
        return this._txtTodoLongDesc;
    } //-- java.lang.String getTxtTodoLongDesc() 

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
     * Returns the value of field 'ulIdTodoPersAssigned'.
     * 
     * @return the value of field 'UlIdTodoPersAssigned'.
     */
    public int getUlIdTodoPersAssigned()
    {
        return this._ulIdTodoPersAssigned;
    } //-- int getUlIdTodoPersAssigned() 

    /**
     * Returns the value of field 'ulIdTodoPersCreator'.
     * 
     * @return the value of field 'UlIdTodoPersCreator'.
     */
    public int getUlIdTodoPersCreator()
    {
        return this._ulIdTodoPersCreator;
    } //-- int getUlIdTodoPersCreator() 

    /**
     * Returns the value of field 'ulIdTodoPersWorker'.
     * 
     * @return the value of field 'UlIdTodoPersWorker'.
     */
    public int getUlIdTodoPersWorker()
    {
        return this._ulIdTodoPersWorker;
    } //-- int getUlIdTodoPersWorker() 

    /**
     * Method hasLdIdTodo
     * 
     * 
     * 
     * @return true if at least one LdIdTodo has been added
     */
    public boolean hasLdIdTodo()
    {
        return this._has_ldIdTodo;
    } //-- boolean hasLdIdTodo() 

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
     * Method hasUlIdTodoPersAssigned
     * 
     * 
     * 
     * @return true if at least one UlIdTodoPersAssigned has been
     * added
     */
    public boolean hasUlIdTodoPersAssigned()
    {
        return this._has_ulIdTodoPersAssigned;
    } //-- boolean hasUlIdTodoPersAssigned() 

    /**
     * Method hasUlIdTodoPersCreator
     * 
     * 
     * 
     * @return true if at least one UlIdTodoPersCreator has been
     * added
     */
    public boolean hasUlIdTodoPersCreator()
    {
        return this._has_ulIdTodoPersCreator;
    } //-- boolean hasUlIdTodoPersCreator() 

    /**
     * Method hasUlIdTodoPersWorker
     * 
     * 
     * 
     * @return true if at least one UlIdTodoPersWorker has been adde
     */
    public boolean hasUlIdTodoPersWorker()
    {
        return this._has_ulIdTodoPersWorker;
    } //-- boolean hasUlIdTodoPersWorker() 

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
     * Sets the value of field 'dtDtTaskDue'.
     * 
     * @param dtDtTaskDue the value of field 'dtDtTaskDue'.
     */
    public void setDtDtTaskDue(org.exolab.castor.types.Date dtDtTaskDue)
    {
        this._dtDtTaskDue = dtDtTaskDue;
    } //-- void setDtDtTaskDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtTodoCompleted'.
     * 
     * @param dtDtTodoCompleted the value of field
     * 'dtDtTodoCompleted'.
     */
    public void setDtDtTodoCompleted(org.exolab.castor.types.Date dtDtTodoCompleted)
    {
        this._dtDtTodoCompleted = dtDtTodoCompleted;
    } //-- void setDtDtTodoCompleted(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtTodoCreated'.
     * 
     * @param dtDtTodoCreated the value of field 'dtDtTodoCreated'.
     */
    public void setDtDtTodoCreated(org.exolab.castor.types.Date dtDtTodoCreated)
    {
        this._dtDtTodoCreated = dtDtTodoCreated;
    } //-- void setDtDtTodoCreated(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtTodoDue'.
     * 
     * @param dtDtTodoDue the value of field 'dtDtTodoDue'.
     */
    public void setDtDtTodoDue(org.exolab.castor.types.Date dtDtTodoDue)
    {
        this._dtDtTodoDue = dtDtTodoDue;
    } //-- void setDtDtTodoDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ldIdTodo'.
     * 
     * @param ldIdTodo the value of field 'ldIdTodo'.
     */
    public void setLdIdTodo(int ldIdTodo)
    {
        this._ldIdTodo = ldIdTodo;
        this._has_ldIdTodo = true;
    } //-- void setLdIdTodo(int) 

    /**
     * Sets the value of field 'szCdTodoTask'.
     * 
     * @param szCdTodoTask the value of field 'szCdTodoTask'.
     */
    public void setSzCdTodoTask(java.lang.String szCdTodoTask)
    {
        this._szCdTodoTask = szCdTodoTask;
    } //-- void setSzCdTodoTask(java.lang.String) 

    /**
     * Sets the value of field 'szCdTodoType'.
     * 
     * @param szCdTodoType the value of field 'szCdTodoType'.
     */
    public void setSzCdTodoType(java.lang.String szCdTodoType)
    {
        this._szCdTodoType = szCdTodoType;
    } //-- void setSzCdTodoType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtTodoDesc'.
     * 
     * @param szTxtTodoDesc the value of field 'szTxtTodoDesc'.
     */
    public void setSzTxtTodoDesc(java.lang.String szTxtTodoDesc)
    {
        this._szTxtTodoDesc = szTxtTodoDesc;
    } //-- void setSzTxtTodoDesc(java.lang.String) 

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
     * Sets the value of field 'txtTodoLongDesc'.
     * 
     * @param txtTodoLongDesc the value of field 'txtTodoLongDesc'.
     */
    public void setTxtTodoLongDesc(java.lang.String txtTodoLongDesc)
    {
        this._txtTodoLongDesc = txtTodoLongDesc;
    } //-- void setTxtTodoLongDesc(java.lang.String) 

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
     * Sets the value of field 'ulIdTodoPersAssigned'.
     * 
     * @param ulIdTodoPersAssigned the value of field
     * 'ulIdTodoPersAssigned'.
     */
    public void setUlIdTodoPersAssigned(int ulIdTodoPersAssigned)
    {
        this._ulIdTodoPersAssigned = ulIdTodoPersAssigned;
        this._has_ulIdTodoPersAssigned = true;
    } //-- void setUlIdTodoPersAssigned(int) 

    /**
     * Sets the value of field 'ulIdTodoPersCreator'.
     * 
     * @param ulIdTodoPersCreator the value of field
     * 'ulIdTodoPersCreator'.
     */
    public void setUlIdTodoPersCreator(int ulIdTodoPersCreator)
    {
        this._ulIdTodoPersCreator = ulIdTodoPersCreator;
        this._has_ulIdTodoPersCreator = true;
    } //-- void setUlIdTodoPersCreator(int) 

    /**
     * Sets the value of field 'ulIdTodoPersWorker'.
     * 
     * @param ulIdTodoPersWorker the value of field
     * 'ulIdTodoPersWorker'.
     */
    public void setUlIdTodoPersWorker(int ulIdTodoPersWorker)
    {
        this._ulIdTodoPersWorker = ulIdTodoPersWorker;
        this._has_ulIdTodoPersWorker = true;
    } //-- void setUlIdTodoPersWorker(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO unmarshal(java.io.Reader) 

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
