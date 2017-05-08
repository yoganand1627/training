/**
 * Created on Oct 8, 2006 at 11:02:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;

import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class SJSASResourceEntityResolver extends ResourceEntityResolver {
  /**
   * Create a ResourceEntityResolver for the specified ResourceLoader (usually, an ApplicationContext).
   *
   * @param resourceLoader the ResourceLoader (or ApplicationContext) to load XML entity includes with
   */
  public SJSASResourceEntityResolver(final ResourceLoader resourceLoader) {
    super(new ResourceLoader() {

      public Resource getResource(String location) {
        return resourceLoader.getResource(location);
      }

      public ClassLoader getClassLoader() {
        return new ClassLoader(resourceLoader.getClassLoader()) {
          /**
           * This version of the {@link #getResources(String)} method uses the first found resources if the overridden
           * classloader has a non-functional verison of this method.
           *
           * @param name
           * @return
           * @throws java.io.IOException
           */
          @Override
          public Enumeration<URL> getResources(String name) throws IOException {
            Enumeration<URL> resources = super.getResources(name);
            if (resources == null || !resources.hasMoreElements()) {
              // Attempt to find at least one resource.
              URL resource = getResource(name);
              if (resource != null) {
                return Collections.enumeration(Collections.singletonList(resource));
              }
            }
            return resources;
          }
        };
      }
    });
  }
}
