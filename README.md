
# Welcome To Task Runner!  
  
[![](https://jitpack.io/v/paz-lavi/TaskRunner.svg)](https://jitpack.io/#paz-lavi/TaskRunner) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/paz-lavi/TaskRunner/blob/master/LICENSE) [![GitHub forks](https://img.shields.io/github/forks/paz-lavi/TaskRunner)](https://github.com/paz-lavi/TaskRunner/network) [![GitHub stars](https://img.shields.io/github/stars/paz-lavi/TaskRunner)](https://github.com/paz-lavi/TaskRunner/stargazers) [![GitHub issues](https://img.shields.io/github/issues/paz-lavi/TaskRunner)](https://github.com/paz-lavi/TaskRunner/issues)
## Table of Contents  
* [Usage](https://github.com/paz-lavi/TaskRunner/blob/master/README.md#usage)  
* [Integration](https://github.com/paz-lavi/TaskRunner/blob/master/README.md#integration)  
* [How To Use](https://github.com/paz-lavi/TaskRunner/blob/master/README.md#how-to-use)  
  *  [Class instanse](https://github.com/paz-lavi/TaskRunner/blob/master/README.md#class-instanse)
  * [Interface instanse](https://github.com/paz-lavi/TaskRunner/blob/master/README.md#interface-instanse)
* [License](https://github.com/paz-lavi/TaskRunner/blob/master/README.md#license)   
  
  
## Usage
  
**Task Runner**  is an Android library that provides a solution for running AsyncTask without using AsyncTask that has been deprecated.

  
## Integration  
  
Add it in your root build.gradle at the end of repositories:  
```css  
   allprojects {  
      repositories {  
         ...  
         maven { url 'https://jitpack.io' }  
      }  
   }  
```  
Add the dependency  
  
```css  
   dependencies {  
	     implementation 'com.github.paz-lavi:TaskRunner:1.0.0'
   }  
```  



##  How To Use  

### Class instanse
**1.** Create a class that extend `BaseTask<R>`
```Java  
public class MyTask extends BaseTask<Long> {
    Context context;

    public MyTask(Context context) {
        this.context = context;
    }

    @Override
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    public Long call() throws Exception {
        long res = 1;
        for (int i = 1; i < 999999999; i++) {
            res += i;
        }
        return res;
    }

    @Override
    public void onPostExecute(Long result) {
        super.onPostExecute(result);
        Toast.makeText(context, String.valueOf(result), Toast.LENGTH_SHORT).show();
    }
}

```

  
**2.** Create an instanse of `TaskRunner<R>`
```Java  
TaskRunner<Long> taskRunner = new TaskRunner<>();
```  
**3.** Execute the task
```Java  
taskRunner.executeAsync(new MyTask(this));
``` 

### Interface instanse
**1.** Create an instanse of `TaskRunner<R>`
```Java  
TaskRunner<Long> taskRunner = new TaskRunner<>();
```  
**2.** Execute new `RunnerCallback<R>` 
```Java  
 taskRunner.executeAsync(new RunnerCallback<Long>() {
            @Override
            public void onPreExecute() {
                Log.d(TAG, "onPreExecute: ");
            }

            @Override
            public Long call() throws Exception {
                long res = 1;
                for (int i = 1; i < 999999999; i++) {
                    res += i;
                }
                return res;
            }

            @Override
            public void onPostExecute(Long result) {
                Log.d(TAG, "onPostExecute: result = " + result);
            }
        });
``` 



## License   
  
```  
Copyright 2020 Paz Lavi  
  
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
  
 https://github.com/paz-lavi/TaskRunner/blob/master/LICENSE  
  
Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.  
```
