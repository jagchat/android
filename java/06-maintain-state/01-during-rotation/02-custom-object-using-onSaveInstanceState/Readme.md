# Demo
- how to maintain (or persist) screen values during rotation
- using OnSaveInstanceState and onRestoreInstanceState with a parcelable custom object

#### More Info
- very minimal amount of information needs to be placed in state
- probably a couple of values (strings)
- not a good idea to store huge/complex object
- slow performance as the data need to be stored/retrieved from disk (serialization/deserialization takes more time)

#### NOTE
- it is important to note that the values/state in views (or controls) are automatically maintained by android system 
- the member variables/fields of activity are destroyed during rotation and those are supposed to be manually maintained
- In this example, we are still trying to store view values in state, which is not quite necessary (but, just to show an example)

## Features
- using parcelable custom object to store in state (need to have plugin installed for easy creation)

## UI Features
- How to install parcelable plug-in for Android Studio

## Images

![01.png](images/01.png?raw=true "01.png")
---
![02.png](images/02.png?raw=true "02.png")
---
![03.png](images/03.png?raw=true "03.png")
