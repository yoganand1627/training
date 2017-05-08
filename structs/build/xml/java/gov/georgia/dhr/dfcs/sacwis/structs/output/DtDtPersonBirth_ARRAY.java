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
 * Class DtDtPersonBirth_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DtDtPersonBirth_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtPersonBirthList
     */
    private java.util.List<org.exolab.castor.types.Date> _dtDtPersonBirthList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DtDtPersonBirth_ARRAY() 
     {
        super();
        this._dtDtPersonBirthList = new java.util.ArrayList<org.exolab.castor.types.Date>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDtDtPersonBirth
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDtDtPersonBirth(org.exolab.castor.types.Date vDtDtPersonBirth)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._dtDtPersonBirthList.size() >= 100) {
            throw new IndexOutOfBoundsException("addDtDtPersonBirth has a maximum of 100");
        }
        
        this._dtDtPersonBirthList.add(vDtDtPersonBirth);
    } //-- void addDtDtPersonBirth(org.exolab.castor.types.Date) 

    /**
     * 
     * 
     * @param index
     * @param vDtDtPersonBirth
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDtDtPersonBirth(int index, org.exolab.castor.types.Date vDtDtPersonBirth)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._dtDtPersonBirthList.size() >= 100) {
            throw new IndexOutOfBoundsException("addDtDtPersonBirth has a maximum of 100");
        }
        
        this._dtDtPersonBirthList.add(index, vDtDtPersonBirth);
    } //-- void addDtDtPersonBirth(int, org.exolab.castor.types.Date) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateDtDtPersonBirth
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<org.exolab.castor.types.Date> enumerateDtDtPersonBirth()
    {
        return java.util.Collections.enumeration(this._dtDtPersonBirthList);
    } //-- java.util.Enumeration<org.exolab.castor.types.Date> enumerateDtDtPersonBirth() 

    /**
     * Method getDtDtPersonBirth
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.exolab.castor.types.Date at the
     * given index
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._dtDtPersonBirthList.size()) {
            throw new IndexOutOfBoundsException("getDtDtPersonBirth: Index value '" + index + "' not in range [0.." + (this._dtDtPersonBirthList.size() - 1) + "]");
        }
        
        return (org.exolab.castor.types.Date) _dtDtPersonBirthList.get(index);
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth(int) 

    /**
     * Method getDtDtPersonBirth
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public org.exolab.castor.types.Date[] getDtDtPersonBirth()
    {
        int size = this._dtDtPersonBirthList.size();
        org.exolab.castor.types.Date[] array = new org.exolab.castor.types.Date[size];
        for (int index = 0; index < size; index++){
            array[index] = (org.exolab.castor.types.Date) _dtDtPersonBirthList.get(index);
        }
        
        return array;
    } //-- org.exolab.castor.types.Date[] getDtDtPersonBirth() 

    /**
     * Method getDtDtPersonBirthAsReference
     * 
     * Returns a reference to '_dtDtPersonBirthList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<org.exolab.castor.types.Date> getDtDtPersonBirthAsReference()
    {
        return this._dtDtPersonBirthList;
    } //-- java.util.List<org.exolab.castor.types.Date> getDtDtPersonBirthAsReference() 

    /**
     * Method getDtDtPersonBirthCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getDtDtPersonBirthCount()
    {
        return this._dtDtPersonBirthList.size();
    } //-- int getDtDtPersonBirthCount() 

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
     * Method iterateDtDtPersonBirth
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<org.exolab.castor.types.Date> iterateDtDtPersonBirth()
    {
        return this._dtDtPersonBirthList.iterator();
    } //-- java.util.Iterator<org.exolab.castor.types.Date> iterateDtDtPersonBirth() 

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
    public void removeAllDtDtPersonBirth()
    {
        this._dtDtPersonBirthList.clear();
    } //-- void removeAllDtDtPersonBirth() 

    /**
     * Method removeDtDtPersonBirth
     * 
     * 
     * 
     * @param vDtDtPersonBirth
     * @return true if the object was removed from the collection.
     */
    public boolean removeDtDtPersonBirth(org.exolab.castor.types.Date vDtDtPersonBirth)
    {
        boolean removed = _dtDtPersonBirthList.remove(vDtDtPersonBirth);
        return removed;
    } //-- boolean removeDtDtPersonBirth(org.exolab.castor.types.Date) 

    /**
     * Method removeDtDtPersonBirthAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.exolab.castor.types.Date removeDtDtPersonBirthAt(int index)
    {
        Object obj = this._dtDtPersonBirthList.remove(index);
        return (org.exolab.castor.types.Date) obj;
    } //-- org.exolab.castor.types.Date removeDtDtPersonBirthAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vDtDtPersonBirth
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDtDtPersonBirth(int index, org.exolab.castor.types.Date vDtDtPersonBirth)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._dtDtPersonBirthList.size()) {
            throw new IndexOutOfBoundsException("setDtDtPersonBirth: Index value '" + index + "' not in range [0.." + (this._dtDtPersonBirthList.size() - 1) + "]");
        }
        
        this._dtDtPersonBirthList.set(index, vDtDtPersonBirth);
    } //-- void setDtDtPersonBirth(int, org.exolab.castor.types.Date) 

    /**
     * 
     * 
     * @param vDtDtPersonBirthArray
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date[] vDtDtPersonBirthArray)
    {
        //-- copy array
        _dtDtPersonBirthList.clear();
        
        for (int i = 0; i < vDtDtPersonBirthArray.length; i++) {
                this._dtDtPersonBirthList.add(vDtDtPersonBirthArray[i]);
        }
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

    /**
     * Sets the value of '_dtDtPersonBirthList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vDtDtPersonBirthList the Vector to copy.
     */
    public void setDtDtPersonBirth(java.util.List<org.exolab.castor.types.Date> vDtDtPersonBirthList)
    {
        // copy vector
        this._dtDtPersonBirthList.clear();
        
        this._dtDtPersonBirthList.addAll(vDtDtPersonBirthList);
    } //-- void setDtDtPersonBirth(java.util.List) 

    /**
     * Sets the value of '_dtDtPersonBirthList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param DtDtPersonBirthVector the Vector to set.
     */
    public void setDtDtPersonBirthAsReference(java.util.Vector<org.exolab.castor.types.Date> DtDtPersonBirthVector)
    {
        this._dtDtPersonBirthList = DtDtPersonBirthVector;
    } //-- void setDtDtPersonBirthAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY unmarshal(java.io.Reader) 

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
