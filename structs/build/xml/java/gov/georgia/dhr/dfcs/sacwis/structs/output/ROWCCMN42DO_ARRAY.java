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
 * Class ROWCCMN42DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN42DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN42DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> _ROWCCMN42DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN42DO_ARRAY() 
     {
        super();
        this._ROWCCMN42DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN42DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN42DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO vROWCCMN42DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN42DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN42DO has a maximum of 100");
        }
        
        this._ROWCCMN42DOList.add(vROWCCMN42DO);
    } //-- void addROWCCMN42DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN42DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN42DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO vROWCCMN42DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN42DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN42DO has a maximum of 100");
        }
        
        this._ROWCCMN42DOList.add(index, vROWCCMN42DO);
    } //-- void addROWCCMN42DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN42DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> enumerateROWCCMN42DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN42DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> enumerateROWCCMN42DO() 

    /**
     * Method getROWCCMN42DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO getROWCCMN42DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN42DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN42DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN42DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) _ROWCCMN42DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO getROWCCMN42DO(int) 

    /**
     * Method getROWCCMN42DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO[] getROWCCMN42DO()
    {
        int size = this._ROWCCMN42DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) _ROWCCMN42DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO[] getROWCCMN42DO() 

    /**
     * Method getROWCCMN42DOAsReference
     * 
     * Returns a reference to '_ROWCCMN42DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> getROWCCMN42DOAsReference()
    {
        return this._ROWCCMN42DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> getROWCCMN42DOAsReference() 

    /**
     * Method getROWCCMN42DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN42DOCount()
    {
        return this._ROWCCMN42DOList.size();
    } //-- int getROWCCMN42DOCount() 

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
     * Method iterateROWCCMN42DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> iterateROWCCMN42DO()
    {
        return this._ROWCCMN42DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> iterateROWCCMN42DO() 

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
    public void removeAllROWCCMN42DO()
    {
        this._ROWCCMN42DOList.clear();
    } //-- void removeAllROWCCMN42DO() 

    /**
     * Method removeROWCCMN42DO
     * 
     * 
     * 
     * @param vROWCCMN42DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN42DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO vROWCCMN42DO)
    {
        boolean removed = _ROWCCMN42DOList.remove(vROWCCMN42DO);
        return removed;
    } //-- boolean removeROWCCMN42DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) 

    /**
     * Method removeROWCCMN42DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO removeROWCCMN42DOAt(int index)
    {
        Object obj = this._ROWCCMN42DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO removeROWCCMN42DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN42DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN42DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO vROWCCMN42DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN42DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN42DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN42DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN42DOList.set(index, vROWCCMN42DO);
    } //-- void setROWCCMN42DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) 

    /**
     * 
     * 
     * @param vROWCCMN42DOArray
     */
    public void setROWCCMN42DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO[] vROWCCMN42DOArray)
    {
        //-- copy array
        _ROWCCMN42DOList.clear();
        
        for (int i = 0; i < vROWCCMN42DOArray.length; i++) {
                this._ROWCCMN42DOList.add(vROWCCMN42DOArray[i]);
        }
    } //-- void setROWCCMN42DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO) 

    /**
     * Sets the value of '_ROWCCMN42DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN42DOList the Vector to copy.
     */
    public void setROWCCMN42DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> vROWCCMN42DOList)
    {
        // copy vector
        this._ROWCCMN42DOList.clear();
        
        this._ROWCCMN42DOList.addAll(vROWCCMN42DOList);
    } //-- void setROWCCMN42DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN42DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN42DOVector the Vector to set.
     */
    public void setROWCCMN42DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO> ROWCCMN42DOVector)
    {
        this._ROWCCMN42DOList = ROWCCMN42DOVector;
    } //-- void setROWCCMN42DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY unmarshal(java.io.Reader) 

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
