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
 * Class ROWCCMN20DI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN20DI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN20DIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> _ROWCCMN20DIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN20DI_ARRAY() 
     {
        super();
        this._ROWCCMN20DIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN20DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN20DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI vROWCCMN20DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN20DIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN20DI has a maximum of 50");
        }
        
        this._ROWCCMN20DIList.add(vROWCCMN20DI);
    } //-- void addROWCCMN20DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN20DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN20DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI vROWCCMN20DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN20DIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN20DI has a maximum of 50");
        }
        
        this._ROWCCMN20DIList.add(index, vROWCCMN20DI);
    } //-- void addROWCCMN20DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN20DI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> enumerateROWCCMN20DI()
    {
        return java.util.Collections.enumeration(this._ROWCCMN20DIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> enumerateROWCCMN20DI() 

    /**
     * Method getROWCCMN20DI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI getROWCCMN20DI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN20DIList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN20DI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN20DIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) _ROWCCMN20DIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI getROWCCMN20DI(int) 

    /**
     * Method getROWCCMN20DI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI[] getROWCCMN20DI()
    {
        int size = this._ROWCCMN20DIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) _ROWCCMN20DIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI[] getROWCCMN20DI() 

    /**
     * Method getROWCCMN20DIAsReference
     * 
     * Returns a reference to '_ROWCCMN20DIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> getROWCCMN20DIAsReference()
    {
        return this._ROWCCMN20DIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> getROWCCMN20DIAsReference() 

    /**
     * Method getROWCCMN20DICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN20DICount()
    {
        return this._ROWCCMN20DIList.size();
    } //-- int getROWCCMN20DICount() 

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
     * Method iterateROWCCMN20DI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> iterateROWCCMN20DI()
    {
        return this._ROWCCMN20DIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> iterateROWCCMN20DI() 

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
    public void removeAllROWCCMN20DI()
    {
        this._ROWCCMN20DIList.clear();
    } //-- void removeAllROWCCMN20DI() 

    /**
     * Method removeROWCCMN20DI
     * 
     * 
     * 
     * @param vROWCCMN20DI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN20DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI vROWCCMN20DI)
    {
        boolean removed = _ROWCCMN20DIList.remove(vROWCCMN20DI);
        return removed;
    } //-- boolean removeROWCCMN20DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) 

    /**
     * Method removeROWCCMN20DIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI removeROWCCMN20DIAt(int index)
    {
        Object obj = this._ROWCCMN20DIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI removeROWCCMN20DIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN20DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN20DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI vROWCCMN20DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN20DIList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN20DI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN20DIList.size() - 1) + "]");
        }
        
        this._ROWCCMN20DIList.set(index, vROWCCMN20DI);
    } //-- void setROWCCMN20DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) 

    /**
     * 
     * 
     * @param vROWCCMN20DIArray
     */
    public void setROWCCMN20DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI[] vROWCCMN20DIArray)
    {
        //-- copy array
        _ROWCCMN20DIList.clear();
        
        for (int i = 0; i < vROWCCMN20DIArray.length; i++) {
                this._ROWCCMN20DIList.add(vROWCCMN20DIArray[i]);
        }
    } //-- void setROWCCMN20DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) 

    /**
     * Sets the value of '_ROWCCMN20DIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN20DIList the Vector to copy.
     */
    public void setROWCCMN20DI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> vROWCCMN20DIList)
    {
        // copy vector
        this._ROWCCMN20DIList.clear();
        
        this._ROWCCMN20DIList.addAll(vROWCCMN20DIList);
    } //-- void setROWCCMN20DI(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN20DIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN20DIVector the Vector to set.
     */
    public void setROWCCMN20DIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI> ROWCCMN20DIVector)
    {
        this._ROWCCMN20DIList = ROWCCMN20DIVector;
    } //-- void setROWCCMN20DIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY unmarshal(java.io.Reader) 

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
