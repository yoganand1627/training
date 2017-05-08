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
 * Class ROWCARC06SOG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC06SOG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szTxtRptFullName
     */
    private java.lang.String _szTxtRptFullName;

    /**
     * Field _szTxtRptLstStatus
     */
    private java.lang.String _szTxtRptLstStatus;

    /**
     * Field _dtDtRptLstGeneration
     */
    private org.exolab.castor.types.Date _dtDtRptLstGeneration;

    /**
     * Field _dtDtRptLstRetainage
     */
    private org.exolab.castor.types.Date _dtDtRptLstRetainage;

    /**
     * Field _szTxtRptLstRuntimeName
     */
    private java.lang.String _szTxtRptLstRuntimeName;

    /**
     * Field _ulIdRptList
     */
    private int _ulIdRptList;

    /**
     * keeps track of state for field: _ulIdRptList
     */
    private boolean _has_ulIdRptList;

    /**
     * Field _szNmRptSqrName
     */
    private java.lang.String _szNmRptSqrName;

    /**
     * Field _szNmRptSqrVer
     */
    private java.lang.String _szNmRptSqrVer;

    /**
     * Field _szTxtRptGenName
     */
    private java.lang.String _szTxtRptGenName;

    /**
     * Field _szNmRptOrientation
     */
    private java.lang.String _szNmRptOrientation;

    /**
     * Field _szNmRptTemplateName
     */
    private java.lang.String _szNmRptTemplateName;

    /**
     * Field _szNmRptType
     */
    private java.lang.String _szNmRptType;

    /**
     * Field _szTxtRptEmailOption
     */
    private java.lang.String _szTxtRptEmailOption;

    /**
     * Field _bIndShinesBatch
     */
    private java.lang.String _bIndShinesBatch;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC06SOG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdRptList()
    {
        this._has_ulIdRptList= false;
    } //-- void deleteUlIdRptList() 

    /**
     * Returns the value of field 'bIndShinesBatch'.
     * 
     * @return the value of field 'BIndShinesBatch'.
     */
    public java.lang.String getBIndShinesBatch()
    {
        return this._bIndShinesBatch;
    } //-- java.lang.String getBIndShinesBatch() 

    /**
     * Returns the value of field 'dtDtRptLstGeneration'.
     * 
     * @return the value of field 'DtDtRptLstGeneration'.
     */
    public org.exolab.castor.types.Date getDtDtRptLstGeneration()
    {
        return this._dtDtRptLstGeneration;
    } //-- org.exolab.castor.types.Date getDtDtRptLstGeneration() 

    /**
     * Returns the value of field 'dtDtRptLstRetainage'.
     * 
     * @return the value of field 'DtDtRptLstRetainage'.
     */
    public org.exolab.castor.types.Date getDtDtRptLstRetainage()
    {
        return this._dtDtRptLstRetainage;
    } //-- org.exolab.castor.types.Date getDtDtRptLstRetainage() 

    /**
     * Returns the value of field 'szNmRptOrientation'.
     * 
     * @return the value of field 'SzNmRptOrientation'.
     */
    public java.lang.String getSzNmRptOrientation()
    {
        return this._szNmRptOrientation;
    } //-- java.lang.String getSzNmRptOrientation() 

    /**
     * Returns the value of field 'szNmRptSqrName'.
     * 
     * @return the value of field 'SzNmRptSqrName'.
     */
    public java.lang.String getSzNmRptSqrName()
    {
        return this._szNmRptSqrName;
    } //-- java.lang.String getSzNmRptSqrName() 

    /**
     * Returns the value of field 'szNmRptSqrVer'.
     * 
     * @return the value of field 'SzNmRptSqrVer'.
     */
    public java.lang.String getSzNmRptSqrVer()
    {
        return this._szNmRptSqrVer;
    } //-- java.lang.String getSzNmRptSqrVer() 

    /**
     * Returns the value of field 'szNmRptTemplateName'.
     * 
     * @return the value of field 'SzNmRptTemplateName'.
     */
    public java.lang.String getSzNmRptTemplateName()
    {
        return this._szNmRptTemplateName;
    } //-- java.lang.String getSzNmRptTemplateName() 

    /**
     * Returns the value of field 'szNmRptType'.
     * 
     * @return the value of field 'SzNmRptType'.
     */
    public java.lang.String getSzNmRptType()
    {
        return this._szNmRptType;
    } //-- java.lang.String getSzNmRptType() 

    /**
     * Returns the value of field 'szTxtRptEmailOption'.
     * 
     * @return the value of field 'SzTxtRptEmailOption'.
     */
    public java.lang.String getSzTxtRptEmailOption()
    {
        return this._szTxtRptEmailOption;
    } //-- java.lang.String getSzTxtRptEmailOption() 

    /**
     * Returns the value of field 'szTxtRptFullName'.
     * 
     * @return the value of field 'SzTxtRptFullName'.
     */
    public java.lang.String getSzTxtRptFullName()
    {
        return this._szTxtRptFullName;
    } //-- java.lang.String getSzTxtRptFullName() 

    /**
     * Returns the value of field 'szTxtRptGenName'.
     * 
     * @return the value of field 'SzTxtRptGenName'.
     */
    public java.lang.String getSzTxtRptGenName()
    {
        return this._szTxtRptGenName;
    } //-- java.lang.String getSzTxtRptGenName() 

    /**
     * Returns the value of field 'szTxtRptLstRuntimeName'.
     * 
     * @return the value of field 'SzTxtRptLstRuntimeName'.
     */
    public java.lang.String getSzTxtRptLstRuntimeName()
    {
        return this._szTxtRptLstRuntimeName;
    } //-- java.lang.String getSzTxtRptLstRuntimeName() 

    /**
     * Returns the value of field 'szTxtRptLstStatus'.
     * 
     * @return the value of field 'SzTxtRptLstStatus'.
     */
    public java.lang.String getSzTxtRptLstStatus()
    {
        return this._szTxtRptLstStatus;
    } //-- java.lang.String getSzTxtRptLstStatus() 

    /**
     * Returns the value of field 'ulIdRptList'.
     * 
     * @return the value of field 'UlIdRptList'.
     */
    public int getUlIdRptList()
    {
        return this._ulIdRptList;
    } //-- int getUlIdRptList() 

    /**
     * Method hasUlIdRptList
     * 
     * 
     * 
     * @return true if at least one UlIdRptList has been added
     */
    public boolean hasUlIdRptList()
    {
        return this._has_ulIdRptList;
    } //-- boolean hasUlIdRptList() 

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
     * Sets the value of field 'bIndShinesBatch'.
     * 
     * @param bIndShinesBatch the value of field 'bIndShinesBatch'.
     */
    public void setBIndShinesBatch(java.lang.String bIndShinesBatch)
    {
        this._bIndShinesBatch = bIndShinesBatch;
    } //-- void setBIndShinesBatch(java.lang.String) 

    /**
     * Sets the value of field 'dtDtRptLstGeneration'.
     * 
     * @param dtDtRptLstGeneration the value of field
     * 'dtDtRptLstGeneration'.
     */
    public void setDtDtRptLstGeneration(org.exolab.castor.types.Date dtDtRptLstGeneration)
    {
        this._dtDtRptLstGeneration = dtDtRptLstGeneration;
    } //-- void setDtDtRptLstGeneration(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRptLstRetainage'.
     * 
     * @param dtDtRptLstRetainage the value of field
     * 'dtDtRptLstRetainage'.
     */
    public void setDtDtRptLstRetainage(org.exolab.castor.types.Date dtDtRptLstRetainage)
    {
        this._dtDtRptLstRetainage = dtDtRptLstRetainage;
    } //-- void setDtDtRptLstRetainage(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szNmRptOrientation'.
     * 
     * @param szNmRptOrientation the value of field
     * 'szNmRptOrientation'.
     */
    public void setSzNmRptOrientation(java.lang.String szNmRptOrientation)
    {
        this._szNmRptOrientation = szNmRptOrientation;
    } //-- void setSzNmRptOrientation(java.lang.String) 

    /**
     * Sets the value of field 'szNmRptSqrName'.
     * 
     * @param szNmRptSqrName the value of field 'szNmRptSqrName'.
     */
    public void setSzNmRptSqrName(java.lang.String szNmRptSqrName)
    {
        this._szNmRptSqrName = szNmRptSqrName;
    } //-- void setSzNmRptSqrName(java.lang.String) 

    /**
     * Sets the value of field 'szNmRptSqrVer'.
     * 
     * @param szNmRptSqrVer the value of field 'szNmRptSqrVer'.
     */
    public void setSzNmRptSqrVer(java.lang.String szNmRptSqrVer)
    {
        this._szNmRptSqrVer = szNmRptSqrVer;
    } //-- void setSzNmRptSqrVer(java.lang.String) 

    /**
     * Sets the value of field 'szNmRptTemplateName'.
     * 
     * @param szNmRptTemplateName the value of field
     * 'szNmRptTemplateName'.
     */
    public void setSzNmRptTemplateName(java.lang.String szNmRptTemplateName)
    {
        this._szNmRptTemplateName = szNmRptTemplateName;
    } //-- void setSzNmRptTemplateName(java.lang.String) 

    /**
     * Sets the value of field 'szNmRptType'.
     * 
     * @param szNmRptType the value of field 'szNmRptType'.
     */
    public void setSzNmRptType(java.lang.String szNmRptType)
    {
        this._szNmRptType = szNmRptType;
    } //-- void setSzNmRptType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRptEmailOption'.
     * 
     * @param szTxtRptEmailOption the value of field
     * 'szTxtRptEmailOption'.
     */
    public void setSzTxtRptEmailOption(java.lang.String szTxtRptEmailOption)
    {
        this._szTxtRptEmailOption = szTxtRptEmailOption;
    } //-- void setSzTxtRptEmailOption(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRptFullName'.
     * 
     * @param szTxtRptFullName the value of field 'szTxtRptFullName'
     */
    public void setSzTxtRptFullName(java.lang.String szTxtRptFullName)
    {
        this._szTxtRptFullName = szTxtRptFullName;
    } //-- void setSzTxtRptFullName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRptGenName'.
     * 
     * @param szTxtRptGenName the value of field 'szTxtRptGenName'.
     */
    public void setSzTxtRptGenName(java.lang.String szTxtRptGenName)
    {
        this._szTxtRptGenName = szTxtRptGenName;
    } //-- void setSzTxtRptGenName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRptLstRuntimeName'.
     * 
     * @param szTxtRptLstRuntimeName the value of field
     * 'szTxtRptLstRuntimeName'.
     */
    public void setSzTxtRptLstRuntimeName(java.lang.String szTxtRptLstRuntimeName)
    {
        this._szTxtRptLstRuntimeName = szTxtRptLstRuntimeName;
    } //-- void setSzTxtRptLstRuntimeName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRptLstStatus'.
     * 
     * @param szTxtRptLstStatus the value of field
     * 'szTxtRptLstStatus'.
     */
    public void setSzTxtRptLstStatus(java.lang.String szTxtRptLstStatus)
    {
        this._szTxtRptLstStatus = szTxtRptLstStatus;
    } //-- void setSzTxtRptLstStatus(java.lang.String) 

    /**
     * Sets the value of field 'ulIdRptList'.
     * 
     * @param ulIdRptList the value of field 'ulIdRptList'.
     */
    public void setUlIdRptList(int ulIdRptList)
    {
        this._ulIdRptList = ulIdRptList;
        this._has_ulIdRptList = true;
    } //-- void setUlIdRptList(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG unmarshal(java.io.Reader) 

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
