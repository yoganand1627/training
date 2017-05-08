--STGAP00013638 - Adoption Afcars rows for Batch_parameter table

--Note:  no impact to ado conversion


-- DBCR INSERTING into BATCH_PARAMETERS for Adoption Afcars
Insert into CAPS.BATCH_PARAMETERS (NM_BATCH_PROGRAM,NM_BATCH_PARAMETER,DT_PARAM_EFFECTIVE,DT_PARAM_EXPIRED,
DT_LAST_UPDATE,TXT_PARAMETER_VALUE) 
values ('AFCADOJB','beginDt',to_timestamp('01-DEC-08','DD-MON-RR HH.MI.SSXFF AM'),
to_timestamp('31-DEC-12','DD-MON-RR HH.MI.SSXFF AM'),
to_timestamp('19-DEC-08','DD-MON-RR HH.MI.SSXFF AM'),'10/01/2008');

Insert into CAPS.BATCH_PARAMETERS (NM_BATCH_PROGRAM,NM_BATCH_PARAMETER,DT_PARAM_EFFECTIVE,DT_PARAM_EXPIRED,DT_LAST_UPDATE,TXT_PARAMETER_VALUE) 
values ('AFCADOJB','endDt',to_timestamp('01-DEC-08','DD-MON-RR HH.MI.SSXFF AM'),
to_timestamp('31-DEC-12','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('08-JAN-09','DD-MON-RR HH.MI.SSXFF AM'),'03/31/2009');


--STGAP00013653 - Remove Warning wording from the No allegation msgs

--Note:  no impact to ado conversion


--Updating the messages that deal with saving a intake action without any allegations.  This will now be an error message instead of a Warning message so Warning should be removed,

update caps.message set txt_message = 'No allegations have been recorded' where id_message = 15580;

update caps.message set txt_message = 'At least one allegation must reference each principal identified as an alleged maltreator or alleged victim.' where id_message = 15599;


--STGAP00013697 - DBCR: Correct typo in service code decode

--Note:  no impact to ado conversion


--This SQL updates a service code decode in SHINES that includes a typo.

UPDATE CAPS.CODES_TABLES SET DECODE = '52148g - PUP Other'
WHERE CODE_TYPE = 'CSVCCODE' AND CODE = '52148g';



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (467, 'SacwisRev3', 'Release 3.1 - DBCRs 13614,13629,13653,13697,13638');

commit;


