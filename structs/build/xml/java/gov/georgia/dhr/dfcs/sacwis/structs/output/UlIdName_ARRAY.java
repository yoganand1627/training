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
 * Class UlIdName_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdName_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdNameList
     */
    private java.util.List<Integer> _ulIdNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdName_ARRAY() 
     {
        super();
        this._ulIdNameList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdName(int vUlIdName)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdNameList.size() >= 10) {
            throw new IndexOutOfBoundsException("addUlIdName has a maximum of 10");
        }
        
        this._ulIdNameList.add(new java.lang.Integer(vUlIdName));
    } //-- void addUlIdName(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdName(int index, int vUlIdName)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdNameList.size() >= 10) {
            throw new IndexOutOfBoundsException("addUlIdName has a maximum of 10");
        }
        
        this._ulIdNameList.add(index, new java.lang.Integer(vUlIdName));
    } //-- void addUlIdName(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdName
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdName()
    {
        return java.util.Collections.enumeration(this._ulIdNameList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdName() 

    /**
     * Method getUlIdName
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdName(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdNameList.size()) {
            throw new IndexOutOfBoundsException("getUlIdName: Index value '" + index + "' not in range [0.." + (this._ulIdNameList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdNameList.get(index)).intValue();
    } //-- int getUlIdName(int) 

    /**
     * Method getUlIdName
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdName()
    {
        int size = this._ulIdNameList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdNameList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdName() 

    /**
     * Method getUlIdNameAsReference
     * 
     * Returns a reference to '_ulIdNameList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdNameAsReference()
    {
        return this._ulIdNameList;
    } //-- java.util.List<Integer> getUlIdNameAsReference() 

    /**
     * Method getUlIdNameCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdNameCount()
    {
        return this._ulIdNameList.size();
    } //-- int getUlIdNameCount() 

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
     * Method iterateUlIdName
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdName()
    {
        return this._ulIdNameList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdName() 

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
    public void removeAllUlIdName()
    {
        this._ulIdNameList.clear();
    } //-- void removeAllUlIdName() 

    /**
     * Method removeUlIdName
     * 
     * 
     * 
     * @param vUlIdName
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdName(int vUlIdName)
    {
        boolean removed = _ulIdNameList.remove(new java.lang.Integer(vUlIdName));
        return removed;
    } //-- boolean removeUlIdName(int) 

    /**
     * Method removeUlIdNameAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdNameAt(int index)
    {
        Object obj = this._ulIdNameList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdNameAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdName(int index, int vUlIdName)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdNameList.size()) {
            throw new IndexOutOfBoundsException("setUlIdName: Index value '" + index + "' not in range [0.." + (this._ulIdNameList.size() - 1) + "]");
        }
        
        this._ulIdNameList.set(index, new java.lang.Integer(vUlIdName));
    } //-- void setUlIdName(int, int) 

    /**
     * 
     * 
     * @param vUlIdNameArray
     */
    public void setUlIdName(int[] vUlIdNameArray)
    {
        //-- copy array
        _ulIdNameList.clear();
        
        for (int i = 0; i < vUlIdNameArray.length; i++) {
                this._ulIdNameList.add(new java.lang.Integer(vUlIdNameArray[i]));
        }
    } //-- void setUlIdName(int) 

    /**
     * Sets the value of '_ulIdNameList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdNameList the Vector to copy.
     */
    public void setUlIdName(java.util.List<Integer> vUlIdNameList)
    {
        // copy vector
        this._ulIdNameList.clear();
        
        this._ulIdNameList.addAll(vUlIdNameList);
    } //-- void setUlIdName(java.util.List) 

    /**
     * Sets the value of '_ulIdNameList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param UlIdNameVector the Vector to set.
     */
    public void setUlIdNameAsReference(java.util.Vector<Integer> UlIdNameVector)
    {
        this._ulIdNameList = UlIdNameVector;
    } //-- void setUlIdNameAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY unmarshal(java.io.Reader) 

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
