-- All changes for version 2.4 of SHINES

create user ors identified by a1b2c3
default tablespace data01;

alter user ors quota unlimited on data01;
alter user ors quota unlimited on index01;

-- below may be resource_role on some databases
grant resource to ors;
grant connect to ors;
grant create any synonym to ors;

-- 
-- TABLE: ORS.ADVERSE_ACTION 
--

CREATE TABLE ORS.ADVERSE_ACTION(
    AAID                NUMBER(4, 0)     NOT NULL,
    FACID               VARCHAR2(16),
    TRACKID             VARCHAR2(4),
    AASRC               VARCHAR2(3),
    SRCOTHER            VARCHAR2(100),
    EVENTID             VARCHAR2(50),
    FUREQ               VARCHAR2(1),
    AASRCDATE           DATE,
    PRTYPEID            VARCHAR2(50),
    AALTRDATE           DATE,
    GRLTRDATE           DATE,
    EXT                 VARCHAR2(1),
    EXTDATE             DATE,
    EXTDAYS             NUMBER(4, 0),
    LETTERCOMMENTS      VARCHAR2(255),
    MONREQ              VARCHAR2(1),
    MONITSRTDATE        DATE,
    MONVISITS           VARCHAR2(50),
    SVYNOTES            CLOB,
    REVOUTCOME          VARCHAR2(250),
    PREHEAROUTCOME      VARCHAR2(25),
    HEAROUTCOME         VARCHAR2(25),
    HEARINGDEC          VARCHAR2(25),
    ATTNY               VARCHAR2(50),
    NOTES               CLOB,
    COMPLDATE           DATE,
    UNLOUTCOME          VARCHAR2(25),
    FINALOUTCOME        VARCHAR2(25),
    LEGLTRREQUEST       VARCHAR2(3),
    LEGNOTLTRDATE       DATE,
    LEGDATEHEARREQ      DATE,
    PREHEARCONFDATE1    DATE,
    LEGDECISIONDATE     DATE,
    CO                  VARCHAR2(1),
    CA                  VARCHAR2(1),
    SA                  VARCHAR2(1),
    ALJ                 VARCHAR2(1),
    CODATE              DATE,
    COEXPDATE           DATE,
    LEGCOWO             VARCHAR2(1),
    LEGCOTERMS          VARCHAR2(255),
    FINEEFF             DATE,
    ORIGINALFINE        NUMBER(13, 2),
    AMTFINE             NUMBER(13, 2),
    PMTTERMS            NUMBER(13, 2),
    DUEDATE             VARCHAR2(50),
    ACKNPYMLTR          VARCHAR2(1),
    APPEAL              VARCHAR2(1),
    APPEALDHR           VARCHAR2(1),
    APPEALCOURT         VARCHAR2(1),
    APPEALORS           VARCHAR2(1),
    APPEALRRSP          VARCHAR2(1),
    APPEALOUTCOME       VARCHAR2(50),
    APPEALDATE          DATE,
    LEGNOTES            CLOB,
    DT_LAST_UPDATE      DATE             NOT NULL,
    CONSTRAINT PK_ADVERSE_ACTION PRIMARY KEY (AAID)
    USING INDEX
TABLESPACE INDEX01
)
TABLESPACE DATA01
;



GRANT DELETE ON ORS.ADVERSE_ACTION TO CAPS
;
GRANT INSERT ON ORS.ADVERSE_ACTION TO CAPS
;
GRANT SELECT ON ORS.ADVERSE_ACTION TO CAPS
;
GRANT UPDATE ON ORS.ADVERSE_ACTION TO CAPS
;
GRANT DELETE ON ORS.ADVERSE_ACTION TO CAPSON
;
GRANT INSERT ON ORS.ADVERSE_ACTION TO CAPSON
;
GRANT SELECT ON ORS.ADVERSE_ACTION TO CAPSON
;
GRANT UPDATE ON ORS.ADVERSE_ACTION TO CAPSON
;
GRANT DELETE ON ORS.ADVERSE_ACTION TO CAPSBAT
;
GRANT INSERT ON ORS.ADVERSE_ACTION TO CAPSBAT
;
GRANT SELECT ON ORS.ADVERSE_ACTION TO CAPSBAT
;
GRANT UPDATE ON ORS.ADVERSE_ACTION TO CAPSBAT
;
GRANT SELECT ON ORS.ADVERSE_ACTION TO OPERATOR
;

-- 
-- TABLE: ORS.CINTAKE 
--

