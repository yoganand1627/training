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
 * Class ROWCSUB36SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB36SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdChildPlanEvent
     */
    private int _ulIdChildPlanEvent;

    /**
     * keeps track of state for field: _ulIdChildPlanEvent
     */
    private boolean _has_ulIdChildPlanEvent;

    /**
     * Field _ulIdChildPlanPart
     */
    private int _ulIdChildPlanPart;

    /**
     * keeps track of state for field: _ulIdChildPlanPart
     */
    private boolean _has_ulIdChildPlanPart;

    /**
     * Field _szCdCspPartType
     */
    private java.lang.String _szCdCspPartType;

    /**
     * Field _szNmCspPartFull
     */
    private java.lang.String _szNmCspPartFull;

    /**
     * Field _szSdsCspPartRelationship
     */
    private java.lang.String _szSdsCspPartRelationship;

    /**
     * Field _szCdCspPartNotifType
     */
    private java.lang.String _szCdCspPartNotifType;

    /**
     * Field _dtDtCspDateNotified
     */
    private org.exolab.castor.types.Date _dtDtCspDateNotified;

    /**
     * Field _dtDtCspPartParticipate
     */
    private org.exolab.castor.types.Date _dtDtCspPartParticipate;

    /**
     * Field _dtDtCspPartCopyGiven
     */
    private org.exolab.castor.types.Date _dtDtCspPartCopyGiven;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB36SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdChildPlanEvent()
    {
        this._has_ulIdChildPlanEvent= false;
    } //-- void deleteUlIdChildPlanEvent() 

    /**
     */
    public void deleteUlIdChildPlanPart()
    {
        this._has_ulIdChildPlanPart= false;
    } //-- void deleteUlIdChildPlanPart() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'dtDtCspDateNotified'.
     * 
     * @return the value of field 'DtDtCspDateNotified'.
     */
    public org.exolab.castor.types.Date getDtDtCspDateNotified()
    {
        return this._dtDtCspDateNotified;
    } //-- org.exolab.castor.types.Date getDtDtCspDateNotified() 

    /**
     * Returns the value of field 'dtDtCspPartCopyGiven'.
     * 
     * @return the value of field 'DtDtCspPartCopyGiven'.
     */
    public org.exolab.castor.types.Date getDtDtCspPartCopyGiven()
    {
        return this._dtDtCspPartCopyGiven;
    } //-- org.exolab.castor.types.Date getDtDtCspPartCopyGiven() 

    /**
     * Returns the value of field 'dtDtCspPartParticipate'.
     * 
     * @return the value of field 'DtDtCspPartParticipate'.
     */
    public org.exolab.castor.types.Date getDtDtCspPartParticipate()
    {
        return this._dtDtCspPartParticipate;
    } //-- org.exolab.castor.types.Date getDtDtCspPartParticipate() 

    /**
     * Returns the value of field 'szCdCspPartNotifType'.
     * 
     * @return the value of field 'SzCdCspPartNotifType'.
     */
    public java.lang.String getSzCdCspPartNotifType()
    {
        return this._szCdCspPartNotifType;
    } //-- java.lang.String getSzCdCspPartNotifType() 

    /**
     * Returns the value of field 'szCdCspPartType'.
     * 
     * @return the value of field 'SzCdCspPartType'.
     */
    public java.lang.String getSzCdCspPartType()
    {
        return this._szCdCspPartType;
    } //-- java.lang.String getSzCdCspPartType() 

    /**
     * Returns the value of field 'szNmCspPartFull'.
     * 
     * @return the value of field 'SzNmCspPartFull'.
     */
    public java.lang.String getSzNmCspPartFull()
    {
        return this._szNmCspPartFull;
    } //-- java.lang.String getSzNmCspPartFull() 

    /**
     * Returns the value of field 'szSdsCspPartRelationship'.
     * 
     * @return the value of field 'SzSdsCspPartRelationship'.
     */
    public java.lang.String getSzSdsCspPartRelationship()
    {
        return this._szSdsCspPartRelationship;
    } //-- java.lang.String getSzSdsCspPartRelationship() 

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
     * Returns the value of field 'ulIdChildPlanEvent'.
     * 
     * @return the value of field 'UlIdChildPlanEvent'.
     */
    public int getUlIdChildPlanEvent()
    {
        return this._ulIdChildPlanEvent;
    } //-- int getUlIdChildPlanEvent() 

    /**
     * Returns the value of field 'ulIdChildPlanPart'.
     * 
     * @return the value of field 'UlIdChildPlanPart'.
     */
    public int getUlIdChildPlanPart()
    {
        return this._ulIdChildPlanPart;
    } //-- int getUlIdChildPlanPart() 

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
     * Method hasUlIdChildPlanEvent
     * 
     * 
     * 
     * @return true if at least one UlIdChildPlanEvent has been adde
     */
    public boolean hasUlIdChildPlanEvent()
    {
        return this._has_ulIdChildPlanEvent;
    } //-- boolean hasUlIdChildPlanEvent() 

    /**
     * Method hasUlIdChildPlanPart
     * 
     * 
     * 
     * @return true if at least one UlIdChildPlanPart has been added
     */
    public boolean hasUlIdChildPlanPart()
    {
        return this._has_ulIdChildPlanPart;
    } //-- boolean hasUlIdChildPlanPart() 

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
     * Sets the value of field 'dtDtCspDateNotified'.
     * 
     * @param dtDtCspDateNotified the value of field
     * 'dtDtCspDateNotified'.
     */
    public void setDtDtCspDateNotified(org.exolab.castor.types.Date dtDtCspDateNotified)
    {
        this._dtDtCspDateNotified = dtDtCspDateNotified;
    } //-- void setDtDtCspDateNotified(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCspPartCopyGiven'.
     * 
     * @param dtDtCspPartCopyGiven the value of field
     * 'dtDtCspPartCopyGiven'.
     */
    public void setDtDtCspPartCopyGiven(org.exolab.castor.types.Date dtDtCspPartCopyGiven)
    {
        this._dtDtCspPartCopyGiven = dtDtCspPartCopyGiven;
    } //-- void setDtDtCspPartCopyGiven(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCspPartParticipate'.
     * 
     * @param dtDtCspPartParticipate the value of field
     * 'dtDtCspPartParticipate'.
     */
    public void setDtDtCspPartParticipate(org.exolab.castor.types.Date dtDtCspPartParticipate)
    {
        this._dtDtCspPartParticipate = dtDtCspPartParticipate;
    } //-- void setDtDtCspPartParticipate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCspPartNotifType'.
     * 
     * @param szCdCspPartNotifType the value of field
     * 'szCdCspPartNotifType'.
     */
    public void setSzCdCspPartNotifType(java.lang.String szCdCspPartNotifType)
    {
        this._szCdCspPartNotifType = szCdCspPartNotifType;
    } //-- void setSzCdCspPartNotifType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCspPartType'.
     * 
     * @param szCdCspPartType the value of field 'szCdCspPartType'.
     */
    public void setSzCdCspPartType(java.lang.String szCdCspPartType)
    {
        this._szCdCspPartType = szCdCspPartType;
    } //-- void setSzCdCspPartType(java.lang.String) 

    /**
     * Sets the value of field 'szNmCspPartFull'.
     * 
     * @param szNmCspPartFull the value of field 'szNmCspPartFull'.
     */
    public void setSzNmCspPartFull(java.lang.String szNmCspPartFull)
    {
        this._szNmCspPartFull = szNmCspPartFull;
    } //-- void setSzNmCspPartFull(java.lang.String) 

    /**
     * Sets the value of field 'szSdsCspPartRelationship'.
     * 
     * @param szSdsCspPartRelationship the value of field
     * 'szSdsCspPartRelationship'.
     */
    public void setSzSdsCspPartRelationship(java.lang.String szSdsCspPartRelationship)
    {
        this._szSdsCspPartRelationship = szSdsCspPartRelationship;
    } //-- void setSzSdsCspPartRelationship(java.lang.String) 

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
     * Sets the value of field 'ulIdChildPlanEvent'.
     * 
     * @param ulIdChildPlanEvent the value of field
     * 'ulIdChildPlanEvent'.
     */
    public void setUlIdChildPlanEvent(int ulIdChildPlanEvent)
    {
        this._ulIdChildPlanEvent = ulIdChildPlanEvent;
        this._has_ulIdChildPlanEvent = true;
    } //-- void setUlIdChildPlanEvent(int) 

    /**
     * Sets the value of field 'ulIdChildPlanPart'.
     * 
     * @param ulIdChildPlanPart the value of field
     * 'ulIdChildPlanPart'.
     */
    public void setUlIdChildPlanPart(int ulIdChildPlanPart)
    {
        this._ulIdChildPlanPart = ulIdChildPlanPart;
        this._has_ulIdChildPlanPart = true;
    } //-- void setUlIdChildPlanPart(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 unmarshal(java.io.Reader) 

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
