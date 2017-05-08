--STGAP00012775 - Remove Dupl Column in SPECIAL_NEEDS_DETERMINATION

--Note:   the column is not used no impact to ado model


--Need to delete the duplicate collumn IND_SPECIALIZED_RATE_REQ. It's not being used by the application

ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION  DROP COLUMN IND_SPECIALIZED_RATE_REQ;


--STGAP00012793 - Message requiring child be registered w/  Exchange

--Note:   new message no impact to ado model


--Defect STGAP00012681
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
values (60519, 'MSG_XCHANGE_CHILD_REG_REQ', 'The child needs to be registered with the Exchange in order to close the ADO stage with reason of Adoption Finalized.', 500, 700, 'N');


--STGAP00012763 - Formatting Voluntary Surrender values

--Note:  no impact to ado model change to decode formatting


--For defect STGAP00012635 all Voluntary Surrender values should be listed in the same format in drop down list

				UPDATE CAPS.CODES_TABLES SET DECODE = 'Voluntary Surrender-Adoptive Mother'
                                WHERE CODE_TYPE = 'CLEGCPS'
                                AND CODE = 'VAM';

                                UPDATE CAPS.CODES_TABLES SET DECODE = 'Voluntary Surrender-Adoptive Father'
                                WHERE CODE_TYPE = 'CLEGCPS'
                                AND CODE = 'VAF';

                                UPDATE CAPS.CODES_TABLES SET DECODE = 'Voluntary Surrender-Legal/Biological Father'
                                WHERE CODE_TYPE = 'CLEGCPS'
                                AND CODE = 'VSF';

                                UPDATE CAPS.CODES_TABLES SET DECODE = 'Voluntary Surrender-Legal Father'
                                WHERE CODE_TYPE = 'CLEGCPS'
                                AND CODE = 'VLS';

                                UPDATE CAPS.CODES_TABLES SET DECODE = 'Voluntary Surrender-Biological Father'
                                WHERE CODE_TYPE = 'CLEGCPS'
                                AND CODE = 'VBF';




insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (444, 'SacwisRev3', 'Release 3.0 - DBCR 12763,12793,12775');

commit;