CREATE TABLE ORS.CINTAKE(
    INTAKEID              VARCHAR2(10)    NOT NULL,
    FACID                 VARCHAR2(16),
    FACNAME               VARCHAR2(50),
    FACTYPE               VARCHAR2(4),
    CMPTYPE               VARCHAR2(2),
    REFNUM                VARCHAR2(3),
    HFDID                 VARCHAR2(16),
    JCAHO                 VARCHAR2(1),
    ROPHON                DATE,
    STATUS                VARCHAR2(1),
    CMPLNAME              VARCHAR2(36),
    CMPLSTATE             VARCHAR2(2),
    ANONYM                VARCHAR2(1),
    CMPLADDR              VARCHAR2(40),
    CMPLEXTA              VARCHAR2(40),
    CITY                  VARCHAR2(16),
    ZIP                   VARCHAR2(5),
    PHONEDAY              VARCHAR2(13),
    PHONEEVE              VARCHAR2(13),
    RECVDATE              DATE,
    RECVTIME              VARCHAR2(8),
    CMPMODE               VARCHAR2(1),
    CMPSRC                VARCHAR2(2),
    CMPSRC2               VARCHAR2(2),
    CMPSRC3               VARCHAR2(2),
    CMPSRC4               VARCHAR2(2),
    REG_OFF               DATE,
    ASSNDATE              DATE,
    INVTDATE              DATE,
    CMPPRI                VARCHAR2(1),
    REPTDT                DATE,
    OVERFIND              VARCHAR2(1),
    ACK_DATE              DATE,
    DROFORWD              DATE,
    DTOTYPE               DATE,
    JCINVEST              VARCHAR2(20),
    RELATIONSHIP          VARCHAR2(50),
    RELEASABLE            VARCHAR2(1),
    DEFICIENCIES          VARCHAR2(1),
    INVESTID              CHAR(6),
    ORIGIN                CHAR(4),
    DUEDATE               DATE,
    FOASSIGN              CHAR(4),
    STACTIONS             VARCHAR2(36),
    CLOSED                DATE,
    CLOSREASON            VARCHAR2(15),
    INCRECVTIME           VARCHAR2(8),
    INCRECVDATE           DATE,
    EXIT_DATE             DATE,
    SORTDATE              DATE,
    ISFOLLOWUP            NUMBER(1, 0),
    CMPNTID               CHAR(6),
    UPDATEDT              DATE,
    EMPLOYEEID            VARCHAR2(16),
    CIS                   VARCHAR2(10),
    STATECOMPID           VARCHAR2(16),
    PHONEEXT              VARCHAR2(5),
    PHONEEVEEXT           VARCHAR2(5),
    ISEMTALA              VARCHAR2(1),
    ROAPPDATE             DATE,
    EMERGTYPE1            VARCHAR2(2),
    EMERGTYPE2            VARCHAR2(2),
    EMERGTYPE3            VARCHAR2(2),
    EMERGTYPE4            VARCHAR2(2),
    EMERGTYPE5            VARCHAR2(2),
    EMERGTYPE6            VARCHAR2(2),
    EMERGTYPE7            VARCHAR2(2),
    RESOLUTION            VARCHAR2(2),
    SANOTEPAD             CLOB,
    NOTEPAD               CLOB,
    IS_RES_SECL           VARCHAR2(1),
    STAFFNM               VARCHAR2(40),
    ROSAUSER              CHAR(1),
    RO_RECEIPT            DATE,
    FINAL_ACTION          DATE,
    PASTNONCOMP           NUMBER(1, 0),
    EXT_CTRL_NUM          VARCHAR2(12),
    FORWARDED             VARCHAR2(1),
    ISCMPSENT             NUMBER(1, 0),
    REQROAPPR             NUMBER(1, 0),
    ADDDATE               DATE,
    REQRO_EMTALA          NUMBER(1, 0),
    CMPTYPEEXT            CHAR(1),
    NUMDAYSTOINV          NUMBER(4, 0),
    EMTALARESPONSE        CHAR(2),
    PRIORITY              VARCHAR2(6),
    RECVSTART             DATE,
    RECVTIMESTART         VARCHAR2(8),
    EMTALARESPDT          DATE,
    INCSHIFT              VARCHAR2(25),
    INCAMPM               CHAR(2),
    DEEMED                NUMBER(1, 0),
    RECVENDOPEN           NUMBER(1, 0),
    DEEMRESPONSE          CHAR(2),
    DEEMRESPDT            DATE,
    DEEMREQDT             DATE,
    INVNOTES              CLOB,
    ISDELETE              NUMBER(1, 0),
    ISSENT_CSP            NUMBER(1, 0),
    UPLOAD_ADD_DT_CSP     DATE,
    UPLOAD_UPDT_DT_CSP    DATE,
    UPLOADACCEPTED        NUMBER(1, 0),
    REQRO_STD_F           NUMBER(1, 0),
    STD_F_REQDT           DATE,
    STD_F_RESPONSE        VARCHAR2(2),
    STD_F_RESPDT          DATE,
    L10                   VARCHAR2(1),
    CONOTEPAD             CLOB,
    CBER_ID               VARCHAR2(6),
    ISREFERAO             VARCHAR2(1),
    FORWARDCODT           DATE,
    FORWARDCO             VARCHAR2(1),
    LABCERT               VARCHAR2(2),
    LABCLASS              VARCHAR2(2),
    LABROAPPTYPE          VARCHAR2(1),
    DT_LAST_UPDATE        DATE            NOT NULL,
    CONSTRAINT PK_CINTAKE PRIMARY KEY (INTAKEID)
    USING INDEX
TABLESPACE INDEX01
)
TABLESPACE DATA01
;



