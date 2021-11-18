class InversionCount(var comparator:(left:Int, right:Int)->Boolean) {

    private fun mergeAndCount(
        arr: IntArray, l: Int,
        m: Int, r: Int
    ): Int {


        val left = arr.copyOfRange(l, m + 1)
        val right = arr.copyOfRange(m + 1, r + 1)
        var i = 0
        var j = 0
        var k = l
        var invc = 0
        while (i < left.size && j < right.size) {
            if (comparator(left[i] , right[j])) {
                arr[k++] = right[j++]
                invc += m + 1 - (l + i)
            } else {
                arr[k++] = left[i++]

            }
        }
        while (i < left.size) arr[k++] = left[i++]
        while (j < right.size) arr[k++] = right[j++]
        return invc
    }

    // Merge sort function
    fun mergeSortAndCount(
        arr: IntArray, l: Int,
        r: Int
    ): Int {

        var count = 0
        if (l < r) {
            val m = (l + r) / 2

            count += mergeSortAndCount(arr, l, m)
            count += mergeSortAndCount(arr, m + 1, r)
            count += mergeAndCount(arr, l, m, r)
        }
        return count
    }


}

 fun ArrayList<Int>.inversionsCount(comparator : (l:Int, r:Int)->Boolean={ l, r->
    l>r} ): Int {
    return InversionCount(comparator).mergeSortAndCount(this.toIntArray(), 0, this.lastIndex)
}