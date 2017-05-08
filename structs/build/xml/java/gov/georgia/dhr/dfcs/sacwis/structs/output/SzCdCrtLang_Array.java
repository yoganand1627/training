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
 * Class SzCdCrtLang_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdCrtLang_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdCrtLangList
     */
    private java.util.List<java.lang.String> _szCdCrtLangList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdCrtLang_Array() 
     {
        super();
        this._szCdCrtLangList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdCrtLang
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCrtLang(java.lang.String vSzCdCrtLang)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCrtLangList.size() >= 100) {
            throw new IndexOutOfBoundsException("addSzCdCrtLang has a maximum of 100");
        }
        
        this._szCdCrtLangList.add(vSzCdCrtLang);
    } //-- void addSzCdCrtLang(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCrtLang
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCrtLang(int index, java.lang.String vSzCdCrtLang)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCrtLangList.size() >= 100) {
            throw new IndexOutOfBoundsException("addSzCdCrtLang has a maximum of 100");
        }
        
        this._szCdCrtLangList.add(index, vSzCdCrtLang);
    } //-- void addSzCdCrtLang(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdCrtLang
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdCrtLang()
    {
        return java.util.Collections.enumeration(this._szCdCrtLangList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdCrtLang() 

    /**
     * Method getSzCdCrtLang
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdCrtLang(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCrtLangList.size()) {
            throw new IndexOutOfBoundsException("getSzCdCrtLang: Index value '" + index + "' not in range [0.." + (this._szCdCrtLangList.size() - 1) + "]");
        }
        
        return (String)_szCdCrtLangList.get(index);
    } //-- java.lang.String getSzCdCrtLang(int) 

    /**
     * Method getSzCdCrtLang
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdCrtLang()
    {
        int size = this._szCdCrtLangList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdCrtLangList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdCrtLang() 

    /**
     * Method getSzCdCrtLangAsReference
     * 
     * Returns a reference to '_szCdCrtLangList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdCrtLangAsReference()
    {
        return this._szCdCrtLangList;
    } //-- java.util.List<java.lang.String> getSzCdCrtLangAsReference() 

    /**
     * Method getSzCdCrtLangCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdCrtLangCount()
    {
        return this._szCdCrtLangList.size();
    } //-- int getSzCdCrtLangCount() 

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
     * Method iterateSzCdCrtLang
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdCrtLang()
    {
        return this._szCdCrtLangList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdCrtLang() 

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
    public void removeAllSzCdCrtLang()
    {
        this._szCdCrtLangList.clear();
    } //-- void removeAllSzCdCrtLang() 

    /**
     * Method removeSzCdCrtLang
     * 
     * 
     * 
     * @param vSzCdCrtLang
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdCrtLang(java.lang.String vSzCdCrtLang)
    {
        boolean removed = _szCdCrtLangList.remove(vSzCdCrtLang);
        return removed;
    } //-- boolean removeSzCdCrtLang(java.lang.String) 

    /**
     * Method removeSzCdCrtLangAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdCrtLangAt(int index)
    {
        Object obj = this._szCdCrtLangList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdCrtLangAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCrtLang
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdCrtLang(int index, java.lang.String vSzCdCrtLang)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCrtLangList.size()) {
            throw new IndexOutOfBoundsException("setSzCdCrtLang: Index value '" + index + "' not in range [0.." + (this._szCdCrtLangList.size() - 1) + "]");
        }
        
        this._szCdCrtLangList.set(index, vSzCdCrtLang);
    } //-- void setSzCdCrtLang(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdCrtLangArray
     */
    public void setSzCdCrtLang(java.lang.String[] vSzCdCrtLangArray)
    {
        //-- copy array
        _szCdCrtLangList.clear();
        
        for (int i = 0; i < vSzCdCrtLangArray.length; i++) {
                this._szCdCrtLangList.add(vSzCdCrtLangArray[i]);
        }
    } //-- void setSzCdCrtLang(java.lang.String) 

    /**
     * Sets the value of '_szCdCrtLangList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdCrtLangList the Vector to copy.
     */
    public void setSzCdCrtLang(java.util.List<java.lang.String> vSzCdCrtLangList)
    {
        // copy vector
        this._szCdCrtLangList.clear();
        
        this._szCdCrtLangList.addAll(vSzCdCrtLangList);
    } //-- void setSzCdCrtLang(java.util.List) 

    /**
     * Sets the value of '_szCdCrtLangList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdCrtLangVector the Vector to set.
     */
    public void setSzCdCrtLangAsReference(java.util.Vector<java.lang.String> SzCdCrtLangVector)
    {
        this._szCdCrtLangList = SzCdCrtLangVector;
    } //-- void setSzCdCrtLangAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array unmarshal(java.io.Reader) 

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
