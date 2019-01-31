# Demo
- how to maintain (or persist) screen values during rotation
- using OnSaveInstanceState and onRestoreInstanceState

#### More Info
- very minimal amount of information needs to be placed in state
- probably a couple of values (strings)
- not a good idea to store huge/complex object
- slow performance as the data need to be stored/retrieved from disk (serialization/deserialization takes more time)

#### NOTE
- it is important to note that the values/state in views (or controls) are automatically maintained by android system 
- the member variables/fields of activity are destroyed during rotation and those are supposed to be manually maintained
- In this example, we are still trying to store view values in state, which is not quite necessary (but, just to show an example)

		
## Activity Event Life Cycle

#### Scenario #1

--start of app
- test-MainActivity: OnCreate
- test-MainActivity: OnStart
- test-MainActivity: OnResume

--switch to another activity
- test-MainActivity: OnPause
- test-MainActivity: OnStop
- test-MainActivity: OnSaveInstanceState

--back button - to this activity
- test-MainActivity: OnRestart
- test-MainActivity: OnStart
- test-MainActivity: OnResume

--back button to home 
- test-MainActivity: OnPause
- test-MainActivity: OnStop
- test-MainActivity: OnDestroy

--switching back from Recent Apps 
- test-MainActivity: OnCreate
- test-MainActivity: OnStart
- test-MainActivity: OnResume

#### Scenario #2

--start of app
- test-MainActivity: OnCreate
- test-MainActivity: OnStart
- test-MainActivity: OnResume

--switch to another activity
- test-MainActivity: OnPause
- test-MainActivity: OnStop
- test-MainActivity: OnSaveInstanceState

--back button - to this activity
- test-MainActivity: OnRestart
- test-MainActivity: OnStart
- test-MainActivity: OnResume

--home button
- test-MainActivity: OnPause
- test-MainActivity: OnStop
- test-MainActivity: OnSaveInstanceState

--switching back from Recent Apps 
- test-MainActivity: OnRestart
- test-MainActivity: OnStart
- test-MainActivity: OnResume

#### Scenario #3

--start of app
- test-MainActivity: OnCreate
- test-MainActivity: OnStart
- test-MainActivity: OnResume

--rotate
- test-MainActivity: OnPause
- test-MainActivity: OnStop
- test-MainActivity: OnSaveInstanceState
- test-MainActivity: OnDestroy
- test-MainActivity: OnCreate
- test-MainActivity: OnStart
- test-MainActivity: OnRestoreInstanceState
- test-MainActivity: OnResume

## Images

![01.png](images/01.png?raw=true "01.png")
---
![02.png](images/02.png?raw=true "02.png")
---
![03.png](images/03.png?raw=true "03.png")
