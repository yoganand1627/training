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
 * Class ContactCbxDisplay_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContactCbxDisplay_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _contactCbxDisplayList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> _contactCbxDisplayList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContactCbxDisplay_Array() 
     {
        super();
        this._contactCbxDisplayList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContactCbxDisplay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContactCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay vContactCbxDisplay)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._contactCbxDisplayList.size() >= 100) {
            throw new IndexOutOfBoundsException("addContactCbxDisplay has a maximum of 100");
        }
        
        this._contactCbxDisplayList.add(vContactCbxDisplay);
    } //-- void addContactCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) 

    /**
     * 
     * 
     * @param index
     * @param vContactCbxDisplay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContactCbxDisplay(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay vContactCbxDisplay)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._contactCbxDisplayList.size() >= 100) {
            throw new IndexOutOfBoundsException("addContactCbxDisplay has a maximum of 100");
        }
        
        this._contactCbxDisplayList.add(index, vContactCbxDisplay);
    } //-- void addContactCbxDisplay(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateContactCbxDisplay
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> enumerateContactCbxDisplay()
    {
        return java.util.Collections.enumeration(this._contactCbxDisplayList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> enumerateContactCbxDisplay() 

    /**
     * Method getContactCbxDisplay
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay getContactCbxDisplay(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._contactCbxDisplayList.size()) {
            throw new IndexOutOfBoundsException("getContactCbxDisplay: Index value '" + index + "' not in range [0.." + (this._contactCbxDisplayList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) _contactCbxDisplayList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay getContactCbxDisplay(int) 

    /**
     * Method getContactCbxDisplay
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay[] getContactCbxDisplay()
    {
        int size = this._contactCbxDisplayList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) _contactCbxDisplayList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay[] getContactCbxDisplay() 

    /**
     * Method getContactCbxDisplayAsReference
     * 
     * Returns a reference to '_contactCbxDisplayList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> getContactCbxDisplayAsReference()
    {
        return this._contactCbxDisplayList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> getContactCbxDisplayAsReference() 

    /**
     * Method getContactCbxDisplayCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getContactCbxDisplayCount()
    {
        return this._contactCbxDisplayList.size();
    } //-- int getContactCbxDisplayCount() 

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
     * Method iterateContactCbxDisplay
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> iterateContactCbxDisplay()
    {
        return this._contactCbxDisplayList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> iterateContactCbxDisplay() 

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
    public void removeAllContactCbxDisplay()
    {
        this._contactCbxDisplayList.clear();
    } //-- void removeAllContactCbxDisplay() 

    /**
     * Method removeContactCbxDisplay
     * 
     * 
     * 
     * @param vContactCbxDisplay
     * @return true if the object was removed from the collection.
     */
    public boolean removeContactCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay vContactCbxDisplay)
    {
        boolean removed = _contactCbxDisplayList.remove(vContactCbxDisplay);
        return removed;
    } //-- boolean removeContactCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) 

    /**
     * Method removeContactCbxDisplayAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay removeContactCbxDisplayAt(int index)
    {
        Object obj = this._contactCbxDisplayList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay removeContactCbxDisplayAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vContactCbxDisplay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContactCbxDisplay(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay vContactCbxDisplay)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._contactCbxDisplayList.size()) {
            throw new IndexOutOfBoundsException("setContactCbxDisplay: Index value '" + index + "' not in range [0.." + (this._contactCbxDisplayList.size() - 1) + "]");
        }
        
        this._contactCbxDisplayList.set(index, vContactCbxDisplay);
    } //-- void setContactCbxDisplay(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) 

    /**
     * 
     * 
     * @param vContactCbxDisplayArray
     */
    public void setContactCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay[] vContactCbxDisplayArray)
    {
        //-- copy array
        _contactCbxDisplayList.clear();
        
        for (int i = 0; i < vContactCbxDisplayArray.length; i++) {
                this._contactCbxDisplayList.add(vContactCbxDisplayArray[i]);
        }
    } //-- void setContactCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) 

    /**
     * Sets the value of '_contactCbxDisplayList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vContactCbxDisplayList the Vector to copy.
     */
    public void setContactCbxDisplay(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> vContactCbxDisplayList)
    {
        // copy vector
        this._contactCbxDisplayList.clear();
        
        this._contactCbxDisplayList.addAll(vContactCbxDisplayList);
    } //-- void setContactCbxDisplay(java.util.List) 

    /**
     * Sets the value of '_contactCbxDisplayList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param ContactCbxDisplayVector the Vector to set.
     */
    public void setContactCbxDisplayAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay> ContactCbxDisplayVector)
    {
        this._contactCbxDisplayList = ContactCbxDisplayVector;
    } //-- void setContactCbxDisplayAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array unmarshal(java.io.Reader) 

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
