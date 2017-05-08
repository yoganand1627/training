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
 * Class CCMN80SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN80SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bMoreDataInd2
     */
    private java.lang.String _bMoreDataInd2;

    /**
     * Field _ulRowQty2
     */
    private int _ulRowQty2;

    /**
     * keeps track of state for field: _ulRowQty2
     */
    private boolean _has_ulRowQty2;

    /**
     * Field _explan_code
     */
    private int _explan_code;

    /**
     * keeps track of state for field: _explan_code
     */
    private boolean _has_explan_code;

    /**
     * Field _szNmCase
     */
    private java.lang.String _szNmCase;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _ROWCCMN79DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO _ROWCCMN79DO;

    /**
     * Field _assignmentGroup_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY _assignmentGroup_ARRAY;

    /**
     * Field _availStaffGroup_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY _availStaffGroup_ARRAY;

    /**
     * Field _ROWCCMN79DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY _ROWCCMN79DO_ARRAY;

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

    public CCMN80SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO()


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
    public void deleteExplan_code()
    {
        this._has_explan_code= false;
    } //-- void deleteExplan_code() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     */
    public void deleteUlRowQty2()
    {
        this._has_ulRowQty2= false;
    } //-- void deleteUlRowQty2() 

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
     * Returns the value of field 'assignmentGroup_ARRAY'.
     * 
     * @return the value of field 'AssignmentGroup_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY getAssignmentGroup_ARRAY()
    {
        return this._assignmentGroup_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY getAssignmentGroup_ARRAY() 

    /**
     * Returns the value of field 'availStaffGroup_ARRAY'.
     * 
     * @return the value of field 'AvailStaffGroup_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY getAvailStaffGroup_ARRAY()
    {
        return this._availStaffGroup_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY getAvailStaffGroup_ARRAY() 

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
     * Returns the value of field 'bMoreDataInd2'.
     * 
     * @return the value of field 'BMoreDataInd2'.
     */
    public java.lang.String getBMoreDataInd2()
    {
        return this._bMoreDataInd2;
    } //-- java.lang.String getBMoreDataInd2() 

    /**
     * Returns the value of field 'explan_code'.
     * 
     * @return the value of field 'Explan_code'.
     */
    public int getExplan_code()
    {
        return this._explan_code;
    } //-- int getExplan_code() 

    /**
     * Returns the value of field 'ROWCCMN79DO'.
     * 
     * @return the value of field 'ROWCCMN79DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO getROWCCMN79DO()
    {
        return this._ROWCCMN79DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO getROWCCMN79DO() 

    /**
     * Returns the value of field 'ROWCCMN79DO_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN79DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY getROWCCMN79DO_ARRAY()
    {
        return this._ROWCCMN79DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY getROWCCMN79DO_ARRAY() 

    /**
     * Returns the value of field 'szNmCase'.
     * 
     * @return the value of field 'SzNmCase'.
     */
    public java.lang.String getSzNmCase()
    {
        return this._szNmCase;
    } //-- java.lang.String getSzNmCase() 

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
     * Returns the value of field 'ulRowQty2'.
     * 
     * @return the value of field 'UlRowQty2'.
     */
    public int getUlRowQty2()
    {
        return this._ulRowQty2;
    } //-- int getUlRowQty2() 

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
     * Method hasExplan_code
     * 
     * 
     * 
     * @return true if at least one Explan_code has been added
     */
    public boolean hasExplan_code()
    {
        return this._has_explan_code;
    } //-- boolean hasExplan_code() 

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
     * Method hasUlRowQty2
     * 
     * 
     * 
     * @return true if at least one UlRowQty2 has been added
     */
    public boolean hasUlRowQty2()
    {
        return this._has_ulRowQty2;
    } //-- boolean hasUlRowQty2() 

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
     * Sets the value of field 'assignmentGroup_ARRAY'.
     * 
     * @param assignmentGroup_ARRAY the value of field
     * 'assignmentGroup_ARRAY'.
     */
    public void setAssignmentGroup_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY assignmentGroup_ARRAY)
    {
        this._assignmentGroup_ARRAY = assignmentGroup_ARRAY;
    } //-- void setAssignmentGroup_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY) 

    /**
     * Sets the value of field 'availStaffGroup_ARRAY'.
     * 
     * @param availStaffGroup_ARRAY the value of field
     * 'availStaffGroup_ARRAY'.
     */
    public void setAvailStaffGroup_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY availStaffGroup_ARRAY)
    {
        this._availStaffGroup_ARRAY = availStaffGroup_ARRAY;
    } //-- void setAvailStaffGroup_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY) 

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
     * Sets the value of field 'bMoreDataInd2'.
     * 
     * @param bMoreDataInd2 the value of field 'bMoreDataInd2'.
     */
    public void setBMoreDataInd2(java.lang.String bMoreDataInd2)
    {
        this._bMoreDataInd2 = bMoreDataInd2;
    } //-- void setBMoreDataInd2(java.lang.String) 

    /**
     * Sets the value of field 'explan_code'.
     * 
     * @param explan_code the value of field 'explan_code'.
     */
    public void setExplan_code(int explan_code)
    {
        this._explan_code = explan_code;
        this._has_explan_code = true;
    } //-- void setExplan_code(int) 

    /**
     * Sets the value of field 'ROWCCMN79DO'.
     * 
     * @param ROWCCMN79DO the value of field 'ROWCCMN79DO'.
     */
    public void setROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO ROWCCMN79DO)
    {
        this._ROWCCMN79DO = ROWCCMN79DO;
    } //-- void setROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) 

    /**
     * Sets the value of field 'ROWCCMN79DO_ARRAY'.
     * 
     * @param ROWCCMN79DO_ARRAY the value of field
     * 'ROWCCMN79DO_ARRAY'.
     */
    public void setROWCCMN79DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY ROWCCMN79DO_ARRAY)
    {
        this._ROWCCMN79DO_ARRAY = ROWCCMN79DO_ARRAY;
    } //-- void setROWCCMN79DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY) 

    /**
     * Sets the value of field 'szNmCase'.
     * 
     * @param szNmCase the value of field 'szNmCase'.
     */
    public void setSzNmCase(java.lang.String szNmCase)
    {
        this._szNmCase = szNmCase;
    } //-- void setSzNmCase(java.lang.String) 

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
     * Sets the value of field 'ulRowQty2'.
     * 
     * @param ulRowQty2 the value of field 'ulRowQty2'.
     */
    public void setUlRowQty2(int ulRowQty2)
    {
        this._ulRowQty2 = ulRowQty2;
        this._has_ulRowQty2 = true;
    } //-- void setUlRowQty2(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO unmarshal(java.io.Reader) 

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
