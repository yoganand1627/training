/**
 * Created on Mar 20, 2006 at 4:34:55 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.cglib.asm.Type;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Eventually, this will be a class that tests sql translations of Hibernate call; for now, it is a placeholder. */
public class HQLTranslationTest extends BaseDAOTest {

  /** These beans cannot be tested using the arbitrary parameters. */
  @SuppressWarnings({"CloneableClassWithoutClone"})
  private static final Set<String> SKIP_BEANS = new HashSet<String>() {
    {
      add("baseDAO");
      add("commonDAO");
    }
  };

  private static final String CLASS_NAME = HQLTranslationTest.class.getName();
  private static final String DAO_PACKAGE_NAME = CLASS_NAME.substring(0, CLASS_NAME.lastIndexOf("."));

  public HQLTranslationTest(String string) throws Exception {
    super(string);
  }

  public void testNothing() {
    // Prevents an error.
  }

  public static Test suite() {
    // Initialize the application context if it's not initialized
    if (BaseHQLTranslationTest.context == null) {
      //noinspection NonThreadSafeLazyInitialization
      BaseHQLTranslationTest.context = new ClassPathXmlApplicationContext(CONFIG_LOCATIONS);
    }
    return new DynamicDAOTranslationTestSuite(BaseHQLTranslationTest.context);
  }

  private static class DynamicDAOTranslationTestSuite extends TestSuite {
    // Initialize this with common values.
    @SuppressWarnings({"CloneableClassWithoutClone", "unchecked"})
    private static final Map<Class<?>, Object> ARG_CACHE = new HashMap<Class<?>, Object>() {
      {
        put(Long.class, 777l);
        put(Long.TYPE, 777l);
        put(Integer.class, 77);
        put(Integer.TYPE, 77);
        put(Short.class, (short) 7);
        put(Short.TYPE, (short) 7);
        put(Byte.class, (byte) 7);
        put(Byte.TYPE, (byte) 7);
        put(Double.class, 77.7);
        put(Double.TYPE, 77.7);
        put(Float.class, 7.7);
        put(Float.TYPE, 7.7);
        put(Boolean.class, false);
        put(Boolean.TYPE, true);
        put(Character.class, '1');
        put(Character.TYPE, '2');
        put(String.class, "Y");
        put(Date.class, new Date());
        // Create non-empty collections for collection queries; guess that integers work for everything.
        put(Collection.class, Collections.singleton(777));
        put(SortedSet.class, new TreeSet(Collections.singleton(777)));
        put(Set.class, Collections.singleton(777));
        put(List.class, Collections.singletonList(777));
      }
    };
    @SuppressWarnings({"CloneableClassWithoutClone", "unchecked"})
    private static final Map<Class<?>, Object> STRING_COLLECTION_CACHE = new HashMap<Class<?>, Object>() {
      {
        // Create non-empty collections for collection queries; guess that integers work for everything.
        put(Collection.class, Collections.singleton("1"));
        put(SortedSet.class, new TreeSet(Collections.singleton("1")));
        put(Set.class, Collections.singleton("1"));
        put(List.class, Collections.singletonList("1"));
      }
    };
    private static final String DB_PACKAGE_NAME = "gov.georgia.dhr.dfcs.sacwis.db.";

    public DynamicDAOTranslationTestSuite(ConfigurableApplicationContext context) {
      // Search the context for subclasses of BaseDAO and create one test suite for each one.
      String[] beanNameList = context.getBeanDefinitionNames();
      for (int i = 0; i < beanNameList.length; i++) {
        String beanName = beanNameList[i];
        Class beanType = context.getType(beanName);
        if (beanName.endsWith("DAO") &&
            !beanName.startsWith("complex") &&
            !beanName.startsWith("dynamic") &&
            !SKIP_BEANS.contains(beanName)) {
          TestSuite test = createTestSuite(beanName, beanType, context);
          if (test != null) {
            addTest(test);
          }
        }
      }
    }

