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
 * Class ROWCINV55SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV55SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdSvcReferred
     */
    private java.lang.String _szCdSvcReferred;

    /**
     * Field _ulIdChklstItem
     */
    private int _ulIdChklstItem;

    /**
     * keeps track of state for field: _ulIdChklstItem
     */
    private boolean _has_ulIdChklstItem;

    /**
     * Field _bScrIndOnOff
     */
    private java.lang.String _bScrIndOnOff;

    /**
     * Field _ulIdCpsChecklist
     */
    private int _ulIdCpsChecklist;

    /**
     * keeps track of state for field: _ulIdCpsChecklist
     */
    private boolean _has_ulIdCpsChecklist;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV55SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'bScrIndOnOff'.
     * 
     * @return the value of field 'BScrIndOnOff'.
     */
    public java.lang.String getBScrIndOnOff()
    {
        return this._bScrIndOnOff;
    } //-- java.lang.String getBScrIndOnOff() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

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
     * Sets the value of field 'bScrIndOnOff'.
     * 
     * @param bScrIndOnOff the value of field 'bScrIndOnOff'.
     */
    public void setBScrIndOnOff(java.lang.String bScrIndOnOff)
    {
        this._bScrIndOnOff = bScrIndOnOff;
    } //-- void setBScrIndOnOff(java.lang.String) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00 unmarshal(java.io.Reader) 

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
