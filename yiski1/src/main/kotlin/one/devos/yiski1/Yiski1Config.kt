package one.devos.yiski1

import com.akuleshov7.ktoml.file.TomlFileReader
import kotlinx.serialization.serializer
import one.devos.yiski.common.AbstractYiskiConfig
import one.devos.yiski.common.annotations.YiskiModule
import one.devos.yiski.common.entrypoints.ConfigSetupEntrypoint
import one.devos.yiski1.data.Yiski1ConfigData
import kotlin.system.exitProcess

@OptIn(YiskiModule::class)
class Yiski1Config : ConfigSetupEntrypoint {

    private val configPath = System.getProperty("yiski1_config", "yiski1.config.toml")

    override lateinit var config: Yiski1ConfigData

    override fun read() {
        config = try {
            logger.info { "Attemping to load config" }
            TomlFileReader.decodeFromFile(serializer(), configPath)
        } catch (e: Exception) {
            logger.error {
                """
                    
                    
                    #######################################################
                    #                                                     #
                    #    oopsies woopsies we did a wittle fwucky wucky    #
                    #                                                     #
                    #######################################################
                    
                """.trimIndent()
                e
            }
            exitProcess(1)
        }
    }
}
