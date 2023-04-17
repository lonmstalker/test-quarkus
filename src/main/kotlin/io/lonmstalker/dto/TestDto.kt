package io.lonmstalker.dto

import java.util.*

data class TestDto(
    val id: UUID?,
    val name: String,
    var relatedTestModel: List<RelatedTestDto> = listOf()
)