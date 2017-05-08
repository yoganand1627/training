--STGAP00015790 - Release(3.42) MR-60 UPDATE Codes Tables for new spc needs types

update caps.CODES_TABLES set decode = 'A child who has been in the care of a public or private agency or individual other than the legal or biological parent for more than 24 consecutive months' where CODE_TYPE = 'CPRSPCLN' and code = '08';
update caps.CODES_TABLES set decode = 'A child who has been in the care of a public or private agency or individual other than the legal or biological parent for more than 24 consecutive months' where CODE_TYPE = 'CSPCLTYP' and code = 'C';
update caps.CODES_TABLES set decode = 'A child who is a member of a sibling group of two or more placed in the same home' where CODE_TYPE = 'CSPCLTYP' and code = 'U';
update caps.CODES_TABLES set decode = 'A child who is a member of a sibling group of two or more placed in the same home' where CODE_TYPE = 'CPRSPCLN' and code = '09';
update caps.CODES_TABLES set decode = 'A child with a physical, mental or emotional disability, as validated by a licensed physician or psychologist' where CODE_TYPE = 'CPRSPCLN' and code = '10';
update caps.CODES_TABLES set decode = 'A child with a physical, mental or emotional disability, as validated by a licensed physician or psychologist' where CODE_TYPE = 'CSPCLTYP' and code = 'V';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (744, 'SacwisRev3', 'Release 3.42 - DBCR 15790');


commit;
 
