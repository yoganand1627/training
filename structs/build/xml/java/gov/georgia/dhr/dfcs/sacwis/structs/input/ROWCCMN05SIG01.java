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
 * Class ROWCCMN05SIG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN05SIG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdNameSuffix
     */
    private java.lang.String _szCdNameSuffix;

    /**
     * Field _dtDtNameEndDate
     */
    private org.exolab.castor.types.Date _dtDtNameEndDate;

    /**
     * Field _dtDtNameStartDate
     */
    private org.exolab.castor.types.Date _dtDtNameStartDate;

    /**
     * Field _ulIdName
     */
    private int _ulIdName;

    /**
     * keeps track of state for field: _ulIdName
     */
    private boolean _has_ulIdName;

    /**
     * Field _bIndNameInvalid
     */
    private java.lang.String _bIndNameInvalid;

    /**
     * Field _bIndNamePrimary
     */
    private java.lang.String _bIndNamePrimary;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN05SIG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdName()
    {
        this._has_ulIdName= false;
    } //-- void deleteUlIdName() 

    /**
     * Returns the value of field 'bIndNameInvalid'.
     * 
     * @return the value of field 'BIndNameInvalid'.
     */
    public java.lang.String getBIndNameInvalid()
    {
        return this._bIndNameInvalid;
    } //-- java.lang.String getBIndNameInvalid() 

    /**
     * Returns the value of field 'bIndNamePrimary'.
     * 
     * @return the value of field 'BIndNamePrimary'.
     */
    public java.lang.String getBIndNamePrimary()
    {
        return this._bIndNamePrimary;
    } //-- java.lang.String getBIndNamePrimary() 

    /**
     * Returns the value of field 'dtDtNameEndDate'.
     * 
     * @return the value of field 'DtDtNameEndDate'.
     */
    public org.exolab.castor.types.Date getDtDtNameEndDate()
    {
        return this._dtDtNameEndDate;
    } //-- org.exolab.castor.types.Date getDtDtNameEndDate() 

    /**
     * Returns the value of field 'dtDtNameStartDate'.
     * 
     * @return the value of field 'DtDtNameStartDate'.
     */
    public org.exolab.castor.types.Date getDtDtNameStartDate()
    {
        return this._dtDtNameStartDate;
    } //-- org.exolab.castor.types.Date getDtDtNameStartDate() 

    /**
     * Returns the value of field 'szCdNameSuffix'.
     * 
     * @return the value of field 'SzCdNameSuffix'.
     */
    public java.lang.String getSzCdNameSuffix()
    {
        return this._szCdNameSuffix;
    } //-- java.lang.String getSzCdNameSuffix() 

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
     * Returns the value of field 'szNmNameFirst'.
     * 
     * @return the value of field 'SzNmNameFirst'.
     */
    public java.lang.String getSzNmNameFirst()
    {
        return this._szNmNameFirst;
    } //-- java.lang.String getSzNmNameFirst() 

    /**
     * Returns the value of field 'szNmNameLast'.
     * 
     * @return the value of field 'SzNmNameLast'.
     */
    public java.lang.String getSzNmNameLast()
    {
        return this._szNmNameLast;
    } //-- java.lang.String getSzNmNameLast() 

    /**
     * Returns the value of field 'szNmNameMiddle'.
     * 
     * @return the value of field 'SzNmNameMiddle'.
     */
    public java.lang.String getSzNmNameMiddle()
    {
        return this._szNmNameMiddle;
    } //-- java.lang.String getSzNmNameMiddle() 

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
     * Returns the value of field 'ulIdName'.
     * 
     * @return the value of field 'UlIdName'.
     */
    public int getUlIdName()
    {
        return this._ulIdName;
    } //-- int getUlIdName() 

    /**
     * Method hasUlIdName
     * 
     * 
     * 
     * @return true if at least one UlIdName has been added
     */
    public boolean hasUlIdName()
    {
        return this._has_ulIdName;
    } //-- boolean hasUlIdName() 

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
     * Sets the value of field 'bIndNameInvalid'.
     * 
     * @param bIndNameInvalid the value of field 'bIndNameInvalid'.
     */
    public void setBIndNameInvalid(java.lang.String bIndNameInvalid)
    {
        this._bIndNameInvalid = bIndNameInvalid;
    } //-- void setBIndNameInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndNamePrimary'.
     * 
     * @param bIndNamePrimary the value of field 'bIndNamePrimary'.
     */
    public void setBIndNamePrimary(java.lang.String bIndNamePrimary)
    {
        this._bIndNamePrimary = bIndNamePrimary;
    } //-- void setBIndNamePrimary(java.lang.String) 

    /**
     * Sets the value of field 'dtDtNameEndDate'.
     * 
     * @param dtDtNameEndDate the value of field 'dtDtNameEndDate'.
     */
    public void setDtDtNameEndDate(org.exolab.castor.types.Date dtDtNameEndDate)
    {
        this._dtDtNameEndDate = dtDtNameEndDate;
    } //-- void setDtDtNameEndDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtNameStartDate'.
     * 
     * @param dtDtNameStartDate the value of field
     * 'dtDtNameStartDate'.
     */
    public void setDtDtNameStartDate(org.exolab.castor.types.Date dtDtNameStartDate)
    {
        this._dtDtNameStartDate = dtDtNameStartDate;
    } //-- void setDtDtNameStartDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdNameSuffix'.
     * 
     * @param szCdNameSuffix the value of field 'szCdNameSuffix'.
     */
    public void setSzCdNameSuffix(java.lang.String szCdNameSuffix)
    {
        this._szCdNameSuffix = szCdNameSuffix;
    } //-- void setSzCdNameSuffix(java.lang.String) 

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
     * Sets the value of field 'szNmNameFirst'.
     * 
     * @param szNmNameFirst the value of field 'szNmNameFirst'.
     */
    public void setSzNmNameFirst(java.lang.String szNmNameFirst)
    {
        this._szNmNameFirst = szNmNameFirst;
    } //-- void setSzNmNameFirst(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameLast'.
     * 
     * @param szNmNameLast the value of field 'szNmNameLast'.
     */
    public void setSzNmNameLast(java.lang.String szNmNameLast)
    {
        this._szNmNameLast = szNmNameLast;
    } //-- void setSzNmNameLast(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameMiddle'.
     * 
     * @param szNmNameMiddle the value of field 'szNmNameMiddle'.
     */
    public void setSzNmNameMiddle(java.lang.String szNmNameMiddle)
    {
        this._szNmNameMiddle = szNmNameMiddle;
    } //-- void setSzNmNameMiddle(java.lang.String) 

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
     * Sets the value of field 'ulIdName'.
     * 
     * @param ulIdName the value of field 'ulIdName'.
     */
    public void setUlIdName(int ulIdName)
    {
        this._ulIdName = ulIdName;
        this._has_ulIdName = true;
    } //-- void setUlIdName(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01 unmarshal(java.io.Reader) 

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
