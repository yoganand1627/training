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
 * Class ROWCCON13SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON13SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCON13SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> _ROWCCON13SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON13SOG_ARRAY() 
     {
        super();
        this._ROWCCON13SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCON13SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCON13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG vROWCCON13SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCON13SOGList.size() >= 260) {
            throw new IndexOutOfBoundsException("addROWCCON13SOG has a maximum of 260");
        }
        
        this._ROWCCON13SOGList.add(vROWCCON13SOG);
    } //-- void addROWCCON13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCON13SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCON13SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG vROWCCON13SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCON13SOGList.size() >= 260) {
            throw new IndexOutOfBoundsException("addROWCCON13SOG has a maximum of 260");
        }
        
        this._ROWCCON13SOGList.add(index, vROWCCON13SOG);
    } //-- void addROWCCON13SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCON13SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> enumerateROWCCON13SOG()
    {
        return java.util.Collections.enumeration(this._ROWCCON13SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> enumerateROWCCON13SOG() 

    /**
     * Method getROWCCON13SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG getROWCCON13SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCON13SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCCON13SOG: Index value '" + index + "' not in range [0.." + (this._ROWCCON13SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) _ROWCCON13SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG getROWCCON13SOG(int) 

    /**
     * Method getROWCCON13SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG[] getROWCCON13SOG()
    {
        int size = this._ROWCCON13SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) _ROWCCON13SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG[] getROWCCON13SOG() 

    /**
     * Method getROWCCON13SOGAsReference
     * 
     * Returns a reference to '_ROWCCON13SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> getROWCCON13SOGAsReference()
    {
        return this._ROWCCON13SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> getROWCCON13SOGAsReference() 

    /**
     * Method getROWCCON13SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCON13SOGCount()
    {
        return this._ROWCCON13SOGList.size();
    } //-- int getROWCCON13SOGCount() 

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
     * Method iterateROWCCON13SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> iterateROWCCON13SOG()
    {
        return this._ROWCCON13SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> iterateROWCCON13SOG() 

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
    public void removeAllROWCCON13SOG()
    {
        this._ROWCCON13SOGList.clear();
    } //-- void removeAllROWCCON13SOG() 

    /**
     * Method removeROWCCON13SOG
     * 
     * 
     * 
     * @param vROWCCON13SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCON13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG vROWCCON13SOG)
    {
        boolean removed = _ROWCCON13SOGList.remove(vROWCCON13SOG);
        return removed;
    } //-- boolean removeROWCCON13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) 

    /**
     * Method removeROWCCON13SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG removeROWCCON13SOGAt(int index)
    {
        Object obj = this._ROWCCON13SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG removeROWCCON13SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCON13SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCON13SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG vROWCCON13SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCON13SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCCON13SOG: Index value '" + index + "' not in range [0.." + (this._ROWCCON13SOGList.size() - 1) + "]");
        }
        
        this._ROWCCON13SOGList.set(index, vROWCCON13SOG);
    } //-- void setROWCCON13SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) 

    /**
     * 
     * 
     * @param vROWCCON13SOGArray
     */
    public void setROWCCON13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG[] vROWCCON13SOGArray)
    {
        //-- copy array
        _ROWCCON13SOGList.clear();
        
        for (int i = 0; i < vROWCCON13SOGArray.length; i++) {
                this._ROWCCON13SOGList.add(vROWCCON13SOGArray[i]);
        }
    } //-- void setROWCCON13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) 

    /**
     * Sets the value of '_ROWCCON13SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCON13SOGList the Vector to copy.
     */
    public void setROWCCON13SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> vROWCCON13SOGList)
    {
        // copy vector
        this._ROWCCON13SOGList.clear();
        
        this._ROWCCON13SOGList.addAll(vROWCCON13SOGList);
    } //-- void setROWCCON13SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCCON13SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCON13SOGVector the Vector to set.
     */
    public void setROWCCON13SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG> ROWCCON13SOGVector)
    {
        this._ROWCCON13SOGList = ROWCCON13SOGVector;
    } //-- void setROWCCON13SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY unmarshal(java.io.Reader) 

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
