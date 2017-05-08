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
 * Class ROWCRES07SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES07SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES07SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> _ROWCRES07SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES07SOG_ARRAY() 
     {
        super();
        this._ROWCRES07SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES07SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES07SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG vROWCRES07SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES07SOGList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCRES07SOG has a maximum of 50");
        }
        
        this._ROWCRES07SOGList.add(vROWCRES07SOG);
    } //-- void addROWCRES07SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES07SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES07SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG vROWCRES07SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES07SOGList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCRES07SOG has a maximum of 50");
        }
        
        this._ROWCRES07SOGList.add(index, vROWCRES07SOG);
    } //-- void addROWCRES07SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES07SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> enumerateROWCRES07SOG()
    {
        return java.util.Collections.enumeration(this._ROWCRES07SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> enumerateROWCRES07SOG() 

    /**
     * Method getROWCRES07SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG getROWCRES07SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES07SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCRES07SOG: Index value '" + index + "' not in range [0.." + (this._ROWCRES07SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) _ROWCRES07SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG getROWCRES07SOG(int) 

    /**
     * Method getROWCRES07SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG[] getROWCRES07SOG()
    {
        int size = this._ROWCRES07SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) _ROWCRES07SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG[] getROWCRES07SOG() 

    /**
     * Method getROWCRES07SOGAsReference
     * 
     * Returns a reference to '_ROWCRES07SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> getROWCRES07SOGAsReference()
    {
        return this._ROWCRES07SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> getROWCRES07SOGAsReference() 

    /**
     * Method getROWCRES07SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES07SOGCount()
    {
        return this._ROWCRES07SOGList.size();
    } //-- int getROWCRES07SOGCount() 

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
     * Method iterateROWCRES07SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> iterateROWCRES07SOG()
    {
        return this._ROWCRES07SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> iterateROWCRES07SOG() 

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
    public void removeAllROWCRES07SOG()
    {
        this._ROWCRES07SOGList.clear();
    } //-- void removeAllROWCRES07SOG() 

    /**
     * Method removeROWCRES07SOG
     * 
     * 
     * 
     * @param vROWCRES07SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES07SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG vROWCRES07SOG)
    {
        boolean removed = _ROWCRES07SOGList.remove(vROWCRES07SOG);
        return removed;
    } //-- boolean removeROWCRES07SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) 

    /**
     * Method removeROWCRES07SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG removeROWCRES07SOGAt(int index)
    {
        Object obj = this._ROWCRES07SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG removeROWCRES07SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES07SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES07SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG vROWCRES07SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES07SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCRES07SOG: Index value '" + index + "' not in range [0.." + (this._ROWCRES07SOGList.size() - 1) + "]");
        }
        
        this._ROWCRES07SOGList.set(index, vROWCRES07SOG);
    } //-- void setROWCRES07SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) 

    /**
     * 
     * 
     * @param vROWCRES07SOGArray
     */
    public void setROWCRES07SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG[] vROWCRES07SOGArray)
    {
        //-- copy array
        _ROWCRES07SOGList.clear();
        
        for (int i = 0; i < vROWCRES07SOGArray.length; i++) {
                this._ROWCRES07SOGList.add(vROWCRES07SOGArray[i]);
        }
    } //-- void setROWCRES07SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG) 

    /**
     * Sets the value of '_ROWCRES07SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES07SOGList the Vector to copy.
     */
    public void setROWCRES07SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> vROWCRES07SOGList)
    {
        // copy vector
        this._ROWCRES07SOGList.clear();
        
        this._ROWCRES07SOGList.addAll(vROWCRES07SOGList);
    } //-- void setROWCRES07SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCRES07SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES07SOGVector the Vector to set.
     */
    public void setROWCRES07SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG> ROWCRES07SOGVector)
    {
        this._ROWCRES07SOGList = ROWCRES07SOGVector;
    } //-- void setROWCRES07SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY unmarshal(java.io.Reader) 

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
