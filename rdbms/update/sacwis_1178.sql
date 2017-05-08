--STGAP00017839 - Release(5.1) MR-097:Add new column  to tables for UnsubMIC

--Add new column to ALLEGATION table for Unsub MIC
ALTER TABLE CAPS.ALLEGATION ADD IND_UNSUB_MIC Varchar2(1) null ;

comment on column CAPS.ALLEGATION.IND_UNSUB_MIC  is 'Indicates whether the allegation indicates a maltreatment in care situation but the disposition is unsubstantiated';

--Drop new column on ALLEGATION table for Unsub MIC
--alter table CAPS.ALLEGATION drop column IND_UNSUB_MIC;

--Add new column to CPS_INVST_DETAIL table for Unsub MIC
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD IND_UNSUB_MIC Varchar2(1) null ;

comment on column CAPS.CPS_INVST_DETAIL.IND_UNSUB_MIC  is 'Indicates whether the investgation is based on an unsub maltreatment in care';

--Drop new column on CPS_INVST_DETAIL table for Unsub MIC
--alter table CAPS.CPS_INVST_DETAIL drop column IND_UNSUB_MIC;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1179, 'SacwisRev5', 'Release 5.1 - DBCR 17839');

commit;
