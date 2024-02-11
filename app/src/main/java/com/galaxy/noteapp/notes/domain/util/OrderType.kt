package com.galaxy.noteapp.notes.domain.util

sealed class OrderType {
    data object Ascending: OrderType()
    data object Descending: OrderType()
}