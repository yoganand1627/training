-- STGAP00009418 - METAPHOR table insert for Exchange Child Detail 
insert into CAPS.METAPHOR
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, TXT_FILTER_PATH, DT_LAST_UPDATE)
Values
   (1620, '/person/ExchangeChildDetail/displayExchangeChildDetail', 'EXCHANGE_CHILD_DETAIL', 'Exchange Child Detail', 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.ExchangeChildDetailShowTab',sysdate);


-- STGAP00009419 - METAPHOR table insert for Exchange Home Detail
insert into CAPS.METAPHOR
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, TXT_FILTER_PATH, DT_LAST_UPDATE)
Values
   (1630, '/fad/ExchangeHomeDetail/displayExchangeHomeDetail', 'EXCHANGE_HOME_DETAIL', 'Exchange Home Detail', 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.ExchangeHomeDetailShowTab',sysdate);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (352, 'SacwisRev2', 'Release 2.6 - DBCRs 9418,9419');
commit;

