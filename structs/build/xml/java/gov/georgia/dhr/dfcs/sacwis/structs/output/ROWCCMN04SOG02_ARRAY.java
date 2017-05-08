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
 * Class ROWCCMN04SOG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN04SOG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN04SOG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> _ROWCCMN04SOG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN04SOG02_ARRAY() 
     {
        super();
        this._ROWCCMN04SOG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN04SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 vROWCCMN04SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN04SOG02List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN04SOG02 has a maximum of 50");
        }
        
        this._ROWCCMN04SOG02List.add(vROWCCMN04SOG02);
    } //-- void addROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN04SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN04SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 vROWCCMN04SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN04SOG02List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN04SOG02 has a maximum of 50");
        }
        
        this._ROWCCMN04SOG02List.add(index, vROWCCMN04SOG02);
    } //-- void addROWCCMN04SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN04SOG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> enumerateROWCCMN04SOG02()
    {
        return java.util.Collections.enumeration(this._ROWCCMN04SOG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> enumerateROWCCMN04SOG02() 

    /**
     * Method getROWCCMN04SOG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 getROWCCMN04SOG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN04SOG02List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN04SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCCMN04SOG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) _ROWCCMN04SOG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 getROWCCMN04SOG02(int) 

    /**
     * Method getROWCCMN04SOG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02[] getROWCCMN04SOG02()
    {
        int size = this._ROWCCMN04SOG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) _ROWCCMN04SOG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02[] getROWCCMN04SOG02() 

    /**
     * Method getROWCCMN04SOG02AsReference
     * 
     * Returns a reference to '_ROWCCMN04SOG02List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> getROWCCMN04SOG02AsReference()
    {
        return this._ROWCCMN04SOG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> getROWCCMN04SOG02AsReference() 

    /**
     * Method getROWCCMN04SOG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN04SOG02Count()
    {
        return this._ROWCCMN04SOG02List.size();
    } //-- int getROWCCMN04SOG02Count() 

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
     * Method iterateROWCCMN04SOG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> iterateROWCCMN04SOG02()
    {
        return this._ROWCCMN04SOG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> iterateROWCCMN04SOG02() 

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
    public void removeAllROWCCMN04SOG02()
    {
        this._ROWCCMN04SOG02List.clear();
    } //-- void removeAllROWCCMN04SOG02() 

    /**
     * Method removeROWCCMN04SOG02
     * 
     * 
     * 
     * @param vROWCCMN04SOG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 vROWCCMN04SOG02)
    {
        boolean removed = _ROWCCMN04SOG02List.remove(vROWCCMN04SOG02);
        return removed;
    } //-- boolean removeROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) 

    /**
     * Method removeROWCCMN04SOG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 removeROWCCMN04SOG02At(int index)
    {
        Object obj = this._ROWCCMN04SOG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 removeROWCCMN04SOG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN04SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN04SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 vROWCCMN04SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN04SOG02List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN04SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCCMN04SOG02List.size() - 1) + "]");
        }
        
        this._ROWCCMN04SOG02List.set(index, vROWCCMN04SOG02);
    } //-- void setROWCCMN04SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) 

    /**
     * 
     * 
     * @param vROWCCMN04SOG02Array
     */
    public void setROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02[] vROWCCMN04SOG02Array)
    {
        //-- copy array
        _ROWCCMN04SOG02List.clear();
        
        for (int i = 0; i < vROWCCMN04SOG02Array.length; i++) {
                this._ROWCCMN04SOG02List.add(vROWCCMN04SOG02Array[i]);
        }
    } //-- void setROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) 

    /**
     * Sets the value of '_ROWCCMN04SOG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN04SOG02List the Vector to copy.
     */
    public void setROWCCMN04SOG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> vROWCCMN04SOG02List)
    {
        // copy vector
        this._ROWCCMN04SOG02List.clear();
        
        this._ROWCCMN04SOG02List.addAll(vROWCCMN04SOG02List);
    } //-- void setROWCCMN04SOG02(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN04SOG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN04SOG02Vector the Vector to set.
     */
    public void setROWCCMN04SOG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02> ROWCCMN04SOG02Vector)
    {
        this._ROWCCMN04SOG02List = ROWCCMN04SOG02Vector;
    } //-- void setROWCCMN04SOG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY unmarshal(java.io.Reader) 

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
