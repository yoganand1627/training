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
 * Class SzCdMedUpdTransTypE_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdMedUpdTransTypE_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdMedUpdTransTypEList
     */
    private java.util.List<java.lang.String> _szCdMedUpdTransTypEList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdMedUpdTransTypE_ARRAY() 
     {
        super();
        this._szCdMedUpdTransTypEList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdMedUpdTransTypE
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdMedUpdTransTypE(java.lang.String vSzCdMedUpdTransTypE)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdMedUpdTransTypEList.size() >= 5) {
            throw new IndexOutOfBoundsException("addSzCdMedUpdTransTypE has a maximum of 5");
        }
        
        this._szCdMedUpdTransTypEList.add(vSzCdMedUpdTransTypE);
    } //-- void addSzCdMedUpdTransTypE(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdMedUpdTransTypE
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdMedUpdTransTypE(int index, java.lang.String vSzCdMedUpdTransTypE)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdMedUpdTransTypEList.size() >= 5) {
            throw new IndexOutOfBoundsException("addSzCdMedUpdTransTypE has a maximum of 5");
        }
        
        this._szCdMedUpdTransTypEList.add(index, vSzCdMedUpdTransTypE);
    } //-- void addSzCdMedUpdTransTypE(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdMedUpdTransTypE
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdMedUpdTransTypE()
    {
        return java.util.Collections.enumeration(this._szCdMedUpdTransTypEList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdMedUpdTransTypE() 

    /**
     * Method getSzCdMedUpdTransTypE
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdMedUpdTransTypE(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdMedUpdTransTypEList.size()) {
            throw new IndexOutOfBoundsException("getSzCdMedUpdTransTypE: Index value '" + index + "' not in range [0.." + (this._szCdMedUpdTransTypEList.size() - 1) + "]");
        }
        
        return (String)_szCdMedUpdTransTypEList.get(index);
    } //-- java.lang.String getSzCdMedUpdTransTypE(int) 

    /**
     * Method getSzCdMedUpdTransTypE
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdMedUpdTransTypE()
    {
        int size = this._szCdMedUpdTransTypEList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdMedUpdTransTypEList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdMedUpdTransTypE() 

    /**
     * Method getSzCdMedUpdTransTypEAsReference
     * 
     * Returns a reference to '_szCdMedUpdTransTypEList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdMedUpdTransTypEAsReference()
    {
        return this._szCdMedUpdTransTypEList;
    } //-- java.util.List<java.lang.String> getSzCdMedUpdTransTypEAsReference() 

    /**
     * Method getSzCdMedUpdTransTypECount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdMedUpdTransTypECount()
    {
        return this._szCdMedUpdTransTypEList.size();
    } //-- int getSzCdMedUpdTransTypECount() 

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
     * Method iterateSzCdMedUpdTransTypE
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdMedUpdTransTypE()
    {
        return this._szCdMedUpdTransTypEList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdMedUpdTransTypE() 

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
    public void removeAllSzCdMedUpdTransTypE()
    {
        this._szCdMedUpdTransTypEList.clear();
    } //-- void removeAllSzCdMedUpdTransTypE() 

    /**
     * Method removeSzCdMedUpdTransTypE
     * 
     * 
     * 
     * @param vSzCdMedUpdTransTypE
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdMedUpdTransTypE(java.lang.String vSzCdMedUpdTransTypE)
    {
        boolean removed = _szCdMedUpdTransTypEList.remove(vSzCdMedUpdTransTypE);
        return removed;
    } //-- boolean removeSzCdMedUpdTransTypE(java.lang.String) 

    /**
     * Method removeSzCdMedUpdTransTypEAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdMedUpdTransTypEAt(int index)
    {
        Object obj = this._szCdMedUpdTransTypEList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdMedUpdTransTypEAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdMedUpdTransTypE
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdMedUpdTransTypE(int index, java.lang.String vSzCdMedUpdTransTypE)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdMedUpdTransTypEList.size()) {
            throw new IndexOutOfBoundsException("setSzCdMedUpdTransTypE: Index value '" + index + "' not in range [0.." + (this._szCdMedUpdTransTypEList.size() - 1) + "]");
        }
        
        this._szCdMedUpdTransTypEList.set(index, vSzCdMedUpdTransTypE);
    } //-- void setSzCdMedUpdTransTypE(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdMedUpdTransTypEArray
     */
    public void setSzCdMedUpdTransTypE(java.lang.String[] vSzCdMedUpdTransTypEArray)
    {
        //-- copy array
        _szCdMedUpdTransTypEList.clear();
        
        for (int i = 0; i < vSzCdMedUpdTransTypEArray.length; i++) {
                this._szCdMedUpdTransTypEList.add(vSzCdMedUpdTransTypEArray[i]);
        }
    } //-- void setSzCdMedUpdTransTypE(java.lang.String) 

    /**
     * Sets the value of '_szCdMedUpdTransTypEList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdMedUpdTransTypEList the Vector to copy.
     */
    public void setSzCdMedUpdTransTypE(java.util.List<java.lang.String> vSzCdMedUpdTransTypEList)
    {
        // copy vector
        this._szCdMedUpdTransTypEList.clear();
        
        this._szCdMedUpdTransTypEList.addAll(vSzCdMedUpdTransTypEList);
    } //-- void setSzCdMedUpdTransTypE(java.util.List) 

    /**
     * Sets the value of '_szCdMedUpdTransTypEList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param SzCdMedUpdTransTypEVector the Vector to set.
     */
    public void setSzCdMedUpdTransTypEAsReference(java.util.Vector<java.lang.String> SzCdMedUpdTransTypEVector)
    {
        this._szCdMedUpdTransTypEList = SzCdMedUpdTransTypEVector;
    } //-- void setSzCdMedUpdTransTypEAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY unmarshal(java.io.Reader) 

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
