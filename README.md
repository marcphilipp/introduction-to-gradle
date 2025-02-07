# Introduction to Gradle

This is a sample repository that demonstrates some of the features of the [Gradle build tool](https://gradle.org).
Please review the commit history of this repository from the start to see the evolution of the build:

- Use `gradle init` to create a new Java application project
- Register `zipSources` task that reuses an existing task class
- Add adhoc `helloWorld` task
- Define and use custom `Greeting` task class
- Use the Provider API in the custom task class
- Move custom task class to `buildSrc`
- Convert the build into a multi-project build with `app` and `lib` subprojects
- Illustrate difference between `api` and `implementation` dependencies
- Use `subprojects` block to remove duplication
- Centralize dependency version declarations in root build script
- Make it a Spring Boot app to showcase BOM support
- Introduce `integrationTest` source set and task
- Extract `integrationTest` config into separate buildscript
- Refactor build script into pre-compiled script plugin
- Convert pre-compiled script plugin into binary plugin
- Configure build scan plugin

## License

This code is open source software licensed under the [Apache 2.0 License](LICENSE.txt).
