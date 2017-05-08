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
 * Class CFAD33SIG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD33SIG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CFAD33SIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> _CFAD33SIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD33SIG00_ARRAY() 
     {
        super();
        this._CFAD33SIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCFAD33SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCFAD33SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 vCFAD33SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CFAD33SIG00List.size() >= 90) {
            throw new IndexOutOfBoundsException("addCFAD33SIG00 has a maximum of 90");
        }
        
        this._CFAD33SIG00List.add(vCFAD33SIG00);
    } //-- void addCFAD33SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) 

    /**
     * 
     * 
     * @param index
     * @param vCFAD33SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCFAD33SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 vCFAD33SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CFAD33SIG00List.size() >= 90) {
            throw new IndexOutOfBoundsException("addCFAD33SIG00 has a maximum of 90");
        }
        
        this._CFAD33SIG00List.add(index, vCFAD33SIG00);
    } //-- void addCFAD33SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCFAD33SIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> enumerateCFAD33SIG00()
    {
        return java.util.Collections.enumeration(this._CFAD33SIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> enumerateCFAD33SIG00() 

    /**
     * Method getCFAD33SIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 getCFAD33SIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CFAD33SIG00List.size()) {
            throw new IndexOutOfBoundsException("getCFAD33SIG00: Index value '" + index + "' not in range [0.." + (this._CFAD33SIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) _CFAD33SIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 getCFAD33SIG00(int) 

    /**
     * Method getCFAD33SIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00[] getCFAD33SIG00()
    {
        int size = this._CFAD33SIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) _CFAD33SIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00[] getCFAD33SIG00() 

    /**
     * Method getCFAD33SIG00AsReference
     * 
     * Returns a reference to '_CFAD33SIG00List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> getCFAD33SIG00AsReference()
    {
        return this._CFAD33SIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> getCFAD33SIG00AsReference() 

    /**
     * Method getCFAD33SIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCFAD33SIG00Count()
    {
        return this._CFAD33SIG00List.size();
    } //-- int getCFAD33SIG00Count() 

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
     * Method iterateCFAD33SIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> iterateCFAD33SIG00()
    {
        return this._CFAD33SIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> iterateCFAD33SIG00() 

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
    public void removeAllCFAD33SIG00()
    {
        this._CFAD33SIG00List.clear();
    } //-- void removeAllCFAD33SIG00() 

    /**
     * Method removeCFAD33SIG00
     * 
     * 
     * 
     * @param vCFAD33SIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeCFAD33SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 vCFAD33SIG00)
    {
        boolean removed = _CFAD33SIG00List.remove(vCFAD33SIG00);
        return removed;
    } //-- boolean removeCFAD33SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) 

    /**
     * Method removeCFAD33SIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 removeCFAD33SIG00At(int index)
    {
        Object obj = this._CFAD33SIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 removeCFAD33SIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCFAD33SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCFAD33SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 vCFAD33SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CFAD33SIG00List.size()) {
            throw new IndexOutOfBoundsException("setCFAD33SIG00: Index value '" + index + "' not in range [0.." + (this._CFAD33SIG00List.size() - 1) + "]");
        }
        
        this._CFAD33SIG00List.set(index, vCFAD33SIG00);
    } //-- void setCFAD33SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) 

    /**
     * 
     * 
     * @param vCFAD33SIG00Array
     */
    public void setCFAD33SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00[] vCFAD33SIG00Array)
    {
        //-- copy array
        _CFAD33SIG00List.clear();
        
        for (int i = 0; i < vCFAD33SIG00Array.length; i++) {
                this._CFAD33SIG00List.add(vCFAD33SIG00Array[i]);
        }
    } //-- void setCFAD33SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) 

    /**
     * Sets the value of '_CFAD33SIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCFAD33SIG00List the Vector to copy.
     */
    public void setCFAD33SIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> vCFAD33SIG00List)
    {
        // copy vector
        this._CFAD33SIG00List.clear();
        
        this._CFAD33SIG00List.addAll(vCFAD33SIG00List);
    } //-- void setCFAD33SIG00(java.util.List) 

    /**
     * Sets the value of '_CFAD33SIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CFAD33SIG00Vector the Vector to set.
     */
    public void setCFAD33SIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00> CFAD33SIG00Vector)
    {
        this._CFAD33SIG00List = CFAD33SIG00Vector;
    } //-- void setCFAD33SIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY unmarshal(java.io.Reader) 

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
