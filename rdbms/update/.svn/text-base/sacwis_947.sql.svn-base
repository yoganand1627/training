--STGAP00016056 - Release(4.1) MR-53: Update codestable CFCERNE

--12/20/2010
update CAPS.CODES_TABLES set DECODE = 'The Assistance Unit''s Income (minus deductions) is greater than or equal to the AFDC Standard of Need Income Limit for this Assistance Unit.' where CODE_TYPE = 'CFCERNE' and CODE = 'A11';
update CAPS.CODES_TABLES set DECODE = 'The Child''s Net Countable Income (minus deductions) is greater than or equal to the IV-E Standard of Need Income Limit.' where CODE_TYPE = 'CFCERNE' and CODE = 'A15';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (948, 'SacwisRev4', 'Release 4.1 - DBCR 16056');

commit;

