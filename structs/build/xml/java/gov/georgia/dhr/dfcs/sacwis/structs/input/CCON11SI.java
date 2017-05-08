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
 * Class CCON11SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON11SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _ulNbrCnperPeriod
     */
    private int _ulNbrCnperPeriod;

    /**
     * keeps track of state for field: _ulNbrCnperPeriod
     */
    private boolean _has_ulNbrCnperPeriod;

    /**
     * Field _ulNbrCnverVersion
     */
    private int _ulNbrCnverVersion;

    /**
     * keeps track of state for field: _ulNbrCnverVersion
     */
    private boolean _has_ulNbrCnverVersion;

    /**
     * Field _ulPageSizeNbr
     */
    private int _ulPageSizeNbr;

    /**
     * keeps track of state for field: _ulPageSizeNbr
     */
    private boolean _has_ulPageSizeNbr;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON11SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI()


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
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlNbrCnperPeriod()
    {
        this._has_ulNbrCnperPeriod= false;
    } //-- void deleteUlNbrCnperPeriod() 

    /**
     */
    public void deleteUlNbrCnverVersion()
    {
        this._has_ulNbrCnverVersion= false;
    } //-- void deleteUlNbrCnverVersion() 

    /**
     */
    public void deleteUlPageSizeNbr()
    {
        this._has_ulPageSizeNbr= false;
    } //-- void deleteUlPageSizeNbr() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulNbrCnperPeriod'.
     * 
     * @return the value of field 'UlNbrCnperPeriod'.
     */
    public int getUlNbrCnperPeriod()
    {
        return this._ulNbrCnperPeriod;
    } //-- int getUlNbrCnperPeriod() 

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
     * Returns the value of field 'ulPageSizeNbr'.
     * 
     * @return the value of field 'UlPageSizeNbr'.
     */
    public int getUlPageSizeNbr()
    {
        return this._ulPageSizeNbr;
    } //-- int getUlPageSizeNbr() 

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
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

    /**
     * Method hasUlNbrCnperPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCnperPeriod has been added
     */
    public boolean hasUlNbrCnperPeriod()
    {
        return this._has_ulNbrCnperPeriod;
    } //-- boolean hasUlNbrCnperPeriod() 

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
     * Method hasUlPageSizeNbr
     * 
     * 
     * 
     * @return true if at least one UlPageSizeNbr has been added
     */
    public boolean hasUlPageSizeNbr()
    {
        return this._has_ulPageSizeNbr;
    } //-- boolean hasUlPageSizeNbr() 

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
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

    /**
     * Sets the value of field 'ulNbrCnperPeriod'.
     * 
     * @param ulNbrCnperPeriod the value of field 'ulNbrCnperPeriod'
     */
    public void setUlNbrCnperPeriod(int ulNbrCnperPeriod)
    {
        this._ulNbrCnperPeriod = ulNbrCnperPeriod;
        this._has_ulNbrCnperPeriod = true;
    } //-- void setUlNbrCnperPeriod(int) 

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
     * Sets the value of field 'ulPageSizeNbr'.
     * 
     * @param ulPageSizeNbr the value of field 'ulPageSizeNbr'.
     */
    public void setUlPageSizeNbr(int ulPageSizeNbr)
    {
        this._ulPageSizeNbr = ulPageSizeNbr;
        this._has_ulPageSizeNbr = true;
    } //-- void setUlPageSizeNbr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI unmarshal(java.io.Reader) 

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
