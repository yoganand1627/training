--STGAP00010028 - unit_emp_link column sizes need to be increased

ALTER TABLE caps.unit_emp_link MODIFY (nbr_int number(5), nbr_inv number(5), nbr_div
number(5), nbr_ong number(5), nbr_fc number(5), nbr_ado number(5), nbr_pad number(5),
nbr_fad number(5), nbr_total number(5), nbr_pfc number(5));


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (373, 'SacwisRev2', 'Release 2.6 - DBCR 10028');

commit;


