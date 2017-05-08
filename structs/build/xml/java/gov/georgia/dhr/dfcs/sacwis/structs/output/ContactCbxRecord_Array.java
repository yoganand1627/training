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
 * Class ContactCbxRecord_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContactCbxRecord_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _contactCbxRecordList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> _contactCbxRecordList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContactCbxRecord_Array() 
     {
        super();
        this._contactCbxRecordList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContactCbxRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContactCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord vContactCbxRecord)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._contactCbxRecordList.size() >= 100) {
            throw new IndexOutOfBoundsException("addContactCbxRecord has a maximum of 100");
        }
        
        this._contactCbxRecordList.add(vContactCbxRecord);
    } //-- void addContactCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) 

    /**
     * 
     * 
     * @param index
     * @param vContactCbxRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContactCbxRecord(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord vContactCbxRecord)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._contactCbxRecordList.size() >= 100) {
            throw new IndexOutOfBoundsException("addContactCbxRecord has a maximum of 100");
        }
        
        this._contactCbxRecordList.add(index, vContactCbxRecord);
    } //-- void addContactCbxRecord(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateContactCbxRecord
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> enumerateContactCbxRecord()
    {
        return java.util.Collections.enumeration(this._contactCbxRecordList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> enumerateContactCbxRecord() 

    /**
     * Method getContactCbxRecord
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord getContactCbxRecord(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._contactCbxRecordList.size()) {
            throw new IndexOutOfBoundsException("getContactCbxRecord: Index value '" + index + "' not in range [0.." + (this._contactCbxRecordList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) _contactCbxRecordList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord getContactCbxRecord(int) 

    /**
     * Method getContactCbxRecord
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord[] getContactCbxRecord()
    {
        int size = this._contactCbxRecordList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) _contactCbxRecordList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord[] getContactCbxRecord() 

    /**
     * Method getContactCbxRecordAsReference
     * 
     * Returns a reference to '_contactCbxRecordList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> getContactCbxRecordAsReference()
    {
        return this._contactCbxRecordList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> getContactCbxRecordAsReference() 

    /**
     * Method getContactCbxRecordCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getContactCbxRecordCount()
    {
        return this._contactCbxRecordList.size();
    } //-- int getContactCbxRecordCount() 

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
     * Method iterateContactCbxRecord
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> iterateContactCbxRecord()
    {
        return this._contactCbxRecordList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> iterateContactCbxRecord() 

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
    public void removeAllContactCbxRecord()
    {
        this._contactCbxRecordList.clear();
    } //-- void removeAllContactCbxRecord() 

    /**
     * Method removeContactCbxRecord
     * 
     * 
     * 
     * @param vContactCbxRecord
     * @return true if the object was removed from the collection.
     */
    public boolean removeContactCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord vContactCbxRecord)
    {
        boolean removed = _contactCbxRecordList.remove(vContactCbxRecord);
        return removed;
    } //-- boolean removeContactCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) 

    /**
     * Method removeContactCbxRecordAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord removeContactCbxRecordAt(int index)
    {
        Object obj = this._contactCbxRecordList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord removeContactCbxRecordAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vContactCbxRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContactCbxRecord(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord vContactCbxRecord)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._contactCbxRecordList.size()) {
            throw new IndexOutOfBoundsException("setContactCbxRecord: Index value '" + index + "' not in range [0.." + (this._contactCbxRecordList.size() - 1) + "]");
        }
        
        this._contactCbxRecordList.set(index, vContactCbxRecord);
    } //-- void setContactCbxRecord(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) 

    /**
     * 
     * 
     * @param vContactCbxRecordArray
     */
    public void setContactCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord[] vContactCbxRecordArray)
    {
        //-- copy array
        _contactCbxRecordList.clear();
        
        for (int i = 0; i < vContactCbxRecordArray.length; i++) {
                this._contactCbxRecordList.add(vContactCbxRecordArray[i]);
        }
    } //-- void setContactCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord) 

    /**
     * Sets the value of '_contactCbxRecordList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vContactCbxRecordList the Vector to copy.
     */
    public void setContactCbxRecord(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> vContactCbxRecordList)
    {
        // copy vector
        this._contactCbxRecordList.clear();
        
        this._contactCbxRecordList.addAll(vContactCbxRecordList);
    } //-- void setContactCbxRecord(java.util.List) 

    /**
     * Sets the value of '_contactCbxRecordList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param ContactCbxRecordVector the Vector to set.
     */
    public void setContactCbxRecordAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord> ContactCbxRecordVector)
    {
        this._contactCbxRecordList = ContactCbxRecordVector;
    } //-- void setContactCbxRecordAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxRecord_Array unmarshal(java.io.Reader) 

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
