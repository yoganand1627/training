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
 * Class TableMetaData.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TableMetaData implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tableName
     */
    private java.lang.String _tableName;

    /**
     * Field _narrativeColumn
     */
    private java.lang.String _narrativeColumn;

    /**
     * Field _tableFields
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields _tableFields;


      //----------------/
     //- Constructors -/
    //----------------/

    public TableMetaData() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'narrativeColumn'.
     * 
     * @return the value of field 'NarrativeColumn'.
     */
    public java.lang.String getNarrativeColumn()
    {
        return this._narrativeColumn;
    } //-- java.lang.String getNarrativeColumn() 

    /**
     * Returns the value of field 'tableFields'.
     * 
     * @return the value of field 'TableFields'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields getTableFields()
    {
        return this._tableFields;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields getTableFields() 

    /**
     * Returns the value of field 'tableName'.
     * 
     * @return the value of field 'TableName'.
     */
    public java.lang.String getTableName()
    {
        return this._tableName;
    } //-- java.lang.String getTableName() 

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
     * Sets the value of field 'narrativeColumn'.
     * 
     * @param narrativeColumn the value of field 'narrativeColumn'.
     */
    public void setNarrativeColumn(java.lang.String narrativeColumn)
    {
        this._narrativeColumn = narrativeColumn;
    } //-- void setNarrativeColumn(java.lang.String) 

    /**
     * Sets the value of field 'tableFields'.
     * 
     * @param tableFields the value of field 'tableFields'.
     */
    public void setTableFields(gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields tableFields)
    {
        this._tableFields = tableFields;
    } //-- void setTableFields(gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields) 

    /**
     * Sets the value of field 'tableName'.
     * 
     * @param tableName the value of field 'tableName'.
     */
    public void setTableName(java.lang.String tableName)
    {
        this._tableName = tableName;
    } //-- void setTableName(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData unmarshal(java.io.Reader) 

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
