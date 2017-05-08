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
 * Class PersListOutRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PersListOutRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _persListRtrvStruct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY _persListRtrvStruct_ARRAY;

    /**
     * Field _CINT26SO_OTHER_RELATIONSHIP_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY _CINT26SO_OTHER_RELATIONSHIP_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersListOutRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec()


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
     * Returns the value of field
     * 'CINT26SO_OTHER_RELATIONSHIP_ARRAY'.
     * 
     * @return the value of field
     * 'CINT26SO_OTHER_RELATIONSHIP_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY getCINT26SO_OTHER_RELATIONSHIP_ARRAY()
    {
        return this._CINT26SO_OTHER_RELATIONSHIP_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY getCINT26SO_OTHER_RELATIONSHIP_ARRAY() 

    /**
     * Returns the value of field 'persListRtrvStruct_ARRAY'.
     * 
     * @return the value of field 'PersListRtrvStruct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY getPersListRtrvStruct_ARRAY()
    {
        return this._persListRtrvStruct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY getPersListRtrvStruct_ARRAY() 

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
     * Sets the value of field 'CINT26SO_OTHER_RELATIONSHIP_ARRAY'.
     * 
     * @param CINT26SO_OTHER_RELATIONSHIP_ARRAY the value of field
     * 'CINT26SO_OTHER_RELATIONSHIP_ARRAY'.
     */
    public void setCINT26SO_OTHER_RELATIONSHIP_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY CINT26SO_OTHER_RELATIONSHIP_ARRAY)
    {
        this._CINT26SO_OTHER_RELATIONSHIP_ARRAY = CINT26SO_OTHER_RELATIONSHIP_ARRAY;
    } //-- void setCINT26SO_OTHER_RELATIONSHIP_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY) 

    /**
     * Sets the value of field 'persListRtrvStruct_ARRAY'.
     * 
     * @param persListRtrvStruct_ARRAY the value of field
     * 'persListRtrvStruct_ARRAY'.
     */
    public void setPersListRtrvStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY persListRtrvStruct_ARRAY)
    {
        this._persListRtrvStruct_ARRAY = persListRtrvStruct_ARRAY;
    } //-- void setPersListRtrvStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec unmarshal(java.io.Reader) 

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
