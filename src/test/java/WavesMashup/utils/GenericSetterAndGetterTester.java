package WavesMashup.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;

public class GenericSetterAndGetterTester<T> {

  /**
   * To create an instance to test.
   *
   * @param <T>
   *          the type parameter
   * @param atestObject
   *          the object to test the setter and getter
   * @return the new instance
   */
  public static <T> GenericSetterAndGetterTester<T> newInstance(final T atestObject) {
    return new GenericSetterAndGetterTester<>(atestObject);
  }

  private final T testObject;

  /**
   * The filter contains skipped methods for testing.
   */
  private final List<String> filter = new ArrayList<>();

  {
    this.filter.add("getClass");
  }

  /**
   * The values contains all default values for the test.
   */
  private final Map<String, Object> values = new HashMap<>();

  {

    this.values.put("boolean", true);
    this.values.put("byte", (byte) 4);
    this.values.put("short", (short) 6);
    this.values.put("int", 15);
    this.values.put("long", 123L);
    this.values.put("float", 18.2f);
    this.values.put("double", 256.456);
    this.values.put("char", 'E');
    this.values.put("java.lang.String", "Teststring");
    this.values.put("java.lang.Boolean", Boolean.TRUE);
    this.values.put("java.lang.Long", 35L);
    this.values.put("java.lang.Integer", 788);
    this.values.put("java.lang.Short", (short) 3);
    this.values.put("java.lang.Byte", (byte) 5);
    this.values.put("java.lang.Double", 14.5);
    this.values.put("java.lang.Float", 133.7f);
    this.values.put("java.math.BigDecimal", new BigDecimal("1.209"));
    this.values.put("java.util.Date", new Date(0));
    this.values.put("java.util.List", new ArrayList());
    this.values.put("java.util.Map", new HashMap());
    this.values.put("java.util.Set", new HashSet());
    this.values.put("java.util.UUID", UUID.randomUUID());
    this.values.put("java.time.ZonedDateTime", ZonedDateTime.now());
    this.values.put("java.time.LocalDateTime", LocalDateTime.now());
    this.values.put("java.time.LocalTime", LocalTime.NOON);
    this.values.put("java.time.Duration", Duration.ZERO);
    this.values.put("java.util.Optional", Optional.empty());

  }

  private GenericSetterAndGetterTester(final T atestObject) {
    if (atestObject == null) {
      throw new IllegalArgumentException("test object cant be null");
    }
    this.testObject = atestObject;
  }

  /**
   * Appends a filter to skip a getter and setter test for a specified method.
   *
   * @param method
   *          name of the method
   */

  public void addFilter(final String method) {
    this.filter.add(method);
  }

  /**
   * Appends value for a test.
   *
   * @param clazz
   *          Class for the testvalue
   *
   * @param value
   *          Testvalue for the given class
   */
  public void addValue(final Class clazz, final Object value) {
    this.values.put(clazz.getName(), value);
  }

  /**
   * Execute getter of an class.
   *
   * @param method
   *          - method to call
   * @param object
   *          - object on witch the method will be called
   */
  private void executeGetter(final Method method, final Object object) {
    Class type = method.getReturnType();
    Object[] params = {};

    Object result = this.invokeMethode(method, object, params);
    Assertions.assertEquals(this.values.get(type.getName()), result, "Return value for method " + method.getName() + " wasn't expected");

  }

  /**
   * Execute setter of an class.
   *
   * @param method
   *          - method to call
   * @param object
   *          - object on witch the method will be called
   */

  private void executeSetter(final Method method, final Object object) {
    Class[] types = method.getParameterTypes();
    Object[] params = new Object[1];
    if (types.length != 1) {
      throw new IllegalStateException("The method " + method.getName() + " has more than one parameter.");
    }
    String name = types[0].getName();
    if (!this.values.containsKey(name)) {
      throw new IllegalStateException("The value " + name + " wasn't added - method: " + method.getName());
    }
    params[0] = this.values.get(name);
    this.invokeMethode(method, object, params);
  }

  /**
   * Invokes an method with the given parameters.
   *
   * @param method
   *          method which will be invoked
   * @param object
   *          object on which the method will be invoked
   * @param params
   *          params for the method
   * @return
   */
  private Object invokeMethode(final Method method, final Object object, final Object[] params) {
    Object result = null;
    try {
      result = method.invoke(object, params);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
      e.printStackTrace();
      Assertions.fail("Error during execute method " + method.getName());
    }

    return result;
  }

  /**
   * Test all getter and setter.
   *
   */
  public void testAllGetterAndSetter() {

    Method[] methods = this.testObject.getClass().getMethods();
    List<Method> setters = new ArrayList<>();
    List<Method> getters = new ArrayList<>();
    for (Method method : methods) {
      String name = method.getName();
      if (this.filter.contains(name)) {
        continue;
      }
      if (name.startsWith("set")) {
        setters.add(method);
      }
      if (name.startsWith("get") || name.startsWith("is")) {
        getters.add(method);
      }
    }

    for (Method methodSet : setters) {
      this.executeSetter(methodSet, this.testObject);
    }
    for (Method methodGet : getters) {
      this.executeGetter(methodGet, this.testObject);
    }
  }

  /**
   * Test all toString override Methods.
   */
  public void testToString() {
    String result = this.testObject.toString();
    Assertions.assertNotNull(result);
    Assertions.assertNotEquals("", result);
  }

}