package test.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation  class Leetcode (val level: Leetcode.Level, val link: String) {
    enum class Level {
        EASY, MEDIUM, HARD
    }
}


