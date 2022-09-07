package solutions.fluidity.test

import org.springframework.stereotype.Component
import solutions.fluidity.test.service.FixturesService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("fixtures")
class FixturesResource(val fixturesService: FixturesService) {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun getFixtures(): Response? {
        val result = fixturesService.getFixtures();
        return Response.ok(result).build()
    }
}