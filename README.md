# Getting Started

## Note

<font color="red">Never store any credentials ( like GitHub Client ID and Secret ) in the public repos as anyone can 
see them and can use them to interact with your GitHub account.</font>

### Summary

This is a demo OAuth2 server created using SpringBoot3 (and Spring Security 6.x). The server leverages the inbuilt 
Spring Security Filter for OAuth2 authentication to authenticate a user using their GitHub credentials. This is done 
by using the application permissions configured within the GitHub account.

### System Requirement
* Java 21 installed

### Steps

* Go to your GitHub account (create one if you don't have one already)
* Navigate to the [GitHub Developer Settings portal](https://github.com/settings/developers)
* Then create OAuth2 app by clicking the green button `New OAuth app`. Provide below 2 values for the new OAuth app 
  enrollment
  * `Homepage URL = http://localhost:8080`
  * `Callback URL = http://localhost:8080/login/oauth2/code/github`
* Once OAuth app is created
  * Grab the `Client ID` and the `Client Secret` from the new GitHub OAuth app
* Paste them in the `application.properties` file under settings
  * `spring.security.oauth2.client.registration.github.clientId`
  * `spring.security.oauth2.client.registration.github.clientSecret`
* Now start this SpringBoot App in your preferred IDE
* Then navigate to the `http:\\localhost:8080`
  * For the 1st time, the app will redirect you to the GitHub account to grant permission to this app
  * Once the permission is granted, then any future interactions will not require any redirects (or at least it 
    won't be too quick to notice)

### What next?

* This base app can be extended to your specific needs and all you need to do is to update the `AppConfig.java` 
  with how you would like your resources to get authenticated/authorized.