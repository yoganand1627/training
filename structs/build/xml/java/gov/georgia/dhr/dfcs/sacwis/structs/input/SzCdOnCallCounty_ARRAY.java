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
 * Class SzCdOnCallCounty_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdOnCallCounty_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdOnCallCountyList
     */
    private java.util.List<java.lang.String> _szCdOnCallCountyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdOnCallCounty_ARRAY() 
     {
        super();
        this._szCdOnCallCountyList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdOnCallCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdOnCallCounty(java.lang.String vSzCdOnCallCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdOnCallCountyList.size() >= 50) {
            throw new IndexOutOfBoundsException("addSzCdOnCallCounty has a maximum of 50");
        }
        
        this._szCdOnCallCountyList.add(vSzCdOnCallCounty);
    } //-- void addSzCdOnCallCounty(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdOnCallCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdOnCallCounty(int index, java.lang.String vSzCdOnCallCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdOnCallCountyList.size() >= 50) {
            throw new IndexOutOfBoundsException("addSzCdOnCallCounty has a maximum of 50");
        }
        
        this._szCdOnCallCountyList.add(index, vSzCdOnCallCounty);
    } //-- void addSzCdOnCallCounty(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdOnCallCounty
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdOnCallCounty()
    {
        return java.util.Collections.enumeration(this._szCdOnCallCountyList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdOnCallCounty() 

    /**
     * Method getSzCdOnCallCounty
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdOnCallCounty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdOnCallCountyList.size()) {
            throw new IndexOutOfBoundsException("getSzCdOnCallCounty: Index value '" + index + "' not in range [0.." + (this._szCdOnCallCountyList.size() - 1) + "]");
        }
        
        return (String)_szCdOnCallCountyList.get(index);
    } //-- java.lang.String getSzCdOnCallCounty(int) 

    /**
     * Method getSzCdOnCallCounty
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdOnCallCounty()
    {
        int size = this._szCdOnCallCountyList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdOnCallCountyList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdOnCallCounty() 

    /**
     * Method getSzCdOnCallCountyAsReference
     * 
     * Returns a reference to '_szCdOnCallCountyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdOnCallCountyAsReference()
    {
        return this._szCdOnCallCountyList;
    } //-- java.util.List<java.lang.String> getSzCdOnCallCountyAsReference() 

    /**
     * Method getSzCdOnCallCountyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdOnCallCountyCount()
    {
        return this._szCdOnCallCountyList.size();
    } //-- int getSzCdOnCallCountyCount() 

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
     * Method iterateSzCdOnCallCounty
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdOnCallCounty()
    {
        return this._szCdOnCallCountyList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdOnCallCounty() 

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
    public void removeAllSzCdOnCallCounty()
    {
        this._szCdOnCallCountyList.clear();
    } //-- void removeAllSzCdOnCallCounty() 

    /**
     * Method removeSzCdOnCallCounty
     * 
     * 
     * 
     * @param vSzCdOnCallCounty
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdOnCallCounty(java.lang.String vSzCdOnCallCounty)
    {
        boolean removed = _szCdOnCallCountyList.remove(vSzCdOnCallCounty);
        return removed;
    } //-- boolean removeSzCdOnCallCounty(java.lang.String) 

    /**
     * Method removeSzCdOnCallCountyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdOnCallCountyAt(int index)
    {
        Object obj = this._szCdOnCallCountyList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdOnCallCountyAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdOnCallCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdOnCallCounty(int index, java.lang.String vSzCdOnCallCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdOnCallCountyList.size()) {
            throw new IndexOutOfBoundsException("setSzCdOnCallCounty: Index value '" + index + "' not in range [0.." + (this._szCdOnCallCountyList.size() - 1) + "]");
        }
        
        this._szCdOnCallCountyList.set(index, vSzCdOnCallCounty);
    } //-- void setSzCdOnCallCounty(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdOnCallCountyArray
     */
    public void setSzCdOnCallCounty(java.lang.String[] vSzCdOnCallCountyArray)
    {
        //-- copy array
        _szCdOnCallCountyList.clear();
        
        for (int i = 0; i < vSzCdOnCallCountyArray.length; i++) {
                this._szCdOnCallCountyList.add(vSzCdOnCallCountyArray[i]);
        }
    } //-- void setSzCdOnCallCounty(java.lang.String) 

    /**
     * Sets the value of '_szCdOnCallCountyList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdOnCallCountyList the Vector to copy.
     */
    public void setSzCdOnCallCounty(java.util.List<java.lang.String> vSzCdOnCallCountyList)
    {
        // copy vector
        this._szCdOnCallCountyList.clear();
        
        this._szCdOnCallCountyList.addAll(vSzCdOnCallCountyList);
    } //-- void setSzCdOnCallCounty(java.util.List) 

    /**
     * Sets the value of '_szCdOnCallCountyList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdOnCallCountyVector the Vector to set.
     */
    public void setSzCdOnCallCountyAsReference(java.util.Vector<java.lang.String> SzCdOnCallCountyVector)
    {
        this._szCdOnCallCountyList = SzCdOnCallCountyVector;
    } //-- void setSzCdOnCallCountyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY unmarshal(java.io.Reader) 

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
