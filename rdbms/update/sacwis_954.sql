--STGAP00016063 - Release(4.1) MR-53: Update codestable CALOCTYP

--01/25/2011
update CAPS.CODES_TABLES set DECODE = 'Single Allocation' where CODE_TYPE = 'CALOCTYP' and CODE = 'SGLP';
update CAPS.CODES_TABLES set DECODE = 'Mutual Allocation' where CODE_TYPE = 'CALOCTYP' and CODE = 'MUTP';
update CAPS.CODES_TABLES set DECODE = 'Multiple Allocation' where CODE_TYPE = 'CALOCTYP' and CODE = 'MULP';
update CAPS.CODES_TABLES set DECODE = 'Mutual/Single Allocation' where CODE_TYPE = 'CALOCTYP' and CODE = 'MSGL';
update CAPS.CODES_TABLES set DECODE = 'Mutual/Multiple Allocation' where CODE_TYPE = 'CALOCTYP' and CODE = 'MMUL';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (955, 'SacwisRev4', 'Release 4.1 - DBCR 16063');

commit;

