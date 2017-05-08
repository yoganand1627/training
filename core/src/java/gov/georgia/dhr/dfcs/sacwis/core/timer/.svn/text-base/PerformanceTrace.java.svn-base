package gov.georgia.dhr.dfcs.sacwis.core.timer;


import org.grnds.facility.log.GrndsTrace;


/**
 * This class allows for the timing of method calls by wrapping the GrndsTrace framework.  It can be used during
 * development to determine the elapsed time interval for a single function or for an entire method.  By wrapping the
 * GrndsTrace framework, the tracing functionality can be ignored by setting the COMPILE_TRACING variable to false.
 *
 * @author Phillip T. Bernard
 */
public class PerformanceTrace {
  /**
   * Starts Performance/GrndsTracing
   *
   * @param className  (or traceTag)
   * @param methodName (and parameters)
   */
  public static PerformanceTrace enterScope(String className,
                                            String methodName) {
    PerformanceTrace performanceTrace =
            new PerformanceTrace(className, methodName);

    performanceTrace.enterScope();
    return performanceTrace;
  }


  /**
   * Constructor
   *
   * @param className  The class that you want to measure
   * @param methodName The method that you want to measure
   */
  public PerformanceTrace(String className,
                          String methodName) {
    if (COMPILE_TRACING) {
      this.traceTag = className + "." + methodName + "()";
    }
  }


  /**
   * Calculates the time difference in milliseconds between the current system time and the previous call to
   * getElapsedTime.  If there has been no previous calls to getElapsedTime, the method calculates the time difference
   * between the current system time and the enterScope method.
   *
   * @return long Time interval in milliseconds
   * @throws PerformanceTraceException
   */
  public long getElapsedTime() {
    return this.getElapsedTime("");
  }


  /**
   * Calculates the time difference in milliseconds between the current system time and the previous call to
   * getElapsedTime.  If there has been no previous calls to getElapsedTime, the method calculates the time difference
   * between the current system time and the enterScope method.
   *
   * @param label Short text to make clear what operation this is the elapsed time of
   * @return long Time interval in milliseconds
   * @throws PerformanceTraceException
   */
  public long getElapsedTime(String label) {
    if (COMPILE_TRACING) {
      String text = "";
      if (label != null) {
        if ("".equals(label) == false) {
          text = " at " + label;
        }
      }
      this.intervalTime = System.currentTimeMillis() - this.totalTime;
      this.msg(traceTag,
               PERF_TRACE_LEVEL,
               "Performance Time:Elapsed Time" + text +
               ": " + this.intervalTime + "ms");

      this.totalTime = System.currentTimeMillis();
    }
    return this.intervalTime;
  }


  /**
   * Calculates the time difference in milliseconds between the current system time and the call to enterScope.
   *
   * @return long Time interval in milliseconds.
   * @throws PerformanceTraceException
   */
  public long getTotalTime() {
    if (COMPILE_TRACING) {
      this.totalTime = System.currentTimeMillis() - this.startTime;
      this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Time:Total Time: " + this.totalTime + "ms");
    }
    return this.totalTime;
  }


  /**
   * Wrapper method to invoke the GrndsTrace msg method.
   *
   * @param traceTag The class/method name to measure
   * @param level    Tracetag level
   * @param message  The value to be logged
   * @throws PerformanceTraceException
   */
  public void msg(String traceTag,
                  int level,
                  String message) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      GrndsTrace.msg(traceTag, level, message);
    }
  }


  /**
   * Wrapper method to invoke the GrndsTrace enterScope method, initializes startTime and totalTime to the current
   * system time, and sets the active parameter to true.
   */
  public void enterScope() {
    if (COMPILE_TRACING) {
      GrndsTrace.enterScope(traceTag);

      this.startTime = System.currentTimeMillis();
      this.totalTime = this.startTime;
      this.active = true;
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @throws PerformanceTraceException
   */
  public void exitScope() {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope();
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(boolean result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(double result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(float result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(String result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(Object result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(int result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(long result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  /**
   * Wrapper class to invoke the GrndsTrace exitScope method.
   *
   * @param result
   * @throws PerformanceTraceException
   */
  public void exitScope(char result) {
    if (COMPILE_TRACING) {
      if (!active) {
        this.msg(traceTag, PERF_TRACE_LEVEL, "Performance Trace enterScope method has not been called.");
      }
      this.getTotalTime();
      GrndsTrace.exitScope(result);
    }
  }


  // -- testing methods --
  protected final long getStartTimeValue() {
    return this.startTime;
  }


  protected final long getTotalTimeValue() {
    return this.totalTime;
  }


  private long startTime;
  private long intervalTime;
  private long totalTime;
  private String traceTag;
  // ensure enterScope is called before exitScope
  private boolean active;
  public static final boolean COMPILE_TRACING = GrndsTrace.COMPILE_TRACING;
  // allows for msg method to write to GrndsTrace
  public static final int PERF_TRACE_LEVEL = 5;
}















