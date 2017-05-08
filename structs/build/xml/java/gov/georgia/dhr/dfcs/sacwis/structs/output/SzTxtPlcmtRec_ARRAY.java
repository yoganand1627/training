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
 * Class SzTxtPlcmtRec_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzTxtPlcmtRec_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szTxtPlcmtRecList
     */
    private java.util.List<java.lang.String> _szTxtPlcmtRecList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzTxtPlcmtRec_ARRAY() 
     {
        super();
        this._szTxtPlcmtRecList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzTxtPlcmtRec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzTxtPlcmtRec(java.lang.String vSzTxtPlcmtRec)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szTxtPlcmtRecList.size() >= 7) {
            throw new IndexOutOfBoundsException("addSzTxtPlcmtRec has a maximum of 7");
        }
        
        this._szTxtPlcmtRecList.add(vSzTxtPlcmtRec);
    } //-- void addSzTxtPlcmtRec(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzTxtPlcmtRec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzTxtPlcmtRec(int index, java.lang.String vSzTxtPlcmtRec)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szTxtPlcmtRecList.size() >= 7) {
            throw new IndexOutOfBoundsException("addSzTxtPlcmtRec has a maximum of 7");
        }
        
        this._szTxtPlcmtRecList.add(index, vSzTxtPlcmtRec);
    } //-- void addSzTxtPlcmtRec(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzTxtPlcmtRec
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzTxtPlcmtRec()
    {
        return java.util.Collections.enumeration(this._szTxtPlcmtRecList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzTxtPlcmtRec() 

    /**
     * Method getSzTxtPlcmtRec
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzTxtPlcmtRec(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szTxtPlcmtRecList.size()) {
            throw new IndexOutOfBoundsException("getSzTxtPlcmtRec: Index value '" + index + "' not in range [0.." + (this._szTxtPlcmtRecList.size() - 1) + "]");
        }
        
        return (String)_szTxtPlcmtRecList.get(index);
    } //-- java.lang.String getSzTxtPlcmtRec(int) 

    /**
     * Method getSzTxtPlcmtRec
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzTxtPlcmtRec()
    {
        int size = this._szTxtPlcmtRecList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szTxtPlcmtRecList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzTxtPlcmtRec() 

    /**
     * Method getSzTxtPlcmtRecAsReference
     * 
     * Returns a reference to '_szTxtPlcmtRecList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzTxtPlcmtRecAsReference()
    {
        return this._szTxtPlcmtRecList;
    } //-- java.util.List<java.lang.String> getSzTxtPlcmtRecAsReference() 

    /**
     * Method getSzTxtPlcmtRecCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzTxtPlcmtRecCount()
    {
        return this._szTxtPlcmtRecList.size();
    } //-- int getSzTxtPlcmtRecCount() 

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
     * Method iterateSzTxtPlcmtRec
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzTxtPlcmtRec()
    {
        return this._szTxtPlcmtRecList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzTxtPlcmtRec() 

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
    public void removeAllSzTxtPlcmtRec()
    {
        this._szTxtPlcmtRecList.clear();
    } //-- void removeAllSzTxtPlcmtRec() 

    /**
     * Method removeSzTxtPlcmtRec
     * 
     * 
     * 
     * @param vSzTxtPlcmtRec
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzTxtPlcmtRec(java.lang.String vSzTxtPlcmtRec)
    {
        boolean removed = _szTxtPlcmtRecList.remove(vSzTxtPlcmtRec);
        return removed;
    } //-- boolean removeSzTxtPlcmtRec(java.lang.String) 

    /**
     * Method removeSzTxtPlcmtRecAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzTxtPlcmtRecAt(int index)
    {
        Object obj = this._szTxtPlcmtRecList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzTxtPlcmtRecAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzTxtPlcmtRec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzTxtPlcmtRec(int index, java.lang.String vSzTxtPlcmtRec)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szTxtPlcmtRecList.size()) {
            throw new IndexOutOfBoundsException("setSzTxtPlcmtRec: Index value '" + index + "' not in range [0.." + (this._szTxtPlcmtRecList.size() - 1) + "]");
        }
        
        this._szTxtPlcmtRecList.set(index, vSzTxtPlcmtRec);
    } //-- void setSzTxtPlcmtRec(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzTxtPlcmtRecArray
     */
    public void setSzTxtPlcmtRec(java.lang.String[] vSzTxtPlcmtRecArray)
    {
        //-- copy array
        _szTxtPlcmtRecList.clear();
        
        for (int i = 0; i < vSzTxtPlcmtRecArray.length; i++) {
                this._szTxtPlcmtRecList.add(vSzTxtPlcmtRecArray[i]);
        }
    } //-- void setSzTxtPlcmtRec(java.lang.String) 

    /**
     * Sets the value of '_szTxtPlcmtRecList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzTxtPlcmtRecList the Vector to copy.
     */
    public void setSzTxtPlcmtRec(java.util.List<java.lang.String> vSzTxtPlcmtRecList)
    {
        // copy vector
        this._szTxtPlcmtRecList.clear();
        
        this._szTxtPlcmtRecList.addAll(vSzTxtPlcmtRecList);
    } //-- void setSzTxtPlcmtRec(java.util.List) 

    /**
     * Sets the value of '_szTxtPlcmtRecList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzTxtPlcmtRecVector the Vector to set.
     */
    public void setSzTxtPlcmtRecAsReference(java.util.Vector<java.lang.String> SzTxtPlcmtRecVector)
    {
        this._szTxtPlcmtRecList = SzTxtPlcmtRecVector;
    } //-- void setSzTxtPlcmtRecAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRAY unmarshal(java.io.Reader) 

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
