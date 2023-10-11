package main

import java.util.*

data class Date(var year: Int = Calendar.YEAR,
                var month: Int = Calendar.MONTH,
                var day: Int = Calendar.DAY_OF_MONTH): Comparable<Date> {
    companion object: Comparable<Date> {
//        override fun compareTo(a: Date, b: Date): Int = when {
//            a.year != b.year -> a.year - b.year
//        }

        override fun compareTo(a: Date, b: Date): Int = when {
            a.year != b.year -> a.year - b.year
        }
    }

    override fun compareTo(other: Date): Int {
        TODO("Not yet implemented")
    }
}


