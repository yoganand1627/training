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
 * Class SpecHD.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SpecHD extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szCdCaseSpeclHndlg
     */
    private java.lang.String _szCdCaseSpeclHndlg;

    /**
     * Field _bIndCaseSensitive
     */
    private java.lang.String _bIndCaseSensitive;

    /**
     * Field _bIndCaseSuspMeth
     */
    private java.lang.String _bIndCaseSuspMeth;

    /**
     * Field _bIndCaseWorkerSafety
     */
    private java.lang.String _bIndCaseWorkerSafety;

    /**
     * Field _szTxtCaseWorkerSafety
     */
    private java.lang.String _szTxtCaseWorkerSafety;

    /**
     * Field _szTxtCaseSensitiveCmnts
     */
    private java.lang.String _szTxtCaseSensitiveCmnts;

    /**
     * Field _szTxtCaseSuspMeth
     */
    private java.lang.String _szTxtCaseSuspMeth;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;


      //----------------/
     //- Constructors -/
    //----------------/

    public SpecHD() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD()


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
     * Returns the value of field 'bIndCaseSuspMeth'.
     * 
     * @return the value of field 'BIndCaseSuspMeth'.
     */
    public java.lang.String getBIndCaseSuspMeth()
    {
        return this._bIndCaseSuspMeth;
    } //-- java.lang.String getBIndCaseSuspMeth() 

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
     * Returns the value of field 'szCdCaseSpeclHndlg'.
     * 
     * @return the value of field 'SzCdCaseSpeclHndlg'.
     */
    public java.lang.String getSzCdCaseSpeclHndlg()
    {
        return this._szCdCaseSpeclHndlg;
    } //-- java.lang.String getSzCdCaseSpeclHndlg() 

    /**
     * Returns the value of field 'szTxtCaseSensitiveCmnts'.
     * 
     * @return the value of field 'SzTxtCaseSensitiveCmnts'.
     */
    public java.lang.String getSzTxtCaseSensitiveCmnts()
    {
        return this._szTxtCaseSensitiveCmnts;
    } //-- java.lang.String getSzTxtCaseSensitiveCmnts() 

    /**
     * Returns the value of field 'szTxtCaseSuspMeth'.
     * 
     * @return the value of field 'SzTxtCaseSuspMeth'.
     */
    public java.lang.String getSzTxtCaseSuspMeth()
    {
        return this._szTxtCaseSuspMeth;
    } //-- java.lang.String getSzTxtCaseSuspMeth() 

    /**
     * Returns the value of field 'szTxtCaseWorkerSafety'.
     * 
     * @return the value of field 'SzTxtCaseWorkerSafety'.
     */
    public java.lang.String getSzTxtCaseWorkerSafety()
    {
        return this._szTxtCaseWorkerSafety;
    } //-- java.lang.String getSzTxtCaseWorkerSafety() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate2'.
     * 
     * @return the value of field 'TsSysTsLastUpdate2'.
     */
    public java.util.Date getTsSysTsLastUpdate2()
    {
        return this._tsSysTsLastUpdate2;
    } //-- java.util.Date getTsSysTsLastUpdate2() 

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
     * Sets the value of field 'bIndCaseSuspMeth'.
     * 
     * @param bIndCaseSuspMeth the value of field 'bIndCaseSuspMeth'
     */
    public void setBIndCaseSuspMeth(java.lang.String bIndCaseSuspMeth)
    {
        this._bIndCaseSuspMeth = bIndCaseSuspMeth;
    } //-- void setBIndCaseSuspMeth(java.lang.String) 

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
     * Sets the value of field 'szTxtCaseSensitiveCmnts'.
     * 
     * @param szTxtCaseSensitiveCmnts the value of field
     * 'szTxtCaseSensitiveCmnts'.
     */
    public void setSzTxtCaseSensitiveCmnts(java.lang.String szTxtCaseSensitiveCmnts)
    {
        this._szTxtCaseSensitiveCmnts = szTxtCaseSensitiveCmnts;
    } //-- void setSzTxtCaseSensitiveCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCaseSuspMeth'.
     * 
     * @param szTxtCaseSuspMeth the value of field
     * 'szTxtCaseSuspMeth'.
     */
    public void setSzTxtCaseSuspMeth(java.lang.String szTxtCaseSuspMeth)
    {
        this._szTxtCaseSuspMeth = szTxtCaseSuspMeth;
    } //-- void setSzTxtCaseSuspMeth(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCaseWorkerSafety'.
     * 
     * @param szTxtCaseWorkerSafety the value of field
     * 'szTxtCaseWorkerSafety'.
     */
    public void setSzTxtCaseWorkerSafety(java.lang.String szTxtCaseWorkerSafety)
    {
        this._szTxtCaseWorkerSafety = szTxtCaseWorkerSafety;
    } //-- void setSzTxtCaseWorkerSafety(java.lang.String) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate2'.
     * 
     * @param tsSysTsLastUpdate2 the value of field
     * 'tsSysTsLastUpdate2'.
     */
    public void setTsSysTsLastUpdate2(java.util.Date tsSysTsLastUpdate2)
    {
        this._tsSysTsLastUpdate2 = tsSysTsLastUpdate2;
    } //-- void setTsSysTsLastUpdate2(java.util.Date) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD unmarshal(java.io.Reader) 

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
