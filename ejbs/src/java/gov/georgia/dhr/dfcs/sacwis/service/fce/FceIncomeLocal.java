//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

import javax.ejb.EJBLocalObject;
import java.util.Date;


public interface FceIncomeLocal extends EJBLocalObject {
  public void save(FceIncomeDB fceIncomeDB)
          throws EjbValidationException;


  public void saveNoTimestampCheck(FceIncomeDB fceIncomeDB);


  public void copyInto(FceIncomeDB fceIncomeDB);


  public Double getAmtIncome();


  public void setAmtIncome(Double amtIncome);


  public String getCdType();


  public void setCdType(String cdType);


  public Date getDtLastUpdate();


  public void setDtLastUpdate(Date dtLastUpdate);


  public Long getIdFceEligibility();


  public void setIdFceEligibility(Long idFceEligibility);


  public Long getIdFceIncome();


  public void setIdFceIncome(Long idFceIncome);


  public Long getIdFcePerson();


  public void setIdFcePerson(Long idFcePerson);


  public Long getIdIncRsrc();


  public void setIdIncRsrc(Long idIncRsrc);


  public Long getIdPerson();


  public void setIdPerson(Long idPerson);


  public String getIndChild();


  public void setIndChild(String indChild);


  public String getIndCountable();


  public void setIndCountable(String indCountable);


  public String getIndEarned();


  public void setIndEarned(String indEarned);


  public String getIndFamily();


  public void setIndFamily(String indFamily);


  public String getIndIncomeSource();


  public void setIndIncomeSource(String indIncomeSource);


  public String getIndNone();


  public void setIndNone(String indNone);


  public String getIndNotAccessible();


  public void setIndNotAccessible(String indNotAccessible);


  public String getIndResourceSource();


  public void setIndResourceSource(String indResourceSource);


  public String getTxtComments();


  public void setTxtComments(String txtComments);


  public String getTxtSource();


  public void setTxtSource(String txtSource);


  public String getTxtVerificationMethod();


  public void setTxtVerificationMethod(String txtVerificationMethod);
}
