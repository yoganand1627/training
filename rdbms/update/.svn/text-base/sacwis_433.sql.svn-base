-- STGAP00012407 - Need a new Sequnce on SEQ_TEMP_CHILD_SEARCH_RESULT

CREATE SEQUENCE CAPS.SEQ_TEMP_CHILD_SEARCH_RESULTS
  START WITH 21
  MAXVALUE 1000
  MINVALUE 1
  CYCLE
  CACHE 20
  ORDER;


GRANT SELECT ON  CAPS.SEQ_TEMP_CHILD_SEARCH_RESULTS TO CAPSBAT,CAPSON,OPS$DATAFIX;


--STGAP00012391 - Need Codes Table value for Placement Type

--Note:  new type to support ado conversion

--Need new Placement Type value to enable conversion process  record Medicaid only Adoptive placements.

INSERT INTO caps.codes_tables ct (ct.CODE_TYPE, ct.CODE, ct.DECODE )
VALUES ('CPLMNTYP', 'OTA', 'Other Adoptive Home');



-- STGAP00012394 - Update Open Slots for homes prior to Release 3.0

/
DECLARE

nbr_open_slots_var 	NUMBER(4);
nbr_active_placements	NUMBER(4);
CURSOR caps_resource_cur IS SELECT cr.NBR_RSRC_FACIL_CAPACITY, cr.ID_RESOURCE 
FROM CAPS.CAPS_RESOURCE cr WHERE cr.CD_RSRC_FACIL_TYPE IN ('70', '71') ORDER BY cr.ID_RESOURCE;
caps_resource_cur_rec caps_resource_cur%rowtype;

BEGIN
-- loop thru all of the Resources in the table.
FOR caps_resource_cur_rec IN caps_resource_cur LOOP

SELECT COUNT(1) INTO nbr_active_placements FROM CAPS.PLACEMENT p 
WHERE p.DT_PLCMT_START <= SYSDATE 
AND p.ID_RSRC_FACIL = caps_resource_cur_rec.ID_RESOURCE
AND p.CD_PLCMT_ACT_PLANNED = 'A' 
AND p.DT_PLCMT_END > SYSDATE 
AND p.ID_PLCMT_EVENT in (SELECT e.ID_EVENT FROM CAPS.EVENT e WHERE e.CD_EVENT_TYPE = 'PLA');

UPDATE CAPS.CAPS_RESOURCE r SET r.NBR_RSRC_OPEN_SLOTS = caps_resource_cur_rec.NBR_RSRC_FACIL_CAPACITY - nbr_active_placements
WHERE r.ID_RESOURCE = caps_resource_cur_rec.ID_RESOURCE;

DBMS_OUTPUT.PUT_LINE(' ');
DBMS_OUTPUT.PUT_LINE('______________________________________________________________________ ');
DBMS_OUTPUT.PUT_LINE('Updating Resource # ' || caps_resource_cur_rec.ID_RESOURCE);
DBMS_OUTPUT.PUT_LINE('The Capacity for Resource # ' || caps_resource_cur_rec.ID_RESOURCE || ' is ' || caps_resource_cur_rec.NBR_RSRC_FACIL_CAPACITY);
DBMS_OUTPUT.PUT_LINE('The number of Active Placements for Resource # ' || caps_resource_cur_rec.ID_RESOURCE || ' is ' || nbr_active_placements);
DBMS_OUTPUT.PUT_LINE('Updated the number of Open Slots for Resource # ' || caps_resource_cur_rec.ID_RESOURCE || ' to ' || (caps_resource_cur_rec.NBR_RSRC_FACIL_CAPACITY - nbr_active_placements));
end loop;

EXCEPTION
WHEN NO_DATA_FOUND THEN 
DBMS_OUTPUT.PUT_LINE(' ');
DBMS_OUTPUT.PUT_LINE('No more Data to be processed');

end;

/
     



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (434, 'SacwisRev3', 'Release 3.0 - DBCRs 12391,12394,12407');

commit;



