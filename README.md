## Aspect I/O Method handler


![picture](https://img.shields.io/badge/Java-11.0.1-green)
![picture](https://img.shields.io/badge/aspectj-1.9.2-%23FF453C.svg)

**Catch and handle or just log method's I/O/Exceptions**

This is convinient input/output handler & logger. You can use it to handle and/or log any input and/or output from any method. You can also use this module as Request/Response logger for any controller or REST controller or any other purpose.


![picture](/jlogger/files/jlogger.png)


*Module is compatible with Spring 5, you can use it in any from your projects (not only Spring ones) but also you can use it with Spring 5 and org.springframework.http.ResponseEntity class*

---

## Install

Install from sources.

Current version is 1.0.1-SNAPSHOT. Version 1.0.1 Stable will be added to Maven Central.


---

## Overview

To use this module just simply add a @Logger annotation to your function/method/clousure or rest controller method as below.

```java
class MyController{

    @Logger  // <- add this annotation to start logging method's input and output
    public ResponseEntity<WalletResponseDto> method(){}
    
}
```

You can also set some additional options and customize handling behaviour or even set up your own I/O handller.
    
```java
class MyController{    
    @Logger(
            logResponseDurationTime = true,
            logRequestTime = true,
            timeZone = "UTC",
            includeStackTrace = true,
            filterStackTraceToPackage = "com.github.hadasbro.jlogger",
            logOnlyOnRequestValue = "userId:350",
            logTypes = {Logger.TYPE.REQUEST, Logger.TYPE.RESPONSE}
            loggerHandler = MyOwnhandler.class
    
    )
    public ResponseEntity<WalletResponseDto> method(){}
}
```

Function/method Input/Request should implement interface *LoggableRequest* or, if you use Spring Framework 5 - *ResponseEntity*
 
Function/method Output/Response should implement interface *LoggableResponse*;

Custom logger/handler should implement interface *LoggerHandler*;

If you want to catch function/method Exception you should implement interface *LoggableException*;

---

## Options

If you don't specify any additional options, module will be working as a simple I/O logger, so every method input and output will be logged to log as "info". You can also customize this behaviour and also set up your own handler as below.

1. logResponseDurationTime [ default: true ] - add/log **duration** (e.g. for REST controller this is gonna be just response time).
	    
    ```java
    @Logger(logResponseDurationTime = true)
    ```
		
2. logRequestTime [ default: true ] - add **request/input datetime** to log.
	
    ```java
    @Logger(logResponseDurationTime = true)
    ```
	
3. timeZone [ default: "UTC" ] - set up timezone for request/input, to be loggeg/handled.
	
    ```java
    @Logger(timeZone = "Europe/Warsaw")
    ```

4. includeStackTrace [ default: false ] - add stack trace to log/handler.
	
    ```java 
    @Logger(includeStackTrace = true)
    ```

5. filterStackTraceToPackage [ default: not settled, no limit ] - limit stack trace log to wanted package only.
	
    ```java
    @Logger(filterStackTraceToPackage = "org.bitbucket.slawekhaa")
    ```

6. logOnlyOnRequestValue - handle/log input **only if** method/function contains param "param" and INPUT.param == value
        
    ```java
    // log or handle only if Request/Input contains param userId and userId == 250, otherwise ommit
    @Logger(logOnlyOnRequestValue = "userId:350")
    ```

    > You can use this option to log in your REST controller request - responses conditionally, only if input contains required parameter and value*

7. logTypes - handle/log only wanted actions (request, response, exception, all of them or only specific ones)
	
    ```java
    // log or handle request and response, input and output
    @Logger(logTypes = {Logger.TYPE.REQUEST, Logger.TYPE.RESPONSE}) 
    
    // log or handle request/input only
    @LoggerlogTypes = Logger.TYPE.REQUEST)
    ```

8. loggerHandler - **declare custom handler** for all I/O action/log

    ```java
    // use your own handler class
    @Logger(loggerHandler = MyOwnhandler.class) 
    
    // handler must implement interface LoggerHandler for example:
    public class MyOwnhandler implements LoggerHandler {
    
        private static String JOIN_SEPARATOR = " | ";
    
        private StringBuilder logResult = new StringBuilder();
    
        // this method will be called first, at the beginnig of Handler creation
        // this is kind of constructor, you can use this method to init your handler
        @Override
        public void init() {}
    
        // this method will be callest last, finally when module finish work
        // this is kind of destructor, you can use this method to finish work, e.g. to log result etc.
        @Override
        public void end() {
            // log to database
            StringUtils.strip(logResult.toString(), JOIN_SEPARATOR);
        }
    
        // this method will be called on request/input and will have an input object injested as a parameter
        @Override
        public void logRequest(LoggableRequest request, LoggerDetails loggerDetails) {
            logResult.append(" request: ").append(request).append(JOIN_SEPARATOR);
        }
    
        // this method will be called on response/output and will have an output object injested as a parameter
        @Override
        public void logResponse(LoggableResponse response, LoggerDetails loggerDetails) {
        
            logResult.append(" response: ").append(response).append(JOIN_SEPARATOR);
        
            if(!loggerDetails.getStackTrace().equals("")) {
                logResult.append(" trace: ").append(loggerDetails.getStackTrace());
            }
        }
    }
    ```

    > Above handler class is a simple REST logger, every request & response handled by REST controller methods which are marked as @Logger(loggerHandler = MyOwnhandler.class) will be logged into a log.*

---

## Real example

This is REST controller/service logger example. 
Request (contaigning userId == 350) and response for method *MyRestController::create* will be logged to DB automatically.


```java
package org.bitbucket.slawekhaa;

public class UserDto {

    public Integer id;
    public String name;
    
    public String toString(){
        return "id: " + id + ", name" + name;
    }
}

public class Response {

    public Integer status;
    public String message;
    
    Response(Integer status, String message) {
        this.status  = status;
        this.message  = message;
    }
    public String toString(){
        return "status:" + status + ", message: " + message;
    }
}

// example of request:
// {"id":1,"name":"super user}

@RestController
@RequestMapping("/rest/")
class MyRestController {

    @Logger(
        logResponseDurationTime = true,
        logRequestTime = true,
        includeStackTrace = true,
        filterStackTraceToPackage = "org.bitbucket.slawekhaa",
        logOnlyOnRequestValue = "userId:350",
        logTypes = Logger.TYPE.ALL, 
        loggerHandler = MyOwnhandler.class

    )
    @RequestMapping(value="create", method = RequestMethod.POST)
    public ResponseEntity<? extends Response> create(@RequestBody UserDto user) {

            // ... do some stuff
            return ResponseEntity.ok(new Response(1, "OK"));

    }
    
}
```


> Result: every request which contains parameter userId == 350 and corresponding response for service `MyRestController::test` will be catched and handled by `MyOwnhandler` and logged in to the DB including stack trace limitd to package `org.bitbucket.slawekhaa`.


    2019-04-01 12:00:28 request: [id: 1, name: super user] | response: [status: 1, message: OK] | duration: 245ms | trace:  ... -> MyRestController.create()
    
---

## Authors

* **Slawomir Hadas** - *author* - [Github](https://github.com/hadasbro)

---

## Todo, future releases

New interceptors and handler types.

    enum TYPE{
        ALL,
        REQUEST,
        RESPONSE,
        ERROR,  // TODO
        TRACE   // TODO
    }
