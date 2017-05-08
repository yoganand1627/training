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
 * Class ROWCARC06SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC06SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCARC06SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> _ROWCARC06SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC06SOG_ARRAY() 
     {
        super();
        this._ROWCARC06SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCARC06SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG vROWCARC06SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC06SOGList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCARC06SOG has a maximum of 50");
        }
        
        this._ROWCARC06SOGList.add(vROWCARC06SOG);
    } //-- void addROWCARC06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC06SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC06SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG vROWCARC06SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC06SOGList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCARC06SOG has a maximum of 50");
        }
        
        this._ROWCARC06SOGList.add(index, vROWCARC06SOG);
    } //-- void addROWCARC06SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCARC06SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> enumerateROWCARC06SOG()
    {
        return java.util.Collections.enumeration(this._ROWCARC06SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> enumerateROWCARC06SOG() 

    /**
     * Method getROWCARC06SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG getROWCARC06SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC06SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCARC06SOG: Index value '" + index + "' not in range [0.." + (this._ROWCARC06SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) _ROWCARC06SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG getROWCARC06SOG(int) 

    /**
     * Method getROWCARC06SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG[] getROWCARC06SOG()
    {
        int size = this._ROWCARC06SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) _ROWCARC06SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG[] getROWCARC06SOG() 

    /**
     * Method getROWCARC06SOGAsReference
     * 
     * Returns a reference to '_ROWCARC06SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> getROWCARC06SOGAsReference()
    {
        return this._ROWCARC06SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> getROWCARC06SOGAsReference() 

    /**
     * Method getROWCARC06SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCARC06SOGCount()
    {
        return this._ROWCARC06SOGList.size();
    } //-- int getROWCARC06SOGCount() 

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
     * Method iterateROWCARC06SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> iterateROWCARC06SOG()
    {
        return this._ROWCARC06SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> iterateROWCARC06SOG() 

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
    public void removeAllROWCARC06SOG()
    {
        this._ROWCARC06SOGList.clear();
    } //-- void removeAllROWCARC06SOG() 

    /**
     * Method removeROWCARC06SOG
     * 
     * 
     * 
     * @param vROWCARC06SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCARC06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG vROWCARC06SOG)
    {
        boolean removed = _ROWCARC06SOGList.remove(vROWCARC06SOG);
        return removed;
    } //-- boolean removeROWCARC06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) 

    /**
     * Method removeROWCARC06SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG removeROWCARC06SOGAt(int index)
    {
        Object obj = this._ROWCARC06SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG removeROWCARC06SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC06SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCARC06SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG vROWCARC06SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC06SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCARC06SOG: Index value '" + index + "' not in range [0.." + (this._ROWCARC06SOGList.size() - 1) + "]");
        }
        
        this._ROWCARC06SOGList.set(index, vROWCARC06SOG);
    } //-- void setROWCARC06SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) 

    /**
     * 
     * 
     * @param vROWCARC06SOGArray
     */
    public void setROWCARC06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG[] vROWCARC06SOGArray)
    {
        //-- copy array
        _ROWCARC06SOGList.clear();
        
        for (int i = 0; i < vROWCARC06SOGArray.length; i++) {
                this._ROWCARC06SOGList.add(vROWCARC06SOGArray[i]);
        }
    } //-- void setROWCARC06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG) 

    /**
     * Sets the value of '_ROWCARC06SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCARC06SOGList the Vector to copy.
     */
    public void setROWCARC06SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> vROWCARC06SOGList)
    {
        // copy vector
        this._ROWCARC06SOGList.clear();
        
        this._ROWCARC06SOGList.addAll(vROWCARC06SOGList);
    } //-- void setROWCARC06SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCARC06SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCARC06SOGVector the Vector to set.
     */
    public void setROWCARC06SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG> ROWCARC06SOGVector)
    {
        this._ROWCARC06SOGList = ROWCARC06SOGVector;
    } //-- void setROWCARC06SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY unmarshal(java.io.Reader) 

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
