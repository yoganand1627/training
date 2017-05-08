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
 * Class ROWCCMN13DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN13DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN13DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> _ROWCCMN13DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN13DO_ARRAY() 
     {
        super();
        this._ROWCCMN13DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN13DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN13DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO vROWCCMN13DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN13DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN13DO has a maximum of 100");
        }
        
        this._ROWCCMN13DOList.add(vROWCCMN13DO);
    } //-- void addROWCCMN13DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN13DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN13DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO vROWCCMN13DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN13DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN13DO has a maximum of 100");
        }
        
        this._ROWCCMN13DOList.add(index, vROWCCMN13DO);
    } //-- void addROWCCMN13DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN13DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> enumerateROWCCMN13DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN13DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> enumerateROWCCMN13DO() 

    /**
     * Method getROWCCMN13DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO getROWCCMN13DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN13DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN13DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN13DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) _ROWCCMN13DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO getROWCCMN13DO(int) 

    /**
     * Method getROWCCMN13DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO[] getROWCCMN13DO()
    {
        int size = this._ROWCCMN13DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) _ROWCCMN13DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO[] getROWCCMN13DO() 

    /**
     * Method getROWCCMN13DOAsReference
     * 
     * Returns a reference to '_ROWCCMN13DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> getROWCCMN13DOAsReference()
    {
        return this._ROWCCMN13DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> getROWCCMN13DOAsReference() 

    /**
     * Method getROWCCMN13DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN13DOCount()
    {
        return this._ROWCCMN13DOList.size();
    } //-- int getROWCCMN13DOCount() 

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
     * Method iterateROWCCMN13DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> iterateROWCCMN13DO()
    {
        return this._ROWCCMN13DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> iterateROWCCMN13DO() 

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
    public void removeAllROWCCMN13DO()
    {
        this._ROWCCMN13DOList.clear();
    } //-- void removeAllROWCCMN13DO() 

    /**
     * Method removeROWCCMN13DO
     * 
     * 
     * 
     * @param vROWCCMN13DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN13DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO vROWCCMN13DO)
    {
        boolean removed = _ROWCCMN13DOList.remove(vROWCCMN13DO);
        return removed;
    } //-- boolean removeROWCCMN13DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) 

    /**
     * Method removeROWCCMN13DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO removeROWCCMN13DOAt(int index)
    {
        Object obj = this._ROWCCMN13DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO removeROWCCMN13DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN13DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN13DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO vROWCCMN13DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN13DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN13DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN13DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN13DOList.set(index, vROWCCMN13DO);
    } //-- void setROWCCMN13DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) 

    /**
     * 
     * 
     * @param vROWCCMN13DOArray
     */
    public void setROWCCMN13DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO[] vROWCCMN13DOArray)
    {
        //-- copy array
        _ROWCCMN13DOList.clear();
        
        for (int i = 0; i < vROWCCMN13DOArray.length; i++) {
                this._ROWCCMN13DOList.add(vROWCCMN13DOArray[i]);
        }
    } //-- void setROWCCMN13DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO) 

    /**
     * Sets the value of '_ROWCCMN13DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN13DOList the Vector to copy.
     */
    public void setROWCCMN13DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> vROWCCMN13DOList)
    {
        // copy vector
        this._ROWCCMN13DOList.clear();
        
        this._ROWCCMN13DOList.addAll(vROWCCMN13DOList);
    } //-- void setROWCCMN13DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN13DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN13DOVector the Vector to set.
     */
    public void setROWCCMN13DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO> ROWCCMN13DOVector)
    {
        this._ROWCCMN13DOList = ROWCCMN13DOVector;
    } //-- void setROWCCMN13DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY unmarshal(java.io.Reader) 

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
