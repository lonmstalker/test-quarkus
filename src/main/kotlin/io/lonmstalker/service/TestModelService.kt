package io.lonmstalker.service

import io.lonmstalker.model.TestModel
import io.smallrye.mutiny.Uni
import java.util.UUID

interface TestModelService {
    fun findAll(): Uni<List<TestModel>>
    fun save(testModel: TestModel): Uni<TestModel>
    fun findByName(name: String): Uni<List<TestModel>>
    fun findRelatedTestModel(relatedIds: Collection<UUID>): Uni<List<TestModel>>
}