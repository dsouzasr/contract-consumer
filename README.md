# SpringCloud Contract Consumer Demo

This example demonstrates hows consumers of contracts can be tested without having to download the providers but just work out of the stubs provided by the consumer to the providers code base or the stubs provided by the provider.

For consumers we needed to we need to add the Stub Runner as a dependency to the Gradle build

    dependencies {
        testCompile("org.springframework.cloud:spring-cloud-starter-contract-stub-runner:${verifier_version}")
        // ... other dependencies
    }
    
With the Stub Runner in place, we create an integration test for our consumer code :

    @AutoConfigureStubRunner(
        ids = "io.selflearning:user-service:+:stubs:6565", 
        workOffline = true)

With the @AutoConfigureStubRunner annotation we tell the Stub Runner to load the Maven artifact with

* the groupId io.selflearning,
* the artifactId user-service,
* of the newest version (+) and
* with the stubs qualifier

from a Maven repository, extract the contract from it and pass it into the Stub Runner who then acts as the API provider on port 6565. The workOffline flag is set to true meaning that the artifact should be resolved against the local maven repository on our machine for now.


In order for the Stub Runner to find the online Maven repository, we need to tell it where to look in the application.yml:

    stubrunner:
      repositoryRoot: http://path.to.repo/repo-name