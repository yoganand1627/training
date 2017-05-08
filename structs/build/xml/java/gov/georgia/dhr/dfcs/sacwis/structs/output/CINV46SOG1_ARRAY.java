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
 * Class CINV46SOG1_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV46SOG1_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV46SOG1List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> _CINV46SOG1List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV46SOG1_ARRAY() 
     {
        super();
        this._CINV46SOG1List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV46SOG1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV46SOG1(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 vCINV46SOG1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV46SOG1List.size() >= 250) {
            throw new IndexOutOfBoundsException("addCINV46SOG1 has a maximum of 250");
        }
        
        this._CINV46SOG1List.add(vCINV46SOG1);
    } //-- void addCINV46SOG1(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) 

    /**
     * 
     * 
     * @param index
     * @param vCINV46SOG1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV46SOG1(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 vCINV46SOG1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV46SOG1List.size() >= 250) {
            throw new IndexOutOfBoundsException("addCINV46SOG1 has a maximum of 250");
        }
        
        this._CINV46SOG1List.add(index, vCINV46SOG1);
    } //-- void addCINV46SOG1(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV46SOG1
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> enumerateCINV46SOG1()
    {
        return java.util.Collections.enumeration(this._CINV46SOG1List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> enumerateCINV46SOG1() 

    /**
     * Method getCINV46SOG1
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 getCINV46SOG1(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV46SOG1List.size()) {
            throw new IndexOutOfBoundsException("getCINV46SOG1: Index value '" + index + "' not in range [0.." + (this._CINV46SOG1List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) _CINV46SOG1List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 getCINV46SOG1(int) 

    /**
     * Method getCINV46SOG1
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1[] getCINV46SOG1()
    {
        int size = this._CINV46SOG1List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) _CINV46SOG1List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1[] getCINV46SOG1() 

    /**
     * Method getCINV46SOG1AsReference
     * 
     * Returns a reference to '_CINV46SOG1List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> getCINV46SOG1AsReference()
    {
        return this._CINV46SOG1List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> getCINV46SOG1AsReference() 

    /**
     * Method getCINV46SOG1Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV46SOG1Count()
    {
        return this._CINV46SOG1List.size();
    } //-- int getCINV46SOG1Count() 

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
     * Method iterateCINV46SOG1
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> iterateCINV46SOG1()
    {
        return this._CINV46SOG1List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> iterateCINV46SOG1() 

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
    public void removeAllCINV46SOG1()
    {
        this._CINV46SOG1List.clear();
    } //-- void removeAllCINV46SOG1() 

    /**
     * Method removeCINV46SOG1
     * 
     * 
     * 
     * @param vCINV46SOG1
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV46SOG1(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 vCINV46SOG1)
    {
        boolean removed = _CINV46SOG1List.remove(vCINV46SOG1);
        return removed;
    } //-- boolean removeCINV46SOG1(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) 

    /**
     * Method removeCINV46SOG1At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 removeCINV46SOG1At(int index)
    {
        Object obj = this._CINV46SOG1List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 removeCINV46SOG1At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV46SOG1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV46SOG1(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1 vCINV46SOG1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV46SOG1List.size()) {
            throw new IndexOutOfBoundsException("setCINV46SOG1: Index value '" + index + "' not in range [0.." + (this._CINV46SOG1List.size() - 1) + "]");
        }
        
        this._CINV46SOG1List.set(index, vCINV46SOG1);
    } //-- void setCINV46SOG1(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) 

    /**
     * 
     * 
     * @param vCINV46SOG1Array
     */
    public void setCINV46SOG1(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1[] vCINV46SOG1Array)
    {
        //-- copy array
        _CINV46SOG1List.clear();
        
        for (int i = 0; i < vCINV46SOG1Array.length; i++) {
                this._CINV46SOG1List.add(vCINV46SOG1Array[i]);
        }
    } //-- void setCINV46SOG1(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1) 

    /**
     * Sets the value of '_CINV46SOG1List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINV46SOG1List the Vector to copy.
     */
    public void setCINV46SOG1(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> vCINV46SOG1List)
    {
        // copy vector
        this._CINV46SOG1List.clear();
        
        this._CINV46SOG1List.addAll(vCINV46SOG1List);
    } //-- void setCINV46SOG1(java.util.List) 

    /**
     * Sets the value of '_CINV46SOG1List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINV46SOG1Vector the Vector to set.
     */
    public void setCINV46SOG1AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1> CINV46SOG1Vector)
    {
        this._CINV46SOG1List = CINV46SOG1Vector;
    } //-- void setCINV46SOG1AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY unmarshal(java.io.Reader) 

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
