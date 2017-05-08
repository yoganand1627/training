--STGAP00015687 - Release(3.41) Increase  the size of the column:NBR_CNSVC_UNIT_RA

--1. Update the size of the column NBR_CNSVC_UNIT_RATE in the CONTRACT_SERVICE table from NUMBER(6,2) to NUMBER(7,2).

--2. Update the size of the column NBR_CNSVC_AUD_UNIT_RATE in the CONTRACT_SERVICE_AUDIT table from NUMBER(6,2) to NUMBER(7,2).

alter table CAPS.CONTRACT_SERVICE modify NBR_CNSVC_UNIT_RATE number(7,2);
alter table CAPS.CONTRACT_SERVICE_AUDIT modify NBR_CNSVC_AUD_UNIT_RATE number(7,2);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (672, 'SacwisRev3', 'Release 3.41 - DBCR 15687');

commit;

