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
 * Class ROWCINV54SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV54SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdSvcReferred
     */
    private java.lang.String _szCdSvcReferred;

    /**
     * Field _ulIdCpsChecklist
     */
    private int _ulIdCpsChecklist;

    /**
     * keeps track of state for field: _ulIdCpsChecklist
     */
    private boolean _has_ulIdCpsChecklist;

    /**
     * Field _ulIdChklstItem
     */
    private int _ulIdChklstItem;

    /**
     * keeps track of state for field: _ulIdChklstItem
     */
    private boolean _has_ulIdChklstItem;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV54SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01()


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
    public void deleteUlIdChklstItem()
    {
        this._has_ulIdChklstItem= false;
    } //-- void deleteUlIdChklstItem() 

    /**
     */
    public void deleteUlIdCpsChecklist()
    {
        this._has_ulIdCpsChecklist= false;
    } //-- void deleteUlIdCpsChecklist() 

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
     * Returns the value of field 'szCdSvcReferred'.
     * 
     * @return the value of field 'SzCdSvcReferred'.
     */
    public java.lang.String getSzCdSvcReferred()
    {
        return this._szCdSvcReferred;
    } //-- java.lang.String getSzCdSvcReferred() 

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
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdChklstItem'.
     * 
     * @return the value of field 'UlIdChklstItem'.
     */
    public int getUlIdChklstItem()
    {
        return this._ulIdChklstItem;
    } //-- int getUlIdChklstItem() 

    /**
     * Returns the value of field 'ulIdCpsChecklist'.
     * 
     * @return the value of field 'UlIdCpsChecklist'.
     */
    public int getUlIdCpsChecklist()
    {
        return this._ulIdCpsChecklist;
    } //-- int getUlIdCpsChecklist() 

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
     * Method hasUlIdChklstItem
     * 
     * 
     * 
     * @return true if at least one UlIdChklstItem has been added
     */
    public boolean hasUlIdChklstItem()
    {
        return this._has_ulIdChklstItem;
    } //-- boolean hasUlIdChklstItem() 

    /**
     * Method hasUlIdCpsChecklist
     * 
     * 
     * 
     * @return true if at least one UlIdCpsChecklist has been added
     */
    public boolean hasUlIdCpsChecklist()
    {
        return this._has_ulIdCpsChecklist;
    } //-- boolean hasUlIdCpsChecklist() 

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
     * Sets the value of field 'szCdSvcReferred'.
     * 
     * @param szCdSvcReferred the value of field 'szCdSvcReferred'.
     */
    public void setSzCdSvcReferred(java.lang.String szCdSvcReferred)
    {
        this._szCdSvcReferred = szCdSvcReferred;
    } //-- void setSzCdSvcReferred(java.lang.String) 

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
     * Sets the value of field 'ulIdChklstItem'.
     * 
     * @param ulIdChklstItem the value of field 'ulIdChklstItem'.
     */
    public void setUlIdChklstItem(int ulIdChklstItem)
    {
        this._ulIdChklstItem = ulIdChklstItem;
        this._has_ulIdChklstItem = true;
    } //-- void setUlIdChklstItem(int) 

    /**
     * Sets the value of field 'ulIdCpsChecklist'.
     * 
     * @param ulIdCpsChecklist the value of field 'ulIdCpsChecklist'
     */
    public void setUlIdCpsChecklist(int ulIdCpsChecklist)
    {
        this._ulIdCpsChecklist = ulIdCpsChecklist;
        this._has_ulIdCpsChecklist = true;
    } //-- void setUlIdCpsChecklist(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01 unmarshal(java.io.Reader) 

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
