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
 * Class DtDtTodoDue_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DtDtTodoDue_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtTodoDueList
     */
    private java.util.List<org.exolab.castor.types.Date> _dtDtTodoDueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DtDtTodoDue_ARRAY() 
     {
        super();
        this._dtDtTodoDueList = new java.util.ArrayList<org.exolab.castor.types.Date>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDtDtTodoDue
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDtDtTodoDue(org.exolab.castor.types.Date vDtDtTodoDue)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._dtDtTodoDueList.size() >= 2) {
            throw new IndexOutOfBoundsException("addDtDtTodoDue has a maximum of 2");
        }
        
        this._dtDtTodoDueList.add(vDtDtTodoDue);
    } //-- void addDtDtTodoDue(org.exolab.castor.types.Date) 

    /**
     * 
     * 
     * @param index
     * @param vDtDtTodoDue
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDtDtTodoDue(int index, org.exolab.castor.types.Date vDtDtTodoDue)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._dtDtTodoDueList.size() >= 2) {
            throw new IndexOutOfBoundsException("addDtDtTodoDue has a maximum of 2");
        }
        
        this._dtDtTodoDueList.add(index, vDtDtTodoDue);
    } //-- void addDtDtTodoDue(int, org.exolab.castor.types.Date) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateDtDtTodoDue
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<org.exolab.castor.types.Date> enumerateDtDtTodoDue()
    {
        return java.util.Collections.enumeration(this._dtDtTodoDueList);
    } //-- java.util.Enumeration<org.exolab.castor.types.Date> enumerateDtDtTodoDue() 

    /**
     * Method getDtDtTodoDue
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.exolab.castor.types.Date at the
     * given index
     */
    public org.exolab.castor.types.Date getDtDtTodoDue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._dtDtTodoDueList.size()) {
            throw new IndexOutOfBoundsException("getDtDtTodoDue: Index value '" + index + "' not in range [0.." + (this._dtDtTodoDueList.size() - 1) + "]");
        }
        
        return (org.exolab.castor.types.Date) _dtDtTodoDueList.get(index);
    } //-- org.exolab.castor.types.Date getDtDtTodoDue(int) 

    /**
     * Method getDtDtTodoDue
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public org.exolab.castor.types.Date[] getDtDtTodoDue()
    {
        int size = this._dtDtTodoDueList.size();
        org.exolab.castor.types.Date[] array = new org.exolab.castor.types.Date[size];
        for (int index = 0; index < size; index++){
            array[index] = (org.exolab.castor.types.Date) _dtDtTodoDueList.get(index);
        }
        
        return array;
    } //-- org.exolab.castor.types.Date[] getDtDtTodoDue() 

    /**
     * Method getDtDtTodoDueAsReference
     * 
     * Returns a reference to '_dtDtTodoDueList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<org.exolab.castor.types.Date> getDtDtTodoDueAsReference()
    {
        return this._dtDtTodoDueList;
    } //-- java.util.List<org.exolab.castor.types.Date> getDtDtTodoDueAsReference() 

    /**
     * Method getDtDtTodoDueCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getDtDtTodoDueCount()
    {
        return this._dtDtTodoDueList.size();
    } //-- int getDtDtTodoDueCount() 

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
     * Method iterateDtDtTodoDue
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<org.exolab.castor.types.Date> iterateDtDtTodoDue()
    {
        return this._dtDtTodoDueList.iterator();
    } //-- java.util.Iterator<org.exolab.castor.types.Date> iterateDtDtTodoDue() 

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
    public void removeAllDtDtTodoDue()
    {
        this._dtDtTodoDueList.clear();
    } //-- void removeAllDtDtTodoDue() 

    /**
     * Method removeDtDtTodoDue
     * 
     * 
     * 
     * @param vDtDtTodoDue
     * @return true if the object was removed from the collection.
     */
    public boolean removeDtDtTodoDue(org.exolab.castor.types.Date vDtDtTodoDue)
    {
        boolean removed = _dtDtTodoDueList.remove(vDtDtTodoDue);
        return removed;
    } //-- boolean removeDtDtTodoDue(org.exolab.castor.types.Date) 

    /**
     * Method removeDtDtTodoDueAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.exolab.castor.types.Date removeDtDtTodoDueAt(int index)
    {
        Object obj = this._dtDtTodoDueList.remove(index);
        return (org.exolab.castor.types.Date) obj;
    } //-- org.exolab.castor.types.Date removeDtDtTodoDueAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vDtDtTodoDue
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDtDtTodoDue(int index, org.exolab.castor.types.Date vDtDtTodoDue)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._dtDtTodoDueList.size()) {
            throw new IndexOutOfBoundsException("setDtDtTodoDue: Index value '" + index + "' not in range [0.." + (this._dtDtTodoDueList.size() - 1) + "]");
        }
        
        this._dtDtTodoDueList.set(index, vDtDtTodoDue);
    } //-- void setDtDtTodoDue(int, org.exolab.castor.types.Date) 

    /**
     * 
     * 
     * @param vDtDtTodoDueArray
     */
    public void setDtDtTodoDue(org.exolab.castor.types.Date[] vDtDtTodoDueArray)
    {
        //-- copy array
        _dtDtTodoDueList.clear();
        
        for (int i = 0; i < vDtDtTodoDueArray.length; i++) {
                this._dtDtTodoDueList.add(vDtDtTodoDueArray[i]);
        }
    } //-- void setDtDtTodoDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of '_dtDtTodoDueList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vDtDtTodoDueList the Vector to copy.
     */
    public void setDtDtTodoDue(java.util.List<org.exolab.castor.types.Date> vDtDtTodoDueList)
    {
        // copy vector
        this._dtDtTodoDueList.clear();
        
        this._dtDtTodoDueList.addAll(vDtDtTodoDueList);
    } //-- void setDtDtTodoDue(java.util.List) 

    /**
     * Sets the value of '_dtDtTodoDueList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param DtDtTodoDueVector the Vector to set.
     */
    public void setDtDtTodoDueAsReference(java.util.Vector<org.exolab.castor.types.Date> DtDtTodoDueVector)
    {
        this._dtDtTodoDueList = DtDtTodoDueVector;
    } //-- void setDtDtTodoDueAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY unmarshal(java.io.Reader) 

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
