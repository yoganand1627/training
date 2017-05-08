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
 * Class CFAD30SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD30SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _tsLastUpdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY _tsLastUpdate_ARRAY;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _szCdRsrcClosureRsn
     */
    private java.lang.String _szCdRsrcClosureRsn;

    /**
     * Field _szCdRsrcFaHomeStatus
     */
    private java.lang.String _szCdRsrcFaHomeStatus;

    /**
     * Field _szCdRsrcInvolClosure
     */
    private java.lang.String _szCdRsrcInvolClosure;

    /**
     * Field _szCdRsrcFacilType
     */
    private java.lang.String _szCdRsrcFacilType;

    /**
     * Field _szCdRsrcRecmndReopen
     */
    private java.lang.String _szCdRsrcRecmndReopen;

    /**
     * Field _szCdRsrcStatus
     */
    private java.lang.String _szCdRsrcStatus;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _bIndBLOBExistsInDatabase
     */
    private java.lang.String _bIndBLOBExistsInDatabase;

    /**
     * Field _bIndRsrcNonPrs
     */
    private java.lang.String _bIndRsrcNonPrs;

    /**
     * Field _szTxtStatusRsnComments
     */
    private java.lang.String _szTxtStatusRsnComments;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD30SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO()


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
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

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
     * Returns the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase'.
     */
    public java.lang.String getBIndBLOBExistsInDatabase()
    {
        return this._bIndBLOBExistsInDatabase;
    } //-- java.lang.String getBIndBLOBExistsInDatabase() 

    /**
     * Returns the value of field 'bIndRsrcNonPrs'.
     * 
     * @return the value of field 'BIndRsrcNonPrs'.
     */
    public java.lang.String getBIndRsrcNonPrs()
    {
        return this._bIndRsrcNonPrs;
    } //-- java.lang.String getBIndRsrcNonPrs() 

    /**
     * Returns the value of field 'bSysIndGeneric'.
     * 
     * @return the value of field 'BSysIndGeneric'.
     */
    public java.lang.String getBSysIndGeneric()
    {
        return this._bSysIndGeneric;
    } //-- java.lang.String getBSysIndGeneric() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'szCdRsrcClosureRsn'.
     * 
     * @return the value of field 'SzCdRsrcClosureRsn'.
     */
    public java.lang.String getSzCdRsrcClosureRsn()
    {
        return this._szCdRsrcClosureRsn;
    } //-- java.lang.String getSzCdRsrcClosureRsn() 

    /**
     * Returns the value of field 'szCdRsrcFaHomeStatus'.
     * 
     * @return the value of field 'SzCdRsrcFaHomeStatus'.
     */
    public java.lang.String getSzCdRsrcFaHomeStatus()
    {
        return this._szCdRsrcFaHomeStatus;
    } //-- java.lang.String getSzCdRsrcFaHomeStatus() 

    /**
     * Returns the value of field 'szCdRsrcFacilType'.
     * 
     * @return the value of field 'SzCdRsrcFacilType'.
     */
    public java.lang.String getSzCdRsrcFacilType()
    {
        return this._szCdRsrcFacilType;
    } //-- java.lang.String getSzCdRsrcFacilType() 

    /**
     * Returns the value of field 'szCdRsrcInvolClosure'.
     * 
     * @return the value of field 'SzCdRsrcInvolClosure'.
     */
    public java.lang.String getSzCdRsrcInvolClosure()
    {
        return this._szCdRsrcInvolClosure;
    } //-- java.lang.String getSzCdRsrcInvolClosure() 

    /**
     * Returns the value of field 'szCdRsrcRecmndReopen'.
     * 
     * @return the value of field 'SzCdRsrcRecmndReopen'.
     */
    public java.lang.String getSzCdRsrcRecmndReopen()
    {
        return this._szCdRsrcRecmndReopen;
    } //-- java.lang.String getSzCdRsrcRecmndReopen() 

    /**
     * Returns the value of field 'szCdRsrcStatus'.
     * 
     * @return the value of field 'SzCdRsrcStatus'.
     */
    public java.lang.String getSzCdRsrcStatus()
    {
        return this._szCdRsrcStatus;
    } //-- java.lang.String getSzCdRsrcStatus() 

    /**
     * Returns the value of field 'szTxtStatusRsnComments'.
     * 
     * @return the value of field 'SzTxtStatusRsnComments'.
     */
    public java.lang.String getSzTxtStatusRsnComments()
    {
        return this._szTxtStatusRsnComments;
    } //-- java.lang.String getSzTxtStatusRsnComments() 

    /**
     * Returns the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY()
    {
        return this._tsLastUpdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdSituation'.
     * 
     * @return the value of field 'UlIdSituation'.
     */
    public int getUlIdSituation()
    {
        return this._ulIdSituation;
    } //-- int getUlIdSituation() 

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
     * Method hasUlIdSituation
     * 
     * 
     * 
     * @return true if at least one UlIdSituation has been added
     */
    public boolean hasUlIdSituation()
    {
        return this._has_ulIdSituation;
    } //-- boolean hasUlIdSituation() 

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
     * Sets the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @param bIndBLOBExistsInDatabase the value of field
     * 'bIndBLOBExistsInDatabase'.
     */
    public void setBIndBLOBExistsInDatabase(java.lang.String bIndBLOBExistsInDatabase)
    {
        this._bIndBLOBExistsInDatabase = bIndBLOBExistsInDatabase;
    } //-- void setBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * Sets the value of field 'bIndRsrcNonPrs'.
     * 
     * @param bIndRsrcNonPrs the value of field 'bIndRsrcNonPrs'.
     */
    public void setBIndRsrcNonPrs(java.lang.String bIndRsrcNonPrs)
    {
        this._bIndRsrcNonPrs = bIndRsrcNonPrs;
    } //-- void setBIndRsrcNonPrs(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndGeneric'.
     * 
     * @param bSysIndGeneric the value of field 'bSysIndGeneric'.
     */
    public void setBSysIndGeneric(java.lang.String bSysIndGeneric)
    {
        this._bSysIndGeneric = bSysIndGeneric;
    } //-- void setBSysIndGeneric(java.lang.String) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'szCdRsrcClosureRsn'.
     * 
     * @param szCdRsrcClosureRsn the value of field
     * 'szCdRsrcClosureRsn'.
     */
    public void setSzCdRsrcClosureRsn(java.lang.String szCdRsrcClosureRsn)
    {
        this._szCdRsrcClosureRsn = szCdRsrcClosureRsn;
    } //-- void setSzCdRsrcClosureRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFaHomeStatus'.
     * 
     * @param szCdRsrcFaHomeStatus the value of field
     * 'szCdRsrcFaHomeStatus'.
     */
    public void setSzCdRsrcFaHomeStatus(java.lang.String szCdRsrcFaHomeStatus)
    {
        this._szCdRsrcFaHomeStatus = szCdRsrcFaHomeStatus;
    } //-- void setSzCdRsrcFaHomeStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFacilType'.
     * 
     * @param szCdRsrcFacilType the value of field
     * 'szCdRsrcFacilType'.
     */
    public void setSzCdRsrcFacilType(java.lang.String szCdRsrcFacilType)
    {
        this._szCdRsrcFacilType = szCdRsrcFacilType;
    } //-- void setSzCdRsrcFacilType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcInvolClosure'.
     * 
     * @param szCdRsrcInvolClosure the value of field
     * 'szCdRsrcInvolClosure'.
     */
    public void setSzCdRsrcInvolClosure(java.lang.String szCdRsrcInvolClosure)
    {
        this._szCdRsrcInvolClosure = szCdRsrcInvolClosure;
    } //-- void setSzCdRsrcInvolClosure(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcRecmndReopen'.
     * 
     * @param szCdRsrcRecmndReopen the value of field
     * 'szCdRsrcRecmndReopen'.
     */
    public void setSzCdRsrcRecmndReopen(java.lang.String szCdRsrcRecmndReopen)
    {
        this._szCdRsrcRecmndReopen = szCdRsrcRecmndReopen;
    } //-- void setSzCdRsrcRecmndReopen(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcStatus'.
     * 
     * @param szCdRsrcStatus the value of field 'szCdRsrcStatus'.
     */
    public void setSzCdRsrcStatus(java.lang.String szCdRsrcStatus)
    {
        this._szCdRsrcStatus = szCdRsrcStatus;
    } //-- void setSzCdRsrcStatus(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStatusRsnComments'.
     * 
     * @param szTxtStatusRsnComments the value of field
     * 'szTxtStatusRsnComments'.
     */
    public void setSzTxtStatusRsnComments(java.lang.String szTxtStatusRsnComments)
    {
        this._szTxtStatusRsnComments = szTxtStatusRsnComments;
    } //-- void setSzTxtStatusRsnComments(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @param tsLastUpdate_ARRAY the value of field
     * 'tsLastUpdate_ARRAY'.
     */
    public void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY tsLastUpdate_ARRAY)
    {
        this._tsLastUpdate_ARRAY = tsLastUpdate_ARRAY;
    } //-- void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY) 

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
     * Sets the value of field 'ulIdSituation'.
     * 
     * @param ulIdSituation the value of field 'ulIdSituation'.
     */
    public void setUlIdSituation(int ulIdSituation)
    {
        this._ulIdSituation = ulIdSituation;
        this._has_ulIdSituation = true;
    } //-- void setUlIdSituation(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO unmarshal(java.io.Reader) 

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
