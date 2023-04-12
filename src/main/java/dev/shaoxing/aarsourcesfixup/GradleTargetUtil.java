package dev.shaoxing.aarsourcesfixup;

import com.intellij.execution.target.value.TargetValue;
import org.jetbrains.concurrency.Promise;
import org.jetbrains.plugins.gradle.util.GradleLog;

public class GradleTargetUtil {
    static <T> T maybeGetLocalValue(TargetValue<T> targetValue) {
      if (targetValue != null) {
        Promise<T> localValue = targetValue.getLocalValue();
        if (localValue != null) {
          try {
            localValue.blockingGet(0);
          } catch (Exception e) {
            GradleLog.LOG.warn("Can not get target value", e);
          }
        }
      }
      return null;
    }
}
