package no.nav.helsearbeidsgiver.norg2

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Norg2ClientTest {

    private lateinit var norgClient: Norg2Client

    val testObject = lagResponse()

    @Test
    fun hentAlleArbeidsfordelinger() {
        runBlocking {
            norgClient = buildClient(HttpStatusCode.OK, Json.encodeToJsonElement(testObject).toString())
            val arbeidsfordelinger = norgClient.hentAlleArbeidsfordelinger(lagRequest(), "123")
            assertEquals(1, arbeidsfordelinger.size)
            assertEquals("1234", arbeidsfordelinger[0].enhetNr)
        }
    }
}
