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
 * Class Attendee_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Attendee_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _attendeeList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> _attendeeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Attendee_Array() 
     {
        super();
        this._attendeeList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAttendee
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAttendee(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee vAttendee)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._attendeeList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAttendee has a maximum of 100");
        }
        
        this._attendeeList.add(vAttendee);
    } //-- void addAttendee(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) 

    /**
     * 
     * 
     * @param index
     * @param vAttendee
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAttendee(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee vAttendee)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._attendeeList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAttendee has a maximum of 100");
        }
        
        this._attendeeList.add(index, vAttendee);
    } //-- void addAttendee(int, gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAttendee
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> enumerateAttendee()
    {
        return java.util.Collections.enumeration(this._attendeeList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> enumerateAttendee() 

    /**
     * Method getAttendee
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee getAttendee(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._attendeeList.size()) {
            throw new IndexOutOfBoundsException("getAttendee: Index value '" + index + "' not in range [0.." + (this._attendeeList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) _attendeeList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee getAttendee(int) 

    /**
     * Method getAttendee
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee[] getAttendee()
    {
        int size = this._attendeeList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) _attendeeList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee[] getAttendee() 

    /**
     * Method getAttendeeAsReference
     * 
     * Returns a reference to '_attendeeList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> getAttendeeAsReference()
    {
        return this._attendeeList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> getAttendeeAsReference() 

    /**
     * Method getAttendeeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAttendeeCount()
    {
        return this._attendeeList.size();
    } //-- int getAttendeeCount() 

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
     * Method iterateAttendee
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> iterateAttendee()
    {
        return this._attendeeList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> iterateAttendee() 

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
    public void removeAllAttendee()
    {
        this._attendeeList.clear();
    } //-- void removeAllAttendee() 

    /**
     * Method removeAttendee
     * 
     * 
     * 
     * @param vAttendee
     * @return true if the object was removed from the collection.
     */
    public boolean removeAttendee(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee vAttendee)
    {
        boolean removed = _attendeeList.remove(vAttendee);
        return removed;
    } //-- boolean removeAttendee(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) 

    /**
     * Method removeAttendeeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee removeAttendeeAt(int index)
    {
        Object obj = this._attendeeList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee removeAttendeeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAttendee
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAttendee(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee vAttendee)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._attendeeList.size()) {
            throw new IndexOutOfBoundsException("setAttendee: Index value '" + index + "' not in range [0.." + (this._attendeeList.size() - 1) + "]");
        }
        
        this._attendeeList.set(index, vAttendee);
    } //-- void setAttendee(int, gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) 

    /**
     * 
     * 
     * @param vAttendeeArray
     */
    public void setAttendee(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee[] vAttendeeArray)
    {
        //-- copy array
        _attendeeList.clear();
        
        for (int i = 0; i < vAttendeeArray.length; i++) {
                this._attendeeList.add(vAttendeeArray[i]);
        }
    } //-- void setAttendee(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee) 

    /**
     * Sets the value of '_attendeeList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vAttendeeList the Vector to copy.
     */
    public void setAttendee(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> vAttendeeList)
    {
        // copy vector
        this._attendeeList.clear();
        
        this._attendeeList.addAll(vAttendeeList);
    } //-- void setAttendee(java.util.List) 

    /**
     * Sets the value of '_attendeeList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param AttendeeVector the Vector to set.
     */
    public void setAttendeeAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee> AttendeeVector)
    {
        this._attendeeList = AttendeeVector;
    } //-- void setAttendeeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array unmarshal(java.io.Reader) 

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
