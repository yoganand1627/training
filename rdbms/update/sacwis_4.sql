-- Standard Alter Table SQL

ALTER TABLE CAPS.ADMIN_DTL DROP (DT_DETERMINATION_LTR,IND_SAAG_NOTIFICATION,IND_LGL_REPRESENTATION,TXT_APPEAL_RESULT,TXT_RSN_APPRV_DENY)
;
ALTER TABLE CAPS.ADMIN_REVIEW ADD DT_DETERMINATION_LTR DATE     NULL
;
ALTER TABLE CAPS.ADMIN_REVIEW ADD IND_SAAG_NOTIFICATION VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.ADMIN_REVIEW ADD IND_LGL_REPRESENTATION VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.ADMIN_REVIEW ADD TXT_APPEAL_RESULT VARCHAR2(80)     NULL
;
ALTER TABLE CAPS.ADMIN_REVIEW ADD TXT_RSN_APPRV_DENY VARCHAR2(4000)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('OPERATOR') };


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (5, 'SacwisRev1', 'Move 5 columns from ADMIN_DTL to ADMIN_REVIEW.');
                         
commit;