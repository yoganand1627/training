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
 * Class SzCdEligCsupQuest1_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdEligCsupQuest1_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdEligCsupQuest1List
     */
    private java.util.List<java.lang.String> _szCdEligCsupQuest1List;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdEligCsupQuest1_ARRAY() 
     {
        super();
        this._szCdEligCsupQuest1List = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdEligCsupQuest1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdEligCsupQuest1(java.lang.String vSzCdEligCsupQuest1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdEligCsupQuest1List.size() >= 7) {
            throw new IndexOutOfBoundsException("addSzCdEligCsupQuest1 has a maximum of 7");
        }
        
        this._szCdEligCsupQuest1List.add(vSzCdEligCsupQuest1);
    } //-- void addSzCdEligCsupQuest1(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdEligCsupQuest1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdEligCsupQuest1(int index, java.lang.String vSzCdEligCsupQuest1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdEligCsupQuest1List.size() >= 7) {
            throw new IndexOutOfBoundsException("addSzCdEligCsupQuest1 has a maximum of 7");
        }
        
        this._szCdEligCsupQuest1List.add(index, vSzCdEligCsupQuest1);
    } //-- void addSzCdEligCsupQuest1(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdEligCsupQuest1
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdEligCsupQuest1()
    {
        return java.util.Collections.enumeration(this._szCdEligCsupQuest1List);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdEligCsupQuest1() 

    /**
     * Method getSzCdEligCsupQuest1
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdEligCsupQuest1(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdEligCsupQuest1List.size()) {
            throw new IndexOutOfBoundsException("getSzCdEligCsupQuest1: Index value '" + index + "' not in range [0.." + (this._szCdEligCsupQuest1List.size() - 1) + "]");
        }
        
        return (String)_szCdEligCsupQuest1List.get(index);
    } //-- java.lang.String getSzCdEligCsupQuest1(int) 

    /**
     * Method getSzCdEligCsupQuest1
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdEligCsupQuest1()
    {
        int size = this._szCdEligCsupQuest1List.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdEligCsupQuest1List.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdEligCsupQuest1() 

    /**
     * Method getSzCdEligCsupQuest1AsReference
     * 
     * Returns a reference to '_szCdEligCsupQuest1List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdEligCsupQuest1AsReference()
    {
        return this._szCdEligCsupQuest1List;
    } //-- java.util.List<java.lang.String> getSzCdEligCsupQuest1AsReference() 

    /**
     * Method getSzCdEligCsupQuest1Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdEligCsupQuest1Count()
    {
        return this._szCdEligCsupQuest1List.size();
    } //-- int getSzCdEligCsupQuest1Count() 

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
     * Method iterateSzCdEligCsupQuest1
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdEligCsupQuest1()
    {
        return this._szCdEligCsupQuest1List.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdEligCsupQuest1() 

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
    public void removeAllSzCdEligCsupQuest1()
    {
        this._szCdEligCsupQuest1List.clear();
    } //-- void removeAllSzCdEligCsupQuest1() 

    /**
     * Method removeSzCdEligCsupQuest1
     * 
     * 
     * 
     * @param vSzCdEligCsupQuest1
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdEligCsupQuest1(java.lang.String vSzCdEligCsupQuest1)
    {
        boolean removed = _szCdEligCsupQuest1List.remove(vSzCdEligCsupQuest1);
        return removed;
    } //-- boolean removeSzCdEligCsupQuest1(java.lang.String) 

    /**
     * Method removeSzCdEligCsupQuest1At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdEligCsupQuest1At(int index)
    {
        Object obj = this._szCdEligCsupQuest1List.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdEligCsupQuest1At(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdEligCsupQuest1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdEligCsupQuest1(int index, java.lang.String vSzCdEligCsupQuest1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdEligCsupQuest1List.size()) {
            throw new IndexOutOfBoundsException("setSzCdEligCsupQuest1: Index value '" + index + "' not in range [0.." + (this._szCdEligCsupQuest1List.size() - 1) + "]");
        }
        
        this._szCdEligCsupQuest1List.set(index, vSzCdEligCsupQuest1);
    } //-- void setSzCdEligCsupQuest1(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdEligCsupQuest1Array
     */
    public void setSzCdEligCsupQuest1(java.lang.String[] vSzCdEligCsupQuest1Array)
    {
        //-- copy array
        _szCdEligCsupQuest1List.clear();
        
        for (int i = 0; i < vSzCdEligCsupQuest1Array.length; i++) {
                this._szCdEligCsupQuest1List.add(vSzCdEligCsupQuest1Array[i]);
        }
    } //-- void setSzCdEligCsupQuest1(java.lang.String) 

    /**
     * Sets the value of '_szCdEligCsupQuest1List' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdEligCsupQuest1List the Vector to copy.
     */
    public void setSzCdEligCsupQuest1(java.util.List<java.lang.String> vSzCdEligCsupQuest1List)
    {
        // copy vector
        this._szCdEligCsupQuest1List.clear();
        
        this._szCdEligCsupQuest1List.addAll(vSzCdEligCsupQuest1List);
    } //-- void setSzCdEligCsupQuest1(java.util.List) 

    /**
     * Sets the value of '_szCdEligCsupQuest1List' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdEligCsupQuest1Vector the Vector to set.
     */
    public void setSzCdEligCsupQuest1AsReference(java.util.Vector<java.lang.String> SzCdEligCsupQuest1Vector)
    {
        this._szCdEligCsupQuest1List = SzCdEligCsupQuest1Vector;
    } //-- void setSzCdEligCsupQuest1AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEligCsupQuest1_ARRAY unmarshal(java.io.Reader) 

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
