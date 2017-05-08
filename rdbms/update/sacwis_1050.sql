--STGAP00016194 - Release(4.3) CAPTA - Update MESSAGE

-- STGAP00016194
-- CAPTA - Update MESSAGE
-- NOTE:
-- This is an update to the previous DBCR STGAP00016190 per Design document change


update caps.message
set txt_message = 'Each resource household member selected over 17 yrs, primary safety resource, and secondary safety resource must have at least one SUCCESS, one County Master File, one GBI Sex Offender Registry, one Department of Corrections Offender Query, and one Board of Pardons and Parole records check documented before submitting for approval.'
where txt_message_name = 'MSG_MISSING_REC_CHECK_OVER_17';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1051, 'SacwisRev4', 'Release 4.3 - DBCR 16194');

commit;

