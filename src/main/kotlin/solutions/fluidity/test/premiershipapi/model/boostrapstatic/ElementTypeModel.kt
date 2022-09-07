package solutions.fluidity.test.premiershipapi.model.boostrapstatic

class ElementTypeModel {
    var id: Long? = null
    var plural_name: String? = null
    var plural_name_short: String? = null
    var singular_name: String? = null
    var singular_name_short: String? = null
    var squad_select: Long? = null
    var squad_min_play: Long? = null
    var squad_max_play: Long? = null
    var ui_shirt_specific: String? = null
    var sub_positions_locked: List<Long> = mutableListOf()
    var element_count: Long? = null
}