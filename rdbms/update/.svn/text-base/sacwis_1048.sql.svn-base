--STGAP00016190 - Release(4.3) CAPTA - Update MESSAGE

-- STGAP00016190
-- CAPTA - Update MESSAGE

update caps.message
set txt_message = 'Each resource household member selected over 17 yrs, primary safety resource, and secondary safety resource must have at least one SUCCESS, one County Master File, one GBI Sex Offender Registry, one Department of Corrections Offender Query, and one Board of Pardons and Parole before submitting for approval.',
txt_message_name = 'MSG_MISSING_REC_CHECK_OVER_17'
where txt_message_name = 'MSG_MISSING_REC_CHECK_OVER_18';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1049, 'SacwisRev4', 'Release 4.3 - DBCR 16190');

commit;

