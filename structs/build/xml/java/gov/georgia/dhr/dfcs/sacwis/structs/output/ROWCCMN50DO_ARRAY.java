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
 * Class ROWCCMN50DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN50DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN50DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> _ROWCCMN50DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN50DO_ARRAY() 
     {
        super();
        this._ROWCCMN50DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN50DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO vROWCCMN50DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN50DOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN50DO has a maximum of 50");
        }
        
        this._ROWCCMN50DOList.add(vROWCCMN50DO);
    } //-- void addROWCCMN50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN50DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN50DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO vROWCCMN50DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN50DOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN50DO has a maximum of 50");
        }
        
        this._ROWCCMN50DOList.add(index, vROWCCMN50DO);
    } //-- void addROWCCMN50DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN50DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> enumerateROWCCMN50DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN50DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> enumerateROWCCMN50DO() 

    /**
     * Method getROWCCMN50DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO getROWCCMN50DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN50DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN50DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN50DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) _ROWCCMN50DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO getROWCCMN50DO(int) 

    /**
     * Method getROWCCMN50DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO[] getROWCCMN50DO()
    {
        int size = this._ROWCCMN50DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) _ROWCCMN50DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO[] getROWCCMN50DO() 

    /**
     * Method getROWCCMN50DOAsReference
     * 
     * Returns a reference to '_ROWCCMN50DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> getROWCCMN50DOAsReference()
    {
        return this._ROWCCMN50DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> getROWCCMN50DOAsReference() 

    /**
     * Method getROWCCMN50DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN50DOCount()
    {
        return this._ROWCCMN50DOList.size();
    } //-- int getROWCCMN50DOCount() 

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
     * Method iterateROWCCMN50DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> iterateROWCCMN50DO()
    {
        return this._ROWCCMN50DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> iterateROWCCMN50DO() 

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
    public void removeAllROWCCMN50DO()
    {
        this._ROWCCMN50DOList.clear();
    } //-- void removeAllROWCCMN50DO() 

    /**
     * Method removeROWCCMN50DO
     * 
     * 
     * 
     * @param vROWCCMN50DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO vROWCCMN50DO)
    {
        boolean removed = _ROWCCMN50DOList.remove(vROWCCMN50DO);
        return removed;
    } //-- boolean removeROWCCMN50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) 

    /**
     * Method removeROWCCMN50DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO removeROWCCMN50DOAt(int index)
    {
        Object obj = this._ROWCCMN50DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO removeROWCCMN50DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN50DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN50DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO vROWCCMN50DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN50DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN50DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN50DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN50DOList.set(index, vROWCCMN50DO);
    } //-- void setROWCCMN50DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) 

    /**
     * 
     * 
     * @param vROWCCMN50DOArray
     */
    public void setROWCCMN50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO[] vROWCCMN50DOArray)
    {
        //-- copy array
        _ROWCCMN50DOList.clear();
        
        for (int i = 0; i < vROWCCMN50DOArray.length; i++) {
                this._ROWCCMN50DOList.add(vROWCCMN50DOArray[i]);
        }
    } //-- void setROWCCMN50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) 

    /**
     * Sets the value of '_ROWCCMN50DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN50DOList the Vector to copy.
     */
    public void setROWCCMN50DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> vROWCCMN50DOList)
    {
        // copy vector
        this._ROWCCMN50DOList.clear();
        
        this._ROWCCMN50DOList.addAll(vROWCCMN50DOList);
    } //-- void setROWCCMN50DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN50DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN50DOVector the Vector to set.
     */
    public void setROWCCMN50DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO> ROWCCMN50DOVector)
    {
        this._ROWCCMN50DOList = ROWCCMN50DOVector;
    } //-- void setROWCCMN50DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY unmarshal(java.io.Reader) 

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
