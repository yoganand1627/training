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
 * Class ROWCINV22SIG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV22SIG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdExtSitInfo
     */
    private int _ulIdExtSitInfo;

    /**
     * keeps track of state for field: _ulIdExtSitInfo
     */
    private boolean _has_ulIdExtSitInfo;

    /**
     * Field _szCdExtDocType
     */
    private java.lang.String _szCdExtDocType;

    /**
     * Field _szCdExtDocSort
     */
    private java.lang.String _szCdExtDocSort;

    /**
     * Field _dtDtExtDocObtained
     */
    private org.exolab.castor.types.Date _dtDtExtDocObtained;

    /**
     * Field _szTxtExtDocLocation
     */
    private java.lang.String _szTxtExtDocLocation;

    /**
     * Field _szTxtExtDocDetails
     */
    private java.lang.String _szTxtExtDocDetails;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _dtExtDocUploaded
     */
    private org.exolab.castor.types.Date _dtExtDocUploaded;

    /**
     * Field _bIndExtDocSigned
     */
    private java.lang.String _bIndExtDocSigned;

    /**
     * Field _bIndNaChecked
     */
    private java.lang.String _bIndNaChecked;

    /**
     * Field _szCdDocClass
     */
    private java.lang.String _szCdDocClass;

    /**
     * Field _szTxtExtDoc
     */
    private java.lang.String _szTxtExtDoc;

    /**
     * Field _dtExtDocAdded
     */
    private org.exolab.castor.types.Date _dtExtDocAdded;

    /**
     * Field _szTxtFileName
     */
    private java.lang.String _szTxtFileName;

    /**
     * Field _szTxtFormatType
     */
    private java.lang.String _szTxtFormatType;

    /**
     * Field _szTxtUcmDId
     */
    private java.lang.String _szTxtUcmDId;

    /**
     * Field _bIndICPCDoc
     */
    private java.lang.String _bIndICPCDoc;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV22SIG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG()


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
    public void deleteUlIdExtSitInfo()
    {
        this._has_ulIdExtSitInfo= false;
    } //-- void deleteUlIdExtSitInfo() 

    /**
     * Returns the value of field 'bIndExtDocSigned'.
     * 
     * @return the value of field 'BIndExtDocSigned'.
     */
    public java.lang.String getBIndExtDocSigned()
    {
        return this._bIndExtDocSigned;
    } //-- java.lang.String getBIndExtDocSigned() 

    /**
     * Returns the value of field 'bIndICPCDoc'.
     * 
     * @return the value of field 'BIndICPCDoc'.
     */
    public java.lang.String getBIndICPCDoc()
    {
        return this._bIndICPCDoc;
    } //-- java.lang.String getBIndICPCDoc() 

    /**
     * Returns the value of field 'bIndNaChecked'.
     * 
     * @return the value of field 'BIndNaChecked'.
     */
    public java.lang.String getBIndNaChecked()
    {
        return this._bIndNaChecked;
    } //-- java.lang.String getBIndNaChecked() 

    /**
     * Returns the value of field 'dtDtExtDocObtained'.
     * 
     * @return the value of field 'DtDtExtDocObtained'.
     */
    public org.exolab.castor.types.Date getDtDtExtDocObtained()
    {
        return this._dtDtExtDocObtained;
    } //-- org.exolab.castor.types.Date getDtDtExtDocObtained() 

    /**
     * Returns the value of field 'dtExtDocAdded'.
     * 
     * @return the value of field 'DtExtDocAdded'.
     */
    public org.exolab.castor.types.Date getDtExtDocAdded()
    {
        return this._dtExtDocAdded;
    } //-- org.exolab.castor.types.Date getDtExtDocAdded() 

    /**
     * Returns the value of field 'dtExtDocUploaded'.
     * 
     * @return the value of field 'DtExtDocUploaded'.
     */
    public org.exolab.castor.types.Date getDtExtDocUploaded()
    {
        return this._dtExtDocUploaded;
    } //-- org.exolab.castor.types.Date getDtExtDocUploaded() 

    /**
     * Returns the value of field 'szCdDocClass'.
     * 
     * @return the value of field 'SzCdDocClass'.
     */
    public java.lang.String getSzCdDocClass()
    {
        return this._szCdDocClass;
    } //-- java.lang.String getSzCdDocClass() 

    /**
     * Returns the value of field 'szCdExtDocSort'.
     * 
     * @return the value of field 'SzCdExtDocSort'.
     */
    public java.lang.String getSzCdExtDocSort()
    {
        return this._szCdExtDocSort;
    } //-- java.lang.String getSzCdExtDocSort() 

    /**
     * Returns the value of field 'szCdExtDocType'.
     * 
     * @return the value of field 'SzCdExtDocType'.
     */
    public java.lang.String getSzCdExtDocType()
    {
        return this._szCdExtDocType;
    } //-- java.lang.String getSzCdExtDocType() 

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
     * Returns the value of field 'szTxtExtDoc'.
     * 
     * @return the value of field 'SzTxtExtDoc'.
     */
    public java.lang.String getSzTxtExtDoc()
    {
        return this._szTxtExtDoc;
    } //-- java.lang.String getSzTxtExtDoc() 

    /**
     * Returns the value of field 'szTxtExtDocDetails'.
     * 
     * @return the value of field 'SzTxtExtDocDetails'.
     */
    public java.lang.String getSzTxtExtDocDetails()
    {
        return this._szTxtExtDocDetails;
    } //-- java.lang.String getSzTxtExtDocDetails() 

    /**
     * Returns the value of field 'szTxtExtDocLocation'.
     * 
     * @return the value of field 'SzTxtExtDocLocation'.
     */
    public java.lang.String getSzTxtExtDocLocation()
    {
        return this._szTxtExtDocLocation;
    } //-- java.lang.String getSzTxtExtDocLocation() 

    /**
     * Returns the value of field 'szTxtFileName'.
     * 
     * @return the value of field 'SzTxtFileName'.
     */
    public java.lang.String getSzTxtFileName()
    {
        return this._szTxtFileName;
    } //-- java.lang.String getSzTxtFileName() 

    /**
     * Returns the value of field 'szTxtFormatType'.
     * 
     * @return the value of field 'SzTxtFormatType'.
     */
    public java.lang.String getSzTxtFormatType()
    {
        return this._szTxtFormatType;
    } //-- java.lang.String getSzTxtFormatType() 

    /**
     * Returns the value of field 'szTxtUcmDId'.
     * 
     * @return the value of field 'SzTxtUcmDId'.
     */
    public java.lang.String getSzTxtUcmDId()
    {
        return this._szTxtUcmDId;
    } //-- java.lang.String getSzTxtUcmDId() 

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
     * Returns the value of field 'ulIdExtSitInfo'.
     * 
     * @return the value of field 'UlIdExtSitInfo'.
     */
    public int getUlIdExtSitInfo()
    {
        return this._ulIdExtSitInfo;
    } //-- int getUlIdExtSitInfo() 

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
     * Method hasUlIdExtSitInfo
     * 
     * 
     * 
     * @return true if at least one UlIdExtSitInfo has been added
     */
    public boolean hasUlIdExtSitInfo()
    {
        return this._has_ulIdExtSitInfo;
    } //-- boolean hasUlIdExtSitInfo() 

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
     * Sets the value of field 'bIndExtDocSigned'.
     * 
     * @param bIndExtDocSigned the value of field 'bIndExtDocSigned'
     */
    public void setBIndExtDocSigned(java.lang.String bIndExtDocSigned)
    {
        this._bIndExtDocSigned = bIndExtDocSigned;
    } //-- void setBIndExtDocSigned(java.lang.String) 

    /**
     * Sets the value of field 'bIndICPCDoc'.
     * 
     * @param bIndICPCDoc the value of field 'bIndICPCDoc'.
     */
    public void setBIndICPCDoc(java.lang.String bIndICPCDoc)
    {
        this._bIndICPCDoc = bIndICPCDoc;
    } //-- void setBIndICPCDoc(java.lang.String) 

    /**
     * Sets the value of field 'bIndNaChecked'.
     * 
     * @param bIndNaChecked the value of field 'bIndNaChecked'.
     */
    public void setBIndNaChecked(java.lang.String bIndNaChecked)
    {
        this._bIndNaChecked = bIndNaChecked;
    } //-- void setBIndNaChecked(java.lang.String) 

    /**
     * Sets the value of field 'dtDtExtDocObtained'.
     * 
     * @param dtDtExtDocObtained the value of field
     * 'dtDtExtDocObtained'.
     */
    public void setDtDtExtDocObtained(org.exolab.castor.types.Date dtDtExtDocObtained)
    {
        this._dtDtExtDocObtained = dtDtExtDocObtained;
    } //-- void setDtDtExtDocObtained(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtExtDocAdded'.
     * 
     * @param dtExtDocAdded the value of field 'dtExtDocAdded'.
     */
    public void setDtExtDocAdded(org.exolab.castor.types.Date dtExtDocAdded)
    {
        this._dtExtDocAdded = dtExtDocAdded;
    } //-- void setDtExtDocAdded(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtExtDocUploaded'.
     * 
     * @param dtExtDocUploaded the value of field 'dtExtDocUploaded'
     */
    public void setDtExtDocUploaded(org.exolab.castor.types.Date dtExtDocUploaded)
    {
        this._dtExtDocUploaded = dtExtDocUploaded;
    } //-- void setDtExtDocUploaded(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdDocClass'.
     * 
     * @param szCdDocClass the value of field 'szCdDocClass'.
     */
    public void setSzCdDocClass(java.lang.String szCdDocClass)
    {
        this._szCdDocClass = szCdDocClass;
    } //-- void setSzCdDocClass(java.lang.String) 

    /**
     * Sets the value of field 'szCdExtDocSort'.
     * 
     * @param szCdExtDocSort the value of field 'szCdExtDocSort'.
     */
    public void setSzCdExtDocSort(java.lang.String szCdExtDocSort)
    {
        this._szCdExtDocSort = szCdExtDocSort;
    } //-- void setSzCdExtDocSort(java.lang.String) 

    /**
     * Sets the value of field 'szCdExtDocType'.
     * 
     * @param szCdExtDocType the value of field 'szCdExtDocType'.
     */
    public void setSzCdExtDocType(java.lang.String szCdExtDocType)
    {
        this._szCdExtDocType = szCdExtDocType;
    } //-- void setSzCdExtDocType(java.lang.String) 

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
     * Sets the value of field 'szTxtExtDoc'.
     * 
     * @param szTxtExtDoc the value of field 'szTxtExtDoc'.
     */
    public void setSzTxtExtDoc(java.lang.String szTxtExtDoc)
    {
        this._szTxtExtDoc = szTxtExtDoc;
    } //-- void setSzTxtExtDoc(java.lang.String) 

    /**
     * Sets the value of field 'szTxtExtDocDetails'.
     * 
     * @param szTxtExtDocDetails the value of field
     * 'szTxtExtDocDetails'.
     */
    public void setSzTxtExtDocDetails(java.lang.String szTxtExtDocDetails)
    {
        this._szTxtExtDocDetails = szTxtExtDocDetails;
    } //-- void setSzTxtExtDocDetails(java.lang.String) 

    /**
     * Sets the value of field 'szTxtExtDocLocation'.
     * 
     * @param szTxtExtDocLocation the value of field
     * 'szTxtExtDocLocation'.
     */
    public void setSzTxtExtDocLocation(java.lang.String szTxtExtDocLocation)
    {
        this._szTxtExtDocLocation = szTxtExtDocLocation;
    } //-- void setSzTxtExtDocLocation(java.lang.String) 

    /**
     * Sets the value of field 'szTxtFileName'.
     * 
     * @param szTxtFileName the value of field 'szTxtFileName'.
     */
    public void setSzTxtFileName(java.lang.String szTxtFileName)
    {
        this._szTxtFileName = szTxtFileName;
    } //-- void setSzTxtFileName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtFormatType'.
     * 
     * @param szTxtFormatType the value of field 'szTxtFormatType'.
     */
    public void setSzTxtFormatType(java.lang.String szTxtFormatType)
    {
        this._szTxtFormatType = szTxtFormatType;
    } //-- void setSzTxtFormatType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtUcmDId'.
     * 
     * @param szTxtUcmDId the value of field 'szTxtUcmDId'.
     */
    public void setSzTxtUcmDId(java.lang.String szTxtUcmDId)
    {
        this._szTxtUcmDId = szTxtUcmDId;
    } //-- void setSzTxtUcmDId(java.lang.String) 

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
     * Sets the value of field 'ulIdExtSitInfo'.
     * 
     * @param ulIdExtSitInfo the value of field 'ulIdExtSitInfo'.
     */
    public void setUlIdExtSitInfo(int ulIdExtSitInfo)
    {
        this._ulIdExtSitInfo = ulIdExtSitInfo;
        this._has_ulIdExtSitInfo = true;
    } //-- void setUlIdExtSitInfo(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG unmarshal(java.io.Reader) 

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
