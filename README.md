#tt-codility#

TODO:
* Create Class CodilityTask, which extends Function<T, U> and has methods for void printDescription(PrintStream stream), boolean hasInputLowerBound(), T getInputLowerBound(), boolean hasInputUpperBound(), T getInputUpperBound(), boolean isInputRangeFinite(), Stream<T> getInputRange(), Stream<T> getInputRange(T from, T to), String getExpectedTimeComplexity(), String getExpectedSpaceComplexity().
* Create CodilityTaskTest.
* Create default implementation of memoization for CodilityTask.
* Add support, wrap for Stream<T> getInputRange(Optional<T> from, Optional<T> to).
* Use getInputRange with Spliterators, ThreadPool, Runnables to allow parallelization.
* Others:
  * Save and load tasks from JSON, XML.
  * Save and load results to allow to save results between executions and find the inputs for a desired output. 
