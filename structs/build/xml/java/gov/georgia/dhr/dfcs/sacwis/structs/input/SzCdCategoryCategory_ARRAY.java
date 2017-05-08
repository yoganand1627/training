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
 * Class SzCdCategoryCategory_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdCategoryCategory_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdCategoryCategoryList
     */
    private java.util.List<java.lang.String> _szCdCategoryCategoryList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdCategoryCategory_ARRAY() 
     {
        super();
        this._szCdCategoryCategoryList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdCategoryCategory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCategoryCategory(java.lang.String vSzCdCategoryCategory)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCategoryCategoryList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdCategoryCategory has a maximum of 2");
        }
        
        this._szCdCategoryCategoryList.add(vSzCdCategoryCategory);
    } //-- void addSzCdCategoryCategory(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCategoryCategory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCategoryCategory(int index, java.lang.String vSzCdCategoryCategory)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCategoryCategoryList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdCategoryCategory has a maximum of 2");
        }
        
        this._szCdCategoryCategoryList.add(index, vSzCdCategoryCategory);
    } //-- void addSzCdCategoryCategory(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdCategoryCategory
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdCategoryCategory()
    {
        return java.util.Collections.enumeration(this._szCdCategoryCategoryList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdCategoryCategory() 

    /**
     * Method getSzCdCategoryCategory
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdCategoryCategory(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCategoryCategoryList.size()) {
            throw new IndexOutOfBoundsException("getSzCdCategoryCategory: Index value '" + index + "' not in range [0.." + (this._szCdCategoryCategoryList.size() - 1) + "]");
        }
        
        return (String)_szCdCategoryCategoryList.get(index);
    } //-- java.lang.String getSzCdCategoryCategory(int) 

    /**
     * Method getSzCdCategoryCategory
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdCategoryCategory()
    {
        int size = this._szCdCategoryCategoryList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdCategoryCategoryList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdCategoryCategory() 

    /**
     * Method getSzCdCategoryCategoryAsReference
     * 
     * Returns a reference to '_szCdCategoryCategoryList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdCategoryCategoryAsReference()
    {
        return this._szCdCategoryCategoryList;
    } //-- java.util.List<java.lang.String> getSzCdCategoryCategoryAsReference() 

    /**
     * Method getSzCdCategoryCategoryCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdCategoryCategoryCount()
    {
        return this._szCdCategoryCategoryList.size();
    } //-- int getSzCdCategoryCategoryCount() 

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
     * Method iterateSzCdCategoryCategory
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdCategoryCategory()
    {
        return this._szCdCategoryCategoryList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdCategoryCategory() 

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
    public void removeAllSzCdCategoryCategory()
    {
        this._szCdCategoryCategoryList.clear();
    } //-- void removeAllSzCdCategoryCategory() 

    /**
     * Method removeSzCdCategoryCategory
     * 
     * 
     * 
     * @param vSzCdCategoryCategory
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdCategoryCategory(java.lang.String vSzCdCategoryCategory)
    {
        boolean removed = _szCdCategoryCategoryList.remove(vSzCdCategoryCategory);
        return removed;
    } //-- boolean removeSzCdCategoryCategory(java.lang.String) 

    /**
     * Method removeSzCdCategoryCategoryAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdCategoryCategoryAt(int index)
    {
        Object obj = this._szCdCategoryCategoryList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdCategoryCategoryAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCategoryCategory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdCategoryCategory(int index, java.lang.String vSzCdCategoryCategory)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCategoryCategoryList.size()) {
            throw new IndexOutOfBoundsException("setSzCdCategoryCategory: Index value '" + index + "' not in range [0.." + (this._szCdCategoryCategoryList.size() - 1) + "]");
        }
        
        this._szCdCategoryCategoryList.set(index, vSzCdCategoryCategory);
    } //-- void setSzCdCategoryCategory(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdCategoryCategoryArray
     */
    public void setSzCdCategoryCategory(java.lang.String[] vSzCdCategoryCategoryArray)
    {
        //-- copy array
        _szCdCategoryCategoryList.clear();
        
        for (int i = 0; i < vSzCdCategoryCategoryArray.length; i++) {
                this._szCdCategoryCategoryList.add(vSzCdCategoryCategoryArray[i]);
        }
    } //-- void setSzCdCategoryCategory(java.lang.String) 

    /**
     * Sets the value of '_szCdCategoryCategoryList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdCategoryCategoryList the Vector to copy.
     */
    public void setSzCdCategoryCategory(java.util.List<java.lang.String> vSzCdCategoryCategoryList)
    {
        // copy vector
        this._szCdCategoryCategoryList.clear();
        
        this._szCdCategoryCategoryList.addAll(vSzCdCategoryCategoryList);
    } //-- void setSzCdCategoryCategory(java.util.List) 

    /**
     * Sets the value of '_szCdCategoryCategoryList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param SzCdCategoryCategoryVector the Vector to set.
     */
    public void setSzCdCategoryCategoryAsReference(java.util.Vector<java.lang.String> SzCdCategoryCategoryVector)
    {
        this._szCdCategoryCategoryList = SzCdCategoryCategoryVector;
    } //-- void setSzCdCategoryCategoryAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY unmarshal(java.io.Reader) 

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
