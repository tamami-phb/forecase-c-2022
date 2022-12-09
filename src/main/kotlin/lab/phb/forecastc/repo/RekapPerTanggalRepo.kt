package lab.phb.forecastc.repo

import lab.phb.forecastc.model.RekapPerTanggal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RekapPerTanggalRepo: JpaRepository<RekapPerTanggal, String> {
    fun findByTglBetween(tglAwal: String, tglAkhir: String): List<RekapPerTanggal>
}