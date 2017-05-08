package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides the framework with string representations of appropriate java data types and wrapper classes for the
 * specified schema data type. Based on code examples by Brett McLaughlin.
 *
 * @author Nick Sharples
 */
public class DataConverter {
  /**
   * @param sSchemaType the schema data type
   * @return the primitive Java type for the schema type
   */
  public static String getJavaType(String schemaType) {
    Object type = TYPES.get(schemaType);
    if (type != null) {
      return (String) type;
    } else {
      return "String";
    }
  }

  /**
   * @param the name of the wrapper class for the Java type
   * @sType the primitive Java type
   */
  public static Class getJavaClass(String type) {
    Object c = CLASSES.get(type);
    if (c != null) {
      return (Class) c;
    } else {
      return String.class;
    }
  }

  /**
   * @param the name of the primitive type for sType
   * @sType the Java type (primitive or wrapper class)
   */
  public static Class getPrimitiveJavaClass(String type) {
    Object c = PRIMITIVE_CLASSES.get(type);
    if (c != null) {
      return (Class) c;
    } else {
      return String.class;
    }
  }

  // Static constants
  private static Map TYPES = new HashMap();
  private static Map CLASSES = new HashMap();
  private static Map PRIMITIVE_CLASSES = new HashMap();

  // initialization method
  static {
    TYPES.put("integer", "int");
    TYPES.put("xsd:integer", "int");

    TYPES.put("string", "String");
    TYPES.put("xsd:string", "String");

    TYPES.put("boolean", "boolean");
    TYPES.put("xsd:boolean", "boolean");

    TYPES.put("float", "float");
    TYPES.put("xsd:float", "float");

    TYPES.put("double", "double");
    TYPES.put("xsd:double", "double");

    TYPES.put("long", "long");
    TYPES.put("xsd:long", "long");

    TYPES.put("short", "short");
    TYPES.put("xsd:short", "short");

    TYPES.put("byte", "byte");
    TYPES.put("xsd:byte", "byte");

    CLASSES.put("int", Integer.class);
    CLASSES.put("string", String.class);
    CLASSES.put("boolean", Boolean.class);
    CLASSES.put("float", Float.class);
    CLASSES.put("double", Double.class);
    CLASSES.put("long", Long.class);
    CLASSES.put("short", Short.class);

    CLASSES.put("java.lang.Integer", Integer.class);
    CLASSES.put("java.lang.String", String.class);
    CLASSES.put("java.lang.Boolean", Boolean.class);
    CLASSES.put("java.lang.Float", Float.class);
    CLASSES.put("java.lang.Double", Double.class);
    CLASSES.put("java.lang.Long", Long.class);
    CLASSES.put("java.lang.Short", Short.class);

    PRIMITIVE_CLASSES.put("int", int.class);
    PRIMITIVE_CLASSES.put("string", String.class);
    PRIMITIVE_CLASSES.put("boolean", boolean.class);
    PRIMITIVE_CLASSES.put("float", float.class);
    PRIMITIVE_CLASSES.put("double", double.class);
    PRIMITIVE_CLASSES.put("long", long.class);
    PRIMITIVE_CLASSES.put("short", short.class);

    PRIMITIVE_CLASSES.put("java.lang.Integer", int.class);
    PRIMITIVE_CLASSES.put("java.lang.String", String.class);
    PRIMITIVE_CLASSES.put("java.lang.Boolean", boolean.class);
    PRIMITIVE_CLASSES.put("java.lang.Float", float.class);
    PRIMITIVE_CLASSES.put("java.lang.Double", double.class);
    PRIMITIVE_CLASSES.put("java.lang.Long", long.class);
    PRIMITIVE_CLASSES.put("java.lang.Short", short.class);
  }

}











