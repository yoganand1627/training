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
 * Class CdIncmgDeterm_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CdIncmgDeterm_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cdIncmgDetermList
     */
    private java.util.List<java.lang.String> _cdIncmgDetermList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CdIncmgDeterm_ARRAY() 
     {
        super();
        this._cdIncmgDetermList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCdIncmgDeterm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCdIncmgDeterm(java.lang.String vCdIncmgDeterm)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._cdIncmgDetermList.size() >= 70) {
            throw new IndexOutOfBoundsException("addCdIncmgDeterm has a maximum of 70");
        }
        
        this._cdIncmgDetermList.add(vCdIncmgDeterm);
    } //-- void addCdIncmgDeterm(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vCdIncmgDeterm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCdIncmgDeterm(int index, java.lang.String vCdIncmgDeterm)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._cdIncmgDetermList.size() >= 70) {
            throw new IndexOutOfBoundsException("addCdIncmgDeterm has a maximum of 70");
        }
        
        this._cdIncmgDetermList.add(index, vCdIncmgDeterm);
    } //-- void addCdIncmgDeterm(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCdIncmgDeterm
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateCdIncmgDeterm()
    {
        return java.util.Collections.enumeration(this._cdIncmgDetermList);
    } //-- java.util.Enumeration<java.lang.String> enumerateCdIncmgDeterm() 

    /**
     * Method getCdIncmgDeterm
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getCdIncmgDeterm(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._cdIncmgDetermList.size()) {
            throw new IndexOutOfBoundsException("getCdIncmgDeterm: Index value '" + index + "' not in range [0.." + (this._cdIncmgDetermList.size() - 1) + "]");
        }
        
        return (String)_cdIncmgDetermList.get(index);
    } //-- java.lang.String getCdIncmgDeterm(int) 

    /**
     * Method getCdIncmgDeterm
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getCdIncmgDeterm()
    {
        int size = this._cdIncmgDetermList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_cdIncmgDetermList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getCdIncmgDeterm() 

    /**
     * Method getCdIncmgDetermAsReference
     * 
     * Returns a reference to '_cdIncmgDetermList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getCdIncmgDetermAsReference()
    {
        return this._cdIncmgDetermList;
    } //-- java.util.List<java.lang.String> getCdIncmgDetermAsReference() 

    /**
     * Method getCdIncmgDetermCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCdIncmgDetermCount()
    {
        return this._cdIncmgDetermList.size();
    } //-- int getCdIncmgDetermCount() 

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
     * Method iterateCdIncmgDeterm
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateCdIncmgDeterm()
    {
        return this._cdIncmgDetermList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateCdIncmgDeterm() 

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
    public void removeAllCdIncmgDeterm()
    {
        this._cdIncmgDetermList.clear();
    } //-- void removeAllCdIncmgDeterm() 

    /**
     * Method removeCdIncmgDeterm
     * 
     * 
     * 
     * @param vCdIncmgDeterm
     * @return true if the object was removed from the collection.
     */
    public boolean removeCdIncmgDeterm(java.lang.String vCdIncmgDeterm)
    {
        boolean removed = _cdIncmgDetermList.remove(vCdIncmgDeterm);
        return removed;
    } //-- boolean removeCdIncmgDeterm(java.lang.String) 

    /**
     * Method removeCdIncmgDetermAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeCdIncmgDetermAt(int index)
    {
        Object obj = this._cdIncmgDetermList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeCdIncmgDetermAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCdIncmgDeterm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCdIncmgDeterm(int index, java.lang.String vCdIncmgDeterm)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._cdIncmgDetermList.size()) {
            throw new IndexOutOfBoundsException("setCdIncmgDeterm: Index value '" + index + "' not in range [0.." + (this._cdIncmgDetermList.size() - 1) + "]");
        }
        
        this._cdIncmgDetermList.set(index, vCdIncmgDeterm);
    } //-- void setCdIncmgDeterm(int, java.lang.String) 

    /**
     * 
     * 
     * @param vCdIncmgDetermArray
     */
    public void setCdIncmgDeterm(java.lang.String[] vCdIncmgDetermArray)
    {
        //-- copy array
        _cdIncmgDetermList.clear();
        
        for (int i = 0; i < vCdIncmgDetermArray.length; i++) {
                this._cdIncmgDetermList.add(vCdIncmgDetermArray[i]);
        }
    } //-- void setCdIncmgDeterm(java.lang.String) 

    /**
     * Sets the value of '_cdIncmgDetermList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCdIncmgDetermList the Vector to copy.
     */
    public void setCdIncmgDeterm(java.util.List<java.lang.String> vCdIncmgDetermList)
    {
        // copy vector
        this._cdIncmgDetermList.clear();
        
        this._cdIncmgDetermList.addAll(vCdIncmgDetermList);
    } //-- void setCdIncmgDeterm(java.util.List) 

    /**
     * Sets the value of '_cdIncmgDetermList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CdIncmgDetermVector the Vector to set.
     */
    public void setCdIncmgDetermAsReference(java.util.Vector<java.lang.String> CdIncmgDetermVector)
    {
        this._cdIncmgDetermList = CdIncmgDetermVector;
    } //-- void setCdIncmgDetermAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY unmarshal(java.io.Reader) 

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
