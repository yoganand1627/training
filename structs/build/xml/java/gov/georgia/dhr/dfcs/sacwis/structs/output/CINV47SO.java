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
 * Class CINV47SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV47SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ulIdVictim
     */
    private int _ulIdVictim;

    /**
     * keeps track of state for field: _ulIdVictim
     */
    private boolean _has_ulIdVictim;

    /**
     * Field _tsSysTsLastUpdate4
     */
    private java.util.Date _tsSysTsLastUpdate4;

    /**
     * Field _ulIdAllegedPerpetrator
     */
    private int _ulIdAllegedPerpetrator;

    /**
     * keeps track of state for field: _ulIdAllegedPerpetrator
     */
    private boolean _has_ulIdAllegedPerpetrator;

    /**
     * Field _tsSysTsLastUpdate3
     */
    private java.util.Date _tsSysTsLastUpdate3;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV47SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAllegedPerpetrator()
    {
        this._has_ulIdAllegedPerpetrator= false;
    } //-- void deleteUlIdAllegedPerpetrator() 

    /**
     */
    public void deleteUlIdVictim()
    {
        this._has_ulIdVictim= false;
    } //-- void deleteUlIdVictim() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate3'.
     * 
     * @return the value of field 'TsSysTsLastUpdate3'.
     */
    public java.util.Date getTsSysTsLastUpdate3()
    {
        return this._tsSysTsLastUpdate3;
    } //-- java.util.Date getTsSysTsLastUpdate3() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate4'.
     * 
     * @return the value of field 'TsSysTsLastUpdate4'.
     */
    public java.util.Date getTsSysTsLastUpdate4()
    {
        return this._tsSysTsLastUpdate4;
    } //-- java.util.Date getTsSysTsLastUpdate4() 

    /**
     * Returns the value of field 'ulIdAllegedPerpetrator'.
     * 
     * @return the value of field 'UlIdAllegedPerpetrator'.
     */
    public int getUlIdAllegedPerpetrator()
    {
        return this._ulIdAllegedPerpetrator;
    } //-- int getUlIdAllegedPerpetrator() 

    /**
     * Returns the value of field 'ulIdVictim'.
     * 
     * @return the value of field 'UlIdVictim'.
     */
    public int getUlIdVictim()
    {
        return this._ulIdVictim;
    } //-- int getUlIdVictim() 

    /**
     * Method hasUlIdAllegedPerpetrator
     * 
     * 
     * 
     * @return true if at least one UlIdAllegedPerpetrator has been
     * added
     */
    public boolean hasUlIdAllegedPerpetrator()
    {
        return this._has_ulIdAllegedPerpetrator;
    } //-- boolean hasUlIdAllegedPerpetrator() 

    /**
     * Method hasUlIdVictim
     * 
     * 
     * 
     * @return true if at least one UlIdVictim has been added
     */
    public boolean hasUlIdVictim()
    {
        return this._has_ulIdVictim;
    } //-- boolean hasUlIdVictim() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate3'.
     * 
     * @param tsSysTsLastUpdate3 the value of field
     * 'tsSysTsLastUpdate3'.
     */
    public void setTsSysTsLastUpdate3(java.util.Date tsSysTsLastUpdate3)
    {
        this._tsSysTsLastUpdate3 = tsSysTsLastUpdate3;
    } //-- void setTsSysTsLastUpdate3(java.util.Date) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate4'.
     * 
     * @param tsSysTsLastUpdate4 the value of field
     * 'tsSysTsLastUpdate4'.
     */
    public void setTsSysTsLastUpdate4(java.util.Date tsSysTsLastUpdate4)
    {
        this._tsSysTsLastUpdate4 = tsSysTsLastUpdate4;
    } //-- void setTsSysTsLastUpdate4(java.util.Date) 

    /**
     * Sets the value of field 'ulIdAllegedPerpetrator'.
     * 
     * @param ulIdAllegedPerpetrator the value of field
     * 'ulIdAllegedPerpetrator'.
     */
    public void setUlIdAllegedPerpetrator(int ulIdAllegedPerpetrator)
    {
        this._ulIdAllegedPerpetrator = ulIdAllegedPerpetrator;
        this._has_ulIdAllegedPerpetrator = true;
    } //-- void setUlIdAllegedPerpetrator(int) 

    /**
     * Sets the value of field 'ulIdVictim'.
     * 
     * @param ulIdVictim the value of field 'ulIdVictim'.
     */
    public void setUlIdVictim(int ulIdVictim)
    {
        this._ulIdVictim = ulIdVictim;
        this._has_ulIdVictim = true;
    } //-- void setUlIdVictim(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO unmarshal(java.io.Reader) 

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
