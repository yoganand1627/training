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
 * Class CCFC22SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC22SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

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

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC22SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI()


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
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

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
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI unmarshal(java.io.Reader) 

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
