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
 * Class SzCdCounty_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdCounty_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdCountyList
     */
    private java.util.List<java.lang.String> _szCdCountyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdCounty_Array() 
     {
        super();
        this._szCdCountyList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCounty(java.lang.String vSzCdCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCountyList.size() >= 254) {
            throw new IndexOutOfBoundsException("addSzCdCounty has a maximum of 254");
        }
        
        this._szCdCountyList.add(vSzCdCounty);
    } //-- void addSzCdCounty(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCounty(int index, java.lang.String vSzCdCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCountyList.size() >= 254) {
            throw new IndexOutOfBoundsException("addSzCdCounty has a maximum of 254");
        }
        
        this._szCdCountyList.add(index, vSzCdCounty);
    } //-- void addSzCdCounty(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdCounty
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdCounty()
    {
        return java.util.Collections.enumeration(this._szCdCountyList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdCounty() 

    /**
     * Method getSzCdCounty
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdCounty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCountyList.size()) {
            throw new IndexOutOfBoundsException("getSzCdCounty: Index value '" + index + "' not in range [0.." + (this._szCdCountyList.size() - 1) + "]");
        }
        
        return (String)_szCdCountyList.get(index);
    } //-- java.lang.String getSzCdCounty(int) 

    /**
     * Method getSzCdCounty
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdCounty()
    {
        int size = this._szCdCountyList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdCountyList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdCounty() 

    /**
     * Method getSzCdCountyAsReference
     * 
     * Returns a reference to '_szCdCountyList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdCountyAsReference()
    {
        return this._szCdCountyList;
    } //-- java.util.List<java.lang.String> getSzCdCountyAsReference() 

    /**
     * Method getSzCdCountyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdCountyCount()
    {
        return this._szCdCountyList.size();
    } //-- int getSzCdCountyCount() 

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
     * Method iterateSzCdCounty
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdCounty()
    {
        return this._szCdCountyList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdCounty() 

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
    public void removeAllSzCdCounty()
    {
        this._szCdCountyList.clear();
    } //-- void removeAllSzCdCounty() 

    /**
     * Method removeSzCdCounty
     * 
     * 
     * 
     * @param vSzCdCounty
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdCounty(java.lang.String vSzCdCounty)
    {
        boolean removed = _szCdCountyList.remove(vSzCdCounty);
        return removed;
    } //-- boolean removeSzCdCounty(java.lang.String) 

    /**
     * Method removeSzCdCountyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdCountyAt(int index)
    {
        Object obj = this._szCdCountyList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdCountyAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdCounty(int index, java.lang.String vSzCdCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCountyList.size()) {
            throw new IndexOutOfBoundsException("setSzCdCounty: Index value '" + index + "' not in range [0.." + (this._szCdCountyList.size() - 1) + "]");
        }
        
        this._szCdCountyList.set(index, vSzCdCounty);
    } //-- void setSzCdCounty(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdCountyArray
     */
    public void setSzCdCounty(java.lang.String[] vSzCdCountyArray)
    {
        //-- copy array
        _szCdCountyList.clear();
        
        for (int i = 0; i < vSzCdCountyArray.length; i++) {
                this._szCdCountyList.add(vSzCdCountyArray[i]);
        }
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of '_szCdCountyList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdCountyList the Vector to copy.
     */
    public void setSzCdCounty(java.util.List<java.lang.String> vSzCdCountyList)
    {
        // copy vector
        this._szCdCountyList.clear();
        
        this._szCdCountyList.addAll(vSzCdCountyList);
    } //-- void setSzCdCounty(java.util.List) 

    /**
     * Sets the value of '_szCdCountyList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdCountyVector the Vector to set.
     */
    public void setSzCdCountyAsReference(java.util.Vector<java.lang.String> SzCdCountyVector)
    {
        this._szCdCountyList = SzCdCountyVector;
    } //-- void setSzCdCountyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array unmarshal(java.io.Reader) 

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
