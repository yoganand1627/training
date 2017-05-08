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
 * Class UlIdPersonSecondary_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdPersonSecondary_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPersonSecondaryList
     */
    private java.util.List<Integer> _ulIdPersonSecondaryList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdPersonSecondary_ARRAY() 
     {
        super();
        this._ulIdPersonSecondaryList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdPersonSecondary
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPersonSecondary(int vUlIdPersonSecondary)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPersonSecondaryList.size() >= 50) {
            throw new IndexOutOfBoundsException("addUlIdPersonSecondary has a maximum of 50");
        }
        
        this._ulIdPersonSecondaryList.add(new java.lang.Integer(vUlIdPersonSecondary));
    } //-- void addUlIdPersonSecondary(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPersonSecondary
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPersonSecondary(int index, int vUlIdPersonSecondary)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPersonSecondaryList.size() >= 50) {
            throw new IndexOutOfBoundsException("addUlIdPersonSecondary has a maximum of 50");
        }
        
        this._ulIdPersonSecondaryList.add(index, new java.lang.Integer(vUlIdPersonSecondary));
    } //-- void addUlIdPersonSecondary(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdPersonSecondary
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdPersonSecondary()
    {
        return java.util.Collections.enumeration(this._ulIdPersonSecondaryList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdPersonSecondary() 

    /**
     * Method getUlIdPersonSecondary
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdPersonSecondary(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPersonSecondaryList.size()) {
            throw new IndexOutOfBoundsException("getUlIdPersonSecondary: Index value '" + index + "' not in range [0.." + (this._ulIdPersonSecondaryList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdPersonSecondaryList.get(index)).intValue();
    } //-- int getUlIdPersonSecondary(int) 

    /**
     * Method getUlIdPersonSecondary
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdPersonSecondary()
    {
        int size = this._ulIdPersonSecondaryList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdPersonSecondaryList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdPersonSecondary() 

    /**
     * Method getUlIdPersonSecondaryAsReference
     * 
     * Returns a reference to '_ulIdPersonSecondaryList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdPersonSecondaryAsReference()
    {
        return this._ulIdPersonSecondaryList;
    } //-- java.util.List<Integer> getUlIdPersonSecondaryAsReference() 

    /**
     * Method getUlIdPersonSecondaryCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdPersonSecondaryCount()
    {
        return this._ulIdPersonSecondaryList.size();
    } //-- int getUlIdPersonSecondaryCount() 

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
     * Method iterateUlIdPersonSecondary
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdPersonSecondary()
    {
        return this._ulIdPersonSecondaryList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdPersonSecondary() 

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
    public void removeAllUlIdPersonSecondary()
    {
        this._ulIdPersonSecondaryList.clear();
    } //-- void removeAllUlIdPersonSecondary() 

    /**
     * Method removeUlIdPersonSecondary
     * 
     * 
     * 
     * @param vUlIdPersonSecondary
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdPersonSecondary(int vUlIdPersonSecondary)
    {
        boolean removed = _ulIdPersonSecondaryList.remove(new java.lang.Integer(vUlIdPersonSecondary));
        return removed;
    } //-- boolean removeUlIdPersonSecondary(int) 

    /**
     * Method removeUlIdPersonSecondaryAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdPersonSecondaryAt(int index)
    {
        Object obj = this._ulIdPersonSecondaryList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdPersonSecondaryAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPersonSecondary
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdPersonSecondary(int index, int vUlIdPersonSecondary)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPersonSecondaryList.size()) {
            throw new IndexOutOfBoundsException("setUlIdPersonSecondary: Index value '" + index + "' not in range [0.." + (this._ulIdPersonSecondaryList.size() - 1) + "]");
        }
        
        this._ulIdPersonSecondaryList.set(index, new java.lang.Integer(vUlIdPersonSecondary));
    } //-- void setUlIdPersonSecondary(int, int) 

    /**
     * 
     * 
     * @param vUlIdPersonSecondaryArray
     */
    public void setUlIdPersonSecondary(int[] vUlIdPersonSecondaryArray)
    {
        //-- copy array
        _ulIdPersonSecondaryList.clear();
        
        for (int i = 0; i < vUlIdPersonSecondaryArray.length; i++) {
                this._ulIdPersonSecondaryList.add(new java.lang.Integer(vUlIdPersonSecondaryArray[i]));
        }
    } //-- void setUlIdPersonSecondary(int) 

    /**
     * Sets the value of '_ulIdPersonSecondaryList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdPersonSecondaryList the Vector to copy.
     */
    public void setUlIdPersonSecondary(java.util.List<Integer> vUlIdPersonSecondaryList)
    {
        // copy vector
        this._ulIdPersonSecondaryList.clear();
        
        this._ulIdPersonSecondaryList.addAll(vUlIdPersonSecondaryList);
    } //-- void setUlIdPersonSecondary(java.util.List) 

    /**
     * Sets the value of '_ulIdPersonSecondaryList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param UlIdPersonSecondaryVector the Vector to set.
     */
    public void setUlIdPersonSecondaryAsReference(java.util.Vector<Integer> UlIdPersonSecondaryVector)
    {
        this._ulIdPersonSecondaryList = UlIdPersonSecondaryVector;
    } //-- void setUlIdPersonSecondaryAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY unmarshal(java.io.Reader) 

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
