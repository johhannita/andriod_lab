package main

import java.util.*
import java.util.Date

@Suppress("DEPRECATION")
data class MyDate(var year: Int = Calendar.YEAR,
                var month: Int = Calendar.MONTH,
                var day: Int = Calendar.DAY_OF_MONTH) : Comparable<Date> {
    companion object: Comparator<Date> {
        override fun compare(a: Date, b: Date): Int = when {
            a.year != b.year -> a.year - b.year
            a.month != b.month -> a.month - b.month
            else -> a.day - b.day
        }
    }
    override fun compareTo(other: Date): Int = naturalOrder<Int>().compare(this.year, other.year)
}



