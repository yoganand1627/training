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
 * Class CCMN80SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN80SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _szCdOnCallProgram
     */
    private java.lang.String _szCdOnCallProgram;

    /**
     * Field _szCdOnCallCounty
     */
    private java.lang.String _szCdOnCallCounty;

    /**
     * Field _szCdRegion
     */
    private java.lang.String _szCdRegion;

    /**
     * Field _ulPageSizeNbr
     */
    private int _ulPageSizeNbr;

    /**
     * keeps track of state for field: _ulPageSizeNbr
     */
    private boolean _has_ulPageSizeNbr;

    /**
     * Field _ulIdStage_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdStage_ARRAY _ulIdStage_ARRAY;

    /**
     * Field _bIndStaffSearch
     */
    private boolean _bIndStaffSearch;

    /**
     * keeps track of state for field: _bIndStaffSearch
     */
    private boolean _has_bIndStaffSearch;

    /**
     * Field _indMesProgramAssistant
     */
    private boolean _indMesProgramAssistant;

    /**
     * keeps track of state for field: _indMesProgramAssistant
     */
    private boolean _has_indMesProgramAssistant;

    /**
     * Field _szCdUserCounty
     */
    private java.lang.String _szCdUserCounty;

    /**
     * Field _szCdUserRegion
     */
    private java.lang.String _szCdUserRegion;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN80SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndStaffSearch()
    {
        this._has_bIndStaffSearch= false;
    } //-- void deleteBIndStaffSearch() 

    /**
     */
    public void deleteIndMesProgramAssistant()
    {
        this._has_indMesProgramAssistant= false;
    } //-- void deleteIndMesProgramAssistant() 

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
    public void deleteUlPageSizeNbr()
    {
        this._has_ulPageSizeNbr= false;
    } //-- void deleteUlPageSizeNbr() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

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
     * Returns the value of field 'bIndStaffSearch'.
     * 
     * @return the value of field 'BIndStaffSearch'.
     */
    public boolean getBIndStaffSearch()
    {
        return this._bIndStaffSearch;
    } //-- boolean getBIndStaffSearch() 

    /**
     * Returns the value of field 'indMesProgramAssistant'.
     * 
     * @return the value of field 'IndMesProgramAssistant'.
     */
    public boolean getIndMesProgramAssistant()
    {
        return this._indMesProgramAssistant;
    } //-- boolean getIndMesProgramAssistant() 

    /**
     * Returns the value of field 'szCdOnCallCounty'.
     * 
     * @return the value of field 'SzCdOnCallCounty'.
     */
    public java.lang.String getSzCdOnCallCounty()
    {
        return this._szCdOnCallCounty;
    } //-- java.lang.String getSzCdOnCallCounty() 

    /**
     * Returns the value of field 'szCdOnCallProgram'.
     * 
     * @return the value of field 'SzCdOnCallProgram'.
     */
    public java.lang.String getSzCdOnCallProgram()
    {
        return this._szCdOnCallProgram;
    } //-- java.lang.String getSzCdOnCallProgram() 

    /**
     * Returns the value of field 'szCdRegion'.
     * 
     * @return the value of field 'SzCdRegion'.
     */
    public java.lang.String getSzCdRegion()
    {
        return this._szCdRegion;
    } //-- java.lang.String getSzCdRegion() 

    /**
     * Returns the value of field 'szCdUserCounty'.
     * 
     * @return the value of field 'SzCdUserCounty'.
     */
    public java.lang.String getSzCdUserCounty()
    {
        return this._szCdUserCounty;
    } //-- java.lang.String getSzCdUserCounty() 

    /**
     * Returns the value of field 'szCdUserRegion'.
     * 
     * @return the value of field 'SzCdUserRegion'.
     */
    public java.lang.String getSzCdUserRegion()
    {
        return this._szCdUserRegion;
    } //-- java.lang.String getSzCdUserRegion() 

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
     * Returns the value of field 'ulIdStage_ARRAY'.
     * 
     * @return the value of field 'UlIdStage_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdStage_ARRAY getUlIdStage_ARRAY()
    {
        return this._ulIdStage_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdStage_ARRAY getUlIdStage_ARRAY() 

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
     * Returns the value of field 'ulPageSizeNbr'.
     * 
     * @return the value of field 'UlPageSizeNbr'.
     */
    public int getUlPageSizeNbr()
    {
        return this._ulPageSizeNbr;
    } //-- int getUlPageSizeNbr() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Method hasBIndStaffSearch
     * 
     * 
     * 
     * @return true if at least one BIndStaffSearch has been added
     */
    public boolean hasBIndStaffSearch()
    {
        return this._has_bIndStaffSearch;
    } //-- boolean hasBIndStaffSearch() 

    /**
     * Method hasIndMesProgramAssistant
     * 
     * 
     * 
     * @return true if at least one IndMesProgramAssistant has been
     * added
     */
    public boolean hasIndMesProgramAssistant()
    {
        return this._has_indMesProgramAssistant;
    } //-- boolean hasIndMesProgramAssistant() 

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
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

    /**
     * Returns the value of field 'bIndStaffSearch'.
     * 
     * @return the value of field 'BIndStaffSearch'.
     */
    public boolean isBIndStaffSearch()
    {
        return this._bIndStaffSearch;
    } //-- boolean isBIndStaffSearch() 

    /**
     * Returns the value of field 'indMesProgramAssistant'.
     * 
     * @return the value of field 'IndMesProgramAssistant'.
     */
    public boolean isIndMesProgramAssistant()
    {
        return this._indMesProgramAssistant;
    } //-- boolean isIndMesProgramAssistant() 

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
     * Sets the value of field 'bIndStaffSearch'.
     * 
     * @param bIndStaffSearch the value of field 'bIndStaffSearch'.
     */
    public void setBIndStaffSearch(boolean bIndStaffSearch)
    {
        this._bIndStaffSearch = bIndStaffSearch;
        this._has_bIndStaffSearch = true;
    } //-- void setBIndStaffSearch(boolean) 

    /**
     * Sets the value of field 'indMesProgramAssistant'.
     * 
     * @param indMesProgramAssistant the value of field
     * 'indMesProgramAssistant'.
     */
    public void setIndMesProgramAssistant(boolean indMesProgramAssistant)
    {
        this._indMesProgramAssistant = indMesProgramAssistant;
        this._has_indMesProgramAssistant = true;
    } //-- void setIndMesProgramAssistant(boolean) 

    /**
     * Sets the value of field 'szCdOnCallCounty'.
     * 
     * @param szCdOnCallCounty the value of field 'szCdOnCallCounty'
     */
    public void setSzCdOnCallCounty(java.lang.String szCdOnCallCounty)
    {
        this._szCdOnCallCounty = szCdOnCallCounty;
    } //-- void setSzCdOnCallCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdOnCallProgram'.
     * 
     * @param szCdOnCallProgram the value of field
     * 'szCdOnCallProgram'.
     */
    public void setSzCdOnCallProgram(java.lang.String szCdOnCallProgram)
    {
        this._szCdOnCallProgram = szCdOnCallProgram;
    } //-- void setSzCdOnCallProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdRegion'.
     * 
     * @param szCdRegion the value of field 'szCdRegion'.
     */
    public void setSzCdRegion(java.lang.String szCdRegion)
    {
        this._szCdRegion = szCdRegion;
    } //-- void setSzCdRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdUserCounty'.
     * 
     * @param szCdUserCounty the value of field 'szCdUserCounty'.
     */
    public void setSzCdUserCounty(java.lang.String szCdUserCounty)
    {
        this._szCdUserCounty = szCdUserCounty;
    } //-- void setSzCdUserCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdUserRegion'.
     * 
     * @param szCdUserRegion the value of field 'szCdUserRegion'.
     */
    public void setSzCdUserRegion(java.lang.String szCdUserRegion)
    {
        this._szCdUserRegion = szCdUserRegion;
    } //-- void setSzCdUserRegion(java.lang.String) 

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
     * Sets the value of field 'ulIdStage_ARRAY'.
     * 
     * @param ulIdStage_ARRAY the value of field 'ulIdStage_ARRAY'.
     */
    public void setUlIdStage_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdStage_ARRAY ulIdStage_ARRAY)
    {
        this._ulIdStage_ARRAY = ulIdStage_ARRAY;
    } //-- void setUlIdStage_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdStage_ARRAY) 

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
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI unmarshal(java.io.Reader) 

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
