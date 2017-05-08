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
 * Class CSUB45SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB45SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB45SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00 _ROWCSUB45SOG00;

    /**
     * Field _ROWCSUB45SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01 _ROWCSUB45SOG01;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dtSysDtGenericSysdate
     */
    private org.exolab.castor.types.Date _dtSysDtGenericSysdate;

    /**
     * Field _bIndPrevAfcars
     */
    private java.lang.String _bIndPrevAfcars;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB45SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO()


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
     * Returns the value of field 'bIndPrevAfcars'.
     * 
     * @return the value of field 'BIndPrevAfcars'.
     */
    public java.lang.String getBIndPrevAfcars()
    {
        return this._bIndPrevAfcars;
    } //-- java.lang.String getBIndPrevAfcars() 

    /**
     * Returns the value of field 'dtSysDtGenericSysdate'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate'.
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdate;
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate() 

    /**
     * Returns the value of field 'ROWCSUB45SOG00'.
     * 
     * @return the value of field 'ROWCSUB45SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00 getROWCSUB45SOG00()
    {
        return this._ROWCSUB45SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00 getROWCSUB45SOG00() 

    /**
     * Returns the value of field 'ROWCSUB45SOG01'.
     * 
     * @return the value of field 'ROWCSUB45SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01 getROWCSUB45SOG01()
    {
        return this._ROWCSUB45SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01 getROWCSUB45SOG01() 

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
     * Sets the value of field 'bIndPrevAfcars'.
     * 
     * @param bIndPrevAfcars the value of field 'bIndPrevAfcars'.
     */
    public void setBIndPrevAfcars(java.lang.String bIndPrevAfcars)
    {
        this._bIndPrevAfcars = bIndPrevAfcars;
    } //-- void setBIndPrevAfcars(java.lang.String) 

    /**
     * Sets the value of field 'dtSysDtGenericSysdate'.
     * 
     * @param dtSysDtGenericSysdate the value of field
     * 'dtSysDtGenericSysdate'.
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date dtSysDtGenericSysdate)
    {
        this._dtSysDtGenericSysdate = dtSysDtGenericSysdate;
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCSUB45SOG00'.
     * 
     * @param ROWCSUB45SOG00 the value of field 'ROWCSUB45SOG00'.
     */
    public void setROWCSUB45SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00 ROWCSUB45SOG00)
    {
        this._ROWCSUB45SOG00 = ROWCSUB45SOG00;
    } //-- void setROWCSUB45SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00) 

    /**
     * Sets the value of field 'ROWCSUB45SOG01'.
     * 
     * @param ROWCSUB45SOG01 the value of field 'ROWCSUB45SOG01'.
     */
    public void setROWCSUB45SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01 ROWCSUB45SOG01)
    {
        this._ROWCSUB45SOG01 = ROWCSUB45SOG01;
    } //-- void setROWCSUB45SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO unmarshal(java.io.Reader) 

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
