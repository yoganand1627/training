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
 * Class ROWCLSC97DIG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCLSC97DIG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCLSC97DIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> _ROWCLSC97DIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCLSC97DIG00_ARRAY() 
     {
        super();
        this._ROWCLSC97DIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCLSC97DIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCLSC97DIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 vROWCLSC97DIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCLSC97DIG00List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCLSC97DIG00 has a maximum of 50");
        }
        
        this._ROWCLSC97DIG00List.add(vROWCLSC97DIG00);
    } //-- void addROWCLSC97DIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCLSC97DIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCLSC97DIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 vROWCLSC97DIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCLSC97DIG00List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCLSC97DIG00 has a maximum of 50");
        }
        
        this._ROWCLSC97DIG00List.add(index, vROWCLSC97DIG00);
    } //-- void addROWCLSC97DIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCLSC97DIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> enumerateROWCLSC97DIG00()
    {
        return java.util.Collections.enumeration(this._ROWCLSC97DIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> enumerateROWCLSC97DIG00() 

    /**
     * Method getROWCLSC97DIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 getROWCLSC97DIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCLSC97DIG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCLSC97DIG00: Index value '" + index + "' not in range [0.." + (this._ROWCLSC97DIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) _ROWCLSC97DIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 getROWCLSC97DIG00(int) 

    /**
     * Method getROWCLSC97DIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00[] getROWCLSC97DIG00()
    {
        int size = this._ROWCLSC97DIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) _ROWCLSC97DIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00[] getROWCLSC97DIG00() 

    /**
     * Method getROWCLSC97DIG00AsReference
     * 
     * Returns a reference to '_ROWCLSC97DIG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> getROWCLSC97DIG00AsReference()
    {
        return this._ROWCLSC97DIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> getROWCLSC97DIG00AsReference() 

    /**
     * Method getROWCLSC97DIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCLSC97DIG00Count()
    {
        return this._ROWCLSC97DIG00List.size();
    } //-- int getROWCLSC97DIG00Count() 

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
     * Method iterateROWCLSC97DIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> iterateROWCLSC97DIG00()
    {
        return this._ROWCLSC97DIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> iterateROWCLSC97DIG00() 

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
    public void removeAllROWCLSC97DIG00()
    {
        this._ROWCLSC97DIG00List.clear();
    } //-- void removeAllROWCLSC97DIG00() 

    /**
     * Method removeROWCLSC97DIG00
     * 
     * 
     * 
     * @param vROWCLSC97DIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCLSC97DIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 vROWCLSC97DIG00)
    {
        boolean removed = _ROWCLSC97DIG00List.remove(vROWCLSC97DIG00);
        return removed;
    } //-- boolean removeROWCLSC97DIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) 

    /**
     * Method removeROWCLSC97DIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 removeROWCLSC97DIG00At(int index)
    {
        Object obj = this._ROWCLSC97DIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 removeROWCLSC97DIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCLSC97DIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCLSC97DIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00 vROWCLSC97DIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCLSC97DIG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCLSC97DIG00: Index value '" + index + "' not in range [0.." + (this._ROWCLSC97DIG00List.size() - 1) + "]");
        }
        
        this._ROWCLSC97DIG00List.set(index, vROWCLSC97DIG00);
    } //-- void setROWCLSC97DIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) 

    /**
     * 
     * 
     * @param vROWCLSC97DIG00Array
     */
    public void setROWCLSC97DIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00[] vROWCLSC97DIG00Array)
    {
        //-- copy array
        _ROWCLSC97DIG00List.clear();
        
        for (int i = 0; i < vROWCLSC97DIG00Array.length; i++) {
                this._ROWCLSC97DIG00List.add(vROWCLSC97DIG00Array[i]);
        }
    } //-- void setROWCLSC97DIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00) 

    /**
     * Sets the value of '_ROWCLSC97DIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCLSC97DIG00List the Vector to copy.
     */
    public void setROWCLSC97DIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> vROWCLSC97DIG00List)
    {
        // copy vector
        this._ROWCLSC97DIG00List.clear();
        
        this._ROWCLSC97DIG00List.addAll(vROWCLSC97DIG00List);
    } //-- void setROWCLSC97DIG00(java.util.List) 

    /**
     * Sets the value of '_ROWCLSC97DIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCLSC97DIG00Vector the Vector to set.
     */
    public void setROWCLSC97DIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00> ROWCLSC97DIG00Vector)
    {
        this._ROWCLSC97DIG00List = ROWCLSC97DIG00Vector;
    } //-- void setROWCLSC97DIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY unmarshal(java.io.Reader) 

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
