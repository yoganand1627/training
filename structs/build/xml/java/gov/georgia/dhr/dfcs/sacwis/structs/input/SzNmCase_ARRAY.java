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
 * Class SzNmCase_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzNmCase_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szNmCaseList
     */
    private java.util.List<java.lang.String> _szNmCaseList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzNmCase_ARRAY() 
     {
        super();
        this._szNmCaseList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzNmCase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzNmCase(java.lang.String vSzNmCase)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szNmCaseList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzNmCase has a maximum of 2");
        }
        
        this._szNmCaseList.add(vSzNmCase);
    } //-- void addSzNmCase(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzNmCase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzNmCase(int index, java.lang.String vSzNmCase)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szNmCaseList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzNmCase has a maximum of 2");
        }
        
        this._szNmCaseList.add(index, vSzNmCase);
    } //-- void addSzNmCase(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzNmCase
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzNmCase()
    {
        return java.util.Collections.enumeration(this._szNmCaseList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzNmCase() 

    /**
     * Method getSzNmCase
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzNmCase(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szNmCaseList.size()) {
            throw new IndexOutOfBoundsException("getSzNmCase: Index value '" + index + "' not in range [0.." + (this._szNmCaseList.size() - 1) + "]");
        }
        
        return (String)_szNmCaseList.get(index);
    } //-- java.lang.String getSzNmCase(int) 

    /**
     * Method getSzNmCase
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzNmCase()
    {
        int size = this._szNmCaseList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szNmCaseList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzNmCase() 

    /**
     * Method getSzNmCaseAsReference
     * 
     * Returns a reference to '_szNmCaseList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzNmCaseAsReference()
    {
        return this._szNmCaseList;
    } //-- java.util.List<java.lang.String> getSzNmCaseAsReference() 

    /**
     * Method getSzNmCaseCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzNmCaseCount()
    {
        return this._szNmCaseList.size();
    } //-- int getSzNmCaseCount() 

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
     * Method iterateSzNmCase
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzNmCase()
    {
        return this._szNmCaseList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzNmCase() 

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
    public void removeAllSzNmCase()
    {
        this._szNmCaseList.clear();
    } //-- void removeAllSzNmCase() 

    /**
     * Method removeSzNmCase
     * 
     * 
     * 
     * @param vSzNmCase
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzNmCase(java.lang.String vSzNmCase)
    {
        boolean removed = _szNmCaseList.remove(vSzNmCase);
        return removed;
    } //-- boolean removeSzNmCase(java.lang.String) 

    /**
     * Method removeSzNmCaseAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzNmCaseAt(int index)
    {
        Object obj = this._szNmCaseList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzNmCaseAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzNmCase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzNmCase(int index, java.lang.String vSzNmCase)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szNmCaseList.size()) {
            throw new IndexOutOfBoundsException("setSzNmCase: Index value '" + index + "' not in range [0.." + (this._szNmCaseList.size() - 1) + "]");
        }
        
        this._szNmCaseList.set(index, vSzNmCase);
    } //-- void setSzNmCase(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzNmCaseArray
     */
    public void setSzNmCase(java.lang.String[] vSzNmCaseArray)
    {
        //-- copy array
        _szNmCaseList.clear();
        
        for (int i = 0; i < vSzNmCaseArray.length; i++) {
                this._szNmCaseList.add(vSzNmCaseArray[i]);
        }
    } //-- void setSzNmCase(java.lang.String) 

    /**
     * Sets the value of '_szNmCaseList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzNmCaseList the Vector to copy.
     */
    public void setSzNmCase(java.util.List<java.lang.String> vSzNmCaseList)
    {
        // copy vector
        this._szNmCaseList.clear();
        
        this._szNmCaseList.addAll(vSzNmCaseList);
    } //-- void setSzNmCase(java.util.List) 

    /**
     * Sets the value of '_szNmCaseList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param SzNmCaseVector the Vector to set.
     */
    public void setSzNmCaseAsReference(java.util.Vector<java.lang.String> SzNmCaseVector)
    {
        this._szNmCaseList = SzNmCaseVector;
    } //-- void setSzNmCaseAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY unmarshal(java.io.Reader) 

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
