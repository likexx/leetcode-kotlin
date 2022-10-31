package test


interface LeetcodeSolution {

	val level: Level
	val link: String

	enum class Level {
		EASY, MEDIUM, HARD
	}
}