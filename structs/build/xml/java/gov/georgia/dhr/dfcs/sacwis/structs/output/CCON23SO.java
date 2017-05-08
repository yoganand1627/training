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
 * Class CCON23SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON23SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bIndOverSpendingLimitPad
     */
    private java.lang.String _bIndOverSpendingLimitPad;

    /**
     * Field _bIndActiveNonRecurrAdopLegalFeesExists
     */
    private java.lang.String _bIndActiveNonRecurrAdopLegalFeesExists;

    /**
     * Field _bIndActiveNonRecurrTravelExists
     */
    private java.lang.String _bIndActiveNonRecurrTravelExists;

    /**
     * Field _bIndActiveNonRecurrLogMealsExists
     */
    private java.lang.String _bIndActiveNonRecurrLogMealsExists;

    /**
     * Field _bIndActiveNonRecurrPhyAdopParentExists
     */
    private java.lang.String _bIndActiveNonRecurrPhyAdopParentExists;

    /**
     * Field _dAmtActiveNonRecurrAdopLegalFees
     */
    private double _dAmtActiveNonRecurrAdopLegalFees;

    /**
     * keeps track of state for field:
     * _dAmtActiveNonRecurrAdopLegalFees
     */
    private boolean _has_dAmtActiveNonRecurrAdopLegalFees;

    /**
     * Field _dAmtActiveNonRecurrPhyAdopParent
     */
    private double _dAmtActiveNonRecurrPhyAdopParent;

    /**
     * keeps track of state for field:
     * _dAmtActiveNonRecurrPhyAdopParent
     */
    private boolean _has_dAmtActiveNonRecurrPhyAdopParent;

    /**
     * Field _dAmtActiveNonRecurrLogMeals
     */
    private double _dAmtActiveNonRecurrLogMeals;

    /**
     * keeps track of state for field: _dAmtActiveNonRecurrLogMeals
     */
    private boolean _has_dAmtActiveNonRecurrLogMeals;

    /**
     * Field _dAmtActiveNonRecurrTravel
     */
    private double _dAmtActiveNonRecurrTravel;

    /**
     * keeps track of state for field: _dAmtActiveNonRecurrTravel
     */
    private boolean _has_dAmtActiveNonRecurrTravel;

    /**
     * Field _dAmtNonRecLimit
     */
    private double _dAmtNonRecLimit;

    /**
     * keeps track of state for field: _dAmtNonRecLimit
     */
    private boolean _has_dAmtNonRecLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON23SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtActiveNonRecurrAdopLegalFees()
    {
        this._has_dAmtActiveNonRecurrAdopLegalFees= false;
    } //-- void deleteDAmtActiveNonRecurrAdopLegalFees() 

    /**
     */
    public void deleteDAmtActiveNonRecurrLogMeals()
    {
        this._has_dAmtActiveNonRecurrLogMeals= false;
    } //-- void deleteDAmtActiveNonRecurrLogMeals() 

    /**
     */
    public void deleteDAmtActiveNonRecurrPhyAdopParent()
    {
        this._has_dAmtActiveNonRecurrPhyAdopParent= false;
    } //-- void deleteDAmtActiveNonRecurrPhyAdopParent() 

    /**
     */
    public void deleteDAmtActiveNonRecurrTravel()
    {
        this._has_dAmtActiveNonRecurrTravel= false;
    } //-- void deleteDAmtActiveNonRecurrTravel() 

    /**
     */
    public void deleteDAmtNonRecLimit()
    {
        this._has_dAmtNonRecLimit= false;
    } //-- void deleteDAmtNonRecLimit() 

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
     * Returns the value of field
     * 'bIndActiveNonRecurrAdopLegalFeesExists'.
     * 
     * @return the value of field
     * 'BIndActiveNonRecurrAdopLegalFeesExists'.
     */
    public java.lang.String getBIndActiveNonRecurrAdopLegalFeesExists()
    {
        return this._bIndActiveNonRecurrAdopLegalFeesExists;
    } //-- java.lang.String getBIndActiveNonRecurrAdopLegalFeesExists() 

    /**
     * Returns the value of field
     * 'bIndActiveNonRecurrLogMealsExists'.
     * 
     * @return the value of field
     * 'BIndActiveNonRecurrLogMealsExists'.
     */
    public java.lang.String getBIndActiveNonRecurrLogMealsExists()
    {
        return this._bIndActiveNonRecurrLogMealsExists;
    } //-- java.lang.String getBIndActiveNonRecurrLogMealsExists() 

    /**
     * Returns the value of field
     * 'bIndActiveNonRecurrPhyAdopParentExists'.
     * 
     * @return the value of field
     * 'BIndActiveNonRecurrPhyAdopParentExists'.
     */
    public java.lang.String getBIndActiveNonRecurrPhyAdopParentExists()
    {
        return this._bIndActiveNonRecurrPhyAdopParentExists;
    } //-- java.lang.String getBIndActiveNonRecurrPhyAdopParentExists() 

    /**
     * Returns the value of field
     * 'bIndActiveNonRecurrTravelExists'.
     * 
     * @return the value of field 'BIndActiveNonRecurrTravelExists'.
     */
    public java.lang.String getBIndActiveNonRecurrTravelExists()
    {
        return this._bIndActiveNonRecurrTravelExists;
    } //-- java.lang.String getBIndActiveNonRecurrTravelExists() 

    /**
     * Returns the value of field 'bIndOverSpendingLimitPad'.
     * 
     * @return the value of field 'BIndOverSpendingLimitPad'.
     */
    public java.lang.String getBIndOverSpendingLimitPad()
    {
        return this._bIndOverSpendingLimitPad;
    } //-- java.lang.String getBIndOverSpendingLimitPad() 

    /**
     * Returns the value of field
     * 'dAmtActiveNonRecurrAdopLegalFees'.
     * 
     * @return the value of field 'DAmtActiveNonRecurrAdopLegalFees'
     */
    public double getDAmtActiveNonRecurrAdopLegalFees()
    {
        return this._dAmtActiveNonRecurrAdopLegalFees;
    } //-- double getDAmtActiveNonRecurrAdopLegalFees() 

    /**
     * Returns the value of field 'dAmtActiveNonRecurrLogMeals'.
     * 
     * @return the value of field 'DAmtActiveNonRecurrLogMeals'.
     */
    public double getDAmtActiveNonRecurrLogMeals()
    {
        return this._dAmtActiveNonRecurrLogMeals;
    } //-- double getDAmtActiveNonRecurrLogMeals() 

    /**
     * Returns the value of field
     * 'dAmtActiveNonRecurrPhyAdopParent'.
     * 
     * @return the value of field 'DAmtActiveNonRecurrPhyAdopParent'
     */
    public double getDAmtActiveNonRecurrPhyAdopParent()
    {
        return this._dAmtActiveNonRecurrPhyAdopParent;
    } //-- double getDAmtActiveNonRecurrPhyAdopParent() 

    /**
     * Returns the value of field 'dAmtActiveNonRecurrTravel'.
     * 
     * @return the value of field 'DAmtActiveNonRecurrTravel'.
     */
    public double getDAmtActiveNonRecurrTravel()
    {
        return this._dAmtActiveNonRecurrTravel;
    } //-- double getDAmtActiveNonRecurrTravel() 

    /**
     * Returns the value of field 'dAmtNonRecLimit'.
     * 
     * @return the value of field 'DAmtNonRecLimit'.
     */
    public double getDAmtNonRecLimit()
    {
        return this._dAmtNonRecLimit;
    } //-- double getDAmtNonRecLimit() 

    /**
     * Method hasDAmtActiveNonRecurrAdopLegalFees
     * 
     * 
     * 
     * @return true if at least one
     * DAmtActiveNonRecurrAdopLegalFees has been added
     */
    public boolean hasDAmtActiveNonRecurrAdopLegalFees()
    {
        return this._has_dAmtActiveNonRecurrAdopLegalFees;
    } //-- boolean hasDAmtActiveNonRecurrAdopLegalFees() 

    /**
     * Method hasDAmtActiveNonRecurrLogMeals
     * 
     * 
     * 
     * @return true if at least one DAmtActiveNonRecurrLogMeals has
     * been added
     */
    public boolean hasDAmtActiveNonRecurrLogMeals()
    {
        return this._has_dAmtActiveNonRecurrLogMeals;
    } //-- boolean hasDAmtActiveNonRecurrLogMeals() 

    /**
     * Method hasDAmtActiveNonRecurrPhyAdopParent
     * 
     * 
     * 
     * @return true if at least one
     * DAmtActiveNonRecurrPhyAdopParent has been added
     */
    public boolean hasDAmtActiveNonRecurrPhyAdopParent()
    {
        return this._has_dAmtActiveNonRecurrPhyAdopParent;
    } //-- boolean hasDAmtActiveNonRecurrPhyAdopParent() 

    /**
     * Method hasDAmtActiveNonRecurrTravel
     * 
     * 
     * 
     * @return true if at least one DAmtActiveNonRecurrTravel has
     * been added
     */
    public boolean hasDAmtActiveNonRecurrTravel()
    {
        return this._has_dAmtActiveNonRecurrTravel;
    } //-- boolean hasDAmtActiveNonRecurrTravel() 

    /**
     * Method hasDAmtNonRecLimit
     * 
     * 
     * 
     * @return true if at least one DAmtNonRecLimit has been added
     */
    public boolean hasDAmtNonRecLimit()
    {
        return this._has_dAmtNonRecLimit;
    } //-- boolean hasDAmtNonRecLimit() 

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
     * Sets the value of field
     * 'bIndActiveNonRecurrAdopLegalFeesExists'.
     * 
     * @param bIndActiveNonRecurrAdopLegalFeesExists the value of
     * field 'bIndActiveNonRecurrAdopLegalFeesExists'.
     */
    public void setBIndActiveNonRecurrAdopLegalFeesExists(java.lang.String bIndActiveNonRecurrAdopLegalFeesExists)
    {
        this._bIndActiveNonRecurrAdopLegalFeesExists = bIndActiveNonRecurrAdopLegalFeesExists;
    } //-- void setBIndActiveNonRecurrAdopLegalFeesExists(java.lang.String) 

    /**
     * Sets the value of field 'bIndActiveNonRecurrLogMealsExists'.
     * 
     * @param bIndActiveNonRecurrLogMealsExists the value of field
     * 'bIndActiveNonRecurrLogMealsExists'.
     */
    public void setBIndActiveNonRecurrLogMealsExists(java.lang.String bIndActiveNonRecurrLogMealsExists)
    {
        this._bIndActiveNonRecurrLogMealsExists = bIndActiveNonRecurrLogMealsExists;
    } //-- void setBIndActiveNonRecurrLogMealsExists(java.lang.String) 

    /**
     * Sets the value of field
     * 'bIndActiveNonRecurrPhyAdopParentExists'.
     * 
     * @param bIndActiveNonRecurrPhyAdopParentExists the value of
     * field 'bIndActiveNonRecurrPhyAdopParentExists'.
     */
    public void setBIndActiveNonRecurrPhyAdopParentExists(java.lang.String bIndActiveNonRecurrPhyAdopParentExists)
    {
        this._bIndActiveNonRecurrPhyAdopParentExists = bIndActiveNonRecurrPhyAdopParentExists;
    } //-- void setBIndActiveNonRecurrPhyAdopParentExists(java.lang.String) 

    /**
     * Sets the value of field 'bIndActiveNonRecurrTravelExists'.
     * 
     * @param bIndActiveNonRecurrTravelExists the value of field
     * 'bIndActiveNonRecurrTravelExists'.
     */
    public void setBIndActiveNonRecurrTravelExists(java.lang.String bIndActiveNonRecurrTravelExists)
    {
        this._bIndActiveNonRecurrTravelExists = bIndActiveNonRecurrTravelExists;
    } //-- void setBIndActiveNonRecurrTravelExists(java.lang.String) 

    /**
     * Sets the value of field 'bIndOverSpendingLimitPad'.
     * 
     * @param bIndOverSpendingLimitPad the value of field
     * 'bIndOverSpendingLimitPad'.
     */
    public void setBIndOverSpendingLimitPad(java.lang.String bIndOverSpendingLimitPad)
    {
        this._bIndOverSpendingLimitPad = bIndOverSpendingLimitPad;
    } //-- void setBIndOverSpendingLimitPad(java.lang.String) 

    /**
     * Sets the value of field 'dAmtActiveNonRecurrAdopLegalFees'.
     * 
     * @param dAmtActiveNonRecurrAdopLegalFees the value of field
     * 'dAmtActiveNonRecurrAdopLegalFees'.
     */
    public void setDAmtActiveNonRecurrAdopLegalFees(double dAmtActiveNonRecurrAdopLegalFees)
    {
        this._dAmtActiveNonRecurrAdopLegalFees = dAmtActiveNonRecurrAdopLegalFees;
        this._has_dAmtActiveNonRecurrAdopLegalFees = true;
    } //-- void setDAmtActiveNonRecurrAdopLegalFees(double) 

    /**
     * Sets the value of field 'dAmtActiveNonRecurrLogMeals'.
     * 
     * @param dAmtActiveNonRecurrLogMeals the value of field
     * 'dAmtActiveNonRecurrLogMeals'.
     */
    public void setDAmtActiveNonRecurrLogMeals(double dAmtActiveNonRecurrLogMeals)
    {
        this._dAmtActiveNonRecurrLogMeals = dAmtActiveNonRecurrLogMeals;
        this._has_dAmtActiveNonRecurrLogMeals = true;
    } //-- void setDAmtActiveNonRecurrLogMeals(double) 

    /**
     * Sets the value of field 'dAmtActiveNonRecurrPhyAdopParent'.
     * 
     * @param dAmtActiveNonRecurrPhyAdopParent the value of field
     * 'dAmtActiveNonRecurrPhyAdopParent'.
     */
    public void setDAmtActiveNonRecurrPhyAdopParent(double dAmtActiveNonRecurrPhyAdopParent)
    {
        this._dAmtActiveNonRecurrPhyAdopParent = dAmtActiveNonRecurrPhyAdopParent;
        this._has_dAmtActiveNonRecurrPhyAdopParent = true;
    } //-- void setDAmtActiveNonRecurrPhyAdopParent(double) 

    /**
     * Sets the value of field 'dAmtActiveNonRecurrTravel'.
     * 
     * @param dAmtActiveNonRecurrTravel the value of field
     * 'dAmtActiveNonRecurrTravel'.
     */
    public void setDAmtActiveNonRecurrTravel(double dAmtActiveNonRecurrTravel)
    {
        this._dAmtActiveNonRecurrTravel = dAmtActiveNonRecurrTravel;
        this._has_dAmtActiveNonRecurrTravel = true;
    } //-- void setDAmtActiveNonRecurrTravel(double) 

    /**
     * Sets the value of field 'dAmtNonRecLimit'.
     * 
     * @param dAmtNonRecLimit the value of field 'dAmtNonRecLimit'.
     */
    public void setDAmtNonRecLimit(double dAmtNonRecLimit)
    {
        this._dAmtNonRecLimit = dAmtNonRecLimit;
        this._has_dAmtNonRecLimit = true;
    } //-- void setDAmtNonRecLimit(double) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO unmarshal(java.io.Reader) 

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
