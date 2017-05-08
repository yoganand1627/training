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
 * Class UlIdPersonId_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdPersonId_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPersonIdList
     */
    private java.util.List<Integer> _ulIdPersonIdList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdPersonId_ARRAY() 
     {
        super();
        this._ulIdPersonIdList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdPersonId
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPersonId(int vUlIdPersonId)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPersonIdList.size() >= 65) {
            throw new IndexOutOfBoundsException("addUlIdPersonId has a maximum of 65");
        }
        
        this._ulIdPersonIdList.add(new java.lang.Integer(vUlIdPersonId));
    } //-- void addUlIdPersonId(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPersonId
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdPersonId(int index, int vUlIdPersonId)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdPersonIdList.size() >= 65) {
            throw new IndexOutOfBoundsException("addUlIdPersonId has a maximum of 65");
        }
        
        this._ulIdPersonIdList.add(index, new java.lang.Integer(vUlIdPersonId));
    } //-- void addUlIdPersonId(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdPersonId
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdPersonId()
    {
        return java.util.Collections.enumeration(this._ulIdPersonIdList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdPersonId() 

    /**
     * Method getUlIdPersonId
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdPersonId(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPersonIdList.size()) {
            throw new IndexOutOfBoundsException("getUlIdPersonId: Index value '" + index + "' not in range [0.." + (this._ulIdPersonIdList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdPersonIdList.get(index)).intValue();
    } //-- int getUlIdPersonId(int) 

    /**
     * Method getUlIdPersonId
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdPersonId()
    {
        int size = this._ulIdPersonIdList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdPersonIdList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdPersonId() 

    /**
     * Method getUlIdPersonIdAsReference
     * 
     * Returns a reference to '_ulIdPersonIdList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdPersonIdAsReference()
    {
        return this._ulIdPersonIdList;
    } //-- java.util.List<Integer> getUlIdPersonIdAsReference() 

    /**
     * Method getUlIdPersonIdCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdPersonIdCount()
    {
        return this._ulIdPersonIdList.size();
    } //-- int getUlIdPersonIdCount() 

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
     * Method iterateUlIdPersonId
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdPersonId()
    {
        return this._ulIdPersonIdList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdPersonId() 

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
    public void removeAllUlIdPersonId()
    {
        this._ulIdPersonIdList.clear();
    } //-- void removeAllUlIdPersonId() 

    /**
     * Method removeUlIdPersonId
     * 
     * 
     * 
     * @param vUlIdPersonId
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdPersonId(int vUlIdPersonId)
    {
        boolean removed = _ulIdPersonIdList.remove(new java.lang.Integer(vUlIdPersonId));
        return removed;
    } //-- boolean removeUlIdPersonId(int) 

    /**
     * Method removeUlIdPersonIdAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdPersonIdAt(int index)
    {
        Object obj = this._ulIdPersonIdList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdPersonIdAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdPersonId
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdPersonId(int index, int vUlIdPersonId)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdPersonIdList.size()) {
            throw new IndexOutOfBoundsException("setUlIdPersonId: Index value '" + index + "' not in range [0.." + (this._ulIdPersonIdList.size() - 1) + "]");
        }
        
        this._ulIdPersonIdList.set(index, new java.lang.Integer(vUlIdPersonId));
    } //-- void setUlIdPersonId(int, int) 

    /**
     * 
     * 
     * @param vUlIdPersonIdArray
     */
    public void setUlIdPersonId(int[] vUlIdPersonIdArray)
    {
        //-- copy array
        _ulIdPersonIdList.clear();
        
        for (int i = 0; i < vUlIdPersonIdArray.length; i++) {
                this._ulIdPersonIdList.add(new java.lang.Integer(vUlIdPersonIdArray[i]));
        }
    } //-- void setUlIdPersonId(int) 

    /**
     * Sets the value of '_ulIdPersonIdList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdPersonIdList the Vector to copy.
     */
    public void setUlIdPersonId(java.util.List<Integer> vUlIdPersonIdList)
    {
        // copy vector
        this._ulIdPersonIdList.clear();
        
        this._ulIdPersonIdList.addAll(vUlIdPersonIdList);
    } //-- void setUlIdPersonId(java.util.List) 

    /**
     * Sets the value of '_ulIdPersonIdList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdPersonIdVector the Vector to set.
     */
    public void setUlIdPersonIdAsReference(java.util.Vector<Integer> UlIdPersonIdVector)
    {
        this._ulIdPersonIdList = UlIdPersonIdVector;
    } //-- void setUlIdPersonIdAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY unmarshal(java.io.Reader) 

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
