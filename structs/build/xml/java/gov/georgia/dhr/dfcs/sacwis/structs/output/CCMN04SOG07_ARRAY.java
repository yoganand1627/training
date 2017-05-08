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
 * Class CCMN04SOG07_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN04SOG07_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CCMN04SOG07List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> _CCMN04SOG07List;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN04SOG07_ARRAY() 
     {
        super();
        this._CCMN04SOG07List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCCMN04SOG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCCMN04SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 vCCMN04SOG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CCMN04SOG07List.size() >= 10) {
            throw new IndexOutOfBoundsException("addCCMN04SOG07 has a maximum of 10");
        }
        
        this._CCMN04SOG07List.add(vCCMN04SOG07);
    } //-- void addCCMN04SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) 

    /**
     * 
     * 
     * @param index
     * @param vCCMN04SOG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCCMN04SOG07(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 vCCMN04SOG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CCMN04SOG07List.size() >= 10) {
            throw new IndexOutOfBoundsException("addCCMN04SOG07 has a maximum of 10");
        }
        
        this._CCMN04SOG07List.add(index, vCCMN04SOG07);
    } //-- void addCCMN04SOG07(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCCMN04SOG07
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> enumerateCCMN04SOG07()
    {
        return java.util.Collections.enumeration(this._CCMN04SOG07List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> enumerateCCMN04SOG07() 

    /**
     * Method getCCMN04SOG07
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 getCCMN04SOG07(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CCMN04SOG07List.size()) {
            throw new IndexOutOfBoundsException("getCCMN04SOG07: Index value '" + index + "' not in range [0.." + (this._CCMN04SOG07List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) _CCMN04SOG07List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 getCCMN04SOG07(int) 

    /**
     * Method getCCMN04SOG07
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07[] getCCMN04SOG07()
    {
        int size = this._CCMN04SOG07List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) _CCMN04SOG07List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07[] getCCMN04SOG07() 

    /**
     * Method getCCMN04SOG07AsReference
     * 
     * Returns a reference to '_CCMN04SOG07List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> getCCMN04SOG07AsReference()
    {
        return this._CCMN04SOG07List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> getCCMN04SOG07AsReference() 

    /**
     * Method getCCMN04SOG07Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCCMN04SOG07Count()
    {
        return this._CCMN04SOG07List.size();
    } //-- int getCCMN04SOG07Count() 

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
     * Method iterateCCMN04SOG07
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> iterateCCMN04SOG07()
    {
        return this._CCMN04SOG07List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> iterateCCMN04SOG07() 

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
    public void removeAllCCMN04SOG07()
    {
        this._CCMN04SOG07List.clear();
    } //-- void removeAllCCMN04SOG07() 

    /**
     * Method removeCCMN04SOG07
     * 
     * 
     * 
     * @param vCCMN04SOG07
     * @return true if the object was removed from the collection.
     */
    public boolean removeCCMN04SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 vCCMN04SOG07)
    {
        boolean removed = _CCMN04SOG07List.remove(vCCMN04SOG07);
        return removed;
    } //-- boolean removeCCMN04SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) 

    /**
     * Method removeCCMN04SOG07At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 removeCCMN04SOG07At(int index)
    {
        Object obj = this._CCMN04SOG07List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 removeCCMN04SOG07At(int) 

    /**
     * 
     * 
     * @param index
     * @param vCCMN04SOG07
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCCMN04SOG07(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07 vCCMN04SOG07)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CCMN04SOG07List.size()) {
            throw new IndexOutOfBoundsException("setCCMN04SOG07: Index value '" + index + "' not in range [0.." + (this._CCMN04SOG07List.size() - 1) + "]");
        }
        
        this._CCMN04SOG07List.set(index, vCCMN04SOG07);
    } //-- void setCCMN04SOG07(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) 

    /**
     * 
     * 
     * @param vCCMN04SOG07Array
     */
    public void setCCMN04SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07[] vCCMN04SOG07Array)
    {
        //-- copy array
        _CCMN04SOG07List.clear();
        
        for (int i = 0; i < vCCMN04SOG07Array.length; i++) {
                this._CCMN04SOG07List.add(vCCMN04SOG07Array[i]);
        }
    } //-- void setCCMN04SOG07(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07) 

    /**
     * Sets the value of '_CCMN04SOG07List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCCMN04SOG07List the Vector to copy.
     */
    public void setCCMN04SOG07(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> vCCMN04SOG07List)
    {
        // copy vector
        this._CCMN04SOG07List.clear();
        
        this._CCMN04SOG07List.addAll(vCCMN04SOG07List);
    } //-- void setCCMN04SOG07(java.util.List) 

    /**
     * Sets the value of '_CCMN04SOG07List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CCMN04SOG07Vector the Vector to set.
     */
    public void setCCMN04SOG07AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07> CCMN04SOG07Vector)
    {
        this._CCMN04SOG07List = CCMN04SOG07Vector;
    } //-- void setCCMN04SOG07AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY unmarshal(java.io.Reader) 

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
