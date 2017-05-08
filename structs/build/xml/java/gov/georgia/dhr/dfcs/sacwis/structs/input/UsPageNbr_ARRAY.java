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
 * Class UsPageNbr_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UsPageNbr_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usPageNbrList
     */
    private java.util.List<Integer> _usPageNbrList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsPageNbr_ARRAY() 
     {
        super();
        this._usPageNbrList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUsPageNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsPageNbr(int vUsPageNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usPageNbrList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUsPageNbr has a maximum of 2");
        }
        
        this._usPageNbrList.add(new java.lang.Integer(vUsPageNbr));
    } //-- void addUsPageNbr(int) 

    /**
     * 
     * 
     * @param index
     * @param vUsPageNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsPageNbr(int index, int vUsPageNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usPageNbrList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUsPageNbr has a maximum of 2");
        }
        
        this._usPageNbrList.add(index, new java.lang.Integer(vUsPageNbr));
    } //-- void addUsPageNbr(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUsPageNbr
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUsPageNbr()
    {
        return java.util.Collections.enumeration(this._usPageNbrList);
    } //-- java.util.Enumeration<Integer> enumerateUsPageNbr() 

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
     * Method getUsPageNbr
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUsPageNbr(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usPageNbrList.size()) {
            throw new IndexOutOfBoundsException("getUsPageNbr: Index value '" + index + "' not in range [0.." + (this._usPageNbrList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_usPageNbrList.get(index)).intValue();
    } //-- int getUsPageNbr(int) 

    /**
     * Method getUsPageNbr
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUsPageNbr()
    {
        int size = this._usPageNbrList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_usPageNbrList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUsPageNbr() 

    /**
     * Method getUsPageNbrAsReference
     * 
     * Returns a reference to '_usPageNbrList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUsPageNbrAsReference()
    {
        return this._usPageNbrList;
    } //-- java.util.List<Integer> getUsPageNbrAsReference() 

    /**
     * Method getUsPageNbrCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUsPageNbrCount()
    {
        return this._usPageNbrList.size();
    } //-- int getUsPageNbrCount() 

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
     * Method iterateUsPageNbr
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUsPageNbr()
    {
        return this._usPageNbrList.iterator();
    } //-- java.util.Iterator<Integer> iterateUsPageNbr() 

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
    public void removeAllUsPageNbr()
    {
        this._usPageNbrList.clear();
    } //-- void removeAllUsPageNbr() 

    /**
     * Method removeUsPageNbr
     * 
     * 
     * 
     * @param vUsPageNbr
     * @return true if the object was removed from the collection.
     */
    public boolean removeUsPageNbr(int vUsPageNbr)
    {
        boolean removed = _usPageNbrList.remove(new java.lang.Integer(vUsPageNbr));
        return removed;
    } //-- boolean removeUsPageNbr(int) 

    /**
     * Method removeUsPageNbrAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUsPageNbrAt(int index)
    {
        Object obj = this._usPageNbrList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUsPageNbrAt(int) 

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
     * @param vUsPageNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUsPageNbr(int index, int vUsPageNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usPageNbrList.size()) {
            throw new IndexOutOfBoundsException("setUsPageNbr: Index value '" + index + "' not in range [0.." + (this._usPageNbrList.size() - 1) + "]");
        }
        
        this._usPageNbrList.set(index, new java.lang.Integer(vUsPageNbr));
    } //-- void setUsPageNbr(int, int) 

    /**
     * 
     * 
     * @param vUsPageNbrArray
     */
    public void setUsPageNbr(int[] vUsPageNbrArray)
    {
        //-- copy array
        _usPageNbrList.clear();
        
        for (int i = 0; i < vUsPageNbrArray.length; i++) {
                this._usPageNbrList.add(new java.lang.Integer(vUsPageNbrArray[i]));
        }
    } //-- void setUsPageNbr(int) 

    /**
     * Sets the value of '_usPageNbrList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUsPageNbrList the Vector to copy.
     */
    public void setUsPageNbr(java.util.List<Integer> vUsPageNbrList)
    {
        // copy vector
        this._usPageNbrList.clear();
        
        this._usPageNbrList.addAll(vUsPageNbrList);
    } //-- void setUsPageNbr(java.util.List) 

    /**
     * Sets the value of '_usPageNbrList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UsPageNbrVector the Vector to set.
     */
    public void setUsPageNbrAsReference(java.util.Vector<Integer> UsPageNbrVector)
    {
        this._usPageNbrList = UsPageNbrVector;
    } //-- void setUsPageNbrAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY unmarshal(java.io.Reader) 

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
