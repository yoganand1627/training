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
 * Class CCMN04SOG08_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN04SOG08_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CCMN04SOG08List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> _CCMN04SOG08List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN04SOG08_ARRAY() 
     {
        super();
        this._CCMN04SOG08List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCCMN04SOG08
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCCMN04SOG08(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 vCCMN04SOG08)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CCMN04SOG08List.size() >= 10) {
            throw new IndexOutOfBoundsException("addCCMN04SOG08 has a maximum of 10");
        }
        
        this._CCMN04SOG08List.add(vCCMN04SOG08);
    } //-- void addCCMN04SOG08(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) 

    /**
     * 
     * 
     * @param index
     * @param vCCMN04SOG08
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCCMN04SOG08(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 vCCMN04SOG08)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CCMN04SOG08List.size() >= 10) {
            throw new IndexOutOfBoundsException("addCCMN04SOG08 has a maximum of 10");
        }
        
        this._CCMN04SOG08List.add(index, vCCMN04SOG08);
    } //-- void addCCMN04SOG08(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCCMN04SOG08
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> enumerateCCMN04SOG08()
    {
        return java.util.Collections.enumeration(this._CCMN04SOG08List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> enumerateCCMN04SOG08() 

    /**
     * Method getCCMN04SOG08
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 getCCMN04SOG08(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CCMN04SOG08List.size()) {
            throw new IndexOutOfBoundsException("getCCMN04SOG08: Index value '" + index + "' not in range [0.." + (this._CCMN04SOG08List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) _CCMN04SOG08List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 getCCMN04SOG08(int) 

    /**
     * Method getCCMN04SOG08
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08[] getCCMN04SOG08()
    {
        int size = this._CCMN04SOG08List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) _CCMN04SOG08List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08[] getCCMN04SOG08() 

    /**
     * Method getCCMN04SOG08AsReference
     * 
     * Returns a reference to '_CCMN04SOG08List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> getCCMN04SOG08AsReference()
    {
        return this._CCMN04SOG08List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> getCCMN04SOG08AsReference() 

    /**
     * Method getCCMN04SOG08Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCCMN04SOG08Count()
    {
        return this._CCMN04SOG08List.size();
    } //-- int getCCMN04SOG08Count() 

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
     * Method iterateCCMN04SOG08
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> iterateCCMN04SOG08()
    {
        return this._CCMN04SOG08List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> iterateCCMN04SOG08() 

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
    public void removeAllCCMN04SOG08()
    {
        this._CCMN04SOG08List.clear();
    } //-- void removeAllCCMN04SOG08() 

    /**
     * Method removeCCMN04SOG08
     * 
     * 
     * 
     * @param vCCMN04SOG08
     * @return true if the object was removed from the collection.
     */
    public boolean removeCCMN04SOG08(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 vCCMN04SOG08)
    {
        boolean removed = _CCMN04SOG08List.remove(vCCMN04SOG08);
        return removed;
    } //-- boolean removeCCMN04SOG08(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) 

    /**
     * Method removeCCMN04SOG08At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 removeCCMN04SOG08At(int index)
    {
        Object obj = this._CCMN04SOG08List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 removeCCMN04SOG08At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCCMN04SOG08
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCCMN04SOG08(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08 vCCMN04SOG08)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CCMN04SOG08List.size()) {
            throw new IndexOutOfBoundsException("setCCMN04SOG08: Index value '" + index + "' not in range [0.." + (this._CCMN04SOG08List.size() - 1) + "]");
        }
        
        this._CCMN04SOG08List.set(index, vCCMN04SOG08);
    } //-- void setCCMN04SOG08(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) 

    /**
     * 
     * 
     * @param vCCMN04SOG08Array
     */
    public void setCCMN04SOG08(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08[] vCCMN04SOG08Array)
    {
        //-- copy array
        _CCMN04SOG08List.clear();
        
        for (int i = 0; i < vCCMN04SOG08Array.length; i++) {
                this._CCMN04SOG08List.add(vCCMN04SOG08Array[i]);
        }
    } //-- void setCCMN04SOG08(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08) 

    /**
     * Sets the value of '_CCMN04SOG08List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCCMN04SOG08List the Vector to copy.
     */
    public void setCCMN04SOG08(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> vCCMN04SOG08List)
    {
        // copy vector
        this._CCMN04SOG08List.clear();
        
        this._CCMN04SOG08List.addAll(vCCMN04SOG08List);
    } //-- void setCCMN04SOG08(java.util.List) 

    /**
     * Sets the value of '_CCMN04SOG08List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CCMN04SOG08Vector the Vector to set.
     */
    public void setCCMN04SOG08AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08> CCMN04SOG08Vector)
    {
        this._CCMN04SOG08List = CCMN04SOG08Vector;
    } //-- void setCCMN04SOG08AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY unmarshal(java.io.Reader) 

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
