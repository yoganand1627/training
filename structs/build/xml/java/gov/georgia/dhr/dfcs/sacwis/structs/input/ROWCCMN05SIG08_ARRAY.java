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
 * Class ROWCCMN05SIG08_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN05SIG08_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN05SIG08List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> _ROWCCMN05SIG08List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN05SIG08_ARRAY() 
     {
        super();
        this._ROWCCMN05SIG08List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN05SIG08
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN05SIG08(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 vROWCCMN05SIG08)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN05SIG08List.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCCMN05SIG08 has a maximum of 10");
        }
        
        this._ROWCCMN05SIG08List.add(vROWCCMN05SIG08);
    } //-- void addROWCCMN05SIG08(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN05SIG08
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN05SIG08(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 vROWCCMN05SIG08)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN05SIG08List.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCCMN05SIG08 has a maximum of 10");
        }
        
        this._ROWCCMN05SIG08List.add(index, vROWCCMN05SIG08);
    } //-- void addROWCCMN05SIG08(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN05SIG08
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> enumerateROWCCMN05SIG08()
    {
        return java.util.Collections.enumeration(this._ROWCCMN05SIG08List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> enumerateROWCCMN05SIG08() 

    /**
     * Method getROWCCMN05SIG08
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 getROWCCMN05SIG08(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN05SIG08List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN05SIG08: Index value '" + index + "' not in range [0.." + (this._ROWCCMN05SIG08List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) _ROWCCMN05SIG08List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 getROWCCMN05SIG08(int) 

    /**
     * Method getROWCCMN05SIG08
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08[] getROWCCMN05SIG08()
    {
        int size = this._ROWCCMN05SIG08List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) _ROWCCMN05SIG08List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08[] getROWCCMN05SIG08() 

    /**
     * Method getROWCCMN05SIG08AsReference
     * 
     * Returns a reference to '_ROWCCMN05SIG08List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> getROWCCMN05SIG08AsReference()
    {
        return this._ROWCCMN05SIG08List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> getROWCCMN05SIG08AsReference() 

    /**
     * Method getROWCCMN05SIG08Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN05SIG08Count()
    {
        return this._ROWCCMN05SIG08List.size();
    } //-- int getROWCCMN05SIG08Count() 

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
     * Method iterateROWCCMN05SIG08
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> iterateROWCCMN05SIG08()
    {
        return this._ROWCCMN05SIG08List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> iterateROWCCMN05SIG08() 

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
    public void removeAllROWCCMN05SIG08()
    {
        this._ROWCCMN05SIG08List.clear();
    } //-- void removeAllROWCCMN05SIG08() 

    /**
     * Method removeROWCCMN05SIG08
     * 
     * 
     * 
     * @param vROWCCMN05SIG08
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN05SIG08(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 vROWCCMN05SIG08)
    {
        boolean removed = _ROWCCMN05SIG08List.remove(vROWCCMN05SIG08);
        return removed;
    } //-- boolean removeROWCCMN05SIG08(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) 

    /**
     * Method removeROWCCMN05SIG08At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 removeROWCCMN05SIG08At(int index)
    {
        Object obj = this._ROWCCMN05SIG08List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 removeROWCCMN05SIG08At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN05SIG08
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN05SIG08(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08 vROWCCMN05SIG08)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN05SIG08List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN05SIG08: Index value '" + index + "' not in range [0.." + (this._ROWCCMN05SIG08List.size() - 1) + "]");
        }
        
        this._ROWCCMN05SIG08List.set(index, vROWCCMN05SIG08);
    } //-- void setROWCCMN05SIG08(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) 

    /**
     * 
     * 
     * @param vROWCCMN05SIG08Array
     */
    public void setROWCCMN05SIG08(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08[] vROWCCMN05SIG08Array)
    {
        //-- copy array
        _ROWCCMN05SIG08List.clear();
        
        for (int i = 0; i < vROWCCMN05SIG08Array.length; i++) {
                this._ROWCCMN05SIG08List.add(vROWCCMN05SIG08Array[i]);
        }
    } //-- void setROWCCMN05SIG08(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08) 

    /**
     * Sets the value of '_ROWCCMN05SIG08List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN05SIG08List the Vector to copy.
     */
    public void setROWCCMN05SIG08(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> vROWCCMN05SIG08List)
    {
        // copy vector
        this._ROWCCMN05SIG08List.clear();
        
        this._ROWCCMN05SIG08List.addAll(vROWCCMN05SIG08List);
    } //-- void setROWCCMN05SIG08(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN05SIG08List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN05SIG08Vector the Vector to set.
     */
    public void setROWCCMN05SIG08AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08> ROWCCMN05SIG08Vector)
    {
        this._ROWCCMN05SIG08List = ROWCCMN05SIG08Vector;
    } //-- void setROWCCMN05SIG08AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY unmarshal(java.io.Reader) 

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
