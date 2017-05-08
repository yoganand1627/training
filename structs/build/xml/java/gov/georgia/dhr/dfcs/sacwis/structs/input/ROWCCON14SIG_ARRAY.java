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
 * Class ROWCCON14SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON14SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCON14SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> _ROWCCON14SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON14SIG_ARRAY() 
     {
        super();
        this._ROWCCON14SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCON14SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCON14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG vROWCCON14SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCON14SIGList.size() >= 260) {
            throw new IndexOutOfBoundsException("addROWCCON14SIG has a maximum of 260");
        }
        
        this._ROWCCON14SIGList.add(vROWCCON14SIG);
    } //-- void addROWCCON14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCON14SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCON14SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG vROWCCON14SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCON14SIGList.size() >= 260) {
            throw new IndexOutOfBoundsException("addROWCCON14SIG has a maximum of 260");
        }
        
        this._ROWCCON14SIGList.add(index, vROWCCON14SIG);
    } //-- void addROWCCON14SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCON14SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> enumerateROWCCON14SIG()
    {
        return java.util.Collections.enumeration(this._ROWCCON14SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> enumerateROWCCON14SIG() 

    /**
     * Method getROWCCON14SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG getROWCCON14SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCON14SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCCON14SIG: Index value '" + index + "' not in range [0.." + (this._ROWCCON14SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) _ROWCCON14SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG getROWCCON14SIG(int) 

    /**
     * Method getROWCCON14SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG[] getROWCCON14SIG()
    {
        int size = this._ROWCCON14SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) _ROWCCON14SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG[] getROWCCON14SIG() 

    /**
     * Method getROWCCON14SIGAsReference
     * 
     * Returns a reference to '_ROWCCON14SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> getROWCCON14SIGAsReference()
    {
        return this._ROWCCON14SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> getROWCCON14SIGAsReference() 

    /**
     * Method getROWCCON14SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCON14SIGCount()
    {
        return this._ROWCCON14SIGList.size();
    } //-- int getROWCCON14SIGCount() 

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
     * Method iterateROWCCON14SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> iterateROWCCON14SIG()
    {
        return this._ROWCCON14SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> iterateROWCCON14SIG() 

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
    public void removeAllROWCCON14SIG()
    {
        this._ROWCCON14SIGList.clear();
    } //-- void removeAllROWCCON14SIG() 

    /**
     * Method removeROWCCON14SIG
     * 
     * 
     * 
     * @param vROWCCON14SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCON14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG vROWCCON14SIG)
    {
        boolean removed = _ROWCCON14SIGList.remove(vROWCCON14SIG);
        return removed;
    } //-- boolean removeROWCCON14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) 

    /**
     * Method removeROWCCON14SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG removeROWCCON14SIGAt(int index)
    {
        Object obj = this._ROWCCON14SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG removeROWCCON14SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCON14SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCON14SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG vROWCCON14SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCON14SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCCON14SIG: Index value '" + index + "' not in range [0.." + (this._ROWCCON14SIGList.size() - 1) + "]");
        }
        
        this._ROWCCON14SIGList.set(index, vROWCCON14SIG);
    } //-- void setROWCCON14SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) 

    /**
     * 
     * 
     * @param vROWCCON14SIGArray
     */
    public void setROWCCON14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG[] vROWCCON14SIGArray)
    {
        //-- copy array
        _ROWCCON14SIGList.clear();
        
        for (int i = 0; i < vROWCCON14SIGArray.length; i++) {
                this._ROWCCON14SIGList.add(vROWCCON14SIGArray[i]);
        }
    } //-- void setROWCCON14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG) 

    /**
     * Sets the value of '_ROWCCON14SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCON14SIGList the Vector to copy.
     */
    public void setROWCCON14SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> vROWCCON14SIGList)
    {
        // copy vector
        this._ROWCCON14SIGList.clear();
        
        this._ROWCCON14SIGList.addAll(vROWCCON14SIGList);
    } //-- void setROWCCON14SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCCON14SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCON14SIGVector the Vector to set.
     */
    public void setROWCCON14SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG> ROWCCON14SIGVector)
    {
        this._ROWCCON14SIGList = ROWCCON14SIGVector;
    } //-- void setROWCCON14SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY unmarshal(java.io.Reader) 

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
