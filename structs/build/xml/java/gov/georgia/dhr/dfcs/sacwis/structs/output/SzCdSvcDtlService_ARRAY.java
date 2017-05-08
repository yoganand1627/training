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
 * Class SzCdSvcDtlService_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdSvcDtlService_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdSvcDtlServiceList
     */
    private java.util.List<java.lang.String> _szCdSvcDtlServiceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdSvcDtlService_ARRAY() 
     {
        super();
        this._szCdSvcDtlServiceList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdSvcDtlService
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdSvcDtlService(java.lang.String vSzCdSvcDtlService)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdSvcDtlServiceList.size() >= 300) {
            throw new IndexOutOfBoundsException("addSzCdSvcDtlService has a maximum of 300");
        }
        
        this._szCdSvcDtlServiceList.add(vSzCdSvcDtlService);
    } //-- void addSzCdSvcDtlService(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdSvcDtlService
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdSvcDtlService(int index, java.lang.String vSzCdSvcDtlService)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdSvcDtlServiceList.size() >= 300) {
            throw new IndexOutOfBoundsException("addSzCdSvcDtlService has a maximum of 300");
        }
        
        this._szCdSvcDtlServiceList.add(index, vSzCdSvcDtlService);
    } //-- void addSzCdSvcDtlService(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdSvcDtlService
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdSvcDtlService()
    {
        return java.util.Collections.enumeration(this._szCdSvcDtlServiceList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdSvcDtlService() 

    /**
     * Method getSzCdSvcDtlService
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdSvcDtlService(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdSvcDtlServiceList.size()) {
            throw new IndexOutOfBoundsException("getSzCdSvcDtlService: Index value '" + index + "' not in range [0.." + (this._szCdSvcDtlServiceList.size() - 1) + "]");
        }
        
        return (String)_szCdSvcDtlServiceList.get(index);
    } //-- java.lang.String getSzCdSvcDtlService(int) 

    /**
     * Method getSzCdSvcDtlService
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdSvcDtlService()
    {
        int size = this._szCdSvcDtlServiceList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdSvcDtlServiceList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdSvcDtlService() 

    /**
     * Method getSzCdSvcDtlServiceAsReference
     * 
     * Returns a reference to '_szCdSvcDtlServiceList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdSvcDtlServiceAsReference()
    {
        return this._szCdSvcDtlServiceList;
    } //-- java.util.List<java.lang.String> getSzCdSvcDtlServiceAsReference() 

    /**
     * Method getSzCdSvcDtlServiceCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdSvcDtlServiceCount()
    {
        return this._szCdSvcDtlServiceList.size();
    } //-- int getSzCdSvcDtlServiceCount() 

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
     * Method iterateSzCdSvcDtlService
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdSvcDtlService()
    {
        return this._szCdSvcDtlServiceList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdSvcDtlService() 

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
    public void removeAllSzCdSvcDtlService()
    {
        this._szCdSvcDtlServiceList.clear();
    } //-- void removeAllSzCdSvcDtlService() 

    /**
     * Method removeSzCdSvcDtlService
     * 
     * 
     * 
     * @param vSzCdSvcDtlService
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdSvcDtlService(java.lang.String vSzCdSvcDtlService)
    {
        boolean removed = _szCdSvcDtlServiceList.remove(vSzCdSvcDtlService);
        return removed;
    } //-- boolean removeSzCdSvcDtlService(java.lang.String) 

    /**
     * Method removeSzCdSvcDtlServiceAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdSvcDtlServiceAt(int index)
    {
        Object obj = this._szCdSvcDtlServiceList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdSvcDtlServiceAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdSvcDtlService
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdSvcDtlService(int index, java.lang.String vSzCdSvcDtlService)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdSvcDtlServiceList.size()) {
            throw new IndexOutOfBoundsException("setSzCdSvcDtlService: Index value '" + index + "' not in range [0.." + (this._szCdSvcDtlServiceList.size() - 1) + "]");
        }
        
        this._szCdSvcDtlServiceList.set(index, vSzCdSvcDtlService);
    } //-- void setSzCdSvcDtlService(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdSvcDtlServiceArray
     */
    public void setSzCdSvcDtlService(java.lang.String[] vSzCdSvcDtlServiceArray)
    {
        //-- copy array
        _szCdSvcDtlServiceList.clear();
        
        for (int i = 0; i < vSzCdSvcDtlServiceArray.length; i++) {
                this._szCdSvcDtlServiceList.add(vSzCdSvcDtlServiceArray[i]);
        }
    } //-- void setSzCdSvcDtlService(java.lang.String) 

    /**
     * Sets the value of '_szCdSvcDtlServiceList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdSvcDtlServiceList the Vector to copy.
     */
    public void setSzCdSvcDtlService(java.util.List<java.lang.String> vSzCdSvcDtlServiceList)
    {
        // copy vector
        this._szCdSvcDtlServiceList.clear();
        
        this._szCdSvcDtlServiceList.addAll(vSzCdSvcDtlServiceList);
    } //-- void setSzCdSvcDtlService(java.util.List) 

    /**
     * Sets the value of '_szCdSvcDtlServiceList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdSvcDtlServiceVector the Vector to set.
     */
    public void setSzCdSvcDtlServiceAsReference(java.util.Vector<java.lang.String> SzCdSvcDtlServiceVector)
    {
        this._szCdSvcDtlServiceList = SzCdSvcDtlServiceVector;
    } //-- void setSzCdSvcDtlServiceAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY unmarshal(java.io.Reader) 

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
