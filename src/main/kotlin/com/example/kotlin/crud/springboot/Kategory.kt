package com.example.kotlin.crud.springboot

import jakarta.persistence.*

@Entity
@Table(name = "kategory")
open class Kategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null
}