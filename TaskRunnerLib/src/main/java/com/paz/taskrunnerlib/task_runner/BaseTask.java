package com.paz.taskrunnerlib.task_runner;

import android.util.Log;

/**
 * abstract class for implementing TaskRunner
 *
 * @param <R> - the return type of call() (equivalent for doInBackground) and the result param type for onPostExecute
 */
public abstract class BaseTask<R> implements RunnerCallback<R> {
    private final String TAG = "_" + getClass().getSimpleName();

    @Override
    public void onPreExecute() {
        Log.d(TAG, "onPreExecute: ");
    }

    @Override
    public R call() throws Exception {
        Log.d(TAG, "call: ");
        return null;
    }

    @Override
    public void onPostExecute(R result) {
        Log.d(TAG, "onPostExecute: result = " + result);

    }
}
