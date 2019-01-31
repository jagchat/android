# Demo
- how to maintain (or persist) screen values during rotation
- using OnSaveInstanceState and onRestoreInstanceState

## Activity Event Life Cycle

######Scenario #1

--start of app
test-MainActivity: OnCreate
test-MainActivity: OnStart
test-MainActivity: OnResume

--switch to another activity
test-MainActivity: OnPause
test-MainActivity: OnStop
test-MainActivity: OnSaveInstanceState

--back button - to this activity
test-MainActivity: OnRestart
test-MainActivity: OnStart
test-MainActivity: OnResume

--back button to home 
test-MainActivity: OnPause
test-MainActivity: OnStop
test-MainActivity: OnDestroy

switching back from Recent Apps 
test-MainActivity: OnCreate
test-MainActivity: OnStart
test-MainActivity: OnResume

Scenario #2

--start of app
test-MainActivity: OnCreate
test-MainActivity: OnStart
test-MainActivity: OnResume

--switch to another activity
test-MainActivity: OnPause
test-MainActivity: OnStop
test-MainActivity: OnSaveInstanceState

--back button - to this activity
test-MainActivity: OnRestart
test-MainActivity: OnStart
test-MainActivity: OnResume

--home button
test-MainActivity: OnPause
test-MainActivity: OnStop
test-MainActivity: OnSaveInstanceState

--switching back from Recent Apps 
test-MainActivity: OnRestart
test-MainActivity: OnStart
test-MainActivity: OnResume

Scenario #3

--start of app
test-MainActivity: OnCreate
test-MainActivity: OnStart
test-MainActivity: OnResume

--rotate
test-MainActivity: OnPause
test-MainActivity: OnStop
test-MainActivity: OnSaveInstanceState
test-MainActivity: OnDestroy
test-MainActivity: OnCreate
test-MainActivity: OnStart
test-MainActivity: OnRestoreInstanceState
test-MainActivity: OnResume

### Images

![01.png](images/01.png?raw=true "01.png")
---
![02.png](images/02.png?raw=true "02.png")
---
![03.png](images/03.png?raw=true "03.png")
