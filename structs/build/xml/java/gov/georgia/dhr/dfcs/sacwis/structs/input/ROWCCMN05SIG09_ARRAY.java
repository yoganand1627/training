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
 * Class ROWCCMN05SIG09_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN05SIG09_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN05SIG09List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> _ROWCCMN05SIG09List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN05SIG09_ARRAY() 
     {
        super();
        this._ROWCCMN05SIG09List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN05SIG09
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN05SIG09(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 vROWCCMN05SIG09)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN05SIG09List.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCCMN05SIG09 has a maximum of 10");
        }
        
        this._ROWCCMN05SIG09List.add(vROWCCMN05SIG09);
    } //-- void addROWCCMN05SIG09(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN05SIG09
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN05SIG09(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 vROWCCMN05SIG09)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN05SIG09List.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCCMN05SIG09 has a maximum of 10");
        }
        
        this._ROWCCMN05SIG09List.add(index, vROWCCMN05SIG09);
    } //-- void addROWCCMN05SIG09(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN05SIG09
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> enumerateROWCCMN05SIG09()
    {
        return java.util.Collections.enumeration(this._ROWCCMN05SIG09List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> enumerateROWCCMN05SIG09() 

    /**
     * Method getROWCCMN05SIG09
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 getROWCCMN05SIG09(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN05SIG09List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN05SIG09: Index value '" + index + "' not in range [0.." + (this._ROWCCMN05SIG09List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) _ROWCCMN05SIG09List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 getROWCCMN05SIG09(int) 

    /**
     * Method getROWCCMN05SIG09
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09[] getROWCCMN05SIG09()
    {
        int size = this._ROWCCMN05SIG09List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) _ROWCCMN05SIG09List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09[] getROWCCMN05SIG09() 

    /**
     * Method getROWCCMN05SIG09AsReference
     * 
     * Returns a reference to '_ROWCCMN05SIG09List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> getROWCCMN05SIG09AsReference()
    {
        return this._ROWCCMN05SIG09List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> getROWCCMN05SIG09AsReference() 

    /**
     * Method getROWCCMN05SIG09Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN05SIG09Count()
    {
        return this._ROWCCMN05SIG09List.size();
    } //-- int getROWCCMN05SIG09Count() 

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
     * Method iterateROWCCMN05SIG09
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> iterateROWCCMN05SIG09()
    {
        return this._ROWCCMN05SIG09List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> iterateROWCCMN05SIG09() 

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
    public void removeAllROWCCMN05SIG09()
    {
        this._ROWCCMN05SIG09List.clear();
    } //-- void removeAllROWCCMN05SIG09() 

    /**
     * Method removeROWCCMN05SIG09
     * 
     * 
     * 
     * @param vROWCCMN05SIG09
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN05SIG09(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 vROWCCMN05SIG09)
    {
        boolean removed = _ROWCCMN05SIG09List.remove(vROWCCMN05SIG09);
        return removed;
    } //-- boolean removeROWCCMN05SIG09(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) 

    /**
     * Method removeROWCCMN05SIG09At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 removeROWCCMN05SIG09At(int index)
    {
        Object obj = this._ROWCCMN05SIG09List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 removeROWCCMN05SIG09At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN05SIG09
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN05SIG09(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09 vROWCCMN05SIG09)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN05SIG09List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN05SIG09: Index value '" + index + "' not in range [0.." + (this._ROWCCMN05SIG09List.size() - 1) + "]");
        }
        
        this._ROWCCMN05SIG09List.set(index, vROWCCMN05SIG09);
    } //-- void setROWCCMN05SIG09(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) 

    /**
     * 
     * 
     * @param vROWCCMN05SIG09Array
     */
    public void setROWCCMN05SIG09(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09[] vROWCCMN05SIG09Array)
    {
        //-- copy array
        _ROWCCMN05SIG09List.clear();
        
        for (int i = 0; i < vROWCCMN05SIG09Array.length; i++) {
                this._ROWCCMN05SIG09List.add(vROWCCMN05SIG09Array[i]);
        }
    } //-- void setROWCCMN05SIG09(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09) 

    /**
     * Sets the value of '_ROWCCMN05SIG09List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN05SIG09List the Vector to copy.
     */
    public void setROWCCMN05SIG09(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> vROWCCMN05SIG09List)
    {
        // copy vector
        this._ROWCCMN05SIG09List.clear();
        
        this._ROWCCMN05SIG09List.addAll(vROWCCMN05SIG09List);
    } //-- void setROWCCMN05SIG09(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN05SIG09List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN05SIG09Vector the Vector to set.
     */
    public void setROWCCMN05SIG09AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09> ROWCCMN05SIG09Vector)
    {
        this._ROWCCMN05SIG09List = ROWCCMN05SIG09Vector;
    } //-- void setROWCCMN05SIG09AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY unmarshal(java.io.Reader) 

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
