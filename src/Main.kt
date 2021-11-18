fun main() {
    /** inversionsCount() is a extension function that can be called for any int array */
    print("Inversion Count  is : ${arrayListOf(4, 7, 2, 1, 3, 5).inversionsCount()} \n")


    /** inversionsCount() take a lambda function as the parameter that can be used for change inversion counting conditions */
    print(
        "Inversion Count with specific conditions is : ${arrayListOf(4, 7, 2, 1, 3, 5).inversionsCount(
            comparator = { l, r ->
                return@inversionsCount (l > r && ((l % 2 != 0) || (l % 2 == 0 && r % 2 == 0)))
            })
        }"
    )


}