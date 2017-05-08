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
 * Class ROWCCMN52DI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN52DI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN52DIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> _ROWCCMN52DIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN52DI_ARRAY() 
     {
        super();
        this._ROWCCMN52DIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN52DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN52DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI vROWCCMN52DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN52DIList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN52DI has a maximum of 100");
        }
        
        this._ROWCCMN52DIList.add(vROWCCMN52DI);
    } //-- void addROWCCMN52DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN52DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN52DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI vROWCCMN52DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN52DIList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN52DI has a maximum of 100");
        }
        
        this._ROWCCMN52DIList.add(index, vROWCCMN52DI);
    } //-- void addROWCCMN52DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN52DI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> enumerateROWCCMN52DI()
    {
        return java.util.Collections.enumeration(this._ROWCCMN52DIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> enumerateROWCCMN52DI() 

    /**
     * Method getROWCCMN52DI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI getROWCCMN52DI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN52DIList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN52DI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN52DIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) _ROWCCMN52DIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI getROWCCMN52DI(int) 

    /**
     * Method getROWCCMN52DI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI[] getROWCCMN52DI()
    {
        int size = this._ROWCCMN52DIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) _ROWCCMN52DIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI[] getROWCCMN52DI() 

    /**
     * Method getROWCCMN52DIAsReference
     * 
     * Returns a reference to '_ROWCCMN52DIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> getROWCCMN52DIAsReference()
    {
        return this._ROWCCMN52DIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> getROWCCMN52DIAsReference() 

    /**
     * Method getROWCCMN52DICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN52DICount()
    {
        return this._ROWCCMN52DIList.size();
    } //-- int getROWCCMN52DICount() 

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
     * Method iterateROWCCMN52DI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> iterateROWCCMN52DI()
    {
        return this._ROWCCMN52DIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> iterateROWCCMN52DI() 

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
    public void removeAllROWCCMN52DI()
    {
        this._ROWCCMN52DIList.clear();
    } //-- void removeAllROWCCMN52DI() 

    /**
     * Method removeROWCCMN52DI
     * 
     * 
     * 
     * @param vROWCCMN52DI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN52DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI vROWCCMN52DI)
    {
        boolean removed = _ROWCCMN52DIList.remove(vROWCCMN52DI);
        return removed;
    } //-- boolean removeROWCCMN52DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) 

    /**
     * Method removeROWCCMN52DIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI removeROWCCMN52DIAt(int index)
    {
        Object obj = this._ROWCCMN52DIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI removeROWCCMN52DIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN52DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN52DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI vROWCCMN52DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN52DIList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN52DI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN52DIList.size() - 1) + "]");
        }
        
        this._ROWCCMN52DIList.set(index, vROWCCMN52DI);
    } //-- void setROWCCMN52DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) 

    /**
     * 
     * 
     * @param vROWCCMN52DIArray
     */
    public void setROWCCMN52DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI[] vROWCCMN52DIArray)
    {
        //-- copy array
        _ROWCCMN52DIList.clear();
        
        for (int i = 0; i < vROWCCMN52DIArray.length; i++) {
                this._ROWCCMN52DIList.add(vROWCCMN52DIArray[i]);
        }
    } //-- void setROWCCMN52DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI) 

    /**
     * Sets the value of '_ROWCCMN52DIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN52DIList the Vector to copy.
     */
    public void setROWCCMN52DI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> vROWCCMN52DIList)
    {
        // copy vector
        this._ROWCCMN52DIList.clear();
        
        this._ROWCCMN52DIList.addAll(vROWCCMN52DIList);
    } //-- void setROWCCMN52DI(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN52DIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN52DIVector the Vector to set.
     */
    public void setROWCCMN52DIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI> ROWCCMN52DIVector)
    {
        this._ROWCCMN52DIList = ROWCCMN52DIVector;
    } //-- void setROWCCMN52DIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY unmarshal(java.io.Reader) 

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
