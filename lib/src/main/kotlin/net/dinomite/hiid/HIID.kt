package net.dinomite.hiid

import java.nio.file.Files
import java.nio.file.Path

public data class HIID(private val identifier: String) {
    override fun toString(): String = identifier
}

public fun randomHIID(): HIID {
    val value = StringBuilder().apply {
        append(Words.eight())
        append('-')
        append(Words.four())
        append('-')
        append(Words.four())
        append('-')
        append(Words.four())
        append('-')
        append(Words.twelve())
    }

    return HIID(value.toString())
}

private object Words {
    private val fours: List<String>
    private val eights: List<String>
    private val twelves: List<String>

    fun four(): String = fours.random()
    fun eight(): String = eights.random()
    fun twelve(): String = twelves.random()

    init {
        val foursBuilder = mutableListOf<String>()
        val eightsBuilder = mutableListOf<String>()
        val twelvesBuilder = mutableListOf<String>()

        val wordlistsDir = HIID::class.java.getResource("/wordlists")
        Files.walk(Path.of(wordlistsDir.toURI()))
            .filter { item -> Files.isRegularFile(item) }
            .forEach { path ->
                path.toFile()
                    .readLines()
                    .drop(1)
                    .forEach { word ->
                        when (word.length) {
                            4 -> foursBuilder.add(word)
                            8 -> eightsBuilder.add(word)
                            12 -> twelvesBuilder.add(word)
                        }
                    }
            }

        fours = foursBuilder.toList()
        eights = eightsBuilder.toList()
        twelves = twelvesBuilder.toList()
    }
}
