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
 * Class DtSysDtGenericSysdate_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DtSysDtGenericSysdate_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtSysDtGenericSysdateList
     */
    private java.util.List<org.exolab.castor.types.Date> _dtSysDtGenericSysdateList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DtSysDtGenericSysdate_ARRAY() 
     {
        super();
        this._dtSysDtGenericSysdateList = new java.util.ArrayList<org.exolab.castor.types.Date>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDtSysDtGenericSysdate
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDtSysDtGenericSysdate(org.exolab.castor.types.Date vDtSysDtGenericSysdate)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._dtSysDtGenericSysdateList.size() >= 300) {
            throw new IndexOutOfBoundsException("addDtSysDtGenericSysdate has a maximum of 300");
        }
        
        this._dtSysDtGenericSysdateList.add(vDtSysDtGenericSysdate);
    } //-- void addDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * 
     * 
     * @param index
     * @param vDtSysDtGenericSysdate
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDtSysDtGenericSysdate(int index, org.exolab.castor.types.Date vDtSysDtGenericSysdate)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._dtSysDtGenericSysdateList.size() >= 300) {
            throw new IndexOutOfBoundsException("addDtSysDtGenericSysdate has a maximum of 300");
        }
        
        this._dtSysDtGenericSysdateList.add(index, vDtSysDtGenericSysdate);
    } //-- void addDtSysDtGenericSysdate(int, org.exolab.castor.types.Date) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateDtSysDtGenericSysdate
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<org.exolab.castor.types.Date> enumerateDtSysDtGenericSysdate()
    {
        return java.util.Collections.enumeration(this._dtSysDtGenericSysdateList);
    } //-- java.util.Enumeration<org.exolab.castor.types.Date> enumerateDtSysDtGenericSysdate() 

    /**
     * Method getDtSysDtGenericSysdate
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.exolab.castor.types.Date at the
     * given index
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._dtSysDtGenericSysdateList.size()) {
            throw new IndexOutOfBoundsException("getDtSysDtGenericSysdate: Index value '" + index + "' not in range [0.." + (this._dtSysDtGenericSysdateList.size() - 1) + "]");
        }
        
        return (org.exolab.castor.types.Date) _dtSysDtGenericSysdateList.get(index);
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate(int) 

    /**
     * Method getDtSysDtGenericSysdate
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public org.exolab.castor.types.Date[] getDtSysDtGenericSysdate()
    {
        int size = this._dtSysDtGenericSysdateList.size();
        org.exolab.castor.types.Date[] array = new org.exolab.castor.types.Date[size];
        for (int index = 0; index < size; index++){
            array[index] = (org.exolab.castor.types.Date) _dtSysDtGenericSysdateList.get(index);
        }
        
        return array;
    } //-- org.exolab.castor.types.Date[] getDtSysDtGenericSysdate() 

    /**
     * Method getDtSysDtGenericSysdateAsReference
     * 
     * Returns a reference to '_dtSysDtGenericSysdateList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<org.exolab.castor.types.Date> getDtSysDtGenericSysdateAsReference()
    {
        return this._dtSysDtGenericSysdateList;
    } //-- java.util.List<org.exolab.castor.types.Date> getDtSysDtGenericSysdateAsReference() 

    /**
     * Method getDtSysDtGenericSysdateCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getDtSysDtGenericSysdateCount()
    {
        return this._dtSysDtGenericSysdateList.size();
    } //-- int getDtSysDtGenericSysdateCount() 

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
     * Method iterateDtSysDtGenericSysdate
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<org.exolab.castor.types.Date> iterateDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdateList.iterator();
    } //-- java.util.Iterator<org.exolab.castor.types.Date> iterateDtSysDtGenericSysdate() 

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
    public void removeAllDtSysDtGenericSysdate()
    {
        this._dtSysDtGenericSysdateList.clear();
    } //-- void removeAllDtSysDtGenericSysdate() 

    /**
     * Method removeDtSysDtGenericSysdate
     * 
     * 
     * 
     * @param vDtSysDtGenericSysdate
     * @return true if the object was removed from the collection.
     */
    public boolean removeDtSysDtGenericSysdate(org.exolab.castor.types.Date vDtSysDtGenericSysdate)
    {
        boolean removed = _dtSysDtGenericSysdateList.remove(vDtSysDtGenericSysdate);
        return removed;
    } //-- boolean removeDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Method removeDtSysDtGenericSysdateAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.exolab.castor.types.Date removeDtSysDtGenericSysdateAt(int index)
    {
        Object obj = this._dtSysDtGenericSysdateList.remove(index);
        return (org.exolab.castor.types.Date) obj;
    } //-- org.exolab.castor.types.Date removeDtSysDtGenericSysdateAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vDtSysDtGenericSysdate
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDtSysDtGenericSysdate(int index, org.exolab.castor.types.Date vDtSysDtGenericSysdate)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._dtSysDtGenericSysdateList.size()) {
            throw new IndexOutOfBoundsException("setDtSysDtGenericSysdate: Index value '" + index + "' not in range [0.." + (this._dtSysDtGenericSysdateList.size() - 1) + "]");
        }
        
        this._dtSysDtGenericSysdateList.set(index, vDtSysDtGenericSysdate);
    } //-- void setDtSysDtGenericSysdate(int, org.exolab.castor.types.Date) 

    /**
     * 
     * 
     * @param vDtSysDtGenericSysdateArray
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date[] vDtSysDtGenericSysdateArray)
    {
        //-- copy array
        _dtSysDtGenericSysdateList.clear();
        
        for (int i = 0; i < vDtSysDtGenericSysdateArray.length; i++) {
                this._dtSysDtGenericSysdateList.add(vDtSysDtGenericSysdateArray[i]);
        }
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of '_dtSysDtGenericSysdateList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vDtSysDtGenericSysdateList the Vector to copy.
     */
    public void setDtSysDtGenericSysdate(java.util.List<org.exolab.castor.types.Date> vDtSysDtGenericSysdateList)
    {
        // copy vector
        this._dtSysDtGenericSysdateList.clear();
        
        this._dtSysDtGenericSysdateList.addAll(vDtSysDtGenericSysdateList);
    } //-- void setDtSysDtGenericSysdate(java.util.List) 

    /**
     * Sets the value of '_dtSysDtGenericSysdateList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param DtSysDtGenericSysdateVector the Vector to set.
     */
    public void setDtSysDtGenericSysdateAsReference(java.util.Vector<org.exolab.castor.types.Date> DtSysDtGenericSysdateVector)
    {
        this._dtSysDtGenericSysdateList = DtSysDtGenericSysdateVector;
    } //-- void setDtSysDtGenericSysdateAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY unmarshal(java.io.Reader) 

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
