--STGAP00016055 - Release(4.1) MR-074 AFCARS: Custody:delete old after conversion

-- related DBCR STGAP00016052: data conversion
-- remove old custody removal reasons after those have been converted to the new code.

-- ***NOTE: TO BE RUN AFTER STGAP00016052

delete caps.removal_reason r where r.cd_removal_reason in ('PHR','NSR','MNR','TAA','TAB','TAC','TAD','EAR')
and r.id_removal_event in (select r2.id_removal_event from caps.removal_reason r2 where r2.cd_removal_reason = 'NEG');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (947, 'SacwisRev4', 'Release 4.1 - DBCR 16055');

commit;


