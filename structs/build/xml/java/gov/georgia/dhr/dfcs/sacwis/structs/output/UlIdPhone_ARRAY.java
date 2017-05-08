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
 * Class UlIdPhone_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdPhone_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPhoneList
     */
    private java.util.List<Integer> _ulIdPhoneList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdPhone_ARRAY() 
     {
        super();
        this._ulIdPhoneList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdPhone
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPhone(int vUlIdPhone)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPhoneList.size() >= 15) {
            throw new IndexOutOfBoundsException("addUlIdPhone has a maximum of 15");
        }
        
        this._ulIdPhoneList.add(new java.lang.Integer(vUlIdPhone));
    } //-- void addUlIdPhone(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPhone
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPhone(int index, int vUlIdPhone)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPhoneList.size() >= 15) {
            throw new IndexOutOfBoundsException("addUlIdPhone has a maximum of 15");
        }
        
        this._ulIdPhoneList.add(index, new java.lang.Integer(vUlIdPhone));
    } //-- void addUlIdPhone(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdPhone
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdPhone()
    {
        return java.util.Collections.enumeration(this._ulIdPhoneList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdPhone() 

    /**
     * Method getUlIdPhone
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdPhone(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPhoneList.size()) {
            throw new IndexOutOfBoundsException("getUlIdPhone: Index value '" + index + "' not in range [0.." + (this._ulIdPhoneList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdPhoneList.get(index)).intValue();
    } //-- int getUlIdPhone(int) 

    /**
     * Method getUlIdPhone
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdPhone()
    {
        int size = this._ulIdPhoneList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdPhoneList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdPhone() 

    /**
     * Method getUlIdPhoneAsReference
     * 
     * Returns a reference to '_ulIdPhoneList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdPhoneAsReference()
    {
        return this._ulIdPhoneList;
    } //-- java.util.List<Integer> getUlIdPhoneAsReference() 

    /**
     * Method getUlIdPhoneCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdPhoneCount()
    {
        return this._ulIdPhoneList.size();
    } //-- int getUlIdPhoneCount() 

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
     * Method iterateUlIdPhone
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdPhone()
    {
        return this._ulIdPhoneList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdPhone() 

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
    public void removeAllUlIdPhone()
    {
        this._ulIdPhoneList.clear();
    } //-- void removeAllUlIdPhone() 

    /**
     * Method removeUlIdPhone
     * 
     * 
     * 
     * @param vUlIdPhone
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdPhone(int vUlIdPhone)
    {
        boolean removed = _ulIdPhoneList.remove(new java.lang.Integer(vUlIdPhone));
        return removed;
    } //-- boolean removeUlIdPhone(int) 

    /**
     * Method removeUlIdPhoneAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdPhoneAt(int index)
    {
        Object obj = this._ulIdPhoneList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdPhoneAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPhone
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdPhone(int index, int vUlIdPhone)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPhoneList.size()) {
            throw new IndexOutOfBoundsException("setUlIdPhone: Index value '" + index + "' not in range [0.." + (this._ulIdPhoneList.size() - 1) + "]");
        }
        
        this._ulIdPhoneList.set(index, new java.lang.Integer(vUlIdPhone));
    } //-- void setUlIdPhone(int, int) 

    /**
     * 
     * 
     * @param vUlIdPhoneArray
     */
    public void setUlIdPhone(int[] vUlIdPhoneArray)
    {
        //-- copy array
        _ulIdPhoneList.clear();
        
        for (int i = 0; i < vUlIdPhoneArray.length; i++) {
                this._ulIdPhoneList.add(new java.lang.Integer(vUlIdPhoneArray[i]));
        }
    } //-- void setUlIdPhone(int) 

    /**
     * Sets the value of '_ulIdPhoneList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdPhoneList the Vector to copy.
     */
    public void setUlIdPhone(java.util.List<Integer> vUlIdPhoneList)
    {
        // copy vector
        this._ulIdPhoneList.clear();
        
        this._ulIdPhoneList.addAll(vUlIdPhoneList);
    } //-- void setUlIdPhone(java.util.List) 

    /**
     * Sets the value of '_ulIdPhoneList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdPhoneVector the Vector to set.
     */
    public void setUlIdPhoneAsReference(java.util.Vector<Integer> UlIdPhoneVector)
    {
        this._ulIdPhoneList = UlIdPhoneVector;
    } //-- void setUlIdPhoneAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY unmarshal(java.io.Reader) 

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
