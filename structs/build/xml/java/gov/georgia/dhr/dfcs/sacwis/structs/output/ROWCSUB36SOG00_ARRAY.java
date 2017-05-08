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
 * Class ROWCSUB36SOG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB36SOG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB36SOG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> _ROWCSUB36SOG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB36SOG00_ARRAY() 
     {
        super();
        this._ROWCSUB36SOG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSUB36SOG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSUB36SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 vROWCSUB36SOG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSUB36SOG00List.size() >= 54) {
            throw new IndexOutOfBoundsException("addROWCSUB36SOG00 has a maximum of 54");
        }
        
        this._ROWCSUB36SOG00List.add(vROWCSUB36SOG00);
    } //-- void addROWCSUB36SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSUB36SOG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSUB36SOG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 vROWCSUB36SOG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSUB36SOG00List.size() >= 54) {
            throw new IndexOutOfBoundsException("addROWCSUB36SOG00 has a maximum of 54");
        }
        
        this._ROWCSUB36SOG00List.add(index, vROWCSUB36SOG00);
    } //-- void addROWCSUB36SOG00(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSUB36SOG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> enumerateROWCSUB36SOG00()
    {
        return java.util.Collections.enumeration(this._ROWCSUB36SOG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> enumerateROWCSUB36SOG00() 

    /**
     * Method getROWCSUB36SOG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 getROWCSUB36SOG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSUB36SOG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCSUB36SOG00: Index value '" + index + "' not in range [0.." + (this._ROWCSUB36SOG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) _ROWCSUB36SOG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 getROWCSUB36SOG00(int) 

    /**
     * Method getROWCSUB36SOG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00[] getROWCSUB36SOG00()
    {
        int size = this._ROWCSUB36SOG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) _ROWCSUB36SOG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00[] getROWCSUB36SOG00() 

    /**
     * Method getROWCSUB36SOG00AsReference
     * 
     * Returns a reference to '_ROWCSUB36SOG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> getROWCSUB36SOG00AsReference()
    {
        return this._ROWCSUB36SOG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> getROWCSUB36SOG00AsReference() 

    /**
     * Method getROWCSUB36SOG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSUB36SOG00Count()
    {
        return this._ROWCSUB36SOG00List.size();
    } //-- int getROWCSUB36SOG00Count() 

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
     * Method iterateROWCSUB36SOG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> iterateROWCSUB36SOG00()
    {
        return this._ROWCSUB36SOG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> iterateROWCSUB36SOG00() 

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
    public void removeAllROWCSUB36SOG00()
    {
        this._ROWCSUB36SOG00List.clear();
    } //-- void removeAllROWCSUB36SOG00() 

    /**
     * Method removeROWCSUB36SOG00
     * 
     * 
     * 
     * @param vROWCSUB36SOG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSUB36SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 vROWCSUB36SOG00)
    {
        boolean removed = _ROWCSUB36SOG00List.remove(vROWCSUB36SOG00);
        return removed;
    } //-- boolean removeROWCSUB36SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) 

    /**
     * Method removeROWCSUB36SOG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 removeROWCSUB36SOG00At(int index)
    {
        Object obj = this._ROWCSUB36SOG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 removeROWCSUB36SOG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSUB36SOG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSUB36SOG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00 vROWCSUB36SOG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSUB36SOG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCSUB36SOG00: Index value '" + index + "' not in range [0.." + (this._ROWCSUB36SOG00List.size() - 1) + "]");
        }
        
        this._ROWCSUB36SOG00List.set(index, vROWCSUB36SOG00);
    } //-- void setROWCSUB36SOG00(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) 

    /**
     * 
     * 
     * @param vROWCSUB36SOG00Array
     */
    public void setROWCSUB36SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00[] vROWCSUB36SOG00Array)
    {
        //-- copy array
        _ROWCSUB36SOG00List.clear();
        
        for (int i = 0; i < vROWCSUB36SOG00Array.length; i++) {
                this._ROWCSUB36SOG00List.add(vROWCSUB36SOG00Array[i]);
        }
    } //-- void setROWCSUB36SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00) 

    /**
     * Sets the value of '_ROWCSUB36SOG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSUB36SOG00List the Vector to copy.
     */
    public void setROWCSUB36SOG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> vROWCSUB36SOG00List)
    {
        // copy vector
        this._ROWCSUB36SOG00List.clear();
        
        this._ROWCSUB36SOG00List.addAll(vROWCSUB36SOG00List);
    } //-- void setROWCSUB36SOG00(java.util.List) 

    /**
     * Sets the value of '_ROWCSUB36SOG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSUB36SOG00Vector the Vector to set.
     */
    public void setROWCSUB36SOG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00> ROWCSUB36SOG00Vector)
    {
        this._ROWCSUB36SOG00List = ROWCSUB36SOG00Vector;
    } //-- void setROWCSUB36SOG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY unmarshal(java.io.Reader) 

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
