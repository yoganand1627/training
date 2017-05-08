--STGAP00011823 - Per STGAP00010567- Add new rows to Codes_Tables

--Note: no impact to ado model

--Per STGAP00010567
--We need to display Determination Factor of 
--'Child resides in the same household of a child who died of what may have been child maltreatment.'
--for all Allegation Types.
--This will display the required check box in the Physical Abuse, Neglect, Emotional Abuse and Sexual Abuse sections of Determination Factors on the Intake Actions Page.

--SQL Statements:

INSERT INTO caps.codes_tables ct
(ct.CODE_TYPE, ct.CODE, ct.DECODE )
VALUES
('CPHYABSE','PCHD','Child resides in the same household of a child who died of what may have been child maltreatment.');

INSERT INTO caps.codes_tables ct
(ct.CODE_TYPE, ct.CODE, ct.DECODE )
VALUES
('CNEGLECT','NCHD','Child resides in the same household of a child who died of what may have been child maltreatment.');

INSERT INTO caps.codes_tables ct
(ct.CODE_TYPE, ct.CODE, ct.DECODE )
VALUES
('CEMLABSE','ECHD','Child resides in the same household of a child who died of what may have been child maltreatment.');

INSERT INTO caps.codes_tables ct
(ct.CODE_TYPE, ct.CODE, ct.DECODE )
VALUES
('CSEXABSE','SCHD','Child resides in the same household of a child who died of what may have been child maltreatment.');



--STGAP00011824 - create new message

--Note: no impact to ado model


--This message is related to defect STGAP00009689 to prevent users from saving a future date as the contract period start date


INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (0,60516, 'MSG_STRT_NO_FUTR', 'The contract period START date cannot be a future date.', 700, 500, 'N');


--STGAP00011836 - End date  two external doc fields in code tables

--Note: no impact to conversion


--Reason
---------
--This defect is needed for resolution of defect STGAP00010364.

--The External Documentation Detail pagevType dropdown box displays Criminal Hist
--Checks (code CH) and Child Regist on TARE (code RC) but these fields were end dated
--by a data fix in the 2.6 production environment. This defect provides the solution 
--to end date these fields for all environments. The end date is being set to same end date used by the data fix.


--SQL to update the CODES_TABLES
------------------------------------------
UPDATE CAPS.CODES_TABLES
  SET DT_END = '08/07/2008'
   WHERE CODE_TYPE = 'CEXDOTYP' AND CODE IN ('CH', 'RC');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (420, 'SacwisRev3', 'Release 3.1 - DBCRs 11823,11824,11836');

commit;

