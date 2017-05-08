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
 * Class ROWCFIN07SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN07SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN07SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> _ROWCFIN07SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN07SIG_ARRAY() 
     {
        super();
        this._ROWCFIN07SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN07SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN07SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG vROWCFIN07SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN07SIGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN07SIG has a maximum of 200");
        }
        
        this._ROWCFIN07SIGList.add(vROWCFIN07SIG);
    } //-- void addROWCFIN07SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN07SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN07SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG vROWCFIN07SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN07SIGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN07SIG has a maximum of 200");
        }
        
        this._ROWCFIN07SIGList.add(index, vROWCFIN07SIG);
    } //-- void addROWCFIN07SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN07SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> enumerateROWCFIN07SIG()
    {
        return java.util.Collections.enumeration(this._ROWCFIN07SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> enumerateROWCFIN07SIG() 

    /**
     * Method getROWCFIN07SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG getROWCFIN07SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN07SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN07SIG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN07SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) _ROWCFIN07SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG getROWCFIN07SIG(int) 

    /**
     * Method getROWCFIN07SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG[] getROWCFIN07SIG()
    {
        int size = this._ROWCFIN07SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) _ROWCFIN07SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG[] getROWCFIN07SIG() 

    /**
     * Method getROWCFIN07SIGAsReference
     * 
     * Returns a reference to '_ROWCFIN07SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> getROWCFIN07SIGAsReference()
    {
        return this._ROWCFIN07SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> getROWCFIN07SIGAsReference() 

    /**
     * Method getROWCFIN07SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN07SIGCount()
    {
        return this._ROWCFIN07SIGList.size();
    } //-- int getROWCFIN07SIGCount() 

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
     * Method iterateROWCFIN07SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> iterateROWCFIN07SIG()
    {
        return this._ROWCFIN07SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> iterateROWCFIN07SIG() 

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
    public void removeAllROWCFIN07SIG()
    {
        this._ROWCFIN07SIGList.clear();
    } //-- void removeAllROWCFIN07SIG() 

    /**
     * Method removeROWCFIN07SIG
     * 
     * 
     * 
     * @param vROWCFIN07SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN07SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG vROWCFIN07SIG)
    {
        boolean removed = _ROWCFIN07SIGList.remove(vROWCFIN07SIG);
        return removed;
    } //-- boolean removeROWCFIN07SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) 

    /**
     * Method removeROWCFIN07SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG removeROWCFIN07SIGAt(int index)
    {
        Object obj = this._ROWCFIN07SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG removeROWCFIN07SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN07SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN07SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG vROWCFIN07SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN07SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN07SIG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN07SIGList.size() - 1) + "]");
        }
        
        this._ROWCFIN07SIGList.set(index, vROWCFIN07SIG);
    } //-- void setROWCFIN07SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) 

    /**
     * 
     * 
     * @param vROWCFIN07SIGArray
     */
    public void setROWCFIN07SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG[] vROWCFIN07SIGArray)
    {
        //-- copy array
        _ROWCFIN07SIGList.clear();
        
        for (int i = 0; i < vROWCFIN07SIGArray.length; i++) {
                this._ROWCFIN07SIGList.add(vROWCFIN07SIGArray[i]);
        }
    } //-- void setROWCFIN07SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG) 

    /**
     * Sets the value of '_ROWCFIN07SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN07SIGList the Vector to copy.
     */
    public void setROWCFIN07SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> vROWCFIN07SIGList)
    {
        // copy vector
        this._ROWCFIN07SIGList.clear();
        
        this._ROWCFIN07SIGList.addAll(vROWCFIN07SIGList);
    } //-- void setROWCFIN07SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN07SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN07SIGVector the Vector to set.
     */
    public void setROWCFIN07SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG> ROWCFIN07SIGVector)
    {
        this._ROWCFIN07SIGList = ROWCFIN07SIGVector;
    } //-- void setROWCFIN07SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY unmarshal(java.io.Reader) 

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
