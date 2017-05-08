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
 * Class ROWCRES06SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES06SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES06SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> _ROWCRES06SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES06SIG_ARRAY() 
     {
        super();
        this._ROWCRES06SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES06SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES06SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG vROWCRES06SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES06SIGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCRES06SIG has a maximum of 200");
        }
        
        this._ROWCRES06SIGList.add(vROWCRES06SIG);
    } //-- void addROWCRES06SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES06SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES06SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG vROWCRES06SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES06SIGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCRES06SIG has a maximum of 200");
        }
        
        this._ROWCRES06SIGList.add(index, vROWCRES06SIG);
    } //-- void addROWCRES06SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES06SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> enumerateROWCRES06SIG()
    {
        return java.util.Collections.enumeration(this._ROWCRES06SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> enumerateROWCRES06SIG() 

    /**
     * Method getROWCRES06SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG getROWCRES06SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES06SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCRES06SIG: Index value '" + index + "' not in range [0.." + (this._ROWCRES06SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) _ROWCRES06SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG getROWCRES06SIG(int) 

    /**
     * Method getROWCRES06SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG[] getROWCRES06SIG()
    {
        int size = this._ROWCRES06SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) _ROWCRES06SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG[] getROWCRES06SIG() 

    /**
     * Method getROWCRES06SIGAsReference
     * 
     * Returns a reference to '_ROWCRES06SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> getROWCRES06SIGAsReference()
    {
        return this._ROWCRES06SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> getROWCRES06SIGAsReference() 

    /**
     * Method getROWCRES06SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES06SIGCount()
    {
        return this._ROWCRES06SIGList.size();
    } //-- int getROWCRES06SIGCount() 

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
     * Method iterateROWCRES06SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> iterateROWCRES06SIG()
    {
        return this._ROWCRES06SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> iterateROWCRES06SIG() 

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
    public void removeAllROWCRES06SIG()
    {
        this._ROWCRES06SIGList.clear();
    } //-- void removeAllROWCRES06SIG() 

    /**
     * Method removeROWCRES06SIG
     * 
     * 
     * 
     * @param vROWCRES06SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES06SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG vROWCRES06SIG)
    {
        boolean removed = _ROWCRES06SIGList.remove(vROWCRES06SIG);
        return removed;
    } //-- boolean removeROWCRES06SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) 

    /**
     * Method removeROWCRES06SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG removeROWCRES06SIGAt(int index)
    {
        Object obj = this._ROWCRES06SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG removeROWCRES06SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES06SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES06SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG vROWCRES06SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES06SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCRES06SIG: Index value '" + index + "' not in range [0.." + (this._ROWCRES06SIGList.size() - 1) + "]");
        }
        
        this._ROWCRES06SIGList.set(index, vROWCRES06SIG);
    } //-- void setROWCRES06SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) 

    /**
     * 
     * 
     * @param vROWCRES06SIGArray
     */
    public void setROWCRES06SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG[] vROWCRES06SIGArray)
    {
        //-- copy array
        _ROWCRES06SIGList.clear();
        
        for (int i = 0; i < vROWCRES06SIGArray.length; i++) {
                this._ROWCRES06SIGList.add(vROWCRES06SIGArray[i]);
        }
    } //-- void setROWCRES06SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) 

    /**
     * Sets the value of '_ROWCRES06SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES06SIGList the Vector to copy.
     */
    public void setROWCRES06SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> vROWCRES06SIGList)
    {
        // copy vector
        this._ROWCRES06SIGList.clear();
        
        this._ROWCRES06SIGList.addAll(vROWCRES06SIGList);
    } //-- void setROWCRES06SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCRES06SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES06SIGVector the Vector to set.
     */
    public void setROWCRES06SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG> ROWCRES06SIGVector)
    {
        this._ROWCRES06SIGList = ROWCRES06SIGVector;
    } //-- void setROWCRES06SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY unmarshal(java.io.Reader) 

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
