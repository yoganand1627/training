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
 * Class SzCdOutcome_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdOutcome_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdOutcomeList
     */
    private java.util.List<java.lang.String> _szCdOutcomeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdOutcome_Array() 
     {
        super();
        this._szCdOutcomeList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdOutcome
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdOutcome(java.lang.String vSzCdOutcome)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdOutcomeList.size() >= 100) {
            throw new IndexOutOfBoundsException("addSzCdOutcome has a maximum of 100");
        }
        
        this._szCdOutcomeList.add(vSzCdOutcome);
    } //-- void addSzCdOutcome(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdOutcome
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdOutcome(int index, java.lang.String vSzCdOutcome)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdOutcomeList.size() >= 100) {
            throw new IndexOutOfBoundsException("addSzCdOutcome has a maximum of 100");
        }
        
        this._szCdOutcomeList.add(index, vSzCdOutcome);
    } //-- void addSzCdOutcome(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdOutcome
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdOutcome()
    {
        return java.util.Collections.enumeration(this._szCdOutcomeList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdOutcome() 

    /**
     * Method getSzCdOutcome
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdOutcome(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdOutcomeList.size()) {
            throw new IndexOutOfBoundsException("getSzCdOutcome: Index value '" + index + "' not in range [0.." + (this._szCdOutcomeList.size() - 1) + "]");
        }
        
        return (String)_szCdOutcomeList.get(index);
    } //-- java.lang.String getSzCdOutcome(int) 

    /**
     * Method getSzCdOutcome
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdOutcome()
    {
        int size = this._szCdOutcomeList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdOutcomeList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdOutcome() 

    /**
     * Method getSzCdOutcomeAsReference
     * 
     * Returns a reference to '_szCdOutcomeList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdOutcomeAsReference()
    {
        return this._szCdOutcomeList;
    } //-- java.util.List<java.lang.String> getSzCdOutcomeAsReference() 

    /**
     * Method getSzCdOutcomeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdOutcomeCount()
    {
        return this._szCdOutcomeList.size();
    } //-- int getSzCdOutcomeCount() 

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
     * Method iterateSzCdOutcome
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdOutcome()
    {
        return this._szCdOutcomeList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdOutcome() 

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
    public void removeAllSzCdOutcome()
    {
        this._szCdOutcomeList.clear();
    } //-- void removeAllSzCdOutcome() 

    /**
     * Method removeSzCdOutcome
     * 
     * 
     * 
     * @param vSzCdOutcome
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdOutcome(java.lang.String vSzCdOutcome)
    {
        boolean removed = _szCdOutcomeList.remove(vSzCdOutcome);
        return removed;
    } //-- boolean removeSzCdOutcome(java.lang.String) 

    /**
     * Method removeSzCdOutcomeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdOutcomeAt(int index)
    {
        Object obj = this._szCdOutcomeList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdOutcomeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdOutcome
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdOutcome(int index, java.lang.String vSzCdOutcome)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdOutcomeList.size()) {
            throw new IndexOutOfBoundsException("setSzCdOutcome: Index value '" + index + "' not in range [0.." + (this._szCdOutcomeList.size() - 1) + "]");
        }
        
        this._szCdOutcomeList.set(index, vSzCdOutcome);
    } //-- void setSzCdOutcome(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdOutcomeArray
     */
    public void setSzCdOutcome(java.lang.String[] vSzCdOutcomeArray)
    {
        //-- copy array
        _szCdOutcomeList.clear();
        
        for (int i = 0; i < vSzCdOutcomeArray.length; i++) {
                this._szCdOutcomeList.add(vSzCdOutcomeArray[i]);
        }
    } //-- void setSzCdOutcome(java.lang.String) 

    /**
     * Sets the value of '_szCdOutcomeList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdOutcomeList the Vector to copy.
     */
    public void setSzCdOutcome(java.util.List<java.lang.String> vSzCdOutcomeList)
    {
        // copy vector
        this._szCdOutcomeList.clear();
        
        this._szCdOutcomeList.addAll(vSzCdOutcomeList);
    } //-- void setSzCdOutcome(java.util.List) 

    /**
     * Sets the value of '_szCdOutcomeList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdOutcomeVector the Vector to set.
     */
    public void setSzCdOutcomeAsReference(java.util.Vector<java.lang.String> SzCdOutcomeVector)
    {
        this._szCdOutcomeList = SzCdOutcomeVector;
    } //-- void setSzCdOutcomeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array unmarshal(java.io.Reader) 

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
