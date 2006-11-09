package opennlp.maxent;

/**
 * This interface allows one to implement a prior distribution for use in
 * maximum entropy model training.  
 * @author Tom Morton
 *
 */
public interface Prior {
  /**
   * Populates the specified array with the the log of the distribution for the specified context.  
   * The returned array will be overwritten and needs to be re-initialized with every call to this method.  
   * @param dist An array to be populated with the log of the prior distribution.
   * @param context The indices of the contextual predicates for an event.
   */
  public void logPrior(double[] dist, int[] context);
}