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
 * Class ROWCRES08SIG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES08SIG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRsrcCharChrctr
     */
    private java.lang.String _szCdRsrcCharChrctr;

    /**
     * Field _uNbrRsrcCharMaxFAge
     */
    private int _uNbrRsrcCharMaxFAge;

    /**
     * keeps track of state for field: _uNbrRsrcCharMaxFAge
     */
    private boolean _has_uNbrRsrcCharMaxFAge;

    /**
     * Field _uNbrRsrcCharMaxMAge
     */
    private int _uNbrRsrcCharMaxMAge;

    /**
     * keeps track of state for field: _uNbrRsrcCharMaxMAge
     */
    private boolean _has_uNbrRsrcCharMaxMAge;

    /**
     * Field _uNbrRsrcCharMinFAge
     */
    private int _uNbrRsrcCharMinFAge;

    /**
     * keeps track of state for field: _uNbrRsrcCharMinFAge
     */
    private boolean _has_uNbrRsrcCharMinFAge;

    /**
     * Field _uNbrRsrcCharMinMAge
     */
    private int _uNbrRsrcCharMinMAge;

    /**
     * keeps track of state for field: _uNbrRsrcCharMinMAge
     */
    private boolean _has_uNbrRsrcCharMinMAge;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES08SIG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUNbrRsrcCharMaxFAge()
    {
        this._has_uNbrRsrcCharMaxFAge= false;
    } //-- void deleteUNbrRsrcCharMaxFAge() 

    /**
     */
    public void deleteUNbrRsrcCharMaxMAge()
    {
        this._has_uNbrRsrcCharMaxMAge= false;
    } //-- void deleteUNbrRsrcCharMaxMAge() 

    /**
     */
    public void deleteUNbrRsrcCharMinFAge()
    {
        this._has_uNbrRsrcCharMinFAge= false;
    } //-- void deleteUNbrRsrcCharMinFAge() 

    /**
     */
    public void deleteUNbrRsrcCharMinMAge()
    {
        this._has_uNbrRsrcCharMinMAge= false;
    } //-- void deleteUNbrRsrcCharMinMAge() 

    /**
     * Returns the value of field 'szCdRsrcCharChrctr'.
     * 
     * @return the value of field 'SzCdRsrcCharChrctr'.
     */
    public java.lang.String getSzCdRsrcCharChrctr()
    {
        return this._szCdRsrcCharChrctr;
    } //-- java.lang.String getSzCdRsrcCharChrctr() 

    /**
     * Returns the value of field 'uNbrRsrcCharMaxFAge'.
     * 
     * @return the value of field 'UNbrRsrcCharMaxFAge'.
     */
    public int getUNbrRsrcCharMaxFAge()
    {
        return this._uNbrRsrcCharMaxFAge;
    } //-- int getUNbrRsrcCharMaxFAge() 

    /**
     * Returns the value of field 'uNbrRsrcCharMaxMAge'.
     * 
     * @return the value of field 'UNbrRsrcCharMaxMAge'.
     */
    public int getUNbrRsrcCharMaxMAge()
    {
        return this._uNbrRsrcCharMaxMAge;
    } //-- int getUNbrRsrcCharMaxMAge() 

    /**
     * Returns the value of field 'uNbrRsrcCharMinFAge'.
     * 
     * @return the value of field 'UNbrRsrcCharMinFAge'.
     */
    public int getUNbrRsrcCharMinFAge()
    {
        return this._uNbrRsrcCharMinFAge;
    } //-- int getUNbrRsrcCharMinFAge() 

    /**
     * Returns the value of field 'uNbrRsrcCharMinMAge'.
     * 
     * @return the value of field 'UNbrRsrcCharMinMAge'.
     */
    public int getUNbrRsrcCharMinMAge()
    {
        return this._uNbrRsrcCharMinMAge;
    } //-- int getUNbrRsrcCharMinMAge() 

    /**
     * Method hasUNbrRsrcCharMaxFAge
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcCharMaxFAge has been
     * added
     */
    public boolean hasUNbrRsrcCharMaxFAge()
    {
        return this._has_uNbrRsrcCharMaxFAge;
    } //-- boolean hasUNbrRsrcCharMaxFAge() 

    /**
     * Method hasUNbrRsrcCharMaxMAge
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcCharMaxMAge has been
     * added
     */
    public boolean hasUNbrRsrcCharMaxMAge()
    {
        return this._has_uNbrRsrcCharMaxMAge;
    } //-- boolean hasUNbrRsrcCharMaxMAge() 

    /**
     * Method hasUNbrRsrcCharMinFAge
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcCharMinFAge has been
     * added
     */
    public boolean hasUNbrRsrcCharMinFAge()
    {
        return this._has_uNbrRsrcCharMinFAge;
    } //-- boolean hasUNbrRsrcCharMinFAge() 

    /**
     * Method hasUNbrRsrcCharMinMAge
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcCharMinMAge has been
     * added
     */
    public boolean hasUNbrRsrcCharMinMAge()
    {
        return this._has_uNbrRsrcCharMinMAge;
    } //-- boolean hasUNbrRsrcCharMinMAge() 

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
     * Sets the value of field 'szCdRsrcCharChrctr'.
     * 
     * @param szCdRsrcCharChrctr the value of field
     * 'szCdRsrcCharChrctr'.
     */
    public void setSzCdRsrcCharChrctr(java.lang.String szCdRsrcCharChrctr)
    {
        this._szCdRsrcCharChrctr = szCdRsrcCharChrctr;
    } //-- void setSzCdRsrcCharChrctr(java.lang.String) 

    /**
     * Sets the value of field 'uNbrRsrcCharMaxFAge'.
     * 
     * @param uNbrRsrcCharMaxFAge the value of field
     * 'uNbrRsrcCharMaxFAge'.
     */
    public void setUNbrRsrcCharMaxFAge(int uNbrRsrcCharMaxFAge)
    {
        this._uNbrRsrcCharMaxFAge = uNbrRsrcCharMaxFAge;
        this._has_uNbrRsrcCharMaxFAge = true;
    } //-- void setUNbrRsrcCharMaxFAge(int) 

    /**
     * Sets the value of field 'uNbrRsrcCharMaxMAge'.
     * 
     * @param uNbrRsrcCharMaxMAge the value of field
     * 'uNbrRsrcCharMaxMAge'.
     */
    public void setUNbrRsrcCharMaxMAge(int uNbrRsrcCharMaxMAge)
    {
        this._uNbrRsrcCharMaxMAge = uNbrRsrcCharMaxMAge;
        this._has_uNbrRsrcCharMaxMAge = true;
    } //-- void setUNbrRsrcCharMaxMAge(int) 

    /**
     * Sets the value of field 'uNbrRsrcCharMinFAge'.
     * 
     * @param uNbrRsrcCharMinFAge the value of field
     * 'uNbrRsrcCharMinFAge'.
     */
    public void setUNbrRsrcCharMinFAge(int uNbrRsrcCharMinFAge)
    {
        this._uNbrRsrcCharMinFAge = uNbrRsrcCharMinFAge;
        this._has_uNbrRsrcCharMinFAge = true;
    } //-- void setUNbrRsrcCharMinFAge(int) 

    /**
     * Sets the value of field 'uNbrRsrcCharMinMAge'.
     * 
     * @param uNbrRsrcCharMinMAge the value of field
     * 'uNbrRsrcCharMinMAge'.
     */
    public void setUNbrRsrcCharMinMAge(int uNbrRsrcCharMinMAge)
    {
        this._uNbrRsrcCharMinMAge = uNbrRsrcCharMinMAge;
        this._has_uNbrRsrcCharMinMAge = true;
    } //-- void setUNbrRsrcCharMinMAge(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01 unmarshal(java.io.Reader) 

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
