1. Project has no purpose of real utility or functionality, just show how to implement a new
project on gradle files and structure for a clean architecture with the dependencies you need.

2. Architecture is based on Uncle Bob's Clean Architecture and uses Dagger as dependency injection
framework. RxJava is not used at the moment but it may come soon (dependencies are added).

3. We have to work always with interfaces, not with the object directly in order to preserve
the architecture correct. That's why on Dagger the return type is always the interface.

4. Annotations go above only if they are used on a method. For variables or fields, they go
immediately before they are declared.

5. Use rxJava to preserve the Architecture rules instead of Callbacks. It is a really powerful tool.