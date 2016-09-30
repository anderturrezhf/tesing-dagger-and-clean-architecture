1. Project has no purpose of real utility or functionality, just show how to implement a new
project on gradle files and structure for a clean architecture with the dependencies you need.

2. Architecture is based on Uncle Bob's Clean Architecture and uses Dagger as dependency injection
framework. I have chosen to use 3 layers: presentation (Android module) and 2 Java modules where
goes the application related logic implementation (app-business-rules) and the models,
repository pattern, POJOs according to possible backend logic and other abstractions (enterprise-business-rules)

4. Annotations go above only if they are used on a method. For variables or fields, they go
immediately before they are declared.