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
 * Class CCMN24SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN24SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _szCdUnitProgram
     */
    private java.lang.String _szCdUnitProgram;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szCdUnitCounty
     */
    private java.lang.String _szCdUnitCounty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN24SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'szCdUnitCounty'.
     * 
     * @return the value of field 'SzCdUnitCounty'.
     */
    public java.lang.String getSzCdUnitCounty()
    {
        return this._szCdUnitCounty;
    } //-- java.lang.String getSzCdUnitCounty() 

    /**
     * Returns the value of field 'szCdUnitProgram'.
     * 
     * @return the value of field 'SzCdUnitProgram'.
     */
    public java.lang.String getSzCdUnitProgram()
    {
        return this._szCdUnitProgram;
    } //-- java.lang.String getSzCdUnitProgram() 

    /**
     * Returns the value of field 'szCdUnitRegion'.
     * 
     * @return the value of field 'SzCdUnitRegion'.
     */
    public java.lang.String getSzCdUnitRegion()
    {
        return this._szCdUnitRegion;
    } //-- java.lang.String getSzCdUnitRegion() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'szCdUnitCounty'.
     * 
     * @param szCdUnitCounty the value of field 'szCdUnitCounty'.
     */
    public void setSzCdUnitCounty(java.lang.String szCdUnitCounty)
    {
        this._szCdUnitCounty = szCdUnitCounty;
    } //-- void setSzCdUnitCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitProgram'.
     * 
     * @param szCdUnitProgram the value of field 'szCdUnitProgram'.
     */
    public void setSzCdUnitProgram(java.lang.String szCdUnitProgram)
    {
        this._szCdUnitProgram = szCdUnitProgram;
    } //-- void setSzCdUnitProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitRegion'.
     * 
     * @param szCdUnitRegion the value of field 'szCdUnitRegion'.
     */
    public void setSzCdUnitRegion(java.lang.String szCdUnitRegion)
    {
        this._szCdUnitRegion = szCdUnitRegion;
    } //-- void setSzCdUnitRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI unmarshal(java.io.Reader) 

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