GRANT DELETE ON ORS.CINTAKE TO CAPS
;
GRANT INSERT ON ORS.CINTAKE TO CAPS
;
GRANT SELECT ON ORS.CINTAKE TO CAPS
;
GRANT UPDATE ON ORS.CINTAKE TO CAPS
;
GRANT DELETE ON ORS.CINTAKE TO CAPSON
;
GRANT INSERT ON ORS.CINTAKE TO CAPSON
;
GRANT SELECT ON ORS.CINTAKE TO CAPSON
;
GRANT UPDATE ON ORS.CINTAKE TO CAPSON
;
GRANT DELETE ON ORS.CINTAKE TO CAPSBAT
;
GRANT INSERT ON ORS.CINTAKE TO CAPSBAT
;
GRANT SELECT ON ORS.CINTAKE TO CAPSBAT
;
GRANT UPDATE ON ORS.CINTAKE TO CAPSBAT
;
GRANT SELECT ON ORS.CINTAKE TO OPERATOR
;

-- 
-- TABLE: ORS.CINTAKERESP 
--

CREATE TABLE ORS.CINTAKERESP(
    INTAKEID            VARCHAR2(10)     NOT NULL,
    EMPLOYEEID          VARCHAR2(16)     NOT NULL,
    STAFFNM             VARCHAR2(40),
    SAROUSER            CHAR(1)          NOT NULL,
    MSGID               NUMBER(10, 0),
    MYTASKCOMPLETEDT    DATE,
    ISPRIMARY           NUMBER(1, 0),
    EVENTTYPE           CHAR(2),
    DT_LAST_UPDATE      DATE             NOT NULL,
    CONSTRAINT PK_CINTAKERESP PRIMARY KEY (EMPLOYEEID, SAROUSER, INTAKEID)
    USING INDEX
TABLESPACE INDEX01
)
TABLESPACE DATA01
;



GRANT DELETE ON ORS.CINTAKERESP TO CAPS
;
GRANT INSERT ON ORS.CINTAKERESP TO CAPS
;
GRANT SELECT ON ORS.CINTAKERESP TO CAPS
;
GRANT UPDATE ON ORS.CINTAKERESP TO CAPS
;
GRANT DELETE ON ORS.CINTAKERESP TO CAPSON
;
GRANT INSERT ON ORS.CINTAKERESP TO CAPSON
;
GRANT SELECT ON ORS.CINTAKERESP TO CAPSON
;
GRANT UPDATE ON ORS.CINTAKERESP TO CAPSON
;
GRANT DELETE ON ORS.CINTAKERESP TO CAPSBAT
;
GRANT INSERT ON ORS.CINTAKERESP TO CAPSBAT
;
GRANT SELECT ON ORS.CINTAKERESP TO CAPSBAT
;
GRANT UPDATE ON ORS.CINTAKERESP TO CAPSBAT
;
GRANT SELECT ON ORS.CINTAKERESP TO OPERATOR
;

-- 
-- TABLE: ORS.COMP_ALG 
--

CREATE TABLE ORS.COMP_ALG(
    INTAKEID          VARCHAR2(10)    NOT NULL,
    ALGID             VARCHAR2(3)     NOT NULL,
    A_TYPE            VARCHAR2(2),
    A_PRI             VARCHAR2(1),
    A_FIND            VARCHAR2(1),
    A_DEF             VARCHAR2(1),
    A_HCFA            VARCHAR2(1),
    PRIORDESC         VARCHAR2(16),
    TYPEDESC          VARCHAR2(50),
    FINDDESC          VARCHAR2(50),
    A_SUB             VARCHAR2(2),
    SUBDESC           VARCHAR2(50),
    UPDATEDT          DATE,
    EMPLOYEEID        VARCHAR2(16),
    A_SERIOUS         VARCHAR2(2),
    SERIOUSDESC       VARCHAR2(50),
    ISEMTALA          VARCHAR2(1),
    IS_RES_SECL       VARCHAR2(1),
    ALGFINDM          CLOB,
    SUMMPVM           CLOB,
    CDETAILM          CLOB,
    DT_LAST_UPDATE    DATE            NOT NULL,
    CONSTRAINT PK_COMP_ALG PRIMARY KEY (INTAKEID, ALGID)
    USING INDEX
TABLESPACE INDEX01
)
TABLESPACE DATA01
;



GRANT DELETE ON ORS.COMP_ALG TO CAPS
;
GRANT INSERT ON ORS.COMP_ALG TO CAPS
;
GRANT SELECT ON ORS.COMP_ALG TO CAPS
;
GRANT UPDATE ON ORS.COMP_ALG TO CAPS
;
GRANT DELETE ON ORS.COMP_ALG TO CAPSON
;
GRANT INSERT ON ORS.COMP_ALG TO CAPSON
;
GRANT SELECT ON ORS.COMP_ALG TO CAPSON
;
GRANT UPDATE ON ORS.COMP_ALG TO CAPSON
;
GRANT DELETE ON ORS.COMP_ALG TO CAPSBAT
;
GRANT INSERT ON ORS.COMP_ALG TO CAPSBAT
;
GRANT SELECT ON ORS.COMP_ALG TO CAPSBAT
;
GRANT UPDATE ON ORS.COMP_ALG TO CAPSBAT
;
GRANT SELECT ON ORS.COMP_ALG TO OPERATOR
;

