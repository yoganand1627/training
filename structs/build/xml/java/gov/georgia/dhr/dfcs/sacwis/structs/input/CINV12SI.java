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
 * Class CINV12SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV12SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ROWCINV12SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01 _ROWCINV12SIG01;

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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ROWCINV12SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00_ARRAY _ROWCINV12SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV12SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI()


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
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCINV12SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV12SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00_ARRAY getROWCINV12SIG00_ARRAY()
    {
        return this._ROWCINV12SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00_ARRAY getROWCINV12SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV12SIG01'.
     * 
     * @return the value of field 'ROWCINV12SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01 getROWCINV12SIG01()
    {
        return this._ROWCINV12SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01 getROWCINV12SIG01() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCINV12SIG00_ARRAY'.
     * 
     * @param ROWCINV12SIG00_ARRAY the value of field
     * 'ROWCINV12SIG00_ARRAY'.
     */
    public void setROWCINV12SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00_ARRAY ROWCINV12SIG00_ARRAY)
    {
        this._ROWCINV12SIG00_ARRAY = ROWCINV12SIG00_ARRAY;
    } //-- void setROWCINV12SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV12SIG01'.
     * 
     * @param ROWCINV12SIG01 the value of field 'ROWCINV12SIG01'.
     */
    public void setROWCINV12SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01 ROWCINV12SIG01)
    {
        this._ROWCINV12SIG01 = ROWCINV12SIG01;
    } //-- void setROWCINV12SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI unmarshal(java.io.Reader) 

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
