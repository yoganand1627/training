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
 * Class LdIdAddress_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LdIdAddress_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ldIdAddressList
     */
    private java.util.List<Integer> _ldIdAddressList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LdIdAddress_ARRAY() 
     {
        super();
        this._ldIdAddressList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLdIdAddress
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLdIdAddress(int vLdIdAddress)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ldIdAddressList.size() >= 15) {
            throw new IndexOutOfBoundsException("addLdIdAddress has a maximum of 15");
        }
        
        this._ldIdAddressList.add(new java.lang.Integer(vLdIdAddress));
    } //-- void addLdIdAddress(int) 

    /**
     * 
     * 
     * @param index
     * @param vLdIdAddress
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLdIdAddress(int index, int vLdIdAddress)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ldIdAddressList.size() >= 15) {
            throw new IndexOutOfBoundsException("addLdIdAddress has a maximum of 15");
        }
        
        this._ldIdAddressList.add(index, new java.lang.Integer(vLdIdAddress));
    } //-- void addLdIdAddress(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateLdIdAddress
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateLdIdAddress()
    {
        return java.util.Collections.enumeration(this._ldIdAddressList);
    } //-- java.util.Enumeration<Integer> enumerateLdIdAddress() 

    /**
     * Method getLdIdAddress
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getLdIdAddress(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ldIdAddressList.size()) {
            throw new IndexOutOfBoundsException("getLdIdAddress: Index value '" + index + "' not in range [0.." + (this._ldIdAddressList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ldIdAddressList.get(index)).intValue();
    } //-- int getLdIdAddress(int) 

    /**
     * Method getLdIdAddress
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getLdIdAddress()
    {
        int size = this._ldIdAddressList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ldIdAddressList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getLdIdAddress() 

    /**
     * Method getLdIdAddressAsReference
     * 
     * Returns a reference to '_ldIdAddressList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getLdIdAddressAsReference()
    {
        return this._ldIdAddressList;
    } //-- java.util.List<Integer> getLdIdAddressAsReference() 

    /**
     * Method getLdIdAddressCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getLdIdAddressCount()
    {
        return this._ldIdAddressList.size();
    } //-- int getLdIdAddressCount() 

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
     * Method iterateLdIdAddress
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateLdIdAddress()
    {
        return this._ldIdAddressList.iterator();
    } //-- java.util.Iterator<Integer> iterateLdIdAddress() 

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
    public void removeAllLdIdAddress()
    {
        this._ldIdAddressList.clear();
    } //-- void removeAllLdIdAddress() 

    /**
     * Method removeLdIdAddress
     * 
     * 
     * 
     * @param vLdIdAddress
     * @return true if the object was removed from the collection.
     */
    public boolean removeLdIdAddress(int vLdIdAddress)
    {
        boolean removed = _ldIdAddressList.remove(new java.lang.Integer(vLdIdAddress));
        return removed;
    } //-- boolean removeLdIdAddress(int) 

    /**
     * Method removeLdIdAddressAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeLdIdAddressAt(int index)
    {
        Object obj = this._ldIdAddressList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeLdIdAddressAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vLdIdAddress
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLdIdAddress(int index, int vLdIdAddress)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ldIdAddressList.size()) {
            throw new IndexOutOfBoundsException("setLdIdAddress: Index value '" + index + "' not in range [0.." + (this._ldIdAddressList.size() - 1) + "]");
        }
        
        this._ldIdAddressList.set(index, new java.lang.Integer(vLdIdAddress));
    } //-- void setLdIdAddress(int, int) 

    /**
     * 
     * 
     * @param vLdIdAddressArray
     */
    public void setLdIdAddress(int[] vLdIdAddressArray)
    {
        //-- copy array
        _ldIdAddressList.clear();
        
        for (int i = 0; i < vLdIdAddressArray.length; i++) {
                this._ldIdAddressList.add(new java.lang.Integer(vLdIdAddressArray[i]));
        }
    } //-- void setLdIdAddress(int) 

    /**
     * Sets the value of '_ldIdAddressList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vLdIdAddressList the Vector to copy.
     */
    public void setLdIdAddress(java.util.List<Integer> vLdIdAddressList)
    {
        // copy vector
        this._ldIdAddressList.clear();
        
        this._ldIdAddressList.addAll(vLdIdAddressList);
    } //-- void setLdIdAddress(java.util.List) 

    /**
     * Sets the value of '_ldIdAddressList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param LdIdAddressVector the Vector to set.
     */
    public void setLdIdAddressAsReference(java.util.Vector<Integer> LdIdAddressVector)
    {
        this._ldIdAddressList = LdIdAddressVector;
    } //-- void setLdIdAddressAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY unmarshal(java.io.Reader) 

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
