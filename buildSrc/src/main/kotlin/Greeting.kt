import org.gradle.api.DefaultTask
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

open class Greeting @Inject constructor(objects: ObjectFactory): DefaultTask() {
    val message: Property<String> = objects.property()
    val recipient: Property<String> = objects.property()
    @TaskAction
    fun greet() {
        println("$message, $recipient!")
    }
}