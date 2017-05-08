--STGAP00015736 - Release(3.5) MR-60 New Codes Table

INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'N', 'None Applicable', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'R', 'Black Heritage 1 year of age or older', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'A', 'Age 8 or older', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'S', 'Membership of a sibling group of two placed together where one child is special needs', NULL, SYSDATE); 
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'T', 'Member of a sibling group of three or more placed together at the same time', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'M', 'Documented physical/medical condition or mental/emotional disabilities', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'C', 'In the care of a public or private agency or individual other than the legal or biological parent for more than 24 consecutive months', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'U', 'Member of a sibling group of two or more placed in the same adoptive home', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CSPCLTYP', 'V', 'Child with Physical , Mental, or Emotional Disability, as certified by a licensed physician or psychologist', NULL, SYSDATE);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (710, 'SacwisRev3', 'Release 3.5 - DBCR 15736');

commit;


