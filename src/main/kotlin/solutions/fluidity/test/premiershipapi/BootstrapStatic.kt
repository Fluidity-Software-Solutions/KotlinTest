package solutions.fluidity.test.premiershipapi

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component
import solutions.fluidity.test.premiershipapi.model.boostrapstatic.*
import solutions.fluidity.test.premiershipapi.model.fixtures.FixtureModel
import solutions.fluidity.test.service.FixturesService

private const val GOAL_KEEPER: Long = 1
private const val DEFENDER: Long = 2
private const val MIDFIELDER: Long = 3
private const val FORWARD: Long = 4

@Component
class BootstrapStatic(val fixturesService: FixturesService) {


    fun lookup(): String {
        val client = OkHttpClient()
        val request = Request.Builder().url("https://fantasy.premierleague.com/api/bootstrap-static/")
            .header("Accept", "application/json")
            .header("User-Agent", "Mozilla/5.0").build()
        val response = client.newCall(request).execute()
        val responseBody = response.body!!.string()

        if (response.code < 400) {
            println("yeah we got it")
            val gson = GsonBuilder().create()
            val bootstrapStaticModel: BootstrapStaticModel = gson.fromJson(responseBody, BootstrapStaticModel::class.java)

            val result = fixturesService.getFixtures();
            val fixtures: List<FixtureModel> = fixturesService.parseResponse(result);
            var bootstrapModel = BootstrapModel()

//            val filteredEvents: List<EventModel> =
//                bootstrapStaticModel.events.filter { evt -> evt.finished == false }
//                    .filter { evt -> evt.is_current == true }

            //Temp till we have the new game weeks
            val filteredEvents: List<EventModel> =
                bootstrapStaticModel.events.subList(0, 1)

            getEvents(bootstrapStaticModel, filteredEvents, fixtures)
            setEventPlayerTypes(bootstrapStaticModel, filteredEvents[0])
            bootstrapModel.events = filteredEvents
            return gson.toJson(bootstrapModel, BootstrapModel::class.java)
        }
        return responseBody
    }

    private fun setEventPlayerTypes(
        bootstrapStaticModel: BootstrapStaticModel,
        filteredEvents: EventModel
    ) {
        bootstrapStaticModel.element_types.forEach { _ ->
            filteredEvents.goalKeepers =
                bootstrapStaticModel.elements.filter { el -> el.element_type == GOAL_KEEPER }
            filteredEvents.forwards = bootstrapStaticModel.elements.filter { el -> el.element_type == DEFENDER }
            filteredEvents.midfielders = bootstrapStaticModel.elements.filter { el -> el.element_type == MIDFIELDER }
            filteredEvents.defenders = bootstrapStaticModel.elements.filter { el -> el.element_type == FORWARD }
        }
    }

    private fun getEvents(
        bootstrapStaticModel: BootstrapStaticModel,
        filteredEvents: List<EventModel>,
        fixtures: List<FixtureModel>
    ) {
        filteredEvents.forEach { evt ->
            getEventFixtures(bootstrapStaticModel, fixtures, evt)
        }
    }

    private fun getEventFixtures(
        bootstrapStaticModel: BootstrapStaticModel,
        fixtures: List<FixtureModel>,
        evt: EventModel
    ) {
        val eventFixtures: List<FixtureModel> =
            fixtures.filter { fix -> fix.event == evt.id }

        eventFixtures.forEach { evtFix ->
            getTeams(bootstrapStaticModel, evtFix)
        }
        evt.fixtures = eventFixtures
    }

    private fun getTeams(
        bootstrapStaticModel: BootstrapStaticModel,
        evtFix: FixtureModel
    ) {
        val homeTeam: List<TeamModel> =
            bootstrapStaticModel.teams.filter { t -> t.id == evtFix.team_h }
        val awayTeam: List<TeamModel> =
            bootstrapStaticModel.teams.filter { t -> t.id == evtFix.team_a }

        var teams = TeamsModel()
        teams.homeTeam = homeTeam[0]
        teams.awayTeam = awayTeam[0]

        getPlayers(bootstrapStaticModel, teams)
        evtFix.teams = teams
    }

    private fun getPlayers(
        bootstrapStaticModel: BootstrapStaticModel,
        teams: TeamsModel
    ): TeamsModel {
        val homeTeamPlayers: List<ElementModel> =
            bootstrapStaticModel.elements.filter { elm -> elm.team == teams.homeTeam?.id }
        val awayTeamPlayers: List<ElementModel> =
            bootstrapStaticModel.elements.filter { elm -> elm.team == teams.awayTeam?.id }

       teams.homeTeam?.elements = homeTeamPlayers
       teams.awayTeam?.elements = awayTeamPlayers

        return teams
    }
}