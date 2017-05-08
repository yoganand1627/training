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
 * Class ROWCCMN22SIG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN22SIG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN22SIG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> _ROWCCMN22SIG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN22SIG02_ARRAY() 
     {
        super();
        this._ROWCCMN22SIG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN22SIG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN22SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 vROWCCMN22SIG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN22SIG02List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN22SIG02 has a maximum of 50");
        }
        
        this._ROWCCMN22SIG02List.add(vROWCCMN22SIG02);
    } //-- void addROWCCMN22SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN22SIG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN22SIG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 vROWCCMN22SIG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN22SIG02List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN22SIG02 has a maximum of 50");
        }
        
        this._ROWCCMN22SIG02List.add(index, vROWCCMN22SIG02);
    } //-- void addROWCCMN22SIG02(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN22SIG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> enumerateROWCCMN22SIG02()
    {
        return java.util.Collections.enumeration(this._ROWCCMN22SIG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> enumerateROWCCMN22SIG02() 

    /**
     * Method getROWCCMN22SIG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 getROWCCMN22SIG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN22SIG02List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN22SIG02: Index value '" + index + "' not in range [0.." + (this._ROWCCMN22SIG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) _ROWCCMN22SIG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 getROWCCMN22SIG02(int) 

    /**
     * Method getROWCCMN22SIG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02[] getROWCCMN22SIG02()
    {
        int size = this._ROWCCMN22SIG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) _ROWCCMN22SIG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02[] getROWCCMN22SIG02() 

    /**
     * Method getROWCCMN22SIG02AsReference
     * 
     * Returns a reference to '_ROWCCMN22SIG02List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> getROWCCMN22SIG02AsReference()
    {
        return this._ROWCCMN22SIG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> getROWCCMN22SIG02AsReference() 

    /**
     * Method getROWCCMN22SIG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN22SIG02Count()
    {
        return this._ROWCCMN22SIG02List.size();
    } //-- int getROWCCMN22SIG02Count() 

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
     * Method iterateROWCCMN22SIG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> iterateROWCCMN22SIG02()
    {
        return this._ROWCCMN22SIG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> iterateROWCCMN22SIG02() 

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
    public void removeAllROWCCMN22SIG02()
    {
        this._ROWCCMN22SIG02List.clear();
    } //-- void removeAllROWCCMN22SIG02() 

    /**
     * Method removeROWCCMN22SIG02
     * 
     * 
     * 
     * @param vROWCCMN22SIG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN22SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 vROWCCMN22SIG02)
    {
        boolean removed = _ROWCCMN22SIG02List.remove(vROWCCMN22SIG02);
        return removed;
    } //-- boolean removeROWCCMN22SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) 

    /**
     * Method removeROWCCMN22SIG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 removeROWCCMN22SIG02At(int index)
    {
        Object obj = this._ROWCCMN22SIG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 removeROWCCMN22SIG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN22SIG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN22SIG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 vROWCCMN22SIG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN22SIG02List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN22SIG02: Index value '" + index + "' not in range [0.." + (this._ROWCCMN22SIG02List.size() - 1) + "]");
        }
        
        this._ROWCCMN22SIG02List.set(index, vROWCCMN22SIG02);
    } //-- void setROWCCMN22SIG02(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) 

    /**
     * 
     * 
     * @param vROWCCMN22SIG02Array
     */
    public void setROWCCMN22SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02[] vROWCCMN22SIG02Array)
    {
        //-- copy array
        _ROWCCMN22SIG02List.clear();
        
        for (int i = 0; i < vROWCCMN22SIG02Array.length; i++) {
                this._ROWCCMN22SIG02List.add(vROWCCMN22SIG02Array[i]);
        }
    } //-- void setROWCCMN22SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) 

    /**
     * Sets the value of '_ROWCCMN22SIG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN22SIG02List the Vector to copy.
     */
    public void setROWCCMN22SIG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> vROWCCMN22SIG02List)
    {
        // copy vector
        this._ROWCCMN22SIG02List.clear();
        
        this._ROWCCMN22SIG02List.addAll(vROWCCMN22SIG02List);
    } //-- void setROWCCMN22SIG02(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN22SIG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN22SIG02Vector the Vector to set.
     */
    public void setROWCCMN22SIG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02> ROWCCMN22SIG02Vector)
    {
        this._ROWCCMN22SIG02List = ROWCCMN22SIG02Vector;
    } //-- void setROWCCMN22SIG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY unmarshal(java.io.Reader) 

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
