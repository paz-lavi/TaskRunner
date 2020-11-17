package com.paz.taskrunnerlib.task_runner;


import java.util.concurrent.Callable;

/**
 * interface for executing TaskRunner
 *
 * @param <R> - the return type of call() (equivalent for doInBackground) and the result param type for onPostExecute
 */
public interface RunnerCallback<R> extends Callable<R> {


    /**
     * call to perform before starting the background task
     */
    void onPreExecute();

    /**
     * this is the equivalent for doInBackground (AsyncTask)
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    R call() throws Exception;

    /**
     * call after the task finished
     *
     * @param result -  the task result
     */
    void onPostExecute(R result);
}

