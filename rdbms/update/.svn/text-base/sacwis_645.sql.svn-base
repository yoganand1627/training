--STGAP00015647 - Release(Undetermined) SQR: update Most recent placement by mmonth view

-- Added new field to the view because question Is this a long term foster careplacement is added back to MR-057
-- Dependency: DBCR to add the new column to the Placement table: STGAP00015632

-- This is a view query to find the most recent, actual, and approved placement for a child in a case
-- as of the last day of the reporting month, for SQR report development purposes.
-- dt_report is the reporting month parameter. This value needs to be inserted to report_work table by the 
-- SQR program. Do not commit the inserts to report_work. Roll back before exiting the SQR program.
CREATE OR REPLACE VIEW CAPS.MOST_RECENT_PLACEMENT_BY_MONTH
(ID_EVENT_PLACEMENT, ID_PERSON_CHILD, ID_CASE_PLACEMENT, CD_PLACEMENT_TYPE, IND_LTFC, DT_LTFC_SIGNED, IND_CONN_ADULT)
AS
select pla_child.id_plcmt_event , pla_child.id_plcmt_child , pla_child.id_case, pla_child.cd_plcmt_type
, pla_child.IND_LTFC_PLACEMENT 
, pla_child.DT_LTFC_AGREEMENT_SIGNED
, pla_child. IND_CHILD_CONNECT_ADULT 
from caps.placement pla_child , caps.event e_pla_child
where pla_child.id_plcmt_event = e_pla_child.id_event
and e_pla_child.cd_event_status = 'APRV'
and pla_child.CD_PLCMT_ACT_PLANNED = 'A'
and (pla_child.CD_TEMP_TYPE is null or pla_child.CD_TEMP_TYPE not in ('COR','RED','REN'))
and pla_child.dt_plcmt_end >= to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')
and pla_child.dt_plcmt_start < last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy'))+1
and pla_child.dt_plcmt_start = 
            (select max(pla_child2.dt_plcmt_start)
             from caps.placement pla_child2 , caps.event e_pla_child2 
             where pla_child2.id_plcmt_child = pla_child.id_plcmt_child 
             and pla_child2.id_plcmt_event = e_pla_child2.id_event
             and pla_child2.id_case = pla_child.id_case 
             and e_pla_child2.cd_event_status = 'APRV'
             and pla_child2.CD_PLCMT_ACT_PLANNED = 'A'
             and (pla_child2.CD_TEMP_TYPE is null or pla_child2.CD_TEMP_TYPE not in ('COR','RED','REN'))
             and pla_child2.dt_plcmt_end >= to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')
             and pla_child2.dt_plcmt_start < last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy'))+1
            );

grant select on CAPS.MOST_RECENT_PLACEMENT_BY_MONTH to operator,capson,capsbat,ops$datafix;            



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (646, 'SacwisRev3', 'Release Undetermined - DBCR 15647');

commit;


