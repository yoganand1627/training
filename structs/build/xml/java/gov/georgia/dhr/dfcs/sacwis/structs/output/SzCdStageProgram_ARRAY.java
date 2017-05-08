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
 * Class SzCdStageProgram_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdStageProgram_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdStageProgramList
     */
    private java.util.List<java.lang.String> _szCdStageProgramList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdStageProgram_ARRAY() 
     {
        super();
        this._szCdStageProgramList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdStageProgram
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdStageProgram(java.lang.String vSzCdStageProgram)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdStageProgramList.size() >= 200) {
            throw new IndexOutOfBoundsException("addSzCdStageProgram has a maximum of 200");
        }
        
        this._szCdStageProgramList.add(vSzCdStageProgram);
    } //-- void addSzCdStageProgram(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdStageProgram
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdStageProgram(int index, java.lang.String vSzCdStageProgram)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdStageProgramList.size() >= 200) {
            throw new IndexOutOfBoundsException("addSzCdStageProgram has a maximum of 200");
        }
        
        this._szCdStageProgramList.add(index, vSzCdStageProgram);
    } //-- void addSzCdStageProgram(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdStageProgram
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdStageProgram()
    {
        return java.util.Collections.enumeration(this._szCdStageProgramList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdStageProgram() 

    /**
     * Method getSzCdStageProgram
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdStageProgram(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdStageProgramList.size()) {
            throw new IndexOutOfBoundsException("getSzCdStageProgram: Index value '" + index + "' not in range [0.." + (this._szCdStageProgramList.size() - 1) + "]");
        }
        
        return (String)_szCdStageProgramList.get(index);
    } //-- java.lang.String getSzCdStageProgram(int) 

    /**
     * Method getSzCdStageProgram
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdStageProgram()
    {
        int size = this._szCdStageProgramList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdStageProgramList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdStageProgram() 

    /**
     * Method getSzCdStageProgramAsReference
     * 
     * Returns a reference to '_szCdStageProgramList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdStageProgramAsReference()
    {
        return this._szCdStageProgramList;
    } //-- java.util.List<java.lang.String> getSzCdStageProgramAsReference() 

    /**
     * Method getSzCdStageProgramCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdStageProgramCount()
    {
        return this._szCdStageProgramList.size();
    } //-- int getSzCdStageProgramCount() 

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
     * Method iterateSzCdStageProgram
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdStageProgram()
    {
        return this._szCdStageProgramList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdStageProgram() 

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
    public void removeAllSzCdStageProgram()
    {
        this._szCdStageProgramList.clear();
    } //-- void removeAllSzCdStageProgram() 

    /**
     * Method removeSzCdStageProgram
     * 
     * 
     * 
     * @param vSzCdStageProgram
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdStageProgram(java.lang.String vSzCdStageProgram)
    {
        boolean removed = _szCdStageProgramList.remove(vSzCdStageProgram);
        return removed;
    } //-- boolean removeSzCdStageProgram(java.lang.String) 

    /**
     * Method removeSzCdStageProgramAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdStageProgramAt(int index)
    {
        Object obj = this._szCdStageProgramList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdStageProgramAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdStageProgram
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdStageProgram(int index, java.lang.String vSzCdStageProgram)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdStageProgramList.size()) {
            throw new IndexOutOfBoundsException("setSzCdStageProgram: Index value '" + index + "' not in range [0.." + (this._szCdStageProgramList.size() - 1) + "]");
        }
        
        this._szCdStageProgramList.set(index, vSzCdStageProgram);
    } //-- void setSzCdStageProgram(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdStageProgramArray
     */
    public void setSzCdStageProgram(java.lang.String[] vSzCdStageProgramArray)
    {
        //-- copy array
        _szCdStageProgramList.clear();
        
        for (int i = 0; i < vSzCdStageProgramArray.length; i++) {
                this._szCdStageProgramList.add(vSzCdStageProgramArray[i]);
        }
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of '_szCdStageProgramList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdStageProgramList the Vector to copy.
     */
    public void setSzCdStageProgram(java.util.List<java.lang.String> vSzCdStageProgramList)
    {
        // copy vector
        this._szCdStageProgramList.clear();
        
        this._szCdStageProgramList.addAll(vSzCdStageProgramList);
    } //-- void setSzCdStageProgram(java.util.List) 

    /**
     * Sets the value of '_szCdStageProgramList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdStageProgramVector the Vector to set.
     */
    public void setSzCdStageProgramAsReference(java.util.Vector<java.lang.String> SzCdStageProgramVector)
    {
        this._szCdStageProgramList = SzCdStageProgramVector;
    } //-- void setSzCdStageProgramAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY unmarshal(java.io.Reader) 

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
