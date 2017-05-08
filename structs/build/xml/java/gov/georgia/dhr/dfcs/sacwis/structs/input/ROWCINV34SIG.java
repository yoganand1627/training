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
 * Class ROWCINV34SIG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV34SIG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdCharacteristics
     */
    private int _ulIdCharacteristics;

    /**
     * keeps track of state for field: _ulIdCharacteristics
     */
    private boolean _has_ulIdCharacteristics;

    /**
     * Field _szCdCharCategory
     */
    private java.lang.String _szCdCharCategory;

    /**
     * Field _cdCharacteristic
     */
    private java.lang.String _cdCharacteristic;

    /**
     * Field _dtDtCharStart
     */
    private org.exolab.castor.types.Date _dtDtCharStart;

    /**
     * Field _dtDtCharEnd
     */
    private org.exolab.castor.types.Date _dtDtCharEnd;

    /**
     * Field _sysLastUpdate
     */
    private java.util.Date _sysLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV34SIG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCharacteristics()
    {
        this._has_ulIdCharacteristics= false;
    } //-- void deleteUlIdCharacteristics() 

    /**
     * Returns the value of field 'cdCharacteristic'.
     * 
     * @return the value of field 'CdCharacteristic'.
     */
    public java.lang.String getCdCharacteristic()
    {
        return this._cdCharacteristic;
    } //-- java.lang.String getCdCharacteristic() 

    /**
     * Returns the value of field 'dtDtCharEnd'.
     * 
     * @return the value of field 'DtDtCharEnd'.
     */
    public org.exolab.castor.types.Date getDtDtCharEnd()
    {
        return this._dtDtCharEnd;
    } //-- org.exolab.castor.types.Date getDtDtCharEnd() 

    /**
     * Returns the value of field 'dtDtCharStart'.
     * 
     * @return the value of field 'DtDtCharStart'.
     */
    public org.exolab.castor.types.Date getDtDtCharStart()
    {
        return this._dtDtCharStart;
    } //-- org.exolab.castor.types.Date getDtDtCharStart() 

    /**
     * Returns the value of field 'sysLastUpdate'.
     * 
     * @return the value of field 'SysLastUpdate'.
     */
    public java.util.Date getSysLastUpdate()
    {
        return this._sysLastUpdate;
    } //-- java.util.Date getSysLastUpdate() 

    /**
     * Returns the value of field 'szCdCharCategory'.
     * 
     * @return the value of field 'SzCdCharCategory'.
     */
    public java.lang.String getSzCdCharCategory()
    {
        return this._szCdCharCategory;
    } //-- java.lang.String getSzCdCharCategory() 

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
     * Returns the value of field 'ulIdCharacteristics'.
     * 
     * @return the value of field 'UlIdCharacteristics'.
     */
    public int getUlIdCharacteristics()
    {
        return this._ulIdCharacteristics;
    } //-- int getUlIdCharacteristics() 

    /**
     * Method hasUlIdCharacteristics
     * 
     * 
     * 
     * @return true if at least one UlIdCharacteristics has been
     * added
     */
    public boolean hasUlIdCharacteristics()
    {
        return this._has_ulIdCharacteristics;
    } //-- boolean hasUlIdCharacteristics() 

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
     * Sets the value of field 'cdCharacteristic'.
     * 
     * @param cdCharacteristic the value of field 'cdCharacteristic'
     */
    public void setCdCharacteristic(java.lang.String cdCharacteristic)
    {
        this._cdCharacteristic = cdCharacteristic;
    } //-- void setCdCharacteristic(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCharEnd'.
     * 
     * @param dtDtCharEnd the value of field 'dtDtCharEnd'.
     */
    public void setDtDtCharEnd(org.exolab.castor.types.Date dtDtCharEnd)
    {
        this._dtDtCharEnd = dtDtCharEnd;
    } //-- void setDtDtCharEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCharStart'.
     * 
     * @param dtDtCharStart the value of field 'dtDtCharStart'.
     */
    public void setDtDtCharStart(org.exolab.castor.types.Date dtDtCharStart)
    {
        this._dtDtCharStart = dtDtCharStart;
    } //-- void setDtDtCharStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'sysLastUpdate'.
     * 
     * @param sysLastUpdate the value of field 'sysLastUpdate'.
     */
    public void setSysLastUpdate(java.util.Date sysLastUpdate)
    {
        this._sysLastUpdate = sysLastUpdate;
    } //-- void setSysLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'szCdCharCategory'.
     * 
     * @param szCdCharCategory the value of field 'szCdCharCategory'
     */
    public void setSzCdCharCategory(java.lang.String szCdCharCategory)
    {
        this._szCdCharCategory = szCdCharCategory;
    } //-- void setSzCdCharCategory(java.lang.String) 

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
     * Sets the value of field 'ulIdCharacteristics'.
     * 
     * @param ulIdCharacteristics the value of field
     * 'ulIdCharacteristics'.
     */
    public void setUlIdCharacteristics(int ulIdCharacteristics)
    {
        this._ulIdCharacteristics = ulIdCharacteristics;
        this._has_ulIdCharacteristics = true;
    } //-- void setUlIdCharacteristics(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG unmarshal(java.io.Reader) 

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
