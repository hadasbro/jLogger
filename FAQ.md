Frequently Asked Questions
----

If you have any questions, please feel free to contact me.

#### What does this library is usefult to?

This is convinient input/output handler & logger. You can use it to handle and/or log any input and/or output from any method. 

#### Examples
Use as singleton:

```java
class MyController{

    @Logger  // <- add this annotation to start logging method's input and output
    public ResponseEntity<WalletResponseDto> method(){}
    
}
```
    