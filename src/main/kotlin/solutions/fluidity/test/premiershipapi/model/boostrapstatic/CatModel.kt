package solutions.fluidity.test.premiershipapi.model.boostrapstatic

import com.google.gson.annotations.SerializedName

class CatModel {
//    var length: Long? = null
    @SerializedName("length") var length: String? = null
    @SerializedName("fact") var fact: String? = null
}