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
 * Class ROWCFIN16SIG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN16SIG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN16SIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> _ROWCFIN16SIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN16SIG00_ARRAY() 
     {
        super();
        this._ROWCFIN16SIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN16SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN16SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 vROWCFIN16SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN16SIG00List.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN16SIG00 has a maximum of 200");
        }
        
        this._ROWCFIN16SIG00List.add(vROWCFIN16SIG00);
    } //-- void addROWCFIN16SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN16SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN16SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 vROWCFIN16SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN16SIG00List.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN16SIG00 has a maximum of 200");
        }
        
        this._ROWCFIN16SIG00List.add(index, vROWCFIN16SIG00);
    } //-- void addROWCFIN16SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN16SIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> enumerateROWCFIN16SIG00()
    {
        return java.util.Collections.enumeration(this._ROWCFIN16SIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> enumerateROWCFIN16SIG00() 

    /**
     * Method getROWCFIN16SIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 getROWCFIN16SIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN16SIG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN16SIG00: Index value '" + index + "' not in range [0.." + (this._ROWCFIN16SIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) _ROWCFIN16SIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 getROWCFIN16SIG00(int) 

    /**
     * Method getROWCFIN16SIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00[] getROWCFIN16SIG00()
    {
        int size = this._ROWCFIN16SIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) _ROWCFIN16SIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00[] getROWCFIN16SIG00() 

    /**
     * Method getROWCFIN16SIG00AsReference
     * 
     * Returns a reference to '_ROWCFIN16SIG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> getROWCFIN16SIG00AsReference()
    {
        return this._ROWCFIN16SIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> getROWCFIN16SIG00AsReference() 

    /**
     * Method getROWCFIN16SIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN16SIG00Count()
    {
        return this._ROWCFIN16SIG00List.size();
    } //-- int getROWCFIN16SIG00Count() 

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
     * Method iterateROWCFIN16SIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> iterateROWCFIN16SIG00()
    {
        return this._ROWCFIN16SIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> iterateROWCFIN16SIG00() 

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
    public void removeAllROWCFIN16SIG00()
    {
        this._ROWCFIN16SIG00List.clear();
    } //-- void removeAllROWCFIN16SIG00() 

    /**
     * Method removeROWCFIN16SIG00
     * 
     * 
     * 
     * @param vROWCFIN16SIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN16SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 vROWCFIN16SIG00)
    {
        boolean removed = _ROWCFIN16SIG00List.remove(vROWCFIN16SIG00);
        return removed;
    } //-- boolean removeROWCFIN16SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) 

    /**
     * Method removeROWCFIN16SIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 removeROWCFIN16SIG00At(int index)
    {
        Object obj = this._ROWCFIN16SIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 removeROWCFIN16SIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN16SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN16SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00 vROWCFIN16SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN16SIG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN16SIG00: Index value '" + index + "' not in range [0.." + (this._ROWCFIN16SIG00List.size() - 1) + "]");
        }
        
        this._ROWCFIN16SIG00List.set(index, vROWCFIN16SIG00);
    } //-- void setROWCFIN16SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) 

    /**
     * 
     * 
     * @param vROWCFIN16SIG00Array
     */
    public void setROWCFIN16SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00[] vROWCFIN16SIG00Array)
    {
        //-- copy array
        _ROWCFIN16SIG00List.clear();
        
        for (int i = 0; i < vROWCFIN16SIG00Array.length; i++) {
                this._ROWCFIN16SIG00List.add(vROWCFIN16SIG00Array[i]);
        }
    } //-- void setROWCFIN16SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00) 

    /**
     * Sets the value of '_ROWCFIN16SIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN16SIG00List the Vector to copy.
     */
    public void setROWCFIN16SIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> vROWCFIN16SIG00List)
    {
        // copy vector
        this._ROWCFIN16SIG00List.clear();
        
        this._ROWCFIN16SIG00List.addAll(vROWCFIN16SIG00List);
    } //-- void setROWCFIN16SIG00(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN16SIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN16SIG00Vector the Vector to set.
     */
    public void setROWCFIN16SIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00> ROWCFIN16SIG00Vector)
    {
        this._ROWCFIN16SIG00List = ROWCFIN16SIG00Vector;
    } //-- void setROWCFIN16SIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRAY unmarshal(java.io.Reader) 

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
