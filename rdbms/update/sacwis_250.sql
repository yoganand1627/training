-- Standard Alter Table SQL

ALTER TABLE CAPS.FCCP_FAMILY MODIFY(NM_ASSGN_JUDGE  VARCHAR2(50))
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (251, 'SacwisRev22', 'extend column width to match CPRS');                                    
commit;
