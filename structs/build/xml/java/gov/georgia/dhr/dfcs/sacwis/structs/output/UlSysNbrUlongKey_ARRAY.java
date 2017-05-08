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
 * Class UlSysNbrUlongKey_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlSysNbrUlongKey_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulSysNbrUlongKeyList
     */
    private java.util.List<Integer> _ulSysNbrUlongKeyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlSysNbrUlongKey_ARRAY() 
     {
        super();
        this._ulSysNbrUlongKeyList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlSysNbrUlongKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlSysNbrUlongKey(int vUlSysNbrUlongKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulSysNbrUlongKeyList.size() >= 2500) {
            throw new IndexOutOfBoundsException("addUlSysNbrUlongKey has a maximum of 2500");
        }
        
        this._ulSysNbrUlongKeyList.add(new java.lang.Integer(vUlSysNbrUlongKey));
    } //-- void addUlSysNbrUlongKey(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlSysNbrUlongKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlSysNbrUlongKey(int index, int vUlSysNbrUlongKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulSysNbrUlongKeyList.size() >= 2500) {
            throw new IndexOutOfBoundsException("addUlSysNbrUlongKey has a maximum of 2500");
        }
        
        this._ulSysNbrUlongKeyList.add(index, new java.lang.Integer(vUlSysNbrUlongKey));
    } //-- void addUlSysNbrUlongKey(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlSysNbrUlongKey
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlSysNbrUlongKey()
    {
        return java.util.Collections.enumeration(this._ulSysNbrUlongKeyList);
    } //-- java.util.Enumeration<Integer> enumerateUlSysNbrUlongKey() 

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
     * Method getUlSysNbrUlongKey
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlSysNbrUlongKey(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulSysNbrUlongKeyList.size()) {
            throw new IndexOutOfBoundsException("getUlSysNbrUlongKey: Index value '" + index + "' not in range [0.." + (this._ulSysNbrUlongKeyList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulSysNbrUlongKeyList.get(index)).intValue();
    } //-- int getUlSysNbrUlongKey(int) 

    /**
     * Method getUlSysNbrUlongKey
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlSysNbrUlongKey()
    {
        int size = this._ulSysNbrUlongKeyList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulSysNbrUlongKeyList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlSysNbrUlongKey() 

    /**
     * Method getUlSysNbrUlongKeyAsReference
     * 
     * Returns a reference to '_ulSysNbrUlongKeyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlSysNbrUlongKeyAsReference()
    {
        return this._ulSysNbrUlongKeyList;
    } //-- java.util.List<Integer> getUlSysNbrUlongKeyAsReference() 

    /**
     * Method getUlSysNbrUlongKeyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlSysNbrUlongKeyCount()
    {
        return this._ulSysNbrUlongKeyList.size();
    } //-- int getUlSysNbrUlongKeyCount() 

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
     * Method iterateUlSysNbrUlongKey
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlSysNbrUlongKey()
    {
        return this._ulSysNbrUlongKeyList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlSysNbrUlongKey() 

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
    public void removeAllUlSysNbrUlongKey()
    {
        this._ulSysNbrUlongKeyList.clear();
    } //-- void removeAllUlSysNbrUlongKey() 

    /**
     * Method removeUlSysNbrUlongKey
     * 
     * 
     * 
     * @param vUlSysNbrUlongKey
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlSysNbrUlongKey(int vUlSysNbrUlongKey)
    {
        boolean removed = _ulSysNbrUlongKeyList.remove(new java.lang.Integer(vUlSysNbrUlongKey));
        return removed;
    } //-- boolean removeUlSysNbrUlongKey(int) 

    /**
     * Method removeUlSysNbrUlongKeyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlSysNbrUlongKeyAt(int index)
    {
        Object obj = this._ulSysNbrUlongKeyList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlSysNbrUlongKeyAt(int) 

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
     * 
     * 
     * @param index
     * @param vUlSysNbrUlongKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlSysNbrUlongKey(int index, int vUlSysNbrUlongKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulSysNbrUlongKeyList.size()) {
            throw new IndexOutOfBoundsException("setUlSysNbrUlongKey: Index value '" + index + "' not in range [0.." + (this._ulSysNbrUlongKeyList.size() - 1) + "]");
        }
        
        this._ulSysNbrUlongKeyList.set(index, new java.lang.Integer(vUlSysNbrUlongKey));
    } //-- void setUlSysNbrUlongKey(int, int) 

    /**
     * 
     * 
     * @param vUlSysNbrUlongKeyArray
     */
    public void setUlSysNbrUlongKey(int[] vUlSysNbrUlongKeyArray)
    {
        //-- copy array
        _ulSysNbrUlongKeyList.clear();
        
        for (int i = 0; i < vUlSysNbrUlongKeyArray.length; i++) {
                this._ulSysNbrUlongKeyList.add(new java.lang.Integer(vUlSysNbrUlongKeyArray[i]));
        }
    } //-- void setUlSysNbrUlongKey(int) 

    /**
     * Sets the value of '_ulSysNbrUlongKeyList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vUlSysNbrUlongKeyList the Vector to copy.
     */
    public void setUlSysNbrUlongKey(java.util.List<Integer> vUlSysNbrUlongKeyList)
    {
        // copy vector
        this._ulSysNbrUlongKeyList.clear();
        
        this._ulSysNbrUlongKeyList.addAll(vUlSysNbrUlongKeyList);
    } //-- void setUlSysNbrUlongKey(java.util.List) 

    /**
     * Sets the value of '_ulSysNbrUlongKeyList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param UlSysNbrUlongKeyVector the Vector to set.
     */
    public void setUlSysNbrUlongKeyAsReference(java.util.Vector<Integer> UlSysNbrUlongKeyVector)
    {
        this._ulSysNbrUlongKeyList = UlSysNbrUlongKeyVector;
    } //-- void setUlSysNbrUlongKeyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY unmarshal(java.io.Reader) 

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
