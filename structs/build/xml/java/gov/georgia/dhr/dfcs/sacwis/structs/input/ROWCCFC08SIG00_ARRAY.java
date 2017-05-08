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
 * Class ROWCCFC08SIG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC08SIG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCFC08SIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> _ROWCCFC08SIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC08SIG00_ARRAY() 
     {
        super();
        this._ROWCCFC08SIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCFC08SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCFC08SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 vROWCCFC08SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCFC08SIG00List.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCCFC08SIG00 has a maximum of 20");
        }
        
        this._ROWCCFC08SIG00List.add(vROWCCFC08SIG00);
    } //-- void addROWCCFC08SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCFC08SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCFC08SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 vROWCCFC08SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCFC08SIG00List.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCCFC08SIG00 has a maximum of 20");
        }
        
        this._ROWCCFC08SIG00List.add(index, vROWCCFC08SIG00);
    } //-- void addROWCCFC08SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCFC08SIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> enumerateROWCCFC08SIG00()
    {
        return java.util.Collections.enumeration(this._ROWCCFC08SIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> enumerateROWCCFC08SIG00() 

    /**
     * Method getROWCCFC08SIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 getROWCCFC08SIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCFC08SIG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCCFC08SIG00: Index value '" + index + "' not in range [0.." + (this._ROWCCFC08SIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) _ROWCCFC08SIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 getROWCCFC08SIG00(int) 

    /**
     * Method getROWCCFC08SIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00[] getROWCCFC08SIG00()
    {
        int size = this._ROWCCFC08SIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) _ROWCCFC08SIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00[] getROWCCFC08SIG00() 

    /**
     * Method getROWCCFC08SIG00AsReference
     * 
     * Returns a reference to '_ROWCCFC08SIG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> getROWCCFC08SIG00AsReference()
    {
        return this._ROWCCFC08SIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> getROWCCFC08SIG00AsReference() 

    /**
     * Method getROWCCFC08SIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCFC08SIG00Count()
    {
        return this._ROWCCFC08SIG00List.size();
    } //-- int getROWCCFC08SIG00Count() 

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
     * Method iterateROWCCFC08SIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> iterateROWCCFC08SIG00()
    {
        return this._ROWCCFC08SIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> iterateROWCCFC08SIG00() 

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
    public void removeAllROWCCFC08SIG00()
    {
        this._ROWCCFC08SIG00List.clear();
    } //-- void removeAllROWCCFC08SIG00() 

    /**
     * Method removeROWCCFC08SIG00
     * 
     * 
     * 
     * @param vROWCCFC08SIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCFC08SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 vROWCCFC08SIG00)
    {
        boolean removed = _ROWCCFC08SIG00List.remove(vROWCCFC08SIG00);
        return removed;
    } //-- boolean removeROWCCFC08SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) 

    /**
     * Method removeROWCCFC08SIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 removeROWCCFC08SIG00At(int index)
    {
        Object obj = this._ROWCCFC08SIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 removeROWCCFC08SIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCFC08SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCFC08SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00 vROWCCFC08SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCFC08SIG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCCFC08SIG00: Index value '" + index + "' not in range [0.." + (this._ROWCCFC08SIG00List.size() - 1) + "]");
        }
        
        this._ROWCCFC08SIG00List.set(index, vROWCCFC08SIG00);
    } //-- void setROWCCFC08SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) 

    /**
     * 
     * 
     * @param vROWCCFC08SIG00Array
     */
    public void setROWCCFC08SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00[] vROWCCFC08SIG00Array)
    {
        //-- copy array
        _ROWCCFC08SIG00List.clear();
        
        for (int i = 0; i < vROWCCFC08SIG00Array.length; i++) {
                this._ROWCCFC08SIG00List.add(vROWCCFC08SIG00Array[i]);
        }
    } //-- void setROWCCFC08SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00) 

    /**
     * Sets the value of '_ROWCCFC08SIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCFC08SIG00List the Vector to copy.
     */
    public void setROWCCFC08SIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> vROWCCFC08SIG00List)
    {
        // copy vector
        this._ROWCCFC08SIG00List.clear();
        
        this._ROWCCFC08SIG00List.addAll(vROWCCFC08SIG00List);
    } //-- void setROWCCFC08SIG00(java.util.List) 

    /**
     * Sets the value of '_ROWCCFC08SIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCFC08SIG00Vector the Vector to set.
     */
    public void setROWCCFC08SIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00> ROWCCFC08SIG00Vector)
    {
        this._ROWCCFC08SIG00List = ROWCCFC08SIG00Vector;
    } //-- void setROWCCFC08SIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRAY unmarshal(java.io.Reader) 

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
