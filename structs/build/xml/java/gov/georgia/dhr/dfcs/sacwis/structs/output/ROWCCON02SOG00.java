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
 * Class ROWCCON02SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON02SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdRsrcAddress
     */
    private int _ulIdRsrcAddress;

    /**
     * keeps track of state for field: _ulIdRsrcAddress
     */
    private boolean _has_ulIdRsrcAddress;

    /**
     * Field _szNbrRsrcAddrVid
     */
    private java.lang.String _szNbrRsrcAddrVid;

    /**
     * Field _szAddrRsrcAddrStLn1
     */
    private java.lang.String _szAddrRsrcAddrStLn1;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON02SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdRsrcAddress()
    {
        this._has_ulIdRsrcAddress= false;
    } //-- void deleteUlIdRsrcAddress() 

    /**
     * Returns the value of field 'szAddrRsrcAddrStLn1'.
     * 
     * @return the value of field 'SzAddrRsrcAddrStLn1'.
     */
    public java.lang.String getSzAddrRsrcAddrStLn1()
    {
        return this._szAddrRsrcAddrStLn1;
    } //-- java.lang.String getSzAddrRsrcAddrStLn1() 

    /**
     * Returns the value of field 'szNbrRsrcAddrVid'.
     * 
     * @return the value of field 'SzNbrRsrcAddrVid'.
     */
    public java.lang.String getSzNbrRsrcAddrVid()
    {
        return this._szNbrRsrcAddrVid;
    } //-- java.lang.String getSzNbrRsrcAddrVid() 

    /**
     * Returns the value of field 'ulIdRsrcAddress'.
     * 
     * @return the value of field 'UlIdRsrcAddress'.
     */
    public int getUlIdRsrcAddress()
    {
        return this._ulIdRsrcAddress;
    } //-- int getUlIdRsrcAddress() 

    /**
     * Method hasUlIdRsrcAddress
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcAddress has been added
     */
    public boolean hasUlIdRsrcAddress()
    {
        return this._has_ulIdRsrcAddress;
    } //-- boolean hasUlIdRsrcAddress() 

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
     * Sets the value of field 'szAddrRsrcAddrStLn1'.
     * 
     * @param szAddrRsrcAddrStLn1 the value of field
     * 'szAddrRsrcAddrStLn1'.
     */
    public void setSzAddrRsrcAddrStLn1(java.lang.String szAddrRsrcAddrStLn1)
    {
        this._szAddrRsrcAddrStLn1 = szAddrRsrcAddrStLn1;
    } //-- void setSzAddrRsrcAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szNbrRsrcAddrVid'.
     * 
     * @param szNbrRsrcAddrVid the value of field 'szNbrRsrcAddrVid'
     */
    public void setSzNbrRsrcAddrVid(java.lang.String szNbrRsrcAddrVid)
    {
        this._szNbrRsrcAddrVid = szNbrRsrcAddrVid;
    } //-- void setSzNbrRsrcAddrVid(java.lang.String) 

    /**
     * Sets the value of field 'ulIdRsrcAddress'.
     * 
     * @param ulIdRsrcAddress the value of field 'ulIdRsrcAddress'.
     */
    public void setUlIdRsrcAddress(int ulIdRsrcAddress)
    {
        this._ulIdRsrcAddress = ulIdRsrcAddress;
        this._has_ulIdRsrcAddress = true;
    } //-- void setUlIdRsrcAddress(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00 unmarshal(java.io.Reader) 

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
