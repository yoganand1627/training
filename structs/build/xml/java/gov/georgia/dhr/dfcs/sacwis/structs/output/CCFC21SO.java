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
 * Class CCFC21SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC21SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _cSysIndPrimaryWorker
     */
    private java.lang.String _cSysIndPrimaryWorker;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdCaseFileOfficeType
     */
    private java.lang.String _szCdCaseFileOfficeType;

    /**
     * Field _dtDtCaseClosed
     */
    private org.exolab.castor.types.Date _dtDtCaseClosed;

    /**
     * Field _szCdCaseProgram
     */
    private java.lang.String _szCdCaseProgram;

    /**
     * Field _szCdOfficeRegion
     */
    private java.lang.String _szCdOfficeRegion;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szAddrMailCode
     */
    private java.lang.String _szAddrMailCode;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _szNmCaseFileOffice
     */
    private java.lang.String _szNmCaseFileOffice;

    /**
     * Field _szAddrCaseFileCity
     */
    private java.lang.String _szAddrCaseFileCity;

    /**
     * Field _szAddrCaseFileStLn1
     */
    private java.lang.String _szAddrCaseFileStLn1;

    /**
     * Field _szAddrCaseFileStLn2
     */
    private java.lang.String _szAddrCaseFileStLn2;

    /**
     * Field _dtDtCaseFileArchCompl
     */
    private org.exolab.castor.types.Date _dtDtCaseFileArchCompl;

    /**
     * Field _dtDtCaseFileArchElig
     */
    private org.exolab.castor.types.Date _dtDtCaseFileArchElig;

    /**
     * Field _sztxtCaseFileLocateInfo
     */
    private java.lang.String _sztxtCaseFileLocateInfo;

    /**
     * Field _szTxtPriorCmnts
     */
    private java.lang.String _szTxtPriorCmnts;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC21SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'cSysIndPrimaryWorker'.
     * 
     * @return the value of field 'CSysIndPrimaryWorker'.
     */
    public java.lang.String getCSysIndPrimaryWorker()
    {
        return this._cSysIndPrimaryWorker;
    } //-- java.lang.String getCSysIndPrimaryWorker() 

    /**
     * Returns the value of field 'dtDtCaseClosed'.
     * 
     * @return the value of field 'DtDtCaseClosed'.
     */
    public org.exolab.castor.types.Date getDtDtCaseClosed()
    {
        return this._dtDtCaseClosed;
    } //-- org.exolab.castor.types.Date getDtDtCaseClosed() 

    /**
     * Returns the value of field 'dtDtCaseFileArchCompl'.
     * 
     * @return the value of field 'DtDtCaseFileArchCompl'.
     */
    public org.exolab.castor.types.Date getDtDtCaseFileArchCompl()
    {
        return this._dtDtCaseFileArchCompl;
    } //-- org.exolab.castor.types.Date getDtDtCaseFileArchCompl() 

    /**
     * Returns the value of field 'dtDtCaseFileArchElig'.
     * 
     * @return the value of field 'DtDtCaseFileArchElig'.
     */
    public org.exolab.castor.types.Date getDtDtCaseFileArchElig()
    {
        return this._dtDtCaseFileArchElig;
    } //-- org.exolab.castor.types.Date getDtDtCaseFileArchElig() 

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
     * Returns the value of field 'szAddrCaseFileCity'.
     * 
     * @return the value of field 'SzAddrCaseFileCity'.
     */
    public java.lang.String getSzAddrCaseFileCity()
    {
        return this._szAddrCaseFileCity;
    } //-- java.lang.String getSzAddrCaseFileCity() 

    /**
     * Returns the value of field 'szAddrCaseFileStLn1'.
     * 
     * @return the value of field 'SzAddrCaseFileStLn1'.
     */
    public java.lang.String getSzAddrCaseFileStLn1()
    {
        return this._szAddrCaseFileStLn1;
    } //-- java.lang.String getSzAddrCaseFileStLn1() 

    /**
     * Returns the value of field 'szAddrCaseFileStLn2'.
     * 
     * @return the value of field 'SzAddrCaseFileStLn2'.
     */
    public java.lang.String getSzAddrCaseFileStLn2()
    {
        return this._szAddrCaseFileStLn2;
    } //-- java.lang.String getSzAddrCaseFileStLn2() 

    /**
     * Returns the value of field 'szAddrMailCode'.
     * 
     * @return the value of field 'SzAddrMailCode'.
     */
    public java.lang.String getSzAddrMailCode()
    {
        return this._szAddrMailCode;
    } //-- java.lang.String getSzAddrMailCode() 

    /**
     * Returns the value of field 'szCdCaseFileOfficeType'.
     * 
     * @return the value of field 'SzCdCaseFileOfficeType'.
     */
    public java.lang.String getSzCdCaseFileOfficeType()
    {
        return this._szCdCaseFileOfficeType;
    } //-- java.lang.String getSzCdCaseFileOfficeType() 

    /**
     * Returns the value of field 'szCdCaseProgram'.
     * 
     * @return the value of field 'SzCdCaseProgram'.
     */
    public java.lang.String getSzCdCaseProgram()
    {
        return this._szCdCaseProgram;
    } //-- java.lang.String getSzCdCaseProgram() 

    /**
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdOfficeRegion'.
     * 
     * @return the value of field 'SzCdOfficeRegion'.
     */
    public java.lang.String getSzCdOfficeRegion()
    {
        return this._szCdOfficeRegion;
    } //-- java.lang.String getSzCdOfficeRegion() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

    /**
     * Returns the value of field 'szNmCaseFileOffice'.
     * 
     * @return the value of field 'SzNmCaseFileOffice'.
     */
    public java.lang.String getSzNmCaseFileOffice()
    {
        return this._szNmCaseFileOffice;
    } //-- java.lang.String getSzNmCaseFileOffice() 

    /**
     * Returns the value of field 'szTxtPriorCmnts'.
     * 
     * @return the value of field 'SzTxtPriorCmnts'.
     */
    public java.lang.String getSzTxtPriorCmnts()
    {
        return this._szTxtPriorCmnts;
    } //-- java.lang.String getSzTxtPriorCmnts() 

    /**
     * Returns the value of field 'sztxtCaseFileLocateInfo'.
     * 
     * @return the value of field 'SztxtCaseFileLocateInfo'.
     */
    public java.lang.String getSztxtCaseFileLocateInfo()
    {
        return this._sztxtCaseFileLocateInfo;
    } //-- java.lang.String getSztxtCaseFileLocateInfo() 

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
     * Sets the value of field 'cSysIndPrimaryWorker'.
     * 
     * @param cSysIndPrimaryWorker the value of field
     * 'cSysIndPrimaryWorker'.
     */
    public void setCSysIndPrimaryWorker(java.lang.String cSysIndPrimaryWorker)
    {
        this._cSysIndPrimaryWorker = cSysIndPrimaryWorker;
    } //-- void setCSysIndPrimaryWorker(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCaseClosed'.
     * 
     * @param dtDtCaseClosed the value of field 'dtDtCaseClosed'.
     */
    public void setDtDtCaseClosed(org.exolab.castor.types.Date dtDtCaseClosed)
    {
        this._dtDtCaseClosed = dtDtCaseClosed;
    } //-- void setDtDtCaseClosed(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCaseFileArchCompl'.
     * 
     * @param dtDtCaseFileArchCompl the value of field
     * 'dtDtCaseFileArchCompl'.
     */
    public void setDtDtCaseFileArchCompl(org.exolab.castor.types.Date dtDtCaseFileArchCompl)
    {
        this._dtDtCaseFileArchCompl = dtDtCaseFileArchCompl;
    } //-- void setDtDtCaseFileArchCompl(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCaseFileArchElig'.
     * 
     * @param dtDtCaseFileArchElig the value of field
     * 'dtDtCaseFileArchElig'.
     */
    public void setDtDtCaseFileArchElig(org.exolab.castor.types.Date dtDtCaseFileArchElig)
    {
        this._dtDtCaseFileArchElig = dtDtCaseFileArchElig;
    } //-- void setDtDtCaseFileArchElig(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szAddrCaseFileCity'.
     * 
     * @param szAddrCaseFileCity the value of field
     * 'szAddrCaseFileCity'.
     */
    public void setSzAddrCaseFileCity(java.lang.String szAddrCaseFileCity)
    {
        this._szAddrCaseFileCity = szAddrCaseFileCity;
    } //-- void setSzAddrCaseFileCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrCaseFileStLn1'.
     * 
     * @param szAddrCaseFileStLn1 the value of field
     * 'szAddrCaseFileStLn1'.
     */
    public void setSzAddrCaseFileStLn1(java.lang.String szAddrCaseFileStLn1)
    {
        this._szAddrCaseFileStLn1 = szAddrCaseFileStLn1;
    } //-- void setSzAddrCaseFileStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrCaseFileStLn2'.
     * 
     * @param szAddrCaseFileStLn2 the value of field
     * 'szAddrCaseFileStLn2'.
     */
    public void setSzAddrCaseFileStLn2(java.lang.String szAddrCaseFileStLn2)
    {
        this._szAddrCaseFileStLn2 = szAddrCaseFileStLn2;
    } //-- void setSzAddrCaseFileStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrMailCode'.
     * 
     * @param szAddrMailCode the value of field 'szAddrMailCode'.
     */
    public void setSzAddrMailCode(java.lang.String szAddrMailCode)
    {
        this._szAddrMailCode = szAddrMailCode;
    } //-- void setSzAddrMailCode(java.lang.String) 

    /**
     * Sets the value of field 'szCdCaseFileOfficeType'.
     * 
     * @param szCdCaseFileOfficeType the value of field
     * 'szCdCaseFileOfficeType'.
     */
    public void setSzCdCaseFileOfficeType(java.lang.String szCdCaseFileOfficeType)
    {
        this._szCdCaseFileOfficeType = szCdCaseFileOfficeType;
    } //-- void setSzCdCaseFileOfficeType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCaseProgram'.
     * 
     * @param szCdCaseProgram the value of field 'szCdCaseProgram'.
     */
    public void setSzCdCaseProgram(java.lang.String szCdCaseProgram)
    {
        this._szCdCaseProgram = szCdCaseProgram;
    } //-- void setSzCdCaseProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdOfficeRegion'.
     * 
     * @param szCdOfficeRegion the value of field 'szCdOfficeRegion'
     */
    public void setSzCdOfficeRegion(java.lang.String szCdOfficeRegion)
    {
        this._szCdOfficeRegion = szCdOfficeRegion;
    } //-- void setSzCdOfficeRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

    /**
     * Sets the value of field 'szNmCaseFileOffice'.
     * 
     * @param szNmCaseFileOffice the value of field
     * 'szNmCaseFileOffice'.
     */
    public void setSzNmCaseFileOffice(java.lang.String szNmCaseFileOffice)
    {
        this._szNmCaseFileOffice = szNmCaseFileOffice;
    } //-- void setSzNmCaseFileOffice(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPriorCmnts'.
     * 
     * @param szTxtPriorCmnts the value of field 'szTxtPriorCmnts'.
     */
    public void setSzTxtPriorCmnts(java.lang.String szTxtPriorCmnts)
    {
        this._szTxtPriorCmnts = szTxtPriorCmnts;
    } //-- void setSzTxtPriorCmnts(java.lang.String) 

    /**
     * Sets the value of field 'sztxtCaseFileLocateInfo'.
     * 
     * @param sztxtCaseFileLocateInfo the value of field
     * 'sztxtCaseFileLocateInfo'.
     */
    public void setSztxtCaseFileLocateInfo(java.lang.String sztxtCaseFileLocateInfo)
    {
        this._sztxtCaseFileLocateInfo = sztxtCaseFileLocateInfo;
    } //-- void setSztxtCaseFileLocateInfo(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO unmarshal(java.io.Reader) 

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
