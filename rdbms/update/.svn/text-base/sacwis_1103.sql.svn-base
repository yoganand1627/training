--STGAP00017103 - Release(5.0) ECEM 5.0: Fiscal code updates

GRANT SELECT ON CAPS.SEQ_UAS_PROGRAM_CODE_MTNT TO capson,capsbat,ops$datafix;
alter table caps.UAS_PROGRAM_CODE_MTNT modify dt_effective Date null;
-- Commented out due to issue with key duplication for the column
--alter table  caps.uas_program_code_mtnt add unique (cd_uas);

-- ECEM 5.0 update
update CAPS.codes_tables set decode = 'Perform Financial Maintenance' where code_type = 'CSECATTR' and code  = 'PT';
INSERT INTO caps.codes_tables values ('CSVCRGNS', '95', 'All Regions',null, sysdate);

-- correction update per current design
UPDATE caps.codes_tables SET dt_end = sysdate where code_type = 'CSVCRGNS' and code = '98';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1104, 'SacwisRev5', 'Release 5.0 - DBCR 17103');

commit;
