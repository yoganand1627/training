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
 * Class ROWCINV22SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV22SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV22SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> _ROWCINV22SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV22SIG_ARRAY() 
     {
        super();
        this._ROWCINV22SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV22SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV22SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG vROWCINV22SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV22SIGList.size() >= 75) {
            throw new IndexOutOfBoundsException("addROWCINV22SIG has a maximum of 75");
        }
        
        this._ROWCINV22SIGList.add(vROWCINV22SIG);
    } //-- void addROWCINV22SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV22SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV22SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG vROWCINV22SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV22SIGList.size() >= 75) {
            throw new IndexOutOfBoundsException("addROWCINV22SIG has a maximum of 75");
        }
        
        this._ROWCINV22SIGList.add(index, vROWCINV22SIG);
    } //-- void addROWCINV22SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV22SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> enumerateROWCINV22SIG()
    {
        return java.util.Collections.enumeration(this._ROWCINV22SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> enumerateROWCINV22SIG() 

    /**
     * Method getROWCINV22SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG getROWCINV22SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV22SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCINV22SIG: Index value '" + index + "' not in range [0.." + (this._ROWCINV22SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) _ROWCINV22SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG getROWCINV22SIG(int) 

    /**
     * Method getROWCINV22SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG[] getROWCINV22SIG()
    {
        int size = this._ROWCINV22SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) _ROWCINV22SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG[] getROWCINV22SIG() 

    /**
     * Method getROWCINV22SIGAsReference
     * 
     * Returns a reference to '_ROWCINV22SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> getROWCINV22SIGAsReference()
    {
        return this._ROWCINV22SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> getROWCINV22SIGAsReference() 

    /**
     * Method getROWCINV22SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV22SIGCount()
    {
        return this._ROWCINV22SIGList.size();
    } //-- int getROWCINV22SIGCount() 

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
     * Method iterateROWCINV22SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> iterateROWCINV22SIG()
    {
        return this._ROWCINV22SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> iterateROWCINV22SIG() 

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
    public void removeAllROWCINV22SIG()
    {
        this._ROWCINV22SIGList.clear();
    } //-- void removeAllROWCINV22SIG() 

    /**
     * Method removeROWCINV22SIG
     * 
     * 
     * 
     * @param vROWCINV22SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV22SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG vROWCINV22SIG)
    {
        boolean removed = _ROWCINV22SIGList.remove(vROWCINV22SIG);
        return removed;
    } //-- boolean removeROWCINV22SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) 

    /**
     * Method removeROWCINV22SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG removeROWCINV22SIGAt(int index)
    {
        Object obj = this._ROWCINV22SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG removeROWCINV22SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV22SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV22SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG vROWCINV22SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV22SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCINV22SIG: Index value '" + index + "' not in range [0.." + (this._ROWCINV22SIGList.size() - 1) + "]");
        }
        
        this._ROWCINV22SIGList.set(index, vROWCINV22SIG);
    } //-- void setROWCINV22SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) 

    /**
     * 
     * 
     * @param vROWCINV22SIGArray
     */
    public void setROWCINV22SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG[] vROWCINV22SIGArray)
    {
        //-- copy array
        _ROWCINV22SIGList.clear();
        
        for (int i = 0; i < vROWCINV22SIGArray.length; i++) {
                this._ROWCINV22SIGList.add(vROWCINV22SIGArray[i]);
        }
    } //-- void setROWCINV22SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG) 

    /**
     * Sets the value of '_ROWCINV22SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV22SIGList the Vector to copy.
     */
    public void setROWCINV22SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> vROWCINV22SIGList)
    {
        // copy vector
        this._ROWCINV22SIGList.clear();
        
        this._ROWCINV22SIGList.addAll(vROWCINV22SIGList);
    } //-- void setROWCINV22SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCINV22SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV22SIGVector the Vector to set.
     */
    public void setROWCINV22SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG> ROWCINV22SIGVector)
    {
        this._ROWCINV22SIGList = ROWCINV22SIGVector;
    } //-- void setROWCINV22SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY unmarshal(java.io.Reader) 

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
