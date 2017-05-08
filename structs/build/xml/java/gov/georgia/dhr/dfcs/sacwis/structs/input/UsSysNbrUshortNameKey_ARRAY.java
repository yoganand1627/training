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
 * Class UsSysNbrUshortNameKey_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UsSysNbrUshortNameKey_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usSysNbrUshortNameKeyList
     */
    private java.util.List<Integer> _usSysNbrUshortNameKeyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsSysNbrUshortNameKey_ARRAY() 
     {
        super();
        this._usSysNbrUshortNameKeyList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortNameKey_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUsSysNbrUshortNameKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortNameKey(int vUsSysNbrUshortNameKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortNameKeyList.size() >= 10) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortNameKey has a maximum of 10");
        }
        
        this._usSysNbrUshortNameKeyList.add(new java.lang.Integer(vUsSysNbrUshortNameKey));
    } //-- void addUsSysNbrUshortNameKey(int) 

    /**
     * 
     * 
     * @param index
     * @param vUsSysNbrUshortNameKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrUshortNameKey(int index, int vUsSysNbrUshortNameKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrUshortNameKeyList.size() >= 10) {
            throw new IndexOutOfBoundsException("addUsSysNbrUshortNameKey has a maximum of 10");
        }
        
        this._usSysNbrUshortNameKeyList.add(index, new java.lang.Integer(vUsSysNbrUshortNameKey));
    } //-- void addUsSysNbrUshortNameKey(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUsSysNbrUshortNameKey
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUsSysNbrUshortNameKey()
    {
        return java.util.Collections.enumeration(this._usSysNbrUshortNameKeyList);
    } //-- java.util.Enumeration<Integer> enumerateUsSysNbrUshortNameKey() 

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
     * Method getUsSysNbrUshortNameKey
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUsSysNbrUshortNameKey(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortNameKeyList.size()) {
            throw new IndexOutOfBoundsException("getUsSysNbrUshortNameKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortNameKeyList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_usSysNbrUshortNameKeyList.get(index)).intValue();
    } //-- int getUsSysNbrUshortNameKey(int) 

    /**
     * Method getUsSysNbrUshortNameKey
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUsSysNbrUshortNameKey()
    {
        int size = this._usSysNbrUshortNameKeyList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_usSysNbrUshortNameKeyList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUsSysNbrUshortNameKey() 

    /**
     * Method getUsSysNbrUshortNameKeyAsReference
     * 
     * Returns a reference to '_usSysNbrUshortNameKeyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUsSysNbrUshortNameKeyAsReference()
    {
        return this._usSysNbrUshortNameKeyList;
    } //-- java.util.List<Integer> getUsSysNbrUshortNameKeyAsReference() 

    /**
     * Method getUsSysNbrUshortNameKeyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUsSysNbrUshortNameKeyCount()
    {
        return this._usSysNbrUshortNameKeyList.size();
    } //-- int getUsSysNbrUshortNameKeyCount() 

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
     * Method iterateUsSysNbrUshortNameKey
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUsSysNbrUshortNameKey()
    {
        return this._usSysNbrUshortNameKeyList.iterator();
    } //-- java.util.Iterator<Integer> iterateUsSysNbrUshortNameKey() 

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
    public void removeAllUsSysNbrUshortNameKey()
    {
        this._usSysNbrUshortNameKeyList.clear();
    } //-- void removeAllUsSysNbrUshortNameKey() 

    /**
     * Method removeUsSysNbrUshortNameKey
     * 
     * 
     * 
     * @param vUsSysNbrUshortNameKey
     * @return true if the object was removed from the collection.
     */
    public boolean removeUsSysNbrUshortNameKey(int vUsSysNbrUshortNameKey)
    {
        boolean removed = _usSysNbrUshortNameKeyList.remove(new java.lang.Integer(vUsSysNbrUshortNameKey));
        return removed;
    } //-- boolean removeUsSysNbrUshortNameKey(int) 

    /**
     * Method removeUsSysNbrUshortNameKeyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUsSysNbrUshortNameKeyAt(int index)
    {
        Object obj = this._usSysNbrUshortNameKeyList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUsSysNbrUshortNameKeyAt(int) 

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
     * @param vUsSysNbrUshortNameKey
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUsSysNbrUshortNameKey(int index, int vUsSysNbrUshortNameKey)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrUshortNameKeyList.size()) {
            throw new IndexOutOfBoundsException("setUsSysNbrUshortNameKey: Index value '" + index + "' not in range [0.." + (this._usSysNbrUshortNameKeyList.size() - 1) + "]");
        }
        
        this._usSysNbrUshortNameKeyList.set(index, new java.lang.Integer(vUsSysNbrUshortNameKey));
    } //-- void setUsSysNbrUshortNameKey(int, int) 

    /**
     * 
     * 
     * @param vUsSysNbrUshortNameKeyArray
     */
    public void setUsSysNbrUshortNameKey(int[] vUsSysNbrUshortNameKeyArray)
    {
        //-- copy array
        _usSysNbrUshortNameKeyList.clear();
        
        for (int i = 0; i < vUsSysNbrUshortNameKeyArray.length; i++) {
                this._usSysNbrUshortNameKeyList.add(new java.lang.Integer(vUsSysNbrUshortNameKeyArray[i]));
        }
    } //-- void setUsSysNbrUshortNameKey(int) 

    /**
     * Sets the value of '_usSysNbrUshortNameKeyList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vUsSysNbrUshortNameKeyList the Vector to copy.
     */
    public void setUsSysNbrUshortNameKey(java.util.List<Integer> vUsSysNbrUshortNameKeyList)
    {
        // copy vector
        this._usSysNbrUshortNameKeyList.clear();
        
        this._usSysNbrUshortNameKeyList.addAll(vUsSysNbrUshortNameKeyList);
    } //-- void setUsSysNbrUshortNameKey(java.util.List) 

    /**
     * Sets the value of '_usSysNbrUshortNameKeyList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param UsSysNbrUshortNameKeyVector the Vector to set.
     */
    public void setUsSysNbrUshortNameKeyAsReference(java.util.Vector<Integer> UsSysNbrUshortNameKeyVector)
    {
        this._usSysNbrUshortNameKeyList = UsSysNbrUshortNameKeyVector;
    } //-- void setUsSysNbrUshortNameKeyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortNameKey_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortNameKey_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortNameKey_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortNameKey_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsSysNbrUshortNameKey_ARRAY unmarshal(java.io.Reader) 

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
