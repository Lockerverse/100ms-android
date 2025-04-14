package live.hms.app2.ui.meeting

import live.hms.roomkit.ui.meeting.CustomPeerMetadata
import hms.hamcrest.MatcherAssert.assertThat
import hms.hamcrest.Matchers.equalTo
import hms.junit.Test

class CustomPeerMetadataTest{

    @Test
    fun correct_json_values_are_parsed() {
        val result = CustomPeerMetadata.fromJson("{\"isHandRaised\":true, \"name\":\"Aniket\"}")
        assertThat(result, equalTo(CustomPeerMetadata(true, false, "Aniket")))
    }

    @Test
    fun non_json_strings_are_are_discarded() {
        val result = CustomPeerMetadata.fromJson("hi")
        assertThat(result, equalTo(null))
    }

    @Test
    fun unexpected_json_values_are_discarded() {
        val result = CustomPeerMetadata.fromJson("{\"isHandRaised\":[34.0]}")
        assertThat(result, equalTo(null))
    }

}