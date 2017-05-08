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
 * Class SzNmPersonFull_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzNmPersonFull_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szNmPersonFullList
     */
    private java.util.List<java.lang.String> _szNmPersonFullList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzNmPersonFull_ARRAY() 
     {
        super();
        this._szNmPersonFullList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzNmPersonFull
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzNmPersonFull(java.lang.String vSzNmPersonFull)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szNmPersonFullList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzNmPersonFull has a maximum of 2");
        }
        
        this._szNmPersonFullList.add(vSzNmPersonFull);
    } //-- void addSzNmPersonFull(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzNmPersonFull
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzNmPersonFull(int index, java.lang.String vSzNmPersonFull)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szNmPersonFullList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzNmPersonFull has a maximum of 2");
        }
        
        this._szNmPersonFullList.add(index, vSzNmPersonFull);
    } //-- void addSzNmPersonFull(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzNmPersonFull
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzNmPersonFull()
    {
        return java.util.Collections.enumeration(this._szNmPersonFullList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzNmPersonFull() 

    /**
     * Method getSzNmPersonFull
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzNmPersonFull(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szNmPersonFullList.size()) {
            throw new IndexOutOfBoundsException("getSzNmPersonFull: Index value '" + index + "' not in range [0.." + (this._szNmPersonFullList.size() - 1) + "]");
        }
        
        return (String)_szNmPersonFullList.get(index);
    } //-- java.lang.String getSzNmPersonFull(int) 

    /**
     * Method getSzNmPersonFull
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzNmPersonFull()
    {
        int size = this._szNmPersonFullList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szNmPersonFullList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzNmPersonFull() 

    /**
     * Method getSzNmPersonFullAsReference
     * 
     * Returns a reference to '_szNmPersonFullList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzNmPersonFullAsReference()
    {
        return this._szNmPersonFullList;
    } //-- java.util.List<java.lang.String> getSzNmPersonFullAsReference() 

    /**
     * Method getSzNmPersonFullCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzNmPersonFullCount()
    {
        return this._szNmPersonFullList.size();
    } //-- int getSzNmPersonFullCount() 

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
     * Method iterateSzNmPersonFull
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzNmPersonFull()
    {
        return this._szNmPersonFullList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzNmPersonFull() 

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
    public void removeAllSzNmPersonFull()
    {
        this._szNmPersonFullList.clear();
    } //-- void removeAllSzNmPersonFull() 

    /**
     * Method removeSzNmPersonFull
     * 
     * 
     * 
     * @param vSzNmPersonFull
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzNmPersonFull(java.lang.String vSzNmPersonFull)
    {
        boolean removed = _szNmPersonFullList.remove(vSzNmPersonFull);
        return removed;
    } //-- boolean removeSzNmPersonFull(java.lang.String) 

    /**
     * Method removeSzNmPersonFullAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzNmPersonFullAt(int index)
    {
        Object obj = this._szNmPersonFullList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzNmPersonFullAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzNmPersonFull
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzNmPersonFull(int index, java.lang.String vSzNmPersonFull)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szNmPersonFullList.size()) {
            throw new IndexOutOfBoundsException("setSzNmPersonFull: Index value '" + index + "' not in range [0.." + (this._szNmPersonFullList.size() - 1) + "]");
        }
        
        this._szNmPersonFullList.set(index, vSzNmPersonFull);
    } //-- void setSzNmPersonFull(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzNmPersonFullArray
     */
    public void setSzNmPersonFull(java.lang.String[] vSzNmPersonFullArray)
    {
        //-- copy array
        _szNmPersonFullList.clear();
        
        for (int i = 0; i < vSzNmPersonFullArray.length; i++) {
                this._szNmPersonFullList.add(vSzNmPersonFullArray[i]);
        }
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of '_szNmPersonFullList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzNmPersonFullList the Vector to copy.
     */
    public void setSzNmPersonFull(java.util.List<java.lang.String> vSzNmPersonFullList)
    {
        // copy vector
        this._szNmPersonFullList.clear();
        
        this._szNmPersonFullList.addAll(vSzNmPersonFullList);
    } //-- void setSzNmPersonFull(java.util.List) 

    /**
     * Sets the value of '_szNmPersonFullList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzNmPersonFullVector the Vector to set.
     */
    public void setSzNmPersonFullAsReference(java.util.Vector<java.lang.String> SzNmPersonFullVector)
    {
        this._szNmPersonFullList = SzNmPersonFullVector;
    } //-- void setSzNmPersonFullAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY unmarshal(java.io.Reader) 

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
