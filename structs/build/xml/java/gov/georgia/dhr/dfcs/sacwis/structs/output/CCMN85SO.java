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
 * Class CCMN85SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN85SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szNmPersonFull_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY _szNmPersonFull_ARRAY;

    /**
     * Field _szCdStageProgram_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY _szCdStageProgram_ARRAY;

    /**
     * Field _szCdStagePersRole_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY _szCdStagePersRole_ARRAY;

    /**
     * Field _ulIdNmPerson_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY _ulIdNmPerson_ARRAY;

    /**
     * Field _szNmFacilInvstFacility
     */
    private java.lang.String _szNmFacilInvstFacility;

    /**
     * Field _ulIdPriorStage
     */
    private int _ulIdPriorStage;

    /**
     * keeps track of state for field: _ulIdPriorStage
     */
    private boolean _has_ulIdPriorStage;

    /**
     * Field _nmPersonHistFull
     */
    private java.lang.String _nmPersonHistFull;

    /**
     * Field _nmIncmgFacilName
     */
    private java.lang.String _nmIncmgFacilName;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN85SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPriorStage()
    {
        this._has_ulIdPriorStage= false;
    } //-- void deleteUlIdPriorStage() 

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
     * Returns the value of field 'nmIncmgFacilName'.
     * 
     * @return the value of field 'NmIncmgFacilName'.
     */
    public java.lang.String getNmIncmgFacilName()
    {
        return this._nmIncmgFacilName;
    } //-- java.lang.String getNmIncmgFacilName() 

    /**
     * Returns the value of field 'nmPersonHistFull'.
     * 
     * @return the value of field 'NmPersonHistFull'.
     */
    public java.lang.String getNmPersonHistFull()
    {
        return this._nmPersonHistFull;
    } //-- java.lang.String getNmPersonHistFull() 

    /**
     * Returns the value of field 'szCdStagePersRole_ARRAY'.
     * 
     * @return the value of field 'SzCdStagePersRole_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY getSzCdStagePersRole_ARRAY()
    {
        return this._szCdStagePersRole_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY getSzCdStagePersRole_ARRAY() 

    /**
     * Returns the value of field 'szCdStageProgram_ARRAY'.
     * 
     * @return the value of field 'SzCdStageProgram_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY getSzCdStageProgram_ARRAY()
    {
        return this._szCdStageProgram_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY getSzCdStageProgram_ARRAY() 

    /**
     * Returns the value of field 'szNmFacilInvstFacility'.
     * 
     * @return the value of field 'SzNmFacilInvstFacility'.
     */
    public java.lang.String getSzNmFacilInvstFacility()
    {
        return this._szNmFacilInvstFacility;
    } //-- java.lang.String getSzNmFacilInvstFacility() 

    /**
     * Returns the value of field 'szNmPersonFull_ARRAY'.
     * 
     * @return the value of field 'SzNmPersonFull_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY getSzNmPersonFull_ARRAY()
    {
        return this._szNmPersonFull_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY getSzNmPersonFull_ARRAY() 

    /**
     * Returns the value of field 'ulIdNmPerson_ARRAY'.
     * 
     * @return the value of field 'UlIdNmPerson_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY getUlIdNmPerson_ARRAY()
    {
        return this._ulIdNmPerson_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY getUlIdNmPerson_ARRAY() 

    /**
     * Returns the value of field 'ulIdPriorStage'.
     * 
     * @return the value of field 'UlIdPriorStage'.
     */
    public int getUlIdPriorStage()
    {
        return this._ulIdPriorStage;
    } //-- int getUlIdPriorStage() 

    /**
     * Method hasUlIdPriorStage
     * 
     * 
     * 
     * @return true if at least one UlIdPriorStage has been added
     */
    public boolean hasUlIdPriorStage()
    {
        return this._has_ulIdPriorStage;
    } //-- boolean hasUlIdPriorStage() 

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
     * Sets the value of field 'nmIncmgFacilName'.
     * 
     * @param nmIncmgFacilName the value of field 'nmIncmgFacilName'
     */
    public void setNmIncmgFacilName(java.lang.String nmIncmgFacilName)
    {
        this._nmIncmgFacilName = nmIncmgFacilName;
    } //-- void setNmIncmgFacilName(java.lang.String) 

    /**
     * Sets the value of field 'nmPersonHistFull'.
     * 
     * @param nmPersonHistFull the value of field 'nmPersonHistFull'
     */
    public void setNmPersonHistFull(java.lang.String nmPersonHistFull)
    {
        this._nmPersonHistFull = nmPersonHistFull;
    } //-- void setNmPersonHistFull(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole_ARRAY'.
     * 
     * @param szCdStagePersRole_ARRAY the value of field
     * 'szCdStagePersRole_ARRAY'.
     */
    public void setSzCdStagePersRole_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY szCdStagePersRole_ARRAY)
    {
        this._szCdStagePersRole_ARRAY = szCdStagePersRole_ARRAY;
    } //-- void setSzCdStagePersRole_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY) 

    /**
     * Sets the value of field 'szCdStageProgram_ARRAY'.
     * 
     * @param szCdStageProgram_ARRAY the value of field
     * 'szCdStageProgram_ARRAY'.
     */
    public void setSzCdStageProgram_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY szCdStageProgram_ARRAY)
    {
        this._szCdStageProgram_ARRAY = szCdStageProgram_ARRAY;
    } //-- void setSzCdStageProgram_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY) 

    /**
     * Sets the value of field 'szNmFacilInvstFacility'.
     * 
     * @param szNmFacilInvstFacility the value of field
     * 'szNmFacilInvstFacility'.
     */
    public void setSzNmFacilInvstFacility(java.lang.String szNmFacilInvstFacility)
    {
        this._szNmFacilInvstFacility = szNmFacilInvstFacility;
    } //-- void setSzNmFacilInvstFacility(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull_ARRAY'.
     * 
     * @param szNmPersonFull_ARRAY the value of field
     * 'szNmPersonFull_ARRAY'.
     */
    public void setSzNmPersonFull_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY szNmPersonFull_ARRAY)
    {
        this._szNmPersonFull_ARRAY = szNmPersonFull_ARRAY;
    } //-- void setSzNmPersonFull_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY) 

    /**
     * Sets the value of field 'ulIdNmPerson_ARRAY'.
     * 
     * @param ulIdNmPerson_ARRAY the value of field
     * 'ulIdNmPerson_ARRAY'.
     */
    public void setUlIdNmPerson_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY ulIdNmPerson_ARRAY)
    {
        this._ulIdNmPerson_ARRAY = ulIdNmPerson_ARRAY;
    } //-- void setUlIdNmPerson_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY) 

    /**
     * Sets the value of field 'ulIdPriorStage'.
     * 
     * @param ulIdPriorStage the value of field 'ulIdPriorStage'.
     */
    public void setUlIdPriorStage(int ulIdPriorStage)
    {
        this._ulIdPriorStage = ulIdPriorStage;
        this._has_ulIdPriorStage = true;
    } //-- void setUlIdPriorStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO unmarshal(java.io.Reader) 

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
