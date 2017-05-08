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
 * Class CRES10SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES10SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _bIndAvailableAfterHrs
     */
    private java.lang.String _bIndAvailableAfterHrs;

    /**
     * Field _szCdRsrcCertBy
     */
    private java.lang.String _szCdRsrcCertBy;

    /**
     * Field _txtSpecCert
     */
    private java.lang.String _txtSpecCert;

    /**
     * Field _szCdRsrcOperBy
     */
    private java.lang.String _szCdRsrcOperBy;

    /**
     * Field _szCdRsrcSetting
     */
    private java.lang.String _szCdRsrcSetting;

    /**
     * Field _szCdRsrcPayment
     */
    private java.lang.String _szCdRsrcPayment;

    /**
     * Field _dtDtRsrcCert
     */
    private org.exolab.castor.types.Date _dtDtRsrcCert;

    /**
     * Field _dtDtRsrcClose
     */
    private org.exolab.castor.types.Date _dtDtRsrcClose;

    /**
     * Field _uNbrRsrcFacilCapacity
     */
    private int _uNbrRsrcFacilCapacity;

    /**
     * keeps track of state for field: _uNbrRsrcFacilCapacity
     */
    private boolean _has_uNbrRsrcFacilCapacity;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _ulRowQty2
     */
    private int _ulRowQty2;

    /**
     * keeps track of state for field: _ulRowQty2
     */
    private boolean _has_ulRowQty2;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _CRES10SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00_ARRAY _CRES10SIG00_ARRAY;

    /**
     * Field _CRES10SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01_ARRAY _CRES10SIG01_ARRAY;

    /**
     * Field _szNmRsrcLastUpdate
     */
    private java.lang.String _szNmRsrcLastUpdate;

    /**
     * Field _selectedLicensureTypesArrayIn
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn _selectedLicensureTypesArrayIn;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES10SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUNbrRsrcFacilCapacity()
    {
        this._has_uNbrRsrcFacilCapacity= false;
    } //-- void deleteUNbrRsrcFacilCapacity() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     */
    public void deleteUlRowQty2()
    {
        this._has_ulRowQty2= false;
    } //-- void deleteUlRowQty2() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'bIndAvailableAfterHrs'.
     * 
     * @return the value of field 'BIndAvailableAfterHrs'.
     */
    public java.lang.String getBIndAvailableAfterHrs()
    {
        return this._bIndAvailableAfterHrs;
    } //-- java.lang.String getBIndAvailableAfterHrs() 

    /**
     * Returns the value of field 'CRES10SIG00_ARRAY'.
     * 
     * @return the value of field 'CRES10SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00_ARRAY getCRES10SIG00_ARRAY()
    {
        return this._CRES10SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00_ARRAY getCRES10SIG00_ARRAY() 

    /**
     * Returns the value of field 'CRES10SIG01_ARRAY'.
     * 
     * @return the value of field 'CRES10SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01_ARRAY getCRES10SIG01_ARRAY()
    {
        return this._CRES10SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01_ARRAY getCRES10SIG01_ARRAY() 

    /**
     * Returns the value of field 'dtDtRsrcCert'.
     * 
     * @return the value of field 'DtDtRsrcCert'.
     */
    public org.exolab.castor.types.Date getDtDtRsrcCert()
    {
        return this._dtDtRsrcCert;
    } //-- org.exolab.castor.types.Date getDtDtRsrcCert() 

    /**
     * Returns the value of field 'dtDtRsrcClose'.
     * 
     * @return the value of field 'DtDtRsrcClose'.
     */
    public org.exolab.castor.types.Date getDtDtRsrcClose()
    {
        return this._dtDtRsrcClose;
    } //-- org.exolab.castor.types.Date getDtDtRsrcClose() 

    /**
     * Returns the value of field 'selectedLicensureTypesArrayIn'.
     * 
     * @return the value of field 'SelectedLicensureTypesArrayIn'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn getSelectedLicensureTypesArrayIn()
    {
        return this._selectedLicensureTypesArrayIn;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn getSelectedLicensureTypesArrayIn() 

    /**
     * Returns the value of field 'szCdRsrcCertBy'.
     * 
     * @return the value of field 'SzCdRsrcCertBy'.
     */
    public java.lang.String getSzCdRsrcCertBy()
    {
        return this._szCdRsrcCertBy;
    } //-- java.lang.String getSzCdRsrcCertBy() 

    /**
     * Returns the value of field 'szCdRsrcOperBy'.
     * 
     * @return the value of field 'SzCdRsrcOperBy'.
     */
    public java.lang.String getSzCdRsrcOperBy()
    {
        return this._szCdRsrcOperBy;
    } //-- java.lang.String getSzCdRsrcOperBy() 

    /**
     * Returns the value of field 'szCdRsrcPayment'.
     * 
     * @return the value of field 'SzCdRsrcPayment'.
     */
    public java.lang.String getSzCdRsrcPayment()
    {
        return this._szCdRsrcPayment;
    } //-- java.lang.String getSzCdRsrcPayment() 

    /**
     * Returns the value of field 'szCdRsrcSetting'.
     * 
     * @return the value of field 'SzCdRsrcSetting'.
     */
    public java.lang.String getSzCdRsrcSetting()
    {
        return this._szCdRsrcSetting;
    } //-- java.lang.String getSzCdRsrcSetting() 

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
     * Returns the value of field 'szNmRsrcLastUpdate'.
     * 
     * @return the value of field 'SzNmRsrcLastUpdate'.
     */
    public java.lang.String getSzNmRsrcLastUpdate()
    {
        return this._szNmRsrcLastUpdate;
    } //-- java.lang.String getSzNmRsrcLastUpdate() 

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
     * Returns the value of field 'txtSpecCert'.
     * 
     * @return the value of field 'TxtSpecCert'.
     */
    public java.lang.String getTxtSpecCert()
    {
        return this._txtSpecCert;
    } //-- java.lang.String getTxtSpecCert() 

    /**
     * Returns the value of field 'uNbrRsrcFacilCapacity'.
     * 
     * @return the value of field 'UNbrRsrcFacilCapacity'.
     */
    public int getUNbrRsrcFacilCapacity()
    {
        return this._uNbrRsrcFacilCapacity;
    } //-- int getUNbrRsrcFacilCapacity() 

    /**
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Returns the value of field 'ulRowQty2'.
     * 
     * @return the value of field 'UlRowQty2'.
     */
    public int getUlRowQty2()
    {
        return this._ulRowQty2;
    } //-- int getUlRowQty2() 

    /**
     * Method hasUNbrRsrcFacilCapacity
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFacilCapacity has been
     * added
     */
    public boolean hasUNbrRsrcFacilCapacity()
    {
        return this._has_uNbrRsrcFacilCapacity;
    } //-- boolean hasUNbrRsrcFacilCapacity() 

    /**
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

    /**
     * Method hasUlRowQty2
     * 
     * 
     * 
     * @return true if at least one UlRowQty2 has been added
     */
    public boolean hasUlRowQty2()
    {
        return this._has_ulRowQty2;
    } //-- boolean hasUlRowQty2() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bIndAvailableAfterHrs'.
     * 
     * @param bIndAvailableAfterHrs the value of field
     * 'bIndAvailableAfterHrs'.
     */
    public void setBIndAvailableAfterHrs(java.lang.String bIndAvailableAfterHrs)
    {
        this._bIndAvailableAfterHrs = bIndAvailableAfterHrs;
    } //-- void setBIndAvailableAfterHrs(java.lang.String) 

    /**
     * Sets the value of field 'CRES10SIG00_ARRAY'.
     * 
     * @param CRES10SIG00_ARRAY the value of field
     * 'CRES10SIG00_ARRAY'.
     */
    public void setCRES10SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00_ARRAY CRES10SIG00_ARRAY)
    {
        this._CRES10SIG00_ARRAY = CRES10SIG00_ARRAY;
    } //-- void setCRES10SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00_ARRAY) 

    /**
     * Sets the value of field 'CRES10SIG01_ARRAY'.
     * 
     * @param CRES10SIG01_ARRAY the value of field
     * 'CRES10SIG01_ARRAY'.
     */
    public void setCRES10SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01_ARRAY CRES10SIG01_ARRAY)
    {
        this._CRES10SIG01_ARRAY = CRES10SIG01_ARRAY;
    } //-- void setCRES10SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01_ARRAY) 

    /**
     * Sets the value of field 'dtDtRsrcCert'.
     * 
     * @param dtDtRsrcCert the value of field 'dtDtRsrcCert'.
     */
    public void setDtDtRsrcCert(org.exolab.castor.types.Date dtDtRsrcCert)
    {
        this._dtDtRsrcCert = dtDtRsrcCert;
    } //-- void setDtDtRsrcCert(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRsrcClose'.
     * 
     * @param dtDtRsrcClose the value of field 'dtDtRsrcClose'.
     */
    public void setDtDtRsrcClose(org.exolab.castor.types.Date dtDtRsrcClose)
    {
        this._dtDtRsrcClose = dtDtRsrcClose;
    } //-- void setDtDtRsrcClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'selectedLicensureTypesArrayIn'.
     * 
     * @param selectedLicensureTypesArrayIn the value of field
     * 'selectedLicensureTypesArrayIn'.
     */
    public void setSelectedLicensureTypesArrayIn(gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn selectedLicensureTypesArrayIn)
    {
        this._selectedLicensureTypesArrayIn = selectedLicensureTypesArrayIn;
    } //-- void setSelectedLicensureTypesArrayIn(gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn) 

    /**
     * Sets the value of field 'szCdRsrcCertBy'.
     * 
     * @param szCdRsrcCertBy the value of field 'szCdRsrcCertBy'.
     */
    public void setSzCdRsrcCertBy(java.lang.String szCdRsrcCertBy)
    {
        this._szCdRsrcCertBy = szCdRsrcCertBy;
    } //-- void setSzCdRsrcCertBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcOperBy'.
     * 
     * @param szCdRsrcOperBy the value of field 'szCdRsrcOperBy'.
     */
    public void setSzCdRsrcOperBy(java.lang.String szCdRsrcOperBy)
    {
        this._szCdRsrcOperBy = szCdRsrcOperBy;
    } //-- void setSzCdRsrcOperBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcPayment'.
     * 
     * @param szCdRsrcPayment the value of field 'szCdRsrcPayment'.
     */
    public void setSzCdRsrcPayment(java.lang.String szCdRsrcPayment)
    {
        this._szCdRsrcPayment = szCdRsrcPayment;
    } //-- void setSzCdRsrcPayment(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSetting'.
     * 
     * @param szCdRsrcSetting the value of field 'szCdRsrcSetting'.
     */
    public void setSzCdRsrcSetting(java.lang.String szCdRsrcSetting)
    {
        this._szCdRsrcSetting = szCdRsrcSetting;
    } //-- void setSzCdRsrcSetting(java.lang.String) 

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
     * Sets the value of field 'szNmRsrcLastUpdate'.
     * 
     * @param szNmRsrcLastUpdate the value of field
     * 'szNmRsrcLastUpdate'.
     */
    public void setSzNmRsrcLastUpdate(java.lang.String szNmRsrcLastUpdate)
    {
        this._szNmRsrcLastUpdate = szNmRsrcLastUpdate;
    } //-- void setSzNmRsrcLastUpdate(java.lang.String) 

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
     * Sets the value of field 'txtSpecCert'.
     * 
     * @param txtSpecCert the value of field 'txtSpecCert'.
     */
    public void setTxtSpecCert(java.lang.String txtSpecCert)
    {
        this._txtSpecCert = txtSpecCert;
    } //-- void setTxtSpecCert(java.lang.String) 

    /**
     * Sets the value of field 'uNbrRsrcFacilCapacity'.
     * 
     * @param uNbrRsrcFacilCapacity the value of field
     * 'uNbrRsrcFacilCapacity'.
     */
    public void setUNbrRsrcFacilCapacity(int uNbrRsrcFacilCapacity)
    {
        this._uNbrRsrcFacilCapacity = uNbrRsrcFacilCapacity;
        this._has_uNbrRsrcFacilCapacity = true;
    } //-- void setUNbrRsrcFacilCapacity(int) 

    /**
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

    /**
     * Sets the value of field 'ulRowQty2'.
     * 
     * @param ulRowQty2 the value of field 'ulRowQty2'.
     */
    public void setUlRowQty2(int ulRowQty2)
    {
        this._ulRowQty2 = ulRowQty2;
        this._has_ulRowQty2 = true;
    } //-- void setUlRowQty2(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI unmarshal(java.io.Reader) 

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
