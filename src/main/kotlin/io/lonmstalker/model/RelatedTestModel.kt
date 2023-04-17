package io.lonmstalker.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "related_test_model")
data class RelatedTestModel @JvmOverloads constructor(
    @field:Id var id: UUID? = null,
    var name: String? = null,
    @field:ManyToOne
    var testModel: TestModel? = null
)