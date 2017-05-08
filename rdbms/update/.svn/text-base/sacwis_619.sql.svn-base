--STGAP00015611 - Release(3.4) DBCR: Correct FOSTER_CARE_RATE for CPA programs

-- This DBCR sets rates in the FOSTER_CARE_RATE table to 0.00 for CPA RBWO programs
-- where the age rate is not used.  This corrects issues tied to the incorrect dis
-- play of these rates in SHINES and Portal on the Payment of Care, Placement Log,
-- and Child List pages.

UPDATE CAPS.FOSTER_CARE_RATE SET AMT_FCARE_RT_UNIT_RATE = 0.00 WHERE CD_FCARE_RATE_SERVICE
IN ('60901g','61001g','61101g','61301g','61401g','61601g','60901h','61001h','61101h',
'61301h','61401h','61601h','60901i','61001i','61101i','61301i','61401i','61601i')
AND DT_FCARE_RT_END > SYSDATE;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (620, 'SacwisRev3', 'Release 3.4 - DBCR 15611');

commit;


