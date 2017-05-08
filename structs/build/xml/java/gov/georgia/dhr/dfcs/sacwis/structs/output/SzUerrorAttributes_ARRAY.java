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
 * Class SzUerrorAttributes_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzUerrorAttributes_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szAttributeList
     */
    private java.util.List<java.lang.String> _szAttributeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzUerrorAttributes_ARRAY() 
     {
        super();
        this._szAttributeList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzAttribute
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzAttribute(java.lang.String vSzAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szAttributeList.size() >= 10) {
            throw new IndexOutOfBoundsException("addSzAttribute has a maximum of 10");
        }
        
        this._szAttributeList.add(vSzAttribute);
    } //-- void addSzAttribute(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzAttribute
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzAttribute(int index, java.lang.String vSzAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szAttributeList.size() >= 10) {
            throw new IndexOutOfBoundsException("addSzAttribute has a maximum of 10");
        }
        
        this._szAttributeList.add(index, vSzAttribute);
    } //-- void addSzAttribute(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzAttribute
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzAttribute()
    {
        return java.util.Collections.enumeration(this._szAttributeList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzAttribute() 

    /**
     * Method getSzAttribute
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzAttribute(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szAttributeList.size()) {
            throw new IndexOutOfBoundsException("getSzAttribute: Index value '" + index + "' not in range [0.." + (this._szAttributeList.size() - 1) + "]");
        }
        
        return (String)_szAttributeList.get(index);
    } //-- java.lang.String getSzAttribute(int) 

    /**
     * Method getSzAttribute
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzAttribute()
    {
        int size = this._szAttributeList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szAttributeList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzAttribute() 

    /**
     * Method getSzAttributeAsReference
     * 
     * Returns a reference to '_szAttributeList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzAttributeAsReference()
    {
        return this._szAttributeList;
    } //-- java.util.List<java.lang.String> getSzAttributeAsReference() 

    /**
     * Method getSzAttributeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzAttributeCount()
    {
        return this._szAttributeList.size();
    } //-- int getSzAttributeCount() 

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
     * Method iterateSzAttribute
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzAttribute()
    {
        return this._szAttributeList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzAttribute() 

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
    public void removeAllSzAttribute()
    {
        this._szAttributeList.clear();
    } //-- void removeAllSzAttribute() 

    /**
     * Method removeSzAttribute
     * 
     * 
     * 
     * @param vSzAttribute
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzAttribute(java.lang.String vSzAttribute)
    {
        boolean removed = _szAttributeList.remove(vSzAttribute);
        return removed;
    } //-- boolean removeSzAttribute(java.lang.String) 

    /**
     * Method removeSzAttributeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzAttributeAt(int index)
    {
        Object obj = this._szAttributeList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzAttributeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzAttribute
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzAttribute(int index, java.lang.String vSzAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szAttributeList.size()) {
            throw new IndexOutOfBoundsException("setSzAttribute: Index value '" + index + "' not in range [0.." + (this._szAttributeList.size() - 1) + "]");
        }
        
        this._szAttributeList.set(index, vSzAttribute);
    } //-- void setSzAttribute(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzAttributeArray
     */
    public void setSzAttribute(java.lang.String[] vSzAttributeArray)
    {
        //-- copy array
        _szAttributeList.clear();
        
        for (int i = 0; i < vSzAttributeArray.length; i++) {
                this._szAttributeList.add(vSzAttributeArray[i]);
        }
    } //-- void setSzAttribute(java.lang.String) 

    /**
     * Sets the value of '_szAttributeList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzAttributeList the Vector to copy.
     */
    public void setSzAttribute(java.util.List<java.lang.String> vSzAttributeList)
    {
        // copy vector
        this._szAttributeList.clear();
        
        this._szAttributeList.addAll(vSzAttributeList);
    } //-- void setSzAttribute(java.util.List) 

    /**
     * Sets the value of '_szAttributeList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzAttributeVector the Vector to set.
     */
    public void setSzAttributeAsReference(java.util.Vector<java.lang.String> SzAttributeVector)
    {
        this._szAttributeList = SzAttributeVector;
    } //-- void setSzAttributeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY unmarshal(java.io.Reader) 

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
