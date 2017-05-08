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
 * Class BIndBLOBExistsInDatabase_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BIndBLOBExistsInDatabase_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bIndBLOBExistsInDatabaseList
     */
    private java.util.List<java.lang.String> _bIndBLOBExistsInDatabaseList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BIndBLOBExistsInDatabase_ARRAY() 
     {
        super();
        this._bIndBLOBExistsInDatabaseList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vBIndBLOBExistsInDatabase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBIndBLOBExistsInDatabase(java.lang.String vBIndBLOBExistsInDatabase)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._bIndBLOBExistsInDatabaseList.size() >= 6) {
            throw new IndexOutOfBoundsException("addBIndBLOBExistsInDatabase has a maximum of 6");
        }
        
        this._bIndBLOBExistsInDatabaseList.add(vBIndBLOBExistsInDatabase);
    } //-- void addBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vBIndBLOBExistsInDatabase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBIndBLOBExistsInDatabase(int index, java.lang.String vBIndBLOBExistsInDatabase)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._bIndBLOBExistsInDatabaseList.size() >= 6) {
            throw new IndexOutOfBoundsException("addBIndBLOBExistsInDatabase has a maximum of 6");
        }
        
        this._bIndBLOBExistsInDatabaseList.add(index, vBIndBLOBExistsInDatabase);
    } //-- void addBIndBLOBExistsInDatabase(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateBIndBLOBExistsInDatabase
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateBIndBLOBExistsInDatabase()
    {
        return java.util.Collections.enumeration(this._bIndBLOBExistsInDatabaseList);
    } //-- java.util.Enumeration<java.lang.String> enumerateBIndBLOBExistsInDatabase() 

    /**
     * Method getBIndBLOBExistsInDatabase
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getBIndBLOBExistsInDatabase(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._bIndBLOBExistsInDatabaseList.size()) {
            throw new IndexOutOfBoundsException("getBIndBLOBExistsInDatabase: Index value '" + index + "' not in range [0.." + (this._bIndBLOBExistsInDatabaseList.size() - 1) + "]");
        }
        
        return (String)_bIndBLOBExistsInDatabaseList.get(index);
    } //-- java.lang.String getBIndBLOBExistsInDatabase(int) 

    /**
     * Method getBIndBLOBExistsInDatabase
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getBIndBLOBExistsInDatabase()
    {
        int size = this._bIndBLOBExistsInDatabaseList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_bIndBLOBExistsInDatabaseList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getBIndBLOBExistsInDatabase() 

    /**
     * Method getBIndBLOBExistsInDatabaseAsReference
     * 
     * Returns a reference to '_bIndBLOBExistsInDatabaseList'. No
     * type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getBIndBLOBExistsInDatabaseAsReference()
    {
        return this._bIndBLOBExistsInDatabaseList;
    } //-- java.util.List<java.lang.String> getBIndBLOBExistsInDatabaseAsReference() 

    /**
     * Method getBIndBLOBExistsInDatabaseCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getBIndBLOBExistsInDatabaseCount()
    {
        return this._bIndBLOBExistsInDatabaseList.size();
    } //-- int getBIndBLOBExistsInDatabaseCount() 

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
     * Method iterateBIndBLOBExistsInDatabase
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateBIndBLOBExistsInDatabase()
    {
        return this._bIndBLOBExistsInDatabaseList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateBIndBLOBExistsInDatabase() 

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
    public void removeAllBIndBLOBExistsInDatabase()
    {
        this._bIndBLOBExistsInDatabaseList.clear();
    } //-- void removeAllBIndBLOBExistsInDatabase() 

    /**
     * Method removeBIndBLOBExistsInDatabase
     * 
     * 
     * 
     * @param vBIndBLOBExistsInDatabase
     * @return true if the object was removed from the collection.
     */
    public boolean removeBIndBLOBExistsInDatabase(java.lang.String vBIndBLOBExistsInDatabase)
    {
        boolean removed = _bIndBLOBExistsInDatabaseList.remove(vBIndBLOBExistsInDatabase);
        return removed;
    } //-- boolean removeBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * Method removeBIndBLOBExistsInDatabaseAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeBIndBLOBExistsInDatabaseAt(int index)
    {
        Object obj = this._bIndBLOBExistsInDatabaseList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeBIndBLOBExistsInDatabaseAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vBIndBLOBExistsInDatabase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setBIndBLOBExistsInDatabase(int index, java.lang.String vBIndBLOBExistsInDatabase)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._bIndBLOBExistsInDatabaseList.size()) {
            throw new IndexOutOfBoundsException("setBIndBLOBExistsInDatabase: Index value '" + index + "' not in range [0.." + (this._bIndBLOBExistsInDatabaseList.size() - 1) + "]");
        }
        
        this._bIndBLOBExistsInDatabaseList.set(index, vBIndBLOBExistsInDatabase);
    } //-- void setBIndBLOBExistsInDatabase(int, java.lang.String) 

    /**
     * 
     * 
     * @param vBIndBLOBExistsInDatabaseArray
     */
    public void setBIndBLOBExistsInDatabase(java.lang.String[] vBIndBLOBExistsInDatabaseArray)
    {
        //-- copy array
        _bIndBLOBExistsInDatabaseList.clear();
        
        for (int i = 0; i < vBIndBLOBExistsInDatabaseArray.length; i++) {
                this._bIndBLOBExistsInDatabaseList.add(vBIndBLOBExistsInDatabaseArray[i]);
        }
    } //-- void setBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * Sets the value of '_bIndBLOBExistsInDatabaseList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vBIndBLOBExistsInDatabaseList the Vector to copy.
     */
    public void setBIndBLOBExistsInDatabase(java.util.List<java.lang.String> vBIndBLOBExistsInDatabaseList)
    {
        // copy vector
        this._bIndBLOBExistsInDatabaseList.clear();
        
        this._bIndBLOBExistsInDatabaseList.addAll(vBIndBLOBExistsInDatabaseList);
    } //-- void setBIndBLOBExistsInDatabase(java.util.List) 

    /**
     * Sets the value of '_bIndBLOBExistsInDatabaseList' by setting
     * it to the given Vector. No type checking is performed.
     * 
     * @param BIndBLOBExistsInDatabaseVector the Vector to set.
     */
    public void setBIndBLOBExistsInDatabaseAsReference(java.util.Vector<java.lang.String> BIndBLOBExistsInDatabaseVector)
    {
        this._bIndBLOBExistsInDatabaseList = BIndBLOBExistsInDatabaseVector;
    } //-- void setBIndBLOBExistsInDatabaseAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY unmarshal(java.io.Reader) 

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
