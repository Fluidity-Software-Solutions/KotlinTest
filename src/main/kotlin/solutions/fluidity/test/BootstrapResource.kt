package solutions.fluidity.test

import org.springframework.stereotype.Component
import solutions.fluidity.test.service.BootstrapService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("bootstrap")
class BootstrapResource(val bootstrapService: BootstrapService) {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun getBootstrapStatic(): Response? {
        val result = bootstrapService.getBootstrapData();
        return Response.ok(result).build()
    }
}