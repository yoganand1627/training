package gov.georgia.dhr.dfcs.sacwis.web.core.tags;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public interface DocListInterface {
  public String getFormName();

  public String getDestination();

  public String getSelectName();

  public String getTextLower();

  public String getTextUpper();

  public void addDoc(DocTagInterface dct);
}