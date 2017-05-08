--STGAP00015742 - Release(3.42) MR-60 New Codes Table for non incident AFCARS

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '08', 'In the care of a public or private agency or individual other than the legal or biological parent for more than 24 consecutive months', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '09', 'Member of a sibling group of two or more placed in the same adoptive home', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '10', 'Child with Physical , Mental, or Emotional Disability, as certified by a licensed physician or psychologist', NULL, SYSDATE);

update caps.codes_tables set decode = ' Black Heritage 1 year of age or older' where code = '02' and code_type = 'CPRSPCLN';
update caps.codes_tables set decode = ' Age 8 or older' where code = '03' and code_type = 'CPRSPCLN';

INSERT INTO CAPS.CODES_TABLES VALUES('CPLCYCHG', 'PRE', 'Pre Policy Change', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CPLCYCHG', 'POS', 'Post Policy Change', NULL, SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (713, 'SacwisRev3', 'Release 3.42 - DBCR 15742');

commit;

