package solutions.fluidity.test.premiershipapi

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import solutions.fluidity.test.premiershipapi.model.fixtures.FixtureModel
import java.lang.reflect.Type

@Component
class Fixtures() {

    fun fixturesLookup(): String {

        val client = OkHttpClient()
        val request = Request.Builder().url("https://fantasy.premierleague.com/api/fixtures/")
            .header("Accept", "application/json")
            .header("User-Agent", "Mozilla/5.0").build()

        val response = client.newCall(request).execute()
        val responseBody = response.body!!.string()

        if (response.code >= 400) {
            println("error")
            println("ok2")

//        val typeToken = object : TypeToken<List>() {}.type
//        val authors = Gson().fromJson<List>(json, typeToken)
//        val responseMap = GsonJsonParser().parseMap(responseBody)
        }
        return responseBody
    }

    fun parseResponse(responseBody: String):List<FixtureModel> {
        val gson = GsonBuilder().create()
        // java.lang.reflect.Type
        val listType: Type = object : TypeToken<List<FixtureModel?>?>() {}.getType()
        return gson.fromJson(responseBody, listType)
//        val fixtures: List<FixtureModel> = gson.fromJson<List<FixtureModel>>(responseBody, listType)
//        return fixtures
    }

}