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
 * Class CCMN20SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN20SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _codeCounty_ARRAY_CCMN20SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI _codeCounty_ARRAY_CCMN20SI;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdPerson_ARRAY_CCMN20SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI _ulIdPerson_ARRAY_CCMN20SI;

    /**
     * Field _szNmCase
     */
    private java.lang.String _szNmCase;

    /**
     * Field _szCdCaseCounty
     */
    private java.lang.String _szCdCaseCounty;

    /**
     * Field _szCdCaseProgram
     */
    private java.lang.String _szCdCaseProgram;

    /**
     * Field _szCdCaseRegion
     */
    private java.lang.String _szCdCaseRegion;

    /**
     * Field _szAddrMailCodeCity
     */
    private java.lang.String _szAddrMailCodeCity;

    /**
     * Field _bWcdCdSortBy
     */
    private java.lang.String _bWcdCdSortBy;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _ulIdCaseManager
     */
    private int _ulIdCaseManager;

    /**
     * keeps track of state for field: _ulIdCaseManager
     */
    private boolean _has_ulIdCaseManager;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _dtDtLastUpdate
     */
    private org.exolab.castor.types.Date _dtDtLastUpdate;

    /**
     * Field _selRbOpenClose
     */
    private java.lang.String _selRbOpenClose;

    /**
     * Field _szNmCaseManager
     */
    private java.lang.String _szNmCaseManager;

    /**
     * Field _szCdCpsInvstDtlOvrllDisptn
     */
    private java.lang.String _szCdCpsInvstDtlOvrllDisptn;

    /**
     * Field _szSortDir
     */
    private java.lang.String _szSortDir;

    /**
     * Field _indUseStageCode
     */
    private java.lang.String _indUseStageCode;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN20SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI()


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
    public void deleteUlIdCaseManager()
    {
        this._has_ulIdCaseManager= false;
    } //-- void deleteUlIdCaseManager() 

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
     * Returns the value of field 'bWcdCdSortBy'.
     * 
     * @return the value of field 'BWcdCdSortBy'.
     */
    public java.lang.String getBWcdCdSortBy()
    {
        return this._bWcdCdSortBy;
    } //-- java.lang.String getBWcdCdSortBy() 

    /**
     * Returns the value of field 'codeCounty_ARRAY_CCMN20SI'.
     * 
     * @return the value of field 'CodeCounty_ARRAY_CCMN20SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI getCodeCounty_ARRAY_CCMN20SI()
    {
        return this._codeCounty_ARRAY_CCMN20SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI getCodeCounty_ARRAY_CCMN20SI() 

    /**
     * Returns the value of field 'dtDtLastUpdate'.
     * 
     * @return the value of field 'DtDtLastUpdate'.
     */
    public org.exolab.castor.types.Date getDtDtLastUpdate()
    {
        return this._dtDtLastUpdate;
    } //-- org.exolab.castor.types.Date getDtDtLastUpdate() 

    /**
     * Returns the value of field 'indUseStageCode'.
     * 
     * @return the value of field 'IndUseStageCode'.
     */
    public java.lang.String getIndUseStageCode()
    {
        return this._indUseStageCode;
    } //-- java.lang.String getIndUseStageCode() 

    /**
     * Returns the value of field 'selRbOpenClose'.
     * 
     * @return the value of field 'SelRbOpenClose'.
     */
    public java.lang.String getSelRbOpenClose()
    {
        return this._selRbOpenClose;
    } //-- java.lang.String getSelRbOpenClose() 

    /**
     * Returns the value of field 'szAddrMailCodeCity'.
     * 
     * @return the value of field 'SzAddrMailCodeCity'.
     */
    public java.lang.String getSzAddrMailCodeCity()
    {
        return this._szAddrMailCodeCity;
    } //-- java.lang.String getSzAddrMailCodeCity() 

    /**
     * Returns the value of field 'szCdCaseCounty'.
     * 
     * @return the value of field 'SzCdCaseCounty'.
     */
    public java.lang.String getSzCdCaseCounty()
    {
        return this._szCdCaseCounty;
    } //-- java.lang.String getSzCdCaseCounty() 

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
     * Returns the value of field 'szCdCaseRegion'.
     * 
     * @return the value of field 'SzCdCaseRegion'.
     */
    public java.lang.String getSzCdCaseRegion()
    {
        return this._szCdCaseRegion;
    } //-- java.lang.String getSzCdCaseRegion() 

    /**
     * Returns the value of field 'szCdCpsInvstDtlOvrllDisptn'.
     * 
     * @return the value of field 'SzCdCpsInvstDtlOvrllDisptn'.
     */
    public java.lang.String getSzCdCpsInvstDtlOvrllDisptn()
    {
        return this._szCdCpsInvstDtlOvrllDisptn;
    } //-- java.lang.String getSzCdCpsInvstDtlOvrllDisptn() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

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
     * Returns the value of field 'szNmCase'.
     * 
     * @return the value of field 'SzNmCase'.
     */
    public java.lang.String getSzNmCase()
    {
        return this._szNmCase;
    } //-- java.lang.String getSzNmCase() 

    /**
     * Returns the value of field 'szNmCaseManager'.
     * 
     * @return the value of field 'SzNmCaseManager'.
     */
    public java.lang.String getSzNmCaseManager()
    {
        return this._szNmCaseManager;
    } //-- java.lang.String getSzNmCaseManager() 

    /**
     * Returns the value of field 'szSortDir'.
     * 
     * @return the value of field 'SzSortDir'.
     */
    public java.lang.String getSzSortDir()
    {
        return this._szSortDir;
    } //-- java.lang.String getSzSortDir() 

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
     * Returns the value of field 'ulIdCaseManager'.
     * 
     * @return the value of field 'UlIdCaseManager'.
     */
    public int getUlIdCaseManager()
    {
        return this._ulIdCaseManager;
    } //-- int getUlIdCaseManager() 

    /**
     * Returns the value of field 'ulIdPerson_ARRAY_CCMN20SI'.
     * 
     * @return the value of field 'UlIdPerson_ARRAY_CCMN20SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI getUlIdPerson_ARRAY_CCMN20SI()
    {
        return this._ulIdPerson_ARRAY_CCMN20SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI getUlIdPerson_ARRAY_CCMN20SI() 

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
     * Method hasUlIdCaseManager
     * 
     * 
     * 
     * @return true if at least one UlIdCaseManager has been added
     */
    public boolean hasUlIdCaseManager()
    {
        return this._has_ulIdCaseManager;
    } //-- boolean hasUlIdCaseManager() 

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
     * Sets the value of field 'bWcdCdSortBy'.
     * 
     * @param bWcdCdSortBy the value of field 'bWcdCdSortBy'.
     */
    public void setBWcdCdSortBy(java.lang.String bWcdCdSortBy)
    {
        this._bWcdCdSortBy = bWcdCdSortBy;
    } //-- void setBWcdCdSortBy(java.lang.String) 

    /**
     * Sets the value of field 'codeCounty_ARRAY_CCMN20SI'.
     * 
     * @param codeCounty_ARRAY_CCMN20SI the value of field
     * 'codeCounty_ARRAY_CCMN20SI'.
     */
    public void setCodeCounty_ARRAY_CCMN20SI(gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI codeCounty_ARRAY_CCMN20SI)
    {
        this._codeCounty_ARRAY_CCMN20SI = codeCounty_ARRAY_CCMN20SI;
    } //-- void setCodeCounty_ARRAY_CCMN20SI(gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI) 

    /**
     * Sets the value of field 'dtDtLastUpdate'.
     * 
     * @param dtDtLastUpdate the value of field 'dtDtLastUpdate'.
     */
    public void setDtDtLastUpdate(org.exolab.castor.types.Date dtDtLastUpdate)
    {
        this._dtDtLastUpdate = dtDtLastUpdate;
    } //-- void setDtDtLastUpdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indUseStageCode'.
     * 
     * @param indUseStageCode the value of field 'indUseStageCode'.
     */
    public void setIndUseStageCode(java.lang.String indUseStageCode)
    {
        this._indUseStageCode = indUseStageCode;
    } //-- void setIndUseStageCode(java.lang.String) 

    /**
     * Sets the value of field 'selRbOpenClose'.
     * 
     * @param selRbOpenClose the value of field 'selRbOpenClose'.
     */
    public void setSelRbOpenClose(java.lang.String selRbOpenClose)
    {
        this._selRbOpenClose = selRbOpenClose;
    } //-- void setSelRbOpenClose(java.lang.String) 

    /**
     * Sets the value of field 'szAddrMailCodeCity'.
     * 
     * @param szAddrMailCodeCity the value of field
     * 'szAddrMailCodeCity'.
     */
    public void setSzAddrMailCodeCity(java.lang.String szAddrMailCodeCity)
    {
        this._szAddrMailCodeCity = szAddrMailCodeCity;
    } //-- void setSzAddrMailCodeCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdCaseCounty'.
     * 
     * @param szCdCaseCounty the value of field 'szCdCaseCounty'.
     */
    public void setSzCdCaseCounty(java.lang.String szCdCaseCounty)
    {
        this._szCdCaseCounty = szCdCaseCounty;
    } //-- void setSzCdCaseCounty(java.lang.String) 

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
     * Sets the value of field 'szCdCaseRegion'.
     * 
     * @param szCdCaseRegion the value of field 'szCdCaseRegion'.
     */
    public void setSzCdCaseRegion(java.lang.String szCdCaseRegion)
    {
        this._szCdCaseRegion = szCdCaseRegion;
    } //-- void setSzCdCaseRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdCpsInvstDtlOvrllDisptn'.
     * 
     * @param szCdCpsInvstDtlOvrllDisptn the value of field
     * 'szCdCpsInvstDtlOvrllDisptn'.
     */
    public void setSzCdCpsInvstDtlOvrllDisptn(java.lang.String szCdCpsInvstDtlOvrllDisptn)
    {
        this._szCdCpsInvstDtlOvrllDisptn = szCdCpsInvstDtlOvrllDisptn;
    } //-- void setSzCdCpsInvstDtlOvrllDisptn(java.lang.String) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

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
     * Sets the value of field 'szNmCase'.
     * 
     * @param szNmCase the value of field 'szNmCase'.
     */
    public void setSzNmCase(java.lang.String szNmCase)
    {
        this._szNmCase = szNmCase;
    } //-- void setSzNmCase(java.lang.String) 

    /**
     * Sets the value of field 'szNmCaseManager'.
     * 
     * @param szNmCaseManager the value of field 'szNmCaseManager'.
     */
    public void setSzNmCaseManager(java.lang.String szNmCaseManager)
    {
        this._szNmCaseManager = szNmCaseManager;
    } //-- void setSzNmCaseManager(java.lang.String) 

    /**
     * Sets the value of field 'szSortDir'.
     * 
     * @param szSortDir the value of field 'szSortDir'.
     */
    public void setSzSortDir(java.lang.String szSortDir)
    {
        this._szSortDir = szSortDir;
    } //-- void setSzSortDir(java.lang.String) 

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
     * Sets the value of field 'ulIdCaseManager'.
     * 
     * @param ulIdCaseManager the value of field 'ulIdCaseManager'.
     */
    public void setUlIdCaseManager(int ulIdCaseManager)
    {
        this._ulIdCaseManager = ulIdCaseManager;
        this._has_ulIdCaseManager = true;
    } //-- void setUlIdCaseManager(int) 

    /**
     * Sets the value of field 'ulIdPerson_ARRAY_CCMN20SI'.
     * 
     * @param ulIdPerson_ARRAY_CCMN20SI the value of field
     * 'ulIdPerson_ARRAY_CCMN20SI'.
     */
    public void setUlIdPerson_ARRAY_CCMN20SI(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI ulIdPerson_ARRAY_CCMN20SI)
    {
        this._ulIdPerson_ARRAY_CCMN20SI = ulIdPerson_ARRAY_CCMN20SI;
    } //-- void setUlIdPerson_ARRAY_CCMN20SI(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI unmarshal(java.io.Reader) 

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
