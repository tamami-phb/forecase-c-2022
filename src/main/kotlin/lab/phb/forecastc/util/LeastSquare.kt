package lab.phb.forecastc.util

import lab.phb.forecastc.model.RekapPerTanggal
import org.slf4j.LoggerFactory
import java.math.BigDecimal

class LeastSquare {

    companion object {
        var log = LoggerFactory.getLogger(LeastSquare::class.java)

        fun calculate(data: List<RekapPerTanggal>): Double {
            var a = calculateA(data)
            var b = calculateB(data)
            var x = getNextX(data.size)
            return a + (b * x)
        }

        fun getNextX(size: Int): Int {
            var x = generateX(size)
            if(size % 2 == 0) {
                return x[size-1] + 2
            } else {
                return x[size-1] + 1
            }
        }

        fun calculateB(data: List<RekapPerTanggal>): Double {
            var x = generateX(data.size)
            var xy = generateXY(x, data)
            var x2 = calculateX2(x)
            return xy / x2
        }

        fun calculateX2(x: List<Int>): Int {
            var result = 0
            x.forEach {
                result += it * it
            }
            return result
        }

        fun generateXY(x: List<Int>, data: List<RekapPerTanggal>): Double {
            var result = 0.0
            for(i in 0..(x.size - 1)) {
                result += x.get(i) * data.get(i).total.toDouble()
            }
            return result
        }

        fun generateX(size: Int): List<Int> {
            if(size % 2 == 0) {
                return generateXGenap(size)
            } else {
                return generateXGanjil(size)
            }
        }

        fun generateXGenap(size: Int): List<Int> {
            var start = (size - 1) - ((size - 1) * 2)
            var i=0
            var result = mutableListOf<Int>()
            while(i++ < size) {
                result.add(start)
                start += 2
            }
            return result
        }

        fun generateXGanjil(size: Int): List<Int> {
            var start = (size / 2).toInt() - size + 1
            var i=0
            var result = mutableListOf<Int>()
            while(i++ < size) {
                result.add(start++)
            }
            return result
        }

        fun calculateA(data: List<RekapPerTanggal>): Double {
            var nilai = 0.0
            data.forEach {
                nilai += it.total.toDouble()
            }
            return nilai / data.size
        }
    }

}