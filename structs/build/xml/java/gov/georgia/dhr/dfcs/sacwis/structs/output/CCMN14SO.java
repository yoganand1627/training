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
 * Class CCMN14SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN14SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bSysIndSupervisor
     */
    private java.lang.String _bSysIndSupervisor;

    /**
     * Field _ROWCCMN37DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY _ROWCCMN37DO_ARRAY;

    /**
     * Field _ulWorkloadCount
     */
    private int _ulWorkloadCount;

    /**
     * keeps track of state for field: _ulWorkloadCount
     */
    private boolean _has_ulWorkloadCount;

    /**
     * Field _bIndOverPolicyLimit
     */
    private boolean _bIndOverPolicyLimit;

    /**
     * keeps track of state for field: _bIndOverPolicyLimit
     */
    private boolean _has_bIndOverPolicyLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN14SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndOverPolicyLimit()
    {
        this._has_bIndOverPolicyLimit= false;
    } //-- void deleteBIndOverPolicyLimit() 

    /**
     */
    public void deleteUlWorkloadCount()
    {
        this._has_ulWorkloadCount= false;
    } //-- void deleteUlWorkloadCount() 

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
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean getBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean getBIndOverPolicyLimit() 

    /**
     * Returns the value of field 'bSysIndSupervisor'.
     * 
     * @return the value of field 'BSysIndSupervisor'.
     */
    public java.lang.String getBSysIndSupervisor()
    {
        return this._bSysIndSupervisor;
    } //-- java.lang.String getBSysIndSupervisor() 

    /**
     * Returns the value of field 'ROWCCMN37DO_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN37DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY getROWCCMN37DO_ARRAY()
    {
        return this._ROWCCMN37DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY getROWCCMN37DO_ARRAY() 

    /**
     * Returns the value of field 'ulWorkloadCount'.
     * 
     * @return the value of field 'UlWorkloadCount'.
     */
    public int getUlWorkloadCount()
    {
        return this._ulWorkloadCount;
    } //-- int getUlWorkloadCount() 

    /**
     * Method hasBIndOverPolicyLimit
     * 
     * 
     * 
     * @return true if at least one BIndOverPolicyLimit has been
     * added
     */
    public boolean hasBIndOverPolicyLimit()
    {
        return this._has_bIndOverPolicyLimit;
    } //-- boolean hasBIndOverPolicyLimit() 

    /**
     * Method hasUlWorkloadCount
     * 
     * 
     * 
     * @return true if at least one UlWorkloadCount has been added
     */
    public boolean hasUlWorkloadCount()
    {
        return this._has_ulWorkloadCount;
    } //-- boolean hasUlWorkloadCount() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean isBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean isBIndOverPolicyLimit() 

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
     * Sets the value of field 'bIndOverPolicyLimit'.
     * 
     * @param bIndOverPolicyLimit the value of field
     * 'bIndOverPolicyLimit'.
     */
    public void setBIndOverPolicyLimit(boolean bIndOverPolicyLimit)
    {
        this._bIndOverPolicyLimit = bIndOverPolicyLimit;
        this._has_bIndOverPolicyLimit = true;
    } //-- void setBIndOverPolicyLimit(boolean) 

    /**
     * Sets the value of field 'bSysIndSupervisor'.
     * 
     * @param bSysIndSupervisor the value of field
     * 'bSysIndSupervisor'.
     */
    public void setBSysIndSupervisor(java.lang.String bSysIndSupervisor)
    {
        this._bSysIndSupervisor = bSysIndSupervisor;
    } //-- void setBSysIndSupervisor(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN37DO_ARRAY'.
     * 
     * @param ROWCCMN37DO_ARRAY the value of field
     * 'ROWCCMN37DO_ARRAY'.
     */
    public void setROWCCMN37DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY ROWCCMN37DO_ARRAY)
    {
        this._ROWCCMN37DO_ARRAY = ROWCCMN37DO_ARRAY;
    } //-- void setROWCCMN37DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY) 

    /**
     * Sets the value of field 'ulWorkloadCount'.
     * 
     * @param ulWorkloadCount the value of field 'ulWorkloadCount'.
     */
    public void setUlWorkloadCount(int ulWorkloadCount)
    {
        this._ulWorkloadCount = ulWorkloadCount;
        this._has_ulWorkloadCount = true;
    } //-- void setUlWorkloadCount(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO unmarshal(java.io.Reader) 

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
