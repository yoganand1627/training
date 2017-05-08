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
 * Class CFAD39SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD39SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _szNbrRsrcVid
     */
    private java.lang.String _szNbrRsrcVid;

    /**
     * Field _szAddrRsrcAddrStLn1
     */
    private java.lang.String _szAddrRsrcAddrStLn1;

    /**
     * Field _szAddrRsrcAddrStLn2
     */
    private java.lang.String _szAddrRsrcAddrStLn2;

    /**
     * Field _szAddrRsrcAddrCity
     */
    private java.lang.String _szAddrRsrcAddrCity;

    /**
     * Field _szAddrRsrcAddrState
     */
    private java.lang.String _szAddrRsrcAddrState;

    /**
     * Field _szCdFacilityCounty
     */
    private java.lang.String _szCdFacilityCounty;

    /**
     * Field _szAddrRsrcAddrZip
     */
    private java.lang.String _szAddrRsrcAddrZip;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD39SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'szAddrRsrcAddrCity'.
     * 
     * @return the value of field 'SzAddrRsrcAddrCity'.
     */
    public java.lang.String getSzAddrRsrcAddrCity()
    {
        return this._szAddrRsrcAddrCity;
    } //-- java.lang.String getSzAddrRsrcAddrCity() 

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
     * Returns the value of field 'szAddrRsrcAddrStLn2'.
     * 
     * @return the value of field 'SzAddrRsrcAddrStLn2'.
     */
    public java.lang.String getSzAddrRsrcAddrStLn2()
    {
        return this._szAddrRsrcAddrStLn2;
    } //-- java.lang.String getSzAddrRsrcAddrStLn2() 

    /**
     * Returns the value of field 'szAddrRsrcAddrState'.
     * 
     * @return the value of field 'SzAddrRsrcAddrState'.
     */
    public java.lang.String getSzAddrRsrcAddrState()
    {
        return this._szAddrRsrcAddrState;
    } //-- java.lang.String getSzAddrRsrcAddrState() 

    /**
     * Returns the value of field 'szAddrRsrcAddrZip'.
     * 
     * @return the value of field 'SzAddrRsrcAddrZip'.
     */
    public java.lang.String getSzAddrRsrcAddrZip()
    {
        return this._szAddrRsrcAddrZip;
    } //-- java.lang.String getSzAddrRsrcAddrZip() 

    /**
     * Returns the value of field 'szCdFacilityCounty'.
     * 
     * @return the value of field 'SzCdFacilityCounty'.
     */
    public java.lang.String getSzCdFacilityCounty()
    {
        return this._szCdFacilityCounty;
    } //-- java.lang.String getSzCdFacilityCounty() 

    /**
     * Returns the value of field 'szNbrRsrcVid'.
     * 
     * @return the value of field 'SzNbrRsrcVid'.
     */
    public java.lang.String getSzNbrRsrcVid()
    {
        return this._szNbrRsrcVid;
    } //-- java.lang.String getSzNbrRsrcVid() 

    /**
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

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
     * Sets the value of field 'szAddrRsrcAddrCity'.
     * 
     * @param szAddrRsrcAddrCity the value of field
     * 'szAddrRsrcAddrCity'.
     */
    public void setSzAddrRsrcAddrCity(java.lang.String szAddrRsrcAddrCity)
    {
        this._szAddrRsrcAddrCity = szAddrRsrcAddrCity;
    } //-- void setSzAddrRsrcAddrCity(java.lang.String) 

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
     * Sets the value of field 'szAddrRsrcAddrStLn2'.
     * 
     * @param szAddrRsrcAddrStLn2 the value of field
     * 'szAddrRsrcAddrStLn2'.
     */
    public void setSzAddrRsrcAddrStLn2(java.lang.String szAddrRsrcAddrStLn2)
    {
        this._szAddrRsrcAddrStLn2 = szAddrRsrcAddrStLn2;
    } //-- void setSzAddrRsrcAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcAddrState'.
     * 
     * @param szAddrRsrcAddrState the value of field
     * 'szAddrRsrcAddrState'.
     */
    public void setSzAddrRsrcAddrState(java.lang.String szAddrRsrcAddrState)
    {
        this._szAddrRsrcAddrState = szAddrRsrcAddrState;
    } //-- void setSzAddrRsrcAddrState(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcAddrZip'.
     * 
     * @param szAddrRsrcAddrZip the value of field
     * 'szAddrRsrcAddrZip'.
     */
    public void setSzAddrRsrcAddrZip(java.lang.String szAddrRsrcAddrZip)
    {
        this._szAddrRsrcAddrZip = szAddrRsrcAddrZip;
    } //-- void setSzAddrRsrcAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilityCounty'.
     * 
     * @param szCdFacilityCounty the value of field
     * 'szCdFacilityCounty'.
     */
    public void setSzCdFacilityCounty(java.lang.String szCdFacilityCounty)
    {
        this._szCdFacilityCounty = szCdFacilityCounty;
    } //-- void setSzCdFacilityCounty(java.lang.String) 

    /**
     * Sets the value of field 'szNbrRsrcVid'.
     * 
     * @param szNbrRsrcVid the value of field 'szNbrRsrcVid'.
     */
    public void setSzNbrRsrcVid(java.lang.String szNbrRsrcVid)
    {
        this._szNbrRsrcVid = szNbrRsrcVid;
    } //-- void setSzNbrRsrcVid(java.lang.String) 

    /**
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01 unmarshal(java.io.Reader) 

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
