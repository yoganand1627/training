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
 * Class CINV04SOG04_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV04SOG04_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV04SOG04List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> _CINV04SOG04List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV04SOG04_ARRAY() 
     {
        super();
        this._CINV04SOG04List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV04SOG04
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 vCINV04SOG04)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SOG04List.size() >= 10) {
            throw new IndexOutOfBoundsException("addCINV04SOG04 has a maximum of 10");
        }
        
        this._CINV04SOG04List.add(vCINV04SOG04);
    } //-- void addCINV04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SOG04
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SOG04(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 vCINV04SOG04)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SOG04List.size() >= 10) {
            throw new IndexOutOfBoundsException("addCINV04SOG04 has a maximum of 10");
        }
        
        this._CINV04SOG04List.add(index, vCINV04SOG04);
    } //-- void addCINV04SOG04(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV04SOG04
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> enumerateCINV04SOG04()
    {
        return java.util.Collections.enumeration(this._CINV04SOG04List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> enumerateCINV04SOG04() 

    /**
     * Method getCINV04SOG04
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 getCINV04SOG04(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SOG04List.size()) {
            throw new IndexOutOfBoundsException("getCINV04SOG04: Index value '" + index + "' not in range [0.." + (this._CINV04SOG04List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) _CINV04SOG04List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 getCINV04SOG04(int) 

    /**
     * Method getCINV04SOG04
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04[] getCINV04SOG04()
    {
        int size = this._CINV04SOG04List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) _CINV04SOG04List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04[] getCINV04SOG04() 

    /**
     * Method getCINV04SOG04AsReference
     * 
     * Returns a reference to '_CINV04SOG04List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> getCINV04SOG04AsReference()
    {
        return this._CINV04SOG04List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> getCINV04SOG04AsReference() 

    /**
     * Method getCINV04SOG04Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV04SOG04Count()
    {
        return this._CINV04SOG04List.size();
    } //-- int getCINV04SOG04Count() 

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
     * Method iterateCINV04SOG04
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> iterateCINV04SOG04()
    {
        return this._CINV04SOG04List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> iterateCINV04SOG04() 

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
    public void removeAllCINV04SOG04()
    {
        this._CINV04SOG04List.clear();
    } //-- void removeAllCINV04SOG04() 

    /**
     * Method removeCINV04SOG04
     * 
     * 
     * 
     * @param vCINV04SOG04
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 vCINV04SOG04)
    {
        boolean removed = _CINV04SOG04List.remove(vCINV04SOG04);
        return removed;
    } //-- boolean removeCINV04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) 

    /**
     * Method removeCINV04SOG04At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 removeCINV04SOG04At(int index)
    {
        Object obj = this._CINV04SOG04List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 removeCINV04SOG04At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SOG04
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV04SOG04(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04 vCINV04SOG04)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SOG04List.size()) {
            throw new IndexOutOfBoundsException("setCINV04SOG04: Index value '" + index + "' not in range [0.." + (this._CINV04SOG04List.size() - 1) + "]");
        }
        
        this._CINV04SOG04List.set(index, vCINV04SOG04);
    } //-- void setCINV04SOG04(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) 

    /**
     * 
     * 
     * @param vCINV04SOG04Array
     */
    public void setCINV04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04[] vCINV04SOG04Array)
    {
        //-- copy array
        _CINV04SOG04List.clear();
        
        for (int i = 0; i < vCINV04SOG04Array.length; i++) {
                this._CINV04SOG04List.add(vCINV04SOG04Array[i]);
        }
    } //-- void setCINV04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04) 

    /**
     * Sets the value of '_CINV04SOG04List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINV04SOG04List the Vector to copy.
     */
    public void setCINV04SOG04(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> vCINV04SOG04List)
    {
        // copy vector
        this._CINV04SOG04List.clear();
        
        this._CINV04SOG04List.addAll(vCINV04SOG04List);
    } //-- void setCINV04SOG04(java.util.List) 

    /**
     * Sets the value of '_CINV04SOG04List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINV04SOG04Vector the Vector to set.
     */
    public void setCINV04SOG04AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04> CINV04SOG04Vector)
    {
        this._CINV04SOG04List = CINV04SOG04Vector;
    } //-- void setCINV04SOG04AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY unmarshal(java.io.Reader) 

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
