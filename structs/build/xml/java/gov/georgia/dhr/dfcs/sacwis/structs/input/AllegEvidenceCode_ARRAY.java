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
 * Class AllegEvidenceCode_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AllegEvidenceCode_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _allegEvidenceCodeList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> _allegEvidenceCodeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AllegEvidenceCode_ARRAY() 
     {
        super();
        this._allegEvidenceCodeList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAllegEvidenceCode
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAllegEvidenceCode(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode vAllegEvidenceCode)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._allegEvidenceCodeList.size() >= 50) {
            throw new IndexOutOfBoundsException("addAllegEvidenceCode has a maximum of 50");
        }
        
        this._allegEvidenceCodeList.add(vAllegEvidenceCode);
    } //-- void addAllegEvidenceCode(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) 

    /**
     * 
     * 
     * @param index
     * @param vAllegEvidenceCode
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAllegEvidenceCode(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode vAllegEvidenceCode)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._allegEvidenceCodeList.size() >= 50) {
            throw new IndexOutOfBoundsException("addAllegEvidenceCode has a maximum of 50");
        }
        
        this._allegEvidenceCodeList.add(index, vAllegEvidenceCode);
    } //-- void addAllegEvidenceCode(int, gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAllegEvidenceCode
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> enumerateAllegEvidenceCode()
    {
        return java.util.Collections.enumeration(this._allegEvidenceCodeList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> enumerateAllegEvidenceCode() 

    /**
     * Method getAllegEvidenceCode
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode getAllegEvidenceCode(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._allegEvidenceCodeList.size()) {
            throw new IndexOutOfBoundsException("getAllegEvidenceCode: Index value '" + index + "' not in range [0.." + (this._allegEvidenceCodeList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) _allegEvidenceCodeList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode getAllegEvidenceCode(int) 

    /**
     * Method getAllegEvidenceCode
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode[] getAllegEvidenceCode()
    {
        int size = this._allegEvidenceCodeList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) _allegEvidenceCodeList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode[] getAllegEvidenceCode() 

    /**
     * Method getAllegEvidenceCodeAsReference
     * 
     * Returns a reference to '_allegEvidenceCodeList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> getAllegEvidenceCodeAsReference()
    {
        return this._allegEvidenceCodeList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> getAllegEvidenceCodeAsReference() 

    /**
     * Method getAllegEvidenceCodeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAllegEvidenceCodeCount()
    {
        return this._allegEvidenceCodeList.size();
    } //-- int getAllegEvidenceCodeCount() 

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
     * Method iterateAllegEvidenceCode
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> iterateAllegEvidenceCode()
    {
        return this._allegEvidenceCodeList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> iterateAllegEvidenceCode() 

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
    public void removeAllAllegEvidenceCode()
    {
        this._allegEvidenceCodeList.clear();
    } //-- void removeAllAllegEvidenceCode() 

    /**
     * Method removeAllegEvidenceCode
     * 
     * 
     * 
     * @param vAllegEvidenceCode
     * @return true if the object was removed from the collection.
     */
    public boolean removeAllegEvidenceCode(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode vAllegEvidenceCode)
    {
        boolean removed = _allegEvidenceCodeList.remove(vAllegEvidenceCode);
        return removed;
    } //-- boolean removeAllegEvidenceCode(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) 

    /**
     * Method removeAllegEvidenceCodeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode removeAllegEvidenceCodeAt(int index)
    {
        Object obj = this._allegEvidenceCodeList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode removeAllegEvidenceCodeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAllegEvidenceCode
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAllegEvidenceCode(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode vAllegEvidenceCode)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._allegEvidenceCodeList.size()) {
            throw new IndexOutOfBoundsException("setAllegEvidenceCode: Index value '" + index + "' not in range [0.." + (this._allegEvidenceCodeList.size() - 1) + "]");
        }
        
        this._allegEvidenceCodeList.set(index, vAllegEvidenceCode);
    } //-- void setAllegEvidenceCode(int, gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) 

    /**
     * 
     * 
     * @param vAllegEvidenceCodeArray
     */
    public void setAllegEvidenceCode(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode[] vAllegEvidenceCodeArray)
    {
        //-- copy array
        _allegEvidenceCodeList.clear();
        
        for (int i = 0; i < vAllegEvidenceCodeArray.length; i++) {
                this._allegEvidenceCodeList.add(vAllegEvidenceCodeArray[i]);
        }
    } //-- void setAllegEvidenceCode(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode) 

    /**
     * Sets the value of '_allegEvidenceCodeList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vAllegEvidenceCodeList the Vector to copy.
     */
    public void setAllegEvidenceCode(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> vAllegEvidenceCodeList)
    {
        // copy vector
        this._allegEvidenceCodeList.clear();
        
        this._allegEvidenceCodeList.addAll(vAllegEvidenceCodeList);
    } //-- void setAllegEvidenceCode(java.util.List) 

    /**
     * Sets the value of '_allegEvidenceCodeList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param AllegEvidenceCodeVector the Vector to set.
     */
    public void setAllegEvidenceCodeAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode> AllegEvidenceCodeVector)
    {
        this._allegEvidenceCodeList = AllegEvidenceCodeVector;
    } //-- void setAllegEvidenceCodeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY unmarshal(java.io.Reader) 

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
