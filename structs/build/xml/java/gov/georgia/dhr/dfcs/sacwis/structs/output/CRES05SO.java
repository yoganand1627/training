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
 * Class CRES05SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES05SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES05SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY _ROWCRES05SOG00_ARRAY;

    /**
     * Field _cIndFadHome
     */
    private java.lang.String _cIndFadHome;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES05SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'cIndFadHome'.
     * 
     * @return the value of field 'CIndFadHome'.
     */
    public java.lang.String getCIndFadHome()
    {
        return this._cIndFadHome;
    } //-- java.lang.String getCIndFadHome() 

    /**
     * Returns the value of field 'ROWCRES05SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCRES05SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY getROWCRES05SOG00_ARRAY()
    {
        return this._ROWCRES05SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY getROWCRES05SOG00_ARRAY() 

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
     * Sets the value of field 'cIndFadHome'.
     * 
     * @param cIndFadHome the value of field 'cIndFadHome'.
     */
    public void setCIndFadHome(java.lang.String cIndFadHome)
    {
        this._cIndFadHome = cIndFadHome;
    } //-- void setCIndFadHome(java.lang.String) 

    /**
     * Sets the value of field 'ROWCRES05SOG00_ARRAY'.
     * 
     * @param ROWCRES05SOG00_ARRAY the value of field
     * 'ROWCRES05SOG00_ARRAY'.
     */
    public void setROWCRES05SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY ROWCRES05SOG00_ARRAY)
    {
        this._ROWCRES05SOG00_ARRAY = ROWCRES05SOG00_ARRAY;
    } //-- void setROWCRES05SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO unmarshal(java.io.Reader) 

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
