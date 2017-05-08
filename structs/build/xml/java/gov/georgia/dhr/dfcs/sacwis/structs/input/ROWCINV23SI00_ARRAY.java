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
 * Class ROWCINV23SI00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV23SI00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV23SI00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> _ROWCINV23SI00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV23SI00_ARRAY() 
     {
        super();
        this._ROWCINV23SI00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV23SI00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV23SI00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 vROWCINV23SI00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV23SI00List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCINV23SI00 has a maximum of 50");
        }
        
        this._ROWCINV23SI00List.add(vROWCINV23SI00);
    } //-- void addROWCINV23SI00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV23SI00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV23SI00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 vROWCINV23SI00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV23SI00List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCINV23SI00 has a maximum of 50");
        }
        
        this._ROWCINV23SI00List.add(index, vROWCINV23SI00);
    } //-- void addROWCINV23SI00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV23SI00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> enumerateROWCINV23SI00()
    {
        return java.util.Collections.enumeration(this._ROWCINV23SI00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> enumerateROWCINV23SI00() 

    /**
     * Method getROWCINV23SI00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 getROWCINV23SI00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV23SI00List.size()) {
            throw new IndexOutOfBoundsException("getROWCINV23SI00: Index value '" + index + "' not in range [0.." + (this._ROWCINV23SI00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) _ROWCINV23SI00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 getROWCINV23SI00(int) 

    /**
     * Method getROWCINV23SI00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00[] getROWCINV23SI00()
    {
        int size = this._ROWCINV23SI00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) _ROWCINV23SI00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00[] getROWCINV23SI00() 

    /**
     * Method getROWCINV23SI00AsReference
     * 
     * Returns a reference to '_ROWCINV23SI00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> getROWCINV23SI00AsReference()
    {
        return this._ROWCINV23SI00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> getROWCINV23SI00AsReference() 

    /**
     * Method getROWCINV23SI00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV23SI00Count()
    {
        return this._ROWCINV23SI00List.size();
    } //-- int getROWCINV23SI00Count() 

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
     * Method iterateROWCINV23SI00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> iterateROWCINV23SI00()
    {
        return this._ROWCINV23SI00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> iterateROWCINV23SI00() 

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
    public void removeAllROWCINV23SI00()
    {
        this._ROWCINV23SI00List.clear();
    } //-- void removeAllROWCINV23SI00() 

    /**
     * Method removeROWCINV23SI00
     * 
     * 
     * 
     * @param vROWCINV23SI00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV23SI00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 vROWCINV23SI00)
    {
        boolean removed = _ROWCINV23SI00List.remove(vROWCINV23SI00);
        return removed;
    } //-- boolean removeROWCINV23SI00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) 

    /**
     * Method removeROWCINV23SI00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 removeROWCINV23SI00At(int index)
    {
        Object obj = this._ROWCINV23SI00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 removeROWCINV23SI00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV23SI00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV23SI00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00 vROWCINV23SI00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV23SI00List.size()) {
            throw new IndexOutOfBoundsException("setROWCINV23SI00: Index value '" + index + "' not in range [0.." + (this._ROWCINV23SI00List.size() - 1) + "]");
        }
        
        this._ROWCINV23SI00List.set(index, vROWCINV23SI00);
    } //-- void setROWCINV23SI00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) 

    /**
     * 
     * 
     * @param vROWCINV23SI00Array
     */
    public void setROWCINV23SI00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00[] vROWCINV23SI00Array)
    {
        //-- copy array
        _ROWCINV23SI00List.clear();
        
        for (int i = 0; i < vROWCINV23SI00Array.length; i++) {
                this._ROWCINV23SI00List.add(vROWCINV23SI00Array[i]);
        }
    } //-- void setROWCINV23SI00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00) 

    /**
     * Sets the value of '_ROWCINV23SI00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV23SI00List the Vector to copy.
     */
    public void setROWCINV23SI00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> vROWCINV23SI00List)
    {
        // copy vector
        this._ROWCINV23SI00List.clear();
        
        this._ROWCINV23SI00List.addAll(vROWCINV23SI00List);
    } //-- void setROWCINV23SI00(java.util.List) 

    /**
     * Sets the value of '_ROWCINV23SI00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV23SI00Vector the Vector to set.
     */
    public void setROWCINV23SI00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00> ROWCINV23SI00Vector)
    {
        this._ROWCINV23SI00List = ROWCINV23SI00Vector;
    } //-- void setROWCINV23SI00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY unmarshal(java.io.Reader) 

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