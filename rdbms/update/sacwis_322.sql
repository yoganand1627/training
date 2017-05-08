-- Release 2.4 Emergency Fix

-- change STGAP00008785
/
create or replace procedure CAPS.ORS_NOTIFICATION (xID_RESOURCE IN number, xORS_ACTION IN varchar2, xFACNAME IN varchar2, xSTATUS IN varchar2)
AS
BEGIN
-- STGAP00008783 Update stage id in TODO and include in group by
 CASE
 when xORS_ACTION='New Complaint' THEN
  insert into todo (id_todo,id_todo_pers_assigned,id_todo_case,id_todo_stage,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,dt_todo_due,id_todo_pers_worker)
  select 0,
  decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),
  spl.id_case,
  spl.id_stage,
  'ORS Complaint: '||xFACNAME,
  'A complaint has been filed for this facility: '||xFACNAME||'.'||chr(10)||'Check Placements for Case Number: '||to_char(spl.id_case)||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
  'A',
  sysdate,
  sysdate,
  spl.id_person
  from CAPS.stage s,CAPS.stage_person_link spl,CAPS.placement p, CAPS.unit u , CAPS.employee e, (select 'CASEMANAGER' RECIPIENT from dual UNION select 'SUPERVISOR' RECIPIENT from dual)
  where s.cd_stage='SUB' and
  spl.id_stage=s.id_stage and
  spl.cd_stage_pers_role='PR'  and
  s.id_case=p.id_case and
  p.id_rsrc_facil = xID_RESOURCE and
  e.id_person=spl.id_person and
  u.id_unit=e.id_emp_unit
  group by decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),spl.id_case,spl.id_stage,spl.id_person;

  insert into todo(id_todo,id_todo_pers_assigned,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,dt_todo_due)
  select 0,
  a.id_person,
  'ORS Complaint: '||xFACNAME,
  'A complaint has been filed for this facility: '||xFACNAME||'.'||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
  'A',
  sysdate,
  sysdate
  from CAPS.EMP_SEC_CLASS_LINK a, CAPS.EMP_SEC_CLASS_LINK b
  where
  a.id_person=b.id_person and
  a.CD_SECURITY_CLASS_NAME='RSRC_DVLPR' and
  b.CD_SECURITY_CLASS_NAME='MAINTAIN_REG_'||(select CD_RSRC_MAINTAINER from CAPS.caps_resource where
  id_resource=xID_RESOURCE)
  group by a.id_person;

  when xORS_ACTION='Complaint Update' THEN
    insert into todo (id_todo,id_todo_pers_assigned,id_todo_case,id_todo_stage,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,dt_todo_due,id_todo_pers_worker)
    select 0,
    decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),
    spl.id_case,
    spl.id_stage,
    'ORS Complaint: '||xFACNAME,
    'A complaint has been updated for this facility: '||xFACNAME||'.'||chr(10)||'Related Case Number: '||to_char(spl.id_case)||chr(10)||'Complaint Status: '||xSTATUS||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
    'A',
    sysdate,
    sysdate,
    spl.id_person
    from CAPS.stage s,CAPS.stage_person_link spl,CAPS.placement p, CAPS.unit u , CAPS.employee e, (select 'CASEMANAGER' RECIPIENT from dual UNION select 'SUPERVISOR' RECIPIENT from dual)
    where s.cd_stage='SUB' and
    spl.id_stage=s.id_stage and
    spl.cd_stage_pers_role='PR'  and
    s.id_case=p.id_case and
    p.id_rsrc_facil = xID_RESOURCE and
    e.id_person=spl.id_person and
    u.id_unit=e.id_emp_unit
    group by decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),spl.id_case,spl.id_stage,spl.id_person;

  insert into todo(id_todo,id_todo_pers_assigned,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,dt_todo_due)
    select 0,
    a.id_person,
    'ORS Complaint: '||xFACNAME,
    'A complaint has been updated for this facility: '||xFACNAME||'.'||chr(10)||'Complaint Status: '||xSTATUS||chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
    'A',
    sysdate,
    sysdate
    from CAPS.EMP_SEC_CLASS_LINK a, CAPS.EMP_SEC_CLASS_LINK b
    where
    a.id_person=b.id_person and
    a.CD_SECURITY_CLASS_NAME='RSRC_DVLPR' and
    b.CD_SECURITY_CLASS_NAME='MAINTAIN_REG_'||(select CD_RSRC_MAINTAINER from CAPS.caps_resource where
    id_resource=xID_RESOURCE)
    group by a.id_person;
        
  when xORS_ACTION='Facility Update' THEN
  insert into todo (id_todo,id_todo_pers_assigned,id_todo_case,id_todo_stage,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,dt_todo_due,id_todo_pers_worker)
    select 0,
    decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),
    spl.id_case,
    spl.id_stage,
    'ORS Complaint: '||xFACNAME,
    'A facility status has been changed: '||xFACNAME||'.'||chr(10)||'Related Case Number: '||to_char(spl.id_case)||chr(10)||'Facility Status: '||
                      decode(xSTATUS,'00','Pending','10','Closed','11','Closed','12','Closed','13','Closed','21','Closed','20','Conditional Ops')||
                      chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
    'A',
    sysdate,
    sysdate,
    spl.id_person
    from CAPS.stage s,CAPS.stage_person_link spl,CAPS.placement p, CAPS.unit u , CAPS.employee e, (select 'CASEMANAGER' RECIPIENT from dual UNION select 'SUPERVISOR' RECIPIENT from dual)
    where s.cd_stage='SUB' and
    spl.id_stage=s.id_stage and
    spl.cd_stage_pers_role='PR'  and
    s.id_case=p.id_case and
    p.id_rsrc_facil = xID_RESOURCE and
    e.id_person=spl.id_person and
    u.id_unit=e.id_emp_unit
    group by decode(RECIPIENT,'CASEMANAGER',spl.id_person,'SUPERVISOR',u.id_person, null),spl.id_case,spl.id_stage,spl.id_person;

  insert into todo(id_todo,id_todo_pers_assigned,txt_todo_desc,txt_todo_long_desc,cd_todo_type,dt_todo_created,dt_todo_due)
    select 0,
    a.id_person,
    'ORS Complaint: '||xFACNAME,
    'A facility status has been changed: '||xFACNAME||'.'||chr(10)||'Facility Status: '||
                      decode(xSTATUS,'00','Pending','10','Closed','11','Closed','12','Closed','13','Closed','21','Closed','20','Conditional Ops')||
                      chr(10)||'This is a system generated alert from the Office of Regulatory Services.',
    'A',
    sysdate,
    sysdate
    from CAPS.EMP_SEC_CLASS_LINK a, CAPS.EMP_SEC_CLASS_LINK b
    where
    a.id_person=b.id_person and
    a.CD_SECURITY_CLASS_NAME='RSRC_DVLPR' and
    b.CD_SECURITY_CLASS_NAME='MAINTAIN_REG_'||(select CD_RSRC_MAINTAINER from CAPS.caps_resource where
    id_resource=xID_RESOURCE)
    group by a.id_person;
       END CASE;
END ORS_NOTIFICATION;
/

grant execute on caps.ors_notification to ors;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (323, 'SacwisRev2', 'update ORS_NOTIFICATION to include STAGE in group by');                        
commit;
