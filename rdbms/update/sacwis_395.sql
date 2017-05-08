--STGAP00010733 - Reports: To add security to reports

ALTER TABLE CAPS.REPORTS ADD (CD_SEC_ATTR VARCHAR2(3));



--STGAP00010628 - Update task codes for PFC and PAD stages in event

update caps.event e
set e.CD_TASK = '9085'
where e.CD_EVENT_TYPE = 'PLA'
and e.CD_TASK = '3080'
and e.ID_EVENT_STAGE in (select s.id_stage from caps.stage s where s.CD_STAGE = 'PFC');

update caps.event e
set e.CD_TASK = '9080'
where e.CD_EVENT_TYPE = 'PLA'
and e.CD_TASK = '3080'
and e.ID_EVENT_STAGE in (select s.id_stage from caps.stage s where s.CD_STAGE = 'PAD');


--STGAP00010719 - Home Info/FA Home Search - Un-end-date Temp Approv


UPDATE CAPS.CODES_TABLES SET DT_END=NULL WHERE CODE_TYPE='CFAHMSTA' AND CODE IN('ATA','PTA');

UPDATE CAPS.REPORTS SET CD_SEC_ATTR = '90', NM_RPT_AREA_TYPE = 'Adoptions' WHERE NM_RPT_SQR_NAME = 'MonthlyChildMangement';

UPDATE CAPS.REPORTS
SET CD_SEC_ATTR = '91', NM_RPT_AREA_TYPE = 'Adoptions'
WHERE NM_RPT_SQR_NAME = 'ConsiderationOverdue';


--STGAP00010734 - (ADAM) AA Agreement - End-Date Decode

UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CSUBTYPE' AND CODE='13';


--STGAP00010742 - Add Code to accomodate dissolution of adoptions

INSERT INTO CAPS.CODES_TABLES VALUES('CRMRSNAC', 'ADD', 'Adoption Dissolved', NULL, SYSDATE);



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (396, 'SacwisRev3', 'Release 3.0 - DBCRs 10628,10719,10733,10734,10742');

commit;

