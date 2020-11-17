package com.paz.taskrunnerlib.task_runner;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Java class to perform AsyncTask without the deprecated API
 *
 * @param <R> - the type of the return value from background
 */
public class TaskRunner<R> {
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    /**
     * execute in the background
     *
     * @param callback - a RunnerCallback<R> instance with a task to execute in the background
     */
    public void executeAsync(RunnerCallback<R> callback) {
        executor.execute(() -> {
            try {
                callback.onPreExecute();
                executor.execute(new RunnableTask<>(handler, callback));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private static class RunnableTask<R> implements Runnable {
        private final Handler handler;
        private final RunnerCallback<R> callable;

        public RunnableTask(Handler handler, RunnerCallback<R> callable) {
            this.handler = handler;
            this.callable = callable;
        }

        @Override
        public void run() {
            try {
                final R result = callable.call();
                handler.post(new RunnableTaskForHandler<R>(callable, result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class RunnableTaskForHandler<R> implements Runnable {

        private final RunnerCallback<R> callable;
        private final R result;

        public RunnableTaskForHandler(RunnerCallback<R> callable, R result) {
            this.callable = callable;
            this.result = result;
        }

        @Override
        public void run() {
            callable.onPostExecute(result);
        }
    }
}
