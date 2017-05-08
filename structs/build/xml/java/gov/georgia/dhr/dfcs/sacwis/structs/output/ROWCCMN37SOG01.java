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
 * Class ROWCCMN37SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN37SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCaseRegion
     */
    private java.lang.String _szCdCaseRegion;

    /**
     * Field _szCdCaseCounty
     */
    private java.lang.String _szCdCaseCounty;

    /**
     * Field _szCdCaseSpeclHndlg
     */
    private java.lang.String _szCdCaseSpeclHndlg;

    /**
     * Field _dtDtCaseClosed
     */
    private org.exolab.castor.types.Date _dtDtCaseClosed;

    /**
     * Field _dtDtCaseOpened
     */
    private org.exolab.castor.types.Date _dtDtCaseOpened;

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
     * Field _bIndCaseSensitive
     */
    private java.lang.String _bIndCaseSensitive;

    /**
     * Field _bIndCaseWorkerSafety
     */
    private java.lang.String _bIndCaseWorkerSafety;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN37SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01()


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
     * Returns the value of field 'bIndCaseSensitive'.
     * 
     * @return the value of field 'BIndCaseSensitive'.
     */
    public java.lang.String getBIndCaseSensitive()
    {
        return this._bIndCaseSensitive;
    } //-- java.lang.String getBIndCaseSensitive() 

    /**
     * Returns the value of field 'bIndCaseWorkerSafety'.
     * 
     * @return the value of field 'BIndCaseWorkerSafety'.
     */
    public java.lang.String getBIndCaseWorkerSafety()
    {
        return this._bIndCaseWorkerSafety;
    } //-- java.lang.String getBIndCaseWorkerSafety() 

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
     * Returns the value of field 'szCdCaseRegion'.
     * 
     * @return the value of field 'SzCdCaseRegion'.
     */
    public java.lang.String getSzCdCaseRegion()
    {
        return this._szCdCaseRegion;
    } //-- java.lang.String getSzCdCaseRegion() 

    /**
     * Returns the value of field 'szCdCaseSpeclHndlg'.
     * 
     * @return the value of field 'SzCdCaseSpeclHndlg'.
     */
    public java.lang.String getSzCdCaseSpeclHndlg()
    {
        return this._szCdCaseSpeclHndlg;
    } //-- java.lang.String getSzCdCaseSpeclHndlg() 

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
     * Sets the value of field 'bIndCaseWorkerSafety'.
     * 
     * @param bIndCaseWorkerSafety the value of field
     * 'bIndCaseWorkerSafety'.
     */
    public void setBIndCaseWorkerSafety(java.lang.String bIndCaseWorkerSafety)
    {
        this._bIndCaseWorkerSafety = bIndCaseWorkerSafety;
    } //-- void setBIndCaseWorkerSafety(java.lang.String) 

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
     * Sets the value of field 'szCdCaseRegion'.
     * 
     * @param szCdCaseRegion the value of field 'szCdCaseRegion'.
     */
    public void setSzCdCaseRegion(java.lang.String szCdCaseRegion)
    {
        this._szCdCaseRegion = szCdCaseRegion;
    } //-- void setSzCdCaseRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdCaseSpeclHndlg'.
     * 
     * @param szCdCaseSpeclHndlg the value of field
     * 'szCdCaseSpeclHndlg'.
     */
    public void setSzCdCaseSpeclHndlg(java.lang.String szCdCaseSpeclHndlg)
    {
        this._szCdCaseSpeclHndlg = szCdCaseSpeclHndlg;
    } //-- void setSzCdCaseSpeclHndlg(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01 unmarshal(java.io.Reader) 

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
