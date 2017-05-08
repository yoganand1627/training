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
 * Class CCON09SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON09SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulNbrCnverPeriod
     */
    private int _ulNbrCnverPeriod;

    /**
     * keeps track of state for field: _ulNbrCnverPeriod
     */
    private boolean _has_ulNbrCnverPeriod;

    /**
     * Field _ulNbrCnverVersion
     */
    private int _ulNbrCnverVersion;

    /**
     * keeps track of state for field: _ulNbrCnverVersion
     */
    private boolean _has_ulNbrCnverVersion;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON09SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlNbrCnverPeriod()
    {
        this._has_ulNbrCnverPeriod= false;
    } //-- void deleteUlNbrCnverPeriod() 

    /**
     */
    public void deleteUlNbrCnverVersion()
    {
        this._has_ulNbrCnverVersion= false;
    } //-- void deleteUlNbrCnverVersion() 

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
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

    /**
     * Returns the value of field 'ulNbrCnverPeriod'.
     * 
     * @return the value of field 'UlNbrCnverPeriod'.
     */
    public int getUlNbrCnverPeriod()
    {
        return this._ulNbrCnverPeriod;
    } //-- int getUlNbrCnverPeriod() 

    /**
     * Returns the value of field 'ulNbrCnverVersion'.
     * 
     * @return the value of field 'UlNbrCnverVersion'.
     */
    public int getUlNbrCnverVersion()
    {
        return this._ulNbrCnverVersion;
    } //-- int getUlNbrCnverVersion() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

    /**
     * Method hasUlNbrCnverPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverPeriod has been added
     */
    public boolean hasUlNbrCnverPeriod()
    {
        return this._has_ulNbrCnverPeriod;
    } //-- boolean hasUlNbrCnverPeriod() 

    /**
     * Method hasUlNbrCnverVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverVersion has been added
     */
    public boolean hasUlNbrCnverVersion()
    {
        return this._has_ulNbrCnverVersion;
    } //-- boolean hasUlNbrCnverVersion() 

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
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

    /**
     * Sets the value of field 'ulNbrCnverPeriod'.
     * 
     * @param ulNbrCnverPeriod the value of field 'ulNbrCnverPeriod'
     */
    public void setUlNbrCnverPeriod(int ulNbrCnverPeriod)
    {
        this._ulNbrCnverPeriod = ulNbrCnverPeriod;
        this._has_ulNbrCnverPeriod = true;
    } //-- void setUlNbrCnverPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCnverVersion'.
     * 
     * @param ulNbrCnverVersion the value of field
     * 'ulNbrCnverVersion'.
     */
    public void setUlNbrCnverVersion(int ulNbrCnverVersion)
    {
        this._ulNbrCnverVersion = ulNbrCnverVersion;
        this._has_ulNbrCnverVersion = true;
    } //-- void setUlNbrCnverVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI unmarshal(java.io.Reader) 

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
