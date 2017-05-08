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
 * Class ROWCFAD08SIG07_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD08SIG07_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFAD08SIG07List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> _ROWCFAD08SIG07List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD08SIG07_ARRAY() 
     {
        super();
        this._ROWCFAD08SIG07List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFAD08SIG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFAD08SIG07(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 vROWCFAD08SIG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFAD08SIG07List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCFAD08SIG07 has a maximum of 50");
        }
        
        this._ROWCFAD08SIG07List.add(vROWCFAD08SIG07);
    } //-- void addROWCFAD08SIG07(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFAD08SIG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFAD08SIG07(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 vROWCFAD08SIG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFAD08SIG07List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCFAD08SIG07 has a maximum of 50");
        }
        
        this._ROWCFAD08SIG07List.add(index, vROWCFAD08SIG07);
    } //-- void addROWCFAD08SIG07(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFAD08SIG07
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> enumerateROWCFAD08SIG07()
    {
        return java.util.Collections.enumeration(this._ROWCFAD08SIG07List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> enumerateROWCFAD08SIG07() 

    /**
     * Method getROWCFAD08SIG07
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 getROWCFAD08SIG07(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFAD08SIG07List.size()) {
            throw new IndexOutOfBoundsException("getROWCFAD08SIG07: Index value '" + index + "' not in range [0.." + (this._ROWCFAD08SIG07List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) _ROWCFAD08SIG07List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 getROWCFAD08SIG07(int) 

    /**
     * Method getROWCFAD08SIG07
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07[] getROWCFAD08SIG07()
    {
        int size = this._ROWCFAD08SIG07List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) _ROWCFAD08SIG07List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07[] getROWCFAD08SIG07() 

    /**
     * Method getROWCFAD08SIG07AsReference
     * 
     * Returns a reference to '_ROWCFAD08SIG07List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> getROWCFAD08SIG07AsReference()
    {
        return this._ROWCFAD08SIG07List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> getROWCFAD08SIG07AsReference() 

    /**
     * Method getROWCFAD08SIG07Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFAD08SIG07Count()
    {
        return this._ROWCFAD08SIG07List.size();
    } //-- int getROWCFAD08SIG07Count() 

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
     * Method iterateROWCFAD08SIG07
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> iterateROWCFAD08SIG07()
    {
        return this._ROWCFAD08SIG07List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> iterateROWCFAD08SIG07() 

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
    public void removeAllROWCFAD08SIG07()
    {
        this._ROWCFAD08SIG07List.clear();
    } //-- void removeAllROWCFAD08SIG07() 

    /**
     * Method removeROWCFAD08SIG07
     * 
     * 
     * 
     * @param vROWCFAD08SIG07
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFAD08SIG07(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 vROWCFAD08SIG07)
    {
        boolean removed = _ROWCFAD08SIG07List.remove(vROWCFAD08SIG07);
        return removed;
    } //-- boolean removeROWCFAD08SIG07(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) 

    /**
     * Method removeROWCFAD08SIG07At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 removeROWCFAD08SIG07At(int index)
    {
        Object obj = this._ROWCFAD08SIG07List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 removeROWCFAD08SIG07At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFAD08SIG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFAD08SIG07(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07 vROWCFAD08SIG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFAD08SIG07List.size()) {
            throw new IndexOutOfBoundsException("setROWCFAD08SIG07: Index value '" + index + "' not in range [0.." + (this._ROWCFAD08SIG07List.size() - 1) + "]");
        }
        
        this._ROWCFAD08SIG07List.set(index, vROWCFAD08SIG07);
    } //-- void setROWCFAD08SIG07(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) 

    /**
     * 
     * 
     * @param vROWCFAD08SIG07Array
     */
    public void setROWCFAD08SIG07(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07[] vROWCFAD08SIG07Array)
    {
        //-- copy array
        _ROWCFAD08SIG07List.clear();
        
        for (int i = 0; i < vROWCFAD08SIG07Array.length; i++) {
                this._ROWCFAD08SIG07List.add(vROWCFAD08SIG07Array[i]);
        }
    } //-- void setROWCFAD08SIG07(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07) 

    /**
     * Sets the value of '_ROWCFAD08SIG07List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFAD08SIG07List the Vector to copy.
     */
    public void setROWCFAD08SIG07(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> vROWCFAD08SIG07List)
    {
        // copy vector
        this._ROWCFAD08SIG07List.clear();
        
        this._ROWCFAD08SIG07List.addAll(vROWCFAD08SIG07List);
    } //-- void setROWCFAD08SIG07(java.util.List) 

    /**
     * Sets the value of '_ROWCFAD08SIG07List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFAD08SIG07Vector the Vector to set.
     */
    public void setROWCFAD08SIG07AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07> ROWCFAD08SIG07Vector)
    {
        this._ROWCFAD08SIG07List = ROWCFAD08SIG07Vector;
    } //-- void setROWCFAD08SIG07AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY unmarshal(java.io.Reader) 

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
