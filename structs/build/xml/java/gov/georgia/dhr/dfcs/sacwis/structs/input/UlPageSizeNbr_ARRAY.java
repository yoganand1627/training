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
 * Class UlPageSizeNbr_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlPageSizeNbr_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulPageSizeNbrList
     */
    private java.util.List<Integer> _ulPageSizeNbrList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlPageSizeNbr_ARRAY() 
     {
        super();
        this._ulPageSizeNbrList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlPageSizeNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlPageSizeNbr(int vUlPageSizeNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulPageSizeNbrList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUlPageSizeNbr has a maximum of 2");
        }
        
        this._ulPageSizeNbrList.add(new java.lang.Integer(vUlPageSizeNbr));
    } //-- void addUlPageSizeNbr(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlPageSizeNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlPageSizeNbr(int index, int vUlPageSizeNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulPageSizeNbrList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUlPageSizeNbr has a maximum of 2");
        }
        
        this._ulPageSizeNbrList.add(index, new java.lang.Integer(vUlPageSizeNbr));
    } //-- void addUlPageSizeNbr(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlPageSizeNbr
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlPageSizeNbr()
    {
        return java.util.Collections.enumeration(this._ulPageSizeNbrList);
    } //-- java.util.Enumeration<Integer> enumerateUlPageSizeNbr() 

    /**
     * Method getUlPageSizeNbr
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlPageSizeNbr(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulPageSizeNbrList.size()) {
            throw new IndexOutOfBoundsException("getUlPageSizeNbr: Index value '" + index + "' not in range [0.." + (this._ulPageSizeNbrList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulPageSizeNbrList.get(index)).intValue();
    } //-- int getUlPageSizeNbr(int) 

    /**
     * Method getUlPageSizeNbr
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlPageSizeNbr()
    {
        int size = this._ulPageSizeNbrList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulPageSizeNbrList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlPageSizeNbr() 

    /**
     * Method getUlPageSizeNbrAsReference
     * 
     * Returns a reference to '_ulPageSizeNbrList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlPageSizeNbrAsReference()
    {
        return this._ulPageSizeNbrList;
    } //-- java.util.List<Integer> getUlPageSizeNbrAsReference() 

    /**
     * Method getUlPageSizeNbrCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlPageSizeNbrCount()
    {
        return this._ulPageSizeNbrList.size();
    } //-- int getUlPageSizeNbrCount() 

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
     * Method iterateUlPageSizeNbr
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlPageSizeNbr()
    {
        return this._ulPageSizeNbrList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlPageSizeNbr() 

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
    public void removeAllUlPageSizeNbr()
    {
        this._ulPageSizeNbrList.clear();
    } //-- void removeAllUlPageSizeNbr() 

    /**
     * Method removeUlPageSizeNbr
     * 
     * 
     * 
     * @param vUlPageSizeNbr
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlPageSizeNbr(int vUlPageSizeNbr)
    {
        boolean removed = _ulPageSizeNbrList.remove(new java.lang.Integer(vUlPageSizeNbr));
        return removed;
    } //-- boolean removeUlPageSizeNbr(int) 

    /**
     * Method removeUlPageSizeNbrAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlPageSizeNbrAt(int index)
    {
        Object obj = this._ulPageSizeNbrList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlPageSizeNbrAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlPageSizeNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlPageSizeNbr(int index, int vUlPageSizeNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulPageSizeNbrList.size()) {
            throw new IndexOutOfBoundsException("setUlPageSizeNbr: Index value '" + index + "' not in range [0.." + (this._ulPageSizeNbrList.size() - 1) + "]");
        }
        
        this._ulPageSizeNbrList.set(index, new java.lang.Integer(vUlPageSizeNbr));
    } //-- void setUlPageSizeNbr(int, int) 

    /**
     * 
     * 
     * @param vUlPageSizeNbrArray
     */
    public void setUlPageSizeNbr(int[] vUlPageSizeNbrArray)
    {
        //-- copy array
        _ulPageSizeNbrList.clear();
        
        for (int i = 0; i < vUlPageSizeNbrArray.length; i++) {
                this._ulPageSizeNbrList.add(new java.lang.Integer(vUlPageSizeNbrArray[i]));
        }
    } //-- void setUlPageSizeNbr(int) 

    /**
     * Sets the value of '_ulPageSizeNbrList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlPageSizeNbrList the Vector to copy.
     */
    public void setUlPageSizeNbr(java.util.List<Integer> vUlPageSizeNbrList)
    {
        // copy vector
        this._ulPageSizeNbrList.clear();
        
        this._ulPageSizeNbrList.addAll(vUlPageSizeNbrList);
    } //-- void setUlPageSizeNbr(java.util.List) 

    /**
     * Sets the value of '_ulPageSizeNbrList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlPageSizeNbrVector the Vector to set.
     */
    public void setUlPageSizeNbrAsReference(java.util.Vector<Integer> UlPageSizeNbrVector)
    {
        this._ulPageSizeNbrList = UlPageSizeNbrVector;
    } //-- void setUlPageSizeNbrAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY unmarshal(java.io.Reader) 

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
