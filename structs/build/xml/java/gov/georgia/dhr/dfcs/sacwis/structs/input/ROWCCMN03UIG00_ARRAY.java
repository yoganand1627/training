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
 * Class ROWCCMN03UIG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN03UIG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN03UIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> _ROWCCMN03UIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN03UIG00_ARRAY() 
     {
        super();
        this._ROWCCMN03UIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN03UIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN03UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 vROWCCMN03UIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN03UIG00List.size() >= 125) {
            throw new IndexOutOfBoundsException("addROWCCMN03UIG00 has a maximum of 125");
        }
        
        this._ROWCCMN03UIG00List.add(vROWCCMN03UIG00);
    } //-- void addROWCCMN03UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN03UIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN03UIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 vROWCCMN03UIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN03UIG00List.size() >= 125) {
            throw new IndexOutOfBoundsException("addROWCCMN03UIG00 has a maximum of 125");
        }
        
        this._ROWCCMN03UIG00List.add(index, vROWCCMN03UIG00);
    } //-- void addROWCCMN03UIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN03UIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> enumerateROWCCMN03UIG00()
    {
        return java.util.Collections.enumeration(this._ROWCCMN03UIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> enumerateROWCCMN03UIG00() 

    /**
     * Method getROWCCMN03UIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 getROWCCMN03UIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN03UIG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN03UIG00: Index value '" + index + "' not in range [0.." + (this._ROWCCMN03UIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) _ROWCCMN03UIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 getROWCCMN03UIG00(int) 

    /**
     * Method getROWCCMN03UIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00[] getROWCCMN03UIG00()
    {
        int size = this._ROWCCMN03UIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) _ROWCCMN03UIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00[] getROWCCMN03UIG00() 

    /**
     * Method getROWCCMN03UIG00AsReference
     * 
     * Returns a reference to '_ROWCCMN03UIG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> getROWCCMN03UIG00AsReference()
    {
        return this._ROWCCMN03UIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> getROWCCMN03UIG00AsReference() 

    /**
     * Method getROWCCMN03UIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN03UIG00Count()
    {
        return this._ROWCCMN03UIG00List.size();
    } //-- int getROWCCMN03UIG00Count() 

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
     * Method iterateROWCCMN03UIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> iterateROWCCMN03UIG00()
    {
        return this._ROWCCMN03UIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> iterateROWCCMN03UIG00() 

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
    public void removeAllROWCCMN03UIG00()
    {
        this._ROWCCMN03UIG00List.clear();
    } //-- void removeAllROWCCMN03UIG00() 

    /**
     * Method removeROWCCMN03UIG00
     * 
     * 
     * 
     * @param vROWCCMN03UIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN03UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 vROWCCMN03UIG00)
    {
        boolean removed = _ROWCCMN03UIG00List.remove(vROWCCMN03UIG00);
        return removed;
    } //-- boolean removeROWCCMN03UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) 

    /**
     * Method removeROWCCMN03UIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 removeROWCCMN03UIG00At(int index)
    {
        Object obj = this._ROWCCMN03UIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 removeROWCCMN03UIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN03UIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN03UIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00 vROWCCMN03UIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN03UIG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN03UIG00: Index value '" + index + "' not in range [0.." + (this._ROWCCMN03UIG00List.size() - 1) + "]");
        }
        
        this._ROWCCMN03UIG00List.set(index, vROWCCMN03UIG00);
    } //-- void setROWCCMN03UIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) 

    /**
     * 
     * 
     * @param vROWCCMN03UIG00Array
     */
    public void setROWCCMN03UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00[] vROWCCMN03UIG00Array)
    {
        //-- copy array
        _ROWCCMN03UIG00List.clear();
        
        for (int i = 0; i < vROWCCMN03UIG00Array.length; i++) {
                this._ROWCCMN03UIG00List.add(vROWCCMN03UIG00Array[i]);
        }
    } //-- void setROWCCMN03UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00) 

    /**
     * Sets the value of '_ROWCCMN03UIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN03UIG00List the Vector to copy.
     */
    public void setROWCCMN03UIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> vROWCCMN03UIG00List)
    {
        // copy vector
        this._ROWCCMN03UIG00List.clear();
        
        this._ROWCCMN03UIG00List.addAll(vROWCCMN03UIG00List);
    } //-- void setROWCCMN03UIG00(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN03UIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN03UIG00Vector the Vector to set.
     */
    public void setROWCCMN03UIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00> ROWCCMN03UIG00Vector)
    {
        this._ROWCCMN03UIG00List = ROWCCMN03UIG00Vector;
    } //-- void setROWCCMN03UIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY unmarshal(java.io.Reader) 

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
