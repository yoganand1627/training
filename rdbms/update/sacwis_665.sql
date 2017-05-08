--STGAP00015679 - Release(3.41) Need to update size of a column in Invoice Outbound

--Update the size of the column AMT_SVC_DTL_UNIT_RATE in the Invoice_outbound table from NUMBER(6,2) to NUMBER(7,2).

alter table sacwisifc.invoice_outbound modify AMT_SVC_DTL_UNIT_RATE number(7,2);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (666, 'SacwisRev3', 'Release 3.41 - DBCR 15679');

commit;


