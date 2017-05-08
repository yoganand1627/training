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
 * Class ROWCCMN13DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN13DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bIndCaseSensitive
     */
    private java.lang.String _bIndCaseSensitive;

    /**
     * Field _szCdCaseCounty
     */
    private java.lang.String _szCdCaseCounty;

    /**
     * Field _szCdCaseProgram
     */
    private java.lang.String _szCdCaseProgram;

    /**
     * Field _dtDtCaseClosed
     */
    private org.exolab.castor.types.Date _dtDtCaseClosed;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szNmCase
     */
    private java.lang.String _szNmCase;

    /**
     * Field _szScrWorkerPrim
     */
    private java.lang.String _szScrWorkerPrim;

    /**
     * Field _bScrIndEmpStageAssign
     */
    private java.lang.String _bScrIndEmpStageAssign;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _cScrIndStageMerged
     */
    private java.lang.String _cScrIndStageMerged;

    /**
     * Field _cScrIndCaseUTC
     */
    private java.lang.String _cScrIndCaseUTC;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdCaseRegion
     */
    private java.lang.String _szCdCaseRegion;

    /**
     * Field _dtDtCaseOpened
     */
    private org.exolab.castor.types.Date _dtDtCaseOpened;

    /**
     * Field _dtDtCaseOpenClose
     */
    private org.exolab.castor.types.Date _dtDtCaseOpenClose;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN13DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO()


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
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     * Returns the value of field 'bIndCaseSensitive'.
     * 
     * @return the value of field 'BIndCaseSensitive'.
     */
    public java.lang.String getBIndCaseSensitive()
    {
        return this._bIndCaseSensitive;
    } //-- java.lang.String getBIndCaseSensitive() 

    /**
     * Returns the value of field 'bScrIndEmpStageAssign'.
     * 
     * @return the value of field 'BScrIndEmpStageAssign'.
     */
    public java.lang.String getBScrIndEmpStageAssign()
    {
        return this._bScrIndEmpStageAssign;
    } //-- java.lang.String getBScrIndEmpStageAssign() 

    /**
     * Returns the value of field 'cScrIndCaseUTC'.
     * 
     * @return the value of field 'CScrIndCaseUTC'.
     */
    public java.lang.String getCScrIndCaseUTC()
    {
        return this._cScrIndCaseUTC;
    } //-- java.lang.String getCScrIndCaseUTC() 

    /**
     * Returns the value of field 'cScrIndStageMerged'.
     * 
     * @return the value of field 'CScrIndStageMerged'.
     */
    public java.lang.String getCScrIndStageMerged()
    {
        return this._cScrIndStageMerged;
    } //-- java.lang.String getCScrIndStageMerged() 

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
     * Returns the value of field 'dtDtCaseOpenClose'.
     * 
     * @return the value of field 'DtDtCaseOpenClose'.
     */
    public org.exolab.castor.types.Date getDtDtCaseOpenClose()
    {
        return this._dtDtCaseOpenClose;
    } //-- org.exolab.castor.types.Date getDtDtCaseOpenClose() 

    /**
     * Returns the value of field 'dtDtCaseOpened'.
     * 
     * @return the value of field 'DtDtCaseOpened'.
     */
    public org.exolab.castor.types.Date getDtDtCaseOpened()
    {
        return this._dtDtCaseOpened;
    } //-- org.exolab.castor.types.Date getDtDtCaseOpened() 

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
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

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
     * Returns the value of field 'szScrWorkerPrim'.
     * 
     * @return the value of field 'SzScrWorkerPrim'.
     */
    public java.lang.String getSzScrWorkerPrim()
    {
        return this._szScrWorkerPrim;
    } //-- java.lang.String getSzScrWorkerPrim() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

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
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

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
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

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
     * Sets the value of field 'bIndCaseSensitive'.
     * 
     * @param bIndCaseSensitive the value of field
     * 'bIndCaseSensitive'.
     */
    public void setBIndCaseSensitive(java.lang.String bIndCaseSensitive)
    {
        this._bIndCaseSensitive = bIndCaseSensitive;
    } //-- void setBIndCaseSensitive(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndEmpStageAssign'.
     * 
     * @param bScrIndEmpStageAssign the value of field
     * 'bScrIndEmpStageAssign'.
     */
    public void setBScrIndEmpStageAssign(java.lang.String bScrIndEmpStageAssign)
    {
        this._bScrIndEmpStageAssign = bScrIndEmpStageAssign;
    } //-- void setBScrIndEmpStageAssign(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndCaseUTC'.
     * 
     * @param cScrIndCaseUTC the value of field 'cScrIndCaseUTC'.
     */
    public void setCScrIndCaseUTC(java.lang.String cScrIndCaseUTC)
    {
        this._cScrIndCaseUTC = cScrIndCaseUTC;
    } //-- void setCScrIndCaseUTC(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndStageMerged'.
     * 
     * @param cScrIndStageMerged the value of field
     * 'cScrIndStageMerged'.
     */
    public void setCScrIndStageMerged(java.lang.String cScrIndStageMerged)
    {
        this._cScrIndStageMerged = cScrIndStageMerged;
    } //-- void setCScrIndStageMerged(java.lang.String) 

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
     * Sets the value of field 'dtDtCaseOpenClose'.
     * 
     * @param dtDtCaseOpenClose the value of field
     * 'dtDtCaseOpenClose'.
     */
    public void setDtDtCaseOpenClose(org.exolab.castor.types.Date dtDtCaseOpenClose)
    {
        this._dtDtCaseOpenClose = dtDtCaseOpenClose;
    } //-- void setDtDtCaseOpenClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCaseOpened'.
     * 
     * @param dtDtCaseOpened the value of field 'dtDtCaseOpened'.
     */
    public void setDtDtCaseOpened(org.exolab.castor.types.Date dtDtCaseOpened)
    {
        this._dtDtCaseOpened = dtDtCaseOpened;
    } //-- void setDtDtCaseOpened(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

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
     * Sets the value of field 'szScrWorkerPrim'.
     * 
     * @param szScrWorkerPrim the value of field 'szScrWorkerPrim'.
     */
    public void setSzScrWorkerPrim(java.lang.String szScrWorkerPrim)
    {
        this._szScrWorkerPrim = szScrWorkerPrim;
    } //-- void setSzScrWorkerPrim(java.lang.String) 

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
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO unmarshal(java.io.Reader) 

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
