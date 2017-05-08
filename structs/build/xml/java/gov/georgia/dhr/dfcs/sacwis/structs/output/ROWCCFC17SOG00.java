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
 * Class ROWCCFC17SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC17SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmEdhistSchDist
     */
    private java.lang.String _szNmEdhistSchDist;

    /**
     * Field _cIndEdhistTeaSchool
     */
    private java.lang.String _cIndEdhistTeaSchool;

    /**
     * Field _szNmEdhistSchool
     */
    private java.lang.String _szNmEdhistSchool;

    /**
     * Field _szCdEdhistNeeds1
     */
    private java.lang.String _szCdEdhistNeeds1;

    /**
     * Field _szCdEdhistNeeds2
     */
    private java.lang.String _szCdEdhistNeeds2;

    /**
     * Field _szCdEdhistNeeds3
     */
    private java.lang.String _szCdEdhistNeeds3;

    /**
     * Field _szCdEdhistNeeds4
     */
    private java.lang.String _szCdEdhistNeeds4;

    /**
     * Field _szCdEdhistNeeds5
     */
    private java.lang.String _szCdEdhistNeeds5;

    /**
     * Field _szCdEdhistNeeds6
     */
    private java.lang.String _szCdEdhistNeeds6;

    /**
     * Field _szCdEdhistNeeds7
     */
    private java.lang.String _szCdEdhistNeeds7;

    /**
     * Field _szCdEdhistNeeds8
     */
    private java.lang.String _szCdEdhistNeeds8;

    /**
     * Field _szCdEdhistNeeds9
     */
    private java.lang.String _szCdEdhistNeeds9;

    /**
     * Field _szCdEdhistNeeds10
     */
    private java.lang.String _szCdEdhistNeeds10;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdEdhistEnrollGrade
     */
    private java.lang.String _szCdEdhistEnrollGrade;

    /**
     * Field _szCdEdhistWithdrawnGrade
     */
    private java.lang.String _szCdEdhistWithdrawnGrade;

    /**
     * Field _dtDtEdhistEnrollDate
     */
    private org.exolab.castor.types.Date _dtDtEdhistEnrollDate;

    /**
     * Field _dtDtEdhistWithdrawnDate
     */
    private org.exolab.castor.types.Date _dtDtEdhistWithdrawnDate;

    /**
     * Field _szAddrEdhistCity
     */
    private java.lang.String _szAddrEdhistCity;

    /**
     * Field _szAddrEdhistCnty
     */
    private java.lang.String _szAddrEdhistCnty;

    /**
     * Field _szAddrEdhistState
     */
    private java.lang.String _szAddrEdhistState;

    /**
     * Field _szAddrEdhistStreetLn1
     */
    private java.lang.String _szAddrEdhistStreetLn1;

    /**
     * Field _szAddrEdhistStreetLn2
     */
    private java.lang.String _szAddrEdhistStreetLn2;

    /**
     * Field _szAddrEdhistZip
     */
    private java.lang.String _szAddrEdhistZip;

    /**
     * Field _ulIdEdhist
     */
    private int _ulIdEdhist;

    /**
     * keeps track of state for field: _ulIdEdhist
     */
    private boolean _has_ulIdEdhist;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szNbrEdhistPhone
     */
    private java.lang.String _szNbrEdhistPhone;

    /**
     * Field _szNbrEdhistPhoneExt
     */
    private java.lang.String _szNbrEdhistPhoneExt;

    /**
     * Field _szTxtEdhistAddrCmnt
     */
    private java.lang.String _szTxtEdhistAddrCmnt;

    /**
     * Field _szCdEdhistType
     */
    private java.lang.String _szCdEdhistType;

    /**
     * Field _szEdHistComments
     */
    private java.lang.String _szEdHistComments;

    /**
     * Field _szIndEdhistLicense
     */
    private java.lang.String _szIndEdhistLicense;

    /**
     * Field _rbSchoolRecs
     */
    private java.lang.String _rbSchoolRecs;

    /**
     * Field _rbRecsToBCounty
     */
    private java.lang.String _rbRecsToBCounty;

    /**
     * Field _rbSchoolChange
     */
    private java.lang.String _rbSchoolChange;

    /**
     * Field _szTxtBehaveDisc
     */
    private java.lang.String _szTxtBehaveDisc;

    /**
     * Field _rbSpecialEdNeeds
     */
    private java.lang.String _rbSpecialEdNeeds;

    /**
     * Field _rbSpecialEdSvc
     */
    private java.lang.String _rbSpecialEdSvc;

    /**
     * Field _szTxtSpecialEdCmnts
     */
    private java.lang.String _szTxtSpecialEdCmnts;

    /**
     * Field _szDtStSupTeamRef
     */
    private java.util.Date _szDtStSupTeamRef;

    /**
     * Field _szDtRbEdDate
     */
    private java.util.Date _szDtRbEdDate;

    /**
     * Field _txtSurrogateParent
     */
    private java.lang.String _txtSurrogateParent;

    /**
     * Field _rbIndFosterParent
     */
    private java.lang.String _rbIndFosterParent;

    /**
     * Field _rbIndOther
     */
    private java.lang.String _rbIndOther;

    /**
     * Field _rbLegalParent
     */
    private java.lang.String _rbLegalParent;

    /**
     * Field _szTxtSstIepCmnts
     */
    private java.lang.String _szTxtSstIepCmnts;

    /**
     * Field _rbChildServices
     */
    private java.lang.String _rbChildServices;

    /**
     * Field _rbPrevChildSvc
     */
    private java.lang.String _rbPrevChildSvc;

    /**
     * Field _szTxtChildSvcComments
     */
    private java.lang.String _szTxtChildSvcComments;

    /**
     * Field _rbCIndEdhistLevel
     */
    private java.lang.String _rbCIndEdhistLevel;

    /**
     * Field _szCEdhistCurrentGradeLevel
     */
    private java.lang.String _szCEdhistCurrentGradeLevel;

    /**
     * Field _szCEdhistAttendance
     */
    private java.lang.String _szCEdhistAttendance;

    /**
     * Field _szTxtSchoolChangeCmnts
     */
    private java.lang.String _szTxtSchoolChangeCmnts;

    /**
     * Field _szTxtSchoolRecordsCmnts
     */
    private java.lang.String _szTxtSchoolRecordsCmnts;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC17SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEdhist()
    {
        this._has_ulIdEdhist= false;
    } //-- void deleteUlIdEdhist() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     * Returns the value of field 'cIndEdhistTeaSchool'.
     * 
     * @return the value of field 'CIndEdhistTeaSchool'.
     */
    public java.lang.String getCIndEdhistTeaSchool()
    {
        return this._cIndEdhistTeaSchool;
    } //-- java.lang.String getCIndEdhistTeaSchool() 

    /**
     * Returns the value of field 'dtDtEdhistEnrollDate'.
     * 
     * @return the value of field 'DtDtEdhistEnrollDate'.
     */
    public org.exolab.castor.types.Date getDtDtEdhistEnrollDate()
    {
        return this._dtDtEdhistEnrollDate;
    } //-- org.exolab.castor.types.Date getDtDtEdhistEnrollDate() 

    /**
     * Returns the value of field 'dtDtEdhistWithdrawnDate'.
     * 
     * @return the value of field 'DtDtEdhistWithdrawnDate'.
     */
    public org.exolab.castor.types.Date getDtDtEdhistWithdrawnDate()
    {
        return this._dtDtEdhistWithdrawnDate;
    } //-- org.exolab.castor.types.Date getDtDtEdhistWithdrawnDate() 

    /**
     * Returns the value of field 'rbCIndEdhistLevel'.
     * 
     * @return the value of field 'RbCIndEdhistLevel'.
     */
    public java.lang.String getRbCIndEdhistLevel()
    {
        return this._rbCIndEdhistLevel;
    } //-- java.lang.String getRbCIndEdhistLevel() 

    /**
     * Returns the value of field 'rbChildServices'.
     * 
     * @return the value of field 'RbChildServices'.
     */
    public java.lang.String getRbChildServices()
    {
        return this._rbChildServices;
    } //-- java.lang.String getRbChildServices() 

    /**
     * Returns the value of field 'rbIndFosterParent'.
     * 
     * @return the value of field 'RbIndFosterParent'.
     */
    public java.lang.String getRbIndFosterParent()
    {
        return this._rbIndFosterParent;
    } //-- java.lang.String getRbIndFosterParent() 

    /**
     * Returns the value of field 'rbIndOther'.
     * 
     * @return the value of field 'RbIndOther'.
     */
    public java.lang.String getRbIndOther()
    {
        return this._rbIndOther;
    } //-- java.lang.String getRbIndOther() 

    /**
     * Returns the value of field 'rbLegalParent'.
     * 
     * @return the value of field 'RbLegalParent'.
     */
    public java.lang.String getRbLegalParent()
    {
        return this._rbLegalParent;
    } //-- java.lang.String getRbLegalParent() 

    /**
     * Returns the value of field 'rbPrevChildSvc'.
     * 
     * @return the value of field 'RbPrevChildSvc'.
     */
    public java.lang.String getRbPrevChildSvc()
    {
        return this._rbPrevChildSvc;
    } //-- java.lang.String getRbPrevChildSvc() 

    /**
     * Returns the value of field 'rbRecsToBCounty'.
     * 
     * @return the value of field 'RbRecsToBCounty'.
     */
    public java.lang.String getRbRecsToBCounty()
    {
        return this._rbRecsToBCounty;
    } //-- java.lang.String getRbRecsToBCounty() 

    /**
     * Returns the value of field 'rbSchoolChange'.
     * 
     * @return the value of field 'RbSchoolChange'.
     */
    public java.lang.String getRbSchoolChange()
    {
        return this._rbSchoolChange;
    } //-- java.lang.String getRbSchoolChange() 

    /**
     * Returns the value of field 'rbSchoolRecs'.
     * 
     * @return the value of field 'RbSchoolRecs'.
     */
    public java.lang.String getRbSchoolRecs()
    {
        return this._rbSchoolRecs;
    } //-- java.lang.String getRbSchoolRecs() 

    /**
     * Returns the value of field 'rbSpecialEdNeeds'.
     * 
     * @return the value of field 'RbSpecialEdNeeds'.
     */
    public java.lang.String getRbSpecialEdNeeds()
    {
        return this._rbSpecialEdNeeds;
    } //-- java.lang.String getRbSpecialEdNeeds() 

    /**
     * Returns the value of field 'rbSpecialEdSvc'.
     * 
     * @return the value of field 'RbSpecialEdSvc'.
     */
    public java.lang.String getRbSpecialEdSvc()
    {
        return this._rbSpecialEdSvc;
    } //-- java.lang.String getRbSpecialEdSvc() 

    /**
     * Returns the value of field 'szAddrEdhistCity'.
     * 
     * @return the value of field 'SzAddrEdhistCity'.
     */
    public java.lang.String getSzAddrEdhistCity()
    {
        return this._szAddrEdhistCity;
    } //-- java.lang.String getSzAddrEdhistCity() 

    /**
     * Returns the value of field 'szAddrEdhistCnty'.
     * 
     * @return the value of field 'SzAddrEdhistCnty'.
     */
    public java.lang.String getSzAddrEdhistCnty()
    {
        return this._szAddrEdhistCnty;
    } //-- java.lang.String getSzAddrEdhistCnty() 

    /**
     * Returns the value of field 'szAddrEdhistState'.
     * 
     * @return the value of field 'SzAddrEdhistState'.
     */
    public java.lang.String getSzAddrEdhistState()
    {
        return this._szAddrEdhistState;
    } //-- java.lang.String getSzAddrEdhistState() 

    /**
     * Returns the value of field 'szAddrEdhistStreetLn1'.
     * 
     * @return the value of field 'SzAddrEdhistStreetLn1'.
     */
    public java.lang.String getSzAddrEdhistStreetLn1()
    {
        return this._szAddrEdhistStreetLn1;
    } //-- java.lang.String getSzAddrEdhistStreetLn1() 

    /**
     * Returns the value of field 'szAddrEdhistStreetLn2'.
     * 
     * @return the value of field 'SzAddrEdhistStreetLn2'.
     */
    public java.lang.String getSzAddrEdhistStreetLn2()
    {
        return this._szAddrEdhistStreetLn2;
    } //-- java.lang.String getSzAddrEdhistStreetLn2() 

    /**
     * Returns the value of field 'szAddrEdhistZip'.
     * 
     * @return the value of field 'SzAddrEdhistZip'.
     */
    public java.lang.String getSzAddrEdhistZip()
    {
        return this._szAddrEdhistZip;
    } //-- java.lang.String getSzAddrEdhistZip() 

    /**
     * Returns the value of field 'szCEdhistAttendance'.
     * 
     * @return the value of field 'SzCEdhistAttendance'.
     */
    public java.lang.String getSzCEdhistAttendance()
    {
        return this._szCEdhistAttendance;
    } //-- java.lang.String getSzCEdhistAttendance() 

    /**
     * Returns the value of field 'szCEdhistCurrentGradeLevel'.
     * 
     * @return the value of field 'SzCEdhistCurrentGradeLevel'.
     */
    public java.lang.String getSzCEdhistCurrentGradeLevel()
    {
        return this._szCEdhistCurrentGradeLevel;
    } //-- java.lang.String getSzCEdhistCurrentGradeLevel() 

    /**
     * Returns the value of field 'szCdEdhistEnrollGrade'.
     * 
     * @return the value of field 'SzCdEdhistEnrollGrade'.
     */
    public java.lang.String getSzCdEdhistEnrollGrade()
    {
        return this._szCdEdhistEnrollGrade;
    } //-- java.lang.String getSzCdEdhistEnrollGrade() 

    /**
     * Returns the value of field 'szCdEdhistNeeds1'.
     * 
     * @return the value of field 'SzCdEdhistNeeds1'.
     */
    public java.lang.String getSzCdEdhistNeeds1()
    {
        return this._szCdEdhistNeeds1;
    } //-- java.lang.String getSzCdEdhistNeeds1() 

    /**
     * Returns the value of field 'szCdEdhistNeeds10'.
     * 
     * @return the value of field 'SzCdEdhistNeeds10'.
     */
    public java.lang.String getSzCdEdhistNeeds10()
    {
        return this._szCdEdhistNeeds10;
    } //-- java.lang.String getSzCdEdhistNeeds10() 

    /**
     * Returns the value of field 'szCdEdhistNeeds2'.
     * 
     * @return the value of field 'SzCdEdhistNeeds2'.
     */
    public java.lang.String getSzCdEdhistNeeds2()
    {
        return this._szCdEdhistNeeds2;
    } //-- java.lang.String getSzCdEdhistNeeds2() 

    /**
     * Returns the value of field 'szCdEdhistNeeds3'.
     * 
     * @return the value of field 'SzCdEdhistNeeds3'.
     */
    public java.lang.String getSzCdEdhistNeeds3()
    {
        return this._szCdEdhistNeeds3;
    } //-- java.lang.String getSzCdEdhistNeeds3() 

    /**
     * Returns the value of field 'szCdEdhistNeeds4'.
     * 
     * @return the value of field 'SzCdEdhistNeeds4'.
     */
    public java.lang.String getSzCdEdhistNeeds4()
    {
        return this._szCdEdhistNeeds4;
    } //-- java.lang.String getSzCdEdhistNeeds4() 

    /**
     * Returns the value of field 'szCdEdhistNeeds5'.
     * 
     * @return the value of field 'SzCdEdhistNeeds5'.
     */
    public java.lang.String getSzCdEdhistNeeds5()
    {
        return this._szCdEdhistNeeds5;
    } //-- java.lang.String getSzCdEdhistNeeds5() 

    /**
     * Returns the value of field 'szCdEdhistNeeds6'.
     * 
     * @return the value of field 'SzCdEdhistNeeds6'.
     */
    public java.lang.String getSzCdEdhistNeeds6()
    {
        return this._szCdEdhistNeeds6;
    } //-- java.lang.String getSzCdEdhistNeeds6() 

    /**
     * Returns the value of field 'szCdEdhistNeeds7'.
     * 
     * @return the value of field 'SzCdEdhistNeeds7'.
     */
    public java.lang.String getSzCdEdhistNeeds7()
    {
        return this._szCdEdhistNeeds7;
    } //-- java.lang.String getSzCdEdhistNeeds7() 

    /**
     * Returns the value of field 'szCdEdhistNeeds8'.
     * 
     * @return the value of field 'SzCdEdhistNeeds8'.
     */
    public java.lang.String getSzCdEdhistNeeds8()
    {
        return this._szCdEdhistNeeds8;
    } //-- java.lang.String getSzCdEdhistNeeds8() 

    /**
     * Returns the value of field 'szCdEdhistNeeds9'.
     * 
     * @return the value of field 'SzCdEdhistNeeds9'.
     */
    public java.lang.String getSzCdEdhistNeeds9()
    {
        return this._szCdEdhistNeeds9;
    } //-- java.lang.String getSzCdEdhistNeeds9() 

    /**
     * Returns the value of field 'szCdEdhistType'.
     * 
     * @return the value of field 'SzCdEdhistType'.
     */
    public java.lang.String getSzCdEdhistType()
    {
        return this._szCdEdhistType;
    } //-- java.lang.String getSzCdEdhistType() 

    /**
     * Returns the value of field 'szCdEdhistWithdrawnGrade'.
     * 
     * @return the value of field 'SzCdEdhistWithdrawnGrade'.
     */
    public java.lang.String getSzCdEdhistWithdrawnGrade()
    {
        return this._szCdEdhistWithdrawnGrade;
    } //-- java.lang.String getSzCdEdhistWithdrawnGrade() 

    /**
     * Returns the value of field 'szDtRbEdDate'.
     * 
     * @return the value of field 'SzDtRbEdDate'.
     */
    public java.util.Date getSzDtRbEdDate()
    {
        return this._szDtRbEdDate;
    } //-- java.util.Date getSzDtRbEdDate() 

    /**
     * Returns the value of field 'szDtStSupTeamRef'.
     * 
     * @return the value of field 'SzDtStSupTeamRef'.
     */
    public java.util.Date getSzDtStSupTeamRef()
    {
        return this._szDtStSupTeamRef;
    } //-- java.util.Date getSzDtStSupTeamRef() 

    /**
     * Returns the value of field 'szEdHistComments'.
     * 
     * @return the value of field 'SzEdHistComments'.
     */
    public java.lang.String getSzEdHistComments()
    {
        return this._szEdHistComments;
    } //-- java.lang.String getSzEdHistComments() 

    /**
     * Returns the value of field 'szIndEdhistLicense'.
     * 
     * @return the value of field 'SzIndEdhistLicense'.
     */
    public java.lang.String getSzIndEdhistLicense()
    {
        return this._szIndEdhistLicense;
    } //-- java.lang.String getSzIndEdhistLicense() 

    /**
     * Returns the value of field 'szNbrEdhistPhone'.
     * 
     * @return the value of field 'SzNbrEdhistPhone'.
     */
    public java.lang.String getSzNbrEdhistPhone()
    {
        return this._szNbrEdhistPhone;
    } //-- java.lang.String getSzNbrEdhistPhone() 

    /**
     * Returns the value of field 'szNbrEdhistPhoneExt'.
     * 
     * @return the value of field 'SzNbrEdhistPhoneExt'.
     */
    public java.lang.String getSzNbrEdhistPhoneExt()
    {
        return this._szNbrEdhistPhoneExt;
    } //-- java.lang.String getSzNbrEdhistPhoneExt() 

    /**
     * Returns the value of field 'szNmEdhistSchDist'.
     * 
     * @return the value of field 'SzNmEdhistSchDist'.
     */
    public java.lang.String getSzNmEdhistSchDist()
    {
        return this._szNmEdhistSchDist;
    } //-- java.lang.String getSzNmEdhistSchDist() 

    /**
     * Returns the value of field 'szNmEdhistSchool'.
     * 
     * @return the value of field 'SzNmEdhistSchool'.
     */
    public java.lang.String getSzNmEdhistSchool()
    {
        return this._szNmEdhistSchool;
    } //-- java.lang.String getSzNmEdhistSchool() 

    /**
     * Returns the value of field 'szTxtBehaveDisc'.
     * 
     * @return the value of field 'SzTxtBehaveDisc'.
     */
    public java.lang.String getSzTxtBehaveDisc()
    {
        return this._szTxtBehaveDisc;
    } //-- java.lang.String getSzTxtBehaveDisc() 

    /**
     * Returns the value of field 'szTxtChildSvcComments'.
     * 
     * @return the value of field 'SzTxtChildSvcComments'.
     */
    public java.lang.String getSzTxtChildSvcComments()
    {
        return this._szTxtChildSvcComments;
    } //-- java.lang.String getSzTxtChildSvcComments() 

    /**
     * Returns the value of field 'szTxtEdhistAddrCmnt'.
     * 
     * @return the value of field 'SzTxtEdhistAddrCmnt'.
     */
    public java.lang.String getSzTxtEdhistAddrCmnt()
    {
        return this._szTxtEdhistAddrCmnt;
    } //-- java.lang.String getSzTxtEdhistAddrCmnt() 

    /**
     * Returns the value of field 'szTxtSchoolChangeCmnts'.
     * 
     * @return the value of field 'SzTxtSchoolChangeCmnts'.
     */
    public java.lang.String getSzTxtSchoolChangeCmnts()
    {
        return this._szTxtSchoolChangeCmnts;
    } //-- java.lang.String getSzTxtSchoolChangeCmnts() 

    /**
     * Returns the value of field 'szTxtSchoolRecordsCmnts'.
     * 
     * @return the value of field 'SzTxtSchoolRecordsCmnts'.
     */
    public java.lang.String getSzTxtSchoolRecordsCmnts()
    {
        return this._szTxtSchoolRecordsCmnts;
    } //-- java.lang.String getSzTxtSchoolRecordsCmnts() 

    /**
     * Returns the value of field 'szTxtSpecialEdCmnts'.
     * 
     * @return the value of field 'SzTxtSpecialEdCmnts'.
     */
    public java.lang.String getSzTxtSpecialEdCmnts()
    {
        return this._szTxtSpecialEdCmnts;
    } //-- java.lang.String getSzTxtSpecialEdCmnts() 

    /**
     * Returns the value of field 'szTxtSstIepCmnts'.
     * 
     * @return the value of field 'SzTxtSstIepCmnts'.
     */
    public java.lang.String getSzTxtSstIepCmnts()
    {
        return this._szTxtSstIepCmnts;
    } //-- java.lang.String getSzTxtSstIepCmnts() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'txtSurrogateParent'.
     * 
     * @return the value of field 'TxtSurrogateParent'.
     */
    public java.lang.String getTxtSurrogateParent()
    {
        return this._txtSurrogateParent;
    } //-- java.lang.String getTxtSurrogateParent() 

    /**
     * Returns the value of field 'ulIdEdhist'.
     * 
     * @return the value of field 'UlIdEdhist'.
     */
    public int getUlIdEdhist()
    {
        return this._ulIdEdhist;
    } //-- int getUlIdEdhist() 

    /**
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Method hasUlIdEdhist
     * 
     * 
     * 
     * @return true if at least one UlIdEdhist has been added
     */
    public boolean hasUlIdEdhist()
    {
        return this._has_ulIdEdhist;
    } //-- boolean hasUlIdEdhist() 

    /**
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

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
     * Sets the value of field 'cIndEdhistTeaSchool'.
     * 
     * @param cIndEdhistTeaSchool the value of field
     * 'cIndEdhistTeaSchool'.
     */
    public void setCIndEdhistTeaSchool(java.lang.String cIndEdhistTeaSchool)
    {
        this._cIndEdhistTeaSchool = cIndEdhistTeaSchool;
    } //-- void setCIndEdhistTeaSchool(java.lang.String) 

    /**
     * Sets the value of field 'dtDtEdhistEnrollDate'.
     * 
     * @param dtDtEdhistEnrollDate the value of field
     * 'dtDtEdhistEnrollDate'.
     */
    public void setDtDtEdhistEnrollDate(org.exolab.castor.types.Date dtDtEdhistEnrollDate)
    {
        this._dtDtEdhistEnrollDate = dtDtEdhistEnrollDate;
    } //-- void setDtDtEdhistEnrollDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEdhistWithdrawnDate'.
     * 
     * @param dtDtEdhistWithdrawnDate the value of field
     * 'dtDtEdhistWithdrawnDate'.
     */
    public void setDtDtEdhistWithdrawnDate(org.exolab.castor.types.Date dtDtEdhistWithdrawnDate)
    {
        this._dtDtEdhistWithdrawnDate = dtDtEdhistWithdrawnDate;
    } //-- void setDtDtEdhistWithdrawnDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'rbCIndEdhistLevel'.
     * 
     * @param rbCIndEdhistLevel the value of field
     * 'rbCIndEdhistLevel'.
     */
    public void setRbCIndEdhistLevel(java.lang.String rbCIndEdhistLevel)
    {
        this._rbCIndEdhistLevel = rbCIndEdhistLevel;
    } //-- void setRbCIndEdhistLevel(java.lang.String) 

    /**
     * Sets the value of field 'rbChildServices'.
     * 
     * @param rbChildServices the value of field 'rbChildServices'.
     */
    public void setRbChildServices(java.lang.String rbChildServices)
    {
        this._rbChildServices = rbChildServices;
    } //-- void setRbChildServices(java.lang.String) 

    /**
     * Sets the value of field 'rbIndFosterParent'.
     * 
     * @param rbIndFosterParent the value of field
     * 'rbIndFosterParent'.
     */
    public void setRbIndFosterParent(java.lang.String rbIndFosterParent)
    {
        this._rbIndFosterParent = rbIndFosterParent;
    } //-- void setRbIndFosterParent(java.lang.String) 

    /**
     * Sets the value of field 'rbIndOther'.
     * 
     * @param rbIndOther the value of field 'rbIndOther'.
     */
    public void setRbIndOther(java.lang.String rbIndOther)
    {
        this._rbIndOther = rbIndOther;
    } //-- void setRbIndOther(java.lang.String) 

    /**
     * Sets the value of field 'rbLegalParent'.
     * 
     * @param rbLegalParent the value of field 'rbLegalParent'.
     */
    public void setRbLegalParent(java.lang.String rbLegalParent)
    {
        this._rbLegalParent = rbLegalParent;
    } //-- void setRbLegalParent(java.lang.String) 

    /**
     * Sets the value of field 'rbPrevChildSvc'.
     * 
     * @param rbPrevChildSvc the value of field 'rbPrevChildSvc'.
     */
    public void setRbPrevChildSvc(java.lang.String rbPrevChildSvc)
    {
        this._rbPrevChildSvc = rbPrevChildSvc;
    } //-- void setRbPrevChildSvc(java.lang.String) 

    /**
     * Sets the value of field 'rbRecsToBCounty'.
     * 
     * @param rbRecsToBCounty the value of field 'rbRecsToBCounty'.
     */
    public void setRbRecsToBCounty(java.lang.String rbRecsToBCounty)
    {
        this._rbRecsToBCounty = rbRecsToBCounty;
    } //-- void setRbRecsToBCounty(java.lang.String) 

    /**
     * Sets the value of field 'rbSchoolChange'.
     * 
     * @param rbSchoolChange the value of field 'rbSchoolChange'.
     */
    public void setRbSchoolChange(java.lang.String rbSchoolChange)
    {
        this._rbSchoolChange = rbSchoolChange;
    } //-- void setRbSchoolChange(java.lang.String) 

    /**
     * Sets the value of field 'rbSchoolRecs'.
     * 
     * @param rbSchoolRecs the value of field 'rbSchoolRecs'.
     */
    public void setRbSchoolRecs(java.lang.String rbSchoolRecs)
    {
        this._rbSchoolRecs = rbSchoolRecs;
    } //-- void setRbSchoolRecs(java.lang.String) 

    /**
     * Sets the value of field 'rbSpecialEdNeeds'.
     * 
     * @param rbSpecialEdNeeds the value of field 'rbSpecialEdNeeds'
     */
    public void setRbSpecialEdNeeds(java.lang.String rbSpecialEdNeeds)
    {
        this._rbSpecialEdNeeds = rbSpecialEdNeeds;
    } //-- void setRbSpecialEdNeeds(java.lang.String) 

    /**
     * Sets the value of field 'rbSpecialEdSvc'.
     * 
     * @param rbSpecialEdSvc the value of field 'rbSpecialEdSvc'.
     */
    public void setRbSpecialEdSvc(java.lang.String rbSpecialEdSvc)
    {
        this._rbSpecialEdSvc = rbSpecialEdSvc;
    } //-- void setRbSpecialEdSvc(java.lang.String) 

    /**
     * Sets the value of field 'szAddrEdhistCity'.
     * 
     * @param szAddrEdhistCity the value of field 'szAddrEdhistCity'
     */
    public void setSzAddrEdhistCity(java.lang.String szAddrEdhistCity)
    {
        this._szAddrEdhistCity = szAddrEdhistCity;
    } //-- void setSzAddrEdhistCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrEdhistCnty'.
     * 
     * @param szAddrEdhistCnty the value of field 'szAddrEdhistCnty'
     */
    public void setSzAddrEdhistCnty(java.lang.String szAddrEdhistCnty)
    {
        this._szAddrEdhistCnty = szAddrEdhistCnty;
    } //-- void setSzAddrEdhistCnty(java.lang.String) 

    /**
     * Sets the value of field 'szAddrEdhistState'.
     * 
     * @param szAddrEdhistState the value of field
     * 'szAddrEdhistState'.
     */
    public void setSzAddrEdhistState(java.lang.String szAddrEdhistState)
    {
        this._szAddrEdhistState = szAddrEdhistState;
    } //-- void setSzAddrEdhistState(java.lang.String) 

    /**
     * Sets the value of field 'szAddrEdhistStreetLn1'.
     * 
     * @param szAddrEdhistStreetLn1 the value of field
     * 'szAddrEdhistStreetLn1'.
     */
    public void setSzAddrEdhistStreetLn1(java.lang.String szAddrEdhistStreetLn1)
    {
        this._szAddrEdhistStreetLn1 = szAddrEdhistStreetLn1;
    } //-- void setSzAddrEdhistStreetLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrEdhistStreetLn2'.
     * 
     * @param szAddrEdhistStreetLn2 the value of field
     * 'szAddrEdhistStreetLn2'.
     */
    public void setSzAddrEdhistStreetLn2(java.lang.String szAddrEdhistStreetLn2)
    {
        this._szAddrEdhistStreetLn2 = szAddrEdhistStreetLn2;
    } //-- void setSzAddrEdhistStreetLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrEdhistZip'.
     * 
     * @param szAddrEdhistZip the value of field 'szAddrEdhistZip'.
     */
    public void setSzAddrEdhistZip(java.lang.String szAddrEdhistZip)
    {
        this._szAddrEdhistZip = szAddrEdhistZip;
    } //-- void setSzAddrEdhistZip(java.lang.String) 

    /**
     * Sets the value of field 'szCEdhistAttendance'.
     * 
     * @param szCEdhistAttendance the value of field
     * 'szCEdhistAttendance'.
     */
    public void setSzCEdhistAttendance(java.lang.String szCEdhistAttendance)
    {
        this._szCEdhistAttendance = szCEdhistAttendance;
    } //-- void setSzCEdhistAttendance(java.lang.String) 

    /**
     * Sets the value of field 'szCEdhistCurrentGradeLevel'.
     * 
     * @param szCEdhistCurrentGradeLevel the value of field
     * 'szCEdhistCurrentGradeLevel'.
     */
    public void setSzCEdhistCurrentGradeLevel(java.lang.String szCEdhistCurrentGradeLevel)
    {
        this._szCEdhistCurrentGradeLevel = szCEdhistCurrentGradeLevel;
    } //-- void setSzCEdhistCurrentGradeLevel(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistEnrollGrade'.
     * 
     * @param szCdEdhistEnrollGrade the value of field
     * 'szCdEdhistEnrollGrade'.
     */
    public void setSzCdEdhistEnrollGrade(java.lang.String szCdEdhistEnrollGrade)
    {
        this._szCdEdhistEnrollGrade = szCdEdhistEnrollGrade;
    } //-- void setSzCdEdhistEnrollGrade(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds1'.
     * 
     * @param szCdEdhistNeeds1 the value of field 'szCdEdhistNeeds1'
     */
    public void setSzCdEdhistNeeds1(java.lang.String szCdEdhistNeeds1)
    {
        this._szCdEdhistNeeds1 = szCdEdhistNeeds1;
    } //-- void setSzCdEdhistNeeds1(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds10'.
     * 
     * @param szCdEdhistNeeds10 the value of field
     * 'szCdEdhistNeeds10'.
     */
    public void setSzCdEdhistNeeds10(java.lang.String szCdEdhistNeeds10)
    {
        this._szCdEdhistNeeds10 = szCdEdhistNeeds10;
    } //-- void setSzCdEdhistNeeds10(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds2'.
     * 
     * @param szCdEdhistNeeds2 the value of field 'szCdEdhistNeeds2'
     */
    public void setSzCdEdhistNeeds2(java.lang.String szCdEdhistNeeds2)
    {
        this._szCdEdhistNeeds2 = szCdEdhistNeeds2;
    } //-- void setSzCdEdhistNeeds2(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds3'.
     * 
     * @param szCdEdhistNeeds3 the value of field 'szCdEdhistNeeds3'
     */
    public void setSzCdEdhistNeeds3(java.lang.String szCdEdhistNeeds3)
    {
        this._szCdEdhistNeeds3 = szCdEdhistNeeds3;
    } //-- void setSzCdEdhistNeeds3(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds4'.
     * 
     * @param szCdEdhistNeeds4 the value of field 'szCdEdhistNeeds4'
     */
    public void setSzCdEdhistNeeds4(java.lang.String szCdEdhistNeeds4)
    {
        this._szCdEdhistNeeds4 = szCdEdhistNeeds4;
    } //-- void setSzCdEdhistNeeds4(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds5'.
     * 
     * @param szCdEdhistNeeds5 the value of field 'szCdEdhistNeeds5'
     */
    public void setSzCdEdhistNeeds5(java.lang.String szCdEdhistNeeds5)
    {
        this._szCdEdhistNeeds5 = szCdEdhistNeeds5;
    } //-- void setSzCdEdhistNeeds5(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds6'.
     * 
     * @param szCdEdhistNeeds6 the value of field 'szCdEdhistNeeds6'
     */
    public void setSzCdEdhistNeeds6(java.lang.String szCdEdhistNeeds6)
    {
        this._szCdEdhistNeeds6 = szCdEdhistNeeds6;
    } //-- void setSzCdEdhistNeeds6(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds7'.
     * 
     * @param szCdEdhistNeeds7 the value of field 'szCdEdhistNeeds7'
     */
    public void setSzCdEdhistNeeds7(java.lang.String szCdEdhistNeeds7)
    {
        this._szCdEdhistNeeds7 = szCdEdhistNeeds7;
    } //-- void setSzCdEdhistNeeds7(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds8'.
     * 
     * @param szCdEdhistNeeds8 the value of field 'szCdEdhistNeeds8'
     */
    public void setSzCdEdhistNeeds8(java.lang.String szCdEdhistNeeds8)
    {
        this._szCdEdhistNeeds8 = szCdEdhistNeeds8;
    } //-- void setSzCdEdhistNeeds8(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistNeeds9'.
     * 
     * @param szCdEdhistNeeds9 the value of field 'szCdEdhistNeeds9'
     */
    public void setSzCdEdhistNeeds9(java.lang.String szCdEdhistNeeds9)
    {
        this._szCdEdhistNeeds9 = szCdEdhistNeeds9;
    } //-- void setSzCdEdhistNeeds9(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistType'.
     * 
     * @param szCdEdhistType the value of field 'szCdEdhistType'.
     */
    public void setSzCdEdhistType(java.lang.String szCdEdhistType)
    {
        this._szCdEdhistType = szCdEdhistType;
    } //-- void setSzCdEdhistType(java.lang.String) 

    /**
     * Sets the value of field 'szCdEdhistWithdrawnGrade'.
     * 
     * @param szCdEdhistWithdrawnGrade the value of field
     * 'szCdEdhistWithdrawnGrade'.
     */
    public void setSzCdEdhistWithdrawnGrade(java.lang.String szCdEdhistWithdrawnGrade)
    {
        this._szCdEdhistWithdrawnGrade = szCdEdhistWithdrawnGrade;
    } //-- void setSzCdEdhistWithdrawnGrade(java.lang.String) 

    /**
     * Sets the value of field 'szDtRbEdDate'.
     * 
     * @param szDtRbEdDate the value of field 'szDtRbEdDate'.
     */
    public void setSzDtRbEdDate(java.util.Date szDtRbEdDate)
    {
        this._szDtRbEdDate = szDtRbEdDate;
    } //-- void setSzDtRbEdDate(java.util.Date) 

    /**
     * Sets the value of field 'szDtStSupTeamRef'.
     * 
     * @param szDtStSupTeamRef the value of field 'szDtStSupTeamRef'
     */
    public void setSzDtStSupTeamRef(java.util.Date szDtStSupTeamRef)
    {
        this._szDtStSupTeamRef = szDtStSupTeamRef;
    } //-- void setSzDtStSupTeamRef(java.util.Date) 

    /**
     * Sets the value of field 'szEdHistComments'.
     * 
     * @param szEdHistComments the value of field 'szEdHistComments'
     */
    public void setSzEdHistComments(java.lang.String szEdHistComments)
    {
        this._szEdHistComments = szEdHistComments;
    } //-- void setSzEdHistComments(java.lang.String) 

    /**
     * Sets the value of field 'szIndEdhistLicense'.
     * 
     * @param szIndEdhistLicense the value of field
     * 'szIndEdhistLicense'.
     */
    public void setSzIndEdhistLicense(java.lang.String szIndEdhistLicense)
    {
        this._szIndEdhistLicense = szIndEdhistLicense;
    } //-- void setSzIndEdhistLicense(java.lang.String) 

    /**
     * Sets the value of field 'szNbrEdhistPhone'.
     * 
     * @param szNbrEdhistPhone the value of field 'szNbrEdhistPhone'
     */
    public void setSzNbrEdhistPhone(java.lang.String szNbrEdhistPhone)
    {
        this._szNbrEdhistPhone = szNbrEdhistPhone;
    } //-- void setSzNbrEdhistPhone(java.lang.String) 

    /**
     * Sets the value of field 'szNbrEdhistPhoneExt'.
     * 
     * @param szNbrEdhistPhoneExt the value of field
     * 'szNbrEdhistPhoneExt'.
     */
    public void setSzNbrEdhistPhoneExt(java.lang.String szNbrEdhistPhoneExt)
    {
        this._szNbrEdhistPhoneExt = szNbrEdhistPhoneExt;
    } //-- void setSzNbrEdhistPhoneExt(java.lang.String) 

    /**
     * Sets the value of field 'szNmEdhistSchDist'.
     * 
     * @param szNmEdhistSchDist the value of field
     * 'szNmEdhistSchDist'.
     */
    public void setSzNmEdhistSchDist(java.lang.String szNmEdhistSchDist)
    {
        this._szNmEdhistSchDist = szNmEdhistSchDist;
    } //-- void setSzNmEdhistSchDist(java.lang.String) 

    /**
     * Sets the value of field 'szNmEdhistSchool'.
     * 
     * @param szNmEdhistSchool the value of field 'szNmEdhistSchool'
     */
    public void setSzNmEdhistSchool(java.lang.String szNmEdhistSchool)
    {
        this._szNmEdhistSchool = szNmEdhistSchool;
    } //-- void setSzNmEdhistSchool(java.lang.String) 

    /**
     * Sets the value of field 'szTxtBehaveDisc'.
     * 
     * @param szTxtBehaveDisc the value of field 'szTxtBehaveDisc'.
     */
    public void setSzTxtBehaveDisc(java.lang.String szTxtBehaveDisc)
    {
        this._szTxtBehaveDisc = szTxtBehaveDisc;
    } //-- void setSzTxtBehaveDisc(java.lang.String) 

    /**
     * Sets the value of field 'szTxtChildSvcComments'.
     * 
     * @param szTxtChildSvcComments the value of field
     * 'szTxtChildSvcComments'.
     */
    public void setSzTxtChildSvcComments(java.lang.String szTxtChildSvcComments)
    {
        this._szTxtChildSvcComments = szTxtChildSvcComments;
    } //-- void setSzTxtChildSvcComments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEdhistAddrCmnt'.
     * 
     * @param szTxtEdhistAddrCmnt the value of field
     * 'szTxtEdhistAddrCmnt'.
     */
    public void setSzTxtEdhistAddrCmnt(java.lang.String szTxtEdhistAddrCmnt)
    {
        this._szTxtEdhistAddrCmnt = szTxtEdhistAddrCmnt;
    } //-- void setSzTxtEdhistAddrCmnt(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSchoolChangeCmnts'.
     * 
     * @param szTxtSchoolChangeCmnts the value of field
     * 'szTxtSchoolChangeCmnts'.
     */
    public void setSzTxtSchoolChangeCmnts(java.lang.String szTxtSchoolChangeCmnts)
    {
        this._szTxtSchoolChangeCmnts = szTxtSchoolChangeCmnts;
    } //-- void setSzTxtSchoolChangeCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSchoolRecordsCmnts'.
     * 
     * @param szTxtSchoolRecordsCmnts the value of field
     * 'szTxtSchoolRecordsCmnts'.
     */
    public void setSzTxtSchoolRecordsCmnts(java.lang.String szTxtSchoolRecordsCmnts)
    {
        this._szTxtSchoolRecordsCmnts = szTxtSchoolRecordsCmnts;
    } //-- void setSzTxtSchoolRecordsCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSpecialEdCmnts'.
     * 
     * @param szTxtSpecialEdCmnts the value of field
     * 'szTxtSpecialEdCmnts'.
     */
    public void setSzTxtSpecialEdCmnts(java.lang.String szTxtSpecialEdCmnts)
    {
        this._szTxtSpecialEdCmnts = szTxtSpecialEdCmnts;
    } //-- void setSzTxtSpecialEdCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSstIepCmnts'.
     * 
     * @param szTxtSstIepCmnts the value of field 'szTxtSstIepCmnts'
     */
    public void setSzTxtSstIepCmnts(java.lang.String szTxtSstIepCmnts)
    {
        this._szTxtSstIepCmnts = szTxtSstIepCmnts;
    } //-- void setSzTxtSstIepCmnts(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'txtSurrogateParent'.
     * 
     * @param txtSurrogateParent the value of field
     * 'txtSurrogateParent'.
     */
    public void setTxtSurrogateParent(java.lang.String txtSurrogateParent)
    {
        this._txtSurrogateParent = txtSurrogateParent;
    } //-- void setTxtSurrogateParent(java.lang.String) 

    /**
     * Sets the value of field 'ulIdEdhist'.
     * 
     * @param ulIdEdhist the value of field 'ulIdEdhist'.
     */
    public void setUlIdEdhist(int ulIdEdhist)
    {
        this._ulIdEdhist = ulIdEdhist;
        this._has_ulIdEdhist = true;
    } //-- void setUlIdEdhist(int) 

    /**
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00 unmarshal(java.io.Reader) 

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
