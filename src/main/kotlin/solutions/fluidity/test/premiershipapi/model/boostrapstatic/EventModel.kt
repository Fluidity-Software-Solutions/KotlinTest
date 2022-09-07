package solutions.fluidity.test.premiershipapi.model.boostrapstatic

import solutions.fluidity.test.premiershipapi.model.fixtures.FixtureModel

class EventModel {
    var id: Long? = null
    var name: String? = null
    var deadline_time: String? = null
    var average_entry_score: String? = null
    var finished: Boolean? = null
    var data_checked: String? = null
    var highest_scoring_entry: String? = null
    var deadline_time_epoch: Long? = null
    var deadline_time_game_offset: String? = null
    var highest_score: String? = null
    var is_previous: String? = null
    var is_current: Boolean? = null
    var is_next: String? = null
//    var cup_leagues_created: String? = null
//    var h2h_ko_matches_created: String? = null
//    var chip_plays: List<ChipPlayModel>? = mutableListOf()
//    var most_selected: String? = null
//    var most_transferred_in: String? = null
//    var top_element: String? = null
//    var top_element_info: TopElementInfo? = null
//    var transfers_made: String? = null
//    var most_captained: String? = null
//    var most_vice_captained: String? = null
    var fixtures: List<FixtureModel> = mutableListOf()
    var goalKeepers: List<ElementModel> = mutableListOf()
    var forwards: List<ElementModel> = mutableListOf()
    var defenders: List<ElementModel> = mutableListOf()
    var midfielders: List<ElementModel> = mutableListOf()
}