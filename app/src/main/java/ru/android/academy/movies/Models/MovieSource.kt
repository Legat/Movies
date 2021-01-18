package ru.android.academy.movies.Models

import ru.android.academy.movies.R


class MovieSource {
    fun getMovie(): List<Movie>{
        return listOf(
            Movie("Avengers: End game", "13+", R.drawable.ic_list_item, listOf(Actor("Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg", true),
                                                                                          Actor("Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg", false),
                                                                                          Actor("Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg", false),
                                                                                          Actor("Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg", true),
                                                                                          Actor("Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg", true)), false, "Action, Adventure, Drama", 4F, "125 Reviews","137 MIN"),
            Movie("Tenet", "16+",R.drawable.ic_tennet_item, listOf(Actor("Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg", true),
                                                                              Actor("Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg", false),
                                                                              Actor("George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg", true)),true, "Action, Sci-Fi, Thriller", 5F, "98 Reviews","97 MIN"),
            Movie("Black Widow", "13+",R.drawable.ic_black_window_item, listOf( Actor("Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg", false),
                                                                                           Actor("Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg", true),
                                                                                           Actor("Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg", false),
                                                                                           Actor("Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg", true),
                                                                                           Actor("Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg", true),
                                                                                           Actor("Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg", false),
                                                                                           Actor("Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg", false) ), false, "Action, Adventure, Sci-Fi", 4F, "38 Reviews","102 MIN"),
            Movie("Wonder Woman 1984", "13+",R.drawable.ic_wonder_woman_item, listOf( Actor("Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg", true),
                                                                                                Actor("Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg", true),
                                                                                                Actor("Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg", false),
                                                                                                Actor("Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg", true),
                                                                                                Actor("Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg", false),
                                                                                                Actor("George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg", true),
                                                                                                Actor("Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg", false)
            ), false, "Action, Adventure, Fantasy", 5F, "74 Reviews","120 MIN")
        )
    }
}