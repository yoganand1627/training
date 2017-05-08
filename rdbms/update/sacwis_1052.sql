--STGAP00016199 - Release(4.3) Update name for security class OPOUM_DRCTR

-- Update security class name for security class  'OPUOM_DRCTR'

insert into caps.security_class
select 
'OPUOM_SPC_DRCTR',sysdate,'10101001011000000000000010000000000000000000000001001001000001000000000000000010000001001100001000','N',NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071)
from dual;

update caps.emp_sec_class_link
set cd_security_class_name = 'OPUOM_SPC_DRCTR'
where cd_security_class_name = 'OPUOM_DRCTR';

delete from  caps.security_class
where cd_security_class_name = 'OPUOM_DRCTR';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1053, 'SacwisRev4', 'Release 4.3 - DBCR 16199');

commit;


