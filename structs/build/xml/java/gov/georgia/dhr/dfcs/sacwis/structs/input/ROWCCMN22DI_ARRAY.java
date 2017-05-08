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
 * Class ROWCCMN22DI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN22DI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN22DIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> _ROWCCMN22DIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN22DI_ARRAY() 
     {
        super();
        this._ROWCCMN22DIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN22DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN22DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI vROWCCMN22DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN22DIList.size() >= 18) {
            throw new IndexOutOfBoundsException("addROWCCMN22DI has a maximum of 18");
        }
        
        this._ROWCCMN22DIList.add(vROWCCMN22DI);
    } //-- void addROWCCMN22DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN22DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN22DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI vROWCCMN22DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN22DIList.size() >= 18) {
            throw new IndexOutOfBoundsException("addROWCCMN22DI has a maximum of 18");
        }
        
        this._ROWCCMN22DIList.add(index, vROWCCMN22DI);
    } //-- void addROWCCMN22DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN22DI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> enumerateROWCCMN22DI()
    {
        return java.util.Collections.enumeration(this._ROWCCMN22DIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> enumerateROWCCMN22DI() 

    /**
     * Method getROWCCMN22DI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI getROWCCMN22DI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN22DIList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN22DI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN22DIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) _ROWCCMN22DIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI getROWCCMN22DI(int) 

    /**
     * Method getROWCCMN22DI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI[] getROWCCMN22DI()
    {
        int size = this._ROWCCMN22DIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) _ROWCCMN22DIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI[] getROWCCMN22DI() 

    /**
     * Method getROWCCMN22DIAsReference
     * 
     * Returns a reference to '_ROWCCMN22DIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> getROWCCMN22DIAsReference()
    {
        return this._ROWCCMN22DIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> getROWCCMN22DIAsReference() 

    /**
     * Method getROWCCMN22DICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN22DICount()
    {
        return this._ROWCCMN22DIList.size();
    } //-- int getROWCCMN22DICount() 

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
     * Method iterateROWCCMN22DI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> iterateROWCCMN22DI()
    {
        return this._ROWCCMN22DIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> iterateROWCCMN22DI() 

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
    public void removeAllROWCCMN22DI()
    {
        this._ROWCCMN22DIList.clear();
    } //-- void removeAllROWCCMN22DI() 

    /**
     * Method removeROWCCMN22DI
     * 
     * 
     * 
     * @param vROWCCMN22DI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN22DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI vROWCCMN22DI)
    {
        boolean removed = _ROWCCMN22DIList.remove(vROWCCMN22DI);
        return removed;
    } //-- boolean removeROWCCMN22DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) 

    /**
     * Method removeROWCCMN22DIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI removeROWCCMN22DIAt(int index)
    {
        Object obj = this._ROWCCMN22DIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI removeROWCCMN22DIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN22DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN22DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI vROWCCMN22DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN22DIList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN22DI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN22DIList.size() - 1) + "]");
        }
        
        this._ROWCCMN22DIList.set(index, vROWCCMN22DI);
    } //-- void setROWCCMN22DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) 

    /**
     * 
     * 
     * @param vROWCCMN22DIArray
     */
    public void setROWCCMN22DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI[] vROWCCMN22DIArray)
    {
        //-- copy array
        _ROWCCMN22DIList.clear();
        
        for (int i = 0; i < vROWCCMN22DIArray.length; i++) {
                this._ROWCCMN22DIList.add(vROWCCMN22DIArray[i]);
        }
    } //-- void setROWCCMN22DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) 

    /**
     * Sets the value of '_ROWCCMN22DIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN22DIList the Vector to copy.
     */
    public void setROWCCMN22DI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> vROWCCMN22DIList)
    {
        // copy vector
        this._ROWCCMN22DIList.clear();
        
        this._ROWCCMN22DIList.addAll(vROWCCMN22DIList);
    } //-- void setROWCCMN22DI(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN22DIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN22DIVector the Vector to set.
     */
    public void setROWCCMN22DIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI> ROWCCMN22DIVector)
    {
        this._ROWCCMN22DIList = ROWCCMN22DIVector;
    } //-- void setROWCCMN22DIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY unmarshal(java.io.Reader) 

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
