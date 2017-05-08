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
 * Class ROWCCMN87DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN87DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN87DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> _ROWCCMN87DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN87DO_ARRAY() 
     {
        super();
        this._ROWCCMN87DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN87DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN87DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO vROWCCMN87DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN87DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN87DO has a maximum of 100");
        }
        
        this._ROWCCMN87DOList.add(vROWCCMN87DO);
    } //-- void addROWCCMN87DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN87DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN87DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO vROWCCMN87DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN87DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN87DO has a maximum of 100");
        }
        
        this._ROWCCMN87DOList.add(index, vROWCCMN87DO);
    } //-- void addROWCCMN87DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN87DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> enumerateROWCCMN87DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN87DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> enumerateROWCCMN87DO() 

    /**
     * Method getROWCCMN87DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO getROWCCMN87DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN87DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN87DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN87DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) _ROWCCMN87DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO getROWCCMN87DO(int) 

    /**
     * Method getROWCCMN87DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO[] getROWCCMN87DO()
    {
        int size = this._ROWCCMN87DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) _ROWCCMN87DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO[] getROWCCMN87DO() 

    /**
     * Method getROWCCMN87DOAsReference
     * 
     * Returns a reference to '_ROWCCMN87DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> getROWCCMN87DOAsReference()
    {
        return this._ROWCCMN87DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> getROWCCMN87DOAsReference() 

    /**
     * Method getROWCCMN87DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN87DOCount()
    {
        return this._ROWCCMN87DOList.size();
    } //-- int getROWCCMN87DOCount() 

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
     * Method iterateROWCCMN87DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> iterateROWCCMN87DO()
    {
        return this._ROWCCMN87DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> iterateROWCCMN87DO() 

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
    public void removeAllROWCCMN87DO()
    {
        this._ROWCCMN87DOList.clear();
    } //-- void removeAllROWCCMN87DO() 

    /**
     * Method removeROWCCMN87DO
     * 
     * 
     * 
     * @param vROWCCMN87DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN87DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO vROWCCMN87DO)
    {
        boolean removed = _ROWCCMN87DOList.remove(vROWCCMN87DO);
        return removed;
    } //-- boolean removeROWCCMN87DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) 

    /**
     * Method removeROWCCMN87DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO removeROWCCMN87DOAt(int index)
    {
        Object obj = this._ROWCCMN87DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO removeROWCCMN87DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN87DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN87DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO vROWCCMN87DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN87DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN87DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN87DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN87DOList.set(index, vROWCCMN87DO);
    } //-- void setROWCCMN87DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) 

    /**
     * 
     * 
     * @param vROWCCMN87DOArray
     */
    public void setROWCCMN87DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO[] vROWCCMN87DOArray)
    {
        //-- copy array
        _ROWCCMN87DOList.clear();
        
        for (int i = 0; i < vROWCCMN87DOArray.length; i++) {
                this._ROWCCMN87DOList.add(vROWCCMN87DOArray[i]);
        }
    } //-- void setROWCCMN87DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO) 

    /**
     * Sets the value of '_ROWCCMN87DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN87DOList the Vector to copy.
     */
    public void setROWCCMN87DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> vROWCCMN87DOList)
    {
        // copy vector
        this._ROWCCMN87DOList.clear();
        
        this._ROWCCMN87DOList.addAll(vROWCCMN87DOList);
    } //-- void setROWCCMN87DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN87DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN87DOVector the Vector to set.
     */
    public void setROWCCMN87DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO> ROWCCMN87DOVector)
    {
        this._ROWCCMN87DOList = ROWCCMN87DOVector;
    } //-- void setROWCCMN87DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY unmarshal(java.io.Reader) 

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
