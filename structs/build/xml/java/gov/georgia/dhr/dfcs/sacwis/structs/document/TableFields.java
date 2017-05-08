/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class TableFields.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TableFields implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _columnList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> _columnList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TableFields() 
     {
        super();
        this._columnList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.document.Column>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vColumn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addColumn(gov.georgia.dhr.dfcs.sacwis.structs.document.Column vColumn)
        throws java.lang.IndexOutOfBoundsException
    {
        this._columnList.add(vColumn);
    } //-- void addColumn(gov.georgia.dhr.dfcs.sacwis.structs.document.Column) 

    /**
     * 
     * 
     * @param index
     * @param vColumn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addColumn(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.Column vColumn)
        throws java.lang.IndexOutOfBoundsException
    {
        this._columnList.add(index, vColumn);
    } //-- void addColumn(int, gov.georgia.dhr.dfcs.sacwis.structs.document.Column) 

    /**
     * Method enumerateColumn
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> enumerateColumn()
    {
        return java.util.Collections.enumeration(this._columnList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> enumerateColumn() 

    /**
     * Method getColumn
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.document.Column at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Column getColumn(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._columnList.size()) {
            throw new IndexOutOfBoundsException("getColumn: Index value '" + index + "' not in range [0.." + (this._columnList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Column) _columnList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Column getColumn(int) 

    /**
     * Method getColumn
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Column[] getColumn()
    {
        int size = this._columnList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.document.Column[] array = new gov.georgia.dhr.dfcs.sacwis.structs.document.Column[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.document.Column) _columnList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Column[] getColumn() 

    /**
     * Method getColumnAsReference
     * 
     * Returns a reference to '_columnList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> getColumnAsReference()
    {
        return this._columnList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> getColumnAsReference() 

    /**
     * Method getColumnCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getColumnCount()
    {
        return this._columnList.size();
    } //-- int getColumnCount() 

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
     * Method iterateColumn
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> iterateColumn()
    {
        return this._columnList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> iterateColumn() 

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
    public void removeAllColumn()
    {
        this._columnList.clear();
    } //-- void removeAllColumn() 

    /**
     * Method removeColumn
     * 
     * 
     * 
     * @param vColumn
     * @return true if the object was removed from the collection.
     */
    public boolean removeColumn(gov.georgia.dhr.dfcs.sacwis.structs.document.Column vColumn)
    {
        boolean removed = _columnList.remove(vColumn);
        return removed;
    } //-- boolean removeColumn(gov.georgia.dhr.dfcs.sacwis.structs.document.Column) 

    /**
     * Method removeColumnAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Column removeColumnAt(int index)
    {
        Object obj = this._columnList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Column) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Column removeColumnAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vColumn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setColumn(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.Column vColumn)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._columnList.size()) {
            throw new IndexOutOfBoundsException("setColumn: Index value '" + index + "' not in range [0.." + (this._columnList.size() - 1) + "]");
        }
        
        this._columnList.set(index, vColumn);
    } //-- void setColumn(int, gov.georgia.dhr.dfcs.sacwis.structs.document.Column) 

    /**
     * 
     * 
     * @param vColumnArray
     */
    public void setColumn(gov.georgia.dhr.dfcs.sacwis.structs.document.Column[] vColumnArray)
    {
        //-- copy array
        _columnList.clear();
        
        for (int i = 0; i < vColumnArray.length; i++) {
                this._columnList.add(vColumnArray[i]);
        }
    } //-- void setColumn(gov.georgia.dhr.dfcs.sacwis.structs.document.Column) 

    /**
     * Sets the value of '_columnList' by copying the given Vector.
     * All elements will be checked for type safety.
     * 
     * @param vColumnList the Vector to copy.
     */
    public void setColumn(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> vColumnList)
    {
        // copy vector
        this._columnList.clear();
        
        this._columnList.addAll(vColumnList);
    } //-- void setColumn(java.util.List) 

    /**
     * Sets the value of '_columnList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param ColumnVector the Vector to set.
     */
    public void setColumnAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.document.Column> ColumnVector)
    {
        this._columnList = ColumnVector;
    } //-- void setColumnAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields unmarshal(java.io.Reader) 

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
