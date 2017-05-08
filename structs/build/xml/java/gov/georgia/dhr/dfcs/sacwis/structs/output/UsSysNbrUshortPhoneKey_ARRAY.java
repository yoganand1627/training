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
 * Class UsSysNbrUshortPhoneKey_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UsSysNbrUshortPhoneKey_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usSysNbrUshortPhoneKeyList
     */
    private java.util.List<Integer> _usSysNbrUshortPhoneKeyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsSysNbrUshortPhoneKey_ARRAY() 
     {
        super();
        this._usSysNbrUshortPhoneKeyList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUsSysNbrUshortPhoneKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortPhoneKey(int vUsSysNbrUshortPhoneKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortPhoneKeyList.size() >= 15) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortPhoneKey has a maximum of 15");
        }
        
        this._usSysNbrUshortPhoneKeyList.add(new java.lang.Integer(vUsSysNbrUshortPhoneKey));
    } //-- void addUsSysNbrUshortPhoneKey(int) 

    /**
     * 
     * 
     * @param index
     * @param vUsSysNbrUshortPhoneKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortPhoneKey(int index, int vUsSysNbrUshortPhoneKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortPhoneKeyList.size() >= 15) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortPhoneKey has a maximum of 15");
        }
        
        this._usSysNbrUshortPhoneKeyList.add(index, new java.lang.Integer(vUsSysNbrUshortPhoneKey));
    } //-- void addUsSysNbrUshortPhoneKey(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUsSysNbrUshortPhoneKey
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUsSysNbrUshortPhoneKey()
    {
        return java.util.Collections.enumeration(this._usSysNbrUshortPhoneKeyList);
    } //-- java.util.Enumeration<Integer> enumerateUsSysNbrUshortPhoneKey() 

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
     * Method getUsSysNbrUshortPhoneKey
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUsSysNbrUshortPhoneKey(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortPhoneKeyList.size()) {
            throw new IndexOutOfBoundsException("getUsSysNbrUshortPhoneKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortPhoneKeyList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_usSysNbrUshortPhoneKeyList.get(index)).intValue();
    } //-- int getUsSysNbrUshortPhoneKey(int) 

    /**
     * Method getUsSysNbrUshortPhoneKey
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUsSysNbrUshortPhoneKey()
    {
        int size = this._usSysNbrUshortPhoneKeyList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_usSysNbrUshortPhoneKeyList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUsSysNbrUshortPhoneKey() 

    /**
     * Method getUsSysNbrUshortPhoneKeyAsReference
     * 
     * Returns a reference to '_usSysNbrUshortPhoneKeyList'. No
     * type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUsSysNbrUshortPhoneKeyAsReference()
    {
        return this._usSysNbrUshortPhoneKeyList;
    } //-- java.util.List<Integer> getUsSysNbrUshortPhoneKeyAsReference() 

    /**
     * Method getUsSysNbrUshortPhoneKeyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUsSysNbrUshortPhoneKeyCount()
    {
        return this._usSysNbrUshortPhoneKeyList.size();
    } //-- int getUsSysNbrUshortPhoneKeyCount() 

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
     * Method iterateUsSysNbrUshortPhoneKey
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUsSysNbrUshortPhoneKey()
    {
        return this._usSysNbrUshortPhoneKeyList.iterator();
    } //-- java.util.Iterator<Integer> iterateUsSysNbrUshortPhoneKey() 

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
    public void removeAllUsSysNbrUshortPhoneKey()
    {
        this._usSysNbrUshortPhoneKeyList.clear();
    } //-- void removeAllUsSysNbrUshortPhoneKey() 

    /**
     * Method removeUsSysNbrUshortPhoneKey
     * 
     * 
     * 
     * @param vUsSysNbrUshortPhoneKey
     * @return true if the object was removed from the collection.
     */
    public boolean removeUsSysNbrUshortPhoneKey(int vUsSysNbrUshortPhoneKey)
    {
        boolean removed = _usSysNbrUshortPhoneKeyList.remove(new java.lang.Integer(vUsSysNbrUshortPhoneKey));
        return removed;
    } //-- boolean removeUsSysNbrUshortPhoneKey(int) 

    /**
     * Method removeUsSysNbrUshortPhoneKeyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUsSysNbrUshortPhoneKeyAt(int index)
    {
        Object obj = this._usSysNbrUshortPhoneKeyList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUsSysNbrUshortPhoneKeyAt(int) 

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
     * @param vUsSysNbrUshortPhoneKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUsSysNbrUshortPhoneKey(int index, int vUsSysNbrUshortPhoneKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortPhoneKeyList.size()) {
            throw new IndexOutOfBoundsException("setUsSysNbrUshortPhoneKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortPhoneKeyList.size() - 1) + "]");
        }
        
        this._usSysNbrUshortPhoneKeyList.set(index, new java.lang.Integer(vUsSysNbrUshortPhoneKey));
    } //-- void setUsSysNbrUshortPhoneKey(int, int) 

    /**
     * 
     * 
     * @param vUsSysNbrUshortPhoneKeyArray
     */
    public void setUsSysNbrUshortPhoneKey(int[] vUsSysNbrUshortPhoneKeyArray)
    {
        //-- copy array
        _usSysNbrUshortPhoneKeyList.clear();
        
        for (int i = 0; i < vUsSysNbrUshortPhoneKeyArray.length; i++) {
                this._usSysNbrUshortPhoneKeyList.add(new java.lang.Integer(vUsSysNbrUshortPhoneKeyArray[i]));
        }
    } //-- void setUsSysNbrUshortPhoneKey(int) 

    /**
     * Sets the value of '_usSysNbrUshortPhoneKeyList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vUsSysNbrUshortPhoneKeyList the Vector to copy.
     */
    public void setUsSysNbrUshortPhoneKey(java.util.List<Integer> vUsSysNbrUshortPhoneKeyList)
    {
        // copy vector
        this._usSysNbrUshortPhoneKeyList.clear();
        
        this._usSysNbrUshortPhoneKeyList.addAll(vUsSysNbrUshortPhoneKeyList);
    } //-- void setUsSysNbrUshortPhoneKey(java.util.List) 

    /**
     * Sets the value of '_usSysNbrUshortPhoneKeyList' by setting
     * it to the given Vector. No type checking is performed.
     * 
     * @param UsSysNbrUshortPhoneKeyVector the Vector to set.
     */
    public void setUsSysNbrUshortPhoneKeyAsReference(java.util.Vector<Integer> UsSysNbrUshortPhoneKeyVector)
    {
        this._usSysNbrUshortPhoneKeyList = UsSysNbrUshortPhoneKeyVector;
    } //-- void setUsSysNbrUshortPhoneKeyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY unmarshal(java.io.Reader) 

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
