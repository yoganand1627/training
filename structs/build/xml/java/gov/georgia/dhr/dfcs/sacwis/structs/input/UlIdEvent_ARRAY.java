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
 * Class UlIdEvent_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdEvent_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdEventList
     */
    private java.util.List<Integer> _ulIdEventList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdEvent_ARRAY() 
     {
        super();
        this._ulIdEventList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdEvent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdEvent(int vUlIdEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdEventList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUlIdEvent has a maximum of 2");
        }
        
        this._ulIdEventList.add(new java.lang.Integer(vUlIdEvent));
    } //-- void addUlIdEvent(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdEvent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdEvent(int index, int vUlIdEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdEventList.size() >= 2) {
            throw new IndexOutOfBoundsException("addUlIdEvent has a maximum of 2");
        }
        
        this._ulIdEventList.add(index, new java.lang.Integer(vUlIdEvent));
    } //-- void addUlIdEvent(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdEvent
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdEvent()
    {
        return java.util.Collections.enumeration(this._ulIdEventList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdEvent() 

    /**
     * Method getUlIdEvent
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdEvent(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdEventList.size()) {
            throw new IndexOutOfBoundsException("getUlIdEvent: Index value '" + index + "' not in range [0.." + (this._ulIdEventList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdEventList.get(index)).intValue();
    } //-- int getUlIdEvent(int) 

    /**
     * Method getUlIdEvent
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdEvent()
    {
        int size = this._ulIdEventList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdEventList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdEvent() 

    /**
     * Method getUlIdEventAsReference
     * 
     * Returns a reference to '_ulIdEventList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdEventAsReference()
    {
        return this._ulIdEventList;
    } //-- java.util.List<Integer> getUlIdEventAsReference() 

    /**
     * Method getUlIdEventCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdEventCount()
    {
        return this._ulIdEventList.size();
    } //-- int getUlIdEventCount() 

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
     * Method iterateUlIdEvent
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdEvent()
    {
        return this._ulIdEventList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdEvent() 

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
    public void removeAllUlIdEvent()
    {
        this._ulIdEventList.clear();
    } //-- void removeAllUlIdEvent() 

    /**
     * Method removeUlIdEvent
     * 
     * 
     * 
     * @param vUlIdEvent
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdEvent(int vUlIdEvent)
    {
        boolean removed = _ulIdEventList.remove(new java.lang.Integer(vUlIdEvent));
        return removed;
    } //-- boolean removeUlIdEvent(int) 

    /**
     * Method removeUlIdEventAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdEventAt(int index)
    {
        Object obj = this._ulIdEventList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdEventAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdEvent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdEvent(int index, int vUlIdEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdEventList.size()) {
            throw new IndexOutOfBoundsException("setUlIdEvent: Index value '" + index + "' not in range [0.." + (this._ulIdEventList.size() - 1) + "]");
        }
        
        this._ulIdEventList.set(index, new java.lang.Integer(vUlIdEvent));
    } //-- void setUlIdEvent(int, int) 

    /**
     * 
     * 
     * @param vUlIdEventArray
     */
    public void setUlIdEvent(int[] vUlIdEventArray)
    {
        //-- copy array
        _ulIdEventList.clear();
        
        for (int i = 0; i < vUlIdEventArray.length; i++) {
                this._ulIdEventList.add(new java.lang.Integer(vUlIdEventArray[i]));
        }
    } //-- void setUlIdEvent(int) 

    /**
     * Sets the value of '_ulIdEventList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdEventList the Vector to copy.
     */
    public void setUlIdEvent(java.util.List<Integer> vUlIdEventList)
    {
        // copy vector
        this._ulIdEventList.clear();
        
        this._ulIdEventList.addAll(vUlIdEventList);
    } //-- void setUlIdEvent(java.util.List) 

    /**
     * Sets the value of '_ulIdEventList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdEventVector the Vector to set.
     */
    public void setUlIdEventAsReference(java.util.Vector<Integer> UlIdEventVector)
    {
        this._ulIdEventList = UlIdEventVector;
    } //-- void setUlIdEventAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY unmarshal(java.io.Reader) 

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
