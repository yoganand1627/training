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
 * Class VisitTypeCbxRecord_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class VisitTypeCbxRecord_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _visitTypeCbxRecordList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> _visitTypeCbxRecordList;


      //----------------/
     //- Constructors -/
    //----------------/

    public VisitTypeCbxRecord_Array() 
     {
        super();
        this._visitTypeCbxRecordList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vVisitTypeCbxRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addVisitTypeCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord vVisitTypeCbxRecord)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._visitTypeCbxRecordList.size() >= 5) {
            throw new IndexOutOfBoundsException("addVisitTypeCbxRecord has a maximum of 5");
        }
        
        this._visitTypeCbxRecordList.add(vVisitTypeCbxRecord);
    } //-- void addVisitTypeCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) 

    /**
     * 
     * 
     * @param index
     * @param vVisitTypeCbxRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addVisitTypeCbxRecord(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord vVisitTypeCbxRecord)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._visitTypeCbxRecordList.size() >= 5) {
            throw new IndexOutOfBoundsException("addVisitTypeCbxRecord has a maximum of 5");
        }
        
        this._visitTypeCbxRecordList.add(index, vVisitTypeCbxRecord);
    } //-- void addVisitTypeCbxRecord(int, gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateVisitTypeCbxRecord
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> enumerateVisitTypeCbxRecord()
    {
        return java.util.Collections.enumeration(this._visitTypeCbxRecordList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> enumerateVisitTypeCbxRecord() 

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
     * Method getVisitTypeCbxRecord
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord getVisitTypeCbxRecord(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._visitTypeCbxRecordList.size()) {
            throw new IndexOutOfBoundsException("getVisitTypeCbxRecord: Index value '" + index + "' not in range [0.." + (this._visitTypeCbxRecordList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) _visitTypeCbxRecordList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord getVisitTypeCbxRecord(int) 

    /**
     * Method getVisitTypeCbxRecord
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord[] getVisitTypeCbxRecord()
    {
        int size = this._visitTypeCbxRecordList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) _visitTypeCbxRecordList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord[] getVisitTypeCbxRecord() 

    /**
     * Method getVisitTypeCbxRecordAsReference
     * 
     * Returns a reference to '_visitTypeCbxRecordList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> getVisitTypeCbxRecordAsReference()
    {
        return this._visitTypeCbxRecordList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> getVisitTypeCbxRecordAsReference() 

    /**
     * Method getVisitTypeCbxRecordCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getVisitTypeCbxRecordCount()
    {
        return this._visitTypeCbxRecordList.size();
    } //-- int getVisitTypeCbxRecordCount() 

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
     * Method iterateVisitTypeCbxRecord
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> iterateVisitTypeCbxRecord()
    {
        return this._visitTypeCbxRecordList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> iterateVisitTypeCbxRecord() 

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
    public void removeAllVisitTypeCbxRecord()
    {
        this._visitTypeCbxRecordList.clear();
    } //-- void removeAllVisitTypeCbxRecord() 

    /**
     * Method removeVisitTypeCbxRecord
     * 
     * 
     * 
     * @param vVisitTypeCbxRecord
     * @return true if the object was removed from the collection.
     */
    public boolean removeVisitTypeCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord vVisitTypeCbxRecord)
    {
        boolean removed = _visitTypeCbxRecordList.remove(vVisitTypeCbxRecord);
        return removed;
    } //-- boolean removeVisitTypeCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) 

    /**
     * Method removeVisitTypeCbxRecordAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord removeVisitTypeCbxRecordAt(int index)
    {
        Object obj = this._visitTypeCbxRecordList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord removeVisitTypeCbxRecordAt(int) 

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
     * 
     * 
     * @param index
     * @param vVisitTypeCbxRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setVisitTypeCbxRecord(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord vVisitTypeCbxRecord)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._visitTypeCbxRecordList.size()) {
            throw new IndexOutOfBoundsException("setVisitTypeCbxRecord: Index value '" + index + "' not in range [0.." + (this._visitTypeCbxRecordList.size() - 1) + "]");
        }
        
        this._visitTypeCbxRecordList.set(index, vVisitTypeCbxRecord);
    } //-- void setVisitTypeCbxRecord(int, gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) 

    /**
     * 
     * 
     * @param vVisitTypeCbxRecordArray
     */
    public void setVisitTypeCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord[] vVisitTypeCbxRecordArray)
    {
        //-- copy array
        _visitTypeCbxRecordList.clear();
        
        for (int i = 0; i < vVisitTypeCbxRecordArray.length; i++) {
                this._visitTypeCbxRecordList.add(vVisitTypeCbxRecordArray[i]);
        }
    } //-- void setVisitTypeCbxRecord(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) 

    /**
     * Sets the value of '_visitTypeCbxRecordList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vVisitTypeCbxRecordList the Vector to copy.
     */
    public void setVisitTypeCbxRecord(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> vVisitTypeCbxRecordList)
    {
        // copy vector
        this._visitTypeCbxRecordList.clear();
        
        this._visitTypeCbxRecordList.addAll(vVisitTypeCbxRecordList);
    } //-- void setVisitTypeCbxRecord(java.util.List) 

    /**
     * Sets the value of '_visitTypeCbxRecordList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param VisitTypeCbxRecordVector the Vector to set.
     */
    public void setVisitTypeCbxRecordAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord> VisitTypeCbxRecordVector)
    {
        this._visitTypeCbxRecordList = VisitTypeCbxRecordVector;
    } //-- void setVisitTypeCbxRecordAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array unmarshal(java.io.Reader) 

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
