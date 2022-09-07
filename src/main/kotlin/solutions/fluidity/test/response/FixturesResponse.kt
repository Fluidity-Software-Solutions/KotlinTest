package solutions.fluidity.test.response

data class FixturesResponse<T>(val status: String, val message: String, val data: T? = null)