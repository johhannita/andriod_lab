package main

import java.util.*
import java.util.Date

data class Date(var year: Int = Calendar.YEAR,
                var month: Int = Calendar.MONTH,
                var day: Int = Calendar.DAY_OF_MONTH) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> day - other.day
        }
    }

                 }

