package io.lonmstalker.config

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import javax.ws.rs.core.Application

@OpenAPIDefinition(info = Info(title = "Test API", version = "1.0"))
class TestApplication : Application()