/**
 * Created on Apr 27, 2007 at 10:03:48 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import org.springframework.aop.target.CommonsPoolTargetSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class IdsConnectionCommonsPoolTargetSource extends CommonsPoolTargetSource {

  protected ObjectPool createObjectPool() {
    ObjectPool objectPool = super.createObjectPool();
    ((GenericObjectPool) objectPool).setTestOnBorrow(true);
    return objectPool;
  }

  public boolean validateObject(Object obj) {
    return obj instanceof IdsConnectionImpl && ((IdsConnectionImpl) obj).validate();
  }
}
