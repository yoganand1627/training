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
 * Class ROWCCFC11SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC11SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdPalServiceCategory
     */
    private java.lang.String _szCdPalServiceCategory;

    /**
     * Field _szCdPalServiceType
     */
    private java.lang.String _szCdPalServiceType;

    /**
     * Field _dtDtPalServiceDate
     */
    private org.exolab.castor.types.Date _dtDtPalServiceDate;

    /**
     * Field _ulIdPalService
     */
    private int _ulIdPalService;

    /**
     * keeps track of state for field: _ulIdPalService
     */
    private boolean _has_ulIdPalService;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _lNbrPalServiceUnits
     */
    private int _lNbrPalServiceUnits;

    /**
     * keeps track of state for field: _lNbrPalServiceUnits
     */
    private boolean _has_lNbrPalServiceUnits;

    /**
     * Field _szSdsPalServiceOther
     */
    private java.lang.String _szSdsPalServiceOther;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC11SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrPalServiceUnits()
    {
        this._has_lNbrPalServiceUnits= false;
    } //-- void deleteLNbrPalServiceUnits() 

    /**
     */
    public void deleteUlIdPalService()
    {
        this._has_ulIdPalService= false;
    } //-- void deleteUlIdPalService() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'dtDtPalServiceDate'.
     * 
     * @return the value of field 'DtDtPalServiceDate'.
     */
    public org.exolab.castor.types.Date getDtDtPalServiceDate()
    {
        return this._dtDtPalServiceDate;
    } //-- org.exolab.castor.types.Date getDtDtPalServiceDate() 

    /**
     * Returns the value of field 'lNbrPalServiceUnits'.
     * 
     * @return the value of field 'LNbrPalServiceUnits'.
     */
    public int getLNbrPalServiceUnits()
    {
        return this._lNbrPalServiceUnits;
    } //-- int getLNbrPalServiceUnits() 

    /**
     * Returns the value of field 'szCdPalServiceCategory'.
     * 
     * @return the value of field 'SzCdPalServiceCategory'.
     */
    public java.lang.String getSzCdPalServiceCategory()
    {
        return this._szCdPalServiceCategory;
    } //-- java.lang.String getSzCdPalServiceCategory() 

    /**
     * Returns the value of field 'szCdPalServiceType'.
     * 
     * @return the value of field 'SzCdPalServiceType'.
     */
    public java.lang.String getSzCdPalServiceType()
    {
        return this._szCdPalServiceType;
    } //-- java.lang.String getSzCdPalServiceType() 

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
     * Returns the value of field 'szSdsPalServiceOther'.
     * 
     * @return the value of field 'SzSdsPalServiceOther'.
     */
    public java.lang.String getSzSdsPalServiceOther()
    {
        return this._szSdsPalServiceOther;
    } //-- java.lang.String getSzSdsPalServiceOther() 

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
     * Returns the value of field 'ulIdPalService'.
     * 
     * @return the value of field 'UlIdPalService'.
     */
    public int getUlIdPalService()
    {
        return this._ulIdPalService;
    } //-- int getUlIdPalService() 

    /**
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Method hasLNbrPalServiceUnits
     * 
     * 
     * 
     * @return true if at least one LNbrPalServiceUnits has been
     * added
     */
    public boolean hasLNbrPalServiceUnits()
    {
        return this._has_lNbrPalServiceUnits;
    } //-- boolean hasLNbrPalServiceUnits() 

    /**
     * Method hasUlIdPalService
     * 
     * 
     * 
     * @return true if at least one UlIdPalService has been added
     */
    public boolean hasUlIdPalService()
    {
        return this._has_ulIdPalService;
    } //-- boolean hasUlIdPalService() 

    /**
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

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
     * Sets the value of field 'dtDtPalServiceDate'.
     * 
     * @param dtDtPalServiceDate the value of field
     * 'dtDtPalServiceDate'.
     */
    public void setDtDtPalServiceDate(org.exolab.castor.types.Date dtDtPalServiceDate)
    {
        this._dtDtPalServiceDate = dtDtPalServiceDate;
    } //-- void setDtDtPalServiceDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrPalServiceUnits'.
     * 
     * @param lNbrPalServiceUnits the value of field
     * 'lNbrPalServiceUnits'.
     */
    public void setLNbrPalServiceUnits(int lNbrPalServiceUnits)
    {
        this._lNbrPalServiceUnits = lNbrPalServiceUnits;
        this._has_lNbrPalServiceUnits = true;
    } //-- void setLNbrPalServiceUnits(int) 

    /**
     * Sets the value of field 'szCdPalServiceCategory'.
     * 
     * @param szCdPalServiceCategory the value of field
     * 'szCdPalServiceCategory'.
     */
    public void setSzCdPalServiceCategory(java.lang.String szCdPalServiceCategory)
    {
        this._szCdPalServiceCategory = szCdPalServiceCategory;
    } //-- void setSzCdPalServiceCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalServiceType'.
     * 
     * @param szCdPalServiceType the value of field
     * 'szCdPalServiceType'.
     */
    public void setSzCdPalServiceType(java.lang.String szCdPalServiceType)
    {
        this._szCdPalServiceType = szCdPalServiceType;
    } //-- void setSzCdPalServiceType(java.lang.String) 

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
     * Sets the value of field 'szSdsPalServiceOther'.
     * 
     * @param szSdsPalServiceOther the value of field
     * 'szSdsPalServiceOther'.
     */
    public void setSzSdsPalServiceOther(java.lang.String szSdsPalServiceOther)
    {
        this._szSdsPalServiceOther = szSdsPalServiceOther;
    } //-- void setSzSdsPalServiceOther(java.lang.String) 

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
     * Sets the value of field 'ulIdPalService'.
     * 
     * @param ulIdPalService the value of field 'ulIdPalService'.
     */
    public void setUlIdPalService(int ulIdPalService)
    {
        this._ulIdPalService = ulIdPalService;
        this._has_ulIdPalService = true;
    } //-- void setUlIdPalService(int) 

    /**
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00 unmarshal(java.io.Reader) 

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
