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
 * Class CCMN05SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN05SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CCMN05SOG02
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG02 _CCMN05SOG02;

    /**
     * Field _CCMN05SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG01 _CCMN05SOG01;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN05SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'CCMN05SOG01'.
     * 
     * @return the value of field 'CCMN05SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG01 getCCMN05SOG01()
    {
        return this._CCMN05SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG01 getCCMN05SOG01() 

    /**
     * Returns the value of field 'CCMN05SOG02'.
     * 
     * @return the value of field 'CCMN05SOG02'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG02 getCCMN05SOG02()
    {
        return this._CCMN05SOG02;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG02 getCCMN05SOG02() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

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
     * Sets the value of field 'CCMN05SOG01'.
     * 
     * @param CCMN05SOG01 the value of field 'CCMN05SOG01'.
     */
    public void setCCMN05SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG01 CCMN05SOG01)
    {
        this._CCMN05SOG01 = CCMN05SOG01;
    } //-- void setCCMN05SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG01) 

    /**
     * Sets the value of field 'CCMN05SOG02'.
     * 
     * @param CCMN05SOG02 the value of field 'CCMN05SOG02'.
     */
    public void setCCMN05SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG02 CCMN05SOG02)
    {
        this._CCMN05SOG02 = CCMN05SOG02;
    } //-- void setCCMN05SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SOG02) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO unmarshal(java.io.Reader) 

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
