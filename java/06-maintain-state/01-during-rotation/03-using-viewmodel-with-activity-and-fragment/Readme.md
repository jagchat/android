# Demo
- how to maintain state during rotation using viewmodel (custom) object 

#### More Info
- viewmodel object can be a complex object (persisted in memory and not on disk)
- fast performance (compared to OnRestoreInstanceState) as the data gets stored/retrieved from memory, instead of disk
- viewmodel created in an activity can be referred by fragments (without passing as parameters)
- viewmodel is not quite a replacement for "OnSaveInstanceState/OnRestoreInstanceState" (it has its own pros/cons)
- there is no "OnRestoreInstanceState" for fragment (instead we use "onActivityCreated")
- we would need to include the following as dependencies when working with viewmodel (Gradle Scripts | build.gradle)
```
implementation "android.arch.lifecycle:extensions:1.1.1"
implementation "android.arch.lifecycle:viewmodel:1.1.1"
```

#### NOTE
- it is important to note that the values/state in views (or controls) with "id"s are automatically maintained by android system 
- we can disable views/controls to retain state automatically by setting 'android:saveEnabled="false"' - we did this in our example
- the member variables/fields of activity are destroyed during rotation and those are supposed to be manually maintained
- state of activity is different from that of fragment

## Features
- how to create and use viewmodel object for maintaing state while rotating device
- using 'android:saveEnabled="false"'
- using "onActivityCreated" in fragment
- how to use text changed listener for EditText views
- how to access viewmodel in activity from within fragment (event during rotation)
- how to call fragment method from activity
- how to maintain activity state using viewmodel


## Images

![01.png](images/01.png?raw=true "01.png")
---
![02.png](images/02.png?raw=true "02.png")
