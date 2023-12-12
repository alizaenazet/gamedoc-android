package com.example.gamedoc.model.gamer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HealthReport(
    @SerialName("berhenti_bermain")
    val berhentiBermain: String,
    @SerialName("bersalah_berlebihan_bermain")
    val bersalahBerlebihanBermain: Boolean,
    @SerialName("durasi_bermain")
    val durasiBermain: Int,
    val fisik: String,
    @SerialName("gangguan_tidur")
    val gangguanTidur: Boolean,
    @SerialName("keluan_gamer")
    val keluanGamer: List<String>,
    @SerialName("keluhan_menggangu_aktivitas")
    val keluhanMengganguAktivitas: String,
    @SerialName("kesulitan_bersosial")
    val kesulitanBersosial: String,
    val mental: String,
    @SerialName("motivasi_beraktivitas")
    val motivasiBeraktivitas: String,
    @SerialName("nyaman_menghabiskan_waktu_untuk_game")
    val nyamanMenghabiskanWaktuUntukGame: String,
    @SerialName("nyeri_tulang_sendi")
    val nyeriTulangSendi: String,
    val sosial: String

)