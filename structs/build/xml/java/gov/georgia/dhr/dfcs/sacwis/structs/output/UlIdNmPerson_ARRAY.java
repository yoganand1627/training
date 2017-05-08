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
 * Class UlIdNmPerson_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdNmPerson_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdNmPersonList
     */
    private java.util.List<Integer> _ulIdNmPersonList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdNmPerson_ARRAY() 
     {
        super();
        this._ulIdNmPersonList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdNmPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdNmPerson(int vUlIdNmPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdNmPersonList.size() >= 200) {
            throw new IndexOutOfBoundsException("addUlIdNmPerson has a maximum of 200");
        }
        
        this._ulIdNmPersonList.add(new java.lang.Integer(vUlIdNmPerson));
    } //-- void addUlIdNmPerson(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdNmPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdNmPerson(int index, int vUlIdNmPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdNmPersonList.size() >= 200) {
            throw new IndexOutOfBoundsException("addUlIdNmPerson has a maximum of 200");
        }
        
        this._ulIdNmPersonList.add(index, new java.lang.Integer(vUlIdNmPerson));
    } //-- void addUlIdNmPerson(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdNmPerson
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdNmPerson()
    {
        return java.util.Collections.enumeration(this._ulIdNmPersonList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdNmPerson() 

    /**
     * Method getUlIdNmPerson
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdNmPerson(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdNmPersonList.size()) {
            throw new IndexOutOfBoundsException("getUlIdNmPerson: Index value '" + index + "' not in range [0.." + (this._ulIdNmPersonList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdNmPersonList.get(index)).intValue();
    } //-- int getUlIdNmPerson(int) 

    /**
     * Method getUlIdNmPerson
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdNmPerson()
    {
        int size = this._ulIdNmPersonList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdNmPersonList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdNmPerson() 

    /**
     * Method getUlIdNmPersonAsReference
     * 
     * Returns a reference to '_ulIdNmPersonList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdNmPersonAsReference()
    {
        return this._ulIdNmPersonList;
    } //-- java.util.List<Integer> getUlIdNmPersonAsReference() 

    /**
     * Method getUlIdNmPersonCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdNmPersonCount()
    {
        return this._ulIdNmPersonList.size();
    } //-- int getUlIdNmPersonCount() 

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
     * Method iterateUlIdNmPerson
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdNmPerson()
    {
        return this._ulIdNmPersonList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdNmPerson() 

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
    public void removeAllUlIdNmPerson()
    {
        this._ulIdNmPersonList.clear();
    } //-- void removeAllUlIdNmPerson() 

    /**
     * Method removeUlIdNmPerson
     * 
     * 
     * 
     * @param vUlIdNmPerson
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdNmPerson(int vUlIdNmPerson)
    {
        boolean removed = _ulIdNmPersonList.remove(new java.lang.Integer(vUlIdNmPerson));
        return removed;
    } //-- boolean removeUlIdNmPerson(int) 

    /**
     * Method removeUlIdNmPersonAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdNmPersonAt(int index)
    {
        Object obj = this._ulIdNmPersonList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdNmPersonAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdNmPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdNmPerson(int index, int vUlIdNmPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdNmPersonList.size()) {
            throw new IndexOutOfBoundsException("setUlIdNmPerson: Index value '" + index + "' not in range [0.." + (this._ulIdNmPersonList.size() - 1) + "]");
        }
        
        this._ulIdNmPersonList.set(index, new java.lang.Integer(vUlIdNmPerson));
    } //-- void setUlIdNmPerson(int, int) 

    /**
     * 
     * 
     * @param vUlIdNmPersonArray
     */
    public void setUlIdNmPerson(int[] vUlIdNmPersonArray)
    {
        //-- copy array
        _ulIdNmPersonList.clear();
        
        for (int i = 0; i < vUlIdNmPersonArray.length; i++) {
                this._ulIdNmPersonList.add(new java.lang.Integer(vUlIdNmPersonArray[i]));
        }
    } //-- void setUlIdNmPerson(int) 

    /**
     * Sets the value of '_ulIdNmPersonList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdNmPersonList the Vector to copy.
     */
    public void setUlIdNmPerson(java.util.List<Integer> vUlIdNmPersonList)
    {
        // copy vector
        this._ulIdNmPersonList.clear();
        
        this._ulIdNmPersonList.addAll(vUlIdNmPersonList);
    } //-- void setUlIdNmPerson(java.util.List) 

    /**
     * Sets the value of '_ulIdNmPersonList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdNmPersonVector the Vector to set.
     */
    public void setUlIdNmPersonAsReference(java.util.Vector<Integer> UlIdNmPersonVector)
    {
        this._ulIdNmPersonList = UlIdNmPersonVector;
    } //-- void setUlIdNmPersonAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY unmarshal(java.io.Reader) 

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
