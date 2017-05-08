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
 * Class CallListStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallListStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _callListStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> _callListStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallListStruct_ARRAY() 
     {
        super();
        this._callListStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCallListStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCallListStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct vCallListStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._callListStructList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCallListStruct has a maximum of 50");
        }
        
        this._callListStructList.add(vCallListStruct);
    } //-- void addCallListStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) 

    /**
     * 
     * 
     * @param index
     * @param vCallListStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCallListStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct vCallListStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._callListStructList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCallListStruct has a maximum of 50");
        }
        
        this._callListStructList.add(index, vCallListStruct);
    } //-- void addCallListStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCallListStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> enumerateCallListStruct()
    {
        return java.util.Collections.enumeration(this._callListStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> enumerateCallListStruct() 

    /**
     * Method getCallListStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct getCallListStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._callListStructList.size()) {
            throw new IndexOutOfBoundsException("getCallListStruct: Index value '" + index + "' not in range [0.." + (this._callListStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) _callListStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct getCallListStruct(int) 

    /**
     * Method getCallListStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct[] getCallListStruct()
    {
        int size = this._callListStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) _callListStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct[] getCallListStruct() 

    /**
     * Method getCallListStructAsReference
     * 
     * Returns a reference to '_callListStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> getCallListStructAsReference()
    {
        return this._callListStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> getCallListStructAsReference() 

    /**
     * Method getCallListStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCallListStructCount()
    {
        return this._callListStructList.size();
    } //-- int getCallListStructCount() 

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
     * Method iterateCallListStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> iterateCallListStruct()
    {
        return this._callListStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> iterateCallListStruct() 

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
    public void removeAllCallListStruct()
    {
        this._callListStructList.clear();
    } //-- void removeAllCallListStruct() 

    /**
     * Method removeCallListStruct
     * 
     * 
     * 
     * @param vCallListStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeCallListStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct vCallListStruct)
    {
        boolean removed = _callListStructList.remove(vCallListStruct);
        return removed;
    } //-- boolean removeCallListStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) 

    /**
     * Method removeCallListStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct removeCallListStructAt(int index)
    {
        Object obj = this._callListStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct removeCallListStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCallListStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCallListStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct vCallListStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._callListStructList.size()) {
            throw new IndexOutOfBoundsException("setCallListStruct: Index value '" + index + "' not in range [0.." + (this._callListStructList.size() - 1) + "]");
        }
        
        this._callListStructList.set(index, vCallListStruct);
    } //-- void setCallListStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) 

    /**
     * 
     * 
     * @param vCallListStructArray
     */
    public void setCallListStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct[] vCallListStructArray)
    {
        //-- copy array
        _callListStructList.clear();
        
        for (int i = 0; i < vCallListStructArray.length; i++) {
                this._callListStructList.add(vCallListStructArray[i]);
        }
    } //-- void setCallListStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct) 

    /**
     * Sets the value of '_callListStructList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCallListStructList the Vector to copy.
     */
    public void setCallListStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> vCallListStructList)
    {
        // copy vector
        this._callListStructList.clear();
        
        this._callListStructList.addAll(vCallListStructList);
    } //-- void setCallListStruct(java.util.List) 

    /**
     * Sets the value of '_callListStructList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CallListStructVector the Vector to set.
     */
    public void setCallListStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct> CallListStructVector)
    {
        this._callListStructList = CallListStructVector;
    } //-- void setCallListStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY unmarshal(java.io.Reader) 

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
