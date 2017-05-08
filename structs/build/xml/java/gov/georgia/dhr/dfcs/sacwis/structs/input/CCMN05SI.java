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
 * Class CCMN05SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN05SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN05SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00 _ROWCCMN05SIG00;

    /**
     * Field _ROWCCMN05SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01 _ROWCCMN05SIG01;

    /**
     * Field _ROWCCMN05SIG02
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02 _ROWCCMN05SIG02;

    /**
     * Field _ROWCCMN05SIG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG03_ARRAY _ROWCCMN05SIG03_ARRAY;

    /**
     * Field _ROWCCMN05SIG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02_ARRAY _ROWCCMN05SIG02_ARRAY;

    /**
     * Field _ROWCCMN05SIG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04 _ROWCCMN05SIG04;

    /**
     * Field _ROWCCMN05SIG05
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05 _ROWCCMN05SIG05;

    /**
     * Field _ROWCCMN05SIG06
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06 _ROWCCMN05SIG06;

    /**
     * Field _ROWCCMN05SIG08_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY _ROWCCMN05SIG08_ARRAY;

    /**
     * Field _ROWCCMN05SIG09_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY _ROWCCMN05SIG09_ARRAY;

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
     * Field _ulIdEmployee
     */
    private int _ulIdEmployee;

    /**
     * keeps track of state for field: _ulIdEmployee
     */
    private boolean _has_ulIdEmployee;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN05SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmployee()
    {
        this._has_ulIdEmployee= false;
    } //-- void deleteUlIdEmployee() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'ROWCCMN05SIG00'.
     * 
     * @return the value of field 'ROWCCMN05SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00 getROWCCMN05SIG00()
    {
        return this._ROWCCMN05SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00 getROWCCMN05SIG00() 

    /**
     * Returns the value of field 'ROWCCMN05SIG01'.
     * 
     * @return the value of field 'ROWCCMN05SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01 getROWCCMN05SIG01()
    {
        return this._ROWCCMN05SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01 getROWCCMN05SIG01() 

    /**
     * Returns the value of field 'ROWCCMN05SIG02'.
     * 
     * @return the value of field 'ROWCCMN05SIG02'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02 getROWCCMN05SIG02()
    {
        return this._ROWCCMN05SIG02;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02 getROWCCMN05SIG02() 

    /**
     * Returns the value of field 'ROWCCMN05SIG02_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN05SIG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02_ARRAY getROWCCMN05SIG02_ARRAY()
    {
        return this._ROWCCMN05SIG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02_ARRAY getROWCCMN05SIG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN05SIG03_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN05SIG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG03_ARRAY getROWCCMN05SIG03_ARRAY()
    {
        return this._ROWCCMN05SIG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG03_ARRAY getROWCCMN05SIG03_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN05SIG04'.
     * 
     * @return the value of field 'ROWCCMN05SIG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04 getROWCCMN05SIG04()
    {
        return this._ROWCCMN05SIG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04 getROWCCMN05SIG04() 

    /**
     * Returns the value of field 'ROWCCMN05SIG05'.
     * 
     * @return the value of field 'ROWCCMN05SIG05'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05 getROWCCMN05SIG05()
    {
        return this._ROWCCMN05SIG05;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05 getROWCCMN05SIG05() 

    /**
     * Returns the value of field 'ROWCCMN05SIG06'.
     * 
     * @return the value of field 'ROWCCMN05SIG06'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06 getROWCCMN05SIG06()
    {
        return this._ROWCCMN05SIG06;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06 getROWCCMN05SIG06() 

    /**
     * Returns the value of field 'ROWCCMN05SIG08_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN05SIG08_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY getROWCCMN05SIG08_ARRAY()
    {
        return this._ROWCCMN05SIG08_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY getROWCCMN05SIG08_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN05SIG09_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN05SIG09_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY getROWCCMN05SIG09_ARRAY()
    {
        return this._ROWCCMN05SIG09_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY getROWCCMN05SIG09_ARRAY() 

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
     * Returns the value of field 'ulIdEmployee'.
     * 
     * @return the value of field 'UlIdEmployee'.
     */
    public int getUlIdEmployee()
    {
        return this._ulIdEmployee;
    } //-- int getUlIdEmployee() 

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
     * Method hasUlIdEmployee
     * 
     * 
     * 
     * @return true if at least one UlIdEmployee has been added
     */
    public boolean hasUlIdEmployee()
    {
        return this._has_ulIdEmployee;
    } //-- boolean hasUlIdEmployee() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'ROWCCMN05SIG00'.
     * 
     * @param ROWCCMN05SIG00 the value of field 'ROWCCMN05SIG00'.
     */
    public void setROWCCMN05SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00 ROWCCMN05SIG00)
    {
        this._ROWCCMN05SIG00 = ROWCCMN05SIG00;
    } //-- void setROWCCMN05SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00) 

    /**
     * Sets the value of field 'ROWCCMN05SIG01'.
     * 
     * @param ROWCCMN05SIG01 the value of field 'ROWCCMN05SIG01'.
     */
    public void setROWCCMN05SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01 ROWCCMN05SIG01)
    {
        this._ROWCCMN05SIG01 = ROWCCMN05SIG01;
    } //-- void setROWCCMN05SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01) 

    /**
     * Sets the value of field 'ROWCCMN05SIG02'.
     * 
     * @param ROWCCMN05SIG02 the value of field 'ROWCCMN05SIG02'.
     */
    public void setROWCCMN05SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02 ROWCCMN05SIG02)
    {
        this._ROWCCMN05SIG02 = ROWCCMN05SIG02;
    } //-- void setROWCCMN05SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02) 

    /**
     * Sets the value of field 'ROWCCMN05SIG02_ARRAY'.
     * 
     * @param ROWCCMN05SIG02_ARRAY the value of field
     * 'ROWCCMN05SIG02_ARRAY'.
     */
    public void setROWCCMN05SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02_ARRAY ROWCCMN05SIG02_ARRAY)
    {
        this._ROWCCMN05SIG02_ARRAY = ROWCCMN05SIG02_ARRAY;
    } //-- void setROWCCMN05SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN05SIG03_ARRAY'.
     * 
     * @param ROWCCMN05SIG03_ARRAY the value of field
     * 'ROWCCMN05SIG03_ARRAY'.
     */
    public void setROWCCMN05SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG03_ARRAY ROWCCMN05SIG03_ARRAY)
    {
        this._ROWCCMN05SIG03_ARRAY = ROWCCMN05SIG03_ARRAY;
    } //-- void setROWCCMN05SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG03_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN05SIG04'.
     * 
     * @param ROWCCMN05SIG04 the value of field 'ROWCCMN05SIG04'.
     */
    public void setROWCCMN05SIG04(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04 ROWCCMN05SIG04)
    {
        this._ROWCCMN05SIG04 = ROWCCMN05SIG04;
    } //-- void setROWCCMN05SIG04(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04) 

    /**
     * Sets the value of field 'ROWCCMN05SIG05'.
     * 
     * @param ROWCCMN05SIG05 the value of field 'ROWCCMN05SIG05'.
     */
    public void setROWCCMN05SIG05(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05 ROWCCMN05SIG05)
    {
        this._ROWCCMN05SIG05 = ROWCCMN05SIG05;
    } //-- void setROWCCMN05SIG05(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05) 

    /**
     * Sets the value of field 'ROWCCMN05SIG06'.
     * 
     * @param ROWCCMN05SIG06 the value of field 'ROWCCMN05SIG06'.
     */
    public void setROWCCMN05SIG06(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06 ROWCCMN05SIG06)
    {
        this._ROWCCMN05SIG06 = ROWCCMN05SIG06;
    } //-- void setROWCCMN05SIG06(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06) 

    /**
     * Sets the value of field 'ROWCCMN05SIG08_ARRAY'.
     * 
     * @param ROWCCMN05SIG08_ARRAY the value of field
     * 'ROWCCMN05SIG08_ARRAY'.
     */
    public void setROWCCMN05SIG08_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY ROWCCMN05SIG08_ARRAY)
    {
        this._ROWCCMN05SIG08_ARRAY = ROWCCMN05SIG08_ARRAY;
    } //-- void setROWCCMN05SIG08_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN05SIG09_ARRAY'.
     * 
     * @param ROWCCMN05SIG09_ARRAY the value of field
     * 'ROWCCMN05SIG09_ARRAY'.
     */
    public void setROWCCMN05SIG09_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY ROWCCMN05SIG09_ARRAY)
    {
        this._ROWCCMN05SIG09_ARRAY = ROWCCMN05SIG09_ARRAY;
    } //-- void setROWCCMN05SIG09_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY) 

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
     * Sets the value of field 'ulIdEmployee'.
     * 
     * @param ulIdEmployee the value of field 'ulIdEmployee'.
     */
    public void setUlIdEmployee(int ulIdEmployee)
    {
        this._ulIdEmployee = ulIdEmployee;
        this._has_ulIdEmployee = true;
    } //-- void setUlIdEmployee(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI unmarshal(java.io.Reader) 

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