-- 
-- TABLE: ORS.FACILITY 
--

CREATE TABLE ORS.FACILITY(
    FACILITY_INTERNAL_ID    NUMBER(10, 0)    NOT NULL,
    FACID                   VARCHAR2(16)     NOT NULL,
    LOGIN_ID                VARCHAR2(16)     NOT NULL,
    NAME                    VARCHAR2(50)     NOT NULL,
    ADDRESS                 VARCHAR2(50)     NOT NULL,
    FAC_CITY                VARCHAR2(20)     NOT NULL,
    FAC_ST                  VARCHAR2(2)      NOT NULL,
    FAC_ZIP                 VARCHAR2(11)     NOT NULL,
    FAC_CNTCT               VARCHAR2(50),
    TELEPHONE               VARCHAR2(13),
    FAC_ADDR_2              VARCHAR2(50),
    MCAID_ID                VARCHAR2(15),
    MCARE_ID                VARCHAR2(12),
    FAC_EXTENSION           VARCHAR2(5),
    ADMSAL                  VARCHAR2(3),
    ADMFIRST                VARCHAR2(20),
    ADMLAST                 VARCHAR2(30),
    ADMTITLE                VARCHAR2(12),
    STATEID                 VARCHAR2(10),
    CATEGORY                VARCHAR2(2),
    MAIL_ADR                VARCHAR2(35),
    MAIL_CITY               VARCHAR2(18),
    MAIL_ZIP                VARCHAR2(5),
    COUNTY_ST               VARCHAR2(3),
    REGION                  VARCHAR2(3),
    JCAHO                   VARCHAR2(1),
    CURRENT_SFW_ID          VARCHAR2(9),
    CURRENT_AGENT_ID        VARCHAR2(9),
    MDS_INDICATOR           CHAR(1),
    HHA_INDICATOR           CHAR(1),
    LEGALNAME               VARCHAR2(80),
    FAXPHONE                VARCHAR2(13),
    FAXPHONEEXT             VARCHAR2(4),
    EMERPHONE               VARCHAR2(13),
    EMERPHONEEXT            VARCHAR2(4),
    EMERCONT                VARCHAR2(25),
    FACEMAIL                VARCHAR2(60),
    FACTYPE                 CHAR(3),
    ABBREV                  VARCHAR2(8),
    ADDDATE                 DATE,
    STAFFID                 CHAR(5),
    OPERSTAT                CHAR(2),
    OPERSTDESC              VARCHAR2(15),
    OPERCATEG               CHAR(18),
    OPERSTATDT              DATE,
    OPENDATE                DATE,
    CLOSEDDATE              DATE,
    TEAMID                  CHAR(4),
    TEAMABBR                VARCHAR2(6),
    MGMTID                  CHAR(4),
    MGMTABBR                VARCHAR2(8),
    LIC                     NUMBER(1, 0),
    TITLE18                 NUMBER(1, 0),
    TITLE19                 NUMBER(1, 0),
    ACCREDIT                VARCHAR2(12),
    OWNCOMP                 VARCHAR2(50),
    OWNERCAT                CHAR(2),
    OWNCATDES               VARCHAR2(18),
    COUNTY                  CHAR(3),
    CNTYNAME                VARCHAR2(20),
    FMREGION                CHAR(2),
    FYEND                   CHAR(2),
    OPHOUR                  NUMBER(1, 0),
    TLA                     DATE,
    INSREQD                 NUMBER(1, 0),
    INSEXPIRE               DATE,
    BEDEFFECT               DATE,
    BEDCNT                  NUMBER(4, 0),
    BEDNETCNT               NUMBER(4, 0),
    CLICNT                  NUMBER(4, 0),
    CLIEFFECT               DATE,
    SRVCNT                  NUMBER(4, 0),
    SRVEFFECT               DATE,
    BUILDINGS               NUMBER(4, 0),
    HOUSEID                 CHAR(3),
    SENATEID                CHAR(3),
    CONFLICT                NUMBER(1, 0),
    AUTOCANCEL              DATE,
    LOCKEXP                 DATE,
    LOCKSTAT                CHAR(2),
    LOCKSTDESC              VARCHAR2(15),
    ISPARENT                NUMBER(1, 0),
    PARENTID                NUMBER(10, 0),
    PARTYPE                 CHAR(2),
    PARTYPEDES              VARCHAR2(15),
    PARDATE                 DATE,
    REPID                   VARCHAR2(3),
    LSCTEAMID               VARCHAR2(4),
    T1819                   NUMBER(1, 0),
    BEDCERTTOT              NUMBER(4, 0),
    BEDLICTOT               NUMBER(4, 0),
    BEDT18                  NUMBER(4, 0),
    BEDT19                  NUMBER(4, 0),
    BEDT1819                NUMBER(4, 0),
    BEDICF                  NUMBER(4, 0),
    BEDIMR                  NUMBER(4, 0),
    SUREBOND                CHAR(1),
    STATE_RGN_CD            VARCHAR2(3),
    CERTSTATUS              CHAR(1),
    PARTCI_DT               DATE,
    CARRIER_NO              CHAR(5),
    ODIE_ACCEPTED           NUMBER(1, 0),
    DEEMED                  NUMBER(1, 0),
    PROV_EIN                VARCHAR2(9),
    BANKRUPT                NUMBER(1, 0),
    BANKRUPT_BEGIN          DATE,
    BANKRUPT_END            DATE,
    SPECIAL_FOCUS           NUMBER(1, 0),
    SPEC_FOCUS_BEGIN        DATE,
    SPEC_FOCUS_END          DATE,
    MEDIACONTACT_ID         VARCHAR2(3),
    MEDIACONTACT_NAME       VARCHAR2(80),
    DOJCONTACT_ID           VARCHAR2(3),
    DOJCONTACT_NAME         VARCHAR2(80),
    CHAINID                 CHAR(2),
    CHAINDESC               VARCHAR2(100),
    NATCEPLOSS              NUMBER(1, 0),
    NATCEPLOSSENDDATE       DATE,
    NATCEPWAIVER            NUMBER(1, 0),
    NATCEPWAIVERENDDATE     DATE,
    LICTYPECODE             CHAR(2),
    LICEFFECTIVE            DATE,
    LICEXPIRE               DATE,
    LICCONTIN               NUMBER(1, 0),
    LICTYPEDESC             VARCHAR2(30),
    LICISSUED               DATE,
    CERTRACKSTATUS          CHAR(2),
    NPI_PRVDR_NUM           VARCHAR2(10),
    PROVINCE                CHAR(2),
    NATCEPCHOW              DATE,
    STATEKEY                VARCHAR2(16),
    LABCLASS                VARCHAR2(2),
    LABGNRLFACTYPE          VARCHAR2(2),
    LABSRVY_DT              DATE,
    UPDT_TS                 DATE,
    CLIA_MDCR_NUM           VARCHAR2(12),
    GEOLONG                 VARCHAR2(12),
    GEOLAT                  VARCHAR2(12),
    SHINES_RSRC_ID          NUMBER(16, 0),
    DT_LAST_UPDATE          DATE             NOT NULL,
    CONSTRAINT PK_FACILITY PRIMARY KEY (FACILITY_INTERNAL_ID)
    USING INDEX
TABLESPACE INDEX01,
    CONSTRAINT UK_FAC_SHINES_ID  UNIQUE (SHINES_RSRC_ID)
    USING INDEX
TABLESPACE INDEX01
)
TABLESPACE DATA01
;



