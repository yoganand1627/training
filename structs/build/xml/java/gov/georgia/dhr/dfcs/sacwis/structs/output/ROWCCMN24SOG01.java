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
 * Class ROWCCMN24SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN24SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _ulIdUnitParent
     */
    private int _ulIdUnitParent;

    /**
     * keeps track of state for field: _ulIdUnitParent
     */
    private boolean _has_ulIdUnitParent;

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
     * Field _szCdUnitSpecialization
     */
    private java.lang.String _szCdUnitSpecialization;

    /**
     * Field _szScrNbrUnitParent
     */
    private java.lang.String _szScrNbrUnitParent;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _szCdUnitCounty
     */
    private java.lang.String _szCdUnitCounty;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN24SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01()


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
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     */
    public void deleteUlIdUnitParent()
    {
        this._has_ulIdUnitParent= false;
    } //-- void deleteUlIdUnitParent() 

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
     * Returns the value of field 'szCdUnitRegion'.
     * 
     * @return the value of field 'SzCdUnitRegion'.
     */
    public java.lang.String getSzCdUnitRegion()
    {
        return this._szCdUnitRegion;
    } //-- java.lang.String getSzCdUnitRegion() 

    /**
     * Returns the value of field 'szCdUnitSpecialization'.
     * 
     * @return the value of field 'SzCdUnitSpecialization'.
     */
    public java.lang.String getSzCdUnitSpecialization()
    {
        return this._szCdUnitSpecialization;
    } //-- java.lang.String getSzCdUnitSpecialization() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szScrNbrUnitParent'.
     * 
     * @return the value of field 'SzScrNbrUnitParent'.
     */
    public java.lang.String getSzScrNbrUnitParent()
    {
        return this._szScrNbrUnitParent;
    } //-- java.lang.String getSzScrNbrUnitParent() 

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
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

    /**
     * Returns the value of field 'ulIdUnitParent'.
     * 
     * @return the value of field 'UlIdUnitParent'.
     */
    public int getUlIdUnitParent()
    {
        return this._ulIdUnitParent;
    } //-- int getUlIdUnitParent() 

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
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

    /**
     * Method hasUlIdUnitParent
     * 
     * 
     * 
     * @return true if at least one UlIdUnitParent has been added
     */
    public boolean hasUlIdUnitParent()
    {
        return this._has_ulIdUnitParent;
    } //-- boolean hasUlIdUnitParent() 

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
     * Sets the value of field 'szCdUnitCounty'.
     * 
     * @param szCdUnitCounty the value of field 'szCdUnitCounty'.
     */
    public void setSzCdUnitCounty(java.lang.String szCdUnitCounty)
    {
        this._szCdUnitCounty = szCdUnitCounty;
    } //-- void setSzCdUnitCounty(java.lang.String) 

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
     * Sets the value of field 'szCdUnitSpecialization'.
     * 
     * @param szCdUnitSpecialization the value of field
     * 'szCdUnitSpecialization'.
     */
    public void setSzCdUnitSpecialization(java.lang.String szCdUnitSpecialization)
    {
        this._szCdUnitSpecialization = szCdUnitSpecialization;
    } //-- void setSzCdUnitSpecialization(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szScrNbrUnitParent'.
     * 
     * @param szScrNbrUnitParent the value of field
     * 'szScrNbrUnitParent'.
     */
    public void setSzScrNbrUnitParent(java.lang.String szScrNbrUnitParent)
    {
        this._szScrNbrUnitParent = szScrNbrUnitParent;
    } //-- void setSzScrNbrUnitParent(java.lang.String) 

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
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

    /**
     * Sets the value of field 'ulIdUnitParent'.
     * 
     * @param ulIdUnitParent the value of field 'ulIdUnitParent'.
     */
    public void setUlIdUnitParent(int ulIdUnitParent)
    {
        this._ulIdUnitParent = ulIdUnitParent;
        this._has_ulIdUnitParent = true;
    } //-- void setUlIdUnitParent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 unmarshal(java.io.Reader) 

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
