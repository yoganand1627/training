update caps.CODES_TABLES set decode = 'A child who has been in the care of a public/private agency or individ other than the legal or bio parent for more than 24 consec months' where CODE_TYPE = 'CPRSPCLN' and code = '08';
update caps.CODES_TABLES set decode = 'A child who has been in the care of a public/private agency or individ other than the legal or bio parent for more than 24 consec months' where CODE_TYPE = 'CSPCLTYP' and code = 'C';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (749, 'SacwisRev3', 'Release 3.42 - DBCR 15799');

commit;
