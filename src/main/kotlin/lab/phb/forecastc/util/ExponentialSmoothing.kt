package lab.phb.forecastc.util

import lab.phb.forecastc.model.RekapPerTanggal
import java.math.BigDecimal

class ExponentialSmoothing {

    companion object {
        fun getForecast(data: List<RekapPerTanggal>): Double {
            var result = 0.0
            var alpha = 2 / (data.size + 1)

            for(i in 0..data.size-1) {
                result = result + (alpha * (data.get(i).total.toDouble() - result))
            }
            return result
        }
    }

}