    private static TestSuite createTestSuite(final String beanName, final Class clazz,
                                             final ConfigurableApplicationContext context) {
      final Map<String, Method> methodMap = new HashMap<String, Method>();
      Class[] interfaces = clazz.getInterfaces();
      // Create the interfact maker
      InterfaceMaker interfaceMaker = new InterfaceMaker();
      String primaryInterfaceName = null;
      // Only test interfaces in the same package as this test.
      for (int i = 0; i < interfaces.length; i++) {
        Class anInterface = interfaces[i];
        String interfaceName = anInterface.getName();
        if (interfaceName.startsWith(DAO_PACKAGE_NAME)) {
          primaryInterfaceName = interfaceName;
          // Create a test method for each method
          Method[] methods = anInterface.getMethods();
          for (int j = 0; j < methods.length; j++) {
            Method method = methods[j];
            String methodName = method.getName();
            String testMethodName = "test" + methodName.substring(0, 1).toUpperCase() +
                                    (methodName.length() > 1 ? methodName.substring(1) : "");
            int k = 1;
            String baseTestMethodName = testMethodName;
            while (methodMap.containsKey(testMethodName)) {
              testMethodName = baseTestMethodName + (k++);
            }
            methodMap.put(testMethodName, method);
            interfaceMaker.add(new Signature(testMethodName, Type.VOID_TYPE, new Type[0]), new Type[0]);
          }
          // Assume that there is only 1 interface.
          break;
        }
      }
      if (primaryInterfaceName == null) {
        LogFactory.getLog(HQLTranslationTest.class).warn("Failed to find interface for bean: " + beanName);
        return null;
      }
      final Class testMethodsInterface = interfaceMaker.create();
      final SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
      CallbackHelper callbackHelper =
              new CallbackHelper(BaseHQLTranslationTest.class, new Class[] {testMethodsInterface}) {
                protected Object getCallback(Method method) {
                  final String methodName = method.getName();
                  if (methodMap.containsKey(methodName)) {
                    return new MethodInterceptor() {
                      @SuppressWarnings({"ProhibitedExceptionDeclared"})
                      public Object intercept(Object obj, Method testMethod, Object[] testArgs, MethodProxy proxy)
                              throws Throwable {
                        Log logger = LogFactory.getLog(obj.getClass());
                        Method method = methodMap.get(methodName);
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        Object[] parameters = new Object[parameterTypes.length];
                        for (int i = 0; i < parameterTypes.length; i++) {
                          Class<?> parameterType = parameterTypes[i];
                          // Manually skip parameterized types so we can attempt to deal with them below.
                          if (ARG_CACHE.containsKey(parameterType)) {
                            parameters[i] = ARG_CACHE.get(parameterType);
                          } else {
                            parameters[i] = createInstance(parameterType, sessionFactory, logger);
                            ARG_CACHE.put(parameterType, parameters[i]);
                          }
                        }
                        Object bean = context.getBean(beanName);
                        return invokeMethod(beanName, bean, method, parameters, logger);
                      }

                      @SuppressWarnings({"ProhibitedExceptionDeclared"})
                      private Object invokeMethod(String beanName, Object bean, Method method, Object[] parameters,
                                                  Log logger)
                              throws Throwable {
                        try {
                          return method.invoke(bean, parameters);
                        } catch (InvocationTargetException e) {
                          Throwable throwable = e.getCause();
                          if (throwable instanceof ClassCastException &&
                              throwable.getMessage().equals(Integer.class.getName())) {
                            // Guess that the problem was that the collections required strings, not numbers.
                            // TODO: Handle all cases.
                            for (int i = 0; i < parameters.length; i++) {
                              Class<? extends Object> parameterClasss = parameters[i].getClass();
                              if (Set.class.isAssignableFrom(parameterClasss)) {
                                parameters[i] = STRING_COLLECTION_CACHE.get(SortedSet.class);
                              } else if (List.class.isAssignableFrom(parameterClasss)) {
                                parameters[i] = STRING_COLLECTION_CACHE.get(List.class);
                              }
                            }
                            try {
                              return method.invoke(bean, parameters);
                            } catch (InvocationTargetException e2) {
                              throwable = e2.getCause();
                              // fall through to processing below.
                            }
                          }
                          processInvocationTargetException(beanName, logger, method, throwable);
                          return null;
                        } catch (IllegalArgumentException e) {
                          logger.debug("Threw exception while trying to execute 'method' with:");
                          for (int i = 0; i < parameters.length; i++) {
                            Object parameter = parameters[i];
                            logger.debug("Parameter " + i + ": " + parameter);
                          }
                          throw e;
                        }
                      }
                    };
                  }
                  return NoOp.INSTANCE;
                }
              };
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(BaseHQLTranslationTest.class);
      enhancer.setInterfaces(new Class[] {testMethodsInterface});
      enhancer.setCallbackFilter(callbackHelper);
      enhancer.setCallbacks(callbackHelper.getCallbacks());
      final String generatedClassName = primaryInterfaceName.replaceFirst("(.*[.])([^.]*)", "$1Test$2");
      enhancer.setNamingPolicy(new NamingPolicy() {
        private int counter = 0;
        public String getClassName(String prefix, String source, Object key, Predicate names) {
          return counter++ == 0 ? generatedClassName : generatedClassName + counter;
        }
      });
      TestSuite suite = new TestSuite(primaryInterfaceName.substring(primaryInterfaceName.lastIndexOf(".") + 1));
      Method[] testMethods = testMethodsInterface.getMethods();
      if (testMethods == null || testMethods.length == 0) {
        return null;
      }
      Factory factory = (Factory) enhancer.create(new Class[] {String.class}, new Object[] {testMethods[0].getName()});
      suite.addTest((BaseHQLTranslationTest) factory);
      for (int i = 0; i < testMethods.length; i++) {
        suite.addTest((Test) factory.newInstance(new Class[] {String.class}, new Object[] {testMethods[i].getName()},
                                                 factory.getCallbacks()));
      }
      return suite;
    }

