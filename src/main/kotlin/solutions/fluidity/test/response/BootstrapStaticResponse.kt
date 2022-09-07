package solutions.fluidity.mtfl.resource.response

data class BootstrapStaticResponse<T>(val status: String, val message: String, val data: T? = null)