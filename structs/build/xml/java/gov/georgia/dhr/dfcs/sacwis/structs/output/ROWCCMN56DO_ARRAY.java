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
 * Class ROWCCMN56DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN56DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN56DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> _ROWCCMN56DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN56DO_ARRAY() 
     {
        super();
        this._ROWCCMN56DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN56DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN56DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO vROWCCMN56DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN56DOList.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCCMN56DO has a maximum of 20");
        }
        
        this._ROWCCMN56DOList.add(vROWCCMN56DO);
    } //-- void addROWCCMN56DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN56DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN56DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO vROWCCMN56DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN56DOList.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCCMN56DO has a maximum of 20");
        }
        
        this._ROWCCMN56DOList.add(index, vROWCCMN56DO);
    } //-- void addROWCCMN56DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN56DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> enumerateROWCCMN56DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN56DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> enumerateROWCCMN56DO() 

    /**
     * Method getROWCCMN56DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO getROWCCMN56DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN56DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN56DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN56DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) _ROWCCMN56DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO getROWCCMN56DO(int) 

    /**
     * Method getROWCCMN56DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO[] getROWCCMN56DO()
    {
        int size = this._ROWCCMN56DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) _ROWCCMN56DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO[] getROWCCMN56DO() 

    /**
     * Method getROWCCMN56DOAsReference
     * 
     * Returns a reference to '_ROWCCMN56DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> getROWCCMN56DOAsReference()
    {
        return this._ROWCCMN56DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> getROWCCMN56DOAsReference() 

    /**
     * Method getROWCCMN56DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN56DOCount()
    {
        return this._ROWCCMN56DOList.size();
    } //-- int getROWCCMN56DOCount() 

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
     * Method iterateROWCCMN56DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> iterateROWCCMN56DO()
    {
        return this._ROWCCMN56DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> iterateROWCCMN56DO() 

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
    public void removeAllROWCCMN56DO()
    {
        this._ROWCCMN56DOList.clear();
    } //-- void removeAllROWCCMN56DO() 

    /**
     * Method removeROWCCMN56DO
     * 
     * 
     * 
     * @param vROWCCMN56DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN56DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO vROWCCMN56DO)
    {
        boolean removed = _ROWCCMN56DOList.remove(vROWCCMN56DO);
        return removed;
    } //-- boolean removeROWCCMN56DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) 

    /**
     * Method removeROWCCMN56DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO removeROWCCMN56DOAt(int index)
    {
        Object obj = this._ROWCCMN56DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO removeROWCCMN56DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN56DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN56DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO vROWCCMN56DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN56DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN56DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN56DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN56DOList.set(index, vROWCCMN56DO);
    } //-- void setROWCCMN56DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) 

    /**
     * 
     * 
     * @param vROWCCMN56DOArray
     */
    public void setROWCCMN56DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO[] vROWCCMN56DOArray)
    {
        //-- copy array
        _ROWCCMN56DOList.clear();
        
        for (int i = 0; i < vROWCCMN56DOArray.length; i++) {
                this._ROWCCMN56DOList.add(vROWCCMN56DOArray[i]);
        }
    } //-- void setROWCCMN56DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) 

    /**
     * Sets the value of '_ROWCCMN56DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN56DOList the Vector to copy.
     */
    public void setROWCCMN56DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> vROWCCMN56DOList)
    {
        // copy vector
        this._ROWCCMN56DOList.clear();
        
        this._ROWCCMN56DOList.addAll(vROWCCMN56DOList);
    } //-- void setROWCCMN56DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN56DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN56DOVector the Vector to set.
     */
    public void setROWCCMN56DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO> ROWCCMN56DOVector)
    {
        this._ROWCCMN56DOList = ROWCCMN56DOVector;
    } //-- void setROWCCMN56DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY unmarshal(java.io.Reader) 

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
