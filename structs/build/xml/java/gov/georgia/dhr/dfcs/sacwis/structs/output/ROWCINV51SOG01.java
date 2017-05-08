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
 * Class ROWCINV51SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV51SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdRiskFactor
     */
    private int _ulIdRiskFactor;

    /**
     * keeps track of state for field: _ulIdRiskFactor
     */
    private boolean _has_ulIdRiskFactor;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdRiskFactor
     */
    private java.lang.String _szCdRiskFactor;

    /**
     * Field _szCdRiskFactorResponse
     */
    private java.lang.String _szCdRiskFactorResponse;

    /**
     * Field _szCdRiskFactorCateg
     */
    private java.lang.String _szCdRiskFactorCateg;

    /**
     * Field _txtRiskFactorComment
     */
    private java.lang.String _txtRiskFactorComment;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV51SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdRiskFactor()
    {
        this._has_ulIdRiskFactor= false;
    } //-- void deleteUlIdRiskFactor() 

    /**
     * Returns the value of field 'szCdRiskFactor'.
     * 
     * @return the value of field 'SzCdRiskFactor'.
     */
    public java.lang.String getSzCdRiskFactor()
    {
        return this._szCdRiskFactor;
    } //-- java.lang.String getSzCdRiskFactor() 

    /**
     * Returns the value of field 'szCdRiskFactorCateg'.
     * 
     * @return the value of field 'SzCdRiskFactorCateg'.
     */
    public java.lang.String getSzCdRiskFactorCateg()
    {
        return this._szCdRiskFactorCateg;
    } //-- java.lang.String getSzCdRiskFactorCateg() 

    /**
     * Returns the value of field 'szCdRiskFactorResponse'.
     * 
     * @return the value of field 'SzCdRiskFactorResponse'.
     */
    public java.lang.String getSzCdRiskFactorResponse()
    {
        return this._szCdRiskFactorResponse;
    } //-- java.lang.String getSzCdRiskFactorResponse() 

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
     * Returns the value of field 'txtRiskFactorComment'.
     * 
     * @return the value of field 'TxtRiskFactorComment'.
     */
    public java.lang.String getTxtRiskFactorComment()
    {
        return this._txtRiskFactorComment;
    } //-- java.lang.String getTxtRiskFactorComment() 

    /**
     * Returns the value of field 'ulIdRiskFactor'.
     * 
     * @return the value of field 'UlIdRiskFactor'.
     */
    public int getUlIdRiskFactor()
    {
        return this._ulIdRiskFactor;
    } //-- int getUlIdRiskFactor() 

    /**
     * Method hasUlIdRiskFactor
     * 
     * 
     * 
     * @return true if at least one UlIdRiskFactor has been added
     */
    public boolean hasUlIdRiskFactor()
    {
        return this._has_ulIdRiskFactor;
    } //-- boolean hasUlIdRiskFactor() 

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
     * Sets the value of field 'szCdRiskFactor'.
     * 
     * @param szCdRiskFactor the value of field 'szCdRiskFactor'.
     */
    public void setSzCdRiskFactor(java.lang.String szCdRiskFactor)
    {
        this._szCdRiskFactor = szCdRiskFactor;
    } //-- void setSzCdRiskFactor(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskFactorCateg'.
     * 
     * @param szCdRiskFactorCateg the value of field
     * 'szCdRiskFactorCateg'.
     */
    public void setSzCdRiskFactorCateg(java.lang.String szCdRiskFactorCateg)
    {
        this._szCdRiskFactorCateg = szCdRiskFactorCateg;
    } //-- void setSzCdRiskFactorCateg(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskFactorResponse'.
     * 
     * @param szCdRiskFactorResponse the value of field
     * 'szCdRiskFactorResponse'.
     */
    public void setSzCdRiskFactorResponse(java.lang.String szCdRiskFactorResponse)
    {
        this._szCdRiskFactorResponse = szCdRiskFactorResponse;
    } //-- void setSzCdRiskFactorResponse(java.lang.String) 

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
     * Sets the value of field 'txtRiskFactorComment'.
     * 
     * @param txtRiskFactorComment the value of field
     * 'txtRiskFactorComment'.
     */
    public void setTxtRiskFactorComment(java.lang.String txtRiskFactorComment)
    {
        this._txtRiskFactorComment = txtRiskFactorComment;
    } //-- void setTxtRiskFactorComment(java.lang.String) 

    /**
     * Sets the value of field 'ulIdRiskFactor'.
     * 
     * @param ulIdRiskFactor the value of field 'ulIdRiskFactor'.
     */
    public void setUlIdRiskFactor(int ulIdRiskFactor)
    {
        this._ulIdRiskFactor = ulIdRiskFactor;
        this._has_ulIdRiskFactor = true;
    } //-- void setUlIdRiskFactor(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 unmarshal(java.io.Reader) 

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
