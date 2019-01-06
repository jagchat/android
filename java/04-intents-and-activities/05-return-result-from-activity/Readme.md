# Demo
- How to return values (in the form of a custom object) from child activity to parent activity

### Features
- pass values from source activity to target activities using "custom object" with the help of intent
- use "startActivityForResult" to register/wait for result from child activity
- fetch custom object in target activity using "getSerializableExtra" method of intent
- fetch values in target activity using "get" methods of custom object
- create result (custom) object to return to parent (using "setResult")
- "finish" after returning (using "finish")
- retrieve returned result in parent activity using (onActivityResult)

### UI Feature
- in order to create a new class, right click on app | java | <your package> and select New | Java Class
