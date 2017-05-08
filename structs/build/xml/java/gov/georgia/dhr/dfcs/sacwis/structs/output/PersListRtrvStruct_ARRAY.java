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
 * Class PersListRtrvStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PersListRtrvStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _persListRtrvStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> _persListRtrvStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersListRtrvStruct_ARRAY() 
     {
        super();
        this._persListRtrvStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPersListRtrvStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPersListRtrvStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct vPersListRtrvStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._persListRtrvStructList.size() >= 30) {
            throw new IndexOutOfBoundsException("addPersListRtrvStruct has a maximum of 30");
        }
        
        this._persListRtrvStructList.add(vPersListRtrvStruct);
    } //-- void addPersListRtrvStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) 

    /**
     * 
     * 
     * @param index
     * @param vPersListRtrvStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPersListRtrvStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct vPersListRtrvStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._persListRtrvStructList.size() >= 30) {
            throw new IndexOutOfBoundsException("addPersListRtrvStruct has a maximum of 30");
        }
        
        this._persListRtrvStructList.add(index, vPersListRtrvStruct);
    } //-- void addPersListRtrvStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumeratePersListRtrvStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> enumeratePersListRtrvStruct()
    {
        return java.util.Collections.enumeration(this._persListRtrvStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> enumeratePersListRtrvStruct() 

    /**
     * Method getPersListRtrvStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct getPersListRtrvStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._persListRtrvStructList.size()) {
            throw new IndexOutOfBoundsException("getPersListRtrvStruct: Index value '" + index + "' not in range [0.." + (this._persListRtrvStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) _persListRtrvStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct getPersListRtrvStruct(int) 

    /**
     * Method getPersListRtrvStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct[] getPersListRtrvStruct()
    {
        int size = this._persListRtrvStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) _persListRtrvStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct[] getPersListRtrvStruct() 

    /**
     * Method getPersListRtrvStructAsReference
     * 
     * Returns a reference to '_persListRtrvStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> getPersListRtrvStructAsReference()
    {
        return this._persListRtrvStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> getPersListRtrvStructAsReference() 

    /**
     * Method getPersListRtrvStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getPersListRtrvStructCount()
    {
        return this._persListRtrvStructList.size();
    } //-- int getPersListRtrvStructCount() 

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
     * Method iteratePersListRtrvStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> iteratePersListRtrvStruct()
    {
        return this._persListRtrvStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> iteratePersListRtrvStruct() 

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
    public void removeAllPersListRtrvStruct()
    {
        this._persListRtrvStructList.clear();
    } //-- void removeAllPersListRtrvStruct() 

    /**
     * Method removePersListRtrvStruct
     * 
     * 
     * 
     * @param vPersListRtrvStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removePersListRtrvStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct vPersListRtrvStruct)
    {
        boolean removed = _persListRtrvStructList.remove(vPersListRtrvStruct);
        return removed;
    } //-- boolean removePersListRtrvStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) 

    /**
     * Method removePersListRtrvStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct removePersListRtrvStructAt(int index)
    {
        Object obj = this._persListRtrvStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct removePersListRtrvStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vPersListRtrvStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPersListRtrvStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct vPersListRtrvStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._persListRtrvStructList.size()) {
            throw new IndexOutOfBoundsException("setPersListRtrvStruct: Index value '" + index + "' not in range [0.." + (this._persListRtrvStructList.size() - 1) + "]");
        }
        
        this._persListRtrvStructList.set(index, vPersListRtrvStruct);
    } //-- void setPersListRtrvStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) 

    /**
     * 
     * 
     * @param vPersListRtrvStructArray
     */
    public void setPersListRtrvStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct[] vPersListRtrvStructArray)
    {
        //-- copy array
        _persListRtrvStructList.clear();
        
        for (int i = 0; i < vPersListRtrvStructArray.length; i++) {
                this._persListRtrvStructList.add(vPersListRtrvStructArray[i]);
        }
    } //-- void setPersListRtrvStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) 

    /**
     * Sets the value of '_persListRtrvStructList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vPersListRtrvStructList the Vector to copy.
     */
    public void setPersListRtrvStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> vPersListRtrvStructList)
    {
        // copy vector
        this._persListRtrvStructList.clear();
        
        this._persListRtrvStructList.addAll(vPersListRtrvStructList);
    } //-- void setPersListRtrvStruct(java.util.List) 

    /**
     * Sets the value of '_persListRtrvStructList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param PersListRtrvStructVector the Vector to set.
     */
    public void setPersListRtrvStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct> PersListRtrvStructVector)
    {
        this._persListRtrvStructList = PersListRtrvStructVector;
    } //-- void setPersListRtrvStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY unmarshal(java.io.Reader) 

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
