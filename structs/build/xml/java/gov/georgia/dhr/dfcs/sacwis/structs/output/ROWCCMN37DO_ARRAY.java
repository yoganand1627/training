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
 * Class ROWCCMN37DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN37DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN37DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> _ROWCCMN37DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN37DO_ARRAY() 
     {
        super();
        this._ROWCCMN37DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN37DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN37DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO vROWCCMN37DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN37DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN37DO has a maximum of 100");
        }
        
        this._ROWCCMN37DOList.add(vROWCCMN37DO);
    } //-- void addROWCCMN37DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN37DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN37DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO vROWCCMN37DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN37DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMN37DO has a maximum of 100");
        }
        
        this._ROWCCMN37DOList.add(index, vROWCCMN37DO);
    } //-- void addROWCCMN37DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN37DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> enumerateROWCCMN37DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN37DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> enumerateROWCCMN37DO() 

    /**
     * Method getROWCCMN37DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO getROWCCMN37DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN37DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN37DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN37DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) _ROWCCMN37DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO getROWCCMN37DO(int) 

    /**
     * Method getROWCCMN37DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO[] getROWCCMN37DO()
    {
        int size = this._ROWCCMN37DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) _ROWCCMN37DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO[] getROWCCMN37DO() 

    /**
     * Method getROWCCMN37DOAsReference
     * 
     * Returns a reference to '_ROWCCMN37DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> getROWCCMN37DOAsReference()
    {
        return this._ROWCCMN37DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> getROWCCMN37DOAsReference() 

    /**
     * Method getROWCCMN37DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN37DOCount()
    {
        return this._ROWCCMN37DOList.size();
    } //-- int getROWCCMN37DOCount() 

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
     * Method iterateROWCCMN37DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> iterateROWCCMN37DO()
    {
        return this._ROWCCMN37DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> iterateROWCCMN37DO() 

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
    public void removeAllROWCCMN37DO()
    {
        this._ROWCCMN37DOList.clear();
    } //-- void removeAllROWCCMN37DO() 

    /**
     * Method removeROWCCMN37DO
     * 
     * 
     * 
     * @param vROWCCMN37DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN37DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO vROWCCMN37DO)
    {
        boolean removed = _ROWCCMN37DOList.remove(vROWCCMN37DO);
        return removed;
    } //-- boolean removeROWCCMN37DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) 

    /**
     * Method removeROWCCMN37DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO removeROWCCMN37DOAt(int index)
    {
        Object obj = this._ROWCCMN37DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO removeROWCCMN37DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN37DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN37DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO vROWCCMN37DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN37DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN37DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN37DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN37DOList.set(index, vROWCCMN37DO);
    } //-- void setROWCCMN37DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) 

    /**
     * 
     * 
     * @param vROWCCMN37DOArray
     */
    public void setROWCCMN37DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO[] vROWCCMN37DOArray)
    {
        //-- copy array
        _ROWCCMN37DOList.clear();
        
        for (int i = 0; i < vROWCCMN37DOArray.length; i++) {
                this._ROWCCMN37DOList.add(vROWCCMN37DOArray[i]);
        }
    } //-- void setROWCCMN37DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO) 

    /**
     * Sets the value of '_ROWCCMN37DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN37DOList the Vector to copy.
     */
    public void setROWCCMN37DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> vROWCCMN37DOList)
    {
        // copy vector
        this._ROWCCMN37DOList.clear();
        
        this._ROWCCMN37DOList.addAll(vROWCCMN37DOList);
    } //-- void setROWCCMN37DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN37DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN37DOVector the Vector to set.
     */
    public void setROWCCMN37DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO> ROWCCMN37DOVector)
    {
        this._ROWCCMN37DOList = ROWCCMN37DOVector;
    } //-- void setROWCCMN37DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY unmarshal(java.io.Reader) 

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
