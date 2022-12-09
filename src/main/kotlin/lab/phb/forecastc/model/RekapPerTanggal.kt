package lab.phb.forecastc.model

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "rekap_per_tanggal")
data class RekapPerTanggal(
    @Id @Column(name = "tgl")
    var tgl: String,
    @Column(name = "total")
    var total: BigDecimal
) {
    constructor(): this("", BigDecimal.ZERO)

    override fun toString(): String {
        return "[ " + tgl + " : " + total.toString() + " ]"
    }
}
