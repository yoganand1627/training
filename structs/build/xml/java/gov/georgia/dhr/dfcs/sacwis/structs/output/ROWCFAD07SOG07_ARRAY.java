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
 * Class ROWCFAD07SOG07_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD07SOG07_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFAD07SOG07List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> _ROWCFAD07SOG07List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD07SOG07_ARRAY() 
     {
        super();
        this._ROWCFAD07SOG07List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFAD07SOG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFAD07SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 vROWCFAD07SOG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFAD07SOG07List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCFAD07SOG07 has a maximum of 50");
        }
        
        this._ROWCFAD07SOG07List.add(vROWCFAD07SOG07);
    } //-- void addROWCFAD07SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFAD07SOG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFAD07SOG07(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 vROWCFAD07SOG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFAD07SOG07List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCFAD07SOG07 has a maximum of 50");
        }
        
        this._ROWCFAD07SOG07List.add(index, vROWCFAD07SOG07);
    } //-- void addROWCFAD07SOG07(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFAD07SOG07
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> enumerateROWCFAD07SOG07()
    {
        return java.util.Collections.enumeration(this._ROWCFAD07SOG07List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> enumerateROWCFAD07SOG07() 

    /**
     * Method getROWCFAD07SOG07
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 getROWCFAD07SOG07(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFAD07SOG07List.size()) {
            throw new IndexOutOfBoundsException("getROWCFAD07SOG07: Index value '" + index + "' not in range [0.." + (this._ROWCFAD07SOG07List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) _ROWCFAD07SOG07List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 getROWCFAD07SOG07(int) 

    /**
     * Method getROWCFAD07SOG07
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07[] getROWCFAD07SOG07()
    {
        int size = this._ROWCFAD07SOG07List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) _ROWCFAD07SOG07List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07[] getROWCFAD07SOG07() 

    /**
     * Method getROWCFAD07SOG07AsReference
     * 
     * Returns a reference to '_ROWCFAD07SOG07List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> getROWCFAD07SOG07AsReference()
    {
        return this._ROWCFAD07SOG07List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> getROWCFAD07SOG07AsReference() 

    /**
     * Method getROWCFAD07SOG07Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFAD07SOG07Count()
    {
        return this._ROWCFAD07SOG07List.size();
    } //-- int getROWCFAD07SOG07Count() 

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
     * Method iterateROWCFAD07SOG07
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> iterateROWCFAD07SOG07()
    {
        return this._ROWCFAD07SOG07List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> iterateROWCFAD07SOG07() 

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
    public void removeAllROWCFAD07SOG07()
    {
        this._ROWCFAD07SOG07List.clear();
    } //-- void removeAllROWCFAD07SOG07() 

    /**
     * Method removeROWCFAD07SOG07
     * 
     * 
     * 
     * @param vROWCFAD07SOG07
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFAD07SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 vROWCFAD07SOG07)
    {
        boolean removed = _ROWCFAD07SOG07List.remove(vROWCFAD07SOG07);
        return removed;
    } //-- boolean removeROWCFAD07SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) 

    /**
     * Method removeROWCFAD07SOG07At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 removeROWCFAD07SOG07At(int index)
    {
        Object obj = this._ROWCFAD07SOG07List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 removeROWCFAD07SOG07At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFAD07SOG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFAD07SOG07(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07 vROWCFAD07SOG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFAD07SOG07List.size()) {
            throw new IndexOutOfBoundsException("setROWCFAD07SOG07: Index value '" + index + "' not in range [0.." + (this._ROWCFAD07SOG07List.size() - 1) + "]");
        }
        
        this._ROWCFAD07SOG07List.set(index, vROWCFAD07SOG07);
    } //-- void setROWCFAD07SOG07(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) 

    /**
     * 
     * 
     * @param vROWCFAD07SOG07Array
     */
    public void setROWCFAD07SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07[] vROWCFAD07SOG07Array)
    {
        //-- copy array
        _ROWCFAD07SOG07List.clear();
        
        for (int i = 0; i < vROWCFAD07SOG07Array.length; i++) {
                this._ROWCFAD07SOG07List.add(vROWCFAD07SOG07Array[i]);
        }
    } //-- void setROWCFAD07SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07) 

    /**
     * Sets the value of '_ROWCFAD07SOG07List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFAD07SOG07List the Vector to copy.
     */
    public void setROWCFAD07SOG07(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> vROWCFAD07SOG07List)
    {
        // copy vector
        this._ROWCFAD07SOG07List.clear();
        
        this._ROWCFAD07SOG07List.addAll(vROWCFAD07SOG07List);
    } //-- void setROWCFAD07SOG07(java.util.List) 

    /**
     * Sets the value of '_ROWCFAD07SOG07List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFAD07SOG07Vector the Vector to set.
     */
    public void setROWCFAD07SOG07AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07> ROWCFAD07SOG07Vector)
    {
        this._ROWCFAD07SOG07List = ROWCFAD07SOG07Vector;
    } //-- void setROWCFAD07SOG07AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY unmarshal(java.io.Reader) 

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
