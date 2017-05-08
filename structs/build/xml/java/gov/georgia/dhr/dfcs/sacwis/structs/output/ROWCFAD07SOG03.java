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
 * Class ROWCFAD07SOG03.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD07SOG03 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdFaHomeIntEthnicity
     */
    private java.lang.String _szCdFaHomeIntEthnicity;

    /**
     * Field _dtScrDtFaHomeEthnicAdd
     */
    private org.exolab.castor.types.Date _dtScrDtFaHomeEthnicAdd;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD07SOG03() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dtScrDtFaHomeEthnicAdd'.
     * 
     * @return the value of field 'DtScrDtFaHomeEthnicAdd'.
     */
    public org.exolab.castor.types.Date getDtScrDtFaHomeEthnicAdd()
    {
        return this._dtScrDtFaHomeEthnicAdd;
    } //-- org.exolab.castor.types.Date getDtScrDtFaHomeEthnicAdd() 

    /**
     * Returns the value of field 'szCdFaHomeIntEthnicity'.
     * 
     * @return the value of field 'SzCdFaHomeIntEthnicity'.
     */
    public java.lang.String getSzCdFaHomeIntEthnicity()
    {
        return this._szCdFaHomeIntEthnicity;
    } //-- java.lang.String getSzCdFaHomeIntEthnicity() 

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
     * Sets the value of field 'dtScrDtFaHomeEthnicAdd'.
     * 
     * @param dtScrDtFaHomeEthnicAdd the value of field
     * 'dtScrDtFaHomeEthnicAdd'.
     */
    public void setDtScrDtFaHomeEthnicAdd(org.exolab.castor.types.Date dtScrDtFaHomeEthnicAdd)
    {
        this._dtScrDtFaHomeEthnicAdd = dtScrDtFaHomeEthnicAdd;
    } //-- void setDtScrDtFaHomeEthnicAdd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdFaHomeIntEthnicity'.
     * 
     * @param szCdFaHomeIntEthnicity the value of field
     * 'szCdFaHomeIntEthnicity'.
     */
    public void setSzCdFaHomeIntEthnicity(java.lang.String szCdFaHomeIntEthnicity)
    {
        this._szCdFaHomeIntEthnicity = szCdFaHomeIntEthnicity;
    } //-- void setSzCdFaHomeIntEthnicity(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03 unmarshal(java.io.Reader) 

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
