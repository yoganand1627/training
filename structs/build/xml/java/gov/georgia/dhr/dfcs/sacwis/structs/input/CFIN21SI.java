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
 * Class CFIN21SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN21SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulScrFinPayhistId
     */
    private int _ulScrFinPayhistId;

    /**
     * keeps track of state for field: _ulScrFinPayhistId
     */
    private boolean _has_ulScrFinPayhistId;

    /**
     * Field _szScrFinPayhistSearch
     */
    private java.lang.String _szScrFinPayhistSearch;

    /**
     * Field _dtScrNbrFinPayhistFrom
     */
    private org.exolab.castor.types.Date _dtScrNbrFinPayhistFrom;

    /**
     * Field _dtScrDtFinPayhistTo
     */
    private org.exolab.castor.types.Date _dtScrDtFinPayhistTo;

    /**
     * Field _dAmtInvoValidAmount
     */
    private double _dAmtInvoValidAmount;

    /**
     * keeps track of state for field: _dAmtInvoValidAmount
     */
    private boolean _has_dAmtInvoValidAmount;

    /**
     * Field _szCdRegion
     */
    private java.lang.String _szCdRegion;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN21SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtInvoValidAmount()
    {
        this._has_dAmtInvoValidAmount= false;
    } //-- void deleteDAmtInvoValidAmount() 

    /**
     */
    public void deleteUlScrFinPayhistId()
    {
        this._has_ulScrFinPayhistId= false;
    } //-- void deleteUlScrFinPayhistId() 

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
     * Returns the value of field 'dAmtInvoValidAmount'.
     * 
     * @return the value of field 'DAmtInvoValidAmount'.
     */
    public double getDAmtInvoValidAmount()
    {
        return this._dAmtInvoValidAmount;
    } //-- double getDAmtInvoValidAmount() 

    /**
     * Returns the value of field 'dtScrDtFinPayhistTo'.
     * 
     * @return the value of field 'DtScrDtFinPayhistTo'.
     */
    public org.exolab.castor.types.Date getDtScrDtFinPayhistTo()
    {
        return this._dtScrDtFinPayhistTo;
    } //-- org.exolab.castor.types.Date getDtScrDtFinPayhistTo() 

    /**
     * Returns the value of field 'dtScrNbrFinPayhistFrom'.
     * 
     * @return the value of field 'DtScrNbrFinPayhistFrom'.
     */
    public org.exolab.castor.types.Date getDtScrNbrFinPayhistFrom()
    {
        return this._dtScrNbrFinPayhistFrom;
    } //-- org.exolab.castor.types.Date getDtScrNbrFinPayhistFrom() 

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
     * Returns the value of field 'szCdRegion'.
     * 
     * @return the value of field 'SzCdRegion'.
     */
    public java.lang.String getSzCdRegion()
    {
        return this._szCdRegion;
    } //-- java.lang.String getSzCdRegion() 

    /**
     * Returns the value of field 'szScrFinPayhistSearch'.
     * 
     * @return the value of field 'SzScrFinPayhistSearch'.
     */
    public java.lang.String getSzScrFinPayhistSearch()
    {
        return this._szScrFinPayhistSearch;
    } //-- java.lang.String getSzScrFinPayhistSearch() 

    /**
     * Returns the value of field 'ulScrFinPayhistId'.
     * 
     * @return the value of field 'UlScrFinPayhistId'.
     */
    public int getUlScrFinPayhistId()
    {
        return this._ulScrFinPayhistId;
    } //-- int getUlScrFinPayhistId() 

    /**
     * Method hasDAmtInvoValidAmount
     * 
     * 
     * 
     * @return true if at least one DAmtInvoValidAmount has been
     * added
     */
    public boolean hasDAmtInvoValidAmount()
    {
        return this._has_dAmtInvoValidAmount;
    } //-- boolean hasDAmtInvoValidAmount() 

    /**
     * Method hasUlScrFinPayhistId
     * 
     * 
     * 
     * @return true if at least one UlScrFinPayhistId has been added
     */
    public boolean hasUlScrFinPayhistId()
    {
        return this._has_ulScrFinPayhistId;
    } //-- boolean hasUlScrFinPayhistId() 

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
     * Sets the value of field 'dAmtInvoValidAmount'.
     * 
     * @param dAmtInvoValidAmount the value of field
     * 'dAmtInvoValidAmount'.
     */
    public void setDAmtInvoValidAmount(double dAmtInvoValidAmount)
    {
        this._dAmtInvoValidAmount = dAmtInvoValidAmount;
        this._has_dAmtInvoValidAmount = true;
    } //-- void setDAmtInvoValidAmount(double) 

    /**
     * Sets the value of field 'dtScrDtFinPayhistTo'.
     * 
     * @param dtScrDtFinPayhistTo the value of field
     * 'dtScrDtFinPayhistTo'.
     */
    public void setDtScrDtFinPayhistTo(org.exolab.castor.types.Date dtScrDtFinPayhistTo)
    {
        this._dtScrDtFinPayhistTo = dtScrDtFinPayhistTo;
    } //-- void setDtScrDtFinPayhistTo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtScrNbrFinPayhistFrom'.
     * 
     * @param dtScrNbrFinPayhistFrom the value of field
     * 'dtScrNbrFinPayhistFrom'.
     */
    public void setDtScrNbrFinPayhistFrom(org.exolab.castor.types.Date dtScrNbrFinPayhistFrom)
    {
        this._dtScrNbrFinPayhistFrom = dtScrNbrFinPayhistFrom;
    } //-- void setDtScrNbrFinPayhistFrom(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdRegion'.
     * 
     * @param szCdRegion the value of field 'szCdRegion'.
     */
    public void setSzCdRegion(java.lang.String szCdRegion)
    {
        this._szCdRegion = szCdRegion;
    } //-- void setSzCdRegion(java.lang.String) 

    /**
     * Sets the value of field 'szScrFinPayhistSearch'.
     * 
     * @param szScrFinPayhistSearch the value of field
     * 'szScrFinPayhistSearch'.
     */
    public void setSzScrFinPayhistSearch(java.lang.String szScrFinPayhistSearch)
    {
        this._szScrFinPayhistSearch = szScrFinPayhistSearch;
    } //-- void setSzScrFinPayhistSearch(java.lang.String) 

    /**
     * Sets the value of field 'ulScrFinPayhistId'.
     * 
     * @param ulScrFinPayhistId the value of field
     * 'ulScrFinPayhistId'.
     */
    public void setUlScrFinPayhistId(int ulScrFinPayhistId)
    {
        this._ulScrFinPayhistId = ulScrFinPayhistId;
        this._has_ulScrFinPayhistId = true;
    } //-- void setUlScrFinPayhistId(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI unmarshal(java.io.Reader) 

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
