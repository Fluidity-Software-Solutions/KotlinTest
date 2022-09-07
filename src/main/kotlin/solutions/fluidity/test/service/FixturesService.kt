package solutions.fluidity.test.service

import org.springframework.stereotype.Component
import solutions.fluidity.test.premiershipapi.Fixtures
import solutions.fluidity.test.premiershipapi.model.fixtures.FixtureModel

@Component
class FixturesService(
    val fixtures: Fixtures
) {

    fun getFixtures(): String {
        val result = fixtures.fixturesLookup();
        return result;
    }

    fun parseResponse(responseBody: String): List<FixtureModel> {
        val fixtures: List<FixtureModel> = fixtures.parseResponse(responseBody);
        return fixtures
    }
}