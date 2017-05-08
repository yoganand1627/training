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
 * Class ROWCCMN17DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN17DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN17DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> _ROWCCMN17DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN17DO_ARRAY() 
     {
        super();
        this._ROWCCMN17DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN17DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN17DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO vROWCCMN17DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN17DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN17DO has a maximum of 100");
        }
        
        this._ROWCCMN17DOList.add(vROWCCMN17DO);
    } //-- void addROWCCMN17DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN17DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN17DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO vROWCCMN17DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN17DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN17DO has a maximum of 100");
        }
        
        this._ROWCCMN17DOList.add(index, vROWCCMN17DO);
    } //-- void addROWCCMN17DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN17DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> enumerateROWCCMN17DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN17DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> enumerateROWCCMN17DO() 

    /**
     * Method getROWCCMN17DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO getROWCCMN17DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN17DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN17DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN17DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) _ROWCCMN17DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO getROWCCMN17DO(int) 

    /**
     * Method getROWCCMN17DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO[] getROWCCMN17DO()
    {
        int size = this._ROWCCMN17DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) _ROWCCMN17DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO[] getROWCCMN17DO() 

    /**
     * Method getROWCCMN17DOAsReference
     * 
     * Returns a reference to '_ROWCCMN17DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> getROWCCMN17DOAsReference()
    {
        return this._ROWCCMN17DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> getROWCCMN17DOAsReference() 

    /**
     * Method getROWCCMN17DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN17DOCount()
    {
        return this._ROWCCMN17DOList.size();
    } //-- int getROWCCMN17DOCount() 

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
     * Method iterateROWCCMN17DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> iterateROWCCMN17DO()
    {
        return this._ROWCCMN17DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> iterateROWCCMN17DO() 

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
    public void removeAllROWCCMN17DO()
    {
        this._ROWCCMN17DOList.clear();
    } //-- void removeAllROWCCMN17DO() 

    /**
     * Method removeROWCCMN17DO
     * 
     * 
     * 
     * @param vROWCCMN17DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN17DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO vROWCCMN17DO)
    {
        boolean removed = _ROWCCMN17DOList.remove(vROWCCMN17DO);
        return removed;
    } //-- boolean removeROWCCMN17DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) 

    /**
     * Method removeROWCCMN17DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO removeROWCCMN17DOAt(int index)
    {
        Object obj = this._ROWCCMN17DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO removeROWCCMN17DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN17DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN17DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO vROWCCMN17DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN17DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN17DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN17DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN17DOList.set(index, vROWCCMN17DO);
    } //-- void setROWCCMN17DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) 

    /**
     * 
     * 
     * @param vROWCCMN17DOArray
     */
    public void setROWCCMN17DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO[] vROWCCMN17DOArray)
    {
        //-- copy array
        _ROWCCMN17DOList.clear();
        
        for (int i = 0; i < vROWCCMN17DOArray.length; i++) {
                this._ROWCCMN17DOList.add(vROWCCMN17DOArray[i]);
        }
    } //-- void setROWCCMN17DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO) 

    /**
     * Sets the value of '_ROWCCMN17DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN17DOList the Vector to copy.
     */
    public void setROWCCMN17DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> vROWCCMN17DOList)
    {
        // copy vector
        this._ROWCCMN17DOList.clear();
        
        this._ROWCCMN17DOList.addAll(vROWCCMN17DOList);
    } //-- void setROWCCMN17DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN17DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN17DOVector the Vector to set.
     */
    public void setROWCCMN17DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO> ROWCCMN17DOVector)
    {
        this._ROWCCMN17DOList = ROWCCMN17DOVector;
    } //-- void setROWCCMN17DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY unmarshal(java.io.Reader) 

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
