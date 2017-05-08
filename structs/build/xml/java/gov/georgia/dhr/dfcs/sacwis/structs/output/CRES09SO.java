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
 * Class CRES09SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES09SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bIndAvailableAfterHrs
     */
    private java.lang.String _bIndAvailableAfterHrs;

    /**
     * Field _dtDtFlocEffect
     */
    private org.exolab.castor.types.Date _dtDtFlocEffect;

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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _uNbrRsrcFacilCapacity
     */
    private int _uNbrRsrcFacilCapacity;

    /**
     * keeps track of state for field: _uNbrRsrcFacilCapacity
     */
    private boolean _has_uNbrRsrcFacilCapacity;

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
     * Field _ROWCRES06DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY _ROWCRES06DO_ARRAY;

    /**
     * Field _ROWCRES07DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY _ROWCRES07DO_ARRAY;

    /**
     * Field _selectedLicensureTypesArray
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray _selectedLicensureTypesArray;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES09SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO()


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
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

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
     * Returns the value of field 'dtDtFlocEffect'.
     * 
     * @return the value of field 'DtDtFlocEffect'.
     */
    public org.exolab.castor.types.Date getDtDtFlocEffect()
    {
        return this._dtDtFlocEffect;
    } //-- org.exolab.castor.types.Date getDtDtFlocEffect() 

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
     * Returns the value of field 'ROWCRES06DO_ARRAY'.
     * 
     * @return the value of field 'ROWCRES06DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY getROWCRES06DO_ARRAY()
    {
        return this._ROWCRES06DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY getROWCRES06DO_ARRAY() 

    /**
     * Returns the value of field 'ROWCRES07DO_ARRAY'.
     * 
     * @return the value of field 'ROWCRES07DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY getROWCRES07DO_ARRAY()
    {
        return this._ROWCRES07DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY getROWCRES07DO_ARRAY() 

    /**
     * Returns the value of field 'selectedLicensureTypesArray'.
     * 
     * @return the value of field 'SelectedLicensureTypesArray'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray getSelectedLicensureTypesArray()
    {
        return this._selectedLicensureTypesArray;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray getSelectedLicensureTypesArray() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

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
     * Sets the value of field 'dtDtFlocEffect'.
     * 
     * @param dtDtFlocEffect the value of field 'dtDtFlocEffect'.
     */
    public void setDtDtFlocEffect(org.exolab.castor.types.Date dtDtFlocEffect)
    {
        this._dtDtFlocEffect = dtDtFlocEffect;
    } //-- void setDtDtFlocEffect(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCRES06DO_ARRAY'.
     * 
     * @param ROWCRES06DO_ARRAY the value of field
     * 'ROWCRES06DO_ARRAY'.
     */
    public void setROWCRES06DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY ROWCRES06DO_ARRAY)
    {
        this._ROWCRES06DO_ARRAY = ROWCRES06DO_ARRAY;
    } //-- void setROWCRES06DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY) 

    /**
     * Sets the value of field 'ROWCRES07DO_ARRAY'.
     * 
     * @param ROWCRES07DO_ARRAY the value of field
     * 'ROWCRES07DO_ARRAY'.
     */
    public void setROWCRES07DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY ROWCRES07DO_ARRAY)
    {
        this._ROWCRES07DO_ARRAY = ROWCRES07DO_ARRAY;
    } //-- void setROWCRES07DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY) 

    /**
     * Sets the value of field 'selectedLicensureTypesArray'.
     * 
     * @param selectedLicensureTypesArray the value of field
     * 'selectedLicensureTypesArray'.
     */
    public void setSelectedLicensureTypesArray(gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray selectedLicensureTypesArray)
    {
        this._selectedLicensureTypesArray = selectedLicensureTypesArray;
    } //-- void setSelectedLicensureTypesArray(gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO unmarshal(java.io.Reader) 

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
