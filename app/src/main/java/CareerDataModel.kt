data class Career(
    val name: String,
    val description: String,
    val skills: List<String>
)
val careers = listOf(
    Career("Software Developer", "Build apps and software", listOf("logic", "math", "computers")),
    Career("Doctor", "Treat patients and save lives", listOf("biology", "helping", "science")),
    Career("Designer", "Design UI/UX and graphics", listOf("creativity", "art", "design")),
    Career("Entrepreneur", "Start your own business", listOf("risk", "leadership", "business")),
    Career("Data Scientist", "Analyze data and trends", listOf("math", "analysis", "coding"))
)
val questions = listOf(
    "Do you like solving logical problems?",
    "Do you enjoy helping people?",
    "Are you creative?",
    "Do you like business ideas?",
    "Do you enjoy working with data?"
)

fun recommendCareer(answers: List<Boolean>): Career {

    val scoreMap = mutableMapOf<Career, Int>()

    careers.forEach { career ->
        var score = 0

        if (answers[0] && "logic" in career.skills) score++
        if (answers[1] && "helping" in career.skills) score++
        if (answers[2] && "creativity" in career.skills) score++
        if (answers[3] && "business" in career.skills) score++
        if (answers[4] && "analysis" in career.skills) score++

        scoreMap[career] = score
    }

    return scoreMap.maxByOrNull { it.value }?.key ?: careers[0]
}