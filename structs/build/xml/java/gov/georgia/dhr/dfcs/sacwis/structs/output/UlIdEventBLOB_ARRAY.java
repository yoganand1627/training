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
 * Class UlIdEventBLOB_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdEventBLOB_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdEventBLOBList
     */
    private java.util.List<Integer> _ulIdEventBLOBList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdEventBLOB_ARRAY() 
     {
        super();
        this._ulIdEventBLOBList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdEventBLOB
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdEventBLOB(int vUlIdEventBLOB)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdEventBLOBList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUlIdEventBLOB has a maximum of 2");
        }
        
        this._ulIdEventBLOBList.add(new java.lang.Integer(vUlIdEventBLOB));
    } //-- void addUlIdEventBLOB(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdEventBLOB
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdEventBLOB(int index, int vUlIdEventBLOB)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdEventBLOBList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUlIdEventBLOB has a maximum of 2");
        }
        
        this._ulIdEventBLOBList.add(index, new java.lang.Integer(vUlIdEventBLOB));
    } //-- void addUlIdEventBLOB(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdEventBLOB
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdEventBLOB()
    {
        return java.util.Collections.enumeration(this._ulIdEventBLOBList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdEventBLOB() 

    /**
     * Method getUlIdEventBLOB
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdEventBLOB(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdEventBLOBList.size()) {
            throw new IndexOutOfBoundsException("getUlIdEventBLOB: Index value '" + index + "' not in range [0.." + (this._ulIdEventBLOBList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdEventBLOBList.get(index)).intValue();
    } //-- int getUlIdEventBLOB(int) 

    /**
     * Method getUlIdEventBLOB
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdEventBLOB()
    {
        int size = this._ulIdEventBLOBList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdEventBLOBList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdEventBLOB() 

    /**
     * Method getUlIdEventBLOBAsReference
     * 
     * Returns a reference to '_ulIdEventBLOBList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdEventBLOBAsReference()
    {
        return this._ulIdEventBLOBList;
    } //-- java.util.List<Integer> getUlIdEventBLOBAsReference() 

    /**
     * Method getUlIdEventBLOBCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdEventBLOBCount()
    {
        return this._ulIdEventBLOBList.size();
    } //-- int getUlIdEventBLOBCount() 

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
     * Method iterateUlIdEventBLOB
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdEventBLOB()
    {
        return this._ulIdEventBLOBList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdEventBLOB() 

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
    public void removeAllUlIdEventBLOB()
    {
        this._ulIdEventBLOBList.clear();
    } //-- void removeAllUlIdEventBLOB() 

    /**
     * Method removeUlIdEventBLOB
     * 
     * 
     * 
     * @param vUlIdEventBLOB
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdEventBLOB(int vUlIdEventBLOB)
    {
        boolean removed = _ulIdEventBLOBList.remove(new java.lang.Integer(vUlIdEventBLOB));
        return removed;
    } //-- boolean removeUlIdEventBLOB(int) 

    /**
     * Method removeUlIdEventBLOBAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdEventBLOBAt(int index)
    {
        Object obj = this._ulIdEventBLOBList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdEventBLOBAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdEventBLOB
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdEventBLOB(int index, int vUlIdEventBLOB)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdEventBLOBList.size()) {
            throw new IndexOutOfBoundsException("setUlIdEventBLOB: Index value '" + index + "' not in range [0.." + (this._ulIdEventBLOBList.size() - 1) + "]");
        }
        
        this._ulIdEventBLOBList.set(index, new java.lang.Integer(vUlIdEventBLOB));
    } //-- void setUlIdEventBLOB(int, int) 

    /**
     * 
     * 
     * @param vUlIdEventBLOBArray
     */
    public void setUlIdEventBLOB(int[] vUlIdEventBLOBArray)
    {
        //-- copy array
        _ulIdEventBLOBList.clear();
        
        for (int i = 0; i < vUlIdEventBLOBArray.length; i++) {
                this._ulIdEventBLOBList.add(new java.lang.Integer(vUlIdEventBLOBArray[i]));
        }
    } //-- void setUlIdEventBLOB(int) 

    /**
     * Sets the value of '_ulIdEventBLOBList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdEventBLOBList the Vector to copy.
     */
    public void setUlIdEventBLOB(java.util.List<Integer> vUlIdEventBLOBList)
    {
        // copy vector
        this._ulIdEventBLOBList.clear();
        
        this._ulIdEventBLOBList.addAll(vUlIdEventBLOBList);
    } //-- void setUlIdEventBLOB(java.util.List) 

    /**
     * Sets the value of '_ulIdEventBLOBList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdEventBLOBVector the Vector to set.
     */
    public void setUlIdEventBLOBAsReference(java.util.Vector<Integer> UlIdEventBLOBVector)
    {
        this._ulIdEventBLOBList = UlIdEventBLOBVector;
    } //-- void setUlIdEventBLOBAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY unmarshal(java.io.Reader) 

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
