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
 * Class CFAD01UIG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD01UIG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CFAD01UIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> _CFAD01UIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD01UIG00_ARRAY() 
     {
        super();
        this._CFAD01UIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCFAD01UIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCFAD01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 vCFAD01UIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CFAD01UIG00List.size() >= 100) {
            throw new IndexOutOfBoundsException("addCFAD01UIG00 has a maximum of 100");
        }
        
        this._CFAD01UIG00List.add(vCFAD01UIG00);
    } //-- void addCFAD01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) 

    /**
     * 
     * 
     * @param index
     * @param vCFAD01UIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCFAD01UIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 vCFAD01UIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CFAD01UIG00List.size() >= 100) {
            throw new IndexOutOfBoundsException("addCFAD01UIG00 has a maximum of 100");
        }
        
        this._CFAD01UIG00List.add(index, vCFAD01UIG00);
    } //-- void addCFAD01UIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCFAD01UIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> enumerateCFAD01UIG00()
    {
        return java.util.Collections.enumeration(this._CFAD01UIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> enumerateCFAD01UIG00() 

    /**
     * Method getCFAD01UIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 getCFAD01UIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CFAD01UIG00List.size()) {
            throw new IndexOutOfBoundsException("getCFAD01UIG00: Index value '" + index + "' not in range [0.." + (this._CFAD01UIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) _CFAD01UIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 getCFAD01UIG00(int) 

    /**
     * Method getCFAD01UIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00[] getCFAD01UIG00()
    {
        int size = this._CFAD01UIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) _CFAD01UIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00[] getCFAD01UIG00() 

    /**
     * Method getCFAD01UIG00AsReference
     * 
     * Returns a reference to '_CFAD01UIG00List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> getCFAD01UIG00AsReference()
    {
        return this._CFAD01UIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> getCFAD01UIG00AsReference() 

    /**
     * Method getCFAD01UIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCFAD01UIG00Count()
    {
        return this._CFAD01UIG00List.size();
    } //-- int getCFAD01UIG00Count() 

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
     * Method iterateCFAD01UIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> iterateCFAD01UIG00()
    {
        return this._CFAD01UIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> iterateCFAD01UIG00() 

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
    public void removeAllCFAD01UIG00()
    {
        this._CFAD01UIG00List.clear();
    } //-- void removeAllCFAD01UIG00() 

    /**
     * Method removeCFAD01UIG00
     * 
     * 
     * 
     * @param vCFAD01UIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeCFAD01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 vCFAD01UIG00)
    {
        boolean removed = _CFAD01UIG00List.remove(vCFAD01UIG00);
        return removed;
    } //-- boolean removeCFAD01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) 

    /**
     * Method removeCFAD01UIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 removeCFAD01UIG00At(int index)
    {
        Object obj = this._CFAD01UIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 removeCFAD01UIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCFAD01UIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCFAD01UIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00 vCFAD01UIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CFAD01UIG00List.size()) {
            throw new IndexOutOfBoundsException("setCFAD01UIG00: Index value '" + index + "' not in range [0.." + (this._CFAD01UIG00List.size() - 1) + "]");
        }
        
        this._CFAD01UIG00List.set(index, vCFAD01UIG00);
    } //-- void setCFAD01UIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) 

    /**
     * 
     * 
     * @param vCFAD01UIG00Array
     */
    public void setCFAD01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00[] vCFAD01UIG00Array)
    {
        //-- copy array
        _CFAD01UIG00List.clear();
        
        for (int i = 0; i < vCFAD01UIG00Array.length; i++) {
                this._CFAD01UIG00List.add(vCFAD01UIG00Array[i]);
        }
    } //-- void setCFAD01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00) 

    /**
     * Sets the value of '_CFAD01UIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCFAD01UIG00List the Vector to copy.
     */
    public void setCFAD01UIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> vCFAD01UIG00List)
    {
        // copy vector
        this._CFAD01UIG00List.clear();
        
        this._CFAD01UIG00List.addAll(vCFAD01UIG00List);
    } //-- void setCFAD01UIG00(java.util.List) 

    /**
     * Sets the value of '_CFAD01UIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CFAD01UIG00Vector the Vector to set.
     */
    public void setCFAD01UIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00> CFAD01UIG00Vector)
    {
        this._CFAD01UIG00List = CFAD01UIG00Vector;
    } //-- void setCFAD01UIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY unmarshal(java.io.Reader) 

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
