package com.codingstuff.imageslider

interface IPageSwitcher {
    fun switchPage(type: CarouselType, delay: Long = 5000)
}

enum class CarouselType {
    CITIZEN_CHARTER,
    MEDIA,
    REPRESENTATIVE,
    STAFF,
}