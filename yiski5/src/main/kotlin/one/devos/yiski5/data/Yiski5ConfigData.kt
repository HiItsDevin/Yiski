package one.devos.yiski5.data

import kotlinx.serialization.Serializable
import one.devos.yiski.common.AbstractYiskiConfig

@Serializable
data class Yiski5ConfigData(
    val bot: BotConfig,
    val channels: ChannelConfig,
    val filters: FiltersConfig
) : AbstractYiskiConfig {

    @Serializable
    data class BotConfig(
        val timezone: String = "America/Los_Angeles",
        val daysAhead: Long = 1,
        val resetInterval: Long = 24,
        val initialResetHour: Long = 0,
        val initialResetMinute: Long = 0
    )

    @Serializable
    data class ChannelConfig(
        val vent: String,
        val ventLog: String,
        val ventAttachments: String
    )

    @Serializable
    data class FiltersConfig(
        val webhooks: Boolean,
        val bots: Boolean,
        val pinned: Boolean,
        val system: Boolean,
        val messages: List<Long>,
        val authors: List<Long>
    )

}