interface TopLogger: Logger {
    val groupId: Int
    val operationName: String
    val id: Int
}