GRANT DELETE ON ORS.FACILITY TO CAPS
;
GRANT INSERT ON ORS.FACILITY TO CAPS
;
GRANT SELECT ON ORS.FACILITY TO CAPS
;
GRANT UPDATE ON ORS.FACILITY TO CAPS
;
GRANT DELETE ON ORS.FACILITY TO CAPSON
;
GRANT INSERT ON ORS.FACILITY TO CAPSON
;
GRANT SELECT ON ORS.FACILITY TO CAPSON
;
GRANT UPDATE ON ORS.FACILITY TO CAPSON
;
GRANT DELETE ON ORS.FACILITY TO CAPSBAT
;
GRANT INSERT ON ORS.FACILITY TO CAPSBAT
;
GRANT SELECT ON ORS.FACILITY TO CAPSBAT
;
GRANT UPDATE ON ORS.FACILITY TO CAPSBAT
;
GRANT SELECT ON ORS.FACILITY TO OPERATOR
;

-- 
-- TABLE: ORS.FACSRV 
--

CREATE TABLE ORS.FACSRV(
    FACILITY_INTERNAL_ID    NUMBER(10, 0)    NOT NULL,
    SRVTYPE                 CHAR(2)          NOT NULL,
    SRVDESC                 VARCHAR2(30),
    SRVEFFECT               DATE             NOT NULL,
    SRVABBREV               VARCHAR2(6),
    SRVCNT                  NUMBER(4, 0),
    SRVPROV                 CHAR(2),
    SRVPROVDES              VARCHAR2(15),
    SERVICEID               NUMBER(10, 0),
    SRVENDDT                DATE,
    DT_LAST_UPDATE          DATE             NOT NULL,
    CONSTRAINT PK_FACSRV PRIMARY KEY (FACILITY_INTERNAL_ID, SRVTYPE, SRVEFFECT)
    USING INDEX
TABLESPACE INDEX01
)
TABLESPACE DATA01
;



GRANT DELETE ON ORS.FACSRV TO CAPS
;
GRANT INSERT ON ORS.FACSRV TO CAPS
;
GRANT SELECT ON ORS.FACSRV TO CAPS
;
GRANT UPDATE ON ORS.FACSRV TO CAPS
;
GRANT DELETE ON ORS.FACSRV TO CAPSON
;
GRANT INSERT ON ORS.FACSRV TO CAPSON
;
GRANT SELECT ON ORS.FACSRV TO CAPSON
;
GRANT UPDATE ON ORS.FACSRV TO CAPSON
;
GRANT DELETE ON ORS.FACSRV TO CAPSBAT
;
GRANT INSERT ON ORS.FACSRV TO CAPSBAT
;
GRANT SELECT ON ORS.FACSRV TO CAPSBAT
;
GRANT UPDATE ON ORS.FACSRV TO CAPSBAT
;
GRANT SELECT ON ORS.FACSRV TO OPERATOR
;

