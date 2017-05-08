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
 * Class CSUB26SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB26SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _sNbrRshsOpenSlots
     */
    private int _sNbrRshsOpenSlots;

    /**
     * keeps track of state for field: _sNbrRshsOpenSlots
     */
    private boolean _has_sNbrRshsOpenSlots;

    /**
     * Field _tsLastUpdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY _tsLastUpdate_ARRAY;

    /**
     * Field _sNbrRsrcOpenSlots
     */
    private int _sNbrRsrcOpenSlots;

    /**
     * keeps track of state for field: _sNbrRsrcOpenSlots
     */
    private boolean _has_sNbrRsrcOpenSlots;

    /**
     * Field _cIndEllig
     */
    private java.lang.String _cIndEllig;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB26SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSNbrRshsOpenSlots()
    {
        this._has_sNbrRshsOpenSlots= false;
    } //-- void deleteSNbrRshsOpenSlots() 

    /**
     */
    public void deleteSNbrRsrcOpenSlots()
    {
        this._has_sNbrRsrcOpenSlots= false;
    } //-- void deleteSNbrRsrcOpenSlots() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

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
     * Returns the value of field 'cIndEllig'.
     * 
     * @return the value of field 'CIndEllig'.
     */
    public java.lang.String getCIndEllig()
    {
        return this._cIndEllig;
    } //-- java.lang.String getCIndEllig() 

    /**
     * Returns the value of field 'sNbrRshsOpenSlots'.
     * 
     * @return the value of field 'SNbrRshsOpenSlots'.
     */
    public int getSNbrRshsOpenSlots()
    {
        return this._sNbrRshsOpenSlots;
    } //-- int getSNbrRshsOpenSlots() 

    /**
     * Returns the value of field 'sNbrRsrcOpenSlots'.
     * 
     * @return the value of field 'SNbrRsrcOpenSlots'.
     */
    public int getSNbrRsrcOpenSlots()
    {
        return this._sNbrRsrcOpenSlots;
    } //-- int getSNbrRsrcOpenSlots() 

    /**
     * Returns the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY()
    {
        return this._tsLastUpdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY() 

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
     * Method hasSNbrRshsOpenSlots
     * 
     * 
     * 
     * @return true if at least one SNbrRshsOpenSlots has been added
     */
    public boolean hasSNbrRshsOpenSlots()
    {
        return this._has_sNbrRshsOpenSlots;
    } //-- boolean hasSNbrRshsOpenSlots() 

    /**
     * Method hasSNbrRsrcOpenSlots
     * 
     * 
     * 
     * @return true if at least one SNbrRsrcOpenSlots has been added
     */
    public boolean hasSNbrRsrcOpenSlots()
    {
        return this._has_sNbrRsrcOpenSlots;
    } //-- boolean hasSNbrRsrcOpenSlots() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'cIndEllig'.
     * 
     * @param cIndEllig the value of field 'cIndEllig'.
     */
    public void setCIndEllig(java.lang.String cIndEllig)
    {
        this._cIndEllig = cIndEllig;
    } //-- void setCIndEllig(java.lang.String) 

    /**
     * Sets the value of field 'sNbrRshsOpenSlots'.
     * 
     * @param sNbrRshsOpenSlots the value of field
     * 'sNbrRshsOpenSlots'.
     */
    public void setSNbrRshsOpenSlots(int sNbrRshsOpenSlots)
    {
        this._sNbrRshsOpenSlots = sNbrRshsOpenSlots;
        this._has_sNbrRshsOpenSlots = true;
    } //-- void setSNbrRshsOpenSlots(int) 

    /**
     * Sets the value of field 'sNbrRsrcOpenSlots'.
     * 
     * @param sNbrRsrcOpenSlots the value of field
     * 'sNbrRsrcOpenSlots'.
     */
    public void setSNbrRsrcOpenSlots(int sNbrRsrcOpenSlots)
    {
        this._sNbrRsrcOpenSlots = sNbrRsrcOpenSlots;
        this._has_sNbrRsrcOpenSlots = true;
    } //-- void setSNbrRsrcOpenSlots(int) 

    /**
     * Sets the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @param tsLastUpdate_ARRAY the value of field
     * 'tsLastUpdate_ARRAY'.
     */
    public void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY tsLastUpdate_ARRAY)
    {
        this._tsLastUpdate_ARRAY = tsLastUpdate_ARRAY;
    } //-- void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO unmarshal(java.io.Reader) 

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
