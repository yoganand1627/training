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
 * Class CINV04SG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV04SG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV04SG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> _CINV04SG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV04SG02_ARRAY() 
     {
        super();
        this._CINV04SG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV04SG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 vCINV04SG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SG02List.size() >= 1500) {
            throw new IndexOutOfBoundsException("addCINV04SG02 has a maximum of 1500");
        }
        
        this._CINV04SG02List.add(vCINV04SG02);
    } //-- void addCINV04SG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 vCINV04SG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SG02List.size() >= 1500) {
            throw new IndexOutOfBoundsException("addCINV04SG02 has a maximum of 1500");
        }
        
        this._CINV04SG02List.add(index, vCINV04SG02);
    } //-- void addCINV04SG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV04SG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> enumerateCINV04SG02()
    {
        return java.util.Collections.enumeration(this._CINV04SG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> enumerateCINV04SG02() 

    /**
     * Method getCINV04SG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 getCINV04SG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SG02List.size()) {
            throw new IndexOutOfBoundsException("getCINV04SG02: Index value '" + index + "' not in range [0.." + (this._CINV04SG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) _CINV04SG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 getCINV04SG02(int) 

    /**
     * Method getCINV04SG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02[] getCINV04SG02()
    {
        int size = this._CINV04SG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) _CINV04SG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02[] getCINV04SG02() 

    /**
     * Method getCINV04SG02AsReference
     * 
     * Returns a reference to '_CINV04SG02List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> getCINV04SG02AsReference()
    {
        return this._CINV04SG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> getCINV04SG02AsReference() 

    /**
     * Method getCINV04SG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV04SG02Count()
    {
        return this._CINV04SG02List.size();
    } //-- int getCINV04SG02Count() 

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
     * Method iterateCINV04SG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> iterateCINV04SG02()
    {
        return this._CINV04SG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> iterateCINV04SG02() 

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
    public void removeAllCINV04SG02()
    {
        this._CINV04SG02List.clear();
    } //-- void removeAllCINV04SG02() 

    /**
     * Method removeCINV04SG02
     * 
     * 
     * 
     * @param vCINV04SG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV04SG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 vCINV04SG02)
    {
        boolean removed = _CINV04SG02List.remove(vCINV04SG02);
        return removed;
    } //-- boolean removeCINV04SG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) 

    /**
     * Method removeCINV04SG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 removeCINV04SG02At(int index)
    {
        Object obj = this._CINV04SG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 removeCINV04SG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV04SG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02 vCINV04SG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SG02List.size()) {
            throw new IndexOutOfBoundsException("setCINV04SG02: Index value '" + index + "' not in range [0.." + (this._CINV04SG02List.size() - 1) + "]");
        }
        
        this._CINV04SG02List.set(index, vCINV04SG02);
    } //-- void setCINV04SG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) 

    /**
     * 
     * 
     * @param vCINV04SG02Array
     */
    public void setCINV04SG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02[] vCINV04SG02Array)
    {
        //-- copy array
        _CINV04SG02List.clear();
        
        for (int i = 0; i < vCINV04SG02Array.length; i++) {
                this._CINV04SG02List.add(vCINV04SG02Array[i]);
        }
    } //-- void setCINV04SG02(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02) 

    /**
     * Sets the value of '_CINV04SG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINV04SG02List the Vector to copy.
     */
    public void setCINV04SG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> vCINV04SG02List)
    {
        // copy vector
        this._CINV04SG02List.clear();
        
        this._CINV04SG02List.addAll(vCINV04SG02List);
    } //-- void setCINV04SG02(java.util.List) 

    /**
     * Sets the value of '_CINV04SG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINV04SG02Vector the Vector to set.
     */
    public void setCINV04SG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02> CINV04SG02Vector)
    {
        this._CINV04SG02List = CINV04SG02Vector;
    } //-- void setCINV04SG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY unmarshal(java.io.Reader) 

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
