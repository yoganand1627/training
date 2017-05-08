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
 * Class MUpdIDInStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MUpdIDInStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _MUpdIDInStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> _MUpdIDInStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MUpdIDInStruct_ARRAY() 
     {
        super();
        this._MUpdIDInStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMUpdIDInStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMUpdIDInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct vMUpdIDInStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._MUpdIDInStructList.size() >= 30) {
            throw new IndexOutOfBoundsException("addMUpdIDInStruct has a maximum of 30");
        }
        
        this._MUpdIDInStructList.add(vMUpdIDInStruct);
    } //-- void addMUpdIDInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) 

    /**
     * 
     * 
     * @param index
     * @param vMUpdIDInStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMUpdIDInStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct vMUpdIDInStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._MUpdIDInStructList.size() >= 30) {
            throw new IndexOutOfBoundsException("addMUpdIDInStruct has a maximum of 30");
        }
        
        this._MUpdIDInStructList.add(index, vMUpdIDInStruct);
    } //-- void addMUpdIDInStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateMUpdIDInStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> enumerateMUpdIDInStruct()
    {
        return java.util.Collections.enumeration(this._MUpdIDInStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> enumerateMUpdIDInStruct() 

    /**
     * Method getMUpdIDInStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct getMUpdIDInStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._MUpdIDInStructList.size()) {
            throw new IndexOutOfBoundsException("getMUpdIDInStruct: Index value '" + index + "' not in range [0.." + (this._MUpdIDInStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) _MUpdIDInStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct getMUpdIDInStruct(int) 

    /**
     * Method getMUpdIDInStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct[] getMUpdIDInStruct()
    {
        int size = this._MUpdIDInStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) _MUpdIDInStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct[] getMUpdIDInStruct() 

    /**
     * Method getMUpdIDInStructAsReference
     * 
     * Returns a reference to '_MUpdIDInStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> getMUpdIDInStructAsReference()
    {
        return this._MUpdIDInStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> getMUpdIDInStructAsReference() 

    /**
     * Method getMUpdIDInStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getMUpdIDInStructCount()
    {
        return this._MUpdIDInStructList.size();
    } //-- int getMUpdIDInStructCount() 

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
     * Method iterateMUpdIDInStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> iterateMUpdIDInStruct()
    {
        return this._MUpdIDInStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> iterateMUpdIDInStruct() 

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
    public void removeAllMUpdIDInStruct()
    {
        this._MUpdIDInStructList.clear();
    } //-- void removeAllMUpdIDInStruct() 

    /**
     * Method removeMUpdIDInStruct
     * 
     * 
     * 
     * @param vMUpdIDInStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeMUpdIDInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct vMUpdIDInStruct)
    {
        boolean removed = _MUpdIDInStructList.remove(vMUpdIDInStruct);
        return removed;
    } //-- boolean removeMUpdIDInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) 

    /**
     * Method removeMUpdIDInStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct removeMUpdIDInStructAt(int index)
    {
        Object obj = this._MUpdIDInStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct removeMUpdIDInStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vMUpdIDInStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMUpdIDInStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct vMUpdIDInStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._MUpdIDInStructList.size()) {
            throw new IndexOutOfBoundsException("setMUpdIDInStruct: Index value '" + index + "' not in range [0.." + (this._MUpdIDInStructList.size() - 1) + "]");
        }
        
        this._MUpdIDInStructList.set(index, vMUpdIDInStruct);
    } //-- void setMUpdIDInStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) 

    /**
     * 
     * 
     * @param vMUpdIDInStructArray
     */
    public void setMUpdIDInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct[] vMUpdIDInStructArray)
    {
        //-- copy array
        _MUpdIDInStructList.clear();
        
        for (int i = 0; i < vMUpdIDInStructArray.length; i++) {
                this._MUpdIDInStructList.add(vMUpdIDInStructArray[i]);
        }
    } //-- void setMUpdIDInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) 

    /**
     * Sets the value of '_MUpdIDInStructList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vMUpdIDInStructList the Vector to copy.
     */
    public void setMUpdIDInStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> vMUpdIDInStructList)
    {
        // copy vector
        this._MUpdIDInStructList.clear();
        
        this._MUpdIDInStructList.addAll(vMUpdIDInStructList);
    } //-- void setMUpdIDInStruct(java.util.List) 

    /**
     * Sets the value of '_MUpdIDInStructList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param MUpdIDInStructVector the Vector to set.
     */
    public void setMUpdIDInStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct> MUpdIDInStructVector)
    {
        this._MUpdIDInStructList = MUpdIDInStructVector;
    } //-- void setMUpdIDInStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY unmarshal(java.io.Reader) 

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
