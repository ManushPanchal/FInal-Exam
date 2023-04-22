package ca.manushpanchal.finalexam

class Dice(// Getters
    var sides: Int, // Setters
    var name: String
) {

    fun roll(): Int {
        return Math.round(Math.random() * sides).toInt()
    }

    fun getSides(sides: Int) {
        this.sides = sides
    }
}