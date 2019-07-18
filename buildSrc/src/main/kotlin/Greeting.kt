import org.gradle.api.DefaultTask
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

open class Greeting @Inject constructor(objects: ObjectFactory): DefaultTask() {
    val message = objects.property<String>().convention("Hello")
    val recipient = objects.property<String>()
    init {
        group = "welcome"
        description = "Produces a greeting"
    }
    @TaskAction
    fun print() = println("${message.get()}, ${recipient.get()}!")
}
