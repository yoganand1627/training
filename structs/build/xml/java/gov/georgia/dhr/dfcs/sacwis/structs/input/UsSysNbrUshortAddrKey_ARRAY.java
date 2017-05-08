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
 * Class UsSysNbrUshortAddrKey_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UsSysNbrUshortAddrKey_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usSysNbrUshortAddrKeyList
     */
    private java.util.List<Integer> _usSysNbrUshortAddrKeyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsSysNbrUshortAddrKey_ARRAY() 
     {
        super();
        this._usSysNbrUshortAddrKeyList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortAddrKey_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUsSysNbrUshortAddrKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortAddrKey(int vUsSysNbrUshortAddrKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortAddrKeyList.size() >= 15) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortAddrKey has a maximum of 15");
        }
        
        this._usSysNbrUshortAddrKeyList.add(new java.lang.Integer(vUsSysNbrUshortAddrKey));
    } //-- void addUsSysNbrUshortAddrKey(int) 

    /**
     * 
     * 
     * @param index
     * @param vUsSysNbrUshortAddrKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortAddrKey(int index, int vUsSysNbrUshortAddrKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortAddrKeyList.size() >= 15) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortAddrKey has a maximum of 15");
        }
        
        this._usSysNbrUshortAddrKeyList.add(index, new java.lang.Integer(vUsSysNbrUshortAddrKey));
    } //-- void addUsSysNbrUshortAddrKey(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUsSysNbrUshortAddrKey
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUsSysNbrUshortAddrKey()
    {
        return java.util.Collections.enumeration(this._usSysNbrUshortAddrKeyList);
    } //-- java.util.Enumeration<Integer> enumerateUsSysNbrUshortAddrKey() 

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
     * Method getUsSysNbrUshortAddrKey
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUsSysNbrUshortAddrKey(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortAddrKeyList.size()) {
            throw new IndexOutOfBoundsException("getUsSysNbrUshortAddrKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortAddrKeyList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_usSysNbrUshortAddrKeyList.get(index)).intValue();
    } //-- int getUsSysNbrUshortAddrKey(int) 

    /**
     * Method getUsSysNbrUshortAddrKey
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUsSysNbrUshortAddrKey()
    {
        int size = this._usSysNbrUshortAddrKeyList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_usSysNbrUshortAddrKeyList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUsSysNbrUshortAddrKey() 

    /**
     * Method getUsSysNbrUshortAddrKeyAsReference
     * 
     * Returns a reference to '_usSysNbrUshortAddrKeyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUsSysNbrUshortAddrKeyAsReference()
    {
        return this._usSysNbrUshortAddrKeyList;
    } //-- java.util.List<Integer> getUsSysNbrUshortAddrKeyAsReference() 

    /**
     * Method getUsSysNbrUshortAddrKeyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUsSysNbrUshortAddrKeyCount()
    {
        return this._usSysNbrUshortAddrKeyList.size();
    } //-- int getUsSysNbrUshortAddrKeyCount() 

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
     * Method iterateUsSysNbrUshortAddrKey
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUsSysNbrUshortAddrKey()
    {
        return this._usSysNbrUshortAddrKeyList.iterator();
    } //-- java.util.Iterator<Integer> iterateUsSysNbrUshortAddrKey() 

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
    public void removeAllUsSysNbrUshortAddrKey()
    {
        this._usSysNbrUshortAddrKeyList.clear();
    } //-- void removeAllUsSysNbrUshortAddrKey() 

    /**
     * Method removeUsSysNbrUshortAddrKey
     * 
     * 
     * 
     * @param vUsSysNbrUshortAddrKey
     * @return true if the object was removed from the collection.
     */
    public boolean removeUsSysNbrUshortAddrKey(int vUsSysNbrUshortAddrKey)
    {
        boolean removed = _usSysNbrUshortAddrKeyList.remove(new java.lang.Integer(vUsSysNbrUshortAddrKey));
        return removed;
    } //-- boolean removeUsSysNbrUshortAddrKey(int) 

    /**
     * Method removeUsSysNbrUshortAddrKeyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUsSysNbrUshortAddrKeyAt(int index)
    {
        Object obj = this._usSysNbrUshortAddrKeyList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUsSysNbrUshortAddrKeyAt(int) 

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
     * @param vUsSysNbrUshortAddrKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUsSysNbrUshortAddrKey(int index, int vUsSysNbrUshortAddrKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortAddrKeyList.size()) {
            throw new IndexOutOfBoundsException("setUsSysNbrUshortAddrKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortAddrKeyList.size() - 1) + "]");
        }
        
        this._usSysNbrUshortAddrKeyList.set(index, new java.lang.Integer(vUsSysNbrUshortAddrKey));
    } //-- void setUsSysNbrUshortAddrKey(int, int) 

    /**
     * 
     * 
     * @param vUsSysNbrUshortAddrKeyArray
     */
    public void setUsSysNbrUshortAddrKey(int[] vUsSysNbrUshortAddrKeyArray)
    {
        //-- copy array
        _usSysNbrUshortAddrKeyList.clear();
        
        for (int i = 0; i < vUsSysNbrUshortAddrKeyArray.length; i++) {
                this._usSysNbrUshortAddrKeyList.add(new java.lang.Integer(vUsSysNbrUshortAddrKeyArray[i]));
        }
    } //-- void setUsSysNbrUshortAddrKey(int) 

    /**
     * Sets the value of '_usSysNbrUshortAddrKeyList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vUsSysNbrUshortAddrKeyList the Vector to copy.
     */
    public void setUsSysNbrUshortAddrKey(java.util.List<Integer> vUsSysNbrUshortAddrKeyList)
    {
        // copy vector
        this._usSysNbrUshortAddrKeyList.clear();
        
        this._usSysNbrUshortAddrKeyList.addAll(vUsSysNbrUshortAddrKeyList);
    } //-- void setUsSysNbrUshortAddrKey(java.util.List) 

    /**
     * Sets the value of '_usSysNbrUshortAddrKeyList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param UsSysNbrUshortAddrKeyVector the Vector to set.
     */
    public void setUsSysNbrUshortAddrKeyAsReference(java.util.Vector<Integer> UsSysNbrUshortAddrKeyVector)
    {
        this._usSysNbrUshortAddrKeyList = UsSysNbrUshortAddrKeyVector;
    } //-- void setUsSysNbrUshortAddrKeyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortAddrKey_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortAddrKey_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortAddrKey_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortAddrKey_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortAddrKey_ARRAY unmarshal(java.io.Reader) 

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
