/**
 * Package responsible for processing the data to be consumed by other packages or outside applications
 * such as R scripts. Follows a list of some classes in the package:
 * 
 * JoinAnswerWorker.java = produces a CSV file in which each row is an answer with all attributes from the answer, 
 * question, and the corresponding worker who produced the answer. This CSV file is utilized to run train 
 * a Decision Tree implemented in an R script.
 *
 */

/**
 * @author chris
 *
 */
package luciola.data.wrangling;