-- 
-- PROCEDURE: ORS_NOTIFICATION 
--
/
create or replace procedure CAPS.ORS_NOTIFICATION(xID_RESOURCE IN number, xORS_ACTION IN varchar2, xFACNAME IN varchar2, xSTATUS IN varchar2)
AS
BEGIN
     CASE
        when xORS_ACTION='New Complaint' THEN
	insert into todo (id_todo,id_todo_pers_assigned,id_todo_case,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,id_todo_pers_worker)
	select 0,
	decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),
	spl.id_case,
	'ORS Complaint: '||xFACNAME,
	'A complaint has been filed for this facility: '||xFACNAME||'.'||chr(10)||'Check Placements for Case Number: '||to_char(spl.id_case)||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
	'A',
	sysdate,
	spl.id_person
	from caps.stage s,caps.stage_person_link spl,caps.placement p, caps.unit u , caps.employee e, (select 'CASEMANAGER' RECIPIENT from dual UNION select 'SUPERVISOR' RECIPIENT from dual)
	where s.cd_stage='SUB' and
	spl.id_stage=s.id_stage and
	spl.cd_stage_pers_role='PR'  and
	s.id_case=p.id_case and
	p.id_rsrc_facil = xID_RESOURCE and
	e.id_person=spl.id_person and
	u.id_unit=e.id_emp_unit
	group by decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),spl.id_case,spl.id_person;

	insert into todo(id_todo,id_todo_pers_assigned,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created)
	select 0,
	a.id_person,
	'ORS Complaint: '||xFACNAME,
	'A complaint has been filed for this facility: '||xFACNAME||'.'||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
	'A',
	sysdate
	from caps.EMP_SEC_CLASS_LINK a, caps.EMP_SEC_CLASS_LINK b
	where
	a.id_person=b.id_person and
	a.CD_SECURITY_CLASS_NAME='RSRC_DVLPR' and
	b.CD_SECURITY_CLASS_NAME='MAINTAIN_REG_'||(select CD_RSRC_MAINTAINER from caps.caps_resource where
	id_resource=xID_RESOURCE)
	group by a.id_person;

        when xORS_ACTION='Complaint Update' THEN
         	insert into todo (id_todo,id_todo_pers_assigned,id_todo_case,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,id_todo_pers_worker)
		select 0,
		decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),
		spl.id_case,
		'ORS Complaint: '||xFACNAME,
		'A complaint has been updated for this facility: '||xFACNAME||'.'||chr(10)||'Related Case Number: '||to_char(spl.id_case)||chr(10)||'Complaint Status: '||xSTATUS||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
		'A',
		sysdate,
		spl.id_person
		from caps.stage s,caps.stage_person_link spl,caps.placement p, caps.unit u , caps.employee e, (select 'CASEMANAGER' RECIPIENT from dual UNION select 'SUPERVISOR' RECIPIENT from dual)
		where s.cd_stage='SUB' and
		spl.id_stage=s.id_stage and
		spl.cd_stage_pers_role='PR'  and
		s.id_case=p.id_case and
		p.id_rsrc_facil = xID_RESOURCE and
		e.id_person=spl.id_person and
		u.id_unit=e.id_emp_unit
		group by decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),spl.id_case,spl.id_person;

	insert into todo(id_todo,id_todo_pers_assigned,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created)
		select 0,
		a.id_person,
		'ORS Complaint: '||xFACNAME,
		'A complaint has been updated for this facility: '||xFACNAME||'.'||chr(10)||'Complaint Status: '||xSTATUS||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
		'A',
		sysdate
		from caps.EMP_SEC_CLASS_LINK a, caps.EMP_SEC_CLASS_LINK b
		where
		a.id_person=b.id_person and
		a.CD_SECURITY_CLASS_NAME='RSRC_DVLPR' and
		b.CD_SECURITY_CLASS_NAME='MAINTAIN_REG_'||(select CD_RSRC_MAINTAINER from caps.caps_resource where
		id_resource=xID_RESOURCE)
		group by a.id_person;
        when xORS_ACTION='Facility Update' THEN
	insert into todo (id_todo,id_todo_pers_assigned,id_todo_case,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,id_todo_pers_worker)
		select 0,
		decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),
		spl.id_case,
		'ORS Complaint: '||xFACNAME,
		'A facility status has been changed: '||xFACNAME||'.'||chr(10)||'Related Case Number: '||to_char(spl.id_case)||chr(10)||'Facility Status: '||
	                    decode(xSTATUS,'00','Pending','10','Closed','11','Closed','12','Closed','13','Closed','21','Closed','20','Conditional Ops')||
	                    chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
		'A',
		sysdate,
		spl.id_person
		from caps.stage s,caps.stage_person_link spl,caps.placement p, caps.unit u , caps.employee e, (select 'CASEMANAGER' RECIPIENT from dual UNION select 'SUPERVISOR' RECIPIENT from dual)
		where s.cd_stage='SUB' and
		spl.id_stage=s.id_stage and
		spl.cd_stage_pers_role='PR'  and
		s.id_case=p.id_case and
		p.id_rsrc_facil = xID_RESOURCE and
		e.id_person=spl.id_person and
		u.id_unit=e.id_emp_unit
		group by decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),spl.id_case,spl.id_person;

	insert into todo(id_todo,id_todo_pers_assigned,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created)
		select 0,
		a.id_person,
		'ORS Complaint: '||xFACNAME,
		'A facility status has been changed: '||xFACNAME||'.'||chr(10)||'Facility Status: '||
	                    decode(xSTATUS,'00','Pending','10','Closed','11','Closed','12','Closed','13','Closed','21','Closed','20','Conditional Ops')||
	                    chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
		'A',
		sysdate
		from caps.EMP_SEC_CLASS_LINK a, caps.EMP_SEC_CLASS_LINK b
		where
		a.id_person=b.id_person and
		a.CD_SECURITY_CLASS_NAME='RSRC_DVLPR' and
		b.CD_SECURITY_CLASS_NAME='MAINTAIN_REG_'||(select CD_RSRC_MAINTAINER from caps.caps_resource where
		id_resource=xID_RESOURCE)
		group by a.id_person;
       END CASE;
