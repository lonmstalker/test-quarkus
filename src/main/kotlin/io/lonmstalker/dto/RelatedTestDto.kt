package io.lonmstalker.dto

import io.lonmstalker.model.TestModel
import java.util.*

data class RelatedTestDto(
    val id: UUID,
    val name: String,
    val testModel: TestModel?
)
