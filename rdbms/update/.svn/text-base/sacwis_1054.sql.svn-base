--STGAP00016251 - Release(Undetermined) AFCARS Adoptions - Update Adoption Assistance Type

--The SQL statement below updates the Class of Assistance value displayed on the Adoption Assistance --Agreement page from  "Title IV-E Medicaid Only (GA Child)" to "Medicaid Only (GA Child)". This change --was requested by ACF during their June 2011 review of AFCARS reporting. This change has been
--approved as one of the batch-only changes affecting the AFCARS Adoptions extract.

update caps.codes_tables
set DECODE = 'Medicaid Only (GA Child)'
where CODE_TYPE = 'CSUBTYPE' and CODE = '26';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1055, 'SacwisRev4', 'Release Undetermined - DBCR 16251');

commit;


