--STGAP00015849 - Release(3.5) New Help Messages per CAPTA CDNFSI page

-- New Help messages for CDNFSI Page.
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60723,'MSG_NAA_HELP',
       'Not at all preventable refers to deaths for which there are no cures, current technology, or resources available to prevent it. For example, an incurable type of cancer is not at all preventable.  No current amount of medical, educational, social or technological resources could prevent the
death from occurring.', 700, 500, 'N');

       -- New Help messages for CDNFSI Page.
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60724,'MSG_PPREV_HELP',
                        'Possibly preventable refers to a death for which there is not enough information to determine if it was preventable (example: an infant sleep-related death while bed-sharing a queen size bed with two parents who smoke heavily)'
       , 700, 500, 'N');

       -- New Help messages for CDNFSI Page.
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60725,'MSG_DPREV_HELP',
                        'Definitely preventable refers to a death for which the findings and information demonstrate clear action steps that could have been taken that would have prevented the death from occurring (example:  not allowing a ten-year-old child to drive a truck down the street)'
       , 700, 500, 'N');

--Updating decodes for code_type of CDCAUDEA

UPDATE caps.codes_tables SET decode = 'Other' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD12' ;

UPDATE caps.codes_tables SET decode = 'Child Abuse' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD04' ;

UPDATE caps.codes_tables SET decode = 'Drowning' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD08' ;

UPDATE caps.codes_tables SET decode = 'Firearm' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD11' ;

UPDATE caps.codes_tables SET decode = 'Poisoning' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD03' ;

UPDATE caps.codes_tables SET decode = 'SIDS (Sudden Infant Death Syndrome)' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD07' ;

UPDATE caps.codes_tables SET decode = 'Medical (Natural Causes)' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD13' ;

UPDATE caps.codes_tables SET decode = 'Fire/Burn/Smoke' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD06' ;

UPDATE caps.codes_tables SET decode = 'SUID (Sudden Unexpected Infant Death)' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD10' ;

UPDATE caps.codes_tables SET decode = 'Motor Vehicle Incident' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD02' ;

UPDATE caps.codes_tables SET decode = 'Suicide' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD05' ;

UPDATE caps.codes_tables SET decode = 'Fall' WHERE code_type = 'CDCAUDEA' AND code = 'CDCOD09' ;

--Insert new code

INSERT INTO caps.codes_tables
values('CDCAUDEA', 'CDCOD14', 'Asphyxia/Choking',null,sysdate);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (789, 'SacwisRev3', 'Release 3.5 - DBCR 15849');

commit;


