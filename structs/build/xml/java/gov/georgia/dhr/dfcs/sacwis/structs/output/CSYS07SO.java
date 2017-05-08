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
 * Class CSYS07SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSYS07SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _nbrContact
     */
    private int _nbrContact;

    /**
     * keeps track of state for field: _nbrContact
     */
    private boolean _has_nbrContact;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _dtDtInvStart
     */
    private org.exolab.castor.types.Date _dtDtInvStart;

    /**
     * Field _dtDTContactOccurred
     */
    private java.util.Date _dtDTContactOccurred;

    /**
     * Field _ulIdPalStage
     */
    private int _ulIdPalStage;

    /**
     * keeps track of state for field: _ulIdPalStage
     */
    private boolean _has_ulIdPalStage;

    /**
     * Field _ulIdPalWorker
     */
    private int _ulIdPalWorker;

    /**
     * keeps track of state for field: _ulIdPalWorker
     */
    private boolean _has_ulIdPalWorker;

    /**
     * Field _bIndSendPalFollowup
     */
    private java.lang.String _bIndSendPalFollowup;

    /**
     * Field _ulIdPlcmtChild
     */
    private int _ulIdPlcmtChild;

    /**
     * keeps track of state for field: _ulIdPlcmtChild
     */
    private boolean _has_ulIdPlcmtChild;

    /**
     * Field _eventIdStruct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY _eventIdStruct_ARRAY;

    /**
     * Field _bIndVictimRole_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY _bIndVictimRole_ARRAY;

    /**
     * Field _bIndSendEdit
     */
    private java.lang.String _bIndSendEdit;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSYS07SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNbrContact()
    {
        this._has_nbrContact= false;
    } //-- void deleteNbrContact() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdPalStage()
    {
        this._has_ulIdPalStage= false;
    } //-- void deleteUlIdPalStage() 

    /**
     */
    public void deleteUlIdPalWorker()
    {
        this._has_ulIdPalWorker= false;
    } //-- void deleteUlIdPalWorker() 

    /**
     */
    public void deleteUlIdPlcmtChild()
    {
        this._has_ulIdPlcmtChild= false;
    } //-- void deleteUlIdPlcmtChild() 

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
     * Returns the value of field 'bIndSendEdit'.
     * 
     * @return the value of field 'BIndSendEdit'.
     */
    public java.lang.String getBIndSendEdit()
    {
        return this._bIndSendEdit;
    } //-- java.lang.String getBIndSendEdit() 

    /**
     * Returns the value of field 'bIndSendPalFollowup'.
     * 
     * @return the value of field 'BIndSendPalFollowup'.
     */
    public java.lang.String getBIndSendPalFollowup()
    {
        return this._bIndSendPalFollowup;
    } //-- java.lang.String getBIndSendPalFollowup() 

    /**
     * Returns the value of field 'bIndVictimRole_ARRAY'.
     * 
     * @return the value of field 'BIndVictimRole_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY getBIndVictimRole_ARRAY()
    {
        return this._bIndVictimRole_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY getBIndVictimRole_ARRAY() 

    /**
     * Returns the value of field 'dtDTContactOccurred'.
     * 
     * @return the value of field 'DtDTContactOccurred'.
     */
    public java.util.Date getDtDTContactOccurred()
    {
        return this._dtDTContactOccurred;
    } //-- java.util.Date getDtDTContactOccurred() 

    /**
     * Returns the value of field 'dtDtInvStart'.
     * 
     * @return the value of field 'DtDtInvStart'.
     */
    public org.exolab.castor.types.Date getDtDtInvStart()
    {
        return this._dtDtInvStart;
    } //-- org.exolab.castor.types.Date getDtDtInvStart() 

    /**
     * Returns the value of field 'eventIdStruct_ARRAY'.
     * 
     * @return the value of field 'EventIdStruct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY getEventIdStruct_ARRAY()
    {
        return this._eventIdStruct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY getEventIdStruct_ARRAY() 

    /**
     * Returns the value of field 'nbrContact'.
     * 
     * @return the value of field 'NbrContact'.
     */
    public int getNbrContact()
    {
        return this._nbrContact;
    } //-- int getNbrContact() 

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
     * Returns the value of field 'ulIdPalStage'.
     * 
     * @return the value of field 'UlIdPalStage'.
     */
    public int getUlIdPalStage()
    {
        return this._ulIdPalStage;
    } //-- int getUlIdPalStage() 

    /**
     * Returns the value of field 'ulIdPalWorker'.
     * 
     * @return the value of field 'UlIdPalWorker'.
     */
    public int getUlIdPalWorker()
    {
        return this._ulIdPalWorker;
    } //-- int getUlIdPalWorker() 

    /**
     * Returns the value of field 'ulIdPlcmtChild'.
     * 
     * @return the value of field 'UlIdPlcmtChild'.
     */
    public int getUlIdPlcmtChild()
    {
        return this._ulIdPlcmtChild;
    } //-- int getUlIdPlcmtChild() 

    /**
     * Method hasNbrContact
     * 
     * 
     * 
     * @return true if at least one NbrContact has been added
     */
    public boolean hasNbrContact()
    {
        return this._has_nbrContact;
    } //-- boolean hasNbrContact() 

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
     * Method hasUlIdPalStage
     * 
     * 
     * 
     * @return true if at least one UlIdPalStage has been added
     */
    public boolean hasUlIdPalStage()
    {
        return this._has_ulIdPalStage;
    } //-- boolean hasUlIdPalStage() 

    /**
     * Method hasUlIdPalWorker
     * 
     * 
     * 
     * @return true if at least one UlIdPalWorker has been added
     */
    public boolean hasUlIdPalWorker()
    {
        return this._has_ulIdPalWorker;
    } //-- boolean hasUlIdPalWorker() 

    /**
     * Method hasUlIdPlcmtChild
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtChild has been added
     */
    public boolean hasUlIdPlcmtChild()
    {
        return this._has_ulIdPlcmtChild;
    } //-- boolean hasUlIdPlcmtChild() 

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
     * Sets the value of field 'bIndSendEdit'.
     * 
     * @param bIndSendEdit the value of field 'bIndSendEdit'.
     */
    public void setBIndSendEdit(java.lang.String bIndSendEdit)
    {
        this._bIndSendEdit = bIndSendEdit;
    } //-- void setBIndSendEdit(java.lang.String) 

    /**
     * Sets the value of field 'bIndSendPalFollowup'.
     * 
     * @param bIndSendPalFollowup the value of field
     * 'bIndSendPalFollowup'.
     */
    public void setBIndSendPalFollowup(java.lang.String bIndSendPalFollowup)
    {
        this._bIndSendPalFollowup = bIndSendPalFollowup;
    } //-- void setBIndSendPalFollowup(java.lang.String) 

    /**
     * Sets the value of field 'bIndVictimRole_ARRAY'.
     * 
     * @param bIndVictimRole_ARRAY the value of field
     * 'bIndVictimRole_ARRAY'.
     */
    public void setBIndVictimRole_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY bIndVictimRole_ARRAY)
    {
        this._bIndVictimRole_ARRAY = bIndVictimRole_ARRAY;
    } //-- void setBIndVictimRole_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY) 

    /**
     * Sets the value of field 'dtDTContactOccurred'.
     * 
     * @param dtDTContactOccurred the value of field
     * 'dtDTContactOccurred'.
     */
    public void setDtDTContactOccurred(java.util.Date dtDTContactOccurred)
    {
        this._dtDTContactOccurred = dtDTContactOccurred;
    } //-- void setDtDTContactOccurred(java.util.Date) 

    /**
     * Sets the value of field 'dtDtInvStart'.
     * 
     * @param dtDtInvStart the value of field 'dtDtInvStart'.
     */
    public void setDtDtInvStart(org.exolab.castor.types.Date dtDtInvStart)
    {
        this._dtDtInvStart = dtDtInvStart;
    } //-- void setDtDtInvStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'eventIdStruct_ARRAY'.
     * 
     * @param eventIdStruct_ARRAY the value of field
     * 'eventIdStruct_ARRAY'.
     */
    public void setEventIdStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY eventIdStruct_ARRAY)
    {
        this._eventIdStruct_ARRAY = eventIdStruct_ARRAY;
    } //-- void setEventIdStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY) 

    /**
     * Sets the value of field 'nbrContact'.
     * 
     * @param nbrContact the value of field 'nbrContact'.
     */
    public void setNbrContact(int nbrContact)
    {
        this._nbrContact = nbrContact;
        this._has_nbrContact = true;
    } //-- void setNbrContact(int) 

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
     * Sets the value of field 'ulIdPalStage'.
     * 
     * @param ulIdPalStage the value of field 'ulIdPalStage'.
     */
    public void setUlIdPalStage(int ulIdPalStage)
    {
        this._ulIdPalStage = ulIdPalStage;
        this._has_ulIdPalStage = true;
    } //-- void setUlIdPalStage(int) 

    /**
     * Sets the value of field 'ulIdPalWorker'.
     * 
     * @param ulIdPalWorker the value of field 'ulIdPalWorker'.
     */
    public void setUlIdPalWorker(int ulIdPalWorker)
    {
        this._ulIdPalWorker = ulIdPalWorker;
        this._has_ulIdPalWorker = true;
    } //-- void setUlIdPalWorker(int) 

    /**
     * Sets the value of field 'ulIdPlcmtChild'.
     * 
     * @param ulIdPlcmtChild the value of field 'ulIdPlcmtChild'.
     */
    public void setUlIdPlcmtChild(int ulIdPlcmtChild)
    {
        this._ulIdPlcmtChild = ulIdPlcmtChild;
        this._has_ulIdPlcmtChild = true;
    } //-- void setUlIdPlcmtChild(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO unmarshal(java.io.Reader) 

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
