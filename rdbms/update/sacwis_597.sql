--STGAP00015570 - Release(3.32) Update Batch Parameters for Case Review Batch

--Update the Batch Parameters table to begin automatic execution of the Case Review
-- Sampling batch job.  The parameters should be changed so that the November batch run samples from 10/2009.

update CAPS.batch_parameters set txt_parameter_value = '10/2009'
where NM_BATCH_PROGRAM in ('CASRVJOB','CSRVDRJB')
and nm_batch_parameter = 'beginDt';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (598, 'SacwisRev3', 'Release 3.32 - DBCR 15570');

commit;

