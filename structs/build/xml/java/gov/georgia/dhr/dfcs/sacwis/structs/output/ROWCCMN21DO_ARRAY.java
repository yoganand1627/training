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
 * Class ROWCCMN21DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN21DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN21DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> _ROWCCMN21DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN21DO_ARRAY() 
     {
        super();
        this._ROWCCMN21DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN21DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN21DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO vROWCCMN21DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN21DOList.size() >= 9) {
            throw new IndexOutOfBoundsException("addROWCCMN21DO has a maximum of 9");
        }
        
        this._ROWCCMN21DOList.add(vROWCCMN21DO);
    } //-- void addROWCCMN21DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN21DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN21DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO vROWCCMN21DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN21DOList.size() >= 9) {
            throw new IndexOutOfBoundsException("addROWCCMN21DO has a maximum of 9");
        }
        
        this._ROWCCMN21DOList.add(index, vROWCCMN21DO);
    } //-- void addROWCCMN21DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN21DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> enumerateROWCCMN21DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN21DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> enumerateROWCCMN21DO() 

    /**
     * Method getROWCCMN21DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO getROWCCMN21DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN21DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN21DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN21DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) _ROWCCMN21DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO getROWCCMN21DO(int) 

    /**
     * Method getROWCCMN21DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO[] getROWCCMN21DO()
    {
        int size = this._ROWCCMN21DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) _ROWCCMN21DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO[] getROWCCMN21DO() 

    /**
     * Method getROWCCMN21DOAsReference
     * 
     * Returns a reference to '_ROWCCMN21DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> getROWCCMN21DOAsReference()
    {
        return this._ROWCCMN21DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> getROWCCMN21DOAsReference() 

    /**
     * Method getROWCCMN21DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN21DOCount()
    {
        return this._ROWCCMN21DOList.size();
    } //-- int getROWCCMN21DOCount() 

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
     * Method iterateROWCCMN21DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> iterateROWCCMN21DO()
    {
        return this._ROWCCMN21DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> iterateROWCCMN21DO() 

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
    public void removeAllROWCCMN21DO()
    {
        this._ROWCCMN21DOList.clear();
    } //-- void removeAllROWCCMN21DO() 

    /**
     * Method removeROWCCMN21DO
     * 
     * 
     * 
     * @param vROWCCMN21DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN21DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO vROWCCMN21DO)
    {
        boolean removed = _ROWCCMN21DOList.remove(vROWCCMN21DO);
        return removed;
    } //-- boolean removeROWCCMN21DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) 

    /**
     * Method removeROWCCMN21DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO removeROWCCMN21DOAt(int index)
    {
        Object obj = this._ROWCCMN21DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO removeROWCCMN21DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN21DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN21DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO vROWCCMN21DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN21DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN21DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN21DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN21DOList.set(index, vROWCCMN21DO);
    } //-- void setROWCCMN21DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) 

    /**
     * 
     * 
     * @param vROWCCMN21DOArray
     */
    public void setROWCCMN21DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO[] vROWCCMN21DOArray)
    {
        //-- copy array
        _ROWCCMN21DOList.clear();
        
        for (int i = 0; i < vROWCCMN21DOArray.length; i++) {
                this._ROWCCMN21DOList.add(vROWCCMN21DOArray[i]);
        }
    } //-- void setROWCCMN21DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO) 

    /**
     * Sets the value of '_ROWCCMN21DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN21DOList the Vector to copy.
     */
    public void setROWCCMN21DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> vROWCCMN21DOList)
    {
        // copy vector
        this._ROWCCMN21DOList.clear();
        
        this._ROWCCMN21DOList.addAll(vROWCCMN21DOList);
    } //-- void setROWCCMN21DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN21DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN21DOVector the Vector to set.
     */
    public void setROWCCMN21DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO> ROWCCMN21DOVector)
    {
        this._ROWCCMN21DOList = ROWCCMN21DOVector;
    } //-- void setROWCCMN21DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY unmarshal(java.io.Reader) 

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