    @SuppressWarnings({"ProhibitedExceptionDeclared", "ProhibitedExceptionThrown"})
    private static void processInvocationTargetException(String beanName, Log logger, Method method, Throwable t)
            throws Throwable {
      String message = "Exception while executing " + beanName + "." + method.getName() + "(): " + t;
      if (t instanceof ConstraintViolationException || t instanceof ObjectNotFoundException) {
        // The data isn't real that we feed into these, and this just means that Hibernate detected an expected error.
        logger.trace(message, t);
        return;
      } else if (t instanceof DataException &&
                 ((DataException) t).getSQLException().getErrorCode() == 1403 &&
                 "02000".equals(((DataException) t).getSQLException().getSQLState())) {
        // This means that a trigger failed because it could not find something, which is to be expected with fake data.
        logger.trace(message, t);
        return;
      } else if (t instanceof SQLGrammarException &&
                 ((SQLGrammarException) t).getSQLException().getErrorCode() == 6510 &&
                 "65000".equals(((SQLGrammarException) t).getSQLException().getSQLState())) {
        // This means that a trigger failed because it could not find something, which is to be expected with fake data.
        logger.trace(message, t);
        return;
      }
      logger.debug(message, t);
      throw t;
    }

    @SuppressWarnings({"unchecked"})
    private static Object createInstance(Class<?> aClass, SessionFactory sessionFactory, Log logger)
            throws InvocationTargetException, IllegalAccessException, InstantiationException {
      // Cache the advanced type information to see if we need to use it later.
      // See if we have a DB.
      if (aClass.getName().startsWith(DB_PACKAGE_NAME)) {
        // Try to instantiate a new instance; if that fails, let it be null.
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(aClass);
        if (classMetadata == null) {
          // This means that we have a compound ID; search for the constructor with the largest # of fields, as that
          //   one will be most likely to prevent NPE's.
          Constructor[] constructors = aClass.getConstructors();
          Constructor mostParamsConstructors = constructors[0];
          for (int i = 1; i < constructors.length; i++) {
            if(mostParamsConstructors.getParameterTypes().length < constructors[i].getParameterTypes().length) {
              mostParamsConstructors = constructors[1];
            }
          }
          // Loop over the parameters and populate them.
          Class[] paramTypes = mostParamsConstructors.getParameterTypes();
          Object[] params = new Object[paramTypes.length];
          for (int i = 0; i < paramTypes.length; i++) {
            Class paramType = paramTypes[i];
            if(ARG_CACHE.containsKey(paramType)) {
              params[i] = ARG_CACHE.get(paramType);
            } else {
              params[i] = createInstance(paramType, sessionFactory, logger);
              ARG_CACHE.put(paramType, params[i]);
            }
          }
          return mostParamsConstructors.newInstance(params);
        }
        org.hibernate.type.Type idType = classMetadata.getIdentifierType();
        Class idClass = idType.getReturnedClass();
        // Safe because we know that ID types must be serializable.
        Serializable idObj = (Serializable) ARG_CACHE.get(idClass);
        if (idObj == null) {
          // Safe because we know that ID types must be serializable.
          idObj = (Serializable) createInstance(idClass, sessionFactory, logger);
          ARG_CACHE.put(idClass, idObj);
        }
        Object instance = sessionFactory.getCurrentSession().load(aClass, idObj);
        ARG_CACHE.put(aClass, instance);
        return instance;
      } else if (aClass.isArray()) {
        // Create a 1 element array; assume that the type is a simple type.
        Object[] array = (Object[]) Array.newInstance(aClass.getComponentType(), 1);
        Class<?> componentClass = aClass.getComponentType();
        if (ARG_CACHE.containsKey(componentClass)) {
          array[0] = ARG_CACHE.get(componentClass);
        } else {
          array[0] = createInstance(componentClass, sessionFactory, logger);
          ARG_CACHE.put(componentClass, array[0]);
        }
        ARG_CACHE.put(aClass, array);
        return array;
      } else if (aClass.isInterface()) {
        // We have an interface, and it's not a collection; we can't instantiate it because we don't know the implementing type.
        logger.info("No way to instantiate interface: " + aClass.getName());
        return null;
      } else {
        // Try to instantiate a new instance of the unknonw object; if that fails, let it be null.
        try {
          Object parameter = aClass.newInstance();
          ARG_CACHE.put(aClass, parameter);
          return parameter;
        } catch (InstantiationException e) {
          logger.info("Failed to create instance of: " + aClass.getName());
        } catch (IllegalAccessException e) {
          logger.info("No permission to create instance of: " + aClass.getName());
        }
      }
      return null;
    }
  }
  private static class BaseHQLTranslationTest extends BaseDAOTest {
    @SuppressWarnings({"ProhibitedExceptionDeclared"})
    public BaseHQLTranslationTest(String string) throws Exception {
      super(string);
      setDependencyCheck(false);
    }
  }
}
