package io.lonmstalker.repository

import io.lonmstalker.model.RelatedTestModel
import io.quarkus.hibernate.reactive.panache.kotlin.PanacheRepositoryBase
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RelatedTestModelRepository : PanacheRepositoryBase<RelatedTestModel, UUID> {
}