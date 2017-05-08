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
 * Class CdAllegDisposition_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CdAllegDisposition_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cdAllegDispositionList
     */
    private java.util.List<java.lang.String> _cdAllegDispositionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CdAllegDisposition_ARRAY() 
     {
        super();
        this._cdAllegDispositionList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCdAllegDisposition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCdAllegDisposition(java.lang.String vCdAllegDisposition)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._cdAllegDispositionList.size() >= 2) {
            throw new IndexOutOfBoundsException("addCdAllegDisposition has a maximum of 2");
        }
        
        this._cdAllegDispositionList.add(vCdAllegDisposition);
    } //-- void addCdAllegDisposition(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vCdAllegDisposition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCdAllegDisposition(int index, java.lang.String vCdAllegDisposition)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._cdAllegDispositionList.size() >= 2) {
            throw new IndexOutOfBoundsException("addCdAllegDisposition has a maximum of 2");
        }
        
        this._cdAllegDispositionList.add(index, vCdAllegDisposition);
    } //-- void addCdAllegDisposition(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCdAllegDisposition
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateCdAllegDisposition()
    {
        return java.util.Collections.enumeration(this._cdAllegDispositionList);
    } //-- java.util.Enumeration<java.lang.String> enumerateCdAllegDisposition() 

    /**
     * Method getCdAllegDisposition
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getCdAllegDisposition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._cdAllegDispositionList.size()) {
            throw new IndexOutOfBoundsException("getCdAllegDisposition: Index value '" + index + "' not in range [0.." + (this._cdAllegDispositionList.size() - 1) + "]");
        }
        
        return (String)_cdAllegDispositionList.get(index);
    } //-- java.lang.String getCdAllegDisposition(int) 

    /**
     * Method getCdAllegDisposition
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getCdAllegDisposition()
    {
        int size = this._cdAllegDispositionList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_cdAllegDispositionList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getCdAllegDisposition() 

    /**
     * Method getCdAllegDispositionAsReference
     * 
     * Returns a reference to '_cdAllegDispositionList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getCdAllegDispositionAsReference()
    {
        return this._cdAllegDispositionList;
    } //-- java.util.List<java.lang.String> getCdAllegDispositionAsReference() 

    /**
     * Method getCdAllegDispositionCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCdAllegDispositionCount()
    {
        return this._cdAllegDispositionList.size();
    } //-- int getCdAllegDispositionCount() 

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
     * Method iterateCdAllegDisposition
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateCdAllegDisposition()
    {
        return this._cdAllegDispositionList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateCdAllegDisposition() 

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
    public void removeAllCdAllegDisposition()
    {
        this._cdAllegDispositionList.clear();
    } //-- void removeAllCdAllegDisposition() 

    /**
     * Method removeCdAllegDisposition
     * 
     * 
     * 
     * @param vCdAllegDisposition
     * @return true if the object was removed from the collection.
     */
    public boolean removeCdAllegDisposition(java.lang.String vCdAllegDisposition)
    {
        boolean removed = _cdAllegDispositionList.remove(vCdAllegDisposition);
        return removed;
    } //-- boolean removeCdAllegDisposition(java.lang.String) 

    /**
     * Method removeCdAllegDispositionAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeCdAllegDispositionAt(int index)
    {
        Object obj = this._cdAllegDispositionList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeCdAllegDispositionAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCdAllegDisposition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCdAllegDisposition(int index, java.lang.String vCdAllegDisposition)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._cdAllegDispositionList.size()) {
            throw new IndexOutOfBoundsException("setCdAllegDisposition: Index value '" + index + "' not in range [0.." + (this._cdAllegDispositionList.size() - 1) + "]");
        }
        
        this._cdAllegDispositionList.set(index, vCdAllegDisposition);
    } //-- void setCdAllegDisposition(int, java.lang.String) 

    /**
     * 
     * 
     * @param vCdAllegDispositionArray
     */
    public void setCdAllegDisposition(java.lang.String[] vCdAllegDispositionArray)
    {
        //-- copy array
        _cdAllegDispositionList.clear();
        
        for (int i = 0; i < vCdAllegDispositionArray.length; i++) {
                this._cdAllegDispositionList.add(vCdAllegDispositionArray[i]);
        }
    } //-- void setCdAllegDisposition(java.lang.String) 

    /**
     * Sets the value of '_cdAllegDispositionList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vCdAllegDispositionList the Vector to copy.
     */
    public void setCdAllegDisposition(java.util.List<java.lang.String> vCdAllegDispositionList)
    {
        // copy vector
        this._cdAllegDispositionList.clear();
        
        this._cdAllegDispositionList.addAll(vCdAllegDispositionList);
    } //-- void setCdAllegDisposition(java.util.List) 

    /**
     * Sets the value of '_cdAllegDispositionList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param CdAllegDispositionVector the Vector to set.
     */
    public void setCdAllegDispositionAsReference(java.util.Vector<java.lang.String> CdAllegDispositionVector)
    {
        this._cdAllegDispositionList = CdAllegDispositionVector;
    } //-- void setCdAllegDispositionAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY unmarshal(java.io.Reader) 

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
