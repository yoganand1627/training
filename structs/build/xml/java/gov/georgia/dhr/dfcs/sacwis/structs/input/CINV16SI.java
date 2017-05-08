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
 * Class CINV16SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV16SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bIndChkd
     */
    private java.lang.String _bIndChkd;

    /**
     * Field _ROWCINV14DOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00 _ROWCINV14DOG00;

    /**
     * Field _ROWCINV14SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00 _ROWCINV14SOG00;

    /**
     * Field _ROWCCMN45DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO _ROWCCMN45DO;

    /**
     * Field _ROWCINV10DOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00 _ROWCINV10DOG00;

    /**
     * Field _ROWCINV10DOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01 _ROWCINV10DOG01;

    /**
     * Field _ulIdPersonSupervisor
     */
    private int _ulIdPersonSupervisor;

    /**
     * keeps track of state for field: _ulIdPersonSupervisor
     */
    private boolean _has_ulIdPersonSupervisor;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV16SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPersonSupervisor()
    {
        this._has_ulIdPersonSupervisor= false;
    } //-- void deleteUlIdPersonSupervisor() 

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
     * Returns the value of field 'bIndChkd'.
     * 
     * @return the value of field 'BIndChkd'.
     */
    public java.lang.String getBIndChkd()
    {
        return this._bIndChkd;
    } //-- java.lang.String getBIndChkd() 

    /**
     * Returns the value of field 'ROWCCMN45DO'.
     * 
     * @return the value of field 'ROWCCMN45DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO getROWCCMN45DO()
    {
        return this._ROWCCMN45DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO getROWCCMN45DO() 

    /**
     * Returns the value of field 'ROWCINV10DOG00'.
     * 
     * @return the value of field 'ROWCINV10DOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00 getROWCINV10DOG00()
    {
        return this._ROWCINV10DOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00 getROWCINV10DOG00() 

    /**
     * Returns the value of field 'ROWCINV10DOG01'.
     * 
     * @return the value of field 'ROWCINV10DOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01 getROWCINV10DOG01()
    {
        return this._ROWCINV10DOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01 getROWCINV10DOG01() 

    /**
     * Returns the value of field 'ROWCINV14DOG00'.
     * 
     * @return the value of field 'ROWCINV14DOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00 getROWCINV14DOG00()
    {
        return this._ROWCINV14DOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00 getROWCINV14DOG00() 

    /**
     * Returns the value of field 'ROWCINV14SOG00'.
     * 
     * @return the value of field 'ROWCINV14SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00 getROWCINV14SOG00()
    {
        return this._ROWCINV14SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00 getROWCINV14SOG00() 

    /**
     * Returns the value of field 'ulIdPersonSupervisor'.
     * 
     * @return the value of field 'UlIdPersonSupervisor'.
     */
    public int getUlIdPersonSupervisor()
    {
        return this._ulIdPersonSupervisor;
    } //-- int getUlIdPersonSupervisor() 

    /**
     * Method hasUlIdPersonSupervisor
     * 
     * 
     * 
     * @return true if at least one UlIdPersonSupervisor has been
     * added
     */
    public boolean hasUlIdPersonSupervisor()
    {
        return this._has_ulIdPersonSupervisor;
    } //-- boolean hasUlIdPersonSupervisor() 

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
     * Sets the value of field 'bIndChkd'.
     * 
     * @param bIndChkd the value of field 'bIndChkd'.
     */
    public void setBIndChkd(java.lang.String bIndChkd)
    {
        this._bIndChkd = bIndChkd;
    } //-- void setBIndChkd(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN45DO'.
     * 
     * @param ROWCCMN45DO the value of field 'ROWCCMN45DO'.
     */
    public void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO ROWCCMN45DO)
    {
        this._ROWCCMN45DO = ROWCCMN45DO;
    } //-- void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO) 

    /**
     * Sets the value of field 'ROWCINV10DOG00'.
     * 
     * @param ROWCINV10DOG00 the value of field 'ROWCINV10DOG00'.
     */
    public void setROWCINV10DOG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00 ROWCINV10DOG00)
    {
        this._ROWCINV10DOG00 = ROWCINV10DOG00;
    } //-- void setROWCINV10DOG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00) 

    /**
     * Sets the value of field 'ROWCINV10DOG01'.
     * 
     * @param ROWCINV10DOG01 the value of field 'ROWCINV10DOG01'.
     */
    public void setROWCINV10DOG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01 ROWCINV10DOG01)
    {
        this._ROWCINV10DOG01 = ROWCINV10DOG01;
    } //-- void setROWCINV10DOG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01) 

    /**
     * Sets the value of field 'ROWCINV14DOG00'.
     * 
     * @param ROWCINV14DOG00 the value of field 'ROWCINV14DOG00'.
     */
    public void setROWCINV14DOG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00 ROWCINV14DOG00)
    {
        this._ROWCINV14DOG00 = ROWCINV14DOG00;
    } //-- void setROWCINV14DOG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00) 

    /**
     * Sets the value of field 'ROWCINV14SOG00'.
     * 
     * @param ROWCINV14SOG00 the value of field 'ROWCINV14SOG00'.
     */
    public void setROWCINV14SOG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00 ROWCINV14SOG00)
    {
        this._ROWCINV14SOG00 = ROWCINV14SOG00;
    } //-- void setROWCINV14SOG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00) 

    /**
     * Sets the value of field 'ulIdPersonSupervisor'.
     * 
     * @param ulIdPersonSupervisor the value of field
     * 'ulIdPersonSupervisor'.
     */
    public void setUlIdPersonSupervisor(int ulIdPersonSupervisor)
    {
        this._ulIdPersonSupervisor = ulIdPersonSupervisor;
        this._has_ulIdPersonSupervisor = true;
    } //-- void setUlIdPersonSupervisor(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI unmarshal(java.io.Reader) 

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
