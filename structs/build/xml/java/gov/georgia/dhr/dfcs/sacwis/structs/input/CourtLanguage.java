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
 * Class CourtLanguage.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CourtLanguage extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCrtLang
     */
    private java.lang.String _szCdCrtLang;

    /**
     * Field _cReqFuncCd
     */
    private java.lang.String _cReqFuncCd;


      //----------------/
     //- Constructors -/
    //----------------/

    public CourtLanguage() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'cReqFuncCd'.
     * 
     * @return the value of field 'CReqFuncCd'.
     */
    public java.lang.String getCReqFuncCd()
    {
        return this._cReqFuncCd;
    } //-- java.lang.String getCReqFuncCd() 

    /**
     * Returns the value of field 'szCdCrtLang'.
     * 
     * @return the value of field 'SzCdCrtLang'.
     */
    public java.lang.String getSzCdCrtLang()
    {
        return this._szCdCrtLang;
    } //-- java.lang.String getSzCdCrtLang() 

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
     * Sets the value of field 'cReqFuncCd'.
     * 
     * @param cReqFuncCd the value of field 'cReqFuncCd'.
     */
    public void setCReqFuncCd(java.lang.String cReqFuncCd)
    {
        this._cReqFuncCd = cReqFuncCd;
    } //-- void setCReqFuncCd(java.lang.String) 

    /**
     * Sets the value of field 'szCdCrtLang'.
     * 
     * @param szCdCrtLang the value of field 'szCdCrtLang'.
     */
    public void setSzCdCrtLang(java.lang.String szCdCrtLang)
    {
        this._szCdCrtLang = szCdCrtLang;
    } //-- void setSzCdCrtLang(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage unmarshal(java.io.Reader) 

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
