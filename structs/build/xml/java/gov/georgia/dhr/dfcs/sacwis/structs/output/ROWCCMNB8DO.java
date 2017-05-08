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
 * Class ROWCCMNB8DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMNB8DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sCdStageProgProgram
     */
    private java.lang.String _sCdStageProgProgram;

    /**
     * Field _szCdStageProgStage
     */
    private java.lang.String _szCdStageProgStage;

    /**
     * Field _sCdStageProgStageType
     */
    private java.lang.String _sCdStageProgStageType;

    /**
     * Field _szCdStageProgRsnClosed
     */
    private java.lang.String _szCdStageProgRsnClosed;

    /**
     * Field _bIndStageProgClose
     */
    private java.lang.String _bIndStageProgClose;

    /**
     * Field _szCdStageProgOpen
     */
    private java.lang.String _szCdStageProgOpen;

    /**
     * Field _szCdStageProgEventType
     */
    private java.lang.String _szCdStageProgEventType;

    /**
     * Field _szCdStageProgStatus
     */
    private java.lang.String _szCdStageProgStatus;

    /**
     * Field _szTxtStageProgEvntDesc
     */
    private java.lang.String _szTxtStageProgEvntDesc;

    /**
     * Field _szCdStageProgTask
     */
    private java.lang.String _szCdStageProgTask;

    /**
     * Field _ulNbrStageProgDaysDue
     */
    private int _ulNbrStageProgDaysDue;

    /**
     * keeps track of state for field: _ulNbrStageProgDaysDue
     */
    private boolean _has_ulNbrStageProgDaysDue;

    /**
     * Field _szTxtStageProgTodoDesc
     */
    private java.lang.String _szTxtStageProgTodoDesc;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdStageProgTodoInfo
     */
    private java.lang.String _szCdStageProgTodoInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMNB8DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlNbrStageProgDaysDue()
    {
        this._has_ulNbrStageProgDaysDue= false;
    } //-- void deleteUlNbrStageProgDaysDue() 

    /**
     * Returns the value of field 'bIndStageProgClose'.
     * 
     * @return the value of field 'BIndStageProgClose'.
     */
    public java.lang.String getBIndStageProgClose()
    {
        return this._bIndStageProgClose;
    } //-- java.lang.String getBIndStageProgClose() 

    /**
     * Returns the value of field 'sCdStageProgProgram'.
     * 
     * @return the value of field 'SCdStageProgProgram'.
     */
    public java.lang.String getSCdStageProgProgram()
    {
        return this._sCdStageProgProgram;
    } //-- java.lang.String getSCdStageProgProgram() 

    /**
     * Returns the value of field 'sCdStageProgStageType'.
     * 
     * @return the value of field 'SCdStageProgStageType'.
     */
    public java.lang.String getSCdStageProgStageType()
    {
        return this._sCdStageProgStageType;
    } //-- java.lang.String getSCdStageProgStageType() 

    /**
     * Returns the value of field 'szCdStageProgEventType'.
     * 
     * @return the value of field 'SzCdStageProgEventType'.
     */
    public java.lang.String getSzCdStageProgEventType()
    {
        return this._szCdStageProgEventType;
    } //-- java.lang.String getSzCdStageProgEventType() 

    /**
     * Returns the value of field 'szCdStageProgOpen'.
     * 
     * @return the value of field 'SzCdStageProgOpen'.
     */
    public java.lang.String getSzCdStageProgOpen()
    {
        return this._szCdStageProgOpen;
    } //-- java.lang.String getSzCdStageProgOpen() 

    /**
     * Returns the value of field 'szCdStageProgRsnClosed'.
     * 
     * @return the value of field 'SzCdStageProgRsnClosed'.
     */
    public java.lang.String getSzCdStageProgRsnClosed()
    {
        return this._szCdStageProgRsnClosed;
    } //-- java.lang.String getSzCdStageProgRsnClosed() 

    /**
     * Returns the value of field 'szCdStageProgStage'.
     * 
     * @return the value of field 'SzCdStageProgStage'.
     */
    public java.lang.String getSzCdStageProgStage()
    {
        return this._szCdStageProgStage;
    } //-- java.lang.String getSzCdStageProgStage() 

    /**
     * Returns the value of field 'szCdStageProgStatus'.
     * 
     * @return the value of field 'SzCdStageProgStatus'.
     */
    public java.lang.String getSzCdStageProgStatus()
    {
        return this._szCdStageProgStatus;
    } //-- java.lang.String getSzCdStageProgStatus() 

    /**
     * Returns the value of field 'szCdStageProgTask'.
     * 
     * @return the value of field 'SzCdStageProgTask'.
     */
    public java.lang.String getSzCdStageProgTask()
    {
        return this._szCdStageProgTask;
    } //-- java.lang.String getSzCdStageProgTask() 

    /**
     * Returns the value of field 'szCdStageProgTodoInfo'.
     * 
     * @return the value of field 'SzCdStageProgTodoInfo'.
     */
    public java.lang.String getSzCdStageProgTodoInfo()
    {
        return this._szCdStageProgTodoInfo;
    } //-- java.lang.String getSzCdStageProgTodoInfo() 

    /**
     * Returns the value of field 'szTxtStageProgEvntDesc'.
     * 
     * @return the value of field 'SzTxtStageProgEvntDesc'.
     */
    public java.lang.String getSzTxtStageProgEvntDesc()
    {
        return this._szTxtStageProgEvntDesc;
    } //-- java.lang.String getSzTxtStageProgEvntDesc() 

    /**
     * Returns the value of field 'szTxtStageProgTodoDesc'.
     * 
     * @return the value of field 'SzTxtStageProgTodoDesc'.
     */
    public java.lang.String getSzTxtStageProgTodoDesc()
    {
        return this._szTxtStageProgTodoDesc;
    } //-- java.lang.String getSzTxtStageProgTodoDesc() 

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
     * Returns the value of field 'ulNbrStageProgDaysDue'.
     * 
     * @return the value of field 'UlNbrStageProgDaysDue'.
     */
    public int getUlNbrStageProgDaysDue()
    {
        return this._ulNbrStageProgDaysDue;
    } //-- int getUlNbrStageProgDaysDue() 

    /**
     * Method hasUlNbrStageProgDaysDue
     * 
     * 
     * 
     * @return true if at least one UlNbrStageProgDaysDue has been
     * added
     */
    public boolean hasUlNbrStageProgDaysDue()
    {
        return this._has_ulNbrStageProgDaysDue;
    } //-- boolean hasUlNbrStageProgDaysDue() 

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
     * Sets the value of field 'bIndStageProgClose'.
     * 
     * @param bIndStageProgClose the value of field
     * 'bIndStageProgClose'.
     */
    public void setBIndStageProgClose(java.lang.String bIndStageProgClose)
    {
        this._bIndStageProgClose = bIndStageProgClose;
    } //-- void setBIndStageProgClose(java.lang.String) 

    /**
     * Sets the value of field 'sCdStageProgProgram'.
     * 
     * @param sCdStageProgProgram the value of field
     * 'sCdStageProgProgram'.
     */
    public void setSCdStageProgProgram(java.lang.String sCdStageProgProgram)
    {
        this._sCdStageProgProgram = sCdStageProgProgram;
    } //-- void setSCdStageProgProgram(java.lang.String) 

    /**
     * Sets the value of field 'sCdStageProgStageType'.
     * 
     * @param sCdStageProgStageType the value of field
     * 'sCdStageProgStageType'.
     */
    public void setSCdStageProgStageType(java.lang.String sCdStageProgStageType)
    {
        this._sCdStageProgStageType = sCdStageProgStageType;
    } //-- void setSCdStageProgStageType(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgEventType'.
     * 
     * @param szCdStageProgEventType the value of field
     * 'szCdStageProgEventType'.
     */
    public void setSzCdStageProgEventType(java.lang.String szCdStageProgEventType)
    {
        this._szCdStageProgEventType = szCdStageProgEventType;
    } //-- void setSzCdStageProgEventType(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgOpen'.
     * 
     * @param szCdStageProgOpen the value of field
     * 'szCdStageProgOpen'.
     */
    public void setSzCdStageProgOpen(java.lang.String szCdStageProgOpen)
    {
        this._szCdStageProgOpen = szCdStageProgOpen;
    } //-- void setSzCdStageProgOpen(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgRsnClosed'.
     * 
     * @param szCdStageProgRsnClosed the value of field
     * 'szCdStageProgRsnClosed'.
     */
    public void setSzCdStageProgRsnClosed(java.lang.String szCdStageProgRsnClosed)
    {
        this._szCdStageProgRsnClosed = szCdStageProgRsnClosed;
    } //-- void setSzCdStageProgRsnClosed(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgStage'.
     * 
     * @param szCdStageProgStage the value of field
     * 'szCdStageProgStage'.
     */
    public void setSzCdStageProgStage(java.lang.String szCdStageProgStage)
    {
        this._szCdStageProgStage = szCdStageProgStage;
    } //-- void setSzCdStageProgStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgStatus'.
     * 
     * @param szCdStageProgStatus the value of field
     * 'szCdStageProgStatus'.
     */
    public void setSzCdStageProgStatus(java.lang.String szCdStageProgStatus)
    {
        this._szCdStageProgStatus = szCdStageProgStatus;
    } //-- void setSzCdStageProgStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgTask'.
     * 
     * @param szCdStageProgTask the value of field
     * 'szCdStageProgTask'.
     */
    public void setSzCdStageProgTask(java.lang.String szCdStageProgTask)
    {
        this._szCdStageProgTask = szCdStageProgTask;
    } //-- void setSzCdStageProgTask(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgTodoInfo'.
     * 
     * @param szCdStageProgTodoInfo the value of field
     * 'szCdStageProgTodoInfo'.
     */
    public void setSzCdStageProgTodoInfo(java.lang.String szCdStageProgTodoInfo)
    {
        this._szCdStageProgTodoInfo = szCdStageProgTodoInfo;
    } //-- void setSzCdStageProgTodoInfo(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStageProgEvntDesc'.
     * 
     * @param szTxtStageProgEvntDesc the value of field
     * 'szTxtStageProgEvntDesc'.
     */
    public void setSzTxtStageProgEvntDesc(java.lang.String szTxtStageProgEvntDesc)
    {
        this._szTxtStageProgEvntDesc = szTxtStageProgEvntDesc;
    } //-- void setSzTxtStageProgEvntDesc(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStageProgTodoDesc'.
     * 
     * @param szTxtStageProgTodoDesc the value of field
     * 'szTxtStageProgTodoDesc'.
     */
    public void setSzTxtStageProgTodoDesc(java.lang.String szTxtStageProgTodoDesc)
    {
        this._szTxtStageProgTodoDesc = szTxtStageProgTodoDesc;
    } //-- void setSzTxtStageProgTodoDesc(java.lang.String) 

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
     * Sets the value of field 'ulNbrStageProgDaysDue'.
     * 
     * @param ulNbrStageProgDaysDue the value of field
     * 'ulNbrStageProgDaysDue'.
     */
    public void setUlNbrStageProgDaysDue(int ulNbrStageProgDaysDue)
    {
        this._ulNbrStageProgDaysDue = ulNbrStageProgDaysDue;
        this._has_ulNbrStageProgDaysDue = true;
    } //-- void setUlNbrStageProgDaysDue(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO unmarshal(java.io.Reader) 

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
