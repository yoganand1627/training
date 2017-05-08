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
 * Class SzCdIncmgDetermType_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdIncmgDetermType_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdIncmgDetermTypeList
     */
    private java.util.List<java.lang.String> _szCdIncmgDetermTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdIncmgDetermType_ARRAY() 
     {
        super();
        this._szCdIncmgDetermTypeList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdIncmgDetermType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdIncmgDetermType(java.lang.String vSzCdIncmgDetermType)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdIncmgDetermTypeList.size() >= 70) {
            throw new IndexOutOfBoundsException("addSzCdIncmgDetermType has a maximum of 70");
        }
        
        this._szCdIncmgDetermTypeList.add(vSzCdIncmgDetermType);
    } //-- void addSzCdIncmgDetermType(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdIncmgDetermType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdIncmgDetermType(int index, java.lang.String vSzCdIncmgDetermType)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdIncmgDetermTypeList.size() >= 70) {
            throw new IndexOutOfBoundsException("addSzCdIncmgDetermType has a maximum of 70");
        }
        
        this._szCdIncmgDetermTypeList.add(index, vSzCdIncmgDetermType);
    } //-- void addSzCdIncmgDetermType(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdIncmgDetermType
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdIncmgDetermType()
    {
        return java.util.Collections.enumeration(this._szCdIncmgDetermTypeList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdIncmgDetermType() 

    /**
     * Method getSzCdIncmgDetermType
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdIncmgDetermType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdIncmgDetermTypeList.size()) {
            throw new IndexOutOfBoundsException("getSzCdIncmgDetermType: Index value '" + index + "' not in range [0.." + (this._szCdIncmgDetermTypeList.size() - 1) + "]");
        }
        
        return (String)_szCdIncmgDetermTypeList.get(index);
    } //-- java.lang.String getSzCdIncmgDetermType(int) 

    /**
     * Method getSzCdIncmgDetermType
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdIncmgDetermType()
    {
        int size = this._szCdIncmgDetermTypeList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdIncmgDetermTypeList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdIncmgDetermType() 

    /**
     * Method getSzCdIncmgDetermTypeAsReference
     * 
     * Returns a reference to '_szCdIncmgDetermTypeList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdIncmgDetermTypeAsReference()
    {
        return this._szCdIncmgDetermTypeList;
    } //-- java.util.List<java.lang.String> getSzCdIncmgDetermTypeAsReference() 

    /**
     * Method getSzCdIncmgDetermTypeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdIncmgDetermTypeCount()
    {
        return this._szCdIncmgDetermTypeList.size();
    } //-- int getSzCdIncmgDetermTypeCount() 

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
     * Method iterateSzCdIncmgDetermType
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdIncmgDetermType()
    {
        return this._szCdIncmgDetermTypeList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdIncmgDetermType() 

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
    public void removeAllSzCdIncmgDetermType()
    {
        this._szCdIncmgDetermTypeList.clear();
    } //-- void removeAllSzCdIncmgDetermType() 

    /**
     * Method removeSzCdIncmgDetermType
     * 
     * 
     * 
     * @param vSzCdIncmgDetermType
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdIncmgDetermType(java.lang.String vSzCdIncmgDetermType)
    {
        boolean removed = _szCdIncmgDetermTypeList.remove(vSzCdIncmgDetermType);
        return removed;
    } //-- boolean removeSzCdIncmgDetermType(java.lang.String) 

    /**
     * Method removeSzCdIncmgDetermTypeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdIncmgDetermTypeAt(int index)
    {
        Object obj = this._szCdIncmgDetermTypeList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdIncmgDetermTypeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdIncmgDetermType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdIncmgDetermType(int index, java.lang.String vSzCdIncmgDetermType)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdIncmgDetermTypeList.size()) {
            throw new IndexOutOfBoundsException("setSzCdIncmgDetermType: Index value '" + index + "' not in range [0.." + (this._szCdIncmgDetermTypeList.size() - 1) + "]");
        }
        
        this._szCdIncmgDetermTypeList.set(index, vSzCdIncmgDetermType);
    } //-- void setSzCdIncmgDetermType(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdIncmgDetermTypeArray
     */
    public void setSzCdIncmgDetermType(java.lang.String[] vSzCdIncmgDetermTypeArray)
    {
        //-- copy array
        _szCdIncmgDetermTypeList.clear();
        
        for (int i = 0; i < vSzCdIncmgDetermTypeArray.length; i++) {
                this._szCdIncmgDetermTypeList.add(vSzCdIncmgDetermTypeArray[i]);
        }
    } //-- void setSzCdIncmgDetermType(java.lang.String) 

    /**
     * Sets the value of '_szCdIncmgDetermTypeList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdIncmgDetermTypeList the Vector to copy.
     */
    public void setSzCdIncmgDetermType(java.util.List<java.lang.String> vSzCdIncmgDetermTypeList)
    {
        // copy vector
        this._szCdIncmgDetermTypeList.clear();
        
        this._szCdIncmgDetermTypeList.addAll(vSzCdIncmgDetermTypeList);
    } //-- void setSzCdIncmgDetermType(java.util.List) 

    /**
     * Sets the value of '_szCdIncmgDetermTypeList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param SzCdIncmgDetermTypeVector the Vector to set.
     */
    public void setSzCdIncmgDetermTypeAsReference(java.util.Vector<java.lang.String> SzCdIncmgDetermTypeVector)
    {
        this._szCdIncmgDetermTypeList = SzCdIncmgDetermTypeVector;
    } //-- void setSzCdIncmgDetermTypeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY unmarshal(java.io.Reader) 

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
