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
 * Class UlIdPerson_ARRAY_CCMN29SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdPerson_ARRAY_CCMN29SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPersonList
     */
    private java.util.List<Integer> _ulIdPersonList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdPerson_ARRAY_CCMN29SI() 
     {
        super();
        this._ulIdPersonList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPerson(int vUlIdPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPersonList.size() >= 11) {
            throw new IndexOutOfBoundsException("addUlIdPerson has a maximum of 11");
        }
        
        this._ulIdPersonList.add(new java.lang.Integer(vUlIdPerson));
    } //-- void addUlIdPerson(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPerson(int index, int vUlIdPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPersonList.size() >= 11) {
            throw new IndexOutOfBoundsException("addUlIdPerson has a maximum of 11");
        }
        
        this._ulIdPersonList.add(index, new java.lang.Integer(vUlIdPerson));
    } //-- void addUlIdPerson(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdPerson
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdPerson()
    {
        return java.util.Collections.enumeration(this._ulIdPersonList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdPerson() 

    /**
     * Method getUlIdPerson
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdPerson(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPersonList.size()) {
            throw new IndexOutOfBoundsException("getUlIdPerson: Index value '" + index + "' not in range [0.." + (this._ulIdPersonList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdPersonList.get(index)).intValue();
    } //-- int getUlIdPerson(int) 

    /**
     * Method getUlIdPerson
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdPerson()
    {
        int size = this._ulIdPersonList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdPersonList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdPerson() 

    /**
     * Method getUlIdPersonAsReference
     * 
     * Returns a reference to '_ulIdPersonList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdPersonAsReference()
    {
        return this._ulIdPersonList;
    } //-- java.util.List<Integer> getUlIdPersonAsReference() 

    /**
     * Method getUlIdPersonCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdPersonCount()
    {
        return this._ulIdPersonList.size();
    } //-- int getUlIdPersonCount() 

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
     * Method iterateUlIdPerson
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdPerson()
    {
        return this._ulIdPersonList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdPerson() 

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
    public void removeAllUlIdPerson()
    {
        this._ulIdPersonList.clear();
    } //-- void removeAllUlIdPerson() 

    /**
     * Method removeUlIdPerson
     * 
     * 
     * 
     * @param vUlIdPerson
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdPerson(int vUlIdPerson)
    {
        boolean removed = _ulIdPersonList.remove(new java.lang.Integer(vUlIdPerson));
        return removed;
    } //-- boolean removeUlIdPerson(int) 

    /**
     * Method removeUlIdPersonAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdPersonAt(int index)
    {
        Object obj = this._ulIdPersonList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdPersonAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdPerson(int index, int vUlIdPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPersonList.size()) {
            throw new IndexOutOfBoundsException("setUlIdPerson: Index value '" + index + "' not in range [0.." + (this._ulIdPersonList.size() - 1) + "]");
        }
        
        this._ulIdPersonList.set(index, new java.lang.Integer(vUlIdPerson));
    } //-- void setUlIdPerson(int, int) 

    /**
     * 
     * 
     * @param vUlIdPersonArray
     */
    public void setUlIdPerson(int[] vUlIdPersonArray)
    {
        //-- copy array
        _ulIdPersonList.clear();
        
        for (int i = 0; i < vUlIdPersonArray.length; i++) {
                this._ulIdPersonList.add(new java.lang.Integer(vUlIdPersonArray[i]));
        }
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of '_ulIdPersonList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdPersonList the Vector to copy.
     */
    public void setUlIdPerson(java.util.List<Integer> vUlIdPersonList)
    {
        // copy vector
        this._ulIdPersonList.clear();
        
        this._ulIdPersonList.addAll(vUlIdPersonList);
    } //-- void setUlIdPerson(java.util.List) 

    /**
     * Sets the value of '_ulIdPersonList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdPersonVector the Vector to set.
     */
    public void setUlIdPersonAsReference(java.util.Vector<Integer> UlIdPersonVector)
    {
        this._ulIdPersonList = UlIdPersonVector;
    } //-- void setUlIdPersonAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI unmarshal(java.io.Reader) 

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
