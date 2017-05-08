-- Release 2.5 
--change STGAP00009256
-- Standard Alter Table SQL

ALTER TABLE CAPS.INCMG_DETERM_FACTORS DROP (TXT_NG_ABUSE_CMNTS,TXT_EM_ABUSE_CMNTS,TXT_SX_ABUSE_CMNTS,TXT_OT_ABUSE_CMNTS)
;
ALTER TABLE CAPS.INCMG_DETERM_FACTORS RENAME COLUMN TXT_PH_ABUSE_CMNTS TO TXT_DET_FAC_CMNTS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (341, 'SacwisRev2', 'static table updates, update INCMG_DETERM_FACTORS');                        
commit;
