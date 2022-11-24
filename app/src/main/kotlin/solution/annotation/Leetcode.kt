package solution.annotation

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation  class Leetcode (val id: Int)

data class LeetcodeMetaInfo(
    val id: Int,
    val level: String,
    val link: String,
    val rating: Int,
    val hint: String?) {
}

object LeetcodeMetaConfig
{
    private var leetcodeMetatable = hashMapOf<Int, LeetcodeMetaInfo>()
    init
    {
        val yamlPath = "src/main/resources/leetcode_meta.yaml"
        val mapper = ObjectMapper(YAMLFactory()).registerKotlinModule()
        val values = mapper.readValue(File(yamlPath), object: TypeReference<List<LeetcodeMetaInfo>>() {})
        for (v in values) {
            leetcodeMetatable[v.id] = v
        }
    }

    fun getMetaFromID(id: Int): LeetcodeMetaInfo {
        return leetcodeMetatable[id] ?: LeetcodeMetaInfo(id=0, level = "", link= "", rating = 0, hint = "")
    }

    fun getQuestionList(): List<LeetcodeMetaInfo> {
        return leetcodeMetatable.values.toList()
    }

    fun convertToJson(): String {
        val mapper = ObjectMapper(JsonFactory()).registerKotlinModule()
        return mapper.writeValueAsString(leetcodeMetatable)
    }
}