END ORS_NOTIFICATION;
/
grant execute on caps.ors_notification to ors;

-- 
-- INDEX: ORS.FK_COMP_ALG_CINTAKE 
--

CREATE INDEX ORS.FK_COMP_ALG_CINTAKE ON ORS.COMP_ALG(INTAKEID)
TABLESPACE INDEX01
;
-- 
-- INDEX: ORS.UK_FACID 
--

CREATE UNIQUE INDEX ORS.UK_FACID ON ORS.FACILITY(FACID)
TABLESPACE INDEX01
;
-- 
-- TABLE: ORS.COMP_ALG 
--

ALTER TABLE ORS.COMP_ALG ADD CONSTRAINT FK_COMP_ALG_CINTAKE 
    FOREIGN KEY (INTAKEID)
    REFERENCES ORS.CINTAKE(INTAKEID)
;


-- 
-- TRIGGER: TIBR_ADVERSE_ACTION 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TIBR_ADVERSE_ACTION
BEFORE INSERT
ON ORS.ADVERSE_ACTION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 
 

-- 
-- TRIGGER: ORS.TUBR_ADVERSE_ACTION 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TUBR_ADVERSE_ACTION
BEFORE UPDATE
ON ORS.ADVERSE_ACTION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
    IF ((:OLD.FACID <> :NEW.FACID) OR
       (:OLD.EVENTID <> :NEW.EVENTID) OR
       (:OLD.AASRCDATE <> :NEW.AASRCDATE) OR
       (:OLD.PRTYPEID <> :NEW.PRTYPEID) OR
       (:OLD.FINALOUTCOME <> :NEW.FINALOUTCOME)) THEN
	   :new.DT_LAST_UPDATE := SYSDATE;
    END IF;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 
 

-- 
-- TRIGGER: TIBR_CINTAKE 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
create or replace TRIGGER ORS.TIBR_CINTAKE
BEFORE INSERT
ON ORS.CINTAKE
REFERENCING NEW AS NEW
FOR EACH ROW

declare
     vID_RESOURCE number(16);

BEGIN

:new.DT_LAST_UPDATE := SYSDATE;

select distinct(nvl(f.shines_rsrc_id,-1)) into vID_RESOURCE from ors.facility f where f.facid=:new.facid;
caps.ors_notification(vID_RESOURCE,'New Complaint',:new.facname,:new.status);

END;
/

-- 
-- TRIGGER: ORS.TUBR_CINTAKE 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TUBR_CINTAKE 
BEFORE UPDATE
ON ORS.CINTAKE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW

declare
     vID_RESOURCE number(16);

BEGIN
    IF ((:OLD.INTAKEID <> :NEW.INTAKEID) OR
       (:OLD.FACID <> :NEW.FACID) OR
       (:OLD.CMPTYPE <> :NEW.CMPTYPE) OR
       (:OLD.STATUS <> :NEW.STATUS) OR
       (:OLD.SANOTEPAD <> :NEW.SANOTEPAD) OR
       (:OLD.PRIORITY <> :NEW.PRIORITY) OR
       (:OLD.RECVSTART <> :NEW.RECVSTART)) THEN
	     :new.DT_LAST_UPDATE := SYSDATE;
    END IF;
    IF (:OLD.STATUS <> :NEW.STATUS) THEN
	select distinct(nvl(f.shines_rsrc_id,-1)) into vID_RESOURCE from ors.facility f where f.facid=:new.facid;
	caps.ors_notification(vID_RESOURCE,'Complaint Update',:new.facname,:new.status);
    END IF;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 


