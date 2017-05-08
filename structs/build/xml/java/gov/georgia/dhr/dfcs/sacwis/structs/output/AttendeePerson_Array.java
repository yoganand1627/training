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
 * Class AttendeePerson_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AttendeePerson_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _attendeePersonList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> _attendeePersonList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AttendeePerson_Array() 
     {
        super();
        this._attendeePersonList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAttendeePerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAttendeePerson(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson vAttendeePerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._attendeePersonList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAttendeePerson has a maximum of 100");
        }
        
        this._attendeePersonList.add(vAttendeePerson);
    } //-- void addAttendeePerson(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) 

    /**
     * 
     * 
     * @param index
     * @param vAttendeePerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAttendeePerson(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson vAttendeePerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._attendeePersonList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAttendeePerson has a maximum of 100");
        }
        
        this._attendeePersonList.add(index, vAttendeePerson);
    } //-- void addAttendeePerson(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAttendeePerson
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> enumerateAttendeePerson()
    {
        return java.util.Collections.enumeration(this._attendeePersonList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> enumerateAttendeePerson() 

    /**
     * Method getAttendeePerson
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson getAttendeePerson(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._attendeePersonList.size()) {
            throw new IndexOutOfBoundsException("getAttendeePerson: Index value '" + index + "' not in range [0.." + (this._attendeePersonList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) _attendeePersonList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson getAttendeePerson(int) 

    /**
     * Method getAttendeePerson
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson[] getAttendeePerson()
    {
        int size = this._attendeePersonList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) _attendeePersonList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson[] getAttendeePerson() 

    /**
     * Method getAttendeePersonAsReference
     * 
     * Returns a reference to '_attendeePersonList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> getAttendeePersonAsReference()
    {
        return this._attendeePersonList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> getAttendeePersonAsReference() 

    /**
     * Method getAttendeePersonCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAttendeePersonCount()
    {
        return this._attendeePersonList.size();
    } //-- int getAttendeePersonCount() 

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
     * Method iterateAttendeePerson
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> iterateAttendeePerson()
    {
        return this._attendeePersonList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> iterateAttendeePerson() 

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
    public void removeAllAttendeePerson()
    {
        this._attendeePersonList.clear();
    } //-- void removeAllAttendeePerson() 

    /**
     * Method removeAttendeePerson
     * 
     * 
     * 
     * @param vAttendeePerson
     * @return true if the object was removed from the collection.
     */
    public boolean removeAttendeePerson(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson vAttendeePerson)
    {
        boolean removed = _attendeePersonList.remove(vAttendeePerson);
        return removed;
    } //-- boolean removeAttendeePerson(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) 

    /**
     * Method removeAttendeePersonAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson removeAttendeePersonAt(int index)
    {
        Object obj = this._attendeePersonList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson removeAttendeePersonAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAttendeePerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAttendeePerson(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson vAttendeePerson)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._attendeePersonList.size()) {
            throw new IndexOutOfBoundsException("setAttendeePerson: Index value '" + index + "' not in range [0.." + (this._attendeePersonList.size() - 1) + "]");
        }
        
        this._attendeePersonList.set(index, vAttendeePerson);
    } //-- void setAttendeePerson(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) 

    /**
     * 
     * 
     * @param vAttendeePersonArray
     */
    public void setAttendeePerson(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson[] vAttendeePersonArray)
    {
        //-- copy array
        _attendeePersonList.clear();
        
        for (int i = 0; i < vAttendeePersonArray.length; i++) {
                this._attendeePersonList.add(vAttendeePersonArray[i]);
        }
    } //-- void setAttendeePerson(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson) 

    /**
     * Sets the value of '_attendeePersonList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vAttendeePersonList the Vector to copy.
     */
    public void setAttendeePerson(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> vAttendeePersonList)
    {
        // copy vector
        this._attendeePersonList.clear();
        
        this._attendeePersonList.addAll(vAttendeePersonList);
    } //-- void setAttendeePerson(java.util.List) 

    /**
     * Sets the value of '_attendeePersonList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param AttendeePersonVector the Vector to set.
     */
    public void setAttendeePersonAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson> AttendeePersonVector)
    {
        this._attendeePersonList = AttendeePersonVector;
    } //-- void setAttendeePersonAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array unmarshal(java.io.Reader) 

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
