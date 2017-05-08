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
 * Class SzCdStageCnty_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdStageCnty_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdStageCntyList
     */
    private java.util.List<java.lang.String> _szCdStageCntyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdStageCnty_ARRAY() 
     {
        super();
        this._szCdStageCntyList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdStageCnty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdStageCnty(java.lang.String vSzCdStageCnty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdStageCntyList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdStageCnty has a maximum of 2");
        }
        
        this._szCdStageCntyList.add(vSzCdStageCnty);
    } //-- void addSzCdStageCnty(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdStageCnty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdStageCnty(int index, java.lang.String vSzCdStageCnty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdStageCntyList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdStageCnty has a maximum of 2");
        }
        
        this._szCdStageCntyList.add(index, vSzCdStageCnty);
    } //-- void addSzCdStageCnty(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdStageCnty
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdStageCnty()
    {
        return java.util.Collections.enumeration(this._szCdStageCntyList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdStageCnty() 

    /**
     * Method getSzCdStageCnty
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdStageCnty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdStageCntyList.size()) {
            throw new IndexOutOfBoundsException("getSzCdStageCnty: Index value '" + index + "' not in range [0.." + (this._szCdStageCntyList.size() - 1) + "]");
        }
        
        return (String)_szCdStageCntyList.get(index);
    } //-- java.lang.String getSzCdStageCnty(int) 

    /**
     * Method getSzCdStageCnty
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdStageCnty()
    {
        int size = this._szCdStageCntyList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdStageCntyList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdStageCnty() 

    /**
     * Method getSzCdStageCntyAsReference
     * 
     * Returns a reference to '_szCdStageCntyList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdStageCntyAsReference()
    {
        return this._szCdStageCntyList;
    } //-- java.util.List<java.lang.String> getSzCdStageCntyAsReference() 

    /**
     * Method getSzCdStageCntyCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdStageCntyCount()
    {
        return this._szCdStageCntyList.size();
    } //-- int getSzCdStageCntyCount() 

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
     * Method iterateSzCdStageCnty
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdStageCnty()
    {
        return this._szCdStageCntyList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdStageCnty() 

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
    public void removeAllSzCdStageCnty()
    {
        this._szCdStageCntyList.clear();
    } //-- void removeAllSzCdStageCnty() 

    /**
     * Method removeSzCdStageCnty
     * 
     * 
     * 
     * @param vSzCdStageCnty
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdStageCnty(java.lang.String vSzCdStageCnty)
    {
        boolean removed = _szCdStageCntyList.remove(vSzCdStageCnty);
        return removed;
    } //-- boolean removeSzCdStageCnty(java.lang.String) 

    /**
     * Method removeSzCdStageCntyAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdStageCntyAt(int index)
    {
        Object obj = this._szCdStageCntyList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdStageCntyAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdStageCnty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdStageCnty(int index, java.lang.String vSzCdStageCnty)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdStageCntyList.size()) {
            throw new IndexOutOfBoundsException("setSzCdStageCnty: Index value '" + index + "' not in range [0.." + (this._szCdStageCntyList.size() - 1) + "]");
        }
        
        this._szCdStageCntyList.set(index, vSzCdStageCnty);
    } //-- void setSzCdStageCnty(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdStageCntyArray
     */
    public void setSzCdStageCnty(java.lang.String[] vSzCdStageCntyArray)
    {
        //-- copy array
        _szCdStageCntyList.clear();
        
        for (int i = 0; i < vSzCdStageCntyArray.length; i++) {
                this._szCdStageCntyList.add(vSzCdStageCntyArray[i]);
        }
    } //-- void setSzCdStageCnty(java.lang.String) 

    /**
     * Sets the value of '_szCdStageCntyList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdStageCntyList the Vector to copy.
     */
    public void setSzCdStageCnty(java.util.List<java.lang.String> vSzCdStageCntyList)
    {
        // copy vector
        this._szCdStageCntyList.clear();
        
        this._szCdStageCntyList.addAll(vSzCdStageCntyList);
    } //-- void setSzCdStageCnty(java.util.List) 

    /**
     * Sets the value of '_szCdStageCntyList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdStageCntyVector the Vector to set.
     */
    public void setSzCdStageCntyAsReference(java.util.Vector<java.lang.String> SzCdStageCntyVector)
    {
        this._szCdStageCntyList = SzCdStageCntyVector;
    } //-- void setSzCdStageCntyAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY unmarshal(java.io.Reader) 

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