-- 
-- TRIGGER: TIBR_CINTAKERESP 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TIBR_CINTAKERESP
BEFORE INSERT
ON ORS.CINTAKERESP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END; 
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 


-- 
-- TRIGGER: ORS.TUBR_CINTAKERESP 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TUBR_CINTAKERESP
BEFORE UPDATE
ON ORS.CINTAKERESP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
    IF ((:OLD.INTAKEID <> :NEW.INTAKEID) OR
       (:OLD.STAFFNM <> :OLD.STAFFNM)) THEN
	  :new.DT_LAST_UPDATE := SYSDATE;
    END IF;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 


-- 
-- TRIGGER: TIBR_COMP_ALG 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TIBR_COMP_ALG
BEFORE INSERT
ON ORS.COMP_ALG
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 


-- 
-- TRIGGER: ORS.TUBR_COMP_ALG 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TUBR_COMP_ALG
BEFORE UPDATE
ON ORS.COMP_ALG
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
    IF ((:OLD.INTAKEID <> :NEW.INTAKEID) OR
        (:OLD.TYPEDESC <> :NEW.TYPEDESC) OR
        (:OLD.FINDDESC <> :NEW.FINDDESC) OR
        (:OLD.SUBDESC <> :NEW.SUBDESC) OR
        (:OLD.ALGFINDM <> :NEW.ALGFINDM) OR
        (:OLD.CDETAILM <> :NEW.CDETAILM)) THEN
	   :new.DT_LAST_UPDATE := SYSDATE;
    END IF;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 
 

-- 
-- TRIGGER: TIBR_FACILITY 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TIBR_FACILITY
BEFORE INSERT
ON ORS.FACILITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 


-- 
-- TRIGGER: ORS.TUBR_FACILITY 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TUBR_FACILITY 
BEFORE UPDATE
ON ORS.FACILITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   IF ((:OLD.FACID <> :NEW.FACID) OR
        (:OLD.NAME <> :NEW.NAME) OR
        (:OLD.ADDRESS <> :NEW.ADDRESS) OR
        (:OLD.FAC_CITY <> :NEW.FAC_CITY) OR
        (:OLD.FAC_ST <> :NEW.FAC_ST) OR
        (:OLD.FAC_ZIP <> :NEW.FAC_ZIP) OR
        (:OLD.STATEID <> :NEW.STATEID) OR
        (:OLD.COUNTY_ST <> :NEW.COUNTY_ST) OR
        (:OLD.LEGALNAME <> :NEW.LEGALNAME) OR
        (:OLD.EMERCONT <> :NEW.EMERCONT) OR
        (:OLD.FACTYPE <> :NEW.FACTYPE) OR
        (:OLD.OPERSTAT <> :NEW.OPERSTAT) OR
        (:OLD.BEDLICTOT <> :NEW.BEDLICTOT) OR
        (:OLD.LICEFFECTIVE <> :NEW.LICEFFECTIVE) OR
        (:OLD.LICCONTIN <> :NEW.LICCONTIN) OR
        (:OLD.LICTYPEDESC <> :NEW.LICTYPEDESC)) THEN
	  :new.DT_LAST_UPDATE := SYSDATE;
   END IF;
   IF (:OLD.OPERSTAT <> :NEW.OPERSTAT) AND (:NEW.OPERSTAT in ('00','10','11','12','13','20','21')) AND (:NEW.SHINES_RSRC_ID is not null) THEN
	caps.ors_notification(:new.shines_rsrc_id,'Facility Update',:new.name,:new.operstat);
    END IF;

END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 

-- 
-- TRIGGER: TIBR_FACSRV 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TIBR_FACSRV
BEFORE INSERT
ON ORS.FACSRV
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 


-- 
-- TRIGGER: ORS.TUBR_FACSRV 
--

-- BEGIN PL/SQL BLOCK (do not remove this line) -------------------------------- 
/
CREATE OR REPLACE TRIGGER ORS.TUBR_FACSRV
BEFORE UPDATE
ON ORS.FACSRV
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   IF ((:OLD.FACILITY_INTERNAL_ID <> :NEW.FACILITY_INTERNAL_ID) OR
      (:OLD.SRVDESC <> :NEW.SRVDESC) OR
      (:OLD.SRVENDDT <> :NEW.SRVENDDT)) THEN
	  :new.DT_LAST_UPDATE := SYSDATE;
   END IF;
END;
/
-- END PL/SQL BLOCK (do not remove this line) ---------------------------------- 



-- Here comes the synonyms
create or replace synonym CAPS.ADVERSE_ACTION for ORS.ADVERSE_ACTION;
create or replace synonym CAPS.CINTAKE for ORS.CINTAKE;
create or replace synonym CAPS.CINTAKERESP for ORS.CINTAKERESP;
create or replace synonym CAPS.COMP_ALG for ORS.COMP_ALG;
create or replace synonym CAPS.FACILITY for ORS.FACILITY;
create or replace synonym CAPS.FACSRV for ORS.FACSRV;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (305, 'SacwisRev2', 'Add the ORS schema');                        
commit;


