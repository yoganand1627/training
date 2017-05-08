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
 * Class CCMN37SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN37SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN37SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01 _ROWCCMN37SOG01;

    /**
     * Field _ROWCCMN37SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY _ROWCCMN37SOG02_ARRAY;

    /**
     * Field _STFFASSGNMTHIST_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY _STFFASSGNMTHIST_ARRAY;

    /**
     * Field _bIndPadCase
     */
    private java.lang.String _bIndPadCase;

    /**
     * Field _ulIdAdoCase
     */
    private int _ulIdAdoCase;

    /**
     * keeps track of state for field: _ulIdAdoCase
     */
    private boolean _has_ulIdAdoCase;

    /**
     * Field _ulIdPadCase
     */
    private int _ulIdPadCase;

    /**
     * keeps track of state for field: _ulIdPadCase
     */
    private boolean _has_ulIdPadCase;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN37SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAdoCase()
    {
        this._has_ulIdAdoCase= false;
    } //-- void deleteUlIdAdoCase() 

    /**
     */
    public void deleteUlIdPadCase()
    {
        this._has_ulIdPadCase= false;
    } //-- void deleteUlIdPadCase() 

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
     * Returns the value of field 'bIndPadCase'.
     * 
     * @return the value of field 'BIndPadCase'.
     */
    public java.lang.String getBIndPadCase()
    {
        return this._bIndPadCase;
    } //-- java.lang.String getBIndPadCase() 

    /**
     * Returns the value of field 'ROWCCMN37SOG01'.
     * 
     * @return the value of field 'ROWCCMN37SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01 getROWCCMN37SOG01()
    {
        return this._ROWCCMN37SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01 getROWCCMN37SOG01() 

    /**
     * Returns the value of field 'ROWCCMN37SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN37SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY getROWCCMN37SOG02_ARRAY()
    {
        return this._ROWCCMN37SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY getROWCCMN37SOG02_ARRAY() 

    /**
     * Returns the value of field 'STFFASSGNMTHIST_ARRAY'.
     * 
     * @return the value of field 'STFFASSGNMTHIST_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY getSTFFASSGNMTHIST_ARRAY()
    {
        return this._STFFASSGNMTHIST_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY getSTFFASSGNMTHIST_ARRAY() 

    /**
     * Returns the value of field 'ulIdAdoCase'.
     * 
     * @return the value of field 'UlIdAdoCase'.
     */
    public int getUlIdAdoCase()
    {
        return this._ulIdAdoCase;
    } //-- int getUlIdAdoCase() 

    /**
     * Returns the value of field 'ulIdPadCase'.
     * 
     * @return the value of field 'UlIdPadCase'.
     */
    public int getUlIdPadCase()
    {
        return this._ulIdPadCase;
    } //-- int getUlIdPadCase() 

    /**
     * Method hasUlIdAdoCase
     * 
     * 
     * 
     * @return true if at least one UlIdAdoCase has been added
     */
    public boolean hasUlIdAdoCase()
    {
        return this._has_ulIdAdoCase;
    } //-- boolean hasUlIdAdoCase() 

    /**
     * Method hasUlIdPadCase
     * 
     * 
     * 
     * @return true if at least one UlIdPadCase has been added
     */
    public boolean hasUlIdPadCase()
    {
        return this._has_ulIdPadCase;
    } //-- boolean hasUlIdPadCase() 

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
     * Sets the value of field 'bIndPadCase'.
     * 
     * @param bIndPadCase the value of field 'bIndPadCase'.
     */
    public void setBIndPadCase(java.lang.String bIndPadCase)
    {
        this._bIndPadCase = bIndPadCase;
    } //-- void setBIndPadCase(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN37SOG01'.
     * 
     * @param ROWCCMN37SOG01 the value of field 'ROWCCMN37SOG01'.
     */
    public void setROWCCMN37SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01 ROWCCMN37SOG01)
    {
        this._ROWCCMN37SOG01 = ROWCCMN37SOG01;
    } //-- void setROWCCMN37SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01) 

    /**
     * Sets the value of field 'ROWCCMN37SOG02_ARRAY'.
     * 
     * @param ROWCCMN37SOG02_ARRAY the value of field
     * 'ROWCCMN37SOG02_ARRAY'.
     */
    public void setROWCCMN37SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY ROWCCMN37SOG02_ARRAY)
    {
        this._ROWCCMN37SOG02_ARRAY = ROWCCMN37SOG02_ARRAY;
    } //-- void setROWCCMN37SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY) 

    /**
     * Sets the value of field 'STFFASSGNMTHIST_ARRAY'.
     * 
     * @param STFFASSGNMTHIST_ARRAY the value of field
     * 'STFFASSGNMTHIST_ARRAY'.
     */
    public void setSTFFASSGNMTHIST_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY STFFASSGNMTHIST_ARRAY)
    {
        this._STFFASSGNMTHIST_ARRAY = STFFASSGNMTHIST_ARRAY;
    } //-- void setSTFFASSGNMTHIST_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY) 

    /**
     * Sets the value of field 'ulIdAdoCase'.
     * 
     * @param ulIdAdoCase the value of field 'ulIdAdoCase'.
     */
    public void setUlIdAdoCase(int ulIdAdoCase)
    {
        this._ulIdAdoCase = ulIdAdoCase;
        this._has_ulIdAdoCase = true;
    } //-- void setUlIdAdoCase(int) 

    /**
     * Sets the value of field 'ulIdPadCase'.
     * 
     * @param ulIdPadCase the value of field 'ulIdPadCase'.
     */
    public void setUlIdPadCase(int ulIdPadCase)
    {
        this._ulIdPadCase = ulIdPadCase;
        this._has_ulIdPadCase = true;
    } //-- void setUlIdPadCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO unmarshal(java.io.Reader) 

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
