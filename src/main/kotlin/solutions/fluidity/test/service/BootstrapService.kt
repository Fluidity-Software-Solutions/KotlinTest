package solutions.fluidity.test.service

import org.springframework.stereotype.Component
import solutions.fluidity.test.premiershipapi.BootstrapStatic

@Component
class BootstrapService(
    val bootstrapStatic: BootstrapStatic
) {

    fun getBootstrapData(): String{
        val result = bootstrapStatic.lookup();
        return result;
    }
}