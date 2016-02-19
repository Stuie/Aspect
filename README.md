# Aspect
Extremely basic Android project demonstrating Aspect Oriented Programming.

# Instructions
1. Checkout the source
2. Build and deploy to a device or emulator with <code>./gradlew installDebug</code>
3. Observe the logcat output as you press the buttons

# How it works
The <code>MetricsAspect</code> class contains a method that is configured to run whenever an <code>onClick</code> method is called within the project's package.

From the Aspect method it is possible to access the <code>View</code> argument passed to the <code>onClick</code> method along with other useful information about the current execution context.

The classes have been kept as simple as possible to make it simple to understand what is happening.
