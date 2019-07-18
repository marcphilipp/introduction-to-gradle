import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering
import org.gradle.kotlin.dsl.the

class IntegrationTestPlugin: Plugin<Project> {

    override fun apply(project: Project) {

        project.pluginManager.apply(JavaPlugin::class)

        val sourceSets = project.the<SourceSetContainer>()

        val integrationTestSourceSet = sourceSets.create("integrationTest") {
            compileClasspath += sourceSets["main"].output
            runtimeClasspath += sourceSets["main"].output
        }

        project.configurations {
            named(integrationTestSourceSet.implementationConfigurationName) {
                extendsFrom(project.configurations["testImplementation"])
            }
            named(integrationTestSourceSet.runtimeOnlyConfigurationName) {
                extendsFrom(project.configurations["testRuntimeOnly"])
            }
        }

        project.tasks {
            val integrationTest by registering(Test::class) {
                description = "Runs the integration tests."
                group = "verification"
                testClassesDirs = integrationTestSourceSet.output.classesDirs
                classpath = integrationTestSourceSet.runtimeClasspath
                mustRunAfter(named("test"))
            }

            named("check") {
                dependsOn(integrationTest)
            }
        }

    }
}