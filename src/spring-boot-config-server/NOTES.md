
```shell
***************************
APPLICATION FAILED TO START
***************************

Description:

No spring.config.import property has been defined

Action:

Add a spring.config.import=configserver: property to your configuration.
	If configuration is not required add spring.config.import=optional:configserver: instead.
	To disable this check, set spring.cloud.config.enabled=false or
	spring.cloud.config.import-check.enabled=false.
```