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
 * Class ROWCCMN42SOG00_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN42SOG00_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN42SOG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> _ROWCCMN42SOG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN42SOG00_ARRAY() 
     {
        super();
        this._ROWCCMN42SOG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN42SOG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN42SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 vROWCCMN42SOG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN42SOG00List.size() >= 65) {
            throw new IndexOutOfBoundsException("addROWCCMN42SOG00 has a maximum of 65");
        }
        
        this._ROWCCMN42SOG00List.add(vROWCCMN42SOG00);
    } //-- void addROWCCMN42SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN42SOG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN42SOG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 vROWCCMN42SOG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN42SOG00List.size() >= 65) {
            throw new IndexOutOfBoundsException("addROWCCMN42SOG00 has a maximum of 65");
        }
        
        this._ROWCCMN42SOG00List.add(index, vROWCCMN42SOG00);
    } //-- void addROWCCMN42SOG00(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN42SOG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> enumerateROWCCMN42SOG00()
    {
        return java.util.Collections.enumeration(this._ROWCCMN42SOG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> enumerateROWCCMN42SOG00() 

    /**
     * Method getROWCCMN42SOG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 getROWCCMN42SOG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN42SOG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN42SOG00: Index value '" + index + "' not in range [0.." + (this._ROWCCMN42SOG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) _ROWCCMN42SOG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 getROWCCMN42SOG00(int) 

    /**
     * Method getROWCCMN42SOG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00[] getROWCCMN42SOG00()
    {
        int size = this._ROWCCMN42SOG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) _ROWCCMN42SOG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00[] getROWCCMN42SOG00() 

    /**
     * Method getROWCCMN42SOG00AsReference
     * 
     * Returns a reference to '_ROWCCMN42SOG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> getROWCCMN42SOG00AsReference()
    {
        return this._ROWCCMN42SOG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> getROWCCMN42SOG00AsReference() 

    /**
     * Method getROWCCMN42SOG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN42SOG00Count()
    {
        return this._ROWCCMN42SOG00List.size();
    } //-- int getROWCCMN42SOG00Count() 

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
     * Method iterateROWCCMN42SOG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> iterateROWCCMN42SOG00()
    {
        return this._ROWCCMN42SOG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> iterateROWCCMN42SOG00() 

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
    public void removeAllROWCCMN42SOG00()
    {
        this._ROWCCMN42SOG00List.clear();
    } //-- void removeAllROWCCMN42SOG00() 

    /**
     * Method removeROWCCMN42SOG00
     * 
     * 
     * 
     * @param vROWCCMN42SOG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN42SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 vROWCCMN42SOG00)
    {
        boolean removed = _ROWCCMN42SOG00List.remove(vROWCCMN42SOG00);
        return removed;
    } //-- boolean removeROWCCMN42SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) 

    /**
     * Method removeROWCCMN42SOG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 removeROWCCMN42SOG00At(int index)
    {
        Object obj = this._ROWCCMN42SOG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 removeROWCCMN42SOG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN42SOG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN42SOG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00 vROWCCMN42SOG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN42SOG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN42SOG00: Index value '" + index + "' not in range [0.." + (this._ROWCCMN42SOG00List.size() - 1) + "]");
        }
        
        this._ROWCCMN42SOG00List.set(index, vROWCCMN42SOG00);
    } //-- void setROWCCMN42SOG00(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) 

    /**
     * 
     * 
     * @param vROWCCMN42SOG00Array
     */
    public void setROWCCMN42SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00[] vROWCCMN42SOG00Array)
    {
        //-- copy array
        _ROWCCMN42SOG00List.clear();
        
        for (int i = 0; i < vROWCCMN42SOG00Array.length; i++) {
                this._ROWCCMN42SOG00List.add(vROWCCMN42SOG00Array[i]);
        }
    } //-- void setROWCCMN42SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00) 

    /**
     * Sets the value of '_ROWCCMN42SOG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN42SOG00List the Vector to copy.
     */
    public void setROWCCMN42SOG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> vROWCCMN42SOG00List)
    {
        // copy vector
        this._ROWCCMN42SOG00List.clear();
        
        this._ROWCCMN42SOG00List.addAll(vROWCCMN42SOG00List);
    } //-- void setROWCCMN42SOG00(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN42SOG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN42SOG00Vector the Vector to set.
     */
    public void setROWCCMN42SOG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00> ROWCCMN42SOG00Vector)
    {
        this._ROWCCMN42SOG00List = ROWCCMN42SOG00Vector;
    } //-- void setROWCCMN42SOG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY unmarshal(java.io.Reader) 

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
