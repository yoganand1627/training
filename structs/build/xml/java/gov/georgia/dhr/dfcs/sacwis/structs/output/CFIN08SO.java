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
 * Class CFIN08SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN08SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _lNbrRsrcFacilAcclaim
     */
    private int _lNbrRsrcFacilAcclaim;

    /**
     * keeps track of state for field: _lNbrRsrcFacilAcclaim
     */
    private boolean _has_lNbrRsrcFacilAcclaim;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN08SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrRsrcFacilAcclaim()
    {
        this._has_lNbrRsrcFacilAcclaim= false;
    } //-- void deleteLNbrRsrcFacilAcclaim() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'lNbrRsrcFacilAcclaim'.
     * 
     * @return the value of field 'LNbrRsrcFacilAcclaim'.
     */
    public int getLNbrRsrcFacilAcclaim()
    {
        return this._lNbrRsrcFacilAcclaim;
    } //-- int getLNbrRsrcFacilAcclaim() 

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
     * Method hasLNbrRsrcFacilAcclaim
     * 
     * 
     * 
     * @return true if at least one LNbrRsrcFacilAcclaim has been
     * added
     */
    public boolean hasLNbrRsrcFacilAcclaim()
    {
        return this._has_lNbrRsrcFacilAcclaim;
    } //-- boolean hasLNbrRsrcFacilAcclaim() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'lNbrRsrcFacilAcclaim'.
     * 
     * @param lNbrRsrcFacilAcclaim the value of field
     * 'lNbrRsrcFacilAcclaim'.
     */
    public void setLNbrRsrcFacilAcclaim(int lNbrRsrcFacilAcclaim)
    {
        this._lNbrRsrcFacilAcclaim = lNbrRsrcFacilAcclaim;
        this._has_lNbrRsrcFacilAcclaim = true;
    } //-- void setLNbrRsrcFacilAcclaim(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO unmarshal(java.io.Reader) 

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
