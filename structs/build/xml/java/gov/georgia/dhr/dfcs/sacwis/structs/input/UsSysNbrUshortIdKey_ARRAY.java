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
 * Class UsSysNbrUshortIdKey_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UsSysNbrUshortIdKey_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usSysNbrUshortIdKeyList
     */
    private java.util.List<Integer> _usSysNbrUshortIdKeyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsSysNbrUshortIdKey_ARRAY() 
     {
        super();
        this._usSysNbrUshortIdKeyList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortIdKey_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUsSysNbrUshortIdKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortIdKey(int vUsSysNbrUshortIdKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortIdKeyList.size() >= 65) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortIdKey has a maximum of 65");
        }
        
        this._usSysNbrUshortIdKeyList.add(new java.lang.Integer(vUsSysNbrUshortIdKey));
    } //-- void addUsSysNbrUshortIdKey(int) 

    /**
     * 
     * 
     * @param index
     * @param vUsSysNbrUshortIdKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortIdKey(int index, int vUsSysNbrUshortIdKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortIdKeyList.size() >= 65) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortIdKey has a maximum of 65");
        }
        
        this._usSysNbrUshortIdKeyList.add(index, new java.lang.Integer(vUsSysNbrUshortIdKey));
    } //-- void addUsSysNbrUshortIdKey(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUsSysNbrUshortIdKey
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUsSysNbrUshortIdKey()
    {
        return java.util.Collections.enumeration(this._usSysNbrUshortIdKeyList);
    } //-- java.util.Enumeration<Integer> enumerateUsSysNbrUshortIdKey() 

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
     * Method getUsSysNbrUshortIdKey
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUsSysNbrUshortIdKey(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortIdKeyList.size()) {
            throw new IndexOutOfBoundsException("getUsSysNbrUshortIdKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortIdKeyList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_usSysNbrUshortIdKeyList.get(index)).intValue();
    } //-- int getUsSysNbrUshortIdKey(int) 

    /**
     * Method getUsSysNbrUshortIdKey
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUsSysNbrUshortIdKey()
    {
        int size = this._usSysNbrUshortIdKeyList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_usSysNbrUshortIdKeyList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUsSysNbrUshortIdKey() 

    /**
     * Method getUsSysNbrUshortIdKeyAsReference
     * 
     * Returns a reference to '_usSysNbrUshortIdKeyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUsSysNbrUshortIdKeyAsReference()
    {
        return this._usSysNbrUshortIdKeyList;
    } //-- java.util.List<Integer> getUsSysNbrUshortIdKeyAsReference() 

    /**
     * Method getUsSysNbrUshortIdKeyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUsSysNbrUshortIdKeyCount()
    {
        return this._usSysNbrUshortIdKeyList.size();
    } //-- int getUsSysNbrUshortIdKeyCount() 

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
     * Method iterateUsSysNbrUshortIdKey
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUsSysNbrUshortIdKey()
    {
        return this._usSysNbrUshortIdKeyList.iterator();
    } //-- java.util.Iterator<Integer> iterateUsSysNbrUshortIdKey() 

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
    public void removeAllUsSysNbrUshortIdKey()
    {
        this._usSysNbrUshortIdKeyList.clear();
    } //-- void removeAllUsSysNbrUshortIdKey() 

    /**
     * Method removeUsSysNbrUshortIdKey
     * 
     * 
     * 
     * @param vUsSysNbrUshortIdKey
     * @return true if the object was removed from the collection.
     */
    public boolean removeUsSysNbrUshortIdKey(int vUsSysNbrUshortIdKey)
    {
        boolean removed = _usSysNbrUshortIdKeyList.remove(new java.lang.Integer(vUsSysNbrUshortIdKey));
        return removed;
    } //-- boolean removeUsSysNbrUshortIdKey(int) 

    /**
     * Method removeUsSysNbrUshortIdKeyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUsSysNbrUshortIdKeyAt(int index)
    {
        Object obj = this._usSysNbrUshortIdKeyList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUsSysNbrUshortIdKeyAt(int) 

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
     * @param vUsSysNbrUshortIdKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUsSysNbrUshortIdKey(int index, int vUsSysNbrUshortIdKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortIdKeyList.size()) {
            throw new IndexOutOfBoundsException("setUsSysNbrUshortIdKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortIdKeyList.size() - 1) + "]");
        }
        
        this._usSysNbrUshortIdKeyList.set(index, new java.lang.Integer(vUsSysNbrUshortIdKey));
    } //-- void setUsSysNbrUshortIdKey(int, int) 

    /**
     * 
     * 
     * @param vUsSysNbrUshortIdKeyArray
     */
    public void setUsSysNbrUshortIdKey(int[] vUsSysNbrUshortIdKeyArray)
    {
        //-- copy array
        _usSysNbrUshortIdKeyList.clear();
        
        for (int i = 0; i < vUsSysNbrUshortIdKeyArray.length; i++) {
                this._usSysNbrUshortIdKeyList.add(new java.lang.Integer(vUsSysNbrUshortIdKeyArray[i]));
        }
    } //-- void setUsSysNbrUshortIdKey(int) 

    /**
     * Sets the value of '_usSysNbrUshortIdKeyList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vUsSysNbrUshortIdKeyList the Vector to copy.
     */
    public void setUsSysNbrUshortIdKey(java.util.List<Integer> vUsSysNbrUshortIdKeyList)
    {
        // copy vector
        this._usSysNbrUshortIdKeyList.clear();
        
        this._usSysNbrUshortIdKeyList.addAll(vUsSysNbrUshortIdKeyList);
    } //-- void setUsSysNbrUshortIdKey(java.util.List) 

    /**
     * Sets the value of '_usSysNbrUshortIdKeyList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param UsSysNbrUshortIdKeyVector the Vector to set.
     */
    public void setUsSysNbrUshortIdKeyAsReference(java.util.Vector<Integer> UsSysNbrUshortIdKeyVector)
    {
        this._usSysNbrUshortIdKeyList = UsSysNbrUshortIdKeyVector;
    } //-- void setUsSysNbrUshortIdKeyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortIdKey_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortIdKey_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortIdKey_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortIdKey_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortIdKey_ARRAY unmarshal(java.io.Reader) 

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
