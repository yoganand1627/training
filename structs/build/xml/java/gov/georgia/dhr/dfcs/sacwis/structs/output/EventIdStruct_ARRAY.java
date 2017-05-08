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
 * Class EventIdStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EventIdStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _eventIdStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> _eventIdStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EventIdStruct_ARRAY() 
     {
        super();
        this._eventIdStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vEventIdStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEventIdStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct vEventIdStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._eventIdStructList.size() >= 500) {
            throw new IndexOutOfBoundsException("addEventIdStruct has a maximum of 500");
        }
        
        this._eventIdStructList.add(vEventIdStruct);
    } //-- void addEventIdStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) 

    /**
     * 
     * 
     * @param index
     * @param vEventIdStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEventIdStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct vEventIdStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._eventIdStructList.size() >= 500) {
            throw new IndexOutOfBoundsException("addEventIdStruct has a maximum of 500");
        }
        
        this._eventIdStructList.add(index, vEventIdStruct);
    } //-- void addEventIdStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateEventIdStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> enumerateEventIdStruct()
    {
        return java.util.Collections.enumeration(this._eventIdStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> enumerateEventIdStruct() 

    /**
     * Method getEventIdStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct getEventIdStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._eventIdStructList.size()) {
            throw new IndexOutOfBoundsException("getEventIdStruct: Index value '" + index + "' not in range [0.." + (this._eventIdStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) _eventIdStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct getEventIdStruct(int) 

    /**
     * Method getEventIdStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct[] getEventIdStruct()
    {
        int size = this._eventIdStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) _eventIdStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct[] getEventIdStruct() 

    /**
     * Method getEventIdStructAsReference
     * 
     * Returns a reference to '_eventIdStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> getEventIdStructAsReference()
    {
        return this._eventIdStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> getEventIdStructAsReference() 

    /**
     * Method getEventIdStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getEventIdStructCount()
    {
        return this._eventIdStructList.size();
    } //-- int getEventIdStructCount() 

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
     * Method iterateEventIdStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> iterateEventIdStruct()
    {
        return this._eventIdStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> iterateEventIdStruct() 

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
    public void removeAllEventIdStruct()
    {
        this._eventIdStructList.clear();
    } //-- void removeAllEventIdStruct() 

    /**
     * Method removeEventIdStruct
     * 
     * 
     * 
     * @param vEventIdStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeEventIdStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct vEventIdStruct)
    {
        boolean removed = _eventIdStructList.remove(vEventIdStruct);
        return removed;
    } //-- boolean removeEventIdStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) 

    /**
     * Method removeEventIdStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct removeEventIdStructAt(int index)
    {
        Object obj = this._eventIdStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct removeEventIdStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vEventIdStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEventIdStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct vEventIdStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._eventIdStructList.size()) {
            throw new IndexOutOfBoundsException("setEventIdStruct: Index value '" + index + "' not in range [0.." + (this._eventIdStructList.size() - 1) + "]");
        }
        
        this._eventIdStructList.set(index, vEventIdStruct);
    } //-- void setEventIdStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) 

    /**
     * 
     * 
     * @param vEventIdStructArray
     */
    public void setEventIdStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct[] vEventIdStructArray)
    {
        //-- copy array
        _eventIdStructList.clear();
        
        for (int i = 0; i < vEventIdStructArray.length; i++) {
                this._eventIdStructList.add(vEventIdStructArray[i]);
        }
    } //-- void setEventIdStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) 

    /**
     * Sets the value of '_eventIdStructList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vEventIdStructList the Vector to copy.
     */
    public void setEventIdStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> vEventIdStructList)
    {
        // copy vector
        this._eventIdStructList.clear();
        
        this._eventIdStructList.addAll(vEventIdStructList);
    } //-- void setEventIdStruct(java.util.List) 

    /**
     * Sets the value of '_eventIdStructList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param EventIdStructVector the Vector to set.
     */
    public void setEventIdStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct> EventIdStructVector)
    {
        this._eventIdStructList = EventIdStructVector;
    } //-- void setEventIdStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY unmarshal(java.io.Reader) 

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
