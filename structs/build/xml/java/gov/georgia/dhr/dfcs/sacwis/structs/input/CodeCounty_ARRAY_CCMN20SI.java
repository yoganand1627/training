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
 * Class CodeCounty_ARRAY_CCMN20SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CodeCounty_ARRAY_CCMN20SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdCaseCountyList
     */
    private java.util.List<java.lang.String> _szCdCaseCountyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CodeCounty_ARRAY_CCMN20SI() 
     {
        super();
        this._szCdCaseCountyList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdCaseCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCaseCounty(java.lang.String vSzCdCaseCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCaseCountyList.size() >= 10) {
            throw new IndexOutOfBoundsException("addSzCdCaseCounty has a maximum of 10");
        }
        
        this._szCdCaseCountyList.add(vSzCdCaseCounty);
    } //-- void addSzCdCaseCounty(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCaseCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCaseCounty(int index, java.lang.String vSzCdCaseCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCaseCountyList.size() >= 10) {
            throw new IndexOutOfBoundsException("addSzCdCaseCounty has a maximum of 10");
        }
        
        this._szCdCaseCountyList.add(index, vSzCdCaseCounty);
    } //-- void addSzCdCaseCounty(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdCaseCounty
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdCaseCounty()
    {
        return java.util.Collections.enumeration(this._szCdCaseCountyList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdCaseCounty() 

    /**
     * Method getSzCdCaseCounty
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdCaseCounty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCaseCountyList.size()) {
            throw new IndexOutOfBoundsException("getSzCdCaseCounty: Index value '" + index + "' not in range [0.." + (this._szCdCaseCountyList.size() - 1) + "]");
        }
        
        return (String)_szCdCaseCountyList.get(index);
    } //-- java.lang.String getSzCdCaseCounty(int) 

    /**
     * Method getSzCdCaseCounty
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdCaseCounty()
    {
        int size = this._szCdCaseCountyList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdCaseCountyList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdCaseCounty() 

    /**
     * Method getSzCdCaseCountyAsReference
     * 
     * Returns a reference to '_szCdCaseCountyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdCaseCountyAsReference()
    {
        return this._szCdCaseCountyList;
    } //-- java.util.List<java.lang.String> getSzCdCaseCountyAsReference() 

    /**
     * Method getSzCdCaseCountyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdCaseCountyCount()
    {
        return this._szCdCaseCountyList.size();
    } //-- int getSzCdCaseCountyCount() 

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
     * Method iterateSzCdCaseCounty
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdCaseCounty()
    {
        return this._szCdCaseCountyList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdCaseCounty() 

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
    public void removeAllSzCdCaseCounty()
    {
        this._szCdCaseCountyList.clear();
    } //-- void removeAllSzCdCaseCounty() 

    /**
     * Method removeSzCdCaseCounty
     * 
     * 
     * 
     * @param vSzCdCaseCounty
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdCaseCounty(java.lang.String vSzCdCaseCounty)
    {
        boolean removed = _szCdCaseCountyList.remove(vSzCdCaseCounty);
        return removed;
    } //-- boolean removeSzCdCaseCounty(java.lang.String) 

    /**
     * Method removeSzCdCaseCountyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdCaseCountyAt(int index)
    {
        Object obj = this._szCdCaseCountyList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdCaseCountyAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCaseCounty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdCaseCounty(int index, java.lang.String vSzCdCaseCounty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCaseCountyList.size()) {
            throw new IndexOutOfBoundsException("setSzCdCaseCounty: Index value '" + index + "' not in range [0.." + (this._szCdCaseCountyList.size() - 1) + "]");
        }
        
        this._szCdCaseCountyList.set(index, vSzCdCaseCounty);
    } //-- void setSzCdCaseCounty(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdCaseCountyArray
     */
    public void setSzCdCaseCounty(java.lang.String[] vSzCdCaseCountyArray)
    {
        //-- copy array
        _szCdCaseCountyList.clear();
        
        for (int i = 0; i < vSzCdCaseCountyArray.length; i++) {
                this._szCdCaseCountyList.add(vSzCdCaseCountyArray[i]);
        }
    } //-- void setSzCdCaseCounty(java.lang.String) 

    /**
     * Sets the value of '_szCdCaseCountyList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdCaseCountyList the Vector to copy.
     */
    public void setSzCdCaseCounty(java.util.List<java.lang.String> vSzCdCaseCountyList)
    {
        // copy vector
        this._szCdCaseCountyList.clear();
        
        this._szCdCaseCountyList.addAll(vSzCdCaseCountyList);
    } //-- void setSzCdCaseCounty(java.util.List) 

    /**
     * Sets the value of '_szCdCaseCountyList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdCaseCountyVector the Vector to set.
     */
    public void setSzCdCaseCountyAsReference(java.util.Vector<java.lang.String> SzCdCaseCountyVector)
    {
        this._szCdCaseCountyList = SzCdCaseCountyVector;
    } //-- void setSzCdCaseCountyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI unmarshal(java.io.Reader) 

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
