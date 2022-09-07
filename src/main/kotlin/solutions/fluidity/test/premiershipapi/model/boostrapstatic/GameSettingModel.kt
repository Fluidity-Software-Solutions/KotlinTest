package solutions.fluidity.test.premiershipapi.model.boostrapstatic

class GameSettingModel {
    var league_join_private_max: Long? = null
    var league_join_public_max: Long? = null
    var league_max_size_public_classic: Long? = null
    var league_max_size_public_h2h: Long? = null
    var league_max_size_private_h2h: Long? = null
    var league_max_ko_rounds_private_h2h: Long? = null
    var league_prefix_public: String? = null
    var league_points_h2h_win: Long? = null
    var league_points_h2h_lose: Long? = null
    var league_points_h2h_draw: Long? = null
    var league_ko_first_instead_of_random: String? = null
    var cup_start_event_id: Long? = null
    var cup_stop_event_id: Long? = null
    var cup_qualifying_method: String? = null
    var cup_type: String? = null
    var squad_squadplay: Long? = null
    var squad_squadsize: Long? = null
    var squad_team_limit: Long? = null
    var squad_total_spend: Long? = null
    var ui_currency_multiplier: Long? = null
    var ui_use_special_shirts: String? = null
    var ui_special_shirt_exclusions: List<String> = mutableListOf()
    var stats_form_days: Long? = null
    var sys_vice_captain_enabled: String? = null
    var transfers_cap: Long? = null
    var transfers_sell_on_fee: String? = null
    var league_h2h_tiebreak_stats: List<String> = mutableListOf()
    var timezone: String? = null
}