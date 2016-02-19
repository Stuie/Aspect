package ie.stu.aspect;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * An aspect for handling metrics logging for click events.
 *
 * Created by stu on 18/02/2016.
 */
@Aspect
public class MetricsAspect {
    private static final String TAG = MetricsAspect.class.getSimpleName();

    /**
     * This pointcut and method will find any onClick method in any package under ie.stu.aspect
     * and find the {@link View} associated with the click. Using the View's
     * {@link android.content.res.Resources} access the method finds the human-friendly ID of the
     * View and logs it.
     *
     * @param joinPoint {@link JoinPoint} representing the method being hijacked
     */
    @After("within(ie.stu.aspect.*.*) && execution(* onClick(View))")
    public void logMetrics(final JoinPoint joinPoint) {
        Log.i(TAG, "Metrics Aspect checking in");

        Object[] args = joinPoint.getArgs();

        if (args[0] instanceof View) {
            final View view = (View) args[0];

            final String idName = view.getResources().getResourceName(view.getId());

            Log.d(TAG, "Here's the ID I got: " + idName);

            // Now you have an ID you can record a metric to show the button was clicked.
        }
    }
}
