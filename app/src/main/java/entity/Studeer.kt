package entity

class Class(var name: String, var kelas: Int, var jurusan: String) {

    companion object{
        @JvmField
        var listOfClass = arrayOf(
            Class("Hans", 12, "IPA"),
            Class("Avila", 12, "IPA"),
            Class("Nicholas", 12, "IPA"),
            Class("Henry", 12, "IPA"),
            Class("Eric", 11, "IPS"),
            Class("Kevin", 11, "IPS"),
            Class("Leon", 10, "IPA"),
            Class("Rebecca", 10, "IPS"),
            Class("Vanessa", 11, "IPS"),
            Class("Via", 10, "IPA"),
        )
    }
}