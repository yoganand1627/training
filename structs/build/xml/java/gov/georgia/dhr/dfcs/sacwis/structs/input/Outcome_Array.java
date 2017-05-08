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
 * Class Outcome_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Outcome_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _outcomeList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> _outcomeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Outcome_Array() 
     {
        super();
        this._outcomeList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOutcome
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOutcome(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome vOutcome)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._outcomeList.size() >= 100) {
            throw new IndexOutOfBoundsException("addOutcome has a maximum of 100");
        }
        
        this._outcomeList.add(vOutcome);
    } //-- void addOutcome(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) 

    /**
     * 
     * 
     * @param index
     * @param vOutcome
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOutcome(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome vOutcome)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._outcomeList.size() >= 100) {
            throw new IndexOutOfBoundsException("addOutcome has a maximum of 100");
        }
        
        this._outcomeList.add(index, vOutcome);
    } //-- void addOutcome(int, gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateOutcome
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> enumerateOutcome()
    {
        return java.util.Collections.enumeration(this._outcomeList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> enumerateOutcome() 

    /**
     * Method getOutcome
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome getOutcome(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._outcomeList.size()) {
            throw new IndexOutOfBoundsException("getOutcome: Index value '" + index + "' not in range [0.." + (this._outcomeList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) _outcomeList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome getOutcome(int) 

    /**
     * Method getOutcome
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome[] getOutcome()
    {
        int size = this._outcomeList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) _outcomeList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome[] getOutcome() 

    /**
     * Method getOutcomeAsReference
     * 
     * Returns a reference to '_outcomeList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> getOutcomeAsReference()
    {
        return this._outcomeList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> getOutcomeAsReference() 

    /**
     * Method getOutcomeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getOutcomeCount()
    {
        return this._outcomeList.size();
    } //-- int getOutcomeCount() 

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
     * Method iterateOutcome
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> iterateOutcome()
    {
        return this._outcomeList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> iterateOutcome() 

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
     */
    public void removeAllOutcome()
    {
        this._outcomeList.clear();
    } //-- void removeAllOutcome() 

    /**
     * Method removeOutcome
     * 
     * 
     * 
     * @param vOutcome
     * @return true if the object was removed from the collection.
     */
    public boolean removeOutcome(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome vOutcome)
    {
        boolean removed = _outcomeList.remove(vOutcome);
        return removed;
    } //-- boolean removeOutcome(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) 

    /**
     * Method removeOutcomeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome removeOutcomeAt(int index)
    {
        Object obj = this._outcomeList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome removeOutcomeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vOutcome
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOutcome(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome vOutcome)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._outcomeList.size()) {
            throw new IndexOutOfBoundsException("setOutcome: Index value '" + index + "' not in range [0.." + (this._outcomeList.size() - 1) + "]");
        }
        
        this._outcomeList.set(index, vOutcome);
    } //-- void setOutcome(int, gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) 

    /**
     * 
     * 
     * @param vOutcomeArray
     */
    public void setOutcome(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome[] vOutcomeArray)
    {
        //-- copy array
        _outcomeList.clear();
        
        for (int i = 0; i < vOutcomeArray.length; i++) {
                this._outcomeList.add(vOutcomeArray[i]);
        }
    } //-- void setOutcome(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome) 

    /**
     * Sets the value of '_outcomeList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vOutcomeList the Vector to copy.
     */
    public void setOutcome(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> vOutcomeList)
    {
        // copy vector
        this._outcomeList.clear();
        
        this._outcomeList.addAll(vOutcomeList);
    } //-- void setOutcome(java.util.List) 

    /**
     * Sets the value of '_outcomeList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param OutcomeVector the Vector to set.
     */
    public void setOutcomeAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome> OutcomeVector)
    {
        this._outcomeList = OutcomeVector;
    } //-- void setOutcomeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array unmarshal(java.io.Reader) 

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
