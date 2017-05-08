--STGAP00016067 - Release(4.1) Convert FCEA columns to now store ID_PERSON

-- Convert FCE_ELIGIBLITY.ID_PRN_EARNER that store ID_FCE_PERSON to now store ID_PERSON
UPDATE CAPS.FCE_ELIGIBILITY fcee
SET fcee.ID_PRN_EARNER = ( SELECT fcep.ID_PERSON
                           FROM CAPS.FCE_PERSON fcep
                           WHERE fcep.ID_FCE_PERSON = fcee.ID_PRN_EARNER)
WHERE fcee.ID_PRN_EARNER > 0
AND exists (SELECT 'x'
            FROM CAPS.FCE_PERSON fcep
                           WHERE fcep.ID_FCE_PERSON = fcee.ID_PRN_EARNER);

-- Convert FCE_APPLICATION.ID_OTHER_RELATIVE_PERSON that store ID_FCE_PERSON to now store ID_PERSON
UPDATE CAPS.FCE_APPLICATION fcea
SET fcea.ID_OTHER_RELATIVE_PERSON = ( SELECT fcep.ID_PERSON
                                      FROM CAPS.FCE_PERSON fcep
                                      WHERE fcep.ID_FCE_PERSON = fcea.ID_OTHER_RELATIVE_PERSON)
WHERE fcea.ID_OTHER_RELATIVE_PERSON > 0
AND exists (SELECT 'x'
            FROM CAPS.FCE_PERSON fcep
                           WHERE fcep.ID_FCE_PERSON = fcea.ID_OTHER_RELATIVE_PERSON);

-- Convert FCE_APPLICATION.ID_MNGNG_CVS_PERSON that store ID_FCE_PERSON to now store ID_PERSON
UPDATE CAPS.FCE_APPLICATION fcea
SET fcea.ID_MNGNG_CVS_PERSON = ( SELECT fcep.ID_PERSON
                                      FROM CAPS.FCE_PERSON fcep
                                      WHERE fcep.ID_FCE_PERSON = fcea.ID_MNGNG_CVS_PERSON)
WHERE fcea.ID_MNGNG_CVS_PERSON > 0
AND exists (SELECT 'x'
            FROM CAPS.FCE_PERSON fcep
                           WHERE fcep.ID_FCE_PERSON = fcea.ID_MNGNG_CVS_PERSON);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (958, 'SacwisRev4', 'Release 4.1 - DBCR 16067');

commit;


