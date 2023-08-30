package com.example.kotlin.crud.springboot.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "anggota")
open class Anggota : Serializable {
    @JsonProperty("anggota_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anggota_id", nullable = false)
    open var id: Int? = null


    @JsonProperty("anggota_nama")
    @Column(name = "anggota_nama", nullable = false, length = 50)
    open var anggotaNama: String? = null


    @Lob
    @JsonProperty("anggota_alamat")
    @Column(name = "anggota_alamat", nullable = false)
    open var anggotaAlamat: String? = null


    @Lob
    @JsonProperty("anggota_jk")
    @Column(name = "anggota_jk", nullable = false)
    open var anggotaJk: String? = null


    @JsonProperty("anggota_telp")
    @Column(name = "anggota_telp", nullable = false, length = 14)
    open var anggotaTelp: String? = null


    @JsonProperty("nim")
    @Column(name = "nim", nullable = false)
    open var nim: Int? = null


    @Lob
    @JsonProperty("semester")
    @Column(name = "semester")
    open var semester: String? = null
}