--STGAP00015737 - Release(3.5) MR-60 New Column in SPECIAL_NEEDS_DETERMINATION

ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION
ADD CD_SPC_NDS_PRE_POS_REQ VARCHAR2(3);

ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION
ADD CD_SPC_NDS_PRE_POS_APR VARCHAR2(3);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (711, 'SacwisRev3', 'Release 3.5 - DBCR 15737');


commit;



