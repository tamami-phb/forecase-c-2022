package lab.phb.forecastc.model

data class Parameter(
    var tglAwal: String,
    var tglAkhir: String
) {
    constructor(): this("", "")
}
