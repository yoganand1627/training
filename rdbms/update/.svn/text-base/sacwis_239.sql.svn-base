-- change STGAP00005347
insert into caps.codes_tables values('CCNTYREG','999','97',NULL,NULL);

-- change STGAP00005372
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
     VALUES (99310, 'MSG_FCE_APPBG_DATA_REQ','Please ensure the following has been completed prior to entering or saving data:<br>- Child''s relationship must be ''Self'' on Person Detail page<br>- Indicate if child has been adopted on Person Characteristics page<br>- CRS ID must be obtained from Person Identifiers Detail page<br>- Child Citizenship and Mother Marital Status must be completed on Citizenship and Identity page',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (240, 'SacwisRev2', 'static table updates');                        
commit;
