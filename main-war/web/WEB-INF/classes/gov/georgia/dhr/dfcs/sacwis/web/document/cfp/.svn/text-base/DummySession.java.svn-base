package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/** Used to pass DocumentUtilityHelper the UserProfile Only implements Attribute functionality */
@SuppressWarnings({"deprecation"})
public class DummySession implements HttpSession {
  protected Map<String, Object> map = new HashMap<String, Object>();

  public Enumeration getAttributeNames() {
    return Collections.enumeration(map.keySet());
  }

  public Object getAttribute(String key) {
    return map.get(key);
  }

  /** @deprecated  */
  @Deprecated
  public Object getValue(String key) {
    return map.get(key);
  }

  /** @deprecated  */
  @Deprecated
  public String[] getValueNames() {
    throw new IllegalStateException("not supported");
  }

  /** @deprecated  */
  @Deprecated
  public void putValue(String key, Object value) {
    map.put(key, value);
  }

  public void removeAttribute(String key) {
    map.remove(key);
  }

  /** @deprecated  */
  @Deprecated
  public void removeValue(String key) {
    map.remove(key);
  }

  public void setAttribute(String key, Object value) {
    map.put(key, value);
  }

  /** @deprecated  */
  @Deprecated
  public javax.servlet.http.HttpSessionContext getSessionContext() {
    throw new IllegalStateException("not supported");
  }

  /** @deprecated  */
  @Deprecated
  public ServletContext getServletContext() {
    throw new IllegalStateException("not supported");
  }

  public String getId() {
    throw new IllegalStateException("not supported");
  }

  public boolean isNew() {
    throw new IllegalStateException("not supported");
  }

  public int getMaxInactiveInterval() {
    throw new IllegalStateException("not supported");
  }

  public long getCreationTime() {
    throw new IllegalStateException("not supported");
  }

  public long getLastAccessedTime() {
    throw new IllegalStateException("not supported");
  }

  public void invalidate() {
    throw new IllegalStateException("not supported");
  }

  public void setMaxInactiveInterval(int interval) {
    throw new IllegalStateException("not supported");
  }
}
