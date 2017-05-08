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
 * Class ROWCCMN03UIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN03UIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPersonPrincipal
     */
    private int _ulIdPersonPrincipal;

    /**
     * keeps track of state for field: _ulIdPersonPrincipal
     */
    private boolean _has_ulIdPersonPrincipal;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szCdStagePersRelInt
     */
    private java.lang.String _szCdStagePersRelInt;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN03UIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPersonPrincipal()
    {
        this._has_ulIdPersonPrincipal= false;
    } //-- void deleteUlIdPersonPrincipal() 

    /**
     * Returns the value of field 'szCdStagePersRelInt'.
     * 
     * @return the value of field 'SzCdStagePersRelInt'.
     */
    public java.lang.String getSzCdStagePersRelInt()
    {
        return this._szCdStagePersRelInt;
    } //-- java.lang.String getSzCdStagePersRelInt() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'ulIdPersonPrincipal'.
     * 
     * @return the value of field 'UlIdPersonPrincipal'.
     */
    public int getUlIdPersonPrincipal()
    {
        return this._ulIdPersonPrincipal;
    } //-- int getUlIdPersonPrincipal() 

    /**
     * Method hasUlIdPersonPrincipal
     * 
     * 
     * 
     * @return true if at least one UlIdPersonPrincipal has been
     * added
     */
    public boolean hasUlIdPersonPrincipal()
    {
        return this._has_ulIdPersonPrincipal;
    } //-- boolean hasUlIdPersonPrincipal() 

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
     * Sets the value of field 'szCdStagePersRelInt'.
     * 
     * @param szCdStagePersRelInt the value of field
     * 'szCdStagePersRelInt'.
     */
    public void setSzCdStagePersRelInt(java.lang.String szCdStagePersRelInt)
    {
        this._szCdStagePersRelInt = szCdStagePersRelInt;
    } //-- void setSzCdStagePersRelInt(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPersonPrincipal'.
     * 
     * @param ulIdPersonPrincipal the value of field
     * 'ulIdPersonPrincipal'.
     */
    public void setUlIdPersonPrincipal(int ulIdPersonPrincipal)
    {
        this._ulIdPersonPrincipal = ulIdPersonPrincipal;
        this._has_ulIdPersonPrincipal = true;
    } //-- void setUlIdPersonPrincipal(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 unmarshal(java.io.Reader) 

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
