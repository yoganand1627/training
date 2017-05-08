--STGAP00016117 - Release(4.2) TCM Denial Code Parameter Descriptor Change

--TCM Denial Codes have 3 descriptors that were not uniform with the other descriptors as far
--as  the case of the letters. Had to change the descriptors' wording to upper case

UPDATE  CAPS.CODES_TABLES CT
SET CT.DECODE = '0471 - QMB MEMBER ELIGIBLE FOR MCARE CROSSOVERS ONLY'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '0471';

UPDATE  CAPS.CODES_TABLES CT
SET CT.DECODE = '2064 - CLAIM DOS/MEMBER DATE OF DEATH CONFLICT'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '2064';

UPDATE  CAPS.CODES_TABLES CT
SET CT.DECODE = '2517 - TPL ON MEMBER FILE, NOT ON CLAIM (PAY CLAIM)'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '2517';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1000, 'SacwisRev4', 'Release 4.2 - DBCR 16117');

commit;


