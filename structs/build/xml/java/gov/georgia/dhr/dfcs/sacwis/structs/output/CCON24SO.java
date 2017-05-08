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
 * Class CCON24SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON24SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdPersonLivArr
     */
    private java.lang.String _szCdPersonLivArr;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _dtSysDtGenericSysdate
     */
    private org.exolab.castor.types.Date _dtSysDtGenericSysdate;

    /**
     * Field _szCdSvcAuthAbilToRespond
     */
    private java.lang.String _szCdSvcAuthAbilToRespond;

    /**
     * Field _dtDtSvcAuthVerbalReferl
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthVerbalReferl;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szTxtDirectToHome
     */
    private java.lang.String _szTxtDirectToHome;

    /**
     * Field _szTxtHomeEnviron
     */
    private java.lang.String _szTxtHomeEnviron;

    /**
     * Field _szTxtMedicalConditions
     */
    private java.lang.String _szTxtMedicalConditions;

    /**
     * Field _lAmtEstValue
     */
    private double _lAmtEstValue;

    /**
     * keeps track of state for field: _lAmtEstValue
     */
    private boolean _has_lAmtEstValue;

    /**
     * Field _ROWCCON24SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG00_ARRAY _ROWCCON24SOG00_ARRAY;

    /**
     * Field _ROWCCON24SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG01_ARRAY _ROWCCON24SOG01_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON24SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLAmtEstValue()
    {
        this._has_lAmtEstValue= false;
    } //-- void deleteLAmtEstValue() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'dtDtSvcAuthVerbalReferl'.
     * 
     * @return the value of field 'DtDtSvcAuthVerbalReferl'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthVerbalReferl()
    {
        return this._dtDtSvcAuthVerbalReferl;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthVerbalReferl() 

    /**
     * Returns the value of field 'dtSysDtGenericSysdate'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate'.
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdate;
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate() 

    /**
     * Returns the value of field 'lAmtEstValue'.
     * 
     * @return the value of field 'LAmtEstValue'.
     */
    public double getLAmtEstValue()
    {
        return this._lAmtEstValue;
    } //-- double getLAmtEstValue() 

    /**
     * Returns the value of field 'ROWCCON24SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCON24SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG00_ARRAY getROWCCON24SOG00_ARRAY()
    {
        return this._ROWCCON24SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG00_ARRAY getROWCCON24SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCCON24SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCCON24SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG01_ARRAY getROWCCON24SOG01_ARRAY()
    {
        return this._ROWCCON24SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG01_ARRAY getROWCCON24SOG01_ARRAY() 

    /**
     * Returns the value of field 'szCdPersonLivArr'.
     * 
     * @return the value of field 'SzCdPersonLivArr'.
     */
    public java.lang.String getSzCdPersonLivArr()
    {
        return this._szCdPersonLivArr;
    } //-- java.lang.String getSzCdPersonLivArr() 

    /**
     * Returns the value of field 'szCdSvcAuthAbilToRespond'.
     * 
     * @return the value of field 'SzCdSvcAuthAbilToRespond'.
     */
    public java.lang.String getSzCdSvcAuthAbilToRespond()
    {
        return this._szCdSvcAuthAbilToRespond;
    } //-- java.lang.String getSzCdSvcAuthAbilToRespond() 

    /**
     * Returns the value of field 'szTxtDirectToHome'.
     * 
     * @return the value of field 'SzTxtDirectToHome'.
     */
    public java.lang.String getSzTxtDirectToHome()
    {
        return this._szTxtDirectToHome;
    } //-- java.lang.String getSzTxtDirectToHome() 

    /**
     * Returns the value of field 'szTxtHomeEnviron'.
     * 
     * @return the value of field 'SzTxtHomeEnviron'.
     */
    public java.lang.String getSzTxtHomeEnviron()
    {
        return this._szTxtHomeEnviron;
    } //-- java.lang.String getSzTxtHomeEnviron() 

    /**
     * Returns the value of field 'szTxtMedicalConditions'.
     * 
     * @return the value of field 'SzTxtMedicalConditions'.
     */
    public java.lang.String getSzTxtMedicalConditions()
    {
        return this._szTxtMedicalConditions;
    } //-- java.lang.String getSzTxtMedicalConditions() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasLAmtEstValue
     * 
     * 
     * 
     * @return true if at least one LAmtEstValue has been added
     */
    public boolean hasLAmtEstValue()
    {
        return this._has_lAmtEstValue;
    } //-- boolean hasLAmtEstValue() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'dtDtSvcAuthVerbalReferl'.
     * 
     * @param dtDtSvcAuthVerbalReferl the value of field
     * 'dtDtSvcAuthVerbalReferl'.
     */
    public void setDtDtSvcAuthVerbalReferl(org.exolab.castor.types.Date dtDtSvcAuthVerbalReferl)
    {
        this._dtDtSvcAuthVerbalReferl = dtDtSvcAuthVerbalReferl;
    } //-- void setDtDtSvcAuthVerbalReferl(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtSysDtGenericSysdate'.
     * 
     * @param dtSysDtGenericSysdate the value of field
     * 'dtSysDtGenericSysdate'.
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date dtSysDtGenericSysdate)
    {
        this._dtSysDtGenericSysdate = dtSysDtGenericSysdate;
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lAmtEstValue'.
     * 
     * @param lAmtEstValue the value of field 'lAmtEstValue'.
     */
    public void setLAmtEstValue(double lAmtEstValue)
    {
        this._lAmtEstValue = lAmtEstValue;
        this._has_lAmtEstValue = true;
    } //-- void setLAmtEstValue(double) 

    /**
     * Sets the value of field 'ROWCCON24SOG00_ARRAY'.
     * 
     * @param ROWCCON24SOG00_ARRAY the value of field
     * 'ROWCCON24SOG00_ARRAY'.
     */
    public void setROWCCON24SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG00_ARRAY ROWCCON24SOG00_ARRAY)
    {
        this._ROWCCON24SOG00_ARRAY = ROWCCON24SOG00_ARRAY;
    } //-- void setROWCCON24SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCCON24SOG01_ARRAY'.
     * 
     * @param ROWCCON24SOG01_ARRAY the value of field
     * 'ROWCCON24SOG01_ARRAY'.
     */
    public void setROWCCON24SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG01_ARRAY ROWCCON24SOG01_ARRAY)
    {
        this._ROWCCON24SOG01_ARRAY = ROWCCON24SOG01_ARRAY;
    } //-- void setROWCCON24SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON24SOG01_ARRAY) 

    /**
     * Sets the value of field 'szCdPersonLivArr'.
     * 
     * @param szCdPersonLivArr the value of field 'szCdPersonLivArr'
     */
    public void setSzCdPersonLivArr(java.lang.String szCdPersonLivArr)
    {
        this._szCdPersonLivArr = szCdPersonLivArr;
    } //-- void setSzCdPersonLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthAbilToRespond'.
     * 
     * @param szCdSvcAuthAbilToRespond the value of field
     * 'szCdSvcAuthAbilToRespond'.
     */
    public void setSzCdSvcAuthAbilToRespond(java.lang.String szCdSvcAuthAbilToRespond)
    {
        this._szCdSvcAuthAbilToRespond = szCdSvcAuthAbilToRespond;
    } //-- void setSzCdSvcAuthAbilToRespond(java.lang.String) 

    /**
     * Sets the value of field 'szTxtDirectToHome'.
     * 
     * @param szTxtDirectToHome the value of field
     * 'szTxtDirectToHome'.
     */
    public void setSzTxtDirectToHome(java.lang.String szTxtDirectToHome)
    {
        this._szTxtDirectToHome = szTxtDirectToHome;
    } //-- void setSzTxtDirectToHome(java.lang.String) 

    /**
     * Sets the value of field 'szTxtHomeEnviron'.
     * 
     * @param szTxtHomeEnviron the value of field 'szTxtHomeEnviron'
     */
    public void setSzTxtHomeEnviron(java.lang.String szTxtHomeEnviron)
    {
        this._szTxtHomeEnviron = szTxtHomeEnviron;
    } //-- void setSzTxtHomeEnviron(java.lang.String) 

    /**
     * Sets the value of field 'szTxtMedicalConditions'.
     * 
     * @param szTxtMedicalConditions the value of field
     * 'szTxtMedicalConditions'.
     */
    public void setSzTxtMedicalConditions(java.lang.String szTxtMedicalConditions)
    {
        this._szTxtMedicalConditions = szTxtMedicalConditions;
    } //-- void setSzTxtMedicalConditions(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO unmarshal(java.io.Reader) 

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
