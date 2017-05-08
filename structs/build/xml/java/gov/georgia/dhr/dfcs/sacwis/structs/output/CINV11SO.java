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
 * Class CINV11SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV11SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV11SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG01 _ROWCINV11SOG01;

    /**
     * Field _ROWCCMN45DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO _ROWCCMN45DO;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ROWCINV11SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY _ROWCINV11SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV11SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO()


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
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'ROWCCMN45DO'.
     * 
     * @return the value of field 'ROWCCMN45DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO()
    {
        return this._ROWCCMN45DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO() 

    /**
     * Returns the value of field 'ROWCINV11SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV11SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY getROWCINV11SOG00_ARRAY()
    {
        return this._ROWCINV11SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY getROWCINV11SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV11SOG01'.
     * 
     * @return the value of field 'ROWCINV11SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG01 getROWCINV11SOG01()
    {
        return this._ROWCINV11SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG01 getROWCINV11SOG01() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'ROWCCMN45DO'.
     * 
     * @param ROWCCMN45DO the value of field 'ROWCCMN45DO'.
     */
    public void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO ROWCCMN45DO)
    {
        this._ROWCCMN45DO = ROWCCMN45DO;
    } //-- void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO) 

    /**
     * Sets the value of field 'ROWCINV11SOG00_ARRAY'.
     * 
     * @param ROWCINV11SOG00_ARRAY the value of field
     * 'ROWCINV11SOG00_ARRAY'.
     */
    public void setROWCINV11SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY ROWCINV11SOG00_ARRAY)
    {
        this._ROWCINV11SOG00_ARRAY = ROWCINV11SOG00_ARRAY;
    } //-- void setROWCINV11SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV11SOG01'.
     * 
     * @param ROWCINV11SOG01 the value of field 'ROWCINV11SOG01'.
     */
    public void setROWCINV11SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG01 ROWCINV11SOG01)
    {
        this._ROWCINV11SOG01 = ROWCINV11SOG01;
    } //-- void setROWCINV11SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG01) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO unmarshal(java.io.Reader) 

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
